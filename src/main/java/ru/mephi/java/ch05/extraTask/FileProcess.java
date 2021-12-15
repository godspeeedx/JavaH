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
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Scanner;

public class FileProcess {


    public static void main(String[] args) {
        try {
            String fileWithTask = "src/main/reddsources/task";
            String fileWithResult = "src/main/resources/taskResulting";
            String fileWithErr = "src/main/resources/taskErr";
            FileProcess.getSum(fileWithTask, fileWithResult, fileWithErr);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // сделать меньше catch; +
    //

    private static void checkFileTask(File fileTask) throws FileNotFoundException {
        if (!fileTask.exists()) {
            throw new FileNotFoundException("Путь к файлу с заданиями указан неверно, так как такой файл не" +
                    "существует");
        }
    }

    private static void checkFileRes(File fileRes) throws Exception {
        if (!fileRes.createNewFile()) {
            throw new FileFormatException("Файл с результатами уже существует");
        }

    }


    private static void getSum(String fileWithTask, String fileWithResult, String fileWithErr) throws Exception {
        File fileTask = new File(fileWithTask);
        File fileRes = new File(fileWithResult);
        File fileErr = new File(fileWithErr);
        Exception exception = null;
        try {
            fileErr.createNewFile();
        } catch (IOException io) {
            throw new Exception("Путь к файлу с ошибками не корректен", io);
        }

      /*  if (fileRes.exists()) {
            FileFormatException ex = new FileFormatException("Путь к файлу с результатами указан неверно, такой файл уже существует");
            if (exception != null) {
                exception.addSuppressed(ex);
            } else {
                exception = ex;
            }
        } else if (exception == null) {
            try {
                if (!fileRes.createNewFile()) {
                    exception = new FileFormatException("Путь к файлу с заданиями указан неверно, такой файл уже существует или путь указан неверно");
                }
            } catch (IOException e) {
                exception = new FileFormatException("Путь к файлу с заданиями указан неверно, такой директории не существует", e);
            }
        }*/
    /*
    else {   Exception ex1 = null;
            try {
                if (!fileRes.createNewFile()) {
                    ex1 = new FileFormatException("Путь к файлу с заданиями указан неверно, такой файл уже существует");
                }
            } catch (IOException e) {
                ex1 = new FileFormatException("Путь к файлу с заданиями указан неверно, такой директории не существует", e);
            }
            if (exception != null){
               exception.addSuppressed(ex1)
            }
        }
     */

       /* if (exception != null) {
            try (PrintWriter pw = new PrintWriter(fileWithErr)) {

                String st = (new Date()).toString() + ": " + exception.getMessage();
                pw.write(st);
            } catch (Exception ex) {
                exception.addSuppressed(ex);
            }
            throw exception;
        }*/

        /*
        Гриша, спроси плиз, вот я не смог удалить файл с заданием, значит, я должен буду удалить
        Файл с результатами и кинуть exception("Не смог удалить файл с заданием"), а если при попытке удалить файл
        с результами, то к этому исключению ещё супресед добавить
         */
        boolean flag = true;
        try {
            FileProcess.checkFileTask(fileTask);
            FileProcess.checkFileRes(fileRes);
            int sum = FileProcess.sum(fileTask);
            try (PrintWriter pw = new PrintWriter(fileRes)) {
                pw.println(sum);
            }
            if (!Files.deleteIfExists(Path.of(fileWithTask))) {
                throw new FileFormatException("Не удалось удалить файл с заданием");
            }

        } catch (Exception ex) {
            try {
                if (!Files.deleteIfExists(Path.of(fileWithResult))) {
                    throw new FileFormatException("Не удалось удалить файл с результатом");// Если файл используется в другой программе то его низя удалить
                }
            } catch (Exception ex2) {
                ex.addSuppressed(ex2);
            }
            try (PrintWriter pw = new PrintWriter(fileWithErr)) {
                ex.printStackTrace(pw);
            } catch (Exception exx) {
                ex.addSuppressed(exx);
            }

            throw ex;
        }


    }

    private static int sum(File fileWithTask) throws FileFormatException, FileNotFoundException {
        int sum = 0;

        try (Scanner scanner = new Scanner(fileWithTask)) {
            while (scanner.hasNext()) {
                String[] str = scanner.nextLine().split(",");
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
