package jep533;

import java.sql.SQLOutput;
import java.util.List;

public record Member(String humanName, String precureName, boolean thread, String... messages) {

    public String transform() throws TransformFailedException{
        if(thread){
            Transform.targetThread = Thread.currentThread();
        }
        try {
            for(String message : messages){
                long length = message.length();
                System.out.println(humanName + " : " + message);
                Thread.sleep(length * 200);
            }
            return precureName;

        }catch (InterruptedException e) {
            System.err.println(humanName + "に割り込み発生");
            throw new TransformFailedException(humanName + " : 割り込まれた！");

        }finally {
            System.out.println(humanName + " : スレッド終了");
        }
    }

    public static List<Member> starDetective(boolean interrupt1, boolean interrupt2, boolean interrupt3, boolean interrupt4){
        return List.of(
                new Member("明智あんな", "キュアアンサー", interrupt1,
                        "オープン！ジュエルキュアウォッチ！",
                        "プリキュア！ウェイクアップタイム！",
                        "サン！見つける！",
                        "ロク！向き合う！",
                        "キュー！奇跡のふたり！",
                        "くるっと回して！キュートに決めるよ！",
                        "どんな謎でもはなまる解決！",
                        "名探偵キュアアンサー！"),
                new Member("小林みくる", "キュアミスティック", interrupt2,
                        "オープン！ジュエルキュアウォッチ！",
                        "プリキュア！ウェイクアップタイム！",
                        "サン！見つける！",
                        "ロク！向き合う！",
                        "キュー！奇跡のふたり！",
                        "くるっと回して！キュートに決めるよ！",
                        "重ねた推理で笑顔にジャンプ！",
                        "名探偵キュアミスティック！"),
                new Member("帆羽くれあ", "キュアエクレール", interrupt3,
                        "オープン！トップオブリリーフレグランス！",
                        "プリキュア！ウェイクアップタイム！",
                        "フローラルスピン！",
                        "ブルーム！",
                        "解き放て！内なる真実の香り",
                        "名探偵キュアエクレール！"),
                new Member("森亜るるか", "キュアアルカナ", interrupt4,
                        "オープン！シャインアルカナロッド！",
                        "プリキュア！ウェイクアップタイム！",
                        "輝きなさい純白に！",
                        "フラワータップ！",
                        "真実を照らす白き光",
                        "名探偵キュアアルカナ！",
                        "私の答え示します")
        );
    }
}
