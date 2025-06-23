package org.ashara.chennai.transport.tripsheet.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="dry_storage")
public class DryStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String zone;

    @Column
    private String entryTime;

    @Column
    private String teamMemberName;

    @OneToMany(mappedBy = "dryStorage", cascade = CascadeType.ALL)
    private List<DryStorageItems> dryStorageItemsList = new ArrayList<>();

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

    public List<DryStorageItems> getDryStorageItemsList() {
        return dryStorageItemsList;
    }

    public void setDryStorageItemsList(List<DryStorageItems> dryStorageItemsList) {
        this.dryStorageItemsList = dryStorageItemsList;
    }

    public String getTeamMemberName() {
        return teamMemberName;
    }

    public void setTeamMemberName(String teamMemberName) {
        this.teamMemberName = teamMemberName;
    }
}
