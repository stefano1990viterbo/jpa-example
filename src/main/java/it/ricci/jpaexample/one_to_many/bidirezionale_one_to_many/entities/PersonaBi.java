package it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PersonaBi {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, orphanRemoval = false)
  private List<MacchinaBi> macchine = new ArrayList<>();

  /**
   * presenta due metodi di utilità (ad esempio addCommente removeComment) che vengono utilizzati
   * per sincronizzare entrambi i lati dell'associazione bidirezionale. Dovresti sempre fornire
   * questi metodi ogni volta che lavori con un'associazione bidirezionale poiché, altrimenti,
   * rischi di problemi di propagazione dello stato molto sottili
   */
  public void aggiungiMacchina(MacchinaBi macchinaBi) {
    macchine.add(macchinaBi);
    macchinaBi.setProprietario(this);
  }

  public void rimuoviMacchina(MacchinaBi macchinaBi) {
    macchine.remove(macchinaBi);
    macchinaBi.setProprietario(null);
  }
}
