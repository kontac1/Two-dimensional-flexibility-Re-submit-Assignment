package ckonta_lab1;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * this program will create a 2d array based on user input
 * and fill the array with random numbers; additionally
 * calculate the total values of row and column before
 * printing the values
 *
 * @author cheickamadoukonta
 * @version 1.0
 */
public class TwoDimArray {
    /**
     * Main function to collect user input and pass it
     * as argument into fillArray function to conducts
     * calculation
     *
     * @param args contain command line argument
     */
    public static void main(String[] args) {
        //declaring row variable
        int row;
        //declaring varaible for repeat option
        char choice;
        //storing input for repeat option
        String line;

        //create scanner object
        Scanner input = new Scanner(System.in);
        //do function to allow user to repeat the program
        do {
            //collect integers from user
            System.out.print("Enter the number of row (between 2 to 10): ");
            row = input.nextInt();

            //validation user input
            while (row > 10 || row < 2) {
                System.out.print("Enter the number of row (between 2 to 10): ");
                row = input.nextInt();
            }

            //call  fillArray function
            fillArray(row);
            //new line
            System.out.println();
            //prompt user option to try again
            System.out.print("\n" + "Will you like to try again" + "(" + "Y/N"
                    + "): ");
            //line to capture user input
            line = input.next();
            //store characters
            choice = line.charAt(0);

         //loop around the program
        }while( choice == 'y' || choice == 'Y');

        //print new line
        System.out.println();

    }

    /**
     *  fillArray function to print array values and
     *  totals
     * @param row number pass by main function
     */
    private static void fillArray(int row) {

        //declaring and assigning variables
        int i = 0, j = 0 , rowTotal = 0, colTotal = 0;
        //creating array object
        int[][] array = new int[row][row];
        //loop to generate random number
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array.length; j++) {
                array[i][j] = (int) (Math.random() * 12);
            }
        }

        //loop to print array value and row total
        for (i = 0; i < array.length; i++) {
            //print new line
            System.out.println();
            //asigning row total to zero
            rowTotal = 0;
            //loop to print array values
            for (j = 0; j < array.length; j++) {
                //print array values
                System.out.print("\t" + array[i][j]);
                //calcualte row total
                rowTotal += array[i][j];
            }
            //print row totals
            System.out.print("\t" + "= " + rowTotal);
        }
        //assigning diagonal total value
        int diagTotal = 0;
        //loop to calculate diagonal total value
        for(i = 0; i < array.length; i++) {
            diagTotal += array[i][i];
        }
        //initiating total right diagonal value to 0
        int rightDiag = 0;
        //for loop to calculate value
        for (i = 0; i < array.length; i++) {
            rightDiag += array[i][(array.length - 1) - i];
        }
        //new line
        System.out.println();
        //print rightDiagonal total value
        System.out.print(rightDiag);

        //for loop to calculate and print column value
        for ( i = 0; i < array.length; i++) {
            //start column totla value at 0
            colTotal = 0;
            //for loop to get value of row
            for (j = 0; j < array.length; j++) {
                //calculate column total value
                colTotal += array[j][i];
            }
            //print column total
            System.out.print("\t" + colTotal);
        }
        //print diagonal right value
        System.out.print("\t" + "  " + diagTotal);

    }
}
