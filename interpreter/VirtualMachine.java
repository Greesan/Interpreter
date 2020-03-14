package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    public RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    public boolean        isDump;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram(){
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        isDump = false;

        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            if (isDump) {
                System.out.println(code);
                this.runTimeStack.dump();
            }
            programCounter++;
        }
    }

    public void pop_req()
    {
        runTimeStack.pop();
    }

    public void push_req(int val)
    {
        runTimeStack.push(val);
    }







}
