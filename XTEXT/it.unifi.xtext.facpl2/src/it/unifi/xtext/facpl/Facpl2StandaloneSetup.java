/*
 * generated by Xtext
 */
package it.unifi.xtext.facpl;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class Facpl2StandaloneSetup extends Facpl2StandaloneSetupGenerated {

	public static void doSetup() {
		new Facpl2StandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
