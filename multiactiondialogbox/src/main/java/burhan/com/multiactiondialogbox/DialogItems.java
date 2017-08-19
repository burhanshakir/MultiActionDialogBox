package burhan.com.multiactiondialogbox;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by burhan on 16-08-2017.
 */

public class DialogItems
{
    List<DialogItem> dialogItems = new ArrayList<>();

    public List<DialogItem> getDialogItems()
    {
        return dialogItems;
    }

    public void add(int id, String title, Drawable icon)
    {

        DialogItem item = new DialogItem();

        item.setId(id);
        item.setTitle(title);
        item.setIcon(icon);

        dialogItems.add(item);

    }


}
