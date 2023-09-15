package it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.repositories;

import it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.entities.Macchina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MacchinaOTM_Uni_repository extends JpaRepository<Macchina, Long> {}
