package learn.hochnt.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Process layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//gan giao dien de xu ly
        //R chinh la mot lop duoc tao ra tu android=>chua cac thanh phan trong du an (ID - Luu trong R)

    }
}
