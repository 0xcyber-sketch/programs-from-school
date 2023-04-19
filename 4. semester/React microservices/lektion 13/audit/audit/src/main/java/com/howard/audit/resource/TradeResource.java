package com.howard.audit.resource;

import com.howard.audit.domain.Trade;
import com.howard.audit.domain.TradeData;
import com.howard.audit.resource.dto.CreateTradeDTO;
import com.howard.audit.resource.dto.TradeDTO;
import com.howard.audit.service.TradeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/trades")
public class TradeResource {

    private final TradeService service;

    @Inject
    public TradeResource(TradeService service) {
        this.service = service;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<TradeDTO> getTrades() {
        return service.getTrades().stream()
                .map(TradeDTO::new)
                .collect(Collectors.toList());
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public TradeDTO createTrade(CreateTradeDTO dto) {
        return new TradeDTO(service.createTrade(dto.toTradeData(), true));
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path("/list")
    public List<TradeDTO> createTradeList(List<CreateTradeDTO> list) {
        return service.createTradeList(list.stream()
                        .map(CreateTradeDTO::toTradeData)
                        .collect(Collectors.toList()))
                .stream()
                .map(TradeDTO::new)
                .collect(Collectors.toList());
    }

}
