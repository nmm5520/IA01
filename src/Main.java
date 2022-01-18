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

                float newGrade = Float.parseFloat(newInput);

                if ((newGrade >= 0.0 && newGrade <= 100.0) && !cont.equals("-1")) {
                    validGrades.add(newGrade);
                    break;
                }

                else if ((newGrade < 0.0 || newGrade > 100.0) && !cont.equals("-1")) {
                    System.out.print("Error. Grade must be between 0 and 100; or -1 to finish\n");
                    invalidGrades.add((newGrade));
                    break;
                }

                else if (cont.equals("-1")) {
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

        for (Float grade: validGrades) {
            sum += grade;
        }

        float averageGrade = (sum/newTotal);

        System.out.println();
        System.out.printf("You entered %s valid grades.\n", validGrades.size());
        System.out.printf("You entered %s invalid grades.\n", invalidGrades.size());
        System.out.println();

        System.out.printf("Highest grade: %s (%s) \n", maxGrade,letterGrade(maxGrade));
        System.out.printf("Lowest grade: %s (%s) \n", minGrade, letterGrade(minGrade));
        System.out.printf("Average: %s (%s) \n", averageGrade, letterGrade(averageGrade));
        System.out.println();

        System.out.printf("Here are the %s valid grades:\n", validGrades.size());
        for (float grade: validGrades) {
            System.out.printf("%s (%s)\n\n", grade, letterGrade(grade));
        }

        System.out.printf("Here are the %s invalid grades:\n", invalidGrades.size());
        for (float grade: invalidGrades) {
            System.out.printf("%s\n", grade);
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
}
