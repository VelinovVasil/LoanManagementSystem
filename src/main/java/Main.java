import controller.Controller;
import controller.ControllerImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Controller controller = new ControllerImpl();

        String[] input = scanner.nextLine().split(" ");

        while (!input.equals("End")) {

            String output = null;

            try {

                if (input[0].equals("addClient")) {

                    output = controller.addClient(input[1], input[2], Double.parseDouble(input[3]));

                } else if (input[0].equals("removeClient")) {

                    output = controller.removeClient(input[1]);

                } else if (input[0].equals("offer")) {

                    output = controller.offer(input[1], Double.parseDouble(input[2]), Integer.parseInt(input[3]));

                } else if (input[0].equals("newLoan")) {

                    output = controller.newLoan(input[1], Double.parseDouble(input[2]), Integer.parseInt(input[3]));

                } else if (input[0].equals("monthlyPayment")) {

                    output = controller.monthlyPayment(input[1]);

                } else {

                    throw new IllegalArgumentException("Invalid command");

                }
            } catch (Exception e) {
                output = e.getMessage();
            }

            System.out.println(output);

            input = scanner.nextLine().split(" ");
        }
    }
}
