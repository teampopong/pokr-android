package kr.pokr.android.network.data;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.json.JSONArray;
import org.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillJsonData {

	@JsonProperty("sponsor")
	public String sponsor;
	
	@JsonProperty("name")
	public String title;
	
	@JsonProperty("summary")
	public String content;
	
	@JsonProperty("decision_date")
	public String date;
	
	@JsonProperty("status")
	public String status;

}
