package com.salarycalculator;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Execute {


    public static void fileExtract() {
        //local variables
        String line = "";
        String name ="";
        String Role= "";
        Integer rate = 0;
        Integer hour= 0;

        Calculation cal = new Calculation();
        String[] employee = new String[0];


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
                    System.out.println("q. Close application");
                    choice = input.nextLine();
                while ((line = sc.readLine()) != null) {

                    //  " | " is a special character so you need to "\\|" to be able to split information
                    // on the CSV file
                    employee = line.split("\\|");
                    if (choice.equals("a") || choice.equals("A")) {
                        System.out.println("Name = " + employee[0] +", "+" Salary = " + cal.salary( rate.parseInt(employee[1]), hour.parseInt(employee[2])));
                    } else if (choice.equals("b") || choice.equals("B")) {
                        System.out.println("Name = " + employee[0] +", "+ " Salary = " + cal.salary(rate.parseInt(employee[1]), hour.parseInt(employee[2]), employee[3]) +", "+ " Role = " + employee[3]);

                    }
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


