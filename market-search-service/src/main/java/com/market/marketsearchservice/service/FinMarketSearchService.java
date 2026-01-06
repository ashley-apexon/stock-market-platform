package com.market.marketsearchservice.service;

import com.market.marketsearchservice.dto.StockSearchDto;
import com.market.marketsearchservice.dto.StockSymbolDto;
import com.market.marketsearchservice.entity.StockSymbol;

import java.util.List;

public interface FinMarketSearchService {

    List<StockSearchDto> searchStocks(String keyword);
    List<StockSymbolDto> allStocks();
    List<String> searchStock(String prefix);
    StockSymbol stockNameToSymbol(String name);

}
