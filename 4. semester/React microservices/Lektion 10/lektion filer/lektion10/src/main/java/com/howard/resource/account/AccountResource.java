package com.howard.resource.account;

import com.howard.resource.account.dto.AccountDTO;
import com.howard.resource.account.dto.AccountId;
import com.howard.resource.account.dto.CreateAccountDTO;
import com.howard.resource.customer.dto.CustomerDTO;
import com.howard.resource.customer.dto.NameDTO;
import com.howard.resource.customer.dto.SsnDTO;
import com.howard.service.account.AccountService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Path("/accounts")
public class AccountResource {

    public static List<AccountDTO> accountDTOS = new ArrayList<>();
    public static List<CustomerDTO> customerDTOS = new ArrayList<>();

    static {
        List<CustomerDTO> customers = Arrays.asList(
                new CustomerDTO(new NameDTO("hans", "Nielsen"), new SsnDTO("23434324334")),
                new CustomerDTO(new NameDTO("Gerda", "Hansen"), new SsnDTO("234324334")),
                new CustomerDTO(new NameDTO("Gerda", "Hansen"), new SsnDTO("234324334")),
                new CustomerDTO(new NameDTO("Gerda", "Hansen"), new SsnDTO("234324334")),
                new CustomerDTO(new NameDTO("Gerda", "Hansen"), new SsnDTO("234324334")));
        customerDTOS.addAll(customers);
    }


    Logger log;
    AccountService accountService;

    @Inject
    public AccountResource(AccountService accountService, Logger log) {
        this.accountService = accountService;
        this.log = log;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AccountDTO> getAccounts() {
        //log.info("Account resource getAccounts called");
        return accountDTOS;

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public AccountDTO createAccount(CreateAccountDTO account) {
        //log.info("Account resource Creating account");
        CustomerDTO customer = customerDTOS.stream()
                .filter(c -> c.getSsnDTO().getSsn().equals(account.getSsn()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("error"));

        AccountDTO accountDTO = new AccountDTO(new AccountId(account.getRegNumber(), account.getAccountNumber()), customer);
        accountDTOS.add(accountDTO);
        return accountDTO;
    }

}
