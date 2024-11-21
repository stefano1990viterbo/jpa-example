package it.ricci.jpaexample.one_to_one.repositories;

import it.ricci.jpaexample.one_to_one.entities.StoCittadino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StoCittadinoReposiroty extends JpaRepository<StoCittadino, Long> {

    @Query("select max (s.id) from StoCittadino s where s.idCittadino = ?1")
    public Long trovaUltimoIdStorico(Long idDinamico);

    @Query("select s1 from StoCittadino s1 where s1.id = ( select max (s.id) from StoCittadino s where s.idCittadino = ?1) ")
    public StoCittadino trovaUltimoStorico(Long idDinamico);
}
