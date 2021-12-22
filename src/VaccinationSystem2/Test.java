package VaccinationSystem2;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    static Scanner in = new Scanner(System.in);

    static Vaccine[] obj = new Vaccine[100];

    static int patientNmbr;

    static void display() {
        try {
            BufferedWriter filewrite = new BufferedWriter(new FileWriter("C:\\Users\\mhmol\\Desktop\\fileWrite.txt"));

            for (int i = 0; i < patientNmbr; i++) {
                if (obj[i].vaccine != null) {
//                	filewrite.write("Patients who are eligible for Vaccination: \n");
                    filewrite.write("Name: " + obj[i].name + "\t" + "Age: " + obj[i].age + "\t" + "Gender: "
                            + obj[i].gender + "\t" + "NID: " + obj[i].nid + "\t" + "Vaccine: " + obj[i].vaccine + "\t"
                            + "Hospital: " + obj[i].hospital + "\n");

                } else {
                    filewrite.write("");
                }

            }
            filewrite.flush();
            filewrite.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File myObj = new File("C:\\Users\\mhmol\\Desktop\\fileWrite.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    static void info() {
        System.out.println("How many patient list do you want?: ");

        patientNmbr = in.nextInt();
        in.nextLine();

        for (int i = 0; i < patientNmbr; i++) {

            obj[i] = new Vaccine();
            System.out.println("Enter your Name: ");
            obj[i].name = in.nextLine();
            System.out.println("Enter your Age: ");
            obj[i].age = in.nextInt();
            in.nextLine();
            System.out.println("Enter your Gender: ");
            obj[i].gender = in.nextLine();
            System.out.println("Enter your NID: ");
            obj[i].nid = in.nextLong();
            in.nextLine();
            System.out.println("complete for patient " + (i + 1));
            // obj[i].display();

        }
    }

    static void search() {

        System.out.println("enter nid");
        int search = in.nextInt();
        in.nextLine();

        for (int i = 0; i < patientNmbr; i++) {
            if (search == obj[i].nid) {
                System.out.println("\n");
                System.out.println("Search successful!!!");
                System.out.println("Found you " + obj[i].name);

                if (obj[i].gender.equals("female")) {
                    System.out.println("\n");
                    System.out.println("Are You Pragnent?(yes/no)");
                    String prg = in.nextLine();
                    if (prg.equals("yes")) {System.out.println("\n");
                        System.out.println("SORRY!! You are not eligible");
                    } else {System.out.println("\n");
                        System.out.println("Whats your covid result?(positive/negative)");
                        String covid = in.nextLine();
                        if (covid.equals("positive")) {
                            System.out.println("\n");
                            System.out.println("SORRY!! You are not eligible");

                        } else {System.out.println("\n");
                            System.out.println("Select Vaccine from (Moderna, Pfizer, AstraZeneca):");
                            String vacc = in.nextLine();
                            obj[i].vaccine = vacc;
                            System.out.println("\n");
                            System.out.println("Select Hospital (Square, Popular, DMC): ");
                            String hospital = in.nextLine();
                            obj[i].hospital = hospital;
                            System.out.println("\n");
                            System.out.println("Thank You. All done!");
                            System.out.println("We will let you know the date");
                        }

                    }

                } else {
                    System.out.println("Whats your covid result?(positive/negative)");
                    String covid = in.nextLine();
                    if (covid.equals("positive")) {
                        System.out.println("SORRY!! You are not eligible");

                    } else {
                        System.out.println("Select Vaccine from (Moderna, Pfizer, AstraZeneca):");
                        String vacc = in.nextLine();
                        obj[i].vaccine = vacc;
                        System.out.println("Select Hospital (Square, Popular, DMC): ");
                        String hospital = in.nextLine();
                        obj[i].hospital = hospital;

                        System.out.println("Thank You. All done!");
                        System.out.println("We will let you know the date");
                    }
                }

            }

        }
    }

    static void find_info() throws FileNotFoundException {
        File fobj = new File("C:\\Users\\mhmol\\Desktop\\vaccInfo.txt");
        Scanner myreader = new Scanner(fobj);
        while (myreader.hasNextLine()) {
            String data = myreader.nextLine();
            System.out.println(data);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        int selection;
        System.out.println("Select 1 to enter new patient information ");
        System.out.println("Select 2 to take Vaccination");
        System.out.println("Select 3 to get Vaccination Information");
        System.out.println("Select 4 to see List of Eligible");
        System.out.println("Select 5 to exit ");
        do {
            selection = in.nextInt();
            switch (selection) {
                case 1:
                    info();
                    System.out.println("\n");

                    System.out.println("Select 2 to take Vaccination");
                    System.out.println("Select 3 to get Vaccination Information");
                    System.out.println("Select 4 to see List of Eligible");
                    System.out.println("Select 5 to exit ");

                    break;

                case 2:

                    search();

                    System.out.println("\n");
                    System.out.println("Select 1 to enter new patient information ");
                    System.out.println("Select 2 to take Vaccination");
                    System.out.println("Select 3 to get Vaccination Information");
                    System.out.println("Select 4 to see List of Eligible");
                    System.out.println("Select 5 to exit ");
                    break;

                case 3:
                    find_info();

                    System.out.println("\n");
                    System.out.println("Select 1 to enter new patient information ");
                    System.out.println("Select 2 to take Vaccination");
                    System.out.println("Select 4 to see List of Eligible");
                    System.out.println("Select 5 to exit ");

                    break;
                case 4:
                    display();

                    System.out.println("\n");
                    System.out.println("Select 1 to enter new patient information ");
                    System.out.println("Select 2 to take Vaccination");
                    System.out.println("Select 5 to exit ");
                    break;
                case 5:
                    System.out.println("You have exited the program");
                    break;
                default:
                    System.out.println("wrong input");
                    break;
            }

        } while (selection < 5);
    }

}
