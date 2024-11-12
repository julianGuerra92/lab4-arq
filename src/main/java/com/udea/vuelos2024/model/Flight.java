package com.udea.vuelos2024.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idflight")
    private Long idFlight;

    @Column(name = "nombreavion", nullable = false, length = 80)
    private @NotNull String nombreAvion;

    @Column(name = "numerovuelo", nullable = false, length = 80)
    private @NotNull String numeroVuelo;

    @Column(name = "origen", nullable = false, length = 80)
    private @NotNull String origen;

    @Column(name = "destino", nullable = false, length = 80)
    private @NotNull String destino;

    @Column(name = "capacidad", nullable = false)
    private @NotNull int capacidad;

    @Column(name = "rating", nullable = false)
    @Min(value = 1, message = "Rating must be equal or greater than 1")
    @Max(value = 5, message = "Rating must be equal or less than 5")
    private @NotNull int rating;

    @Column(name = "planvuelo", nullable = false)
    private @NotNull long planVuelo;

    private Boolean cumplido;

}
