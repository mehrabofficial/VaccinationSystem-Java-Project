package VaccinationSystem;

import java.util.Scanner;
import java.io.*;

//System will Store this Information

public class VaccinationSystem {
    String PatientName;
    int age;
    String gender;
    int nid;
    String vaccine_name;
    String selected_hospital;

    Scanner input = new Scanner(System.in);
    static int a;
    VaccinationSystem[] arr = new VaccinationSystem[100];

    void BasicInfo(String name,
                   int age,
                   String gender,
                   int nid) {
        this.PatientName = name;
        this.age = age;
        this.gender = gender;
        this.nid = nid;
    }

    //This Method will work for our process 1,2,3,4

    void output() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Mehrab\\Vaccination System.txt"));

            for (int i = 0; i < a; i++) {
                if (arr[i].vaccine_name != null) {

                    bw.write(arr[i].PatientName + " " + arr[i].age + " " + arr[i].gender + " " + arr[i].nid + " " + arr[i].vaccine_name + " " + arr[i].selected_hospital + "\n");
                }

            }
            bw.flush();
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //This Method will read the file

        try {
            File myObj = new File("E:\\Mehrab\\Vaccination System.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //This method will take Patient information

    void take() {

        for (int i = 0; i < a; i++) {
            System.out.println("Inserting " + (i + 1) + " patient information");

            System.out.println("Enter Patient Name:");
            String name = input.next();

            System.out.println("Enter Patient Age:");
            int age = input.nextInt();

            System.out.println("Enter Patient Gender:");
            String gender = input.next();

            System.out.println("Enter Patient NID:");
            int nid = input.nextInt();

            arr[i] = new VaccinationSystem();
            arr[i].BasicInfo(name, age, gender, nid);

            System.out.println((i + 1) + " Patient information inserted successfully");
        }

    }

    //This method will Search Patient by NID

    void search() {
        System.out.println("Enter Patient NID");
        int search = input.nextInt();
        for (int i = 0; i < a; i++) {
            if (search == arr[i].nid) {
                System.out.println("Patient Information Found Successfully!  Welcome " + arr[i].PatientName);

                //For Female Patient

                if (arr[i].gender.equals("Female")) {
                    System.out.println("Are You Pregnant?"); // If yes = not eligible for vaccine.

                    String prg = input.next();
                    if (prg.equals("yes")) {
                        System.out.println("YOU ARE NOT ELIGIBLE FOR COVID VACCINE");
                    } else {
                        System.out.println("Are you infected with covid currently?");
                        String covid = input.next();

                        if (covid.equals("positive")) {
                            System.out.println("YOU ARE NOT ELIGIBLE FOR COVID VACCINE");

                        } else {
                            System.out.println("Select Vaccine from (Moderna, Pfizer, AstraZeneca):");
                            String vacn = input.next();
                            arr[i].vaccine_name = vacn;
                            System.out.println("Select your nearby Hospital (Square, Popular, DMC): ");
                            String hospt = input.next();
                            arr[i].selected_hospital = hospt;
                            System.out.println("Congratulations your registration is successful! ");
                            System.out.println("We will let you know the date");
                        }

                    }

                } else {

                    System.out.println("Are you infected with covid currently?"); //For Male Patient
                    String covid = input.next();
                    if (covid.equals("positive")) {
                        System.out.println("YOU ARE NOT ELIGIBLE FOR COVID VACCINE");

                    } else {
                        System.out.println("Select Vaccine from (Moderna, Pfizer, AstraZeneca):");
                        String vacn = input.next();
                        arr[i].vaccine_name = vacn;
                        System.out.println("Select your nearby Hospital (Square, Popular, DMC): ");
                        String hospt = input.next();
                        arr[i].selected_hospital = hospt;
                        System.out.println("Congratulations your registration is successful!");
                        System.out.println("We will let you know the date");
                    }
                }

            }

        }

    }

    //Vaccination Information from FILE

    void fileread() {

        try {
            File myObj = new File("E:\\Mehrab\\Vaccine Registration information.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // This Method will work for select step from menu

    void menu() {

        System.out.println("Select 1 to enter new patient information ");
        System.out.println("Select 2 to take Vaccine");
        System.out.println("Select 3 to get Vaccination Information");
        System.out.println("Select 4 to see the patient eligible for Vaccination");
        System.out.println("Select 5 to exit ");
        System.out.println("\n");
    }


}




