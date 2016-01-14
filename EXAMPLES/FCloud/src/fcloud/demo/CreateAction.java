package fcloud.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

import it.unifi.facpl.lib.interfaces.IPepAction;

public class CreateAction implements IPepAction {
	/**
	 * @param args
	 *            0 = HYPER_1 or HYPER_2 1 = VM name 2 = TYPE_1 or TYPE_2
	 * @throws Throwable
	 */
	public void eval(List<Object> args) throws Throwable {
		String absPath = FCloud.getInstance().getAbsPath();

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(absPath + File.separator + args.get(0) + ".properties")));

			int n = 0;
			if (args.get(2).equals("TYPE_1"))
				n = 1;
			else
				n = 2;
			prop.setProperty("VM_" + args.get(2) + "s",
					Integer.toString(Integer.parseInt(prop.getProperty("VM_" + args.get(2) + "s")) + 1));
			prop.setProperty("VM_" + args.get(2) + "_" + args.get(1) + "load", Integer.toString(n));
			prop.setProperty("availableResources",
					Integer.toString(Integer.parseInt(prop.getProperty("availableResources")) - n));

			prop.store(new FileOutputStream(new File(absPath + File.separator + args.get(0) + ".properties")),
					"Add new VM");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
