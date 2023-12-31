package com.example.crossfitexercise.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Service
public class TelegramProgramService {
    private final Logger logger = LoggerFactory.getLogger(TelegramProgramService.class);

    public TelegramProgramService(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    private final TelegramBot telegramBot;

    private final  ArrayList<String> programForPro = new ArrayList<>(Arrays.asList("1. SUSAN (СЬЮЗАН)\n" +
                    "\n" +
                    "Выполнить 5 раундов на время: \n" +
                    "- бег 200 метров \n" +
                    "- 10 отжиманий от пола \n" +
                    "- 10 воздушных приседаний\n" +
                    "\n" +
                    "Кроссфит комплекс для самых начинающих атлетов. \n" +
                    "Все что вам понадобится - это четко выверенная дистанция 200 метров для бега, возможность отжиматься и приседать. \n" +
                    "Задача на первый взгляд крайне простая, но если бежать действительно быстро, то пульс будет крайне высоким, " +
                    "ведь это в общей сумме 1000 метров бега, а это одна из самых сложных дистанций в легкой атлетике."
            ,
            "АНДЕРСОН (ANDERSON)\n" +
                    "ЗКМБР - 20 МИНУТ (AMRAP): \n" +
                    "- 5 бурпи \n" +
                    "- 10 отжимания от пола \n" +
                    "- 15 ситапы \n" +
                    "- 20 воздушные приседания\n" +
                    "\n" +
                    "Долгая работа с весом собственного тела, данный комплекс покажет насколько долго вы сможете" +
                    " поддерживать интенсивность задания! Настоящая проверка на ментальную устойчивость!"
            ,"Джеки (Jackie)\n" +
                    "Нужно как можно быстрее выполнить следующие упражнения:\n" +
                    "\n" +
                    "1 000 метров на гребном тренажёре;\n" +
                    "50 выбросов штанги с весом 20/15 килограммов (здесь и далее первое значение — для мужчин, второе — для женщин);\n" +
                    "30 подтягиваний.\n" +
                    "Хорошо, если у вас получится уложиться в 11–15 минут, и просто супер, если в 8–11 минут." +
                    " Продвинутые и элитные атлеты выполняют этот комплекс за 6,5–8 минут."
            ,"Фрэн (Fran)\n" +
                    "Это, наверное, самый популярный комплекс в кроссфите. Нужно выполнить за максимально короткое время:\n" +
                    "\n" +
                    "21 выброс штанги весом 42,5/30 килограммов;\n" +
                    "21 подтягивание;\n" +
                    "15 выбросов штанги;\n" +
                    "15 подтягиваний;\n" +
                    "9 выбросов штанги;\n" +
                    "9 подтягиваний.\n" +
                    "Соревнующиеся атлеты выполняют комплекс меньше чем за две минуты."
            ,"Хелен (Helen)\n" +
                    "Выполните три раунда на время:\n" +
                    "\n" +
                    "400 метров бега;\n" +
                    "21 мах гирей весом 32/16 килограммов;\n" +
                    "12 подтягиваний.\n" +
                    "Если у вас получится выполнить три круга за 12–15 минут — вы хорошо подготовлены, " +
                    "если потребуется меньше 8 минут — пора готовиться к соревнованиям."
            ,"Диана (Diane)\n" +
                    "Комплекс нужно выполнить за минимальное время:\n" +
                    "\n" +
                    "21 становая тяга с весом 100/70 килограммов;\n" +
                    "21 отжимание в стойке на руках;\n" +
                    "15 становых тяг;\n" +
                    "15 отжиманий в стойке на руках;\n" +
                    "9 становых тяг;\n" +
                    "9 отжиманий в стойке на руках.\n" +
                    "Если вы выполнили комплекс за 7–10 минут, у вас отличная подготовка. " +
                    "Продвинутые атлеты выполняют его за 4–7 минут, элитные — за 2,5 минуты."
            ,"Барбара (Barbara)\n" +
                    "Нужно как можно быстрее выполнить пять кругов из следующих упражнений:\n" +
                    "\n" +
                    "20 подтягиваний;\n" +
                    "30 отжиманий;\n" +
                    "40 подъёмов корпуса;\n" +
                    "50 приседаний.\n" +
                    "Между кругами вы отдыхаете по 3 минуты.\n" +
                    "\n" +
                    "Если получится закончить за 25–26 минут, у вас впечатляющая подготовка, " +
                    "23–25 минут — вы можете побороться на соревнованиях," +
                    " менее 23 минут — вы наверняка давно занимаетесь кроссфитом или служите в спецназе."
            ,"Линда (Linda)\n" +
                    "Этот комплекс также известен как «три штанги смерти» и включает в себя три упражнения:\n" +
                    "\n" +
                    "становую тягу с весом, в полтора раза превышающим вес вашего тела (1,5 × ваш вес);\n" +
                    "жим лёжа с весом вашего тела;\n" +
                    "взятие на грудь штанги с 0,75 от своего веса.\n" +
                    "Эти упражнения выполняются друг за другом," +
                    " количество повторений такое: 10, 9, 8, 7, 6, 5, 4, 3, 2, 1." +
                    " То есть сначала вы выполняете всё по 10 раз, затем всё по 9 и так до одного." +
                    "Если вы справились за 15–17 минут, можете себя поздравить — у вас отличная подготовка. " +
                    "Продвинутые атлеты могут закончить комплекс за 12–15 минут, элитные — меньше чем за 12 минут."
            ,"Грейс (Grace)\n" +
                    "В этом комплексе нет особого разнообразия движений, но от этого он не становится более лёгким. Вам нужно на время выполнить 30 толчков штанги. Мужчины делают упражнение со штангой весом 60 килограммов, женщины — 42,5 килограмма.\n" +
                    "\n" +
                    "Если вы можете закончить за 5,5–8 минут, ваша подготовка впечатляет." +
                    " Продвинутые атлеты выполняют комплекс за 2,5–5,5 минуты, " +
                    "элитные кроссфитеры могут закончить и раньше 2 минут"
            ,"Элизабет (Elizabet)\n" +
                    "В этом комплексе вам нужно сделать три круга (21, 15 и 9 повторений) следующих упражнений:\n" +
                    "\n" +
                    "взятие на грудь штанги с весом 60/42,5 килограмма;\n" +
                    "отжимание на кольцах.\n" +
                    "Хороший результат — 7–10 минут, отличный — 3–7 минут, заоблачный — менее 3 минут."
            ,"Аманда (Amanda)\n" +
                    "Как можно быстрее нужно выполнить три круга (9, 7 и 5 повторений) следующих упражнений:\n" +
                    "\n" +
                    "строгие выходы на кольцах (если не получаются строгие, можно кипингом);\n" +
                    "рывок штанги весом 60/42,5 килограмма.\n" +
                    "Хорошо, если вы закончите за 5,5–10 минут. Средний результат для продвинутых атлетов — 3,5–5,5 " +
                    "минуты, а самые крутые кроссфитеры заканчивают «Аманду» меньше чем за 3 минуты."
            ,"Кинг Конг (King Kong)\n" +
                    "Вам нужно сделать три круга следующих упражнений:\n" +
                    "\n" +
                    "1 становая тяга с весом 205/145 килограммов;\n" +
                    "2 выхода силой на кольцах;\n" +
                    "3 взятия на грудь в приседании со штангой 112,5/77,5 килограмма;\n" +
                    "4 отжимания в стойке на руках."
            ,"" ));

    /**
     * listProgramForBeginners-содержит программы тренеровок для новичков
     */
    private final ArrayList<String> listProgramForBeginners = new ArrayList<>(Arrays.asList("\"АНДЕРСОН (ANDERSON)\\n\" +\n" +
                    "                \"ЗКМБР - 20 МИНУТ (AMRAP): \\n\" +\n" +
                    "                \"- 5 бурпи \\n\" +\n" +
                    "                \"- 10 отжимания от пола \\n\" +\n" +
                    "                \"- 15 ситапы \\n\" +\n" +
                    "                \"- 20 воздушные приседания\\n\" +\n" +
                    "                \"\\n\" +\n" +
                    "                \"Долгая работа с весом собственного тела, данный комплекс покажет насколько долго вы сможете\" +\n" +
                    "                \" поддерживать интенсивность задания! Настоящая проверка на ментальную устойчивость!",

            "Подтягивания плечами в висе на турнике 10 движений\n" +
                    "Ротационные подтягивания 6 движений\n" +
                    "Строгие подтягивания 4 повторения\n" +
                    "Приведение руки внутрь с резиной по 10 повторений на каждую руку\n" +
                    "Отжимания от возвышенности 10 повторений\n" +
                    "Медленные приседания 5 повторений\n" +
                    "Переходы в стороны широком выпаде"));


    /**
     * listWithoutImplements-содержит программы тренеровок без инструмента с собственным весом
     */
    private final ArrayList<String> listWithoutImplements = new ArrayList<>(Arrays.asList(
            "WOD 1\n" +
                    "5 раундов на время:\n" +
                    "\n" +
                    "10 отжиманий от пола\n" +
                    "20 выпадов\n" +
                    "10 подтягиваний\n" +
                    "20 выпадов\n" +
                    "10 отжиманий на брусьях\n" +
                    "* Запомни время, за которое ты выполнил данный комплекс. Повтори комплекс через две недели, затем сравни время.",
            "WOD 2\n" +
                    "50-40-30-20-10\n" +
                    "\n" +
                    "Воздушные приседания\n" +
                    "Двойные прыжки\n" +
                    "* Этот комплекс рассчитан на то, чтобы хорошенько нагрузить ноги. Не хватило нагрузки? Повтори лесенку в обратном порядке!",
            "WOD 3\n" +
                    "3 раунда на время\n" +
                    "\n" +
                    "400 м бег\n" +
                    "21 берпи\n" +
                    "* Берпи – «любимое» упражнение кроссфитера, которое включит в работу все мышцы твоего тела!",
            "\n" +
                    "WOD 4\n" +
                    "Выполнить за 20 минут как можно больше раундов:\n" +
                    "\n" +
                    "10 подтягиваний\n" +
                    "10 отжиманий на брусьях\n" +
                    "10 пистолетов\n" +
                    "* Старайтесь отдыхать как можно меньше между подходами. Выкладывайся на все 100!",
            "WOD 5\n" +
                    "EMOM 12 минут\n" +
                    "\n" +
                    "А. спринт 30м\n" +
                    "В. 12 носков к перекладине\n" +
                    "* Чередуйте упражнения от минуты к минуте.",
            "\n" +
                    "WOD 6\n" +
                    "5 раундов\n" +
                    "\n" +
                    "400м бег\n" +
                    "15 отжиманий\n" +
                    "15 ситапов\n" +
                    "* Ситапы - это самый простой способ укрепить и подтянуть мышцы живота (пресс)",
            "WOD 7\n" +
                    "7 раундов на время\n" +
                    "\n" +
                    "7 подтягиваний обратным хватом\n" +
                    "7 отжиманий в стойке на руках\n" +
                    "* Если не получается стойка на руках, начните с упрощенного варианта – отжимания вниз головой с ногами на возвышении\n" +
                    "\n",
            "WOD 8\n" +
                    "\n" +
                    "1600м бег\n" +
                    "50 берпи\n" +
                    "800м бег\n" +
                    "* Этот комплекс заставить биться твое сердце быстрее!",
            "WOD 9\n" +
                    "5 раундов на время\n" +
                    "\n" +
                    "15 приседаний с выпрыгиванием вверх\n" +
                    "15 v-складок\n" +
                    "* Приседания с выпрыгиванием вверх задействуют квадрицепсы, ягодичные, икры, и дополнительно пресс и поясничный отдел",
            "WOD 10\n" +
                    "\n" +
                    "1-2-3-4-5-6-7-8-9-10 подтягивания\n" +
                    "10-20-30-40-50-60-70-80-90-100 одиночные прыжки на скакалке\n" +
                    "* Надоели одиночные прыжки на скакалке? Начни прыгать двойные или тройные!",
            "WOD 11\n" +
                    "5 раундов на время\n" +
                    "\n" +
                    "20 отжиманий хлопком\n" +
                    "100м спринт\n" +
                    "После каждого раунда отдых 2 минуты.\n" +
                    "\n" +
                    "* Главный совет для этого комплекса – включайся на максимум! Эта связка отжиманий и бега прицельно развивает взрывную силу",
            "WOD 12\n" +
                    "\n" +
                    "400 м бег\n" +
                    "25 берпи\n" +
                    "300 м бег\n" +
                    "20 подтягиваний\n" +
                    "200 м бег\n" +
                    "15 носков к перекладине\n" +
                    "100 м бег\n" +
                    "10 отжиманий в стойке на руках\n" +
                    "* Зафиксируй время, за которое ты выполнил комплекс",
            "WOD 13\n" +
                    "Табата в течение 8 минут\n" +
                    "\n" +
                    "0:20 берпи\n" +
                    "0:10 отдых\n" +
                    "0:20 обратные берпи\n" +
                    "0:10 отдых\n" +
                    "* Поработав в таком темпе, вы включите в работу практически все мышечные волокна.",
            "WOD 14\n" +
                    "4 раунда на время\n" +
                    "\n" +
                    "15 носков к перекладине\n" +
                    "20 перепрыгиваний через скамью или бокс\n" +
                    "\n" +
                    "* Во время выполнения прыжков на ящик включаются практически все мышцы тела",
            "WOD 15\n" +
                    "Закончить как можно больше раундов за 15 минут:\n" +
                    "\n" +
                    "10 подтягиваний до груди\n" +
                    "30м медвежья походка\n" +
                    "10 отжиманий на брусьях\n" +
                    "30м медвежья походка\n" +
                    "* Межвежья походка - упражнение, которое значительно укрепит ваши отводящие мышцы бедра, руки и пресс\n" +
                    "\n",
            "WOD 16\n" +
                    "На время:\n" +
                    "\n" +
                    "50 двойных прыжков на скакалке\n" +
                    "50 выпадов\n" +
                    "50 отжиманий\n" +
                    "50 ситапов\n" +
                    "50 двойных прыжков на скакалке\n" +
                    "* Пока не получаются двойные прыжки на скакалке? Замени на одиночные, однако умножь количество повторений на 2",
            "WOD 17\n" +
                    "\n" +
                    "2000 м бег\n" +
                    "В начале каждой минуты бега выполнять 5 отжиманий.",
            "WOD 18\n" +
                    "\n" +
                    "Выполнить 100 берпи как можно быстрее\n" +
                    "* Каждая остановка штраф 10 приседаний",
            "WOD 19\n" +
                    "3 раунда на время:\n" +
                    "\n" +
                    "5 берпи\n" +
                    "10 приседаний\n" +
                    "15 ситапов\n" +
                    "400м бег\n" +
                    "* Старайтесь меньше времени отдыхать между подходами",
            "WOD 20\n" +
                    "Выполнить как можно больше раундов за 20 минут:\n" +
                    "\n" +
                    "1 подтягивание;\n" +
                    "2 отжимания;\n" +
                    "3 приседания;\n" +
                    "4 подтягивания;\n" +
                    "5 отжиманий;\n" +
                    "6 приседаний;\n" +
                    "7 подтягиваний;\n" +
                    "8 отжиманий;\n" +
                    "9 приседаний и т.д.\n" +
                    "* Запиши количество выполненный раундов"));



    /**

     Генерирует случайную программу без оборудования и отправляет её в виде сообщения по указанному идентификатору чата.

     @param chatId идентификатор чата, куда будет отправленная программа
     */
    public void getRandomWithoutImplements(Long chatId) {
        Random random1 = new Random();

        int randomIndex1 = random1.nextInt(listWithoutImplements.size());

        String randomElement1 = listWithoutImplements.get(randomIndex1);

        telegramBot.execute(new SendMessage(chatId, randomElement1));
    }
    /**

     Генерирует случайную программу для начинающих и отправляет её в виде сообщения по указанному идентификатору чата.

     @param chatId идентификатор чата, куда будет отправленная программа
     */
    public void getRandomProgramForBeginners(Long chatId) {
        Random random = new Random();

// Получаем случайный индекс из ArrayList listProgramForBeginners
        int randomIndex = random.nextInt(listProgramForBeginners.size());

// Получаем случайный элемент из ArrayList listProgramForBeginners
        String randomElement = listProgramForBeginners.get(randomIndex);

// Отправляем случайную программу в виде сообщения, используя telegramBot
        telegramBot.execute(new SendMessage(chatId, randomElement));
    }

    public void getRandomProgramForPro(Long chatId) {

        Random random = new Random();

        int randomIndex1 = random.nextInt(programForPro.size());

        String randomElement1 = programForPro.get(randomIndex1);
        telegramBot.execute(new SendMessage(chatId, randomElement1));

    }


}
