package fcloud.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.UUID;

public class FCloud {

	private String absPath;
	private static FCloud instance;

	private FCloud() {
		this.absPath = "";
	}

	public static FCloud getInstance() {
		if (FCloud.instance == null) {
			FCloud.instance = new FCloud();
		}
		return FCloud.instance;
	}

	public String getAbsPath() {
		return absPath;
	}

	/**
	 * Setting up the simulation environment. Each Hypervisor has 10 units of
	 * resource and VM TYPE_1 and TYPE_2 costs 1 and 2 units respectively.
	 * 
	 * @param absPath
	 *            Path of the folder where the files for Cloud simulation are
	 *            places
	 */
	public void initializeSimulation(String absPath) {
		// INITIALIZE CLOUD SYSTEM

		this.absPath = absPath;

		File system_folder = new File(absPath);
		system_folder.delete();
		system_folder.mkdir();

		this.createSystemProp(system_folder);
	}

	private void createSystemProp(File system_folder) {

		// System properties
		Properties props = new Properties();
		String id_system = UUID.randomUUID().toString();
		String status_system = "active";
		// #Hypervisors
		int _hype = 2;
		props.setProperty("id", id_system);
		props.setProperty("status", status_system);
		props.setProperty("n_hype", Integer.toString(_hype));

		try {

			props.store(new FileOutputStream(system_folder.getAbsoluteFile() + File.separator + "system.properties"),
					null);

		} catch (Exception e) {

			e.printStackTrace();
		}

		// Hypervisor properties

		// create file for hypervisor
		for (int i = 1; i <= _hype; i++) {
			Properties prop_hype = new Properties();
			int t = 10;

			prop_hype.setProperty("availableResources", Integer.toString(t));
			prop_hype.setProperty("status", "active");

			addVMs(prop_hype);

			try {
				prop_hype.store(
						new FileOutputStream(new File(
								system_folder.getAbsoluteFile() + File.separator + "HYPER_" + i + ".properties")),
						null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void addVMs(Properties p) {
		p.setProperty("VM_TYPE_1s", Integer.toString(0));
		p.setProperty("VM_TYPE_2s", Integer.toString(0));
	}

}
