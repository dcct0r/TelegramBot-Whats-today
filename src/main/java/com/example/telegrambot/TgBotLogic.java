package com.example.telegrambot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.example.telegrambot.buttons.ButtonsRatesList;
import com.example.telegrambot.config.BotConfig;
import com.example.telegrambot.controller.CurrencyModelService;
import com.example.telegrambot.model.CurrencyModel;
import static com.example.telegrambot.buttons.MenuCommandsList.cmdList;
import static com.example.telegrambot.languages.engLocalization.EngLanguageConst.*;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;


@Slf4j
@Component
public class TgBotLogic extends TelegramLongPollingBot {

    private final BotConfig config;
    private String[] wrd = new String[2];
    private int i = 0;

    TgBotLogic(BotConfig config) {
        this.config = config;
        try {
            this.execute(new SetMyCommands(cmdList, new BotCommandScopeDefault(), null));
            log.info("Button pressed");
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }

    private void onChooseLanguage(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(LANGUAGE_CHOOSE_TEXT_ENG);
        message.setReplyMarkup(ButtonsRatesList.languageKeyboardMarkup());
        try {
            execute(message);
            log.info("Seems like it works!");
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }

    private void onExchangeRates(long chatId, String baseRate, String transRate) throws IOException {
        CurrencyModel currencyModel = new CurrencyModel();
        String currency = CurrencyModelService.getCurrencyRate(baseRate, transRate, currencyModel);
        sendMessage(chatId, currency);
    }

    private void cutMessageString(String mText) {
        if(!mText.startsWith("/")) {
            if (i <= 2) {
                wrd[i] = mText.substring(0, mText.indexOf(" "));
                i++;
            } else {
                i = 0;
                wrd[0] = wrd[1] = "";
            }
        }
    }

    private void onCurrency(long chatId) {
        if(i == 2 && wrd[0].equals(wrd[1])) {
            sendMessage(chatId, CURRENCY_TEXT_ERROR_ENG);
            wrd[0] = wrd[1] = "";
            i = 0;
        } else if(i == 2){
            try {
                onExchangeRates(chatId, wrd[0], wrd[1]);
                i = 0;
                wrd[0] = wrd[1] = "";
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        } else sendMessage(chatId, CURRENCY_TEXT_ENG);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            cutMessageString(messageText);

            switch (messageText) {
                case "/start":
                    sendMessage(chatId, START_TEXT_ENG);
                    break;
                case "/currency":
                    onCurrency(chatId);
                    break;
                case "/conversion":

                    break;
                case "/language":
                    onChooseLanguage(chatId);
                    break;
                case "/help":
                    sendMessage(chatId, HELP_TEXT_ENG);
                    break;
            }

        }
    }

    public void sendMessage(Long chatId, String textToSend) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(textToSend);
        try {
            execute(sendMessage);
            log.info("Seems like it works!");
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }
}
