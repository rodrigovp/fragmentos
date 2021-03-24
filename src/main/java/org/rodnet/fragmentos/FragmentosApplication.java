package org.rodnet.fragmentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FragmentosApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ac = SpringApplication.run(FragmentosApplication.class, args);
		ac.getBean(FragmentosRunner.class).run();
	}
}
