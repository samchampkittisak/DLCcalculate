package e.a5835512034.dlccalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MyData bd = getIntent().getParcelableExtra("MyData");
        TextView tv02 = (TextView) findViewById(R.id.tv02);

        tv02.setText(bd.data + "");
    }
}
