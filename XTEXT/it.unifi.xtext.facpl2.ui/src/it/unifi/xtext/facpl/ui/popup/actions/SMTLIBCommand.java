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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.generator.Z3Generator;

public class SMTLIBCommand extends AbstractHandler implements IHandler {

	@Inject
	private Z3Generator generator;

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
						srcGenFolder.create(true, true,
								new NullProgressMonitor());
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}

				final EclipseResourceFileSystemAccess2 fsa = fileAccessProvider
						.get();

				// OUTPUTConfiguration
				OutputConfiguration onceOutput = new OutputConfiguration(
						IFileSystemAccess.DEFAULT_OUTPUT);
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

				URI uri = URI.createPlatformResourceURI(file.getFullPath()
						.toString(), true);
				ResourceSet rs = resourceSetProvider.get(project);
				Resource r = rs.getResource(uri, true);

				for (Object e : r.getContents()) {
					if (e instanceof Facpl) {
						// Call SMTLIB generation
						try {
							generator.doGenerateFileZ3((Facpl) e, fsa);

							MessageDialog.openInformation(activeShell,
									"Generate SMT-LIB",
									"All SMT-LIB code generated!");
						} catch (Exception ex) {
							MessageDialog.openWarning(activeShell,
									"Generate SMT-LIB", ex.getMessage());
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
