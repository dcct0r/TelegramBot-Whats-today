package com.example.telegrambot.buttons;

import com.example.telegrambot.rates.Rates;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import java.util.ArrayList;
import java.util.List;

public class ButtonsRatesList {

    private static final String RUSSIAN_LANGUAGE = "RUSSIAN_LANGUAGE";
    private static final String ENGLISH_LANGUAGE = "ENGLISH_LANGUAGE";

    public static ReplyKeyboardMarkup currenciesKeyboardMarkup() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();

        keyboardRow.add(Rates.EUR.getCur() + EmojiParser.parseToUnicode(" :eu:"));
        keyboardRow.add(Rates.USD.getCur() + EmojiParser.parseToUnicode(" :us:"));
        keyboardRow.add(Rates.RUB.getCur() + EmojiParser.parseToUnicode(" :ru:"));

        keyboardRows.add(keyboardRow);

        keyboardRow = new KeyboardRow();

        keyboardRow.add(Rates.AMD.getCur() + EmojiParser.parseToUnicode(" :am:"));
        keyboardRow.add(Rates.GBP.getCur() + EmojiParser.parseToUnicode(" :gb:"));
        keyboardRow.add(Rates.BYN.getCur() + EmojiParser.parseToUnicode(" :by:"));

        keyboardRows.add(keyboardRow);

        keyboardRow = new KeyboardRow();

        keyboardRow.add(Rates.GEL.getCur() + EmojiParser.parseToUnicode(" :ge:"));
        keyboardRow.add(Rates.CNY.getCur() + EmojiParser.parseToUnicode(" :cn:"));
        keyboardRow.add(Rates.TRY.getCur() + EmojiParser.parseToUnicode(" :tr:"));

        keyboardRows.add(keyboardRow);

        keyboardRow = new KeyboardRow();

        keyboardRow.add(Rates.UYU.getCur() + EmojiParser.parseToUnicode(" :uy:"));
        keyboardRow.add(Rates.JPY.getCur() + EmojiParser.parseToUnicode(" :jp:"));
        keyboardRow.add(Rates.KZT.getCur() + EmojiParser.parseToUnicode(" :kz:"));
        keyboardRow.add(Rates.UAH.getCur() + EmojiParser.parseToUnicode(" :ua:"));

        keyboardRows.add(keyboardRow);

        keyboardMarkup.setKeyboard(keyboardRows);

        return keyboardMarkup;
    }

    public static InlineKeyboardMarkup languageKeyboardMarkup() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();

        var buttonRu = new InlineKeyboardButton();
        buttonRu.setText("Russian" + EmojiParser.parseToUnicode(" :ru:"));
        buttonRu.setCallbackData(RUSSIAN_LANGUAGE);

        var buttonEng = new InlineKeyboardButton();
        buttonEng.setText("English" + EmojiParser.parseToUnicode(" :gb:"));
        buttonEng.setCallbackData(ENGLISH_LANGUAGE);

        rowInLine.add(buttonRu);
        rowInLine.add(buttonEng);
        rowsInLine.add(rowInLine);

        markupInline.setKeyboard(rowsInLine);

        return markupInline;
    }
}
