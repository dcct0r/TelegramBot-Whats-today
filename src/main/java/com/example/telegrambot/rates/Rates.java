package com.example.telegrambot.rates;

public enum Rates {

    RUB("rub", "₽"),
    USD("usd", "$"),
    EUR("eur", "€"),
    AMD("amd", "֏"),
    BYN("byn", "руб."),
    GBP("gbp", "£"),
    GEL("gel", "₾"),
    CNY("cny", "¥"),
    TRY("try", "₺"),
    UYU("uyu", "$U"),
    JPY("jpy", "¥"),
    KZT("kzt", "₸"),
    UAH("uah", "₴");

    private final String cur;
    private String curSymb;
    Rates(String cur, String curSymb) {
        this.cur = cur;
        this.curSymb = curSymb;
    }

    public String getCur() {
        return cur;
    }

    public String getCurSymb() {
        return curSymb;
    }
}
