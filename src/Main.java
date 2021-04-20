import java.util.Scanner;

public class Main {
    final static int MAX_ORDERS = 9;

    public static void main(String[] args) {
        Order[] orders = createOrders();
        StatusOrder inputStatusOrder = readStatus();

        Order[] theSameOrders = filterOrderByStatus(orders, inputStatusOrder);   //filtr nie uwzględnia braku zamówień o danym statusie
        showInfo(theSameOrders, inputStatusOrder);
    }

    private static Order[] createOrders(){
        Order[] orders = new Order[MAX_ORDERS];
        orders[0] = new Order("Komputer 1", 3000, StatusOrder.NEW);
        orders[1] = new Order("Komputer 2", 4000, StatusOrder.PAID);
        orders[2] = new Order("Komputer 3", 5000, StatusOrder.SHIPPED);
        orders[3] = new Order("Komputer 4", 6000, StatusOrder.DELIVERED);
        orders[4] = new Order("Komputer 5", 7000, StatusOrder.CANCELLED);
        orders[5] = new Order("Telefon1", 1000, StatusOrder.PAID);
        orders[6] = new Order("Telefon2", 1500, StatusOrder.PAID);
        orders[7] = new Order("Telefon3", 2000, StatusOrder.PAID);
        orders[8] = new Order("Telefon4", 500, StatusOrder.NEW);

        return orders;
    }


    static void showInfo(Order[] theSameOrders, StatusOrder inputStatusOrder){
        System.out.println("Lista zamówień ze statusem " + inputStatusOrder.getDescription());
        for (Order theSameOrder : theSameOrders) {
            if (theSameOrder != null)
                System.out.println(theSameOrder.toString());
        }
    }

    static void showPossibleValues(){
        StatusOrder[] values = StatusOrder.values();
        System.out.print("( ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i].name() + " ");
        }
        System.out.print(")\n");
    }

    static String getInputValue() {
        Scanner scanner = new Scanner(System.in);
        String inputStatus = scanner.nextLine().toUpperCase();          //brak zabezpieczenia przed wpisaniem czegos innego
        scanner.close();
        return inputStatus;
    }

    private static StatusOrder readStatus(){
        System.out.println("Podaj status zamówień do wyświetlenia: " );
        showPossibleValues();
        String inputStatus = getInputValue();
        StatusOrder inputStatusOrder = StatusOrder.valueOf(inputStatus);

        return inputStatusOrder;
    }

    public static Order[] filterOrderByStatus(Order[] orders, StatusOrder status){
        int size = countOrderByStatus(orders, status);
        Order[] orders1 = new Order[size];
        int j = 0;

        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getStatus() == status) {
                orders1[j] = orders[i];
                j++;
            }
        }
    return orders1;
    }

    private static int countOrderByStatus(Order[] orders, StatusOrder status) {
        int count = 0;
        for (Order order : orders) {
            if (order.getStatus() == status)
                count++;
        }
        return count;
    }
}
