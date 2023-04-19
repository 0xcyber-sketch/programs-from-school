package com.howard.audit.domain;

public class TradeData {
    private final TradeType type;
    private final String stockNNumber;
    private final int numberOfStocks;
    private final String traderId;

    public TradeData(TradeType type, String stockNNumber, int numberOfStocks, String traderId) {
        this.type = type;
        this.stockNNumber = stockNNumber;
        this.numberOfStocks = numberOfStocks;
        this.traderId = traderId;
    }

    public String getStockNNumber() {
        return stockNNumber;
    }

    public int getNumberOfStocks() {
        return numberOfStocks;
    }

    public String getTraderId() {
        return traderId;
    }

    public TradeType getType() {
        return type;
    }
}
