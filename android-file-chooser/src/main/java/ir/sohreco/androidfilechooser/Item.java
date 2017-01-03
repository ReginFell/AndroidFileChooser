package ir.sohreco.androidfilechooser;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import java.io.File;
import java.io.Serializable;

class Item extends File implements Comparable<File>, Serializable{
    private Drawable icon;

    public Item(String path, Drawable icon) {
        super(path);
        this.icon = icon;
    }

    public Drawable getIcon() {
        return icon;
    }

    // We want our list to show directories first and then show files below them
    // so we need to sort our items. Since Collections.sort() sorts items in ascending order
    // we should assume that directories are smaller than files.
    @Override
    public int compareTo(@NonNull File pathname) {
        if (isDirectory() && pathname.isFile()) {
            return -1;
        }
        if (isFile() && pathname.isDirectory()) {
            return 1;
        }
        return 0;
    }
}
