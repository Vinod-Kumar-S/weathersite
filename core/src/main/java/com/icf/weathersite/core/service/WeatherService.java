package com.icf.weathersite.core.service;

import com.icf.weathersite.core.data.ApiResponse;
import com.icf.weathersite.core.fiveDaysData.ApiResponseFiveDays;
import com.icf.weathersite.core.hourlyData.HourlyApiResponse;

public interface WeatherService {

    ApiResponse getCurrentWeather(String cityName);
    ApiResponseFiveDays getDailyForecastFor5Days(String name);
    HourlyApiResponse getClimateForecastForHourly(String lon, String lat);

}
