/**
 * Trap if:
 * Its left and center tiles are traps, but its right tile is not.
 Its center and right tiles are traps, but its left tile is not.
 Only its left tile is a trap.
 Only its right tile is a trap.
 */
public class Day18 {
    private StringBuilder thisRow = new StringBuilder();
    private StringBuilder nextRow = new StringBuilder();
    private int numSafeTiles = 0;

    public static void main(String[] args) {
        Day18 d = new Day18();
    }

    private Day18() {
        thisRow.append(".^.^..^......^^^^^...^^^...^...^....^^.^...^.^^^^....^...^^.^^^...^^^^.^^.^.^^..^.^^^..^^^^^^.^^^..^");
        findSafes(thisRow);
        System.out.println(thisRow.toString());
        int rowNumber = 1;
        while (rowNumber < 400000){
            fillNextRow();
            thisRow.replace(0, thisRow.length(), "");
            thisRow.append(nextRow);
            findSafes(thisRow);
            System.out.println(thisRow.toString());
            nextRow.replace(0, nextRow.length(), "");
            rowNumber++;
        }
        System.out.println(numSafeTiles);

    }
    private void fillNextRow() {
        for (int i = 0; i < thisRow.length(); i++) {
            if (i == 0) {
                firstRow();
                continue;
            }
            if (i == thisRow.length() - 1) {
                lastRow();
                continue;
            }
            midRow(i);
        }
    }

    private boolean checkIsTrap(char[] c) {
        if (c[1] == '^') {
            if ( ( c[0] == '^' && c[2] == '.') || ( c[0] == '.' && c[2] == '^') ) return true;
        }
        if (c[0] == '^' ^ c[2] == '^') {
            if (c[1] == '.') return true;
        }
        return false;
    }

    private void midRow(int index) {
        char[] prevRow = new char[3];
        prevRow[0] = thisRow.charAt(index - 1);
        prevRow[1] = thisRow.charAt(index);
        prevRow[2] = thisRow.charAt(index + 1);
        nextRow.append( (checkIsTrap(prevRow)) ? '^' : ".");
    }

    private void firstRow() {
        char[] prevRow = new char[3];
        prevRow[0] = '.';
        prevRow[1] = thisRow.charAt(0);
        prevRow[2] = thisRow.charAt(1);
        nextRow.append( (checkIsTrap(prevRow)) ? '^' : ".");
    }

    private void lastRow() {
        char[] prevRow = new char[3];
        prevRow[0] = thisRow.charAt(thisRow.length()-2);
        prevRow[1] = thisRow.charAt(thisRow.length()-1);
        prevRow[2] = '.';
        nextRow.append( (checkIsTrap(prevRow)) ? '^' : ".");
    }

    private void findSafes(StringBuilder in) {
        for (char c : in.toString().toCharArray())
            if (c == '.') this.numSafeTiles++;
    }

}
