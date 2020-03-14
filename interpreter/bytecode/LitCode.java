package interpreter.bytecode;

import interpreter.Program;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode
{
    private int value;
    private String id;

    @Override
    public void execute(VirtualMachine vm) {
        if(vm.isDump)
        {
            toString();
        }
    }

    @Override
    public void init(ArrayList<String> args) {
        if(args!=null && args.size() >= 2) {
            codeType = args.get(0);
            value = Integer.parseInt(args.get(1));
        }
        if(args.size()==3)
            id = args.get(2);
    }

    @Override
    public String toString() {
        String base = " LIT " + value;
        if(id != null){
            base = base + " " + this.id;
        }
        return base;
    }
}
