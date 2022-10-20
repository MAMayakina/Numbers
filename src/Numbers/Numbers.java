package Numbers;

import java.util.HashSet;
import java.util.Set;

public class Numbers {
    private static Set<Integer> setNumbers = new HashSet<>();
    static final int COUNT = 20;

    public Numbers() {
    }

    public static void fillSetRandomNumber() {
        for (int i = 0; i < COUNT; i++) {
            int newNumber = (int) (Math.random() * 1000);
            setNumbers.add(newNumber);
        }
    }

    public static Set<Integer> getEvenNumbers(Set<Integer> setAllNumbers) {
        Set<Integer> setEvenNumbers = new HashSet<>();

        for (Integer number : setAllNumbers) {
            if (number % 2 != 0) {
            } else {
                setEvenNumbers.add(number);
            }
        }

        return setEvenNumbers;
    }

    public static void changeSetNumbers(Set<Integer> newSet) {
        setNumbers=newSet;
    }

    public static Set<Integer> getSetNumbers() {
        return setNumbers;
    }
}
