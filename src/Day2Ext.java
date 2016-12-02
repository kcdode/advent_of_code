import java.util.ArrayList;

/**
 * Created by kevin on 12/2/2016.
 */
public class Day2Ext {

    String[][] keypad = {
                {"1"},              //          00              ypos, xpos
           {"2", "3", "4"},         //      10  11  12
      {"5", "6", "7", "8", "9"},    //  20  21  22  23  24
           {"A", "B", "C"},         //      30  31  32
                {"D"}};             //          40
    int pos = 20;
    private ArrayList<String> code = new ArrayList<>();

    public static void main(String[] args) {
        Day2Ext day2 = new Day2Ext();
        day2.iterate();
        //System.out.println(day2.keypad[0][0]);
    }
    private void iterate() {
        for (String x: input) {
            for (int i = 0; i<x.length(); i++) {
                move(x.charAt(i));
            }
            String num = String.valueOf(pos);
            System.out.println(num);
        }
        System.out.println(code);
    }

    private boolean move(char direction) {
        switch (direction) {
            case 'U':
                moveUp();
                return true;
            case 'D':
                moveDown();
                return true;
            case 'L':
                moveLeft();
                return true;
            case 'R':
                moveRight();
                return true;
        }
        return false;
    }
    private boolean moveRight() {
        if (pos == 40 || pos == 32 || pos == 24 || pos == 12 || pos == 00)
            return false;
        else if (pos == 20) pos = 21;
        else if (pos == 30) pos = 31;
        else if (pos == 21) pos = 22;
        else if (pos == 10) pos = 11;
        else if (pos == 31) pos = 32;
        else if (pos == 22) pos = 23;
        else if (pos == 11) pos = 12;
        else if (pos == 23) pos = 24;
        return true;
    }
    private boolean moveLeft() {
        if (pos == 40 || pos == 30 || pos == 20 || pos == 10 || pos == 00)
            return false;
        else if (pos == 24) pos = 23;
        else if (pos == 12) pos = 11;
        else if (pos == 23) pos = 22;
        else if (pos == 32) pos = 31;
        else if (pos == 11) pos = 10;
        else if (pos == 22) pos = 21;
        else if (pos == 31) pos = 30;
        else if (pos == 21) pos = 20;
        return true;
    }
    private boolean moveDown() {
        if (pos == 20 || pos == 30 || pos == 40 || pos == 32 || pos == 24)
            return false;
        else if (pos == 10) pos = 21;
        else if (pos == 11) pos = 22;
        else if (pos == 00) pos = 11;
        else if (pos == 12) pos = 23;
        else if (pos == 21) pos = 30;
        else if (pos == 22) pos = 31;
        else if (pos == 23) pos = 32;
        else if (pos == 31) pos = 40;
        return true;
    }
    private boolean moveUp() {
        if (pos == 20 || pos == 10 || pos == 00 || pos == 12 || pos == 24)
            return false;
        else if (pos == 21) pos = 10;
        else if (pos == 22) pos = 11;
        else if (pos == 23) pos = 12;
        else if (pos == 30) pos = 21;
        else if (pos == 21) pos = 22;
        else if (pos == 32) pos = 23;
        else if (pos == 11) pos = 00;
        else if (pos == 31) pos = 22;
        else if (pos == 40) pos = 31;
        return true;
    }


