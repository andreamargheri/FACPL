package it.unifi.xtext.facpl.ui.popup.actions;

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
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

import it.unifi.xtext.facpl.ui.popup.actions.XACMLToFACPL.ParserxacmlToFacplEntryPoint;

public class XACMLTOFACPLCommand extends AbstractHandler implements IHandler {

	@Inject
	IResourceDescriptions resourceDescriptions;

	@Inject
	IResourceSetProvider resourceSetProvider;

	@Inject 
	private Provider<EclipseResourceFileSystemAccess2> fileAccessProvider;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		IFile file = (IFile) activeEditor.getEditorInput().getAdapter(IFile.class);
		IProject project = file.getProject();

		IFolder srcGenFolder = project.getFolder("gen-FACPL");
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
		onceOutput.setOutputDirectory("./gen-FACPL");
		onceOutput.setOverrideExistingResources(true);
		onceOutput.setCreateOutputDirectory(true);
		onceOutput.setCleanUpDerivedResources(true);
		onceOutput.setSetDerivedProperty(true);

		Map<String,OutputConfiguration> output = new HashMap<String,OutputConfiguration>();
		output.put("DEFAULT_OUTPUT", onceOutput);
		fsa.setOutputConfigurations(output);

		fsa.setMonitor(new NullProgressMonitor());
		fsa.setProject(project);
		
		//URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		//ResourceSet rs = resourceSetProvider.get(project);
		//Resource r = rs.getResource(uri, true);
		
		try {
			String s = ParserxacmlToFacplEntryPoint.translate(file);

			//Create output file usint fsa, input of file given by string s
			//Removed the .xml extension
			fsa.generateFile(file.getName().substring(0, file.getName().length()-4)+".fpl",s );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
