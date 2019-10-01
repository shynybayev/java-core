package ru.job4j.refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *  Bank class
 *  @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 *  @version 1.0
 *  @since 0.1
 */
public class Bank {

    /**
     * Map of accounts, one user can have multiple accounts
     */
    private Map<User, ArrayList<Account>> account = new TreeMap<>();

    public Bank() {
    }

    public Bank(Map<User, ArrayList<Account>> account) {
        this.account = account;
    }

    /**
     * This method is used to add the user to the banking system
     * @param user current user
     */
    public void addUser(User user) {
        this.account.put(user, new ArrayList<>());
    }

    /**
     * This method is designed to remove user from the banking system
     * @param user - current user
     */
    public void deleteUser(User user) {
        this.account.remove(user);
    }

    /**
     * Method to add account to user
     * @param user current user
     * @param account current account
     */
    public void addAccountToUser(User user, Account account) {
        this.account.get(user).add(account);
    }

    /**
     * Method to remove account
     * @param user
     * @param account
     */
    public void deleteAccount(User user, Account account) {
        this.account.get(user).remove(account);
    }

    /**
     * return the actual account
     * @param user current user
     * @param account  current account
     * @return
     */
    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> accounts = this.account.get(user);
        return accounts.get(accounts.indexOf(account));
    }

    /**
     * return all user accounts
     * @param user current user
     * @return all accounts
     */
    public List<Account> getAccounts(User user) {
        return this.account.get(user);
    }

    /**
     * Getter for account
     */
    public Map<User, ArrayList<Account>> getAccount() {
        return account;
    }

    /**
     * Setter for account
     */
    public void setAccount(Map<User, ArrayList<Account>> account) {
        this.account = account;
    }

    /**
     * Method for money transfer
     * @param fromUser User Sender
     * @param fromAccount user sender's account
     * @param toUser user recipient
     * @param toAccount user account's recipient
     * @param amount amount of money
     * @return true if the transfer was made
     */
    public boolean transfer(User fromUser, Account fromAccount,
                            User toUser, Account toAccount, double amount) {
        return this.account.get(fromUser).contains(fromAccount)
                && this.account.get(toUser).contains(toAccount)
                && getActualAccount(fromUser, fromAccount).transfer(
                getActualAccount(toUser, toAccount), amount);
    }

    public String toString() {
        return "Bank{" + "accounts=" + account + "}";
    }
}
