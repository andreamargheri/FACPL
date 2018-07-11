

Getting started
-----------------

.. The FACPL language has the dedicated web site `facpl.sourceforge.net <http://facpl.sourceforge.net>`__ that provides a full account of the language and its supporting tools. From the web site, it is also accessible the `"Try FACPL in your Browser" <http://150.217.32.61:8080/FACPL-App/index.jsp>`__ web application, that allows newcomer users to experiment with FACPL without installing any software. 

A set of FACPL examples are available in the GitHub repository together with the corresponding
Java-translated policies, in the `code examples
repository <https://github.com/andreamargheri/FACPL/tree/master/EXAMPLES>`__. The binaries
and source code of the Java library and its unit tests can be downloaded
from the repository as well.

Eclipse installation
=====================

.. NOTE:: The Eclipse plugin is provided by means of the Eclipse p2 repository (the current stable version is the 2.0.5). The repository is available in .zip format as part of the last release in GitHub `here <https://github.com/andreamargheri/FACPL/releases>`_.

By using the well-known
procedure "Install new software..." from the Eclipse's toolbar menu, the
FACPL plugin can be easily installed. Note that it is required to accept
the *Eclipse Public License* in order to complete the installation. The
plugin installation requires:

-  Eclipse for Java and DSL Developers version 4.\* or higher version
-  Xtext framework plugins
-  Java 8

If the Xtext plugins are missing, they will be automatically added
through the standard Eclipse update site. 

.. NOTE:: The plugin has been successfully tested by using the Eclipse DSL Release Neon 

Using the tool
~~~~~~~~~~~~~~

When the installation of the plugin has completed, we can create a FACPL
project to start coding, analysing and evaluating FACPL policies. In the :ref:`Usage guide <usage-page>`, all the needed details.


Java Library
=============

Basic examples of FACPL Java code is available in the `Java code examples <https://github.com/andreamargheri/FACPL/tree/master/EXAMPLES/FACPL_JAVA_Examples>`_. 

.. NOTE:: FACPL is not intended to be used directly from Java, but via its high-level syntax (whose IDE is available in the Eclipse plugin). Therefore, the way a policy is constructed is more `friendly` for an automated code generator than a programmer. 

Library Structure
~~~~~~~~~~~~~~~~~

The high-level type structure of FACPL policy is 

::

| IEvaluablePolicy
| ├── FacplPolicy
| │   ├── PolicySet
| │   └── Rule

*FacplPolicy* abstracts *obligation* and *target* field of the PolicySet and Rule. The corresponding type structure of the two fields are

:: 

| IObligationElement
| ├── Obligation

::

| ExpressionBooleanTree
| ├── ExpressionFunction

where the tree structure organises the functions with boolean operators. Comparison and arithmetics functions are organised with a Factory pattern according to the input types. 

Therefore, *PolicySet* and *Rule* provide the abstract structure and the evaluation methods of the FACPL policy elements. Specifically, *PolicySet* includes the combining algorithm (whose specification is given by *IEvaluableAlgorithm*) and the list of enclosed elements (either PolicySet or Rule), while *Rule* contains the decision (viz. *PERMIT* or *DENY*).

Creating a FACPL policy
~~~~~~~~~~~~~~~~~~~~~~~~

*PolicySet* and *Rule* are abstract classes, hence to create a FACPL policy is needed to extended the corresponding class and use the 'setter' methods to add the internal elements. 

We report here some Java code from the `examples <https://github.com/andreamargheri/FACPL/tree/master/EXAMPLES/>`_.

Let's start with a policy enclosing a single rule 

.. code-block:: java 

	public class PolicySet_pName extends PolicySet {
		public PolicySet_pName() {
			addId("pName");
			// Algorithm Combining
			addCombiningAlg(new it.unifi.facpl.lib.algorithm.PermitOverridesGreedy());
			// PolElements
			addPolicyElement(new Rule_rule1());
		}

		private class Rule_rule1 extends Rule {

			Rule_rule1() {
				addId("rule1");
				// Effect
				addEffect(Effect.PERMIT);
			}
		}
	}

