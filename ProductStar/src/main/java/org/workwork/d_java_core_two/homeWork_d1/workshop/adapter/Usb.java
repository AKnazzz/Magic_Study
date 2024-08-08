package org.workwork.d_java_core_two.homeWork_d1.workshop.adapter;

public interface Usb {
    void connectWithUsbCable();
}

class MemoryCard {

    public void insert() {
        System.out.println("Карта памяти успешно вставлена.");
    }

    public void copyData() {
        System.out.println("Данные скопированы на компьютер.");
    }

}

class CartReader implements Usb {

    // адаптируемый класс (карта памяти) становится одним из полей адаптера
    private MemoryCard memoryCard;

    public CartReader(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void connectWithUsbCable() {
        this.memoryCard.insert();
        this.memoryCard.copyData();
    }
}


class User {
    public static void main(String[] args) {

        Usb cardReader = new CartReader(new MemoryCard());
        cardReader.connectWithUsbCable();

    }
}

