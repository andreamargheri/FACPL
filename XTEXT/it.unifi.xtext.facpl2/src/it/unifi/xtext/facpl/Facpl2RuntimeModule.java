/*
 * generated by Xtext
 */
package it.unifi.xtext.facpl;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class Facpl2RuntimeModule extends it.unifi.xtext.facpl.AbstractFacpl2RuntimeModule {

	@Override
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider.class;
	}
}
