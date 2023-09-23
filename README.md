## 🔥 Currency Pair Selection  
Users can choose from a wide range of available currency pairs such as USD/EUR, GBP/JPY and 12 more.

## 📅 Up-to-date information  
The bot provides up-to-date data on the exchange rate of the selected currency pair at the time the exchange closed. This allows users to monitor changes in exchange rates and make informed decisions.

![image](https://github.com/dcct0r/telegram-bot/assets/111187206/0993c3e8-19a0-4a91-9cd0-1b285d9585ba)

## 🔗 URL Structure
```
https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@{apiVersion}/{date}/{endpoint}
```

## 📆 Date

The date should either be latest or in YYYY-MM-DD format
Note: Historical rates are only available for last 6 months and some dates may be missing

The Endpoints Supports HTTP GET Method and returns the data in two formats:
```
/{endpoint}.json

/{endpoint}.min.json
```
The above formats also work for fallback i.e if .min.json link fails, you can use .json link and vice versa

Warning: You should include fallback mechanism in your code, to avoid issues

## 👉 Endpoints
```
/currencies
```
Lists all the available currencies in prettified json format:
```
https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies.json
```
Get a minified version of it:
```
https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies.min.json
```
```
/currencies/{currencyCode}
```
Get the currency list with EUR as base currency:
```
https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/eur.json
```
Get the currency list with EUR as base currency on date 2022-11-24:
```
https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/2022-11-24/currencies/eur.json
```


