package kr.pokr.android.utils;

import java.util.ArrayList;

import kr.pokr.android.R;
import kr.pokr.android.data.KeywordBillCardData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class KeywordBillCardAdapter extends ArrayAdapter<KeywordBillCardData> {

	public LayoutInflater mInflater;
	
	public KeywordBillCardAdapter(Context context, ArrayList<KeywordBillCardData> resource) {
		super(context,0, resource);
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		ViewHolder holder;
		
		if(convertView ==null){
			view = mInflater.inflate(R.layout.keyword_bill_card, null);
			holder = new ViewHolder();
			holder.bill_proposer = (TextView)view.findViewById(R.id.text_proposer);
			holder.bill_before_status = (TextView)view.findViewById(R.id.text_bill_status_before);
			holder.bill_after_status = (TextView)view.findViewById(R.id.text_bill_status_after);
			holder.bill_title = (TextView)view.findViewById(R.id.text_bill_title);
			holder.bill_content = (TextView)view.findViewById(R.id.text_bill_content);
			holder.bill_date = (TextView)view.findViewById(R.id.text_bill_date);
			view.setTag(holder);
		}else{
			view = convertView;
			holder = (ViewHolder)view.getTag();
		}
		
		KeywordBillCardData card_data = getItem(position);
		holder.bill_proposer.setText(card_data.proposer);
		holder.bill_before_status.setText(card_data.bill_before_status);
		holder.bill_after_status.setText(card_data.bill_after_status);
		holder.bill_title.setText(card_data.bill_title);
		holder.bill_content.setText(card_data.bill_content);
		holder.bill_date.setText(card_data.date);
		
		return view;
	}
	
	
	
	class ViewHolder{
		TextView bill_proposer;
		TextView bill_before_status;
		TextView bill_after_status;
		TextView bill_title;
		TextView bill_content;
		TextView bill_date;
	}	
	

}
