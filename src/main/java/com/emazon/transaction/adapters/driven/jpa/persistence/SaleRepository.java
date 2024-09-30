package com.emazon.transaction.adapters.driven.jpa.persistence;

import com.emazon.transaction.adapters.driven.jpa.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
}
