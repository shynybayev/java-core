package ru.job4j.bank;

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
        this.account.putIfAbsent(user, new ArrayList<>());
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
     * @param passport current user passport
     * @param account current account
     */
    public void addAccountToUser(String passport, Account account) {
        this.account.get(passport).add(account);
    }

    /**
     * Method to remove account
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.account.get(passport).remove(account);
    }

    /**
     * return the actual account
     * @param passport current user
     * @param requisite  current account
     * @return actual account
     */
    private Account getActualAccount(String passport, String requisite) {
        ArrayList<Account> accounts = this.account.get(passport);
        return accounts.get(accounts.indexOf(requisite));
    }

    /**
     * return all user accounts
     * @param passport current user
     * @return all accounts
     */
    public List<Account> getUserAccounts(String passport) {
        return this.account.get(passport);
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
     * @param srcPassport User Sender
     * @param srcRequisite sender's requisite
     * @param destPassport dest's recipient
     * @param dstRequisite user's recipient
     * @param amount amount of money
     * @return true if the transfer was made
     */
    public boolean transfer(String srcPassport, String srcRequisite,
                            String destPassport,  String dstRequisite, double amount) {
        return this.account.get(srcPassport).contains(srcRequisite)
                && this.account.get(destPassport).contains(dstRequisite)
                && getActualAccount(srcPassport, srcRequisite).transfer(
                getActualAccount(destPassport, dstRequisite), amount);
    }

    @Override
    public String toString() {
        return "Bank{"
                + "account=" + account + '}';
    }
}
