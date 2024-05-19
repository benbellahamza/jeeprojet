package org.sid.projectue.repositories;

import org.sid.projectue.entities.Order1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order1, Long> {
}
