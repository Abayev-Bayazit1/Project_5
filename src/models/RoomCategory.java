package models;

public class RoomCategory {
    private int id;
    private String name;

    public RoomCategory(int id, String name){
        setId(id);
        setName(name);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category ID: " + id + " | Name: " + name;
    }
}
