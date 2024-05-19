package org.sid.projectue.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.projectue.enums.OrderState;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createAT;
    private OrderState orderState = OrderState.New;
    @OneToMany(mappedBy = "order1", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails = new ArrayList<>();
    @OneToMany(mappedBy = "order1", fetch = FetchType.LAZY)
    private List<Payement> payements = new ArrayList<>();
    @ManyToOne
    private Customer customer;
}
