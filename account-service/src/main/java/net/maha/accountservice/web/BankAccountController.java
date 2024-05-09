package net.maha.accountservice.web;

import net.maha.accountservice.clients.CustomerRestClient;
import net.maha.accountservice.entities.BankAccount;
import net.maha.accountservice.models.Customer;
import net.maha.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public BankAccountController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> getList(){
        List<BankAccount>accountList=bankAccountRepository.findAll();
        accountList.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return accountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount getById(@PathVariable String id){
        BankAccount bankAccount= bankAccountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return  bankAccount;
    }
}
