package task13;

public class PageExample {
    public static void main(String[] args) {
        Page page = new Page();
        methodsButton(page);
        methodsField(page);
        methodsLabel(page);
        methodsDropdown(page);
    }

    private static void methodsButton(Page page) {
        Button button1 = new Button("button1", "action1");
        Button button2 = new Button("button2", "action2");
        Button button3 = new Button("button3", "action3");
        Button button4 = new Button("button4", "action4");

        page.add(button1);
        page.add(button2);
        page.add(button3);
        System.out.println("Вывести все объекты класса Button после создания: ");
        page.printAllButtons();
        System.out.println();
        page.remove(button1);
        System.out.println("Вывести все объекты класса Button после удаления: ");
        page.printAllButtons();
        System.out.println();
        page.replace(button2, button4);
        System.out.println("Вывести все объекты класса Button после замены: ");
        page.printAllButtons();
    }

    private static void methodsField(Page page) {
        Field field1 = new Field(1, "field1");
        Field field2 = new Field(2, "field2");
        Field field3 = new Field(3, "field3");
        Field field4 = new Field(4, "field4");

        page.add(field1);
        page.add(field2);
        page.add(field3);
        System.out.println("\nВывести все объекты класса Field после создания: ");
        page.printFields();
        System.out.println();
        page.remove(field1);
        System.out.println("Вывести объекты класса Field после удаления: ");
        page.printFields();
        System.out.println();
        page.replace(field2, field4);
        System.out.println("Вывести объекты класса Field после замены: ");
        page.printFields();
    }

    private static void methodsLabel(Page page) {
        Label label1 = new Label("label1");
        Label label2 = new Label("label2");
        Label label3 = new Label("label3");
        Label label4 = new Label("label4");

        page.add(label1);
        page.add(label2);
        page.add(label3);
        System.out.println("\nВывести все объекты класса Label после создания: ");
        page.printLabels();
        System.out.println();
        page.remove(label1);
        System.out.println("Вывести все объекты класса Label после удаления: ");
        page.printLabels();
        System.out.println();
        page.replace(label2, label4);
        System.out.println("Вывести все объекты класса Label после замены: ");
        page.printLabels();
    }

    private static void methodsDropdown(Page page) {
        Dropdown dropdown1 = new Dropdown("dropdown1");
        Dropdown dropdown2 = new Dropdown("dropdown2");
        Dropdown dropdown3 = new Dropdown("dropdown3");
        Dropdown dropdown4 = new Dropdown("dropdown4");

        page.add(1, dropdown1);
        page.add(2, dropdown2);
        page.add(3, dropdown3);
        System.out.println("\nВывести все объекты класса Dropdowns после создания: ");
        page.printDropdowns();
        System.out.println();
        page.remove(dropdown1);
        System.out.println("Вывести все объекты класса Dropdowns после удаления: ");
        page.printDropdowns();
        System.out.println();
        page.replace(dropdown2, dropdown4);
        System.out.println("Вывести все объекты класса Dropdowns после замены: ");
        page.printDropdowns();
    }
}
