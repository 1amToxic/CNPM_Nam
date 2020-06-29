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
public class Booking {
    private int id;
    private Date bookedDate;
    private int saleoff;
    private Client client;
    private User user;
    private int total; //add to database
    private String name;
    private String idcard,telephone;
    private ArrayList<BookedField> listBookedField;

    public Booking() {
    }
    
}
