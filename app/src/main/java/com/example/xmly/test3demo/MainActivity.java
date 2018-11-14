package com.example.xmly.test3demo;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MainActivity extends AppCompatActivity implements HorizontalScrollView.OnScrollChangeListener{
    private CustomImageView left,right;
    private HorizontalScrollView horizontalScrollView;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        Log.i(TAG, "onCreate: ----");
        horizontalScrollView = findViewById(R.id.horizontal);
        horizontalScrollView.setOnScrollChangeListener(this);

    }

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (scrollX <= 0 || oldScrollX <= 0){
            return;
        }
        Log.i(TAG, "onScrollChange: "+scrollX+"     "+oldScrollX);
        if (oldScrollX < scrollX && Math.abs(oldScrollX - scrollX) > 1){ //向左滚动,leftIcon放大,playIcon缩小
            if(right.getVisibility() == View.INVISIBLE){
                return;
            }
//            Log.i(TAG, "onScrollChange: ----"+leftIcon.getLayoutParams().width);
//            if (leftIcon.getLayoutParams().width > 76 || leftIcon.getLayoutParams().width < 0){
//                return;
//            }
//            mLeftIconWith = mLeftIconWith + 5;
//            mLeftIconHeight = mLeftIconHeight + 5;
//
//            layoutParams.width = mLeftIconWith;
//            layoutParams.height = mLeftIconHeight;
//            leftIcon.setLayoutParams(layoutParams);
//            playIcon.getLayoutParams().width =
            Log.i(TAG, "onScrollChange: ---------");
            left.startAnimator();
            right.startAnimator3();


        }else if (oldScrollX > scrollX && Math.abs(oldScrollX - scrollX) > 1 ){
            //防止右滑的时候出现左侧按钮重复放大
            if(left.getVisibility() == View.VISIBLE && scrollX > 140){
                return;
            }
            left.startAnimator2();
            right.startAnimator4();
        }

    }
}
