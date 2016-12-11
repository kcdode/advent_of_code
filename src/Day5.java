
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class Day5 {
    private String input = "ojvtpuvg";
    private MessageDigest md;
    private StringBuffer password = new StringBuffer(8);
    private Character[] passTwo = {'-', '-', '-', '-', '-', '-', '-', '-'};
    private Day5() throws NoSuchAlgorithmException {
        md = MessageDigest.getInstance("MD5");
        run();
        runAgain();
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Day5 day5 = new Day5();
    }

    private void run() throws NoSuchAlgorithmException{
        for (int i = 0; password.length() !=8 ; i++) {
            String toHash = input + i;
            String hash = MD5(toHash);
            if (hash.startsWith("00000")) password.append(hash.charAt(5));
        }
        System.out.println(password.toString());
    }

    private void runAgain() throws NoSuchAlgorithmException {
        System.out.println("Hacking in Progress");
        long i = 0;
        int hacking = 150;
        while (!isFilled(passTwo)) {
            String toHash = input + i;
            String hash = MD5(toHash);
            if (hacking == 500) {
                System.out.print("\r" + Arrays.toString(passTwo) + "  :  " + hash + " :: " + toHash);
                hacking = 0; }
            if (hash.startsWith("00000")) {
                int posInPass = Integer.parseInt(hash.substring(5, 6), 16);
                if (posInPass > 7 || posInPass < 0) {
                    i++;
                    continue;
                }
                if (passTwo[posInPass] == '-')
                    passTwo[posInPass] = hash.charAt(6);
            }
            i++;
            hacking++;
        }
        System.out.println("\n" + Arrays.toString(passTwo));
    }
    private static boolean isFilled(Character[] c) {
        for (int i = 0; i < 8; i++) {
            if (c[i] == '-') return false;
        }
        return true;
    }
    private String MD5(String md5) throws NoSuchAlgorithmException {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(md5.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
        }
        return sb.toString();
    }

}
//import java.security.MessageDigest;
//        import java.util.Arrays;
//
///**
// * @author /u/Philboyd_Studge on 12/4/2016.
// */
//public class temp {
//
//    static String md5BytesToString(byte[] b) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < b.length; i++) {
//            sb.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
//        }
//        return sb.toString();
//    }
//
//    static boolean isFilled(char[] c) {
//        for (int i = 0; i < 8; i++) {
//            if (c[i] == '-') return false;
//        }
//        return true;
//    }
//
//    public static void main(String[] args) throws Exception{
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        String input = "ojvtpuvg";
//        int index = 0;
//
//        String password = "";
//
//        for (int i = 0; i < 8; i++) {
//            while(true) {
//                String temp = input + index++;
//                md.update(temp.getBytes());
//                String hash = md5BytesToString(md.digest());
//                if (hash.startsWith("00000")) {
//                    password += hash.substring(5, 6);
//                    //System.out.println(hash);
//                    break;
//                }
//
//            }
//        }
//
//        System.out.println(password);
//
//        //part 2
//
//        char[] password2 = new char[8];
//        Arrays.fill(password2, '-');
//        index = 0;
//
//        while (!isFilled(password2)) {
//            while(true) {
//                String temp = input + index++;
//                md.update(temp.getBytes());
//                String hash = md5BytesToString(md.digest());
//                if (hash.startsWith("00000")) {
//                    int loc = Integer.parseInt(hash.substring(5, 6), 16);
//                    if (loc < 0 || loc > 7) break;
//                    if (password2[loc] == '-') {
//                        password2[loc] = hash.charAt(6);
//                    }
//                    //System.out.println(hash);
//                    break;
//                }
//            }
//        }
//        System.out.println(new String(password2));
//    }
//}