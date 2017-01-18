package me.hailu.jm;

import jm.JMC;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.music.tools.Mod;
import jm.util.View;
import jm.util.Write;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liming_liu
 * Date: 15/5/14
 * Time: 下午7:55
 * To change this template use File | Settings | File Templates.
 */
public class Dot01 implements JMC {
    private static Score aScore = new Score("Composition 101");
    private static int partCounter = 0;

    public static void main(String[] args) {
        SingleNoteList singleNoteList = new SingleNoteList(SIXTEENTH_NOTE);
        //C
        for (int i=0; i<4; ++i) {
            singleNoteList.addPitch(C4);
            singleNoteList.addPitch(E4);
            singleNoteList.addPitch(G4);
        }
        //B
        for (int i=0; i<4; ++i) {
            singleNoteList.addPitch(B3);
            singleNoteList.addPitch(D4);
            singleNoteList.addPitch(G4);
        }
        //Am7
        for (int i=0; i<4; ++i) {
            singleNoteList.addPitch(A3);
            singleNoteList.addPitch(E4);
            singleNoteList.addPitch(G4);
        }
        //Am7/G
        for (int i=0; i<4; ++i) {
            singleNoteList.addPitch(G3);
            singleNoteList.addPitch(E4);
            singleNoteList.addPitch(G4);
        }
        //F
        for (int i=0; i<4; ++i) {
            singleNoteList.addPitch(F4);
            singleNoteList.addPitch(A4);
            singleNoteList.addPitch(C5);
        }
        //Am7
        for (int i=0; i<4; ++i) {
            singleNoteList.addPitch(E4);
            singleNoteList.addPitch(G4);
            singleNoteList.addPitch(C5);
        }
        //Dm
        for (int i=0; i<4; ++i) {
            singleNoteList.addPitch(D4);
            singleNoteList.addPitch(A4);
            singleNoteList.addPitch(C5);
        }
        //G
        for (int i=0; i<2; ++i) {
            singleNoteList.addPitch(G3);
            singleNoteList.addPitch(A4);
            singleNoteList.addPitch(B4);
        }
        singleNoteList.addPitch(A4);
        for (int i=0; i<5; ++i) {
            singleNoteList.addPitch(REST);
        }
        notesToPart(singleNoteList.toList(), 0.0, 4, GUITAR);

        View.show(aScore);
        Write.midi(aScore, "Daisy.mid");
    }

    public Dot01() {
        double[] n = {REST, EIGHTH_NOTE, C4, EIGHTH_NOTE, REST, QUARTER_NOTE};
        notesToPart(n, 0.0, 4, JAZZ_GUITAR);

        double[] phrase2data = {REST, QUARTER_NOTE, E4, EIGHTH_NOTE, REST, EIGHTH_NOTE};
        notesToPart(phrase2data, 0.0, 4, GUITAR_HARMONICS);

        double[] phrase3data = {REST, QUARTER_NOTE, REST, EIGHTH_NOTE, G4, EIGHTH_NOTE};
        notesToPart(phrase3data, 0.0, 4, NYLON_GUITAR);

        double[] amdata1 = {REST, EIGHTH_NOTE, A4, EIGHTH_NOTE, REST, QUARTER_NOTE};
        notesToPart(amdata1, 8.0, 4, JAZZ_GUITAR);

        double[] amdata2 = {REST, QUARTER_NOTE, E4, EIGHTH_NOTE, REST, EIGHTH_NOTE};
        notesToPart(amdata2, 8.0, 4, GUITAR_HARMONICS);

        double[] amdata3 = {REST, QUARTER_NOTE, REST, EIGHTH_NOTE, A5, EIGHTH_NOTE};
        notesToPart(amdata3, 8.0, 4, NYLON_GUITAR);

        double[] fdata1 = {REST, EIGHTH_NOTE, F3, EIGHTH_NOTE, REST, QUARTER_NOTE};
        notesToPart(fdata1, 16.0, 4, JAZZ_GUITAR);

        double[] fdata2 = {REST, QUARTER_NOTE, A5, EIGHTH_NOTE, REST, EIGHTH_NOTE};
        notesToPart(fdata2, 16.0, 4, GUITAR_HARMONICS);

        double[] fdata3 = {REST, QUARTER_NOTE, REST, EIGHTH_NOTE, C5, EIGHTH_NOTE};
        notesToPart(fdata3, 16.0, 4, NYLON_GUITAR);

        double[] gdata1 = {REST, EIGHTH_NOTE, G3, EIGHTH_NOTE, REST, QUARTER_NOTE};
        notesToPart(gdata1, 24.0, 4, JAZZ_GUITAR);

        double[] gdata2 = {REST, QUARTER_NOTE, G4, EIGHTH_NOTE, REST, EIGHTH_NOTE};
        notesToPart(gdata2, 24.0, 4, GUITAR_HARMONICS);

        double[] gdata3 = {REST, QUARTER_NOTE, REST, EIGHTH_NOTE, B5, EIGHTH_NOTE};
        notesToPart(gdata3, 24.0, 4, NYLON_GUITAR);

        View.show(aScore);
        Write.midi(aScore, "Daisy.mid");
    }

    private static class SingleNoteList {
        private double duration;
        private List<Double> noteList = new ArrayList<Double>();
        public SingleNoteList(double duration) {
            this.duration = duration;
        }

        public void addPitch(int pitch) {
            noteList.add(Double.valueOf(pitch));
            noteList.add(duration);
        }

        public double[] toList() {
            double[] notes = new double[noteList.size()];
            for (int i=0; i<noteList.size(); ++i) {
                notes[i] = noteList.get(i);
            }
            return notes;
        }
    }

    private static void notesToPart(double[] notes,
                                    double startTime, int repeats, int instrument) {
        // create a new phrase from the notes and loop it
        Phrase aPhrase = new Phrase(startTime);
        aPhrase.addNoteList(notes);
        Mod.repeat(aPhrase, repeats);
        // create a new part and add the phrase to it
        Part aPart = new Part("Part "+ partCounter,
                instrument, partCounter);
        aPart.addPhrase(aPhrase);
        // keep track of how many parts have been created
        partCounter++;
        // add the part to the score
        aScore.addPart(aPart);
    }
}
