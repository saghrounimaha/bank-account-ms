package net.maha.customerservice;

import net.maha.customerservice.Config.GlobalConfig;
import net.maha.customerservice.entity.Customer;
import net.maha.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    //chaque methode utiliser bean c'est une methode on va executer au niveau de demarrage
    //if i used bean method retun object
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            //to save custor 3 methode
			/*1:constructor sans parametre
	       Customer customer=new Customer();
			  customer.setFirstName();
			  */
			/*2:costuctor with parametre
             Customer customer=new Customer(null,"","","");
              mais ce n'est pas pratique si on utiliser pleusieur parametere vous perdre ou le 1 parametere ou 2
			 */
             /*3:utiliser builder:pour crerer et configurer les obj complexe
              avant build on peut remplir l'objet
             * */
			/*
			    Customer customer1=Customer.builder()
						.firstName("maha")
						.lastName("saghrouni")
						.email("maha@gmail.com")
						.build();
                customerRepository.save(customer1);
			Customer customer2=Customer.builder()
					.firstName("riadh")
					.lastName("bouzid")
					.email("riadh@gmail.com")
					.build();
			customerRepository.save(customer2);
            */
            List<Customer> customerList=List.of(
                    Customer.builder()
                            .firstName("maha")
                            .lastName("saghrouni")
                            .email("maha@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("riadh")
                            .lastName("bouzid")
                            .email("riadh@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };
    }
}
