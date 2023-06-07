package conexaoBanco;

import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection connection = factory.conexao()) {
            connection.setAutoCommit(false);


            //TRY WITH RESOURCES
            try (PreparedStatement stm =
                         connection.prepareStatement("INSERT INTO PRODUTO (nome,descricao) VALUES (?,?)",
                                 Statement.RETURN_GENERATED_KEYS);
            ) {
                adicionarVariavel("CAIXA DE SOM JBL ", " 50 W", stm);
                adicionarVariavel("FONE DE OUVIDO SEM FIO", "FONE JBL", stm);

                connection.commit();


            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Roolback");
                connection.rollback();
            }
        }

    }

    private  static void adicionarVariavel (String name, String description, PreparedStatement stm) throws SQLException{

        stm.setString(1,name);
        stm.setString(2, description);

        stm.execute();

       try( ResultSet rst = stm.getGeneratedKeys()) {
           while (rst.next()) {
               Integer id = rst.getInt(1);
               System.out.println(id);
           }
       }
    }

}
