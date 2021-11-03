package collection;

import records.*;
import utilities.Console;

import java.util.ArrayList;
import java.util.List;

public class RecordCollection {
    public final String owner;
    public final ArrayList<Disc> records = new ArrayList<>();

    public RecordCollection() {
        this.owner = Console.getString("Enter your name:", true);
        System.out.println("Welcome " + owner);
    }

    public RecordCollection (String owner) {
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

    public void menuSelection() {
        while (true) {

            int menuChoice = Console.getInt("Choose a Menu Option:\n1) Display Collection\n2) Display a Record's Info\n3) Add a New Record\n" +
                    "4) Modify A Record\n5) Remove A Record\n0) Exit System", 0, 5);

            switch (menuChoice) {
                case 0 -> quitProgram();
                case 1 -> displayCollection();
                case 2 -> displaySelectedRecord();
                case 3 -> newRecordType();
                case 4 -> {
                    int selectedRecordIndex = selectRecord();

                    if (selectedRecordIndex >= 0) {
                        Disc selectedRecord = records.get(selectedRecordIndex);

                        int choice = Console.getInt("Which piece of data will you edit?\n" +
                                "1) Record Type\n" +
                                "2) Record Name\n" +
                                "3) Artist Name\n" +
                                "4) Disc Speed\n" +
                                "5) Disc Size" +
                                "6) Release Year\n" +
                                "7) Number Of Tracks" +
                                "8) Number of Discs" +
                                "9) Track Information\n" +
                                "0) Exit", 0, 9);



                    } else {
                        System.out.println("No record selected to edit");
                    }

                }
                case 5 -> {
                    //TODO create remove a record method
                }
            }
        }
    }

    private void quitProgram() {
        System.out.println("Leaving...");
        System.exit(0);
    }

    private void displayCollection() {
        if (records.size() > 0) {

            int recordNumber = 1;
            for (Disc record : records) {
                System.out.println(recordNumber + ") " + record.getRecordName());
                recordNumber++;
            }
        } else {
            System.out.println(owner + "'s Collection is empty");
        }
    }

    private int selectRecord() {
        int selectedRecord = 0;

        String prompt = "Enter the number of Record you wish to select\nIf it isn't listed, press ENTER to advance";

        for (int recordCounter = 0; recordCounter < records.size(); recordCounter++) {
            System.out.println(recordCounter + 1 + ") " + records.get(recordCounter).getRecordName());

            if (records.size() > 10 || recordCounter % 10 == 0) {
                String choice = Console.getString(prompt, false);

                switch (choice) {
                    case "" -> System.out.println("Printing next 10 Records");
                    default -> {
                        try {
                            selectedRecord = Integer.parseInt(choice) - 1;
                        } catch (Exception e) {
                            System.out.println("Invalid entry, try again");
                            selectRecord();
                        }

                        return selectedRecord;

                    }
                }
            }
        }

        return 0;
    }

    private void displaySelectedRecord() {
        int selectedRecord = selectRecord();

        if (selectedRecord >= 0) {
            System.out.println(records.get(selectedRecord).recordInfo());
        } else {
            System.out.println("No record selected");
        }
    }

    private void newRecordType() {
        int recordChoice = Console.getInt("What type of Record is this?\n1) Album\n2) EP\n3) Single\n0) Exit", 0, 3);

        if (recordChoice != 0) {


            String recordName = Console.getString("What is the name of the Record?", true);
            String recordArtist = Console.getString(recordName + " is by which Artist?", true);
            String discSize = Console.getString("What is the Diameter of the Record, in Inches?", true);
            String releaseYear = Console.getString("When was the Record released?", true);
            int numberOfTracks = Console.getInt("How many Tracks are on this Record?", 1, Integer.MAX_VALUE);

            List<Song> songs = new ArrayList<>();
            int trackNumber = 1;

            while (songs.size() < numberOfTracks) {

                String trackName = Console.getString("What is the name of track #" + trackNumber + "?", true);
                String trackLength = Console.getString("How long is " + trackName + "?\nEnter in x:xx format", true);

                trackNumber++;

                songs.add(new Song(trackName, trackLength));
            }

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

            switch (recordChoice) {
                case 1 -> {
                    System.out.println("Creating Album " + recordName);
                    Album newAlbum = new Album(recordName, recordArtist, discSpeed, discSize, releaseYear, numberOfTracks, numberOfDiscs);
                    newAlbum.addSongs(songs);

                    records.add(newAlbum);
                }
                case 2 -> {
                    System.out.println("Creating EP " + recordName);
                    EP newEP = new EP(recordName, recordArtist, discSpeed, discSize, releaseYear, numberOfTracks, numberOfDiscs);
                    newEP.addSongs(songs);

                    records.add(newEP);
                }
                case 3 -> {
                    System.out.println("Creating Single " + recordName);
                    Single newSingle = new Single(recordName, recordArtist, discSpeed, discSize, releaseYear, numberOfTracks, numberOfDiscs);
                    newSingle.addSongs(songs);

                    records.add(newSingle);
                }

                default -> System.out.println("Invalid selection, how did you get here?");
            }

        } else {
            System.out.println("Returning to prior menu");
        }

    }

}
