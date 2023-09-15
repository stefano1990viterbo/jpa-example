package it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.services;

import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.entities.MacchinaBi;
import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.entities.PersonaBi;
import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.repositories.MacchinaRepository_OTM_Bidirezionale;
import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.repositories.PersonaRepositoryOTM_Bidirezionale;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PersonaService_OTM_Bidirezionale {

  private final PersonaRepositoryOTM_Bidirezionale repository;
  private final MacchinaRepository_OTM_Bidirezionale macchinaRepository;

  @Transactional
  public void initPersonaConDueMacchine() {
    log.info(() -> "Inizializzo il db con la creazione di una persona con una macchina associata");

    PersonaBi stefano = new PersonaBi();
    stefano.setName("Stefano");

    MacchinaBi ford = new MacchinaBi();
    ford.setModello("ford");

    MacchinaBi bmw = new MacchinaBi();
    bmw.setModello("bmw");

    stefano.aggiungiMacchina(ford);
    stefano.aggiungiMacchina(bmw);

    repository.save(stefano);

    log.info(() -> "Fine inizializzazione");
  }

  /** delete from macchina_bi where id=? */
  @Transactional
  public void rimuoviMacchinaDaProprietario() {
    log.info(() -> "Inzio rimozione macchina da proprietario");

    PersonaBi persona =
        repository.findAll().stream().findFirst().orElseThrow(EntityNotFoundException::new);

    MacchinaBi macchinaDaRimuovere = persona.getMacchine().get(0);

    persona.rimuoviMacchina(macchinaDaRimuovere);

    repository.flush();

    log.info(() -> "Fine");
  }

  @Transactional
  public void pulisciDb() {
    log.info(()->"Pulisco il db");
    repository.deleteByIdNotNull();
    macchinaRepository.deleteByIdNotNull();
  }
}
