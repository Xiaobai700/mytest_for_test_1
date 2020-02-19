package com.njupt.shijimoshidemo.adapter;

public class MeidaAdapter implements Midiaplayer {
    AdvanceMediaplayer advanceMediaplayer;

    public MeidaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("vlc")){
            advanceMediaplayer = new VlcPlayer();
        }else if(audioType.equalsIgnoreCase("mp4")){
            advanceMediaplayer = new Mp4Player();
        }
    }

    @Override
    public void display(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advanceMediaplayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advanceMediaplayer.playMp4(fileName);
        }
    }
}
