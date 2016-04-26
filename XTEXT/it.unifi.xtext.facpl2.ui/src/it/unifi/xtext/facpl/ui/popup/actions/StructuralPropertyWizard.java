/**
 * 
 */
package it.unifi.xtext.facpl.ui.popup.actions;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;

import it.unifi.xtext.facpl.facpl2.Facpl;
import it.unifi.xtext.facpl.facpl2.FacplPolicy;
import it.unifi.xtext.facpl.generator.SMT_LIBGenerator;
import it.unifi.xtext.facpl.generator.util.StructuralProperty;
import it.unifi.xtext.facpl.ui.popup.actions.propertyDialog.PropertyNameDialog;

/**
 * @author Andrea Margheri
 *
 */
public class StructuralPropertyWizard {

	public Object createStructuralProperty(Shell activeShell, EclipseResourceFileSystemAccess2 fsa, Facpl e,
			SMT_LIBGenerator generator) {

		try {

			/* 0 -> Choose a Property Name */
			PropertyNameDialog dialog = new PropertyNameDialog(activeShell);
			dialog.create();
			if (dialog.open() != Window.OK) {
				return false;
			}

			String name_property = dialog.getPropertyName();

			/* 1 -> Choose the Property Type */

			String msg_info = "Check the FACPL guide at http://facpl.sf.net/guide/index.html for further details";

			ListDialog type_P_dialog = new ListDialog(activeShell);
			type_P_dialog.setMessage("Choose a Property... \n" + msg_info);
			type_P_dialog.setInput(new StructuralProperty[] { StructuralProperty.COMPLETE, StructuralProperty.COVER,
					StructuralProperty.DISJOINT });
			type_P_dialog.setContentProvider(new ArrayContentProvider());
			type_P_dialog.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(Object element) {
					return ((StructuralProperty) element).toString();
				}
			});
			type_P_dialog.setInitialSelections(new StructuralProperty[] { StructuralProperty.COMPLETE });

			type_P_dialog.setTitle("Which structural property...");

			// user pressed cancel
			if (type_P_dialog.open() != ListDialog.OK) {
				return false;
			}

			StructuralProperty struct_prop = (StructuralProperty) type_P_dialog.getResult()[0];

			/* 2 -> Choose the Policy(s) */

			if (struct_prop.equals(StructuralProperty.COMPLETE)) {
				// COMPLETE -> ONLY ONE POLICY

				ListDialog type_Policy_dialog = new ListDialog(activeShell);
				type_Policy_dialog.setMessage("Choose a Policy... \n" + msg_info);
				try {
					type_Policy_dialog.setInput(getPolicies(e));
					type_Policy_dialog.setContentProvider(new ArrayContentProvider());
					type_Policy_dialog.setLabelProvider(new LabelProvider());

				} catch (Exception ex) {
					MessageDialog.openError(activeShell, "Create Structural Property1", AuthorisationPropertyWizard.ex_mess);
					return false;
				}
				type_Policy_dialog.setTitle("Which policy...");

				// user pressed cancel
				if (type_Policy_dialog.open() != ListDialog.OK) {
					return false;
				}

				if (type_Policy_dialog.getResult().length > 1) {
					throw new Exception("Unxexpected choice in the policy selection!");
				}

				String policy_name = (String) type_Policy_dialog.getResult()[0];

				/*
				 * 3 -> Generate the file for the Verification of the chosen
				 * Property
				 */

				generator.doGenerateStructural_Property(e, policy_name, null, name_property, struct_prop, fsa);

			} else {
				// DISJOINT or COVERAGE -> TWO POLICIES

				ListDialog type_Policy_dialog_1 = new ListDialog(activeShell);
				type_Policy_dialog_1.setMessage("Choose a Policy... \n" + msg_info);
				try {
					type_Policy_dialog_1.setInput(getPolicies(e));
					type_Policy_dialog_1.setContentProvider(new ArrayContentProvider());
					type_Policy_dialog_1.setLabelProvider(new LabelProvider());

				} catch (Exception ex) {
					if (!ex.getMessage().equals("")) {
						MessageDialog.openError(activeShell, "Create Structural Property", ex.getMessage());
					} else {
						MessageDialog.openError(activeShell, "Create Structural Property",
								AuthorisationPropertyWizard.ex_mess);
					}
					return false;
				}
				type_Policy_dialog_1.setTitle("Which policy...");

				// user pressed cancel
				if (type_Policy_dialog_1.open() != ListDialog.OK) {
					return false;
				}

				if (type_Policy_dialog_1.getResult().length > 1) {
					throw new Exception("Unxexpected choice in the policy selection!");
				}

				String policy_name1 = (String) type_Policy_dialog_1.getResult()[0];

				// -> SECOND POLICY

				ListDialog type_Policy_dialog_2 = new ListDialog(activeShell);
				type_Policy_dialog_2.setMessage("Chosen " + policy_name1 + " " + struct_prop.toString()
						+ ".  Choose a second Policy... \n" + msg_info);
				try {
					type_Policy_dialog_2.setInput(getPolicies(e));
					type_Policy_dialog_2.setContentProvider(new ArrayContentProvider());
					type_Policy_dialog_2.setLabelProvider(new LabelProvider());

				} catch (Exception ex) {
					if (!ex.getMessage().equals("")) {
						MessageDialog.openError(activeShell, "Create Structural Property", ex.getMessage());
					} else {
						MessageDialog.openError(activeShell, "Create Structural Property",
								AuthorisationPropertyWizard.ex_mess);
					}
				}
				type_Policy_dialog_2.setTitle("Which policy...");

				// user pressed cancel
				if (type_Policy_dialog_2.open() != ListDialog.OK) {
					return false;
				}

				if (type_Policy_dialog_2.getResult().length > 1) {
					throw new Exception("Unxexpected choice in the policy selection!");
				}

				String policy_name2 = (String) type_Policy_dialog_2.getResult()[0];

				/*
				 * 3 -> Generate the file for the Verification of the chosen
				 * Property
				 */

				generator.doGenerateStructural_Property(e, policy_name1, policy_name2, name_property, struct_prop, fsa);

			}

			MessageDialog.openInformation(activeShell, "Create Structural Property",
					"SMT-LIB code for property verification generated!");

		} catch (Exception ex) {
			if (ex.getMessage().equals("")) {
				MessageDialog.openWarning(activeShell, "Create Structural Property",
						"Creation of Structural Property Aborted");
			} else {
				MessageDialog.openWarning(activeShell, "Create Structural Property", ex.getMessage());
			}
		}

		return true;
	}

	private Object[] getPolicies(Facpl e) throws Exception {
		ArrayList<String> ar = new ArrayList<String>();
		if (e.getPolicies().size() == 0) {
			throw new Exception(
					"No policies are defined in the chosen FACPL file. Declare at least one policy to use in Property Specification");
		}
		for (FacplPolicy pol : e.getPolicies()) {
			ar.add(pol.getName());
		}
		return ar.toArray();
	}

}
