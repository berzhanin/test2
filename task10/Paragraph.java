package tests.task10;

public abstract class Paragraph {

    //variable
    protected String paragraphClassName;

    //constructors
    Paragraph(String anyClassname) {
        this.paragraphClassName = anyClassname;
    }

    //abstract methods
    public abstract void printClassName();
}
