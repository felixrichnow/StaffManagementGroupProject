package suntec;

import java.util.ArrayList;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private int id;
    private String gender;
    private double bonus;
    protected double experience;
    protected double nWorkingHours;


    public Employee(String firstName,String lastName,int id,String gender, double experience,double numberOfWorkingHours){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gender = gender;
        this.experience=experience;
        this.nWorkingHours=numberOfWorkingHours;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdNumber() {
        return id;
    }

    public int setIdNumber() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getnWorkingHours() {
        return nWorkingHours;
    }
    public void setnWorkingHours(double nWorkingHours) {
        this.nWorkingHours = nWorkingHours;
    }

    public double getExperience() {
        return experience;
    }
    public void setExperience(double experience) {
        this.experience = experience;
    }

    public abstract void salary();
    public abstract double getSalary();
    public abstract void bonus();
    public abstract double getBonus();
}
