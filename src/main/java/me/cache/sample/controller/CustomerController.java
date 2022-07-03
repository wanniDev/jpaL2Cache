package me.cache.sample.controller;

import lombok.RequiredArgsConstructor;
import me.cache.sample.entity.Customer;
import me.cache.sample.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerRepository customerRepository;

  @GetMapping("/customer/{id}")
  public ResponseEntity<Customer> findCustomer(@PathVariable Long id) {
    return ResponseEntity.ok(customerRepository.findById(id).get());
  }

  @GetMapping("/customer")
  public ResponseEntity<List<Customer>> customers() {
    return ResponseEntity.ok(customerRepository.findAll());
  }

  @PostMapping("/customer")
  public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
    return ResponseEntity.ok(customerRepository.save(customer));
  }
}
