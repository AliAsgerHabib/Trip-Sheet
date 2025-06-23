package org.ashara.chennai.transport.tripsheet.entities;

import jakarta.persistence.*;

@Entity
@Table(name="cold_storage_item")
public class ColdStorageItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "cold_storage_id")
    private ColdStorage coldStorage;

    @Column
    private Boolean isVehicleClean = false;

    @Column
    private Boolean isPackagingWithoutDamage = false;

    @Column
    private Boolean isUnderExpiry = false;

    @Column
    private Boolean isIngredientsChecked = false;

    @Column
    private Boolean isItemsSeparated = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getVehicleClean() {
        return isVehicleClean;
    }

    public void setVehicleClean(Boolean vehicleClean) {
        isVehicleClean = vehicleClean;
    }

    public Boolean getPackagingWithoutDamage() {
        return isPackagingWithoutDamage;
    }

    public void setPackagingWithoutDamage(Boolean packagingWithoutDamage) {
        isPackagingWithoutDamage = packagingWithoutDamage;
    }

    public Boolean getUnderExpiry() {
        return isUnderExpiry;
    }

    public void setUnderExpiry(Boolean underExpiry) {
        isUnderExpiry = underExpiry;
    }


    public Boolean getItemsSeparated() {
        return isItemsSeparated;
    }

    public void setItemsSeparated(Boolean itemsSeparated) {
        isItemsSeparated = itemsSeparated;
    }

    public Boolean getIngredientsChecked() {
        return isIngredientsChecked;
    }

    public void setIngredientsChecked(Boolean ingredientsChecked) {
        isIngredientsChecked = ingredientsChecked;
    }

    public ColdStorage getColdStorage() {
        return coldStorage;
    }

    public void setColdStorage(ColdStorage coldStorage) {
        this.coldStorage = coldStorage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
