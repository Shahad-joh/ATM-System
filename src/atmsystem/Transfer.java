/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
public class Transfer {
    // History of all transitions between the users
    static ArrayList<String> transitionHistory = new ArrayList<String>();

    // transfer money between users
    public static Boolean transferMoney(User fromUser, User toUser, Double amount) throws Exception {
        if (fromUser.getBalance() >= amount) {
            fromUser.withdraw(amount);
            toUser.Deposit(amount);

            System.out.println("transfer the amount " + amount + "$ from " + fromUser.getFirstName() + " "
                    + fromUser.getLastName() + " to " + toUser.getFirstName() + " " + toUser.getLastName());
            transitionHistory.add( "" + LocalDateTime.now().withNano(0) + " transfer the amount " + amount + "$ from " + fromUser.getFirstName() + " "
                    + fromUser.getLastName() + " to " + toUser.getFirstName() + " " + toUser.getLastName());
            fromUser.History.add("send amount " + amount + "$ to " + toUser.getFirstName() + " " + toUser.getLastName());
            toUser.History.add("recive amount " + amount + "$ from " + fromUser.getFirstName() + " " + fromUser.getLastName());

            return true;
        } else {
            System.out.println("there is no enough moneny in your account");
            System.out.println("your account has : " + fromUser.getBalance() + "$");
            return false;
        }

    }

    public static void showTransactionHistory() {
        if (transitionHistory.isEmpty()) {
            System.out.println("History is Empty");

        } else {
            for (String transmition : transitionHistory) {
                System.out.println(transmition);
            }
        }
    }


}
