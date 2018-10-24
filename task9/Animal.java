package task9;
import java.util.Arrays;

public class Animal {

        public void pringAnimals(String...animals){
            //вариант стримами
            Arrays.asList(animals).stream().forEach(animal -> System.out.println(animal));

            //вариант for
            for(String animal : animals){
                System.out.println(animal);
            }
        }


}
