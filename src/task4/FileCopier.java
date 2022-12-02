package task4;

import java.io.*;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.NotDirectoryException;

public class FileCopier {
    private FileExtension ext;
    private BufferedInputStream bufIn;
    private BufferedOutputStream bufOut;

    public void copyFiles(String extension, File from, File to) throws IOException {
        ext = new FileExtension(extension);
        if (!from.isDirectory() || !to.isDirectory())
            throw new NotDirectoryException("Inputted files aren't folders!");
        File[] files = from.listFiles(ext);
        int c;

//        for (File f : files) {
//            bufIn = new BufferedInputStream(new FileInputStream(f), 1024);
//            bufOut = new BufferedOutputStream(new FileOutputStream(createPath(f, to)), 1024);
//
//            while ((c = bufIn.read()) != -1) {
//                bufOut.write(c);
//                bufOut.flush();
//            }
//        }

        for (File f : files) {

        }
    }

    private String createPath(File file, File dest) {
        return dest.getAbsolutePath() + "\\" + file.getName();
    }
}
