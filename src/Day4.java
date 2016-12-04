
import java.util.*;
import java.io.File;
import java.io.IOException;
public class Day4 {
    File file = new File("inputs/day4in.txt");
    Scanner scanner;
    int sum;
    HashMap<String, String> inputs = new HashMap<>();
    HashMap<Character, Integer> frequency = new HashMap<>();


    public Day4() throws IOException{
        fill();
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] x = scanner.nextLine().split( "\\[");
            String y = x[0].replaceAll("-", "");
            String z = x[1].replaceAll("]", "");
            inputs.put(z, y);
        }
        iterate();
        System.out.println(sum);
    }

    // checks if the md5 is valid
    private boolean isGood(HashMap<Character, Integer> inputs, String key) {
        for (int i = 0; i < appearences.length-1; i++) {
            for (int h = i; h < appearences.length; h++) {
                if (appearences[i] < appearences[h]) return false;
                //if (appearences[i] == appearences[h]) {
                if (Character.valueOf(key.charAt(i)) > Character.valueOf(key.charAt(h))) return false;
                //}
            }
        }
        return true;
//            if (appearences[i] == appearences[i+1]) {
//                if (Character.valueOf(key.charAt(i)) > Character.valueOf(key.charAt(i++))) return false;
//            }
    }

    // tests how many apperances of each md5, then checks if it's a good one
    private void iterate() {
        for (String key: inputs.keySet()) {
            for( int i = 0; i < inputs.get(key).length(); i++){
                Character c = inputs.get(key).charAt(i);
                if (Character.isDigit(c)) continue;
                Integer val = frequency.get(c);
                frequency.put(c, val + 1);
            }
            isGood(frequency, key);
        }

    }

    public static void main(String[] args) throws IOException {
        Day4 day4 = new Day4();
    }
    private void fill() {
        frequency.put('a', 0);
        frequency.put('b', 0);
        frequency.put('c', 0);
        frequency.put('d', 0);
        frequency.put('e', 0);
        frequency.put('f', 0);
        frequency.put('g', 0);
        frequency.put('h', 0);
        frequency.put('i', 0);
        frequency.put('j', 0);
        frequency.put('k', 0);
        frequency.put('l', 0);
        frequency.put('m', 0);
        frequency.put('n', 0);
        frequency.put('o', 0);
        frequency.put('p', 0);
        frequency.put('q', 0);
        frequency.put('r', 0);
        frequency.put('s', 0);
        frequency.put('t', 0);
        frequency.put('u', 0);
        frequency.put('v', 0);
        frequency.put('w', 0);
        frequency.put('x', 0);
        frequency.put('y', 0);
        frequency.put('z', 0);

    }
}
//    int[] appearances = {0, 0, 0, 0, 0};
//    String value = inputs.get(key);
//            for (int i = 0; i < key.length(); i++) {
//        for (char c: value.toCharArray()) {
//        if (key.charAt(i) == c) appearances[i]++;
//        }
//        }
//        if (isGood(appearances, key)) {
//        String num = "";
//        for (char c: inputs.get(key).toCharArray()) {
//        if (Character.isDigit(c))
//        num+=c;
//        }
//        int numm = Integer.parseInt(num);
//        sum+= numm;
//        }