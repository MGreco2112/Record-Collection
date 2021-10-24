package collection;

import records.Album;
import utilities.Console;

import java.util.ArrayList;
import java.util.List;

public class RecordCollection {
    public final String owner;
    public final List<Record> records = new ArrayList<>();

    public RecordCollection(String owner) {
        this.owner = owner;
    }

    /*
    Interface Options:
        Display Collection
        Display Record
        Add A Record
        Modify A Record
        Remove A Record
        Exit

        Display Collection:
            Prints each record name
        Display Record
            Prints selected record's info
        Add A Record
            Creates a Record object and adds it to the records List
        Modify A Record
            Returns selected Record, stores its data in variables, removes Object from list,
            asks for area(s) to be edited, builds new Object from variables, adds it to List
        Remove A Record
            Removes Record from List
        Exit
            Closes System
     */

    public void newRecordType() {
        int choice = Console.getInt("What type of Record is this?\n1) Album\n2) EP\n3) Single\n0) Exit", 0, 3);

        String recordName = Console.getString("What is the name of the Record?", true);
        String recordArtist = Console.getString(recordName + " is by which Artist?", true);
        String discSize = Console.getString("What is the Diameter of the Record, in Inches?", true);
        String releaseYear = Console.getString("When was the Record released?", true);
        int numberOfTracks = Console.getInt("How many Tracks are on this Record?", 1, Integer.MAX_VALUE);
        int numberOfDiscs = Console.getInt("How many Discs are in this Set?", 1, Integer.MAX_VALUE);

        int discSpeedInput = Console.getInt("What is the Speed of this Record, in RPM?" +
                "\n1) 33 1/3\n2) 45\n3) 78", 1, 3);

        String discSpeed = "";

        switch (discSpeedInput) {
            case 1 -> {
                System.out.println("Disc Speed set to 33 1/3 RPM");
                discSpeed = "33 1/3";
            }
            case 2 -> {
                System.out.println("Disc Speed set to 45 RPM");
                discSpeed = "45";
            }
            case 3 -> {
                System.out.println("Disc Speed set to 78 RPM");
                discSpeed = "78";
            }
            default -> System.out.println("Invalid Selection, how did you get here?");
        }

        switch (choice) {
            case 1 -> {
                System.out.println("Creating Album " + recordName);
                Album newAlbum = new Album(recordName, recordArtist, discSpeed, discSize, releaseYear, numberOfTracks, numberOfDiscs);

                records.add()
            }
        }

    }

}
