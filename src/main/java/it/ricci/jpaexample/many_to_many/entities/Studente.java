package it.ricci.jpaexample.many_to_many.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Studente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  //lato PROPRIETARIO è dove configuriamo la relazione. Utilizzeremo la classe Studente .
  @ManyToMany
  /**
   * Non è necessario utilizzare @JoinTable o anche @JoinColumn . JPA genererà per noi i nomi delle
   * tabelle e delle colonne. Tuttavia, la strategia utilizzata da JPA non corrisponde sempre alle
   * convenzioni di denominazione utilizzate. Quindi, abbiamo bisogno della possibilità di
   * configurare i nomi di tabelle e colonne.
   */
  @JoinTable(
      name = "Studenti_Corsi",
      joinColumns = @JoinColumn(name = "studente_id"),
      inverseJoinColumns = @JoinColumn(name = "corso_id"))
  private Set<Corso> iscrizioni;
}
