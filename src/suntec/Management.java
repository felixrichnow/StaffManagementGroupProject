package suntec;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Created by Felix on 2017-03-30.
 * Class Management works as the management part of a company.
 * It handles all the employees and all the necessary information about them.
 * It can calculate average, salary, bonus and genederpercentage. Both for the entire
 * company that the management is part of, but also for each profession within the company.
 */

public class Management {
    // An ArrayList is created to contain all profession ArrayLists. Which each will contain employees of that type.
    private ArrayList<ArrayList> EmployeeListArayList;
    private ArrayList<Admin> AdminArayList;
    private ArrayList<Designer> DesignerArayList;
    private ArrayList<Developer> DeveloperArayList;
    //All of these values are necessary to store calculated values or used to calculate them
    private double averageSalary, totalSalary, averageBonus, totalBonus,
            maxBonus, minBonus, maxSalary, minSalary, totalGenderPercentageInFemales,
            adminGenderPercentage, designerGenderPercentage, developerGenderPercentage;

    //Contstructor that creates a new ArrayList for each profession and adds them to it

    public Management() {
        EmployeeListArayList = new ArrayList<ArrayList>();
        AdminArayList = new ArrayList<Admin>();
        DesignerArayList = new ArrayList<Designer>();
        DeveloperArayList = new ArrayList<Developer>();
        EmployeeListArayList.add(AdminArayList); // Index 0
        EmployeeListArayList.add(DesignerArayList); // Index 1
        EmployeeListArayList.add(DeveloperArayList); // Index 2
        double[] profArray = new double[3];
    }

    /**
     * Updates the information of a specific Employee.
     * The Employees Id must be provided and known for the
     * the method to be able to be called and used.
     * This method can take a variety of types of variables to be updated.
     * That's why the param, variable is of the type Object.
     * In the method it checks what type of variable and updates
     * the same type of variable inside it with the given variable.
     * It has a way of handling types of variables that don't fit
     * with the employees variables but it is most likely not very safe.
     *
     * @param id                  is the id of the employee
     * @param variableToBeUpdated is the variable to be updated
     * @param variable            is the type of variable to be updated
     */

    public void updateEmployeeInformation(int id, String variableToBeUpdated, Object variable) {
        Employee employeeToBeUpdated = findEmployee(id);
        if (variableToBeUpdated.equalsIgnoreCase("firstName")) {
            String testString = variable.toString();
            employeeToBeUpdated.setFirstName(testString);
        } else if (variableToBeUpdated.equalsIgnoreCase("lastName")) {
            String testString = variable.toString();
            employeeToBeUpdated.setLastName(testString);
        } else if (variableToBeUpdated.equalsIgnoreCase("gender")) {
            String testString = variable.toString();
            employeeToBeUpdated.setGender(testString);
        } else if (variableToBeUpdated.equalsIgnoreCase("nWorkingHours")) {
            double workHours = (double) variable;
            employeeToBeUpdated.setnWorkingHours(workHours);
        } else if (variableToBeUpdated.equalsIgnoreCase("experience")) {
            double experience = (double) variable;
            employeeToBeUpdated.setExperience(experience);
        } else {
            System.out.println("This is not a valid name of a variable to change");
        }

    }

    /**
     * Removes a specific Employee inside the Management class.
     * The Employees Id must be provided and known for the
     * the method to be able to be called and used.
     * It then loops through all Employees til it finds
     * the right one and removes it.
     *
     * @param id is the id of the employee
     */

    public void removeEmployee(int id) {
        for (int i = 0; i < EmployeeListArayList.size(); i++) {
            ArrayList<Employee> currentArrayList = EmployeeListArayList.get(i);
            for (int j = 0; j < currentArrayList.size(); j++) {
                Employee loopEmployee = currentArrayList.get(j);
                if (loopEmployee.getIdNumber() == id) {
                    EmployeeListArayList.get(i).remove(j);
                    return;
                }
            }
        }
    }

    /**
     * Adds a specific Employee to the Management class.
     * It checks what type the Employee is and adds it to
     * that types/professions ArrayList in Management.
     *
     * @param currentEmployee is Employee that's being added
     */

