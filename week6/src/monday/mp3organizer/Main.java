package monday.mp3organizer;

import java.io.IOException;
import java.nio.file.Paths;
import org.farng.mp3.TagException;

public class Main {
	public static void main(String[] args) throws IOException, TagException {
		new Mp3Organizer().organizeSongs(Paths
				.get("/home/boyko/Downloads/music/"));
	}
}
