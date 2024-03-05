package controllers.FacilityController;

import java.util.Scanner;

public class FacilityController {
    private Scanner SCANNER = new Scanner(System.in);
    public void controller(){
        while (true){
            try {

                System.out.println("Please input your choice !");
                System.out.println("""
                        1.Display list facility\s
                        2.Add new facility\s
                        3.Display list facility maintenance\s
                        4.Return main menu""");
                String input = SCANNER.nextLine();
                int choose = Integer.parseInt(input);
                if (choose > 5 || choose < 1) {
                    System.out.println("Please input 1 to 4");
                    continue;
                }
                switch (choose) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4: return;
                    default:
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
    };
}
