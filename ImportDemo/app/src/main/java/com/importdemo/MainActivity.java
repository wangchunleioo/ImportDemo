package com.importdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.importdemolibrary.Calculate;
import com.importdemolibrary.L;
import com.importdemolibrary.MyDialog;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements View.OnClickListener {
    @Bind(R.id.et1)
    EditText mEt1;
    @Bind(R.id.et2)
    EditText mEt2;
    @Bind(R.id.btn_add)
    Button mBtnAdd;
    @Bind(R.id.btn_sub)
    Button mBtnSub;
    @Bind(R.id.btn_mul)
    Button mBtnMul;
    @Bind(R.id.btn_divide)
    Button mBtnDivide;
    @Bind(R.id.tv)
    TextView mTv;
    @Bind(R.id.activity_main)
    RelativeLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setListener();
    }

    private void setListener() {
        mBtnAdd.setOnClickListener(this);
        mBtnSub.setOnClickListener(this);
        mBtnMul.setOnClickListener(this);
        mBtnDivide.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (!mEt1.getText().toString().isEmpty() && !mEt2.getText().toString().isEmpty()) {
            switch (view.getId()) {
                case R.id.btn_add:
                    mTv.setText("" + Calculate.add(mEt1.getText().toString(), mEt2.getText().toString()));
//                    MyDialog.showDialogo(MainActivity.this, "正在加载...");
                    break;
                case R.id.btn_sub:
                    mTv.setText("" + Calculate.sub(mEt1.getText().toString(), mEt2.getText().toString()));
                    MyDialog.dismiss();
                    break;
                case R.id.btn_mul:
                    try {
                        mTv.setText("" + Calculate.mul(mEt1.getText().toString(), mEt2.getText().toString(), 2));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.btn_divide:
                    try {
                        mTv.setText("" + Calculate.divide(mEt1.getText().toString(), mEt2.getText().toString(), 2));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } else {
            L.t(MainActivity.this, "请输入正确的数字");
        }

    }
}
