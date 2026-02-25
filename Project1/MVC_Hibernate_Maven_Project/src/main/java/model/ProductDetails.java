package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="product_details")
@Getter
@Setter
@NoArgsConstructor
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name="expiration_date")
    private Date expirationDate;

    @Column(name="manufacturer")
    private String manufacturer;

    @Column(name="price")
    private double price;

    @Column(name="available")
    private boolean available;

    public ProductDetails(String name, Date expirationDate, String manufacturer, double price, boolean available) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.manufacturer = manufacturer;
        this.price = price;
        this.available = available;
    }
}
