package org.workwork.c_java_core_one.homework_c7.workshop;

import java.util.Map;

public class StudentCommandHandler {

    private StudentStorage studentStorage = new StudentStorage();

    public void processCommand(Command command) {
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
            case STATS_BY_COURSES -> {
                processStatsByCourseCommand(command);
                break;
            }
            case STATS_BY_CITY -> {
                processStatsByCityCommand(command);
                break;
            }
            case SEARCH -> {
                processSearchCommand(command);
                break;
            }
            default -> {
                System.out.println("Действие " + action + " не поддерживается.");
            }
        }
        System.out.println("Обработка команды. Действие: " + command.getAction().name() + " ,данные: " + command.getData());
    }


    private void processCreateCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");

        if (dataArray.length != 5) {
            System.out.println("Некорректные данные. Ожидается [Фамилия,Имя,Курс,Город,Возраст]");
            return;
        }
        try {
            Student student = new Student();
            student.setSurname(dataArray[0]);
            student.setName(dataArray[1]);
            student.setCourse(dataArray[2]);
            student.setCity(dataArray[3]);
            student.setAge(Integer.valueOf(dataArray[4]));

            studentStorage.createStudent(student);
            studentStorage.printAll();
        } catch (Exception e) {
            System.out.println("Ошибка обработки данных. Убедитесь, что возраст - это число.");
        }
    }

    private void processUpdateCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");
        if (dataArray.length != 6) {
            System.out.println("Некорректные данные. Ожидается [ID,Фамилия,Имя,Курс,Город,Возраст]");
            return;
        }

        try {
            Long id = Long.valueOf(dataArray[0]);
            Student student = new Student();
            student.setSurname(dataArray[1]);
            student.setName(dataArray[2]);
            student.setCourse(dataArray[3]);
            student.setCity(dataArray[4]);
            student.setAge(Integer.valueOf(dataArray[5]));

            studentStorage.updateStudent(id, student);
            studentStorage.printAll();
        } catch (Exception e) {
            System.out.println("Ошибка обработки данных. Убедитесь, что ID и возраст - это числа.");
        }
    }

    private void processDeleteCommand(Command command) {
        String data = command.getData();
        try {
            Long id = Long.valueOf(data);
            studentStorage.deleteStudent(id);

            studentStorage.printAll();
        } catch (Exception e) {
            System.out.println("Ошибка обработки данных. Убедитесь, что ID - это число.");
        }
    }

    private void processStatsByCourseCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCourse();
        studentStorage.printMap(data);
    }

    private void processStatsByCityCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCity();
        studentStorage.printMap(data);
    }

    private void processSearchCommand(Command command) {
        String surname = command.getData();
        studentStorage.search(surname);
    }

}