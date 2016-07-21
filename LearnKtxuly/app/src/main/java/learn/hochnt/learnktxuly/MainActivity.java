package learn.hochnt.learnktxuly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener{//nhan lau moi lam

    EditText txtA,txtB;
    //Anomous
    Button btnTru;

    //Variable
    Button btnNhan;
    Button btnChia;

    View.OnClickListener suKienChiaSe = null;

    //activity as listen: lớp có thể biến thành một activity co khả năng sinh sự kiện
    Button btnAn;

    //Explicit class Listen ner: dự án phình lớn=> Lớp tường minh, tự xây dựng sinh và chia sẻ sự kiện
    Button btnThoat;

    //Classing
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//truyen id hay control
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

        suKienChiaSe = new View.OnClickListener() {
            @Override
            public void onClick(View v) {//tu dong hung control dang xu ly
                if (v.getId() == R.id.btnNhan){
                    xuLyPhepNhan();
                }
                else if (v.getId()==R.id.btnChia)
                {
                    xuLyPhepChia();
                }
            }
        };
        btnNhan.setOnClickListener(suKienChiaSe);
        btnChia.setOnClickListener(suKienChiaSe);

        btnAn.setOnLongClickListener(this);

        btnThoat.setOnClickListener(new MyEvent());
    }

    private void addControls() {
        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);

        //
        btnTru = (Button) findViewById(R.id.btnTru);
        //khoi tao dia chi tham chieu
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);

        btnAn = (Button) findViewById(R.id.btnAn);
        btnThoat = (Button) findViewById(R.id.btnThoat);
    }

    //khong can ađ vao event hay control, da khaibao ơ xml
    public void xuLyPhepCong(View v) {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a + b;
        Toast.makeText(MainActivity.this,"Tổng = " + c,Toast.LENGTH_SHORT).show();
    }

    //anomous
    private void xuLyPhepTru() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a - b;
        Toast.makeText(MainActivity.this,"Hiệu = " + c,Toast.LENGTH_SHORT).show();
    }

    private void xuLyPhepNhan() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a * b;
        Toast.makeText(MainActivity.this,"Tích = " + c,Toast.LENGTH_SHORT).show();
    }

    private void xuLyPhepChia() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a / b;
        Toast.makeText(MainActivity.this,"Thương = " + c,Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onLongClick(View v) {
        //mot man hinh co kha nang sinh su kien thi tat ca cac control trong do co the ke thua
        if(v.getId() == R.id.btnAn){
            btnAn.setVisibility(v.INVISIBLE);
        }
        return false;
    }

    //ex
    public class MyEvent implements View.OnClickListener,View.OnLongClickListener{//lop tuong minh va cu the

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btnThoat)
                finish();
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }

    //view subclassing
    public void xuLyDoiManHinh(View v){
        Button btnMoi = new Button(MainActivity.this){//button tu tao => quay ve lai man hinh cu gom cac thuoc tinh da setting
            @Override
            public boolean performClick() {
                setContentView(R.layout.activity_main);//truyen id hay control=>thay doi lay out
                addControls();
                addEvents();
                return super.performClick();
            }
        };
        btnMoi.setText("Quay về");//mot nut tran man hinh=>perform click
        btnMoi.setWidth(100);
        btnMoi.setHeight(100);

        setContentView(btnMoi);//set view khi bam vao nut doi man hinh
    }
}
