package com.howard.audit.persistence.entity;

import com.howard.audit.domain.Trade;
import com.howard.audit.domain.TradeData;
import com.howard.audit.domain.TradeType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@NamedQueries({
        @NamedQuery(name = "TradePO.findAll", query = "Select t FROM TradePO t")
})
@Entity
@Table(name = "TRADE")
public class TradePO {

    public static final String FIND_ALL = "TradePO.findAll";

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", columnDefinition = "varchar(40)")
    private UUID id;

    @Column(name = "STOCK_NMUMBER", columnDefinition = "varchar(40)")
    private String stockNumber;

    @Column(name = "NUBER_STOCK")
    private int numberOfStock;

    @Enumerated(EnumType.STRING)
    @Column(name = "TRADE_TYPE", columnDefinition = "varchar(10)")
    private TradeType tradeType;

    @Column(name = "TRADE_ID", columnDefinition = "varchar(40)")
    private String traderId;

    public TradePO() {
        //JPA
    }

    public TradePO(TradeData tradeData) {
        this.stockNumber = tradeData.getStockNNumber();
        this.numberOfStock = tradeData.getNumberOfStocks();
        this.tradeType = tradeData.getType();
        this.traderId = tradeData.getTraderId();
    }

    public Trade toTrade() {
        return new Trade(id, new TradeData(tradeType, stockNumber, numberOfStock, traderId));
    }

}
