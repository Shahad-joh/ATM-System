/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsystem;
import java.util.Scanner;
public class Admin {

    private static int step = 1;
    private String firstName;
    private String lastName;
    private String pinNumber;
    private int ID;


    public Admin() {
        this.ID = step++;
        this.firstName = "Default";
        this.lastName = "Default";
        this.pinNumber = "";
    }

    public Admin(String firstName, String lastName, String pinNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pinNumber = pinNumber;
        this.ID = step++;
    }
    public int getID() {
        return ID;
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

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }
// creat User and return it to put it in virtual database

    public User createUser() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("********** Creating a User Process.");

            User temp = new User();
            while (true) {
                System.out.println("********** please Enter your first name :");
                String firstName = in.nextLine();
                System.out.println("********** Please Enter your last name :");
                String lastName = in.nextLine();
                System.out.println("********** please Enter your pin number ");
                String pin = in.nextLine();

                while (true) {
                    System.out.println("********** please Enter your pin again to confirm :");
                    String confirmpin = in.nextLine();
                    if (confirmpin.equals(pin)) {
                        break;
                    } else {
                        System.out.println("********** two pin doesn't match !!");
                    }
                }
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setPinNumber(pin);
                temp.printInformation();
                System.out.println("********** do you want to confirm creating this user with these information : ");
                System.out.println("********** for save and exit please press 1");
                System.out.println("********** for Exit without saving please press 2");
                System.out.println("********** retry the process please press 3");
                int choice = in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 1: {
                        System.out.println("********** user created");

                        return temp;
                    }
                    case 2: {
                        System.out.println("********** Exit without saving");
                        return null;
                    }
                    case 3: {
                        System.out.println("********** retry the process!");
                    }
                }

            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }

    }

    public void printInformation() {
        System.out.println("Admin ID : " + this.ID);
        System.out.println("Admin first Name : " + this.firstName);
        System.out.println("Admin last Name : " + this.lastName);
        System.out.println("Admin pin number : " + this.pinNumber);
    }

    // creat admin and return it to put it in the virtual database
    public Admin createAdmin() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("********** Creating a Admin Process.");

            Admin temp = new Admin();
            while (true) {
                System.out.println("********** please Enter your first name :");
                String firstName = in.nextLine();
                System.out.println("********** Please Enter your last name :");
                String lastName = in.nextLine();
                System.out.println("********** please Enter your pin number ");
                String pin = in.nextLine();

                while (true) {
                    System.out.println("********** please Enter your pin again to confirm :");
                    String confirmpin = in.nextLine();
                    if (confirmpin.equals(pin)) {
                        break;
                    } else {
                        System.out.println("********** two pin doesn't match !!");
                    }
                }
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setPinNumber(pin);
                temp.printInformation();
                System.out.println("********** do you want to confirm creating this admin with these information : ");
                System.out.println("********** for save and exit please press 1");
                System.out.println("********** for Exit without saving please press 2");
                System.out.println("********** retry the process please press 3");
                int choice = in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 1: {
                        System.out.println("********** admin created");

                        return temp;
                    }
                    case 2: {
                        System.out.println("********** Exit without saving");
                        return null;
                    }
                    case 3: {
                        System.out.println("********** retry the process!");
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("wrong Enter");
            return null;
        }

    }
}
