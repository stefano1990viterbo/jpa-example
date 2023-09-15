package it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.controller;

import it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.services.PersonaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class PersonaController_OTM {

  private final PersonaService service;

  public void cicloVita(){
  service.inizializzaPersonaConUnaMacchinaAssociata();
  service.rimuoviMacchinaDaProprietario();
  }


}
