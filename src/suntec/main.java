package suntec;

import suntec.Designer;

import javax.swing.*;


/**
 * Created by Felix on 2017-03-30.
 * Main class to display and run out Staff Management Project Program
 * The system exists of Employees that a Management handles
 */
public class main {
    public static void main(String[] args) {
        randomEmployeeCreator testRand = new randomEmployeeCreator();
        Management testManagement = new Management();

        String stringEmployeeNumber = JOptionPane.showInputDialog("How many random employees do you want to create?");
        int whileMax = Integer.parseInt(stringEmployeeNumber);

        int whileCounter = 0;
        while (whileCounter < whileMax) {
            Employee testEmployee = testRand.createARandomEmployee();
            testEmployee.salary();
            testEmployee.bonus();
            testManagement.addEmployee(testEmployee);
            whileCounter++;
        }

        String infoChoice;
        do {
            infoChoice = JOptionPane.showInputDialog("Options : (PrintAll), (SingleEmployeeInfo),  \n"
                    + " (AverageSalary) , (MinSalary), (MaxSalary) , AdminAverageSalary)"
                    + "(DesignerAverageSalary) , (DeveloperAverageSalary) , \n"
                    + " (AverageBonus) , (MinBonus) , (MaxBonus) , \n"
                    + " (AllGenderPercentage) , (AdminGenderPercentage) ,"
                    +"(DesignerGenderPercantege) , (DeveloperGenderPercentage) , \n"
                    + " (RemoveEmployee) , (AddRandEmployee)  , (UpdateEmployeeInfo) , \n"
                    + " In case of updated Employees: (updateAllSalary) , (updateAllBonus)   \n"
                    + "Program is not case sensitive, to Quit the program enter (Quit) ");

            if (infoChoice.equalsIgnoreCase("PrintAll")) {
                testManagement.allEmployeeDetais();
                System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - -");

            } else if (infoChoice.equalsIgnoreCase("AverageSalary")) {
                testManagement.calculateAverageEmployeeSalaryAndMinxMax();
                double averageSalaryPrint = testManagement.getAverageSalary();
                System.out.println("Average employee Salary: " + averageSalaryPrint + "\n");

            } else if (infoChoice.equalsIgnoreCase("MaxSalary")) {
                testManagement.calculateAverageEmployeeSalaryAndMinxMax();
                double maxSalaryPrint = testManagement.getMaxSalary();
                System.out.println("Maximum employee Salary: " + maxSalaryPrint + "\n");

            } else if (infoChoice.equalsIgnoreCase("MinSalary")) {
                testManagement.calculateAverageEmployeeSalaryAndMinxMax();
                double minSalaryPrint = testManagement.getMinSalary();
                System.out.println("Minimum employee Salary: " + minSalaryPrint + "\n");

            } else if (infoChoice.equalsIgnoreCase("AverageBonus")) {
                testManagement.calculateAverageBonusAndLowMaxBonus();
                double averageBonusPrint = testManagement.getAverageBonus();
                System.out.println("Average employee Bonus: " + averageBonusPrint + "\n");

            } else if (infoChoice.equalsIgnoreCase("MinBonus")) {
                testManagement.calculateAverageBonusAndLowMaxBonus();
                double minBonusPrint = testManagement.getMinBonus();
                System.out.println("Minimum bonus: " + minBonusPrint + "\n");

            } else if (infoChoice.equalsIgnoreCase("MaxBonus")) {
                testManagement.calculateAverageBonusAndLowMaxBonus();
                double maxSalaryPrint = testManagement.getMaxBonus();
                System.out.println("Maximum bonus : " + maxSalaryPrint + "\n");

            } else if (infoChoice.equalsIgnoreCase("AdminAverageSalary")) {
                double adminSalaryPrint = testManagement.calculateAverageProfessionSalary(0);
                System.out.println("Admin average salary: " + adminSalaryPrint + "\n");

            } else if (infoChoice.equalsIgnoreCase("DesignerAverageSalary")) {
                double designerSalaryPrint = testManagement.calculateAverageProfessionSalary(1);
                System.out.println("Designer average salary: " + designerSalaryPrint + "\n");

            } else if (infoChoice.equalsIgnoreCase("DeveloperAverageSalary")) {
                double developerSalaryPrint = testManagement.calculateAverageProfessionSalary(2);
                System.out.println("Developer average salary: " + developerSalaryPrint + "\n");

            } else if (infoChoice.equalsIgnoreCase("RemoveEmployee")) {
                String idNumberString = JOptionPane.showInputDialog("Give employee Id");
                int idNumber = Integer.parseInt(idNumberString);
                testManagement.removeEmployee(idNumber);

            } else if (infoChoice.equalsIgnoreCase("AddRandomEmployee")) {
                Employee newEmp = testRand.createARandomEmployee();
                testManagement.addEmployee(newEmp);

            } else if (infoChoice.equalsIgnoreCase("AllGenderPercentage")) {
                testManagement.genderRatio();
                System.out.println("Total female percantege: "
                + testManagement.getTotalGenderPercentageInFemales() +"% \n");

            } else if (infoChoice.equalsIgnoreCase("AdminGenderPercentage")) {
                testManagement.genderRatio();
                System.out.println("Total female percentage: "
                + testManagement.getTotalGenderPercentageInFemales() +"% \n");

            } else if (infoChoice.equalsIgnoreCase("DesignerGenderPercentage")) {
                testManagement.genderRatioInDesigner();
                System.out.println("Total designer female percentage: "
                + testManagement.getDesignerGenderPercentage() +"% \n");

            } else if (infoChoice.equalsIgnoreCase("DeveloperGenderPercentage")) {
                testManagement.genderRatioInDeveloper();
                System.out.println("Total developer female percentage: "
                + testManagement.getDeveloperGenderPercentage()  +"% \n");

            } else if (infoChoice.equalsIgnoreCase("SingleEmployeeInfo")) {
                String idNumberString = JOptionPane.showInputDialog("Give employee Id to find out their info");
                int idNumber = Integer.parseInt(idNumberString);
                System.out.println("\n" + "All information about Employee " + idNumber);
                testManagement.printEmployee(idNumber);

            } else if (infoChoice.equalsIgnoreCase("UpdateEmployeeInfo")) {
                String idNumberString = JOptionPane.showInputDialog("Give employee Id you want to update");
                int idNumber = Integer.parseInt(idNumberString);
                String variableNameString = JOptionPane.showInputDialog("What do you want to change?" + "\n "
                        + "Options: (firstName),(lastName), (gender), (nWorkingHours), (experience)");
                String variableString = JOptionPane.showInputDialog("Give new value,name or"
                +"whatever it is you want to change");
                testManagement.updateEmployeeInformation(idNumber, variableNameString, variableString);

            }
             else if (infoChoice.equalsIgnoreCase("updateAllSalary")) {
            testManagement.updateAllEmployeesSalary();
            }
            else if (infoChoice.equalsIgnoreCase("updateAllBonus")) {
                testManagement.updateAllEmployeesBonus();
            }
            else {
                if(!infoChoice.equalsIgnoreCase("Quit"))
                System.out.println("Invalid input, make sure you pick a valid option " +"\n");
                }
        } while (!infoChoice.equalsIgnoreCase("Quit"));
    }
}
