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
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
public class FileProcess2 {
    public static void main(String[] args) {
        try {
            String fileWithTask = "src/main/resources/task";
            String fileWithResult = "src/main/resources/taskResult";
            String fileWithErr = "src/main/resources/taskE";
            FileProcess2.getSum(fileWithTask, fileWithResult, fileWithErr);

        } catch (FileFormatException | IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void getSum(String fileWithTask, String fileWithResult, String fileWithErr) throws  IOException,FileFormatException {
        Integer sum = null;
        try {
            sum = FileProcess2.sum(fileWithTask);
        } catch (FileNotFoundException | FileFormatException ex){
            File fileErr = new File(fileWithErr);
            if(!fileErr.exists()){
                try {
                    fileErr.createNewFile();
                } catch (IOException e) {
                    e.addSuppressed(ex);
                    throw e;
                }
            }
            try (FileWriter fw = new FileWriter(fileErr, true)){
            //   fw.
            }
           /* if(!fileErr.exists()){
               FileNotFoundException exception
                       = new FileNotFoundException("Путь к файлу с ошибками указан неправильно или данный файл не создан");
               exception.addSuppressed(ex);
               throw exception;
            }*/
         //   try (PrintWriter pw ){

          //  }

            throw ex;
        }
    }

    private static Integer sum(String fileWithTask) throws FileFormatException, FileNotFoundException {
        Integer sum = null;
        File file = new File(fileWithTask);
        if (!file.exists()) {
            throw new FileNotFoundException("Путь к файлу с заданием указан неправильно или данный файл не создан");
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] str = scanner.nextLine().split(",");
                if (str.length != 0 && sum == null)
                    sum = 0;
                for (String s : str) {
                    s = s.replaceAll("\\s", "");
                    sum += Integer.parseInt(s);
                }
            }
        } catch (NumberFormatException exception) {
            throw new FileFormatException("Неверно составлен файл с данными " + fileWithTask +
                    " Ошибка: " + exception.getMessage() +
                    "\nВ файле должны быть написаны целые числа через запятую, пробелы между цифрами возможны\n"
                    + "Например: запись \"2 0 20\" = \"2020\"");
        }
        return sum;
    }
}
