import java.util.ArrayList;

public class MusicOrganizer {
    private ArrayList<Track> files;
    private MusicPlayer player;

    public MusicOrganizer(){
        files = new ArrayList<>();
        player = new MusicPlayer();
    }

    public void startPlaying(int index){
        if (index >= 0 && index < files.size()) {
            Track filename = files.get(index);
            player.play(filename);
        } else {
            System.out.println("Index out of bounds.");
        }
    }

    public void ListAllTrack(){
        for (Track file : files) {
            System.out.println("################");
            System.out.println(file.getDetail());
            System.out.println("################\n");
        }
    }

    public void addTrack(Track track){
        files.add(track);
    }

    public int searchTrack(String trackName){
        for (int i=-0;i< files.size();i++) {
            if (files.get(i).getTitle().equals(trackName)) {
                System.out.println("Track found: " + files.get(i).getTitle());
                return i;
            }
        }
        System.out.println("Track not found.");
        return -1;
    }

    public void removeTrack(int index){
        if(index>=0 && index<files.size()){
            System.out.println("Track " + files.get(index).getTitle() + " Already Removed");
            files.remove(index);
        }else{
            System.out.println("Out of bound.");
        }
    }

    public void removeTrack(Track track){
        int indexFind =searchTrack(track.getTitle());
        if(indexFind==-1){
            System.out.println("Track name not in playlist.");
        }else{
            files.remove(indexFind);
            System.out.println("Track " + track.getTitle() + " Already Removed");
        }
    }
}
