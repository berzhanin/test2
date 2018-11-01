package task13;

import java.util.Objects;

public class Field {
    int id;
    String value;

    //constructor
    public Field(int id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        String result = "Field: " + "id = " + id + ", value = '" + value ;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Field field = (Field) obj;
        return id == field.id &&
                Objects.equals(value, field.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}

