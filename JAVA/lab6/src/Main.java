public class Main {

    public static void main(String[] args) {

        Exchange exchange = new Exchange(0.5, 2);
        System.out.println(exchange.dollarToFrancRatio());
        System.out.println(exchange.francToDollarRatio());

        System.out.println();


        Dollar dollar1 = new Dollar(3);
        exchange = new Exchange(0.5, 2);
        Franc franc = exchange.dollarToFranc(dollar1);
        System.out.println(franc.getAmount());
        Dollar dollar2 = exchange.francToDollar(franc);
        System.out.println(dollar2.getAmount());
        
    }

}
