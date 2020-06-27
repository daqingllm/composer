package me.hailu;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.View;
import jm.util.Write;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: liming_liu
 * Date: 15/4/22
 * Time: 下午6:47
 * To change this template use File | Settings | File Templates.
 */
public class Compose implements JMC {

    @Test
    public void compose() {
        int[] pitches = { C5, A4, F4, C4, D4, E4, F4, D4, F4, C4 };
        double[] rhythmValues =
                {
                        DOTTED_HALF_NOTE,
                        DOTTED_HALF_NOTE,
                        DOTTED_HALF_NOTE,
                        DOTTED_HALF_NOTE,
                        QUARTER_NOTE,
                        QUARTER_NOTE,
                        QUARTER_NOTE,
                        HALF_NOTE,
                        QUARTER_NOTE,
                        2 * DOTTED_HALF_NOTE };
        Note[] notes = new Note[pitches.length];
        for (int i = 0; i < notes.length; i++) {
            // A note is made up of a pitch and duration
            notes[i] = new Note(pitches[i], rhythmValues[i]);
        }
// A phrase is made up of notes
        Phrase phrase = new Phrase(notes);
        Part pianoPart = new Part("Piano", GUITAR);
// A part is made up of phrases
        pianoPart.add(phrase);
// A score is made up of part(s)
        int tempo = 180;
        Score daisy = new Score("A Bicycle Built For Two", tempo, pianoPart);
// In key of F: 1 flat
        daisy.setKeySignature(-1);
// In 3/4 time
        daisy.setNumerator(3);
        daisy.setDenominator(4);
// Display score in standard musical notation
        View.notate(daisy);

        Write.midi(daisy, "Daisy001.mid");
    }
}
