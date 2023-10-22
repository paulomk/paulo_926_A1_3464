import java.util.Scanner;
import java.text.DecimalFormat;


public class Main {
    private static DecimalFormat df = new DecimalFormat("#.000");

    public static void main(String args[]) {

        int[] residentialsCoordinates = {9, 30, 18, 8, 3, 18, 25, 36};

        // read data
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the x coordinate of the discharge: ");
        int x = keyboard.nextInt();
        System.out.print("Enter the y coordinate of the discharge: ");
        int y = keyboard.nextInt();

        // find the coordinates of the nearest home
        // (identified by the corresponding index in the table of coordinates)
        int closest = Discharge.closest(x, y, residentialsCoordinates);
        System.out.println("--- Question 1 ---");
        System.out.println("Coordinates of the nearest home to the discharge:");
        System.out.println("(" + residentialsCoordinates[closest * 2] + "," + residentialsCoordinates[closest * 2 + 1]
                + ") ; distance = " +
                df.format(Discharge.calculateDistance(x, y, residentialsCoordinates[closest * 2],
                        residentialsCoordinates[closest * 2 + 1]))
                + " meters");

        // find the coordinates of the 3 nearest houses and show the coordinates

        System.out.println("--- Question 2 ---");
        System.out.println("Coordinates of the 3 houses closest to the discharge:");
        Discharge.showThreeClosest(x, y, residentialsCoordinates);

        // show the center of gravity of the 3 closest (the best place)
        int[] center = Discharge.bestPlace(x, y, residentialsCoordinates);
        System.out.println("--- Question 3 ---");
        System.out.println("Coordinates of the best place for the discharge:");
        System.out.println("(" + center[0] + "," + center[1] + ")");
        keyboard.close();
    }
}