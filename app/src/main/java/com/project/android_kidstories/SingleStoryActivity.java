package com.project.android_kidstories;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.project.android_kidstories.Model.Story;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author .: Utibe Etim
 * @email ..: etim.utibe@gmail.com
 * @created : 17/10/19
 */
public class SingleStoryActivity extends AppCompatActivity {
    public static final String STORY_POSITION = "story_position";

    public static final String PREFERENCE_NAME = "com.project.android_kidstories";
    public static final String PREFERENCE_KEY_NAME = "favourite";
    Set<String> mFavourite;

    ImageView story_pic;
    private ImageView favourite;
     TextView story_author;
     TextView story_content;
    int story_id = 2;
    private Toolbar toolbar;
    ProgressDialog progressDoalog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_story);
//        toolbar = findViewById(R.id.singlestory_toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        progressDoalog = new ProgressDialog(SingleStoryActivity.this);
//        progressDoalog.setMessage("Loading....");
//        progressDoalog.dismiss();


        initViews();

        saveFavourite();
    }

    private void initViews() {
//        progressDoalog = new ProgressDialog(SingleStoryActivity.this);
//        progressDoalog.setMessage("Loading....");
//        progressDoalog.show();
//        progressDoalog.show();
        story_author = findViewById(R.id.author_tv);
        story_content = findViewById(R.id.story_content);
        story_pic = findViewById(R.id.story_thumbnail);
        favourite = findViewById(R.id.favourite_btn);
        story_id = getIntent().getIntExtra("story_id", 0);
        Intent intent = getIntent();
        mFavourite = getFavourite();
        if (intent != null) {
            Story story = getIntent().getParcelableExtra("story");

            Glide.with(this).load(story.getImageUrl()).into(story_pic);
            //story_pic.s(story.getImageUrl());
            story_author.setText("By" + story.getAuthor());
            story_content.setText(story.getBody());

        }
    }


    private void saveFavourite() {
        SharedPreferences prefs = getSharedPreferences(PREFERENCE_NAME, 0);
        SharedPreferences.Editor editP = prefs.edit();
        editP.putStringSet(PREFERENCE_KEY_NAME, mFavourite).apply();
        if (ConfirmFavourite(1)) {
            favourite.setImageResource(R.drawable.ic_fav);
        } else {
            favourite.setImageResource(R.drawable.ic_fav_border);
        }
    }

    private Set<String> getFavourite() {
        SharedPreferences prefs = getSharedPreferences(PREFERENCE_NAME, 0);
        return prefs.getStringSet(PREFERENCE_KEY_NAME, new HashSet<String>());
    }

    public void fav(View v) {

        if (ConfirmFavourite(1)) {
            mFavourite.remove(Integer.toString(1));
            Toast.makeText(SingleStoryActivity.this, "Removed from favorite list", Toast.LENGTH_SHORT).show();
        } else {
            mFavourite.add(Integer.toString(1));
            Toast.makeText(SingleStoryActivity.this, "Added to your favorite list", Toast.LENGTH_SHORT).show();
        }
        saveFavourite();
    }

    private boolean ConfirmFavourite(int isPosition) {
        Set<String> FavCF = getFavourite();
        if (FavCF.contains(Integer.toString(isPosition))) {
            return true;
        } else {
            return false;
        }
    }
}
