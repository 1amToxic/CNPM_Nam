/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lamit
 */
public class Field {
    private int id;
    private String quality;
    private String name;
    private int price;
    private String des;

    public Field() {
    }

    public Field(int id,String quality, String name, int price, String des) {
        this.id = id;
        this.quality = quality;
        this.name = name;
        this.price = price;
        this.des = des;
    }

    public int getId() {
        return id;
    }
    
    public Object[] toObjects(){
        return new Object[]{this.name,this.quality,this.price,this.des};
    }

    public String getQuality() {
        return quality;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDes() {
        return des;
    }
    
}
