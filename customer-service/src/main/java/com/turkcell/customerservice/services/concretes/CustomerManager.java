package com.turkcell.customerservice.services.concretes;

import com.turkcell.customerservice.entities.Customer;
import com.turkcell.customerservice.entities.requests.CustomerAddRequest;
import com.turkcell.customerservice.entities.requests.CustomerUpdateRequest;
import com.turkcell.customerservice.entities.responses.CustomerAddResponse;
import com.turkcell.customerservice.entities.responses.CustomerGetResponse;
import com.turkcell.customerservice.entities.responses.CustomerUpdateResponse;
import com.turkcell.customerservice.repositories.CustomerRepository;
import com.turkcell.customerservice.services.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerAddResponse register(CustomerAddRequest request) {
        Customer customer =
                Customer.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .userName(request.getUsername())
                        .lastName(request.getLastName())
                        .password(request.getPassword())
                        .balance(0)
                        .build();
        customerRepository.save(customer);
        CustomerAddResponse customerAddResponse =
                CustomerAddResponse.builder()
                        .id(customer.getId())
                        .name(customer.getName())
                        .email(customer.getEmail())
                        .lastName(customer.getLastName())
                        .username(customer.getUserName())
                        .build();
        return customerAddResponse;
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerUpdateResponse update(int id, CustomerUpdateRequest update) {
        return null;
    }

    @Override
    public List<CustomerGetResponse> getAll() {
        return null;
    }

    @Override
    public CustomerGetResponse getById(int id) {
        return null;
    }

    @Override
    public double getBalanceByCustomerId(int customerId) {
        Customer customer = customerRepository.getReferenceById(customerId);
        return customer.getBalance();
    }

    @Override
    public double balanceUp(int customerId, double balance) {
        Customer customer = customerRepository.getReferenceById(customerId);
        customer.setBalance(customer.getBalance() + balance);
        customer = customerRepository.save(customer);
        return customer.getBalance();
    }

    @Override
    public double balanceDown(int customerId, double balance) {
        Customer customer = customerRepository.getReferenceById(customerId);
        customer.setBalance(customer.getBalance() - balance);
        customer = customerRepository.save(customer);
        return customer.getBalance();
    }

}
