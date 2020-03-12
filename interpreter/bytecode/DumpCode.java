package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    boolean on;
    @Override
    public void execute(VirtualMachine wm) {

    }

    @Override
    public void init(ArrayList<String> args)
    {
        if(args!=null && args.size() ==2)
        {
            codeType = args.get(0);
            if(args.get(1) == "ON")
                on = true;
            else if(args.get(1) == "OFF")
                on = false;
        }
    }

    @Override
    public String toString() {
        if(on)
            return codeType + " ON";
        return codeType + " OFF";
    }
}
