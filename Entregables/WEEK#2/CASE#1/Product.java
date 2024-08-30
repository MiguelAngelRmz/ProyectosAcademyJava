public abstract class Product {
    protected String name;
    protected String category;
    protected Integer quantityOfStock;

    public Product(String name, String category, Integer quantityOfStock) {
        this.name = name;
        this.category = category;
        this.quantityOfStock = quantityOfStock;
    }

    public Integer getQuantityOfStock() {
        return quantityOfStock;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + "(" + category + ") - Stock: " + quantityOfStock;
    }
}
