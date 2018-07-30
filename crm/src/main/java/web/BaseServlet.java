package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet")
public  class BaseServlet extends HttpServlet {



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");
        System.out.println("method="+methodName);
        if(methodName == null ||methodName.trim().isEmpty()){
            System.out.println("方法无参数");
            throw new  RuntimeException("请输入参数");
        }

        Class c =this.getClass();
        Method method = null;
        try{
            //System.out.println("执行方法"+methodName);
            method = this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);

        }catch (NoSuchMethodException e){
            System.out.println("这里异常");
            e.printStackTrace();
        }catch (SecurityException e){
            e.printStackTrace();
        }


        try{
            String result = (String)method.invoke(this,req,resp);
            if(result.equals(null)){

            }else{
                if(result.contains(":")){
                    //System.out.println("result="+result);
                    int index = result.indexOf(":");
                    String s = result.substring(0,index);
                    String path = result.substring(index+1);
                    //System.out.println("path="+path);
                    if(s.equalsIgnoreCase("f")){
                        //System.out.println(path);
                        req.getRequestDispatcher(req.getContextPath()+path).forward(req,resp);
                    }else if(s.equalsIgnoreCase("r")){
                        resp.sendRedirect(req.getContextPath()+path);
                    }
                }
            }

        }catch (Exception e){
            throw new RuntimeException();
        }



    }
}
