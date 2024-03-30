package com.example.tddcoremoney.Money;

import java.util.Hashtable;

class Bank {

    private Hashtable<Pair, Integer> rates = new Hashtable<>();

    void addRate(String from, String to, int rate){
        rates.put(new Pair(from, to), rate);
    }
     Money reduce(Expression source, String to){
         return source.reduce(this , to);
     }

     int rate(String from, String to){
         if(from.equals(to)) return 1;
         return (Integer) rates.get(new Pair(from, to));
     }
}
