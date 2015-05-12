package com.yayun.gitlearning;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
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
			
		case 2:
			this.showwWebView.loadUrl("file:///android_asset/git_repository.html");
			
			break;
			
		case 3:
			this.showwWebView.loadUrl("file:///android_asset/git_commit.html");
			
			break;
		case 4:
			this.showwWebView.loadUrl("file:///android_asset/git_time.html");
			
			break;

		default:
			break;
		}
		
		

	}

}
