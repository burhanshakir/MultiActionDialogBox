package burhan.com.multiactiondialogbox;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

/**
 * Created by burhan on 16-08-2017.
 */

public class MultiActionDialog extends PopupWindow
{
    public static final int VERTICAL_ORIENTATION = 52;
    public static final int HORIZONTAL_ORIENTATION = 53;

    DialogItems items;
    int orientation;
    View attachableView;


    public void initialise(DialogItems items, int orientation, View attachableView)
    {
        this.items = items;
        this.orientation = orientation;
        this.attachableView = attachableView;
    }

    public void show(Activity context)
    {
        ViewGroup viewGroup = (LinearLayout) context.findViewById(R.id.llDialog);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.dialog_layout, viewGroup);

        setContentView(layout);
        setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        showAsDropDown(attachableView,attachableView.getWidth()/2, 0);
    }

}
