package com.howard.audit.persistence.entity;

import com.howard.audit.domain.Trade;
import com.howard.audit.domain.TradeData;
import com.howard.audit.domain.TradeType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TRADE_AUDIT")
public class AuditPO {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", columnDefinition = "varchar(40)")
    private UUID id;

    @Column(name = "TRADE_ID", columnDefinition = "varchar(40)")
    private String traderId;

    @Column(name = "STOCK_NUMBER", columnDefinition = "varchar(40)")
    private String stockNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "TRADE_TYPE", columnDefinition = "varchar(10)")
    private TradeType tradeType;

    @Column(name = "TRADE_TIME")
    private LocalDateTime created;

    public AuditPO() {
        //JPA
    }

    public AuditPO(TradeData tradeData) {
        this.stockNumber = tradeData.getStockNNumber();
        this.tradeType = tradeData.getType();
        this.traderId = tradeData.getTraderId();
        this.created = LocalDateTime.now();
    }
}
