package com.salarycalculator;

// This class will have all the methods to calculate the salary

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Calculation {
    //made them private because variable do not need to be used in another class
     private final int weeks =52;
     private final int bonus = 10000;
     List<String> summary = new ArrayList<>();
    List<String> summary2 = new ArrayList<>();
    List<String> summary3= new ArrayList<>();
    // This method is for Total salary in dollars
    public List<String> getCollect(List<CSV> list) {
        return list.stream().map(x-> x.getName()+" $"+ (x.getHour() * x.getRate()) * weeks).collect(Collectors.toList());
    }

     //This method is for Total salary in dollars grouped by role
    public List<String> salary(List<CSV> list)
    {

                summary =   list.stream().filter(x -> x.getRole().equalsIgnoreCase("Part Time")).map(x -> x.getName() + " $" + ((x.getHour() * x.getRate()) * weeks)+ " " + x.getRole()).collect(Collectors.toList());

                summary2 = list.stream().filter(x -> x.getRole().equalsIgnoreCase("Full Time")).filter(x -> ((x.getHour() * x.getRate()) * weeks) < 50000).map(x -> x.getName() + " $" + ((x.getHour() * x.getRate()) * weeks)+ " " + x.getRole()).collect(Collectors.toList());

                summary3 = list.stream().filter(x -> x.getRole().equalsIgnoreCase("Contract")).map(x -> x.getName() + " $" + (((x.getHour() * x.getRate()) * weeks) + bonus)  + " " + x.getRole()).collect(Collectors.toList());
                List<String> newList = Stream.of(summary,summary2,summary3).flatMap(Collection::stream).collect(Collectors.toList());


        return newList;
    }






}
