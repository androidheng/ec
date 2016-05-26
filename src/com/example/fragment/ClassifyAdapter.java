package com.example.fragment;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragment.Cate;
import com.example.fragment.R;

public class ClassifyAdapter extends BaseAdapter {

	private int[] imag={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,};
	private Context context;
	private List<Cate> newlist;
	public ClassifyAdapter(Context context,List<Cate> newlist){
		this.context=context;
		this.newlist=newlist;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return newlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		if(convertView==null){
//			convertView =View.inflate(context, R.layout.classify_item, null);
//		}
//		ImageView classiy_img=(ImageView) convertView.findViewById(R.id.classiy_img);
//		TextView classiy_text=(TextView) convertView.findViewById(R.id.classiy_text);
//		TextView classiy_tv=(TextView) convertView.findViewById(R.id.classiy_tv);
//		classiy_img.setImageResource(imag[position]);
//		//BitmapUtils bitmap=new BitmapUtils(context);
//		//bitmap.display(classiy_img, newlist.get(position).getPic());
//		classiy_text.setText(newlist.get(position).getName());
//		classiy_tv.setText(newlist.get(position).getTag());
//		return convertView;
//	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder=null;
		if(convertView==null){
			convertView =View.inflate(context, R.layout.classify_item, null);
			viewHolder=new ViewHolder();
			viewHolder.classiy_img=(ImageView) convertView.findViewById(R.id.classiy_img);
			viewHolder. classiy_text=(TextView) convertView.findViewById(R.id.classiy_text);
			viewHolder. classiy_tv=(TextView) convertView.findViewById(R.id.classiy_tv);
			convertView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder) convertView.getTag();
		}
		
		viewHolder.classiy_img.setImageResource(imag[position]);
		//BitmapUtils bitmap=new BitmapUtils(context);
		//bitmap.display(classiy_img, newlist.get(position).getPic());
		viewHolder.classiy_text.setText(newlist.get(position).getName());
		viewHolder.classiy_tv.setText(newlist.get(position).getTag());
		return convertView;
	}
	class ViewHolder{
		ImageView classiy_img;
		TextView classiy_text,classiy_tv;
	}
}
