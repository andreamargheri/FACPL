package generator;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import generator.util.ValidationException;
import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.generator.Facpl2Generator;
import it.unifi.xtext.facpl.generator.SMT_LIBGenerator;
import it.unifi.xtext.facpl.generator.XMLGenerator;
import it.unifi.xtext.facpl.generator.util.StructuralProperty;

public class FacplGenerator {

	private static FacplGenerator instance;
	
	/*
	 * The three FACPL code generators: 
	 * 1 - Java code generator (Facpl2Generator)
	 * 2 - SMT code generator (SMT_LIBGenerator)
	 * 3 - XACML code generator (XMLGenerator)
	 */
	
	@Inject
	private Facpl2Generator java_generator;

	@Inject
	private SMT_LIBGenerator smt_generator;
	
	@Inject
	private XMLGenerator xml_generator;
	
	
	/* ------ */
	
	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	@Inject
	private JavaIoFileSystemAccess fileAccess;
	
	
	private static void getInstance() {
		Injector injector = new it.unifi.xtext.facpl.Facpl2StandaloneSetupGenerated()
				.createInjectorAndDoEMFRegistration();
		instance = injector.getInstance(FacplGenerator.class);

	}
	
	
	/**
	 * 
	 * @param args:
	 *            (1) file FACPL; (2) output folder path
	 * @throws Exception
	 *             compile and validation exception. For validation checks is
	 *             thrown ValidationException
	 */
	public static void java_compile(String[] args) throws Exception {
		if (args.length != 2) {
			throw new Exception("Aborting: no output path and no path to EMF resource provided!");
		}
		
		if (instance == null) {
			getInstance();
		}

		instance.runGenerator_Java(args[0], args[1]);
	}

	public static void xml_compile(String[] args) throws Exception {
		if (args.length != 2) {
			throw new Exception("Aborting: no output path and no path to EMF resource provided!");
		}
		
		if (instance == null) {
			getInstance();
		}

		instance.runGenerator_XML(args[0], args[1]);
	}

	
	public static void compile_SMT_Complete(String[] args, int n_Prop) throws Exception {
		if (instance == null) {
			getInstance();
		}

		instance.runGenerator_SMT(args[0], args[1],n_Prop);

	}
	
	
	/* GENERATORs invocation methods */ 
	
	/**
	 * 
	 * @param string
	 *            Path of the file to compile
	 * @param outputPath
	 *            Folder where compiled policies will be added
	 * @throws ValidationException
	 */
	protected void runGenerator_Java(String string, String outputPath) throws ValidationException {
		// load the resource
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createURI(string), true);

		// validate the resource
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			ValidationException v = new ValidationException();
			int i = 0;
			for (Issue issue : list) {
				if (issue.getSeverity() != Severity.INFO && issue.getSeverity() != Severity.WARNING) {
					v.addError(issue);
					i++;
				}
			}
			if (i > 0) {
				throw v;
			}
		}

		// Configure and start the generator
		fileAccess.setOutputPath(outputPath);

		// System.out.println(set.getResources());
		java_generator.doGenerate(resource, fileAccess);

		System.out.println("Java Code generation finished.");
	}

	
	
	protected void runGenerator_XML(String string, String outputPath) throws Exception {
		// load the resource
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createURI(string), true);

		// validate the resource
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			ValidationException v = new ValidationException();
			int i = 0;
			for (Issue issue : list) {
				if (issue.getSeverity() != Severity.INFO && issue.getSeverity() != Severity.WARNING) {
					v.addError(issue);
					i++;
				}
			}
			if (i > 0) {
				throw v;
			}
		}

		// Configure and start the generator
		fileAccess.setOutputPath(outputPath);

		// System.out.println(set.getResources());
		xml_generator.doGenerateFileXACML(resource, fileAccess);

		System.out.println("XACML Code generation finished.");
	}

	private void runGenerator_SMT(String string, String outputPath, int n_Prop) throws ValidationException {
		// load the resource
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createURI(string), true);

		// validate the resource
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			ValidationException v = new ValidationException();
			int i = 0;
			for (Issue issue : list) {
				if (issue.getSeverity() != Severity.INFO && issue.getSeverity() != Severity.WARNING) {
					v.addError(issue);
					i++;
				}
			}
			if (i > 0) {
				throw v;
			}
		}


		// Configure and start the generator
		//System.out.println(outputPath);
		fileAccess.setOutputPath(outputPath);

		// System.out.println(set.getResources());
		for (EObject e : resource.getContents()) {
			if (e instanceof Facpl) {
				smt_generator.doGenerateStructural_Property((Facpl) e, "root", "", "COMPLETE_" + n_Prop,
						StructuralProperty.COMPLETE, fileAccess);
				
				/* TO USE THE FOLLOWING CODE IF INTERESTED IN JUST CREATING SMT_LIB CODE */
				
				// smt_generator.doGenerateComplete_Property_Code((Facpl) e,"root");
				System.out.println("End code Generation");
			}
		}

	}

}
