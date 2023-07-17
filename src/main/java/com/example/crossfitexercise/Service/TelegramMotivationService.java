package com.example.crossfitexercise.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
@Service
public class TelegramMotivationService {

    private final TelegramBot telegramBot;
    private final ArrayList<String> listMotivate = new ArrayList<>(Arrays.asList(

            "Определите, зачем вам это нужно К занятиям спортом и фитнесом вас может подтолкнуть не только стремление " +
                    "к высоким спортивным результатам, но и, например, желание получить подтянутую фигуру к отпуску " +
                    "на побережье, что, разумеется, прекрасная мотивация, но она закончится, как только вы вернётесь " +
                    "из путешествия. Постарайтесь найти причину для тренировок, которая будет актуальна круглый " +
                    "год, — в конце концов, красивое и сильное тело нужно человеку всегда. Кроме того, регулярная " +
                    "активность подарит вам хорошее самочувствие и позитивные эмоции.",
            "Создайте пространство\n" +
                    "Для тренировки нужно место. Небольшое пространство в доме или квартире, специально отведённое " +
                    "для физических упражнений, поможет вам настроиться и свести к минимуму отвлекающие факторы. " +
                    "Отдельная комната, подвал или даже просто перегородка в комнате подарят вам священное место " +
                    "для занятий йогой или сета бёрпи. Ах да, уберите телефон в другую комнату на время тренировки" +
                    " — сообщения от босса способны убить даже самую сильную мотивацию.",
            "Пользуйтесь мотивирующими установками\n" +
                    "Позитивные цитаты о тренировках будут напоминать вам о том, что заниматься на самом деле круто. " +
                    "Вы можете наклеивать их на зеркало в ванной, на рабочий компьютер или на холодильник, устанавливать" +
                    " фразы-напоминания на сообщение будильника. Пусть они заставляют вас двигаться к цели. ",
            "Положитесь на социальные сети\n" +
                    "Социальные сети — отличный инструмент, который помогает не сходить с пути к достижению результата." +
                    " Исследование подтверждает, что поддержка подписчиков, регулярные отчёты о выполненных тренировках " +
                    "и даже конкуренция в онлайн-сообществах помогают тренироваться ежедневно. Будьте смелее, заявляйте " +
                    "о себе и делитесь успехами.",
            "Планируйте Определите, какой вид тренировки вы будете делать, как долго и где. " +
                    "Затем потратьте 10 минут на планирование своего расписания до конца недели и следуйте этому " +
                    "распорядку. Ещё лучше — довериться тренеру, который составит тренировочный план за вас. " +
                    "Когда ваше расписание включает в себя обязательную физическую активность, вам будет гораздо" +
                    " сложнее её пропустить.",
            "Совместите занятия с чем-то ещё например, вы можете смотреть любимое телешоу в то время, как бежите на дорожке, крутите педали на" +
                    " велостанке или выполняете любимый комплекс упражнений на мышцы пресса. Ещё вариант: выберите " +
                    "подкаст, который хотели бы послушать, и делайте это только на тренировке. Так вы будете ждать " +
                    "следующего занятия с нетерпением.",
            "Присоединитесь к челленджу\n" +
                    "В Интернете то и дело кто-то объявляет очередной челлендж: блогеры мотивируют " +
                    "подписчиков стоять в планке, приседать или бегать каждый день, соцсети типа Strava " +
                    "подкидывают вам задачи на месяц. Не стесняйтесь, выбирайте то, что вам интересно, и " +
                    "присоединяйтесь.",
            "Найдите компанию\n" +
                    "Выйти на тренировку намного проще, когда вас ждёт друг, ведь вы не можете его подвести. " +
                    "Вместо посиделок в кафе отправьтесь на пробежку или покатайтесь на лыжах. Кроме того, " +
                    "исследования показывают, что рядом с товарищем по фитнесу люди, как правило, делают " +
                    "больше упражнений.",
            "Отдыхайте\n" +
                    "Ежедневные тренировки утомляют, приводят к усталости и перетренированности и, как следствие, " +
                    "к нежеланию заниматься. Оставьте себе хотя бы один день отдыха на неделе. " +
                    "Если вы чувствуете, что нагрузка слишком высока, сбавьте обороты.")
    );

    public TelegramMotivationService(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void getRandomMotivate(Long chatId) {
        Random random = new Random();

// Получаем случайный индекс из ArrayList listProgramForBeginners
        int randomIndex = random.nextInt(listMotivate.size());

// Получаем случайный элемент из ArrayList listProgramForBeginners
        String randomElement = listMotivate.get(randomIndex);

// Отправляем случайную программу в виде сообщения, используя telegramBot
        telegramBot.execute(new SendMessage(chatId, randomElement));
    }
}
