package com.example.telegrambot.buttons;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

public interface ButtonCommandsList {
    List<BotCommand> cmdList = List.of(
            new BotCommand("/currency", "catalog of currencies"),
            new BotCommand("/conversion", "convert your money"),
            new BotCommand("/language", "choose language"),
            new BotCommand("/help", "info")
    );
}
