package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name = "drivers")
public class DriverRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String team;
    private int points;

    public DriverRecord() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTeam() { return team; }

    public void setTeam(String team) { this.team = team; }

    public void updateDriver(DriverRecord driverRecord) {
        this.name = driverRecord.getName();
        this.team = driverRecord.getTeam();
        this.points = driverRecord.getPoints();
    }
}
