package e.a5835512034.dlccalculate;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
ActionBarDrawerToggle actionBarDrawerToggle;
    private String[] mDrawertitle = {"random integer 1 to 100 for Multiplicand","random integer 1 to 100 for calculate",
            "plus","minus","multiply","divide","mod","calculate"};
    private DrawerLayout mDrawerLayout;
    private ListView mListView;
    private TextView ip1,ip2,symbol,call;
    private double rdom0,rdom1;
    private String rdoms0,rdoms1,sans;
    private double ans;
    RecyclerViewAdapter adap;
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String[] list = { "Cat", "Dog", "food"
                , "game","movie","phone","school","shop","travel","beverage" };

        int[] image = {R.drawable.cat,R.drawable.dog,R.drawable.food,R.drawable.game,R.drawable.movie,R.drawable.phone,R.drawable.school,
                R.drawable.shop,R.drawable.travel,R.drawable.water};

        List<Actor> setv = new ArrayList<Actor>();
        for(int i=0;i< list.length;i++)
            setv.add(new Actor(list[i],image[i]));

        RecyclerView listView = findViewById(R.id.listview1);
        adap = new RecyclerViewAdapter(this,setv);
        listView.setLayoutManager(new LinearLayoutManager(this));
        adap.setClickListener(this);
        listView.setAdapter(adap);

        //------------------------------------//
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mListView = (ListView) findViewById(R.id.list1);
        ip1 = (TextView) findViewById(R.id.ip1);
        ip2 = (TextView) findViewById(R.id.ip2);
        symbol = (TextView) findViewById(R.id.symbol);
        call = (TextView) findViewById(R.id.call);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mDrawertitle);
        mListView.setAdapter(adapter);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,mDrawerLayout,R.string.open_drawer,R.string.close_drawer);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String itemv = (String) mListView.getItemAtPosition(position);
                if (position == 0){
                    rdom0 = (int) (Math.random()*100 + 1);
                    rdoms0 = Double.toString(rdom0);
                    ip1.setText(rdoms0);
                }
                else if(position == 1){
                    rdom1 = (int) (Math.random()*100 + 1);
                    rdoms1 = Double.toString(rdom1);
                    ip2.setText(rdoms1);
                }
                else if (position == 2){
                    symbol.setText("+");
                }
                else if (position == 3){
                    symbol.setText("-");
                }
                else if (position == 4){
                    symbol.setText("X");
                }
                else if (position == 5){
                    symbol.setText("/");
                }
                else if (position == 6){
                    symbol.setText("mod");
                }
                else if (position == 7){
                    if (ip1.getText().toString().equals("input01")||ip2.getText().toString().equals("input02")||symbol.getText().toString().equals("symbol"))
                        call.setText("Error");
                    else{
                        if (symbol.getText().toString().equals("+"))
                            ans = rdom0+rdom1;
                        else if (symbol.getText().toString().equals("-"))
                            ans = rdom0-rdom1;
                        else if (symbol.getText().toString().equals("X"))
                            ans = rdom0*rdom1;
                        else if (symbol.getText().toString().equals("/"))
                            ans = rdom0/rdom1;
                        else if (symbol.getText().toString().equals("mod"))
                            ans = rdom0%rdom1;
                        sans = Double.toString(ans);
                        call.setText(sans);
                    }

                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "Click: " + adap.getItem(position) +
                " on row:" + position, Toast.LENGTH_SHORT).show();
        if (position == 0){
            Intent zero = new Intent(MainActivity.this,CatActivity.class);
            Bundle putmessage = new Bundle();
            putmessage.putString("mes.",adap.getItem(position).toString());
            putmessage.putInt("int.",0);
            zero.putExtra("putmessage",putmessage);
            startActivity(zero);
            finish();
        }
        else if (position == 1){
            Intent one = new Intent(MainActivity.this,CatActivity.class);
            Bundle putmessage = new Bundle();
            putmessage.putString("mes.",adap.getItem(position).toString());
            putmessage.putInt("int.",1);
            one.putExtra("putmessage",putmessage);
            startActivity(one);
            finish();
        }
        else if (position == 2){
            Intent two = new Intent(MainActivity.this,CatActivity.class);
            Bundle putmessage = new Bundle();
            putmessage.putString("mes.",adap.getItem(position).toString());
            putmessage.putInt("int.",2);
            two.putExtra("putmessage",putmessage);
            startActivity(two);
            finish();
        }
        else if (position == 3){
            Intent three = new Intent(MainActivity.this,CatActivity.class);
            Bundle putmessage = new Bundle();
            putmessage.putString("mes.",adap.getItem(position).toString());
            putmessage.putInt("int.",3);
            three.putExtra("putmessage",putmessage);
            startActivity(three);
            finish();
        }
        else if (position == 4){
            Intent four = new Intent(MainActivity.this,CatActivity.class);
            Bundle putmessage = new Bundle();
            putmessage.putString("mes.",adap.getItem(position).toString());
            putmessage.putInt("int.",4);
            four.putExtra("putmessage",putmessage);
            startActivity(four);
            finish();
        }
        else if (position == 5){
            Intent five = new Intent(MainActivity.this,CatActivity.class);
            Bundle putmessage = new Bundle();
            putmessage.putString("mes.",adap.getItem(position).toString());
            putmessage.putInt("int.",5);
            five.putExtra("putmessage",putmessage);
            startActivity(five);
            finish();
        }
        else if (position == 6){
            Intent six = new Intent(MainActivity.this,CatActivity.class);
            Bundle putmessage = new Bundle();
            putmessage.putString("mes.",adap.getItem(position).toString());
            putmessage.putInt("int.",6);
            six.putExtra("putmessage",putmessage);
            startActivity(six);
            finish();
        }
        else if (position == 7){
            Intent seven = new Intent(MainActivity.this,CatActivity.class);
            Bundle putmessage = new Bundle();
            putmessage.putString("mes.",adap.getItem(position).toString());
            putmessage.putInt("int.",7);
            seven.putExtra("putmessage",putmessage);
            startActivity(seven);
            finish();
        }
        else if (position == 8){
            Intent eight = new Intent(MainActivity.this,CatActivity.class);
            Bundle putmessage = new Bundle();
            putmessage.putString("mes.",adap.getItem(position).toString());
            putmessage.putInt("int.",8);
            eight.putExtra("putmessage",putmessage);
            startActivity(eight);
            finish();
        }
        else if (position == 9){
            Intent nine = new Intent(MainActivity.this,CatActivity.class);
            Bundle putmessage = new Bundle();
            putmessage.putString("mes.",adap.getItem(position).toString());
            putmessage.putInt("int.",9);
            nine.putExtra("putmessage",putmessage);
            startActivity(nine);
            finish();
        }
        else {}
    }

    public void goshow(View view) {
        Intent goshow = new Intent(MainActivity.this,Main2Activity.class);
        goshow.putExtra("MyData",new MyData());
        startActivity(goshow);
    }


}
