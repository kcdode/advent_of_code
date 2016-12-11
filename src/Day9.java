import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;
import java.util.regex.*;
import java.util.Scanner;
import java.util.Arrays;
public class Day9 {
    private int index;
    private StringBuilder finalString = new StringBuilder();
    int num = 0;
    public static void main(String[] args) throws FileNotFoundException {
        Day9 day = new Day9();
    }

    private Day9() throws FileNotFoundException {
        File file = new File("inputs/day9in.txt");
        Scanner sc = new Scanner(file);
        StringBuilder x = new StringBuilder();
        x.append(sc.nextLine());
        System.out.println(index);
        increment(x);
        findLength(finalString);

    }

    private void increment(StringBuilder input) {
        Pattern pattern = Pattern.compile("\\((\\d+)x\\d+\\)");
        Pattern pattern1 = Pattern.compile(".+?(?=\\()");
        while (input.length()>0) {
            Matcher m = pattern.matcher(input);
            Matcher matcher = pattern1.matcher(input);
            m.find();
            finalString.append(m.group(0));
            input.replace(0, Integer.parseInt(m.group(1))+m.group(0).length(), "");
            if (input.length() != 0 && Character.isAlphabetic(input.toString().charAt(0))) {
                matcher.find();
                finalString.append(matcher.group(0));
                input.replace(0, matcher.group(0).length(), "");
            }
            System.out.println(finalString);
        }
    }

    private void findLength(StringBuilder finalString) {
        Pattern pattern = Pattern.compile("\\((\\d+)x\\d+\\)");
        Pattern pattern1 = Pattern.compile(".+?(?=\\()");
        while (finalString.length() > 0) {
//            if (Character.isAlphabetic(finalString.toString().charAt(0))) {
//                Matcher m = pattern1.matcher(finalString.toString());
//                num+= m.group(0).length();
//                finalString.replace(0, m.group(0).length(), "");
//                continue;
//            }
            Matcher m = pattern.matcher(finalString.toString());
            m.find();
            String[] x = m.group(0).replace("(", "").replace(")","").split("x");
            System.out.println(Arrays.toString(x));
            finalString.replace(0, m.group(0).length(), "");
            num += Integer.parseInt(x[0]) * Integer.parseInt(x[1]);
        }
        System.out.println(num);
    }
}
