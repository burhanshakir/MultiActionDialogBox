package burhan.com.multiactiondialogbox;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.List;

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
    private Activity mContext;
    private LinearLayout dialogLayout;


    public void initialise(DialogItems items, int orientation, View attachableView)
    {
        this.items = items;
        this.orientation = orientation;
        this.attachableView = attachableView;
    }

    public void show(Activity context)
    {
        mContext = context;

        CardView background = (CardView) mContext.findViewById(R.id.cvDialog);

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

        List<DialogItem> dialogItems = items.getDialogItems();

        if(orientation == HORIZONTAL_ORIENTATION)
        {
            dialogLayout.setOrientation(LinearLayout.HORIZONTAL);
        }
        else
        {
            dialogLayout.setOrientation(LinearLayout.VERTICAL);
        }

        int i;

        for(i = 0; i< dialogItems.size(); i++ )
        {
            DialogItem item = dialogItems.get(i);

            LinearLayout itemLayout = new LinearLayout(mContext);
            itemLayout.setLayoutParams(new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            itemLayout.setId(item.getId());

            if(orientation == HORIZONTAL_ORIENTATION)
            {
                itemLayout.setOrientation(LinearLayout.VERTICAL);
            }
            else
            {
                itemLayout.setOrientation(LinearLayout.HORIZONTAL);
            }

            ImageView iv = new ImageView(mContext);
            iv.setImageDrawable(item.getIcon());

            TextView tv = new TextView(mContext);
            tv.setText(item.getTitle());


            itemLayout.addView(iv);
            itemLayout.addView(tv);

            dialogLayout.addView(itemLayout);


            if(i != dialogItems.size() -1)
            {
                View divider = new View(mContext);


                LinearLayout.LayoutParams dividerParams;
                if(orientation == HORIZONTAL_ORIENTATION)
                {
                    dividerParams = new LinearLayout.LayoutParams(
                            (int) mContext.getResources().getDimension(R.dimen.divider_width),LinearLayout.LayoutParams.MATCH_PARENT);

                    dividerParams.setMargins((int) mContext.getResources().getDimension(R.dimen.divider_margin),0,(int) mContext.getResources().getDimension(R.dimen.divider_margin),0);

                }
                else
                {
                    dividerParams = new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.MATCH_PARENT, (int) mContext.getResources().getDimension(R.dimen.divider_width));

                    dividerParams.setMargins(0,(int) mContext.getResources().getDimension(R.dimen.divider_margin),0,(int) mContext.getResources().getDimension(R.dimen.divider_margin));
                }


                divider.setLayoutParams(dividerParams);
                divider.setBackgroundColor(ContextCompat.getColor(mContext, R.color.divider_color));


                dialogLayout.addView(divider);
            }


        }
    }

}
