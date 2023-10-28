import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File(args[0]);
        ArrayList<Integer> nums = new ArrayList<>();

        try {
          Scanner scanner = new Scanner(file);

          while (scanner.hasNextLine()) {
              String line = scanner.nextLine();
              nums.add(Integer.parseInt(line));
          }

          scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int average = 0;
        double sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum+= nums.get(i);
        }
        average = Integer.parseInt(String.format("%.0f", (sum / nums.size())));
        int answer = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) >= average){
                answer+= nums.get(i) - average;
            } else {
                answer+= average - nums.get(i);
            }
        }
        System.out.println(answer);
    }
}