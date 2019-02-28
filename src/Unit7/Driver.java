package Unit7;

public class Driver {
    public static void main(String[] args) {
        MonetaryCoin coin = new MonetaryCoin(15);
        coin.flip();
        System.out.println(coin.isHeads());
        System.out.println(coin.getValue());
    }
}
