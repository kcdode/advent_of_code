import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
// rotate x by z rotate xth column [same][change]
// rotate y by z rotates yth row    [change][same]
public class Day8 {
    private Scanner sc;
    private ArrayList<String> instructions = new ArrayList<>();
    private boolean[][] screen = new boolean[6][50];
    int totalOn;

    public static void main(String[] args) throws FileNotFoundException {
        Day8 day = new Day8();
    }

    private Day8() throws FileNotFoundException{
        File file = new File("inputs/day8in.txt");
        sc = new Scanner(file);
        fill();
        start();
    }

    private void start() {
        for (String x: instructions) {
            if (x.contains("rect") ) {
                addRectangle(x);
                continue;
            }
            if (x.contains("y=") ) {
                moveRow(x);
                continue;
            }
            if (x.contains("x=")) {
                moveColumn(x);
            }
        }
    }

    private void moveRow(String y) {
        String[] x = y.replace("y=", "").split("by"); // [row number, amount]
        int row = Integer.parseInt(x[0]);
        for (int i = 0; i < Integer.parseInt(x[1]); i++) {
            int h = findFirst(screen[row], 50);
            System.out.println(h);
            //checkNext(screen[row], i);
        }
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(screen[row]));
    }

    private void checkNext(boolean[] booleans, int h) {
        if (h == 49) {
            checkNext(booleans, 0);
           }
        if (h!= 49 && booleans[h+1]) {
            checkNext(booleans, h+1);
            }
        else if (h!= 49 && !booleans[h+1]){
            booleans[h+1] = true;
            booleans[h] = false;
        }
    }

    private int findFirst(boolean[] array, int index) {
        if (array[index]) findFirst(array, index-1);
        return index;
    }

    private void moveColumn(String x) {
        //System.out.println("Column");
    }

    private void addRectangle(String rectangle){
        String [] x = rectangle.replace("rect", "").split("x");
        for (int i = 0; i <Integer.parseInt(x[1]); i++) {
            for (int h = 0; h < Integer.parseInt(x[0]); h++) {
                screen[i][h] = true;

            }
        }
        System.out.println(Arrays.toString(x));
        printMap();
    }
    private void fill() {
        while (sc.hasNextLine()) {
            instructions.add(sc.nextLine().replace("row", "").replace("rotate", "").replace(" ", "".replace("rect", "")));
        }
        for (int i = 0; i < screen.length; i++) {
            for (int h = 0; h < screen[i].length; h++) {
                screen[i][h] = false;
            }
        }
    }
    private void printMap() {
        for (boolean[] x: screen) {
            System.out.println(Arrays.toString(x));
        }
    }
}
