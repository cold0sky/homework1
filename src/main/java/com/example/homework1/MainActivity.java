package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.*;

import java.text.Collator;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //定义各种控件
        final EditText edt1 = findViewById(R.id.editText1);//姓名
        final EditText edt2 = findViewById(R.id.editText2);//手机号
        final EditText edt3 = findViewById(R.id.editText3);//邮箱
        final RadioButton rb1 = findViewById(R.id.rb1);//性别男
        final RadioButton rb2 = findViewById(R.id.rb2);//性别女
        RadioGroup rg1 = findViewById(R.id.rg1);//选择组

        final CheckBox cb1 = findViewById(R.id.checkBox);//勾选框
        final Button btn1 = findViewById(R.id.button);//确定按钮

        final TextView tv6 = findViewById(R.id.textView6);//显示结果
        final Switch sw = findViewById(R.id.switch1);//调整背景亮度

        final TextView tv4 = findViewById(R.id.textView4);//调整背景亮度

        //点击开灯
        sw.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(sw.isChecked()){
                    Log.d("MainActivity","开灯");
                    tv4.setBackgroundColor(Color.WHITE);//开灯
                }

                else{
                    Log.d("MainActivity","关灯");
                    tv4.setBackgroundColor(Color.parseColor("#535353"));//关灯
                }



            }
        });


        btn1.setEnabled(false);//最开始不能点击提交
        //当勾选框被勾选后可以提交
        cb1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(cb1.isChecked()) {
                    btn1.setEnabled(true);
                    Log.d("MainActivity","已同意信息商用");
                }
                else{
                    btn1.setEnabled(false);
                    Log.d("MainActivity","已取消信息商用");
                }
            }
        });

        //点击提交
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = edt1.getText().toString();
                String phone = edt2.getText().toString();
                String address = edt3.getText().toString();
                String sex = new String();
                if(rb1.isChecked())
                    sex = "男";
                if(rb2.isChecked())
                    sex = "女";
                String result = "名字："+name+"\n"+"性别："+sex+"\n"+"电话号码:"+phone+"\n"+"邮箱："+address+"\n";
                tv6.setText(result);
                Log.d("MainActivity","已提交信息");
            }
        });

    }
}
