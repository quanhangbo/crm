package dao.impl;

import domain.Customer;

import java.util.List;

public interface CustomerDaoImpl {
    void save(Customer c);

    List<Customer> getAll();

    void  delete(Long custId);

    Customer get(Long  custId);

    void edit_save(Customer customer);
    int count_info(String custName);

    List<Customer> getlist(int page, String custName);
}
