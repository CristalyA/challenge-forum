package conexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteRemocao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.conexao();

        PreparedStatement stm =  connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
        stm.setInt(1,2);
        stm.execute();

        Integer linhasModificadas = stm.getUpdateCount();

        System.out.println(linhasModificadas);


    }

}
