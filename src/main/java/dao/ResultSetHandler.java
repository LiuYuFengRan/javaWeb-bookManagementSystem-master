package dao;
import java.sql.ResultSet;

/**
 * @desc 结果集的处理器接口
 **/
public interface ResultSetHandler<T> {
    T resultSetHandler(ResultSet resultSet);
}
