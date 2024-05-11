package org.ya.module_7.stream_apt.task_client;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Необходимо создать класс клиента со следующими полями: уникальный идентификатор, имя, возраст.
 * Также у клиента есть список телефонов. Класс телефона содержит само значение и тип (стационарный или мобильный).
 * <p>
 * Найти самого возрастного клиента, которой пользуется стационарным телефоном
 */
public class TestClient {
    public static void main(String[] args) {

        Phone phone1 = new Phone(84951111111L, PhoneType.STATIONARY);
        Phone phone2 = new Phone(84952222222L, PhoneType.STATIONARY);
        Phone phone3 = new Phone(84953333333L, PhoneType.STATIONARY);
        Phone phone4 = new Phone(84954444444L, PhoneType.STATIONARY);
        Phone phone5 = new Phone(89161111111L, PhoneType.MOBIL);
        Phone phone6 = new Phone(89162222222L, PhoneType.MOBIL);
        Phone phone7 = new Phone(89163333333L, PhoneType.MOBIL);
        Phone phone8 = new Phone(89164444444L, PhoneType.MOBIL);

        Client client1 = new Client(1, "Иван", 25, List.of(phone1));
        Client client2 = new Client(2, "Олег", 35, List.of(phone2));
        Client client3 = new Client(3, "Мария", 45, List.of(phone7));
        Client client4 = new Client(1, "Лев", 70, List.of(phone8));

        List<Client> clients = Arrays.asList(client1, client2, client3, client4);

        Optional<Client> old = clients.stream()
                .filter(a -> a.getPhones().stream().anyMatch(b -> b.getType() == PhoneType.STATIONARY))
                .min((c, d) -> d.getAge() - c.getAge());

        System.out.println(old.get().getName());

        int a = 0;
        for (int i = 0; i < 101; i++) {
            a = a + i;
        }

    }
}
