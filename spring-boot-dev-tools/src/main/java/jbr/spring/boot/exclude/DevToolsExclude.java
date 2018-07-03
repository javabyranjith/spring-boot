package jbr.spring.boot.exclude;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DevToolsExclude {

	private static final Logger log = LoggerFactory.getLogger(DevToolsExclude.class);

	public void printMe() {
		log.info("inside DevToolsExclude--change class");
	}
}
