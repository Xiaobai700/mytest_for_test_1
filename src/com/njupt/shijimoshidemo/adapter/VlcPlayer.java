package com.njupt.shijimoshidemo.adapter;

public class VlcPlayer implements AdvanceMediaplayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing Vlc filename"+fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
