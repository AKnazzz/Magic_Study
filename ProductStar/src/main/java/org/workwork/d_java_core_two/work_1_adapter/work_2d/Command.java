package org.workwork.d_java_core_two.work_1_adapter.work_2d;

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
        if (data == null) {
            return "нет данных";
        }
        return data;
    }
}