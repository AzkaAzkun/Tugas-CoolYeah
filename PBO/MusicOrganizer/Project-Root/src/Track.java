public class Track {
    private String title;
    private String artist;
    private int time;

    public Track(String title,String artist,int time){
        this.title = title;
        this.artist = artist;
        this.time = time;
    }

    String getTitle(){
        return title;
    }

    String getArtist(){
        return artist;
    }

    public int getTime() {
        return time;
    }

    private String formatTime() {
        int minutes = time / 60;
        int seconds = time % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    public String getDetail() {
        return "Song\t: " + title + "\n" +
                "Artist\t: " + artist + "\n" +
                "Duration\t: " + formatTime();
    }

}
