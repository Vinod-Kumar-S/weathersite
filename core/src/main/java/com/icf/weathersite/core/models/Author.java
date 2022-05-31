package com.icf.weathersite.core.models;

import com.icf.weathersite.core.Pojo.AuthorPojo;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Author {


    @ChildResource
    private List<AuthorPojo> multiLink;


    public List<AuthorPojo> getMultiLink() {
        return multiLink;
    }
}