    private String[] input = {
            "UDRLRRRUULUUDULRULUDRDRURLLDUUDURLUUUDRRRLUUDRUUDDDRRRLRURLLLDDDRDDRUDDULUULDDU" +
                    "DRUUUDLRLLRLDUDUUUUDLDULLLDRLRLRULDDDDDLULURUDURDDLLRDLUDRRULDURDDLUDLL" +
                    "RRUDRUDDDLLURULRDDDRDRRLLUUDDLLLLRLRUULRDRURRRLLLLDULDDLRRRRUDRDULLLDD" +
                    "RRRDLRLRRRLDRULDUDDLDLUULRDDULRDRURRURLDULRUUDUUURDRLDDDURLDURLDUDUR" +
                    "RLLLLRDDLDRUURURRRRDRRDLUULLURRDLLLDLDUUUDRDRULULRULUUDDULDUURRLRLRRDU" +
                    "LDULDRUUDLLUDLLLLUDDULDLLDLLURLLLRUDRDLRUDLULDLLLUDRLRLUDLDRDURDDULDURL" +
                    "LRRRDUUDLRDDRUUDLUURLDRRRRRLDDUUDRURUDLLLRRULLRLDRUURRRRRLRLLUDDRLUDRRDU" +
                    "DUUUDRUDULRRULRDRRRDDRLUUUDRLLURURRLLDUDRUURDLRURLLRDUDUUDLLLUULLRULRLDLRDDDU",
            "DRRRDRUDRLDUUDLLLRLULLLUURLLRLDRLURDRDRDRLDUUULDRDDLDDDURURUDRUUURDRDURLR" +
                    "LUDRRRDURDRRRDULLRDRRLUUUURLRUULRRDUDDDDUURLDULUDLLLRULUDUURRDUUL" +
                    "RRDDURLURRUDRDRLDLRLLULULURLRDLRRRUUURDDUUURDRDRUURUDLULDRDDULLLL" +
                    "LRLRLLUDDLULLUDDLRLRDLDULURDUDULRDDRLUDUUDUDRLLDRRLLDULLRLDURUDRL" +
                    "RRRDULUUUULRRLUDDDLDUUDULLUUURDRLLULRLDLLUUDLLUULUULUDLRRDDRLUUULD" +
                    "DRULDRLURUURDLURDDRULLLLDUDULUDURRDRLDDRRLRURLLRLLLLDURDLUULDLDDLUL" +
                    "LLRDRRRDLLLUUDDDLDRRLUUUUUULDRULLLDUDLDLURLDUDULRRRULDLRRDRUUUUUURR" +
                    "DRUURLDDURDUURURULULLURLLLLUURDUDRRLRRLRLRRRRRULLDLLLRURRDULLDLLULLR" +
                    "DUULDUDUDULDURLRDLDRUUURLLDLLUUDURURUD",
            "UDUUUUURUDLLLRRRDRDRUDDRLLDRRLDRLLUURRULUULULRLLRUDDRLDRLUURDUDLURUULLLULLRR" +
                    "RULRLURRDDULLULULRUDDDUURDRLUDUURRRRUUULLRULLLDLURUDLDDLLRRRULDLLUUR" +
                    "DRRRDRDURURLRUDLDLURDDRLLLUUDRUULLDLLLLUUDRRURLDDUDULUDLDURDLURUURDU" +
                    "UUURDLLLRUUURDUUUDLDUDDLUDDUDUDUDLDUDUUULDULUURDDLRRRULLUDRRDLUDULDUR" +
                    "UURULLLLUDDDLURURLRLRDLRULRLULURRLLRDUDUDRULLRULRUDLURUDLLDUDLRDRLRDU" +
                    "RURRULLDDLRLDDRLRDRRDLRDDLLLLDUURRULLRLLDDLDLURLRLLDULRURRRRDULRLRURU" +
                    "RRULULDUURRDLURRDDLDLLLRULRLLURLRLLDDLRUDDDULDLDLRLURRULRRLULUDLDUDUDD" +
                    "LLUURDDDLULURRULDRRDDDUUURLLDRDURUDRUDLLDRUD",
            "ULRDULURRDDLULLDDLDDDRLDUURDLLDRRRDLLURDRUDDLDURUDRULRULRULULUULLLLDRLRLDRLLLL" +
                    "LRLRRLRLRRRDDULRRLUDLURLLRLLURDDRRDRUUUDLDLDRRRUDLRUDDRURRDUUUDUUULRLD" +
                    "DRDRDRULRLLDLDDLLRLUDLLLLUURLDLRUDRLRDRDRLRULRDDURRLRUDLRLRLDRUDURLRDLD" +
                    "ULLUUULDRLRDDRDUDLLRUDDUDURRRRDLDURRUURDUULLDLRDUDDLUDDDRRRULRLULDRLDDR" +
                    "UURURLRRRURDURDRULLUUDURUDRDRLDLURDDDUDDURUDLRULULURRUULDRLDULRRRRDUUL" +
                    "LRRRRLUDLRDDRLRUDLURRRDRDRLLLULLUULRDULRDLDUURRDULLRULRLRRURDDLDLLRUUDL" +
                    "RLDLRUUDLDDLLULDLUURRRLRDULRLRLDRLDUDURRRLLRUUDLUURRDLDDULDLULUUUUDRRUL" +
                    "LLLLLUULDRULDLRUDDDRDRDDURUURLURRDLDDRUURULLULUUUDDLRDULDDLULDUDRU",
            "LRLRLRLLLRRLUULDDUUUURDULLLRURLDLDRURRRUUDDDULURDRRDURLRLUDLLULDRULLRRRDUUDDRD" +
                    "RULLDDULLLUURDLRLRUURRRLRDLDUDLLRLLURLRLLLDDDULUDUDRDLRRLUDDLRDDURRDRD" +
                    "UUULLUURURLRRDUURLRDLLUDURLRDRLURUURDRLULLUUUURRDDULDDDRULURUULLUDDDDL" +
                    "RURDLLDRURDUDRRLRLDLRRDDRRDDRUDRDLUDDDLUDLUDLRUDDUDRUDLLRURDLRUULRUURU" +
                    "LUURLRDULDLDLLRDRDUDDDULRLDDDRDUDDRRRLRRLLRRRUUURRLDLLDRRDLULUUURUDLULD" +
                    "ULLLDLULRLRDLDDDDDDDLRDRDUDLDLRLUDRRDRRDRUURDUDLDDLUDDDDDDRUURURUURLURL" +
                    "DULUDDLDDLRUUUULRDRLUDLDDLLLRLLDRRULULRLRDURRRLDDRDDRLU" };

}
