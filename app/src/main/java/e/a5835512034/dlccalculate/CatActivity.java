package e.a5835512034.dlccalculate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class CatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);

        Bundle zeroAct = getIntent().getBundleExtra("putmessage");
        TextView textview =(TextView) findViewById(R.id.textchange);
        ImageView imageView = (ImageView) findViewById(R.id.imageview);
        textview.setText(zeroAct.getString("mes."));
        if (zeroAct.getInt("int.")==0){
            imageView.setImageResource(R.drawable.cat);
        }
        else if (zeroAct.getInt("int.")==1){
            imageView.setImageResource(R.drawable.dog);
        }
        else if (zeroAct.getInt("int.")==2){
            imageView.setImageResource(R.drawable.food);
        }
        else if (zeroAct.getInt("int.")==3){
            imageView.setImageResource(R.drawable.game);
        }
        else if (zeroAct.getInt("int.")==4){
            imageView.setImageResource(R.drawable.movie);
        }
        else if (zeroAct.getInt("int.")==5){
            imageView.setImageResource(R.drawable.phone);
        }
        else if (zeroAct.getInt("int.")==6){
            imageView.setImageResource(R.drawable.school);
        }
        else if (zeroAct.getInt("int.")==7){
            imageView.setImageResource(R.drawable.shop);
        }
        else if (zeroAct.getInt("int.")==8){
            imageView.setImageResource(R.drawable.travel);
        }
        else if (zeroAct.getInt("int.")==9){
            imageView.setImageResource(R.drawable.water);
        }
    }

    public void gomain(View view) {
        Intent back = new Intent(CatActivity.this,MainActivity.class);
        startActivity(back);
        finish();
    }
}
