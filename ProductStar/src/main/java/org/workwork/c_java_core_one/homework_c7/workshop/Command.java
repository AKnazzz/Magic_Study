package org.workwork.c_java_core_one.homework_c7.workshop;

import lombok.Getter;

public class Command {

    @Getter
    private Action action;

    @Getter
    private String data;

    public Command(Action action, String data) {
        this.action = action;
        this.data = data;
    }

    public Command(Action action) {
        this.action = action;
    }
}