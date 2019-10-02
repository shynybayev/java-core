package ru.job4j.bank;

import java.util.*;

/**
 *  Account class
 *  @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 *  @version 1.0
 *  @since 0.1
 */
public class Account {
    private double value;
    private String requisites;

    public Account() {
    }

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Getter for value
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Getter for requistes
     */
    public String getRequisites() {
        return this.requisites;
    }

    /**
     * Setter for account
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Setter for requisites
     */
    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    /**
     * Method for money transfer
     * @param destination actual account
     * @param amount amount of money
     * @return boolean value, if true the transfer is success
     */
    public boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.value && destination != null) {
            success = true;
            this.value -= amount;
            destination.value += amount;
        }
        return success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.value, value) == 0 &&
                Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }

    @Override
    public String toString() {
        return "Account{"
                + "value=" + value
                + ", requisites='" + requisites + '\'' + '}';
    }
}
