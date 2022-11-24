package task4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopier {
    private FileExtension ext;

    public void copyFiles(String extension, File from, File to) throws IOException {
        ext = new FileExtension(extension);
        File[] files = from.listFiles(ext);

        for (File f : files) {
            Files.copy(f.toPath(), createPath(f, to), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private Path createPath(File file, File dest) {
        String result = dest.getAbsolutePath() + "\\" + file.getName();
        return Paths.get(result);
    }
}
