import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int x = 0;
        boolean flag = true;
        String answer = "1";
        while (flag) {
            if ((x + m - 1) > (n)) {
                x = (x + m - 1) % (n);
                answer += Integer.toString(x + 1);
            }
            else {
                x = (x + m - 1);
                answer += Integer.toString(x + 1);
            }
            if ((x + m - 1) == (n)) {
                flag = false;
            }
        }
        System.out.println(Integer.parseInt(answer));
    }
}