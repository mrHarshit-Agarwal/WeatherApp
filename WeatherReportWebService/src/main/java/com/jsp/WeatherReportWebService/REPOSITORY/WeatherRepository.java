package com.jsp.WeatherReportWebService.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.jsp.WeatherReportWebService.DTO.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Integer>
{
	// all methods of JpaRepository interface will be inherited

	// JPQL QUERY
	@Query("select w from Weather w where w.city=?1")
	public List<Weather> findByCity(String city);
	
	// SQL QUERY
	//	@Query(value = "select * from weather where city=?1" , nativeQuery = true)
	//	public List<Weather> findByCity(String city);
	
	
	@Modifying
	@Transactional
	@Query("update Weather w set w.conditions=?1 where w.date=?2")
	public int updateWeatherByDate(String conditions , String date);
}








