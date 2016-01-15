package monday.mp3organizer.metadata;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Mp3Metadata {
	private String title;
	private String artist;
	private String album;

	public Mp3Metadata(String title, String artist, String album)
			throws UnsupportedEncodingException {
		super();
		this.title = title;
		this.artist = artist;
		this.album = album;
		new Mp3MetaDataNormalizer(this).normalize();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Mp3Metadata [title=" + title + ", artist=" + artist
				+ ", album=" + album + "]";
	}
}
