package web;

import domain.Customer;
import org.apache.commons.beanutils.BeanUtils;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class CustomerServlet extends BaseServlet {
    CustomerServiceImpl service = new CustomerService();

    public Customer get_param(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException{
        Customer customer = new Customer();
        try {
            Map map = request.getParameterMap();
            for(Object o: map.keySet()){
                System.out.println(o );
            }
            BeanUtils.populate(customer,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer c = get_param(request,response);
        service.save(c);
        /*response.sendRedirect(request.getContextPath()+"ListCustomerServlet");*/
        return "f:/jsp/customer/add.jsp";
    }

    public String getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String custName =request.getParameter("custName");
        int count_info = service.count_info(custName);

        int page =1;
        List<Customer> list=null;
        int totalPage=1;
        if(count_info%10==0){
            totalPage= count_info/10;
        }else{
            totalPage=count_info/10+1;
        }
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("total",count_info);
        String page_str=request.getParameter("page");
        if(page_str==null||page_str.isEmpty()){
            page=1;
        }else if(Integer.parseInt(page_str)>totalPage){
            page=totalPage;
        }else{
            page = Integer.parseInt(page_str);
        }
        if(page==1){
            request.setAttribute("page",1);
        }else{
            request.setAttribute("page",page);
        }
       list = service.getlist(page,custName);
        request.setAttribute("list",list);
        /*request.getRequestDispatcher("/jsp/customer/list1.jsp").forward(request,response);*/
        System.out.println("custname="+request.getParameter("custName"));
        return "f:/jsp/customer/list.jsp";
    }


    public String  delete(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

        Long custId= (long)Integer.parseInt(request.getParameter("custId"));
        service.delete(custId);
        return "r:"+request.getContextPath()+"CustomerServlet?method=getAll";
    }

    public String edit(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        Long custId= (long)Integer.parseInt(request.getParameter("custId"));
        System.out.println("edit获取到值"+custId);
        Customer customer = get(custId);
        request.setAttribute("customer",customer);
        System.out.println("即将转发到editjsp");
        return "f:/jsp/customer/edit.jsp";
    }


    public  Customer get(Long custId){
        Customer  customer =  new Customer();
        customer= service.get(custId);
        return customer;
    }

    public String edit_save(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        Customer customer = get_param(request,response);
        service.edit_save(customer);
        return "f:/jsp/success.jsp";
    }


}
