package conexaoBanco;

import conexaoBanco.dao.CategoriaDAO;
import conexaoBanco.model.Categoria;
import conexaoBanco.model.Product;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemCategorias {
    public static void main(String[] args) throws SQLException {

        try(Connection connection = new ConnectionFactory().conexao()) {
            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listCategorias = categoriaDAO.listarcomProdutos();
            listCategorias.stream().forEach(ct -> {
                System.out.println(ct.getNome());
            for (Product product: ct.getProducts()) {
                System.out.println(ct.getNome() + " - " + product.getName());
                }
            });
        }
    }
}
