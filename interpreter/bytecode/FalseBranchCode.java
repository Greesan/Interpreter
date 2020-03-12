package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends JumpCode {
    @Override
    public void execute(VirtualMachine wm) {

    }

    @Override
    public String toString() {
        return codeType;
    }

    @Override
    public int getAddress() {
        return address;
    }

}
