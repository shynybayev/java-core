package ru.job4j.refactoring;

import java.util.Objects;

/**
 *  Account class
 *  @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 *  @version 1.0
 *  @since 0.1
 */
public class Account {
    private double values;
    private String requisites;

    public Account(){
    }

    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    /**
     * Getter for values
     */
    public double getValues() {
        return this.values;
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
    public void setValues(double values) {
        this.values = values;
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
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.values, values) == 0 &&
                Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, requisites);
    }

    @Override
    public String toString() {
        return "Account{"
                + "values=" + values
                + ", requisites='" + requisites + '\'' + '}';
    }
}
