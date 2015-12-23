package it.unifi.xtext.facpl.ui.popup.actions;


import it.unifi.xtext.facpl.generator.Facpl2Generator_Menu;

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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class GenerateFacplCode extends AbstractHandler implements IHandler {


	@Inject
	private Facpl2Generator_Menu generator;

	@Inject
	XtextResourceSetProvider resourceSetProvider;

	@Inject 
	//private IFileSystemAccess fileAccess;
	private Provider<EclipseResourceFileSystemAccess2> fileAccessProvider;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof IFile) {
				IFile file = (IFile) firstElement;
				IProject project = file.getProject();

				IFolder srcGenFolder = project.getFolder("src");
				if (!srcGenFolder.exists()) {
					try {
						srcGenFolder.create(true, true, new NullProgressMonitor());
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}

				final EclipseResourceFileSystemAccess2 fsa = fileAccessProvider.get();

				//OUTPUTConfiguration
				OutputConfiguration onceOutput = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
				onceOutput.setDescription("Output Folder");
				onceOutput.setOutputDirectory("./src");
				onceOutput.setOverrideExistingResources(true);
				onceOutput.setCreateOutputDirectory(true);
				onceOutput.setCleanUpDerivedResources(true);
				onceOutput.setSetDerivedProperty(true);

				Map<String,OutputConfiguration> output = new HashMap<String,OutputConfiguration>();
				output.put("DEFAULT_OUTPUT", onceOutput);
				fsa.setOutputConfigurations(output);
				
				fsa.setMonitor(new NullProgressMonitor());
				fsa.setProject(project);

				URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				ResourceSet rs = resourceSetProvider.get(project);
				Resource r = rs.getResource(uri, true);

				generator.doGenerateFacpl(r, fsa, "");
			}
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
