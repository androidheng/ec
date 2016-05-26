package com.example.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment.ClassifyAdapter;
import com.example.fragment.Cate;

public class FenleiThreeActivity extends Activity {
	private List<Cate> newlist=new ArrayList<Cate>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab02);
//		TextView textView_text=(TextView) findViewById(R.id.textView_text);
//		 textView_text.setVisibility(textView_text.VISIBLE);
//		 ImageView fenlei_image=(ImageView) findViewById(R.id.fenlei_image);
//		 fenlei_image.setVisibility(fenlei_image.VISIBLE);
//		 fenlei_image.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				finish();
//			}
//		});
//		Intent intent=getIntent();
//		List<Cate> Threelist= (List<Cate>) intent.getExtras().getSerializable("lists");
//		int cid=intent.getIntExtra("sid", 0);
//		
//		 for (int i = 0; i < Threelist.size(); i++) {
//			 if(Threelist.get(i).getParent_id()==cid){
//					
//					newlist.add(Threelist.get(i));
//				}
//		}
		
//		 ListView classify_view = (ListView) findViewById(R.id.classify_view);
//		 ClassifyAdapter adapters = new ClassifyAdapter(FenleiThreeActivity.this,newlist);
//		 classify_view.setAdapter(adapters);
//		 classify_view.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				// TODO Auto-generated method stub
//				Toast.makeText(FenleiThreeActivity.this, "×îºóÒ»Ò³", 0).show();
//			}
//		});
	}
}
