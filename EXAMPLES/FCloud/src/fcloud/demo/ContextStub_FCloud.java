package fcloud.demo;


import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import it.unifi.facpl.lib.interfaces.IContextStub;
import it.unifi.facpl.lib.util.AttributeName;
import it.unifi.facpl.lib.util.Bag;
import it.unifi.facpl.lib.util.exception.MissingAttributeException;

@SuppressWarnings("all")
public class ContextStub_FCloud implements IContextStub{

	private static ContextStub_FCloud instance; 

	private String absPath; //path obtained by the cloud simulation environment
	
	private static int num; //numeric identifier for creating vm-id
	
	public static ContextStub_FCloud getInstance(){
		if (instance == null){
			instance = new ContextStub_FCloud();
		}
		return instance;
	}

	private ContextStub_FCloud(){
		
		absPath = FCloud.getInstance().getAbsPath();
		
		if (absPath == "")
			System.err.println("You MUST execute PDP initialistion before loading requests");
		
	}

	@Override
	public Object getContextValues(AttributeName attribute) {
		//Context Time Value
		if (attribute.getCategory().equals("environment") && attribute.getIDAttribute().equals("time")){
			return new Date();
		}
		//True and False constant
		if (attribute.getCategory().equals("environment") && attribute.getIDAttribute().equals("true")){
			return true;
		}
		if (attribute.getCategory().equals("environment") && attribute.getIDAttribute().equals("false")){
			return false;
		}
		//for each hyper: hyper#. (availableResources | vm-ids | vm1-counter)
		if (attribute.getCategory().equals("system")){
			String id = attribute.getIDAttribute();
			if (id.equals("vm-id")){
//				return UUID.randomUUID().toString();
				return getRandomId();
			}
			if (id.indexOf('.') != -1){
				if (id.subSequence(0, id.indexOf('.')).equals("hyper1")){
					//hypervisor 1
					String last = id.substring(id.indexOf('.')+1);
					if (last.equals("availableResources")){
						System.out.println("AvailableResourcesH1: " + getResources("HYPER_1"));
						return getResources("HYPER_1");
					}else if (last.equals("vm-ids")){
						return getIDs("HYPER_1");
					}else if (last.equals("vm1-counter")){
						return getVmCounter("HYPER_1","TYPE_1");
					}else {
						return new MissingAttributeException();
					}
				}else if (id.subSequence(0, id.indexOf('.')).equals("hyper2")){
					//hypervisor 2
					String last = id.substring(id.indexOf('.')+1);
					if (last.equals("availableResources")){
						System.out.println("AvailableResourcesH2: " + getResources("HYPER_2"));
						return getResources("HYPER_2");
					}else if (last.equals("vm-ids")){
						return getIDs("HYPER_2");
					}else if (last.equals("vm1-counter")){
						return getVmCounter("HYPER_2","TYPE_1");
					}else {
						return new MissingAttributeException();
					}
				}
			}
		}
		return new MissingAttributeException();
	}

	private int getResources(String hyper){
		Properties prop = new Properties();
		int resources = 0;
		try {
			prop.load(new FileInputStream(new File(absPath + File.separator + hyper + ".properties")));

			resources = Integer.parseInt(prop.getProperty("availableResources"));

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return resources;
	}

	private int getVmCounter(String hyper,String type){
		Properties prop = new Properties();
		int counter = 0;
		try {
			prop.load(new FileInputStream(new File(absPath + File.separator + hyper + ".properties")));
			counter =  Integer.parseInt(prop.getProperty("VM_"+type+"s"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return counter;

	}

	private Bag getIDs (String hyper){
		Properties prop = new Properties();
		Bag bag = new Bag();
		try {
			prop.load(new FileInputStream(new File(absPath + File.separator + hyper + ".properties")));
			Enumeration<?> iter = prop.propertyNames();
			while (iter.hasMoreElements()){
				String s = (String) iter.nextElement();
				if ((s.contains("TYPE_2") || s.contains("TYPE_1")) && (!(s.contains("VM_TYPE_1s"))&&!(s.contains("VM_TYPE_2s")))){
					//get VM id and then add to List 
					String vm_id = s.substring(new String("VM_TYPE_1_").length(), s.length()-4);
					bag.addValue(vm_id);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return bag;
	}
	
	private String getRandomId() {
		num ++;
		return "vm_id" + num;
	}

}
