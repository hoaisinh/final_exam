package common;

import java.util.Objects;
import java.util.Scanner;

public class CustomFunction {
    private static final Scanner scanner = new Scanner(System.in);
    public static String requiredDataInput(boolean isRequire){
        String temp = "";
        boolean check;
        if(isRequire){
            do {
                temp = scanner.nextLine();
                if(Objects.equals(temp,"")){
                    check = true;
                    System.out.println("Please enter data for this field");
                }else {
                    check = false;
                }
            }while (check);
        }else {
            temp = scanner.nextLine();
        }
        return temp;
    }

    public static String getDataInput(String regexPatten,boolean isRequire){
        String temp;
        if(!Objects.equals(regexPatten, "")){
            boolean check;
            do{
                temp = requiredDataInput(isRequire);
                check = Validation.checkRegex(regexPatten,temp);
                if(!check){
                    System.out.println("Please enter data in the correct format");
                }
            }while (!check);
        }else {
            temp = requiredDataInput(isRequire);
        }
        return temp;
    }
}
