package com.redhat.demo.asyncroutingdemo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import java.sql.Timestamp; 
import java.time.LocalDate;
import java.util.UUID;

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

        .post("/asyncrouting").to("direct:async-routing");
        //.get("/myfile").to("direct:viewfile");

        from("direct:async-routing")
        .to("log:request")
        .wireTap("direct:wiretap-routing")
        .process(exchange->{
            UUID uuid=UUID.randomUUID();
            exchange.getIn().setBody("Employee Creation request acknowledged. Reference number : " + uuid);
            exchange.getIn().setHeader("ackId", uuid);
        })
        .to("log:response");

        from("direct:wiretap-routing")
        .to("atlasmap:employee-xml-to-json-mapping.adm")
        .convertBodyTo(String.class)
        .to("log:outgoing-request")
        .setHeader(Exchange.HTTP_METHOD, constant("POST"))
        .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
        .to("https://dummy.restapiexample.com/api/v1/create?bridgeEndpoint=true")
        //.unmarshal(getJacksonDataFormat(OpportunityList.class))
        //.marshal().json()
        .convertBodyTo(String.class)
        .to("log:async-response")
        .to("kafka:requests?brokers={{camel.component.kafka.brokers}}");
    }

    private JacksonDataFormat getJacksonDataFormat(Class<?> unmarshalType) {
        JacksonDataFormat format = new JacksonDataFormat();
        format.setUnmarshalType(unmarshalType);
        return format;
    }
}
