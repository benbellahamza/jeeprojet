package org.sid.projectue.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CHECK")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Check extends Payement {
    private String bankName;
    private String bankId;
}
