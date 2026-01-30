package es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.domain;

import javax.persistence.*;

import es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.domain.Vehicle;

@Entity
@DiscriminatorValue("PLANE")
public class Plane extends Vehicle {

    private boolean autopilot;
    private String tailNumber;

    public Plane() {}

    public boolean isAutopilot() { return autopilot; }
    public void setAutopilot(boolean autopilot) { this.autopilot = autopilot; }

    public String getTailNumber() { return tailNumber; }
    public void setTailNumber(String tailNumber) { this.tailNumber = tailNumber; }
}
