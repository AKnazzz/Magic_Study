package org.workwork.c_java_core_one.homework_c7.work_1;

public class Command {
    private Action action;
    private String data;

    public Action getAction() {
        return action;
    }

    public String getData() {
        return data;
    }

    public Command(Action action) {
        this.action = action;
    }

    public Command(Action action, String data) {
        this.action = action;
        this.data = data;
    }
}
