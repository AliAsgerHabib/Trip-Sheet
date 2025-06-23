package org.ashara.chennai.transport.tripsheet.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cold_storage")
public class ColdStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String zone;

    @Column
    private String entryTime;

    @Column
    private String teamMemberName;

    @OneToMany(mappedBy = "coldStorage", cascade = CascadeType.ALL)
    private List<ColdStorageItems> coldStorageItemsList = new ArrayList<>();

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

    public List<ColdStorageItems> getColdStorageItemsList() {
        return coldStorageItemsList;
    }

    public void setColdStorageItemsList(List<ColdStorageItems> coldStorageItemsList) {
        this.coldStorageItemsList = coldStorageItemsList;
    }

    public String getTeamMemberName() {
        return teamMemberName;
    }

    public void setTeamMemberName(String teamMemberName) {
        this.teamMemberName = teamMemberName;
    }
}
