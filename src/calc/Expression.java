package calc;


public class Expression {
    private int operand1;
    private String op;
    private int operand2;
    private String type;
    private int result;

    public Expression(int op1, String op, int op2, String type) {
        this.operand1 = op1;
        this.op = op;
        this.operand2 = op2;
        this.type = type;
        this.result = 0;
    }

    public String getType() {return this.type;}

    public void calculate() {
        switch(op) {
            case "+": result = operand1 + operand2; break;
            case "-": result = operand1 - operand2; break;
            case "/": result = operand1 / operand2; break;
            case "*": result = operand1 * operand2; break;
        }
    }

    public int getResult() {
        return this.result;
    }
}
