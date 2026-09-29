package jep533;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample3 {

    static void main(String[] args) {

        try(ExecutorService executor = Executors.newSingleThreadExecutor()){
            executor.submit(() -> {
                try{
                    Thread.sleep(5000);
                    Transform.targetThread.interrupt();
                }catch (InterruptedException e){}
            });
            Transform.start(List.of(
                    new Member("明智あんな", "キュアアンサー",
                            "オープン！ジュエルキュアウォッチ！",
                            "プリキュア！ウェイクアップタイム！",
                            "サン！見つける！",
                            "ロク！向き合う！",
                            "キュー！奇跡のふたり！",
                            "くるっと回して！キュートに決めるよ！",
                            "どんな謎でもはなまる解決！",
                            "名探偵キュアアンサー！"),
                    new Member("小林みくる", "キュアミスティック", true,
                            "オープン！ジュエルキュアウォッチ！",
                            "プリキュア！ウェイクアップタイム！",
                            "サン！見つける！",
                            "ロク！向き合う！",
                            "キュー！奇跡のふたり！",
                            "くるっと回して！キュートに決めるよ！",
                            "重ねた推理で笑顔にジャンプ！",
                            "名探偵キュアミスティック！"),
                    new Member("帆羽くれあ", "キュアエクレール",
                            "オープン！トップオブリリーフレグランス！",
                            "プリキュア！ウェイクアップタイム！",
                            "フローラルスピン！",
                            "ブルーム！",
                            "解き放て！内なる真実の香り",
                            "名探偵キュアエクレール！"),
                    new Member("森亜るるか", "キュアアルカナ",
                            "オープン！シャインアルカナロッド！",
                            "プリキュア！ウェイクアップタイム！",
                            "輝きなさい純白に！",
                            "フラワータップ！",
                            "真実を照らす白き光",
                            "名探偵キュアアルカナ！",
                            "私の答え示します")
            ));
        }

    }
}
