package org.workwork.d_java_core_two.work_1_adapter.work_7d;

public class Command {

    private final Action action;
    private String data;
    private String content;

    public Command(Action action) {
        this.action = action;
    }

    public Command(Action action, String data) {
        this.action = action;
        this.data = data;
    }

    public Command(Action action, String data, String content) {
        this.action = action;
        this.data = data;
        this.content = content;
    }

    public Action getAction() {
        return action;
    }

    public String getData() {
        return data;
    }

    public String getContent() {
        return content;
    }
}
