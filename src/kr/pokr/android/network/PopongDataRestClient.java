package kr.pokr.android.network;

import kr.pokr.android.network.data.BillJsonDataList;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.MediaType;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

@Rest(rootUrl = "http://api.popong.com/v0.1/", converters = { MappingJacksonHttpMessageConverter.class })
@JsonIgnoreProperties(ignoreUnknown=true)
public interface PopongDataRestClient {
	
	@Get("bill/?api_key=test")
	@Accept(MediaType.APPLICATION_JSON)
	Object getEvents();

	
	@Get("bill/search?q={keyword}&api_key=test")
	@Accept(MediaType.APPLICATION_JSON)
	BillJsonDataList search_bill_data_by_keyword(String keyword);
	
	// OK
	@Get("/events/{year}/{location}")
	Object getEventsByYearAndLocation(int year, String location);

	// OK
	@Get("/events/{year}/{location}")
	Object getEventsByLocationAndYear(String location, int year);
}