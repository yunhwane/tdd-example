package com.example.tddcoremoney.Money;

class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public boolean equals(Object o){
        Money money = (Money) o;
        return money.amount == this.amount && this.currency.equals(money.currency);
    }

    public Expression times(int multiplier){
        return new Money(amount*multiplier, currency);
    }

    String currency(){
        return currency;
    }

    static Money doller(int amount){
        return new Doller(amount, "USD");
    }

    static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Money reduce(Bank bank, String to){
        int rate = bank.rate(currency, to);
        return new Money(amount/rate, to);
    }
}