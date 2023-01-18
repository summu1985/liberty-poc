package com.redhat.demo.dataformatdemo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import java.sql.Timestamp; 
import java.time.LocalDate;

import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;


@Component
public class SimpleRouteBuilder extends RouteBuilder {

    private final Environment env;

    public SimpleRouteBuilder(Environment env) {
        this.env = env;
    }

    @Override
    public void configure() throws Exception {

        restConfiguration()
        .component("servlet");

        rest()
        .consumes(MediaType.APPLICATION_JSON_VALUE)
        .produces(MediaType.APPLICATION_JSON_VALUE)

        //.get("/opportunity").to("{{route.findAllOpportunities}}")
        .post("/prospect").to("direct:getCustomer");
        //.get("/myfile").to("direct:viewfile");

        from("direct:getCustomer")
        .to("log:response")
        .to("atlasmap:atlasmap-mapping.adm")
                .convertBodyTo(String.class)
                //.unmarshal(getJacksonDataFormat(OpportunityList.class))
                //.marshal().json()
                .to("log:response");


    }

    private JacksonDataFormat getJacksonDataFormat(Class<?> unmarshalType) {
        JacksonDataFormat format = new JacksonDataFormat();
        format.setUnmarshalType(unmarshalType);
        return format;
    }
}
