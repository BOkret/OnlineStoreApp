public enum StatusOrder {
    NEW("zamówione"),
    PAID("opłacone"),
    SHIPPED("wysłane"),
    DELIVERED("dostarczone"),
    CANCELLED("anulowane");

    private final String description;

    StatusOrder(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public String toString(){
        return name();
    }
}
