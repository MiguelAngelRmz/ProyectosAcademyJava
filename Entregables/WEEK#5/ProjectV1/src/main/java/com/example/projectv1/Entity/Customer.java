package com.example.projectv1.Entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Set;


@Entity
@Data
public class Customer {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
private String name;
private String email;

@OneToMany(mappedBy="customer")
private Set<Account> accounts; //multi account relation


    
}
