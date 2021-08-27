public class Dollar extends Money{

   // private int amount;
   private String currency;

    Dollar(int amount) {
        this.amount = amount;
        currency = "USD";
    }

    Money times(int multiplier){
        return new Dollar(amount * multiplier);
    }

    String currency() {
        return currency;
    }

}
