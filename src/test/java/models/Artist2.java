package models;

public class Artist2 implements Artist3{

    public String city;

    public Boolean isFrom(String city){
        if(city == "London"){
            return false;
        }else{
            return true;
        }
    }
}
