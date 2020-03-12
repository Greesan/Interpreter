package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    String labelName;
    int address;
    @Override
    public void execute(VirtualMachine wm) {

    }

    @Override
    public void init(ArrayList<String> args)
    {
        if(args != null && args.size() >= 1) {
            codeType = args.get(0);
            dumpable = true;
            if (args.size() == 2) {
                String addressString = args.get(1).split("<<", 2)[1];
                labelName = args.get(1).split("<<", 2)[0];
                address = Integer.parseInt(addressString.split(">>", 2)[0]);
            }
        }
    }

    @Override
    public String toString() {
        return null;
    }
}
