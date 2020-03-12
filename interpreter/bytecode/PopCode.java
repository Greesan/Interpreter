package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    int numpop;
    @Override
    public void execute(VirtualMachine wm) {

    }

    @Override
    public void init(ArrayList<String> args) {
        if(args != null && args.size() == 2) {
            codeType = args.get(0);
            numpop = Integer.parseInt(args.get(1));
            dumpable = true;
        }
    }

    @Override
    public String toString() {

    }
}
