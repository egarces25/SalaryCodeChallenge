package com.salarycalculator;

import java.util.Objects;

public class CSV implements Comparable {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CSV csv = (CSV) o;
        return rate == csv.rate && hour == csv.hour && name.equals(csv.name) && role.equals(csv.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rate, hour, role);
    }

    @Override
    public String toString() {
        return "CSV{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", hour=" + hour +
                ", role='" + role + '\'' +
                '}';
    }

    private final String name;
    private final int rate;
    private final int hour;
    private final String role;
    public CSV(String name, int rate, int hour, String role) {
        this.name = name;
        this.rate = rate;
        this.hour = hour;
        this.role = role;
    }






    public String getName() {
        return name;
    }



    public int getRate() {
        return rate;
    }



    public int getHour() {
        return hour;
    }



    public String getRole() {
        return role;
    }






    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((CSV)o).getName());
    }
}
