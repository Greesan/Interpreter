package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public abstract class JumpCode extends ByteCode {
    protected int address;
    protected String labelName;
    public abstract void execute(VirtualMachine wm);

    @Override
    public void init(ArrayList<String> args) {
        if(args != null && args.size()==2) {
            codeType = args.get(0);
            String addressString = args.get(1).split("<<", 2)[1];
            labelName = args.get(1).split("<<", 2)[0];
            address = Integer.parseInt(addressString.split(">>", 2)[0]);
        }
    }

    public int getAddress()
    {
        return address;
    }

    public void setAddress(int value)
    {
        this.address = value;
    }
}
