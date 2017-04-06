package suntec;

/**
 * Created by user on 2017-04-03.
 */


public class Admin extends Employee{
    private  double payPerHour = 120;
    private double salary;
    private double bonus;
    private double numberOfWorkingHours;
    private double experience;

    Admin(String firstName,String lastName,int idNumber,String gender, double experience, double numberOfWorkingHours){
        super(firstName,lastName,idNumber,gender,experience,numberOfWorkingHours);
        this.numberOfWorkingHours=numberOfWorkingHours;
        this.experience=experience;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }


    public double getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(double payPerHour) {
        this.payPerHour = payPerHour;
    }

    public void salary() {
        if((experience>=0)&&(experience<=3)){
            salary = numberOfWorkingHours*getPayPerHour();
        }else if((experience >= 4)&&(experience < 7)){
            salary = 1.3*numberOfWorkingHours*getPayPerHour();
        }else if(experience>=7){
            salary = 2*numberOfWorkingHours*getPayPerHour();
        }
    }

    public void bonus() {
        bonus =  0.5*salary;
        this.salary+= bonus;
    }

}