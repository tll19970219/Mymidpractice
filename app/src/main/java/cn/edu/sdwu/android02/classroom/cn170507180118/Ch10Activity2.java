package cn.edu.sdwu.android02.classroom.cn170507180118;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        }else if(requestCode==102){
            //从联系人列表返回结果
            if(resultCode==RESULT_OK){
                //的带联系人信息(联系人的编号，lookup uri)
                String content=data.getDataString();
                Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
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
    //查看通讯录列表
public void contactsList(View view){
    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/"));
    startActivity(intent);
}
//查看联系人明细
public void contactsDetail(View view){
    Intent intent=new Intent(Intent.ACTION_EDIT);
    intent.setData(Uri.parse("content://contacts/people/1"));
    startActivity(intent);
}
public void showMap(View view){
    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:50.123,7.1434"));
    startActivity(intent);
}
public void showPhoto(View view){
    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("content://media/external/images/media"));
    startActivity(intent);
}
public void pickcontact(View view){
    //以子activity的形式，打开联系人列表，用户选择联系人后选择结果
    Intent intent=new Intent(Intent.ACTION_PICK);//隐式启动
    intent.setData(ContactsContract.Contacts.CONTENT_URI);
    startActivityForResult(intent,102);
}
public void implicitStart(View view){
    Intent intent=new Intent("com.inspur.action2");
    intent.setData(Uri.parse("abc://com.ispur"));
    startActivity(intent);
}
}
