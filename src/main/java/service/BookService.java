package service;

import domain.Book;
import domain.PageBean;

import java.util.Map;

/**
 * @desc  书籍的业务逻辑接口
 **/
public interface BookService {
/**
 * @Description :  通过数据的起始位置，页面大小，查询条件，排序的名称以及排序方式来进行获得排序的对象
 * @Param * @param offset  数据的起始位置
* @param pageSize  页面的大小
* @param condition ：  查询的条件
* @param tableSortName 排序的列名
 * @param tableOrder 排序的方式
 * @return domain.PageBean<domain.Book>
 **/
    PageBean<Book> findABookByPage(int offset, int pageSize, Map<String, String> condition, String tableSortName, String tableOrder);
/**
 * @Description : 通过数据的起始位置，页面大小，搜索的条件，排序的名称以及排序方式来进行获得排序的对象
 * @Param * @param offset
 * @param pageSize   页面的大小
 * @param fuzzySearchContent  模糊搜索的内容
 * @param tableSortName  排序的列名
 * @param tableOrder ：排序的方式
 * @return domain.PageBean<domain.Book>
 **/
    PageBean<Book> fuzzySearchABookByPage(int offset, int pageSize, String fuzzySearchContent, String tableSortName, String tableOrder);
/**
 * @Description :通过ID来删除书籍
 * @Param * @param id ：
 * @return boolean
 **/
    boolean removeBookById(int id);
/**
 * @Description :更新数据库中的书籍
 * @Param * @param book ：
 * @return boolean
 **/
    boolean updateBook(Book book);
/**
 * @Description :通过id获取书籍
 * @Param * @param bookid ：
 * @return domain.Book
 **/
    Book findBookById(int bookid);
/**
 * @Description :向数据库中添加新的书籍
 * @Param * @param book ：
 * @return boolean
 **/
    boolean addNewBook(Book book);
}
