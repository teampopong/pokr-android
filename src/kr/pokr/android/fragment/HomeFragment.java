package kr.pokr.android.fragment;

import java.util.ArrayList;

import kr.pokr.android.R;
import kr.pokr.android.data.KeywordBillCardData;
import kr.pokr.android.utils.KeywordBillCardAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

@EFragment(R.layout.home_fragment)
public class HomeFragment extends Fragment {
	
	@ViewById
	LinearLayout home_fragment_empty;
	
	@Click
	void btn_add_scrap(){
		home_fragment_empty.setVisibility(View.GONE);
	}
	
	@ViewById
	ListView home_fragment_lv;
	
	@AfterViews
	void initListView(){
    
    ArrayList<KeywordBillCardData> card_list = new ArrayList<KeywordBillCardData>();

    card_list.add(new KeywordBillCardData());
    
	ArrayAdapter<KeywordBillCardData> card_adapter = new KeywordBillCardAdapter(getActivity(), card_list);
	home_fragment_lv.setAdapter(card_adapter);
	
	}
	
	
}
