package org.example.exs1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidNumbers {

    private List<String> numberList = new ArrayList<>();
    private File file;

    public ValidNumbers(File file) {
        this.file = file;
    }

    public void getNumbers(){
        String results = "";
        try(Scanner s = new Scanner(file)){
            while(s.hasNext()){
                numberList.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < numberList.size();i++ ){
            if(isValidNumber(numberList.get(i))){
                results += "\n" + numberList.get(i);
            }
        }
        System.out.println(results);

    }

    private static boolean isValidNumber(String phoneNumber) {
        String regex = "^\\((\\d{3})\\) (\\d{3})-(\\d{4})$|^\\d{3}-\\d{3}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(phoneNumber).matches();
    }
}

