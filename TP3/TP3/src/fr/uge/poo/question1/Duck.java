package fr.uge.poo.question1;

public interface Duck {
    void quack();
    default void quackManyTimes(int n){
        for(int i=0; i < n; i++){
            quack();
        }
    }
}

/***
 * Le contrat de l'interface a changé. Et le comportement des classes peuvent changer suivant l'utilisation faite
 * par l'utilisateur.
 * */