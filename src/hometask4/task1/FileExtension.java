package hometask4.task1;

import java.io.File;
import java.io.FilenameFilter;

public class FileExtension implements FilenameFilter {
    private String ext;

    public FileExtension(String ext) {
        this.ext = ext;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}