    public void addEmployee(Employee currentEmployee) {
        String employeeString = currentEmployee.getClass().toString();

        if (employeeString.equals("class suntec.Admin")) {
            ArrayList<Employee> currentArrayList = EmployeeListArayList.get(0);
            currentArrayList.add(currentEmployee);
        } else if (employeeString.equals("class suntec.Designer")) {
            ArrayList<Employee> currentArrayList = EmployeeListArayList.get(1);
            currentArrayList.add(currentEmployee);
        } else if (employeeString.equals("class suntec.Developer")) {
            ArrayList<Employee> currentArrayList = EmployeeListArayList.get(2);
            currentArrayList.add(currentEmployee);
        }
    }

    /**
     * Calculates Average,Minimum and Maximum Salary for
     * all Employees that's in the Management (company).
     * It only calculates them and stores them inside variables.
     * The variables are named to fit their purpose:
     * averageSalary
     * maxSalary
     * minSalary
     */

    public void calculateAverageEmployeeSalaryAndMinxMax() {
        double currentSalary = 0, previousSalary = 0, previousSalary2 = 0, totalEmployeess = 0;

        for (int i = 0; i < EmployeeListArayList.size(); i++) {
            ArrayList<Employee> currentArrayList = EmployeeListArayList.get(i);
            totalEmployeess += currentArrayList.size();
            for (int j = 0; j < currentArrayList.size(); j++) {
                Employee loopEmployee = currentArrayList.get(j);
                totalSalary += loopEmployee.getSalary();
                currentSalary = loopEmployee.getSalary();

                if (currentSalary >= previousSalary) {
                    previousSalary = currentSalary;
                }
                if (previousSalary2 == 0) {
                    previousSalary2 = currentSalary;
                } else {
                    if (previousSalary2 >= currentSalary) {
                        previousSalary2 = currentSalary;
                    }
                }
            }
        }
        int totalSalaryCalc = (int) totalSalary;
        int totalEmployeessCalc = (int) totalEmployeess;
        averageSalary = totalSalaryCalc / totalEmployeessCalc;
        maxSalary = previousSalary;
        minSalary = previousSalary2;
    }

    // Simple get-methods to get a hold of the calculated values

