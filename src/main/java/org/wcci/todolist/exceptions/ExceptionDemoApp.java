package org.wcci.todolist.exceptions;

import org.wcci.todolist.models.TodoItem;

public class ExceptionDemoApp {

    public static void main(String[] args) {


        throwExceptions();

        System.out.println("Made it through");

    }

    private static void throwExceptions() {
        System.out.println("About to throw exceptions");

        try {
            throwDemoException();
            throwDemoRuntimeException();

        } catch (RuntimeException runtimeException) {
            System.out.println("Caught a run time exception!!!!");
            System.out.println(runtimeException.getMessage());
            System.exit(101);
        } catch (Exception caughtException) {
            System.out.println("Caught an exception!");
        }

        System.out.println("Done throwing exceptions");
    }

    private static void throwDemoRuntimeException() {
        throw new DemoRunTimeException("Another message");
    }

    private static void throwDemoException() throws DemoException {
        throw new DemoException("Some message");
    }
}
