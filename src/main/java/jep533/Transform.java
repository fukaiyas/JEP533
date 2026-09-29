package jep533;

import java.util.List;
import java.util.concurrent.StructuredTaskScope;

public class Transform {

    public static Thread targetThread = null;

    public static void start(List<Member> members) {

        try(StructuredTaskScope<String, String, TransformFailedException> scope =
                    StructuredTaskScope.open(new SampleJoiner())){

            members.forEach(m -> scope.fork(m::transform));
            System.out.println(scope.join());
            System.out.println("名探偵プリキュア！");

        } catch (InterruptedException e) {
            System.err.println("メインスレッドに割り込み");
        } catch (TransformFailedException e) {
            System.err.println(e.getMessage());
        }
    }
}
