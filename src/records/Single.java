package records;

public class Single extends Record{

    public Single(String recordType, String recordName, String recordArtist, String discSpeed, String discSize, String year, int numberOfTracks, int numberOfDiscs) {
        super("Single", recordName, recordArtist, discSpeed, discSize, year, numberOfTracks, numberOfDiscs);
    }
}
