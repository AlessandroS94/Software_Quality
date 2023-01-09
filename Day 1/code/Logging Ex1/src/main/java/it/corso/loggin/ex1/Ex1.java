package it.corso.loggin.ex1;

import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex1 {

    final static Logger logger = Logger.getLogger(Ex1.class);

    public static void main(String[] args) {
        Ex1 obj = new Ex1();
        obj.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("INSERISCI UN VALORE NUMERICO");
            int input = scanner.nextInt();
			System.out.println("INSERISCI UN VALORE NUMERICO");
			int input2 = scanner.nextInt();
            input = this.divide(input,input2);
            System.out.println(input);
        } catch (InputMismatchException inputMismatchException) {
        } catch (ArithmeticException ex) {
        } catch (Exception exception) {
        }
    }

    public int divide(int input,int input2) {

        return (input / input2);
    }
}
