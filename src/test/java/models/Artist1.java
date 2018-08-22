package models;

public class Artist1 implements Artist3{

    public String city;

    public int age;

    public String nationality;

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean isFrom(String city){
        if(city == "London"){
            return true;
        }else{
            return false;
        }
    }
}
