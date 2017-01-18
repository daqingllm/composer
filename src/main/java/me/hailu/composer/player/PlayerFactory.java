package me.hailu.composer.player;

import me.hailu.composer.player.impl.ComposerDefaultPlayer;

/**
 * Created with IntelliJ IDEA.
 * User: liming_liu
 * Date: 15/4/22
 * Time: 下午8:32
 * To change this template use File | Settings | File Templates.
 */
public abstract class PlayerFactory {

    private static ComposerPlayer composerPlayer = new ComposerDefaultPlayer();

    public static ComposerPlayer getPlayer() {
        return composerPlayer;
    }
}
