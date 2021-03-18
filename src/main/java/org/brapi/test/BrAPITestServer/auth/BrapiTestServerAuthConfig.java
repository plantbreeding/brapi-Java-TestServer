package org.brapi.test.BrAPITestServer.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity 
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class BrapiTestServerAuthConfig extends WebSecurityConfigurerAdapter{

	@Value( "${security.oidc_discovery_url}" )
	private String oidcDiscoveryUrl;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .anyRequest()
                .permitAll().and() //TODO secure this
                //.authenticated().and()
                .addFilter(new BrapiTestServerJWTAuthFilter(authenticationManager(), oidcDiscoveryUrl))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
