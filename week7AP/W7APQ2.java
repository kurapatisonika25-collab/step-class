import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int songCount;

    Playlist(int maxSongs) {
        songs = new String[maxSongs];
        songCount = 0;
    }

    void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    int getSongCount() {
        return songCount;
    }
}

public class W7APQ2{
    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Songs in playlist:");
        String[] songs = p.getSongs();

        for (int i = 0; i < songs.length; i++) {
            System.out.println(songs[i]);
        }

        System.out.println("Song count: " + p.getSongCount());
    }
}