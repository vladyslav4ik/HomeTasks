package task2;

import java.io.*;

public class TextSaver {
    private File file;
    private TextTransformer transformer;

    public TextSaver() {
    }

    public TextSaver(TextTransformer transformer) {
        this.transformer = transformer;
    }

    public void saveTextToFile(String text) {
        String result = transformer.transform(text);
        try {
            FileOutputStream fos = new FileOutputStream("textSaver.txt");
            fos.write(result.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
