import java.util.Scanner;

public class StrCalculator {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        String text = console.nextLine();
        char first = text.charAt(0);
        if (first != '\"'){
            throw new Exception("Первым аргументом выражения должна быть строка");
        }
        String[] element;
        char operation;
        if (text.contains(" + ")) {
            element = text.split(" \\+ ");
            operation = '+';
        } else if (text.contains(" - ")) {
            element = text.split(" - ");
            operation = '-';
        } else if (text.contains(" * ")) {
            element = text.split(" \\* ");
            operation = '*';
        } else if (text.contains(" / ")) {
            element = text.split(" / ");
            operation = '/';
        } else {
            throw new Exception("Нет такой арифметической операции");
        }
        if (operation == '*' || operation == '/'){
            if (element[1].contains("\"")) throw new Exception("Второй аргумент должен быть числом");
        }
        if (operation == '+' || operation == '-'){
            if (!element[1].contains("\"")) throw new Exception("Второй аргумент должен быть строкой");
        }
        for (int i = 0; i < element.length; i++) {
            element[i] = element[i].replace("\"", "");
        }
        if (element[0].length() > 10 || element[1].length() > 10) throw new Exception("Строки не могут быть больше 10 символов");
        if (operation == '+'){
            System.out.println("\""+element[0]+element[1]+"\"");
        } else if (operation == '-') {
            int index = element[0].indexOf(element[1]);
            if(index == -1){
                System.out.println("\""+element[0]+"\"");
            } else {
                String result = element[0].substring(0, index);
                result += element[0].substring(index+element[1].length());
                System.out.println("\""+result+"\"");
            }
        } else if (operation == '*') {
            int multiplier = Integer.parseInt(element[1]);
            String result = "";
            if (multiplier < 1 || multiplier > 10) throw new Exception("Диапазон чисел от 1 до 10");
            for (int i = 0; i < multiplier; i++) {
                result += element[0];
            }
            resultOfMultiplier(result);
        } else {
            int multiplier = Integer.parseInt(element[1]);
            int length = element[0].length()/Integer.parseInt(element[1]);
            if (multiplier < 1 || multiplier > 10) throw new Exception("Диапазон чисел от 1 до 10");
            String result = element[0].substring(0, length);
            System.out.println("\""+result+"\"");
        }
    }

    private static void resultOfMultiplier(String result) {
        if (result.length() > 40){
            result = result.substring(0,40) + "...";
            System.out.println("\""+result+"\"");
        } else {
            System.out.println("\""+result+"\"");
        }
    }
}
