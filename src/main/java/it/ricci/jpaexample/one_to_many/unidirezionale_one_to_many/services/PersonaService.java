package it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.services;

import it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.entities.Macchina;
import it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.entities.Persona;
import it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.repositories.MacchinaOTM_Uni_repository;
import it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.repositories.PersonaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PersonaService {

  private final PersonaRepository personaRepository;


  public void eseguiCicloOneToManyUnidirezionale(){
    inizializzaPersonaConUnaMacchinaAssociata();
    rimuoviMacchinaDaProprietario();
  }

  public void inizializzaPersona() {

    log.info(() -> "Inizializzo Persone nel DB");

    Persona stefano = new Persona();
    stefano.setName("Stefano");

    personaRepository.save(stefano);
  }

  /**
   * <h2>Query risultanti:</h2>
   * <p>insert into persona (name,id) values (?,default)</p>
   * <p>insert into macchina (modello,id) values (?,default)</p>
   * <p>insert into persona_macchine (persona_id,macchine_id) values (?,?)</p>
   *
   */
  public void inizializzaPersonaConUnaMacchinaAssociata() {

    log.info(() -> "Inizializzo il db con la creazione di una persona con una macchina associata");

    Persona stefano = new Persona();
    stefano.setName("Stefano");

    Macchina ford = new Macchina();
    ford.setModello("ford");

    Macchina bmw = new Macchina();
    bmw.setModello("bmw");

    stefano.getMacchine().add(ford);
    stefano.getMacchine().add(bmw);

    personaRepository.save(stefano);

    log.info(()-> "Fine inizializzazione");
  }

  /**
   *<p>update macchina set persona_id=? where id=?</p>
   * <p>delete from macchina where id=?</p>
   */
  public void rimuoviMacchinaDaProprietario(){
    log.info(()-> "Inzio rimozione macchina");

    Persona persona = personaRepository.findAll().stream()
        .findFirst()
        .orElseThrow(EntityNotFoundException::new);

    persona.getMacchine().remove(0);

    personaRepository.save(persona);

    log.info(()-> "Fine");
  }



}














