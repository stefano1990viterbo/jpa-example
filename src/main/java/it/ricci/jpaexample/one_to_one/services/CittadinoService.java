package it.ricci.jpaexample.one_to_one.services;

import it.ricci.jpaexample.one_to_one.entities.Cittadino;
import it.ricci.jpaexample.one_to_one.entities.Passaporto;
import it.ricci.jpaexample.one_to_one.entities.StoCittadino;
import it.ricci.jpaexample.one_to_one.entities.StoPassaporto;
import it.ricci.jpaexample.one_to_one.repositories.CittadinoReporitory;
import it.ricci.jpaexample.one_to_one.repositories.StoCittadinoReposiroty;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class CittadinoService {

    private final CittadinoReporitory cittadinoReporitory;

    private final StoCittadinoReposiroty stoCittadinoReposiroty;

    @Transactional
    public Long creaCittadino(String nomeCittadino) {

        Cittadino cittadino = new Cittadino();
        cittadino.setNome(nomeCittadino);

        Cittadino cittadinoSalvato = cittadinoReporitory.save(cittadino);

        return cittadinoSalvato.getId();
    }

    @Transactional
    public Long creaCittadinoConPassaportoAssociato(String nomeCittadino) {

        Cittadino cittadino = new Cittadino();
        cittadino.setNome(nomeCittadino);

        Passaporto passaporto = new Passaporto();
        passaporto.setCodice(UUID.randomUUID().toString());
        cittadino.setPassaporto(passaporto);

        Cittadino cittadinoSalvato = cittadinoReporitory.save(cittadino);

        // gestisco storico

        log.warn("Avvio storicizzatore");
        StoCittadino stoCittadino = toCittadino(cittadinoSalvato);
        stoCittadinoReposiroty.save(stoCittadino);


        return cittadinoSalvato.getId();
    }

    private StoCittadino toCittadino(Cittadino cittadino){

        StoCittadino s = new StoCittadino();

        s.setIdCittadino(cittadino.getId());
        s.setNome(cittadino.getNome());
        StoPassaporto stoPassaporto =  toPassaporto(cittadino.getPassaporto());
        s.setStoPassaporto(stoPassaporto);

        return s;
    }

    private StoPassaporto toPassaporto(Passaporto passaporto){

        if(passaporto == null){
            return null;
        }

        StoPassaporto stoPassaporto = new StoPassaporto();
        stoPassaporto.setCodice(passaporto.getCodice());

        return stoPassaporto;
    }

    public void modificaCittatido(Cittadino cittadino){

        Cittadino cittadinoSalvato = cittadinoReporitory.save(cittadino);

        // gestione storico
        StoCittadino stoCittadino = toCittadino(cittadino);
        stoCittadinoReposiroty.save(stoCittadino);

    }

    public void vediUltimoStorico(Long idCittadinoDimanico){

        Long l = stoCittadinoReposiroty.trovaUltimoIdStorico(idCittadinoDimanico);

//        StoCittadino stoCittadino = stoCittadinoReposiroty.trovaUltimoStorico(idCittadinoDimanico);

        StoCittadino stoCittadino = stoCittadinoReposiroty.findById(l).get();

        log.warn("TEST ultimo idStorico: "+stoCittadino.getId());
    }

    @Transactional
    public void rimuoviPassaportoDaCittadino(Long idCittadino) {


        Optional<Cittadino> byId = cittadinoReporitory.findById(idCittadino);

        byId.ifPresent(cittadino -> cittadino.setPassaporto(null));
//        if (byId.isPresent()) {
//            Cittadino cittadino = byId.get();
//            cittadino.setPassaporto(null);
//            cittadinoReporitory.save(cittadino);
//        }

    }

    @Transactional
    public Cittadino trovaTramiteId(Long id) {
        Optional<Cittadino> byId = cittadinoReporitory.findById(id);

        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Transactional
    public List<Cittadino> findAll() {
        return cittadinoReporitory.findAll();
    }

}
