package edu.njit.littmanapp.ui.helper;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.njit.littmanapp.R;

public class BaseActivity extends AppCompatActivity {

    TextView textViewTitle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        textViewTitle = (TextView) findViewById(R.id.placeholder_title);
    }

    public void setTitle(String title) {
        textViewTitle.setText(title);
    }

}