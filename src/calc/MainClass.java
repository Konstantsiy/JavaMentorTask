package calc;

import java.io.*;

public class MainClass {
    public static void main(String[] args) {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input: ");
        String userStr;
        try {
            userStr = bufferReader.readLine();
        } catch(IOException exc) {
            System.out.println("Error:" + exc.getMessage());
            return;
        }
        Parser parser = new Parser();
        Expression expression = parser.parse(userStr);
        expression.calculate();
        System.out.print("Output: ");
        if(expression.getType().equals("arab")) System.out.println(expression.getResult());
        else {
            parser.convertAndPrint(expression.getResult());
        }
    }
}
