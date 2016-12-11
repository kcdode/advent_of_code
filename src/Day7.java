import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day7 {
    private File file;
    private Scanner sc;
    private HashMap<String, String> ips = new HashMap<>();
    private int total;
    private int total2;

    private Day7() throws FileNotFoundException {
        file = new File("inputs/day7in.txt");
        sc = new Scanner(file);
        fill(sc);
        increment();
        System.out.println(total);
        partTwo();
        System.out.println(total2);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Day7 day7 = new Day7();
    }

    private void fill(Scanner sc) {
        while (sc.hasNextLine()) {
            StringBuilder noBrackets = new StringBuilder();
            StringBuilder brackets = new StringBuilder();
            boolean inBrackets = false;
            bracketOrNot(sc, noBrackets, brackets, inBrackets);
            ips.put(noBrackets.toString(), brackets.toString());
        }
        //System.out.println(ips);
    }

    private void bracketOrNot(Scanner sc, StringBuilder noBrackets, StringBuilder brackets, boolean inBrackets) {
        for (char c : sc.nextLine().toCharArray()) {
            if (c == '[') {
                noBrackets.append('1');
                inBrackets = true;
                continue;
            }
            if (c == ']') {
                brackets.append('1');
                inBrackets = false;
                continue;
            }
            if (!inBrackets) noBrackets.append(c);
            if (inBrackets) brackets.append(c);
        }
    }

    // part 2
    private void partTwo() {
        for (String x : ips.keySet()) {
            for (int i = 0; i <= x.length() - 3; i++) {
                if (isABA(x.substring(i, i + 3))) {
                    String reverse = createReverse(x.substring(i, i + 3));
                    if (ips.get(x).contains(reverse)) {
                        total2++;
                        break;
                    }
                }
            }
        }
    }

    private String createReverse(String x) {
        StringBuilder temp = new StringBuilder();
        temp.append(x.charAt(1));
        temp.append(x.charAt(0));
        temp.append(x.charAt(1));
        return temp.toString();
    }

    private boolean isABA(String x) {
        if (x.length() != 3) {
            System.out.println("len > 3" + x);
            System.exit(0);
        }
        return (x.charAt(0) == x.charAt(2) && x.charAt(0) != x.charAt(1));
    }


    // part 1

    private void increment() {
        for (String x : ips.keySet()) {
            String y = ips.get(x);
            if (bracketsContainABBA(y)) continue;
            for (int i = 0; i <= x.length() - 4; i++) {
                if (isAABA(x.substring(i, i + 4))) {
                    total++;
                    break;
                }
            }
        }
    }

    private boolean bracketsContainABBA(String y) {
        for (int i = 0; i <= y.length() - 4; i++) {
            if (isAABA(y.substring(i, i + 4))) return true;
        }
        return false;
    }

    private boolean isAABA(String x) {
        return ((x.charAt(0) == x.charAt(3)) && (x.charAt(1) == x.charAt(2)) && (x.charAt(0) != x.charAt(1)));

    }
}
