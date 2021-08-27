public class Dollar extends Money{

   // private int amount;
  // private String currency;

    Dollar(int amount, String currency) {
        super(amount, currency);
    }

//    Money times(int multiplier) {
//        return new Money(amount * multiplier, currency);
//    }

    String currency() {
        return currency;
    }

}
