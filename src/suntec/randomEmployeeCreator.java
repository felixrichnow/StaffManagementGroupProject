package suntec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Felix
 * Class to create a random Employee
 * Pretty much only exists to run the method createARandomEmployee
 */

public class randomEmployeeCreator {
    private int idNumberCounter=0;

    /**
     * Method createARandomEmployee creates arraylists of first names and last names.
     * The first names are two arraylists, one for each gender.
     * Then random numbers are generated to create random employees.
     * Once the numbers are generated they're translated into variables that fit
     * each profession. Lastly a random employee are created and returned.
     *  @return returnEmployee the randomly created Employee
     */


    public Employee createARandomEmployee() {
        Random randomGenerator = new Random();
        int employeeNumber = randomGenerator.nextInt(3) + 1;
        ArrayList<String> lastNamesArayList = new ArrayList<>(Arrays.asList("Pettersson", "Svensson", "Andersson", "Johansson", "Eriksson"));
        ArrayList<String> femaleNamesArrayList = new ArrayList<>(Arrays.asList("Erika", "Jenny", "Nina", "Andrea", "Terese"));
        ArrayList<String> maleNamesArayList = new ArrayList<>(Arrays.asList("Per", "Andreas", "Henrik", "Sven", "Nils"));
        int genderNumber = randomGenerator.nextInt(2) + 1;
        int firstNameNumber = randomGenerator.nextInt(4) + 0;
        int lastNameNumber = randomGenerator.nextInt(4) + 0;
        String lastNameString = lastNamesArayList.get(lastNameNumber);
        String firstNameString = null;
        String genderString = null;
        String typeOfContractString = null;
        double workingHoursNumber = randomGenerator.nextInt(40) + 1;
        double experienceNumber = randomGenerator.nextInt(10) + 1;

        if (genderNumber == 1) {
            firstNameString = maleNamesArayList.get(firstNameNumber);
            genderString = "Male";
        } else {
            firstNameString = femaleNamesArrayList.get(firstNameNumber);
            genderString = "Female";
        }

        idNumberCounter++;
        String printString = null;
        Employee returnEmployee = null;

        if (employeeNumber == 1) {
            Admin testAdmin = new Admin(firstNameString, lastNameString, idNumberCounter, genderString, experienceNumber, workingHoursNumber);
            printString = testAdmin.getClass().toString();
            returnEmployee = testAdmin;
        } else if (employeeNumber == 2) {
            Designer testDesigner = new Designer(firstNameString, lastNameString, idNumberCounter, genderString, " ", experienceNumber, workingHoursNumber);
            printString = testDesigner.getClass().toString();
            returnEmployee = testDesigner;
        } else if (employeeNumber == 3) {
            int typeOfContractNumber = randomGenerator.nextInt(2) + 1;
            int certNumber = randomGenerator.nextInt(2) + 1;
            boolean certBool;

            if (typeOfContractNumber == 1) {
                typeOfContractString = "temporary";
            } else {
                typeOfContractString = "fixed";
            }
            certBool = certNumber == 1;

            Developer testDeveloper = new Developer(firstNameString, lastNameString, idNumberCounter,
            genderString, typeOfContractString, false, experienceNumber, workingHoursNumber);

            printString = testDeveloper.getClass().toString();
            returnEmployee = testDeveloper;
        }

        return returnEmployee;
    }
}

