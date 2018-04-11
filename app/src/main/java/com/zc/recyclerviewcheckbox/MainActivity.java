package com.zc.recyclerviewcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zc.recyclerviewcheckbox.adapter.MyAdapter;
import com.zc.recyclerviewcheckbox.util.InitDataUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * RecyclerView中使用CheckBox勾选混乱问题解决以及单选功能的实现
 * https://blog.csdn.net/ww897532167/article/details/77529605
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRV();
    }

    public void initRV(){
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter(InitDataUtil.getList()));
    }

}
