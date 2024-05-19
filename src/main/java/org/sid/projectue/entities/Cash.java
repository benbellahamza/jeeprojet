package org.sid.projectue.entities;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CASH")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cash extends Payement {
    private Double cashTendered;
}
