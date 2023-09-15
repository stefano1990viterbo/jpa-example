package it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.repositories;

import it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.entities.MacchinaBi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MacchinaRepository_OTM_Bidirezionale extends JpaRepository<MacchinaBi,Long> {}
