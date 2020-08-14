package calc;

import java.io.IOException;

public class Parser {

    public final String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    public final String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public Parser() {}

    public Expression parse(String str) {
        String[] splits = str.split(" ");
        int op1 = 0, op2 = 0;
        String type = "arab";
        try {
            if(splits.length != 3) throw new IOException("Incorrect input: enter 2 numbers and operation.");
            boolean flag1_arab = false,
                    flag2_arab = false,
                    flag1_rome = false,
                    flag2_rome = false;
            for(String number : arab) {
                if(splits[0].equals(number)) {
                    flag1_arab = true;
                    op1 = Integer.parseInt(splits[0]);
                }
                if(splits[2].equals(number)) {
                    flag2_arab = true;
                    op2 = Integer.parseInt(splits[2]);
                }
            }
            if((!flag1_arab && flag2_arab) || (flag1_arab && !flag2_arab))
                throw new IOException("Incorrect input: must be one alphabet (arab or rome).");
            if(flag1_arab && flag2_arab) return new Expression(op1, splits[1], op2, type);
            if(!flag1_arab && !flag2_arab) {
                type = "rome";
                for(String number : rome) {
                    if(splits[0].equals(number)) {
                        flag1_rome = true;
                        for(int i = 0; i < rome.length; i++) {
                            if(number.equals(rome[i])) {
                                op1 = Integer.parseInt(arab[i]);
                                break;
                            }
                        }
                    }
                    if(splits[2].equals(number)) {
                        flag2_rome = true;
                        for(int i = 0; i < rome.length; i++) {
                            if(number.equals(rome[i])) {
                                op2 = Integer.parseInt(arab[i]);
                                break;
                            }
                        }
                    }
                }
                if(!flag1_rome || !flag2_rome) throw new IOException("Incorrect input: must be one alphabet (arab or rome).");
            }
        } catch(IOException exc) {
            System.out.println(exc.getMessage());
            return null;
        }
        return new Expression(op1, splits[1], op2, type);
    }

    public void convertAndPrint(int number) {
        if(number > 10 && number < 40) {
            for(int i = 0; i < (number / 10); i++) {
                System.out.print("X");
            }
        }
        else if(number >= 40) {
            int n = number;
            n -= (number % 10);
            switch(n) {
                case 40: System.out.print("XL"); break;
                case 50: System.out.print("L"); break;
                case 60: System.out.print("LX"); break;
                case 70: System.out.print("LXX"); break;
                case 80: System.out.print("LXXX"); break;
                case 90: System.out.print("XC"); break;
                case 100: System.out.print("C"); break;
            }
        }
        number %= 10;
        for(int i = 0; i < arab.length; i++) {
            if(number == Integer.parseInt(arab[i])) {
                System.out.println(rome[i]);
                break;
            }
        }
    }
}
