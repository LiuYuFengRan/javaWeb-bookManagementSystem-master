package dao.impl;

import org.junit.Test;

/**

 * @desc 测试类
 **/
public class AccountDaoImplTest {
    @Test
    public void testGetAll(){
        AccountDaoImpl accountDao=new AccountDaoImpl();
        System.out.println(accountDao.getAll());
    }

}
