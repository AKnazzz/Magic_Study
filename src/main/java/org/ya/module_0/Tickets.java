package org.ya.module_0;

public class Tickets {

    public static void main(String[] args) {
        Bus bus = new Bus(23765);
        String[] passengersTimestamps = new String[]{
                "08:33",
                "09:42",
                "10:43",
                "17:59",
                "18:01",
                "19:15"
        };

        for (int i = 0; i < passengersTimestamps.length; i++) {
            increaseTicketNumber(bus);
            System.out.println("Оплата поездки в " + passengersTimestamps[i]
                    + ". Номер билета: " + bus.ticketNumber);
        }
    }

    private static void increaseTicketNumber(Bus bus) {
        // вставьте код для увеличения номера билета
        bus.ticketNumber++;
    }

}

class Bus {
    public Bus(int initialNumber) {
        ticketNumber = initialNumber;
    }

    int ticketNumber;
}