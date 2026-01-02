package com.market.marketsearchservice.repository;


import com.market.marketsearchservice.entity.StockSymbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockSymbolRepository extends JpaRepository<StockSymbol, String> {

}
