import java.io.*;

public class FileReader {
    String[] files;

    public FileReader(String[] files) {
        this.files = files;
    }

    public String getData() throws IOException {
        String data = "";
        for (int index = 0; index < this.files.length; index++) {
            File csvData = new File(this.files[index]);
            InputStream inputStream = new FileInputStream(csvData);
            int size = inputStream.available();
            for (int i = 0; i < size; i++)
                data += (char) inputStream.read();
        }
        return data;
    }
}
