package it.ricci.jpaexample.many_to_many.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Corso {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String denominazione;

  /**
   * <p>Dal lato target, dobbiamo solo fornire il nome del campo, che mappa la relazione.</p>
   *
   * <p>Tieni presente che, poiché una relazione molti-a-molti non ha un lato proprietario nel
   * database , potremmo configurare la tabella di join nella classe Course e farvi riferimento
   * dalla classe Student
   */
  @ManyToMany(mappedBy = "iscrizioni")
  private Set<Studente> iscritti;
}
