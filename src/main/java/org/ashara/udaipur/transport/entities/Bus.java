package org.ashara.udaipur.transport.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String registrationNumber;

    @Column
    private String driverName;

    @Column
    private String driverContactNo;

    @Column
    private Integer maxCapacity;

    @ManyToOne
    @JoinColumn(name = "pickup_id")
    private Point pickup;

    @ManyToOne
    @JoinColumn(name = "drop_off_id")
    private Point dropOff;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
