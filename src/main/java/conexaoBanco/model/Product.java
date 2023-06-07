package conexaoBanco.model;

public class Product {

    private Integer id;
    private  String name;
    private String description;

    public Product(String name, String description) {
       super();
       this.name = name;
       this.description = description;
    }

    public Product(Integer id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Produto criado:  %d,%s, %s",
                this.id, this.name, this.description);
    }
}
