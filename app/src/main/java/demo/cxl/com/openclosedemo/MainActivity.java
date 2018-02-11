package demo.cxl.com.openclosedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import demo.cxl.com.openclosedemo.view.SlideLayout;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btn;

    private SlideLayout slide_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        slide_layout = (SlideLayout) findViewById(R.id.slide_layout);
    }


    @Override
    public void onClick(View view) {
        if (view.equals(btn)) {
            if (slide_layout.isOpened()) {
                slide_layout.scrollClose();
            } else {
                slide_layout.scrollOpen();
            }
        }
    }
}
