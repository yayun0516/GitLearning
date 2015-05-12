package com.yayun.gitlearning;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StartActivity extends Activity {
	private String data[] = { "第一章：Git简介", "第二章：Git安装", "第三章：代码仓库的创建", "第四章：提交本地代码", "第五章：更多功能",
			"第六章：删除文件", "第七章：远程仓库", "第一章：简介", "第一章：简介", };
	private TextView titleTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startactivity);
		this.titleTextView=(TextView)super.findViewById(R.id.title);
		//this.titleTextView.setTextColor(Color.GREEN);
		LinearLayout layout=(LinearLayout)super.findViewById(R.id.mulu);
		for(int i=0;i<data.length;i++){
			Button button=new Button(this);
			button.setText(data[i]);
			button.setId(i);
			button.setOnClickListener(new OnClickListenerImpl());
			layout.addView(button);
		}
	}
	private class OnClickListenerImpl implements OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case 0:
				Intent intent0=new Intent(StartActivity.this,MainActivity.class);
				intent0.putExtra("id",0);
				startActivity(intent0);
				break;
			case 1:
				Intent intent1=new Intent(StartActivity.this,MainActivity.class);
				intent1.putExtra("id",1);
				startActivity(intent1);
				break;
			case 2:
				Intent intent2=new Intent(StartActivity.this,MainActivity.class);
				intent2.putExtra("id",2);
				startActivity(intent2);
				break;
			case 3:
				Intent intent3=new Intent(StartActivity.this,MainActivity.class);
				intent3.putExtra("id",3);
				startActivity(intent3);
				break;
			case 4:
				Intent intent4=new Intent(StartActivity.this,MainActivity.class);
				intent4.putExtra("id",4);
				startActivity(intent4);
				break;
			case 5:
				Intent intent5=new Intent(StartActivity.this,MainActivity.class);
				intent5.putExtra("id",5);
				startActivity(intent5);
				break;
			case 6:
				Intent intent6=new Intent(StartActivity.this,MainActivity.class);
				intent6.putExtra("id",6);
				startActivity(intent6);
				break;

			default:
				break;
			}
			
		}
		
	

}
}
