package service.impl;

import dao.BorrowBookDao;
import dao.impl.BorrowBookDaoImpl;
import domain.BorrowBook;
import service.BorrowBookService;

/**
 * @desc 借书业务逻辑的实现
 **/
public class BorrowBookServiceImpl implements BorrowBookService {
    BorrowBookDao borrowBookDao =  new BorrowBookDaoImpl();
    @Override
    public boolean saveBorrowBook(BorrowBook borrowBook) {
        int result = borrowBookDao.save(borrowBook);
        return result==1;
    }
}
