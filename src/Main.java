import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Name: Nikhil Mehta");
        System.out.println("Email: nmm5520@psu.edu");
        System.out.println("Course: IST 311");
        System.out.println("Assignment: IA01");

        Scanner userInput = new Scanner(System.in);
        String cont = "1";
        ArrayList<Float> grades = new ArrayList<Float>();

        do {
            String newInput;

            while (true) {
                System.out.println("Enter a grade: ");
                newInput = userInput.nextLine();
                cont = newInput;

                float newGrade = Float.parseFloat(newInput);

                if ((newGrade >= 0.0 && newGrade <= 100.0) && !cont.equals("-1")) {
                    grades.add(newGrade);
                    break;
                }

                else if ((newGrade < 0.0 || newGrade > 100.0) && !cont.equals("-1")) {
                    System.out.println("Error. Grade must be between 0 and 100; or -1 to finish");
                    break;
                }

                else if (cont.equals("-1")) {
                    break;
                }
            }

        } while (!cont.equals("-1"));
    }
}
