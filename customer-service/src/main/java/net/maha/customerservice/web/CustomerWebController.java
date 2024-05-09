package net.maha.customerservice.web;

import net.maha.customerservice.entity.Customer;
import net.maha.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerWebController {

    //Injection avec @autowired sa marche mais il est debreckted pour faire l'injection des dependance
    //il faut faire l'injection avec le constractor on peut ajouter l'annotation @allargsConstractor
    private CustomerRepository customerRepository;

    public CustomerWebController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/customers")
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    @GetMapping("/Customers/{id}")
    public  Customer getCustomerById(@PathVariable Long id){
        return  customerRepository.findById(id).get();
    }

}
