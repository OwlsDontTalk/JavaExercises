package java2.unit3;

import java.util.*;

public class MainCollection {
    public static void main(String[] args) {


        //task 1
        String[] wordsArray = initWordsArray(20);
        countUniqueWords(wordsArray);

        //task 2
        PhoneBook ph = new PhoneBook();
        ph.add("Petrov", "111");
        ph.add("Ivanova", "222");
        ph.add("Maev", "112");
        ph.add("Petrov", "333");

        ph.get("Petrov");
        ph.printPhonebook();
    }

    static String[] initWordsArray(int size){
        String[] wordsArray = new String[size];
        Random r = new Random();

        System.out.println("Generating String array: ");

        for (int i = 0; i < size; i++) {
            wordsArray[i] = "a" + r.nextInt(5);
            System.out.print(wordsArray[i] + " ");
        }
        return wordsArray;
    }

    static void countUniqueWords(String[] wordsArray){
        Map<String, Integer> uniqueWords = new HashMap<>();

        for (String s : wordsArray) {
            Integer wordCounter = uniqueWords.get(s);
            uniqueWords.put( s, wordCounter == null ?  1 : wordCounter + 1 );
        }

        System.out.println("\nUnique string counted: ");
        System.out.println(uniqueWords + " ");
    }
}


class PhoneBook{

    Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone){
        List<String> abonent = new ArrayList<>();

        if(this.phoneBook.containsKey(name)){
            abonent = phoneBook.get(name);
            abonent.add(phone);
        } else {
            abonent.add(phone);
            this.phoneBook.put(name, abonent);
        }
    }

    public void get(String name){
        if(phoneBook.containsKey(name)){
            System.out.println("Abonent " + name + " phones: " + phoneBook.get(name));
        } else {
            System.out.println("There is no such abonent in our phonebook");
        }
    }

    public void printPhonebook(){

        System.out.println("\nPhonebook database:");
        for (String s : phoneBook.keySet()) {
            System.out.println("Abonent: " + s + ", phones: " + phoneBook.get(s));
        }
    }
}