package it.unifi.xtext.facpl.validation.inference;

import java.util.LinkedList;

import it.unifi.xtext.facpl.facpl2.AbstractPolicyIncl;
import it.unifi.xtext.facpl.facpl2.AndExpression;
import it.unifi.xtext.facpl.facpl2.AttributeName;
import it.unifi.xtext.facpl.facpl2.AttributeReq;
import it.unifi.xtext.facpl.facpl2.Bag;
import it.unifi.xtext.facpl.facpl2.BooleanLiteral;
import it.unifi.xtext.facpl.facpl2.DateLiteral;
import it.unifi.xtext.facpl.facpl2.DeclaredFunction;
import it.unifi.xtext.facpl.facpl2.DoubleLiteral;
import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.FacplPolicy;
import it.unifi.xtext.facpl.facpl2.Function;
import it.unifi.xtext.facpl.facpl2.IntLiteral;
import it.unifi.xtext.facpl.facpl2.NotExpression;
import it.unifi.xtext.facpl.facpl2.Obligation;
import it.unifi.xtext.facpl.facpl2.OrExpression;
import it.unifi.xtext.facpl.facpl2.PolicySet;
import it.unifi.xtext.facpl.facpl2.Rule;
import it.unifi.xtext.facpl.facpl2.StringLiteral;
import it.unifi.xtext.facpl.facpl2.TypeLiteral;
import it.unifi.xtext.facpl.facpl2.funID;
import it.unifi.xtext.facpl.facpl2.util.Facpl2Switch;
import it.unifi.xtext.facpl.validation.FacplType;

public class FacplTypeInference extends Facpl2Switch<FacplType> {

	private SubstitutionSet typeAssignments;

	public FacplTypeInference() {
		this.typeAssignments = new SubstitutionSet();
	}

	public SubstitutionSet getTypeAssignments() {
		return typeAssignments;
	}

	/*
	 * MAIN INFERENCE -> VALIDATION CHECK ON POLICY SET AND RULE (comprising
	 * obligation and target)
	 */

	// POLICY SET
	@Override
	public FacplType casePolicySet(PolicySet p) {
		FacplType t;
		if (p.getTarget() != null) {
			t = doSwitch(p.getTarget());
			if (p.equals(FacplType.ERR)) {
				return FacplType.ERR;
			}
		}
		// Internal Elements
		for (AbstractPolicyIncl el : p.getPolicies()) {
			if (el.getRefPol() != null) {
				t = doSwitch(el.getRefPol());
				if (t.equals(FacplType.ERR))
					return FacplType.ERR;
			} else if (el.getNewPolicy() != null) {
				t = doSwitch(el.getNewPolicy());
				if (t.equals(FacplType.ERR))
					return FacplType.ERR;
			}
		}
		// Obligations
		for (Obligation o : p.getObl()) {
			t = doSwitch(o);
			if (t.equals(FacplType.ERR))
				return FacplType.ERR;
		}
		return FacplType.BOOLEAN;
	}

	// RULE
	@Override
	public FacplType caseRule(Rule r) {
		FacplType t;
		// target
		if (r.getTarget() != null) {
			t = doSwitch(r.getTarget());
			if (t.equals(FacplType.ERR)) {
				return FacplType.ERR;
			}
		}
		// Obligations
		for (Obligation o : r.getObl()) {
			t = doSwitch(o);
			if (t.equals(FacplType.ERR))
				return FacplType.ERR;
		}
		return FacplType.BOOLEAN;
	}

	@Override
	public FacplType caseFacplPolicy(FacplPolicy object) {
		if (object instanceof Rule) {
			return doSwitch((Rule) object);
		} else if (object instanceof PolicySet) {
			return doSwitch((PolicySet) object);
		}
		return FacplType.ERR;
	}

	// Return Boolean if all expression match the inferences
	@Override
	public FacplType caseObligation(Obligation object) {
		FacplType t;
		for (Expression exp : object.getExpr()) {
			t = doSwitch(exp);
			if (t.equals(FacplType.ERR))
				return FacplType.ERR;
		}
		return FacplType.BOOLEAN;
	}

	/*
	 * ################## EXPRESSION ##################
	 */

	// Expression
	@Override
	public FacplType caseExpression(Expression object) {
		return super.caseExpression(object);
	}

