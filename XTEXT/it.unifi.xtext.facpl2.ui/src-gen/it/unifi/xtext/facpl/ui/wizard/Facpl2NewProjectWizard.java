package it.unifi.xtext.facpl.ui.wizard;

import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.xtext.ui.wizard.IProjectCreator;
import org.eclipse.xtext.ui.wizard.IProjectInfo;

import com.google.inject.Inject;

public class Facpl2NewProjectWizard extends org.eclipse.xtext.ui.wizard.XtextNewProjectWizard {

	private WizardNewProjectCreationPage mainPage;

	@Inject
	public Facpl2NewProjectWizard(IProjectCreator projectCreator) {
		super(projectCreator);
		setWindowTitle("New Facpl2 Project");
	}

	/**
	 * Use this method to add pages to the wizard. The one-time generated
	 * version of this class will add a default new project page to the wizard.
	 */
	@Override
	public void addPages() {
		mainPage = new WizardNewProjectCreationPage("basicNewProjectPage");
		mainPage.setTitle("Facpl2 Project");
		mainPage.setDescription("Create a new Facpl2 project.");
		addPage(mainPage);
	}

	/**
	 * Use this method to read the project settings from the wizard pages and
	 * feed them into the project info class.
	 */
	@Override
	protected IProjectInfo getProjectInfo() {
		it.unifi.xtext.facpl.ui.wizard.Facpl2ProjectInfo projectInfo = new it.unifi.xtext.facpl.ui.wizard.Facpl2ProjectInfo();
		projectInfo.setProjectName(mainPage.getProjectName());
		return projectInfo;
	}

}
