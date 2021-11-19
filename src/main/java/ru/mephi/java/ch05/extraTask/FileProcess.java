package ru.mephi.java.ch05.extraTask;

/*
Обработка Файла
Метод принимает 3 пути
* файл с заданиями (несколько строк с целыми числами через запятую)
* файл с результатами
* файл с ошибками
1. Метод выполняет задание - числа из каждой
строки складывает, записывает в другой в файл с результатами
2. При возникновении возможных ошибок, в файл с ошибками записывается
понятный текст ошибки. В случае, если файл с заданиями не получилось
обработать, файл с результатами не должен быть создан(записан результат?)
3. Файл с заданиями удаляется в случае успешного завершения работы.
Метод выбрасывает исключение в случае ошибок. Если исключений было
несколько, наверх нужно выбросить информацию о каждом из них
 */

import javax.xml.crypto.Data;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class FileProcess {


    public static void main(String[] args) {
        try {
            String fileWithTask = "src/main/resources/task";
            String fileWithResult = "src/main/resources/taskResulting";
            String fileWithErr = "src/main/resources/taskErr";
            FileProcess.getSum(fileWithTask, fileWithResult, fileWithErr);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // сделать меньше catch;
    // проверить что в этот момент никто не создал файл


    public static void getSum(String fileWithTask, String fileWithResult, String fileWithErr) throws  Exception {
        File fileTask = new File(fileWithTask);
        File fileRes = new File(fileWithResult);
        File fileErr = new File(fileWithErr);
        Exception exception = null;
        try {
            fileErr.createNewFile();
        } catch (IOException io) {
            throw new Exception("Путь к файлу с ошибками не корректен", io);
        }

        if (!fileTask.exists()) {
            FileNotFoundException ex = new FileNotFoundException("Путь к файлу с заданиями указан неверно, так как такой файл не" +
                    "существует");
            exception = ex;
            // throw exception;
        }
        if (fileRes.exists()) {
            FileFormatException ex = new FileFormatException("Путь к файлу с заданиями указан неверно, такой файл уже существует");
            if (exception != null) {
                ex.addSuppressed(exception);
            }
            throw ex;
        } else if (exception == null) {
            try {
                if (!fileRes.createNewFile()) {
                    exception = new FileFormatException("Путь к файлу с заданиями указан неверно, такой файл уже существует");
                }
            } catch (IOException e) {
                exception = new FileFormatException("Путь к файлу с заданиями указан неверно, такой директории не существует", e);
            }
        }


        if (exception != null) {
            throw exception;
        }


        try {
            int sum = FileProcess.sum(fileTask);
            try (PrintWriter pw = new PrintWriter(fileRes)) {
                pw.println(sum);
                File file = new File(fileWithTask);
                file.delete();
            }
        } catch (FileFormatException ex) {
            try (PrintWriter pw = new PrintWriter(fileWithErr)) {
                String st = (new Date()).toString() + ": " + ex.getMessage();
                pw.write(st);
            }
            throw ex;
        }


    }

    private static Integer sum(File fileWithTask) throws FileFormatException, FileNotFoundException {
        Integer sum = null;

        try (Scanner scanner = new Scanner(fileWithTask)) {
            while (scanner.hasNext()) {
                String[] str = scanner.nextLine().split(",");
                if (str.length != 0 && sum == null)
                    sum = 0;
                for (String s : str) {
                    s = s.replaceAll("\\s", "");
                    sum += Integer.parseInt(s);
                }
            }
        } catch (NumberFormatException exception) { // правильно обработать исключение
            throw new FileFormatException("Неверно составлен файл с данными " + fileWithTask +
                    " Ошибка: " + exception.getMessage() +
                    "\nВ файле должны быть написаны целые числа через запятую, пробелы между цифрами возможны\n"
                    + "Например: запись \"2 0 20\" = \"2020\"", exception);
        }

        return sum;
    }
}
