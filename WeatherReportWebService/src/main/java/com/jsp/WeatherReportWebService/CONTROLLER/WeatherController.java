package com.jsp.WeatherReportWebService.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.WeatherReportWebService.DTO.Weather;
import com.jsp.WeatherReportWebService.SERVICE.WeatherService;

@RestController // @Controller + @ResponseBody
public class WeatherController {

	@Autowired
	WeatherService service;

	// REST API TO INSERT A WEATHER OBJECT INTO DB

	@PostMapping("/weather")
	public Weather storeWeatherReport(@RequestBody Weather weather) {
		return service.insertWeather(weather);
	}
	
	// REST API TO RETRIEVE ALL WEATHER OBJECTS FROM DB
	
	@GetMapping("/weather")
	public List<Weather> getAllWeatherReports() {
		return service.getAllWeather();
	}
	
	// REST API TO RETRIEVE A WEATHER OBJECT FROM DB BASED ON ID
	
	@GetMapping("/byid")
	public Weather getWeatherReport(@RequestParam int id) {
		return service.getWeatherById(id);
	}
	
	// REST API TO UPDATE WEATHER CONDITIONS AND TEMPERATURE BASED ON ID
	
	@PutMapping("/weather")
	public String updateWeatherReport(@RequestParam int id , @RequestParam String condt , 
								@RequestParam String temp) {
		
		return service.updateWeather(id, condt, temp);
	}
	
	// REST API TO DELETE A WEATHER REPORT BASED ON ID
	@DeleteMapping("/weather")
	public String deleteWeatherReport(@RequestParam int id) {
	
		return service.deleteWeather(id);
	}
	
	// REST API TO FETCH ALL WEATHER REPORTS BASED ON CITY
	
	@GetMapping("/bycity")
	public List<Weather> getWeatherByCity(@RequestParam String city) {
		return service.getAllCity(city);
	}
	
	// REST API TO UPDATE WEATHER CONDITIONS BASED ON DATE
	
	@PutMapping("/bydate")
	public String updateWeatherByDate(@RequestParam String condt ,@RequestParam String date) {
		return service.updateConditionsByDate(condt, date);
	}
}













