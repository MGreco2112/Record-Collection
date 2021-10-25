package records;

import java.util.ArrayList;
import java.util.List;

public abstract class Record implements Disc{
    public final String recordType;
    public final String recordName;
    public final String recordArtist;
    public final String discSpeed;
    public final String discSize;
    public final String year;
    public final int numberOfTracks;
    public final int numberOfDiscs;
    public final List<Song> songs = new ArrayList<>();

    public Record(String recordType,
                  String recordName,
                  String recordArtist,
                  String discSpeed,
                  String discSize,
                  String year,
                  int numberOfTracks,
                  int numberOfDiscs) {
        this.recordType = recordType;
        this.recordName = recordName;
        this.recordArtist = recordArtist;
        this.discSpeed = discSpeed;
        this.discSize = discSize;
        this.year = year;
        this.numberOfTracks = numberOfTracks;
        this.numberOfDiscs = numberOfDiscs;

    }

    public void addSongs(List<Song> tracks) {
        if (songs.size() < numberOfTracks) {
            songs.addAll(tracks);
        } else {
            System.out.println("Album can hold no more songs");
        }
    }

    public String recordInfo() {
        String output = recordType + "\n" + recordName + "\nBy: " + recordArtist + "\n" + discSpeed + " RPM\n" + discSize + " inch Disc\n" +
                "Released in " + year + "\nNumber of tracks: " + numberOfTracks + "\nDisc Count: " + numberOfDiscs + "\n";

        for (Song song : songs) {
            output += song.songName;
        }

        return output;
    }

    public String getRecordName() {
        return recordName;
    }



}
