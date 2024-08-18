package com.emazon.transaction.adapters.driven.jpa.persistence;

import com.emazon.transaction.adapters.driven.jpa.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<SupplyEntity, Long> {
}
