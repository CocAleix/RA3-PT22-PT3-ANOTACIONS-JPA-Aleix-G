package es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.domain;

import javax.persistence.*;

import es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.domain.Vehicle;

@Entity
@DiscriminatorValue("CAR")
public class Car extends Vehicle {

    private int doors;
    private int seats;

    public Car() {}

    public int getDoors() { return doors; }
    public void setDoors(int doors) { this.doors = doors; }

    public int getSeats() { return seats; }
    public void setSeats(int seats) { this.seats = seats; }
}
