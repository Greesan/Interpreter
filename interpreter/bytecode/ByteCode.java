package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode {
    protected String codeType;
    protected boolean dumpable;
    protected abstract void execute(VirtualMachine wm);
    public abstract void init(ArrayList<String> args);
    public abstract String toString();
    public boolean getDumpable()
    {
        return dumpable;
    }
}
