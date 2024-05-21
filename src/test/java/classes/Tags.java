package classes;

public class Tags {
    int id;
    String name;

    public Tags(int id, String name){
        this.name = name;
        this.id = id;
    }

    public Tags(int id){
        this.name = "";
        this.id = id;
    }

    public Tags(String name){
        this.name = name;
        this.id = 0;
    }

    public Tags(){
        this.name = "";
        this.id = 0;
    }
}
