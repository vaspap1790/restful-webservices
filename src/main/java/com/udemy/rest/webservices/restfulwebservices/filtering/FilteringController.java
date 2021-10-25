package com.udemy.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

//    @GetMapping("/filtering")
//    public SomeBean retrieveSomeBean(){
//        return new SomeBean("value1", "value2", "value3");
//    }

//    @GetMapping("/filtering-list")
//    public List<SomeBean> retrieveSomeBeanList(){
//        return Arrays.asList(new SomeBean("value11", "value12", "value13"), new SomeBean("value21", "value22", "value23"));
//    }

    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue retrieveSomeBeanDynamic(){

        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

}
