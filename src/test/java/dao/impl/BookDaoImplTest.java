package dao.impl;

import org.junit.Test;

/**

 * @desc 测试类
 **/
public class BookDaoImplTest {
    @Test
    public void testGetAll(){
        BookDaoImpl accountDao=new BookDaoImpl();
        System.out.println(accountDao.getAll());
    }
}
