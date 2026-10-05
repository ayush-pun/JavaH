package org.ayushcontinue;

import jakarta.persistence.*;

import java.util.List;

@Entity
//this annotation make sure the laptop class is level2 cachable
@Cacheable

public class Laptop {

    @Id
    private int Lid;
    private String Lname;
    private String Lmodel;
    private int ram;

    @ManyToMany
    private List<Alien> aliens;

    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    public int getLid() {
        return Lid;
    }

    public void setLid(int lid) {
        Lid = lid;
    }

    public String getLmodel() {
        return Lmodel;
    }

    public void setLmodel(String lmodel) {
        Lmodel = lmodel;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "Lid=" + Lid +
                ", Lname='" + Lname + '\'' +
                ", Lmodel='" + Lmodel + '\'' +
                ", ram=" + ram +
                '}';
    }


}
