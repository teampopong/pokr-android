package kr.pokr.android.fragment;

import java.util.ArrayList;

import kr.pokr.android.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@EFragment(R.layout.home_fragment)
public class HomeFragment extends Fragment {
	
	@ViewById
	ListView home_fragment_lv;
	
	@AfterViews
	void initListView(){
    String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
        "Android", "iPhone", "WindowsMobile" };

    final ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < values.length; ++i) {
      list.add(values[i]);
    }
    ArrayAdapter adapter = new ArrayAdapter(getActivity(),
        android.R.layout.simple_list_item_1, list);
    home_fragment_lv.setAdapter(adapter);
	}
}
