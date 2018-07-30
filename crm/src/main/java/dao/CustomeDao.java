package dao;

import dao.impl.CustomerDaoImpl;
import domain.Customer;
import domain.Main;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
/*
HQL检索
 */

public class CustomeDao implements CustomerDaoImpl {
    @Override
    public void save(Customer c) {
        Session session = Main.getCurrentSession();
        session.save(c);

    }

    @Override
    public List<Customer> getAll() {
        Session  session = Main.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> list = query.list();
        return  list;
    }

    @Override
    public void delete(Long custId) {
        Session session = Main.getCurrentSession();
        Query query = session.createQuery("delete from Customer where custId =?");
        query.setParameter(0,custId);
        query.executeUpdate();
    }

    @Override
    public Customer get(Long custId) {
        Session sesion = Main.getCurrentSession();
        Query query = sesion.createQuery("from Customer where custId =?");
        query.setParameter(0,custId);
        return (Customer)query.uniqueResult();
    }

    @Override
    public void edit_save(Customer customer) {
        Session sesion = Main.getCurrentSession();
        Customer c = get(customer.getCustId());
        c.setCustName(customer.getCustName());
        c.setCustMobile(customer.getCustMobile());
        c.setCustLinkman(customer.getCustLinkman());
        c.setCustPhone(customer.getCustPhone());
        c.setCustSource(customer.getCustSource());
        sesion.save(c);
    }

    @Override
    public int count_info(String custName) {
        Session sesion = Main.getCurrentSession();
        String hql = "select count(*) from  Customer ";
        System.out.println("custName="+custName);
        if(custName!=null&&!custName.isEmpty()){
            hql=hql+"where custName like '%"+custName+"%'";
        }
        System.out.println(hql);
        Query query = sesion.createQuery(hql);
        System.out.println(((Long)query.uniqueResult()).intValue());
        return ((Long)query.uniqueResult()).intValue();
    }

    @Override
    public List<Customer> getlist(int page, String custName) {
        Session session = Main.getCurrentSession();
        String hql ="from Customer  ";
        if(custName!=null&&!custName.isEmpty()){
            hql = hql +" where custName like '%"+custName+"%'";
        }
        System.out.println(hql);
        Query query = session.createQuery(hql);
        query.setFirstResult((page-1)*10);
        query.setMaxResults(page*10);
        return query.list();
    }

}
