package ru.gb.springbootapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String title;
    private double cost;
    @Column(name = "manufacture_date")
    private LocalDate date;
    @Column (name = "manufacturer_id")
    private long manufacturer;

}
