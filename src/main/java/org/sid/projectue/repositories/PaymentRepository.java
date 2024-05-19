package org.sid.projectue.repositories;

import org.sid.projectue.entities.Payement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payement, Long> {
}
