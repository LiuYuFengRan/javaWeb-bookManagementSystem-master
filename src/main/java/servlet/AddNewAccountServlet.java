package servlet;

import com.alibaba.fastjson.JSON;
import domain.Account;
import service.AccountService;
import service.impl.AaccountServiceImpl;
import util.EncapsulateJavaBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @TODO:
 */
@WebServlet("/addNewAccountServlet")
public class AddNewAccountServlet extends HttpServlet {
    AccountService accountService = new AaccountServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        //获取所有的参数
        Map<String, String[]> parameterMap = request.getParameterMap();

        System.out.println("添加新用户返回的请求："+parameterMap);

        System.out.println("获取日期框中的数据："+request.getParameter("createTime"));

        Map<String ,String > map= new HashMap<>();
        if (parameterMap.size()==0){
            map.put("msg","添加新账户出错！");
            String jsonString = JSON.toJSONString(map);

            System.out.println("JSON.toJSONString(map)"+jsonString);

            response.getWriter().write(jsonString);
            return;
        }
        Map<String, String> accountParameterMap = new HashMap<String, String>();
        //获取书用户参数map
        for (Map.Entry<String,String[]> entry:parameterMap.entrySet()){
            accountParameterMap.put(entry.getKey(),entry.getValue()[0]);
        }

        System.out.println("遍历map集合：");

        Iterator<Map.Entry<String, String>> it = accountParameterMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }



        //获取用户的对象
        Account account = EncapsulateJavaBean.encapsulateJavaBean(Account.class, accountParameterMap);
        System.out.println("获取用户的对象"+account.getCreateTime());
        //向数据库中存储书籍
        boolean fla = this.accountService.addNewAccount(account);
        if (fla){
            map.put("msg","添加新账户成功！");
            String jsonString = JSON.toJSONString(map);
            response.getWriter().write(jsonString);
        }else {
            map.put("msg","添加新账户出错！");
            String jsonString = JSON.toJSONString(map);
            response.getWriter().write(jsonString);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
