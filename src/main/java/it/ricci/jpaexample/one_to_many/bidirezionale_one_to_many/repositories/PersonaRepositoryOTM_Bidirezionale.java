package it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.repositories;

import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.entities.PersonaBi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositoryOTM_Bidirezionale extends JpaRepository<PersonaBi,Long> {
  long deleteByIdNotNull();
}
