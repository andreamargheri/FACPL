package it.unifi.xtext.facpl2.ui.syntaxcoloring

import org.eclipse.xtext.ui.editor.utils.TextStyle
import org.eclipse.swt.graphics.RGB
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor
import org.eclipse.swt.SWT
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration

class SyntaxHighlighting extends DefaultHighlightingConfiguration {

	public static final String POLICY = "policy";
	public static final String ID = "id";
	public static final String ALG = "algorithm";
	public static final String STRATEGY = "fulfillmentstragey";
	public static final String EFFECT = "effect";
	public static final String START_KEYWORD = "start keyword";
	public static final String POLICY_KEYWORD = "policy keyword";
	public static final String FUNCTION = "match function";
	public static final String STRING_ID = "string";
	public static final String NUMBER = "number";
	public static final String STRUCT_NAME = "structured name";
	public static final String DATETIME = "datetime";
	public static final String SET = "set";
	public static final String MAIN = "main";

	override configure(IHighlightingConfigurationAcceptor acceptor) {
		// super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(POLICY, "Policy", policyTextStyle());
		acceptor.acceptDefaultHighlighting(ID, "Id", idTextStyle());
		acceptor.acceptDefaultHighlighting(ALG, "Algorithm", algTextStyle());
		acceptor.acceptDefaultHighlighting(STRATEGY, "Strategy", strategyTextStyle());
		acceptor.acceptDefaultHighlighting(EFFECT, "Effect", effectTextStyle());
		acceptor.acceptDefaultHighlighting(START_KEYWORD, "Start Keyword", startTextStyle());
		acceptor.acceptDefaultHighlighting(POLICY_KEYWORD, "Policy Keyword", policyKeyTextStyle());
		acceptor.acceptDefaultHighlighting(FUNCTION, "Match Function", functionTextStyle());
		acceptor.acceptDefaultHighlighting(STRING_ID, "String_ID", stringTextStyle());
		acceptor.acceptDefaultHighlighting(NUMBER, "Number", numberTextStyle());
		acceptor.acceptDefaultHighlighting(STRUCT_NAME, "Structured Name", attributeTextStyle());
		acceptor.acceptDefaultHighlighting(SET, "Set value", stringSetStyle());
		acceptor.acceptDefaultHighlighting(MAIN, "Main option", stringMainStyle());
		acceptor.acceptDefaultHighlighting(DATETIME, "DateTime", dateStyle());
	}

	def TextStyle effectTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(208, 32, 144));
		// textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	def TextStyle functionTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 156));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}

	def TextStyle dateStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(180, 40, 40));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	def TextStyle algTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(1, 100, 1));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	def TextStyle strategyTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(1, 1, 100));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	def TextStyle policyTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(255, 127, 0));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	def TextStyle policyKeyTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(100, 10, 10));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

//	def TextStyle stringTextStyle() {
//		var TextStyle textStyle = defaultTextStyle().copy();
//		textStyle.setColor(new RGB(42, 0, 255));
//		return textStyle;
//	}
	def TextStyle stringSetStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(131, 111, 255));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}

	def TextStyle stringMainStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(58, 95, 205));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

//	def TextStyle numberTextStyle() {
//		var TextStyle textStyle = defaultTextStyle().copy();
//		textStyle.setColor(new RGB(125, 125, 125));
//		return textStyle;
//	}
	def TextStyle attributeTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(138, 43, 226));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	def TextStyle startTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(100, 10, 10));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	def TextStyle idTextStyle() {
		var TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(1, 1, 100));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}
}