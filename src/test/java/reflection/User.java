package reflection;

import annotation.TestAnnotation1;

public class User {
    @TestAnnotation1(columnName = "id",type = "int",length = 10)
    private int id;
    private int age;
    private String uname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public User(){}

    public User(int id, int age, String uname){
        this.id = id;
        this.age= age;
        this.uname = uname;
    }
}
