package org.ya.module_7.stream_apt.task_client;

public class Phone {
    Long number;
    PhoneType type;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public Phone(Long number, PhoneType type) {
        this.number = number;
        this.type = type;
    }
}