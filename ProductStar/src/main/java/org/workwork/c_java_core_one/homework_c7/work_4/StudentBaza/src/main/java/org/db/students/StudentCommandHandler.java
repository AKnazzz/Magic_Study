package org.db.students;

import java.util.Map;

// Класс StudentCommandHandler отвечает за обработку команд, связанных с управлением студентами.
public class StudentCommandHandler {

    // Экземпляр класса StudentStorage для управления данными студентов
    private StudentStorage studentStorage = new StudentStorage();

    // Метод для обработки входящей команды и выполнения соответствующего действия
    public void processCommand(Command command) {

        // Получение действия, связанного с данной командой
        Action action = command.getAction();
        switch (action) {
            case CREATE -> {
                processCreateCommand(command);
                break;
            }
            case UPDATE -> {
                processUpdateCommand(command);
                break;
            }
            case DELETE -> {
                processDeleteCommand(command);
                break;
            }
            case STATS_BY_COURSE -> {
                processStatsByCourseCommand(command);
                break;
            }
            case SHOW_ALL -> {
                processShowAllStudents(command);
                break;
            }
            case SEARCH -> {
                processSearchCommand(command);
                break;
            }
            case STATS_BY_CITIES -> {
                processStatsByCitiesCommand(command);
                break;
            }
            default -> System.out.println("Действие " + action + " не поддерживается.");
        }

        // Вывод информации о выполненной команде на экран
        System.out.println("Обработка команды. Действие: "
                + command.getAction().name()
                + ", данные: " + command.getData());
    }

    // Метод для обработки команды, выводящей всех студентов на экран
    private void processShowAllStudents(Command command) {
        studentStorage.printAll();
    }

    // Метод для обработки команды, выводящей статистику студентов по курсам
    private void processStatsByCourseCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCourse();
        studentStorage.printMap(data);
    }

    // Метод для обработки команды, создающей нового студента
    private void processCreateCommand(Command command) {
        String data = command.getData().trim();
        String[] dataArray = data.split(",");

        // Проверяем корректность введенных данных по числу запятых
        int commaCount = data.split(",").length - 1;
        if (commaCount < 4) {
            System.out.println("Данные введены не полностью. Данные не добавлены, повторите ввод");
            return;
        }

        Student student = new Student();

        if (dataArray[0].length() < 3) {
            System.out.println("Ошибка: Не указана фамилия. Данные не добавлены, повторите ввод");
            return;
        } else {
            student.setSurname(dataArray[0]);
        }

        if (dataArray[1].length() < 3) {
            System.out.println("Ошибка: Не указано имя. Данные не добавлены, повторите ввод");
            return;
        } else {
            student.setName(dataArray[1]);
        }

        if (dataArray[2].length() < 3) {
            System.out.println("Ошибка: Название курса не может быть пустым. Данные не добавлены, повторите ввод");
            return;
        } else {
            student.setCourse(dataArray[2].trim());
        }

        if (dataArray[3].length() < 3) {
            System.out.println("Ошибка: Введите корректный город. Данные не добавлены, повторите ввод");
            return;
        } else {
            student.setCity(dataArray[3].trim());
        }

        // Проверка, что возраст является числом
        try {
            int age = Integer.parseInt(dataArray[4].trim());
            student.setAge(age);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Возраст должен быть целым числом. Данные не добавлены, повторите ввод");
            return;
        }

        studentStorage.createStudent(student);
        studentStorage.printAll();
    }

    // Метод для обработки команды, обновляющей информацию о студенте
    public void processUpdateCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");
        Long id = Long.valueOf(dataArray[0]);

        int commaCount = data.split(",").length - 1;
        if (commaCount < 4) {
            System.out.println("Ошибка: Данные введены не полностью. Данные не добавлены, повторите ввод");
            return;
        }

        Student student = new Student();

        if (dataArray[1].length() < 3) {
            System.out.println("Ошибка: Не указана фамилия. Данные не добавлены, повторите ввод");
            return;
        } else {
            student.setSurname(dataArray[1]);
        }

        if (dataArray[2].length() < 3) {
            System.out.println("Ошибка: Не указано имя. Данные не добавлены, повторите ввод");
            return;
        } else {
            student.setName(dataArray[2]);
        }

        if (dataArray[3].length() < 3) {
            System.out.println("Ошибка: Название курса не может быть пустым. Данные не добавлены, повторите ввод");
            return;
        } else {
            student.setCourse(dataArray[3].trim());
        }

        if (dataArray[4].length() < 3) {
            System.out.println("Ошибка: Введите корректный город. Данные не добавлены, повторите ввод");
            return;
        } else {
            student.setCity(dataArray[4].trim());
        }

        // Проверка, что возраст является числом
        try {
            int age = Integer.parseInt(dataArray[5].trim());
            student.setAge(age);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Возраст должен быть целым числом. Данные не добавлены, повторите ввод");
            return;
        }

        studentStorage.updateStudent(id, student);
        studentStorage.printAll();
    }

    // Метод для обработки команды, удаляющей студента
    public void processDeleteCommand(Command command) {
        String data = command.getData();
        Long id = Long.valueOf(data);
        studentStorage.deleteStudent(id);
    }

    // Метод для обработки команды, ищущей студентов по фамилии
    public void processSearchCommand(Command command) {
        String data = command.getData().trim();
        if (data.isEmpty()) {
            System.out.println("Выведен полный список студентов:");
            studentStorage.printAll();
        } else if (data.contains(",")) {
            String[] surnames = data.split(",");
            if (surnames.length == 2) {
                System.out.println("Вывод студентов в диапазоне фамилий: " + surnames[0].trim() + " - " + surnames[1].trim());
                studentStorage.searchInRange(surnames[0].trim(), surnames[1].trim());
            } else {
                System.out.println("Ошибка: Введите либо одну фамилию, либо две фамилии, разделенные запятой.");
            }
        } else {
            System.out.println("Поиск студентов с фамилией: " + data);
            studentStorage.searchExact(data);
        }
    }

    // Метод для обработки команды, выводящей статистику студентов по городам
    private void processStatsByCitiesCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCity();
        studentStorage.printMap(data);
    }
}