	// BOOLEAN EXPRESSION
	@Override
	public FacplType caseAndExpression(AndExpression exp) {
		FacplType arg1 = doSwitch(exp.getLeft());
		FacplType arg2 = doSwitch(exp.getRight());

		try {
			if (arg1.equals(FacplType.NAME)) {
				if (arg2.equals(FacplType.BOOLEAN)) {
					// first argument a name second a boolean -> such name has
					// to be BOOLEAN
					this.typeAssignments.add((AttributeName) exp.getLeft(), FacplType.BOOLEAN);
					return FacplType.BOOLEAN;
				} else if (arg2.equals(FacplType.NAME)) {
					// both arguments are names, we assert that their types have
					// to be the same and that one of them is BOOLEAN
					this.typeAssignments.addEquality((AttributeName) exp.getLeft(), (AttributeName) exp.getRight());
					this.typeAssignments.add((AttributeName) exp.getLeft(), FacplType.BOOLEAN);
					return FacplType.BOOLEAN;
				}
			} else if (arg2.equals(FacplType.NAME)) {
				if (arg1.equals(FacplType.BOOLEAN)) {
					// second argument a name second a boolean -> such name has
					// to be BOOLEAN
					this.typeAssignments.add((AttributeName) exp.getRight(), FacplType.BOOLEAN);
					return FacplType.BOOLEAN;
				} else if (arg1.equals(FacplType.NAME)) {
					this.typeAssignments.addEquality((AttributeName) exp.getLeft(), (AttributeName) exp.getRight());
					this.typeAssignments.add((AttributeName) exp.getRight(), FacplType.BOOLEAN);
					return FacplType.BOOLEAN;
				}
			} else if (arg1.equals(arg2)){
				return FacplType.BOOLEAN;
			}

			return FacplType.ERR;
		} catch (Exception e) {
			return FacplType.ERR;
		}
	}

	@Override
	public FacplType caseOrExpression(OrExpression exp) {
		FacplType arg1 = doSwitch(exp.getLeft());
		FacplType arg2 = doSwitch(exp.getRight());

		// see case of AND
		try {
			if (arg1.equals(FacplType.NAME)) {
				if (arg2.equals(FacplType.BOOLEAN)) {
					this.typeAssignments.add((AttributeName) exp.getLeft(), FacplType.BOOLEAN);
					return FacplType.BOOLEAN;
				} else if (arg2.equals(FacplType.NAME)) {
					this.typeAssignments.addEquality((AttributeName) exp.getLeft(), (AttributeName) exp.getRight());
					this.typeAssignments.add((AttributeName) exp.getLeft(), FacplType.BOOLEAN);
					return FacplType.BOOLEAN;
				}
			} else if (arg2.equals(FacplType.NAME)) {
				if (arg1.equals(FacplType.BOOLEAN)) {
					this.typeAssignments.add((AttributeName) exp.getRight(), FacplType.BOOLEAN);
					return FacplType.BOOLEAN;
				} else if (arg1.equals(FacplType.NAME)) {
					this.typeAssignments.addEquality((AttributeName) exp.getLeft(), (AttributeName) exp.getRight());
					this.typeAssignments.add((AttributeName) exp.getRight(), FacplType.BOOLEAN);
					return FacplType.BOOLEAN;
				}
			}else if (arg1.equals(arg2)){
				return FacplType.BOOLEAN;
			}

			return FacplType.ERR;
		} catch (Exception e) {
			return FacplType.ERR;
		}
	}

	@Override
	public FacplType caseNotExpression(NotExpression exp) {
		FacplType arg = doSwitch(exp.getArg());
		// see case of AND
		try {
			if (arg.equals(FacplType.NAME)) {
				this.typeAssignments.add((AttributeName) exp.getArg(), FacplType.BOOLEAN);
				return FacplType.BOOLEAN;
			} else if (arg.equals(FacplType.BOOLEAN)) {
				return FacplType.BOOLEAN;
			}
			return FacplType.ERR;
		} catch (Exception e) {
			return FacplType.ERR;
		}
	}

	// DECLARED FUNCTIONs
	@Override
	public FacplType caseDeclaredFunction(DeclaredFunction fun) {
		
		return toFacplType(fun.getFunctionId().getType());
		
	}
	

	private FacplType toFacplType(TypeLiteral type) {
		switch (type) {
		case BAG: return FacplType.BAG_NAME;
		case BOOL: return FacplType.BOOLEAN;
		case DOUBLE : return FacplType.DOUBLE;
		case INT : return FacplType.INT;
		case STRING : return FacplType.STRING;
		case DATE_TIME : return FacplType.DATE;
		default : 
			return FacplType.BAG_NAME;
		}	
	}

