package Passport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class Passport {
    private int number;
    private String surname;
    private String name;
    private String patronymic;
    private String dataOfBirth;
    private static List<Passport> listOfPassports = new LinkedList<>();

    public Passport(int number, String surname, String name, String dataOFBirth) {
        this(number, surname, name, null, dataOFBirth);
    }

    public Passport(int number, String surname, String name, String patronymic, String dataOfBirth) {
        if (number <= 0) {
            throw new RuntimeException("Номер паспорта должен быть больше 0!");
        } else {
            this.number = number;
        }
        if (surname == null && surname.isEmpty() && surname.isBlank()) {
            throw new RuntimeException("Введите корректное имя!");
        } else {
            this.surname = surname;
        }
        if (name == null && name.isEmpty() && name.isBlank()) {
            throw new RuntimeException("Введите корректную фамилию!");
        } else {
            this.name = name;
        }
        this.patronymic = patronymic;
        if (parseDate(dataOfBirth) == null) {
            System.out.println("Введите дату рождения в формате \"dd.MM.yyyy\"");
        } else {
            this.dataOfBirth = dataOfBirth;
        }
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static void addNewPassport(Passport newPassport) {
        boolean checkNewPassport = true; //false - паспорт с таким номером уже есть
        for (Passport passport : listOfPassports) {
            if (passport.getNumber() == newPassport.getNumber()) {
                passport.setName(newPassport.getName());
                passport.setSurname(newPassport.getSurname());
                passport.setPatronymic(newPassport.getPatronymic());
                passport.setDataOfBirth(newPassport.getDataOfBirth());
                checkNewPassport = false;
                break;
            }
        }
        if (checkNewPassport) {
            listOfPassports.add(newPassport);
        }
    }

    public static Passport searchPassport(Passport searchPassport) {
        for (Passport passport : listOfPassports) {
            if (passport.getNumber() == searchPassport.getNumber()) {
                return searchPassport;
            }
        }
        return null;
    }

    public static void printListOfPassports() {
        System.out.println("Полный перечень паспортов:");
        for (Passport passport : listOfPassports) {
            System.out.println(passport);
        }
    }

    @Override
    public String toString() {
        if (patronymic == null) {
            return "Паспорт №" + number + " - " + surname + " " + name + " (" + dataOfBirth + ")";
        } else {
            return "Паспорт №" + number + " - " + surname + " " + name + " " + patronymic + " (" + dataOfBirth + ")";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return number == passport.number && Objects.equals(surname, passport.surname) && Objects.equals(name, passport.name) && Objects.equals(patronymic, passport.patronymic) && Objects.equals(dataOfBirth, passport.dataOfBirth) && Objects.equals(listOfPassports, passport.listOfPassports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, surname, name, patronymic, dataOfBirth, listOfPassports);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number <= 0) {
            throw new RuntimeException("Номер паспорта должен быть больше 0!");
        } else {
            this.number = number;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null && surname.isEmpty() && surname.isBlank()) {
            throw new RuntimeException("Введите корректное имя!");
        } else {
            this.surname = surname;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null && name.isEmpty() && name.isBlank()) {
            throw new RuntimeException("Введите корректную фамилию!");
        } else {
            this.name = name;
        }
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(String dataOfBirth) {
        if (parseDate(dataOfBirth) == null) {
            System.out.println("Введите дату рождения в формате \"dd.MM.yyyy\"");
        } else {
            this.dataOfBirth = dataOfBirth;
        }
    }

    private static List<Passport> getListOfPassports() {
        return listOfPassports;
    }


}
