package es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type")
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private double price;
    private int year;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

    public Vehicle() {}

    public Long getId() { return id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public Person getOwner() { return owner; }
    public void setOwner(Person owner) { this.owner = owner; }
}
