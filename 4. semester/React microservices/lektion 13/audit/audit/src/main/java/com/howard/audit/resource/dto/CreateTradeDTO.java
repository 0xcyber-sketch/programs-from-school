package com.howard.audit.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.howard.audit.domain.TradeData;
import com.howard.audit.domain.TradeType;

public class CreateTradeDTO {
    private final String traderId;
    private final String stockNumber;
    private final int numberOfStocks;
    private final TradeType type;

    @JsonCreator
    public CreateTradeDTO(@JsonProperty("traderId") String traderId,
                          @JsonProperty("stockNumber") String stockNumber,
                          @JsonProperty("numberOfStocks") int numberOfStocks,
                          @JsonProperty("type") TradeType type
    ) {
        this.traderId = traderId;
        this.stockNumber = stockNumber;
        this.numberOfStocks = numberOfStocks;
        this.type = type;
    }

    public String getTraderId() {
        return traderId;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public int getNumberOfStocks() {
        return numberOfStocks;
    }

    public TradeType getType() {
        return type;
    }

    public TradeData toTradeData() {
        return new TradeData(type, stockNumber, numberOfStocks, traderId);
    }
}
