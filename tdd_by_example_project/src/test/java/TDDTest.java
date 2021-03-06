import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TDDTest {
//    @Test
//    public void testMultiplication() {
//        Money five = Money.dollar(5);
//        assertEquals(new Dollar(10), five.times(2));
//        assertEquals(new Dollar(15), five.times(3));
//    }
//
//    @Test
//    public void testEquality() {
//        assertTrue(new Dollar(5).equals(new Dollar(5)));
//        assertFalse(new Dollar(5).equals(new Dollar(6)));
//        assertTrue(new Franc(5).equals(new Franc(5)));
//        assertFalse(new Franc(5).equals(new Franc(6)));
//        assertFalse(new Franc(5).equals(new Dollar(5)));
//    }

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

//    @Test
//    public void testFrancMultiplication() {
//        Money five = Money.franc(5);
//        assertEquals(Money.franc(10), five.times(2));
//        assertEquals(Money.franc(15), five.times(3));
//    }
//    public void testFrancMultiplication() {
//        Franc five= new Franc(5);
//        assertEquals(new Franc(10), five.times(2));
//        assertEquals(new Franc(15), five.times(3));
//    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

//    @Test
//    public void testDifferentClassEquality() {
//        assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
//    }

    @Test
    public void testSimpleAddition() {
        Money five= Money.dollar(5);
        Expression sum= five.plus(five);
        Bank bank= new Bank();
        Money reduced= bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnsSum() {
        Money five= Money.dollar(5);
        Expression result= five.plus(five);
        Sum sum= (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum() {
        Expression sum= new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank= new Bank();
        Money result= bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank= new Bank();
        Money result= bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank= new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result= bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testArrayEquals() {
        assertEquals(new Object[] {"abc"}, new Object[] {"abc"});
    }

    @Test
    public void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition() {
        Expression fiveBucks= Money.dollar(5);
        Expression tenFrancs= Money.franc(10);
        Bank bank= new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result= bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testSumPlusMoney() {
        Expression fiveBucks= Money.dollar(5);
        Expression tenFrancs= Money.franc(10);
        Bank bank= new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum= new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Money result= bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void testSumTimes() {
        Expression fiveBucks= Money.dollar(5);
        Expression tenFrancs= Money.franc(10);
        Bank bank= new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum= new Sum(fiveBucks, tenFrancs).times(2);
        Money result= bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }

//    @Test
//    public void testPlusSameCurrencyReturnsMoney() {
//        Expression sum= Money.dollar(1).plus(Money.dollar(1));
//        assertTrue(sum instanceof Money);
//    }


    private class FullFile extends File {
        public FullFile(String path) {
            super(path);
        }
        public boolean createNewFile() throws IOException {
            throw new IOException();
        }
    }

//    @Test
//    public void testFileSystemError() {
//        File f= new File("foo") {
//            public boolean createNewFile() throws IOException {
//                throw new IOException();
//            }
//        };
//        try {
//            saveAs(f);
//            fail();
//        } catch (IOException e) {
//        }
//    }


    private int plus(int augend, int addend) {
        return augend + addend;
    }

//    @Test
//    public void testSum() {
//        assertEquals(4, plus(3, 1));
//    }

    @Test
    public void testSum() {
        assertEquals(4, plus(3, 1));
        assertEquals(7, plus(3,4));
    }



    @Test
    public void testSum2() {
        Exercise exercise = new Exercise();
      //  assertEquals(5, exercise.sum(new int[] {5}));
        assertEquals(12, exercise.sum(new int[] {5, 7}));
    }

//    private Rectangle empty;
//    public void setUp() {
//        empty= new Rectangle(0,0,0,0);
//    }
//    @Test
//    public void testEmpty() {
//        assertTrue(empty.isEmpty());
//    }
//    @Test
//    public void testWidth() {
//        assertEquals(0.0, empty.getWidth(), 0.0);
//    }

//    @Test
//    public void testRate() {
//        exchange.addRate("USD", "GBP", 2);
//        int rate= exchange.findRate(???USD???, ???GBP???);
//        assertEquals(2, rate);
//    }
//
//    @Test
//    public void testMissingRate() {
//        try {
//            exchange.findRate("USD", ???GBP");
//                    fail();
//        } catch (IllegalArgumentException expected) {
//        }
//    }

}
