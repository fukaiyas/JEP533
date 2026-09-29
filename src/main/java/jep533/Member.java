package jep533;

public record Member(String humanName, String precureName, boolean thread, String... messages) {

    public Member(String humanName, String precureName, String... messages) {
        this(humanName, precureName, false, messages);
    }

    public String transform() throws TransformFailedException{
        if(thread){
            Transform.targetThread = Thread.currentThread();
        }
        try {
            for(String message : messages){
                long length = message.length();
                System.out.println(humanName + " : " + message);
                Thread.sleep(length * 100);
            }
            return precureName;
        }catch (InterruptedException e) {
            throw new TransformFailedException(humanName + " : 割り込まれた！");
        }finally {
            System.out.println(humanName + " : スレッド終了");
        }
    }
}
