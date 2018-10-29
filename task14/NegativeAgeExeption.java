package tests.task14;

public class NegativeAgeExeption extends Exception {

    @Override
    public String getMessage() {

        return "The Age cannot be negative";
    }
}
