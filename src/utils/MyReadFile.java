package utils;



import models.Person.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyReadFile {
    private List<String> readFile(String path) {
        List<String> strings = new ArrayList<>();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line!=null){
                    strings.add(line);
                }
            }
            return strings;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return strings;
    }

    public List<Customer> readFileCustomer(String path) {
        List<Customer> customerList = new ArrayList<>();

        List<String> strings = readFile(path);

        String[] array;
        for (String string : strings) {
            array = string.split(",");
            customerList.add(
                    new Customer(Long.parseLong(array[0]),
                            array[1],
                            array[2],
                            array[3],
                            array[4],
                            array[5],
                            array[6],
                            array[7],
                            CustomerType.valueOf(array[8]),
                            array[9]));
        }


        return customerList;
    }
    public List<Employee> readFileEmployee(String path) {
        List<Employee> employeeList = new ArrayList<>();

        List<String> strings = readFile(path);

        String[] array;
        for (String string : strings) {
            array = string.split(",");
            employeeList.add(
                    new Employee(Long.parseLong(array[0]),
                            array[1],
                            array[2],
                            array[3],
                            array[4],
                            array[5],
                            array[6],
                            Level.valueOf(array[7]),
                            Position.valueOf(array[8]),
                            Double.parseDouble(array[9])));
        }


        return employeeList;
    }

}
