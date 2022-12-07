package servlet;

import domain.Account;
import service.AccountService;
import service.impl.AaccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @TODO:用户注册的servlet
 */
@WebServlet("/accountRegisterServlet")
public class AccountRegisterServlet extends HttpServlet {
    AccountService accountService = new AaccountServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        //获取用户输入的验证码
        String login_checkcode = (String) request.getParameter("checkcode");
        //获取用户名和密码
        String name= (String) request.getParameter("name");
        String password= (String) request.getParameter("password");
        //获取用户性别
        String sex=request.getParameter("sex");
        //获取用户电话
        String phone=request.getParameter("phone");
        //获取用户邮箱
        String email=request.getParameter("email");
        //获取用户类型
        String type = request.getParameter("type");
        System.out.println("用户注册的类型："+type);

        //设置回显的数据
        request.setAttribute("name",name);
        request.setAttribute("password",password);
        request.setAttribute("sex",sex);
        request.setAttribute("phone",phone);
        request.setAttribute("email",email);
        request.setAttribute("type",type);

        /*验证码输入错误*/
        if (login_checkcode==null||login_checkcode.length()==0){
            request.getSession().removeAttribute("checkcode");
            //验证为空
            request.setAttribute("checkcode_err","验证码错误");
            request.getRequestDispatcher("/accountregister.jsp").forward(request,response);
        }else{
            //验证码不为空
            request.setAttribute("checkcode",login_checkcode);
            //获取网页自动生成的验证码
            String checkcode = (String) request.getSession().getAttribute("checkcode");
            request.getSession().removeAttribute("checkcode");
            //比较用户输入的验证码和网页生成的验证码
            if (checkcode.equalsIgnoreCase(login_checkcode)){
                //用户输入的验证码匹配
                request.setAttribute("checkcode_err","验证码正确");
                //封装只有用户名和密码的账号
                Account user=new Account();
                user.setName(name);

               /* 注册用户*/
                Account registerUser = accountService.findAccountByName(name);
                if (registerUser==null){
                    //该用户不存在，则说明该账号未注册
                    //设置用户密码
                    user.setPassword(password);
                    //设置用户性别
                    user.setSex(sex);
                   //设置用户联系方式
                    user.setPhone(phone);
                    //设置用户邮箱
                    user.setEmail(email);

                    //设置用户类型
                    if(type.compareTo("管理员")==0){
                        user.setType(Account.TYPE_ADMINISTRATOR);
                    }
                    if(type.compareTo("普通用户")==0){
                        user.setType(Account.TYPE_USER);
                    }
                    if(type.compareTo("游客")==0){
                        user.setType(Account.TYPE_TOURIST);
                    }


                    //设置创建账户时间
                    user.setCreateTime(new Date());
                    //将新的用户信息添加到数据库中去
                  boolean fla=  accountService.saveAccount(user);
                  if (fla){
                      //添加成功转到登录页面
                      response.sendRedirect(request.getContextPath()+"/login.jsp");
                  }else {
                      //添加失败
                  }

                }else {
                    //用户存在,说明该账号已经被注册
                    request.setAttribute("register_err","该账号已被注册");
                    response.sendRedirect(request.getContextPath()+"/accountregister.jsp");
                }
            }else {
                //用户输入的验证码不匹配
                request.setAttribute("checkcode_err","验证码错误");
                request.getRequestDispatcher("/accountregister.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
