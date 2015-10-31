package edu.temple.androidcontext;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

public class MainActivity extends Activity {

    LinearLayout ll;
    EditText imageURL;
    CheckBox cacheCheckBox;
    boolean shouldUseCache = true;
    int cacheCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ll = (LinearLayout) findViewById(R.id.imageContainer);
        imageURL = (EditText) findViewById(R.id.imageURL);
        cacheCheckBox = (CheckBox) findViewById(R.id.checkBox);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView image = new ImageView(MainActivity.this);
                ll.addView(image);

                String url = imageURL.getText().toString();

                if (!shouldUseCache)
                    url = url.concat("?" + String.valueOf(cacheCounter++));

                // Picasso singleton with activity (local) context
                Picasso.with(MainActivity.this).load(url).into(image);
            }
        });

        cacheCheckBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                shouldUseCache = isChecked;
            }
        });

    }

}
