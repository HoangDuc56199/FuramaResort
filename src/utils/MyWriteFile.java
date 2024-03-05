package utils;


import models.Person.Customer;
import models.Person.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class MyWriteFile {
    private void writeFile(String path, String data) {
        File file = new File(path);
        try {
            Writer writeFile = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writeFile);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeCustomerFile(String path, List<Customer> customerList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : customerList) {
            stringBuilder.append(customer.getInfo());
        }
        writeFile(path, String.valueOf(stringBuilder));
    }
    public void writeEmployeeFile(String path, List<Employee> employeeList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee employee : employeeList) {
            stringBuilder.append(employee.getInfo());
        }
        writeFile(path, String.valueOf(stringBuilder));
    }
}
