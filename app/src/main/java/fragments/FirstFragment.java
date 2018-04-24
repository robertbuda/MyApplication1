package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.robert.myapplication1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstFragment extends Fragment implements TextCommunicator {

    public static final String TAG = "FirstFragment";

    @BindView(R.id.first_text)
    TextView firstText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void communicate(String textToCommunicate) {
        firstText.setText(textToCommunicate);
    }

}
