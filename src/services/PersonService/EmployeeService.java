package services.PersonService;

import models.Person.Employee;
import models.Person.Level;
import models.Person.Position;
import services.IService;
import utils.MyReadFile;
import utils.MyWriteFile;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IService {
    private MyWriteFile myWriteFile = new MyWriteFile();
    private MyReadFile myReadFile = new MyReadFile();
    private Scanner SCANNER = new Scanner(System.in);
    private String DATA_PATH ="src/data/employee.csv";
    public void findAll(){
        List<Employee> employees = myReadFile.readFileEmployee(DATA_PATH);
        for (int i =0;i<employees.size();i++){
            System.out.println(i+1 + "." + employees.get(i).toString());
        };
    };
    private String getLevel() {
        String[] level = {
                String.valueOf(Level.TrungCap),
                String.valueOf(Level.CaoDang),
                String.valueOf(Level.DaiHoc),
                String.valueOf(Level.SauDaiHoc)
        };
        while (true) {
            try {
                System.out.println("Please choose level type \n" +
                        "1.TrungCap \n" +
                        "2.CaoDang\n" +
                        "3.DaiHoc\n" +
                        "4.SauDaiHoc\n"
                );
                String input = SCANNER.nextLine();
                int choose = Integer.parseInt(input);
                if (choose > 4 || choose < 1) {
                    System.out.println("Please input 1 to 4");
                    continue;
                }
                return level[choose - 1];
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
    };
    private String getPosition() {
        String[] position = {
                String.valueOf(Position.LeTan),
                String.valueOf(Position.PhucVu),
                String.valueOf(Position.ChuyenVien),
                String.valueOf(Position.GiamSat),
                String.valueOf(Position.QuanLy),
                String.valueOf(Position.GiamDoc)
        };
        while (true) {
            try {
                System.out.println("Please choose position \n" +
                        "1.LeTan \n" +
                        "2.PhucVu\n" +
                        "3.ChuyenVien\n" +
                        "4.GiamSat\n"+
                        "5.QuanLy\n"+
                        "6.GiamDoc\n"
                );
                String input = SCANNER.nextLine();
                int choose = Integer.parseInt(input);
                if (choose > 6 || choose < 1) {
                    System.out.println("Please input 1 to 4");
                    continue;
                }
                return position[choose - 1];
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
    };
    private double getSalary(){
        while (true){
            try {
                System.out.println("Please input salary ");
                String salary = SCANNER.nextLine();
                double salaryConvert = Double.parseDouble(salary);
                return salaryConvert;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }


    };
    public Employee getInfo() {
        System.out.println("Please input name ");
        String fullname = SCANNER.nextLine();
        System.out.println("Please input date of birth ");
        String  dateOfBirth= SCANNER.nextLine();
        System.out.println("Please input gender ");
        String  gender= SCANNER.nextLine();
        System.out.println("Please input phone number ");
        String  phoneNumber= SCANNER.nextLine();
        System.out.println("Please input numberOfIdentityCard ");
        String  numberOfIdentityCard= SCANNER.nextLine();
        System.out.println("Please input email ");
        String email = SCANNER.nextLine();
        String level = getLevel();
        String position = getPosition();
        double salary = getSalary();
        return new Employee(fullname,dateOfBirth,gender,phoneNumber,numberOfIdentityCard,email, Level.valueOf(level),Position.valueOf(position),salary);
    }


    @Override
    public void save() {
        List<Employee> employees = myReadFile.readFileEmployee(DATA_PATH);
        long id = employees.get(employees.size()-1).getId()+1;
        Employee Employee = getInfo();
        Employee.setId(id);
        employees.add(Employee);
        myWriteFile.writeEmployeeFile(DATA_PATH,employees);
    }
    private Employee chooseFeild(int numberical){
      List<Employee> employees = myReadFile.readFileEmployee(DATA_PATH);
      Employee employee = employees.get(numberical-1);
      while (true){
          try{
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
                      employee.setFullName(SCANNER.nextLine());
                      break;
                  case 2:
                      System.out.println("Input date of birth to edit:");
                      employee.setDateOfBirth(SCANNER.nextLine());
                      break;
                  case 3:
                      System.out.println("Input gender to edit:");
                      employee.setGender(SCANNER.nextLine());
                      break;
                  case 4:
                      System.out.println("Input phone number to edit:");
                      employee.setPhoneNumber(SCANNER.nextLine());
                      break;
                  case 5:
                      System.out.println("Input number of identify card to edit:");
                      employee.setNumberOfIdentityCard(SCANNER.nextLine());
                      break;
                  case 6:
                      System.out.println("Input email to edit:");
                      employee.setEmail(SCANNER.nextLine());
                      break;
                  case 7:
                      employee.setLevel(Level.valueOf(getLevel()));
                  case 8:
                      System.out.println("Input customer type to edit:");
                      employee.setPosition(Position.valueOf(getPosition()));
                      break;
                  case 9:
                      System.out.println("Input address to edit:");
                      employee.setSalary(getSalary());
                      break;
              };
          }catch (NumberFormatException e) {
              System.out.println("Please enter a number");
          }
          return employee;
      }


    };

    @Override
    public void update() {
        findAll();
        List<Employee> employees = myReadFile.readFileEmployee(DATA_PATH);
        while (true) {
            try {
                System.out.println("please choice customer numerical order to edit");
                String input = SCANNER.nextLine();
                int choose = Integer.parseInt(input);
                if (choose > employees.size() || choose < 1) {
                    System.out.println("Please input 1 to " + employees.size());
                    continue;
                }
                employees.set(choose-1,chooseFeild(choose));
                myWriteFile.writeEmployeeFile(DATA_PATH, employees);
                System.out.println("-------update success-------");
                break;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }


    }

    @Override
    public void delete() {
        findAll();
        List<Employee> employees = myReadFile.readFileEmployee(DATA_PATH);
        while (true){
            try {
                System.out.println("please choice employee numerical order to delete");
                String input = SCANNER.nextLine();
                int choose = Integer.parseInt(input);
                if (choose > employees.size() || choose < 1) {
                    System.out.println("Please input 1 to "+employees.size());
                    continue;
                }
                employees.remove(choose-1);
                myWriteFile.writeEmployeeFile(DATA_PATH, employees);
                break;
            }catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
    }
}
