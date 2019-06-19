package com.garciagiovane.cloud.netflixoss.karyon;

import com.garciagiovane.cloud.netflixoss.karyon.KaryonJerseyServerApp.KaryonJerseyModuleImpl;
import com.garciagiovane.cloud.netflixoss.karyon.rest.PowService;
import com.netflix.governator.annotations.Modules;

import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.KaryonBootstrap;
import netflix.karyon.archaius.ArchaiusBootstrap;
import netflix.karyon.eureka.KaryonEurekaModule;
import netflix.karyon.jersey.blocking.KaryonJerseyModule;
import netflix.karyon.servo.KaryonServoModule;

@ArchaiusBootstrap
@KaryonBootstrap(name = "pow-microservice", healthcheck = HealthcheckResource.class)
@Modules(include = { 
		ShutdownModule.class, 
		KaryonWebAdminModule.class, 
		KaryonServoModule.class,
		KaryonJerseyModuleImpl.class, 
		KaryonEurekaModule.class })
public interface KaryonJerseyServerApp {
	class KaryonJerseyModuleImpl extends KaryonJerseyModule {
		@Override
		protected void configureServer() {

			bind(PowService.class).asEagerSingleton();

			bind(AuthenticationService.class).to(AuthenticationServiceImpl.class);
			interceptorSupport().forUri("/*").intercept(LoggingInterceptor.class);
			interceptorSupport().forUri("/math").interceptIn(AuthInterceptor.class);
			server().port(6007).threadPoolSize(400);
		}
	}
}
