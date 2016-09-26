package com.xin.xinprojectsdemo.job;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.xin.xinprojectsdemo.R;

public class LeftFragment extends Fragment {

    private EditText edit_text;
    private Button btn_commit;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_left, null);
        btn_commit = (Button) view.findViewById(R.id.btn_commit);
        edit_text = (EditText) view.findViewById(R.id.edit_text);
        return view;
    }


    public void getEditText(CallBacka callBacka) {

        callBacka.getResult(edit_text.getText().toString());
    }

    public interface CallBacka {
        public void getResult(String msg);
    }
}
