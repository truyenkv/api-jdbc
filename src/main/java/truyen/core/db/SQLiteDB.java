package truyen.core.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDB {
    public static Connection connection;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static MysqlDataSource ds = null;

    public static MysqlDataSource Schema_DBname(String dataName) throws SQLException {
        if(ds==null){
            getDataSource(null,null,null, 3306);
        }
        ds.setDatabaseName(dataName);
        return ds;
    }

    public static Connection getDataSource(String url, String username, String password, int port) throws SQLException {
        ds = new MysqlDataSource();
        ds.setUrl(url);
        ds.setUser(username);
        ds.setPassword(password);
        ds.setPort(port);
        connection = DriverManager.getConnection(url );
        return connection;
    }

    public static Connection getConnection(String db_name) throws ClassNotFoundException, SQLException {
        if(connection==null){
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(db_name);
        }
        return connection; 
    }
}
