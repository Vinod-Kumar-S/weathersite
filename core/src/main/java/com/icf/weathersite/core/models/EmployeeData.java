package com.icf.weathersite.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EmployeeData {

    @ChildResource
    private List <EmployeeDataPojo> employeeDataPojoList;

    public List<EmployeeDataPojo> getEmployeeDataPojoList(){
        return employeeDataPojoList;
    }


}