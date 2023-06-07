package conexaoBanco;

import java.sql.Connection;
import java.sql.SQLException;

import  com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class ConnectionFactory {

    //Faz com que o pool funcione
    public DataSource dataSource;
    public ConnectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=ture&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root");

        comboPooledDataSource.setMaxPoolSize(15);


        this.dataSource = comboPooledDataSource;
    }

    public Connection conexao()throws SQLException {
        return this.dataSource.getConnection();
    }
}
