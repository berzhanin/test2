package tests.task10;

public abstract class Sentence extends Paragraph {

    protected String sentenceClassName;

    //constructors
    Sentence(String anyClassname, String anyClassName) {
        super(anyClassname);
        this.sentenceClassName = anyClassName;
    }

    //abstract methods
    public abstract void printSuperClass();


}
