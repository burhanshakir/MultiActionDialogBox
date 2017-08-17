package burhan.com.multiactiondialogbox;

import android.graphics.drawable.Drawable;

/**
 * Created by burha on 16-08-2017.
 */

public class DialogItem
{
    int id;
    String title;
    Drawable icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
