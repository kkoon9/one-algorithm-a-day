package test;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminConnectionMaker implements ConnectionMaker {
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        return null;
    }
}
