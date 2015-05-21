package com.yayun.gitlearning;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends Activity {
	private String data[] = { "第一章：Git简介", "第二章：Git安装", "第三章：代码仓库的创建", "第四章：提交本地代码", "第五章：更多功能",
			"第六章：删除文件", "第七章：远程仓库", "第八章：分支",  };
	private TextView titleTextView;
	private long exitTime;

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {//！！！！！！！！！！！！�?
		menu.add(Menu.NONE, Menu.FIRST + 1, 0, "exit").setIcon(null);
		menu.add(Menu.NONE, Menu.FIRST + 2, 1, "more")
				.setIcon(null);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {//！！！！！！！！！！！！�?
		switch (item.getItemId()) {
		case Menu.FIRST + 1:
			finish();
			break;
		case Menu.FIRST + 2:
			Intent intent=new Intent(StartActivity.this,Information.class);
		    startActivity(intent);
			break;

		default:
			break;
		}
		return false;
	}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startactivity);
		this.titleTextView=(TextView)super.findViewById(R.id.title);
		//this.titleTextView.setTextColor(Color.GREEN);
		LinearLayout layout=(LinearLayout)super.findViewById(R.id.mulu);
		GradientDrawable drawable = new GradientDrawable();  
		drawable.setShape(GradientDrawable.RECTANGLE); // 画框   
		drawable.setStroke(1, Color.WHITE); // 边框粗细及颜色   
     	drawable.setColor(0xFF007500); // 边框内部颜色   

		for(int i=0;i<data.length;i++){
			Button button=new Button(this);
			button.setText(data[i]);
			button.setId(i);
			button.setOnClickListener(new OnClickListenerImpl());
			//button.setBackgroundColor(Color.GREEN);
			button.setTextColor(Color.WHITE);
			button.setBackgroundDrawable(drawable); 
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
			case 7:
				Intent intent7=new Intent(StartActivity.this,MainActivity.class);
				intent7.putExtra("id",7);
				startActivity(intent7);
				break;

			default:
				break;
			}
			
		}
		   

		
	}	
	public boolean onKeyDown(int keyCode, KeyEvent event)   
    {  
                 if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN)  
                 {  
                           
                         if((System.currentTimeMillis()-exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000   
                         {  
                          Toast.makeText(getApplicationContext(), "再按一次退出程序",Toast.LENGTH_SHORT).show();                                  
                          exitTime = System.currentTimeMillis();  
                         }  
                         else  
                         {  
                             finish();  
                             System.exit(0);  
                         }  
                                   
                         return true;  
                 }  
                 return super.onKeyDown(keyCode, event);  
    }  
 

}



