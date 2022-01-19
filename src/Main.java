import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Name: Nikhil Mehta");
        System.out.println("Email: nmm5520@psu.edu");
        System.out.println("Course: IST 311");
        System.out.println("Assignment: IA01");
        System.out.println();

        Scanner userInput = new Scanner(System.in);
        String cont = "1";
        ArrayList<Float> validGrades = new ArrayList<Float>();
        ArrayList<Float> invalidGrades = new ArrayList<Float>();

        do {
            String newInput;

            while (true) {
                System.out.print("Enter a grade: ");
                newInput = userInput.nextLine();
                cont = newInput;

                /*
                  https://www.geeksforgeeks.org/float-parsefloat-method-in-java-with-examples/

                  I used this source to learn how to use parseFloat.
                  I have previously used parseInt, but did not know how to parse input for a float.
                  I decided to parse the input for a float because the input also includes grades with decimals.
                 */
                float newGrade = Float.parseFloat(newInput);

                if ((newGrade >= 0.0 && newGrade <= 100.0) && !cont.equals("-1")) {
                    validGrades.add(newGrade);
                    break;
                } else if ((newGrade < 0.0 || newGrade > 100.0) && !cont.equals("-1")) {
                    System.out.print("Error. Grade must be between 0 and 100; or -1 to finish\n");
                    invalidGrades.add((newGrade));
                    break;
                } else if (cont.equals("-1")) {
                    break;
                }
            }

        } while (!cont.equals("-1"));


        Float maxGrade = Collections.max(validGrades);
        int maxIndex = validGrades.indexOf(maxGrade);
        Float minGrade = Collections.min(validGrades);
        int minIndex = validGrades.indexOf(minGrade);

        int total = validGrades.size();
        float newTotal = total;
        float sum = 0;

        for (Float grade : validGrades) {
            sum += grade;
        }

        float averageGrade = (sum / newTotal);

        System.out.println();
        System.out.printf("You entered %s valid grades.\n", validGrades.size());
        System.out.printf("You entered %s invalid grades.\n", invalidGrades.size());
        System.out.println();

        System.out.printf("Highest grade: %s (%s) \n", wholeNumFinder(maxGrade), letterGrade(maxGrade));
        System.out.printf("Lowest grade: %s (%s) \n", wholeNumFinder(minGrade), letterGrade(minGrade));
        System.out.printf("Average: %s (%s) \n", wholeNumFinder(averageGrade), letterGrade(averageGrade));
        System.out.println();

        System.out.printf("Here are the %s valid grades:\n", validGrades.size());
        for (float grade : validGrades) {
            System.out.printf("%s (%s)\n", wholeNumFinder(grade), letterGrade(grade));
        }

        System.out.println();
        System.out.printf("Here are the %s invalid grades:\n", invalidGrades.size());
        for (float grade : invalidGrades) {
            System.out.printf("%s\n", wholeNumFinder(grade));
        }
    }

    static String letterGrade(float grade) {

        String actualGrade = null;

        if (grade >= 93.0 && grade <= 100.0) {
            actualGrade = ("A");
        } else if (grade >= 90.0 && grade <= 92.9) {
            actualGrade = ("A-");
        } else if (grade >= 87.0 && grade <= 89.9) {
            actualGrade = ("B+");
        } else if (grade >= 83.0 && grade <= 86.9) {
            actualGrade = ("B");
        } else if (grade >= 80.0 && grade <= 82.9) {
            actualGrade = ("B-");
        } else if (grade >= 77.0 && grade <= 79.9) {
            actualGrade = ("C+");
        } else if (grade >= 70.0 && grade <= 76.9) {
            actualGrade = ("C");
        } else if (grade >= 60.0 && grade <= 69.9) {
            actualGrade = ("D");
        } else if (grade >= 0.00 && grade <= 59.9) {
            actualGrade = ("F");
        }

        return (actualGrade);
    }

    static String wholeNumFinder(float num) {
        /*
          https://stackoverflow.com/questions/14799943/how-to-check-if-number-is-a-decimal#:~:text=Use%20the%20modulus%20operator%20to%20check%20if%20there%20is%20a%20remainder.&text=int%20will%20not%20hold%20a,if%20decimals%20are%20being%20dropped.

          I used this stackoverflow forum discussion to find how to determine if a number was whole, meaning without any numbers after the
          decimal.
          By used the modulus operator, we can determine if a number can be represented as an integer by doing Mod(0).
          A whole number will return 0, without any decimals. Any float that has numbers after the decimal will return a number other than 0.
         */

        String newNum = null;
        if (num % 1 == 0) {
            newNum = String.format("%.0f", num);
        } else {
            newNum = Float.toString(num);
        }

        return (newNum);
    }

}
