package suntec;

public class Designer extends Employee {
    private double salary;
    private double bonus;
    private double payPerHour = 200;
    private String qualification;
    double experience;
    double numberOfWorkingHours;

    public Designer (String firstName,String lastName,int idNumber,String gender,String qualification, double experience,double numberOfWorkingHours){
        super(firstName,lastName,idNumber,gender, experience, numberOfWorkingHours);
        this.qualification = qualification;
        this.numberOfWorkingHours=numberOfWorkingHours;
        this.experience=experience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public double getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(double payPerHour) {
        payPerHour = payPerHour;
    }


    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void salary(){
        double basicSalary;
        switch(getQualification()){
            case "BSc":
                if((experience>=0)&&(experience<5)){
                    basicSalary = numberOfWorkingHours*(getPayPerHour());
                    salary = (basicSalary=+(basicSalary*0.1));
                }
                else if ((experience>=5) && (experience<10)){
                    basicSalary = numberOfWorkingHours*(getPayPerHour());
                    salary = basicSalary+(basicSalary * 0.2);
                }
                else if (experience>=10){
                    basicSalary = numberOfWorkingHours*(getPayPerHour());
                    salary = basicSalary + (basicSalary*0.5);
                }

            case "MSc":
                if((experience>=0)&&(experience<5)){
                    basicSalary = numberOfWorkingHours*(getPayPerHour());
                    salary = basicSalary + (basicSalary*0.3);
                }
                else if((experience>=5)&&(experience<10)){
                    basicSalary = numberOfWorkingHours * (getPayPerHour());
                    salary = basicSalary+ (basicSalary*0.4);
                }
                else if(experience>= 10){
                    basicSalary = numberOfWorkingHours*(getPayPerHour());
                    salary= 2*basicSalary;
                }
            case "PhD":
                if((experience>=0)&&(experience<5)){
                    basicSalary = numberOfWorkingHours*getPayPerHour();
                    salary= basicSalary+(basicSalary*0.5);}
                else if((experience>=5)&&(experience<10)){
                    basicSalary = numberOfWorkingHours*(getPayPerHour());
                    salary = basicSalary+ (basicSalary*0.8);}
                else if(experience>= 10){
                    basicSalary = numberOfWorkingHours*(getPayPerHour());
                    salary= 2.5*basicSalary;
                }

            case " ":
                if(experience>= 10){
                    basicSalary = numberOfWorkingHours*getPayPerHour();
                    salary = basicSalary+ (basicSalary*0.8);
                }
                else if ((experience>=5)&&(experience<10)){
                    basicSalary = numberOfWorkingHours*(getPayPerHour());
                    salary = basicSalary+ (basicSalary*0.1);
                }
                else if ((experience>=0)&&(experience<5)){
                    salary = numberOfWorkingHours*(getPayPerHour());
                }
        }
    }

    public void bonus() {
        bonus =  0.1*salary;
        this.salary+= bonus;
    }
}
