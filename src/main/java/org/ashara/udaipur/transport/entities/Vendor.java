package org.ashara.udaipur.transport.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String registeredCity;

    @Column
    private String registeredCountry;

    @Column
    private String contactPersonName;

    @Column
    private String contactPersonNo;

    @Column
    private String contactPersonEmail;

    @OneToMany(mappedBy = "vendor")
    private List<Bus> buses;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;
}
