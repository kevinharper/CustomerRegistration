package net.javaguides.springboot.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import net.javaguides.springboot.entity.Customer;
import net.javaguides.springboot.service.CustomerService;



@Controller
public class CustomerController
{
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) { //adding customerService in a constructor
        super();
        this.customerService = customerService;
    }
    
    // handler method to handle list customer and return mode and view
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
