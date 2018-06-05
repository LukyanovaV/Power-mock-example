public class Second {


    public String method(){

        return "Hello";

    }

    public String callPrivateMethod(){
        return "Hello "+ privatMethod();
    }

    private String privatMethod(){
        return "person";
    }
}
