package me.hailu.composer.player.jfugue;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class HelloWorld {

    public static void main(String[] args) {
//        Player player = new Player();
//        player.play("C D E F G A B");

//        Player player = new Player();
//        player.play("V0 I[Piano] Eq Ch. | Eq Ch. | Dq Eq Dq Cq   V1 I[Flute] Rw | Rw | GmajQQQ CmajQ");

//        Pattern p1 = new Pattern("V0 I[Piano] Eq Ch. | Eq Ch. | Dq Eq Dq Cq");
//        Pattern p2 = new Pattern("V1 I[Flute] Rw     | Rw     | GmajQQQ  CmajQ");
//        Player player = new Player();
//        player.play(p1, p2);

        Pattern p1 = new Pattern("Eq Ch. | Eq Ch. | Dq Eq Dq Cq").setVoice(0).setInstrument("Piano");
        Pattern p2 = new Pattern("Rw     | Rw     | GmajQQQ  CmajQ").setVoice(1).setInstrument("Flute");
        Player player = new Player();
        player.play(p1, p2);
    }
}
