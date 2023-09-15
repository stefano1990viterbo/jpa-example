package it.ricci.jpaexample.many_to_many.repositories;

import it.ricci.jpaexample.many_to_many.entities.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorsoRepository extends JpaRepository<Corso, Long> {}
