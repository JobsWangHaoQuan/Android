package com.example.shiyan4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<Map<String,Object>> lists;
    private SimpleAdapter adapter;
    private ListView listView;
    //行星名称数组
    private String[] names = new String[]{"水星", "金星", "地球", "火星", "木星", "土星"};
    //行星描述数组
    private String[] descs = new String[]{
            "水星是太阳系八大行星最内侧也是最小的一颗行星，也是离太阳最近的行星。",
            "金星是太阳系八大行星之一，排行第二，距离太阳0.725天文单位。",
            "地球是太阳系八大行星之一，排行第三，也是太阳系中直径、质量和密度最大的类地行星。",
            "火星是太阳系八大行星之一，排行第四，属于类地行星，直径约为地球的53%。",
            "木星是太阳系八大行星中体积最大、自转最快的行星，排行第五。它的质量为太阳的千分之一。",
            "土星为太阳系八大行星之一，排行第六，体积仅次于木星。"};
    //行星图片数组
    private int[] imageIds = new int[]{R.drawable.shuixing, R.drawable.jinxing,
           R.drawable.diqiu, R.drawable.huoxing, R.drawable.muxing, R.drawable.tuxing};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
//                android.R.layout.simple_list_item_1, names);
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this,
//                android.R.layout.simple_expandable_list_item_1, descs);
        listView = findViewById(R.id.list_view);
        //listView.setAdapter(adapter);
        lists = new ArrayList<>();
        for(int i = 0;i < names.length;i++){
            Map<String,Object> map =new HashMap<>();
            map.put("imageIds",imageIds[i]);
            map.put("names",names[i]);
            map.put("descs",descs[i]);
            lists.add(map);
        }
        adapter = new SimpleAdapter(MainActivity.this,lists,R.layout.first
                ,new String[]{"imageIds","names","descs"}
                ,new int[]{R.id.image1,R.id.text1,R.id.text2});
        listView.setAdapter(adapter);
    }
}
