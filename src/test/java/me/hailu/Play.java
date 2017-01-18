package me.hailu;

import me.hailu.composer.player.ComposerPlayer;
import me.hailu.composer.player.Instrument;
import me.hailu.composer.player.PlayerFactory;
import org.testng.annotations.Test;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liming_liu
 * Date: 15/4/22
 * Time: 下午9:11
 * To change this template use File | Settings | File Templates.
 */
public class Play {

    private Map<Integer, Integer[]> music = new HashMap<Integer, Integer[]>();

    private void init() {
        music.put(Instrument.Bass_Drum, new Integer[]{1,0,1,0,2,0,2,0});
        music.put(Instrument.Closed_Hi_Hat, new Integer[]{0,1,1,0});
    }

    @Test
    public void play() throws InterruptedException {
        init();
        ComposerPlayer player = PlayerFactory.getPlayer();
        player.play(music);

        Thread.sleep(1000000);
    }

    public static void main(String[] args)
    {
        try {
            FileInputStream fileau=new  FileInputStream("Daisy.mid");
            AudioStream as=new AudioStream(fileau);
            AudioPlayer.player.start(as);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
