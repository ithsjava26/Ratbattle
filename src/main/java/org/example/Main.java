package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        String code = IO.readln("Enter pin code: ");
        if ("1234".equals(code))
            IO.println("Welcome to the main program!");
        else
            IO.println("Wrong code!");
    }
}
