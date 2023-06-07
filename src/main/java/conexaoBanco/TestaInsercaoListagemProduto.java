package conexaoBanco;

import conexaoBanco.dao.ProductDAO;
import conexaoBanco.model.Product;

import java.sql.*;
import java.util.List;

public class TestaInsercaoListagemProduto {
    public static void main(String[] args) throws SQLException {

        Product teclado = new Product("TECLADO","TECLADO SEM FIO");

        try (Connection connection = new ConnectionFactory().conexao()){

            ProductDAO produtoDAO = new ProductDAO(connection);

            produtoDAO.save(teclado);
            List<Product> productList = produtoDAO.list();
            productList.stream().forEach(lp -> System.out.println(lp));


            }
        }
    }
