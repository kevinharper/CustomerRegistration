package net.javaguides.springboot.controller;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import net.javaguides.springboot.entity.Customer;
import net.javaguides.springboot.service.CustomerService;



@RestController
@Tag(name = "Customer API")
public class CustomerController
{
    private CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService) { //adding customerService in a constructor
        super();
        this.customerService = customerService;
    }
    
    // handler method to handle list customer and return model and view
    @Operation(summary = "Get a list of all customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @GetMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }


    @GetMapping("/customers/new")
    public String createCustomerForm(Model model) {
        
        // create customer object to hold customer form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create_customer";
        
    }

            @PostMapping("/customers")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult result) 
    {
        if (result.hasErrors()) {
            return "create_customer";
          }
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
    
    
    
    
    
    @GetMapping("/customers/edit/{id}")
    public String editCustomerForm(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "edit_customer";
    }

    @PostMapping("/customers/{id}")
    public String updateCustomer(@PathVariable Long id,
            @ModelAttribute("customer") Customer customer,
            Model model) {
        
        // get customer from database by id
        Customer existingCustomer = customerService.getCustomerById(id);
        existingCustomer.setId(id);
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());

        
        // save updated customer object
        customerService.updateCustomer(existingCustomer);
        return "redirect:/customers";        
    }
    
    // handler method to handle delete customer request
    
    @GetMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }
    
    
    
}
