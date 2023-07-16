package com.example.crossfitexercise.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import static com.example.crossfitexercise.Service.TelegramBotListener.*;

@Service
public class TelegramBotService {


    private TelegramBot telegramBot;


    public TelegramBotService(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void sendHello(Long chatId) {
        SendMessage message = new SendMessage(chatId, "Я работаю");
        telegramBot.execute(message);
    }

    public void takeDogFromShelter(Long chatId) {  // кнопки этапа 2, кейсы между 2 и 3
        SendMessage message = new SendMessage(chatId, "Рекомендации для собак");

        InlineKeyboardButton button1 = new InlineKeyboardButton("Правила знакомства с собакой до того, как можно забрать ее из приюта.");
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        keyboard.addRow(button1);
        keyboard.addRow(getProgram());
        message.replyMarkup(keyboard);
        telegramBot.execute(message);
    }

    public InlineKeyboardButton getProgram() {  // метод записи данных
        InlineKeyboardButton button = new InlineKeyboardButton("записать данные");
        button.callbackData(GET_PROGRAM_LEVEL_PRO);
        return button;
    }

    public void firstMenu(Long chatId) { // кнопки этапа 1, кейсы между 1 и 2

        SendMessage message = new SendMessage(chatId, "Спасибо что пользуешься ботом");

        InlineKeyboardButton buttonGetExercisePro = new InlineKeyboardButton("Комплекс упражнений уровень pro");
        buttonGetExercisePro.callbackData(GET_PROGRAM_LEVEL_PRO);
        InlineKeyboardButton buttonGetMotivate = new InlineKeyboardButton("Получить мотивацию");
        buttonGetMotivate.callbackData(GET_MOTIVATION);
        InlineKeyboardButton buttonGetExerciseBeginner = new InlineKeyboardButton("Комплекс упражнений уровень beginner");
        buttonGetExerciseBeginner.callbackData(GET_PROGRAM_LEVEL_BEGINNER);
        InlineKeyboardButton buttonGlossary = new InlineKeyboardButton("Кроссфит глоссарий");
        buttonGetExerciseBeginner.callbackData(GET_GLOSSARY);
        InlineKeyboardButton buttonGetProgramWithoutImplements = new InlineKeyboardButton("Программа без оборудования с собственным весом");
        buttonGetExerciseBeginner.callbackData(GET_PROGRAM_WITHOUT_IMPLEMENTS);
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        keyboard.addRow(buttonGetExercisePro);
        keyboard.addRow(buttonGetExerciseBeginner);
        keyboard.addRow(buttonGetMotivate);
        keyboard.addRow(buttonGlossary);
        keyboard.addRow(buttonGetProgramWithoutImplements);
        message.replyMarkup(keyboard);
        telegramBot.execute(message);
    }
//    public void firstMenu(Long chatId) { // меню начальное, кейсы 1/2/3
//        SendMessage helloMessage = new SendMessage(chatId, "Главное меню. Выберите интересующий пункт из меню: ");
//
//        InlineKeyboardButton button1 = new InlineKeyboardButton("Узнать информацию о приюте!");
//        button1.callbackData(SHELTER_INFO_MENU);
//        InlineKeyboardButton button2 = new InlineKeyboardButton("Как взять собаку из приюта?");
//        button2.callbackData(HOW_TO_TAKE_DOG);
//        InlineKeyboardButton button3 = new InlineKeyboardButton("Прислать отчет о питомце");
//        button3.callbackData(SEND_REPORT);
//        InlineKeyboardButton button4 = new InlineKeyboardButton("Позвать волонтера");
//        button4.callbackData(CALL_VOLUNTEER);
//        InlineKeyboardButton button5 = new InlineKeyboardButton("Как взять кошку из приюта?");
//        button5.callbackData(HOW_TO_TAKE_CAT);
//        InlineKeyboardButton button6 = new InlineKeyboardButton("Записать данные");
//        button6.callbackData(WRITE_DOWN_CONTACT_DATA);
//        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
//        keyboard.addRow(button1,button3);
//        keyboard.addRow(button2,button4);
//        keyboard.addRow(cats(),saveInfo());
//        helloMessage.replyMarkup(keyboard);
//        telegramBot.execute(helloMessage);
//    }
//    public void firstMenu(Long chatId) { // меню начальное, кейсы 1/2/3
//        SendMessage helloMessage = new SendMessage(chatId, "Главное меню. Выберите интересующий пункт из меню: ");
//
//        InlineKeyboardButton button1 = new InlineKeyboardButton("Узнать информацию о приюте!");
//        button1.callbackData(SHELTER_INFO_MENU);
//        InlineKeyboardButton button2 = new InlineKeyboardButton("Как взять собаку из приюта?");
//        button2.callbackData(HOW_TO_TAKE_DOG);
//        InlineKeyboardButton button3 = new InlineKeyboardButton("Прислать отчет о питомце");
//        button3.callbackData(SEND_REPORT);
//        InlineKeyboardButton button4 = new InlineKeyboardButton("Позвать волонтера");
//        button4.callbackData(CALL_VOLUNTEER);
//        InlineKeyboardButton button5 = new InlineKeyboardButton("Как взять кошку из приюта?");
//        button5.callbackData(HOW_TO_TAKE_CAT);
//        InlineKeyboardButton button6 = new InlineKeyboardButton("Записать данные");
//        button6.callbackData(WRITE_DOWN_CONTACT_DATA);
//        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
//        keyboard.addRow(button1,button3);
//        keyboard.addRow(button2,button4);
//        keyboard.addRow(cats(),saveInfo());
//        helloMessage.replyMarkup(keyboard);
//        telegramBot.execute(helloMessage);
//    }
}
