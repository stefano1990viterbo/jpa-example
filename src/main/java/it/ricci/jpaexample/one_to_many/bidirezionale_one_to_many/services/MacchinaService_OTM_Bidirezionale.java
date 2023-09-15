package it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.services;

import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.entities.MacchinaBi;
import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.entities.PersonaBi;
import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.repositories.MacchinaRepository_OTM_Bidirezionale;
import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.repositories.PersonaRepositoryOTM_Bidirezionale;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class MacchinaService_OTM_Bidirezionale {

  private final MacchinaRepository_OTM_Bidirezionale repository;

  private final PersonaRepositoryOTM_Bidirezionale personaRepository;

  @Transactional
  public void inizializzaElementiInTabella() {
    log.info(() -> "Inizializzo il db con la creazione di una persona con una macchina associata");

    PersonaBi stefano = new PersonaBi();
    stefano.setName("Stefano");

    MacchinaBi ford = new MacchinaBi();
    ford.setModello("ford");

    MacchinaBi bmw = new MacchinaBi();
    bmw.setModello("bmw");

    stefano.aggiungiMacchina(ford);
    stefano.aggiungiMacchina(bmw);

    personaRepository.save(stefano);

    log.info(() -> "Fine inizializzazione");
  }

  /** update macchina_bi set modello=?,proprietario_id=? where id=? */
  @Transactional
  public void rimuoviIlProprietario() {
    log.info(() -> "Rimuovo proprietario dalla macchina");
    MacchinaBi macchina = repository.findByProprietario_IdNotNull().get(0);
    macchina.rimuoviProprietario();
    log.info(() -> "Fine rimozione proprietario");
  }

  @Transactional
  public void pulisciTabelleCreate() {
    log.info("Pulizia db");
    repository.deleteByIdNotNull();
    personaRepository.deleteByIdNotNull();
    log.info("Fine Pulizia db");
  }
}
