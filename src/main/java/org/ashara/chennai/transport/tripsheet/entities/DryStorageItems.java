package org.ashara.chennai.transport.tripsheet.entities;

import jakarta.persistence.*;

@Entity
@Table(name="dry_storage_item")
public class DryStorageItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "dry_storage_id")
    private DryStorage dryStorage;

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

    public DryStorage getDryStorage() {
        return dryStorage;
    }

    public void setDryStorage(DryStorage dryStorage) {
        this.dryStorage = dryStorage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
