package dao;
import java.util.List;
/**
 * @desc 所有数据库访问的总接口
 **/
public interface DAO <T>{

    int save(T t);
    /**
     * @Description :更新对应的对象，更新成功返回1，否则返回0
     * @Param * @param id ：
     * @return int
     **/
    int upDate(T t);
    /**
     * @Description :删除指定id对应的对象，删除成功返回1，否则返回0
     * @Param * @param id ：
     * @return int
     **/
    int remove(int id);
    /**
     * @Description :获取指定id对应的对象
     * @Param * @param id ：
     * @return T
     **/
    T get(int id);
    /**
     * @Description :获取所有的数据
     * @Param * @param  ：
     * @return java.util.List<T>
     **/
    List<T> getAll();
    /**
     * @Description :获取总记录数
     * @Param * @param  ：
     * @return int
     **/
    int getCount(String sql);
}
