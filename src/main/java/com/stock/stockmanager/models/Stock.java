package com.stock.stockmanager.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private String batch;
    @Column(nullable = false)
    private Integer amount;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false, updatable = false)
    private String stockCode;
}
