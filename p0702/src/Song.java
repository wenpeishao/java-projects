
public class Song {
	private String songName; // name or title of the song
	private String artist; // artist of the song
	private String duration; // duration of the song

	public Song(String songName, String artist, String duration) {		
		this.songName = songName;
		this.artist = artist;
		this.duration = duration;
		
//		duration.split(":");
//		duration.matches("mm:ss");
	}
	public String getSongName() {
		return songName;
	}

	public String getArtist() {
		return artist;
	}
	public String getDuration() {
		return duration;
	}
	public String toString() {
		return songName + "---" + artist + "---" + duration;
				//e.g. "Out of Time---The weekend---3:34"
	}
	@Override
	public boolean equals(Object other) {	
		Song otherSong = null;
		if(other instanceof Song) {
			otherSong = (Song)other;
			if(artist.equals(otherSong.artist) && songName.equals(otherSong.songName)) {
				return true;
			}
		}
		return false;
	}
}
