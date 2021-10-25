package records;

import java.util.List;

public class EP extends Record implements Disc{


    public EP(String recordName, String recordArtist, String discSpeed, String discSize, String year, int numberOfTracks, int numberOfDiscs) {
        super("EP", recordName, recordArtist, discSpeed, discSize, year, numberOfTracks, numberOfDiscs);
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

}
