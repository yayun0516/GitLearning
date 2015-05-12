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
	private String data[] = { "��һ�£�Git���", "�ڶ��£�Git��װ", "�����£�����ֿ�Ĵ���", "�����£��ύ���ش���", "��һ�£����",
			"��һ�£����", "��һ�£����", "��һ�£����", "��һ�£����", };
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

			default:
				break;
			}
			
		}
		
	

}
}
