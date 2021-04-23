hu/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsystem;

/**
 *
 * @author ahadj
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class ATMSystem {

    // virtual database for User and Admin
    static ArrayList<User> users;
    static ArrayList<Admin> admins;

    // admin senario
    public static void loginAsAdmin() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("********** Login as admin : ");
        System.out.println("********** please Enter your ID :");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("********** please Enter your password :");
        String pin = in.nextLine();
        Boolean adminFlage = false;
        int i = 0;
        // find the admin in the database
        for (int i = 0 ; i < admins.size(); i++) {
            if (admins.get(i).getID() == id && admins.get(i).getPinNumber().equals(pin)) {
                adminFlage = true;
                break;
            }
        }
        while (true) {
            if (adminFlage) {
                System.out.println("Welcom " + admins.get(i).getFirstName());
                System.out.println("********** choose a process from the list : ");
                System.out.println("********** to add a user press 1 ");
                System.out.println("********** to add a admin press 2 ");
                System.out.println("********** to show transaction History today press 3");
                System.out.println("********** to show a list of admins press 4");
                System.out.println("********** to show a list of users press 5");
                System.out.println("********** to Exit process press 6");
                int ch = in.nextInt();
                in.nextLine();
                switch (ch) {
                    case 1: {
                        User temp = admins.get(i).createUser();
                        if (temp != null) {
                            users.add(temp);
                        }
                        break;
                    }
                    case 2: {
                        Admin temp = admins.get(i).createAdmin();
                        if (temp != null) {
                            admins.add(temp);
                        }
                        break;
                    }
                    case 3: {
                        Transfer.showTransactionHistory();
                        break;
                    }
                    case 4: {
                        for (Admin A : admins) {
                            A.printInformation();
                        }
                        break;

                    }
                    case 5: {
                        for (User U : users) {
                            U.printInformation();
                        }
                        break;
                    }
                    case 6: {
                        System.out.println("********** Exiting...");
                        return;
                    }

                }
            } else {
                System.out.println("********** the ID and the bin doesn't match ,try again please !");
                return;
            }
        }
    }
//  user scenario

    public static void loginAsUser() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("********** Login as user : ");
        System.out.println("********** please Enter your ID : ");
        int id = in.nextInt();
        in.nextLine();
        System.out.println("********** please Enter your password : ");
        String pin = in.nextLine();
        Boolean userFlage = false;
        int index = 0;
        for (index = 0 ; index < users.size(); index++) {
            if (users.get(index).getID() == id && users.get(index).getPinNumber().equals(pin)) {
                userFlage = true;
                break;
            }
        }

        if (userFlage) {
            System.out.println("Welcome " + users.get(index).getFirstName());
            while (true) {
                System.out.println("********** choose a process from the list :");
                System.out.println("********** to Withdraw from your account press 1");
                System.out.println("********** to Deposit to your account press 2 ");
                System.out.println("********** to transfer to another account press 3");
                System.out.println("********** to show your transitions History press 4");
                System.out.println("********** to show your balance press 5");
                System.out.println("********** to Exit process press 6");
                int ch = in.nextInt();
                in.nextLine();
                switch (ch) {
                    case 1: {
                        System.out.println("********** withdraw amount of money :");
                        double amount = in.nextDouble();
                        in.nextLine();
                        // process if the user send negative value to withdraw
                        if (amount >= 0) {
                            users.get(index).withdraw(amount);
                        } else {
                            System.out.println("you can't withdraw negative amount, try again!");
                        }

                        break;
                    }
                    case 2: {
                        System.out.println("********** Deposit amount : ");
                        double amount = in.nextInt();
                        in.nextLine();
                        // process if the user send negative value to deposit

                        if (amount >= 0) {
                            users.get(index).Deposit(amount);
                        } else {
                            System.out.println("you can't Deposit negative amount, try again!");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("********** money amount : ");
                        double amount = in.nextDouble();
                        in.nextLine();
                        if (amount > 0) {
                            while (true) {
                                System.out.println("********** Enter reciver ID : ");
                                int reciverId = in.nextInt();
                                in.nextLine();
                                int reciverIndex = 0;
                                Boolean reciverFlage = false;
                                for (reciverIndex = 0; reciverIndex < users.size(); reciverIndex++) {
                                    if (users.get(reciverIndex).getID() == reciverId) {
                                        reciverFlage = true;
                                        break;
                                    }
                                }
                                if (reciverFlage) {
                                    Transfer.transferMoney(users.get(index), users.get(reciverIndex), amount);
                                    break;
                                } else {
                                    System.out.println("********** the reciver's ID is either not correct or not existed try again **********");
                                }
                            }
                        } else {
                            System.out.println("you can't transfer negative amount, try again!");
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("********** My account History **********");
                        users.get(index).showHistory();
                        break;
                    }
                    case 5: {
                        System.out.println("" + users.get(index).getFirstName() + "'s balance is " + users.get(index).getBalance() + "$");
                        break;
                    }
                    case 6: {
                        return;
                    }
                }
            }
        } else {
            System.out.println("********** the ID and the pin number doesn't match ,try again please ! **********");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            users = new ArrayList<User>();
            admins = new ArrayList<Admin>();
            Boolean stop = false;
            for (int i = 0; i < 20; i++) {
                System.out.print("*");
            }
            System.out.print(" Welcom to ATM System ");
            for (int i = 0; i < 20; i++) {
                System.out.print("*");
            }
            System.out.println("");
            while (!stop) {

                Admin adman1 = new Admin("Reem", "Almutiari", "123");
                Admin adman2 = new Admin("albandary", "bin ibrahim", "123");
                User user1 = new User("Shahad", "Aljohani", "123");
                User user2 = new User("Sadeam", "osama", "123");
                admins.add(adman1);
                admins.add(adman2);
                users.add(user1);
                users.add(user2);

                System.out.println("********** please choose between these two configurations :");
                System.out.println("********** login as Admin press 1.");
                System.out.println("********** login as User press 2");
                System.out.println("********** Quit the system press 3");
                int choice = in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 1: {
                        loginAsAdmin();
                        break;
                    }
                    case 2: {
                        loginAsUser();
                        break;
                    }
                    case 3: {
                        stop = true;
                        break;
                    }

                }

            }

        } catch (Exception e) {
           System.out.println("wrong Enter ");
        }
    }
}
