package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends JumpCode {
    @Override
    public void execute(VirtualMachine wm) {

    }

    @Override
    public String toString() {
        return null;
    }


    @Override
    public int getAddress() {
        return address;
    }

    public void setAddress() {

    }
}
