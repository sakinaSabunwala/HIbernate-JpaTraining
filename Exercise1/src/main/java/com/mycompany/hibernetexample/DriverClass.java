/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernetexample;

import com.mycompany.dao.HelloWorldDao;
import com.mycompany.model.HelloWorld;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sakina
 */
public class DriverClass {

    public static void main(String[] args) {

        HelloWorldDao helloWorldDao = new HelloWorldDao();
        Scanner sc = new Scanner(System.in);

        //save data
        System.out.println("Enter message:");
        String msg = sc.nextLine();
        if (msg == null) {
            System.out.println("Provide valid message..");

        } else {
            HelloWorld helloWorld = new HelloWorld(msg);
            helloWorldDao.saveMessage(helloWorld);
            System.out.println("Message added..");
        }

        //retrieve data
        List<HelloWorld> messages = helloWorldDao.getMessages();
        messages.forEach(s -> System.out.println(s.getMessage()));

    }

}
