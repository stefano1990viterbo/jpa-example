package it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.controller;

import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.services.PersonaService_OTM_Bidirezionale;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class PersonaController_OTM_BI {

  private final PersonaService_OTM_Bidirezionale service;

  public void cicloPersona(){
    log.warn(()-> "Inizio ciclo persona ONE_TO_MANY Bidirezionale");
    service.initPersonaConDueMacchine();
    service.rimuoviMacchinaDaProprietario();
//    service.pulisciDb();
    log.warn(()-> "Fine ciclo persona ONE_TO_MANY Bidirezionale");
  }


}
