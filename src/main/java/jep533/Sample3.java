package jep533;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample3 {

    static void main(String[] args) {

        try(ExecutorService executor = Executors.newSingleThreadExecutor()){
            executor.submit(() -> {
                try{
                    Thread.sleep(10000);
                    Transform.targetThread.interrupt();
                }catch (InterruptedException e){}
            });
            Transform.start(Member.starDetective(false, false, true, false));
        }
    }
}
