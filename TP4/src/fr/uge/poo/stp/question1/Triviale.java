package fr.uge.poo.stp.question1;

import com.evilcorp.stp.CommandTreatmentVisitor;
import com.evilcorp.stp.HelloCmd;
import com.evilcorp.stp.STPParser;

import java.util.Scanner;

public class Triviale {
    public static void main(String[] args) {
         try(var sc = new Scanner(System.in)){
             while(sc.hasNextLine()){
                 var name = sc.nextLine();
                 var nameParse = STPParser.parse(sc.nextLine());
                 if(name.equals("quit")){
                     break;
                 }
                 if(nameParse.isEmpty()){
                     var command = new CommandTreatmentVisitor();
                     nameParse.get().accept(command);
                 } else{

                 }
             }
         }
    }
}

/**
 * Open-closed n'est pas respecté
 *
 * En ajoutant une méthode dans l'interface qui sera implémenté par les classes. Non, car chaque application
 * utiliseront à leur manière la librairie donc devront rajouter des méthddes à chaque fois.
 *
 * C'est le patron visitor.
 * */