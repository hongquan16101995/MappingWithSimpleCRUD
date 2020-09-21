package service;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    private static final List<Customer> customers;

    static {

        customers = new ArrayList<>();
        customers.add(new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customers.add(new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customers.add(new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customers.add(new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customers.add(new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.add(new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.stream().filter(c -> c.getId() == (id)).findFirst().orElse(null);
    }

    @Override
    public void update(int id, Customer customer) {
        Customer customer1 = findById(id);
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setAddress(customer.getAddress());
    }

    @Override
    public void remove(int id) {
        customers.removeIf(c -> c.getId() == (id));
    }
}
