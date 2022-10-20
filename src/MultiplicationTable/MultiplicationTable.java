package MultiplicationTable;

import java.util.HashSet;
import java.util.Set;

public class MultiplicationTable {
    private static Set<String> setTasks = new HashSet<>();
    static final int COUNT_PUPIL = 15;

    public MultiplicationTable() {
    }

    public static String generatePairNumber() {
        int x;
        int y;
        x = (int) (Math.random() * 8) + 2;
        y = (int) (Math.random() * 8) + 2;
        String pairNumber = String.valueOf(x) + "*" + String.valueOf(y);
        return pairNumber;
    }

    public static boolean checkTask(String pairNumber) {
        String invertedPairNumber = pairNumber.charAt(2) + "*" + pairNumber.charAt(0);
        for (String task : setTasks) {
            if (pairNumber.equals(task) || invertedPairNumber.equals(task)) {
                return true;
            }
        }
        return false;
    }

    public static void generateTasks() {
        setTasks.add(generatePairNumber());
        while (setTasks.size() < COUNT_PUPIL) {
            String pairNumber = generatePairNumber();
            while (checkTask(pairNumber)) {
                pairNumber = generatePairNumber();
            }
            setTasks.add(pairNumber);
        }
    }

    public static Set<String> getSetTasks() {
        return setTasks;
    }
}
