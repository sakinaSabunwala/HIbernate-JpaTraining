package com.mycompany.hibernatemapping.driver;

import com.mycompany.hibernatemapping.dao.StudentDetailsDao;
import com.mycompany.hibernatemapping.entity.Address;
import com.mycompany.hibernatemapping.entity.Education;
import com.mycompany.hibernatemapping.entity.Student;
import java.util.Scanner;

/**
 *
 * @author sakina
 */
public class DriverClass {
    
    public static void main(String[] args) {
        
        StudentDetailsDao studentDetailsDao = new StudentDetailsDao();
        
        Address address = new Address("streetUDP","streetUD","UDP","RAJ","IND");
        
        Education education = new Education("Full-Time","full day in college",2019L,"sararpura");
        
        Student student = new Student("sakina",
                                      "sabunwala",
                                      "ss",
                                      "sabunwala",
                                      "ssabunwala@argusoft.in",
                                      address,education);
        
        studentDetailsDao.saveDetails(student);
        System.out.println("student details added");
        
    }
    
}
