package com.bezy.school_system.repositories;

import com.bezy.school_system.entities.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
}
