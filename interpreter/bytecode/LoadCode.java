package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    int offset;
    String identifier;
    @Override
    public void execute(VirtualMachine wm) {

    }

    @Override
    public void init(ArrayList<String> args) {
        if(args!=null && args.size() >= 2)
        {
            codeType = args.get(0);
            offset = Integer.parseInt(args.get(1));
            identifier = args.get(2);
        }
    }

    @Override
    public String toString() {
        return null;
    }
}
