package records;

import java.util.List;

public class Album extends Record{




    public Album(String albumName,
                 String albumArtist,
                 String discSpeed,
                 String discSize,
                 String year,
                 int numberOfTracks,
                 int numberOfDiscs) {
        super("Album", albumName, albumArtist, discSpeed, discSize, year, numberOfTracks, numberOfDiscs);
    }


}
