package org.ashara.udaipur.transport.beans;

public class DryStorageItemsDTO {

    private Integer id;
    private String itemName;
    private Boolean isVehicleClean;
    private Boolean isPackagingWithoutDamage;
    private Boolean isUnderExpiry;
    private Boolean isIngredientsChecked;
    private Boolean isItemsSeparated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Boolean getIsVehicleClean() {
        return isVehicleClean;
    }

    public void setIsVehicleClean(Boolean isVehicleClean) {
        this.isVehicleClean = isVehicleClean;
    }

    public Boolean getIsPackagingWithoutDamage() {
        return isPackagingWithoutDamage;
    }

    public void setIsPackagingWithoutDamage(Boolean isPackagingWithoutDamage) {
        this.isPackagingWithoutDamage = isPackagingWithoutDamage;
    }

    public Boolean getIsUnderExpiry() {
        return isUnderExpiry;
    }

    public void setIsUnderExpiry(Boolean isUnderExpiry) {
        this.isUnderExpiry = isUnderExpiry;
    }

    public Boolean getIsIngredientsChecked() {
        return isIngredientsChecked;
    }

    public void setIsIngredientsChecked(Boolean isIngredientsChecked) {
        this.isIngredientsChecked = isIngredientsChecked;
    }

    public Boolean getIsItemsSeparated() {
        return isItemsSeparated;
    }

    public void setIsItemsSeparated(Boolean isItemsSeparated) {
        this.isItemsSeparated = isItemsSeparated;
    }
}