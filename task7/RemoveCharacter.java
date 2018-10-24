package tests.task7;
//удалить указанный символ , например 'X' везде, где он встречается
public class RemoveCharacter {

    public static void main(String[] args){
        String testString = "MXy nameX iXs DXmitXryX XBeXrzhaXninX";
        char removeOneChar = 'X';
        System.out.println(removeCharacter(testString,removeOneChar));
    }

    public static String removeCharacter(String str, char anyChar){
        StringBuilder stringBuilder = new StringBuilder();
        char[] removeString = str.toCharArray();
        for(int i=0; i<removeString.length; i++){
            if(removeString[i] == anyChar){

            } else {
                stringBuilder.append(removeString[i]);
            }
        }
        return stringBuilder.toString();
    }
}
