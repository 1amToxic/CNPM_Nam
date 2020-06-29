/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lamit
 */
public class BookedField {
    private int id;
    private String startmatch;
    private String endmatch;
    private LocalDate starttime;
    private LocalDate endtime;
    private int price;
    private int saleoff;
    private Field field;
    private String des;
    private String nameField;
    private ArrayList<UsedService> listUsedService; 

    public BookedField() {
    }

    public BookedField(String startmatch, String endmatch, LocalDate starttime, LocalDate endtime, 
            int price, int saleoff, Field field, String des, String nameField) {
        this.startmatch = startmatch;
        this.endmatch = endmatch;
        this.starttime = starttime;
        this.endtime = endtime;
        this.price = price;
        this.saleoff = saleoff;
        this.field = field;
        this.des = des;
        this.nameField = nameField;
    }

    public int getId() {
        return id;
    }

    public String getStartmatch() {
        return startmatch;
    }

    public String getEndmatch() {
        return endmatch;
    }

    public LocalDate getStarttime() {
        return starttime;
    }

    public LocalDate getEndtime() {
        return endtime;
    }

    public int getPrice() {
        return price;
    }

    public int getSaleoff() {
        return saleoff;
    }

    public Field getField() {
        return field;
    }

    public String getDes() {
        return des;
    }

    public String getNameField() {
        return nameField;
    }

    public ArrayList<UsedService> getListUsedService() {
        return listUsedService;
    }
    
    
}
