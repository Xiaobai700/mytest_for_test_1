package com.njupt.shijimoshidemo.adapter;

public class AdapterDemo {
    public static void main(String[] args){
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.display("mp3", "beyond the horizon.mp3");
        audioPlayer.display("mp4", "alone.mp4");
        audioPlayer.display("vlc", "far far away.vlc");
        audioPlayer.display("avi", "mind me.avi");
    }
}
