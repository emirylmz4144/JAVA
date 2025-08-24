import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static boolean control(String forControl)
    {

        Stack<Character> beginChars=new Stack<>();
        for(char c:forControl.toCharArray())
        {
            if (c=='{'||c=='(' ||c=='[')
                beginChars.push(c);


            else if (c=='}'||c==')'||c==']')
            {
                if (beginChars.isEmpty())
                    return false;

                char control=beginChars.pop();
                if ((control=='(' && c!=')')||(control=='{' &&c!='}')||(control=='['&&c!=']'))
                    return false;

            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String s;
        List<String> allInput=new ArrayList<>();

        while ((s=input.nextLine())!="")
          allInput.add(s);

        for (String sendToControl:allInput)
            System.out.println(control(sendToControl));
    }
}