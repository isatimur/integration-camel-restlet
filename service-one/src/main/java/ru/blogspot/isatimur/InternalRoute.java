package ru.blogspot.isatimur;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http.HttpOperationFailedException;

/**
 * Created by tisachenko on 25.08.15.
 */
public class InternalRoute extends RouteBuilder {
    public void configure() {

        //TODO: configure this path independently http://localhost:9090/services/rest/v1
        from("restlet://http://localhost:9090/services/rest/v1/hello/{id}?restletMethod=GET")
                .removeHeaders("CamelHttp*", "CamelHttp(Method|Path|Query)")
                .transform().simple("${header.id}")
                //TODO: configure this path independently the same goes here http://localhost:9094/altyn-services/services/rest/hello_world/${header.id}/
                .recipientList(simple("http://localhost:9094/services/service-two/rest/hello_world/${header.id}/?bridgeEndpoint=true&amp;transferException=true"))
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Message msg = exchange.getIn();
                        msg.setHeader(Exchange.CONTENT_TYPE, constant("text/html"));

                    }
                })
                .onException(HttpOperationFailedException.class)
                .setHeader("CamelHttpResponseCode").simple("${exception.statusCode}")
                .setBody().simple("${exception.responseBody}");


    }

}
