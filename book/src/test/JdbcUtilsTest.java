package test;

import org.junit.Test;
import utils.Jdbc_utils;

import java.sql.Connection;
import java.sql.SQLOutput;

public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 100; i++) {
            Connection connection= Jdbc_utils.getConnection();
            System.out.println(connection);
            Jdbc_utils.close(connection);

        }

    }

}
