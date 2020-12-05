package com.owlsdonttalk.Unit4;
/*

8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true);
9. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой – 600 м.

 */


public class Unit4homework {

    public static void main(String[] args){
        employees();
        catsAndDogs();
    }

    public static void employees(){
        Employee[] empArr = new Employee[5];
        empArr[0] = new Employee("Ivanov Ivan", "CEO", "ivanov@company.com", "1234", "100", 50);
        empArr[1] = new Employee("Petrova Masha", "CTO", "petrova@company.com", "12345", "50", 14);
        empArr[2] = new Employee("Kuznetsov Grigory", "Manager", "kg@company.com", "1231", "30", 41);
        empArr[3] = new Employee("Selv Olga", "devops", "so@company.com", "12377", "150", 39);
        empArr[4] = new Employee("Petrov Anton", "dev", "pa@company.com", "123411", "90", 25);


        System.out.println("Employees older than 40 years.");
        for(Employee e : empArr){
            if(e.getAge() > 40)
                e.getInfo();
        }
    }

    public static void catsAndDogs(){
        boolean result;
        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.JumpOver(3);
        dog.Run(150);

    }
}

