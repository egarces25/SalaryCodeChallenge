package com.salarycalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Execute {
      

    public static void fileExtract() {
        //local variables
        String line;
        String name;
        String role;
        int rate;
        int hour;
        List<CSV> list = new ArrayList<>();

        Calculation cal = new Calculation();





        try {
            System.out.println("Welcome to the salary calculator");
            String choice;

            // do while loop to allow the user to be able input different CSV files
            do {
                Scanner input = new Scanner(System.in);


                System.out.println("Enter CSV file");


                BufferedReader sc = new BufferedReader(new FileReader(input.nextLine()));


                    // Calculation option for the user
                    System.out.println("How would you like to calculate the summary: ");
                    System.out.println("a. Total Salary in dollars");
                    System.out.println("b. Total Salary in dollars group by role");
                System.out.println("c. Sort name");
                    System.out.println("q. Close application");
                    choice = input.nextLine();
                while ((line = sc.readLine()) != null) {
                    String[] employee;

                    //  " | " is a special character so you need to "\\|" to be able to split information
                    // on the CSV file
                    employee = line.split("\\|");

                    name = employee[0];
                    rate= Integer.parseInt(employee[1]);
                    hour = Integer.parseInt(employee[2]);
                    role = employee[3];
                    list.add(new CSV(name,rate,hour,role));
                }

                    if (choice.equals("a") || choice.equals("A")) {
                        System.out.println(cal.getCollect(list));
                    } else if (choice.equals("b") || choice.equals("B")) {
                        System.out.println(cal.salary(list));
                    } else if(choice.equals("c") || choice.equals("C"))
                    {

                        System.out.println(list.stream().map(CSV::getName).collect(Collectors.toList()));

                    }


                  //Give the user a chance to input another CSV
                  System.out.println("Press Enter if you would like to check another CSV? If not press q....");
                choice = input.nextLine();

            }while(!(choice.equals("q"))  && !(choice.equals("Q")));

           System.out.println("Good bye");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


