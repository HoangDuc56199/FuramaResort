package services.PersonService;


import models.Person.CustomerType;
import models.Person.Customer;
import services.IService;
import utils.MyReadFile;
import utils.MyWriteFile;

import java.util.List;
import java.util.Scanner;

public class CustomerService implements IService {
    private MyWriteFile myWriteFile = new MyWriteFile();
    private MyReadFile myReadFile = new MyReadFile();
    private Scanner SCANNER = new Scanner(System.in);
    private String DATA_PATH ="src/data/customer.csv";


    public CustomerService() {
    }
    public void findAll() {
        List<Customer> customers = myReadFile.readFileCustomer(DATA_PATH);
//
        for(int i =0;i<customers.size();i++){
            System.out.println(i+1 + "." + customers.get(i).toString());
        };
    }
    private String getCustomerType() {
        String[] customerTypes = {String.valueOf(CustomerType.Diamond),
                String.valueOf(CustomerType.Platinum),
                String.valueOf(CustomerType.Gold),
                String.valueOf(CustomerType.Silver),
                String.valueOf(CustomerType.Member)};
        while (true) {
            try {
                System.out.println("Please choose customer type \n" +
                        "1.Diamond \n" +
                        "2.Platinum\n" +
                        "3.Gold\n" +
                        "4.Silver\n" +
                        "5.Member\n"
                );
                String input = SCANNER.nextLine();
                int choose = Integer.parseInt(input);
                if (choose > 5 || choose < 1) {
                    System.out.println("Please input 1 to 5");
                    continue;
                }
                return customerTypes[choose - 1];
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
    }

    public Customer getInfo() {
        System.out.println("Please input name ");
        String fullname = SCANNER.nextLine();
        System.out.println("Please input date of birth ");
        String  dateOfBirth= SCANNER.nextLine();
        System.out.println("Please input gender ");
        String  gender= SCANNER.nextLine();
        System.out.println("Please input customerCode ");
        String  customerCode= SCANNER.nextLine();
        System.out.println("Please input phone number ");
        String  phoneNumber= SCANNER.nextLine();
        System.out.println("Please input numberOfIdentityCard ");
        String  numberOfIdentityCard= SCANNER.nextLine();
        System.out.println("Please input email ");
        String  email= SCANNER.nextLine();
        System.out.println("Please input customerType ");
        String  customerType= getCustomerType();
        System.out.println(customerType);
        System.out.println("Please input address ");
        String  address= SCANNER.nextLine();
        return new Customer(fullname,dateOfBirth, customerCode,gender,phoneNumber,numberOfIdentityCard,email, CustomerType.valueOf(customerType),address);

    }

    @Override
    public void save() {
        List<Customer> customers = myReadFile.readFileCustomer(DATA_PATH);
        long id = customers.get(customers.size() - 1).getId() + 1;
        Customer Customer = getInfo();
        Customer.setId(id);
        customers.add(Customer);
        myWriteFile.writeCustomerFile(DATA_PATH, customers);

    }

    private Customer chooseFeild(int numerical){
        List<Customer> customers = myReadFile.readFileCustomer(DATA_PATH);
        Customer customer = customers.get(numerical-1);
        boolean shouldStop = false;
        while (!shouldStop) {
            try {
                System.out.println("please choose feild to edit\n"+
                        "1. full name\n"+
                        "2. date of birth\n"+
                        "3. customer code\n"+
                        "4. gender\n"+
                        "5. phone number\n"+
                        "6. number of identify card\n"+
                        "7. email\n"+
                        "8. customer type\n"+
                        "9. address\n"
                );
                String input = SCANNER.nextLine();
                int choose = Integer.parseInt(input);
                if (choose > 9 || choose < 1) {
                    System.out.println("Please input 1 to 9");
                    continue;
                }
                switch (choose){
                    case 1:
                        System.out.println("Input full name to edit:");
                        customer.setFullName(SCANNER.nextLine());
                        break;
                    case 2:
                        System.out.println("Input date of birth to edit:");
                        customer.setDateOfBirth(SCANNER.nextLine());
                        break;
                    case 3:
                        System.out.println("Input customer code to edit:");
                        customer.setCustomerCode(SCANNER.nextLine());
                        break;
                    case 4:
                        System.out.println("Input gender to edit:");
                        customer.setGender(SCANNER.nextLine());
                        break;
                    case 5:
                        System.out.println("Input phone number to edit:");
                        customer.setPhoneNumber(SCANNER.nextLine());
                        break;
                    case 6:
                        System.out.println("Input number of identify card to edit:");
                        customer.setNumberOfIdentityCard(SCANNER.nextLine());
                        break;
                    case 7:
                        System.out.println("Input email to edit:");
                        customer.setEmail(SCANNER.nextLine());
                        break;
                    case 8:
                        System.out.println("Input customer type to edit:");
                        customer.setCustomerType(CustomerType.valueOf(getCustomerType()));
                        break;
                    case 9:
                        System.out.println("Input address to edit:");
                        customer.setAddress(SCANNER.nextLine());
                        break;
                };
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
            shouldStop = true;


        }

    return customer;

    };


    @Override
    public void update() {
        findAll();
        List<Customer> customers = myReadFile.readFileCustomer(DATA_PATH);
        boolean shouldStop = false;
        while (!shouldStop) {
            try {
                System.out.println("please choice customer numerical order to edit");
                String input = SCANNER.nextLine();
                int choose = Integer.parseInt(input);
                if (choose > customers.size() || choose < 1) {
                    System.out.println("Please input 1 to "+customers.size());
                    continue;
                }
                customers.set(choose-1,chooseFeild(choose));
                myWriteFile.writeCustomerFile(DATA_PATH, customers);
                System.out.println("-------update success-------");

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
            shouldStop = true;
        }


    }

    @Override
    public void delete() {
        findAll();
        List<Customer> customers = myReadFile.readFileCustomer(DATA_PATH);
        boolean shouldStop = false;
        while (!shouldStop) {
            try {
                System.out.println("please choice customer numerical order to delete");
                String input = SCANNER.nextLine();
                int choose = Integer.parseInt(input);
                if (choose > customers.size() || choose < 1) {
                    System.out.println("Please input 1 to "+customers.size());
                    continue;
                }
                customers.remove(choose-1);
                myWriteFile.writeCustomerFile(DATA_PATH, customers);


            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
            shouldStop = true;
        }
    }
}
