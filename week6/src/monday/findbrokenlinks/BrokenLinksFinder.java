package monday.findbrokenlinks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BrokenLinksFinder {

	public static void brokenListFinder(Path path) throws IOException {
		File filePath = path.toFile();
		try {
			for (File file : filePath.listFiles()) {
				Path fileToPath = file.toPath();
				if (file.isDirectory()) {
					brokenListFinder(fileToPath);
				} else {
					if (Files.isSymbolicLink(fileToPath)) {
						if (!file.exists()) {
							System.out.println(fileToPath);
						}
					}
				}
			}
		} catch (Exception e) {
			throw new NoSuchFileException("Link is broken");
		}
	}

	public static void main(String[] args) throws IOException {
		BrokenLinksFinder.brokenListFinder(Paths
				.get("/home/boyko/Desktop/music"));
	}
}
