package kr.pokr.android.network.data;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

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
	
	@JsonProperty("status_ids")
	public List status_ids;

}
