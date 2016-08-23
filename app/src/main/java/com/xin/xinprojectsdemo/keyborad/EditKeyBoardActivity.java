package com.xin.xinprojectsdemo.keyborad;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;

public class EditKeyBoardActivity extends BaseActivity {

    private EditText etone;
    private EditText ettwo;
    private EditText etthree;
    private EditText etfour;
    private EditText etfive;
    private Button mBtnCommit;

    @Override
    public void initView() {
        setContentView(R.layout.activity_edit_key_board);
        //设置键盘模式
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        etfive = (EditText) findViewById(R.id.et_five);
        etfour = (EditText) findViewById(R.id.et_four);
        etthree = (EditText) findViewById(R.id.et_three);
        ettwo = (EditText) findViewById(R.id.et_two);
        etone = (EditText) findViewById(R.id.et_one);
        etone.setOnEditorActionListener(new lastEditorActionListener());
        ettwo.setOnEditorActionListener(new lastEditorActionListener());
        etthree.setOnEditorActionListener(new lastEditorActionListener());
        etfour.setOnEditorActionListener(new lastEditorActionListener());
        etfive.setOnEditorActionListener(new lastEditorActionListener());
        mBtnCommit = (Button) findViewById(R.id.btn_commit);

        etone.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        etfive.setSelection(etfive.length());
    }

    @Override
    public void initListener() {
        mBtnCommit.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.btn_commit:
                Intent intent = new Intent(EditKeyBoardActivity.this, GetTextActivity.class);
                intent.putExtra("text", etone.getText().toString().trim());
                startActivity(intent);
                break;
        }
    }


    class lastEditorActionListener implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_NEXT) {


            } else if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            } else if (actionId == EditorInfo.IME_ACTION_DONE) {
                Toast.makeText(EditKeyBoardActivity.this, "完成", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    }

}
