package com.company;

//Задание на лабораторную работу 12. Необходимо доделать приложение из 11 работы, таким образом
//чтобы сведения о введенном ip-адресе записывались в файл, который создается программно в папке с проектом.

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите IP адрес: ");
        String ip = in.nextLine();
        Pattern pattern = Pattern.compile("\\b([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\b");
        Matcher m = pattern.matcher(ip);
        if(m.find()){
            try (PrintWriter wrt = new PrintWriter("IPstate.txt")) {
                System.out.println("Верный IP адрес: ");
                System.out.println(m.group());
                wrt.println("Верный IP адрес: " + m.group());
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        else{
            try (PrintWriter wrt = new PrintWriter("IPstate.txt")) {
                System.out.println("Не найден верный IP адрес");
                wrt.println("Не найден верный IP адрес");
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}












