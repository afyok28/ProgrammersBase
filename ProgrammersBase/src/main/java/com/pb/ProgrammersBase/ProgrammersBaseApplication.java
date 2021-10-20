/* Created by Adam Jost on 09/13/2021 */
package com.pb.ProgrammersBase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProgrammersBaseApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammersBaseApplication.class, args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProgrammersBaseApplication.class);
	}
}
