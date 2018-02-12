package com.example.thongdt.asyntask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text_view_thong_tin)
    TextView text_view_thong_tin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_xu_ly)
    public void button_xu_ly() {
        new CongViec().execute();
    }

    //AsynTask<Params, Progres, Result>
//    - Param: khi goi ban co muon goi class CV thuc thi hay la co muon truyen vao tham so gi hay khong
//    - Progress: qua trinh tra ve tham so kieu gi
//    - Result: ket qa tra ra
    private class CongViec extends AsyncTask<Void, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            text_view_thong_tin.setText("Bat dau." + "\n" );
        }

        //Tra ve kieu chuoi(String) (Do Result la kieu String)
        //Khong lam thay doi giao dien
        @Override
        protected String doInBackground(Void... voids) {

            for (int i = 1; i <= 5; i++){

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress("Xong viec" + i + "\n");
            }

            return "Xong roi.\n";
        }

//      Nhan ket qua tu doInBackgroung de xu ly, kieu chuoi(String)
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            text_view_thong_tin.append(s);
        }

        //Nhan ve chuoi. Do Progress kieu String
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            text_view_thong_tin.append(values[0]);
        }
    }
}

//      https://www.youtube.com/watch?v=yN5WRAchVoA
