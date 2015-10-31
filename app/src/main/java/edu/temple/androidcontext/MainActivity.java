package edu.temple.androidcontext;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends Activity {

    LinearLayout ll;

    EditText imageURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.imageContainer);
        imageURL = (EditText) findViewById(R.id.imageURL);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = new ImageView(MainActivity.this);
                ll.addView(image);

                ImageLoader.getInstance().displayImage(imageURL.getText().toString(), image);
            }
        });

    }

}
