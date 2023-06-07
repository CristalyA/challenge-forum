package conexaoBanco.dao;

import conexaoBanco.model.Categoria;
import conexaoBanco.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private  Connection connection;
    public ProductDAO(Connection connection) {

        this.connection = connection;
    }

    public void save(Product product) throws SQLException {
        String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, product.getName());
            pstm.setString(2, product.getDescription());

            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    product.setId(rst.getInt(1));
                }
            }
        }
    }

    public List<Product> list () throws SQLException{
        List<Product> products= new ArrayList<Product>();

        String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";

        try (PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()){
                while (rst.next()) {
                    Product product = new Product(rst.getInt(1),rst.getString(2),rst.getString(3));

                    products.add(product);
                }

            }

        }

        return products;
    }


    public List<Product> buscar(Categoria ct) throws  SQLException{
       List<Product> products = new ArrayList<Product>();

       String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";

       try (PreparedStatement pstm = connection.prepareStatement(sql)) {

           pstm.setInt(1,ct.getId());
           pstm.execute();

           try(ResultSet rst = pstm.getResultSet()){
               while (rst.next()){
                   Product product = new Product(rst.getInt(1), rst.getString(2),rst.getString(3));

                   products.add(product);
               }
           }

       }

       return products;

    }
}

