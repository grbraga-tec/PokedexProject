package Pokedex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidarNumero {




        public static double ValidarNumerosDouble(Scanner teclado, String msg){
            while(true){
                try{
                    System.out.println(msg);
                    return teclado.nextDouble();
                }catch (InputMismatchException e){
                    System.out.println("Apenas números");
                    teclado.nextLine();
                }
            }
        }





        public static int ValidarNumerosInt(Scanner teclado, String msg){
            while(true){
                try{
                    System.out.println(msg);
                    return teclado.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("Apenas números !");
                    teclado.nextLine();
                }
            }
        }



    }


