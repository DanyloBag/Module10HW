package org.example.exs1;

import java.io.File;

public class Test1 {
    public static void main(String[] args) {
        ValidNumbers numbers = new ValidNumbers(new File("file.txt"));
        numbers.getNumbers();
    }
}
