import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file1 = new File(args[0]);
        File file2 = new File(args[1]);

        ArrayList <Float> listOfCenterX = new ArrayList<>();
        ArrayList <Float> listOfCenterY = new ArrayList<>();
        ArrayList <Float> listOfRadius = new ArrayList<>();
        ArrayList <Float> listOfPointsX = new ArrayList<>();
        ArrayList <Float> listOfPointsY = new ArrayList<>();

        try{
            //read from file1
            Scanner scanner1 = new Scanner(file1);

            int counter = 0;
            while (scanner1.hasNextLine()) {
                String line = scanner1.nextLine();
                if(counter % 2 == 0) {
                    String[] coords = line.split(" ");
                    listOfCenterX.add(Float.parseFloat(coords[0]));
                    listOfCenterY.add(Float.parseFloat(coords[1]));
                } else {
                    listOfRadius.add(Float.parseFloat(line));
                }
                counter++;
            }

            scanner1.close();

            //read from file2
            Scanner scanner2 = new Scanner(file2);
            while (scanner2.hasNextLine()) {
                String line = scanner2.nextLine();
                String[] coords = line.split(" ");
                listOfPointsX.add(Float.parseFloat(coords[0]));
                listOfPointsY.add(Float.parseFloat(coords[1]));
            }

            scanner2.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //calculate
        for (int i = 0; i < listOfRadius.size(); i++) {
            float x = listOfCenterX.get(i);
            float y = listOfCenterY.get(i);
            float r = listOfRadius.get(i);
            float a = listOfPointsX.get(i);
            float b = listOfPointsY.get(i);

            if(((a - x) * (a - x) + (b - y) * (b - y)) < r * r) {
                System.out.println("1\n");
            }
            if(((a - x) * (a - x) + (b - y) * (b - y)) == r * r) {
                System.out.println("0\n");
            }
            if(((a - x) * (a - x) + (b - y) * (b - y)) > r * r) {
                System.out.println("2\n");
            }
        }

    }
}