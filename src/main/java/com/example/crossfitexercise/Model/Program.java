package com.example.crossfitexercise.Model;

import org.springframework.stereotype.Service;

@Service
public class Program {
    String p1 = "1. SUSAN (СЬЮЗАН)\n" +
            "\n" +
            "Выполнить 5 раундов на время: \n" +
            "- бег 200 метров \n" +
            "- 10 отжиманий от пола \n" +
            "- 10 воздушных приседаний\n" +
            "\n" +
            "Кроссфит комплекс для самых начинающих атлетов. \n" +
            "\n" +
            "Все что вам понадобится - это четко выверенная дистанция 200 метров для бега, возможность отжиматься и приседать. \n" +
            "Задача на первый взгляд крайне простая, но если бежать действительно быстро, то пульс будет крайне высоким," +
            " ведь это в общей сумме 1000 метров бега, а это одна из самых сложных дистанций в легкой атлетике.";

    public String getP1() {
        return p1;
    }
}
