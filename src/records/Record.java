package records;

import java.util.ArrayList;
import java.util.List;

public abstract class Record {
    public final String albumName;
    public final String albumArtist;
    public final String discSpeed;
    public final String discSize;
    public final String year;
    public final int numberOfTracks;
    public final int numberOfDiscs;
    public final List<Song> songs = new ArrayList<>();

    public Record(String albumName,
                  String albumArtist,
                  String discSpeed,
                  String discSize,
                  String year,
                  int numberOfTracks,
                  int numberOfDiscs) {
        this.albumName = albumName;
        this.albumArtist = albumArtist;
        this.discSpeed = discSpeed;
        this.discSize = discSize;
        this.year = year;
        this.numberOfTracks = numberOfTracks;
        this.numberOfDiscs = numberOfDiscs;

    }

    public void addSong(Song song) {
        if (songs.size() < numberOfTracks) {
            songs.add(song);
        } else {
            System.out.println("Album can hold no more songs");
        }
    }

}
