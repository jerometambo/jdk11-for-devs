package org.jerometambo.jdk11;

import io.undertow.Undertow;
import io.undertow.util.Headers;

public class ServerLite {
    
    public static void main(String... args) {
        Undertow server = Undertow.builder()
                .addHttpListener(1234, "localhost")
                .setHandler(
                        exchange ->
                        {
                            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                            exchange.getResponseSender().send("Hello, Citoyens de la santé et du " + exchange.getQueryParameters().get("a").peekFirst().replaceAll("\\[","").replaceAll("/",""));
                            System.out.println("Accept-Charset : " + exchange.getRequestHeaders().get("Accept-Charset"));
                        }).build();
        server.start();
    }
    
}
