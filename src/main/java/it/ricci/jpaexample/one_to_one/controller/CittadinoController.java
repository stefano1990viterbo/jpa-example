package it.ricci.jpaexample.one_to_one.controller;

import it.ricci.jpaexample.one_to_one.entities.Cittadino;
import it.ricci.jpaexample.one_to_one.entities.Passaporto;
import it.ricci.jpaexample.one_to_one.services.CittadinoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.net.PasswordAuthentication;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Log4j2
public class CittadinoController {

    private final CittadinoService cittadinoService;

    public void cicloVita(){

//        cittadinoService.creaCittadino("Stafano");

//        cittadinoService.creaCittadinoConPassaportoAssociato("Ciccio");
//        Long mario = cittadinoService.creaCittadinoConPassaportoAssociato("Mario");

//        cittadinoService.rimuoviPassaportoDaCittadino(2L);

//        for(int i =0 ; i<20;i++){
//            String nome = "ciccio"+i;
//            cittadinoService.creaCittadinoConPassaportoAssociato(nome);
//        }

//        Cittadino cittadino = cittadinoService.trovaTramiteId(5L);

        //Chiamare il passaporto fuori dalla transazione genera LazyInitializatinoException
//        Passaporto passaporto = cittadino.getPassaporto();
//        log.warn(passaporto.getCodice());


//        for(int i =4 ; i<10;i++){
//            cittadinoService.rimuoviPassaportoDaCittadino((long)i);
//        }
//
//        Cittadino cittadino1 = cittadinoService.trovaTramiteId(2L);
//        cittadino1.setNome("GINO");
//        cittadinoService.modificaCittatido(cittadino1);
//
//        Cittadino cittadino2 = cittadinoService.trovaTramiteId(5L);
//        cittadino2.setNome("NO_PASSPORT");
//        cittadinoService.modificaCittatido(cittadino2);

gestioneStorico();
    }

    private void gestioneStorico(){
        Long ciccio = cittadinoService.creaCittadinoConPassaportoAssociato("Ciccio");

        Cittadino cittadino = cittadinoService.trovaTramiteId(ciccio);
        cittadino.setNome("MArio");
        cittadinoService.modificaCittatido(cittadino);

        cittadino.setNome("Gino");
        cittadinoService.modificaCittatido(cittadino);

        cittadino.setNome("Filini");
        cittadinoService.modificaCittatido(cittadino);

        cittadino.setPassaporto(null);
        cittadinoService.modificaCittatido(cittadino);

        cittadino.setPassaporto(creaPassaporto());
        cittadinoService.modificaCittatido(cittadino);

        vediUltimoStorico(ciccio);
    }

    private Passaporto creaPassaporto(){
        Passaporto passaporto = new Passaporto();
        passaporto.setCodice(UUID.randomUUID().toString());
        return passaporto;
    }

    private void vediUltimoStorico(Long idCittadinoDinamico){
        cittadinoService.vediUltimoStorico(idCittadinoDinamico);
    }

}
