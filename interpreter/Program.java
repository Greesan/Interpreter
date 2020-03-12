package interpreter;

import interpreter.bytecode.*;

import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }
    // this function returns the ByteCode at a given index.
    protected ByteCode getCode(int index) {
        return this.program.get(index);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    /*
        resolve address?
        ByteCode code = program.get(0)
        COULD COME UP WITH JUMPCODE ABSTRACTION WHICH FBC,CALL, AND GOTO EXTENDS
        for (int j = 0; j <program.getSize();j++)
        if(code instanceof(FBC))
            three steps
        else if (GOTO)
            three steps
        else if(CALL)
            three steps
     */
    public void resolveAddress()
    {
        ByteCode code;
        for(int i = 0; i < program.size();i++)
        {
            code = program.get(i);
            if(code instanceof JumpCode)
            {
                for(int j = 0; i< program.size();j++)
                {
                    if(code instanceof LabelCode)
                    {

                    }
                }
            }
        }
    }

    public void insertByteCode(ByteCode code)
    {
        if(code != null)
            program.add(code);
    }
}
