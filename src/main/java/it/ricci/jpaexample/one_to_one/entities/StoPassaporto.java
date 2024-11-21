package it.ricci.jpaexample.one_to_one.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class StoPassaporto {

    @Id
    private Long id;

    private String codice;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "stocittadino_id")
    private StoCittadino stoCittadino;
}
