package models;

public class Artist {

    private String city;

    public Artist(String city){
        this.city = city;
    }

    public Boolean isFrom(String city){
        if(city == "London"){
            return false;
        }else{
            return true;
        }
    }
}
