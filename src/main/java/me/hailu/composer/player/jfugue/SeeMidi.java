package me.hailu.composer.player.jfugue;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.midi.MidiParser;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.staccato.StaccatoParserListener;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import java.io.File;
import java.io.IOException;

public class SeeMidi {
    public static void main(String[] args) throws IOException, InvalidMidiDataException {
//        Pattern pattern = MidiFileManager.loadPatternFromMidi(new File("Daisy001.mid"));
//        System.out.println(pattern);

//        MidiParser parser = new MidiParser();
//        StaccatoParserListener listener = new StaccatoParserListener();
//        parser.addParserListener(listener);
//        parser.parse(MidiSystem.getSequence(new File("Daisy001.mid")));
//        Pattern staccatoPattern = listener.getPattern();
//        System.out.println(staccatoPattern);
//
//        Player player = new Player();
//        player.play(staccatoPattern);

        MidiParser parser = new MidiParser();
        StaccatoParserListener listener = new StaccatoParserListener();
        parser.addParserListener(listener);
        parser.parse(MidiSystem.getSequence(new File("Daisy001.mid")));
        Pattern staccatoPattern = listener.getPattern();
        System.out.println(staccatoPattern);

        Player player = new Player();
        player.play(staccatoPattern);
    }
}
