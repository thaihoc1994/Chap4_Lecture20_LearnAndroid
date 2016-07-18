package learn.hochnt.learnktxuly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtA,txtB;
    //Anomous
    Button btnTru;

    //Variable
    Button btnNhan;
    Button btnChia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        //anomous chua co san, phai khai bao
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyPhepTru();
            }
        });
    }

    //anomous
    private void xuLyPhepTru() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a - b;
        Toast.makeText(MainActivity.this,"Hiệu = " + c,Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);

        //
        btnTru = (Button) findViewById(R.id.btnTru);


    }

    public void xuLyPhepCong(View v) {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a + b;
        Toast.makeText(MainActivity.this,"Tổng = " + c,Toast.LENGTH_LONG).show();
    }
}
