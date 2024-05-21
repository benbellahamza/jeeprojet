package org.sid.projectue.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    private String imageUrl;
    private String description;
    private Date datePublication;
<<<<<<< HEAD
    private float prix;

=======
    @ManyToOne
    private Customer customer;
>>>>>>> 2e6dfdcff4c39999ebe6d5bb7d3fe55650525531


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
<<<<<<< HEAD
=======
                ", Customer=" +customer.toString() +
>>>>>>> 2e6dfdcff4c39999ebe6d5bb7d3fe55650525531
                '}';
    }
}
