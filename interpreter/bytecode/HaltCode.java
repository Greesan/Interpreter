package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {
    @Override
    public void execute(VirtualMachine wm) {

    }

    @Override
    public void init(ArrayList<String> args) {
        if(args!=null && args.size()==1)
            codeType = args.get(0);
    }

    @Override
    public String toString() {
        return codeType;
    }
}
