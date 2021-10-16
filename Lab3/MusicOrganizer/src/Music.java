
/**
 * The Music class represents a music which could be in a collection.
 * It holds the music details.
 * @author Mohsen
 * @version 0.0
 */
public class Music {
    private String path;
    private String Singer;
    private int year;

    /**
     * Create new music
     * @param file Music path
     * @param singer Name of the person who sing the song
     * @param year Year of the production
     */
    public Music(String file, String singer, int year) {
        this.path = file;
        this.Singer = singer;
        this.year = year;
    }

    /**
     * @return The path of the music
     */
    public String getPath() {
        return path;
    }

    /**
     * Set the path of the music
     * @param file Path of the music
     */
    public void setPath(String file) {
        this.path = file;
    }

    /**
     *
     * @return The name of the singer
     */
    public String getSinger() {
        return Singer;
    }

    /**
     * Set the name of the singer
     * @param singer Name of the singer
     */
    public void setSinger(String singer) {
        Singer = singer;
    }

    /**
     *
     * @return The year that the song produced
     */
    public int getYear() {
        return year;
    }

    /**
     * Set the year that the song produced
     * @param year The year that the song produced
     */
    public void setYear(int year) {
        this.year = year;
    }

}
