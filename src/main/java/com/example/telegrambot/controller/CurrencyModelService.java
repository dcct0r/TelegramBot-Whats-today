package com.example.telegrambot.controller;

import com.example.telegrambot.model.CurrencyModel;
import com.example.telegrambot.rates.Rates;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class CurrencyModelService {
    public static String getCurrencyRate(String baseRate, String transRate, CurrencyModel currencyModel) throws IOException {
        URL url = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/"
                + baseRate + "/" + transRate + ".json");

        Scanner scanner = new Scanner((InputStream) url.getContent());
        StringBuilder result = new StringBuilder();
        while (scanner.hasNext()){
            result.append(scanner.nextLine());
        }

        JSONObject object = new JSONObject(result.toString());

        currencyModel.setCurrencyPrice(object.getDouble(transRate));

        return baseRate.toUpperCase() + "/" + transRate.toUpperCase() + "\n" + currencyModel.getCurrencyPrice()
                + " " + getCurrencySymbol(transRate);
    }

    private static String getCurrencySymbol(String tR) {
        Rates[] rates = Rates.values();

        for(Rates rates1 : rates) {
            if(tR.equals(rates1.getCur())) {
                return rates1.getCurSymb();
            }
        }
        return " ";
    }
}
