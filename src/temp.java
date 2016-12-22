import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class temp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("inputs/day8in.txt"));
        final int XSIZE = 6;
        final int YSIZE = 50;
        char[][] grid = new char[XSIZE][YSIZE];
        for (int a = 0; a < XSIZE; a++) {
            for (int b = 0; b < YSIZE; b++) {
                grid[a][b] = '.';
            }
        }
        int count = 0;
        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(" ");
            if (line[0].equals("rect")) {
                String[] size = line[1].split("x");
                int x = Integer.parseInt(size[0]);
                int y = Integer.parseInt(size[1]);
                for (int a = 0; a < x; a++) {
                    for (int b = 0; b < y; b++) {
                        grid[b][a] = '#';
                    }
                }
            } else if (line[0].equals("rotate")) {
                if (line[1].equals("column")) {
                    String[] size = line[2].split("=");
                    int x = Integer.parseInt(size[1]);
                    int y = Integer.parseInt(line[4]);
                    ArrayList<Character> list = new ArrayList<>();
                    for (int b = 0; b < XSIZE; b++) {
                        list.add(grid[b][x]);
                    }
                    for (int a = 0; a < y; a++) {
                        char a1 = list.remove(list.size() - 1);
                        list.add(0, a1);
                    }
                    for (int b = 0; b < XSIZE; b++) {
                        grid[b][x] = list.get(b);
                    }
                }
                else if (line[1].equals("row")) {
                    String[] size = line[2].split("=");
                    int x = Integer.parseInt(size[1]);
                    int y = Integer.parseInt(line[4]);
                    ArrayList<Character> list = new ArrayList<>();
                    for (int b = 0; b < YSIZE; b++) {
                        list.add(grid[x][b]);
                    }
                    for (int a = 0; a < y; a++) {
                        char a1 = list.remove(list.size() - 1);
                        list.add(0, a1);
                    }
                    for (int b = 0; b < YSIZE; b++) {
                        grid[x][b] = list.get(b);
                    }
                }
            }
        }
        for (int a = 0; a < XSIZE; a++) {
            for (int b = 0; b < YSIZE; b++) {
                if(grid[a][b] == '#')
                    count++;
                System.out.print(grid[a][b]);
            }
            System.out.println();
        }
        System.out.println(count);
    }
}
