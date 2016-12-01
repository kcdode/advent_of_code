import java.util.ArrayList;
import java.util.HashMap;

public class Day1 {
    String input = "L3, R2, L5, R1, L1, L2, L2, R1, " +
            "R5, R1, L1, L2, R2, R4, L4, L3, L3, R5, L1, " +
            "R3, L5, L2, R4, L5, R4, R2, L2, L1, R1, L3, " +
            "L3, R2, R1, L4, L1, L1, R4, R5, R1, L2, L1, " +
            "R188, R4, L3, R54, L4, R4, R74, R2, L4, R185, " +
            "R1, R3, R5, L2, L3, R1, L1, L3, R3, R2, L3, " +
            "L4, R1, L3, L5, L2, R2, L1, R2, R1, L4, R5, R4," +
            " L5, L5, L4, R5, R4, L5, L3, R4, R1, L5, L4, L3, " +
            "R5, L5, L2, L4, R4, R4, R2, L1, L3, L2, R5, R4, L5," +
            " R1, R2, R5, L2, R4, R5, L2, L3, R3, L4, R3, L2, " +
            "R1, R4, L5, R1, L5, L3, R4, L2, L2, L5, L5, R5, R2, " +
            "L5, R1, L3, L2, L2, R3, L3, L4, R2, R3, L1, R2, L5, " +
            "L3, R4, L4, R4, R3, L3, R1, L3, R5, L5, R1, R5, R3, L1";
    String[] directions = input.split(", ");
    int x = 0;
    int y = 0;
    String facing; //up down left right
    ArrayList<String> stops = new ArrayList<>();

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        day1.facing = "up";
        day1.run();
        System.out.println(day1.stops);
    }

    private void run() {
        for (String i: directions) {
            move(i);    }
        System.out.printf("%d, %d", x, y); // -131, 78, distance 209
    }

    private void move(String movement) {
        char direction = movement.charAt(0);
        int steps = Integer.parseInt(movement.substring(1, movement.length()));
        if (direction == 'L') {
            left(direction, steps);
            repeats();
        } else if (direction == 'R') {
            right(direction, steps);
            repeats();
        }
    }

    private boolean left(char direction, int steps) {
        switch (facing) {
            case "up":
                facing = "left";
                x = x - steps;
                for (int i = 0; i < steps; i++) { stops.add(String.valueOf(x+i) + "," + String.valueOf(y));   }
                return true;
            case "left":
                facing = "down";
                y = y - steps;
                for (int i = 0; i < steps; i++) { stops.add(String.valueOf(x) + "," + String.valueOf(y+i));   }
                return true;
            case "down":
                facing = "right";
                x = x + steps;
                for (int i = 0; i < steps; i++) { stops.add(String.valueOf(x-i) + "," +  String.valueOf(y));   }
                return true;
            case "right":
                facing = "up";
                y = y + steps;
                for (int i = 0; i < steps; i++) { stops.add(String.valueOf(x) + "," + String.valueOf(y-i));   }
                return true;
        }
        return false;
    }
    private boolean right(char direction, int steps) {
        switch (facing) {
            case "up":
                facing = "right";
                x = x + steps;
                for (int i = 0; i < steps; i++) { stops.add(String.valueOf(x-i) + "," + String.valueOf(y));   }
                return true;
            case "left":
                facing = "up";
                y = y + steps;
                for (int i = 0; i < steps; i++) { stops.add(String.valueOf(x) + "," + String.valueOf(y-i));   }
                return true;
            case "down":
                facing = "left";
                x = x - steps;
                for (int i = 0; i < steps; i++) { stops.add(String.valueOf(x+i) + "," + String.valueOf(y));   }
                return true;
            case "right":
                facing = "down";
                y = y - steps;
                for (int i = 0; i < steps; i++) { stops.add(String.valueOf(x) + "," + String.valueOf(y+i));   }
                return true;
        }
        return false;
    }
    private void repeats() {
        for (int x = 0; x < stops.size(); x++ ) {
            for (int i = x+1; i < stops.size(); i++) {
                if (stops.get(x).equals(stops.get(i))) {
                    System.out.println(stops.get(i)); // -6, 130
                    System.exit(0);
                }
            }
        }
    }
}
