

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Day4 {
    File file = new File("day4in.txt");
    Scanner scanner;
    public Day4() throws IOException{
        scanner = new Scanner(file);
        String[] x = scanner.nextLine().split( "\\[");
        System.out.println(Arrays.toString(x));
    }
    public static void main(String[] args) throws IOException {
        Day4 day4 = new Day4();
    }
}
