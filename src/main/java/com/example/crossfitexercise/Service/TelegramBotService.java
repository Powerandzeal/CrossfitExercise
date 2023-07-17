package com.example.crossfitexercise.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import static com.example.crossfitexercise.Service.TelegramBotListener.*;

@Service
public class TelegramBotService {


    private final TelegramBot telegramBot;


    public TelegramBotService(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void sendHello(Long chatId) {
        SendMessage message = new SendMessage(chatId, "Я работаю");
        telegramBot.execute(message);
    }

//    public InlineKeyboardButton getProgram() {  // метод записи данных
//        InlineKeyboardButton button = new InlineKeyboardButton("записать данные");
//        button.callbackData(GET_PROGRAM_LEVEL_PRO);
//        return button;
//    }

    public void firstMenu(Long chatId) { // кнопки этапа 1, кейсы между 1 и 2

        SendMessage message = new SendMessage(chatId, "Спасибо что пользуешься ботом");

        InlineKeyboardButton buttonGetExercisePro = new InlineKeyboardButton("Получить программу уровень pro");
        buttonGetExercisePro.callbackData(GET_PROGRAM_LEVEL_PRO);

        InlineKeyboardButton buttonGetMotivate = new InlineKeyboardButton("Получить мотивацию");
        buttonGetMotivate.callbackData(GET_MOTIVATION);
//
        InlineKeyboardButton buttonGetExerciseBeginner = new InlineKeyboardButton("Комплекс упражнений уровень beginner");
        buttonGetExerciseBeginner.callbackData(GET_PROGRAM_LEVEL_BEGINNER);

//        InlineKeyboardButton buttonGlossary = new InlineKeyboardButton("Кроссфит глоссарий");
//        buttonGlossary.callbackData(GET_GLOSSARY);
//
//        InlineKeyboardButton buttonGetProgramWithoutImplements = new InlineKeyboardButton("Получить программу тренеровки " +
//                "без оборудования с собственным весом");
//        buttonGetProgramWithoutImplements.callbackData(GET_PROGRAM_WITHOUT_IMPLEMENTS);

        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        keyboard.addRow(buttonGetExercisePro);
        keyboard.addRow(buttonGetExerciseBeginner);
        keyboard.addRow(buttonGetMotivate);

//        keyboard.addRow(buttonGetProgramWithoutImplements);
//        keyboard.addRow(buttonGlossary);

        message.replyMarkup(keyboard);
        telegramBot.execute(message);
    }
}
