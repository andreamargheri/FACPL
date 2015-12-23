package it.unifi.xtext.facpl.validation;

import it.unifi.xtext.facpl.facpl2.AndExpression;
import it.unifi.xtext.facpl.facpl2.AttributeReq;
import it.unifi.xtext.facpl.facpl2.AttributeName;
import it.unifi.xtext.facpl.facpl2.Bag;
import it.unifi.xtext.facpl.facpl2.BooleanLiteral;
import it.unifi.xtext.facpl.facpl2.DateLiteral;
import it.unifi.xtext.facpl.facpl2.DoubleLiteral;
import it.unifi.xtext.facpl.facpl2.Expression;
import it.unifi.xtext.facpl.facpl2.Function;
import it.unifi.xtext.facpl.facpl2.IntLiteral;
import it.unifi.xtext.facpl.facpl2.NotExpression;
import it.unifi.xtext.facpl.facpl2.OrExpression;
import it.unifi.xtext.facpl.facpl2.StringLiteral;
import it.unifi.xtext.facpl.facpl2.funID;
import it.unifi.xtext.facpl.facpl2.util.Facpl2Switch;

public class FacplTypeChecker extends Facpl2Switch<FacplType> {

	private static FacplTypeChecker instance;

	public static FacplTypeChecker getInstance() {
		if (instance == null) {
			instance = new FacplTypeChecker();
		}

		return instance;
	}

	private FacplTypeChecker() {
	}

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

		if ((arg1.equals(FacplType.BOOLEAN) || arg1.equals(FacplType.NAME)) && (arg2.equals(FacplType.BOOLEAN))
				|| arg2.equals(FacplType.NAME)) {
			return FacplType.BOOLEAN;
		} else {
			return FacplType.ERR;
		}
	}

	@Override
	public FacplType caseOrExpression(OrExpression exp) {
		FacplType arg1 = doSwitch(exp.getLeft());
		FacplType arg2 = doSwitch(exp.getRight());

		if ((arg1.equals(FacplType.BOOLEAN) || arg1.equals(FacplType.NAME)) && (arg2.equals(FacplType.BOOLEAN))
				|| arg2.equals(FacplType.NAME)) {
			return FacplType.BOOLEAN;
		} else {
			return FacplType.ERR;
		}
	}

	@Override
	public FacplType caseNotExpression(NotExpression exp) {

		FacplType arg = doSwitch(exp.getArg());

		if ((arg.equals(FacplType.BOOLEAN) || arg.equals(FacplType.NAME))) {
			return FacplType.BOOLEAN;
		} else {
			return FacplType.ERR;
		}
	}

	// FUNCTIONs
	public FacplType caseFunction(Function fun) {
		FacplType arg1 = doSwitch(fun.getArg1());
		FacplType arg2 = doSwitch(fun.getArg2());
		FacplType combinedT = FacplType.combine(arg1, arg2);

		funID idFun = fun.getFunctionId();
		// Math Functions: ADD, DIVIDE, SUBTRACT, MULTIPLY
		if (idFun.equals(funID.ADD) || idFun.equals(funID.DIVIDE) || idFun.equals(funID.SUBTRACT)
				|| idFun.equals(funID.MULTIPLY)) {
			if (combinedT.equals(FacplType.NAME) || combinedT.equals(FacplType.DOUBLE)
					|| combinedT.equals(FacplType.INT)) {
				return combinedT;
			} else {
				return FacplType.ERR;
			}
		}
		// EQUAL. NOT-EQUAL
		if (idFun.equals(funID.EQUAL) || idFun.equals(funID.NEQUAL)) {
			if (!combinedT.equals(FacplType.ERR) && !FacplType.isBag(combinedT))
				return FacplType.BOOLEAN;
			else
				return FacplType.ERR;
		}
		// IN
		if (idFun.equals(funID.IN)) {
			if (!arg1.equals(FacplType.ERR) && !FacplType.isBag(arg1) && FacplType.isBag(arg2)) {
				return FacplType.BOOLEAN;
			} else {
				return FacplType.ERR;
			}
		}
		// LESS-(EQ), GREATER-(EQ)
		if (idFun.equals(funID.GREATER) || idFun.equals(funID.GREATER_EQ) || idFun.equals(funID.LESS)
				|| idFun.equals(funID.LESS_EQ)) {
			if (combinedT.equals(FacplType.NAME) || combinedT.equals(FacplType.DOUBLE)
					|| combinedT.equals(FacplType.INT) || combinedT.equals(FacplType.DATE)) {
				return FacplType.BOOLEAN;
			} else {
				return FacplType.ERR;
			}
		}
		return FacplType.ERR;
	}

	// Request Attribute -> Check if bags contain elements of the same type
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

	// Literal

	@Override
	public FacplType caseBag(Bag bag) {
		FacplType t = doSwitch(bag.getArgs().get(0));
		for(Expression ob : bag.getArgs()){
			t = FacplType.combine(t, doSwitch(ob));
		}
		if (!t.equals(FacplType.ERR))
			return FacplType.getBagType(t);
		else 
			return FacplType.ERR;
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
		return FacplType.NAME;
	}

	@Override
	public FacplType caseStringLiteral(StringLiteral object) {
		return FacplType.STRING;
	}

}
