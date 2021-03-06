package com.tmobile.yaml.parser;

import org.python.core.PyInstance;
import org.python.util.PythonInterpreter;


public class InterpreterExample
{

    PythonInterpreter interpreter = null;


    public InterpreterExample()
    {
        PythonInterpreter.initialize(System.getProperties(),
                System.getProperties(), new String[0]);

        this.interpreter = new PythonInterpreter();
    }

    void execfile( final String fileName )
    {
        this.interpreter.execfile(fileName);
    }

    PyInstance createClass( final String className, final String opts )
    {
        return (PyInstance) this.interpreter.eval(className + "(" + opts + ")");
    }

    public static void main( String gargs[] )
    {
        InterpreterExample ie = new InterpreterExample();

        ie.execfile("D:\\Hello.py");

        PyInstance hello = ie.createClass("Hello.java", "None");

        //hello.invoke("run");
    }
}