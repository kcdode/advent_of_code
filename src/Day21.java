import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class Day21 {

    private StringBuilder word = new StringBuilder();
    private String shouldMatch = "fbgdceah";

    public static void main(String[] args) throws FileNotFoundException {
        Day21 day = new Day21("abcdefgh");
        permutation("", "abcdefgh");
    }
    private static void permutation(String prefix, String str) throws FileNotFoundException {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
            Day21 d = new Day21(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    private Day21(String k) throws  FileNotFoundException{
        ArrayList<String> commands = new ArrayList<>();
        word.append(k);
        //word.append("abcdefgh");
        System.out.println("Before scramble " + word.toString());
        File file = new File("inputs/day21in.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            commands.add(sc.nextLine());
        }
        //for (String x : commands) System.out.println(x);
        for (String command: commands) {
            int h = command.indexOf(' ');
            String move = command.substring(0, h);
            //System.out.println(command);
            //System.out.print("Before: " + word.toString());
            switch (move) {
                case "rotate":
                    rotate(command);
                    break;
                case "swap":
                    swap(command);
                    break;
                case "move":
                    move(command);
                    break;
                case "reverse":
                    reverse(command);
                    break;

            }
            //System.out.println("  After: " + word.toString() + "\n\n");
            if (word.length() != 8) System.exit(0);
        }
        System.out.println("-> Scrambles to: " + word.toString());
        if (word.toString().equals(shouldMatch)) {
            System.out.println(word.toString());
            System.exit(0);
        }
        //partTwo();
    }


    private void move(String x) {
        String[] words = x.split(" ");
        char c = word.charAt(Integer.parseInt(words[2]));
        word.replace(Integer.parseInt(words[2]), Integer.parseInt(words[2]) + 1, "");
        //if (Integer.parseInt(words[5]) == 7)    word.insert(6, String.valueOf(c));
        word.insert(Integer.parseInt(words[5]), String.valueOf(c));
    }

    private void rotate(String x) {
        String[] words = x.split(" ");
        switch (words[1]) {
            case "based":
                rotateByPosition(words);
                break;
            case "left":
                rotateLeft(words);
                break;
            case "right":
                rotateRight(words);
                break;
        }
    }

    private void rotateByPosition(String[] words) {
        StringBuilder out = new StringBuilder();
        out.append(word);
        int x = 1 + out.indexOf(words[6]) + ( (out.indexOf(words[6]) > 3) ? 1 : 0) ; //+1 if pos > 4
        for (int i = 0; i < x; i++) {
            char c = out.charAt(word.length()-1);
            for (int h = word.length(); h > 1; h--) {
                out.replace(h - 1, h, out.substring(h - 2, h - 1));
            }
            out.replace(0, 1, String.valueOf(c));
        }

        this.word.replace(0, word.length(), out.toString());
    }

    private void rotateLeft(String[] words) {
        StringBuilder out = new StringBuilder();
        out.append(word);
        int x = Integer.parseInt(words[2]);
        for (int i = 0; i < x; i++) {
            char c = out.charAt(0);
            for (int h = 0; h < out.length() - 1; h++) {
                out.replace(h, h + 1, out.substring(h + 1, h + 2));
            }
            out.replace(out.length() - 1, out.length(), String.valueOf(c));
        }

        this.word.replace(0, word.length(), out.toString());
    }

    private void rotateRight(String[] words) {
        StringBuilder out = new StringBuilder();
        out.append(word);
        int x = Integer.parseInt(words[2]);
        for (int i = 0; i < x; i++) {
            char c = out.charAt(word.length()-1);
            for (int h = word.length(); h > 1; h--) {
                out.replace(h - 1, h, out.substring(h - 2, h - 1));
            }
            out.replace(0, 1, String.valueOf(c));
        }

        this.word.replace(0, word.length(), out.toString());
    }



    private void swap(String x) {
        String[] words = x.split(" ");
        if (words[1].equals("letter")) {
            int first = word.indexOf(words[2]);
            int second = word.indexOf(words[5]);
            word.replace(first, first + 1, words[5]);
            word.replace(second, second + 1, words[2]);
        } else if (words[1].equals("position")) {
            char one = word.charAt(Integer.parseInt(words[2]));
            char two = word.charAt(Integer.parseInt(words[5]));
            word.replace(Integer.parseInt(words[2]), Integer.parseInt(words[2]) + 1, String.valueOf(two));
            word.replace(Integer.parseInt(words[5]), Integer.parseInt(words[5]) + 1, String.valueOf(one));
        }
    }

    private void reverse(String x) {
        String[] words = x.split(" ");
        int[] pos = {Integer.parseInt(words[2]), Integer.parseInt(words[4])};
        StringBuilder reverse = new StringBuilder();
        for (int i = pos[1]; i >= pos[0]; i--) {
            reverse.append(word.charAt(i));
        }
        word.replace(pos[0], pos[1] + 1, reverse.toString());
    }

}
