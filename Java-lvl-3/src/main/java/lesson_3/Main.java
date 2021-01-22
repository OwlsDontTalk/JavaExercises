package lesson_3;

//+ 1.Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
//+2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
//+3. Может пригодиться следующая конструкция: ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);
//4. Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
// Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
// Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
//5. Сделать клиен-серверное приложение. Передать по сети сеарилизованный объект.

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {

        //readFile();
        //readFiewFiles();
        readBigFile();
    }

    public static void readFile(){
        ArrayList<Character> characters = new ArrayList<>();

        try(FileInputStream in = new FileInputStream("lesson-3/lesson3task1.txt")) {

            byte[] arr = new byte[100];
            int x;

            while ( (x=in.read()) != -1) {
                System.out.print((char)x);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFiewFiles() throws IOException {
        ArrayList<InputStream> is = new ArrayList<>();
        ArrayList<Character> out = new ArrayList<>();
        is.add(new FileInputStream("lesson-3/task2-1.txt"));
        is.add(new FileInputStream("lesson-3/task2-2.txt"));
        is.add(new FileInputStream("lesson-3/task2-3.txt"));
        is.add(new FileInputStream("lesson-3/task2-4.txt"));
        is.add(new FileInputStream("lesson-3/task2-5.txt"));

        SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(is));
        int x;

        while ( (x=sis.read()) != -1) {
            out.add((char) x);
        }

        try (FileOutputStream outS = new FileOutputStream("lesson-3/task2-result.txt")) {
            for (int i = 0; i < out.size(); i++) {
                outS.write(out.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBigFile() throws IOException {
        long t = System.currentTimeMillis();
        int page = 0;
        Reader reader = new InputStreamReader(new FileInputStream("lesson-3/task3-loremIpsum.txt"));
        char[] chars = new char[1800];
        while (reader.read(chars) != -1){
            System.out.println("Page: " + page++);
            System.out.println(chars);
        }

        System.out.println("\n\nTotal pages printed: " + page);
        System.out.println("Time spent: " + (System.currentTimeMillis() - t));
    }
}
