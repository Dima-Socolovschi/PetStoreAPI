package classes;

public class Category {
    int id;
    String name;

    public Category(int id, String name){
        this.name = name;
        this.id = id;
    }

    public Category(int id){
        this.name = "";
        this.id = id;
    }

    public Category(String name){
        this.name = name;
        this.id = 0;
    }

    public Category(){
        this.name = "";
        this.id = 0;
    }
}
