public interface Expression {
    //Money reduce(String to);
    Expression times(int multiplier);

    Expression plus(Expression addend);

    Money reduce(Bank bank, String to);
}
