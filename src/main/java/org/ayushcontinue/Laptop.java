package org.ayushcontinue;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Laptop {

    @Id
    private int Lid;
    private String Lname;
    private String Lmodel;
    private int ram;

    @OneToOne(mappedBy = "laptop")
    private Alien alien;

    public Alien getAlien() {
        return alien;
    }

    public void setAlien(Alien alien) {
        this.alien = alien;
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
