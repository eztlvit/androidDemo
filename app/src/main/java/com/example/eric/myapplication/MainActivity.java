package com.example.eric.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.MyListView);
        /*List<HashMap<String, String>> map = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 30; i++) {
            HashMap<String, String> tm = new HashMap<String, String>();
            tm.put("title", "aaaaaa");
            tm.put("text", "bbbbbb");
            map.add(tm);
        }*/

       /* SimpleAdapter mSchedule = new SimpleAdapter(this, //没什么解释
                map,//数据来源
                R.layout.listview_item,//ListItem的XML实现

                //动态数组与ListItem对应的子项
                new String[] {"title", "text"},

                //ListItem的XML文件里面的两个TextView ID
                new int[] {R.id.title,R.id.text});
       lv.setAdapter(mSchedule);*/

        lv.setAdapter(new MyListAdapter(R.layout.listview_item));
        GridView gv = (GridView) findViewById(R.id.MyGridView);
        gv.setAdapter(new MyListAdapter(R.layout.gridview_item));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RelativeLayout rl = (RelativeLayout) parent.getItemAtPosition(position);
                TextView tv = (TextView) rl.findViewById(R.id.text);
                setTitle(tv.getText());

                new AlertDialog.Builder(MainActivity.this).setTitle(tv.getText()).show();
            }
        });
    }

    public class MyListAdapter extends BaseAdapter {

        List<RelativeLayout> views = new ArrayList<RelativeLayout>();

        public MyListAdapter(int item) {
            for (int i = 0; i < 10; i++) {
                LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                RelativeLayout rl = (RelativeLayout) inflater.inflate(item, null);

                ImageView iv = (ImageView) rl.findViewById(R.id.img);
                iv.setImageResource(R.drawable.ic_launcher);
                TextView text = (TextView) rl.findViewById(R.id.text);
                text.setText("a" + i);
                TextView title = (TextView) rl.findViewById(R.id.title);
                title.setText("b" + i);
                views.add(rl);
            }
            Log.i("eric", String.valueOf(views.size()));
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public Object getItem(int position) {
            return views.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (null == convertView) {
                return views.get(position);
            }
            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
