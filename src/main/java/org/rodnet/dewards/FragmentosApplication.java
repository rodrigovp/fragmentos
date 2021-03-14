package org.rodnet.dewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FragmentosApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext run = SpringApplication.run(FragmentosApplication.class, args);
		run.getBean(FragmentosRunner.class).run(args);
	}
}
