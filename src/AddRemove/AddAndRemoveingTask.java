package AddRemove;

import java.util.ArrayList;
import java.util.List;

public class AddAndRemoveingTask {
    public static void main(String[] args) throws InterruptedException {
        List <Integer> list = new ArrayList<>();
        Runnable addNumber = ()->{
            for(int i =0; i < 100 ; i++){
                list.add(i);
            }
        };
        Runnable removeNumber  = ()->{
            for(int i =0; i < 50 ; i++) {
                if (!list.isEmpty()) {
                    list.remove(i);
                }
            }
        };

        Thread add = new Thread(addNumber);
        Thread remove = new Thread(removeNumber);

        add.start();
        remove.start();

        add.join();
        remove.join();

        System.out.println("List : " + list);
        System.out.println("Size : " + list.size());
    }
}
