package kr.pokr.android.network.data;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.json.JSONArray;
import org.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillJsonDataList {

	@JsonProperty("items")
	public ArrayList<BillJsonData> items;
	
	public int length(){
		return items.size();
	}
}
