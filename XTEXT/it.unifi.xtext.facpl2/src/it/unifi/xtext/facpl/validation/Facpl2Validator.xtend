/*
 * generated by Xtext
 */
package it.unifi.xtext.facpl.validation

import it.unifi.xtext.facpl.facpl2.Facpl
import it.unifi.xtext.facpl.facpl2.Import
import org.eclipse.xtext.validation.Check
import it.unifi.xtext.facpl.facpl2.Request
import it.unifi.xtext.facpl.facpl2.PolicySet
import com.google.common.base.Predicate
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import java.util.ArrayList
import it.unifi.xtext.facpl.facpl2.FacplPolicy
import it.unifi.xtext.facpl.facpl2.DateLiteral
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.resource.IEObjectDescription
import com.google.inject.Inject
import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl
import it.unifi.xtext.facpl.facpl2.AttributeReq
import org.eclipse.emf.ecore.EObject
import it.unifi.xtext.facpl.facpl2.Rule
import org.eclipse.emf.ecore.resource.Resource
import it.unifi.xtext.facpl.facpl2.MainFacpl
import it.unifi.xtext.facpl.facpl2.Facpl2Package
import java.util.HashMap
import org.eclipse.xtext.resource.XtextResourceSet
import it.unifi.xtext.facpl.facpl2.AndExpression
import it.unifi.xtext.facpl.facpl2.OrExpression
import it.unifi.xtext.facpl.facpl2.NotExpression
import it.unifi.xtext.facpl.facpl2.Function
import it.unifi.xtext.facpl.facpl2.Expression
import it.unifi.xtext.facpl.facpl2.Bag
import it.unifi.xtext.facpl.facpl2.Alg
import it.unifi.xtext.facpl.facpl2.FulfillmentStrategy
import it.unifi.xtext.facpl.facpl2.AlgLiteral
import it.unifi.xtext.facpl.validation.inference.FacplTypeInference
import it.unifi.xtext.facpl.facpl2.DeclaredFunction
import it.unifi.xtext.facpl.facpl2.FunctionDeclaration

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class Facpl2Validator extends AbstractFacpl2Validator {

	@Inject
	IGlobalScopeProvider gloablScope;

	/*
	 * ###################################################
	 * Check Name Requests
	 * ###################################################
	 */
	@Check
	def void checkNameRequest(Request request) {
		var Facpl a = getRoot(request);
		var Boolean flag = false;
		for (Request el : a.getRequests()) {
			if (el instanceof Request) {
				if (el.getName().equals(request.getName())) {
					if (flag) {
						error("Duplicate request name " + request.getName(), Facpl2Package.Literals.REQUEST__NAME);
						return
					}
					flag = true;
				}
			}
		}
	}

	@Check
	def void checkGlobalNameRequest(Request request) {
		var IScope global = gloablScope.getScope(request.eResource(), Facpl2Package.Literals.MAIN_FACPL__REF_REQUEST,
			new Predicate<IEObjectDescription>() {

				override boolean apply(IEObjectDescription input) {
					return true;
				}
			});
		for (IEObjectDescription eOb : global.getAllElements()) {
			if (eOb.getName().toString().equals(request.getName())) {
				error("Duplicate request name " + request.getName() + " with file imported",
					Facpl2Package.Literals.REQUEST__NAME);
				return
			}
		}
	}

	/*
	 * ###################################################
	 * Check Name Rules
	 * ###################################################
	 */
	@Check
	def void checkNameRule(Rule rule) {
		var PolicySet pol = rule.eContainer().eContainer() as PolicySet;
		var Boolean flag = false;
		for (AbstractPolicyIncl r : pol.getPolicies()) {
			if (r.getRefPol() != null) {
				if (r.getRefPol().getName().equals(rule.getName())) {
					error("Duplicate rule name " + rule.getName() + " with referenced policy " + pol.getName(),
						Facpl2Package.Literals.FACPL_POLICY__NAME);
					return
				}
			} else if (r.getNewPolicy() != null) {

				if (r.getNewPolicy().getName().equals(rule.getName())) {
					if (flag) {
						error("Duplicate rule name " + rule.getName() + " in policy " + pol.getName(),
							Facpl2Package.Literals.FACPL_POLICY__NAME);
						return
					}
					flag = true;
				}
			}
		}
	}

	/* #######################################################
	 * Check in global scope for policy/policySet name policy
	 * #######################################################
	 */
	@Check
	def void checkGlobalPolicy(FacplPolicy policy) {
		var IScope global = gloablScope.getScope(policy.eResource(),
			Facpl2Package.Literals.ABSTRACT_POLICY_INCL__REF_POL, new Predicate<IEObjectDescription>() {

				override boolean apply(IEObjectDescription input) {
					return true;
				}
			});
		for (IEObjectDescription eOb : global.getAllElements()) {
			if (eOb.getName().getLastSegment().toString().equals(policy.getName())) {
				error("Duplicate policy name " + policy.getName() +
					". A policy with the same name is defined in an imported file",
					Facpl2Package.Literals.FACPL_POLICY__NAME);
				return
			}
		}
	}

	/* #############################################################
	 * Check Policy Set / Policy Name Collisions in the local file
	 * #############################################################
	 */
	@Check
	def void checkLocalPolicy(FacplPolicy policy) {

		var String name_policy = policy.getName();

		var Facpl root = getRoot(policy);
		var int count = 0;
		for (FacplPolicy p : root.getPolicies()) {
			if (p.getName().equals(name_policy))
				count++;
			// In case of Policy Set recursively on the internal items
			if (p instanceof PolicySet)
				count += checkNamePolicySet(name_policy, p as PolicySet);
		}

		if (root.getMain() != null)
			if (root.getMain().getPaf() != null)
				if (root.getMain().getPaf().getPdp() != null)
					for (AbstractPolicyIncl p : root.getMain().getPaf().getPdp().getPolSet()) {
						if (p.getNewPolicy() != null) {
							if (p.getNewPolicy().getName().equals(name_policy))
								count++;
							// In case of Policy Set recursively on the internal
							// items
							if (p.getNewPolicy() instanceof PolicySet)
								count += checkNamePolicySet(name_policy, p.getNewPolicy() as PolicySet);
						}
					}

		if (count > 1)
			error("Duplicate policy name " + policy.getName(), Facpl2Package.Literals.FACPL_POLICY__NAME);

	}

	def int checkNamePolicySet(String name, PolicySet polSet) {
		var int count = 0;
		for (AbstractPolicyIncl p : polSet.getPolicies()) {
			if (p.getNewPolicy() != null) {
				if (p.getNewPolicy().getName().equals(name)) {
					count++;
				}
				if (p.getNewPolicy() instanceof PolicySet) {
					count += checkNamePolicySet(name, p.getNewPolicy() as PolicySet);
				}
			}
		}
		return count;
	}

	/*
	 * ###################################################
	 */
	/* ###################################################
	 * LOOP DEPENDECIES WITHIN POLICY SET
	 * ###################################################
	 */
	@Check
	def void checkLoopFree(PolicySet pSet) {

		try {
			checkLoop(pSet, null);
		} catch (LoopException e) {
			warning("The Policy may generate an evaluation loop starting from " + pSet.getName(),
				Facpl2Package.Literals.FACPL_POLICY__NAME);
		}

	}

	def HashMap<String, ArrayList<String>> checkLoop(PolicySet pSet,
		HashMap<String, ArrayList<String>> dp) throws LoopException {

		var dp_graph = dp

		var ArrayList<String> sub_pols = new ArrayList<String>();

		var ArrayList<EObject> eob_sub_pols = new ArrayList<EObject>();

		// Adding all policies used within this policy set
		for (AbstractPolicyIncl p : pSet.getPolicies()) {
			if (p.getNewPolicy() != null) {
				sub_pols.add(p.getNewPolicy().getName());

				eob_sub_pols.add(p.getNewPolicy());
			}
			if (p.getRefPol() != null) {
				sub_pols.add(p.getRefPol().getName());

				eob_sub_pols.add(p.getRefPol());

			}

		}
		if (dp_graph == null)
			dp_graph = new HashMap<String, ArrayList<String>>();

		// Add the current dependencies in the hash map
		dp_graph.put(pSet.getName(), sub_pols);

		// Iterating on the sub-elements
		for (EObject r : eob_sub_pols) {
			// if r policy set (or reference to a policy set it is needed to
			// iterate on sub-elements)
			if (r instanceof PolicySet) {
				// if the policy set is not already evaluated (i.e. it is in the
				// previous dp-graph) we create the dependencies
				var Boolean f = false;
				if (dp_graph == null) {
					f = true;
				} else {
					if (!dp_graph.containsKey((r as PolicySet).getName())) {
						f = true;
					}
				}

				if (f) {
					var HashMap<String, ArrayList<String>> sub_pol_dependencies = checkLoop(r as PolicySet, dp_graph);

					for (String polName : sub_pol_dependencies.keySet()) {

						dp_graph.put(polName, sub_pol_dependencies.get(polName));

					}
				}

				// check for loop within dependencies
				if (hasLoop(dp_graph))
					throw new LoopException();

			}
		}
		return dp_graph;
	}

	def boolean hasLoop(HashMap<String, ArrayList<String>> dp_graph) {

		var HashMap<String, Boolean> visited = new HashMap<String, Boolean>();

		for (String el : dp_graph.keySet()) {
			visited.put(el, false);
		}

		for (String el : dp_graph.keySet()) {
			visited.put(el, true);
			if (hasLoopUtil(dp_graph, el, visited)) {
				return true;
			}
		}

		return false;
	}

	def boolean hasLoopUtil(HashMap<String, ArrayList<String>> dp_graph, String el, HashMap<String, Boolean> visited) {

		for (String sub_el : dp_graph.get(el)) {
			if (visited.get(sub_el)) {
				// loop
				return true;
			} else {
				// no loop, iterate on the hash-map
				visited.put(sub_el, true);
				hasLoopUtil(dp_graph, sub_el, visited);
			}
		}

		return false;
	}

	static class LoopException extends Exception {

		@Override
		override String getMessage() {
			return super.getMessage();
		}
	}

	/* 
	 * ###################################################
	 */
	/*
	 * Utility
	 */
	def Facpl getRoot(EObject policy) {
		var EObject eObject = policy;
		while (!(eObject.eContainer() instanceof Facpl)) {
			eObject = eObject.eContainer();
		}
		return eObject.eContainer() as Facpl;
	}

	/* ###################################################
	 * CHECK IMPORT URI and MAIN Attributes
	 * ###################################################
	 */
	@Inject
	XtextResourceSet set;

	@Check
	def void checkImportUriIsNotEmpty(Import imports) {
		if (imports.getImportURI() != null && imports.getImportURI().trim().length() == 0) {
			error("Empty importURI string", null);
		}
	}

	@Check
	def void checkMain(MainFacpl p) {
		var Facpl root = getRoot(p);
		var StringBuffer importFile = new StringBuffer();
		var int i = 1;
		for (String s : p.eResource().getURI().segmentsList()) {
			if (i != 1) {
				if (i != p.eResource().getURI().segmentsList().size()) {
					importFile.append(s + "/");
				}
			}
			i = i + 1;
		}
		for (Import el : root.getImportEl()) {
			var Resource res = null;
			var Boolean flag = false;
			try {
				var URI uri = URI.createPlatformResourceURI(importFile.toString() + el.getImportURI(), true);
				try {
					res = set.getResource(uri, true);
					flag = true;
				} catch (Exception f) {
					set.createResource(uri);
					res = set.getResource(uri, true);
					flag = true;
				}
			} catch (Exception e) {
				// resource not available
				return;
			}
			if (flag) {
				// check if in res there is any main
				for (EObject ob : res.getContents()) {
					if (ob instanceof Facpl) {
						if ((ob as Facpl).getMain() != null) {
							warning("These Main Attributes override Main of " + el.getImportURI() + " file", null);
							return;
						}
					}
				}

			}
		}
	}

	/*
	 * ################################################### 
	 */
	/**
	 * Check date-time format yyyy/MM/dd-HH:mm:ss
	 */
	@Check
	def void checkDate(DateLiteral date) {
		var String sdate = date.getValue();
		if (sdate.contains("-")) {
			// date + time
			var String err = "";
			if (!checkDate(sdate.substring(0, sdate.indexOf("-"))))
				err = "Error date value. Must be yyyy/MM/dd";

			if (!checkTime(sdate.substring(sdate.indexOf("-") + 1, sdate.length())))
				err = "\n Error time value. Must be HH:mm:ss";

			if (err != "")
				error(err, Facpl2Package.Literals.DATE_LITERAL__VALUE);
		} else {
			if (sdate.contains("/")) {
				// date
				if (!checkDate(sdate)) {
					error("Error date value. Must be yyyy/MM/dd", Facpl2Package.Literals.DATE_LITERAL__VALUE);
				}
			} else {
				// time
				if (!checkTime(sdate)) {
					error("Error time value. Must be HH:mm:ss", Facpl2Package.Literals.DATE_LITERAL__VALUE);
				}
			}
		}

	}

	def boolean checkTime(String sdate) {
		// time
		if (!(sdate.charAt(2) == ':')) {
			return false;
		} else {
			if (!(sdate.charAt(5) == ':')) {
				return false;
			}
		}
		var String h = sdate.substring(0, 2);
		var String m = sdate.substring(3, 5);
		var String s = sdate.substring(6, 8);
		if (Integer.parseInt(h) < 24) {
			if (Integer.parseInt(m) < 60) {
				if (Integer.parseInt(s) < 60) {
					return true;
				}
			}
		}
		return false;
	}

	def Boolean checkDate(String sdate) {
		// date
		val int y_sep = sdate.indexOf('/');
		val int m_sep = sdate.indexOf('/', 5)
		if (y_sep == -1) {
			return false;
		} else {
			if (m_sep == -1) {
				return false;
			}
		}
		// String y = sdate.substring(0,4);
		var String m = sdate.substring(y_sep + 1, y_sep + (m_sep - y_sep));
		var String d = sdate.substring(m_sep + 1);
		if (Integer.parseInt(m) <= 12) {
			if (Integer.parseInt(d) <= 31) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Error for the multi-valued attributes
	 */
	@Check
	def void checkAttributeRequestName(AttributeReq a) {
		var Request r = a.eContainer() as Request;
		var Boolean flag = false;
		for (AttributeReq atr : r.getAttributes()) {
			if ((atr.getName().getCategory().equals(a.getName().getCategory())) &&
				(atr.getName().getId().equals(a.getName().getId()))) {
				if (flag) {
					error("Attributes with same names must be declared as Bag of values",
						Facpl2Package.Literals.ATTRIBUTE_REQ__NAME);
					return;
				} else {
					flag = true;
				}
			}
		}
	}

	/**
	 * Warning for fulfilment strategies for consensus algorithm 
	 */
	@Check
	def void checkAlgGreedy(Alg alg) {
		if (alg.FStrategy != null) {
			if (alg.FStrategy.equals(FulfillmentStrategy.GREEDY)) {
				if (alg.idAlg.equals(AlgLiteral.FIRST) || alg.idAlg.equals(AlgLiteral.ONLY_ONE) ||
					alg.idAlg.equals(AlgLiteral.
						WEAK_CONS)) {
						warning(
							"Algorithms first-applicable, only-one-applicable and weak-consensus have the same implementation with or without greedy option",
							Facpl2Package.Literals.ALG__FSTRATEGY
						)
					}
				}
			}
		}

		/**
		 * Check uniqueness of function names 
		 */
		@Check
		def void checkNameDeclFun(FunctionDeclaration f) {
			val root = getRoot(f)
			var i = 0
			for (dec : root.declarations) {
				if (dec.name == f.name)
					i++
			}
			if (i > 1)
				error(
					"Duplicate function name " + f.name,
					Facpl2Package.Literals.FUNCTION_DECLARATION__NAME
				)
		}

		/**
		 * Check for function invocation
		 */
		@Check
		def void checkInvokDeclFun(DeclaredFunction f) {
			val root = getRoot(f)
			for (dec : root.declarations) {
				if (dec.name.equals(f.functionId.name)) {
					// Check arity of invocation
					if (dec.args.size != f.args.size) {
						error(
							"Invalid number of arguments",
							Facpl2Package.Literals.DECLARED_FUNCTION__FUNCTION_ID
						)
					}
					var FacplTypeInference tCheck = new FacplTypeInference();
					var flag = false
					// Check type of arguments
					var decl_fun_T = ""
					var current_T = ""
					for (var i = 0; i < f.args.size; i++) {
						val FacplType type = tCheck.doSwitch(f.args.get(i))
						if (!FacplType::equalType(type, dec.args.get(i))) {
							flag = true
						}
						// create labels for error output
						if (i > 0) {
							decl_fun_T = decl_fun_T + "," + dec.args.get(i)
							current_T = current_T + "," + f.args.get(i)
						} else {
							decl_fun_T = decl_fun_T + dec.args.get(i)
							current_T = current_T + f.args.get(i)
						}
					}
					if (flag) {
						error(
							"Type mismatch: expected (" + decl_fun_T + ") not (" + current_T + ")",
							Facpl2Package.Literals.DECLARED_FUNCTION__FUNCTION_ID
						)
					}
				}
			}
			return
		}

		/*
		 * ###########################################################
		 * TYPE CHECKs
		 * ###########################################################
		 */
		@Check
		def void checkTarget(FacplPolicy policy) {
			var FacplTypeInference tCheck = new FacplTypeInference();
			val FacplType type = tCheck.doSwitch(policy.target)
			if (!type.equals(FacplType.BOOLEAN) && !type.equals(FacplType.NAME))
				warning(
					"Target Expression evaluates to a not-boolean value. This element evaluates to indetrminate",
					Facpl2Package.Literals.FACPL_POLICY__TARGET
				)
		}

		@Check
		def void checkBag(Bag bag) {
			var FacplTypeInference tCheck = new FacplTypeInference();
			var FacplType t = tCheck.doSwitch(bag.getArgs().get(0));
			for (Expression ob : bag.getArgs()) {
				t = FacplType.combine(t, tCheck.doSwitch(ob));
			}
			if (t.equals(FacplType.ERR))
				error("Bag elements have to be of the same type", Facpl2Package.Literals.BAG__ARGS)
		}

		@Check
		def void checkFunction(Function e) {
			var FacplTypeInference tCheck = new FacplTypeInference();
			var t = tCheck.doSwitch(e)
			if (t.equals(FacplType::ERR)) {
				error("Expression cannot be typed", Facpl2Package.Literals.FUNCTION__FUNCTION_ID);
			}
		}

		@Check
		def void checkAndExpression(AndExpression e) {
			var FacplTypeInference tCheck = new FacplTypeInference();
			var t = tCheck.doSwitch(e)
			if (t.equals(FacplType::ERR)) {
				error("Expression cannot be typed", Facpl2Package.Literals.AND_EXPRESSION__LEFT);
			}
		}

		@Check
		def void checkOrExpression(OrExpression e) {
			var FacplTypeInference tCheck = new FacplTypeInference();
			var t = tCheck.doSwitch(e)
			if (t.equals(FacplType::ERR)) {
				error("Expression cannot be typed", Facpl2Package.Literals.OR_EXPRESSION__LEFT);
			}
		}

		@Check
		def void checkNotExpression(NotExpression e) {
			var FacplTypeInference tCheck = new FacplTypeInference();
			var t = tCheck.doSwitch(e)
			if (t.equals(FacplType::ERR)) {
				error("Expression cannot be typed", Facpl2Package.Literals.NOT_EXPRESSION__ARG);
			}
		}

//	@Check
//	def void checkArithExpression(ArithExpr e) {
//		FacplTypeChecker tCheck = FacplTypeChecker.getInstance();
//		FacplType t = tCheck.doSwitch(e);
//		if (!t.equals(FacplType.INT) && !t.equals(FacplType.DOUBLE) && !t.equals(FacplType.NAME)) {
//			error("Arguments must be numeric!", Facpl2Package.Literals.ARITH_EXPR__FUN, ARITHMETIC_EXPRESSION);
//		} else if (e.getFun() == "mod" && t.equals(FacplType.DOUBLE) && !t.equals(FacplType.NAME)) {
//			error("Function mod is defined only for int arguments", Facpl2Package.Literals.ARITH_EXPR__FUN,
//					ARITHMETIC_MOD_EXPRESSION);
//		}
//	}
//	@Check
//	def void checkBagExpression(Bag e) {
//		FacplTypeChecker tCheck = FacplTypeChecker.getInstance();
//		FacplType t = tCheck.doSwitch(e);
//		if (t.equals(FacplType.ERR)) {
//			error("All bag elements must be string or structured names!", Facpl2Package.Literals.BAG__ARGS,
//					BAG_EXPRESSION);
//		}
//	}
//

//TODO

		@Check
		def void checkAttributeRequestType(AttributeReq a) {
			var FacplTypeInference tCheck = new FacplTypeInference();
			var FacplType t = tCheck.doSwitch(a);
			if (t.equals(FacplType.ERR)) {
				error("All bag elements must be string or structured names!",
					Facpl2Package.Literals.ATTRIBUTE_REQ__VALUE);
			}
		}
	}
	