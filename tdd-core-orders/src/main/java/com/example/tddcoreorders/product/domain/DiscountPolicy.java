package com.example.tddcoreorders.product.domain;

public enum DiscountPolicy {
    NONE{
        @Override
        public int applyDiscount(final int price) {
            return price;
        }
    },
    Fix_1000_AMOUNT{
        @Override
        public int applyDiscount(final int price) {
            return Math.max(price - 1000, 0);
        }
    };

    public abstract int applyDiscount(final int price);


}
