public class Main {

    public static void main(String[] args) {
        Dollar dollar1 = new Dollar(3);
        Exchange exchange = new Exchange(0.5, 2);
        Franc franc = exchange.dollarToFranc(dollar1);
        System.out.println(franc.getAmount());
        Dollar dollar2 = exchange.francToDollar(franc);
        System.out.println(dollar2.getAmount());
    }
}
