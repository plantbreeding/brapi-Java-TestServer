package org.brapi.test.BrAPITestServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class BrapiTestServer 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(BrapiTestServer.class, args);
    }
}
