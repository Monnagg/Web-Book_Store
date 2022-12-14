package dao.impl;

import com.mysql.jdbc.JDBC4Connection;
import jdk.nashorn.internal.runtime.regexp.joni.constants.internal.Arguments;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.Jdbc_utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    public int update(String sql, Object ...args){
        Connection connection = Jdbc_utils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public <T> T queryForOne(Class<T> type, String sql,Object...args){
        Connection connection= Jdbc_utils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Jdbc_utils.close(connection);
        }
        return null;
    }

    public <T>List<T> queryForList(Class<T> type,String sql, Object ...args){
        Connection connection= Jdbc_utils.getConnection();

        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Jdbc_utils.close(connection);
        }
        return null;
    }

    public Object queryForSingleValue(String sql, Object...args){
        Connection connection= Jdbc_utils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Jdbc_utils.close(connection);
        }
        return null;
    }
}
