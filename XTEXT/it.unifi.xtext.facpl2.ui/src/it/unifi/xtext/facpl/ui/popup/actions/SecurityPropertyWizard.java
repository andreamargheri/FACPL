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
import it.unifi.xtext.facpl.facpl2.Request;
import it.unifi.xtext.facpl.generator.SMT_LIBGenerator;
import it.unifi.xtext.facpl.generator.util.Decision;
import it.unifi.xtext.facpl.generator.util.SecurityProperty;
import it.unifi.xtext.facpl.ui.popup.actions.propertyDialog.PropertyNameDialog;

/**
 * @author Andrea Margheri
 *
 */
public class SecurityPropertyWizard {

	public static final String ex_mess = "No element selected!";

	public Object createSecurityProperty(Shell activeShell, EclipseResourceFileSystemAccess2 fsa, Facpl e,
			SMT_LIBGenerator generator) {

		try {

			/* 0 -> Choose a Property Name */
			PropertyNameDialog dialog = new PropertyNameDialog(activeShell);
			dialog.create();
			if (dialog.open() != Window.OK) {
				return false;
			}

			String name_property = dialog.getPropertyName();

			/* 1a -> Choose the Property Type */

			String msg_info = "Check the FACPL guide at http://facpl.sf.net/guide/index.html for further details";

			ListDialog type_P_dialog = new ListDialog(activeShell);
			type_P_dialog.setMessage("Choose a Property... \n" + msg_info);
			type_P_dialog.setInput(
					new SecurityProperty[] { SecurityProperty.EVAL, SecurityProperty.MAY, SecurityProperty.MUST });
			type_P_dialog.setContentProvider(new ArrayContentProvider());
			type_P_dialog.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(Object element) {
					return ((SecurityProperty) element).toString();
				}
			});
			type_P_dialog.setInitialSelections(new SecurityProperty[] { SecurityProperty.EVAL });

			type_P_dialog.setTitle("Which security property...");

			// user pressed cancel
			if (type_P_dialog.open() != ListDialog.OK) {
				return false;
			}

			SecurityProperty sec_prop = (SecurityProperty) type_P_dialog.getResult()[0];

			/* 1b -> Choose the Property Decision */

			ListDialog type_P_Dec_dialog = new ListDialog(activeShell);
			type_P_Dec_dialog.setMessage("Choose a Decision... \n" + msg_info);
			type_P_Dec_dialog.setInput(
					new Decision[] { Decision.PERMIT, Decision.DENY, Decision.NOT_APPLICABLE, Decision.INDETERMINATE });
			type_P_Dec_dialog.setContentProvider(new ArrayContentProvider());
			type_P_Dec_dialog.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(Object element) {
					return ((Decision) element).toString();
				}
			});
			type_P_Dec_dialog.setInitialSelections(new Decision[] { Decision.PERMIT });

			type_P_Dec_dialog.setTitle("Which decision for the chosen security property...");

			// user pressed cancel
			if (type_P_Dec_dialog.open() != ListDialog.OK) {
				return false;
			}

			Decision prop_decision = (Decision) type_P_Dec_dialog.getResult()[0];

			/* 2 -> Choose the Request */

			ListDialog type_Request_dialog = new ListDialog(activeShell);
			type_Request_dialog.setMessage("Choose a Request... \n" + msg_info);
			try {
				type_Request_dialog.setInput(getRequests(e));

				type_Request_dialog.setContentProvider(new ArrayContentProvider());
				type_Request_dialog.setLabelProvider(new LabelProvider());

			} catch (Exception ex) {
				MessageDialog.openError(activeShell, "Security Property", ex_mess);
				return false;
			}
			type_Request_dialog.setTitle("Which request...");

			// user pressed cancel
			if (type_Request_dialog.open() != ListDialog.OK) {
				return false;
			}

			Request req = _getRequest(e, type_Request_dialog.getResult());

			/* 3 -> Choose the Policy */

			ListDialog type_Policy_dialog = new ListDialog(activeShell);
			type_Policy_dialog.setMessage("Choose a Policy... \n" + msg_info);
			try {
				type_Policy_dialog.setInput(getPolicies(e));
				type_Policy_dialog.setContentProvider(new ArrayContentProvider());
				type_Policy_dialog.setLabelProvider(new LabelProvider());

			} catch (Exception ex) {
				MessageDialog.openError(activeShell, "Security Property", ex_mess);
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
			 * 4 -> Generate the file for the Verification of the chosen
			 * Property
			 */

			generator.doGenerateSecurity_Property((Facpl) e, policy_name, name_property, req, prop_decision, sec_prop,
					fsa);

			MessageDialog.openInformation(activeShell, "Create Security Property",
					"SMT-LIB code for property verification generated!");

		} catch (Exception ex) {
			if (ex.getMessage().equals("")) {
				MessageDialog.openWarning(activeShell, "Create Security Property",
						"Creation of Security Property Aborted");
			} else {
				MessageDialog.openWarning(activeShell, "Create Security Property", ex.getMessage());
			}
		}

		return true;
	}

	private Request _getRequest(Facpl e, Object[] result) throws Exception {
		if (result.length > 1) {
			throw new Exception("Unxexpected choice in the request selection!");
		}
		String id = (String) result[0];
		for (Request r : e.getRequests()) {
			if (r.getName().equals(id)) {
				return r;
			}
		}

		throw new Exception("Unxexpected choice in the request selection!");
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

	private Object[] getRequests(Facpl e) throws Exception {
		ArrayList<String> ar = new ArrayList<String>();
		if (e.getRequests().size() == 0) {
			throw new Exception(
					"No requests are defined in the chosen FACPL file. Declare at least one request to use in Property Specification");
		}
		for (Request r : e.getRequests()) {
			ar.add(r.getName());
		}
		return ar.toArray();
	}

}
