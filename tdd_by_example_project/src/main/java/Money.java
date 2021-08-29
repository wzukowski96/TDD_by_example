import java.io.File;
import java.io.IOException;

public class Money implements Expression{
    protected int amount;
    protected String currency;

//    public boolean equals(Object object) {
//        Money money= (Money) object;
//        return amount == money.amount;
//    }

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }


    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount
                && currency().equals(money.currency());
    }


    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

   // abstract String currency();



    String currency() {
        return currency;
    }

    public String toString() {
        return amount + " " + currency;
    }

//    Money times(int multiplier) {
//        return new Money(amount * multiplier, currency);
//    }

//    Expression times(int multiplier) {
//        return new Money(amount * multiplier, currency);
//    }

//    Expression plus(Money addend) {
//        return new Sum(this, addend);
//    }

//    Expression plus(Expression addend) {
//        return new Sum(this, addend);
//    }

//    public Money reduce(String to) {
//        return this;
//    }

//    public Money reduce(Bank bank, String to) {
//        int rate = (currency.equals("CHF") && to.equals("USD"))
//                ? 2
//                : 1;
//        return new Money(amount / rate, to);
//    }

    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }









}
