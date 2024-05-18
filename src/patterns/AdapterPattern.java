package patterns;

public class AdapterPattern {
    public static void main(String[] args) {
        MediaPlayer m3pAdapter = new M3pAdapter(new M3PPlayerImpl());
        MediaPlayer vlcAdapter = new VlcAdapter(new VlcPlayerImpl());

        System.out.println(m3pAdapter.play());
        System.out.println(vlcAdapter.play());
        System.out.println(vlcAdapter.pause());
        System.out.println(vlcAdapter.stop());
        System.out.println(m3pAdapter.pause());
        System.out.println(m3pAdapter.stop());

    }
}

interface VlcPlayer {
    String playVlc();
    String pauseVlc();
    String stopVlc();
}

class VlcPlayerImpl implements VlcPlayer {

    @Override
    public String playVlc() {
        return "Playing audio on VLC! ";
    }

    @Override
    public String pauseVlc() {
        return "Paused the audio on VLC! ";
    }

    @Override
    public String stopVlc() {
        return "Stopped the song on VLC ";
    }
}

interface M3PPlayer {
    String playM3p();
    String pauseM3p();
    String stopM3p();
}

class M3PPlayerImpl implements M3PPlayer {

    @Override
    public String playM3p() {
        return "Playing the audio on M3p! ";
    }

    @Override
    public String pauseM3p() {
        return "Paused the audio on M3p! ";
    }

    @Override
    public String stopM3p() {
        return "Stopped the audio on M3p! ";
    }
}

interface MediaPlayer { //Target
    String play();
    String pause();
    String stop();
}

class VlcAdapter implements MediaPlayer {
    private final VlcPlayer vlcPlayer;

    VlcAdapter(VlcPlayer vlcPlayer) {
        this.vlcPlayer = vlcPlayer;
    }

    @Override
    public String play() {
        return vlcPlayer.playVlc();
    }

    @Override
    public String pause() {
        return vlcPlayer.pauseVlc();
    }

    @Override
    public String stop() {
        return vlcPlayer.stopVlc();
    }
}

class M3pAdapter implements MediaPlayer {

    private final M3PPlayer m3PPlayer;

    M3pAdapter(M3PPlayer m3PPlayer) {
        this.m3PPlayer = m3PPlayer;
    }

    @Override
    public String play() {
        return m3PPlayer.playM3p();
    }

    @Override
    public String pause() {
        return m3PPlayer.pauseM3p();
    }

    @Override
    public String stop() {
        return m3PPlayer.stopM3p();
    }
}