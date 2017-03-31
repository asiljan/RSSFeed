package com.android.rssfeed.common.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.rssfeed.R;
import com.android.rssfeed.util.ResourceUtil;

import static butterknife.ButterKnife.findById;
/**
 * Created by Alen Siljan on 30.3.2017..
 * alen.siljan@gmail.com
 */

public class AppButtonView extends RelativeLayout {

    RelativeLayout mButtonHolder;
    TextView mButtonText;

    public AppButtonView(Context context) {
        super(context);
        initUI(context, null);
    }

    public AppButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUI(context, attrs);
    }

    private void initUI(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.view_button, this);

        mButtonHolder = findById(view, R.id.appButtonHolder);
        mButtonText = findById(view, R.id.appButtonText);

        if (attrs != null) {
            TypedArray tArray = context.obtainStyledAttributes(attrs, R.styleable.AppButtonView);

            Drawable btnBackground = tArray.getDrawable(R.styleable.AppButtonView_appButtonBackgroundDrawable);
            String btnText = tArray.getString(R.styleable.AppButtonView_appButtonText);
            int btnTextColor = tArray.getColor(R.styleable.AppButtonView_appButtonTextColor,
                    ResourceUtil.getColor(getContext(), R.color.white));

            tArray.recycle();

            if (btnBackground != null) {
                mButtonHolder.setBackground(btnBackground);
            }

            if (btnText != null) {
                mButtonText.setText(btnText);
            }

            mButtonText.setTextColor(btnTextColor);
        }
    }
}
