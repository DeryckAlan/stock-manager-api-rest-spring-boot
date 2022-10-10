package com.stock.stockmanager.repo;

import com.stock.stockmanager.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepo extends JpaRepository<Stock, Long> {
    void deleteStockById(Long id);

    Optional<Stock> findStockById(Long id);
}
