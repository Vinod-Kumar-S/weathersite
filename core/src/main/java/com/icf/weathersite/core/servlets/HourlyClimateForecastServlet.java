package com.icf.weathersite.core.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icf.weathersite.core.data.ApiError;
import com.icf.weathersite.core.data.ApiResponse;
import com.icf.weathersite.core.hourlyData.HourlyApiResponse;
import com.icf.weathersite.core.service.WeatherService;
import org.apache.http.HttpStatus;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(service = { Servlet.class }, property = {
        "sling.servlet.paths=/bin/weather/api/v1/hourlyweather"
})
@ServiceDescription("Servlet for getting the current Weather for a city by Latitude and Longitude")
public class HourlyClimateForecastServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;
    private Logger logger = LoggerFactory.getLogger(HourlyClimateForecastServlet.class.getName());

    @Reference
    WeatherService weatherService;

    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws IOException {
        String lon = req.getParameter("lon");
        String lat = req.getParameter("lat");

        ObjectMapper mapper = new ObjectMapper();
        logger.info("calling weatherservice for current weather for longitude and latitude : {}", lon, lat);
        HourlyApiResponse hourlyApiResponse = weatherService.getClimateForecastForHourly(lon, lat);
        logger.debug("got api response for current weather Longitude and Latitude : {} \n {}", lon, lat, hourlyApiResponse);
        if(hourlyApiResponse != null){
            logger.info("writing response to api call for current weather for city : {}", lon, lat);
            resp.getWriter().write(mapper.writeValueAsString(hourlyApiResponse));
        }else{
            logger.error("received null for current weather for city : {}", lon, lat);
            //set the response code
            resp.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
            //construct ApiError object
            ApiError apiError = new ApiError(HttpStatus.SC_INTERNAL_SERVER_ERROR, "There was an internal server error");
            //write the error response to the request
            resp.getWriter().write(mapper.writeValueAsString(apiError));
        }
    }

}
