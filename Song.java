import java.util.ArrayList;

public class Song{
    private String name;
    private ArrayList<Artist> artists;
    private Album album;
    private ArrayList<Genre> genres;
    private Date date;
    private int duration;
    private boolean explicit;
    private int popularity;
    private Lyrics lyrics;
    private static ArrayList<Song> songs = new ArrayList<Song>();
    
    public Song(String n, ArrayList<Artist> ar, Album al, ArrayList<Genre> g, Date da, int du, boolean e, int p){
        name = n;
        artists = ar;
        album = al;
        genres = g;
        date = da;
        duration = du;
        explicit = e;
        popularity = p;
        songs.add(this);
        al.addSong(this);
    }
    
    public static Song getSong(String n){
        for (int i=0; i<songs.size(); i++){
            if (songs.get(i).name.toLowerCase().equals(n.toLowerCase())) return songs.get(i);
        }
        return null;
    }
    
    public static ArrayList<Song> getAllSongs(){
        return songs;
    }
    
    public String getName(){
        return name;
    }
    
    public ArrayList<Artist> getArtists(){
        return artists;
    }
    
    public Album getAlbum(){
        return album;
    }
    
    public ArrayList<Genre> getGenres(){
        return genres;
    }
    
    public Date getDate(){
        return date;
    }
    
    public String getFormattedDuration(){
        int totalSeconds = duration/1000;
        int min = totalSeconds/60;
        int sec = totalSeconds%60;
        return min + " minutes and " + sec + " seconds";
    }
    
    public double getDuration(){
        return duration;
    }
    
    public boolean getExplicitRating(){
        return explicit;
    }
    
    public String getFormattedExplicitRating(){
        if (explicit) return "Yes";
        return "No";
    }
    
    public double getPopularity(){
        return popularity;
    }
    
    public String toString(){
        return name;
    }
    
    public static ArrayList<Song> sortSongsAlphabetically(ArrayList<Song> songs){
        int songCount = songs.size();
        for (int i=0; i<songCount-1; i++){
            int maxIndex = i;
            for (int j=i+1; j < songCount; j++){
                String maxString = songs.get(maxIndex).getName().toLowerCase();
                String indexString = songs.get(j).getName().toLowerCase();
                if(indexString.compareTo(maxString)<0) maxIndex = j;
            }
            Song temp = songs.get(maxIndex);
            songs.set(maxIndex, songs.get(i));
            songs.set(i, temp);
        }
        return songs;
    }
    
    //public getSongs{
        //for(int i;song.length>i;i++){
            //System.out.println(songs.get(i));
        //}
        
    }