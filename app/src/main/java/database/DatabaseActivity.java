package database;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.robert.myapplication1.R;
import com.example.robert.myapplication1.simplecasemvp.Contract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DatabaseActivity extends AppCompatActivity {

    private String fileName1 = "file 1";
    private String fileContent1 = "Content of file 1";
    FileOutputStream fileOutputStream;

    @BindView(R.id.textFromDatabase)
    TextView textFromDatabase;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_database);
        ButterKnife.bind(this);

        writeFile();
    }

    private void writeFile() {
        try {
        fileOutputStream = openFileOutput(fileName1, Context.MODE_PRIVATE);
        fileOutputStream.write(fileContent1.getBytes());
        fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        File path = this.getFilesDir();
        File file = new File(path, fileName1);

        int length = (int) file.length();
        byte[] bytes = new byte[length];

        FileInputStream in = null;

        try {
            in = openFileInput(fileName1);
            in.read(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        String contents = new String(bytes);
        textFromDatabase.setText(contents);
    }
}
