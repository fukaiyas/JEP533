package jep533;

import java.util.List;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class Transform {

    public static Thread targetThread = null;

    public static void start(List<Member> members) {

        try(StructuredTaskScope<String, String, TransformFailedException> scope =
                    StructuredTaskScope.open(new SampleJoiner())){

            List<Subtask<String>> tasks = members.stream().map(m -> scope.fork(m::transform)).toList();
            scope.join();
            System.out.println(tasks.stream().map(Subtask::get).toList());
            System.out.println("名探偵プリキュア！");

        } catch (InterruptedException e) {
            System.err.println("メインスレッドに割り込み");

        } catch (TransformFailedException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
