package com.example.crossfitexercise.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.springframework.stereotype.Service;

import static com.example.crossfitexercise.Service.TelegramBotListener.*;

/**
 * Сервис Telegram-бота для кроссфит тренировок.
 */
@Service
public class TelegramBotService {

    private final TelegramBot telegramBot;
    private final TelegramGlossaryService telegramGlossaryService;
    private int currentPage = 0;
    private int messageId = 0;

    /**
     * Конструктор класса TelegramBotService.
     *
     * @param telegramBot             экземпляр TelegramBot для взаимодействия с Telegram API.
     * @param telegramGlossaryService сервис для работы с глоссарием.
     */
    public TelegramBotService(TelegramBot telegramBot, TelegramGlossaryService telegramGlossaryService) {
        this.telegramBot = telegramBot;
        this.telegramGlossaryService = telegramGlossaryService;
    }

    /**
     * Отправляет приветственное сообщение пользователю.
     *
     * @param chatId идентификатор чата.
     */
    public void sendHello(Long chatId) {
        SendMessage message = new SendMessage(chatId, "Я работаю");
        telegramBot.execute(message);
    }

    /**
     * Отображает главное меню с кнопками выбора комплексов тренировок.
     *
     * @param chatId идентификатор чата.
     */
    public void firstMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId, "Выбери интересующий комплекс и нажми на кнопку");

        InlineKeyboardButton button1 = new InlineKeyboardButton("Комплекс упражнений уровень pro");
        button1.callbackData(GET_PROGRAM_LEVEL_PRO);

        InlineKeyboardButton button2 = new InlineKeyboardButton("Получить совет");
        button2.callbackData(GET_MOTIVATION);

        InlineKeyboardButton button3 = new InlineKeyboardButton("Комплекс упражнений уровень beginner");
        button3.callbackData(GET_PROGRAM_LEVEL_BEGINNER);

        InlineKeyboardButton button4 = new InlineKeyboardButton("Комплекс упражнений без инвентаря");
        button4.callbackData(PROGRAM_WITHOUT);

        InlineKeyboardButton buttonGlossary = new InlineKeyboardButton("Кроссфит глоссарий");
        buttonGlossary.callbackData(GET_GLOSSARY);

        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        keyboard.addRow(button1);
        keyboard.addRow(button3);
        keyboard.addRow(button4);
        keyboard.addRow(button2);
        keyboard.addRow(buttonGlossary);

        message.replyMarkup(keyboard);
        telegramBot.execute(message);
    }

    /**
     * Отображает меню глоссария с кнопками выбора разделов.
     *
     * @param chatId идентификатор чата.
     */
    public void glossaryMenu(Long chatId) {
        SendMessage message = new SendMessage(chatId, "Данный раздел поможет тебе ответить на твои вопросы");

        InlineKeyboardButton button1 = new InlineKeyboardButton("Разновидности программ");
        button1.callbackData(VARIANTS_PROGRAM);

        InlineKeyboardButton button2 = new InlineKeyboardButton("Общие термины");
        button2.callbackData(GENERAL_TERMINS);

        InlineKeyboardButton button3 = new InlineKeyboardButton("Разновидности упражнений");
        button3.callbackData(VARIANTS_EXERCISE);

        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        keyboard.addRow(button1);
        keyboard.addRow(button3);
        keyboard.addRow(button2);

        message.replyMarkup(keyboard);
        telegramBot.execute(message);
    }

    /**
     * Отображает список упражнений с пагинацией.
     *
     * @param chatId идентификатор чата.
     */
    public void glossaryExercisePagination(Long chatId) {
        String messageText = "Упражнения идут в алфавитном порядке" + "\n"
                + telegramGlossaryService.getList().get(currentPage);

        InlineKeyboardButton rightButton = new InlineKeyboardButton("Вперед");
        rightButton.callbackData(RIGHT_BUTTON);

        InlineKeyboardButton leftButton = new InlineKeyboardButton("Назад");
        leftButton.callbackData(LEFT_BUTTON);

        InlineKeyboardButton page = new InlineKeyboardButton(String.valueOf(currentPage + 1));
        page.callbackData(PAGE_BUTTON);

        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        keyboard.addRow(leftButton, page, rightButton);

        if (messageId != 0) {
            EditMessageText editMessageText = new EditMessageText(chatId, messageId, messageText);
            editMessageText.replyMarkup(keyboard);
            telegramBot.execute(editMessageText);
        } else {
            SendMessage message = new SendMessage(chatId, messageText);
            message.replyMarkup(keyboard);
            SendResponse sendResponse = telegramBot.execute(message);
            messageId = sendResponse.message().messageId();
        }
    }

    /**
     * Увеличивает текущую страницу пагинации.
     */
    public void incrementCurrentPage() {
        currentPage++;
    }

    /**
     * Уменьшает текущую страницу пагинации.
     */
    public void decrementCurrentPage() {
        currentPage--;
        if (currentPage < 0) {
            currentPage = 0;
        }
    }
}

