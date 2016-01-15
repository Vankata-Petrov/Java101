package monday.duplicatesfinder;

import java.io.IOException;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class Main {
	public static void main(String[] args) throws IOException,
			NoSuchAlgorithmException {
		DuplicatesFinder duplicates = new DuplicatesFinder();
		try {
			duplicates.findDuplicate(Paths.get("testData"), Options.PRINT);
		} catch (Exception e) {
			if (e.getMessage() == null) {
				System.err.println("File Not exist!");
			}
		} finally {
			System.out.println(duplicates);
		}
	}
}