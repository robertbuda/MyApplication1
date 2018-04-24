package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.robert.myapplication1.R;

public class SecondFragment extends Fragment implements TextCommunicator {

    public static final String TAG = "SecondFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second2, container, false);
    }

    @Override
    public void communicate(String textToCommunicate) {
        Toast.makeText(getContext(), textToCommunicate, Toast.LENGTH_SHORT).show();
    }

}
