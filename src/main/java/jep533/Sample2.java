package jep533;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample2 {

    static void main(String[] args) {

        final Thread currentThread = Thread.currentThread();
        try(ExecutorService executor = Executors.newSingleThreadExecutor()){
            executor.submit(() -> {
                try{
                    Thread.sleep(10000);
                    currentThread.interrupt();
                }catch (InterruptedException e){}
            });
            Transform.start(Member.starDetective(false, false, false, false));
        }
    }
}
