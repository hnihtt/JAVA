package SerializationNLambda;

public class Test {
    private String str = "From test";


    Formatter test = (x) -> this.str;

    public void mt() {
        Formatter test1 = (x) -> this.str;
    }
}
