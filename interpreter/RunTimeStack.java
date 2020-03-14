package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {
    //bop bytecode is basically assignment one
    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
        int i = 0;
        int fppointer = 0;
        while (i < runTimeStack.size()) {
            int fpbarrier = framePointer.get(fppointer);
            System.out.print(" [");
            while (i < fpbarrier) {
                System.out.print(runTimeStack.get(i) + " ");
                i++;
            }
            System.out.print("]");
            fppointer++;
        }
    }
    public int peek(){
        return runTimeStack.get(runTimeStack.size()-1);
    }

    public int push(int i){
        runTimeStack.add(i);
        return i;
    }

    public int pop(){
        int temptop = runTimeStack.get(runTimeStack.size()-1);
        runTimeStack.remove(runTimeStack.size()-1);
        return temptop;
    }

    public int store(int offset)
    {
        if(framePointer.peek()+offset<runTimeStack.size()-1) {
            runTimeStack.add(framePointer.peek() + offset, pop());
            return framePointer.get(framePointer.peek() + offset);
        }
        return -1;
    }

    public int load(int offset)
    {
        if(framePointer.peek()+offset <= runTimeStack.size()-1) {
            runTimeStack.add(runTimeStack.get(framePointer.peek()+offset));
            runTimeStack.remove(offset);
            return runTimeStack.get(offset);
        }
        return -1;
    }

    public void newFrameAt(int offset)
    {
        if(offset < runTimeStack.size()-1)
            framePointer.push(runTimeStack.size()-1-offset);
    }

    public void popFrame()
    {
        while(runTimeStack.size()>framePointer.peek())
        {
            pop();
        }
        framePointer.pop();
    }
}
