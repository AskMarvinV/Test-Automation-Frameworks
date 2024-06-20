public class Product {

    private int id;
    private String name;
    private String description;
    private double price;
    private int category_id;

    public Product() {
    };

    //Used for Post request
    public Product(String name, String description, double price, int categoryId) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategoryId(categoryId);
    }

    //Used for Put request
    public Product(int id, String name, String description, double price, int categoryId) {
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategoryId(categoryId);
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getCategoryId() {
        return category_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategoryId(int categoryId) {
        this.category_id = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category_id=" + category_id +
                '}';
    }
}
