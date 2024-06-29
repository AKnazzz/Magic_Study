package org.workwork.d_java_core_two.homeWork_d1.work_1d;

public class Command {
    private Action action;
    private String data;

    public void setAction(Action action) {
        this.action = action;
    }

    public void setData(Faile.Files data) {

        this.data = String.valueOf(data);
    }

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
