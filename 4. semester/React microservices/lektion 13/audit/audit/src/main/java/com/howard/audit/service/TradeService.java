package com.howard.audit.service;

import com.howard.audit.domain.Trade;
import com.howard.audit.domain.TradeData;
import com.howard.audit.persistence.Repository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
@Transactional(Transactional.TxType.REQUIRED)
public class TradeService {

    private final Repository repository;

    @Inject
    public TradeService(Repository repository) {
        this.repository = repository;
    }

    public List<Trade> getTrades() {
        return repository.getTrades();
    }

    public Trade createTrade(TradeData tradeData, boolean fail) {

        Trade trade = repository.createTrade(tradeData);
        repository.createAudit(tradeData);
        if (fail) {
            throw new RuntimeException("FAIL TRADE");
        }
        return trade;
    }

    public List<Trade> createTradeList(List<TradeData> tradeDataList) {
        List<Trade> list = new ArrayList<>();
        for (int i = 0; i < tradeDataList.size(); i++) {
            try {
                list.add(repository.createTradeWithNew(tradeDataList.get(i), i % 2 == 0));
            } catch (RuntimeException e) {
                System.out.println(e);
            }
        }
        return list;
    }

}
