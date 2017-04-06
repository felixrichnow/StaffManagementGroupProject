package suntec;

/**
 * Created by user on 2017-04-03.
 */


public class Developer extends Employee{
    private double salary;
    private double bonus;
    private  double payPerHour=150;
    private String typeOfContract;
    private boolean cert;

    public Developer(String firstName,String lastName,int idNumber,String gender,String typeOfContract,boolean cert, double experience,double nWorkingHours ){
        super(firstName,lastName,idNumber,gender,experience,nWorkingHours);
        this.typeOfContract = typeOfContract;
        this.cert = cert;
        this.experience =  experience;
        this.nWorkingHours= nWorkingHours;

    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getPayPerHour() {
        return payPerHour;
    }


    public void setPayPerHour(double payPerHour) {
        this.payPerHour = payPerHour;
    }


    public String getTypeOfContract() {
        return typeOfContract;
    }

    public void setTypeOfContract(String typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    public void setCert(boolean cert) {
        this.cert = cert;
    }

    public void salary(){
        if( getTypeOfContract().equalsIgnoreCase("Fixed")){
            {
                if((this.cert == true)&& ((experience>=0)&&(experience<=5))){
                    salary = nWorkingHours*getPayPerHour();
                }else if((this.cert == true)&&(experience>5)&&(experience<10)){
                    salary= (nWorkingHours*getPayPerHour())+(nWorkingHours*getPayPerHour()*0.5);

                }
                else if((this.cert == true)&&(experience>10)){
                    salary = 3*(nWorkingHours*getPayPerHour());
                }
                else if(this.cert == false && (experience>=0)&&(experience<10)){
                    salary = nWorkingHours*getPayPerHour()+ (experience*nWorkingHours*getPayPerHour()*0.1);

                }
            }
        }else if(getTypeOfContract().equalsIgnoreCase("Temporary")){
            if((experience>=0)&&(experience<5)){
                salary = (nWorkingHours*getPayPerHour())-(nWorkingHours*getPayPerHour()*0.1);
            }
            else if ((experience >=5)&&(experience<10)){salary = nWorkingHours*getPayPerHour()+(nWorkingHours*getPayPerHour()*0.1);}
            else salary = 2*(nWorkingHours*getPayPerHour());
        }
    }


    public void bonus() {
        bonus =  0.5*salary;
        this.salary+= bonus;
    }

}