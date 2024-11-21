package fr.uge.poo.stp.question1;

import com.evilcorp.stp.*;

import java.util.Optional;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        var commandFind = new CommandTreatmentVisitor();
        var scan = new Scanner(System.in);

        while(scan.hasNextLine()){
            var line = scan.nextLine();
            if (line.equals("quit")){
                break;
            }

            Optional<STPCommand> answer = STPParser.parse(line);
            if (!answer.isPresent()){
                System.out.println("Unrecognized command");
                continue;
            }

            STPCommand cmd = answer.get();
            cmd.accept(commandFind);
         }
        }
    }

