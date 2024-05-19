package org.sid.projectue.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.projectue.enums.CustomerState;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "ERROR FIRSTNAME")
    private String firstName;
    private String lastName;
    @NotBlank(message = "ERROR email")
    @Email
    private String email;
    private String address;
    private CustomerState customerState = CustomerState.New;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order1> order1s = new ArrayList<>();
}
