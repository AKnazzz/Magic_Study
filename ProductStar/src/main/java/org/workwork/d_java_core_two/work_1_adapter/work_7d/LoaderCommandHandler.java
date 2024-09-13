package org.workwork.d_java_core_two.work_1_adapter.work_7d;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LoaderCommandHandler {

    public void processCommand(Command command) {
        Action action = command.getAction();

        switch (action) {
            case SAVE:
                processSaveCommand(command);
                break;
            case FIND:
                processFindCommand(command);
                break;
            case DELETE:
                processDeleteCommand(command);
                break;
            default:
                System.out.println("Действие " + action + " не поддерживается");
                break;
        }

        System.out.println("Обработка команды. "
                + "Действие " + command.getAction().name() +
                ", данные:  " + command.getData());
    }

    private void processSaveCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");

        if (dataArray.length != 2) {
            System.out.println("Некорректные входные данные");
            return;
        }

        if (command.getContent() == null) {
            System.out.println("Не поступил текст на сохранение");
            return;
        }

        String name = dataArray[0];
        String path = dataArray[1];
        String content = command.getContent();

        File directory = new File(path);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Директория " + path + " создана");
            } else {
                System.out.println("Директория " + path + " не создана");
                return;
            }
        }

        File newFile = new File(directory, name);
        System.out.println("Путь к создаваемому файлу: " + newFile.getAbsolutePath());

        if (newFile.exists()) {
            System.out.println("Файл " + name + " уже существует и будет перезаписан");
        } else {
            try {
                boolean created = newFile.createNewFile();
                if (created) {
                    System.out.println("Файл " + name + " создан");
                } else {
                    System.out.println("Файл " + name + " не создан");
                    return;
                }
            } catch (IOException e) {
                System.out.println("Ошибка создания файла");
                return;
            }
        }

        FileWriter writer;
        try {
            writer = new FileWriter(newFile);
        } catch (IOException e) {
            System.out.println("Ошибка создания потока ");
            return;
        }

        try {
            writer.write(content);
            System.out.println("Файл " + name + " записан");
            System.out.println("Размер сохранённого файла: " + content.length());

            String myDate = dateFormatter(newFile.lastModified());
            System.out.println("Время записи файла: " + newFile + "\t" + myDate);

        } catch (IOException e) {
            System.out.println("Ошибка записи данных в файл ");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия потока ");
                return;
            }
        }
    }

    private void processFindCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");

        if (dataArray.length != 2) {
            System.out.println("Некорректные входные данные");
            return;
        }

        String name = dataArray[0];
        String path = dataArray[1];

        File newFile = new File(path, name);
        System.out.println("Путь к искомому файлу: " + newFile.getAbsolutePath());

        if (newFile.exists()) {
            try {
                List<String> content = Files.readAllLines(newFile.toPath(), Charset.defaultCharset());
                System.out.println("Содержимое искомого файла: ");
                System.out.println(content);
            } catch (IOException e) {
                System.out.println("Ошибка чтения данных из файла ");
            }
        } else {
            System.out.println("По указанному пути поиска файл не найден");
        }
    }

    private void processDeleteCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");

        if (dataArray.length != 2) {
            System.out.println("Некорректные входные данные");
            return;
        }

        String name = dataArray[0];
        String path = dataArray[1];

        File newFile = new File(path, name);
        System.out.println("Путь к удаляемому файлу: " + newFile.getAbsolutePath());

        if (newFile.exists()) {
            boolean deleted = newFile.delete();
            if (deleted) {
                System.out.println("Файл " + name + " удален");
            } else {
                System.out.println("Файл " + name + " не удален");
            }
        } else {
            System.out.println("По указанному пути файл для удаления не найден");
        }
    }

    private String dateFormatter(long time) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
