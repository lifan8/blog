package lambda;

public class Person {
    private String type_id;

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    private Double fee;

    Person(String type_id,Double fee){
        this.type_id = type_id;
        this.fee = fee;
    }
}
