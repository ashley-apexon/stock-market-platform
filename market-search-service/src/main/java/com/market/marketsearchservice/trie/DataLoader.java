package com.market.marketsearchservice.trie;


import com.market.marketsearchservice.entity.StockSymbol;
import com.market.marketsearchservice.repository.StockSymbolRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final StockSymbolRepository stockSymbolRepo;

    @PostConstruct
    public void init() {

        if (stockSymbolRepo.count() > 0) return; // prevents duplicate insert on restart

        List<StockSymbol> stocks = List.of(
                new StockSymbol( "AAPL", "Apple Inc"),
                new StockSymbol( "MSFT", "Microsoft Corporation"),
                new StockSymbol( "AMZN", "Amazon.com Inc"),
                new StockSymbol( "GOOGL", "Alphabet Class A"),
                new StockSymbol( "META", "Meta Platforms"),
                new StockSymbol( "NVDA", "NVIDIA Corporation"),
                new StockSymbol( "TSLA", "Tesla Inc"),
                new StockSymbol( "BRK.B", "Berkshire Hathaway"),
                new StockSymbol( "JPM", "JPMorgan Chase & Co")
                // Add all 500 here or load from CSV/API
        );

        stockSymbolRepo.saveAll(stocks);
        System.out.println("StockSymbols Loaded ✔");
    }
}
