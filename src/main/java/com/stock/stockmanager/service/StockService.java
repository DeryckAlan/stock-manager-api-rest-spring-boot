package com.stock.stockmanager.service;

import com.stock.stockmanager.exception.ProductNotFoundException;
import com.stock.stockmanager.models.Stock;
import com.stock.stockmanager.repo.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StockService {
    private final StockRepo stockRepo;

    @Autowired
    public StockService(StockRepo stockRepo){
        this.stockRepo = stockRepo;
    }

    public Stock addStock(Stock stock){
        stock.setStockCode(UUID.randomUUID().toString());
        return stockRepo.save(stock);
    }

    public List<Stock> findAllStock(){
        return stockRepo.findAll();
    }

    public Stock updateStock(Stock stock){
        return stockRepo.save(stock);
    }

    public Stock findStockById(Long id){
        return stockRepo.findStockById(id)
                .orElseThrow(() -> new ProductNotFoundException("product by id: " + id + " was not found"));
    }

    public void deleteStock(Long id){
        stockRepo.deleteStockById(id);
    }

}
