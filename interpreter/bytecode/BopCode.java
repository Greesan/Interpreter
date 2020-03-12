package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    String operand;
    @Override
    public void execute(VirtualMachine wm) {

    }

    @Override
    public void init(ArrayList<String> args) {
        if(args!=null && args.size() == 2)
        {
            codeType = args.get(0);
            operand = args.get(1);
        }
    }

    @Override
    public String toString() {
        String base = codeType + " " + operand;
        return base;
    }
}
