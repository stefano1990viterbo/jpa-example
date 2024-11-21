package it.ricci.jpaexample.one_to_one.repositories;

import it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.entities.Persona;
import it.ricci.jpaexample.one_to_one.entities.Cittadino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CittadinoReporitory extends JpaRepository<Cittadino, Long> {
}
