package monday.mp3organizer.organizer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import monday.mp3organizer.metadata.Mp3Metadata;

public class Id3TagExtractor {
	private static final int ID3_TAG_SIZE =128;
	private File mp3;
	private final static byte[] TAG = new byte[3];
	private final static byte[] TITLE = new byte[30];
	private final static byte[] ARTIST = new byte[30];
	private final static byte[] ALBUM = new byte[30];
	private ByteBuffer last128Bytes;

	public Id3TagExtractor(File mp3) throws IOException {
		this.mp3 = mp3;
		readID3Tag();
	}

	@SuppressWarnings("resource")
	public void readID3Tag() throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile(mp3, "r");
		byte[] tagData = new byte[ID3_TAG_SIZE];
		randomAccessFile.seek(randomAccessFile.length() - ID3_TAG_SIZE);
		// put last 128 bytes in tagData array
		randomAccessFile.read(tagData);
		last128Bytes = ByteBuffer.allocate(ID3_TAG_SIZE);
		last128Bytes.put(tagData);
		last128Bytes.rewind();
		// send bytes to corresponding array
		last128Bytes.get(TAG).get(TITLE).get(ARTIST).get(ALBUM);
	}

	public Mp3Metadata getMetaData() throws IllegalArgumentException,
			UnsupportedEncodingException {
		return new Mp3Metadata(new String(TITLE), new String(ARTIST),
				new String(ALBUM));
	}
}