A more complex target can be added by using a tree structure with the following code

.. code-block:: java

	addTarget(new ExpressionBooleanTree(ExprBooleanConnector.AND,
		new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.Equal(),
					"John", new AttributeName("subject", "id"))),
		new ExpressionBooleanTree(new ExpressionFunction(new it.unifi.facpl.lib.function.comparison.In(),
					new AttributeName("action", "id"), new Set("read", "seek")))));
								
								
the corresponding target expression is ``equal(subject/id,"John") && in(action/id,{"read","seek"})``.

To add obligations to either the rule of the policy, the following code has to be added

.. code-block:: java 

		addObligation(new Obligation("compress", Effect.PERMIT, ObligationType.O, null));


According to the chosen obligation actions (in this case `compress`), a list of arguments can be inserted in place of ``null``. By default, the available obligation actions is

* `mailTo`: to send an email to a given address and text
* `log`: to create a log file with a given text
* `compress`: to zip a given text

Here an example of a `log` obligation

.. code-block:: java 

	addObligation(new Obligation("log", Effect.DENY, ObligationType.M, "Subject: ",
			new AttributeName("subject", "id"), new AttributeName("subject", "name")));

the use of `AttributeName` as obligation arguments allows to retrieve at the policy evaluation time the actual input for discharging the action.

.. NOTE:: To add additional obligation action, just implement the interface *IPepAction* and provide the class with the corresponding name in the PEPAction class. Details below on its usage.

Evaluating a policy
~~~~~~~~~~~~~~~~~~~~

The evaluation of FACPL Policy correspond to invoke the method ``evalute`` given an access request in input. The method is 


public AuthorisationPDP evaluate(ContextRequest cxtRequest, Boolean extendedIndeterminate) 

where ``extendedIndeterminate`` set to ``true`` means that the extended evaluation of the indeterminate values (see `XACML semantics <http://docs.oasis-open.org/xacml/3.0/xacml-3.0-core-spec-os-en.html>`_). 

An access request is defined by a list of attributes, grouped by category, and a link to a context stub that can be used to dynamically access to external information. A simple request is 

.. code-block:: java

	public class ContextRequest_Name {

		private static ContextRequest CxtReq;

		public static ContextRequest getContextReq() {
			if (CxtReq != null) {
				return CxtReq;
			}
			// create map for each category
			HashMap<String, Object> req_action = new HashMap<String, Object>();
			req_action.put("id", "READ");

			Request req = new Request("Name");
			req.addAttribute("action", req_action);

			// context stub: default-one
			CxtReq = new ContextRequest(req, ContextStub_Default.getInstance());
			return CxtReq;
		}
	}

which is formed by a single attribute named ``id`` and with category ``action``; together represented as ``action/id``. 


The enforcement procedure is completed by the two key components PDP and PEP described in the :ref:`Introduction <facpl>`. Their structure is defined in the library and can be instantiated as follows

.. code-block:: java 
	
	this.pdp = new PDP(new it.unifi.facpl.lib.algorithm.PermitUnlessDenyGreedy(), policies, false);
	this.pep = new PEP(EnforcementAlgorithm.DENY_BIASED);


