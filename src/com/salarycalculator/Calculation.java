package com.salarycalculator;

// This class will have all the methods to calculate the salary

public class Calculation {
    //Instance Variable
     final int weeks =52;
     final int bonus = 10000;
    int total=0;

    // This method is for Total salary in dollars
     public int salary(int rate, int hour)
     {
         total = rate * hour * weeks;
         return total;
     }

     //This method is for Total salary in dollars grouped by role
    public int salary(int rate, int hour, String role)
    {

        if(role.equalsIgnoreCase("PART TIME"))
        {
            total = hour * rate * weeks;
        }
        else if(role.equalsIgnoreCase("FULL TIME"))
        {
            if(hour * rate * weeks > 50000)
            {
                System.out.println("Full time Employees cap at 50000");
                total = 50000;
            }else
                {
                    total = hour * rate * weeks;
                }
        } else if (role.equalsIgnoreCase("Contract"))
        {
            total = 10000 + (hour * rate * 52);
        }else
        {
            System.out.println("Incorrect Role. Please check information in document");
        }


        return total;
    }

}
