package monday.filedatacompression;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class FileDataCompression {
	private WordsContainer container;
	private TextManager manager;

	public FileDataCompression() {
		container = new WordsContainer();
		manager = new TextManager();
	}

	public File compress(Path path) throws IOException {
		List<String> content = FileManager.loadFile(path);
		for (String line : content) {
			line = manager.compressDelimiter(line);
			String[] words = manager.splitLine(line);
			for (String word : words) {
				word = manager.removePunctuations(word);
				if (!container.contains(word)) {
					container.putInContainer(word);
				}
				line = line
						.replaceFirst(word, container.getFromContainer(word));
			}
			container.appendCompressedText(line);
		}
		return container.save();
	}
}
