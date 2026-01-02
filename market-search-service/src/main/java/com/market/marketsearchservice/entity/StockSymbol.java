package com.market.marketsearchservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stock_symbol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StockSymbol {
    @Id
    private String symbol;
    private String name;

}
