package controllers;

import controllers.FacilityController.FacilityController;
import controllers.PersonController.CustomerController;
import controllers.PersonController.EmployeeController;

import java.util.Scanner;

public class FuramaController {
    private Scanner SCANNER = new Scanner(System.in);
    CustomerController customerController = new CustomerController();
    EmployeeController employeeController = new EmployeeController();
    FacilityController facilityController = new FacilityController();
    public void displayMainMenu(){
        while (true){
            try {
                System.out.println("choose one option");
                System.out.println("          1. Employee Management");
                System.out.println("          2. Custommer Management");
                System.out.println("          3. Facility Management");
                System.out.println("          4. Booking  Management");
                System.out.println("          5. Promotion Management");
                System.out.println("          6. Exit");
                String input = SCANNER.nextLine();
                int choose = Integer.parseInt(input);
                if (choose > 6 || choose < 1) {
                    System.out.println("Please input 1 to 6");
                    continue;
                }
                switch (choose) {
                    case 1: employeeController.controller();break;
                    case 2: customerController.controller();break;
                    case 3: facilityController.controller(); break;
                    case 4: break;
                    case 5: break;
                    case 6:
                        System.out.println("Stop app......"); return;
                    default:
                        break;
                }
            }   catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }

        }

    }
}
