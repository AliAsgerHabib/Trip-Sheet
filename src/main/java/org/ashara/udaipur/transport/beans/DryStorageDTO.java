package org.ashara.udaipur.transport.beans;

import java.util.List;

public class DryStorageDTO {

    private Integer id;
    private String zone;
    private String entryTime;
    private String teamMemberName;
    private List<DryStorageItemsDTO> dryStorageItemsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getTeamMemberName() {
        return teamMemberName;
    }

    public void setTeamMemberName(String teamMemberName) {
        this.teamMemberName = teamMemberName;
    }

    public List<DryStorageItemsDTO> getDryStorageItemsList() {
        return dryStorageItemsList;
    }

    public void setDryStorageItemsList(List<DryStorageItemsDTO> dryStorageItemsList) {
        this.dryStorageItemsList = dryStorageItemsList;
    }
}