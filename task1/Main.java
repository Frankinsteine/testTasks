import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int x = 0;
        boolean flag = true;
        String answer = "1";
        while (flag) {
            if (((x + m - 1) % n) == 0) {
                flag = false;
            }
            else {
                x = (x + m - 1) % n;
                answer += Integer.toString(x + 1);
            }
        }
        System.out.println(Integer.parseInt(answer));
    }
}