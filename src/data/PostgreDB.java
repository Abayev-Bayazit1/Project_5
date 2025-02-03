package data;

import data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreDB implements IDB {
    private static PostgreDB instance;
    private String host;
    private String username;
    private String password;
    private String DbName;

    private Connection connection;

    public PostgreDB(String host, String username, String password, String DbName) {
        setHost(host);
        setUsername(username);
        setPassword(password);
        setDbName(DbName);
    }

    public static synchronized PostgreDB getInstance(String host, String username, String password, String DbName) {
        if (instance == null) {
            instance = new PostgreDB(host, username, password, DbName);
        }
        return instance;  // Public method to provide access to the instance
    }

@Override
public Connection getConnection() {
        String connectionUrl = host + '/' + DbName;

    try {
        if (connection != null && !connection.isClosed()) {
            return connection;
        }

            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(connectionUrl, username, password);


            return connection;
        } catch (Exception e) {
        System.out.println("failed to connect to database" + e.getMessage());
    }

    return null;
}

    public void setHost(String host) {this.host = host;}

    public String getHost() {return host;}

    public void setUsername(String username) {this.username = username;}

    public String getUsername() {return username;}

    public void setPassword(String password) {this.password = password;}

    public String getPassword() {return password;}

    public void setDbName(String DbName) {this.DbName = DbName;}

    public String getDbName() {return DbName;}

    @Override
    public void close() {
    if(connection != null) {
        try{
            connection.close();
        }catch (SQLException e) {
            System.out.println("Connection close Error" + e.getMessage());
            }
        }
    }

}