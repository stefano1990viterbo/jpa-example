package it.ricci.jpaexample.one_to_many.unidirezionale_one_to_many.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Persona {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;


  /**
   * Questo mappaggio crea la tabella di mezzo
   *
   * <p>PERSONA_MACCHINE
   */
  //  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  //  private List<Macchina> macchine = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
  /**
   * Con la JoinColumn si dice ad hibernate di inserire nella tabella MACCHINE la colonna PERSONA_ID
   * come FK con il quale crea il collegamento con Persona In questo modo non viene creata la
   * tabella di mezzo PERSONA_MACCHINE
   */
//  @JoinColumn(name = "persona_id")

  private Set<Macchina> macchine = new HashSet<>();

  /**
   * Evitare di usare le liste, perchè questo genere una quantita di insert nel momento della rimozione di un elemento dalla lista.
   * Questo perchè essendo le liste ordinate, quando rimuovi un elemento lui si deve riordinare la lista come in precedenza
   * hibernate vede questo come una modifica e quindi elimina tutti gli elementi e li reinserisce.
   */
  //  private List<Macchina> macchine = new ArrayList<>();

}
