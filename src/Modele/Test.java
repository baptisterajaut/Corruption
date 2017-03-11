package Modele;
import Modele.Cartes.Abstacts.Card;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

/**
 * Created by bapti on 09/03/2017.
 */
public class Test {


    public static void main(String[] args) {
        for(int i=0;i<15;i++)
        System.out.println(new Random().nextInt(4)+1);
    }
}
