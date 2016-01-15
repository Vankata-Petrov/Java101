package monday.mp3organizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;

import monday.duplicatesfinder.DuplicatesFinder;
import monday.duplicatesfinder.Options;
import monday.mp3organizer.organizer.Mp3Organizer;

public class Main {
	private static final Path PATH = new File("/home/boyko/Downloads/music/")
			.toPath();

	public static void main(String[] args) throws IOException,
			NoSuchAlgorithmException, IllegalArgumentException {
		new Mp3Organizer().organizeSongs(PATH);
		new DuplicatesFinder().findDuplicate(PATH, Options.DELETE);
	}
}