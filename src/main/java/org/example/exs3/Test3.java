package org.example.exs3;

import java.io.File;

public class Test3 {

    public static void main(String[] args) {
        ReaderAndCounter test = new ReaderAndCounter(new File("words.txt"));
        test.getWords();
    }
}

