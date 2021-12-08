package com.icf.weathersite.core.models;

import com.icf.weathersite.core.service.WeatherService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = WeatherForecastImpl.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class WeatherForecastImpl implements WeatherForecast {

    @OSGiService
    public WeatherService weatherService;

    @Inject
    public String currentTemperature;

    @Inject
    public String sunriseTime;

    @Inject
    public String sunsetTime;

    @Inject
    public String maximumTemperature;

    @Inject
    public String minimumTemperature;

    @Inject
    public String humidity;

    @Override
    public String getCurrentTemperature() {

        String name = null;
        weatherService.getCurrentWeather(name);
        return null;
    }

    public void setCurrentTemperature(String currentTemperature) {

        this.currentTemperature = currentTemperature;
    }

    @Override
    public String getSunriseTime() {

        return null;
    }

    public void setSunriseTime(String sunriseTime) {

        this.sunriseTime = sunriseTime;
    }

    @Override
    public String getSunsetTime() {

        return null;
    }

    public void setSunsetTime(String sunsetTime) {

        this.sunsetTime = sunsetTime;
    }

    @Override
    public String getMaximumTemperature() {

        return null;
    }

    public void setMaximumTemperature(String maximumTemperature) {

        this.maximumTemperature = maximumTemperature;
    }

    @Override
    public String getMinimumTemperature() {

        return null;
    }

    public void setMinimumTemperature(String minimumTemperature) {

        this.minimumTemperature = minimumTemperature;
    }

    public void setWeatherService(WeatherService weatherService) {

        this.weatherService = weatherService;
    }

    @Override
    public String getHumidity() {

        return null;
    }

    public void setHumidity(String humidity) {

        this.humidity = humidity;
    }
}
