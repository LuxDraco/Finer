package com.smartti.finer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import jp.wasabeef.glide.transformations.BlurTransformation;
import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class GetStarted extends AppCompatActivity {

    private ImageView backB;
    private Button registrar1;
    private Button login1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        backB = findViewById(R.id.backBLUR);
        registrar1 = findViewById(R.id.btnRegistrar1);
        login1 = findViewById(R.id.btnLogin1);

        Glide.with(this).load(R.drawable.back_blur)
                .apply(bitmapTransform(new BlurTransformation(25, 10)))
                .into(backB);

        registrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registrar.class);
                startActivity(intent);
            }
        });

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}
