package records;

import java.util.ArrayList;
import java.util.List;

public abstract class Record {
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



}
