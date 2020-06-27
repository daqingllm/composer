package me.hailu.composer.player.jfugue;

import org.jfugue.player.Player;
import org.jfugue.theory.Chord;
import org.jfugue.theory.ChordProgression;
import org.jfugue.theory.Note;

public class IntroToChordProgressions {

    public static void main(String[] args) {
        ChordProgression cp = new ChordProgression("IV V iii vi ii V I I").eachChordAs("$!qa100 Rq $!qa50 Rq");

        Chord[] chords = cp.setKey("F").getChords();
        for (Chord chord : chords) {
            System.out.print("Chord "+chord+" has these notes: ");
            Note[] notes = chord.getNotes();
            for (Note note : notes) {
                System.out.print(note+" ");
            }
            System.out.println();
        }

        Player player = new Player();
        player.play(cp.getPattern().setTempo(80).repeat(2));
    }
}
