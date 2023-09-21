
/**
 * Song objects are used to store the song name, artist, duration. You will write this class from
 * scratch.
 * 
 * @author wenpei
 *
 */
class Song {
  private String songName; // name or title of the song
  private String artist; // artist of the song
  private String duration; // duration of the song

  /**
   * Creates a new Song given the song name, the name of the artist, and the duration of the song
   * 
   * @param songName - title of the song
   * @param artist   - name of the artist who performed this song
   * @param duration - duration of the song in the format mm:ss
   */
  public Song(java.lang.String songName, java.lang.String artist, java.lang.String duration) {
   
    if (songName == null || artist == null || duration == null) {
      throw new IllegalArgumentException(
          "either of songName, or artist, or duration is null or is blank, or if the duration"
          + " is not formatted as mm:ss where both mm and ss are in the 0 .. 59 range");
    }
    
    if (songName.isBlank() || artist.isBlank() || duration.isBlank()) {
      throw new IllegalArgumentException(
          "either of songName, or artist, or duration is null or is blank, or if the duration is"
          + " not formatted as mm:ss where both mm and ss are in the 0 .. 59 range");
    }
   
    
//    if (duration.matches("mm:ss")) {
//    } else {
//      throw new IllegalArgumentException(
//          "either of songName, or artist, or duration is null or is blank, or if the duration
   // is not formatted as mm:ss where both mm and ss are in the 0 .. 59 range");
//    }

    if (duration.matches("([0-5]?\\d):([0-5]?\\d)")) {
    } else {
      throw new IllegalArgumentException(
          "either of songName, or artist, or duration is null or is blank, or if the duration "
          + "is not formatted as mm:ss where both mm and ss are in the 0 .. 59 range");
    }
    

    this.songName = songName;
    this.artist = artist;
    this.duration = duration;
  }

  /**
   * Gets the title or name of this song
   * 
   * @return the title or name of this song
   */
  public java.lang.String getSongName() {
    return songName;
  }

  /**
   * @return the artist
   */
  public String getArtist() {
    return artist;
  }

  /**
   * @return the duration
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Returns a string representation of this song. This string should be formatted as follows.
   * "songName---artist---duration" where songName is the title of the song, artist is the name of
   * the artist, and duration is the duration of the song.
   * 
   */
  @Override
  public String toString() {
    return songName + "---" + artist + "---" + duration;
  }

  /**
   * Returns true when this song's name and artist strings equals to the other song's name and
   * artist strings, and false otherwise. Note that this method takes an Object rather than a Song
   * argument, so that it Overrides Object.equals(Object). If an object that is not an instance of
   * Song is ever passed to this method, it should return false.
   * 
   * @param other
   * @return
   */
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Song) {
      Song other = (Song)obj;
      if(songName.equals(other.getSongName())&&artist.equals(other.getArtist())) {
        return true;
      }
      
    }
    return false;
  }


}
