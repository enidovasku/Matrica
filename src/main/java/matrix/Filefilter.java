package matrix;

import java.io.File;

import javax.swing.filechooser.FileFilter;


public class Filefilter extends FileFilter {

    public boolean accept(File file) {

        if (file.isDirectory()) {
            return true;
        }

        String name = file.getName();

        String extension = Utils.getFileExtension(name);

        return extension != null && extension.equals("txt");

    }

    public String getDescription() {
        return "Person database file (*.txt)";
    }

}
