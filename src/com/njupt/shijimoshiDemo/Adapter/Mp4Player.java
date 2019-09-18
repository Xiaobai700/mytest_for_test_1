package com.njupt.shijimoshiDemo.Adapter;

public class Mp4Player implements AdvanceMediaplayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 filename"+fileName);
    }
}
