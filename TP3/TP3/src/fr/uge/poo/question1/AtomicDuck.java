package fr.uge.poo.question1;

public class AtomicDuck implements Duck{
    @Override
    public void quack() {
        System.out.println("Atomic Quack");
    }

//    @Override
//    public void quackManyTimes(int n) {
//        for(int i=0; i < n; i++){
//            quack();
//        }
//    }

}
