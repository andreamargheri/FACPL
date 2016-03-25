/*
 * generated by Xtext
 */
package it.unifi.xtext.facpl.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import it.unifi.xtext.facpl.services.Facpl2GrammarAccess;

public class Facpl2Parser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private Facpl2GrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected it.unifi.xtext.facpl.parser.antlr.internal.InternalFacpl2Parser createParser(XtextTokenStream stream) {
		return new it.unifi.xtext.facpl.parser.antlr.internal.InternalFacpl2Parser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Facpl";
	}
	
	public Facpl2GrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(Facpl2GrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
