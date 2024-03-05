package controllers.PersonController;

import services.PersonService.CustomerService;

import java.util.Scanner;

public class CustomerController {
    CustomerService customerService = new CustomerService();
    private Scanner SCANNER = new Scanner(System.in);




        public void controller() {
            while (true){
                try{
                    System.out.println("Please input your choice !");
                    System.out.println("""
                        1.Add Customer\s
                        2.Show all\s
                        3.Update\s
                        4.Delete\s
                        5.Back to main menu""");
                    String input = SCANNER.nextLine();
                    int choose = Integer.parseInt(input);
                    if (choose > 5 || choose < 1) {
                        System.out.println("Please input 1 to 4");
                        continue;
                    }
                    switch (choose) {
                        case 1:
                            customerService.save();
                            break;
                        case 2:
                            customerService.findAll();
                            break;
                        case 3:
                            customerService.update();
                            break;
                        case 4:
                            customerService.delete();
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
