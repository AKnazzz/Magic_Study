package org.workwork.c_java_core_one.homework_c7.work_2;

public class Command {
    private Action action;
    private String data;

    public Command(Action action) {
        this.action = action;
    }

    public Command(Action action, String data) {
        this.action = action;
        this.data = data;
    }

    public Action getAction() {
        return action;
    }

    public String getData() {
        return data;
    }
}
