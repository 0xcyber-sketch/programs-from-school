package com.howard.audit.resource.dto;

import com.howard.audit.domain.Trade;

public class TradeDTO {
    private final String id;
    private final String stockNumber;
    private final int numberOfStocks;
    private final String traderNumber;

    public TradeDTO(Trade trade) {
        this.id = trade.getId().toString();
        this.stockNumber = trade.getData().getStockNNumber();
        this.numberOfStocks = trade.getData().getNumberOfStocks();
        this.traderNumber = trade.getData().getTraderId();
    }

    public String getId() {
        return id;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public int getNumberOfStocks() {
        return numberOfStocks;
    }

    public String getTraderNumber() {
        return traderNumber;
    }
}
