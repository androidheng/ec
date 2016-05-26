package com.example.fragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class FenleitwoActivity extends Activity {

	private List<Cate> newlist=new ArrayList<Cate>();
	private String jsons;
	private ProgressDialog progressDialog;
	private ListView classify_view;
	private ClassifyAdapter adapters;
	private List<Cate> list;
	private fenlei fen;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab02);
		 TextView textView_text=(TextView) findViewById(R.id.textView_text);
//		 textView_text.setVisibility(textView_text.VISIBLE);
		 ImageView fenlei_image=(ImageView) findViewById(R.id.fenlei_image);
//		 fenlei_image.setVisibility(fenlei_image.VISIBLE);
		 fenlei_image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
//		Intent intent=getIntent();
//		list = (List<Cate>) intent.getExtras().getSerializable("newlist");
//		int cid=intent.getIntExtra("id", 0);
//		
//		 for (int i = 0; i < list.size(); i++) {
//			 if(list.get(i).getParent_id()==cid){
//					
//					newlist.add(list.get(i));
//				}
//		}
		
		 classify_view = (ListView) findViewById(R.id.classify_view);
//		 adapters = new ClassifyAdapter(FenleitwoActivity.this,newlist);
		 classify_view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(FenleitwoActivity.this,FenleiThreeActivity.class);
				Bundle	b = new Bundle();
				b.putSerializable("lists", (Serializable) list);
				intent.putExtras(b);
				intent.putExtra("sid", list.get(position).getId());
				startActivity(intent);
			}
		});
		 initData();
	}
	private void initData(){
		HttpUtils http = new HttpUtils();
		http.send(HttpRequest.HttpMethod.GET,
		    "http://121.42.8.95:8090/ECServer_D/category",
		    new RequestCallBack<String>(){

		        @Override
		        public void onSuccess(ResponseInfo<String> responseInfo) {
//		            textView.setText(responseInfo.result);
//		        	Log.e("ceshi", responseInfo.result);
		        	jsons=responseInfo.result;
		        	fen=new Gson().fromJson(jsons, fenlei.class);
//		        	Log.e("ceshi", fen.toString());
		        	list=fen.getCategory();
//		        	Log.e("ceshi", list.size()+"");
		        	 adapters = new ClassifyAdapter(FenleitwoActivity.this,list);
		        	 classify_view.setAdapter(adapters);
		        	 adapters.notifyDataSetChanged();
		        }

		        @Override
		        public void onFailure(HttpException error, String msg) {
		        }
		});
	}
	
}
