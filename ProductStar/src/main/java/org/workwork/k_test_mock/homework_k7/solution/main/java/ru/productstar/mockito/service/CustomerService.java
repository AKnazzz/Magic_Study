package org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.service;


import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.model.Customer;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.repository.CustomerRepository;

public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getOrCreate(String name) {
        Customer customer = customerRepository.getByName(name);
        if (customer == null) {
            customer = new Customer(name);
            return customerRepository.add(customer);
        } else {
            return customer;
        }
    }
}
