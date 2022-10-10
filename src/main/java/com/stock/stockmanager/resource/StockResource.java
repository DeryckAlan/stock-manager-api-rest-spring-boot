package com.stock.stockmanager.resource;

import com.stock.stockmanager.models.Stock;
import com.stock.stockmanager.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockResource {
    private final StockService stockService;

    public StockResource(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Stock>> getAllStock(){
        List<Stock> stocks = stockService.findAllStock();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable("id") Long id){
        Stock stock = stockService.findStockById(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock){
        Stock newStock = stockService.addStock(stock);
        return new ResponseEntity<>(newStock, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock){
        Stock updateStock = stockService.updateStock(stock);
        return new ResponseEntity<>(updateStock, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable("id") Long id){
        stockService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
