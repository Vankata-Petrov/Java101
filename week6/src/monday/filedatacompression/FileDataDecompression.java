package monday.filedatacompression;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import monday.filedatacompression.WordsContainer.TextManager;

public class FileDataDecompression {
	private WordsContainer container;
	private TextManager manager;

	public FileDataDecompression() {
		container = new WordsContainer();
		manager = container.new TextManager();
	}

	public File decompress(Path path) throws ClassNotFoundException,
			IOException, NotCompressedFileException {
		String[] compressedText = container.getCompression(path);
		for (String line : compressedText) {
			String[] words = manager.splitLine(line);
			for (String code : words) {
				code = manager.removePunctuations(code);
				String word = container.getWord(code);
				line = line.replaceAll(code, word);
			}
			manager.decompressDelimiter(line);
		}
		return FileManager.saveToFile(manager.getDecompressedContent());
	}
}
