package Statements;

public class Print extends Statement {

    private String var;
    public static StringBuffer stringBuffer ;
    public Print(String var,int lineNumber) {
        //this.setVar(super.variableGetValue(var));
        this.setVar(var);
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public Number run() {
        Number output = super.variableGetValue(this.var,super.getLineNumber());
        stringBuffer = new StringBuffer() ;
        stringBuffer.append(output) ;
        return String.valueOf(output).length();
    }

}
