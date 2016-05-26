package com.example.fragment;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fragment.ClassifyAdapter;
import com.example.fragment.Cate;
import com.example.fragment.fenlei;
import com.example.fragment.FenleitwoActivity;
import com.example.fragment.R;
import com.google.gson.Gson;

public class fragment2 extends Fragment {

	private View view2;
	private ListView classify_view;
	private String json;
	private ProgressDialog progressDialog;
	private List<Cate> classiy_list;
	private List<Cate> newlist=new ArrayList<Cate>();
	private Intent intent;
	private Bundle b;
	private ClassifyAdapter adapters;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		view2 = inflater.inflate(R.layout.tab02, null);
		return view2;
	}
	@Override
	public void onActivityCreated( Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		intent = new Intent(getActivity(),FenleitwoActivity.class);
		b = new Bundle();
		classify_view = (ListView) view2.findViewById(R.id.classify_view);
		classify_view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
			if(classiy_list.get(position).getIsleafnode()==false){
				b.putSerializable("newlist", (Serializable) classiy_list);
				intent.putExtras(b);
				intent.putExtra("id", newlist.get(position).getId());
				startActivity(intent);
			}else{
				Toast.makeText(getActivity(), "已经是最后一页了", 0).show();
			}
				
				
			}
		});
		classifyAsytask task=new classifyAsytask();
		task.execute("http://121.42.8.95:8090/ECServer_D/category");
		adapters = new ClassifyAdapter(getActivity(),newlist);
		classify_view.setAdapter(adapters);
	}
	 class classifyAsytask extends AsyncTask<String, Void, String>{
		
		@Override
		protected String doInBackground(String... params) {
			String url="http://121.42.8.95:8090/ECServer_D/category";
			json = classiyjson(url);
			System.out.println(classiyjson(url));
			return json;
		}
		@Override
		protected void onPreExecute() {
			progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("正在加载.....");
            progressDialog.show();
			super.onPreExecute();
		}
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			progressDialog.cancel();
			Gson g=new Gson();
			newlist.clear();
			fenlei fromJson = g.fromJson(json,fenlei.class);
			classiy_list = fromJson.getCategory();
			for (int i = 0; i <classiy_list.size() ; i++) {
				
				if(classiy_list.get(i).getParent_id()==0){
					
					newlist.add(classiy_list.get(i));
					//Log.i("newlist", newlist.toString());
				}
			}
			
			adapters.notifyDataSetChanged();
		}
		 
	 }
	public String classiyjson(String url) {
		String fenleijson=null;
		try {
			HttpClient client=new DefaultHttpClient();
			HttpGet get=new HttpGet(url);
			HttpResponse  response=client.execute(get);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode==200){
				HttpEntity entity = response.getEntity();
				 fenleijson = EntityUtils.toString(entity, "UTF_8");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fenleijson;
	}
}
