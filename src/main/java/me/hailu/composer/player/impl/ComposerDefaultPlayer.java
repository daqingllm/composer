package me.hailu.composer.player.impl;

import me.hailu.composer.player.ComposerPlayer;

import javax.sound.midi.*;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liming_liu
 * Date: 15/4/22
 * Time: 下午8:34
 * To change this template use File | Settings | File Templates.
 */
public class ComposerDefaultPlayer implements ComposerPlayer {

    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;

    public ComposerDefaultPlayer() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(Map<Integer, Integer[]> music) {
        int[] trackList = null;
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (Integer instrument : music.keySet()) {
            Integer[] solo = music.get(instrument);
            makeTracks(instrument, solo);
        }

        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeTracks(Integer instrument, Integer[] solo) {
        for (int i=0; i<solo.length; ++i) {
            if (solo[i] != 0) {
                track.add(makeEvent(144, 9, instrument, 127, i));
                track.add(makeEvent(128, 9, instrument, 127, i+1));
            }
        }
    }

    private MidiEvent makeEvent(int command, int channel, int one, int two, int tick) {
        ShortMessage message = new ShortMessage();
        try {
            message.setMessage(command, channel, one, two);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return new MidiEvent(message, tick);
    }
}
