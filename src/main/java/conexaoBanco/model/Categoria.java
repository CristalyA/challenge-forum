package conexaoBanco.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private  Integer id;
    private String nome;
    private List<Product> products = new ArrayList<>();

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
