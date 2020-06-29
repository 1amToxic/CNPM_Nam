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
public class Client {
    private int id;
    private String name;
    private String address;
    private String idcard;
    private String telephone;
    private String email;
    private String des;

    public Client() {
    }
    
    public Client(int id, String name, String address, String idcard, String telephone, String des) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.idcard = idcard;
        this.telephone = telephone;
        this.des = des;
    }
    
   
    public Client(String name, String address, String idcard, String telephone, String email, String des) {
        this.name = name;
        this.address = address;
        this.idcard = idcard;
        this.telephone = telephone;
        this.email = email;
        this.des = des;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    public String getEmail() {
        return email;
    }
    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getDes() {
        return des;
    }
    public Object[] toObjects(){
        return new Object[]{name,address,idcard,telephone,des};
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", address=" + address + ", idcard=" + idcard + ", telephone=" + telephone + ", email=" + email + ", des=" + des + '}';
    }
    
}
