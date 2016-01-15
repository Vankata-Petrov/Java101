package monday.duplicatesfinder;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import monday.duplicatesfinder.DuplicatesFinder.Key;

public class DuplicatesStorage {
	public Map<Key, List<Path>> storage;

	public DuplicatesStorage() {
		storage = new HashMap<>();
	}

	public void storeFiles(Key hash, Path path, Options option) {
		if (!storage.containsKey(hash)) {
			List<Path> p = new ArrayList<Path>();
			p.add(path);
			storage.put(hash, p);
		} else {
			// put duplicates in the list
			storage.get(hash).add(path);
			if (storage.get(hash).size() > 1) {
				if (Options.DELETE.equals(option)) {
					// get last added file path
					Path filePath = storage.get(hash).get(
							storage.remove(hash).size() - 1);
					filePath.toFile().delete();
				}
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Entry<Key, List<Path>> entry : storage.entrySet()) {
			if (entry.getValue().size() > 1) {
				sb.append(entry.getValue());
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}
}
