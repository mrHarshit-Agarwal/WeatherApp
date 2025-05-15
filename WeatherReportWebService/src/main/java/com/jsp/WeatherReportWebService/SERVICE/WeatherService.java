package com.jsp.WeatherReportWebService.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.WeatherReportWebService.DTO.Weather;
import com.jsp.WeatherReportWebService.REPOSITORY.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	WeatherRepository repository;

	// to insert weather object into DB
	public Weather insertWeather(Weather weather) {
		return repository.save(weather);
	}

	// to fetch all weather reports(all objects) from DB
	public List<Weather> getAllWeather() {
		return repository.findAll();
	}

	// to fetch a weather report(specific object) based on ID
	public Weather getWeatherById(int id) {

		Optional<Weather> opt = repository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	// to update weather conditions and temperature based on weather id
	public String updateWeather(int id, String newCondt, String newTemp) {

		Weather w = getWeatherById(id);
		if (w != null) {
			w.setConditions(newCondt);
			w.setTemperature(newTemp);
			repository.save(w);
			return "Weather details are updated...";
		} else {
			return "Weather report doesnt exist...";
		}
	}

	// to delete a weather object based on ID
	public String deleteWeather(int id) {

		Weather w = getWeatherById(id);
		if (w != null) {

			repository.delete(w);
			// OR
			// repository.deleteById(id);
			return "weather report is deleted...";
		} else {
			return "weather report doesnt exist.";
		}
	}
	
	// to fetch all weather reports based on city
	public List<Weather> getAllCity(String city) {
		return repository.findByCity(city);
	}
	
	// to update weather condition based on date
	public String updateConditionsByDate(String condt , String date) {
			
		int rows = repository.updateWeatherByDate(condt, date);
		if(rows == 0) {
			return "No weather reports on "+date;
		}
		else {
			return "weather report is updated...";
		}
	}
}














