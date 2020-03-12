package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends JumpCode {
    protected int address;
    protected String labelName;
    @Override
    public void execute(VirtualMachine wm) {

    }

    @Override
    public String toString() {
        String base = codeType + " " + labelName + "<<" + address + ">>";
        return base;
    }


    @Override
    public int getAddress() {
        return address;
    }

    @Override
    public void setAddress(int value) {
        this.address = value;
    }

}
