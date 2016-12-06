import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
public class Day6 {
    private HashMap<Character, Integer> frequency = new HashMap<>();
    private ArrayList<String> input = new ArrayList<>();

    //ArrayList
    public Day6() throws FileNotFoundException{
        File file = new File("inputs/day6in.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }
        run();
    }
    public static void main(String[] args) throws FileNotFoundException {
        Day6 day6 = new Day6();
    }

    private void run() {
        fill();
        for (int i = 0; i < 8; i ++) {
            for (String x : input) {
                int temp = frequency.get(x.charAt(i));
                frequency.put(x.charAt(i), temp+1);
               // System.out.println(frequency);
            }
            findMax();
            //System.out.println(frequency);
            fill();
        }

    }
    private void findMax() {
        int temp = frequency.get('a');
        char tempc = '1';
        for (Character c : frequency.keySet()) {
            if (frequency.get(c) < temp) { // or > for part 1
                tempc = c;
                temp = frequency.get(c);
            }
        }
        System.out.println(temp + " " + tempc);
    }

    private void fill() {
        for (char c = 'a'; c <= 'z'; ++c)
            frequency.put(c, 0);
    }

}
