package monday.propertyparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyParser {

	public static Map<String, String> propertyParser(File file)
			throws FileNotFoundException, IOException {
		Map<String, String> refactoredPropertyFile = new HashMap<>();
		List<String> lines = Files.readAllLines(file.toPath());
		for (String line : lines) {
			line = line.trim().replaceAll("\\s+", "");
			if (line.charAt(0) != '#') {
				String[] keyAndValue = line.split("\\=", 2);
				refactoredPropertyFile.put(keyAndValue[0], keyAndValue[1]);
			}
		}
		return refactoredPropertyFile;
	}
}
