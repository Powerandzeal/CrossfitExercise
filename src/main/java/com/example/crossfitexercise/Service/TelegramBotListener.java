package com.example.crossfitexercise.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TelegramBotListener implements UpdatesListener {

    private final TelegramBot telegramBot;

    private final TelegramMotivationService telegramMotivationService;


    public static final String START = "/start";
    public static final String GET_PROGRAM_LEVEL_PRO = "Получить программу уровень pro";
    public static final String GET_MOTIVATION = "Получить совет";
    public static final String GET_GLOSSARY = "Открыть кроссфит глоссарий";
    public static final String GET_PROGRAM_LEVEL_BEGINNER = "Получить программу уровень beginner";
    public static final String GET_PROGRAM_WITHOUT_IMPLEMENTS = "Получить программу тренеровки без оборудования с собственным весом";
    public static final String PROGRAM_WITHOUT = "Тренеровка без экипы";


    private final Logger logger = LoggerFactory.getLogger(TelegramBotListener.class);



    private final TelegramBotService telegramBotService;
    private Long chatId;

    private final TelegramProgramService telegramProgramService;

    public TelegramBotListener(TelegramBot telegramBot, TelegramMotivationService telegramMotivationService, TelegramBotService telegramBotService, TelegramProgramService telegramProgramService) {
        this.telegramBot = telegramBot;
        this.telegramMotivationService = telegramMotivationService;
        this.telegramBotService = telegramBotService;
        this.telegramProgramService = telegramProgramService;
    }


    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }


//    @Override
//    public int process(List<Update> updates) {
//
//        try {
//            updates.forEach(update -> {
//
//
//                        logger.info("Processing update: {}", update);
//                        //тут две кнопки приют кошки или собаки если
//
//
//                        if (update.callbackQuery() != null && update.message() == null) {
//                            // обработка этапа 0
//
//                            chatId = update.callbackQuery().message().chat().id();
//                            CallbackQuery callbackQuery = update.callbackQuery();
//                            String data = callbackQuery.data();
//
//
//                            try {
//                                System.out.println(update.message().text());
//
//                            } catch (Exception e) {
//                                System.out.println("Ошибка");
//                            }
//
////                            System.out.println(update.message().text());
////                            System.out.println(data);
//                            switch (data) {
//
//                                case START -> telegramBotService.firstMenu(chatId);
//                                case GET_PROGRAM_LEVEL_PRO -> telegramProgramService.getRandomProgramForPro(chatId);
//                                case GET_PROGRAM_LEVEL_BEGINNER -> telegramProgramService.getRandomProgramForBeginners(chatId);
//                                case GET_PROGRAM_WITHOUT_IMPLEMENTS -> telegramProgramService.getRandomWithoutImplements(chatId);
//                                case GET_MOTIVATION -> telegramMotivationService.getRandomMotivate(chatId);
//                                case GET_GLOSSARY -> telegramProgramService.programAnderson(chatId);
//
//                            }
//
//                        }
//                        if (update.message() != null) {
//                            chatId = update.message().chat().id();
//                            String message = update.message().text();
//                            if (START.equals(message)) {
//                                telegramBotService.firstMenu(chatId);
//                            }
//
//                        }
//                    }
//            );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return UpdatesListener.CONFIRMED_UPDATES_ALL;
//    }
@Override
public int process(List<Update> updates) {
    try {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);

            if (update.callbackQuery() != null && update.message() == null) {
                chatId = update.callbackQuery().message().chat().id();
                CallbackQuery callbackQuery = update.callbackQuery();
                String data = callbackQuery.data();

                switch (data) {
                    case START:
                        telegramBotService.firstMenu(chatId);
                        break;
                    case GET_PROGRAM_LEVEL_PRO:
                        telegramProgramService.getRandomProgramForPro(chatId);
                        break;
                    case GET_PROGRAM_LEVEL_BEGINNER:
                        telegramProgramService.getRandomProgramForBeginners(chatId);
                        break;
//                    case GET_PROGRAM_WITHOUT_IMPLEMENTS:
//                        telegramProgramService.getRandomWithoutImplements(chatId);
//                        break;
                    case GET_MOTIVATION:
                        telegramMotivationService.getRandomMotivate(chatId);
                        break;
                    case GET_GLOSSARY:
                        telegramProgramService.programAnderson(chatId);
                        break;
                    case PROGRAM_WITHOUT:
                        telegramProgramService.getRandomWithoutImplements(chatId);

                }
            }

            if (update.message() != null) {
                chatId = update.message().chat().id();
                String message = update.message().text();
                if (START.equals(message)) {
                    telegramBotService.firstMenu(chatId);
                }
            }
        });
    } catch (Exception e) {
        e.printStackTrace();
    }
    return UpdatesListener.CONFIRMED_UPDATES_ALL;
}







}

