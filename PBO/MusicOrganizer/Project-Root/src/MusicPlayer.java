public class MusicPlayer {
    private boolean isPlaying;

    public MusicPlayer() {
        this.isPlaying = false;
    }

    // Method to play a track
    public void play(Track track) {
        if (isPlaying) {
            System.out.println("\nAnother song is playing now\n");
        } else {
            isPlaying = true; // Set isPlaying to true before starting the thread

            new Thread(() -> {
                int duration = track.getTime(); // Get the track duration
                try {
                    for (int i = 0; i < duration; i++) {
                        System.out.println("Playing: " + track.getTitle() + " - " + (i + 1) + "s");
                        Thread.sleep(1000); // Simulate the duration of the track
                    }
                    System.out.println("Track finished: " + track.getTitle());
                } catch (InterruptedException e) {
                    System.out.println("Playback was interrupted.");
                } finally {
                    stop(); // Call stop() to reset the playing status
                }
            }).start();
        }
    }

    public void stop() {
        if (isPlaying) {
            System.out.println("Stopping the track....");
            isPlaying = false;
        } else {
            System.out.println("No track is currently playing.");
        }
    }
}
