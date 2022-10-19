import Passport.Passport;

public class Main {

    public static void main(String[] args) {
/*
        //ДЗ про числа
        System.out.println("ДЗ про числа");

        fillSetRandomNumber();
        System.out.println(getSetNumbers());

        changeSetNumbers(getEvenNumbers(getSetNumbers()));
        System.out.println(getSetNumbers());

        //ДЗ про таблицу умножения
        System.out.println("ДЗ про таблицу умножения");

        generateTasks();
        System.out.println(getSetTasks());
*/
        //ДЗ про паспорт
        System.out.println("ДЗ про паспорт");

        Passport.addNewPassport(new Passport(55516, "Петров", "Иван","Андреевич", "16.02.1970"));
        Passport.addNewPassport(new Passport(356, "Сидорова", "Ольга","Леонидовна", "25.04.1983"));
        Passport.addNewPassport(new Passport(111111, "Пинта", "Гонсалес", "13.09.2000"));
        Passport.addNewPassport(new Passport(2323, "Бахметьева", "Ирина","Олеговна", "03.12.2064"));
        Passport.addNewPassport(new Passport(04, "Меркулов", "Игорь","Александрович", "10.01.1996"));

        Passport.printListOfPassports();

        System.out.println();
        System.out.println("Поиск паспорта");
        System.out.println(Passport.searchPassport(new Passport(55516, "Петров", "Иван","Андреевич", "16.02.1970")));
        System.out.println(Passport.searchPassport(new Passport(55517, "Петрова", "Марина","Андреевна", "17.10.1972")));



    }
}