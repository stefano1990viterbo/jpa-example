package it.ricci.jpaexample.one_to_one.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cittadino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


    @OneToOne(
            mappedBy = "cittadino",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Passaporto passaporto;

    public void setPassaporto(Passaporto passaporto) {

        if (passaporto == null) {
            if (this.passaporto != null) {
                this.passaporto.setCittadino(null);
            }
        } else {
            passaporto.setCittadino(this);
        }
        this.passaporto = passaporto;
    }

}
