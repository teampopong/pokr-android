package kr.pokr.android.fragment;

import java.util.ArrayList;

import kr.pokr.android.R;
import kr.pokr.android.data.KeywordBillCardData;
import kr.pokr.android.network.PopongDataRestClient;
import kr.pokr.android.network.data.BillJsonDataList;
import kr.pokr.android.utils.KeywordBillCardAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

@JsonIgnoreProperties(ignoreUnknown=true)
@EFragment(R.layout.home_fragment)
public class HomeFragment extends Fragment {
	
	String key_word = "È¯°æ";

	@ViewById
	LinearLayout home_fragment_empty;

	@Click
	void btn_add_scrap() {
		home_fragment_empty.setVisibility(View.GONE);
	}

	@ViewById
	ListView home_fragment_lv;

	@RestService
	PopongDataRestClient restClient; // Inject it

	@AfterViews
	@Background
	void get_bill_data() {
		BillJsonDataList bill_data_json_list = (BillJsonDataList) restClient.search_bill_data_by_keyword(key_word); // Play with it
		initListView(bill_data_json_list);
	}

	@UiThread
	void initListView(BillJsonDataList bill_data_json_list) {

		ArrayList<KeywordBillCardData> card_list = new ArrayList<KeywordBillCardData>();
		
		for(int i=0 ; i<bill_data_json_list.length();i++){
			Log.d("dd",bill_data_json_list.items.get(i).title);
			card_list.add(new KeywordBillCardData(bill_data_json_list.items.get(i),key_word));
		}

		
		ArrayAdapter<KeywordBillCardData> card_adapter = new KeywordBillCardAdapter(
				getActivity(), card_list);
		home_fragment_lv.setAdapter(card_adapter);

	}

}
