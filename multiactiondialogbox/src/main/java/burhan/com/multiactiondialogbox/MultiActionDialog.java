package burhan.com.multiactiondialogbox;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by burhan on 16-08-2017.
 */

public class MultiActionDialog extends PopupWindow
{
    public static final int VERTICAL_ORIENTATION = 52;
    public static final int HORIZONTAL_ORIENTATION = 53;

    private DialogItems items;
    private int orientation;
    private View attachableView;
    CardView background;
    Activity mContext;
    LinearLayout dialogLayout;


    public void initialise(DialogItems items, int orientation, View attachableView)
    {
        this.items = items;
        this.orientation = orientation;
        this.attachableView = attachableView;
    }

    public void show(Activity context)
    {
        mContext = context;

        background = (CardView) mContext.findViewById(R.id.cvDialog);

        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layout = layoutInflater.inflate(R.layout.dialog_layout, background);

        dialogLayout = (LinearLayout) layout.findViewById(R.id.dialogLayout);

        setContentView(layout);
        setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        showAsDropDown(attachableView,attachableView.getWidth()/2, 0);

        setUpButtons();
    }

    private void setUpButtons()
    {

        if(orientation == HORIZONTAL_ORIENTATION)
        {
            dialogLayout.setOrientation(LinearLayout.HORIZONTAL);
        }
        else
        {
            dialogLayout.setOrientation(LinearLayout.VERTICAL);
        }

//        background.addView(dialogLayout);
        int i;

        for(i = 0; i< items.getDialogItems().size(); i++ )
        {
            TextView tv = new TextView(mContext);

            tv.setText(items.getDialogItems().get(i).getTitle());

            dialogLayout.addView(tv);
        }
    }

}
