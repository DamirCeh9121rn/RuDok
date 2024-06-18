package controller.action.FileFilter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class PresFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        return (f.isDirectory() ||
                f.getName().toLowerCase().endsWith(".rprjf"));
    }

    @Override
    public String getDescription() {
        return "RuDok Project Files (*.rprjf)";
    }

}
