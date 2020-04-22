package cn.edu.sdwu.android02.classroom.sn170507180118;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static cn.edu.sdwu.android02.classroom.sn170507180118.R.id.text;

public class Ch10Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch10_2);
    }
    public void send_broadcast(View view){
        //发送广播
        Intent intent=new Intent("com.inspur.broadcast");//指定频道
        intent.putExtra("key","message");

        sendBroadcast(intent);//发送

    }
    public void Ch10Activity1(View view){
        Intent intent=new Intent(this,Ch10Activity1.class);
        EditText editText=(EditText)findViewById(R.id.ch10_2_et) ;
        intent.putExtra("text",editText.getText().toString());
         startActivity(intent);
    }
    public void starSubActivity(View view){
        //1、以sub_activity的方式启动子activity
   Intent intent=new Intent(this,Ch10Activity3.class);
        startActivityForResult(intent,101);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==101){
            if(resultCode==RESULT_OK){
                String name=data.getStringExtra("name");
                Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"cancel",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void web(View view){
        //使用隐式启动方式，打开网页
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://baidu.com"));
   startActivity(intent);
    }

}
