package com.howard.audit.persistence;

import com.howard.audit.domain.Trade;
import com.howard.audit.domain.TradeData;
import com.howard.audit.persistence.entity.AuditPO;
import com.howard.audit.persistence.entity.TradePO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class Repository {
    private final EntityManager entityManager;

    @Inject
    public Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Trade> getTrades() {
        return entityManager.createNamedQuery(TradePO.FIND_ALL, TradePO.class).getResultList().stream()
                .map(TradePO::toTrade)
                .collect(Collectors.toList());
    }

    @Transactional(Transactional.TxType.MANDATORY)
    public Trade createTrade(TradeData tradeData) {
        TradePO po = new TradePO(tradeData);
        entityManager.persist(po);
        return po.toTrade();
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Trade createTradeWithNew(TradeData tradeData, boolean fail) {
        TradePO po = new TradePO(tradeData);
        entityManager.persist(po);
        if (fail) {
            throw new RuntimeException("FAILED");
        }
        return po.toTrade();
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createAudit(TradeData tradeData) {
        AuditPO auditPO = new AuditPO(tradeData);
        entityManager.persist(auditPO);
    }
}
