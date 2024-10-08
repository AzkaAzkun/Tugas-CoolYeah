public class Main {
    public static void main(String[] args) {
        MusicOrganizer musicOrganizer = new MusicOrganizer();

        // Create two different Track objects
        Track track1 = new Track("Aku Mau Makan", "Siti Lololo", 2);
        Track track2 = new Track("Lagu Kedua", "Penyanyi Kedua", 3);
        Track track3 = new Track("Lagu Ke3", "Penyanyi Ke3", 3);


        // Add tracks to the MusicOrganizer
        musicOrganizer.addTrack(track1);
        musicOrganizer.addTrack(track2);
        musicOrganizer.addTrack(track3);

        // List all tracks to verify they were added
        musicOrganizer.ListAllTrack();

        musicOrganizer.startPlaying(0);
        musicOrganizer.startPlaying(1);
        musicOrganizer.startPlaying(2);

        try {
            Thread.sleep(8000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

        musicOrganizer.removeTrack(1);
        musicOrganizer.removeTrack(track3);

        musicOrganizer.ListAllTrack();

    }
}
