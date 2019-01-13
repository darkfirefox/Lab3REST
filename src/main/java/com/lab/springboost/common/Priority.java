package com.lab.springboost.common;

import java.util.ArrayList;
import java.util.List;

public class Priority {
    public static List<String> getPriorities() {
        List<String> priorities = new ArrayList<>();
        priorities.add("Нормальный");
        priorities.add("Срочный");
        priorities.add("Немедленный");
        return  priorities;
    }
}
