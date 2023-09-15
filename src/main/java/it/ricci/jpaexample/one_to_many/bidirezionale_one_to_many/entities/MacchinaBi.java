package it.ricci.jpaexample.one_to_many.bidirezionale_one_to_many.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class MacchinaBi {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String modello;

  /**
   * L' @ManyToOneassociazione utilizza FetchType.LAZYperché, altrimenti, ricadremmo sul recupero
   * EAGER, il che è negativo per le prestazioni .
   */
  @ManyToOne(fetch = FetchType.LAZY)
  private PersonaBi proprietario;

  /**
   * L'entità figlio, PostComment, implementa i metodi equalse hashCode. Poiché non possiamo fare
   * affidamento su un identificatore naturale per i controlli di uguaglianza , dobbiamo utilizzare
   * invece l'identificatore di entità per il equalsmetodo. Tuttavia, è necessario farlo
   * correttamente in modo che l'uguaglianza sia coerente in tutte le transizioni dello stato
   * dell'entità , che è anche il motivo per cui hashCodedeve essere un valore costante. Poiché
   * facciamo affidamento sull'uguaglianza per removeComment, è buona norma sovrascrivere equalse
   * hashCodeper l'entità figlio in un'associazione bidirezionale.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MacchinaBi macchina = (MacchinaBi) o;
    return Objects.equals(id, macchina.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public void rimuoviProprietario(){
    //TODO verificare se è necessario rimuovere dal proprietario la macchina???
    this.proprietario.rimuoviMacchina(this);
    this.setProprietario(null);
  }

}
