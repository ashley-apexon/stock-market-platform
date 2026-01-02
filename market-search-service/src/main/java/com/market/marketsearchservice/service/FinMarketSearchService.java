package com.market.marketsearchservice.service;

import com.market.marketsearchservice.dto.StockSearchDto;
import com.market.marketsearchservice.dto.StockSymbolDto;

import java.util.List;

public interface FinMarketSearchService {

    public List<StockSearchDto> searchStocks(String keyword);
    public List<StockSymbolDto> allStocks();
    public List<String> searchStock(String prefix);

}
