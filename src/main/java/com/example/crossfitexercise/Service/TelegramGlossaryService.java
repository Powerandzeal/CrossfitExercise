package com.example.crossfitexercise.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TelegramGlossaryService {

   private final TelegramBot telegramBot;
    private final String program =
            "Разновидости программ:\n" +
                    "AMRAP  (as many Reps (sometimes Rounds) as possible/) - сделать как можно большее " +
                    "количество повторений/раундов за отведенный промежуток времени \n" +
                    "\n" +
                    "EMOM  (every minute on the minute) – выполнять движение каждую минуту\n" +
                    "\n" +
                    "*R4T  (rounds for time) – выполнить определенное количество раундов на время\n" +
                    "\n" +
                    "TABATA - это тренировка с интервалами 20 и 10 секунд. 20 секунд максимально интенсивной работы " +
                    "и 10 секунд отдыха, такие циклы повторяются 8 раз подряд и составляют в общей сумме 4 минуты"
            ;

    private final String commonTerms = "BW (Body weight) – вес тела\n" +
            "\n" +
            "CrossFit Total (consisting of max squat, press, and deadlift) – сумма троеборья: приседания, жим и становя тяга\n" +
            "\n" +
            "GPP (General physical preparedness) - общая физическая подготовка (ОФП) \n" +
            "\n" +
            "MetCon ( Metabolic Conditioning workout) - метаболическая тренировка\n" +
            "\n" +
            "PR (Personal record) -  личный рекорд\n" +
            "\n" +
            "Rep (Repetition) — повтор \n" +
            "\n" +
            "RM (Repetition maximum) — одноповторный максимум \n" +
            "\n" +
            "Rx’d (As prescribed) - комплекс выполнен без изменений\n" +
            "\n" +
            "Ubroken – непрерывно\n" +
            "\n" +
            "WOD (Workout of the day) - задание на день\n" +
            "\n" +
            "WU (Warm-up) – разминка";

    private final List<String> mainMotionsExercise = new ArrayList<>(Arrays.asList(
            "A\n" +
                    "\n" +
                    "Air Squat - воздушные приседания"
            ,"B\n" +
                    "\n" +
                    "\n" +
                    "Back/Hip Extension – гиперэкстензия\n" +
                    "\n" +
                    "Box Jumps (BJ) – взапрыгивания на тумбу\n" +
                    "Burpees – берпи \n" +
                    "\n" +
                    "Ball Slams - удар мячом об пол \n" +
                    "Bench press (BP) - жим лежа \n" +
                    "Back squat (BS) - приседания со штангой на плечах  "
            ,"C\n" +
                    "\n" +
                    "Clean (CLN) - взятие на грудь \n" +
                    "Clean & Jerk (C&J) - взятие на грудь и толчок"
            ,"D\n" +
                    " \n" +
                    "\n" +
                    "Dumbell Snatch - рывок гири\n" +
                    "\n" +
                    "Dip - отжимания на брусьях \n" +
                    "Double-Unders - двойные прыжки со скакалкой \n" +
                    "Deadlift (DL) - становая тяга"
            ,"F\n" +
                    "\n" +
                    "Front Squat (FS) - приседания со штангой на груди  \n" +
                    "From Shoulder to overhead (FS2OH) - с позиции на плечах до позиции над головой, " +
                    "допускается любым способом: швунг жимой, швунг толчковый, жим"
            ,"H\n" +
                    "\n" +
                    "Handstand Push-up (HSPU) - отжимания в стойке на руках (вниз головой) \n" +
                    "Hang Power Clean (HPC) - взятие на грудь с виса \n" +
                    "Hang Power Snatch (HPS) - рывок с виса \n" +
                    "Hollow Rock - качели (одновременное поднятие рук и ног в положении лежа и раскачивание"
            ,"J\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "Jerk - толчок "
            ,"K\n" +
                    "\n" +
                    "Kettlebell Swing - мах гири \n" +
                    "Knees to Elbows (K2E) - колени к локтям  "
            ,"M\n" +
                    "\n" +
                    "Medicine Ball Cleans - взятие на грудь с медицинским мячом \n" +
                    "Muscle-up (MU) - выход на кольцах/турник \n" +
                    "Military press - армейский жим  "
            ,"O\n" +
                    "\n" +
                    "Overhead Squat (OHS) - приседание со штангой над головой"
            ,"P\n" +
                    "\n" +
                    "Pistols – приседания на одной ноге\n" +
                    "\n" +
                    "Power Clean - силовое взятие на грудь \n" +
                    "Power Snatch - силовой рывок \n" +
                    "Push Jerk - швунг толчковый \n" +
                    "Push Press - швунг жимовой \n" +
                    "Pull-ups - подтягивания \n" +
                    "Push-ups - отжимания \n" +
                    "Pood (pd) - единица измерения веса, 1 пуд = 16кг  \n"
            ,"R\n" +
                    "\n" +
                    "Ring Dips - отжимания на кольцах \n" +
                    "Rope Climb - лазание по канату "
            ,"S\n" +
                    "\n" +
                    "Squat - приседания \n" +
                    "Snatch - рывок \n" +
                    "Sumo Dead Lift High Pull - становая тяга из стойки сумо с подъемом до уровня плеч \n" +
                    "Sit-up - упражнения на пресс  "
            ,"T\n" +
                    "\n" +
                    "Thruster - выброс \n" +
                    "Turkish get-up - турецкий подъем \n" +
                    "Toes to bar (T2B) - подьем носов к турнику"
            ,"W\n" +
                    "\n" +
                    "\n" +
                    "Walking Lunges - шагающие выпады \n" +
                    "Wall Ball - броски мяча в стену "
    ));

    public TelegramGlossaryService(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void getProgram (Long chatId){
        telegramBot.execute(new SendMessage(chatId,program));
    }
    public void getCommonTermines(Long chatId){
        telegramBot.execute(new SendMessage(chatId,commonTerms));
    }
}
