package domain;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/**

 * @desc 测试类
 **/
public class AccountTest {
    @Test
    public void testAccount() {
        Class<Account> accountClass = Account.class;
        Method[] methods = accountClass.getMethods();
        for (Method method:methods){

            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length==1){
                System.out.println(parameterTypes[0].getName());
            }
        }
    }
}
