package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name = "constructors")
public class TeamRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int points;

    public TeamRecord() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void updateTeam(TeamRecord teamRecord) {
        this.name = teamRecord.getName();
        this.points = teamRecord.getPoints();
    }
}
