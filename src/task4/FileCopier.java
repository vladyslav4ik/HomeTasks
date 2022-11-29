package task4;

import java.io.*;

public class FileCopier {
    private FileExtension ext;
    private FileInputStream fileIn;
    private FileOutputStream fileOut;
    private BufferedInputStream bufIn;
    private BufferedOutputStream bufOut;

    public void copyFiles(String extension, File from, File to) throws IOException {
        ext = new FileExtension(extension);
        File[] files = from.listFiles(ext);
        int c;

        for (File f : files) {
            fileIn = new FileInputStream(f);
            fileOut = new FileOutputStream(createPath(f, to));

            bufIn = new BufferedInputStream(fileIn, 1024);
            bufOut = new BufferedOutputStream(fileOut, 1024);

            while ((c = bufIn.read()) != -1) {
                bufOut.write(c);
                bufOut.flush();
            }
        }
    }

    private String createPath(File file, File dest) {
        return dest.getAbsolutePath() + "\\" + file.getName();
    }
}
