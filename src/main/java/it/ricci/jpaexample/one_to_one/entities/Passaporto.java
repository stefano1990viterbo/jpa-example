package it.ricci.jpaexample.one_to_one.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Passaporto {

    @Id
    private Long id;

    @Setter
    private String codice;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "cittadino_id")
    private Cittadino cittadino;
}
