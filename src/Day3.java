
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Day3 {
    File input = new File("day3input.txt");
    Scanner reader;
    private int total;
    int[][] nextNine;
    private Day3() {
        try {
            reader = new Scanner(input);
            int i = 0;
            int[][] temp = {
                    {0, 0, 0},
                    {0, 0, 0} };


            int[][] nextNine = {
                    {reader.nextInt(), reader.nextInt(), reader.nextInt()},
                    {reader.nextInt(), reader.nextInt(), reader.nextInt()},
                    {reader.nextInt(), reader.nextInt(), reader.nextInt()} };
            for (int j = 0; j < 3; j++) { // column number
                // finds hundreds digit triangle
                if (intlength(nextNine[0][j]) < 3 || intlength(nextNine[1][j]) < 3 || intlength(nextNine[2][j]) < 3 ) {}
                else {calcTriangles(intss(nextNine[0][j], 0, 1), intss(nextNine[1][j], 0, 1), intss(nextNine[2][j], 0, 1)); }
                // finds tens digit length
                if (intlength(nextNine[0][j]) < 2 || intlength(nextNine[1][j]) < 2 || intlength(nextNine[2][j]) < 2  ) {}
                else {
                    int one = (intlength(nextNine[0][j]) == 2) ? 0 : 1;
                    int two = (intlength(nextNine[1][j]) == 2) ? 0 : 1;
                    int three = (intlength(nextNine[2][j]) == 2) ? 0 : 1;
                    calcTriangles(intss(nextNine[0][j], one, one+1),intss(nextNine[1][j], two, two+1), intss(nextNine[2][j], three, three+1) ); }
                // finds one digit length
                int one1 = (intlength(nextNine[0][j]) < 3) ? ((intlength(nextNine[0][j]) < 2) ? 0 : 1 ) : 2;
                int two1 = (intlength(nextNine[1][j]) < 3) ? ((intlength(nextNine[1][j]) < 2) ? 0 : 1 ) : 2;
                int three1 = (intlength(nextNine[2][j]) < 3) ? ((intlength(nextNine[2][j]) < 2) ? 0 : 1 ) : 2;
                calcTriangles(intss(nextNine[0][j], one1, one1+1),intss(nextNine[1][j], two1, two1+1), intss(nextNine[2][j], three1, three1+1) );
            }
            for (int z = 0; z < 3; z++) {
                nextNine[0][z] = nextNine[1][z];
                //System.out.println(nextNine[0][z]);
                nextNine[1][z] = nextNine[2][z];
                //System.out.println(nextNine[1][z]);
            }


            while (reader.hasNextLine()) {
                nextNine[2][0] = reader.nextInt();
                nextNine[2][1] = reader.nextInt();
                nextNine[2][2] = reader.nextInt();
                for (int j = 0; j < 3; j++) { // column number
                        // finds hundreds digit triangle
                        if (intlength(nextNine[0][j]) < 3 || intlength(nextNine[1][j]) < 3 || intlength(nextNine[2][j]) < 3 ) {}
                        else {calcTriangles(intss(nextNine[0][j], 0, 1), intss(nextNine[1][j], 0, 1), intss(nextNine[2][j], 0, 1)); }
                        // finds tens digit length
                        if (intlength(nextNine[0][j]) < 2 || intlength(nextNine[1][j]) < 2 || intlength(nextNine[2][j]) < 2  ) {}
                        else {
                            int one = (intlength(nextNine[0][j]) == 2) ? 0 : 1;
                            int two = (intlength(nextNine[1][j]) == 2) ? 0 : 1;
                            int three = (intlength(nextNine[2][j]) == 2) ? 0 : 1;
                            calcTriangles(intss(nextNine[0][j], one, one+1),intss(nextNine[1][j], two, two+1), intss(nextNine[2][j], three, three+1) ); }
                        // finds one digit length
                        int one1 = (intlength(nextNine[0][j]) < 3) ? ((intlength(nextNine[0][j]) < 2) ? 0 : 1 ) : 2;
                        int two1 = (intlength(nextNine[1][j]) < 3) ? ((intlength(nextNine[1][j]) < 2) ? 0 : 1 ) : 2;
                        int three1 = (intlength(nextNine[2][j]) < 3) ? ((intlength(nextNine[2][j]) < 2) ? 0 : 1 ) : 2;
                        calcTriangles(intss(nextNine[0][j], one1, one1+1),intss(nextNine[1][j], two1, two1+1), intss(nextNine[2][j], three1, three1+1) );
                }
                for (int z = 0; z < 3; z++) {
                    nextNine[0][z] = nextNine[1][z];
                    //System.out.println(nextNine[0][z]);
                    nextNine[1][z] = nextNine[2][z];
                    //System.out.println(nextNine[1][z]);
                }
            }
            System.out.println(total);
        } catch (IOException e) {System.out.println("Whoops"); }

    }
    private void firstrun() {


    }

    private int intlength(int x) {return String.valueOf(x).length(); }
    private int intss(int x, int beg, int end) {return Integer.parseInt(Integer.toString(x).substring(beg, end));}

    public static void main(String[] args) {
        Day3 day = new Day3();
    }

    private void calcTriangles(int one, int two, int three) {
        if ( (one + two > three) && (one + three > two) && (two + three > one)) total++;
    }



}
