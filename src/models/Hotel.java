package models;

public class Hotel {
    private int id;
    private String name;
    private String address;


    public Hotel(int id, String  name, String address){
        setId(id);
        setName(name);
        setAddress(address);
    }

    public Hotel(String name, String address){
        setName(name);
        setAddress(address);
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ID: " +  id  + " Name: " + name + " Address: " + address;
    }



}