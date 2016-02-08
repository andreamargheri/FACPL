/**
 * 
 */
package it.unifi.xtext.facpl.ui.popup.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.facpl2.Request;
import it.unifi.xtext.facpl.generator.SMT_LIBGenerator;
import it.unifi.xtext.facpl.generator.util.SecurityProperty;
import it.unifi.xtext.facpl.ui.popup.actions.propertyDialog.PropertyNameDialog;

/**
 * @author Andrea Margheri
 *
 */
public class SecurityPropertyCommand extends AbstractHandler implements IHandler {

	@Inject
	private SMT_LIBGenerator generator;

	@Inject
	IResourceDescriptions resourceDescriptions;

	@Inject
	IResourceSetProvider resourceSetProvider;

	@Inject
	// private IFileSystemAccess fileAccess;
	private Provider<EclipseResourceFileSystemAccess2> fileAccessProvider;

	public Object execute(ExecutionEvent event) throws ExecutionException {

		Shell activeShell = HandlerUtil.getActiveShell(event);

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof IFile) {

				IFile file = (IFile) firstElement;
				IProject project = file.getProject();

				IFolder srcGenFolder = project.getFolder("src-smtlib");
				if (!srcGenFolder.exists()) {
					try {
						srcGenFolder.create(true, true, new NullProgressMonitor());
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}

				final EclipseResourceFileSystemAccess2 fsa = fileAccessProvider.get();

				// OUTPUTConfiguration
				OutputConfiguration onceOutput = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
				onceOutput.setDescription("Output Folder");
				onceOutput.setOutputDirectory("./src-smtlib");
				onceOutput.setOverrideExistingResources(true);
				onceOutput.setCreateOutputDirectory(true);
				onceOutput.setCleanUpDerivedResources(true);
				onceOutput.setSetDerivedProperty(true);

				Map<String, OutputConfiguration> output = new HashMap<String, OutputConfiguration>();
				output.put("DEFAULT_OUTPUT", onceOutput);
				fsa.setOutputConfigurations(output);

				fsa.setMonitor(new NullProgressMonitor());
				fsa.setProject(project);

				URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				ResourceSet rs = resourceSetProvider.get(project);
				Resource r = rs.getResource(uri, true);

				for (Object e : r.getContents()) {
					if (e instanceof Facpl) {
						// Call SMTLIB generation
						try {
							generator.doGenerateFileSMT_LIB((Facpl) e, fsa);

							/* 0 -> Choose a Property Name */
							PropertyNameDialog dialog = new PropertyNameDialog(activeShell);
							dialog.create();
							if (dialog.open() == Window.OK) {
								System.out.println(dialog.getPropertyName());
							}

							/* 1 -> Choose the Property */

							String msg_info = "Check the FACPL guide at http://facpl.sf.net/guide/index.html for further details";

							ElementListSelectionDialog type_P_dialog = new ElementListSelectionDialog(activeShell,
									new LabelProvider());
							type_P_dialog.setMessage(msg_info);
							// type_P_dialog.setElements(new String[] { "EVAL",
							// "MAY", "MUST" });
							type_P_dialog.setElements(new SecurityProperty[] { SecurityProperty.EVAL,
									SecurityProperty.MAY, SecurityProperty.MUST });
							type_P_dialog.setTitle("Which security property...");

							// user pressed cancel
							if (type_P_dialog.open() != Window.OK) {
								return false;
							}

							SecurityProperty sec_prop = _getSecProp(type_P_dialog.getResult());

							System.out.println(sec_prop);

							/* 2 -> Choose the Request */

							ElementListSelectionDialog type_Request_dialog = new ElementListSelectionDialog(activeShell,
									new LabelProvider());
							type_Request_dialog.setMessage(msg_info);
							try {
								type_Request_dialog.setElements(getRequests((Facpl) e));
							} catch (Exception ex) {
								MessageDialog.openError(activeShell, "Security Property", ex.getMessage());
								return false;
							}
							type_Request_dialog.setTitle("Which request...");

							// user pressed cancel
							if (type_Request_dialog.open() != Window.OK) {
								return false;
							}

							// TODO GET REQUEST

							/* 3 -> Choose the Policy */
							
							ElementListSelectionDialog type_Policy_dialog = new ElementListSelectionDialog(activeShell,
									new LabelProvider());
							type_Request_dialog.setMessage(msg_info);
							try {
								type_Request_dialog.setElements(getPolicies((Facpl) e));
							} catch (Exception ex) {
								MessageDialog.openError(activeShell, "Security Property", ex.getMessage());
								return false;
							}
							type_Request_dialog.setTitle("Which policy...");

							// user pressed cancel
							if (type_Request_dialog.open() != Window.OK) {
								return false;
							}

							
							//TODO Get Policy
							
							
							/* 4 -> Generate the file for the Verification of the chosen Property */
							
							
							//TODO  Generate SMT-LIB code
							

						} catch (Exception ex) {
							MessageDialog.openWarning(activeShell, "Generate SMT-LIB", ex.getMessage());
						}
					}
				}
			}
		}

		return null;

	}

	private Object[] getPolicies(Facpl e)  throws Exception {
		ArrayList<String> ar = new ArrayList<String>();
		if (e.getRequests().size() == 0) {
			throw new Exception("No policies are defined in the chosen FACPL file. Declare at least one policy to use in Property Specification");
		}
		
		
		/*
		 * 
		 * 
		 * 
		 * TODO
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		return ar.toArray();
	}

	private Object[] getRequests(Facpl e) throws Exception {
		ArrayList<String> ar = new ArrayList<String>();
		if (e.getRequests().size() == 0) {
			throw new Exception("No requests are defined in the chosen FACPL file. Declare at least one request to use in Property Specification");
		}
		for (Request r : e.getRequests()) {
			ar.add(r.getName());
		}
		return ar.toArray();
	}

	private SecurityProperty _getSecProp(Object[] result) {
		if (result[0].equals("EVAL")) {
			return SecurityProperty.EVAL;
		} else if (result[0].equals("MAY")) {
			return SecurityProperty.MAY;
		} else {
			return SecurityProperty.MUST;
		}

	}

}
