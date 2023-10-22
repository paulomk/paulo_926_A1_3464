import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Discharge {
    private static DecimalFormat df = new DecimalFormat("#.000");


    /*******************************************
     * Complete your code between these lines.
     *******************************************/

    public static double calculateDistance(int x1, int y1, int x2, int y2){
        return (Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2)));
    }

    public static int closest(int x, int y, int[] residentialsCoordinates){
        int closest = 0;
        double previous = Double.MAX_VALUE;
        double current;
        for (int i = 0; i < residentialsCoordinates.length; i += 2){
            current = calculateDistance(x, y, residentialsCoordinates[i], residentialsCoordinates[i+1]);
            if (current < previous) {
                previous = current;
                closest = i/2;
            }
        }
        return closest;
    }

    public static int[] threeClosest(int x, int y, int[] residentialsCoordinates){
        int[] result = new int[3];
        int[] temporaryArray = residentialsCoordinates.clone();
        for (int i = 0; i < result.length; i++){
            result[i] = closest(x, y, temporaryArray);
            System.out.println(result[i]);
            temporaryArray[result[i]*2] = Integer.MAX_VALUE;
            temporaryArray[result[i]*2+1] = Integer.MAX_VALUE;
        }
        return result;
    }

    public static int[] bestPlace(int x, int y, int[] residentialsCoordinates){
        int[] result = new int[2];
        int[] threeBestCoord = threeClosest(x, y, residentialsCoordinates);
        int tempX = 0;
        int tempY = 0;

        for (int i = 0; i < threeBestCoord.length; i++){
            tempX += residentialsCoordinates[i*2];
            tempY += residentialsCoordinates[i*2+1];
        }
        result[0] = tempX / 3;
        result[1]= tempY / 3;
        return result;
    }
    /*******************************************
     *******************************************/

    public static void showThreeClosest(int x, int y, int[] residentialsCoordinates) {
        int[] tpp = threeClosest(x, y, residentialsCoordinates);

        System.out.println("(" + x + "," + y + ") is a :");
        for (int i = 0; i < 3; i++) {
            System.out.println("    " + df.format(calculateDistance(x, y, tpp[i]*2, tpp[i]*2+1)) + " of ("
                    + residentialsCoordinates[tpp[i]*2] + "," + residentialsCoordinates[tpp[i]*2+1] + ")");
        }
    }

    // PROGRAMM PRINCIPAL
//    public static void main(String args[]) {
//
//        int[] residentialsCoordinates = {
//                9, 30, 18, 8, 3, 18, 25, 36
//        };
//
//        // read data
//        Scanner keyboard = new Scanner(System.in);
//        System.out.print("Enter the x coordinate of the discharge: ");
//        int x = keyboard.nextInt();
//        System.out.print("Enter the y coordinate of the discharge: ");
//        int y = keyboard.nextInt();
//
//        // find the coordinates of the nearest home
//        // (identified by the corresponding index in the table of coordinates)
//        int closest = closest(x, y, residentialsCoordinates);
//        System.out.println("--- Question 1 ---");
//        System.out.println("Coordinates of the nearest home to the discharge:");
//        System.out.println("(" + residentialsCoordinates[closest * 2] + "," + residentialsCoordinates[closest * 2 + 1]
//                + ") ; distance = " +
//                df.format(calculateDistance(x, y, residentialsCoordinates[closest * 2],
//                        residentialsCoordinates[closest * 2 + 1]))
//                + " meters");
//
//        // find the coordinates of the 3 nearest houses and show the coordinates
//
//        System.out.println("--- Question 2 ---");
//        System.out.println("Coordinates of the 3 houses closest to the discharge:");
//        showThreeClosest(x, y, residentialsCoordinates);
//
//        // show the center of gravity of the 3 closest (the best place)
//        int[] center = bestPlace(x, y, residentialsCoordinates);
//        System.out.println("--- Question 3 ---");
//        System.out.println("Coordinates of the best place for the discharge:");
//        System.out.println("(" + center[0] + "," + center[1] + ")");
//        keyboard.close();
//    }
}
