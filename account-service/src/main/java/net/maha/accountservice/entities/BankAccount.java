package net.maha.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.maha.accountservice.enums.AccountType;
import net.maha.accountservice.models.Customer;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {
    @Id
    private  String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    //@Enumerated(EnumType.ORDINAL) soit 0:sa veut dire current account soit 1:saving account
    @Enumerated(EnumType.STRING)
    private AccountType type;
    //transient(ignorer un attrbuit:cad: c'un attrbuit presenter dans la classe mais n'est pas presenter dans la db
    @Transient
    private Customer customer;
    private Long customerId;

}
