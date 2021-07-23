/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Prabhakar
 */
public class PaymentInfo {
    String name,contact;
    double grossamt,discount,netamt;
    int table_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getGrossamt() {
        return grossamt;
    }

    public void setGrossamt(double grossamt) {
        this.grossamt = grossamt;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getNetamt() {
        return netamt;
    }

    public void setNetamt(double netamt) {
        this.netamt = netamt;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }
        
    
}
