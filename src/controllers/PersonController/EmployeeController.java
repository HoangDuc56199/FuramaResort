package controllers.PersonController;

import services.PersonService.EmployeeService;

import java.util.Scanner;

public class EmployeeController {
    Scanner SCANNER = new Scanner(System.in);
    EmployeeService employeeService = new EmployeeService();
    public void controller() {
        while (true){
            try{
                System.out.println("Please input your choice !");
                System.out.println("""
                1.Add Employee\s
                2.Show all\s
                3.Update\s
                4.Delete\s
                5.Back to main menu""");
                String input = SCANNER.nextLine();
                int choose = Integer.parseInt(input);
                if (choose > 5 || choose < 1) {
                    System.out.println("Please input 1 to 5");
                    continue;
                }
                switch (choose) {
                    case 1:
                        employeeService.save();
                        break;
                    case 2:
                        employeeService.findAll();
                        break;
                    case 3:
                        employeeService.update();
                        break;
                    case 4:
                        employeeService.delete();
                        break;
                    case 5: return;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }



    }
}
