package org.ashara.chennai.transport.tripsheet.beans;

import java.time.LocalDateTime;

public class BusEntryBean {
    private Integer id;
    private String busId;
    private String route;
    private String pickupPoint;
    private Integer noOfPassenegers;
    private EntryType entryType;
    private String entryBy;

    public String getEntryBy() {
        return entryBy;
    }

    public void setEntryBy(String entryBy) {
        this.entryBy = entryBy;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    private LocalDateTime entryTime;


    public EntryType getEntryType() {
        return entryType;
    }

    public void setEntryType(EntryType entryType) {
        this.entryType = entryType;
    }

    public Integer getNoOfPassenegers() {
        return noOfPassenegers;
    }

    public void setNoOfPassenegers(Integer noOfPassenegers) {
        this.noOfPassenegers = noOfPassenegers;
    }

    public String getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(String pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public enum EntryType {
        PICKUP, DROPOFF;
    }

}
