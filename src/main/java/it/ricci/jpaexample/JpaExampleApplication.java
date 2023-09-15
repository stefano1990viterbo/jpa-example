package it.ricci.jpaexample;

import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.controller.MacchinaController_OTM_BI;
import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.controller.PersonaController_OTM_BI;
import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.services.MacchinaService_OTM_Bidirezionale;
import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.services.PersonaService_OTM_Bidirezionale;
import it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.services.PersonaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaExampleApplication implements ApplicationRunner {

private final PersonaController_OTM_BI personaController_otm_bi;
	private final MacchinaController_OTM_BI macchinaController_otm_bi;

	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}

	@Override
//	@Transactional
	public void run(ApplicationArguments args) throws Exception {

//		personaService.eseguiCicloOneToManyUnidirezionale();

//		persona_OTM_Bi.cicloDiVitaPersonaService_OTM_BI();

//		macchinaServiceBi.cicloDiVitaMacchinaServiceBidirezionale();

//		macchinaServiceBi.inizializzaElementiInTabella();
//		macchinaServiceBi.rimuoviIlProprietario();

		personaController_otm_bi.cicloPersona();
//		macchinaController_otm_bi.cicloMacchina();
	}



}
