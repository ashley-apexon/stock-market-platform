package com.market.marketsearchservice.dto;


import com.market.marketsearchservice.entity.StockSymbol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StockSymbolDto {

    private String symbol;
    private String name;


    public StockSymbolDto(StockSymbol stockSymbol){

        this.symbol= stockSymbol.getSymbol();
        this.name  = stockSymbol.getName();
    }

}
