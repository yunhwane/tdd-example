package com.example.tddcoremoney.Money;

import org.junit.jupiter.api.Test;

import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {


    @Test
    public void testDollerMultiplication(){
        Money five = Money.doller(5);
        assertEquals(Money.doller(10), five.times(2));
        assertEquals(Money.doller(15), five.times(3));
    }

    @Test
    public void testFrancMultiplication(){
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testEquality(){
        assertEquals(Money.doller(5), Money.doller(5));
        assertNotEquals(Money.doller(5), Money.doller(6));
        assertNotEquals(Money.franc(5), Money.doller(5));
    }

    @Test
    public void testCurrency(){
        assertEquals("USD", Money.doller(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.doller(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.doller(10), reduced);
    }

    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.doller(1), "USD");
        assertEquals(Money.doller(1), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD",2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.doller(1), result);
    }

    @Test
    public void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition(){
        Expression fiveBucks = Money.doller(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.doller(20), result);
    }

    @Test
    public void testPlusReturnsSum() {
        Expression sum = Money.doller(1).plus(Money.doller(1));
        assertTrue(sum instanceof Sum);
    }


}


