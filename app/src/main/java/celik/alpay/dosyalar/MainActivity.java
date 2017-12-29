package celik.alpay.dosyalar;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            FileOutputStream fos = openFileOutput("dosya", Context.MODE_PRIVATE);
            String mesaj = "Alpay ÇELİK";
            fos.write(mesaj.getBytes());
            fos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        try{
            FileInputStream fis = openFileInput("dosya");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            TextView tv = (TextView) findViewById(R.id.metin);
            tv.setText(br.readLine());
            fis.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
