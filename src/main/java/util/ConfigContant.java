package util;

/**
 * @desc 常量文件
 **/
public class ConfigContant {
    /**用户表*/
    public static final String ACCOUNT_TABLE=ConfigPropertiesUtil.getPropertiesValueByName("AccountTable");
    /**图书表*/
    public static final String BOOK_TABLE=ConfigPropertiesUtil.getPropertiesValueByName("BookTable");
    /**借书表*/
    public static final String BORROWBOOK_TABLE=ConfigPropertiesUtil.getPropertiesValueByName("BorrowBookTable");


}
