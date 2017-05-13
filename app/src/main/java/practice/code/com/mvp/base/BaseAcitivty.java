package practice.code.com.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/5/13 0013.
 */

public abstract class BaseAcitivty extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutID());
        ButterKnife.bind(this);
        APP.activity = this;
        initData();
    }

    public abstract int initLayoutID();


    public abstract void initData();


}
