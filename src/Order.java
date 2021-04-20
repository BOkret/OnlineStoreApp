public class Order {
    private String name;
    private double price;
    private StatusOrder status;

    public Order(String name, double price, StatusOrder status) {
        this.name = name;
        this.price = price;
        this.status = status;
    }

    @Override
    public String toString() {
        return name + " " + "(" + price + "zł)" + " - " + status.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
        this.status = status;
    }
}
