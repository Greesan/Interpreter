
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class ByteCodeLoader extends Object {
    /*
        resolve address?
        ByteCode code = program.get(0)
        COULD COME UP WITH JUMPCODE ABSTRACTION WHICH FTC,CALL, AND GOTO EXTENDS
        if(code instanceof(FBC))
            three steps
        else if (GOTO)
        else if(CALL)
     */
    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts. Can also use the split function in the String class.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() throws IOException {
        Program interpreter = new Program();
        if (this.byteSource.readLine() == null)
            return null;
        String line = this.byteSource.readLine();
        while(line != null) {
            String[] tokens = line.split(" ");
            ArrayList<String> args = new ArrayList<String>();
            for (int i = 1; i < tokens.length; i++)
                args.add(tokens[i]);
            String className = CodeTable.getClassName(tokens[0]);
            Class classBluePrint = null;
            try
            {
                classBluePrint = Class.forName("interpreter.bytecode." + className);
                ByteCode code = (ByteCode) classBluePrint.getConstructor().newInstance();
                code.init(args);
                interpreter.insertByteCode(code);
            }
            catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                    InstantiationException | InvocationTargetException e)
            {
                e.printStackTrace();
            }
            line = this.byteSource.readLine();
        }
        interpreter.resolveAddress();
        return interpreter;
    }
}
