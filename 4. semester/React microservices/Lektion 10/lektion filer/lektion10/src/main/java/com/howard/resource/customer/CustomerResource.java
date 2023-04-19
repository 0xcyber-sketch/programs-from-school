package com.howard.resource.customer;

import com.howard.resource.account.AccountResource;
import com.howard.resource.customer.dto.CreateCustomerDTO;
import com.howard.resource.customer.dto.CustomerDTO;
import com.howard.resource.customer.dto.SsnDTO;
import com.howard.resource.customer.dto.UpdateCustomerDTO;
import com.howard.resource.customer.dto.NameDTO;
import com.howard.resource.customer.dto.PatchFirstNameDTO;
import com.howard.service.customer.CustomerService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customers")
public class CustomerResource {

    @Inject
    private Logger log;

    @Inject
    private CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDTO> getCustomers() {
        log.info("XXXCustomer resource getCustomers called on object " + this.toString());
        customerService.test();
        return AccountResource.customerDTOS;

    }

    @Path("/{ssn}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDTO getCustomer(@PathParam("ssn") String ssn) {
        log.info("Customer resource getCustomers called on object " + this.toString());
        return AccountResource.customerDTOS.stream()
                .filter(c -> c.getSsnDTO().getSsn().equals(ssn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no customer"));
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDTO createCustomer(CreateCustomerDTO customer) {
        log.info("Customer resource Creating Customer");
        CustomerDTO customerDTO = new CustomerDTO(new NameDTO(customer.getFirstName(), customer.getLastName()), new SsnDTO(customer.getSsn()));
        AccountResource.customerDTOS.add(customerDTO);
        return customerDTO;
    }

    @Path("/{ssn}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDTO updateCustomer(@PathParam("ssn") String ssn, UpdateCustomerDTO customer) {
        log.info("Customer resource Creating Customer");
        CustomerDTO customerDTO = AccountResource.customerDTOS.stream()
                .filter(c -> c.getSsnDTO().getSsn().equals(ssn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no customer"));
        customerDTO.setName(new NameDTO(customer.getFirstName(), customer.getLastName()));
        return customerDTO;
    }

    @Path("/{ssn}")
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDTO patchCustomer(@PathParam("ssn") String ssn, PatchFirstNameDTO firstName) {
        log.info("Customer resource Creating Customer");
        CustomerDTO customerDTO = AccountResource.customerDTOS.stream()
                .filter(c -> c.getSsnDTO().getSsn().equals(ssn))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no customer"));
        customerDTO.getName().setFirstName(firstName.getName());
        return customerDTO;
    }
}