	// FUNCTIONs
	@Override
	public FacplType caseFunction(Function fun) {
		FacplType arg1 = doSwitch(fun.getArg1());
		FacplType arg2 = doSwitch(fun.getArg2());

		funID idFun = fun.getFunctionId();
		
		try {
			// Math Functions: ADD, DIVIDE, SUBTRACT, MULTIPLY
			if (idFun.equals(funID.ADD) || idFun.equals(funID.DIVIDE) || idFun.equals(funID.SUBTRACT)
					|| idFun.equals(funID.MULTIPLY)) {
				// accepted types only DOUBLE or INT, we use INT as much as
				// possible, when both we assume everything double
				if (arg1.equals(FacplType.NAME)) {
					if (!arg2.equals(FacplType.NAME) && (arg2.equals(FacplType.INT) || arg2.equals(FacplType.DOUBLE))) {
						this.typeAssignments.add((AttributeName) fun.getArg1(), arg2);
						return arg2;
					} else if (arg2.equals(FacplType.NAME)) {
						this.typeAssignments.addEquality((AttributeName) fun.getArg1(), (AttributeName) fun.getArg2());
						this.typeAssignments.add((AttributeName) fun.getArg1(), FacplType.INT);
						return FacplType.INT;
					}
				} else if (arg2.equals(FacplType.NAME)) {
					if (!arg1.equals(FacplType.NAME) && (arg1.equals(FacplType.INT) || arg1.equals(FacplType.DOUBLE))) {
						this.typeAssignments.add((AttributeName) fun.getArg2(), arg1);
						return arg1;
					} else if (arg1.equals(FacplType.NAME)) {
						this.typeAssignments.addEquality((AttributeName) fun.getArg1(), (AttributeName) fun.getArg2());
						this.typeAssignments.add((AttributeName) fun.getArg1(), FacplType.INT);
						return FacplType.INT;
					}
				}else if (arg1.equals(arg2)){
					return arg1;
				}

			}
			// EQUAL. NOT-EQUAL
			if (idFun.equals(funID.EQUAL) || idFun.equals(funID.NEQUAL)) {
				if (arg1.equals(FacplType.NAME)) {
					if (!arg2.equals(FacplType.NAME) && !arg2.equals(FacplType.ERR)) {
						this.typeAssignments.add((AttributeName) fun.getArg1(), arg2);
						return FacplType.BOOLEAN;
					} else if (arg2.equals(FacplType.NAME)) {
						this.typeAssignments.addEquality((AttributeName) fun.getArg1(), (AttributeName) fun.getArg2());
						return FacplType.BOOLEAN;
					}
				} else if (arg2.equals(FacplType.NAME)) {
					if (!arg1.equals(FacplType.NAME) && !arg1.equals(FacplType.ERR)) {
						this.typeAssignments.add((AttributeName) fun.getArg2(), arg1);
						return FacplType.BOOLEAN;
					} else if (arg1.equals(FacplType.NAME)) {
						this.typeAssignments.addEquality((AttributeName) fun.getArg1(), (AttributeName) fun.getArg2());
						return FacplType.BOOLEAN;
					}
				} else if (arg1.equals(arg2)){
					return FacplType.BOOLEAN;
				}
			}

			// IN
			if (idFun.equals(funID.IN)) {
				if (arg1.equals(FacplType.NAME)) {
					if (FacplType.isBag(arg2)) {
						if (arg2.equals(FacplType.BAG_NAME)) {
							// this.typeAssignments.add((AttributeName)
							// fun.getArg1(),FacplType.getTypeBag(arg2) );
							this.typeAssignments.addEquality((AttributeName) fun.getArg1(),
									getAttributeNameFromBag((Bag) fun.getArg2()));
						} else {
							// the bag literal has a type different from NAME
							this.typeAssignments.add((AttributeName) fun.getArg1(), FacplType.getTypeBag(arg2));
						}
						return FacplType.BOOLEAN;
					} else if (arg2.equals(FacplType.NAME)) {
						this.typeAssignments.addEquality((AttributeName) fun.getArg1(), (AttributeName) fun.getArg2());
						// signed arg2 as a bag element
						this.typeAssignments.addBagName((AttributeName) fun.getArg2());
						return FacplType.BOOLEAN;
					}
				} else {
					if (!arg1.equals(FacplType.ERR)) {
						// arg1 has a type
						if (arg2.equals(FacplType.NAME)) {
							// assert name in arg2 to be of the type BAG_* where
							// * is the type of arg1
							this.typeAssignments.add((AttributeName) fun.getArg2(), FacplType.getBagType(arg1));
							return FacplType.BOOLEAN;
						} else if (arg2.equals(FacplType.BAG_NAME)) {
							// assert one name within BAG_NAME of arg2 to be of
							// the type of arg1
							this.typeAssignments.add(getAttributeNameFromBag((Bag) fun.getArg2()), arg1);
							return FacplType.BOOLEAN;
						}
					}
				} 
				if (arg1.equals(arg2)){
					return FacplType.BOOLEAN;
				}
			}

			// LESS-(EQ), GREATER-(EQ)
			if (idFun.equals(funID.GREATER) || idFun.equals(funID.GREATER_EQ) || idFun.equals(funID.LESS)
					|| idFun.equals(funID.LESS_EQ)) {
				if (arg1.equals(FacplType.NAME)) {
					if (!arg2.equals(FacplType.NAME) && (arg2.equals(FacplType.INT) || arg2.equals(FacplType.DOUBLE))) {
						this.typeAssignments.add((AttributeName) fun.getArg1(), arg2);
						return FacplType.BOOLEAN;
					} else if (arg2.equals(FacplType.NAME)) {
						this.typeAssignments.addEquality((AttributeName) fun.getArg1(), (AttributeName) fun.getArg2());
						this.typeAssignments.add((AttributeName) fun.getArg1(), FacplType.INT);
						return FacplType.BOOLEAN;
					}
				} else if (arg2.equals(FacplType.NAME)) {
					if (!arg1.equals(FacplType.NAME) && (arg1.equals(FacplType.INT) || arg1.equals(FacplType.DOUBLE))) {
						this.typeAssignments.add((AttributeName) fun.getArg2(), arg1);
						return FacplType.BOOLEAN;
					} else if (arg1.equals(FacplType.NAME)) {
						this.typeAssignments.addEquality((AttributeName) fun.getArg1(), (AttributeName) fun.getArg2());
						this.typeAssignments.add((AttributeName) fun.getArg1(), FacplType.INT);
						return FacplType.BOOLEAN;
					}
				} else if (arg1.equals(arg2)){
					return FacplType.BOOLEAN;
				}
			}
			return FacplType.ERR;

		} catch (Exception e) {
			return FacplType.ERR;
		}
	}