    public double getAverageSalary() {
        return averageSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public double getMinSalary() {
        return minSalary;
    }

    /**
     * Calculates the average salary for a profession.
     * It loops through the whole profession and
     *
     * @param professionArrayIndex is the indexnumber of the profession to be calculated
     */

    public double calculateAverageProfessionSalary(int professionArrayIndex) {
        double totalEmployes = 0, previousProfSalary = 0, previousProfSalary2 = 0;
        if (!EmployeeListArayList.get(professionArrayIndex).isEmpty()) {

            ArrayList<Employee> currentArrayList = EmployeeListArayList.get(professionArrayIndex);
            totalEmployes += currentArrayList.size();
            for (int j = 0; j < currentArrayList.size(); j++) {
                Employee loopEmployee = currentArrayList.get(j);
                double currentProfSalary = loopEmployee.getSalary();
                totalSalary += loopEmployee.getSalary();
            }
            //Need to cast it to ints, to be sure no infinity
            int totalSalaryCalc = (int) totalSalary;
            int totalEmployeessCalc = (int) totalEmployes;
            averageSalary = totalSalaryCalc / totalEmployeessCalc;
            return averageSalary;

        } else {
            return 0;
        }
    }

    /**
     * Calculates Average,Minimum and Maximum Bonus for
     * all Employees that's in the Management (company).
     * It only calculates them and stores them inside variables.
     * The variables are named to fit their purpose:
     * averageBonus
     * maxBonus
     * minBonus
     */

    public void calculateAverageBonusAndLowMaxBonus() {
        //Variables to store all counters, mathemathical operators, we use double
        double totalEmployeess = 0, totalbonus = 0, previousbonus = 0, previousbonus2 = 0;

        for (int i = 0; i < EmployeeListArayList.size(); i++) {
            ArrayList<Employee> currentArrayList = EmployeeListArayList.get(i);
            totalEmployeess += currentArrayList.size();

            for (int j = 0; j < currentArrayList.size(); j++) {
                Employee loopEmployee = currentArrayList.get(j);
                double currentBonus = loopEmployee.getBonus();
                if (currentBonus >= previousbonus) {
                    previousbonus = currentBonus;
                }
                if (previousbonus2 == 0) {
                    previousbonus2 = currentBonus;
                } else {
                    if (previousbonus2 >= currentBonus) {
                        previousbonus2 = currentBonus;
                    }
                }
                totalbonus += loopEmployee.getBonus();
            }
        }
        int totalBonuscalc = (int) totalbonus;
        int totalBonusEmployeesscalc = (int) totalEmployeess;
        averageBonus = totalBonuscalc / totalBonusEmployeesscalc;


        maxBonus = previousbonus;
        minBonus = previousbonus2;
    }

    // These methods all are getts for the calculated bonuses

    public double getAverageBonus() {
        return averageBonus;
    }

    public double getMaxBonus() {
        return maxBonus;
    }

    public double getMinBonus() {
        return minBonus;
    }

    /**
     * Calculates the genderratio in terms of females in the company
     * It checks the gender of all Employees that's in the Management (company).
     * It calculates and rounds it off into percentage.
     * The value is stored in a variable called totalGenderPercentageInFemales:
     */

    public void genderRatio() {
        double totalFemales = 0;
        double totalMales = 0;
        for (int i = 0; i < EmployeeListArayList.size(); i++) {
            ArrayList<Employee> currentArrayList = EmployeeListArayList.get(i);
            for (int j = 0; j < currentArrayList.size(); j++) {
                if (currentArrayList.get(j).getGender().equalsIgnoreCase("Female")) {
                    totalFemales += 1;
                } else {
                    totalMales += 1;
                }
            }
        }
        totalGenderPercentageInFemales = (totalFemales) / (totalMales + totalFemales) * 100;
        totalGenderPercentageInFemales = Math.round(totalGenderPercentageInFemales);
    }

    /**
     * Calculates the genderratio of Admins in terms of females in the company
     * It checks the gender of all Employees that's in the Management (company).
     * It calculates and rounds it off into percentage.
     * The value is stored in a variable called adminGenderPercentage :
     */

    public void genderRatioInAdmin() {
        double totalFemales = 0;
        double totalMales = 0;
        ArrayList<Employee> currentArrayList = EmployeeListArayList.get(0);
        for (int i = 0; i < currentArrayList.size(); i++) {
            if (currentArrayList.get(i).getGender().equalsIgnoreCase("Female")) {
                totalFemales += 1;
            } else {
                totalMales += 1;
            }
        }
        adminGenderPercentage = (totalFemales) / (totalMales + totalFemales) * 100;
        adminGenderPercentage = Math.round(adminGenderPercentage);
    }

    /**
     * Calculates the genderratio of Designers in terms of females in the company
     * It checks the gender of all Employees that's in the Management (company).
     * It calculates and rounds it off into percentage.
     * The value is stored in a variable called designerGenderpercentage :
     */

    public void genderRatioInDesigner() {
        double totalFemales = 0;
        double totalMales = 0;
        ArrayList<Employee> currentArrayList = EmployeeListArayList.get(1);
        for (int i = 0; i < currentArrayList.size(); i++) {
            if (currentArrayList.get(i).getGender().equalsIgnoreCase("Female")) {
                totalFemales += 1;
            } else {
                totalMales += 1;
            }
        }
        designerGenderPercentage = (totalFemales) / (totalMales + totalFemales) * 100;
        designerGenderPercentage = Math.round(designerGenderPercentage);
    }

    /**
     * Calculates the genderratio of Developers in terms of females in the company
     * It checks the gender of all Employees that's in the Management (company).
     * It calculates and rounds it off into percentage.
     * The value is stored in a variable called developerGenderpercentage :
     */

    public void genderRatioInDeveloper() {
        double totalFemales = 0;
        double totalMales = 0;
        ArrayList<Employee> currentArrayList = EmployeeListArayList.get(2);
        for (int i = 0; i < currentArrayList.size(); i++) {
            if (currentArrayList.get(i).getGender().equalsIgnoreCase("Female")) {
                totalFemales += 1;
            } else {
                totalMales += 1;
            }
        }
        developerGenderPercentage = (totalFemales) / (totalMales + totalFemales) * 100;
        developerGenderPercentage = Math.round(developerGenderPercentage);
    }

    //Return methods/functions for the genderratios in terms of females

    public double getTotalGenderPercentageInFemales() {
        return totalGenderPercentageInFemales;
    }

    public double getAdminGenderPercentagel() {
        return adminGenderPercentage;
    }

    public double getDeveloperGenderPercentage() {
        return developerGenderPercentage;
    }

    public double getDesignerGenderPercentage() {
        return designerGenderPercentage;
    }

    /**
     * Help method to find an Employee using its id.
     * It checks where the Employee is and then returns it
     *
     * @param id is the employees id
     * @return Employee that was found
     */

    public Employee findEmployee(int id) {
        double totalEmployeess = 0;
        Employee returnEmployee = null;
        for (int i = 0; i < EmployeeListArayList.size(); i++) {
            ArrayList<Employee> currentArrayList = EmployeeListArayList.get(i);
            totalEmployeess += currentArrayList.size();
            for (int j = 0; j < currentArrayList.size(); j++) {
                Employee loopEmployee = currentArrayList.get(j);
                int testId = loopEmployee.getIdNumber();
                if (testId == id) {
                    returnEmployee = loopEmployee;
                }
            }
        }
        return returnEmployee;
    }

    /**
     * Method to print a certain Employee's information, name,id etc.
     * It also writes what type of Employee it is
     *
     * @param id is the employees id
     */

    public void printEmployee(int id) {
        Employee printEmployee = findEmployee(id);
        String employeeString = printEmployee.getClass().toString();
        employeeString = employeeString.substring(employeeString.indexOf(".") + 1);
        System.out.println(printEmployee.getIdNumber() + "    " + printEmployee.getFirstName() + "      "
                + printEmployee.getLastName() + "      " + printEmployee.getGender()
                + "      " + employeeString + "      " + printEmployee.getnWorkingHours() + "      "
                + printEmployee.getSalary());
    }

    /**
     * Method to print all Employees information.
     * It prints all the employees name,lastname,gender
     * profession, experience and working hours.
     */

    public void allEmployeeDetais() {
        System.out.println("Id      Firstname      Lastname      Gender      Profession      Experience      Workinghours");
        for (int i = 0; i < EmployeeListArayList.size(); i++) {
            ArrayList<Employee> currentArrayList = EmployeeListArayList.get(i);
            for (int j = 0; j < currentArrayList.size(); j++) {
                Employee currentEmployeeInfo = currentArrayList.get(j);
                String employeeString = currentEmployeeInfo.getClass().toString();
                employeeString = employeeString.substring(employeeString.indexOf(".") + 1);

                System.out.println(currentEmployeeInfo.getIdNumber() + "      " + currentEmployeeInfo.getFirstName() + "      "
                        + currentEmployeeInfo.getLastName() + "      " + currentEmployeeInfo.getGender()
                        + "      " + employeeString + "      " + currentEmployeeInfo.getnWorkingHours() + "      "
                        + currentEmployeeInfo.getSalary());
            }
        }
    }

    /**
     * If you want to update all Employees bonus, this method can be called.
     * It only really needs to be used in case the information of
     * employees been changed
     */

    public void updateAllEmployeesBonus() {
        for (int i = 0; i < EmployeeListArayList.size(); i++) {
            ArrayList<Employee> currentArrayList = EmployeeListArayList.get(i);
            for (int j = 0; j < currentArrayList.size(); j++) {
                Employee loopEmployeeBonus = currentArrayList.get(j);
                loopEmployeeBonus.bonus();
            }
        }
    }

    /**
     * If you want to update all Employees salary, this method can be called.
     * It only really needs to be used in case the information of
     * employees been changed
     */

    public void updateAllEmployeesSalary() {
        for (int i = 0; i < EmployeeListArayList.size(); i++) {
            ArrayList<Employee> currentArrayList = EmployeeListArayList.get(i);
            for (int j = 0; j < currentArrayList.size(); j++) {
                Employee loopEmployeeBonus = currentArrayList.get(j);
                loopEmployeeBonus.salary();
            }
        }
    }

}

