package it.ricci.jpaexample.one_to_one.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class StoCittadino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCittadino;

    private String nome;

    @OneToOne(
            mappedBy = "stoCittadino",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private StoPassaporto stoPassaporto;

    public void setStoPassaporto(StoPassaporto stoPassaporto) {

        if (stoPassaporto == null) {
            if (this.stoPassaporto != null) {
                this.stoPassaporto.setStoCittadino(null);
            }
        } else {
            stoPassaporto.setStoCittadino(this);
        }
        this.stoPassaporto = stoPassaporto;
    }
}
