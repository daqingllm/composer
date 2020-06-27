package me.hailu.composer.player.jfugue;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.theory.ChordProgression;

import java.io.IOException;

public class TwelveBarBlues {

    public static void main(String[] args) throws IOException {
        Pattern pattern = new ChordProgression("I IV V")
                .distribute("7%6")
                .allChordsAs("$0 $0 $0 $0 $1 $1 $0 $0 $2 $1 $0 $0")
                .eachChordAs("$0ia100 $1ia80 $2ia80 $3ia80 $4ia100 $3ia80 $2ia80 $1ia80").setKey("C")
                .getPattern()
                .setInstrument("Electric_Muted_Guitar")
                .setTempo(100);
        new Player().play(pattern);

//        Pattern pattern = new ChordProgression("I IV V")
//                .distribute("7%6")
//                .allChordsAs("$0 $0 $0 $0 $1 $1 $0 $0 $2 $1 $0 $0")
//                .eachChordAs("$!w Ri $!i Ri $!i Ri $!q Ri")
//                .getPattern()
//                .setInstrument("Piano")
//                .setTempo(180);
//        new Player().play(pattern);
    }
}
