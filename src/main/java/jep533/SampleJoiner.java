package jep533;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.StructuredTaskScope.Joiner;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class SampleJoiner implements Joiner<String, String, TransformFailedException> {

    private final List<String> subtasks = new ArrayList<>();

    private Throwable failed = null;

    @Override
    public boolean onComplete(Subtask<String> subtask) {
        System.out.println("タスク終了");
        if (subtask.state() == Subtask.State.FAILED) {
            failed = subtask.exception();
            return true;
        }
        subtasks.add(subtask.get());
        return false;
    }

    @Override
    public String result() throws TransformFailedException {
        if (failed != null) {
            throw new TransformFailedException(failed.getMessage(), failed);
        }
        return subtasks.toString();
    }

    @Override
    public String timeout() throws TransformFailedException {
        return "";
    }
}
