package it.unifi.xtext.facpl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import it.unifi.xtext.facpl.services.Facpl2GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFacpl2Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_BOOLEAN", "RULE_INT", "RULE_REAL", "RULE_DATE", "RULE_TIME", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'PAS'", "'{'", "'Extended Indeterminate'", "':'", "';'", "'Simulate XACML Semantics'", "'Java Package'", "'Requests To Evaluate'", "','", "'}'", "'dec-fun'", "'('", "')'", "'pep:'", "'pdp:'", "'Request:'", "'['", "']'", "'/'", "'_'", "'-'", "'.'", "'include'", "'PolicySet'", "'target:'", "'policies:'", "'obl-p:'", "'obl-d:'", "'Rule'", "'obl:'", "'M'", "'O'", "'&&'", "'||'", "'!'", "'map('", "'set('", "'Int'", "'Double'", "'Bool'", "'String'", "'DateTime'", "'Set<Int>'", "'Set<Double>'", "'Set<Bool>'", "'Set<String>'", "'Set<DateTime>'", "'base'", "'deny-biased'", "'permit-biased'", "'only-one-applicable'", "'deny-overrides'", "'permit-overrides'", "'first-applicable'", "'deny-unless-permit'", "'permit-unless-deny'", "'weak-consensus'", "'strong-consensus'", "'custom-algorithm'", "'greedy'", "'all'", "'permit'", "'deny'", "'equal'", "'not-equal'", "'less-than'", "'less-than-or-equal'", "'greater-than'", "'greater-than-or-equal'", "'in'", "'addition'", "'subtract'", "'divide'", "'multiply'"
    };
    public static final int T__50=50;
    public static final int RULE_BOOLEAN=6;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RULE_TIME=10;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_REAL=8;
    public static final int RULE_DATE=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__88=88;
    public static final int T__45=45;
    public static final int T__89=89;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalFacpl2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFacpl2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFacpl2Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalFacpl2.g"; }



     	private Facpl2GrammarAccess grammarAccess;
     	
        public InternalFacpl2Parser(TokenStream input, Facpl2GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Facpl";	
       	}
       	
       	@Override
       	protected Facpl2GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleFacpl"
    // InternalFacpl2.g:68:1: entryRuleFacpl returns [EObject current=null] : iv_ruleFacpl= ruleFacpl EOF ;
    public final EObject entryRuleFacpl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFacpl = null;


        try {
            // InternalFacpl2.g:69:2: (iv_ruleFacpl= ruleFacpl EOF )
            // InternalFacpl2.g:70:2: iv_ruleFacpl= ruleFacpl EOF
            {
             newCompositeNode(grammarAccess.getFacplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFacpl=ruleFacpl();

            state._fsp--;

             current =iv_ruleFacpl; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFacpl"


    // $ANTLR start "ruleFacpl"
    // InternalFacpl2.g:77:1: ruleFacpl returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) ) ) )* ) ) ) ;
    public final EObject ruleFacpl() throws RecognitionException {
        EObject current = null;

        EObject lv_importEl_1_0 = null;

        EObject lv_declarations_2_0 = null;

        EObject lv_policies_3_0 = null;

        EObject lv_requests_4_0 = null;

        EObject lv_main_5_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:80:28: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) ) ) )* ) ) ) )
            // InternalFacpl2.g:81:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) ) ) )* ) ) )
            {
            // InternalFacpl2.g:81:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) ) ) )* ) ) )
            // InternalFacpl2.g:83:1: ( ( ( ({...}? => ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) ) ) )* ) )
            {
            // InternalFacpl2.g:83:1: ( ( ( ({...}? => ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) ) ) )* ) )
            // InternalFacpl2.g:84:2: ( ( ({...}? => ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getFacplAccess().getUnorderedGroup());
            	
            // InternalFacpl2.g:87:2: ( ( ({...}? => ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) ) ) )* )
            // InternalFacpl2.g:88:3: ( ({...}? => ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) ) ) )*
            {
            // InternalFacpl2.g:88:3: ( ({...}? => ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) ) ) )*
            loop5:
            do {
                int alt5=6;
                int LA5_0 = input.LA(1);

                if ( LA5_0 == 15 && getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 0) ) {
                    alt5=1;
                }
                else if ( LA5_0 == 26 && getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 1) ) {
                    alt5=2;
                }
                else if ( LA5_0 == 39 && getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 2) ) {
                    alt5=3;
                }
                else if ( LA5_0 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 3) ) {
                    alt5=4;
                }
                else if ( LA5_0 == 16 && getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 4) ) {
                    alt5=5;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalFacpl2.g:90:4: ({...}? => ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ ) )
            	    {
            	    // InternalFacpl2.g:90:4: ({...}? => ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ ) )
            	    // InternalFacpl2.g:91:5: {...}? => ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleFacpl", "getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalFacpl2.g:91:100: ( ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+ )
            	    // InternalFacpl2.g:92:6: ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getFacplAccess().getUnorderedGroup(), 0);
            	    	 				
            	    // InternalFacpl2.g:95:6: ({...}? => ( (lv_importEl_1_0= ruleImport ) ) )+
            	    int cnt1=0;
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==15) ) {
            	            int LA1_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt1=1;
            	            }


            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // InternalFacpl2.g:95:7: {...}? => ( (lv_importEl_1_0= ruleImport ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleFacpl", "true");
            	    	    }
            	    	    // InternalFacpl2.g:95:16: ( (lv_importEl_1_0= ruleImport ) )
            	    	    // InternalFacpl2.g:96:1: (lv_importEl_1_0= ruleImport )
            	    	    {
            	    	    // InternalFacpl2.g:96:1: (lv_importEl_1_0= ruleImport )
            	    	    // InternalFacpl2.g:97:3: lv_importEl_1_0= ruleImport
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getFacplAccess().getImportElImportParserRuleCall_0_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_3);
            	    	    lv_importEl_1_0=ruleImport();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getFacplRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"importEl",
            	    	            		lv_importEl_1_0, 
            	    	            		"it.unifi.xtext.facpl.Facpl2.Import");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt1 >= 1 ) break loop1;
            	                EarlyExitException eee =
            	                    new EarlyExitException(1, input);
            	                throw eee;
            	        }
            	        cnt1++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFacplAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalFacpl2.g:120:4: ({...}? => ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ ) )
            	    {
            	    // InternalFacpl2.g:120:4: ({...}? => ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ ) )
            	    // InternalFacpl2.g:121:5: {...}? => ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleFacpl", "getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalFacpl2.g:121:100: ( ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+ )
            	    // InternalFacpl2.g:122:6: ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getFacplAccess().getUnorderedGroup(), 1);
            	    	 				
            	    // InternalFacpl2.g:125:6: ({...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) ) )+
            	    int cnt2=0;
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==26) ) {
            	            int LA2_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt2=1;
            	            }


            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalFacpl2.g:125:7: {...}? => ( (lv_declarations_2_0= ruleFunctionDeclaration ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleFacpl", "true");
            	    	    }
            	    	    // InternalFacpl2.g:125:16: ( (lv_declarations_2_0= ruleFunctionDeclaration ) )
            	    	    // InternalFacpl2.g:126:1: (lv_declarations_2_0= ruleFunctionDeclaration )
            	    	    {
            	    	    // InternalFacpl2.g:126:1: (lv_declarations_2_0= ruleFunctionDeclaration )
            	    	    // InternalFacpl2.g:127:3: lv_declarations_2_0= ruleFunctionDeclaration
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getFacplAccess().getDeclarationsFunctionDeclarationParserRuleCall_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_3);
            	    	    lv_declarations_2_0=ruleFunctionDeclaration();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getFacplRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"declarations",
            	    	            		lv_declarations_2_0, 
            	    	            		"it.unifi.xtext.facpl.Facpl2.FunctionDeclaration");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt2 >= 1 ) break loop2;
            	                EarlyExitException eee =
            	                    new EarlyExitException(2, input);
            	                throw eee;
            	        }
            	        cnt2++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFacplAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalFacpl2.g:150:4: ({...}? => ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ ) )
            	    {
            	    // InternalFacpl2.g:150:4: ({...}? => ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ ) )
            	    // InternalFacpl2.g:151:5: {...}? => ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleFacpl", "getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalFacpl2.g:151:100: ( ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+ )
            	    // InternalFacpl2.g:152:6: ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getFacplAccess().getUnorderedGroup(), 2);
            	    	 				
            	    // InternalFacpl2.g:155:6: ({...}? => ( (lv_policies_3_0= rulePolicySet ) ) )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==39) ) {
            	            int LA3_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt3=1;
            	            }


            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // InternalFacpl2.g:155:7: {...}? => ( (lv_policies_3_0= rulePolicySet ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleFacpl", "true");
            	    	    }
            	    	    // InternalFacpl2.g:155:16: ( (lv_policies_3_0= rulePolicySet ) )
            	    	    // InternalFacpl2.g:156:1: (lv_policies_3_0= rulePolicySet )
            	    	    {
            	    	    // InternalFacpl2.g:156:1: (lv_policies_3_0= rulePolicySet )
            	    	    // InternalFacpl2.g:157:3: lv_policies_3_0= rulePolicySet
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getFacplAccess().getPoliciesPolicySetParserRuleCall_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_3);
            	    	    lv_policies_3_0=rulePolicySet();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getFacplRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"policies",
            	    	            		lv_policies_3_0, 
            	    	            		"it.unifi.xtext.facpl.Facpl2.PolicySet");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFacplAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalFacpl2.g:180:4: ({...}? => ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ ) )
            	    {
            	    // InternalFacpl2.g:180:4: ({...}? => ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ ) )
            	    // InternalFacpl2.g:181:5: {...}? => ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleFacpl", "getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 3)");
            	    }
            	    // InternalFacpl2.g:181:100: ( ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+ )
            	    // InternalFacpl2.g:182:6: ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getFacplAccess().getUnorderedGroup(), 3);
            	    	 				
            	    // InternalFacpl2.g:185:6: ({...}? => ( (lv_requests_4_0= ruleRequest ) ) )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==31) ) {
            	            int LA4_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt4=1;
            	            }


            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalFacpl2.g:185:7: {...}? => ( (lv_requests_4_0= ruleRequest ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleFacpl", "true");
            	    	    }
            	    	    // InternalFacpl2.g:185:16: ( (lv_requests_4_0= ruleRequest ) )
            	    	    // InternalFacpl2.g:186:1: (lv_requests_4_0= ruleRequest )
            	    	    {
            	    	    // InternalFacpl2.g:186:1: (lv_requests_4_0= ruleRequest )
            	    	    // InternalFacpl2.g:187:3: lv_requests_4_0= ruleRequest
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getFacplAccess().getRequestsRequestParserRuleCall_3_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_3);
            	    	    lv_requests_4_0=ruleRequest();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getFacplRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"requests",
            	    	            		lv_requests_4_0, 
            	    	            		"it.unifi.xtext.facpl.Facpl2.Request");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt4 >= 1 ) break loop4;
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFacplAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalFacpl2.g:210:4: ({...}? => ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) ) )
            	    {
            	    // InternalFacpl2.g:210:4: ({...}? => ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) ) )
            	    // InternalFacpl2.g:211:5: {...}? => ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleFacpl", "getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 4)");
            	    }
            	    // InternalFacpl2.g:211:100: ( ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) ) )
            	    // InternalFacpl2.g:212:6: ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getFacplAccess().getUnorderedGroup(), 4);
            	    	 				
            	    // InternalFacpl2.g:215:6: ({...}? => ( (lv_main_5_0= ruleMainFacpl ) ) )
            	    // InternalFacpl2.g:215:7: {...}? => ( (lv_main_5_0= ruleMainFacpl ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleFacpl", "true");
            	    }
            	    // InternalFacpl2.g:215:16: ( (lv_main_5_0= ruleMainFacpl ) )
            	    // InternalFacpl2.g:216:1: (lv_main_5_0= ruleMainFacpl )
            	    {
            	    // InternalFacpl2.g:216:1: (lv_main_5_0= ruleMainFacpl )
            	    // InternalFacpl2.g:217:3: lv_main_5_0= ruleMainFacpl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFacplAccess().getMainMainFacplParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_main_5_0=ruleMainFacpl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFacplRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"main",
            	            		lv_main_5_0, 
            	            		"it.unifi.xtext.facpl.Facpl2.MainFacpl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getFacplAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getFacplAccess().getUnorderedGroup());
            	

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFacpl"


    // $ANTLR start "entryRuleImport"
    // InternalFacpl2.g:255:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalFacpl2.g:256:2: (iv_ruleImport= ruleImport EOF )
            // InternalFacpl2.g:257:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalFacpl2.g:264:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:267:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // InternalFacpl2.g:268:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // InternalFacpl2.g:268:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // InternalFacpl2.g:268:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalFacpl2.g:272:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // InternalFacpl2.g:273:1: (lv_importURI_1_0= RULE_STRING )
            {
            // InternalFacpl2.g:273:1: (lv_importURI_1_0= RULE_STRING )
            // InternalFacpl2.g:274:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            			newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"importURI",
                    		lv_importURI_1_0, 
                    		"it.unifi.xtext.facpl.Facpl2.STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleMainFacpl"
    // InternalFacpl2.g:298:1: entryRuleMainFacpl returns [EObject current=null] : iv_ruleMainFacpl= ruleMainFacpl EOF ;
    public final EObject entryRuleMainFacpl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMainFacpl = null;


        try {
            // InternalFacpl2.g:299:2: (iv_ruleMainFacpl= ruleMainFacpl EOF )
            // InternalFacpl2.g:300:2: iv_ruleMainFacpl= ruleMainFacpl EOF
            {
             newCompositeNode(grammarAccess.getMainFacplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMainFacpl=ruleMainFacpl();

            state._fsp--;

             current =iv_ruleMainFacpl; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMainFacpl"


    // $ANTLR start "ruleMainFacpl"
    // InternalFacpl2.g:307:1: ruleMainFacpl returns [EObject current=null] : (otherlv_0= 'PAS' otherlv_1= '{' otherlv_2= 'Extended Indeterminate' otherlv_3= ':' ( (lv_extIndet_4_0= ruleBooleanLiteral ) ) otherlv_5= ';' (otherlv_6= 'Simulate XACML Semantics' otherlv_7= ':' ( (lv_simulateXACML_8_0= ruleBooleanLiteral ) ) otherlv_9= ';' )? (otherlv_10= 'Java Package' otherlv_11= ':' ( (lv_genPackage_12_0= RULE_STRING ) ) otherlv_13= ';' )? (otherlv_14= 'Requests To Evaluate' otherlv_15= ':' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= ',' ( (otherlv_18= RULE_ID ) ) )* ) otherlv_19= ';' ) ( (lv_paf_20_0= rulePAF ) ) otherlv_21= '}' ) ;
    public final EObject ruleMainFacpl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_genPackage_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        EObject lv_extIndet_4_0 = null;

        EObject lv_simulateXACML_8_0 = null;

        EObject lv_paf_20_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:310:28: ( (otherlv_0= 'PAS' otherlv_1= '{' otherlv_2= 'Extended Indeterminate' otherlv_3= ':' ( (lv_extIndet_4_0= ruleBooleanLiteral ) ) otherlv_5= ';' (otherlv_6= 'Simulate XACML Semantics' otherlv_7= ':' ( (lv_simulateXACML_8_0= ruleBooleanLiteral ) ) otherlv_9= ';' )? (otherlv_10= 'Java Package' otherlv_11= ':' ( (lv_genPackage_12_0= RULE_STRING ) ) otherlv_13= ';' )? (otherlv_14= 'Requests To Evaluate' otherlv_15= ':' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= ',' ( (otherlv_18= RULE_ID ) ) )* ) otherlv_19= ';' ) ( (lv_paf_20_0= rulePAF ) ) otherlv_21= '}' ) )
            // InternalFacpl2.g:311:1: (otherlv_0= 'PAS' otherlv_1= '{' otherlv_2= 'Extended Indeterminate' otherlv_3= ':' ( (lv_extIndet_4_0= ruleBooleanLiteral ) ) otherlv_5= ';' (otherlv_6= 'Simulate XACML Semantics' otherlv_7= ':' ( (lv_simulateXACML_8_0= ruleBooleanLiteral ) ) otherlv_9= ';' )? (otherlv_10= 'Java Package' otherlv_11= ':' ( (lv_genPackage_12_0= RULE_STRING ) ) otherlv_13= ';' )? (otherlv_14= 'Requests To Evaluate' otherlv_15= ':' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= ',' ( (otherlv_18= RULE_ID ) ) )* ) otherlv_19= ';' ) ( (lv_paf_20_0= rulePAF ) ) otherlv_21= '}' )
            {
            // InternalFacpl2.g:311:1: (otherlv_0= 'PAS' otherlv_1= '{' otherlv_2= 'Extended Indeterminate' otherlv_3= ':' ( (lv_extIndet_4_0= ruleBooleanLiteral ) ) otherlv_5= ';' (otherlv_6= 'Simulate XACML Semantics' otherlv_7= ':' ( (lv_simulateXACML_8_0= ruleBooleanLiteral ) ) otherlv_9= ';' )? (otherlv_10= 'Java Package' otherlv_11= ':' ( (lv_genPackage_12_0= RULE_STRING ) ) otherlv_13= ';' )? (otherlv_14= 'Requests To Evaluate' otherlv_15= ':' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= ',' ( (otherlv_18= RULE_ID ) ) )* ) otherlv_19= ';' ) ( (lv_paf_20_0= rulePAF ) ) otherlv_21= '}' )
            // InternalFacpl2.g:311:3: otherlv_0= 'PAS' otherlv_1= '{' otherlv_2= 'Extended Indeterminate' otherlv_3= ':' ( (lv_extIndet_4_0= ruleBooleanLiteral ) ) otherlv_5= ';' (otherlv_6= 'Simulate XACML Semantics' otherlv_7= ':' ( (lv_simulateXACML_8_0= ruleBooleanLiteral ) ) otherlv_9= ';' )? (otherlv_10= 'Java Package' otherlv_11= ':' ( (lv_genPackage_12_0= RULE_STRING ) ) otherlv_13= ';' )? (otherlv_14= 'Requests To Evaluate' otherlv_15= ':' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= ',' ( (otherlv_18= RULE_ID ) ) )* ) otherlv_19= ';' ) ( (lv_paf_20_0= rulePAF ) ) otherlv_21= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getMainFacplAccess().getPASKeyword_0());
                
            otherlv_1=(Token)match(input,17,FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getMainFacplAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,18,FOLLOW_7); 

                	newLeafNode(otherlv_2, grammarAccess.getMainFacplAccess().getExtendedIndeterminateKeyword_2());
                
            otherlv_3=(Token)match(input,19,FOLLOW_8); 

                	newLeafNode(otherlv_3, grammarAccess.getMainFacplAccess().getColonKeyword_3());
                
            // InternalFacpl2.g:327:1: ( (lv_extIndet_4_0= ruleBooleanLiteral ) )
            // InternalFacpl2.g:328:1: (lv_extIndet_4_0= ruleBooleanLiteral )
            {
            // InternalFacpl2.g:328:1: (lv_extIndet_4_0= ruleBooleanLiteral )
            // InternalFacpl2.g:329:3: lv_extIndet_4_0= ruleBooleanLiteral
            {
             
            	        newCompositeNode(grammarAccess.getMainFacplAccess().getExtIndetBooleanLiteralParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_9);
            lv_extIndet_4_0=ruleBooleanLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMainFacplRule());
            	        }
                   		set(
                   			current, 
                   			"extIndet",
                    		lv_extIndet_4_0, 
                    		"it.unifi.xtext.facpl.Facpl2.BooleanLiteral");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_10); 

                	newLeafNode(otherlv_5, grammarAccess.getMainFacplAccess().getSemicolonKeyword_5());
                
            // InternalFacpl2.g:349:1: (otherlv_6= 'Simulate XACML Semantics' otherlv_7= ':' ( (lv_simulateXACML_8_0= ruleBooleanLiteral ) ) otherlv_9= ';' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalFacpl2.g:349:3: otherlv_6= 'Simulate XACML Semantics' otherlv_7= ':' ( (lv_simulateXACML_8_0= ruleBooleanLiteral ) ) otherlv_9= ';'
                    {
                    otherlv_6=(Token)match(input,21,FOLLOW_7); 

                        	newLeafNode(otherlv_6, grammarAccess.getMainFacplAccess().getSimulateXACMLSemanticsKeyword_6_0());
                        
                    otherlv_7=(Token)match(input,19,FOLLOW_8); 

                        	newLeafNode(otherlv_7, grammarAccess.getMainFacplAccess().getColonKeyword_6_1());
                        
                    // InternalFacpl2.g:357:1: ( (lv_simulateXACML_8_0= ruleBooleanLiteral ) )
                    // InternalFacpl2.g:358:1: (lv_simulateXACML_8_0= ruleBooleanLiteral )
                    {
                    // InternalFacpl2.g:358:1: (lv_simulateXACML_8_0= ruleBooleanLiteral )
                    // InternalFacpl2.g:359:3: lv_simulateXACML_8_0= ruleBooleanLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getMainFacplAccess().getSimulateXACMLBooleanLiteralParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_9);
                    lv_simulateXACML_8_0=ruleBooleanLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMainFacplRule());
                    	        }
                           		set(
                           			current, 
                           			"simulateXACML",
                            		lv_simulateXACML_8_0, 
                            		"it.unifi.xtext.facpl.Facpl2.BooleanLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_11); 

                        	newLeafNode(otherlv_9, grammarAccess.getMainFacplAccess().getSemicolonKeyword_6_3());
                        

                    }
                    break;

            }

            // InternalFacpl2.g:379:3: (otherlv_10= 'Java Package' otherlv_11= ':' ( (lv_genPackage_12_0= RULE_STRING ) ) otherlv_13= ';' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalFacpl2.g:379:5: otherlv_10= 'Java Package' otherlv_11= ':' ( (lv_genPackage_12_0= RULE_STRING ) ) otherlv_13= ';'
                    {
                    otherlv_10=(Token)match(input,22,FOLLOW_7); 

                        	newLeafNode(otherlv_10, grammarAccess.getMainFacplAccess().getJavaPackageKeyword_7_0());
                        
                    otherlv_11=(Token)match(input,19,FOLLOW_4); 

                        	newLeafNode(otherlv_11, grammarAccess.getMainFacplAccess().getColonKeyword_7_1());
                        
                    // InternalFacpl2.g:387:1: ( (lv_genPackage_12_0= RULE_STRING ) )
                    // InternalFacpl2.g:388:1: (lv_genPackage_12_0= RULE_STRING )
                    {
                    // InternalFacpl2.g:388:1: (lv_genPackage_12_0= RULE_STRING )
                    // InternalFacpl2.g:389:3: lv_genPackage_12_0= RULE_STRING
                    {
                    lv_genPackage_12_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

                    			newLeafNode(lv_genPackage_12_0, grammarAccess.getMainFacplAccess().getGenPackageSTRINGTerminalRuleCall_7_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMainFacplRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"genPackage",
                            		lv_genPackage_12_0, 
                            		"it.unifi.xtext.facpl.Facpl2.STRING");
                    	    

                    }


                    }

                    otherlv_13=(Token)match(input,20,FOLLOW_12); 

                        	newLeafNode(otherlv_13, grammarAccess.getMainFacplAccess().getSemicolonKeyword_7_3());
                        

                    }
                    break;

            }

            // InternalFacpl2.g:409:3: (otherlv_14= 'Requests To Evaluate' otherlv_15= ':' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= ',' ( (otherlv_18= RULE_ID ) ) )* ) otherlv_19= ';' )
            // InternalFacpl2.g:409:5: otherlv_14= 'Requests To Evaluate' otherlv_15= ':' ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= ',' ( (otherlv_18= RULE_ID ) ) )* ) otherlv_19= ';'
            {
            otherlv_14=(Token)match(input,23,FOLLOW_7); 

                	newLeafNode(otherlv_14, grammarAccess.getMainFacplAccess().getRequestsToEvaluateKeyword_8_0());
                
            otherlv_15=(Token)match(input,19,FOLLOW_13); 

                	newLeafNode(otherlv_15, grammarAccess.getMainFacplAccess().getColonKeyword_8_1());
                
            // InternalFacpl2.g:417:1: ( ( (otherlv_16= RULE_ID ) ) (otherlv_17= ',' ( (otherlv_18= RULE_ID ) ) )* )
            // InternalFacpl2.g:417:2: ( (otherlv_16= RULE_ID ) ) (otherlv_17= ',' ( (otherlv_18= RULE_ID ) ) )*
            {
            // InternalFacpl2.g:417:2: ( (otherlv_16= RULE_ID ) )
            // InternalFacpl2.g:418:1: (otherlv_16= RULE_ID )
            {
            // InternalFacpl2.g:418:1: (otherlv_16= RULE_ID )
            // InternalFacpl2.g:419:3: otherlv_16= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMainFacplRule());
            	        }
                    
            otherlv_16=(Token)match(input,RULE_ID,FOLLOW_14); 

            		newLeafNode(otherlv_16, grammarAccess.getMainFacplAccess().getRefRequestRequestCrossReference_8_2_0_0()); 
            	

            }


            }

            // InternalFacpl2.g:430:2: (otherlv_17= ',' ( (otherlv_18= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==24) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalFacpl2.g:430:4: otherlv_17= ',' ( (otherlv_18= RULE_ID ) )
            	    {
            	    otherlv_17=(Token)match(input,24,FOLLOW_13); 

            	        	newLeafNode(otherlv_17, grammarAccess.getMainFacplAccess().getCommaKeyword_8_2_1_0());
            	        
            	    // InternalFacpl2.g:434:1: ( (otherlv_18= RULE_ID ) )
            	    // InternalFacpl2.g:435:1: (otherlv_18= RULE_ID )
            	    {
            	    // InternalFacpl2.g:435:1: (otherlv_18= RULE_ID )
            	    // InternalFacpl2.g:436:3: otherlv_18= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getMainFacplRule());
            	    	        }
            	            
            	    otherlv_18=(Token)match(input,RULE_ID,FOLLOW_14); 

            	    		newLeafNode(otherlv_18, grammarAccess.getMainFacplAccess().getRefRequestRequestCrossReference_8_2_1_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            otherlv_19=(Token)match(input,20,FOLLOW_15); 

                	newLeafNode(otherlv_19, grammarAccess.getMainFacplAccess().getSemicolonKeyword_8_3());
                

            }

            // InternalFacpl2.g:451:2: ( (lv_paf_20_0= rulePAF ) )
            // InternalFacpl2.g:452:1: (lv_paf_20_0= rulePAF )
            {
            // InternalFacpl2.g:452:1: (lv_paf_20_0= rulePAF )
            // InternalFacpl2.g:453:3: lv_paf_20_0= rulePAF
            {
             
            	        newCompositeNode(grammarAccess.getMainFacplAccess().getPafPAFParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_16);
            lv_paf_20_0=rulePAF();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMainFacplRule());
            	        }
                   		set(
                   			current, 
                   			"paf",
                    		lv_paf_20_0, 
                    		"it.unifi.xtext.facpl.Facpl2.PAF");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_21=(Token)match(input,25,FOLLOW_2); 

                	newLeafNode(otherlv_21, grammarAccess.getMainFacplAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMainFacpl"


    // $ANTLR start "entryRuleFunctionDeclaration"
    // InternalFacpl2.g:481:1: entryRuleFunctionDeclaration returns [EObject current=null] : iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF ;
    public final EObject entryRuleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDeclaration = null;


        try {
            // InternalFacpl2.g:482:2: (iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF )
            // InternalFacpl2.g:483:2: iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getFunctionDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDeclaration=ruleFunctionDeclaration();

            state._fsp--;

             current =iv_ruleFunctionDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDeclaration"


    // $ANTLR start "ruleFunctionDeclaration"
    // InternalFacpl2.g:490:1: ruleFunctionDeclaration returns [EObject current=null] : (otherlv_0= 'dec-fun' ( (lv_type_1_0= ruleTypeLiteral ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_args_4_0= ruleTypeLiteral ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) ) )* otherlv_7= ')' ) ;
    public final EObject ruleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_type_1_0 = null;

        Enumerator lv_args_4_0 = null;

        Enumerator lv_args_6_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:493:28: ( (otherlv_0= 'dec-fun' ( (lv_type_1_0= ruleTypeLiteral ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_args_4_0= ruleTypeLiteral ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) ) )* otherlv_7= ')' ) )
            // InternalFacpl2.g:494:1: (otherlv_0= 'dec-fun' ( (lv_type_1_0= ruleTypeLiteral ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_args_4_0= ruleTypeLiteral ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) ) )* otherlv_7= ')' )
            {
            // InternalFacpl2.g:494:1: (otherlv_0= 'dec-fun' ( (lv_type_1_0= ruleTypeLiteral ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_args_4_0= ruleTypeLiteral ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) ) )* otherlv_7= ')' )
            // InternalFacpl2.g:494:3: otherlv_0= 'dec-fun' ( (lv_type_1_0= ruleTypeLiteral ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_args_4_0= ruleTypeLiteral ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) ) )* otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_17); 

                	newLeafNode(otherlv_0, grammarAccess.getFunctionDeclarationAccess().getDecFunKeyword_0());
                
            // InternalFacpl2.g:498:1: ( (lv_type_1_0= ruleTypeLiteral ) )
            // InternalFacpl2.g:499:1: (lv_type_1_0= ruleTypeLiteral )
            {
            // InternalFacpl2.g:499:1: (lv_type_1_0= ruleTypeLiteral )
            // InternalFacpl2.g:500:3: lv_type_1_0= ruleTypeLiteral
            {
             
            	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getTypeTypeLiteralEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_13);
            lv_type_1_0=ruleTypeLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"it.unifi.xtext.facpl.Facpl2.TypeLiteral");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalFacpl2.g:516:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalFacpl2.g:517:1: (lv_name_2_0= RULE_ID )
            {
            // InternalFacpl2.g:517:1: (lv_name_2_0= RULE_ID )
            // InternalFacpl2.g:518:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            			newLeafNode(lv_name_2_0, grammarAccess.getFunctionDeclarationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_17); 

                	newLeafNode(otherlv_3, grammarAccess.getFunctionDeclarationAccess().getLeftParenthesisKeyword_3());
                
            // InternalFacpl2.g:538:1: ( (lv_args_4_0= ruleTypeLiteral ) )
            // InternalFacpl2.g:539:1: (lv_args_4_0= ruleTypeLiteral )
            {
            // InternalFacpl2.g:539:1: (lv_args_4_0= ruleTypeLiteral )
            // InternalFacpl2.g:540:3: lv_args_4_0= ruleTypeLiteral
            {
             
            	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getArgsTypeLiteralEnumRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_19);
            lv_args_4_0=ruleTypeLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
            	        }
                   		add(
                   			current, 
                   			"args",
                    		lv_args_4_0, 
                    		"it.unifi.xtext.facpl.Facpl2.TypeLiteral");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalFacpl2.g:556:2: (otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==24) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalFacpl2.g:556:4: otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) )
            	    {
            	    otherlv_5=(Token)match(input,24,FOLLOW_17); 

            	        	newLeafNode(otherlv_5, grammarAccess.getFunctionDeclarationAccess().getCommaKeyword_5_0());
            	        
            	    // InternalFacpl2.g:560:1: ( (lv_args_6_0= ruleTypeLiteral ) )
            	    // InternalFacpl2.g:561:1: (lv_args_6_0= ruleTypeLiteral )
            	    {
            	    // InternalFacpl2.g:561:1: (lv_args_6_0= ruleTypeLiteral )
            	    // InternalFacpl2.g:562:3: lv_args_6_0= ruleTypeLiteral
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getArgsTypeLiteralEnumRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_19);
            	    lv_args_6_0=ruleTypeLiteral();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"args",
            	            		lv_args_6_0, 
            	            		"it.unifi.xtext.facpl.Facpl2.TypeLiteral");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_7=(Token)match(input,28,FOLLOW_2); 

                	newLeafNode(otherlv_7, grammarAccess.getFunctionDeclarationAccess().getRightParenthesisKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDeclaration"


    // $ANTLR start "entryRulePAF"
    // InternalFacpl2.g:590:1: entryRulePAF returns [EObject current=null] : iv_rulePAF= rulePAF EOF ;
    public final EObject entryRulePAF() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAF = null;


        try {
            // InternalFacpl2.g:591:2: (iv_rulePAF= rulePAF EOF )
            // InternalFacpl2.g:592:2: iv_rulePAF= rulePAF EOF
            {
             newCompositeNode(grammarAccess.getPAFRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePAF=rulePAF();

            state._fsp--;

             current =iv_rulePAF; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePAF"


    // $ANTLR start "rulePAF"
    // InternalFacpl2.g:599:1: rulePAF returns [EObject current=null] : (otherlv_0= 'pep:' ( (lv_pep_1_0= rulePEPAlg ) ) otherlv_2= 'pdp:' ( (lv_pdp_3_0= rulePDP ) ) ) ;
    public final EObject rulePAF() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_pep_1_0 = null;

        EObject lv_pdp_3_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:602:28: ( (otherlv_0= 'pep:' ( (lv_pep_1_0= rulePEPAlg ) ) otherlv_2= 'pdp:' ( (lv_pdp_3_0= rulePDP ) ) ) )
            // InternalFacpl2.g:603:1: (otherlv_0= 'pep:' ( (lv_pep_1_0= rulePEPAlg ) ) otherlv_2= 'pdp:' ( (lv_pdp_3_0= rulePDP ) ) )
            {
            // InternalFacpl2.g:603:1: (otherlv_0= 'pep:' ( (lv_pep_1_0= rulePEPAlg ) ) otherlv_2= 'pdp:' ( (lv_pdp_3_0= rulePDP ) ) )
            // InternalFacpl2.g:603:3: otherlv_0= 'pep:' ( (lv_pep_1_0= rulePEPAlg ) ) otherlv_2= 'pdp:' ( (lv_pdp_3_0= rulePDP ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_20); 

                	newLeafNode(otherlv_0, grammarAccess.getPAFAccess().getPepKeyword_0());
                
            // InternalFacpl2.g:607:1: ( (lv_pep_1_0= rulePEPAlg ) )
            // InternalFacpl2.g:608:1: (lv_pep_1_0= rulePEPAlg )
            {
            // InternalFacpl2.g:608:1: (lv_pep_1_0= rulePEPAlg )
            // InternalFacpl2.g:609:3: lv_pep_1_0= rulePEPAlg
            {
             
            	        newCompositeNode(grammarAccess.getPAFAccess().getPepPEPAlgEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_21);
            lv_pep_1_0=rulePEPAlg();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPAFRule());
            	        }
                   		set(
                   			current, 
                   			"pep",
                    		lv_pep_1_0, 
                    		"it.unifi.xtext.facpl.Facpl2.PEPAlg");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,30,FOLLOW_22); 

                	newLeafNode(otherlv_2, grammarAccess.getPAFAccess().getPdpKeyword_2());
                
            // InternalFacpl2.g:629:1: ( (lv_pdp_3_0= rulePDP ) )
            // InternalFacpl2.g:630:1: (lv_pdp_3_0= rulePDP )
            {
            // InternalFacpl2.g:630:1: (lv_pdp_3_0= rulePDP )
            // InternalFacpl2.g:631:3: lv_pdp_3_0= rulePDP
            {
             
            	        newCompositeNode(grammarAccess.getPAFAccess().getPdpPDPParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_pdp_3_0=rulePDP();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPAFRule());
            	        }
                   		set(
                   			current, 
                   			"pdp",
                    		lv_pdp_3_0, 
                    		"it.unifi.xtext.facpl.Facpl2.PDP");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePAF"


    // $ANTLR start "entryRuleRequest"
    // InternalFacpl2.g:655:1: entryRuleRequest returns [EObject current=null] : iv_ruleRequest= ruleRequest EOF ;
    public final EObject entryRuleRequest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequest = null;


        try {
            // InternalFacpl2.g:656:2: (iv_ruleRequest= ruleRequest EOF )
            // InternalFacpl2.g:657:2: iv_ruleRequest= ruleRequest EOF
            {
             newCompositeNode(grammarAccess.getRequestRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRequest=ruleRequest();

            state._fsp--;

             current =iv_ruleRequest; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequest"


    // $ANTLR start "ruleRequest"
    // InternalFacpl2.g:664:1: ruleRequest returns [EObject current=null] : (otherlv_0= 'Request:' (otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_name_5_0= RULE_ID ) ) ( (lv_attributes_6_0= ruleAttributeReq ) )+ otherlv_7= '}' ) ;
    public final EObject ruleRequest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_stub_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;
        Token otherlv_7=null;
        EObject lv_attributes_6_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:667:28: ( (otherlv_0= 'Request:' (otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_name_5_0= RULE_ID ) ) ( (lv_attributes_6_0= ruleAttributeReq ) )+ otherlv_7= '}' ) )
            // InternalFacpl2.g:668:1: (otherlv_0= 'Request:' (otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_name_5_0= RULE_ID ) ) ( (lv_attributes_6_0= ruleAttributeReq ) )+ otherlv_7= '}' )
            {
            // InternalFacpl2.g:668:1: (otherlv_0= 'Request:' (otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_name_5_0= RULE_ID ) ) ( (lv_attributes_6_0= ruleAttributeReq ) )+ otherlv_7= '}' )
            // InternalFacpl2.g:668:3: otherlv_0= 'Request:' (otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_name_5_0= RULE_ID ) ) ( (lv_attributes_6_0= ruleAttributeReq ) )+ otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_23); 

                	newLeafNode(otherlv_0, grammarAccess.getRequestAccess().getRequestKeyword_0());
                
            // InternalFacpl2.g:672:1: (otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==32) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalFacpl2.g:672:3: otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_4); 

                        	newLeafNode(otherlv_1, grammarAccess.getRequestAccess().getLeftSquareBracketKeyword_1_0());
                        
                    // InternalFacpl2.g:676:1: ( (lv_stub_2_0= RULE_STRING ) )
                    // InternalFacpl2.g:677:1: (lv_stub_2_0= RULE_STRING )
                    {
                    // InternalFacpl2.g:677:1: (lv_stub_2_0= RULE_STRING )
                    // InternalFacpl2.g:678:3: lv_stub_2_0= RULE_STRING
                    {
                    lv_stub_2_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

                    			newLeafNode(lv_stub_2_0, grammarAccess.getRequestAccess().getStubSTRINGTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRequestRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"stub",
                            		lv_stub_2_0, 
                            		"it.unifi.xtext.facpl.Facpl2.STRING");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,33,FOLLOW_5); 

                        	newLeafNode(otherlv_3, grammarAccess.getRequestAccess().getRightSquareBracketKeyword_1_2());
                        

                    }
                    break;

            }

            otherlv_4=(Token)match(input,17,FOLLOW_13); 

                	newLeafNode(otherlv_4, grammarAccess.getRequestAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalFacpl2.g:702:1: ( (lv_name_5_0= RULE_ID ) )
            // InternalFacpl2.g:703:1: (lv_name_5_0= RULE_ID )
            {
            // InternalFacpl2.g:703:1: (lv_name_5_0= RULE_ID )
            // InternalFacpl2.g:704:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            			newLeafNode(lv_name_5_0, grammarAccess.getRequestAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRequestRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_5_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalFacpl2.g:720:2: ( (lv_attributes_6_0= ruleAttributeReq ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==27) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalFacpl2.g:721:1: (lv_attributes_6_0= ruleAttributeReq )
            	    {
            	    // InternalFacpl2.g:721:1: (lv_attributes_6_0= ruleAttributeReq )
            	    // InternalFacpl2.g:722:3: lv_attributes_6_0= ruleAttributeReq
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequestAccess().getAttributesAttributeReqParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_25);
            	    lv_attributes_6_0=ruleAttributeReq();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_6_0, 
            	            		"it.unifi.xtext.facpl.Facpl2.AttributeReq");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            otherlv_7=(Token)match(input,25,FOLLOW_2); 

                	newLeafNode(otherlv_7, grammarAccess.getRequestAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequest"


    // $ANTLR start "entryRuleAttributeReq"
    // InternalFacpl2.g:750:1: entryRuleAttributeReq returns [EObject current=null] : iv_ruleAttributeReq= ruleAttributeReq EOF ;
    public final EObject entryRuleAttributeReq() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeReq = null;


        try {
            // InternalFacpl2.g:751:2: (iv_ruleAttributeReq= ruleAttributeReq EOF )
            // InternalFacpl2.g:752:2: iv_ruleAttributeReq= ruleAttributeReq EOF
            {
             newCompositeNode(grammarAccess.getAttributeReqRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeReq=ruleAttributeReq();

            state._fsp--;

             current =iv_ruleAttributeReq; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeReq"


    // $ANTLR start "ruleAttributeReq"
    // InternalFacpl2.g:759:1: ruleAttributeReq returns [EObject current=null] : (otherlv_0= '(' ( (lv_name_1_0= ruleAttributeName ) ) otherlv_2= ',' ( (lv_value_3_0= ruleLiterals ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) ) )* otherlv_6= ')' ) ;
    public final EObject ruleAttributeReq() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_name_1_0 = null;

        EObject lv_value_3_0 = null;

        EObject lv_value_5_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:762:28: ( (otherlv_0= '(' ( (lv_name_1_0= ruleAttributeName ) ) otherlv_2= ',' ( (lv_value_3_0= ruleLiterals ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) ) )* otherlv_6= ')' ) )
            // InternalFacpl2.g:763:1: (otherlv_0= '(' ( (lv_name_1_0= ruleAttributeName ) ) otherlv_2= ',' ( (lv_value_3_0= ruleLiterals ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) ) )* otherlv_6= ')' )
            {
            // InternalFacpl2.g:763:1: (otherlv_0= '(' ( (lv_name_1_0= ruleAttributeName ) ) otherlv_2= ',' ( (lv_value_3_0= ruleLiterals ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) ) )* otherlv_6= ')' )
            // InternalFacpl2.g:763:3: otherlv_0= '(' ( (lv_name_1_0= ruleAttributeName ) ) otherlv_2= ',' ( (lv_value_3_0= ruleLiterals ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) ) )* otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_13); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeReqAccess().getLeftParenthesisKeyword_0());
                
            // InternalFacpl2.g:767:1: ( (lv_name_1_0= ruleAttributeName ) )
            // InternalFacpl2.g:768:1: (lv_name_1_0= ruleAttributeName )
            {
            // InternalFacpl2.g:768:1: (lv_name_1_0= ruleAttributeName )
            // InternalFacpl2.g:769:3: lv_name_1_0= ruleAttributeName
            {
             
            	        newCompositeNode(grammarAccess.getAttributeReqAccess().getNameAttributeNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_26);
            lv_name_1_0=ruleAttributeName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeReqRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"it.unifi.xtext.facpl.Facpl2.AttributeName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_27); 

                	newLeafNode(otherlv_2, grammarAccess.getAttributeReqAccess().getCommaKeyword_2());
                
            // InternalFacpl2.g:789:1: ( (lv_value_3_0= ruleLiterals ) )
            // InternalFacpl2.g:790:1: (lv_value_3_0= ruleLiterals )
            {
            // InternalFacpl2.g:790:1: (lv_value_3_0= ruleLiterals )
            // InternalFacpl2.g:791:3: lv_value_3_0= ruleLiterals
            {
             
            	        newCompositeNode(grammarAccess.getAttributeReqAccess().getValueLiteralsParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_19);
            lv_value_3_0=ruleLiterals();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeReqRule());
            	        }
                   		add(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"it.unifi.xtext.facpl.Facpl2.Literals");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalFacpl2.g:807:2: (otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==24) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalFacpl2.g:807:4: otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) )
            	    {
            	    otherlv_4=(Token)match(input,24,FOLLOW_27); 

            	        	newLeafNode(otherlv_4, grammarAccess.getAttributeReqAccess().getCommaKeyword_4_0());
            	        
            	    // InternalFacpl2.g:811:1: ( (lv_value_5_0= ruleLiterals ) )
            	    // InternalFacpl2.g:812:1: (lv_value_5_0= ruleLiterals )
            	    {
            	    // InternalFacpl2.g:812:1: (lv_value_5_0= ruleLiterals )
            	    // InternalFacpl2.g:813:3: lv_value_5_0= ruleLiterals
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAttributeReqAccess().getValueLiteralsParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_19);
            	    lv_value_5_0=ruleLiterals();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAttributeReqRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"value",
            	            		lv_value_5_0, 
            	            		"it.unifi.xtext.facpl.Facpl2.Literals");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_6=(Token)match(input,28,FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getAttributeReqAccess().getRightParenthesisKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeReq"


    // $ANTLR start "entryRuleAttributeName"
    // InternalFacpl2.g:841:1: entryRuleAttributeName returns [EObject current=null] : iv_ruleAttributeName= ruleAttributeName EOF ;
    public final EObject entryRuleAttributeName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeName = null;


        try {
            // InternalFacpl2.g:842:2: (iv_ruleAttributeName= ruleAttributeName EOF )
            // InternalFacpl2.g:843:2: iv_ruleAttributeName= ruleAttributeName EOF
            {
             newCompositeNode(grammarAccess.getAttributeNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeName=ruleAttributeName();

            state._fsp--;

             current =iv_ruleAttributeName; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeName"


    // $ANTLR start "ruleAttributeName"
    // InternalFacpl2.g:850:1: ruleAttributeName returns [EObject current=null] : ( ( (lv_category_0_0= ruleSTRING_O ) ) otherlv_1= '/' ( (lv_id_2_0= ruleSTRING_O ) ) ) ;
    public final EObject ruleAttributeName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        AntlrDatatypeRuleToken lv_id_2_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:853:28: ( ( ( (lv_category_0_0= ruleSTRING_O ) ) otherlv_1= '/' ( (lv_id_2_0= ruleSTRING_O ) ) ) )
            // InternalFacpl2.g:854:1: ( ( (lv_category_0_0= ruleSTRING_O ) ) otherlv_1= '/' ( (lv_id_2_0= ruleSTRING_O ) ) )
            {
            // InternalFacpl2.g:854:1: ( ( (lv_category_0_0= ruleSTRING_O ) ) otherlv_1= '/' ( (lv_id_2_0= ruleSTRING_O ) ) )
            // InternalFacpl2.g:854:2: ( (lv_category_0_0= ruleSTRING_O ) ) otherlv_1= '/' ( (lv_id_2_0= ruleSTRING_O ) )
            {
            // InternalFacpl2.g:854:2: ( (lv_category_0_0= ruleSTRING_O ) )
            // InternalFacpl2.g:855:1: (lv_category_0_0= ruleSTRING_O )
            {
            // InternalFacpl2.g:855:1: (lv_category_0_0= ruleSTRING_O )
            // InternalFacpl2.g:856:3: lv_category_0_0= ruleSTRING_O
            {
             
            	        newCompositeNode(grammarAccess.getAttributeNameAccess().getCategorySTRING_OParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_28);
            lv_category_0_0=ruleSTRING_O();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeNameRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_0_0, 
                    		"it.unifi.xtext.facpl.Facpl2.STRING_O");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,34,FOLLOW_13); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeNameAccess().getSolidusKeyword_1());
                
            // InternalFacpl2.g:876:1: ( (lv_id_2_0= ruleSTRING_O ) )
            // InternalFacpl2.g:877:1: (lv_id_2_0= ruleSTRING_O )
            {
            // InternalFacpl2.g:877:1: (lv_id_2_0= ruleSTRING_O )
            // InternalFacpl2.g:878:3: lv_id_2_0= ruleSTRING_O
            {
             
            	        newCompositeNode(grammarAccess.getAttributeNameAccess().getIdSTRING_OParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_id_2_0=ruleSTRING_O();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeNameRule());
            	        }
                   		set(
                   			current, 
                   			"id",
                    		lv_id_2_0, 
                    		"it.unifi.xtext.facpl.Facpl2.STRING_O");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeName"


    // $ANTLR start "entryRuleSTRING_O"
    // InternalFacpl2.g:902:1: entryRuleSTRING_O returns [String current=null] : iv_ruleSTRING_O= ruleSTRING_O EOF ;
    public final String entryRuleSTRING_O() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTRING_O = null;


        try {
            // InternalFacpl2.g:903:2: (iv_ruleSTRING_O= ruleSTRING_O EOF )
            // InternalFacpl2.g:904:2: iv_ruleSTRING_O= ruleSTRING_O EOF
            {
             newCompositeNode(grammarAccess.getSTRING_ORule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSTRING_O=ruleSTRING_O();

            state._fsp--;

             current =iv_ruleSTRING_O.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTRING_O"


    // $ANTLR start "ruleSTRING_O"
    // InternalFacpl2.g:911:1: ruleSTRING_O returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleSTRING_O() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:914:28: ( (this_ID_0= RULE_ID ( (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID )* ) )
            // InternalFacpl2.g:915:1: (this_ID_0= RULE_ID ( (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID )* )
            {
            // InternalFacpl2.g:915:1: (this_ID_0= RULE_ID ( (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID )* )
            // InternalFacpl2.g:915:6: this_ID_0= RULE_ID ( (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_29); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getSTRING_OAccess().getIDTerminalRuleCall_0()); 
                
            // InternalFacpl2.g:922:1: ( (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==19||(LA14_0>=35 && LA14_0<=37)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalFacpl2.g:922:2: (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID
            	    {
            	    // InternalFacpl2.g:922:2: (kw= ':' | kw= '_' | kw= '-' | kw= '.' )
            	    int alt13=4;
            	    switch ( input.LA(1) ) {
            	    case 19:
            	        {
            	        alt13=1;
            	        }
            	        break;
            	    case 35:
            	        {
            	        alt13=2;
            	        }
            	        break;
            	    case 36:
            	        {
            	        alt13=3;
            	        }
            	        break;
            	    case 37:
            	        {
            	        alt13=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 13, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt13) {
            	        case 1 :
            	            // InternalFacpl2.g:923:2: kw= ':'
            	            {
            	            kw=(Token)match(input,19,FOLLOW_13); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSTRING_OAccess().getColonKeyword_1_0_0()); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // InternalFacpl2.g:930:2: kw= '_'
            	            {
            	            kw=(Token)match(input,35,FOLLOW_13); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSTRING_OAccess().get_Keyword_1_0_1()); 
            	                

            	            }
            	            break;
            	        case 3 :
            	            // InternalFacpl2.g:937:2: kw= '-'
            	            {
            	            kw=(Token)match(input,36,FOLLOW_13); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSTRING_OAccess().getHyphenMinusKeyword_1_0_2()); 
            	                

            	            }
            	            break;
            	        case 4 :
            	            // InternalFacpl2.g:944:2: kw= '.'
            	            {
            	            kw=(Token)match(input,37,FOLLOW_13); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSTRING_OAccess().getFullStopKeyword_1_0_3()); 
            	                

            	            }
            	            break;

            	    }

            	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_29); 

            	    		current.merge(this_ID_5);
            	        
            	     
            	        newLeafNode(this_ID_5, grammarAccess.getSTRING_OAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTRING_O"


    // $ANTLR start "entryRulePDP"
    // InternalFacpl2.g:964:1: entryRulePDP returns [EObject current=null] : iv_rulePDP= rulePDP EOF ;
    public final EObject entryRulePDP() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePDP = null;


        try {
            // InternalFacpl2.g:965:2: (iv_rulePDP= rulePDP EOF )
            // InternalFacpl2.g:966:2: iv_rulePDP= rulePDP EOF
            {
             newCompositeNode(grammarAccess.getPDPRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePDP=rulePDP();

            state._fsp--;

             current =iv_rulePDP; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePDP"


    // $ANTLR start "rulePDP"
    // InternalFacpl2.g:973:1: rulePDP returns [EObject current=null] : ( ( (lv_pdpAlg_0_0= ruleAlg ) ) ( (lv_polSet_1_0= ruleAbstractPolicyIncl ) )+ ) ;
    public final EObject rulePDP() throws RecognitionException {
        EObject current = null;

        EObject lv_pdpAlg_0_0 = null;

        EObject lv_polSet_1_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:976:28: ( ( ( (lv_pdpAlg_0_0= ruleAlg ) ) ( (lv_polSet_1_0= ruleAbstractPolicyIncl ) )+ ) )
            // InternalFacpl2.g:977:1: ( ( (lv_pdpAlg_0_0= ruleAlg ) ) ( (lv_polSet_1_0= ruleAbstractPolicyIncl ) )+ )
            {
            // InternalFacpl2.g:977:1: ( ( (lv_pdpAlg_0_0= ruleAlg ) ) ( (lv_polSet_1_0= ruleAbstractPolicyIncl ) )+ )
            // InternalFacpl2.g:977:2: ( (lv_pdpAlg_0_0= ruleAlg ) ) ( (lv_polSet_1_0= ruleAbstractPolicyIncl ) )+
            {
            // InternalFacpl2.g:977:2: ( (lv_pdpAlg_0_0= ruleAlg ) )
            // InternalFacpl2.g:978:1: (lv_pdpAlg_0_0= ruleAlg )
            {
            // InternalFacpl2.g:978:1: (lv_pdpAlg_0_0= ruleAlg )
            // InternalFacpl2.g:979:3: lv_pdpAlg_0_0= ruleAlg
            {
             
            	        newCompositeNode(grammarAccess.getPDPAccess().getPdpAlgAlgParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_30);
            lv_pdpAlg_0_0=ruleAlg();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPDPRule());
            	        }
                   		set(
                   			current, 
                   			"pdpAlg",
                    		lv_pdpAlg_0_0, 
                    		"it.unifi.xtext.facpl.Facpl2.Alg");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalFacpl2.g:995:2: ( (lv_polSet_1_0= ruleAbstractPolicyIncl ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=38 && LA15_0<=39)||LA15_0==44) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalFacpl2.g:996:1: (lv_polSet_1_0= ruleAbstractPolicyIncl )
            	    {
            	    // InternalFacpl2.g:996:1: (lv_polSet_1_0= ruleAbstractPolicyIncl )
            	    // InternalFacpl2.g:997:3: lv_polSet_1_0= ruleAbstractPolicyIncl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPDPAccess().getPolSetAbstractPolicyInclParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_31);
            	    lv_polSet_1_0=ruleAbstractPolicyIncl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPDPRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"polSet",
            	            		lv_polSet_1_0, 
            	            		"it.unifi.xtext.facpl.Facpl2.AbstractPolicyIncl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePDP"


    // $ANTLR start "entryRuleFacplPolicy"
    // InternalFacpl2.g:1021:1: entryRuleFacplPolicy returns [EObject current=null] : iv_ruleFacplPolicy= ruleFacplPolicy EOF ;
    public final EObject entryRuleFacplPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFacplPolicy = null;


        try {
            // InternalFacpl2.g:1022:2: (iv_ruleFacplPolicy= ruleFacplPolicy EOF )
            // InternalFacpl2.g:1023:2: iv_ruleFacplPolicy= ruleFacplPolicy EOF
            {
             newCompositeNode(grammarAccess.getFacplPolicyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFacplPolicy=ruleFacplPolicy();

            state._fsp--;

             current =iv_ruleFacplPolicy; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFacplPolicy"


    // $ANTLR start "ruleFacplPolicy"
    // InternalFacpl2.g:1030:1: ruleFacplPolicy returns [EObject current=null] : (this_PolicySet_0= rulePolicySet | this_Rule_1= ruleRule ) ;
    public final EObject ruleFacplPolicy() throws RecognitionException {
        EObject current = null;

        EObject this_PolicySet_0 = null;

        EObject this_Rule_1 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1033:28: ( (this_PolicySet_0= rulePolicySet | this_Rule_1= ruleRule ) )
            // InternalFacpl2.g:1034:1: (this_PolicySet_0= rulePolicySet | this_Rule_1= ruleRule )
            {
            // InternalFacpl2.g:1034:1: (this_PolicySet_0= rulePolicySet | this_Rule_1= ruleRule )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==39) ) {
                alt16=1;
            }
            else if ( (LA16_0==44) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalFacpl2.g:1035:5: this_PolicySet_0= rulePolicySet
                    {
                     
                            newCompositeNode(grammarAccess.getFacplPolicyAccess().getPolicySetParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_PolicySet_0=rulePolicySet();

                    state._fsp--;

                     
                            current = this_PolicySet_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:1045:5: this_Rule_1= ruleRule
                    {
                     
                            newCompositeNode(grammarAccess.getFacplPolicyAccess().getRuleParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Rule_1=ruleRule();

                    state._fsp--;

                     
                            current = this_Rule_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFacplPolicy"


    // $ANTLR start "entryRuleAbstractPolicyIncl"
    // InternalFacpl2.g:1061:1: entryRuleAbstractPolicyIncl returns [EObject current=null] : iv_ruleAbstractPolicyIncl= ruleAbstractPolicyIncl EOF ;
    public final EObject entryRuleAbstractPolicyIncl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractPolicyIncl = null;


        try {
            // InternalFacpl2.g:1062:2: (iv_ruleAbstractPolicyIncl= ruleAbstractPolicyIncl EOF )
            // InternalFacpl2.g:1063:2: iv_ruleAbstractPolicyIncl= ruleAbstractPolicyIncl EOF
            {
             newCompositeNode(grammarAccess.getAbstractPolicyInclRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractPolicyIncl=ruleAbstractPolicyIncl();

            state._fsp--;

             current =iv_ruleAbstractPolicyIncl; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractPolicyIncl"


    // $ANTLR start "ruleAbstractPolicyIncl"
    // InternalFacpl2.g:1070:1: ruleAbstractPolicyIncl returns [EObject current=null] : ( ( (lv_newPolicy_0_0= ruleFacplPolicy ) ) | (otherlv_1= 'include' ( (otherlv_2= RULE_ID ) ) ) ) ;
    public final EObject ruleAbstractPolicyIncl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_newPolicy_0_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1073:28: ( ( ( (lv_newPolicy_0_0= ruleFacplPolicy ) ) | (otherlv_1= 'include' ( (otherlv_2= RULE_ID ) ) ) ) )
            // InternalFacpl2.g:1074:1: ( ( (lv_newPolicy_0_0= ruleFacplPolicy ) ) | (otherlv_1= 'include' ( (otherlv_2= RULE_ID ) ) ) )
            {
            // InternalFacpl2.g:1074:1: ( ( (lv_newPolicy_0_0= ruleFacplPolicy ) ) | (otherlv_1= 'include' ( (otherlv_2= RULE_ID ) ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==39||LA17_0==44) ) {
                alt17=1;
            }
            else if ( (LA17_0==38) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalFacpl2.g:1074:2: ( (lv_newPolicy_0_0= ruleFacplPolicy ) )
                    {
                    // InternalFacpl2.g:1074:2: ( (lv_newPolicy_0_0= ruleFacplPolicy ) )
                    // InternalFacpl2.g:1075:1: (lv_newPolicy_0_0= ruleFacplPolicy )
                    {
                    // InternalFacpl2.g:1075:1: (lv_newPolicy_0_0= ruleFacplPolicy )
                    // InternalFacpl2.g:1076:3: lv_newPolicy_0_0= ruleFacplPolicy
                    {
                     
                    	        newCompositeNode(grammarAccess.getAbstractPolicyInclAccess().getNewPolicyFacplPolicyParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_newPolicy_0_0=ruleFacplPolicy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAbstractPolicyInclRule());
                    	        }
                           		set(
                           			current, 
                           			"newPolicy",
                            		lv_newPolicy_0_0, 
                            		"it.unifi.xtext.facpl.Facpl2.FacplPolicy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:1093:6: (otherlv_1= 'include' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalFacpl2.g:1093:6: (otherlv_1= 'include' ( (otherlv_2= RULE_ID ) ) )
                    // InternalFacpl2.g:1093:8: otherlv_1= 'include' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_13); 

                        	newLeafNode(otherlv_1, grammarAccess.getAbstractPolicyInclAccess().getIncludeKeyword_1_0());
                        
                    // InternalFacpl2.g:1097:1: ( (otherlv_2= RULE_ID ) )
                    // InternalFacpl2.g:1098:1: (otherlv_2= RULE_ID )
                    {
                    // InternalFacpl2.g:1098:1: (otherlv_2= RULE_ID )
                    // InternalFacpl2.g:1099:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAbstractPolicyInclRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		newLeafNode(otherlv_2, grammarAccess.getAbstractPolicyInclAccess().getRefPolPolicySetCrossReference_1_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractPolicyIncl"


    // $ANTLR start "entryRulePolicySet"
    // InternalFacpl2.g:1118:1: entryRulePolicySet returns [EObject current=null] : iv_rulePolicySet= rulePolicySet EOF ;
    public final EObject entryRulePolicySet() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePolicySet = null;


        try {
            // InternalFacpl2.g:1119:2: (iv_rulePolicySet= rulePolicySet EOF )
            // InternalFacpl2.g:1120:2: iv_rulePolicySet= rulePolicySet EOF
            {
             newCompositeNode(grammarAccess.getPolicySetRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePolicySet=rulePolicySet();

            state._fsp--;

             current =iv_rulePolicySet; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePolicySet"


    // $ANTLR start "rulePolicySet"
    // InternalFacpl2.g:1127:1: rulePolicySet returns [EObject current=null] : (otherlv_0= 'PolicySet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_polSetAlg_3_0= ruleAlg ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? otherlv_6= 'policies:' ( (lv_policies_7_0= ruleAbstractPolicyIncl ) )+ (otherlv_8= 'obl-p:' ( (lv_oblp_9_0= ruleObligation ) )* )? (otherlv_10= 'obl-d:' ( (lv_obld_11_0= ruleObligation ) )* )? otherlv_12= '}' ) ;
    public final EObject rulePolicySet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_polSetAlg_3_0 = null;

        EObject lv_target_5_0 = null;

        EObject lv_policies_7_0 = null;

        EObject lv_oblp_9_0 = null;

        EObject lv_obld_11_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1130:28: ( (otherlv_0= 'PolicySet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_polSetAlg_3_0= ruleAlg ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? otherlv_6= 'policies:' ( (lv_policies_7_0= ruleAbstractPolicyIncl ) )+ (otherlv_8= 'obl-p:' ( (lv_oblp_9_0= ruleObligation ) )* )? (otherlv_10= 'obl-d:' ( (lv_obld_11_0= ruleObligation ) )* )? otherlv_12= '}' ) )
            // InternalFacpl2.g:1131:1: (otherlv_0= 'PolicySet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_polSetAlg_3_0= ruleAlg ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? otherlv_6= 'policies:' ( (lv_policies_7_0= ruleAbstractPolicyIncl ) )+ (otherlv_8= 'obl-p:' ( (lv_oblp_9_0= ruleObligation ) )* )? (otherlv_10= 'obl-d:' ( (lv_obld_11_0= ruleObligation ) )* )? otherlv_12= '}' )
            {
            // InternalFacpl2.g:1131:1: (otherlv_0= 'PolicySet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_polSetAlg_3_0= ruleAlg ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? otherlv_6= 'policies:' ( (lv_policies_7_0= ruleAbstractPolicyIncl ) )+ (otherlv_8= 'obl-p:' ( (lv_oblp_9_0= ruleObligation ) )* )? (otherlv_10= 'obl-d:' ( (lv_obld_11_0= ruleObligation ) )* )? otherlv_12= '}' )
            // InternalFacpl2.g:1131:3: otherlv_0= 'PolicySet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_polSetAlg_3_0= ruleAlg ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? otherlv_6= 'policies:' ( (lv_policies_7_0= ruleAbstractPolicyIncl ) )+ (otherlv_8= 'obl-p:' ( (lv_oblp_9_0= ruleObligation ) )* )? (otherlv_10= 'obl-d:' ( (lv_obld_11_0= ruleObligation ) )* )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_13); 

                	newLeafNode(otherlv_0, grammarAccess.getPolicySetAccess().getPolicySetKeyword_0());
                
            // InternalFacpl2.g:1135:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalFacpl2.g:1136:1: (lv_name_1_0= RULE_ID )
            {
            // InternalFacpl2.g:1136:1: (lv_name_1_0= RULE_ID )
            // InternalFacpl2.g:1137:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPolicySetAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPolicySetRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_22); 

                	newLeafNode(otherlv_2, grammarAccess.getPolicySetAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalFacpl2.g:1157:1: ( (lv_polSetAlg_3_0= ruleAlg ) )
            // InternalFacpl2.g:1158:1: (lv_polSetAlg_3_0= ruleAlg )
            {
            // InternalFacpl2.g:1158:1: (lv_polSetAlg_3_0= ruleAlg )
            // InternalFacpl2.g:1159:3: lv_polSetAlg_3_0= ruleAlg
            {
             
            	        newCompositeNode(grammarAccess.getPolicySetAccess().getPolSetAlgAlgParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_32);
            lv_polSetAlg_3_0=ruleAlg();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPolicySetRule());
            	        }
                   		set(
                   			current, 
                   			"polSetAlg",
                    		lv_polSetAlg_3_0, 
                    		"it.unifi.xtext.facpl.Facpl2.Alg");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalFacpl2.g:1175:2: (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==40) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalFacpl2.g:1175:4: otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,40,FOLLOW_33); 

                        	newLeafNode(otherlv_4, grammarAccess.getPolicySetAccess().getTargetKeyword_4_0());
                        
                    // InternalFacpl2.g:1179:1: ( (lv_target_5_0= ruleExpression ) )
                    // InternalFacpl2.g:1180:1: (lv_target_5_0= ruleExpression )
                    {
                    // InternalFacpl2.g:1180:1: (lv_target_5_0= ruleExpression )
                    // InternalFacpl2.g:1181:3: lv_target_5_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPolicySetAccess().getTargetExpressionParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_34);
                    lv_target_5_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPolicySetRule());
                    	        }
                           		set(
                           			current, 
                           			"target",
                            		lv_target_5_0, 
                            		"it.unifi.xtext.facpl.Facpl2.Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,41,FOLLOW_30); 

                	newLeafNode(otherlv_6, grammarAccess.getPolicySetAccess().getPoliciesKeyword_5());
                
            // InternalFacpl2.g:1201:1: ( (lv_policies_7_0= ruleAbstractPolicyIncl ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=38 && LA19_0<=39)||LA19_0==44) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalFacpl2.g:1202:1: (lv_policies_7_0= ruleAbstractPolicyIncl )
            	    {
            	    // InternalFacpl2.g:1202:1: (lv_policies_7_0= ruleAbstractPolicyIncl )
            	    // InternalFacpl2.g:1203:3: lv_policies_7_0= ruleAbstractPolicyIncl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPolicySetAccess().getPoliciesAbstractPolicyInclParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_35);
            	    lv_policies_7_0=ruleAbstractPolicyIncl();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPolicySetRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"policies",
            	            		lv_policies_7_0, 
            	            		"it.unifi.xtext.facpl.Facpl2.AbstractPolicyIncl");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            // InternalFacpl2.g:1219:3: (otherlv_8= 'obl-p:' ( (lv_oblp_9_0= ruleObligation ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==42) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalFacpl2.g:1219:5: otherlv_8= 'obl-p:' ( (lv_oblp_9_0= ruleObligation ) )*
                    {
                    otherlv_8=(Token)match(input,42,FOLLOW_36); 

                        	newLeafNode(otherlv_8, grammarAccess.getPolicySetAccess().getOblPKeyword_7_0());
                        
                    // InternalFacpl2.g:1223:1: ( (lv_oblp_9_0= ruleObligation ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==32) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalFacpl2.g:1224:1: (lv_oblp_9_0= ruleObligation )
                    	    {
                    	    // InternalFacpl2.g:1224:1: (lv_oblp_9_0= ruleObligation )
                    	    // InternalFacpl2.g:1225:3: lv_oblp_9_0= ruleObligation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPolicySetAccess().getOblpObligationParserRuleCall_7_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_36);
                    	    lv_oblp_9_0=ruleObligation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPolicySetRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"oblp",
                    	            		lv_oblp_9_0, 
                    	            		"it.unifi.xtext.facpl.Facpl2.Obligation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalFacpl2.g:1241:5: (otherlv_10= 'obl-d:' ( (lv_obld_11_0= ruleObligation ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==43) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalFacpl2.g:1241:7: otherlv_10= 'obl-d:' ( (lv_obld_11_0= ruleObligation ) )*
                    {
                    otherlv_10=(Token)match(input,43,FOLLOW_37); 

                        	newLeafNode(otherlv_10, grammarAccess.getPolicySetAccess().getOblDKeyword_8_0());
                        
                    // InternalFacpl2.g:1245:1: ( (lv_obld_11_0= ruleObligation ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==32) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalFacpl2.g:1246:1: (lv_obld_11_0= ruleObligation )
                    	    {
                    	    // InternalFacpl2.g:1246:1: (lv_obld_11_0= ruleObligation )
                    	    // InternalFacpl2.g:1247:3: lv_obld_11_0= ruleObligation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPolicySetAccess().getObldObligationParserRuleCall_8_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_37);
                    	    lv_obld_11_0=ruleObligation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPolicySetRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"obld",
                    	            		lv_obld_11_0, 
                    	            		"it.unifi.xtext.facpl.Facpl2.Obligation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,25,FOLLOW_2); 

                	newLeafNode(otherlv_12, grammarAccess.getPolicySetAccess().getRightCurlyBracketKeyword_9());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePolicySet"


    // $ANTLR start "entryRuleAlg"
    // InternalFacpl2.g:1275:1: entryRuleAlg returns [EObject current=null] : iv_ruleAlg= ruleAlg EOF ;
    public final EObject entryRuleAlg() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlg = null;


        try {
            // InternalFacpl2.g:1276:2: (iv_ruleAlg= ruleAlg EOF )
            // InternalFacpl2.g:1277:2: iv_ruleAlg= ruleAlg EOF
            {
             newCompositeNode(grammarAccess.getAlgRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlg=ruleAlg();

            state._fsp--;

             current =iv_ruleAlg; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlg"


    // $ANTLR start "ruleAlg"
    // InternalFacpl2.g:1284:1: ruleAlg returns [EObject current=null] : ( ( (lv_idAlg_0_0= ruleAlgLiteral ) ) (otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) ) )? ) ;
    public final EObject ruleAlg() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_idAlg_0_0 = null;

        Enumerator lv_fStrategy_2_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1287:28: ( ( ( (lv_idAlg_0_0= ruleAlgLiteral ) ) (otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) ) )? ) )
            // InternalFacpl2.g:1288:1: ( ( (lv_idAlg_0_0= ruleAlgLiteral ) ) (otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) ) )? )
            {
            // InternalFacpl2.g:1288:1: ( ( (lv_idAlg_0_0= ruleAlgLiteral ) ) (otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) ) )? )
            // InternalFacpl2.g:1288:2: ( (lv_idAlg_0_0= ruleAlgLiteral ) ) (otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) ) )?
            {
            // InternalFacpl2.g:1288:2: ( (lv_idAlg_0_0= ruleAlgLiteral ) )
            // InternalFacpl2.g:1289:1: (lv_idAlg_0_0= ruleAlgLiteral )
            {
            // InternalFacpl2.g:1289:1: (lv_idAlg_0_0= ruleAlgLiteral )
            // InternalFacpl2.g:1290:3: lv_idAlg_0_0= ruleAlgLiteral
            {
             
            	        newCompositeNode(grammarAccess.getAlgAccess().getIdAlgAlgLiteralEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_38);
            lv_idAlg_0_0=ruleAlgLiteral();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAlgRule());
            	        }
                   		set(
                   			current, 
                   			"idAlg",
                    		lv_idAlg_0_0, 
                    		"it.unifi.xtext.facpl.Facpl2.AlgLiteral");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalFacpl2.g:1306:2: (otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==36) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalFacpl2.g:1306:4: otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) )
                    {
                    otherlv_1=(Token)match(input,36,FOLLOW_39); 

                        	newLeafNode(otherlv_1, grammarAccess.getAlgAccess().getHyphenMinusKeyword_1_0());
                        
                    // InternalFacpl2.g:1310:1: ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) )
                    // InternalFacpl2.g:1311:1: (lv_fStrategy_2_0= ruleFulfillmentStrategy )
                    {
                    // InternalFacpl2.g:1311:1: (lv_fStrategy_2_0= ruleFulfillmentStrategy )
                    // InternalFacpl2.g:1312:3: lv_fStrategy_2_0= ruleFulfillmentStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getAlgAccess().getFStrategyFulfillmentStrategyEnumRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_fStrategy_2_0=ruleFulfillmentStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAlgRule());
                    	        }
                           		set(
                           			current, 
                           			"fStrategy",
                            		lv_fStrategy_2_0, 
                            		"it.unifi.xtext.facpl.Facpl2.FulfillmentStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlg"


    // $ANTLR start "entryRuleRule"
    // InternalFacpl2.g:1336:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalFacpl2.g:1337:2: (iv_ruleRule= ruleRule EOF )
            // InternalFacpl2.g:1338:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalFacpl2.g:1345:1: ruleRule returns [EObject current=null] : (otherlv_0= 'Rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_effect_3_0= ruleEffect ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? (otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )* )? otherlv_8= ')' ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Enumerator lv_effect_3_0 = null;

        EObject lv_target_5_0 = null;

        EObject lv_obl_7_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1348:28: ( (otherlv_0= 'Rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_effect_3_0= ruleEffect ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? (otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )* )? otherlv_8= ')' ) )
            // InternalFacpl2.g:1349:1: (otherlv_0= 'Rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_effect_3_0= ruleEffect ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? (otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )* )? otherlv_8= ')' )
            {
            // InternalFacpl2.g:1349:1: (otherlv_0= 'Rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_effect_3_0= ruleEffect ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? (otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )* )? otherlv_8= ')' )
            // InternalFacpl2.g:1349:3: otherlv_0= 'Rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_effect_3_0= ruleEffect ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? (otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )* )? otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_13); 

                	newLeafNode(otherlv_0, grammarAccess.getRuleAccess().getRuleKeyword_0());
                
            // InternalFacpl2.g:1353:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalFacpl2.g:1354:1: (lv_name_1_0= RULE_ID )
            {
            // InternalFacpl2.g:1354:1: (lv_name_1_0= RULE_ID )
            // InternalFacpl2.g:1355:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_40); 

                	newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getLeftParenthesisKeyword_2());
                
            // InternalFacpl2.g:1375:1: ( (lv_effect_3_0= ruleEffect ) )
            // InternalFacpl2.g:1376:1: (lv_effect_3_0= ruleEffect )
            {
            // InternalFacpl2.g:1376:1: (lv_effect_3_0= ruleEffect )
            // InternalFacpl2.g:1377:3: lv_effect_3_0= ruleEffect
            {
             
            	        newCompositeNode(grammarAccess.getRuleAccess().getEffectEffectEnumRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_41);
            lv_effect_3_0=ruleEffect();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRuleRule());
            	        }
                   		set(
                   			current, 
                   			"effect",
                    		lv_effect_3_0, 
                    		"it.unifi.xtext.facpl.Facpl2.Effect");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalFacpl2.g:1393:2: (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==40) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalFacpl2.g:1393:4: otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,40,FOLLOW_33); 

                        	newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getTargetKeyword_4_0());
                        
                    // InternalFacpl2.g:1397:1: ( (lv_target_5_0= ruleExpression ) )
                    // InternalFacpl2.g:1398:1: (lv_target_5_0= ruleExpression )
                    {
                    // InternalFacpl2.g:1398:1: (lv_target_5_0= ruleExpression )
                    // InternalFacpl2.g:1399:3: lv_target_5_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleAccess().getTargetExpressionParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_42);
                    lv_target_5_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleRule());
                    	        }
                           		set(
                           			current, 
                           			"target",
                            		lv_target_5_0, 
                            		"it.unifi.xtext.facpl.Facpl2.Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalFacpl2.g:1415:4: (otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==45) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalFacpl2.g:1415:6: otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )*
                    {
                    otherlv_6=(Token)match(input,45,FOLLOW_43); 

                        	newLeafNode(otherlv_6, grammarAccess.getRuleAccess().getOblKeyword_5_0());
                        
                    // InternalFacpl2.g:1419:1: ( (lv_obl_7_0= ruleObligation ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==32) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalFacpl2.g:1420:1: (lv_obl_7_0= ruleObligation )
                    	    {
                    	    // InternalFacpl2.g:1420:1: (lv_obl_7_0= ruleObligation )
                    	    // InternalFacpl2.g:1421:3: lv_obl_7_0= ruleObligation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRuleAccess().getOblObligationParserRuleCall_5_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_43);
                    	    lv_obl_7_0=ruleObligation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getRuleRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"obl",
                    	            		lv_obl_7_0, 
                    	            		"it.unifi.xtext.facpl.Facpl2.Obligation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,28,FOLLOW_2); 

                	newLeafNode(otherlv_8, grammarAccess.getRuleAccess().getRightParenthesisKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleObligation"
    // InternalFacpl2.g:1449:1: entryRuleObligation returns [EObject current=null] : iv_ruleObligation= ruleObligation EOF ;
    public final EObject entryRuleObligation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligation = null;


        try {
            // InternalFacpl2.g:1450:2: (iv_ruleObligation= ruleObligation EOF )
            // InternalFacpl2.g:1451:2: iv_ruleObligation= ruleObligation EOF
            {
             newCompositeNode(grammarAccess.getObligationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObligation=ruleObligation();

            state._fsp--;

             current =iv_ruleObligation; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObligation"


    // $ANTLR start "ruleObligation"
    // InternalFacpl2.g:1458:1: ruleObligation returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_typeObl_1_1= 'M' | lv_typeObl_1_2= 'O' ) ) ) ( (lv_pepAction_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_expr_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) ) )* )* otherlv_7= ')' otherlv_8= ']' ) ;
    public final EObject ruleObligation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_typeObl_1_1=null;
        Token lv_typeObl_1_2=null;
        Token lv_pepAction_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_expr_4_0 = null;

        EObject lv_expr_6_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1461:28: ( (otherlv_0= '[' ( ( (lv_typeObl_1_1= 'M' | lv_typeObl_1_2= 'O' ) ) ) ( (lv_pepAction_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_expr_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) ) )* )* otherlv_7= ')' otherlv_8= ']' ) )
            // InternalFacpl2.g:1462:1: (otherlv_0= '[' ( ( (lv_typeObl_1_1= 'M' | lv_typeObl_1_2= 'O' ) ) ) ( (lv_pepAction_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_expr_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) ) )* )* otherlv_7= ')' otherlv_8= ']' )
            {
            // InternalFacpl2.g:1462:1: (otherlv_0= '[' ( ( (lv_typeObl_1_1= 'M' | lv_typeObl_1_2= 'O' ) ) ) ( (lv_pepAction_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_expr_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) ) )* )* otherlv_7= ')' otherlv_8= ']' )
            // InternalFacpl2.g:1462:3: otherlv_0= '[' ( ( (lv_typeObl_1_1= 'M' | lv_typeObl_1_2= 'O' ) ) ) ( (lv_pepAction_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_expr_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) ) )* )* otherlv_7= ')' otherlv_8= ']'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_44); 

                	newLeafNode(otherlv_0, grammarAccess.getObligationAccess().getLeftSquareBracketKeyword_0());
                
            // InternalFacpl2.g:1466:1: ( ( (lv_typeObl_1_1= 'M' | lv_typeObl_1_2= 'O' ) ) )
            // InternalFacpl2.g:1467:1: ( (lv_typeObl_1_1= 'M' | lv_typeObl_1_2= 'O' ) )
            {
            // InternalFacpl2.g:1467:1: ( (lv_typeObl_1_1= 'M' | lv_typeObl_1_2= 'O' ) )
            // InternalFacpl2.g:1468:1: (lv_typeObl_1_1= 'M' | lv_typeObl_1_2= 'O' )
            {
            // InternalFacpl2.g:1468:1: (lv_typeObl_1_1= 'M' | lv_typeObl_1_2= 'O' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==46) ) {
                alt28=1;
            }
            else if ( (LA28_0==47) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalFacpl2.g:1469:3: lv_typeObl_1_1= 'M'
                    {
                    lv_typeObl_1_1=(Token)match(input,46,FOLLOW_13); 

                            newLeafNode(lv_typeObl_1_1, grammarAccess.getObligationAccess().getTypeOblMKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getObligationRule());
                    	        }
                           		setWithLastConsumed(current, "typeObl", lv_typeObl_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:1481:8: lv_typeObl_1_2= 'O'
                    {
                    lv_typeObl_1_2=(Token)match(input,47,FOLLOW_13); 

                            newLeafNode(lv_typeObl_1_2, grammarAccess.getObligationAccess().getTypeOblOKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getObligationRule());
                    	        }
                           		setWithLastConsumed(current, "typeObl", lv_typeObl_1_2, null);
                    	    

                    }
                    break;

            }


            }


            }

            // InternalFacpl2.g:1496:2: ( (lv_pepAction_2_0= RULE_ID ) )
            // InternalFacpl2.g:1497:1: (lv_pepAction_2_0= RULE_ID )
            {
            // InternalFacpl2.g:1497:1: (lv_pepAction_2_0= RULE_ID )
            // InternalFacpl2.g:1498:3: lv_pepAction_2_0= RULE_ID
            {
            lv_pepAction_2_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            			newLeafNode(lv_pepAction_2_0, grammarAccess.getObligationAccess().getPepActionIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getObligationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"pepAction",
                    		lv_pepAction_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_45); 

                	newLeafNode(otherlv_3, grammarAccess.getObligationAccess().getLeftParenthesisKeyword_3());
                
            // InternalFacpl2.g:1518:1: ( ( (lv_expr_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) ) )* )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=RULE_STRING && LA30_0<=RULE_TIME)||LA30_0==27||(LA30_0>=50 && LA30_0<=52)||(LA30_0>=79 && LA30_0<=89)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalFacpl2.g:1518:2: ( (lv_expr_4_0= ruleExpression ) ) (otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) ) )*
            	    {
            	    // InternalFacpl2.g:1518:2: ( (lv_expr_4_0= ruleExpression ) )
            	    // InternalFacpl2.g:1519:1: (lv_expr_4_0= ruleExpression )
            	    {
            	    // InternalFacpl2.g:1519:1: (lv_expr_4_0= ruleExpression )
            	    // InternalFacpl2.g:1520:3: lv_expr_4_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getObligationAccess().getExprExpressionParserRuleCall_4_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_46);
            	    lv_expr_4_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getObligationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expr",
            	            		lv_expr_4_0, 
            	            		"it.unifi.xtext.facpl.Facpl2.Expression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // InternalFacpl2.g:1536:2: (otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) ) )*
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==24) ) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // InternalFacpl2.g:1536:4: otherlv_5= ',' ( (lv_expr_6_0= ruleExpression ) )
            	    	    {
            	    	    otherlv_5=(Token)match(input,24,FOLLOW_33); 

            	    	        	newLeafNode(otherlv_5, grammarAccess.getObligationAccess().getCommaKeyword_4_1_0());
            	    	        
            	    	    // InternalFacpl2.g:1540:1: ( (lv_expr_6_0= ruleExpression ) )
            	    	    // InternalFacpl2.g:1541:1: (lv_expr_6_0= ruleExpression )
            	    	    {
            	    	    // InternalFacpl2.g:1541:1: (lv_expr_6_0= ruleExpression )
            	    	    // InternalFacpl2.g:1542:3: lv_expr_6_0= ruleExpression
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getObligationAccess().getExprExpressionParserRuleCall_4_1_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_46);
            	    	    lv_expr_6_0=ruleExpression();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getObligationRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"expr",
            	    	            		lv_expr_6_0, 
            	    	            		"it.unifi.xtext.facpl.Facpl2.Expression");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop29;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            otherlv_7=(Token)match(input,28,FOLLOW_24); 

                	newLeafNode(otherlv_7, grammarAccess.getObligationAccess().getRightParenthesisKeyword_5());
                
            otherlv_8=(Token)match(input,33,FOLLOW_2); 

                	newLeafNode(otherlv_8, grammarAccess.getObligationAccess().getRightSquareBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObligation"


    // $ANTLR start "entryRuleExpression"
    // InternalFacpl2.g:1574:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalFacpl2.g:1575:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalFacpl2.g:1576:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalFacpl2.g:1583:1: ruleExpression returns [EObject current=null] : this_AndExpression_0= ruleAndExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AndExpression_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1586:28: (this_AndExpression_0= ruleAndExpression )
            // InternalFacpl2.g:1588:5: this_AndExpression_0= ruleAndExpression
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getAndExpressionParserRuleCall()); 
                
            pushFollow(FOLLOW_2);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;

             
                    current = this_AndExpression_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalFacpl2.g:1604:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalFacpl2.g:1605:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalFacpl2.g:1606:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalFacpl2.g:1613:1: ruleAndExpression returns [EObject current=null] : (this_OrExpression_0= ruleOrExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_OrExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1616:28: ( (this_OrExpression_0= ruleOrExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) ) )* ) )
            // InternalFacpl2.g:1617:1: (this_OrExpression_0= ruleOrExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) ) )* )
            {
            // InternalFacpl2.g:1617:1: (this_OrExpression_0= ruleOrExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) ) )* )
            // InternalFacpl2.g:1618:5: this_OrExpression_0= ruleOrExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAndExpressionAccess().getOrExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_47);
            this_OrExpression_0=ruleOrExpression();

            state._fsp--;

             
                    current = this_OrExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalFacpl2.g:1626:1: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==48) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalFacpl2.g:1626:2: () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) )
            	    {
            	    // InternalFacpl2.g:1626:2: ()
            	    // InternalFacpl2.g:1627:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,48,FOLLOW_33); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	        
            	    // InternalFacpl2.g:1636:1: ( (lv_right_3_0= ruleOrExpression ) )
            	    // InternalFacpl2.g:1637:1: (lv_right_3_0= ruleOrExpression )
            	    {
            	    // InternalFacpl2.g:1637:1: (lv_right_3_0= ruleOrExpression )
            	    // InternalFacpl2.g:1638:3: lv_right_3_0= ruleOrExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAndExpressionAccess().getRightOrExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_47);
            	    lv_right_3_0=ruleOrExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"it.unifi.xtext.facpl.Facpl2.OrExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalFacpl2.g:1662:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalFacpl2.g:1663:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalFacpl2.g:1664:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
             newCompositeNode(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;

             current =iv_ruleOrExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalFacpl2.g:1671:1: ruleOrExpression returns [EObject current=null] : (this_BasicExpression_0= ruleBasicExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BasicExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1674:28: ( (this_BasicExpression_0= ruleBasicExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) ) )* ) )
            // InternalFacpl2.g:1675:1: (this_BasicExpression_0= ruleBasicExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) ) )* )
            {
            // InternalFacpl2.g:1675:1: (this_BasicExpression_0= ruleBasicExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) ) )* )
            // InternalFacpl2.g:1676:5: this_BasicExpression_0= ruleBasicExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getOrExpressionAccess().getBasicExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_48);
            this_BasicExpression_0=ruleBasicExpression();

            state._fsp--;

             
                    current = this_BasicExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalFacpl2.g:1684:1: ( () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==49) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalFacpl2.g:1684:2: () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) )
            	    {
            	    // InternalFacpl2.g:1684:2: ()
            	    // InternalFacpl2.g:1685:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,49,FOLLOW_33); 

            	        	newLeafNode(otherlv_2, grammarAccess.getOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	        
            	    // InternalFacpl2.g:1694:1: ( (lv_right_3_0= ruleBasicExpression ) )
            	    // InternalFacpl2.g:1695:1: (lv_right_3_0= ruleBasicExpression )
            	    {
            	    // InternalFacpl2.g:1695:1: (lv_right_3_0= ruleBasicExpression )
            	    // InternalFacpl2.g:1696:3: lv_right_3_0= ruleBasicExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOrExpressionAccess().getRightBasicExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_48);
            	    lv_right_3_0=ruleBasicExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"it.unifi.xtext.facpl.Facpl2.BasicExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleBasicExpression"
    // InternalFacpl2.g:1720:1: entryRuleBasicExpression returns [EObject current=null] : iv_ruleBasicExpression= ruleBasicExpression EOF ;
    public final EObject entryRuleBasicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicExpression = null;


        try {
            // InternalFacpl2.g:1721:2: (iv_ruleBasicExpression= ruleBasicExpression EOF )
            // InternalFacpl2.g:1722:2: iv_ruleBasicExpression= ruleBasicExpression EOF
            {
             newCompositeNode(grammarAccess.getBasicExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBasicExpression=ruleBasicExpression();

            state._fsp--;

             current =iv_ruleBasicExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicExpression"


    // $ANTLR start "ruleBasicExpression"
    // InternalFacpl2.g:1729:1: ruleBasicExpression returns [EObject current=null] : (this_Function_0= ruleFunction | this_DeclaredFunction_1= ruleDeclaredFunction | this_MapFunction_2= ruleMapFunction | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | this_NotExpression_6= ruleNotExpression | this_Literals_7= ruleLiterals ) ;
    public final EObject ruleBasicExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject this_Function_0 = null;

        EObject this_DeclaredFunction_1 = null;

        EObject this_MapFunction_2 = null;

        EObject this_Expression_4 = null;

        EObject this_NotExpression_6 = null;

        EObject this_Literals_7 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1732:28: ( (this_Function_0= ruleFunction | this_DeclaredFunction_1= ruleDeclaredFunction | this_MapFunction_2= ruleMapFunction | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | this_NotExpression_6= ruleNotExpression | this_Literals_7= ruleLiterals ) )
            // InternalFacpl2.g:1733:1: (this_Function_0= ruleFunction | this_DeclaredFunction_1= ruleDeclaredFunction | this_MapFunction_2= ruleMapFunction | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | this_NotExpression_6= ruleNotExpression | this_Literals_7= ruleLiterals )
            {
            // InternalFacpl2.g:1733:1: (this_Function_0= ruleFunction | this_DeclaredFunction_1= ruleDeclaredFunction | this_MapFunction_2= ruleMapFunction | (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' ) | this_NotExpression_6= ruleNotExpression | this_Literals_7= ruleLiterals )
            int alt33=6;
            switch ( input.LA(1) ) {
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
                {
                alt33=1;
                }
                break;
            case RULE_ID:
                {
                int LA33_2 = input.LA(2);

                if ( (LA33_2==27) ) {
                    alt33=2;
                }
                else if ( (LA33_2==19||(LA33_2>=34 && LA33_2<=37)) ) {
                    alt33=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 2, input);

                    throw nvae;
                }
                }
                break;
            case 51:
                {
                alt33=3;
                }
                break;
            case 27:
                {
                alt33=4;
                }
                break;
            case 50:
                {
                alt33=5;
                }
                break;
            case RULE_STRING:
            case RULE_BOOLEAN:
            case RULE_INT:
            case RULE_REAL:
            case RULE_DATE:
            case RULE_TIME:
            case 52:
                {
                alt33=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalFacpl2.g:1734:5: this_Function_0= ruleFunction
                    {
                     
                            newCompositeNode(grammarAccess.getBasicExpressionAccess().getFunctionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Function_0=ruleFunction();

                    state._fsp--;

                     
                            current = this_Function_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:1744:5: this_DeclaredFunction_1= ruleDeclaredFunction
                    {
                     
                            newCompositeNode(grammarAccess.getBasicExpressionAccess().getDeclaredFunctionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_DeclaredFunction_1=ruleDeclaredFunction();

                    state._fsp--;

                     
                            current = this_DeclaredFunction_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalFacpl2.g:1754:5: this_MapFunction_2= ruleMapFunction
                    {
                     
                            newCompositeNode(grammarAccess.getBasicExpressionAccess().getMapFunctionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_MapFunction_2=ruleMapFunction();

                    state._fsp--;

                     
                            current = this_MapFunction_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalFacpl2.g:1763:6: (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' )
                    {
                    // InternalFacpl2.g:1763:6: (otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')' )
                    // InternalFacpl2.g:1763:8: otherlv_3= '(' this_Expression_4= ruleExpression otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,27,FOLLOW_33); 

                        	newLeafNode(otherlv_3, grammarAccess.getBasicExpressionAccess().getLeftParenthesisKeyword_3_0());
                        
                     
                            newCompositeNode(grammarAccess.getBasicExpressionAccess().getExpressionParserRuleCall_3_1()); 
                        
                    pushFollow(FOLLOW_49);
                    this_Expression_4=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_4; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_5=(Token)match(input,28,FOLLOW_2); 

                        	newLeafNode(otherlv_5, grammarAccess.getBasicExpressionAccess().getRightParenthesisKeyword_3_2());
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalFacpl2.g:1782:5: this_NotExpression_6= ruleNotExpression
                    {
                     
                            newCompositeNode(grammarAccess.getBasicExpressionAccess().getNotExpressionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_NotExpression_6=ruleNotExpression();

                    state._fsp--;

                     
                            current = this_NotExpression_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalFacpl2.g:1792:5: this_Literals_7= ruleLiterals
                    {
                     
                            newCompositeNode(grammarAccess.getBasicExpressionAccess().getLiteralsParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Literals_7=ruleLiterals();

                    state._fsp--;

                     
                            current = this_Literals_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicExpression"


    // $ANTLR start "entryRuleNotExpression"
    // InternalFacpl2.g:1808:1: entryRuleNotExpression returns [EObject current=null] : iv_ruleNotExpression= ruleNotExpression EOF ;
    public final EObject entryRuleNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpression = null;


        try {
            // InternalFacpl2.g:1809:2: (iv_ruleNotExpression= ruleNotExpression EOF )
            // InternalFacpl2.g:1810:2: iv_ruleNotExpression= ruleNotExpression EOF
            {
             newCompositeNode(grammarAccess.getNotExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotExpression=ruleNotExpression();

            state._fsp--;

             current =iv_ruleNotExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotExpression"


    // $ANTLR start "ruleNotExpression"
    // InternalFacpl2.g:1817:1: ruleNotExpression returns [EObject current=null] : (otherlv_0= '!' ( (lv_arg_1_0= ruleBasicExpression ) ) ) ;
    public final EObject ruleNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_arg_1_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1820:28: ( (otherlv_0= '!' ( (lv_arg_1_0= ruleBasicExpression ) ) ) )
            // InternalFacpl2.g:1821:1: (otherlv_0= '!' ( (lv_arg_1_0= ruleBasicExpression ) ) )
            {
            // InternalFacpl2.g:1821:1: (otherlv_0= '!' ( (lv_arg_1_0= ruleBasicExpression ) ) )
            // InternalFacpl2.g:1821:3: otherlv_0= '!' ( (lv_arg_1_0= ruleBasicExpression ) )
            {
            otherlv_0=(Token)match(input,50,FOLLOW_33); 

                	newLeafNode(otherlv_0, grammarAccess.getNotExpressionAccess().getExclamationMarkKeyword_0());
                
            // InternalFacpl2.g:1825:1: ( (lv_arg_1_0= ruleBasicExpression ) )
            // InternalFacpl2.g:1826:1: (lv_arg_1_0= ruleBasicExpression )
            {
            // InternalFacpl2.g:1826:1: (lv_arg_1_0= ruleBasicExpression )
            // InternalFacpl2.g:1827:3: lv_arg_1_0= ruleBasicExpression
            {
             
            	        newCompositeNode(grammarAccess.getNotExpressionAccess().getArgBasicExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_arg_1_0=ruleBasicExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNotExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"arg",
                    		lv_arg_1_0, 
                    		"it.unifi.xtext.facpl.Facpl2.BasicExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotExpression"


    // $ANTLR start "entryRuleFunction"
    // InternalFacpl2.g:1851:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalFacpl2.g:1852:2: (iv_ruleFunction= ruleFunction EOF )
            // InternalFacpl2.g:1853:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalFacpl2.g:1860:1: ruleFunction returns [EObject current=null] : ( ( (lv_functionId_0_0= rulefunID ) ) otherlv_1= '(' ( (lv_arg1_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_arg2_4_0= ruleExpression ) ) otherlv_5= ')' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_functionId_0_0 = null;

        EObject lv_arg1_2_0 = null;

        EObject lv_arg2_4_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1863:28: ( ( ( (lv_functionId_0_0= rulefunID ) ) otherlv_1= '(' ( (lv_arg1_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_arg2_4_0= ruleExpression ) ) otherlv_5= ')' ) )
            // InternalFacpl2.g:1864:1: ( ( (lv_functionId_0_0= rulefunID ) ) otherlv_1= '(' ( (lv_arg1_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_arg2_4_0= ruleExpression ) ) otherlv_5= ')' )
            {
            // InternalFacpl2.g:1864:1: ( ( (lv_functionId_0_0= rulefunID ) ) otherlv_1= '(' ( (lv_arg1_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_arg2_4_0= ruleExpression ) ) otherlv_5= ')' )
            // InternalFacpl2.g:1864:2: ( (lv_functionId_0_0= rulefunID ) ) otherlv_1= '(' ( (lv_arg1_2_0= ruleExpression ) ) otherlv_3= ',' ( (lv_arg2_4_0= ruleExpression ) ) otherlv_5= ')'
            {
            // InternalFacpl2.g:1864:2: ( (lv_functionId_0_0= rulefunID ) )
            // InternalFacpl2.g:1865:1: (lv_functionId_0_0= rulefunID )
            {
            // InternalFacpl2.g:1865:1: (lv_functionId_0_0= rulefunID )
            // InternalFacpl2.g:1866:3: lv_functionId_0_0= rulefunID
            {
             
            	        newCompositeNode(grammarAccess.getFunctionAccess().getFunctionIdFunIDEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_18);
            lv_functionId_0_0=rulefunID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionRule());
            	        }
                   		set(
                   			current, 
                   			"functionId",
                    		lv_functionId_0_0, 
                    		"it.unifi.xtext.facpl.Facpl2.funID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_33); 

                	newLeafNode(otherlv_1, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_1());
                
            // InternalFacpl2.g:1886:1: ( (lv_arg1_2_0= ruleExpression ) )
            // InternalFacpl2.g:1887:1: (lv_arg1_2_0= ruleExpression )
            {
            // InternalFacpl2.g:1887:1: (lv_arg1_2_0= ruleExpression )
            // InternalFacpl2.g:1888:3: lv_arg1_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getFunctionAccess().getArg1ExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_26);
            lv_arg1_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionRule());
            	        }
                   		set(
                   			current, 
                   			"arg1",
                    		lv_arg1_2_0, 
                    		"it.unifi.xtext.facpl.Facpl2.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_33); 

                	newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getCommaKeyword_3());
                
            // InternalFacpl2.g:1908:1: ( (lv_arg2_4_0= ruleExpression ) )
            // InternalFacpl2.g:1909:1: (lv_arg2_4_0= ruleExpression )
            {
            // InternalFacpl2.g:1909:1: (lv_arg2_4_0= ruleExpression )
            // InternalFacpl2.g:1910:3: lv_arg2_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getFunctionAccess().getArg2ExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_49);
            lv_arg2_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionRule());
            	        }
                   		set(
                   			current, 
                   			"arg2",
                    		lv_arg2_4_0, 
                    		"it.unifi.xtext.facpl.Facpl2.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,28,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleDeclaredFunction"
    // InternalFacpl2.g:1938:1: entryRuleDeclaredFunction returns [EObject current=null] : iv_ruleDeclaredFunction= ruleDeclaredFunction EOF ;
    public final EObject entryRuleDeclaredFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredFunction = null;


        try {
            // InternalFacpl2.g:1939:2: (iv_ruleDeclaredFunction= ruleDeclaredFunction EOF )
            // InternalFacpl2.g:1940:2: iv_ruleDeclaredFunction= ruleDeclaredFunction EOF
            {
             newCompositeNode(grammarAccess.getDeclaredFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclaredFunction=ruleDeclaredFunction();

            state._fsp--;

             current =iv_ruleDeclaredFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclaredFunction"


    // $ANTLR start "ruleDeclaredFunction"
    // InternalFacpl2.g:1947:1: ruleDeclaredFunction returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleDeclaredFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_args_2_0 = null;

        EObject lv_args_4_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1950:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' ) )
            // InternalFacpl2.g:1951:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' )
            {
            // InternalFacpl2.g:1951:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' )
            // InternalFacpl2.g:1951:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')'
            {
            // InternalFacpl2.g:1951:2: ( (otherlv_0= RULE_ID ) )
            // InternalFacpl2.g:1952:1: (otherlv_0= RULE_ID )
            {
            // InternalFacpl2.g:1952:1: (otherlv_0= RULE_ID )
            // InternalFacpl2.g:1953:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDeclaredFunctionRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            		newLeafNode(otherlv_0, grammarAccess.getDeclaredFunctionAccess().getFunctionIdFunctionDeclarationCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_33); 

                	newLeafNode(otherlv_1, grammarAccess.getDeclaredFunctionAccess().getLeftParenthesisKeyword_1());
                
            // InternalFacpl2.g:1968:1: ( (lv_args_2_0= ruleExpression ) )
            // InternalFacpl2.g:1969:1: (lv_args_2_0= ruleExpression )
            {
            // InternalFacpl2.g:1969:1: (lv_args_2_0= ruleExpression )
            // InternalFacpl2.g:1970:3: lv_args_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getDeclaredFunctionAccess().getArgsExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_19);
            lv_args_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDeclaredFunctionRule());
            	        }
                   		add(
                   			current, 
                   			"args",
                    		lv_args_2_0, 
                    		"it.unifi.xtext.facpl.Facpl2.Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalFacpl2.g:1986:2: (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==24) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalFacpl2.g:1986:4: otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,24,FOLLOW_33); 

            	        	newLeafNode(otherlv_3, grammarAccess.getDeclaredFunctionAccess().getCommaKeyword_3_0());
            	        
            	    // InternalFacpl2.g:1990:1: ( (lv_args_4_0= ruleExpression ) )
            	    // InternalFacpl2.g:1991:1: (lv_args_4_0= ruleExpression )
            	    {
            	    // InternalFacpl2.g:1991:1: (lv_args_4_0= ruleExpression )
            	    // InternalFacpl2.g:1992:3: lv_args_4_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDeclaredFunctionAccess().getArgsExpressionParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_19);
            	    lv_args_4_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDeclaredFunctionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"args",
            	            		lv_args_4_0, 
            	            		"it.unifi.xtext.facpl.Facpl2.Expression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_5=(Token)match(input,28,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getDeclaredFunctionAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclaredFunction"


    // $ANTLR start "entryRuleMapFunction"
    // InternalFacpl2.g:2020:1: entryRuleMapFunction returns [EObject current=null] : iv_ruleMapFunction= ruleMapFunction EOF ;
    public final EObject entryRuleMapFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapFunction = null;


        try {
            // InternalFacpl2.g:2021:2: (iv_ruleMapFunction= ruleMapFunction EOF )
            // InternalFacpl2.g:2022:2: iv_ruleMapFunction= ruleMapFunction EOF
            {
             newCompositeNode(grammarAccess.getMapFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMapFunction=ruleMapFunction();

            state._fsp--;

             current =iv_ruleMapFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapFunction"


    // $ANTLR start "ruleMapFunction"
    // InternalFacpl2.g:2029:1: ruleMapFunction returns [EObject current=null] : (otherlv_0= 'map(' ( (lv_functionId_1_0= rulefunID ) ) otherlv_2= ',' ( (lv_arg1_3_0= ruleAttributeName ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleLiterals ) ) otherlv_6= ')' ) ;
    public final EObject ruleMapFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_functionId_1_0 = null;

        EObject lv_arg1_3_0 = null;

        EObject lv_arg2_5_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:2032:28: ( (otherlv_0= 'map(' ( (lv_functionId_1_0= rulefunID ) ) otherlv_2= ',' ( (lv_arg1_3_0= ruleAttributeName ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleLiterals ) ) otherlv_6= ')' ) )
            // InternalFacpl2.g:2033:1: (otherlv_0= 'map(' ( (lv_functionId_1_0= rulefunID ) ) otherlv_2= ',' ( (lv_arg1_3_0= ruleAttributeName ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleLiterals ) ) otherlv_6= ')' )
            {
            // InternalFacpl2.g:2033:1: (otherlv_0= 'map(' ( (lv_functionId_1_0= rulefunID ) ) otherlv_2= ',' ( (lv_arg1_3_0= ruleAttributeName ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleLiterals ) ) otherlv_6= ')' )
            // InternalFacpl2.g:2033:3: otherlv_0= 'map(' ( (lv_functionId_1_0= rulefunID ) ) otherlv_2= ',' ( (lv_arg1_3_0= ruleAttributeName ) ) otherlv_4= ',' ( (lv_arg2_5_0= ruleLiterals ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_50); 

                	newLeafNode(otherlv_0, grammarAccess.getMapFunctionAccess().getMapKeyword_0());
                
            // InternalFacpl2.g:2037:1: ( (lv_functionId_1_0= rulefunID ) )
            // InternalFacpl2.g:2038:1: (lv_functionId_1_0= rulefunID )
            {
            // InternalFacpl2.g:2038:1: (lv_functionId_1_0= rulefunID )
            // InternalFacpl2.g:2039:3: lv_functionId_1_0= rulefunID
            {
             
            	        newCompositeNode(grammarAccess.getMapFunctionAccess().getFunctionIdFunIDEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_26);
            lv_functionId_1_0=rulefunID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMapFunctionRule());
            	        }
                   		set(
                   			current, 
                   			"functionId",
                    		lv_functionId_1_0, 
                    		"it.unifi.xtext.facpl.Facpl2.funID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_13); 

                	newLeafNode(otherlv_2, grammarAccess.getMapFunctionAccess().getCommaKeyword_2());
                
            // InternalFacpl2.g:2059:1: ( (lv_arg1_3_0= ruleAttributeName ) )
            // InternalFacpl2.g:2060:1: (lv_arg1_3_0= ruleAttributeName )
            {
            // InternalFacpl2.g:2060:1: (lv_arg1_3_0= ruleAttributeName )
            // InternalFacpl2.g:2061:3: lv_arg1_3_0= ruleAttributeName
            {
             
            	        newCompositeNode(grammarAccess.getMapFunctionAccess().getArg1AttributeNameParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_26);
            lv_arg1_3_0=ruleAttributeName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMapFunctionRule());
            	        }
                   		set(
                   			current, 
                   			"arg1",
                    		lv_arg1_3_0, 
                    		"it.unifi.xtext.facpl.Facpl2.AttributeName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_27); 

                	newLeafNode(otherlv_4, grammarAccess.getMapFunctionAccess().getCommaKeyword_4());
                
            // InternalFacpl2.g:2081:1: ( (lv_arg2_5_0= ruleLiterals ) )
            // InternalFacpl2.g:2082:1: (lv_arg2_5_0= ruleLiterals )
            {
            // InternalFacpl2.g:2082:1: (lv_arg2_5_0= ruleLiterals )
            // InternalFacpl2.g:2083:3: lv_arg2_5_0= ruleLiterals
            {
             
            	        newCompositeNode(grammarAccess.getMapFunctionAccess().getArg2LiteralsParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_49);
            lv_arg2_5_0=ruleLiterals();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMapFunctionRule());
            	        }
                   		set(
                   			current, 
                   			"arg2",
                    		lv_arg2_5_0, 
                    		"it.unifi.xtext.facpl.Facpl2.Literals");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,28,FOLLOW_2); 

                	newLeafNode(otherlv_6, grammarAccess.getMapFunctionAccess().getRightParenthesisKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapFunction"


    // $ANTLR start "entryRuleLiterals"
    // InternalFacpl2.g:2111:1: entryRuleLiterals returns [EObject current=null] : iv_ruleLiterals= ruleLiterals EOF ;
    public final EObject entryRuleLiterals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiterals = null;


        try {
            // InternalFacpl2.g:2112:2: (iv_ruleLiterals= ruleLiterals EOF )
            // InternalFacpl2.g:2113:2: iv_ruleLiterals= ruleLiterals EOF
            {
             newCompositeNode(grammarAccess.getLiteralsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiterals=ruleLiterals();

            state._fsp--;

             current =iv_ruleLiterals; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiterals"


    // $ANTLR start "ruleLiterals"
    // InternalFacpl2.g:2120:1: ruleLiterals returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_DoubleLiteral_1= ruleDoubleLiteral | this_BooleanLiteral_2= ruleBooleanLiteral | this_StringLiteral_3= ruleStringLiteral | this_DateLiteral_4= ruleDateLiteral | this_TimeLiteral_5= ruleTimeLiteral | this_AttributeName_6= ruleAttributeName | this_Set_7= ruleSet ) ;
    public final EObject ruleLiterals() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteral_0 = null;

        EObject this_DoubleLiteral_1 = null;

        EObject this_BooleanLiteral_2 = null;

        EObject this_StringLiteral_3 = null;

        EObject this_DateLiteral_4 = null;

        EObject this_TimeLiteral_5 = null;

        EObject this_AttributeName_6 = null;

        EObject this_Set_7 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:2123:28: ( (this_IntLiteral_0= ruleIntLiteral | this_DoubleLiteral_1= ruleDoubleLiteral | this_BooleanLiteral_2= ruleBooleanLiteral | this_StringLiteral_3= ruleStringLiteral | this_DateLiteral_4= ruleDateLiteral | this_TimeLiteral_5= ruleTimeLiteral | this_AttributeName_6= ruleAttributeName | this_Set_7= ruleSet ) )
            // InternalFacpl2.g:2124:1: (this_IntLiteral_0= ruleIntLiteral | this_DoubleLiteral_1= ruleDoubleLiteral | this_BooleanLiteral_2= ruleBooleanLiteral | this_StringLiteral_3= ruleStringLiteral | this_DateLiteral_4= ruleDateLiteral | this_TimeLiteral_5= ruleTimeLiteral | this_AttributeName_6= ruleAttributeName | this_Set_7= ruleSet )
            {
            // InternalFacpl2.g:2124:1: (this_IntLiteral_0= ruleIntLiteral | this_DoubleLiteral_1= ruleDoubleLiteral | this_BooleanLiteral_2= ruleBooleanLiteral | this_StringLiteral_3= ruleStringLiteral | this_DateLiteral_4= ruleDateLiteral | this_TimeLiteral_5= ruleTimeLiteral | this_AttributeName_6= ruleAttributeName | this_Set_7= ruleSet )
            int alt35=8;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt35=1;
                }
                break;
            case RULE_REAL:
                {
                alt35=2;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt35=3;
                }
                break;
            case RULE_STRING:
                {
                alt35=4;
                }
                break;
            case RULE_DATE:
                {
                alt35=5;
                }
                break;
            case RULE_TIME:
                {
                alt35=6;
                }
                break;
            case RULE_ID:
                {
                alt35=7;
                }
                break;
            case 52:
                {
                alt35=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalFacpl2.g:2125:5: this_IntLiteral_0= ruleIntLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralsAccess().getIntLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_IntLiteral_0=ruleIntLiteral();

                    state._fsp--;

                     
                            current = this_IntLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:2135:5: this_DoubleLiteral_1= ruleDoubleLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralsAccess().getDoubleLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_DoubleLiteral_1=ruleDoubleLiteral();

                    state._fsp--;

                     
                            current = this_DoubleLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalFacpl2.g:2145:5: this_BooleanLiteral_2= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralsAccess().getBooleanLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteral_2=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalFacpl2.g:2155:5: this_StringLiteral_3= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralsAccess().getStringLiteralParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_StringLiteral_3=ruleStringLiteral();

                    state._fsp--;

                     
                            current = this_StringLiteral_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalFacpl2.g:2165:5: this_DateLiteral_4= ruleDateLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralsAccess().getDateLiteralParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_DateLiteral_4=ruleDateLiteral();

                    state._fsp--;

                     
                            current = this_DateLiteral_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalFacpl2.g:2175:5: this_TimeLiteral_5= ruleTimeLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralsAccess().getTimeLiteralParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_2);
                    this_TimeLiteral_5=ruleTimeLiteral();

                    state._fsp--;

                     
                            current = this_TimeLiteral_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalFacpl2.g:2185:5: this_AttributeName_6= ruleAttributeName
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralsAccess().getAttributeNameParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_2);
                    this_AttributeName_6=ruleAttributeName();

                    state._fsp--;

                     
                            current = this_AttributeName_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // InternalFacpl2.g:2195:5: this_Set_7= ruleSet
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralsAccess().getSetParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Set_7=ruleSet();

                    state._fsp--;

                     
                            current = this_Set_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiterals"


    // $ANTLR start "entryRuleSet"
    // InternalFacpl2.g:2211:1: entryRuleSet returns [EObject current=null] : iv_ruleSet= ruleSet EOF ;
    public final EObject entryRuleSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSet = null;


        try {
            // InternalFacpl2.g:2212:2: (iv_ruleSet= ruleSet EOF )
            // InternalFacpl2.g:2213:2: iv_ruleSet= ruleSet EOF
            {
             newCompositeNode(grammarAccess.getSetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSet=ruleSet();

            state._fsp--;

             current =iv_ruleSet; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSet"


    // $ANTLR start "ruleSet"
    // InternalFacpl2.g:2220:1: ruleSet returns [EObject current=null] : (otherlv_0= 'set(' ( ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )* ) otherlv_4= ')' ) ;
    public final EObject ruleSet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_args_1_0 = null;

        EObject lv_args_3_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:2223:28: ( (otherlv_0= 'set(' ( ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )* ) otherlv_4= ')' ) )
            // InternalFacpl2.g:2224:1: (otherlv_0= 'set(' ( ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )* ) otherlv_4= ')' )
            {
            // InternalFacpl2.g:2224:1: (otherlv_0= 'set(' ( ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )* ) otherlv_4= ')' )
            // InternalFacpl2.g:2224:3: otherlv_0= 'set(' ( ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )* ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_27); 

                	newLeafNode(otherlv_0, grammarAccess.getSetAccess().getSetKeyword_0());
                
            // InternalFacpl2.g:2228:1: ( ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )* )
            // InternalFacpl2.g:2228:2: ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )*
            {
            // InternalFacpl2.g:2228:2: ( (lv_args_1_0= ruleLiterals ) )
            // InternalFacpl2.g:2229:1: (lv_args_1_0= ruleLiterals )
            {
            // InternalFacpl2.g:2229:1: (lv_args_1_0= ruleLiterals )
            // InternalFacpl2.g:2230:3: lv_args_1_0= ruleLiterals
            {
             
            	        newCompositeNode(grammarAccess.getSetAccess().getArgsLiteralsParserRuleCall_1_0_0()); 
            	    
            pushFollow(FOLLOW_19);
            lv_args_1_0=ruleLiterals();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSetRule());
            	        }
                   		add(
                   			current, 
                   			"args",
                    		lv_args_1_0, 
                    		"it.unifi.xtext.facpl.Facpl2.Literals");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalFacpl2.g:2246:2: (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==24) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalFacpl2.g:2246:4: otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) )
            	    {
            	    otherlv_2=(Token)match(input,24,FOLLOW_27); 

            	        	newLeafNode(otherlv_2, grammarAccess.getSetAccess().getCommaKeyword_1_1_0());
            	        
            	    // InternalFacpl2.g:2250:1: ( (lv_args_3_0= ruleLiterals ) )
            	    // InternalFacpl2.g:2251:1: (lv_args_3_0= ruleLiterals )
            	    {
            	    // InternalFacpl2.g:2251:1: (lv_args_3_0= ruleLiterals )
            	    // InternalFacpl2.g:2252:3: lv_args_3_0= ruleLiterals
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSetAccess().getArgsLiteralsParserRuleCall_1_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_19);
            	    lv_args_3_0=ruleLiterals();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSetRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"args",
            	            		lv_args_3_0, 
            	            		"it.unifi.xtext.facpl.Facpl2.Literals");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            otherlv_4=(Token)match(input,28,FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getSetAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSet"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalFacpl2.g:2280:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalFacpl2.g:2281:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalFacpl2.g:2282:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalFacpl2.g:2289:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:2292:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalFacpl2.g:2293:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalFacpl2.g:2293:1: ( (lv_value_0_0= RULE_STRING ) )
            // InternalFacpl2.g:2294:1: (lv_value_0_0= RULE_STRING )
            {
            // InternalFacpl2.g:2294:1: (lv_value_0_0= RULE_STRING )
            // InternalFacpl2.g:2295:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            			newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"it.unifi.xtext.facpl.Facpl2.STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalFacpl2.g:2319:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalFacpl2.g:2320:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalFacpl2.g:2321:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalFacpl2.g:2328:1: ruleBooleanLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:2331:28: ( ( (lv_value_0_0= RULE_BOOLEAN ) ) )
            // InternalFacpl2.g:2332:1: ( (lv_value_0_0= RULE_BOOLEAN ) )
            {
            // InternalFacpl2.g:2332:1: ( (lv_value_0_0= RULE_BOOLEAN ) )
            // InternalFacpl2.g:2333:1: (lv_value_0_0= RULE_BOOLEAN )
            {
            // InternalFacpl2.g:2333:1: (lv_value_0_0= RULE_BOOLEAN )
            // InternalFacpl2.g:2334:3: lv_value_0_0= RULE_BOOLEAN
            {
            lv_value_0_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

            			newLeafNode(lv_value_0_0, grammarAccess.getBooleanLiteralAccess().getValueBOOLEANTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBooleanLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"it.unifi.xtext.facpl.Facpl2.BOOLEAN");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // InternalFacpl2.g:2358:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalFacpl2.g:2359:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalFacpl2.g:2360:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;

             current =iv_ruleIntLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntLiteral"


    // $ANTLR start "ruleIntLiteral"
    // InternalFacpl2.g:2367:1: ruleIntLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:2370:28: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalFacpl2.g:2371:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalFacpl2.g:2371:1: ( (lv_value_0_0= RULE_INT ) )
            // InternalFacpl2.g:2372:1: (lv_value_0_0= RULE_INT )
            {
            // InternalFacpl2.g:2372:1: (lv_value_0_0= RULE_INT )
            // InternalFacpl2.g:2373:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            			newLeafNode(lv_value_0_0, grammarAccess.getIntLiteralAccess().getValueINTTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIntLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"it.unifi.xtext.facpl.Facpl2.INT");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleDoubleLiteral"
    // InternalFacpl2.g:2397:1: entryRuleDoubleLiteral returns [EObject current=null] : iv_ruleDoubleLiteral= ruleDoubleLiteral EOF ;
    public final EObject entryRuleDoubleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteral = null;


        try {
            // InternalFacpl2.g:2398:2: (iv_ruleDoubleLiteral= ruleDoubleLiteral EOF )
            // InternalFacpl2.g:2399:2: iv_ruleDoubleLiteral= ruleDoubleLiteral EOF
            {
             newCompositeNode(grammarAccess.getDoubleLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDoubleLiteral=ruleDoubleLiteral();

            state._fsp--;

             current =iv_ruleDoubleLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDoubleLiteral"


    // $ANTLR start "ruleDoubleLiteral"
    // InternalFacpl2.g:2406:1: ruleDoubleLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_REAL ) ) ;
    public final EObject ruleDoubleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:2409:28: ( ( (lv_value_0_0= RULE_REAL ) ) )
            // InternalFacpl2.g:2410:1: ( (lv_value_0_0= RULE_REAL ) )
            {
            // InternalFacpl2.g:2410:1: ( (lv_value_0_0= RULE_REAL ) )
            // InternalFacpl2.g:2411:1: (lv_value_0_0= RULE_REAL )
            {
            // InternalFacpl2.g:2411:1: (lv_value_0_0= RULE_REAL )
            // InternalFacpl2.g:2412:3: lv_value_0_0= RULE_REAL
            {
            lv_value_0_0=(Token)match(input,RULE_REAL,FOLLOW_2); 

            			newLeafNode(lv_value_0_0, grammarAccess.getDoubleLiteralAccess().getValueREALTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDoubleLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"it.unifi.xtext.facpl.Facpl2.REAL");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDoubleLiteral"


    // $ANTLR start "entryRuleDateLiteral"
    // InternalFacpl2.g:2436:1: entryRuleDateLiteral returns [EObject current=null] : iv_ruleDateLiteral= ruleDateLiteral EOF ;
    public final EObject entryRuleDateLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateLiteral = null;


        try {
            // InternalFacpl2.g:2437:2: (iv_ruleDateLiteral= ruleDateLiteral EOF )
            // InternalFacpl2.g:2438:2: iv_ruleDateLiteral= ruleDateLiteral EOF
            {
             newCompositeNode(grammarAccess.getDateLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateLiteral=ruleDateLiteral();

            state._fsp--;

             current =iv_ruleDateLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateLiteral"


    // $ANTLR start "ruleDateLiteral"
    // InternalFacpl2.g:2445:1: ruleDateLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_DATE ) ) ;
    public final EObject ruleDateLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:2448:28: ( ( (lv_value_0_0= RULE_DATE ) ) )
            // InternalFacpl2.g:2449:1: ( (lv_value_0_0= RULE_DATE ) )
            {
            // InternalFacpl2.g:2449:1: ( (lv_value_0_0= RULE_DATE ) )
            // InternalFacpl2.g:2450:1: (lv_value_0_0= RULE_DATE )
            {
            // InternalFacpl2.g:2450:1: (lv_value_0_0= RULE_DATE )
            // InternalFacpl2.g:2451:3: lv_value_0_0= RULE_DATE
            {
            lv_value_0_0=(Token)match(input,RULE_DATE,FOLLOW_2); 

            			newLeafNode(lv_value_0_0, grammarAccess.getDateLiteralAccess().getValueDATETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDateLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"it.unifi.xtext.facpl.Facpl2.DATE");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateLiteral"


    // $ANTLR start "entryRuleTimeLiteral"
    // InternalFacpl2.g:2475:1: entryRuleTimeLiteral returns [EObject current=null] : iv_ruleTimeLiteral= ruleTimeLiteral EOF ;
    public final EObject entryRuleTimeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeLiteral = null;


        try {
            // InternalFacpl2.g:2476:2: (iv_ruleTimeLiteral= ruleTimeLiteral EOF )
            // InternalFacpl2.g:2477:2: iv_ruleTimeLiteral= ruleTimeLiteral EOF
            {
             newCompositeNode(grammarAccess.getTimeLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeLiteral=ruleTimeLiteral();

            state._fsp--;

             current =iv_ruleTimeLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeLiteral"


    // $ANTLR start "ruleTimeLiteral"
    // InternalFacpl2.g:2484:1: ruleTimeLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_TIME ) ) ;
    public final EObject ruleTimeLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:2487:28: ( ( (lv_value_0_0= RULE_TIME ) ) )
            // InternalFacpl2.g:2488:1: ( (lv_value_0_0= RULE_TIME ) )
            {
            // InternalFacpl2.g:2488:1: ( (lv_value_0_0= RULE_TIME ) )
            // InternalFacpl2.g:2489:1: (lv_value_0_0= RULE_TIME )
            {
            // InternalFacpl2.g:2489:1: (lv_value_0_0= RULE_TIME )
            // InternalFacpl2.g:2490:3: lv_value_0_0= RULE_TIME
            {
            lv_value_0_0=(Token)match(input,RULE_TIME,FOLLOW_2); 

            			newLeafNode(lv_value_0_0, grammarAccess.getTimeLiteralAccess().getValueTIMETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTimeLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"it.unifi.xtext.facpl.Facpl2.TIME");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeLiteral"


    // $ANTLR start "ruleTypeLiteral"
    // InternalFacpl2.g:2514:1: ruleTypeLiteral returns [Enumerator current=null] : ( (enumLiteral_0= 'Int' ) | (enumLiteral_1= 'Double' ) | (enumLiteral_2= 'Bool' ) | (enumLiteral_3= 'String' ) | (enumLiteral_4= 'DateTime' ) | (enumLiteral_5= 'Set<Int>' ) | (enumLiteral_6= 'Set<Double>' ) | (enumLiteral_7= 'Set<Bool>' ) | (enumLiteral_8= 'Set<String>' ) | (enumLiteral_9= 'Set<DateTime>' ) ) ;
    public final Enumerator ruleTypeLiteral() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;

         enterRule(); 
        try {
            // InternalFacpl2.g:2516:28: ( ( (enumLiteral_0= 'Int' ) | (enumLiteral_1= 'Double' ) | (enumLiteral_2= 'Bool' ) | (enumLiteral_3= 'String' ) | (enumLiteral_4= 'DateTime' ) | (enumLiteral_5= 'Set<Int>' ) | (enumLiteral_6= 'Set<Double>' ) | (enumLiteral_7= 'Set<Bool>' ) | (enumLiteral_8= 'Set<String>' ) | (enumLiteral_9= 'Set<DateTime>' ) ) )
            // InternalFacpl2.g:2517:1: ( (enumLiteral_0= 'Int' ) | (enumLiteral_1= 'Double' ) | (enumLiteral_2= 'Bool' ) | (enumLiteral_3= 'String' ) | (enumLiteral_4= 'DateTime' ) | (enumLiteral_5= 'Set<Int>' ) | (enumLiteral_6= 'Set<Double>' ) | (enumLiteral_7= 'Set<Bool>' ) | (enumLiteral_8= 'Set<String>' ) | (enumLiteral_9= 'Set<DateTime>' ) )
            {
            // InternalFacpl2.g:2517:1: ( (enumLiteral_0= 'Int' ) | (enumLiteral_1= 'Double' ) | (enumLiteral_2= 'Bool' ) | (enumLiteral_3= 'String' ) | (enumLiteral_4= 'DateTime' ) | (enumLiteral_5= 'Set<Int>' ) | (enumLiteral_6= 'Set<Double>' ) | (enumLiteral_7= 'Set<Bool>' ) | (enumLiteral_8= 'Set<String>' ) | (enumLiteral_9= 'Set<DateTime>' ) )
            int alt37=10;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt37=1;
                }
                break;
            case 54:
                {
                alt37=2;
                }
                break;
            case 55:
                {
                alt37=3;
                }
                break;
            case 56:
                {
                alt37=4;
                }
                break;
            case 57:
                {
                alt37=5;
                }
                break;
            case 58:
                {
                alt37=6;
                }
                break;
            case 59:
                {
                alt37=7;
                }
                break;
            case 60:
                {
                alt37=8;
                }
                break;
            case 61:
                {
                alt37=9;
                }
                break;
            case 62:
                {
                alt37=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalFacpl2.g:2517:2: (enumLiteral_0= 'Int' )
                    {
                    // InternalFacpl2.g:2517:2: (enumLiteral_0= 'Int' )
                    // InternalFacpl2.g:2517:4: enumLiteral_0= 'Int'
                    {
                    enumLiteral_0=(Token)match(input,53,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getIntEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getTypeLiteralAccess().getIntEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:2523:6: (enumLiteral_1= 'Double' )
                    {
                    // InternalFacpl2.g:2523:6: (enumLiteral_1= 'Double' )
                    // InternalFacpl2.g:2523:8: enumLiteral_1= 'Double'
                    {
                    enumLiteral_1=(Token)match(input,54,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getDoubleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getTypeLiteralAccess().getDoubleEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalFacpl2.g:2529:6: (enumLiteral_2= 'Bool' )
                    {
                    // InternalFacpl2.g:2529:6: (enumLiteral_2= 'Bool' )
                    // InternalFacpl2.g:2529:8: enumLiteral_2= 'Bool'
                    {
                    enumLiteral_2=(Token)match(input,55,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getBoolEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getTypeLiteralAccess().getBoolEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalFacpl2.g:2535:6: (enumLiteral_3= 'String' )
                    {
                    // InternalFacpl2.g:2535:6: (enumLiteral_3= 'String' )
                    // InternalFacpl2.g:2535:8: enumLiteral_3= 'String'
                    {
                    enumLiteral_3=(Token)match(input,56,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getStringEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getTypeLiteralAccess().getStringEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalFacpl2.g:2541:6: (enumLiteral_4= 'DateTime' )
                    {
                    // InternalFacpl2.g:2541:6: (enumLiteral_4= 'DateTime' )
                    // InternalFacpl2.g:2541:8: enumLiteral_4= 'DateTime'
                    {
                    enumLiteral_4=(Token)match(input,57,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getDateTimeEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getTypeLiteralAccess().getDateTimeEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // InternalFacpl2.g:2547:6: (enumLiteral_5= 'Set<Int>' )
                    {
                    // InternalFacpl2.g:2547:6: (enumLiteral_5= 'Set<Int>' )
                    // InternalFacpl2.g:2547:8: enumLiteral_5= 'Set<Int>'
                    {
                    enumLiteral_5=(Token)match(input,58,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getSetIntEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getTypeLiteralAccess().getSetIntEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // InternalFacpl2.g:2553:6: (enumLiteral_6= 'Set<Double>' )
                    {
                    // InternalFacpl2.g:2553:6: (enumLiteral_6= 'Set<Double>' )
                    // InternalFacpl2.g:2553:8: enumLiteral_6= 'Set<Double>'
                    {
                    enumLiteral_6=(Token)match(input,59,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getSetDoubleEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getTypeLiteralAccess().getSetDoubleEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // InternalFacpl2.g:2559:6: (enumLiteral_7= 'Set<Bool>' )
                    {
                    // InternalFacpl2.g:2559:6: (enumLiteral_7= 'Set<Bool>' )
                    // InternalFacpl2.g:2559:8: enumLiteral_7= 'Set<Bool>'
                    {
                    enumLiteral_7=(Token)match(input,60,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getSetBoolEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getTypeLiteralAccess().getSetBoolEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // InternalFacpl2.g:2565:6: (enumLiteral_8= 'Set<String>' )
                    {
                    // InternalFacpl2.g:2565:6: (enumLiteral_8= 'Set<String>' )
                    // InternalFacpl2.g:2565:8: enumLiteral_8= 'Set<String>'
                    {
                    enumLiteral_8=(Token)match(input,61,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getSetStringEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getTypeLiteralAccess().getSetStringEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // InternalFacpl2.g:2571:6: (enumLiteral_9= 'Set<DateTime>' )
                    {
                    // InternalFacpl2.g:2571:6: (enumLiteral_9= 'Set<DateTime>' )
                    // InternalFacpl2.g:2571:8: enumLiteral_9= 'Set<DateTime>'
                    {
                    enumLiteral_9=(Token)match(input,62,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getSetDateTimeEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getTypeLiteralAccess().getSetDateTimeEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeLiteral"


    // $ANTLR start "rulePEPAlg"
    // InternalFacpl2.g:2581:1: rulePEPAlg returns [Enumerator current=null] : ( (enumLiteral_0= 'base' ) | (enumLiteral_1= 'deny-biased' ) | (enumLiteral_2= 'permit-biased' ) ) ;
    public final Enumerator rulePEPAlg() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // InternalFacpl2.g:2583:28: ( ( (enumLiteral_0= 'base' ) | (enumLiteral_1= 'deny-biased' ) | (enumLiteral_2= 'permit-biased' ) ) )
            // InternalFacpl2.g:2584:1: ( (enumLiteral_0= 'base' ) | (enumLiteral_1= 'deny-biased' ) | (enumLiteral_2= 'permit-biased' ) )
            {
            // InternalFacpl2.g:2584:1: ( (enumLiteral_0= 'base' ) | (enumLiteral_1= 'deny-biased' ) | (enumLiteral_2= 'permit-biased' ) )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt38=1;
                }
                break;
            case 64:
                {
                alt38=2;
                }
                break;
            case 65:
                {
                alt38=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalFacpl2.g:2584:2: (enumLiteral_0= 'base' )
                    {
                    // InternalFacpl2.g:2584:2: (enumLiteral_0= 'base' )
                    // InternalFacpl2.g:2584:4: enumLiteral_0= 'base'
                    {
                    enumLiteral_0=(Token)match(input,63,FOLLOW_2); 

                            current = grammarAccess.getPEPAlgAccess().getBASEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getPEPAlgAccess().getBASEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:2590:6: (enumLiteral_1= 'deny-biased' )
                    {
                    // InternalFacpl2.g:2590:6: (enumLiteral_1= 'deny-biased' )
                    // InternalFacpl2.g:2590:8: enumLiteral_1= 'deny-biased'
                    {
                    enumLiteral_1=(Token)match(input,64,FOLLOW_2); 

                            current = grammarAccess.getPEPAlgAccess().getDENYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getPEPAlgAccess().getDENYEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalFacpl2.g:2596:6: (enumLiteral_2= 'permit-biased' )
                    {
                    // InternalFacpl2.g:2596:6: (enumLiteral_2= 'permit-biased' )
                    // InternalFacpl2.g:2596:8: enumLiteral_2= 'permit-biased'
                    {
                    enumLiteral_2=(Token)match(input,65,FOLLOW_2); 

                            current = grammarAccess.getPEPAlgAccess().getPERMITEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getPEPAlgAccess().getPERMITEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePEPAlg"


    // $ANTLR start "ruleAlgLiteral"
    // InternalFacpl2.g:2606:1: ruleAlgLiteral returns [Enumerator current=null] : ( (enumLiteral_0= 'only-one-applicable' ) | (enumLiteral_1= 'deny-overrides' ) | (enumLiteral_2= 'permit-overrides' ) | (enumLiteral_3= 'first-applicable' ) | (enumLiteral_4= 'deny-unless-permit' ) | (enumLiteral_5= 'permit-unless-deny' ) | (enumLiteral_6= 'weak-consensus' ) | (enumLiteral_7= 'strong-consensus' ) | (enumLiteral_8= 'custom-algorithm' ) ) ;
    public final Enumerator ruleAlgLiteral() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;

         enterRule(); 
        try {
            // InternalFacpl2.g:2608:28: ( ( (enumLiteral_0= 'only-one-applicable' ) | (enumLiteral_1= 'deny-overrides' ) | (enumLiteral_2= 'permit-overrides' ) | (enumLiteral_3= 'first-applicable' ) | (enumLiteral_4= 'deny-unless-permit' ) | (enumLiteral_5= 'permit-unless-deny' ) | (enumLiteral_6= 'weak-consensus' ) | (enumLiteral_7= 'strong-consensus' ) | (enumLiteral_8= 'custom-algorithm' ) ) )
            // InternalFacpl2.g:2609:1: ( (enumLiteral_0= 'only-one-applicable' ) | (enumLiteral_1= 'deny-overrides' ) | (enumLiteral_2= 'permit-overrides' ) | (enumLiteral_3= 'first-applicable' ) | (enumLiteral_4= 'deny-unless-permit' ) | (enumLiteral_5= 'permit-unless-deny' ) | (enumLiteral_6= 'weak-consensus' ) | (enumLiteral_7= 'strong-consensus' ) | (enumLiteral_8= 'custom-algorithm' ) )
            {
            // InternalFacpl2.g:2609:1: ( (enumLiteral_0= 'only-one-applicable' ) | (enumLiteral_1= 'deny-overrides' ) | (enumLiteral_2= 'permit-overrides' ) | (enumLiteral_3= 'first-applicable' ) | (enumLiteral_4= 'deny-unless-permit' ) | (enumLiteral_5= 'permit-unless-deny' ) | (enumLiteral_6= 'weak-consensus' ) | (enumLiteral_7= 'strong-consensus' ) | (enumLiteral_8= 'custom-algorithm' ) )
            int alt39=9;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt39=1;
                }
                break;
            case 67:
                {
                alt39=2;
                }
                break;
            case 68:
                {
                alt39=3;
                }
                break;
            case 69:
                {
                alt39=4;
                }
                break;
            case 70:
                {
                alt39=5;
                }
                break;
            case 71:
                {
                alt39=6;
                }
                break;
            case 72:
                {
                alt39=7;
                }
                break;
            case 73:
                {
                alt39=8;
                }
                break;
            case 74:
                {
                alt39=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalFacpl2.g:2609:2: (enumLiteral_0= 'only-one-applicable' )
                    {
                    // InternalFacpl2.g:2609:2: (enumLiteral_0= 'only-one-applicable' )
                    // InternalFacpl2.g:2609:4: enumLiteral_0= 'only-one-applicable'
                    {
                    enumLiteral_0=(Token)match(input,66,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getONLY_ONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getAlgLiteralAccess().getONLY_ONEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:2615:6: (enumLiteral_1= 'deny-overrides' )
                    {
                    // InternalFacpl2.g:2615:6: (enumLiteral_1= 'deny-overrides' )
                    // InternalFacpl2.g:2615:8: enumLiteral_1= 'deny-overrides'
                    {
                    enumLiteral_1=(Token)match(input,67,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getDENY_OVEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getAlgLiteralAccess().getDENY_OVEREnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalFacpl2.g:2621:6: (enumLiteral_2= 'permit-overrides' )
                    {
                    // InternalFacpl2.g:2621:6: (enumLiteral_2= 'permit-overrides' )
                    // InternalFacpl2.g:2621:8: enumLiteral_2= 'permit-overrides'
                    {
                    enumLiteral_2=(Token)match(input,68,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getPERMIT_OVEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getAlgLiteralAccess().getPERMIT_OVEREnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalFacpl2.g:2627:6: (enumLiteral_3= 'first-applicable' )
                    {
                    // InternalFacpl2.g:2627:6: (enumLiteral_3= 'first-applicable' )
                    // InternalFacpl2.g:2627:8: enumLiteral_3= 'first-applicable'
                    {
                    enumLiteral_3=(Token)match(input,69,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getFIRSTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getAlgLiteralAccess().getFIRSTEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalFacpl2.g:2633:6: (enumLiteral_4= 'deny-unless-permit' )
                    {
                    // InternalFacpl2.g:2633:6: (enumLiteral_4= 'deny-unless-permit' )
                    // InternalFacpl2.g:2633:8: enumLiteral_4= 'deny-unless-permit'
                    {
                    enumLiteral_4=(Token)match(input,70,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getDENY_UNLESSEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getAlgLiteralAccess().getDENY_UNLESSEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // InternalFacpl2.g:2639:6: (enumLiteral_5= 'permit-unless-deny' )
                    {
                    // InternalFacpl2.g:2639:6: (enumLiteral_5= 'permit-unless-deny' )
                    // InternalFacpl2.g:2639:8: enumLiteral_5= 'permit-unless-deny'
                    {
                    enumLiteral_5=(Token)match(input,71,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getPERMIT_UNLESSEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getAlgLiteralAccess().getPERMIT_UNLESSEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // InternalFacpl2.g:2645:6: (enumLiteral_6= 'weak-consensus' )
                    {
                    // InternalFacpl2.g:2645:6: (enumLiteral_6= 'weak-consensus' )
                    // InternalFacpl2.g:2645:8: enumLiteral_6= 'weak-consensus'
                    {
                    enumLiteral_6=(Token)match(input,72,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getWEAK_CONSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getAlgLiteralAccess().getWEAK_CONSEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // InternalFacpl2.g:2651:6: (enumLiteral_7= 'strong-consensus' )
                    {
                    // InternalFacpl2.g:2651:6: (enumLiteral_7= 'strong-consensus' )
                    // InternalFacpl2.g:2651:8: enumLiteral_7= 'strong-consensus'
                    {
                    enumLiteral_7=(Token)match(input,73,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getSTRONG_CONSEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getAlgLiteralAccess().getSTRONG_CONSEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // InternalFacpl2.g:2657:6: (enumLiteral_8= 'custom-algorithm' )
                    {
                    // InternalFacpl2.g:2657:6: (enumLiteral_8= 'custom-algorithm' )
                    // InternalFacpl2.g:2657:8: enumLiteral_8= 'custom-algorithm'
                    {
                    enumLiteral_8=(Token)match(input,74,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getCUSTOM_ALGEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getAlgLiteralAccess().getCUSTOM_ALGEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlgLiteral"


    // $ANTLR start "ruleFulfillmentStrategy"
    // InternalFacpl2.g:2667:1: ruleFulfillmentStrategy returns [Enumerator current=null] : ( (enumLiteral_0= 'greedy' ) | (enumLiteral_1= 'all' ) ) ;
    public final Enumerator ruleFulfillmentStrategy() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalFacpl2.g:2669:28: ( ( (enumLiteral_0= 'greedy' ) | (enumLiteral_1= 'all' ) ) )
            // InternalFacpl2.g:2670:1: ( (enumLiteral_0= 'greedy' ) | (enumLiteral_1= 'all' ) )
            {
            // InternalFacpl2.g:2670:1: ( (enumLiteral_0= 'greedy' ) | (enumLiteral_1= 'all' ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==75) ) {
                alt40=1;
            }
            else if ( (LA40_0==76) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalFacpl2.g:2670:2: (enumLiteral_0= 'greedy' )
                    {
                    // InternalFacpl2.g:2670:2: (enumLiteral_0= 'greedy' )
                    // InternalFacpl2.g:2670:4: enumLiteral_0= 'greedy'
                    {
                    enumLiteral_0=(Token)match(input,75,FOLLOW_2); 

                            current = grammarAccess.getFulfillmentStrategyAccess().getGREEDYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getFulfillmentStrategyAccess().getGREEDYEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:2676:6: (enumLiteral_1= 'all' )
                    {
                    // InternalFacpl2.g:2676:6: (enumLiteral_1= 'all' )
                    // InternalFacpl2.g:2676:8: enumLiteral_1= 'all'
                    {
                    enumLiteral_1=(Token)match(input,76,FOLLOW_2); 

                            current = grammarAccess.getFulfillmentStrategyAccess().getALLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getFulfillmentStrategyAccess().getALLEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFulfillmentStrategy"


    // $ANTLR start "ruleEffect"
    // InternalFacpl2.g:2686:1: ruleEffect returns [Enumerator current=null] : ( (enumLiteral_0= 'permit' ) | (enumLiteral_1= 'deny' ) ) ;
    public final Enumerator ruleEffect() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalFacpl2.g:2688:28: ( ( (enumLiteral_0= 'permit' ) | (enumLiteral_1= 'deny' ) ) )
            // InternalFacpl2.g:2689:1: ( (enumLiteral_0= 'permit' ) | (enumLiteral_1= 'deny' ) )
            {
            // InternalFacpl2.g:2689:1: ( (enumLiteral_0= 'permit' ) | (enumLiteral_1= 'deny' ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==77) ) {
                alt41=1;
            }
            else if ( (LA41_0==78) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalFacpl2.g:2689:2: (enumLiteral_0= 'permit' )
                    {
                    // InternalFacpl2.g:2689:2: (enumLiteral_0= 'permit' )
                    // InternalFacpl2.g:2689:4: enumLiteral_0= 'permit'
                    {
                    enumLiteral_0=(Token)match(input,77,FOLLOW_2); 

                            current = grammarAccess.getEffectAccess().getPERMITEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEffectAccess().getPERMITEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:2695:6: (enumLiteral_1= 'deny' )
                    {
                    // InternalFacpl2.g:2695:6: (enumLiteral_1= 'deny' )
                    // InternalFacpl2.g:2695:8: enumLiteral_1= 'deny'
                    {
                    enumLiteral_1=(Token)match(input,78,FOLLOW_2); 

                            current = grammarAccess.getEffectAccess().getDENYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getEffectAccess().getDENYEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEffect"


    // $ANTLR start "rulefunID"
    // InternalFacpl2.g:2705:1: rulefunID returns [Enumerator current=null] : ( (enumLiteral_0= 'equal' ) | (enumLiteral_1= 'not-equal' ) | (enumLiteral_2= 'less-than' ) | (enumLiteral_3= 'less-than-or-equal' ) | (enumLiteral_4= 'greater-than' ) | (enumLiteral_5= 'greater-than-or-equal' ) | (enumLiteral_6= 'in' ) | (enumLiteral_7= 'addition' ) | (enumLiteral_8= 'subtract' ) | (enumLiteral_9= 'divide' ) | (enumLiteral_10= 'multiply' ) ) ;
    public final Enumerator rulefunID() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;

         enterRule(); 
        try {
            // InternalFacpl2.g:2707:28: ( ( (enumLiteral_0= 'equal' ) | (enumLiteral_1= 'not-equal' ) | (enumLiteral_2= 'less-than' ) | (enumLiteral_3= 'less-than-or-equal' ) | (enumLiteral_4= 'greater-than' ) | (enumLiteral_5= 'greater-than-or-equal' ) | (enumLiteral_6= 'in' ) | (enumLiteral_7= 'addition' ) | (enumLiteral_8= 'subtract' ) | (enumLiteral_9= 'divide' ) | (enumLiteral_10= 'multiply' ) ) )
            // InternalFacpl2.g:2708:1: ( (enumLiteral_0= 'equal' ) | (enumLiteral_1= 'not-equal' ) | (enumLiteral_2= 'less-than' ) | (enumLiteral_3= 'less-than-or-equal' ) | (enumLiteral_4= 'greater-than' ) | (enumLiteral_5= 'greater-than-or-equal' ) | (enumLiteral_6= 'in' ) | (enumLiteral_7= 'addition' ) | (enumLiteral_8= 'subtract' ) | (enumLiteral_9= 'divide' ) | (enumLiteral_10= 'multiply' ) )
            {
            // InternalFacpl2.g:2708:1: ( (enumLiteral_0= 'equal' ) | (enumLiteral_1= 'not-equal' ) | (enumLiteral_2= 'less-than' ) | (enumLiteral_3= 'less-than-or-equal' ) | (enumLiteral_4= 'greater-than' ) | (enumLiteral_5= 'greater-than-or-equal' ) | (enumLiteral_6= 'in' ) | (enumLiteral_7= 'addition' ) | (enumLiteral_8= 'subtract' ) | (enumLiteral_9= 'divide' ) | (enumLiteral_10= 'multiply' ) )
            int alt42=11;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt42=1;
                }
                break;
            case 80:
                {
                alt42=2;
                }
                break;
            case 81:
                {
                alt42=3;
                }
                break;
            case 82:
                {
                alt42=4;
                }
                break;
            case 83:
                {
                alt42=5;
                }
                break;
            case 84:
                {
                alt42=6;
                }
                break;
            case 85:
                {
                alt42=7;
                }
                break;
            case 86:
                {
                alt42=8;
                }
                break;
            case 87:
                {
                alt42=9;
                }
                break;
            case 88:
                {
                alt42=10;
                }
                break;
            case 89:
                {
                alt42=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalFacpl2.g:2708:2: (enumLiteral_0= 'equal' )
                    {
                    // InternalFacpl2.g:2708:2: (enumLiteral_0= 'equal' )
                    // InternalFacpl2.g:2708:4: enumLiteral_0= 'equal'
                    {
                    enumLiteral_0=(Token)match(input,79,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getEQUALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getFunIDAccess().getEQUALEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:2714:6: (enumLiteral_1= 'not-equal' )
                    {
                    // InternalFacpl2.g:2714:6: (enumLiteral_1= 'not-equal' )
                    // InternalFacpl2.g:2714:8: enumLiteral_1= 'not-equal'
                    {
                    enumLiteral_1=(Token)match(input,80,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getN_EQUALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getFunIDAccess().getN_EQUALEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalFacpl2.g:2720:6: (enumLiteral_2= 'less-than' )
                    {
                    // InternalFacpl2.g:2720:6: (enumLiteral_2= 'less-than' )
                    // InternalFacpl2.g:2720:8: enumLiteral_2= 'less-than'
                    {
                    enumLiteral_2=(Token)match(input,81,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getLESSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getFunIDAccess().getLESSEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalFacpl2.g:2726:6: (enumLiteral_3= 'less-than-or-equal' )
                    {
                    // InternalFacpl2.g:2726:6: (enumLiteral_3= 'less-than-or-equal' )
                    // InternalFacpl2.g:2726:8: enumLiteral_3= 'less-than-or-equal'
                    {
                    enumLiteral_3=(Token)match(input,82,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getLESS_EQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getFunIDAccess().getLESS_EQEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalFacpl2.g:2732:6: (enumLiteral_4= 'greater-than' )
                    {
                    // InternalFacpl2.g:2732:6: (enumLiteral_4= 'greater-than' )
                    // InternalFacpl2.g:2732:8: enumLiteral_4= 'greater-than'
                    {
                    enumLiteral_4=(Token)match(input,83,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getGREATEREnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getFunIDAccess().getGREATEREnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // InternalFacpl2.g:2738:6: (enumLiteral_5= 'greater-than-or-equal' )
                    {
                    // InternalFacpl2.g:2738:6: (enumLiteral_5= 'greater-than-or-equal' )
                    // InternalFacpl2.g:2738:8: enumLiteral_5= 'greater-than-or-equal'
                    {
                    enumLiteral_5=(Token)match(input,84,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getGREATER_EQEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getFunIDAccess().getGREATER_EQEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // InternalFacpl2.g:2744:6: (enumLiteral_6= 'in' )
                    {
                    // InternalFacpl2.g:2744:6: (enumLiteral_6= 'in' )
                    // InternalFacpl2.g:2744:8: enumLiteral_6= 'in'
                    {
                    enumLiteral_6=(Token)match(input,85,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getINEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getFunIDAccess().getINEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // InternalFacpl2.g:2750:6: (enumLiteral_7= 'addition' )
                    {
                    // InternalFacpl2.g:2750:6: (enumLiteral_7= 'addition' )
                    // InternalFacpl2.g:2750:8: enumLiteral_7= 'addition'
                    {
                    enumLiteral_7=(Token)match(input,86,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getADDEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getFunIDAccess().getADDEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // InternalFacpl2.g:2756:6: (enumLiteral_8= 'subtract' )
                    {
                    // InternalFacpl2.g:2756:6: (enumLiteral_8= 'subtract' )
                    // InternalFacpl2.g:2756:8: enumLiteral_8= 'subtract'
                    {
                    enumLiteral_8=(Token)match(input,87,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getSUBTRACTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getFunIDAccess().getSUBTRACTEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // InternalFacpl2.g:2762:6: (enumLiteral_9= 'divide' )
                    {
                    // InternalFacpl2.g:2762:6: (enumLiteral_9= 'divide' )
                    // InternalFacpl2.g:2762:8: enumLiteral_9= 'divide'
                    {
                    enumLiteral_9=(Token)match(input,88,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getDIVIDEEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getFunIDAccess().getDIVIDEEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // InternalFacpl2.g:2768:6: (enumLiteral_10= 'multiply' )
                    {
                    // InternalFacpl2.g:2768:6: (enumLiteral_10= 'multiply' )
                    // InternalFacpl2.g:2768:8: enumLiteral_10= 'multiply'
                    {
                    enumLiteral_10=(Token)match(input,89,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getMULTIPLYEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getFunIDAccess().getMULTIPLYEnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulefunID"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000008084018002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000E00000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x7FE0000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100020000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000000000A000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00100000000007F0L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000003800080002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x000010C000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x000010C000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x001C0000080007F0L,0x0000000003FF8000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00001CC002000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000080102000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000102000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001800L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000006000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000210010000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000110000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x001C0000180007F0L,0x0000000003FF8000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x001C0000190007F0L,0x0000000003FF8000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000003FF8000L});

}
