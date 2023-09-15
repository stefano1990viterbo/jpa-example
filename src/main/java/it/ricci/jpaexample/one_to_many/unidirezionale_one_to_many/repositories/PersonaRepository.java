package it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.repositories;

import it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {}
