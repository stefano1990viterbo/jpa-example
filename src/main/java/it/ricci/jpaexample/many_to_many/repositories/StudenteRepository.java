package it.ricci.jpaexample.many_to_many.repositories;

import it.ricci.jpaexample.many_to_many.entities.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente,Long> {}
