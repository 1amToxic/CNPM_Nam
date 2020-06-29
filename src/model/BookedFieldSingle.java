/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lamit
 */
public class BookedFieldSingle {
    private int id;
    private int idBookedField;
    private String playDate;
    private String checkin;
    private String checkout;
    private int total;
    private int penalty;
    private ArrayList<UsedService> list;

    public BookedFieldSingle() {
    }

    public BookedFieldSingle(int idBookedField, String playDate, String checkin, String checkout, int total,int penalty) {
        
        this.idBookedField = idBookedField;
        this.playDate = playDate;
        this.checkin = checkin;
        this.checkout = checkout;
        this.penalty = penalty;
        this.total = total;
    }

    public int getTotal() {
        return total;
    }
    
    public int getIdBookedField() {
        return idBookedField;
    }

    public String getPlayDate() {
        return playDate;
    }

    
    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public int getPenalty() {
        return penalty;
    }
    
}
