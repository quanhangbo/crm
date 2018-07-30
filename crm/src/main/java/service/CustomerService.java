package service;

import dao.CustomeDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import domain.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.impl.CustomerServiceImpl;

import java.util.List;

public class CustomerService implements CustomerServiceImpl {
    @Override
    public void save(Customer c) {
        CustomerDaoImpl dao = new CustomeDao();
        Session session = Main.getCurrentSession();
        Transaction tx= session.beginTransaction();
        try {
            dao.save(c);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> list= null;
        CustomerDaoImpl dao = new CustomeDao();
        Session session = Main.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            list = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
        return list;
    }

    @Override
    public void delete(Long custId) {
        CustomerDaoImpl dao = new CustomeDao();
        Session session = Main.getCurrentSession();
        Transaction tx= session.beginTransaction();
        try {
            dao.delete(custId);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
    }

    @Override
    public Customer get(Long custId) {
        CustomerDaoImpl dao = new CustomeDao();
        Session session = Main.getCurrentSession();
        Transaction tx= session.beginTransaction();
        Customer customer =null;
        try {
            customer = dao.get(custId);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
        return customer;
    }

    @Override
    public void edit_save(Customer customer) {

        CustomerDaoImpl dao = new CustomeDao();
        Session session = Main.getCurrentSession();
        Transaction tx= session.beginTransaction();
        try{
            dao.edit_save(customer);
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
    }

    @Override
    public int count_info(String custName) {
        int count_info=0;
        CustomerDaoImpl dao = new CustomeDao();
        Session session = Main.getCurrentSession();
        Transaction tx= session.beginTransaction();
        try{
           count_info= dao.count_info(custName);
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
        return count_info;
    }

    @Override
    public List<Customer> getlist(int page, String custName) {
        List<Customer> list= null;
        CustomerDaoImpl dao = new CustomeDao();
        Session session = Main.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            list = dao.getlist(page,custName);
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
        return list;
    }

}
