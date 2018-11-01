package task13;

import java.util.*;

public class Page {
    ArrayList<Button> buttons = new ArrayList<>();
    LinkedList<Field> fields = new LinkedList<>();
    HashSet<Label> labels = new HashSet<>();
    HashMap<Integer, Dropdown> dropdownHashMap = new HashMap<>();
    float id;
    String title;

    public boolean add(Button newButton) {
        return buttons.add(newButton);
    }

    public boolean remove(Button removedButton) {
        ArrayList newButtons = new ArrayList();


        for (Object button : buttons) {
            if (!button.equals(removedButton)) {
                newButtons.add(button);
            }
        }
        buttons = newButtons;
        return !buttons.contains(removedButton);
    }

    public boolean replace(Button replaceableButton, Button newButton) {

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).equals(replaceableButton))
                buttons.set(i, newButton);
        }
        return buttons.contains(newButton);
    }

    public void printAllButtons() {
        buttons.forEach(System.out::println);
    }

    public boolean add(Field newField) {
        return fields.add(newField);
    }

    public boolean remove(Field removedField) {
        LinkedList newFields = new LinkedList();
        for (Object field : fields) {
            if (!field.equals(removedField)) {
                newFields.add(field);
            }
        }
        fields = newFields;
        return !fields.contains(removedField);
    }

    public boolean replace(Field replaceableField, Field newField) {
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).equals(replaceableField))
                fields.set(i, newField);
        }
        return fields.contains(newField);
    }

    public void printFields() {
        fields.forEach(System.out::println);
    }

    public boolean add(Label newLabel) {
        return labels.add(newLabel);
    }

    public boolean remove(Label removedLabel) {
        return labels.remove(removedLabel);
    }

    public void replace(Label replaceableLabel, Label newLabel) {
        labels.remove(replaceableLabel);
        labels.add(newLabel);
    }

    public void printLabels() {
        labels.forEach(System.out::println);
    }

    public void add(Integer index, Dropdown newDropdown) {
        dropdownHashMap.put(index, newDropdown);
    }

    public void remove(Dropdown removedDropdown) {
        Iterator iterator = dropdownHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if (entry.getValue().equals(removedDropdown)) {
                iterator.remove();
            }
        }
    }

    public void replace(Dropdown replaceableDropdown, Dropdown newDropdown) {
        int key = 0;
        Iterator iterator = dropdownHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if (entry.getValue().equals(replaceableDropdown)) {
                key = (int) entry.getKey();
                break;
            }
        }
        dropdownHashMap.put(key, newDropdown);
    }

    public void replace(int key, Dropdown newDropdown) {
        dropdownHashMap.put(key, newDropdown);
    }

    public void printDropdowns() {
        for (Object dropdown : dropdownHashMap.entrySet()) {
            System.out.println(dropdown);
        }
    }
}
