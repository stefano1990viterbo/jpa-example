package it.ricci.jpaexample;

import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.controller.MacchinaController_OTM_BI;
import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.controller.PersonaController_OTM_BI;
import it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.controller.PersonaController_OTM;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaExampleApplication implements ApplicationRunner {

  private final PersonaController_OTM personaController_otm;
  private final PersonaController_OTM_BI personaController_otm_bi;
  private final MacchinaController_OTM_BI macchinaController_otm_bi;

  public static void main(String[] args) {
    SpringApplication.run(JpaExampleApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {

    personaController_otm.cicloVita();

    personaController_otm_bi.cicloPersona();
    macchinaController_otm_bi.cicloMacchina();
  }
}
