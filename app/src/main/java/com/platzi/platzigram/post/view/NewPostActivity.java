package com.platzi.platzigram.post.view;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.platzi.platzigram.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewPostActivity extends AppCompatActivity {

    @BindView(R.id.photo)
    ImageView photo;
    @BindView(R.id.edtTitle)
    TextInputEditText edtTitle;
    @BindView(R.id.edtDescription)
    TextInputEditText edtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        ButterKnife.bind(this);
        if(getIntent().getExtras() != null){
            String photoPath = getIntent().getExtras().getString("PHOTO_PATH_TEMP");
            Picasso.with(this).load(photoPath).into(photo);
        }

    }

    @OnClick(R.id.btnCreatePost)
    public void onViewClicked() {
    }
}
