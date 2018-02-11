package demo.cxl.com.openclosedemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;

import demo.cxl.com.openclosedemo.R;

/**
 * Created by caixiaolei on 2018/2/11.
 */

public class SlideLayout extends LinearLayout {

    private Scroller mScroller;

    private LinearLayout ll_content;

    public SlideLayout(Context context) {
        super(context);
        init(context);
    }

    public SlideLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SlideLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mScroller = new Scroller(context, new DecelerateInterpolator());
    }

    public void scrollOpen() {
        isOpen = true;
        startScroll(0, 600);
    }

    public void scrollClose() {
        isOpen = false;
        startScroll(600, 0);
    }

    @Override
    protected void onFinishInflate() {
        ll_content = (LinearLayout) findViewById(R.id.ll_content);
        super.onFinishInflate();
    }

    private void startScroll(int start, int end) {
        stopScroll();
        mScroller.startScroll(start, start, end - start, end - start, 300);
        invalidate();
    }

    private void stopScroll() {
        if (mScroller != null) {
            mScroller.abortAnimation();
        }
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            updateHeight(mScroller.getCurrY());
            postInvalidate();
        }
    }

    //改变布局参数
    private void updateHeight(int current) {
        LinearLayout.LayoutParams orderParams = (LayoutParams) ll_content.getLayoutParams();
        orderParams.height = current;
        ll_content.setLayoutParams(orderParams);

    }

    private boolean isOpen = false;

    public boolean isOpened() {
        return isOpen;
    }
}
