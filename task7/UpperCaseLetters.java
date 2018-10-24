package tests.task7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpperCaseLetters {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char c;
        boolean l = false;
        String s = reader.readLine();
        String str[] = new String[s.length()];
        for (int i=0;i<str.length;i++)
        {
            c = s.charAt(i);
            if (c != ' ')
            {
                str[i] = Character.toString(c);
                if (!l)
                {
                    str[i] = str[i].toUpperCase();
                    l = true;
                }
            }
            else
            {
                str[i] = Character.toString(c);
                l = false;
            }

        }
        s = "";
        for (String a : str) s += a;
        System.out.print(s);
    }
}