	/**
	 * Return an attribute name present in the bag, null otherwise
	 * 
	 * @param arg2
	 * @return
	 */
	private AttributeName getAttributeNameFromBag(Bag arg) {
		AttributeName n = null;
		for (Expression e : arg.getArgs()) {
			if (e instanceof AttributeName)
				return (AttributeName) e;
		}
		return n;
	}

	// Literal
	@Override
	public FacplType caseBag(Bag bag) {
		FacplType def = null;
		LinkedList<AttributeName> list = new LinkedList<AttributeName>();
		for (Expression a : bag.getArgs()) {
			FacplType t = doSwitch(a);
			if (t.equals(FacplType.NAME)) {
				// AttributeName
				list.add((AttributeName) a);
				if (def == null)
					def = FacplType.NAME;
			} else if (!t.equals(FacplType.ERR)) {
				// Int < Double
				if ((def.equals(FacplType.INT) && t.equals(FacplType.DOUBLE))
						|| (def.equals(FacplType.DOUBLE) && t.equals(FacplType.INT))) {
					def = FacplType.DOUBLE;
					break;
				}
				// Unification Check
				if (def.equals(FacplType.NAME) || def.equals(t)) {
					def = t;
				} else {
					return FacplType.ERR;
				}
			} else {
				return FacplType.ERR;
			}
		}
		// Add all the possible constraint on names in the HaspMap of
		// assignments
		try {
			if (!def.equals(FacplType.NAME)) {
				// Type of BAG not equal to name, no need to use equalities
				for (AttributeName el : list) {
					this.typeAssignments.add(el, def);
				}
			} else {
				// Add Equalities
				for (int i = 0; i < list.size() - 1; i++) {
					this.typeAssignments.addEquality(list.get(i), list.get(i + 1));
				}
			}
			return FacplType.getBagType(def);
		} catch (Exception e) {
			return FacplType.ERR;
		}
	}

	@Override
	public FacplType caseDoubleLiteral(DoubleLiteral object) {
		return FacplType.DOUBLE;
	}

	@Override
	public FacplType caseDateLiteral(DateLiteral object) {
		return FacplType.DATE;
	}

	@Override
	public FacplType caseBooleanLiteral(BooleanLiteral object) {
		return FacplType.BOOLEAN;
	}

	@Override
	public FacplType caseIntLiteral(IntLiteral object) {
		return FacplType.INT;
	}

	@Override
	public FacplType caseAttributeName(AttributeName object) {
		if (!this.typeAssignments.isBounded(object)) {
			try {
				// add in the assignment the name of the variable.
				this.typeAssignments.add(object, null);
			} catch (Exception e) {
				// cannot happen
			}
		}
		return FacplType.NAME;
	}

	@Override
	public FacplType caseStringLiteral(StringLiteral object) {
		return FacplType.STRING;
	}

	@Override
	public String toString() {
		return this.typeAssignments.toString();
	}

	public String toEq() {
		return this.typeAssignments.toEq();
	}
	
	/*
	 * This case is used only as TypeCheck, it is not used as Type Inferece
	 */
	
	@Override
	public FacplType caseAttributeReq(AttributeReq object) {
		FacplType f = doSwitch(object.getValue().get(0));
		for (Expression e : object.getValue()) {
			f = FacplType.combine(f, doSwitch(e));
			if (f.equals(FacplType.ERR))
				return FacplType.ERR;
		}
		return f;
	}

}
