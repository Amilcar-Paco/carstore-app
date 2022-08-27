package com.pacocode.carstore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter @Setter @NoArgsConstructor
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String make;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String motorCode;

    public Car(UUID id, String make, String model, String type, String motorCode) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.type = type;
        this.motorCode = motorCode;
    }
}
