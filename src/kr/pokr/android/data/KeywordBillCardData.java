package kr.pokr.android.data;

import kr.pokr.android.network.data.BillJsonData;


public class KeywordBillCardData {
	public String keyword;
	public String proposer;
	public String bill_title;
	public String bill_before_status = "TODO: get before status";
	public String bill_after_status;
	public String bill_content;
	public String date;
	
	
	//TODO: remove the generator below
	public KeywordBillCardData() {
		keyword = "txt_keyword";
		proposer = "txt_proposer";
		bill_title = "txt_bill_title";
		bill_before_status = "txt bill_ before";
		bill_after_status = "txt bill after";
		bill_content = "jgjgjglugug\nhulkhuilhkh\nadfasfwesdfarsadfasdfs";
		date = "2014.9.27";
	}
	
	public KeywordBillCardData(BillJsonData data, String _keyword){
		keyword = _keyword;
		proposer = data.sponsor;
		bill_title = data.title;
		bill_after_status = data.status;
		bill_content = data.content;
		date = data.date;
		
	}

}
