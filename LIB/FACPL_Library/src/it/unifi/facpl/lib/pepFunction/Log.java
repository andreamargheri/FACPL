package it.unifi.facpl.lib.pepFunction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.unifi.facpl.lib.interfaces.IPepAction;

public class Log implements IPepAction{

	@Override
	public void eval(List<Object> args) throws Throwable {
		Logger l = LoggerFactory.getLogger(Log.class);
		try{
			Date d = new Date();
			// Create file 
			BufferedWriter out = new BufferedWriter(new FileWriter("log.txt",true));
		  			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
			
			System.out.println(dateFormat.format(d));
			
			out.write(dateFormat.format(d) + " -  Log: " );
			for (Object a : args){
				out.write(a.toString() + " ");
			}
			out.write("\n");
			//Close the output stream
			out.close();
		}catch (Exception e){//Catch exception if any
			l.debug("Error in log pep function: " + e.getMessage());
			throw e; //throw to manage indet result from enforcement algorithm
		}
	}
}
