package it.ntt.SQLog4J;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloExample{
	
	final static Logger logger = LogManager.getLogger(HelloExample.class);
	
	public static void main(String[] args) {
	
		HelloExample obj = new HelloExample();
		obj.tryPrintLog("Trying");
		logger.warn("This is warn : " );
		logger.error("This is error : " );
		logger.fatal("This is fatal : " );

		logger.info("This is debug : ");
	}
	
	private void tryPrintLog(String parameter){
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		
		logger.warn("This is warn: " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
		
	}
	
}