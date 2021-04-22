/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {
    // data fields
    private static int step = 1;
    private String firstName;
    private String lastName;
    private String pinNumber;
    private String balance;
    private int ID;
    // history for the events and transactions for each user
    ArrayList<String> History;

    public User(String firstName, String lastName, String pinNumber) {
        this.ID = step++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pinNumber = pinNumber;
        this.balance = "0$";
        this.History = new ArrayList<String>();
        History.add("" + LocalDateTime.now().withNano(0) + " creating an account");
    }

    public User() {
        this.ID = step++;
        this.firstName = "Default";
        this.lastName = "Default";
        this.pinNumber = "";
        this.balance = "0$";
        this.History = new ArrayList<String>();
        History.add("" + LocalDateTime.now().withNano(0) + " creating an account");

    }

    public Double getBalance() {
        String cash = this.balance.substring(0, this.balance.length() - 1);
        return Double.parseDouble(cash);
    }

    public int getID() {
        return this.ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void setBalance(Double balance) {

        this.balance = "" + balance + "$";
    }

    public void printInformation() {
        System.out.println("User ID : " + this.ID);
        System.out.println("User first Name : " + this.firstName);
        System.out.println("User last Name : " + this.lastName);
        System.out.println("User pin number : " + this.pinNumber);
        System.out.println("User balance : " + this.balance);
    }

    public Boolean withdraw(double x) throws Exception {
        double cash = this.getBalance();
        if (x > cash) {
            System.out.println("you don't have enough money !");
            System.out.println("your balance is : " + this.balance);

            return false;
        } else {
            System.out.println("with drawing " + x + "$");
            cash -= x;
            System.out.println("Your account has :" + cash + "$");
            this.setBalance(cash);
            History.add("" + LocalDateTime.now().withNano(0) + " withdraw from the account the amount " + x + "$");
            return true;
        }

    }

    public Boolean Deposit(double x) {
        try {
            double cash = this.getBalance();
            System.out.println("Before Deposit " + this.balance);
            cash += x;
            this.setBalance(cash);
            System.out.println("After Deposit " + this.balance);
            History.add("" + LocalDateTime.now().withNano(0) + " Deposit into the account the amount " + x + "$");

            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public void showHistory() {
        if (History.isEmpty()) {
            System.out.println("Hestory is Empty");
        } else {
            for (String event : History) {
                System.out.println(event);
            }
        }
    }
    
}
