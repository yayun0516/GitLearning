package com.yayun.gitlearning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView=null;
	WebView showwWebView=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.textView=(TextView)super.findViewById(R.id.title);
		this.showwWebView=(WebView)super.findViewById(R.id.show);
		Intent intent=super.getIntent();
		int i=intent.getIntExtra("id", 0);
		switch (i) {
		case 0:
			this.showwWebView.loadUrl("file:///android_asset/git_introduction.html");
			
			break;
		case 1:
			this.showwWebView.loadUrl("file:///android_asset/git_install.html");
			break;
			
		case 2:
			this.showwWebView.loadUrl("file:///android_asset/git_repository.html");
			
			break;
			
		case 3:
			this.showwWebView.loadUrl("file:///android_asset/git_commit.html");
			
			break;
		case 4:
			this.showwWebView.loadUrl("file:///android_asset/git_time.html");
			break;
		case 5:
			this.showwWebView.loadUrl("file:///android_asset/git_remove.html");
			break;
		case 6:
			this.showwWebView.loadUrl("file:///android_asset/git_ remoterepository.html");
			break;
		case 7:
			this.showwWebView.loadUrl("file:///android_asset/git_branch.html");
			break;

		default:
			break;
		}
		
		

	}

}
