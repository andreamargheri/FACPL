package it.unifi.xtext.facpl.ui.wizard;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;


/**
 * 
 * @author Andrea Margheri
 *
 */
public class NewFacplFileWizard extends Wizard implements INewWizard {
	private NewFacplFileWizardPage page;
	private ISelection selection;

	/**
	 * Constructor for NewFacplfileWizard.
	 */
	public NewFacplFileWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new NewFacplFileWizardPage(selection);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final String containerName = page.getContainerName();
		final String fileName = page.getFileName();
		final Button checkPDP = page.getCheckPDP();
		final Button checkMain = page.getCheckMain();
		final Button checkRequest = page.getCheckRequest();
		
		final StringBuffer string = new StringBuffer();
		
		if (checkMain.getSelection() == true){
			// add main option template
			string.append(
					
					"\n PAS {\n" + 
					"\t Extended Indeterminate : false ;\n"+
					"\t Java Package : \"foo\" ;\n"+
					"\t Requests To Evaluate : NameRequest ;\n\n"+
					"\t pep: deny-biased\n "+
					"\t pdp: permit-unless-deny\n\n"+
					"\t PolicySet PolName { deny-unless-permit-greedy\n"+
					"\t\t target: equal(\"value\",category/id) \n"+
					"\t\t policies:\n "+
					"\t\t Rule rule1 ( permit)\n"
					+ "\t }\n"+
					"}\n\n"
					);
		}
		if (checkPDP.getSelection() == true){
			// add policies template
			string.append(
					
					"\n"
					+ "PolicySet NamePolicySetOne { deny-overrides-greedy" +
					" \n \t " +
					"policies: \n"
					+ "\t PolicySet NamePolicySetTwo { deny-overrides \n " +
					"\t\t target: equal(\"value\",category/id) \n"
					+ "\t\t " +
					"policies: \n \t\t \t Rule ruleName (deny) \n" +
					"\t\t obl: } \n " +
					"\t obl: \n }\n "					
					);
			}
		if (checkRequest.getSelection() == true){
			// add request template
			string.append("\n Request:{NameRequest \n" +
					"\t (category_attribute/id_attribute, \"\")} \n\n");
		}
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(containerName, fileName, monitor,string);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * The worker method. It will find the container, create the
	 * file if missing or just replace its contents, and open
	 * the editor on the newly created file.
	 */

	private void doFinish(
		String containerName,
		String fileName,
		IProgressMonitor monitor,
		StringBuffer sourceFile)
		throws CoreException {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(new Path(containerName));
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("Container \"" + containerName + "\" does not exist.");
		}
		IContainer container = (IContainer) resource;
		final IFile file = container.getFile(new Path(fileName));
		try {
			InputStream stream = new ByteArrayInputStream(sourceFile.toString().getBytes()); 
					//openContentStream();
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page =
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}
	


	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "it.unifi.xtext.facpl2.ui", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}