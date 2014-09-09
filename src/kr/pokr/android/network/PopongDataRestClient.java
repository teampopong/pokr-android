package kr.pokr.android.network;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.MediaType;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

@Rest(rootUrl = "http://api.popong.com/v0.1/", converters = { MappingJacksonHttpMessageConverter.class })
public interface PopongDataRestClient {
	
	@Get("bill/?api_key=test")
	@Accept(MediaType.APPLICATION_JSON)
	Object getEvents();

	// OK
	@Get("/events/{year}/{location}")
	Object getEventsByYearAndLocation(int year, String location);

	// OK
	@Get("/events/{year}/{location}")
	Object getEventsByLocationAndYear(String location, int year);
}