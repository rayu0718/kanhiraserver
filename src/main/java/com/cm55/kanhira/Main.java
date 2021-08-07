package com.cm55.kanhira;

import java.io.IOException;

public class Main {

    public static void oldmain(String[] args) {
        try {
            KanwaDict dict = KakasiDictReader.load("dict/kakasidict");
            Kanhira kakasi = new Kanhira(new KanwaDict[] {dict});

            System.out.println(kakasi.convert("海外での介入を終了し、アメリカ軍を国に帰還させるという彼の選挙公約を、ありがちな誤解が存在しているように見える。"));
            System.out.println(kakasi.convert("ヨーロッパ全土、また、ヨーロッパとの関係を通じて他の大陸にも、われわれは騒乱と混乱と敵愾心を起こさなければならない"));
            System.out.println(kakasi.convert("悪名高い悪代官の悪巧みによって、貴社の記者が汽車で帰社した"));

            String lyric = "この世界は非現実\n" +
                    "ただ刷り込まれたビジョン\n" +
                    "\n" +
                    "無限遠点 価値観を今 上書きする 変哲の無い宇宙\n" +
                    "傲慢な神は 目に映らない 光速度で 支配続けるならば\n" +
                    "\n" +
                    "僕は 僕だけは 奇跡的で 致命的な\n" +
                    "マイノリティでいい\n" +
                    "\n" +
                    "I can fly\n" +
                    "あの瞬間、あの場面が キミにとって特別なら\n" +
                    "過去は離れて 行くものなんかじゃなくて\n" +
                    "傷つく事の痛みより 大事なシーン その全ての\n" +
                    "ヒカリが今 ゼロを生む\n" +
                    "There is no god Wonderful new world\n" +
                    "\n" +
                    "この命という夢幻\n" +
                    "まだ錯覚とも知らず\n" +
                    "\n" +
                    "二律背反 パラドクスさえ 限りの無い 世界線で欺き\n" +
                    "感情の支配 軌道秩序は 常識さえ すり替えて行くならば\n" +
                    "\n" +
                    "僕の 僕だけの 苦しみその 欠陥さえ\n" +
                    "アルゴリズムのまま\n" +
                    "\n" +
                    "I can fly\n" +
                    "愛のしるし、愛の言葉、明確なるこの記憶を\n" +
                    "二度と彼方に 置き去りにはしないから\n" +
                    "いつでもまだキミのそばに 隣り合わせ その量子が\n" +
                    "もつれ合えば ゼロになる\n" +
                    "There is no god Wonderful new world\n" +
                    "\n" +
                    "The place is worth visiting twice\n" +
                    "まだ知らない 新しい空 世界線へ繋ぐのさ\n" +
                    "\n" +
                    "I can fly\n" +
                    "あの瞬間、あの場面が キミにとって特別なら\n" +
                    "過去は離れて 行くものなんかじゃなくて\n" +
                    "傷つく事の痛みより 大事なシーン その全ての\n" +
                    "ヒカリが今 ゼロを生む\n" +
                    "There is no god Wonderful new world";
            System.out.println(kakasi.convert(lyric));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}