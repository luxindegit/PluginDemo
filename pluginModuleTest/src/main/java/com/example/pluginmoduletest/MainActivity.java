package com.example.pluginmoduletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.pluginlib.PlugLibBean;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent Intent=getIntent();
		if(Intent!=null){
			Toast.makeText(this,Intent.getStringExtra("key"),Toast.LENGTH_LONG).show();
			PlugLibBean PlugLibBean=(PlugLibBean)Intent.getSerializableExtra("bean");
			Toast.makeText(this,PlugLibBean.toString(),Toast.LENGTH_LONG).show();
		}
	}
	public void kk(View view){
		finish();
	}
}