where the PDP gets the combining algorithm to use (in this case `PermitUnlessDenyGreedy` for the evaluation of the list of `policies`; the last boolean sets the use of extendedIndeterminate. The PEP just requires the enforcement algorithm to use for discharging the obligations. 

To add additional obligations to the PEP we can use 

.. code-block:: java 

	this.pep.addPEPActions(PEPAction.getPepActions());

where the template of the class PEPAction is defined as 

.. code-block:: java 

	public class PEPAction{

	    public static HashMap<String, IPepAction> getPepActions() {
			/*
			 * Set your own pep action e.g. HashMap<String,new ***** class Action extending IPepAction***()
			 * 
			 * pepAction = new HashMap<String,IPepAction>(); 
			 * pepAction.put("action", Action.class); return
			 * pepAction;
			 */
			return null;
		}
	
	}
	
All together, the Eclipse plugin generates a *MainFACPL.java* file that create a main method for the evaluation of selected requests. Here an example 

.. code-block:: java 

	public class MainFACPL{
	 	
		private PDP pdp;
		private PEP pep;
		
		public MainFACPL() {
			// defined list of policies included in the PDP
			LinkedList<IEvaluablePolicy> policies = new LinkedList<IEvaluablePolicy>();
			policies.add(new PolicySet_PSet()); 
			this.pdp = new PDP(new it.unifi.facpl.lib.algorithm.PermitUnlessDenyGreedy(), policies, false);
		
			this.pep = new PEP(EnforcementAlgorithm.DENY_BIASED);
			
			this.pep.addPEPActions(PEPAction.getPepActions());
		}
		
		/*
		*ENTRY POINT FOR EVALUATION
		*/
		public static void main(String[] args){
			//Initialise Authorisation System
			MainFACPL system = new MainFACPL();
		
			//log
			StringBuffer result = new StringBuffer();
			//request
			LinkedList<ContextRequest> requests = new LinkedList<ContextRequest>();
			requests.add(ContextRequest_Name.getContextReq());
			for (ContextRequest rcxt : requests) {
				result.append("---------------------------------------------------\n");
				AuthorisationPDP resPDP = system.pdp.doAuthorisation(rcxt);
				result.append("Request: "+ resPDP.getId() + "\n\n");
				result.append("PDP Decision=\n " + resPDP.toString()+"\n\n");
				//enforce decision
				AuthorisationPEP resPEP = system.pep.doEnforcement(resPDP);
				result.append("PEP Decision=\n " + resPEP.toString()+"\n");
				result.append("---------------------------------------------------\n");
			}
			System.out.println(result.toString());
		}	
	
	
		public PDP getPdp() {
			return pdp;
		}
		
		public PEP getPep() {
			return pep;
		}
	
	}


FACPL Java Code Generator and Parsers
======================================

FACPL polices can be generated starting from FACPL code (aka the one used in the Eclipse plugin), instead of directly using the Java library. 

The (parser and) code generators are available standalone by the Eclipse plugin in the `latest release <https://github.com/andreamargheri/FACPL/releases/tag/2.0.1>`_. This  `example project <https://github.com/andreamargheri/FACPL/tree/master/EXAMPLES/Generator>`_ reports practical examples of the code generation, given a FACPL file, of Java, XACML and SMT_LIB code. 

By way of example, given the following FACPL code 

.. code-block:: java 

	PolicySet patientConsent { permit-overrides
		target: equal ( "Alice" , resource / patient-id ) 
		policies:
		PolicySet ePre { permit-overrides - all
			target:equal("e-Prescription",resource/type)
			policies:
			Rule writeDoc ( permit target: equal ( subject / role , "doctor" ) 
				&& equal ( action / id , "write" ) 
				&& in ("e-Pre-Write" , subject / permission ) 
				&& in ( "e-Pre-Read" , subject / permission ) )
			Rule readDoc ( permit target: equal ( subject / role , "doctor" )
				&& equal ( action / id , "read" ) 
				&& in ( "e-Pre-Read", subject / permission ) )
			Rule readPha ( permit target: equal ( subject / role , "pharmacist" ) 
				&& equal ( action / id , "read" ) 
				&& in ("e-Pre-Read" , subject / permission ) )
			obl-p:
			[ M log ( system / time , resource / type , subject / id , action / id ) ]
		}
		Rule denyRule ( deny )
		obl-d:
		[ M mailTo ( resource / patient-id.mail , "Data requested by unauthorized subject" ) ]
	}


The code corresponding to the PolicySet `ePre` and `parientConsent` is generated. 





