package com.company;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner answ = new Scanner(System.in);
        System.out.println("Введите ваш х: ");
        double num = answ.nextDouble();
        System.out.println("Вводите степень (>0): ");
        int k = answ.nextInt();
        double pi = 3.1415926;
        while (num > 2 * pi) {
            num -= 2 * pi;
            }

        double sum = Teylor(k, num);
        BigDecimal s = Teylor_big(k,BigDecimal.valueOf(num));
        System.out.println("Ваша сумма в примитивных типах данных: " + sum);
        System.out.println("Ваша сумма в BigDecimal: " + s);
    }

    public static double Teylor(int  k, double x)
    {
        int n = 1;
        double sum = x;
        double tmp = x;
        double e = Math.pow(10, -k);
        while (Math.abs(tmp) > e)
        {
            tmp*=x*x/(2*n+1)/(2*n)*(-1);
            sum += tmp;
            n+=1;
        }
        return sum;
    }
    public static BigDecimal Teylor_big(int k, BigDecimal x)
    {
        int n = 1;
        BigDecimal tmp;
        BigDecimal sum;
        sum = x;
        tmp = x;
        MathContext mc = new MathContext(10);
        BigDecimal e = BigDecimal.TEN.pow(-k, mc);
        while (tmp.abs().compareTo(e) > 0)
        {
            tmp = tmp.multiply(x).multiply(x);
            tmp = tmp.divide((BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(n))), mc);
            tmp = tmp.divide((BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(n)).add(BigDecimal.ONE)), mc);
            tmp = tmp.multiply(BigDecimal.valueOf(-1));
            sum = sum.add(tmp);
            n+=1;
        }
        return sum;
    }
}

