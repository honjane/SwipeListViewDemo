package com.sample.swipelistview;

import android.app.Activity;
import android.os.Bundle;
import com.sample.swipelistview.view.SwipeListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private SwipeListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mListView = (SwipeListView) findViewById(R.id.swipeListView);
        List<ItemModel> items = new ArrayList<ItemModel>();
        ItemModel item = null;
        for (int i = 0; i < 100; i++) {
            item = new ItemModel();
            item.imgRes = R.drawable.ic_launcher;
            item.title = "swipeListView_" + i;
            item.desc = "你说好不好用呢 还有什么改进可以联系我";
            items.add(item);
        }
        SwipeAdapter swipeAdapter = new SwipeAdapter(this);
        if (items != null && !items.isEmpty()) {
            swipeAdapter.setListData(items);
        }
        mListView.setAdapter(swipeAdapter);

    }

}
