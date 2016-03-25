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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_BOOLEAN", "RULE_INT", "RULE_REAL", "RULE_DATE", "RULE_TIME", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'PAS'", "'{'", "'Extended Indeterminate'", "':'", "';'", "'Java Package'", "'Requests To Evaluate'", "','", "'}'", "'dec-fun'", "'('", "')'", "'pep:'", "'pdp:'", "'status:'", "'['", "']'", "'boolean'", "'='", "'int'", "'date'", "'float'", "'string'", "'add-status'", "'sub-status'", "'div-status'", "'mul-status'", "'sum-date'", "'set-date'", "'set-string'", "'sum-string'", "'flag-status'", "'M'", "'O'", "'Request:'", "'/'", "'_'", "'-'", "'.'", "'include'", "'PolicySet'", "'target:'", "'policies:'", "'obl:'", "'Rule'", "'&&'", "'||'", "'!'", "'status'", "'set('", "'Int'", "'Double'", "'Bool'", "'String'", "'DateTime'", "'Set<Int>'", "'Set<Double>'", "'Set<Bool>'", "'Set<String>'", "'Set<DateTime>'", "'base'", "'deny-biased'", "'permit-biased'", "'only-one-applicable'", "'deny-overrides'", "'permit-overrides'", "'first-applicable'", "'deny-unless-permit'", "'permit-unless-deny'", "'weak-consensus'", "'strong-consensus'", "'custom-algorithm'", "'greedy'", "'all'", "'permit'", "'deny'", "'equal'", "'not-equal'", "'less-than'", "'less-than-or-equal'", "'greater-than'", "'greater-than-or-equal'", "'in'", "'addition'", "'subtract'", "'divide'", "'multiply'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
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
    public static final int RULE_INT=7;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int RULE_BOOLEAN=6;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
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
                else if ( LA5_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 1) ) {
                    alt5=2;
                }
                else if ( LA5_0 == 56 && getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 2) ) {
                    alt5=3;
                }
                else if ( LA5_0 == 50 && getUnorderedGroupHelper().canSelect(grammarAccess.getFacplAccess().getUnorderedGroup(), 3) ) {
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

            	        if ( (LA2_0==25) ) {
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

            	        if ( (LA3_0==56) ) {
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

            	        if ( (LA4_0==50) ) {
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
    // InternalFacpl2.g:307:1: ruleMainFacpl returns [EObject current=null] : (otherlv_0= 'PAS' otherlv_1= '{' otherlv_2= 'Extended Indeterminate' otherlv_3= ':' ( (lv_extIndet_4_0= ruleBooleanLiteral ) ) otherlv_5= ';' (otherlv_6= 'Java Package' otherlv_7= ':' ( (lv_genPackage_8_0= RULE_STRING ) ) otherlv_9= ';' )? (otherlv_10= 'Requests To Evaluate' otherlv_11= ':' ( ( (otherlv_12= RULE_ID ) ) (otherlv_13= ',' ( (otherlv_14= RULE_ID ) ) )* ) otherlv_15= ';' ) ( (lv_paf_16_0= rulePAF ) ) otherlv_17= '}' ) ;
    public final EObject ruleMainFacpl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_genPackage_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        EObject lv_extIndet_4_0 = null;

        EObject lv_paf_16_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:310:28: ( (otherlv_0= 'PAS' otherlv_1= '{' otherlv_2= 'Extended Indeterminate' otherlv_3= ':' ( (lv_extIndet_4_0= ruleBooleanLiteral ) ) otherlv_5= ';' (otherlv_6= 'Java Package' otherlv_7= ':' ( (lv_genPackage_8_0= RULE_STRING ) ) otherlv_9= ';' )? (otherlv_10= 'Requests To Evaluate' otherlv_11= ':' ( ( (otherlv_12= RULE_ID ) ) (otherlv_13= ',' ( (otherlv_14= RULE_ID ) ) )* ) otherlv_15= ';' ) ( (lv_paf_16_0= rulePAF ) ) otherlv_17= '}' ) )
            // InternalFacpl2.g:311:1: (otherlv_0= 'PAS' otherlv_1= '{' otherlv_2= 'Extended Indeterminate' otherlv_3= ':' ( (lv_extIndet_4_0= ruleBooleanLiteral ) ) otherlv_5= ';' (otherlv_6= 'Java Package' otherlv_7= ':' ( (lv_genPackage_8_0= RULE_STRING ) ) otherlv_9= ';' )? (otherlv_10= 'Requests To Evaluate' otherlv_11= ':' ( ( (otherlv_12= RULE_ID ) ) (otherlv_13= ',' ( (otherlv_14= RULE_ID ) ) )* ) otherlv_15= ';' ) ( (lv_paf_16_0= rulePAF ) ) otherlv_17= '}' )
            {
            // InternalFacpl2.g:311:1: (otherlv_0= 'PAS' otherlv_1= '{' otherlv_2= 'Extended Indeterminate' otherlv_3= ':' ( (lv_extIndet_4_0= ruleBooleanLiteral ) ) otherlv_5= ';' (otherlv_6= 'Java Package' otherlv_7= ':' ( (lv_genPackage_8_0= RULE_STRING ) ) otherlv_9= ';' )? (otherlv_10= 'Requests To Evaluate' otherlv_11= ':' ( ( (otherlv_12= RULE_ID ) ) (otherlv_13= ',' ( (otherlv_14= RULE_ID ) ) )* ) otherlv_15= ';' ) ( (lv_paf_16_0= rulePAF ) ) otherlv_17= '}' )
            // InternalFacpl2.g:311:3: otherlv_0= 'PAS' otherlv_1= '{' otherlv_2= 'Extended Indeterminate' otherlv_3= ':' ( (lv_extIndet_4_0= ruleBooleanLiteral ) ) otherlv_5= ';' (otherlv_6= 'Java Package' otherlv_7= ':' ( (lv_genPackage_8_0= RULE_STRING ) ) otherlv_9= ';' )? (otherlv_10= 'Requests To Evaluate' otherlv_11= ':' ( ( (otherlv_12= RULE_ID ) ) (otherlv_13= ',' ( (otherlv_14= RULE_ID ) ) )* ) otherlv_15= ';' ) ( (lv_paf_16_0= rulePAF ) ) otherlv_17= '}'
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
                
            // InternalFacpl2.g:349:1: (otherlv_6= 'Java Package' otherlv_7= ':' ( (lv_genPackage_8_0= RULE_STRING ) ) otherlv_9= ';' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalFacpl2.g:349:3: otherlv_6= 'Java Package' otherlv_7= ':' ( (lv_genPackage_8_0= RULE_STRING ) ) otherlv_9= ';'
                    {
                    otherlv_6=(Token)match(input,21,FOLLOW_7); 

                        	newLeafNode(otherlv_6, grammarAccess.getMainFacplAccess().getJavaPackageKeyword_6_0());
                        
                    otherlv_7=(Token)match(input,19,FOLLOW_4); 

                        	newLeafNode(otherlv_7, grammarAccess.getMainFacplAccess().getColonKeyword_6_1());
                        
                    // InternalFacpl2.g:357:1: ( (lv_genPackage_8_0= RULE_STRING ) )
                    // InternalFacpl2.g:358:1: (lv_genPackage_8_0= RULE_STRING )
                    {
                    // InternalFacpl2.g:358:1: (lv_genPackage_8_0= RULE_STRING )
                    // InternalFacpl2.g:359:3: lv_genPackage_8_0= RULE_STRING
                    {
                    lv_genPackage_8_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

                    			newLeafNode(lv_genPackage_8_0, grammarAccess.getMainFacplAccess().getGenPackageSTRINGTerminalRuleCall_6_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMainFacplRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"genPackage",
                            		lv_genPackage_8_0, 
                            		"it.unifi.xtext.facpl.Facpl2.STRING");
                    	    

                    }


                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_11); 

                        	newLeafNode(otherlv_9, grammarAccess.getMainFacplAccess().getSemicolonKeyword_6_3());
                        

                    }
                    break;

            }

            // InternalFacpl2.g:379:3: (otherlv_10= 'Requests To Evaluate' otherlv_11= ':' ( ( (otherlv_12= RULE_ID ) ) (otherlv_13= ',' ( (otherlv_14= RULE_ID ) ) )* ) otherlv_15= ';' )
            // InternalFacpl2.g:379:5: otherlv_10= 'Requests To Evaluate' otherlv_11= ':' ( ( (otherlv_12= RULE_ID ) ) (otherlv_13= ',' ( (otherlv_14= RULE_ID ) ) )* ) otherlv_15= ';'
            {
            otherlv_10=(Token)match(input,22,FOLLOW_7); 

                	newLeafNode(otherlv_10, grammarAccess.getMainFacplAccess().getRequestsToEvaluateKeyword_7_0());
                
            otherlv_11=(Token)match(input,19,FOLLOW_12); 

                	newLeafNode(otherlv_11, grammarAccess.getMainFacplAccess().getColonKeyword_7_1());
                
            // InternalFacpl2.g:387:1: ( ( (otherlv_12= RULE_ID ) ) (otherlv_13= ',' ( (otherlv_14= RULE_ID ) ) )* )
            // InternalFacpl2.g:387:2: ( (otherlv_12= RULE_ID ) ) (otherlv_13= ',' ( (otherlv_14= RULE_ID ) ) )*
            {
            // InternalFacpl2.g:387:2: ( (otherlv_12= RULE_ID ) )
            // InternalFacpl2.g:388:1: (otherlv_12= RULE_ID )
            {
            // InternalFacpl2.g:388:1: (otherlv_12= RULE_ID )
            // InternalFacpl2.g:389:3: otherlv_12= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMainFacplRule());
            	        }
                    
            otherlv_12=(Token)match(input,RULE_ID,FOLLOW_13); 

            		newLeafNode(otherlv_12, grammarAccess.getMainFacplAccess().getRefRequestRequestCrossReference_7_2_0_0()); 
            	

            }


            }

            // InternalFacpl2.g:400:2: (otherlv_13= ',' ( (otherlv_14= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==23) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalFacpl2.g:400:4: otherlv_13= ',' ( (otherlv_14= RULE_ID ) )
            	    {
            	    otherlv_13=(Token)match(input,23,FOLLOW_12); 

            	        	newLeafNode(otherlv_13, grammarAccess.getMainFacplAccess().getCommaKeyword_7_2_1_0());
            	        
            	    // InternalFacpl2.g:404:1: ( (otherlv_14= RULE_ID ) )
            	    // InternalFacpl2.g:405:1: (otherlv_14= RULE_ID )
            	    {
            	    // InternalFacpl2.g:405:1: (otherlv_14= RULE_ID )
            	    // InternalFacpl2.g:406:3: otherlv_14= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getMainFacplRule());
            	    	        }
            	            
            	    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_13); 

            	    		newLeafNode(otherlv_14, grammarAccess.getMainFacplAccess().getRefRequestRequestCrossReference_7_2_1_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            otherlv_15=(Token)match(input,20,FOLLOW_14); 

                	newLeafNode(otherlv_15, grammarAccess.getMainFacplAccess().getSemicolonKeyword_7_3());
                

            }

            // InternalFacpl2.g:421:2: ( (lv_paf_16_0= rulePAF ) )
            // InternalFacpl2.g:422:1: (lv_paf_16_0= rulePAF )
            {
            // InternalFacpl2.g:422:1: (lv_paf_16_0= rulePAF )
            // InternalFacpl2.g:423:3: lv_paf_16_0= rulePAF
            {
             
            	        newCompositeNode(grammarAccess.getMainFacplAccess().getPafPAFParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_15);
            lv_paf_16_0=rulePAF();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMainFacplRule());
            	        }
                   		set(
                   			current, 
                   			"paf",
                    		lv_paf_16_0, 
                    		"it.unifi.xtext.facpl.Facpl2.PAF");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_17=(Token)match(input,24,FOLLOW_2); 

                	newLeafNode(otherlv_17, grammarAccess.getMainFacplAccess().getRightCurlyBracketKeyword_9());
                

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
    // InternalFacpl2.g:451:1: entryRuleFunctionDeclaration returns [EObject current=null] : iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF ;
    public final EObject entryRuleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDeclaration = null;


        try {
            // InternalFacpl2.g:452:2: (iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF )
            // InternalFacpl2.g:453:2: iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF
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
    // InternalFacpl2.g:460:1: ruleFunctionDeclaration returns [EObject current=null] : (otherlv_0= 'dec-fun' ( (lv_type_1_0= ruleTypeLiteral ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_args_4_0= ruleTypeLiteral ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) ) )* otherlv_7= ')' ) ;
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
            // InternalFacpl2.g:463:28: ( (otherlv_0= 'dec-fun' ( (lv_type_1_0= ruleTypeLiteral ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_args_4_0= ruleTypeLiteral ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) ) )* otherlv_7= ')' ) )
            // InternalFacpl2.g:464:1: (otherlv_0= 'dec-fun' ( (lv_type_1_0= ruleTypeLiteral ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_args_4_0= ruleTypeLiteral ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) ) )* otherlv_7= ')' )
            {
            // InternalFacpl2.g:464:1: (otherlv_0= 'dec-fun' ( (lv_type_1_0= ruleTypeLiteral ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_args_4_0= ruleTypeLiteral ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) ) )* otherlv_7= ')' )
            // InternalFacpl2.g:464:3: otherlv_0= 'dec-fun' ( (lv_type_1_0= ruleTypeLiteral ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_args_4_0= ruleTypeLiteral ) ) (otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) ) )* otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_16); 

                	newLeafNode(otherlv_0, grammarAccess.getFunctionDeclarationAccess().getDecFunKeyword_0());
                
            // InternalFacpl2.g:468:1: ( (lv_type_1_0= ruleTypeLiteral ) )
            // InternalFacpl2.g:469:1: (lv_type_1_0= ruleTypeLiteral )
            {
            // InternalFacpl2.g:469:1: (lv_type_1_0= ruleTypeLiteral )
            // InternalFacpl2.g:470:3: lv_type_1_0= ruleTypeLiteral
            {
             
            	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getTypeTypeLiteralEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_12);
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

            // InternalFacpl2.g:486:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalFacpl2.g:487:1: (lv_name_2_0= RULE_ID )
            {
            // InternalFacpl2.g:487:1: (lv_name_2_0= RULE_ID )
            // InternalFacpl2.g:488:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_17); 

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

            otherlv_3=(Token)match(input,26,FOLLOW_16); 

                	newLeafNode(otherlv_3, grammarAccess.getFunctionDeclarationAccess().getLeftParenthesisKeyword_3());
                
            // InternalFacpl2.g:508:1: ( (lv_args_4_0= ruleTypeLiteral ) )
            // InternalFacpl2.g:509:1: (lv_args_4_0= ruleTypeLiteral )
            {
            // InternalFacpl2.g:509:1: (lv_args_4_0= ruleTypeLiteral )
            // InternalFacpl2.g:510:3: lv_args_4_0= ruleTypeLiteral
            {
             
            	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getArgsTypeLiteralEnumRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_18);
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

            // InternalFacpl2.g:526:2: (otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==23) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalFacpl2.g:526:4: otherlv_5= ',' ( (lv_args_6_0= ruleTypeLiteral ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_16); 

            	        	newLeafNode(otherlv_5, grammarAccess.getFunctionDeclarationAccess().getCommaKeyword_5_0());
            	        
            	    // InternalFacpl2.g:530:1: ( (lv_args_6_0= ruleTypeLiteral ) )
            	    // InternalFacpl2.g:531:1: (lv_args_6_0= ruleTypeLiteral )
            	    {
            	    // InternalFacpl2.g:531:1: (lv_args_6_0= ruleTypeLiteral )
            	    // InternalFacpl2.g:532:3: lv_args_6_0= ruleTypeLiteral
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getArgsTypeLiteralEnumRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_18);
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
            	    break loop8;
                }
            } while (true);

            otherlv_7=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFacpl2.g:560:1: entryRulePAF returns [EObject current=null] : iv_rulePAF= rulePAF EOF ;
    public final EObject entryRulePAF() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePAF = null;


        try {
            // InternalFacpl2.g:561:2: (iv_rulePAF= rulePAF EOF )
            // InternalFacpl2.g:562:2: iv_rulePAF= rulePAF EOF
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
    // InternalFacpl2.g:569:1: rulePAF returns [EObject current=null] : ( ( (lv_status_0_0= ruleSTATUS ) )? otherlv_1= 'pep:' ( (lv_pep_2_0= rulePEPAlg ) ) otherlv_3= 'pdp:' ( (lv_pdp_4_0= rulePDP ) ) ) ;
    public final EObject rulePAF() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_status_0_0 = null;

        Enumerator lv_pep_2_0 = null;

        EObject lv_pdp_4_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:572:28: ( ( ( (lv_status_0_0= ruleSTATUS ) )? otherlv_1= 'pep:' ( (lv_pep_2_0= rulePEPAlg ) ) otherlv_3= 'pdp:' ( (lv_pdp_4_0= rulePDP ) ) ) )
            // InternalFacpl2.g:573:1: ( ( (lv_status_0_0= ruleSTATUS ) )? otherlv_1= 'pep:' ( (lv_pep_2_0= rulePEPAlg ) ) otherlv_3= 'pdp:' ( (lv_pdp_4_0= rulePDP ) ) )
            {
            // InternalFacpl2.g:573:1: ( ( (lv_status_0_0= ruleSTATUS ) )? otherlv_1= 'pep:' ( (lv_pep_2_0= rulePEPAlg ) ) otherlv_3= 'pdp:' ( (lv_pdp_4_0= rulePDP ) ) )
            // InternalFacpl2.g:573:2: ( (lv_status_0_0= ruleSTATUS ) )? otherlv_1= 'pep:' ( (lv_pep_2_0= rulePEPAlg ) ) otherlv_3= 'pdp:' ( (lv_pdp_4_0= rulePDP ) )
            {
            // InternalFacpl2.g:573:2: ( (lv_status_0_0= ruleSTATUS ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==30) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalFacpl2.g:574:1: (lv_status_0_0= ruleSTATUS )
                    {
                    // InternalFacpl2.g:574:1: (lv_status_0_0= ruleSTATUS )
                    // InternalFacpl2.g:575:3: lv_status_0_0= ruleSTATUS
                    {
                     
                    	        newCompositeNode(grammarAccess.getPAFAccess().getStatusSTATUSParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_19);
                    lv_status_0_0=ruleSTATUS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPAFRule());
                    	        }
                           		set(
                           			current, 
                           			"status",
                            		lv_status_0_0, 
                            		"it.unifi.xtext.facpl.Facpl2.STATUS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,28,FOLLOW_20); 

                	newLeafNode(otherlv_1, grammarAccess.getPAFAccess().getPepKeyword_1());
                
            // InternalFacpl2.g:595:1: ( (lv_pep_2_0= rulePEPAlg ) )
            // InternalFacpl2.g:596:1: (lv_pep_2_0= rulePEPAlg )
            {
            // InternalFacpl2.g:596:1: (lv_pep_2_0= rulePEPAlg )
            // InternalFacpl2.g:597:3: lv_pep_2_0= rulePEPAlg
            {
             
            	        newCompositeNode(grammarAccess.getPAFAccess().getPepPEPAlgEnumRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_21);
            lv_pep_2_0=rulePEPAlg();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPAFRule());
            	        }
                   		set(
                   			current, 
                   			"pep",
                    		lv_pep_2_0, 
                    		"it.unifi.xtext.facpl.Facpl2.PEPAlg");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_22); 

                	newLeafNode(otherlv_3, grammarAccess.getPAFAccess().getPdpKeyword_3());
                
            // InternalFacpl2.g:617:1: ( (lv_pdp_4_0= rulePDP ) )
            // InternalFacpl2.g:618:1: (lv_pdp_4_0= rulePDP )
            {
            // InternalFacpl2.g:618:1: (lv_pdp_4_0= rulePDP )
            // InternalFacpl2.g:619:3: lv_pdp_4_0= rulePDP
            {
             
            	        newCompositeNode(grammarAccess.getPAFAccess().getPdpPDPParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_pdp_4_0=rulePDP();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPAFRule());
            	        }
                   		set(
                   			current, 
                   			"pdp",
                    		lv_pdp_4_0, 
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


    // $ANTLR start "entryRuleSTATUS"
    // InternalFacpl2.g:643:1: entryRuleSTATUS returns [EObject current=null] : iv_ruleSTATUS= ruleSTATUS EOF ;
    public final EObject entryRuleSTATUS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSTATUS = null;


        try {
            // InternalFacpl2.g:644:2: (iv_ruleSTATUS= ruleSTATUS EOF )
            // InternalFacpl2.g:645:2: iv_ruleSTATUS= ruleSTATUS EOF
            {
             newCompositeNode(grammarAccess.getSTATUSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSTATUS=ruleSTATUS();

            state._fsp--;

             current =iv_ruleSTATUS; 
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
    // $ANTLR end "entryRuleSTATUS"


    // $ANTLR start "ruleSTATUS"
    // InternalFacpl2.g:652:1: ruleSTATUS returns [EObject current=null] : (otherlv_0= 'status:' otherlv_1= '[' ( (lv_elements_2_0= ruleAttributeDeclaration ) )+ otherlv_3= ']' ) ;
    public final EObject ruleSTATUS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:655:28: ( (otherlv_0= 'status:' otherlv_1= '[' ( (lv_elements_2_0= ruleAttributeDeclaration ) )+ otherlv_3= ']' ) )
            // InternalFacpl2.g:656:1: (otherlv_0= 'status:' otherlv_1= '[' ( (lv_elements_2_0= ruleAttributeDeclaration ) )+ otherlv_3= ']' )
            {
            // InternalFacpl2.g:656:1: (otherlv_0= 'status:' otherlv_1= '[' ( (lv_elements_2_0= ruleAttributeDeclaration ) )+ otherlv_3= ']' )
            // InternalFacpl2.g:656:3: otherlv_0= 'status:' otherlv_1= '[' ( (lv_elements_2_0= ruleAttributeDeclaration ) )+ otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_23); 

                	newLeafNode(otherlv_0, grammarAccess.getSTATUSAccess().getStatusKeyword_0());
                
            otherlv_1=(Token)match(input,31,FOLLOW_17); 

                	newLeafNode(otherlv_1, grammarAccess.getSTATUSAccess().getLeftSquareBracketKeyword_1());
                
            // InternalFacpl2.g:664:1: ( (lv_elements_2_0= ruleAttributeDeclaration ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==26) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalFacpl2.g:665:1: (lv_elements_2_0= ruleAttributeDeclaration )
            	    {
            	    // InternalFacpl2.g:665:1: (lv_elements_2_0= ruleAttributeDeclaration )
            	    // InternalFacpl2.g:666:3: lv_elements_2_0= ruleAttributeDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSTATUSAccess().getElementsAttributeDeclarationParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_24);
            	    lv_elements_2_0=ruleAttributeDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSTATUSRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_2_0, 
            	            		"it.unifi.xtext.facpl.Facpl2.AttributeDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            otherlv_3=(Token)match(input,32,FOLLOW_2); 

                	newLeafNode(otherlv_3, grammarAccess.getSTATUSAccess().getRightSquareBracketKeyword_3());
                

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
    // $ANTLR end "ruleSTATUS"


    // $ANTLR start "entryRuleAttribute"
    // InternalFacpl2.g:694:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalFacpl2.g:695:2: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalFacpl2.g:696:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalFacpl2.g:703:1: ruleAttribute returns [EObject current=null] : ( ( ( (lv_type_0_0= 'boolean' ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_x_3_0= ruleBooleanLiteral ) ) ) | ( ( (lv_type_4_0= 'int' ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '=' ( (lv_x_7_0= ruleIntLiteral ) ) ) | ( ( (lv_type_8_0= 'date' ) ) ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_x_11_1= ruleDateLiteral | lv_x_11_2= ruleTimeLiteral ) ) ) ) | ( ( (lv_type_12_0= 'float' ) ) ( (lv_name_13_0= RULE_ID ) ) otherlv_14= '=' ( ( (lv_x_15_1= ruleIntLiteral | lv_x_15_2= ruleDoubleLiteral ) ) ) ) | ( ( (lv_type_16_0= 'string' ) ) ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '=' ( (lv_x_19_0= ruleStringLiteral ) ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_type_4_0=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token lv_type_8_0=null;
        Token lv_name_9_0=null;
        Token otherlv_10=null;
        Token lv_type_12_0=null;
        Token lv_name_13_0=null;
        Token otherlv_14=null;
        Token lv_type_16_0=null;
        Token lv_name_17_0=null;
        Token otherlv_18=null;
        EObject lv_x_3_0 = null;

        EObject lv_x_7_0 = null;

        EObject lv_x_11_1 = null;

        EObject lv_x_11_2 = null;

        EObject lv_x_15_1 = null;

        EObject lv_x_15_2 = null;

        EObject lv_x_19_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:706:28: ( ( ( ( (lv_type_0_0= 'boolean' ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_x_3_0= ruleBooleanLiteral ) ) ) | ( ( (lv_type_4_0= 'int' ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '=' ( (lv_x_7_0= ruleIntLiteral ) ) ) | ( ( (lv_type_8_0= 'date' ) ) ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_x_11_1= ruleDateLiteral | lv_x_11_2= ruleTimeLiteral ) ) ) ) | ( ( (lv_type_12_0= 'float' ) ) ( (lv_name_13_0= RULE_ID ) ) otherlv_14= '=' ( ( (lv_x_15_1= ruleIntLiteral | lv_x_15_2= ruleDoubleLiteral ) ) ) ) | ( ( (lv_type_16_0= 'string' ) ) ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '=' ( (lv_x_19_0= ruleStringLiteral ) ) ) ) )
            // InternalFacpl2.g:707:1: ( ( ( (lv_type_0_0= 'boolean' ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_x_3_0= ruleBooleanLiteral ) ) ) | ( ( (lv_type_4_0= 'int' ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '=' ( (lv_x_7_0= ruleIntLiteral ) ) ) | ( ( (lv_type_8_0= 'date' ) ) ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_x_11_1= ruleDateLiteral | lv_x_11_2= ruleTimeLiteral ) ) ) ) | ( ( (lv_type_12_0= 'float' ) ) ( (lv_name_13_0= RULE_ID ) ) otherlv_14= '=' ( ( (lv_x_15_1= ruleIntLiteral | lv_x_15_2= ruleDoubleLiteral ) ) ) ) | ( ( (lv_type_16_0= 'string' ) ) ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '=' ( (lv_x_19_0= ruleStringLiteral ) ) ) )
            {
            // InternalFacpl2.g:707:1: ( ( ( (lv_type_0_0= 'boolean' ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_x_3_0= ruleBooleanLiteral ) ) ) | ( ( (lv_type_4_0= 'int' ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '=' ( (lv_x_7_0= ruleIntLiteral ) ) ) | ( ( (lv_type_8_0= 'date' ) ) ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_x_11_1= ruleDateLiteral | lv_x_11_2= ruleTimeLiteral ) ) ) ) | ( ( (lv_type_12_0= 'float' ) ) ( (lv_name_13_0= RULE_ID ) ) otherlv_14= '=' ( ( (lv_x_15_1= ruleIntLiteral | lv_x_15_2= ruleDoubleLiteral ) ) ) ) | ( ( (lv_type_16_0= 'string' ) ) ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '=' ( (lv_x_19_0= ruleStringLiteral ) ) ) )
            int alt13=5;
            switch ( input.LA(1) ) {
            case 33:
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
            case 38:
                {
                alt13=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalFacpl2.g:707:2: ( ( (lv_type_0_0= 'boolean' ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_x_3_0= ruleBooleanLiteral ) ) )
                    {
                    // InternalFacpl2.g:707:2: ( ( (lv_type_0_0= 'boolean' ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_x_3_0= ruleBooleanLiteral ) ) )
                    // InternalFacpl2.g:707:3: ( (lv_type_0_0= 'boolean' ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_x_3_0= ruleBooleanLiteral ) )
                    {
                    // InternalFacpl2.g:707:3: ( (lv_type_0_0= 'boolean' ) )
                    // InternalFacpl2.g:708:1: (lv_type_0_0= 'boolean' )
                    {
                    // InternalFacpl2.g:708:1: (lv_type_0_0= 'boolean' )
                    // InternalFacpl2.g:709:3: lv_type_0_0= 'boolean'
                    {
                    lv_type_0_0=(Token)match(input,33,FOLLOW_12); 

                            newLeafNode(lv_type_0_0, grammarAccess.getAttributeAccess().getTypeBooleanKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "type", lv_type_0_0, "boolean");
                    	    

                    }


                    }

                    // InternalFacpl2.g:722:2: ( (lv_name_1_0= RULE_ID ) )
                    // InternalFacpl2.g:723:1: (lv_name_1_0= RULE_ID )
                    {
                    // InternalFacpl2.g:723:1: (lv_name_1_0= RULE_ID )
                    // InternalFacpl2.g:724:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,34,FOLLOW_8); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttributeAccess().getEqualsSignKeyword_0_2());
                        
                    // InternalFacpl2.g:744:1: ( (lv_x_3_0= ruleBooleanLiteral ) )
                    // InternalFacpl2.g:745:1: (lv_x_3_0= ruleBooleanLiteral )
                    {
                    // InternalFacpl2.g:745:1: (lv_x_3_0= ruleBooleanLiteral )
                    // InternalFacpl2.g:746:3: lv_x_3_0= ruleBooleanLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getXBooleanLiteralParserRuleCall_0_3_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_x_3_0=ruleBooleanLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"x",
                            		lv_x_3_0, 
                            		"it.unifi.xtext.facpl.Facpl2.BooleanLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:763:6: ( ( (lv_type_4_0= 'int' ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '=' ( (lv_x_7_0= ruleIntLiteral ) ) )
                    {
                    // InternalFacpl2.g:763:6: ( ( (lv_type_4_0= 'int' ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '=' ( (lv_x_7_0= ruleIntLiteral ) ) )
                    // InternalFacpl2.g:763:7: ( (lv_type_4_0= 'int' ) ) ( (lv_name_5_0= RULE_ID ) ) otherlv_6= '=' ( (lv_x_7_0= ruleIntLiteral ) )
                    {
                    // InternalFacpl2.g:763:7: ( (lv_type_4_0= 'int' ) )
                    // InternalFacpl2.g:764:1: (lv_type_4_0= 'int' )
                    {
                    // InternalFacpl2.g:764:1: (lv_type_4_0= 'int' )
                    // InternalFacpl2.g:765:3: lv_type_4_0= 'int'
                    {
                    lv_type_4_0=(Token)match(input,35,FOLLOW_12); 

                            newLeafNode(lv_type_4_0, grammarAccess.getAttributeAccess().getTypeIntKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "type", lv_type_4_0, "int");
                    	    

                    }


                    }

                    // InternalFacpl2.g:778:2: ( (lv_name_5_0= RULE_ID ) )
                    // InternalFacpl2.g:779:1: (lv_name_5_0= RULE_ID )
                    {
                    // InternalFacpl2.g:779:1: (lv_name_5_0= RULE_ID )
                    // InternalFacpl2.g:780:3: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    			newLeafNode(lv_name_5_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_5_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,34,FOLLOW_26); 

                        	newLeafNode(otherlv_6, grammarAccess.getAttributeAccess().getEqualsSignKeyword_1_2());
                        
                    // InternalFacpl2.g:800:1: ( (lv_x_7_0= ruleIntLiteral ) )
                    // InternalFacpl2.g:801:1: (lv_x_7_0= ruleIntLiteral )
                    {
                    // InternalFacpl2.g:801:1: (lv_x_7_0= ruleIntLiteral )
                    // InternalFacpl2.g:802:3: lv_x_7_0= ruleIntLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getXIntLiteralParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_x_7_0=ruleIntLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"x",
                            		lv_x_7_0, 
                            		"it.unifi.xtext.facpl.Facpl2.IntLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalFacpl2.g:819:6: ( ( (lv_type_8_0= 'date' ) ) ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_x_11_1= ruleDateLiteral | lv_x_11_2= ruleTimeLiteral ) ) ) )
                    {
                    // InternalFacpl2.g:819:6: ( ( (lv_type_8_0= 'date' ) ) ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_x_11_1= ruleDateLiteral | lv_x_11_2= ruleTimeLiteral ) ) ) )
                    // InternalFacpl2.g:819:7: ( (lv_type_8_0= 'date' ) ) ( (lv_name_9_0= RULE_ID ) ) otherlv_10= '=' ( ( (lv_x_11_1= ruleDateLiteral | lv_x_11_2= ruleTimeLiteral ) ) )
                    {
                    // InternalFacpl2.g:819:7: ( (lv_type_8_0= 'date' ) )
                    // InternalFacpl2.g:820:1: (lv_type_8_0= 'date' )
                    {
                    // InternalFacpl2.g:820:1: (lv_type_8_0= 'date' )
                    // InternalFacpl2.g:821:3: lv_type_8_0= 'date'
                    {
                    lv_type_8_0=(Token)match(input,36,FOLLOW_12); 

                            newLeafNode(lv_type_8_0, grammarAccess.getAttributeAccess().getTypeDateKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "type", lv_type_8_0, "date");
                    	    

                    }


                    }

                    // InternalFacpl2.g:834:2: ( (lv_name_9_0= RULE_ID ) )
                    // InternalFacpl2.g:835:1: (lv_name_9_0= RULE_ID )
                    {
                    // InternalFacpl2.g:835:1: (lv_name_9_0= RULE_ID )
                    // InternalFacpl2.g:836:3: lv_name_9_0= RULE_ID
                    {
                    lv_name_9_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    			newLeafNode(lv_name_9_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_9_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,34,FOLLOW_27); 

                        	newLeafNode(otherlv_10, grammarAccess.getAttributeAccess().getEqualsSignKeyword_2_2());
                        
                    // InternalFacpl2.g:856:1: ( ( (lv_x_11_1= ruleDateLiteral | lv_x_11_2= ruleTimeLiteral ) ) )
                    // InternalFacpl2.g:857:1: ( (lv_x_11_1= ruleDateLiteral | lv_x_11_2= ruleTimeLiteral ) )
                    {
                    // InternalFacpl2.g:857:1: ( (lv_x_11_1= ruleDateLiteral | lv_x_11_2= ruleTimeLiteral ) )
                    // InternalFacpl2.g:858:1: (lv_x_11_1= ruleDateLiteral | lv_x_11_2= ruleTimeLiteral )
                    {
                    // InternalFacpl2.g:858:1: (lv_x_11_1= ruleDateLiteral | lv_x_11_2= ruleTimeLiteral )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==RULE_DATE) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==RULE_TIME) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalFacpl2.g:859:3: lv_x_11_1= ruleDateLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttributeAccess().getXDateLiteralParserRuleCall_2_3_0_0()); 
                            	    
                            pushFollow(FOLLOW_2);
                            lv_x_11_1=ruleDateLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"x",
                                    		lv_x_11_1, 
                                    		"it.unifi.xtext.facpl.Facpl2.DateLiteral");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // InternalFacpl2.g:874:8: lv_x_11_2= ruleTimeLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttributeAccess().getXTimeLiteralParserRuleCall_2_3_0_1()); 
                            	    
                            pushFollow(FOLLOW_2);
                            lv_x_11_2=ruleTimeLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"x",
                                    		lv_x_11_2, 
                                    		"it.unifi.xtext.facpl.Facpl2.TimeLiteral");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalFacpl2.g:893:6: ( ( (lv_type_12_0= 'float' ) ) ( (lv_name_13_0= RULE_ID ) ) otherlv_14= '=' ( ( (lv_x_15_1= ruleIntLiteral | lv_x_15_2= ruleDoubleLiteral ) ) ) )
                    {
                    // InternalFacpl2.g:893:6: ( ( (lv_type_12_0= 'float' ) ) ( (lv_name_13_0= RULE_ID ) ) otherlv_14= '=' ( ( (lv_x_15_1= ruleIntLiteral | lv_x_15_2= ruleDoubleLiteral ) ) ) )
                    // InternalFacpl2.g:893:7: ( (lv_type_12_0= 'float' ) ) ( (lv_name_13_0= RULE_ID ) ) otherlv_14= '=' ( ( (lv_x_15_1= ruleIntLiteral | lv_x_15_2= ruleDoubleLiteral ) ) )
                    {
                    // InternalFacpl2.g:893:7: ( (lv_type_12_0= 'float' ) )
                    // InternalFacpl2.g:894:1: (lv_type_12_0= 'float' )
                    {
                    // InternalFacpl2.g:894:1: (lv_type_12_0= 'float' )
                    // InternalFacpl2.g:895:3: lv_type_12_0= 'float'
                    {
                    lv_type_12_0=(Token)match(input,37,FOLLOW_12); 

                            newLeafNode(lv_type_12_0, grammarAccess.getAttributeAccess().getTypeFloatKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "type", lv_type_12_0, "float");
                    	    

                    }


                    }

                    // InternalFacpl2.g:908:2: ( (lv_name_13_0= RULE_ID ) )
                    // InternalFacpl2.g:909:1: (lv_name_13_0= RULE_ID )
                    {
                    // InternalFacpl2.g:909:1: (lv_name_13_0= RULE_ID )
                    // InternalFacpl2.g:910:3: lv_name_13_0= RULE_ID
                    {
                    lv_name_13_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    			newLeafNode(lv_name_13_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_13_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_14=(Token)match(input,34,FOLLOW_28); 

                        	newLeafNode(otherlv_14, grammarAccess.getAttributeAccess().getEqualsSignKeyword_3_2());
                        
                    // InternalFacpl2.g:930:1: ( ( (lv_x_15_1= ruleIntLiteral | lv_x_15_2= ruleDoubleLiteral ) ) )
                    // InternalFacpl2.g:931:1: ( (lv_x_15_1= ruleIntLiteral | lv_x_15_2= ruleDoubleLiteral ) )
                    {
                    // InternalFacpl2.g:931:1: ( (lv_x_15_1= ruleIntLiteral | lv_x_15_2= ruleDoubleLiteral ) )
                    // InternalFacpl2.g:932:1: (lv_x_15_1= ruleIntLiteral | lv_x_15_2= ruleDoubleLiteral )
                    {
                    // InternalFacpl2.g:932:1: (lv_x_15_1= ruleIntLiteral | lv_x_15_2= ruleDoubleLiteral )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==RULE_INT) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==RULE_REAL) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalFacpl2.g:933:3: lv_x_15_1= ruleIntLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttributeAccess().getXIntLiteralParserRuleCall_3_3_0_0()); 
                            	    
                            pushFollow(FOLLOW_2);
                            lv_x_15_1=ruleIntLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"x",
                                    		lv_x_15_1, 
                                    		"it.unifi.xtext.facpl.Facpl2.IntLiteral");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // InternalFacpl2.g:948:8: lv_x_15_2= ruleDoubleLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttributeAccess().getXDoubleLiteralParserRuleCall_3_3_0_1()); 
                            	    
                            pushFollow(FOLLOW_2);
                            lv_x_15_2=ruleDoubleLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"x",
                                    		lv_x_15_2, 
                                    		"it.unifi.xtext.facpl.Facpl2.DoubleLiteral");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalFacpl2.g:967:6: ( ( (lv_type_16_0= 'string' ) ) ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '=' ( (lv_x_19_0= ruleStringLiteral ) ) )
                    {
                    // InternalFacpl2.g:967:6: ( ( (lv_type_16_0= 'string' ) ) ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '=' ( (lv_x_19_0= ruleStringLiteral ) ) )
                    // InternalFacpl2.g:967:7: ( (lv_type_16_0= 'string' ) ) ( (lv_name_17_0= RULE_ID ) ) otherlv_18= '=' ( (lv_x_19_0= ruleStringLiteral ) )
                    {
                    // InternalFacpl2.g:967:7: ( (lv_type_16_0= 'string' ) )
                    // InternalFacpl2.g:968:1: (lv_type_16_0= 'string' )
                    {
                    // InternalFacpl2.g:968:1: (lv_type_16_0= 'string' )
                    // InternalFacpl2.g:969:3: lv_type_16_0= 'string'
                    {
                    lv_type_16_0=(Token)match(input,38,FOLLOW_12); 

                            newLeafNode(lv_type_16_0, grammarAccess.getAttributeAccess().getTypeStringKeyword_4_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(current, "type", lv_type_16_0, "string");
                    	    

                    }


                    }

                    // InternalFacpl2.g:982:2: ( (lv_name_17_0= RULE_ID ) )
                    // InternalFacpl2.g:983:1: (lv_name_17_0= RULE_ID )
                    {
                    // InternalFacpl2.g:983:1: (lv_name_17_0= RULE_ID )
                    // InternalFacpl2.g:984:3: lv_name_17_0= RULE_ID
                    {
                    lv_name_17_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    			newLeafNode(lv_name_17_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_17_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_18=(Token)match(input,34,FOLLOW_4); 

                        	newLeafNode(otherlv_18, grammarAccess.getAttributeAccess().getEqualsSignKeyword_4_2());
                        
                    // InternalFacpl2.g:1004:1: ( (lv_x_19_0= ruleStringLiteral ) )
                    // InternalFacpl2.g:1005:1: (lv_x_19_0= ruleStringLiteral )
                    {
                    // InternalFacpl2.g:1005:1: (lv_x_19_0= ruleStringLiteral )
                    // InternalFacpl2.g:1006:3: lv_x_19_0= ruleStringLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getXStringLiteralParserRuleCall_4_3_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_x_19_0=ruleStringLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"x",
                            		lv_x_19_0, 
                            		"it.unifi.xtext.facpl.Facpl2.StringLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleAttributeDeclaration"
    // InternalFacpl2.g:1030:1: entryRuleAttributeDeclaration returns [EObject current=null] : iv_ruleAttributeDeclaration= ruleAttributeDeclaration EOF ;
    public final EObject entryRuleAttributeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeDeclaration = null;


        try {
            // InternalFacpl2.g:1031:2: (iv_ruleAttributeDeclaration= ruleAttributeDeclaration EOF )
            // InternalFacpl2.g:1032:2: iv_ruleAttributeDeclaration= ruleAttributeDeclaration EOF
            {
             newCompositeNode(grammarAccess.getAttributeDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeDeclaration=ruleAttributeDeclaration();

            state._fsp--;

             current =iv_ruleAttributeDeclaration; 
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
    // $ANTLR end "entryRuleAttributeDeclaration"


    // $ANTLR start "ruleAttributeDeclaration"
    // InternalFacpl2.g:1039:1: ruleAttributeDeclaration returns [EObject current=null] : (otherlv_0= '(' ( (lv_att_1_0= ruleAttribute ) ) otherlv_2= ')' ) ;
    public final EObject ruleAttributeDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_att_1_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1042:28: ( (otherlv_0= '(' ( (lv_att_1_0= ruleAttribute ) ) otherlv_2= ')' ) )
            // InternalFacpl2.g:1043:1: (otherlv_0= '(' ( (lv_att_1_0= ruleAttribute ) ) otherlv_2= ')' )
            {
            // InternalFacpl2.g:1043:1: (otherlv_0= '(' ( (lv_att_1_0= ruleAttribute ) ) otherlv_2= ')' )
            // InternalFacpl2.g:1043:3: otherlv_0= '(' ( (lv_att_1_0= ruleAttribute ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_29); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeDeclarationAccess().getLeftParenthesisKeyword_0());
                
            // InternalFacpl2.g:1047:1: ( (lv_att_1_0= ruleAttribute ) )
            // InternalFacpl2.g:1048:1: (lv_att_1_0= ruleAttribute )
            {
            // InternalFacpl2.g:1048:1: (lv_att_1_0= ruleAttribute )
            // InternalFacpl2.g:1049:3: lv_att_1_0= ruleAttribute
            {
             
            	        newCompositeNode(grammarAccess.getAttributeDeclarationAccess().getAttAttributeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_30);
            lv_att_1_0=ruleAttribute();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"att",
                    		lv_att_1_0, 
                    		"it.unifi.xtext.facpl.Facpl2.Attribute");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getAttributeDeclarationAccess().getRightParenthesisKeyword_2());
                

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
    // $ANTLR end "ruleAttributeDeclaration"


    // $ANTLR start "entryRulePepFunction"
    // InternalFacpl2.g:1077:1: entryRulePepFunction returns [EObject current=null] : iv_rulePepFunction= rulePepFunction EOF ;
    public final EObject entryRulePepFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePepFunction = null;


        try {
            // InternalFacpl2.g:1078:2: (iv_rulePepFunction= rulePepFunction EOF )
            // InternalFacpl2.g:1079:2: iv_rulePepFunction= rulePepFunction EOF
            {
             newCompositeNode(grammarAccess.getPepFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePepFunction=rulePepFunction();

            state._fsp--;

             current =iv_rulePepFunction; 
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
    // $ANTLR end "entryRulePepFunction"


    // $ANTLR start "rulePepFunction"
    // InternalFacpl2.g:1086:1: rulePepFunction returns [EObject current=null] : ( ( ( (lv_name_0_0= 'add-status' ) ) otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_value_4_0= ruleIntLiteral ) ) otherlv_5= ')' ) | ( ( (lv_name_6_0= 'add-status' ) ) otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_value_10_0= ruleDoubleLiteral ) ) otherlv_11= ')' ) | ( ( (lv_name_12_0= 'sub-status' ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' ( (lv_value_16_0= ruleIntLiteral ) ) otherlv_17= ')' ) | ( ( (lv_name_18_0= 'sub-status' ) ) otherlv_19= '(' ( (otherlv_20= RULE_ID ) ) otherlv_21= ',' ( (lv_value_22_0= ruleDoubleLiteral ) ) otherlv_23= ')' ) | ( ( (lv_name_24_0= 'div-status' ) ) otherlv_25= '(' ( (otherlv_26= RULE_ID ) ) otherlv_27= ',' ( (lv_value_28_0= ruleIntLiteral ) ) otherlv_29= ')' ) | ( ( (lv_name_30_0= 'div-status' ) ) otherlv_31= '(' ( (otherlv_32= RULE_ID ) ) otherlv_33= ',' ( (lv_value_34_0= ruleDoubleLiteral ) ) otherlv_35= ')' ) | ( ( (lv_name_36_0= 'mul-status' ) ) otherlv_37= '(' ( (otherlv_38= RULE_ID ) ) otherlv_39= ',' ( (lv_value_40_0= ruleIntLiteral ) ) otherlv_41= ')' ) | ( ( (lv_name_42_0= 'mul-status' ) ) otherlv_43= '(' ( (otherlv_44= RULE_ID ) ) otherlv_45= ',' ( (lv_value_46_0= ruleDoubleLiteral ) ) otherlv_47= ')' ) | ( ( (lv_name_48_0= 'sum-date' ) ) otherlv_49= '(' ( (otherlv_50= RULE_ID ) ) otherlv_51= ',' ( ( (lv_value_52_1= ruleDateLiteral | lv_value_52_2= ruleTimeLiteral ) ) ) otherlv_53= ')' ) | ( ( (lv_name_54_0= 'set-date' ) ) otherlv_55= '(' ( (otherlv_56= RULE_ID ) ) otherlv_57= ',' ( ( (lv_value_58_1= ruleDateLiteral | lv_value_58_2= ruleTimeLiteral ) ) ) otherlv_59= ')' ) | ( ( (lv_name_60_0= 'set-string' ) ) otherlv_61= '(' ( (otherlv_62= RULE_ID ) ) otherlv_63= ',' ( (lv_value_64_0= ruleStringLiteral ) ) otherlv_65= ')' ) | ( ( (lv_name_66_0= 'sum-string' ) ) otherlv_67= '(' ( (otherlv_68= RULE_ID ) ) otherlv_69= ',' ( (lv_value_70_0= ruleStringLiteral ) ) otherlv_71= ')' ) | ( ( (lv_name_72_0= 'flag-status' ) ) otherlv_73= '(' ( (otherlv_74= RULE_ID ) ) otherlv_75= ',' ( (lv_value_76_0= ruleBooleanLiteral ) ) otherlv_77= ')' ) ) ;
    public final EObject rulePepFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_name_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token lv_name_18_0=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token lv_name_24_0=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token lv_name_30_0=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token lv_name_36_0=null;
        Token otherlv_37=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        Token lv_name_42_0=null;
        Token otherlv_43=null;
        Token otherlv_44=null;
        Token otherlv_45=null;
        Token otherlv_47=null;
        Token lv_name_48_0=null;
        Token otherlv_49=null;
        Token otherlv_50=null;
        Token otherlv_51=null;
        Token otherlv_53=null;
        Token lv_name_54_0=null;
        Token otherlv_55=null;
        Token otherlv_56=null;
        Token otherlv_57=null;
        Token otherlv_59=null;
        Token lv_name_60_0=null;
        Token otherlv_61=null;
        Token otherlv_62=null;
        Token otherlv_63=null;
        Token otherlv_65=null;
        Token lv_name_66_0=null;
        Token otherlv_67=null;
        Token otherlv_68=null;
        Token otherlv_69=null;
        Token otherlv_71=null;
        Token lv_name_72_0=null;
        Token otherlv_73=null;
        Token otherlv_74=null;
        Token otherlv_75=null;
        Token otherlv_77=null;
        EObject lv_value_4_0 = null;

        EObject lv_value_10_0 = null;

        EObject lv_value_16_0 = null;

        EObject lv_value_22_0 = null;

        EObject lv_value_28_0 = null;

        EObject lv_value_34_0 = null;

        EObject lv_value_40_0 = null;

        EObject lv_value_46_0 = null;

        EObject lv_value_52_1 = null;

        EObject lv_value_52_2 = null;

        EObject lv_value_58_1 = null;

        EObject lv_value_58_2 = null;

        EObject lv_value_64_0 = null;

        EObject lv_value_70_0 = null;

        EObject lv_value_76_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1089:28: ( ( ( ( (lv_name_0_0= 'add-status' ) ) otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_value_4_0= ruleIntLiteral ) ) otherlv_5= ')' ) | ( ( (lv_name_6_0= 'add-status' ) ) otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_value_10_0= ruleDoubleLiteral ) ) otherlv_11= ')' ) | ( ( (lv_name_12_0= 'sub-status' ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' ( (lv_value_16_0= ruleIntLiteral ) ) otherlv_17= ')' ) | ( ( (lv_name_18_0= 'sub-status' ) ) otherlv_19= '(' ( (otherlv_20= RULE_ID ) ) otherlv_21= ',' ( (lv_value_22_0= ruleDoubleLiteral ) ) otherlv_23= ')' ) | ( ( (lv_name_24_0= 'div-status' ) ) otherlv_25= '(' ( (otherlv_26= RULE_ID ) ) otherlv_27= ',' ( (lv_value_28_0= ruleIntLiteral ) ) otherlv_29= ')' ) | ( ( (lv_name_30_0= 'div-status' ) ) otherlv_31= '(' ( (otherlv_32= RULE_ID ) ) otherlv_33= ',' ( (lv_value_34_0= ruleDoubleLiteral ) ) otherlv_35= ')' ) | ( ( (lv_name_36_0= 'mul-status' ) ) otherlv_37= '(' ( (otherlv_38= RULE_ID ) ) otherlv_39= ',' ( (lv_value_40_0= ruleIntLiteral ) ) otherlv_41= ')' ) | ( ( (lv_name_42_0= 'mul-status' ) ) otherlv_43= '(' ( (otherlv_44= RULE_ID ) ) otherlv_45= ',' ( (lv_value_46_0= ruleDoubleLiteral ) ) otherlv_47= ')' ) | ( ( (lv_name_48_0= 'sum-date' ) ) otherlv_49= '(' ( (otherlv_50= RULE_ID ) ) otherlv_51= ',' ( ( (lv_value_52_1= ruleDateLiteral | lv_value_52_2= ruleTimeLiteral ) ) ) otherlv_53= ')' ) | ( ( (lv_name_54_0= 'set-date' ) ) otherlv_55= '(' ( (otherlv_56= RULE_ID ) ) otherlv_57= ',' ( ( (lv_value_58_1= ruleDateLiteral | lv_value_58_2= ruleTimeLiteral ) ) ) otherlv_59= ')' ) | ( ( (lv_name_60_0= 'set-string' ) ) otherlv_61= '(' ( (otherlv_62= RULE_ID ) ) otherlv_63= ',' ( (lv_value_64_0= ruleStringLiteral ) ) otherlv_65= ')' ) | ( ( (lv_name_66_0= 'sum-string' ) ) otherlv_67= '(' ( (otherlv_68= RULE_ID ) ) otherlv_69= ',' ( (lv_value_70_0= ruleStringLiteral ) ) otherlv_71= ')' ) | ( ( (lv_name_72_0= 'flag-status' ) ) otherlv_73= '(' ( (otherlv_74= RULE_ID ) ) otherlv_75= ',' ( (lv_value_76_0= ruleBooleanLiteral ) ) otherlv_77= ')' ) ) )
            // InternalFacpl2.g:1090:1: ( ( ( (lv_name_0_0= 'add-status' ) ) otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_value_4_0= ruleIntLiteral ) ) otherlv_5= ')' ) | ( ( (lv_name_6_0= 'add-status' ) ) otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_value_10_0= ruleDoubleLiteral ) ) otherlv_11= ')' ) | ( ( (lv_name_12_0= 'sub-status' ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' ( (lv_value_16_0= ruleIntLiteral ) ) otherlv_17= ')' ) | ( ( (lv_name_18_0= 'sub-status' ) ) otherlv_19= '(' ( (otherlv_20= RULE_ID ) ) otherlv_21= ',' ( (lv_value_22_0= ruleDoubleLiteral ) ) otherlv_23= ')' ) | ( ( (lv_name_24_0= 'div-status' ) ) otherlv_25= '(' ( (otherlv_26= RULE_ID ) ) otherlv_27= ',' ( (lv_value_28_0= ruleIntLiteral ) ) otherlv_29= ')' ) | ( ( (lv_name_30_0= 'div-status' ) ) otherlv_31= '(' ( (otherlv_32= RULE_ID ) ) otherlv_33= ',' ( (lv_value_34_0= ruleDoubleLiteral ) ) otherlv_35= ')' ) | ( ( (lv_name_36_0= 'mul-status' ) ) otherlv_37= '(' ( (otherlv_38= RULE_ID ) ) otherlv_39= ',' ( (lv_value_40_0= ruleIntLiteral ) ) otherlv_41= ')' ) | ( ( (lv_name_42_0= 'mul-status' ) ) otherlv_43= '(' ( (otherlv_44= RULE_ID ) ) otherlv_45= ',' ( (lv_value_46_0= ruleDoubleLiteral ) ) otherlv_47= ')' ) | ( ( (lv_name_48_0= 'sum-date' ) ) otherlv_49= '(' ( (otherlv_50= RULE_ID ) ) otherlv_51= ',' ( ( (lv_value_52_1= ruleDateLiteral | lv_value_52_2= ruleTimeLiteral ) ) ) otherlv_53= ')' ) | ( ( (lv_name_54_0= 'set-date' ) ) otherlv_55= '(' ( (otherlv_56= RULE_ID ) ) otherlv_57= ',' ( ( (lv_value_58_1= ruleDateLiteral | lv_value_58_2= ruleTimeLiteral ) ) ) otherlv_59= ')' ) | ( ( (lv_name_60_0= 'set-string' ) ) otherlv_61= '(' ( (otherlv_62= RULE_ID ) ) otherlv_63= ',' ( (lv_value_64_0= ruleStringLiteral ) ) otherlv_65= ')' ) | ( ( (lv_name_66_0= 'sum-string' ) ) otherlv_67= '(' ( (otherlv_68= RULE_ID ) ) otherlv_69= ',' ( (lv_value_70_0= ruleStringLiteral ) ) otherlv_71= ')' ) | ( ( (lv_name_72_0= 'flag-status' ) ) otherlv_73= '(' ( (otherlv_74= RULE_ID ) ) otherlv_75= ',' ( (lv_value_76_0= ruleBooleanLiteral ) ) otherlv_77= ')' ) )
            {
            // InternalFacpl2.g:1090:1: ( ( ( (lv_name_0_0= 'add-status' ) ) otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_value_4_0= ruleIntLiteral ) ) otherlv_5= ')' ) | ( ( (lv_name_6_0= 'add-status' ) ) otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_value_10_0= ruleDoubleLiteral ) ) otherlv_11= ')' ) | ( ( (lv_name_12_0= 'sub-status' ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' ( (lv_value_16_0= ruleIntLiteral ) ) otherlv_17= ')' ) | ( ( (lv_name_18_0= 'sub-status' ) ) otherlv_19= '(' ( (otherlv_20= RULE_ID ) ) otherlv_21= ',' ( (lv_value_22_0= ruleDoubleLiteral ) ) otherlv_23= ')' ) | ( ( (lv_name_24_0= 'div-status' ) ) otherlv_25= '(' ( (otherlv_26= RULE_ID ) ) otherlv_27= ',' ( (lv_value_28_0= ruleIntLiteral ) ) otherlv_29= ')' ) | ( ( (lv_name_30_0= 'div-status' ) ) otherlv_31= '(' ( (otherlv_32= RULE_ID ) ) otherlv_33= ',' ( (lv_value_34_0= ruleDoubleLiteral ) ) otherlv_35= ')' ) | ( ( (lv_name_36_0= 'mul-status' ) ) otherlv_37= '(' ( (otherlv_38= RULE_ID ) ) otherlv_39= ',' ( (lv_value_40_0= ruleIntLiteral ) ) otherlv_41= ')' ) | ( ( (lv_name_42_0= 'mul-status' ) ) otherlv_43= '(' ( (otherlv_44= RULE_ID ) ) otherlv_45= ',' ( (lv_value_46_0= ruleDoubleLiteral ) ) otherlv_47= ')' ) | ( ( (lv_name_48_0= 'sum-date' ) ) otherlv_49= '(' ( (otherlv_50= RULE_ID ) ) otherlv_51= ',' ( ( (lv_value_52_1= ruleDateLiteral | lv_value_52_2= ruleTimeLiteral ) ) ) otherlv_53= ')' ) | ( ( (lv_name_54_0= 'set-date' ) ) otherlv_55= '(' ( (otherlv_56= RULE_ID ) ) otherlv_57= ',' ( ( (lv_value_58_1= ruleDateLiteral | lv_value_58_2= ruleTimeLiteral ) ) ) otherlv_59= ')' ) | ( ( (lv_name_60_0= 'set-string' ) ) otherlv_61= '(' ( (otherlv_62= RULE_ID ) ) otherlv_63= ',' ( (lv_value_64_0= ruleStringLiteral ) ) otherlv_65= ')' ) | ( ( (lv_name_66_0= 'sum-string' ) ) otherlv_67= '(' ( (otherlv_68= RULE_ID ) ) otherlv_69= ',' ( (lv_value_70_0= ruleStringLiteral ) ) otherlv_71= ')' ) | ( ( (lv_name_72_0= 'flag-status' ) ) otherlv_73= '(' ( (otherlv_74= RULE_ID ) ) otherlv_75= ',' ( (lv_value_76_0= ruleBooleanLiteral ) ) otherlv_77= ')' ) )
            int alt16=13;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // InternalFacpl2.g:1090:2: ( ( (lv_name_0_0= 'add-status' ) ) otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_value_4_0= ruleIntLiteral ) ) otherlv_5= ')' )
                    {
                    // InternalFacpl2.g:1090:2: ( ( (lv_name_0_0= 'add-status' ) ) otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_value_4_0= ruleIntLiteral ) ) otherlv_5= ')' )
                    // InternalFacpl2.g:1090:3: ( (lv_name_0_0= 'add-status' ) ) otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_value_4_0= ruleIntLiteral ) ) otherlv_5= ')'
                    {
                    // InternalFacpl2.g:1090:3: ( (lv_name_0_0= 'add-status' ) )
                    // InternalFacpl2.g:1091:1: (lv_name_0_0= 'add-status' )
                    {
                    // InternalFacpl2.g:1091:1: (lv_name_0_0= 'add-status' )
                    // InternalFacpl2.g:1092:3: lv_name_0_0= 'add-status'
                    {
                    lv_name_0_0=(Token)match(input,39,FOLLOW_17); 

                            newLeafNode(lv_name_0_0, grammarAccess.getPepFunctionAccess().getNameAddStatusKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_0, "add-status");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,26,FOLLOW_12); 

                        	newLeafNode(otherlv_1, grammarAccess.getPepFunctionAccess().getLeftParenthesisKeyword_0_1());
                        
                    // InternalFacpl2.g:1109:1: ( (otherlv_2= RULE_ID ) )
                    // InternalFacpl2.g:1110:1: (otherlv_2= RULE_ID )
                    {
                    // InternalFacpl2.g:1110:1: (otherlv_2= RULE_ID )
                    // InternalFacpl2.g:1111:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_2, grammarAccess.getPepFunctionAccess().getAttAttributeCrossReference_0_2_0()); 
                    	

                    }


                    }

                    otherlv_3=(Token)match(input,23,FOLLOW_26); 

                        	newLeafNode(otherlv_3, grammarAccess.getPepFunctionAccess().getCommaKeyword_0_3());
                        
                    // InternalFacpl2.g:1126:1: ( (lv_value_4_0= ruleIntLiteral ) )
                    // InternalFacpl2.g:1127:1: (lv_value_4_0= ruleIntLiteral )
                    {
                    // InternalFacpl2.g:1127:1: (lv_value_4_0= ruleIntLiteral )
                    // InternalFacpl2.g:1128:3: lv_value_4_0= ruleIntLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueIntLiteralParserRuleCall_0_4_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    lv_value_4_0=ruleIntLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_4_0, 
                            		"it.unifi.xtext.facpl.Facpl2.IntLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_5, grammarAccess.getPepFunctionAccess().getRightParenthesisKeyword_0_5());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:1149:6: ( ( (lv_name_6_0= 'add-status' ) ) otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_value_10_0= ruleDoubleLiteral ) ) otherlv_11= ')' )
                    {
                    // InternalFacpl2.g:1149:6: ( ( (lv_name_6_0= 'add-status' ) ) otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_value_10_0= ruleDoubleLiteral ) ) otherlv_11= ')' )
                    // InternalFacpl2.g:1149:7: ( (lv_name_6_0= 'add-status' ) ) otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_value_10_0= ruleDoubleLiteral ) ) otherlv_11= ')'
                    {
                    // InternalFacpl2.g:1149:7: ( (lv_name_6_0= 'add-status' ) )
                    // InternalFacpl2.g:1150:1: (lv_name_6_0= 'add-status' )
                    {
                    // InternalFacpl2.g:1150:1: (lv_name_6_0= 'add-status' )
                    // InternalFacpl2.g:1151:3: lv_name_6_0= 'add-status'
                    {
                    lv_name_6_0=(Token)match(input,39,FOLLOW_17); 

                            newLeafNode(lv_name_6_0, grammarAccess.getPepFunctionAccess().getNameAddStatusKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_6_0, "add-status");
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,26,FOLLOW_12); 

                        	newLeafNode(otherlv_7, grammarAccess.getPepFunctionAccess().getLeftParenthesisKeyword_1_1());
                        
                    // InternalFacpl2.g:1168:1: ( (otherlv_8= RULE_ID ) )
                    // InternalFacpl2.g:1169:1: (otherlv_8= RULE_ID )
                    {
                    // InternalFacpl2.g:1169:1: (otherlv_8= RULE_ID )
                    // InternalFacpl2.g:1170:3: otherlv_8= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                            
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_8, grammarAccess.getPepFunctionAccess().getAttAttributeCrossReference_1_2_0()); 
                    	

                    }


                    }

                    otherlv_9=(Token)match(input,23,FOLLOW_28); 

                        	newLeafNode(otherlv_9, grammarAccess.getPepFunctionAccess().getCommaKeyword_1_3());
                        
                    // InternalFacpl2.g:1185:1: ( (lv_value_10_0= ruleDoubleLiteral ) )
                    // InternalFacpl2.g:1186:1: (lv_value_10_0= ruleDoubleLiteral )
                    {
                    // InternalFacpl2.g:1186:1: (lv_value_10_0= ruleDoubleLiteral )
                    // InternalFacpl2.g:1187:3: lv_value_10_0= ruleDoubleLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueDoubleLiteralParserRuleCall_1_4_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    lv_value_10_0=ruleDoubleLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_10_0, 
                            		"it.unifi.xtext.facpl.Facpl2.DoubleLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_11=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_11, grammarAccess.getPepFunctionAccess().getRightParenthesisKeyword_1_5());
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalFacpl2.g:1208:6: ( ( (lv_name_12_0= 'sub-status' ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' ( (lv_value_16_0= ruleIntLiteral ) ) otherlv_17= ')' )
                    {
                    // InternalFacpl2.g:1208:6: ( ( (lv_name_12_0= 'sub-status' ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' ( (lv_value_16_0= ruleIntLiteral ) ) otherlv_17= ')' )
                    // InternalFacpl2.g:1208:7: ( (lv_name_12_0= 'sub-status' ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' ( (lv_value_16_0= ruleIntLiteral ) ) otherlv_17= ')'
                    {
                    // InternalFacpl2.g:1208:7: ( (lv_name_12_0= 'sub-status' ) )
                    // InternalFacpl2.g:1209:1: (lv_name_12_0= 'sub-status' )
                    {
                    // InternalFacpl2.g:1209:1: (lv_name_12_0= 'sub-status' )
                    // InternalFacpl2.g:1210:3: lv_name_12_0= 'sub-status'
                    {
                    lv_name_12_0=(Token)match(input,40,FOLLOW_17); 

                            newLeafNode(lv_name_12_0, grammarAccess.getPepFunctionAccess().getNameSubStatusKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_12_0, "sub-status");
                    	    

                    }


                    }

                    otherlv_13=(Token)match(input,26,FOLLOW_12); 

                        	newLeafNode(otherlv_13, grammarAccess.getPepFunctionAccess().getLeftParenthesisKeyword_2_1());
                        
                    // InternalFacpl2.g:1227:1: ( (otherlv_14= RULE_ID ) )
                    // InternalFacpl2.g:1228:1: (otherlv_14= RULE_ID )
                    {
                    // InternalFacpl2.g:1228:1: (otherlv_14= RULE_ID )
                    // InternalFacpl2.g:1229:3: otherlv_14= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                            
                    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_14, grammarAccess.getPepFunctionAccess().getAttAttributeCrossReference_2_2_0()); 
                    	

                    }


                    }

                    otherlv_15=(Token)match(input,23,FOLLOW_26); 

                        	newLeafNode(otherlv_15, grammarAccess.getPepFunctionAccess().getCommaKeyword_2_3());
                        
                    // InternalFacpl2.g:1244:1: ( (lv_value_16_0= ruleIntLiteral ) )
                    // InternalFacpl2.g:1245:1: (lv_value_16_0= ruleIntLiteral )
                    {
                    // InternalFacpl2.g:1245:1: (lv_value_16_0= ruleIntLiteral )
                    // InternalFacpl2.g:1246:3: lv_value_16_0= ruleIntLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueIntLiteralParserRuleCall_2_4_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    lv_value_16_0=ruleIntLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_16_0, 
                            		"it.unifi.xtext.facpl.Facpl2.IntLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_17=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_17, grammarAccess.getPepFunctionAccess().getRightParenthesisKeyword_2_5());
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalFacpl2.g:1267:6: ( ( (lv_name_18_0= 'sub-status' ) ) otherlv_19= '(' ( (otherlv_20= RULE_ID ) ) otherlv_21= ',' ( (lv_value_22_0= ruleDoubleLiteral ) ) otherlv_23= ')' )
                    {
                    // InternalFacpl2.g:1267:6: ( ( (lv_name_18_0= 'sub-status' ) ) otherlv_19= '(' ( (otherlv_20= RULE_ID ) ) otherlv_21= ',' ( (lv_value_22_0= ruleDoubleLiteral ) ) otherlv_23= ')' )
                    // InternalFacpl2.g:1267:7: ( (lv_name_18_0= 'sub-status' ) ) otherlv_19= '(' ( (otherlv_20= RULE_ID ) ) otherlv_21= ',' ( (lv_value_22_0= ruleDoubleLiteral ) ) otherlv_23= ')'
                    {
                    // InternalFacpl2.g:1267:7: ( (lv_name_18_0= 'sub-status' ) )
                    // InternalFacpl2.g:1268:1: (lv_name_18_0= 'sub-status' )
                    {
                    // InternalFacpl2.g:1268:1: (lv_name_18_0= 'sub-status' )
                    // InternalFacpl2.g:1269:3: lv_name_18_0= 'sub-status'
                    {
                    lv_name_18_0=(Token)match(input,40,FOLLOW_17); 

                            newLeafNode(lv_name_18_0, grammarAccess.getPepFunctionAccess().getNameSubStatusKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_18_0, "sub-status");
                    	    

                    }


                    }

                    otherlv_19=(Token)match(input,26,FOLLOW_12); 

                        	newLeafNode(otherlv_19, grammarAccess.getPepFunctionAccess().getLeftParenthesisKeyword_3_1());
                        
                    // InternalFacpl2.g:1286:1: ( (otherlv_20= RULE_ID ) )
                    // InternalFacpl2.g:1287:1: (otherlv_20= RULE_ID )
                    {
                    // InternalFacpl2.g:1287:1: (otherlv_20= RULE_ID )
                    // InternalFacpl2.g:1288:3: otherlv_20= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                            
                    otherlv_20=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_20, grammarAccess.getPepFunctionAccess().getAttAttributeCrossReference_3_2_0()); 
                    	

                    }


                    }

                    otherlv_21=(Token)match(input,23,FOLLOW_28); 

                        	newLeafNode(otherlv_21, grammarAccess.getPepFunctionAccess().getCommaKeyword_3_3());
                        
                    // InternalFacpl2.g:1303:1: ( (lv_value_22_0= ruleDoubleLiteral ) )
                    // InternalFacpl2.g:1304:1: (lv_value_22_0= ruleDoubleLiteral )
                    {
                    // InternalFacpl2.g:1304:1: (lv_value_22_0= ruleDoubleLiteral )
                    // InternalFacpl2.g:1305:3: lv_value_22_0= ruleDoubleLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueDoubleLiteralParserRuleCall_3_4_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    lv_value_22_0=ruleDoubleLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_22_0, 
                            		"it.unifi.xtext.facpl.Facpl2.DoubleLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_23=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_23, grammarAccess.getPepFunctionAccess().getRightParenthesisKeyword_3_5());
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalFacpl2.g:1326:6: ( ( (lv_name_24_0= 'div-status' ) ) otherlv_25= '(' ( (otherlv_26= RULE_ID ) ) otherlv_27= ',' ( (lv_value_28_0= ruleIntLiteral ) ) otherlv_29= ')' )
                    {
                    // InternalFacpl2.g:1326:6: ( ( (lv_name_24_0= 'div-status' ) ) otherlv_25= '(' ( (otherlv_26= RULE_ID ) ) otherlv_27= ',' ( (lv_value_28_0= ruleIntLiteral ) ) otherlv_29= ')' )
                    // InternalFacpl2.g:1326:7: ( (lv_name_24_0= 'div-status' ) ) otherlv_25= '(' ( (otherlv_26= RULE_ID ) ) otherlv_27= ',' ( (lv_value_28_0= ruleIntLiteral ) ) otherlv_29= ')'
                    {
                    // InternalFacpl2.g:1326:7: ( (lv_name_24_0= 'div-status' ) )
                    // InternalFacpl2.g:1327:1: (lv_name_24_0= 'div-status' )
                    {
                    // InternalFacpl2.g:1327:1: (lv_name_24_0= 'div-status' )
                    // InternalFacpl2.g:1328:3: lv_name_24_0= 'div-status'
                    {
                    lv_name_24_0=(Token)match(input,41,FOLLOW_17); 

                            newLeafNode(lv_name_24_0, grammarAccess.getPepFunctionAccess().getNameDivStatusKeyword_4_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_24_0, "div-status");
                    	    

                    }


                    }

                    otherlv_25=(Token)match(input,26,FOLLOW_12); 

                        	newLeafNode(otherlv_25, grammarAccess.getPepFunctionAccess().getLeftParenthesisKeyword_4_1());
                        
                    // InternalFacpl2.g:1345:1: ( (otherlv_26= RULE_ID ) )
                    // InternalFacpl2.g:1346:1: (otherlv_26= RULE_ID )
                    {
                    // InternalFacpl2.g:1346:1: (otherlv_26= RULE_ID )
                    // InternalFacpl2.g:1347:3: otherlv_26= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                            
                    otherlv_26=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_26, grammarAccess.getPepFunctionAccess().getAttAttributeCrossReference_4_2_0()); 
                    	

                    }


                    }

                    otherlv_27=(Token)match(input,23,FOLLOW_26); 

                        	newLeafNode(otherlv_27, grammarAccess.getPepFunctionAccess().getCommaKeyword_4_3());
                        
                    // InternalFacpl2.g:1362:1: ( (lv_value_28_0= ruleIntLiteral ) )
                    // InternalFacpl2.g:1363:1: (lv_value_28_0= ruleIntLiteral )
                    {
                    // InternalFacpl2.g:1363:1: (lv_value_28_0= ruleIntLiteral )
                    // InternalFacpl2.g:1364:3: lv_value_28_0= ruleIntLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueIntLiteralParserRuleCall_4_4_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    lv_value_28_0=ruleIntLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_28_0, 
                            		"it.unifi.xtext.facpl.Facpl2.IntLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_29=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_29, grammarAccess.getPepFunctionAccess().getRightParenthesisKeyword_4_5());
                        

                    }


                    }
                    break;
                case 6 :
                    // InternalFacpl2.g:1385:6: ( ( (lv_name_30_0= 'div-status' ) ) otherlv_31= '(' ( (otherlv_32= RULE_ID ) ) otherlv_33= ',' ( (lv_value_34_0= ruleDoubleLiteral ) ) otherlv_35= ')' )
                    {
                    // InternalFacpl2.g:1385:6: ( ( (lv_name_30_0= 'div-status' ) ) otherlv_31= '(' ( (otherlv_32= RULE_ID ) ) otherlv_33= ',' ( (lv_value_34_0= ruleDoubleLiteral ) ) otherlv_35= ')' )
                    // InternalFacpl2.g:1385:7: ( (lv_name_30_0= 'div-status' ) ) otherlv_31= '(' ( (otherlv_32= RULE_ID ) ) otherlv_33= ',' ( (lv_value_34_0= ruleDoubleLiteral ) ) otherlv_35= ')'
                    {
                    // InternalFacpl2.g:1385:7: ( (lv_name_30_0= 'div-status' ) )
                    // InternalFacpl2.g:1386:1: (lv_name_30_0= 'div-status' )
                    {
                    // InternalFacpl2.g:1386:1: (lv_name_30_0= 'div-status' )
                    // InternalFacpl2.g:1387:3: lv_name_30_0= 'div-status'
                    {
                    lv_name_30_0=(Token)match(input,41,FOLLOW_17); 

                            newLeafNode(lv_name_30_0, grammarAccess.getPepFunctionAccess().getNameDivStatusKeyword_5_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_30_0, "div-status");
                    	    

                    }


                    }

                    otherlv_31=(Token)match(input,26,FOLLOW_12); 

                        	newLeafNode(otherlv_31, grammarAccess.getPepFunctionAccess().getLeftParenthesisKeyword_5_1());
                        
                    // InternalFacpl2.g:1404:1: ( (otherlv_32= RULE_ID ) )
                    // InternalFacpl2.g:1405:1: (otherlv_32= RULE_ID )
                    {
                    // InternalFacpl2.g:1405:1: (otherlv_32= RULE_ID )
                    // InternalFacpl2.g:1406:3: otherlv_32= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                            
                    otherlv_32=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_32, grammarAccess.getPepFunctionAccess().getAttAttributeCrossReference_5_2_0()); 
                    	

                    }


                    }

                    otherlv_33=(Token)match(input,23,FOLLOW_28); 

                        	newLeafNode(otherlv_33, grammarAccess.getPepFunctionAccess().getCommaKeyword_5_3());
                        
                    // InternalFacpl2.g:1421:1: ( (lv_value_34_0= ruleDoubleLiteral ) )
                    // InternalFacpl2.g:1422:1: (lv_value_34_0= ruleDoubleLiteral )
                    {
                    // InternalFacpl2.g:1422:1: (lv_value_34_0= ruleDoubleLiteral )
                    // InternalFacpl2.g:1423:3: lv_value_34_0= ruleDoubleLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueDoubleLiteralParserRuleCall_5_4_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    lv_value_34_0=ruleDoubleLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_34_0, 
                            		"it.unifi.xtext.facpl.Facpl2.DoubleLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_35=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_35, grammarAccess.getPepFunctionAccess().getRightParenthesisKeyword_5_5());
                        

                    }


                    }
                    break;
                case 7 :
                    // InternalFacpl2.g:1444:6: ( ( (lv_name_36_0= 'mul-status' ) ) otherlv_37= '(' ( (otherlv_38= RULE_ID ) ) otherlv_39= ',' ( (lv_value_40_0= ruleIntLiteral ) ) otherlv_41= ')' )
                    {
                    // InternalFacpl2.g:1444:6: ( ( (lv_name_36_0= 'mul-status' ) ) otherlv_37= '(' ( (otherlv_38= RULE_ID ) ) otherlv_39= ',' ( (lv_value_40_0= ruleIntLiteral ) ) otherlv_41= ')' )
                    // InternalFacpl2.g:1444:7: ( (lv_name_36_0= 'mul-status' ) ) otherlv_37= '(' ( (otherlv_38= RULE_ID ) ) otherlv_39= ',' ( (lv_value_40_0= ruleIntLiteral ) ) otherlv_41= ')'
                    {
                    // InternalFacpl2.g:1444:7: ( (lv_name_36_0= 'mul-status' ) )
                    // InternalFacpl2.g:1445:1: (lv_name_36_0= 'mul-status' )
                    {
                    // InternalFacpl2.g:1445:1: (lv_name_36_0= 'mul-status' )
                    // InternalFacpl2.g:1446:3: lv_name_36_0= 'mul-status'
                    {
                    lv_name_36_0=(Token)match(input,42,FOLLOW_17); 

                            newLeafNode(lv_name_36_0, grammarAccess.getPepFunctionAccess().getNameMulStatusKeyword_6_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_36_0, "mul-status");
                    	    

                    }


                    }

                    otherlv_37=(Token)match(input,26,FOLLOW_12); 

                        	newLeafNode(otherlv_37, grammarAccess.getPepFunctionAccess().getLeftParenthesisKeyword_6_1());
                        
                    // InternalFacpl2.g:1463:1: ( (otherlv_38= RULE_ID ) )
                    // InternalFacpl2.g:1464:1: (otherlv_38= RULE_ID )
                    {
                    // InternalFacpl2.g:1464:1: (otherlv_38= RULE_ID )
                    // InternalFacpl2.g:1465:3: otherlv_38= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                            
                    otherlv_38=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_38, grammarAccess.getPepFunctionAccess().getAttAttributeCrossReference_6_2_0()); 
                    	

                    }


                    }

                    otherlv_39=(Token)match(input,23,FOLLOW_26); 

                        	newLeafNode(otherlv_39, grammarAccess.getPepFunctionAccess().getCommaKeyword_6_3());
                        
                    // InternalFacpl2.g:1480:1: ( (lv_value_40_0= ruleIntLiteral ) )
                    // InternalFacpl2.g:1481:1: (lv_value_40_0= ruleIntLiteral )
                    {
                    // InternalFacpl2.g:1481:1: (lv_value_40_0= ruleIntLiteral )
                    // InternalFacpl2.g:1482:3: lv_value_40_0= ruleIntLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueIntLiteralParserRuleCall_6_4_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    lv_value_40_0=ruleIntLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_40_0, 
                            		"it.unifi.xtext.facpl.Facpl2.IntLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_41=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_41, grammarAccess.getPepFunctionAccess().getRightParenthesisKeyword_6_5());
                        

                    }


                    }
                    break;
                case 8 :
                    // InternalFacpl2.g:1503:6: ( ( (lv_name_42_0= 'mul-status' ) ) otherlv_43= '(' ( (otherlv_44= RULE_ID ) ) otherlv_45= ',' ( (lv_value_46_0= ruleDoubleLiteral ) ) otherlv_47= ')' )
                    {
                    // InternalFacpl2.g:1503:6: ( ( (lv_name_42_0= 'mul-status' ) ) otherlv_43= '(' ( (otherlv_44= RULE_ID ) ) otherlv_45= ',' ( (lv_value_46_0= ruleDoubleLiteral ) ) otherlv_47= ')' )
                    // InternalFacpl2.g:1503:7: ( (lv_name_42_0= 'mul-status' ) ) otherlv_43= '(' ( (otherlv_44= RULE_ID ) ) otherlv_45= ',' ( (lv_value_46_0= ruleDoubleLiteral ) ) otherlv_47= ')'
                    {
                    // InternalFacpl2.g:1503:7: ( (lv_name_42_0= 'mul-status' ) )
                    // InternalFacpl2.g:1504:1: (lv_name_42_0= 'mul-status' )
                    {
                    // InternalFacpl2.g:1504:1: (lv_name_42_0= 'mul-status' )
                    // InternalFacpl2.g:1505:3: lv_name_42_0= 'mul-status'
                    {
                    lv_name_42_0=(Token)match(input,42,FOLLOW_17); 

                            newLeafNode(lv_name_42_0, grammarAccess.getPepFunctionAccess().getNameMulStatusKeyword_7_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_42_0, "mul-status");
                    	    

                    }


                    }

                    otherlv_43=(Token)match(input,26,FOLLOW_12); 

                        	newLeafNode(otherlv_43, grammarAccess.getPepFunctionAccess().getLeftParenthesisKeyword_7_1());
                        
                    // InternalFacpl2.g:1522:1: ( (otherlv_44= RULE_ID ) )
                    // InternalFacpl2.g:1523:1: (otherlv_44= RULE_ID )
                    {
                    // InternalFacpl2.g:1523:1: (otherlv_44= RULE_ID )
                    // InternalFacpl2.g:1524:3: otherlv_44= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                            
                    otherlv_44=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_44, grammarAccess.getPepFunctionAccess().getAttAttributeCrossReference_7_2_0()); 
                    	

                    }


                    }

                    otherlv_45=(Token)match(input,23,FOLLOW_28); 

                        	newLeafNode(otherlv_45, grammarAccess.getPepFunctionAccess().getCommaKeyword_7_3());
                        
                    // InternalFacpl2.g:1539:1: ( (lv_value_46_0= ruleDoubleLiteral ) )
                    // InternalFacpl2.g:1540:1: (lv_value_46_0= ruleDoubleLiteral )
                    {
                    // InternalFacpl2.g:1540:1: (lv_value_46_0= ruleDoubleLiteral )
                    // InternalFacpl2.g:1541:3: lv_value_46_0= ruleDoubleLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueDoubleLiteralParserRuleCall_7_4_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    lv_value_46_0=ruleDoubleLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_46_0, 
                            		"it.unifi.xtext.facpl.Facpl2.DoubleLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_47=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_47, grammarAccess.getPepFunctionAccess().getRightParenthesisKeyword_7_5());
                        

                    }


                    }
                    break;
                case 9 :
                    // InternalFacpl2.g:1562:6: ( ( (lv_name_48_0= 'sum-date' ) ) otherlv_49= '(' ( (otherlv_50= RULE_ID ) ) otherlv_51= ',' ( ( (lv_value_52_1= ruleDateLiteral | lv_value_52_2= ruleTimeLiteral ) ) ) otherlv_53= ')' )
                    {
                    // InternalFacpl2.g:1562:6: ( ( (lv_name_48_0= 'sum-date' ) ) otherlv_49= '(' ( (otherlv_50= RULE_ID ) ) otherlv_51= ',' ( ( (lv_value_52_1= ruleDateLiteral | lv_value_52_2= ruleTimeLiteral ) ) ) otherlv_53= ')' )
                    // InternalFacpl2.g:1562:7: ( (lv_name_48_0= 'sum-date' ) ) otherlv_49= '(' ( (otherlv_50= RULE_ID ) ) otherlv_51= ',' ( ( (lv_value_52_1= ruleDateLiteral | lv_value_52_2= ruleTimeLiteral ) ) ) otherlv_53= ')'
                    {
                    // InternalFacpl2.g:1562:7: ( (lv_name_48_0= 'sum-date' ) )
                    // InternalFacpl2.g:1563:1: (lv_name_48_0= 'sum-date' )
                    {
                    // InternalFacpl2.g:1563:1: (lv_name_48_0= 'sum-date' )
                    // InternalFacpl2.g:1564:3: lv_name_48_0= 'sum-date'
                    {
                    lv_name_48_0=(Token)match(input,43,FOLLOW_17); 

                            newLeafNode(lv_name_48_0, grammarAccess.getPepFunctionAccess().getNameSumDateKeyword_8_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_48_0, "sum-date");
                    	    

                    }


                    }

                    otherlv_49=(Token)match(input,26,FOLLOW_12); 

                        	newLeafNode(otherlv_49, grammarAccess.getPepFunctionAccess().getLeftParenthesisKeyword_8_1());
                        
                    // InternalFacpl2.g:1581:1: ( (otherlv_50= RULE_ID ) )
                    // InternalFacpl2.g:1582:1: (otherlv_50= RULE_ID )
                    {
                    // InternalFacpl2.g:1582:1: (otherlv_50= RULE_ID )
                    // InternalFacpl2.g:1583:3: otherlv_50= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                            
                    otherlv_50=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_50, grammarAccess.getPepFunctionAccess().getAttAttributeCrossReference_8_2_0()); 
                    	

                    }


                    }

                    otherlv_51=(Token)match(input,23,FOLLOW_27); 

                        	newLeafNode(otherlv_51, grammarAccess.getPepFunctionAccess().getCommaKeyword_8_3());
                        
                    // InternalFacpl2.g:1598:1: ( ( (lv_value_52_1= ruleDateLiteral | lv_value_52_2= ruleTimeLiteral ) ) )
                    // InternalFacpl2.g:1599:1: ( (lv_value_52_1= ruleDateLiteral | lv_value_52_2= ruleTimeLiteral ) )
                    {
                    // InternalFacpl2.g:1599:1: ( (lv_value_52_1= ruleDateLiteral | lv_value_52_2= ruleTimeLiteral ) )
                    // InternalFacpl2.g:1600:1: (lv_value_52_1= ruleDateLiteral | lv_value_52_2= ruleTimeLiteral )
                    {
                    // InternalFacpl2.g:1600:1: (lv_value_52_1= ruleDateLiteral | lv_value_52_2= ruleTimeLiteral )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_DATE) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==RULE_TIME) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalFacpl2.g:1601:3: lv_value_52_1= ruleDateLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueDateLiteralParserRuleCall_8_4_0_0()); 
                            	    
                            pushFollow(FOLLOW_30);
                            lv_value_52_1=ruleDateLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_52_1, 
                                    		"it.unifi.xtext.facpl.Facpl2.DateLiteral");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // InternalFacpl2.g:1616:8: lv_value_52_2= ruleTimeLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueTimeLiteralParserRuleCall_8_4_0_1()); 
                            	    
                            pushFollow(FOLLOW_30);
                            lv_value_52_2=ruleTimeLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_52_2, 
                                    		"it.unifi.xtext.facpl.Facpl2.TimeLiteral");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


                    }


                    }

                    otherlv_53=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_53, grammarAccess.getPepFunctionAccess().getRightParenthesisKeyword_8_5());
                        

                    }


                    }
                    break;
                case 10 :
                    // InternalFacpl2.g:1639:6: ( ( (lv_name_54_0= 'set-date' ) ) otherlv_55= '(' ( (otherlv_56= RULE_ID ) ) otherlv_57= ',' ( ( (lv_value_58_1= ruleDateLiteral | lv_value_58_2= ruleTimeLiteral ) ) ) otherlv_59= ')' )
                    {
                    // InternalFacpl2.g:1639:6: ( ( (lv_name_54_0= 'set-date' ) ) otherlv_55= '(' ( (otherlv_56= RULE_ID ) ) otherlv_57= ',' ( ( (lv_value_58_1= ruleDateLiteral | lv_value_58_2= ruleTimeLiteral ) ) ) otherlv_59= ')' )
                    // InternalFacpl2.g:1639:7: ( (lv_name_54_0= 'set-date' ) ) otherlv_55= '(' ( (otherlv_56= RULE_ID ) ) otherlv_57= ',' ( ( (lv_value_58_1= ruleDateLiteral | lv_value_58_2= ruleTimeLiteral ) ) ) otherlv_59= ')'
                    {
                    // InternalFacpl2.g:1639:7: ( (lv_name_54_0= 'set-date' ) )
                    // InternalFacpl2.g:1640:1: (lv_name_54_0= 'set-date' )
                    {
                    // InternalFacpl2.g:1640:1: (lv_name_54_0= 'set-date' )
                    // InternalFacpl2.g:1641:3: lv_name_54_0= 'set-date'
                    {
                    lv_name_54_0=(Token)match(input,44,FOLLOW_17); 

                            newLeafNode(lv_name_54_0, grammarAccess.getPepFunctionAccess().getNameSetDateKeyword_9_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_54_0, "set-date");
                    	    

                    }


                    }

                    otherlv_55=(Token)match(input,26,FOLLOW_12); 

                        	newLeafNode(otherlv_55, grammarAccess.getPepFunctionAccess().getLeftParenthesisKeyword_9_1());
                        
                    // InternalFacpl2.g:1658:1: ( (otherlv_56= RULE_ID ) )
                    // InternalFacpl2.g:1659:1: (otherlv_56= RULE_ID )
                    {
                    // InternalFacpl2.g:1659:1: (otherlv_56= RULE_ID )
                    // InternalFacpl2.g:1660:3: otherlv_56= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                            
                    otherlv_56=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_56, grammarAccess.getPepFunctionAccess().getAttAttributeCrossReference_9_2_0()); 
                    	

                    }


                    }

                    otherlv_57=(Token)match(input,23,FOLLOW_27); 

                        	newLeafNode(otherlv_57, grammarAccess.getPepFunctionAccess().getCommaKeyword_9_3());
                        
                    // InternalFacpl2.g:1675:1: ( ( (lv_value_58_1= ruleDateLiteral | lv_value_58_2= ruleTimeLiteral ) ) )
                    // InternalFacpl2.g:1676:1: ( (lv_value_58_1= ruleDateLiteral | lv_value_58_2= ruleTimeLiteral ) )
                    {
                    // InternalFacpl2.g:1676:1: ( (lv_value_58_1= ruleDateLiteral | lv_value_58_2= ruleTimeLiteral ) )
                    // InternalFacpl2.g:1677:1: (lv_value_58_1= ruleDateLiteral | lv_value_58_2= ruleTimeLiteral )
                    {
                    // InternalFacpl2.g:1677:1: (lv_value_58_1= ruleDateLiteral | lv_value_58_2= ruleTimeLiteral )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_DATE) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==RULE_TIME) ) {
                        alt15=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalFacpl2.g:1678:3: lv_value_58_1= ruleDateLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueDateLiteralParserRuleCall_9_4_0_0()); 
                            	    
                            pushFollow(FOLLOW_30);
                            lv_value_58_1=ruleDateLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_58_1, 
                                    		"it.unifi.xtext.facpl.Facpl2.DateLiteral");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // InternalFacpl2.g:1693:8: lv_value_58_2= ruleTimeLiteral
                            {
                             
                            	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueTimeLiteralParserRuleCall_9_4_0_1()); 
                            	    
                            pushFollow(FOLLOW_30);
                            lv_value_58_2=ruleTimeLiteral();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_58_2, 
                                    		"it.unifi.xtext.facpl.Facpl2.TimeLiteral");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


                    }


                    }

                    otherlv_59=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_59, grammarAccess.getPepFunctionAccess().getRightParenthesisKeyword_9_5());
                        

                    }


                    }
                    break;
                case 11 :
                    // InternalFacpl2.g:1716:6: ( ( (lv_name_60_0= 'set-string' ) ) otherlv_61= '(' ( (otherlv_62= RULE_ID ) ) otherlv_63= ',' ( (lv_value_64_0= ruleStringLiteral ) ) otherlv_65= ')' )
                    {
                    // InternalFacpl2.g:1716:6: ( ( (lv_name_60_0= 'set-string' ) ) otherlv_61= '(' ( (otherlv_62= RULE_ID ) ) otherlv_63= ',' ( (lv_value_64_0= ruleStringLiteral ) ) otherlv_65= ')' )
                    // InternalFacpl2.g:1716:7: ( (lv_name_60_0= 'set-string' ) ) otherlv_61= '(' ( (otherlv_62= RULE_ID ) ) otherlv_63= ',' ( (lv_value_64_0= ruleStringLiteral ) ) otherlv_65= ')'
                    {
                    // InternalFacpl2.g:1716:7: ( (lv_name_60_0= 'set-string' ) )
                    // InternalFacpl2.g:1717:1: (lv_name_60_0= 'set-string' )
                    {
                    // InternalFacpl2.g:1717:1: (lv_name_60_0= 'set-string' )
                    // InternalFacpl2.g:1718:3: lv_name_60_0= 'set-string'
                    {
                    lv_name_60_0=(Token)match(input,45,FOLLOW_17); 

                            newLeafNode(lv_name_60_0, grammarAccess.getPepFunctionAccess().getNameSetStringKeyword_10_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_60_0, "set-string");
                    	    

                    }


                    }

                    otherlv_61=(Token)match(input,26,FOLLOW_12); 

                        	newLeafNode(otherlv_61, grammarAccess.getPepFunctionAccess().getLeftParenthesisKeyword_10_1());
                        
                    // InternalFacpl2.g:1735:1: ( (otherlv_62= RULE_ID ) )
                    // InternalFacpl2.g:1736:1: (otherlv_62= RULE_ID )
                    {
                    // InternalFacpl2.g:1736:1: (otherlv_62= RULE_ID )
                    // InternalFacpl2.g:1737:3: otherlv_62= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                            
                    otherlv_62=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_62, grammarAccess.getPepFunctionAccess().getAttAttributeCrossReference_10_2_0()); 
                    	

                    }


                    }

                    otherlv_63=(Token)match(input,23,FOLLOW_4); 

                        	newLeafNode(otherlv_63, grammarAccess.getPepFunctionAccess().getCommaKeyword_10_3());
                        
                    // InternalFacpl2.g:1752:1: ( (lv_value_64_0= ruleStringLiteral ) )
                    // InternalFacpl2.g:1753:1: (lv_value_64_0= ruleStringLiteral )
                    {
                    // InternalFacpl2.g:1753:1: (lv_value_64_0= ruleStringLiteral )
                    // InternalFacpl2.g:1754:3: lv_value_64_0= ruleStringLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueStringLiteralParserRuleCall_10_4_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    lv_value_64_0=ruleStringLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_64_0, 
                            		"it.unifi.xtext.facpl.Facpl2.StringLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_65=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_65, grammarAccess.getPepFunctionAccess().getRightParenthesisKeyword_10_5());
                        

                    }


                    }
                    break;
                case 12 :
                    // InternalFacpl2.g:1775:6: ( ( (lv_name_66_0= 'sum-string' ) ) otherlv_67= '(' ( (otherlv_68= RULE_ID ) ) otherlv_69= ',' ( (lv_value_70_0= ruleStringLiteral ) ) otherlv_71= ')' )
                    {
                    // InternalFacpl2.g:1775:6: ( ( (lv_name_66_0= 'sum-string' ) ) otherlv_67= '(' ( (otherlv_68= RULE_ID ) ) otherlv_69= ',' ( (lv_value_70_0= ruleStringLiteral ) ) otherlv_71= ')' )
                    // InternalFacpl2.g:1775:7: ( (lv_name_66_0= 'sum-string' ) ) otherlv_67= '(' ( (otherlv_68= RULE_ID ) ) otherlv_69= ',' ( (lv_value_70_0= ruleStringLiteral ) ) otherlv_71= ')'
                    {
                    // InternalFacpl2.g:1775:7: ( (lv_name_66_0= 'sum-string' ) )
                    // InternalFacpl2.g:1776:1: (lv_name_66_0= 'sum-string' )
                    {
                    // InternalFacpl2.g:1776:1: (lv_name_66_0= 'sum-string' )
                    // InternalFacpl2.g:1777:3: lv_name_66_0= 'sum-string'
                    {
                    lv_name_66_0=(Token)match(input,46,FOLLOW_17); 

                            newLeafNode(lv_name_66_0, grammarAccess.getPepFunctionAccess().getNameSumStringKeyword_11_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_66_0, "sum-string");
                    	    

                    }


                    }

                    otherlv_67=(Token)match(input,26,FOLLOW_12); 

                        	newLeafNode(otherlv_67, grammarAccess.getPepFunctionAccess().getLeftParenthesisKeyword_11_1());
                        
                    // InternalFacpl2.g:1794:1: ( (otherlv_68= RULE_ID ) )
                    // InternalFacpl2.g:1795:1: (otherlv_68= RULE_ID )
                    {
                    // InternalFacpl2.g:1795:1: (otherlv_68= RULE_ID )
                    // InternalFacpl2.g:1796:3: otherlv_68= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                            
                    otherlv_68=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_68, grammarAccess.getPepFunctionAccess().getAttAttributeCrossReference_11_2_0()); 
                    	

                    }


                    }

                    otherlv_69=(Token)match(input,23,FOLLOW_4); 

                        	newLeafNode(otherlv_69, grammarAccess.getPepFunctionAccess().getCommaKeyword_11_3());
                        
                    // InternalFacpl2.g:1811:1: ( (lv_value_70_0= ruleStringLiteral ) )
                    // InternalFacpl2.g:1812:1: (lv_value_70_0= ruleStringLiteral )
                    {
                    // InternalFacpl2.g:1812:1: (lv_value_70_0= ruleStringLiteral )
                    // InternalFacpl2.g:1813:3: lv_value_70_0= ruleStringLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueStringLiteralParserRuleCall_11_4_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    lv_value_70_0=ruleStringLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_70_0, 
                            		"it.unifi.xtext.facpl.Facpl2.StringLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_71=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_71, grammarAccess.getPepFunctionAccess().getRightParenthesisKeyword_11_5());
                        

                    }


                    }
                    break;
                case 13 :
                    // InternalFacpl2.g:1834:6: ( ( (lv_name_72_0= 'flag-status' ) ) otherlv_73= '(' ( (otherlv_74= RULE_ID ) ) otherlv_75= ',' ( (lv_value_76_0= ruleBooleanLiteral ) ) otherlv_77= ')' )
                    {
                    // InternalFacpl2.g:1834:6: ( ( (lv_name_72_0= 'flag-status' ) ) otherlv_73= '(' ( (otherlv_74= RULE_ID ) ) otherlv_75= ',' ( (lv_value_76_0= ruleBooleanLiteral ) ) otherlv_77= ')' )
                    // InternalFacpl2.g:1834:7: ( (lv_name_72_0= 'flag-status' ) ) otherlv_73= '(' ( (otherlv_74= RULE_ID ) ) otherlv_75= ',' ( (lv_value_76_0= ruleBooleanLiteral ) ) otherlv_77= ')'
                    {
                    // InternalFacpl2.g:1834:7: ( (lv_name_72_0= 'flag-status' ) )
                    // InternalFacpl2.g:1835:1: (lv_name_72_0= 'flag-status' )
                    {
                    // InternalFacpl2.g:1835:1: (lv_name_72_0= 'flag-status' )
                    // InternalFacpl2.g:1836:3: lv_name_72_0= 'flag-status'
                    {
                    lv_name_72_0=(Token)match(input,47,FOLLOW_17); 

                            newLeafNode(lv_name_72_0, grammarAccess.getPepFunctionAccess().getNameFlagStatusKeyword_12_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_72_0, "flag-status");
                    	    

                    }


                    }

                    otherlv_73=(Token)match(input,26,FOLLOW_12); 

                        	newLeafNode(otherlv_73, grammarAccess.getPepFunctionAccess().getLeftParenthesisKeyword_12_1());
                        
                    // InternalFacpl2.g:1853:1: ( (otherlv_74= RULE_ID ) )
                    // InternalFacpl2.g:1854:1: (otherlv_74= RULE_ID )
                    {
                    // InternalFacpl2.g:1854:1: (otherlv_74= RULE_ID )
                    // InternalFacpl2.g:1855:3: otherlv_74= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPepFunctionRule());
                    	        }
                            
                    otherlv_74=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_74, grammarAccess.getPepFunctionAccess().getAttAttributeCrossReference_12_2_0()); 
                    	

                    }


                    }

                    otherlv_75=(Token)match(input,23,FOLLOW_8); 

                        	newLeafNode(otherlv_75, grammarAccess.getPepFunctionAccess().getCommaKeyword_12_3());
                        
                    // InternalFacpl2.g:1870:1: ( (lv_value_76_0= ruleBooleanLiteral ) )
                    // InternalFacpl2.g:1871:1: (lv_value_76_0= ruleBooleanLiteral )
                    {
                    // InternalFacpl2.g:1871:1: (lv_value_76_0= ruleBooleanLiteral )
                    // InternalFacpl2.g:1872:3: lv_value_76_0= ruleBooleanLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getPepFunctionAccess().getValueBooleanLiteralParserRuleCall_12_4_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    lv_value_76_0=ruleBooleanLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPepFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_76_0, 
                            		"it.unifi.xtext.facpl.Facpl2.BooleanLiteral");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_77=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_77, grammarAccess.getPepFunctionAccess().getRightParenthesisKeyword_12_5());
                        

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
    // $ANTLR end "rulePepFunction"


    // $ANTLR start "entryRuleObligation"
    // InternalFacpl2.g:1900:1: entryRuleObligation returns [EObject current=null] : iv_ruleObligation= ruleObligation EOF ;
    public final EObject entryRuleObligation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObligation = null;


        try {
            // InternalFacpl2.g:1901:2: (iv_ruleObligation= ruleObligation EOF )
            // InternalFacpl2.g:1902:2: iv_ruleObligation= ruleObligation EOF
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
    // InternalFacpl2.g:1909:1: ruleObligation returns [EObject current=null] : (otherlv_0= '[' ( (lv_EvaluetedOn_1_0= ruleEffect ) ) ( ( (lv_typeObl_2_1= 'M' | lv_typeObl_2_2= 'O' ) ) ) ( ( ( ( (lv_pepAction_3_0= RULE_ID ) ) otherlv_4= '(' ( ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )* )* otherlv_8= ')' ) | ( (lv_function_9_0= rulePepFunction ) ) ) | ( ( (lv_e1_10_0= ruleFunction ) ) otherlv_11= ',' ( (lv_e2_12_0= ruleFunction ) ) (otherlv_13= ',' ( (lv_expiration_14_0= ruleLiterals ) ) )? ) ) otherlv_15= ']' ) ;
    public final EObject ruleObligation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_typeObl_2_1=null;
        Token lv_typeObl_2_2=null;
        Token lv_pepAction_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Enumerator lv_EvaluetedOn_1_0 = null;

        EObject lv_expr_5_0 = null;

        EObject lv_expr_7_0 = null;

        EObject lv_function_9_0 = null;

        EObject lv_e1_10_0 = null;

        EObject lv_e2_12_0 = null;

        EObject lv_expiration_14_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:1912:28: ( (otherlv_0= '[' ( (lv_EvaluetedOn_1_0= ruleEffect ) ) ( ( (lv_typeObl_2_1= 'M' | lv_typeObl_2_2= 'O' ) ) ) ( ( ( ( (lv_pepAction_3_0= RULE_ID ) ) otherlv_4= '(' ( ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )* )* otherlv_8= ')' ) | ( (lv_function_9_0= rulePepFunction ) ) ) | ( ( (lv_e1_10_0= ruleFunction ) ) otherlv_11= ',' ( (lv_e2_12_0= ruleFunction ) ) (otherlv_13= ',' ( (lv_expiration_14_0= ruleLiterals ) ) )? ) ) otherlv_15= ']' ) )
            // InternalFacpl2.g:1913:1: (otherlv_0= '[' ( (lv_EvaluetedOn_1_0= ruleEffect ) ) ( ( (lv_typeObl_2_1= 'M' | lv_typeObl_2_2= 'O' ) ) ) ( ( ( ( (lv_pepAction_3_0= RULE_ID ) ) otherlv_4= '(' ( ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )* )* otherlv_8= ')' ) | ( (lv_function_9_0= rulePepFunction ) ) ) | ( ( (lv_e1_10_0= ruleFunction ) ) otherlv_11= ',' ( (lv_e2_12_0= ruleFunction ) ) (otherlv_13= ',' ( (lv_expiration_14_0= ruleLiterals ) ) )? ) ) otherlv_15= ']' )
            {
            // InternalFacpl2.g:1913:1: (otherlv_0= '[' ( (lv_EvaluetedOn_1_0= ruleEffect ) ) ( ( (lv_typeObl_2_1= 'M' | lv_typeObl_2_2= 'O' ) ) ) ( ( ( ( (lv_pepAction_3_0= RULE_ID ) ) otherlv_4= '(' ( ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )* )* otherlv_8= ')' ) | ( (lv_function_9_0= rulePepFunction ) ) ) | ( ( (lv_e1_10_0= ruleFunction ) ) otherlv_11= ',' ( (lv_e2_12_0= ruleFunction ) ) (otherlv_13= ',' ( (lv_expiration_14_0= ruleLiterals ) ) )? ) ) otherlv_15= ']' )
            // InternalFacpl2.g:1913:3: otherlv_0= '[' ( (lv_EvaluetedOn_1_0= ruleEffect ) ) ( ( (lv_typeObl_2_1= 'M' | lv_typeObl_2_2= 'O' ) ) ) ( ( ( ( (lv_pepAction_3_0= RULE_ID ) ) otherlv_4= '(' ( ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )* )* otherlv_8= ')' ) | ( (lv_function_9_0= rulePepFunction ) ) ) | ( ( (lv_e1_10_0= ruleFunction ) ) otherlv_11= ',' ( (lv_e2_12_0= ruleFunction ) ) (otherlv_13= ',' ( (lv_expiration_14_0= ruleLiterals ) ) )? ) ) otherlv_15= ']'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_32); 

                	newLeafNode(otherlv_0, grammarAccess.getObligationAccess().getLeftSquareBracketKeyword_0());
                
            // InternalFacpl2.g:1917:1: ( (lv_EvaluetedOn_1_0= ruleEffect ) )
            // InternalFacpl2.g:1918:1: (lv_EvaluetedOn_1_0= ruleEffect )
            {
            // InternalFacpl2.g:1918:1: (lv_EvaluetedOn_1_0= ruleEffect )
            // InternalFacpl2.g:1919:3: lv_EvaluetedOn_1_0= ruleEffect
            {
             
            	        newCompositeNode(grammarAccess.getObligationAccess().getEvaluetedOnEffectEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_33);
            lv_EvaluetedOn_1_0=ruleEffect();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getObligationRule());
            	        }
                   		set(
                   			current, 
                   			"EvaluetedOn",
                    		lv_EvaluetedOn_1_0, 
                    		"it.unifi.xtext.facpl.Facpl2.Effect");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalFacpl2.g:1935:2: ( ( (lv_typeObl_2_1= 'M' | lv_typeObl_2_2= 'O' ) ) )
            // InternalFacpl2.g:1936:1: ( (lv_typeObl_2_1= 'M' | lv_typeObl_2_2= 'O' ) )
            {
            // InternalFacpl2.g:1936:1: ( (lv_typeObl_2_1= 'M' | lv_typeObl_2_2= 'O' ) )
            // InternalFacpl2.g:1937:1: (lv_typeObl_2_1= 'M' | lv_typeObl_2_2= 'O' )
            {
            // InternalFacpl2.g:1937:1: (lv_typeObl_2_1= 'M' | lv_typeObl_2_2= 'O' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==48) ) {
                alt17=1;
            }
            else if ( (LA17_0==49) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalFacpl2.g:1938:3: lv_typeObl_2_1= 'M'
                    {
                    lv_typeObl_2_1=(Token)match(input,48,FOLLOW_34); 

                            newLeafNode(lv_typeObl_2_1, grammarAccess.getObligationAccess().getTypeOblMKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getObligationRule());
                    	        }
                           		setWithLastConsumed(current, "typeObl", lv_typeObl_2_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:1950:8: lv_typeObl_2_2= 'O'
                    {
                    lv_typeObl_2_2=(Token)match(input,49,FOLLOW_34); 

                            newLeafNode(lv_typeObl_2_2, grammarAccess.getObligationAccess().getTypeOblOKeyword_2_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getObligationRule());
                    	        }
                           		setWithLastConsumed(current, "typeObl", lv_typeObl_2_2, null);
                    	    

                    }
                    break;

            }


            }


            }

            // InternalFacpl2.g:1965:2: ( ( ( ( (lv_pepAction_3_0= RULE_ID ) ) otherlv_4= '(' ( ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )* )* otherlv_8= ')' ) | ( (lv_function_9_0= rulePepFunction ) ) ) | ( ( (lv_e1_10_0= ruleFunction ) ) otherlv_11= ',' ( (lv_e2_12_0= ruleFunction ) ) (otherlv_13= ',' ( (lv_expiration_14_0= ruleLiterals ) ) )? ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID||(LA22_0>=39 && LA22_0<=47)) ) {
                alt22=1;
            }
            else if ( ((LA22_0>=92 && LA22_0<=102)) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalFacpl2.g:1965:3: ( ( ( (lv_pepAction_3_0= RULE_ID ) ) otherlv_4= '(' ( ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )* )* otherlv_8= ')' ) | ( (lv_function_9_0= rulePepFunction ) ) )
                    {
                    // InternalFacpl2.g:1965:3: ( ( ( (lv_pepAction_3_0= RULE_ID ) ) otherlv_4= '(' ( ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )* )* otherlv_8= ')' ) | ( (lv_function_9_0= rulePepFunction ) ) )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==RULE_ID) ) {
                        alt20=1;
                    }
                    else if ( ((LA20_0>=39 && LA20_0<=47)) ) {
                        alt20=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalFacpl2.g:1965:4: ( ( (lv_pepAction_3_0= RULE_ID ) ) otherlv_4= '(' ( ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )* )* otherlv_8= ')' )
                            {
                            // InternalFacpl2.g:1965:4: ( ( (lv_pepAction_3_0= RULE_ID ) ) otherlv_4= '(' ( ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )* )* otherlv_8= ')' )
                            // InternalFacpl2.g:1965:5: ( (lv_pepAction_3_0= RULE_ID ) ) otherlv_4= '(' ( ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )* )* otherlv_8= ')'
                            {
                            // InternalFacpl2.g:1965:5: ( (lv_pepAction_3_0= RULE_ID ) )
                            // InternalFacpl2.g:1966:1: (lv_pepAction_3_0= RULE_ID )
                            {
                            // InternalFacpl2.g:1966:1: (lv_pepAction_3_0= RULE_ID )
                            // InternalFacpl2.g:1967:3: lv_pepAction_3_0= RULE_ID
                            {
                            lv_pepAction_3_0=(Token)match(input,RULE_ID,FOLLOW_17); 

                            			newLeafNode(lv_pepAction_3_0, grammarAccess.getObligationAccess().getPepActionIDTerminalRuleCall_3_0_0_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getObligationRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"pepAction",
                                    		lv_pepAction_3_0, 
                                    		"org.eclipse.xtext.common.Terminals.ID");
                            	    

                            }


                            }

                            otherlv_4=(Token)match(input,26,FOLLOW_35); 

                                	newLeafNode(otherlv_4, grammarAccess.getObligationAccess().getLeftParenthesisKeyword_3_0_0_1());
                                
                            // InternalFacpl2.g:1987:1: ( ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )* )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( ((LA19_0>=RULE_STRING && LA19_0<=RULE_TIME)||LA19_0==26||LA19_0==63||LA19_0==65||(LA19_0>=92 && LA19_0<=102)) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // InternalFacpl2.g:1987:2: ( (lv_expr_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )*
                            	    {
                            	    // InternalFacpl2.g:1987:2: ( (lv_expr_5_0= ruleExpression ) )
                            	    // InternalFacpl2.g:1988:1: (lv_expr_5_0= ruleExpression )
                            	    {
                            	    // InternalFacpl2.g:1988:1: (lv_expr_5_0= ruleExpression )
                            	    // InternalFacpl2.g:1989:3: lv_expr_5_0= ruleExpression
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getObligationAccess().getExprExpressionParserRuleCall_3_0_0_2_0_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_36);
                            	    lv_expr_5_0=ruleExpression();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getObligationRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"expr",
                            	            		lv_expr_5_0, 
                            	            		"it.unifi.xtext.facpl.Facpl2.Expression");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }

                            	    // InternalFacpl2.g:2005:2: (otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) ) )*
                            	    loop18:
                            	    do {
                            	        int alt18=2;
                            	        int LA18_0 = input.LA(1);

                            	        if ( (LA18_0==23) ) {
                            	            alt18=1;
                            	        }


                            	        switch (alt18) {
                            	    	case 1 :
                            	    	    // InternalFacpl2.g:2005:4: otherlv_6= ',' ( (lv_expr_7_0= ruleExpression ) )
                            	    	    {
                            	    	    otherlv_6=(Token)match(input,23,FOLLOW_37); 

                            	    	        	newLeafNode(otherlv_6, grammarAccess.getObligationAccess().getCommaKeyword_3_0_0_2_1_0());
                            	    	        
                            	    	    // InternalFacpl2.g:2009:1: ( (lv_expr_7_0= ruleExpression ) )
                            	    	    // InternalFacpl2.g:2010:1: (lv_expr_7_0= ruleExpression )
                            	    	    {
                            	    	    // InternalFacpl2.g:2010:1: (lv_expr_7_0= ruleExpression )
                            	    	    // InternalFacpl2.g:2011:3: lv_expr_7_0= ruleExpression
                            	    	    {
                            	    	     
                            	    	    	        newCompositeNode(grammarAccess.getObligationAccess().getExprExpressionParserRuleCall_3_0_0_2_1_1_0()); 
                            	    	    	    
                            	    	    pushFollow(FOLLOW_36);
                            	    	    lv_expr_7_0=ruleExpression();

                            	    	    state._fsp--;


                            	    	    	        if (current==null) {
                            	    	    	            current = createModelElementForParent(grammarAccess.getObligationRule());
                            	    	    	        }
                            	    	           		add(
                            	    	           			current, 
                            	    	           			"expr",
                            	    	            		lv_expr_7_0, 
                            	    	            		"it.unifi.xtext.facpl.Facpl2.Expression");
                            	    	    	        afterParserOrEnumRuleCall();
                            	    	    	    

                            	    	    }


                            	    	    }


                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    break loop18;
                            	        }
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    break loop19;
                                }
                            } while (true);

                            otherlv_8=(Token)match(input,27,FOLLOW_38); 

                                	newLeafNode(otherlv_8, grammarAccess.getObligationAccess().getRightParenthesisKeyword_3_0_0_3());
                                

                            }


                            }
                            break;
                        case 2 :
                            // InternalFacpl2.g:2032:6: ( (lv_function_9_0= rulePepFunction ) )
                            {
                            // InternalFacpl2.g:2032:6: ( (lv_function_9_0= rulePepFunction ) )
                            // InternalFacpl2.g:2033:1: (lv_function_9_0= rulePepFunction )
                            {
                            // InternalFacpl2.g:2033:1: (lv_function_9_0= rulePepFunction )
                            // InternalFacpl2.g:2034:3: lv_function_9_0= rulePepFunction
                            {
                             
                            	        newCompositeNode(grammarAccess.getObligationAccess().getFunctionPepFunctionParserRuleCall_3_0_1_0()); 
                            	    
                            pushFollow(FOLLOW_38);
                            lv_function_9_0=rulePepFunction();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getObligationRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"function",
                                    		lv_function_9_0, 
                                    		"it.unifi.xtext.facpl.Facpl2.PepFunction");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:2051:6: ( ( (lv_e1_10_0= ruleFunction ) ) otherlv_11= ',' ( (lv_e2_12_0= ruleFunction ) ) (otherlv_13= ',' ( (lv_expiration_14_0= ruleLiterals ) ) )? )
                    {
                    // InternalFacpl2.g:2051:6: ( ( (lv_e1_10_0= ruleFunction ) ) otherlv_11= ',' ( (lv_e2_12_0= ruleFunction ) ) (otherlv_13= ',' ( (lv_expiration_14_0= ruleLiterals ) ) )? )
                    // InternalFacpl2.g:2051:7: ( (lv_e1_10_0= ruleFunction ) ) otherlv_11= ',' ( (lv_e2_12_0= ruleFunction ) ) (otherlv_13= ',' ( (lv_expiration_14_0= ruleLiterals ) ) )?
                    {
                    // InternalFacpl2.g:2051:7: ( (lv_e1_10_0= ruleFunction ) )
                    // InternalFacpl2.g:2052:1: (lv_e1_10_0= ruleFunction )
                    {
                    // InternalFacpl2.g:2052:1: (lv_e1_10_0= ruleFunction )
                    // InternalFacpl2.g:2053:3: lv_e1_10_0= ruleFunction
                    {
                     
                    	        newCompositeNode(grammarAccess.getObligationAccess().getE1FunctionParserRuleCall_3_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_31);
                    lv_e1_10_0=ruleFunction();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getObligationRule());
                    	        }
                           		set(
                           			current, 
                           			"e1",
                            		lv_e1_10_0, 
                            		"it.unifi.xtext.facpl.Facpl2.Function");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_11=(Token)match(input,23,FOLLOW_34); 

                        	newLeafNode(otherlv_11, grammarAccess.getObligationAccess().getCommaKeyword_3_1_1());
                        
                    // InternalFacpl2.g:2073:1: ( (lv_e2_12_0= ruleFunction ) )
                    // InternalFacpl2.g:2074:1: (lv_e2_12_0= ruleFunction )
                    {
                    // InternalFacpl2.g:2074:1: (lv_e2_12_0= ruleFunction )
                    // InternalFacpl2.g:2075:3: lv_e2_12_0= ruleFunction
                    {
                     
                    	        newCompositeNode(grammarAccess.getObligationAccess().getE2FunctionParserRuleCall_3_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_39);
                    lv_e2_12_0=ruleFunction();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getObligationRule());
                    	        }
                           		set(
                           			current, 
                           			"e2",
                            		lv_e2_12_0, 
                            		"it.unifi.xtext.facpl.Facpl2.Function");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalFacpl2.g:2091:2: (otherlv_13= ',' ( (lv_expiration_14_0= ruleLiterals ) ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==23) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalFacpl2.g:2091:4: otherlv_13= ',' ( (lv_expiration_14_0= ruleLiterals ) )
                            {
                            otherlv_13=(Token)match(input,23,FOLLOW_37); 

                                	newLeafNode(otherlv_13, grammarAccess.getObligationAccess().getCommaKeyword_3_1_3_0());
                                
                            // InternalFacpl2.g:2095:1: ( (lv_expiration_14_0= ruleLiterals ) )
                            // InternalFacpl2.g:2096:1: (lv_expiration_14_0= ruleLiterals )
                            {
                            // InternalFacpl2.g:2096:1: (lv_expiration_14_0= ruleLiterals )
                            // InternalFacpl2.g:2097:3: lv_expiration_14_0= ruleLiterals
                            {
                             
                            	        newCompositeNode(grammarAccess.getObligationAccess().getExpirationLiteralsParserRuleCall_3_1_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_38);
                            lv_expiration_14_0=ruleLiterals();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getObligationRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"expiration",
                                    		lv_expiration_14_0, 
                                    		"it.unifi.xtext.facpl.Facpl2.Literals");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,32,FOLLOW_2); 

                	newLeafNode(otherlv_15, grammarAccess.getObligationAccess().getRightSquareBracketKeyword_4());
                

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


    // $ANTLR start "entryRuleRequest"
    // InternalFacpl2.g:2125:1: entryRuleRequest returns [EObject current=null] : iv_ruleRequest= ruleRequest EOF ;
    public final EObject entryRuleRequest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequest = null;


        try {
            // InternalFacpl2.g:2126:2: (iv_ruleRequest= ruleRequest EOF )
            // InternalFacpl2.g:2127:2: iv_ruleRequest= ruleRequest EOF
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
    // InternalFacpl2.g:2134:1: ruleRequest returns [EObject current=null] : (otherlv_0= 'Request:' (otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_name_5_0= RULE_ID ) ) ( (lv_attributes_6_0= ruleAttributeReq ) )+ otherlv_7= '}' ) ;
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
            // InternalFacpl2.g:2137:28: ( (otherlv_0= 'Request:' (otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_name_5_0= RULE_ID ) ) ( (lv_attributes_6_0= ruleAttributeReq ) )+ otherlv_7= '}' ) )
            // InternalFacpl2.g:2138:1: (otherlv_0= 'Request:' (otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_name_5_0= RULE_ID ) ) ( (lv_attributes_6_0= ruleAttributeReq ) )+ otherlv_7= '}' )
            {
            // InternalFacpl2.g:2138:1: (otherlv_0= 'Request:' (otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_name_5_0= RULE_ID ) ) ( (lv_attributes_6_0= ruleAttributeReq ) )+ otherlv_7= '}' )
            // InternalFacpl2.g:2138:3: otherlv_0= 'Request:' (otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']' )? otherlv_4= '{' ( (lv_name_5_0= RULE_ID ) ) ( (lv_attributes_6_0= ruleAttributeReq ) )+ otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_40); 

                	newLeafNode(otherlv_0, grammarAccess.getRequestAccess().getRequestKeyword_0());
                
            // InternalFacpl2.g:2142:1: (otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalFacpl2.g:2142:3: otherlv_1= '[' ( (lv_stub_2_0= RULE_STRING ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,31,FOLLOW_4); 

                        	newLeafNode(otherlv_1, grammarAccess.getRequestAccess().getLeftSquareBracketKeyword_1_0());
                        
                    // InternalFacpl2.g:2146:1: ( (lv_stub_2_0= RULE_STRING ) )
                    // InternalFacpl2.g:2147:1: (lv_stub_2_0= RULE_STRING )
                    {
                    // InternalFacpl2.g:2147:1: (lv_stub_2_0= RULE_STRING )
                    // InternalFacpl2.g:2148:3: lv_stub_2_0= RULE_STRING
                    {
                    lv_stub_2_0=(Token)match(input,RULE_STRING,FOLLOW_38); 

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

                    otherlv_3=(Token)match(input,32,FOLLOW_5); 

                        	newLeafNode(otherlv_3, grammarAccess.getRequestAccess().getRightSquareBracketKeyword_1_2());
                        

                    }
                    break;

            }

            otherlv_4=(Token)match(input,17,FOLLOW_12); 

                	newLeafNode(otherlv_4, grammarAccess.getRequestAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalFacpl2.g:2172:1: ( (lv_name_5_0= RULE_ID ) )
            // InternalFacpl2.g:2173:1: (lv_name_5_0= RULE_ID )
            {
            // InternalFacpl2.g:2173:1: (lv_name_5_0= RULE_ID )
            // InternalFacpl2.g:2174:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_17); 

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

            // InternalFacpl2.g:2190:2: ( (lv_attributes_6_0= ruleAttributeReq ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==26) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalFacpl2.g:2191:1: (lv_attributes_6_0= ruleAttributeReq )
            	    {
            	    // InternalFacpl2.g:2191:1: (lv_attributes_6_0= ruleAttributeReq )
            	    // InternalFacpl2.g:2192:3: lv_attributes_6_0= ruleAttributeReq
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequestAccess().getAttributesAttributeReqParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_41);
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
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            otherlv_7=(Token)match(input,24,FOLLOW_2); 

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
    // InternalFacpl2.g:2220:1: entryRuleAttributeReq returns [EObject current=null] : iv_ruleAttributeReq= ruleAttributeReq EOF ;
    public final EObject entryRuleAttributeReq() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeReq = null;


        try {
            // InternalFacpl2.g:2221:2: (iv_ruleAttributeReq= ruleAttributeReq EOF )
            // InternalFacpl2.g:2222:2: iv_ruleAttributeReq= ruleAttributeReq EOF
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
    // InternalFacpl2.g:2229:1: ruleAttributeReq returns [EObject current=null] : (otherlv_0= '(' ( (lv_name_1_0= ruleAttributeName ) ) otherlv_2= ',' ( (lv_value_3_0= ruleLiterals ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) ) )* otherlv_6= ')' ) ;
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
            // InternalFacpl2.g:2232:28: ( (otherlv_0= '(' ( (lv_name_1_0= ruleAttributeName ) ) otherlv_2= ',' ( (lv_value_3_0= ruleLiterals ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) ) )* otherlv_6= ')' ) )
            // InternalFacpl2.g:2233:1: (otherlv_0= '(' ( (lv_name_1_0= ruleAttributeName ) ) otherlv_2= ',' ( (lv_value_3_0= ruleLiterals ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) ) )* otherlv_6= ')' )
            {
            // InternalFacpl2.g:2233:1: (otherlv_0= '(' ( (lv_name_1_0= ruleAttributeName ) ) otherlv_2= ',' ( (lv_value_3_0= ruleLiterals ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) ) )* otherlv_6= ')' )
            // InternalFacpl2.g:2233:3: otherlv_0= '(' ( (lv_name_1_0= ruleAttributeName ) ) otherlv_2= ',' ( (lv_value_3_0= ruleLiterals ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) ) )* otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_12); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeReqAccess().getLeftParenthesisKeyword_0());
                
            // InternalFacpl2.g:2237:1: ( (lv_name_1_0= ruleAttributeName ) )
            // InternalFacpl2.g:2238:1: (lv_name_1_0= ruleAttributeName )
            {
            // InternalFacpl2.g:2238:1: (lv_name_1_0= ruleAttributeName )
            // InternalFacpl2.g:2239:3: lv_name_1_0= ruleAttributeName
            {
             
            	        newCompositeNode(grammarAccess.getAttributeReqAccess().getNameAttributeNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_31);
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

            otherlv_2=(Token)match(input,23,FOLLOW_37); 

                	newLeafNode(otherlv_2, grammarAccess.getAttributeReqAccess().getCommaKeyword_2());
                
            // InternalFacpl2.g:2259:1: ( (lv_value_3_0= ruleLiterals ) )
            // InternalFacpl2.g:2260:1: (lv_value_3_0= ruleLiterals )
            {
            // InternalFacpl2.g:2260:1: (lv_value_3_0= ruleLiterals )
            // InternalFacpl2.g:2261:3: lv_value_3_0= ruleLiterals
            {
             
            	        newCompositeNode(grammarAccess.getAttributeReqAccess().getValueLiteralsParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_18);
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

            // InternalFacpl2.g:2277:2: (otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==23) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalFacpl2.g:2277:4: otherlv_4= ',' ( (lv_value_5_0= ruleLiterals ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_37); 

            	        	newLeafNode(otherlv_4, grammarAccess.getAttributeReqAccess().getCommaKeyword_4_0());
            	        
            	    // InternalFacpl2.g:2281:1: ( (lv_value_5_0= ruleLiterals ) )
            	    // InternalFacpl2.g:2282:1: (lv_value_5_0= ruleLiterals )
            	    {
            	    // InternalFacpl2.g:2282:1: (lv_value_5_0= ruleLiterals )
            	    // InternalFacpl2.g:2283:3: lv_value_5_0= ruleLiterals
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAttributeReqAccess().getValueLiteralsParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_18);
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
            	    break loop25;
                }
            } while (true);

            otherlv_6=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFacpl2.g:2311:1: entryRuleAttributeName returns [EObject current=null] : iv_ruleAttributeName= ruleAttributeName EOF ;
    public final EObject entryRuleAttributeName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeName = null;


        try {
            // InternalFacpl2.g:2312:2: (iv_ruleAttributeName= ruleAttributeName EOF )
            // InternalFacpl2.g:2313:2: iv_ruleAttributeName= ruleAttributeName EOF
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
    // InternalFacpl2.g:2320:1: ruleAttributeName returns [EObject current=null] : ( ( (lv_category_0_0= ruleSTRING_O ) ) otherlv_1= '/' ( (lv_id_2_0= ruleSTRING_O ) ) ) ;
    public final EObject ruleAttributeName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        AntlrDatatypeRuleToken lv_id_2_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:2323:28: ( ( ( (lv_category_0_0= ruleSTRING_O ) ) otherlv_1= '/' ( (lv_id_2_0= ruleSTRING_O ) ) ) )
            // InternalFacpl2.g:2324:1: ( ( (lv_category_0_0= ruleSTRING_O ) ) otherlv_1= '/' ( (lv_id_2_0= ruleSTRING_O ) ) )
            {
            // InternalFacpl2.g:2324:1: ( ( (lv_category_0_0= ruleSTRING_O ) ) otherlv_1= '/' ( (lv_id_2_0= ruleSTRING_O ) ) )
            // InternalFacpl2.g:2324:2: ( (lv_category_0_0= ruleSTRING_O ) ) otherlv_1= '/' ( (lv_id_2_0= ruleSTRING_O ) )
            {
            // InternalFacpl2.g:2324:2: ( (lv_category_0_0= ruleSTRING_O ) )
            // InternalFacpl2.g:2325:1: (lv_category_0_0= ruleSTRING_O )
            {
            // InternalFacpl2.g:2325:1: (lv_category_0_0= ruleSTRING_O )
            // InternalFacpl2.g:2326:3: lv_category_0_0= ruleSTRING_O
            {
             
            	        newCompositeNode(grammarAccess.getAttributeNameAccess().getCategorySTRING_OParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_42);
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

            otherlv_1=(Token)match(input,51,FOLLOW_12); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeNameAccess().getSolidusKeyword_1());
                
            // InternalFacpl2.g:2346:1: ( (lv_id_2_0= ruleSTRING_O ) )
            // InternalFacpl2.g:2347:1: (lv_id_2_0= ruleSTRING_O )
            {
            // InternalFacpl2.g:2347:1: (lv_id_2_0= ruleSTRING_O )
            // InternalFacpl2.g:2348:3: lv_id_2_0= ruleSTRING_O
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
    // InternalFacpl2.g:2372:1: entryRuleSTRING_O returns [String current=null] : iv_ruleSTRING_O= ruleSTRING_O EOF ;
    public final String entryRuleSTRING_O() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTRING_O = null;


        try {
            // InternalFacpl2.g:2373:2: (iv_ruleSTRING_O= ruleSTRING_O EOF )
            // InternalFacpl2.g:2374:2: iv_ruleSTRING_O= ruleSTRING_O EOF
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
    // InternalFacpl2.g:2381:1: ruleSTRING_O returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleSTRING_O() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:2384:28: ( (this_ID_0= RULE_ID ( (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID )* ) )
            // InternalFacpl2.g:2385:1: (this_ID_0= RULE_ID ( (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID )* )
            {
            // InternalFacpl2.g:2385:1: (this_ID_0= RULE_ID ( (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID )* )
            // InternalFacpl2.g:2385:6: this_ID_0= RULE_ID ( (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_43); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getSTRING_OAccess().getIDTerminalRuleCall_0()); 
                
            // InternalFacpl2.g:2392:1: ( (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==19||(LA27_0>=52 && LA27_0<=54)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalFacpl2.g:2392:2: (kw= ':' | kw= '_' | kw= '-' | kw= '.' ) this_ID_5= RULE_ID
            	    {
            	    // InternalFacpl2.g:2392:2: (kw= ':' | kw= '_' | kw= '-' | kw= '.' )
            	    int alt26=4;
            	    switch ( input.LA(1) ) {
            	    case 19:
            	        {
            	        alt26=1;
            	        }
            	        break;
            	    case 52:
            	        {
            	        alt26=2;
            	        }
            	        break;
            	    case 53:
            	        {
            	        alt26=3;
            	        }
            	        break;
            	    case 54:
            	        {
            	        alt26=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 26, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt26) {
            	        case 1 :
            	            // InternalFacpl2.g:2393:2: kw= ':'
            	            {
            	            kw=(Token)match(input,19,FOLLOW_12); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSTRING_OAccess().getColonKeyword_1_0_0()); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // InternalFacpl2.g:2400:2: kw= '_'
            	            {
            	            kw=(Token)match(input,52,FOLLOW_12); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSTRING_OAccess().get_Keyword_1_0_1()); 
            	                

            	            }
            	            break;
            	        case 3 :
            	            // InternalFacpl2.g:2407:2: kw= '-'
            	            {
            	            kw=(Token)match(input,53,FOLLOW_12); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSTRING_OAccess().getHyphenMinusKeyword_1_0_2()); 
            	                

            	            }
            	            break;
            	        case 4 :
            	            // InternalFacpl2.g:2414:2: kw= '.'
            	            {
            	            kw=(Token)match(input,54,FOLLOW_12); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSTRING_OAccess().getFullStopKeyword_1_0_3()); 
            	                

            	            }
            	            break;

            	    }

            	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_43); 

            	    		current.merge(this_ID_5);
            	        
            	     
            	        newLeafNode(this_ID_5, grammarAccess.getSTRING_OAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalFacpl2.g:2434:1: entryRulePDP returns [EObject current=null] : iv_rulePDP= rulePDP EOF ;
    public final EObject entryRulePDP() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePDP = null;


        try {
            // InternalFacpl2.g:2435:2: (iv_rulePDP= rulePDP EOF )
            // InternalFacpl2.g:2436:2: iv_rulePDP= rulePDP EOF
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
    // InternalFacpl2.g:2443:1: rulePDP returns [EObject current=null] : ( ( (lv_pdpAlg_0_0= ruleAlg ) ) ( (lv_polSet_1_0= ruleAbstractPolicyIncl ) )+ ) ;
    public final EObject rulePDP() throws RecognitionException {
        EObject current = null;

        EObject lv_pdpAlg_0_0 = null;

        EObject lv_polSet_1_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:2446:28: ( ( ( (lv_pdpAlg_0_0= ruleAlg ) ) ( (lv_polSet_1_0= ruleAbstractPolicyIncl ) )+ ) )
            // InternalFacpl2.g:2447:1: ( ( (lv_pdpAlg_0_0= ruleAlg ) ) ( (lv_polSet_1_0= ruleAbstractPolicyIncl ) )+ )
            {
            // InternalFacpl2.g:2447:1: ( ( (lv_pdpAlg_0_0= ruleAlg ) ) ( (lv_polSet_1_0= ruleAbstractPolicyIncl ) )+ )
            // InternalFacpl2.g:2447:2: ( (lv_pdpAlg_0_0= ruleAlg ) ) ( (lv_polSet_1_0= ruleAbstractPolicyIncl ) )+
            {
            // InternalFacpl2.g:2447:2: ( (lv_pdpAlg_0_0= ruleAlg ) )
            // InternalFacpl2.g:2448:1: (lv_pdpAlg_0_0= ruleAlg )
            {
            // InternalFacpl2.g:2448:1: (lv_pdpAlg_0_0= ruleAlg )
            // InternalFacpl2.g:2449:3: lv_pdpAlg_0_0= ruleAlg
            {
             
            	        newCompositeNode(grammarAccess.getPDPAccess().getPdpAlgAlgParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_44);
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

            // InternalFacpl2.g:2465:2: ( (lv_polSet_1_0= ruleAbstractPolicyIncl ) )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=55 && LA28_0<=56)||LA28_0==60) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalFacpl2.g:2466:1: (lv_polSet_1_0= ruleAbstractPolicyIncl )
            	    {
            	    // InternalFacpl2.g:2466:1: (lv_polSet_1_0= ruleAbstractPolicyIncl )
            	    // InternalFacpl2.g:2467:3: lv_polSet_1_0= ruleAbstractPolicyIncl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPDPAccess().getPolSetAbstractPolicyInclParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_45);
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
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
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
    // InternalFacpl2.g:2491:1: entryRuleFacplPolicy returns [EObject current=null] : iv_ruleFacplPolicy= ruleFacplPolicy EOF ;
    public final EObject entryRuleFacplPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFacplPolicy = null;


        try {
            // InternalFacpl2.g:2492:2: (iv_ruleFacplPolicy= ruleFacplPolicy EOF )
            // InternalFacpl2.g:2493:2: iv_ruleFacplPolicy= ruleFacplPolicy EOF
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
    // InternalFacpl2.g:2500:1: ruleFacplPolicy returns [EObject current=null] : (this_PolicySet_0= rulePolicySet | this_Rule_1= ruleRule ) ;
    public final EObject ruleFacplPolicy() throws RecognitionException {
        EObject current = null;

        EObject this_PolicySet_0 = null;

        EObject this_Rule_1 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:2503:28: ( (this_PolicySet_0= rulePolicySet | this_Rule_1= ruleRule ) )
            // InternalFacpl2.g:2504:1: (this_PolicySet_0= rulePolicySet | this_Rule_1= ruleRule )
            {
            // InternalFacpl2.g:2504:1: (this_PolicySet_0= rulePolicySet | this_Rule_1= ruleRule )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==56) ) {
                alt29=1;
            }
            else if ( (LA29_0==60) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalFacpl2.g:2505:5: this_PolicySet_0= rulePolicySet
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
                    // InternalFacpl2.g:2515:5: this_Rule_1= ruleRule
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
    // InternalFacpl2.g:2531:1: entryRuleAbstractPolicyIncl returns [EObject current=null] : iv_ruleAbstractPolicyIncl= ruleAbstractPolicyIncl EOF ;
    public final EObject entryRuleAbstractPolicyIncl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractPolicyIncl = null;


        try {
            // InternalFacpl2.g:2532:2: (iv_ruleAbstractPolicyIncl= ruleAbstractPolicyIncl EOF )
            // InternalFacpl2.g:2533:2: iv_ruleAbstractPolicyIncl= ruleAbstractPolicyIncl EOF
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
    // InternalFacpl2.g:2540:1: ruleAbstractPolicyIncl returns [EObject current=null] : ( ( (lv_newPolicy_0_0= ruleFacplPolicy ) ) | (otherlv_1= 'include' ( (otherlv_2= RULE_ID ) ) ) ) ;
    public final EObject ruleAbstractPolicyIncl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_newPolicy_0_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:2543:28: ( ( ( (lv_newPolicy_0_0= ruleFacplPolicy ) ) | (otherlv_1= 'include' ( (otherlv_2= RULE_ID ) ) ) ) )
            // InternalFacpl2.g:2544:1: ( ( (lv_newPolicy_0_0= ruleFacplPolicy ) ) | (otherlv_1= 'include' ( (otherlv_2= RULE_ID ) ) ) )
            {
            // InternalFacpl2.g:2544:1: ( ( (lv_newPolicy_0_0= ruleFacplPolicy ) ) | (otherlv_1= 'include' ( (otherlv_2= RULE_ID ) ) ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==56||LA30_0==60) ) {
                alt30=1;
            }
            else if ( (LA30_0==55) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalFacpl2.g:2544:2: ( (lv_newPolicy_0_0= ruleFacplPolicy ) )
                    {
                    // InternalFacpl2.g:2544:2: ( (lv_newPolicy_0_0= ruleFacplPolicy ) )
                    // InternalFacpl2.g:2545:1: (lv_newPolicy_0_0= ruleFacplPolicy )
                    {
                    // InternalFacpl2.g:2545:1: (lv_newPolicy_0_0= ruleFacplPolicy )
                    // InternalFacpl2.g:2546:3: lv_newPolicy_0_0= ruleFacplPolicy
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
                    // InternalFacpl2.g:2563:6: (otherlv_1= 'include' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalFacpl2.g:2563:6: (otherlv_1= 'include' ( (otherlv_2= RULE_ID ) ) )
                    // InternalFacpl2.g:2563:8: otherlv_1= 'include' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,55,FOLLOW_12); 

                        	newLeafNode(otherlv_1, grammarAccess.getAbstractPolicyInclAccess().getIncludeKeyword_1_0());
                        
                    // InternalFacpl2.g:2567:1: ( (otherlv_2= RULE_ID ) )
                    // InternalFacpl2.g:2568:1: (otherlv_2= RULE_ID )
                    {
                    // InternalFacpl2.g:2568:1: (otherlv_2= RULE_ID )
                    // InternalFacpl2.g:2569:3: otherlv_2= RULE_ID
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
    // InternalFacpl2.g:2588:1: entryRulePolicySet returns [EObject current=null] : iv_rulePolicySet= rulePolicySet EOF ;
    public final EObject entryRulePolicySet() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePolicySet = null;


        try {
            // InternalFacpl2.g:2589:2: (iv_rulePolicySet= rulePolicySet EOF )
            // InternalFacpl2.g:2590:2: iv_rulePolicySet= rulePolicySet EOF
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
    // InternalFacpl2.g:2597:1: rulePolicySet returns [EObject current=null] : (otherlv_0= 'PolicySet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_polSetAlg_3_0= ruleAlg ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? otherlv_6= 'policies:' ( (lv_policies_7_0= ruleAbstractPolicyIncl ) )+ (otherlv_8= 'obl:' ( (lv_obl_9_0= ruleObligation ) )* )? otherlv_10= '}' ) ;
    public final EObject rulePolicySet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_polSetAlg_3_0 = null;

        EObject lv_target_5_0 = null;

        EObject lv_policies_7_0 = null;

        EObject lv_obl_9_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:2600:28: ( (otherlv_0= 'PolicySet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_polSetAlg_3_0= ruleAlg ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? otherlv_6= 'policies:' ( (lv_policies_7_0= ruleAbstractPolicyIncl ) )+ (otherlv_8= 'obl:' ( (lv_obl_9_0= ruleObligation ) )* )? otherlv_10= '}' ) )
            // InternalFacpl2.g:2601:1: (otherlv_0= 'PolicySet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_polSetAlg_3_0= ruleAlg ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? otherlv_6= 'policies:' ( (lv_policies_7_0= ruleAbstractPolicyIncl ) )+ (otherlv_8= 'obl:' ( (lv_obl_9_0= ruleObligation ) )* )? otherlv_10= '}' )
            {
            // InternalFacpl2.g:2601:1: (otherlv_0= 'PolicySet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_polSetAlg_3_0= ruleAlg ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? otherlv_6= 'policies:' ( (lv_policies_7_0= ruleAbstractPolicyIncl ) )+ (otherlv_8= 'obl:' ( (lv_obl_9_0= ruleObligation ) )* )? otherlv_10= '}' )
            // InternalFacpl2.g:2601:3: otherlv_0= 'PolicySet' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_polSetAlg_3_0= ruleAlg ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? otherlv_6= 'policies:' ( (lv_policies_7_0= ruleAbstractPolicyIncl ) )+ (otherlv_8= 'obl:' ( (lv_obl_9_0= ruleObligation ) )* )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_12); 

                	newLeafNode(otherlv_0, grammarAccess.getPolicySetAccess().getPolicySetKeyword_0());
                
            // InternalFacpl2.g:2605:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalFacpl2.g:2606:1: (lv_name_1_0= RULE_ID )
            {
            // InternalFacpl2.g:2606:1: (lv_name_1_0= RULE_ID )
            // InternalFacpl2.g:2607:3: lv_name_1_0= RULE_ID
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
                
            // InternalFacpl2.g:2627:1: ( (lv_polSetAlg_3_0= ruleAlg ) )
            // InternalFacpl2.g:2628:1: (lv_polSetAlg_3_0= ruleAlg )
            {
            // InternalFacpl2.g:2628:1: (lv_polSetAlg_3_0= ruleAlg )
            // InternalFacpl2.g:2629:3: lv_polSetAlg_3_0= ruleAlg
            {
             
            	        newCompositeNode(grammarAccess.getPolicySetAccess().getPolSetAlgAlgParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_46);
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

            // InternalFacpl2.g:2645:2: (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==57) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalFacpl2.g:2645:4: otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,57,FOLLOW_37); 

                        	newLeafNode(otherlv_4, grammarAccess.getPolicySetAccess().getTargetKeyword_4_0());
                        
                    // InternalFacpl2.g:2649:1: ( (lv_target_5_0= ruleExpression ) )
                    // InternalFacpl2.g:2650:1: (lv_target_5_0= ruleExpression )
                    {
                    // InternalFacpl2.g:2650:1: (lv_target_5_0= ruleExpression )
                    // InternalFacpl2.g:2651:3: lv_target_5_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPolicySetAccess().getTargetExpressionParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_47);
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

            otherlv_6=(Token)match(input,58,FOLLOW_44); 

                	newLeafNode(otherlv_6, grammarAccess.getPolicySetAccess().getPoliciesKeyword_5());
                
            // InternalFacpl2.g:2671:1: ( (lv_policies_7_0= ruleAbstractPolicyIncl ) )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=55 && LA32_0<=56)||LA32_0==60) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalFacpl2.g:2672:1: (lv_policies_7_0= ruleAbstractPolicyIncl )
            	    {
            	    // InternalFacpl2.g:2672:1: (lv_policies_7_0= ruleAbstractPolicyIncl )
            	    // InternalFacpl2.g:2673:3: lv_policies_7_0= ruleAbstractPolicyIncl
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPolicySetAccess().getPoliciesAbstractPolicyInclParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_48);
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
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            // InternalFacpl2.g:2689:3: (otherlv_8= 'obl:' ( (lv_obl_9_0= ruleObligation ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==59) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalFacpl2.g:2689:5: otherlv_8= 'obl:' ( (lv_obl_9_0= ruleObligation ) )*
                    {
                    otherlv_8=(Token)match(input,59,FOLLOW_49); 

                        	newLeafNode(otherlv_8, grammarAccess.getPolicySetAccess().getOblKeyword_7_0());
                        
                    // InternalFacpl2.g:2693:1: ( (lv_obl_9_0= ruleObligation ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==31) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalFacpl2.g:2694:1: (lv_obl_9_0= ruleObligation )
                    	    {
                    	    // InternalFacpl2.g:2694:1: (lv_obl_9_0= ruleObligation )
                    	    // InternalFacpl2.g:2695:3: lv_obl_9_0= ruleObligation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPolicySetAccess().getOblObligationParserRuleCall_7_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_49);
                    	    lv_obl_9_0=ruleObligation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPolicySetRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"obl",
                    	            		lv_obl_9_0, 
                    	            		"it.unifi.xtext.facpl.Facpl2.Obligation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,24,FOLLOW_2); 

                	newLeafNode(otherlv_10, grammarAccess.getPolicySetAccess().getRightCurlyBracketKeyword_8());
                

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
    // InternalFacpl2.g:2723:1: entryRuleAlg returns [EObject current=null] : iv_ruleAlg= ruleAlg EOF ;
    public final EObject entryRuleAlg() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlg = null;


        try {
            // InternalFacpl2.g:2724:2: (iv_ruleAlg= ruleAlg EOF )
            // InternalFacpl2.g:2725:2: iv_ruleAlg= ruleAlg EOF
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
    // InternalFacpl2.g:2732:1: ruleAlg returns [EObject current=null] : ( ( (lv_idAlg_0_0= ruleAlgLiteral ) ) (otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) ) )? ) ;
    public final EObject ruleAlg() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_idAlg_0_0 = null;

        Enumerator lv_fStrategy_2_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:2735:28: ( ( ( (lv_idAlg_0_0= ruleAlgLiteral ) ) (otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) ) )? ) )
            // InternalFacpl2.g:2736:1: ( ( (lv_idAlg_0_0= ruleAlgLiteral ) ) (otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) ) )? )
            {
            // InternalFacpl2.g:2736:1: ( ( (lv_idAlg_0_0= ruleAlgLiteral ) ) (otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) ) )? )
            // InternalFacpl2.g:2736:2: ( (lv_idAlg_0_0= ruleAlgLiteral ) ) (otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) ) )?
            {
            // InternalFacpl2.g:2736:2: ( (lv_idAlg_0_0= ruleAlgLiteral ) )
            // InternalFacpl2.g:2737:1: (lv_idAlg_0_0= ruleAlgLiteral )
            {
            // InternalFacpl2.g:2737:1: (lv_idAlg_0_0= ruleAlgLiteral )
            // InternalFacpl2.g:2738:3: lv_idAlg_0_0= ruleAlgLiteral
            {
             
            	        newCompositeNode(grammarAccess.getAlgAccess().getIdAlgAlgLiteralEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_50);
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

            // InternalFacpl2.g:2754:2: (otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==53) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalFacpl2.g:2754:4: otherlv_1= '-' ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) )
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_51); 

                        	newLeafNode(otherlv_1, grammarAccess.getAlgAccess().getHyphenMinusKeyword_1_0());
                        
                    // InternalFacpl2.g:2758:1: ( (lv_fStrategy_2_0= ruleFulfillmentStrategy ) )
                    // InternalFacpl2.g:2759:1: (lv_fStrategy_2_0= ruleFulfillmentStrategy )
                    {
                    // InternalFacpl2.g:2759:1: (lv_fStrategy_2_0= ruleFulfillmentStrategy )
                    // InternalFacpl2.g:2760:3: lv_fStrategy_2_0= ruleFulfillmentStrategy
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
    // InternalFacpl2.g:2784:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalFacpl2.g:2785:2: (iv_ruleRule= ruleRule EOF )
            // InternalFacpl2.g:2786:2: iv_ruleRule= ruleRule EOF
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
    // InternalFacpl2.g:2793:1: ruleRule returns [EObject current=null] : (otherlv_0= 'Rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_effect_3_0= ruleEffect ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? (otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )* )? otherlv_8= ')' ) ;
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
            // InternalFacpl2.g:2796:28: ( (otherlv_0= 'Rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_effect_3_0= ruleEffect ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? (otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )* )? otherlv_8= ')' ) )
            // InternalFacpl2.g:2797:1: (otherlv_0= 'Rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_effect_3_0= ruleEffect ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? (otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )* )? otherlv_8= ')' )
            {
            // InternalFacpl2.g:2797:1: (otherlv_0= 'Rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_effect_3_0= ruleEffect ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? (otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )* )? otherlv_8= ')' )
            // InternalFacpl2.g:2797:3: otherlv_0= 'Rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_effect_3_0= ruleEffect ) ) (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )? (otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )* )? otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_12); 

                	newLeafNode(otherlv_0, grammarAccess.getRuleAccess().getRuleKeyword_0());
                
            // InternalFacpl2.g:2801:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalFacpl2.g:2802:1: (lv_name_1_0= RULE_ID )
            {
            // InternalFacpl2.g:2802:1: (lv_name_1_0= RULE_ID )
            // InternalFacpl2.g:2803:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); 

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

            otherlv_2=(Token)match(input,26,FOLLOW_32); 

                	newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getLeftParenthesisKeyword_2());
                
            // InternalFacpl2.g:2823:1: ( (lv_effect_3_0= ruleEffect ) )
            // InternalFacpl2.g:2824:1: (lv_effect_3_0= ruleEffect )
            {
            // InternalFacpl2.g:2824:1: (lv_effect_3_0= ruleEffect )
            // InternalFacpl2.g:2825:3: lv_effect_3_0= ruleEffect
            {
             
            	        newCompositeNode(grammarAccess.getRuleAccess().getEffectEffectEnumRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_52);
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

            // InternalFacpl2.g:2841:2: (otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==57) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalFacpl2.g:2841:4: otherlv_4= 'target:' ( (lv_target_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,57,FOLLOW_37); 

                        	newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getTargetKeyword_4_0());
                        
                    // InternalFacpl2.g:2845:1: ( (lv_target_5_0= ruleExpression ) )
                    // InternalFacpl2.g:2846:1: (lv_target_5_0= ruleExpression )
                    {
                    // InternalFacpl2.g:2846:1: (lv_target_5_0= ruleExpression )
                    // InternalFacpl2.g:2847:3: lv_target_5_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleAccess().getTargetExpressionParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_53);
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

            // InternalFacpl2.g:2863:4: (otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==59) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalFacpl2.g:2863:6: otherlv_6= 'obl:' ( (lv_obl_7_0= ruleObligation ) )*
                    {
                    otherlv_6=(Token)match(input,59,FOLLOW_54); 

                        	newLeafNode(otherlv_6, grammarAccess.getRuleAccess().getOblKeyword_5_0());
                        
                    // InternalFacpl2.g:2867:1: ( (lv_obl_7_0= ruleObligation ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==31) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalFacpl2.g:2868:1: (lv_obl_7_0= ruleObligation )
                    	    {
                    	    // InternalFacpl2.g:2868:1: (lv_obl_7_0= ruleObligation )
                    	    // InternalFacpl2.g:2869:3: lv_obl_7_0= ruleObligation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRuleAccess().getOblObligationParserRuleCall_5_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_54);
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
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,27,FOLLOW_2); 

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


    // $ANTLR start "entryRuleExpression"
    // InternalFacpl2.g:2897:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalFacpl2.g:2898:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalFacpl2.g:2899:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalFacpl2.g:2906:1: ruleExpression returns [EObject current=null] : this_AndExpression_0= ruleAndExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AndExpression_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:2909:28: (this_AndExpression_0= ruleAndExpression )
            // InternalFacpl2.g:2911:5: this_AndExpression_0= ruleAndExpression
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
    // InternalFacpl2.g:2927:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalFacpl2.g:2928:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalFacpl2.g:2929:2: iv_ruleAndExpression= ruleAndExpression EOF
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
    // InternalFacpl2.g:2936:1: ruleAndExpression returns [EObject current=null] : (this_OrExpression_0= ruleOrExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_OrExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:2939:28: ( (this_OrExpression_0= ruleOrExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) ) )* ) )
            // InternalFacpl2.g:2940:1: (this_OrExpression_0= ruleOrExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) ) )* )
            {
            // InternalFacpl2.g:2940:1: (this_OrExpression_0= ruleOrExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) ) )* )
            // InternalFacpl2.g:2941:5: this_OrExpression_0= ruleOrExpression ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAndExpressionAccess().getOrExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_55);
            this_OrExpression_0=ruleOrExpression();

            state._fsp--;

             
                    current = this_OrExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalFacpl2.g:2949:1: ( () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==61) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalFacpl2.g:2949:2: () otherlv_2= '&&' ( (lv_right_3_0= ruleOrExpression ) )
            	    {
            	    // InternalFacpl2.g:2949:2: ()
            	    // InternalFacpl2.g:2950:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,61,FOLLOW_37); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAmpersandAmpersandKeyword_1_1());
            	        
            	    // InternalFacpl2.g:2959:1: ( (lv_right_3_0= ruleOrExpression ) )
            	    // InternalFacpl2.g:2960:1: (lv_right_3_0= ruleOrExpression )
            	    {
            	    // InternalFacpl2.g:2960:1: (lv_right_3_0= ruleOrExpression )
            	    // InternalFacpl2.g:2961:3: lv_right_3_0= ruleOrExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAndExpressionAccess().getRightOrExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_55);
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
            	    break loop39;
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
    // InternalFacpl2.g:2985:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalFacpl2.g:2986:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalFacpl2.g:2987:2: iv_ruleOrExpression= ruleOrExpression EOF
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
    // InternalFacpl2.g:2994:1: ruleOrExpression returns [EObject current=null] : (this_BasicExpression_0= ruleBasicExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BasicExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:2997:28: ( (this_BasicExpression_0= ruleBasicExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) ) )* ) )
            // InternalFacpl2.g:2998:1: (this_BasicExpression_0= ruleBasicExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) ) )* )
            {
            // InternalFacpl2.g:2998:1: (this_BasicExpression_0= ruleBasicExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) ) )* )
            // InternalFacpl2.g:2999:5: this_BasicExpression_0= ruleBasicExpression ( () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getOrExpressionAccess().getBasicExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_56);
            this_BasicExpression_0=ruleBasicExpression();

            state._fsp--;

             
                    current = this_BasicExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalFacpl2.g:3007:1: ( () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==62) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalFacpl2.g:3007:2: () otherlv_2= '||' ( (lv_right_3_0= ruleBasicExpression ) )
            	    {
            	    // InternalFacpl2.g:3007:2: ()
            	    // InternalFacpl2.g:3008:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,62,FOLLOW_37); 

            	        	newLeafNode(otherlv_2, grammarAccess.getOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1());
            	        
            	    // InternalFacpl2.g:3017:1: ( (lv_right_3_0= ruleBasicExpression ) )
            	    // InternalFacpl2.g:3018:1: (lv_right_3_0= ruleBasicExpression )
            	    {
            	    // InternalFacpl2.g:3018:1: (lv_right_3_0= ruleBasicExpression )
            	    // InternalFacpl2.g:3019:3: lv_right_3_0= ruleBasicExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOrExpressionAccess().getRightBasicExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_56);
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
            	    break loop40;
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
    // InternalFacpl2.g:3043:1: entryRuleBasicExpression returns [EObject current=null] : iv_ruleBasicExpression= ruleBasicExpression EOF ;
    public final EObject entryRuleBasicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicExpression = null;


        try {
            // InternalFacpl2.g:3044:2: (iv_ruleBasicExpression= ruleBasicExpression EOF )
            // InternalFacpl2.g:3045:2: iv_ruleBasicExpression= ruleBasicExpression EOF
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
    // InternalFacpl2.g:3052:1: ruleBasicExpression returns [EObject current=null] : (this_Function_0= ruleFunction | this_DeclaredFunction_1= ruleDeclaredFunction | (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' ) | this_NotExpression_5= ruleNotExpression | this_Literals_6= ruleLiterals ) ;
    public final EObject ruleBasicExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Function_0 = null;

        EObject this_DeclaredFunction_1 = null;

        EObject this_Expression_3 = null;

        EObject this_NotExpression_5 = null;

        EObject this_Literals_6 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:3055:28: ( (this_Function_0= ruleFunction | this_DeclaredFunction_1= ruleDeclaredFunction | (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' ) | this_NotExpression_5= ruleNotExpression | this_Literals_6= ruleLiterals ) )
            // InternalFacpl2.g:3056:1: (this_Function_0= ruleFunction | this_DeclaredFunction_1= ruleDeclaredFunction | (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' ) | this_NotExpression_5= ruleNotExpression | this_Literals_6= ruleLiterals )
            {
            // InternalFacpl2.g:3056:1: (this_Function_0= ruleFunction | this_DeclaredFunction_1= ruleDeclaredFunction | (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' ) | this_NotExpression_5= ruleNotExpression | this_Literals_6= ruleLiterals )
            int alt41=5;
            switch ( input.LA(1) ) {
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
                {
                alt41=1;
                }
                break;
            case RULE_ID:
                {
                int LA41_2 = input.LA(2);

                if ( (LA41_2==26) ) {
                    alt41=2;
                }
                else if ( (LA41_2==19||(LA41_2>=51 && LA41_2<=54)) ) {
                    alt41=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 2, input);

                    throw nvae;
                }
                }
                break;
            case 26:
                {
                alt41=3;
                }
                break;
            case 63:
                {
                alt41=4;
                }
                break;
            case RULE_STRING:
            case RULE_BOOLEAN:
            case RULE_INT:
            case RULE_REAL:
            case RULE_DATE:
            case RULE_TIME:
            case 65:
                {
                alt41=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalFacpl2.g:3057:5: this_Function_0= ruleFunction
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
                    // InternalFacpl2.g:3067:5: this_DeclaredFunction_1= ruleDeclaredFunction
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
                    // InternalFacpl2.g:3076:6: (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' )
                    {
                    // InternalFacpl2.g:3076:6: (otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')' )
                    // InternalFacpl2.g:3076:8: otherlv_2= '(' this_Expression_3= ruleExpression otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,26,FOLLOW_37); 

                        	newLeafNode(otherlv_2, grammarAccess.getBasicExpressionAccess().getLeftParenthesisKeyword_2_0());
                        
                     
                            newCompositeNode(grammarAccess.getBasicExpressionAccess().getExpressionParserRuleCall_2_1()); 
                        
                    pushFollow(FOLLOW_30);
                    this_Expression_3=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_3; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_4=(Token)match(input,27,FOLLOW_2); 

                        	newLeafNode(otherlv_4, grammarAccess.getBasicExpressionAccess().getRightParenthesisKeyword_2_2());
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalFacpl2.g:3095:5: this_NotExpression_5= ruleNotExpression
                    {
                     
                            newCompositeNode(grammarAccess.getBasicExpressionAccess().getNotExpressionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_NotExpression_5=ruleNotExpression();

                    state._fsp--;

                     
                            current = this_NotExpression_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalFacpl2.g:3105:5: this_Literals_6= ruleLiterals
                    {
                     
                            newCompositeNode(grammarAccess.getBasicExpressionAccess().getLiteralsParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Literals_6=ruleLiterals();

                    state._fsp--;

                     
                            current = this_Literals_6; 
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
    // InternalFacpl2.g:3121:1: entryRuleNotExpression returns [EObject current=null] : iv_ruleNotExpression= ruleNotExpression EOF ;
    public final EObject entryRuleNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpression = null;


        try {
            // InternalFacpl2.g:3122:2: (iv_ruleNotExpression= ruleNotExpression EOF )
            // InternalFacpl2.g:3123:2: iv_ruleNotExpression= ruleNotExpression EOF
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
    // InternalFacpl2.g:3130:1: ruleNotExpression returns [EObject current=null] : (otherlv_0= '!' ( (lv_arg_1_0= ruleBasicExpression ) ) ) ;
    public final EObject ruleNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_arg_1_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:3133:28: ( (otherlv_0= '!' ( (lv_arg_1_0= ruleBasicExpression ) ) ) )
            // InternalFacpl2.g:3134:1: (otherlv_0= '!' ( (lv_arg_1_0= ruleBasicExpression ) ) )
            {
            // InternalFacpl2.g:3134:1: (otherlv_0= '!' ( (lv_arg_1_0= ruleBasicExpression ) ) )
            // InternalFacpl2.g:3134:3: otherlv_0= '!' ( (lv_arg_1_0= ruleBasicExpression ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_37); 

                	newLeafNode(otherlv_0, grammarAccess.getNotExpressionAccess().getExclamationMarkKeyword_0());
                
            // InternalFacpl2.g:3138:1: ( (lv_arg_1_0= ruleBasicExpression ) )
            // InternalFacpl2.g:3139:1: (lv_arg_1_0= ruleBasicExpression )
            {
            // InternalFacpl2.g:3139:1: (lv_arg_1_0= ruleBasicExpression )
            // InternalFacpl2.g:3140:3: lv_arg_1_0= ruleBasicExpression
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
    // InternalFacpl2.g:3164:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalFacpl2.g:3165:2: (iv_ruleFunction= ruleFunction EOF )
            // InternalFacpl2.g:3166:2: iv_ruleFunction= ruleFunction EOF
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
    // InternalFacpl2.g:3173:1: ruleFunction returns [EObject current=null] : ( ( (lv_functionId_0_0= rulefunID ) ) otherlv_1= '(' ( ( (lv_arg1_2_0= ruleExpression ) ) | (otherlv_3= 'status' otherlv_4= '/' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ',' ( ( (lv_arg2_7_0= ruleExpression ) ) | (otherlv_8= 'status' otherlv_9= '/' ( (otherlv_10= RULE_ID ) ) ) ) otherlv_11= ')' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Enumerator lv_functionId_0_0 = null;

        EObject lv_arg1_2_0 = null;

        EObject lv_arg2_7_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:3176:28: ( ( ( (lv_functionId_0_0= rulefunID ) ) otherlv_1= '(' ( ( (lv_arg1_2_0= ruleExpression ) ) | (otherlv_3= 'status' otherlv_4= '/' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ',' ( ( (lv_arg2_7_0= ruleExpression ) ) | (otherlv_8= 'status' otherlv_9= '/' ( (otherlv_10= RULE_ID ) ) ) ) otherlv_11= ')' ) )
            // InternalFacpl2.g:3177:1: ( ( (lv_functionId_0_0= rulefunID ) ) otherlv_1= '(' ( ( (lv_arg1_2_0= ruleExpression ) ) | (otherlv_3= 'status' otherlv_4= '/' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ',' ( ( (lv_arg2_7_0= ruleExpression ) ) | (otherlv_8= 'status' otherlv_9= '/' ( (otherlv_10= RULE_ID ) ) ) ) otherlv_11= ')' )
            {
            // InternalFacpl2.g:3177:1: ( ( (lv_functionId_0_0= rulefunID ) ) otherlv_1= '(' ( ( (lv_arg1_2_0= ruleExpression ) ) | (otherlv_3= 'status' otherlv_4= '/' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ',' ( ( (lv_arg2_7_0= ruleExpression ) ) | (otherlv_8= 'status' otherlv_9= '/' ( (otherlv_10= RULE_ID ) ) ) ) otherlv_11= ')' )
            // InternalFacpl2.g:3177:2: ( (lv_functionId_0_0= rulefunID ) ) otherlv_1= '(' ( ( (lv_arg1_2_0= ruleExpression ) ) | (otherlv_3= 'status' otherlv_4= '/' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ',' ( ( (lv_arg2_7_0= ruleExpression ) ) | (otherlv_8= 'status' otherlv_9= '/' ( (otherlv_10= RULE_ID ) ) ) ) otherlv_11= ')'
            {
            // InternalFacpl2.g:3177:2: ( (lv_functionId_0_0= rulefunID ) )
            // InternalFacpl2.g:3178:1: (lv_functionId_0_0= rulefunID )
            {
            // InternalFacpl2.g:3178:1: (lv_functionId_0_0= rulefunID )
            // InternalFacpl2.g:3179:3: lv_functionId_0_0= rulefunID
            {
             
            	        newCompositeNode(grammarAccess.getFunctionAccess().getFunctionIdFunIDEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_17);
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

            otherlv_1=(Token)match(input,26,FOLLOW_57); 

                	newLeafNode(otherlv_1, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_1());
                
            // InternalFacpl2.g:3199:1: ( ( (lv_arg1_2_0= ruleExpression ) ) | (otherlv_3= 'status' otherlv_4= '/' ( (otherlv_5= RULE_ID ) ) ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=RULE_STRING && LA42_0<=RULE_TIME)||LA42_0==26||LA42_0==63||LA42_0==65||(LA42_0>=92 && LA42_0<=102)) ) {
                alt42=1;
            }
            else if ( (LA42_0==64) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalFacpl2.g:3199:2: ( (lv_arg1_2_0= ruleExpression ) )
                    {
                    // InternalFacpl2.g:3199:2: ( (lv_arg1_2_0= ruleExpression ) )
                    // InternalFacpl2.g:3200:1: (lv_arg1_2_0= ruleExpression )
                    {
                    // InternalFacpl2.g:3200:1: (lv_arg1_2_0= ruleExpression )
                    // InternalFacpl2.g:3201:3: lv_arg1_2_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionAccess().getArg1ExpressionParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_31);
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


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:3218:6: (otherlv_3= 'status' otherlv_4= '/' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalFacpl2.g:3218:6: (otherlv_3= 'status' otherlv_4= '/' ( (otherlv_5= RULE_ID ) ) )
                    // InternalFacpl2.g:3218:8: otherlv_3= 'status' otherlv_4= '/' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,64,FOLLOW_42); 

                        	newLeafNode(otherlv_3, grammarAccess.getFunctionAccess().getStatusKeyword_2_1_0());
                        
                    otherlv_4=(Token)match(input,51,FOLLOW_12); 

                        	newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getSolidusKeyword_2_1_1());
                        
                    // InternalFacpl2.g:3226:1: ( (otherlv_5= RULE_ID ) )
                    // InternalFacpl2.g:3227:1: (otherlv_5= RULE_ID )
                    {
                    // InternalFacpl2.g:3227:1: (otherlv_5= RULE_ID )
                    // InternalFacpl2.g:3228:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFunctionRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_31); 

                    		newLeafNode(otherlv_5, grammarAccess.getFunctionAccess().getAtt1AttributeCrossReference_2_1_2_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,23,FOLLOW_57); 

                	newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getCommaKeyword_3());
                
            // InternalFacpl2.g:3243:1: ( ( (lv_arg2_7_0= ruleExpression ) ) | (otherlv_8= 'status' otherlv_9= '/' ( (otherlv_10= RULE_ID ) ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_STRING && LA43_0<=RULE_TIME)||LA43_0==26||LA43_0==63||LA43_0==65||(LA43_0>=92 && LA43_0<=102)) ) {
                alt43=1;
            }
            else if ( (LA43_0==64) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalFacpl2.g:3243:2: ( (lv_arg2_7_0= ruleExpression ) )
                    {
                    // InternalFacpl2.g:3243:2: ( (lv_arg2_7_0= ruleExpression ) )
                    // InternalFacpl2.g:3244:1: (lv_arg2_7_0= ruleExpression )
                    {
                    // InternalFacpl2.g:3244:1: (lv_arg2_7_0= ruleExpression )
                    // InternalFacpl2.g:3245:3: lv_arg2_7_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionAccess().getArg2ExpressionParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    lv_arg2_7_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"arg2",
                            		lv_arg2_7_0, 
                            		"it.unifi.xtext.facpl.Facpl2.Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:3262:6: (otherlv_8= 'status' otherlv_9= '/' ( (otherlv_10= RULE_ID ) ) )
                    {
                    // InternalFacpl2.g:3262:6: (otherlv_8= 'status' otherlv_9= '/' ( (otherlv_10= RULE_ID ) ) )
                    // InternalFacpl2.g:3262:8: otherlv_8= 'status' otherlv_9= '/' ( (otherlv_10= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,64,FOLLOW_42); 

                        	newLeafNode(otherlv_8, grammarAccess.getFunctionAccess().getStatusKeyword_4_1_0());
                        
                    otherlv_9=(Token)match(input,51,FOLLOW_12); 

                        	newLeafNode(otherlv_9, grammarAccess.getFunctionAccess().getSolidusKeyword_4_1_1());
                        
                    // InternalFacpl2.g:3270:1: ( (otherlv_10= RULE_ID ) )
                    // InternalFacpl2.g:3271:1: (otherlv_10= RULE_ID )
                    {
                    // InternalFacpl2.g:3271:1: (otherlv_10= RULE_ID )
                    // InternalFacpl2.g:3272:3: otherlv_10= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFunctionRule());
                    	        }
                            
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_30); 

                    		newLeafNode(otherlv_10, grammarAccess.getFunctionAccess().getAtt2AttributeCrossReference_4_1_2_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,27,FOLLOW_2); 

                	newLeafNode(otherlv_11, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5());
                

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
    // InternalFacpl2.g:3295:1: entryRuleDeclaredFunction returns [EObject current=null] : iv_ruleDeclaredFunction= ruleDeclaredFunction EOF ;
    public final EObject entryRuleDeclaredFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredFunction = null;


        try {
            // InternalFacpl2.g:3296:2: (iv_ruleDeclaredFunction= ruleDeclaredFunction EOF )
            // InternalFacpl2.g:3297:2: iv_ruleDeclaredFunction= ruleDeclaredFunction EOF
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
    // InternalFacpl2.g:3304:1: ruleDeclaredFunction returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' ) ;
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
            // InternalFacpl2.g:3307:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' ) )
            // InternalFacpl2.g:3308:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' )
            {
            // InternalFacpl2.g:3308:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' )
            // InternalFacpl2.g:3308:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')'
            {
            // InternalFacpl2.g:3308:2: ( (otherlv_0= RULE_ID ) )
            // InternalFacpl2.g:3309:1: (otherlv_0= RULE_ID )
            {
            // InternalFacpl2.g:3309:1: (otherlv_0= RULE_ID )
            // InternalFacpl2.g:3310:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDeclaredFunctionRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            		newLeafNode(otherlv_0, grammarAccess.getDeclaredFunctionAccess().getFunctionIdFunctionDeclarationCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_37); 

                	newLeafNode(otherlv_1, grammarAccess.getDeclaredFunctionAccess().getLeftParenthesisKeyword_1());
                
            // InternalFacpl2.g:3325:1: ( (lv_args_2_0= ruleExpression ) )
            // InternalFacpl2.g:3326:1: (lv_args_2_0= ruleExpression )
            {
            // InternalFacpl2.g:3326:1: (lv_args_2_0= ruleExpression )
            // InternalFacpl2.g:3327:3: lv_args_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getDeclaredFunctionAccess().getArgsExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_18);
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

            // InternalFacpl2.g:3343:2: (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==23) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalFacpl2.g:3343:4: otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_37); 

            	        	newLeafNode(otherlv_3, grammarAccess.getDeclaredFunctionAccess().getCommaKeyword_3_0());
            	        
            	    // InternalFacpl2.g:3347:1: ( (lv_args_4_0= ruleExpression ) )
            	    // InternalFacpl2.g:3348:1: (lv_args_4_0= ruleExpression )
            	    {
            	    // InternalFacpl2.g:3348:1: (lv_args_4_0= ruleExpression )
            	    // InternalFacpl2.g:3349:3: lv_args_4_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDeclaredFunctionAccess().getArgsExpressionParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_18);
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
            	    break loop44;
                }
            } while (true);

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

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


    // $ANTLR start "entryRuleLiterals"
    // InternalFacpl2.g:3377:1: entryRuleLiterals returns [EObject current=null] : iv_ruleLiterals= ruleLiterals EOF ;
    public final EObject entryRuleLiterals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiterals = null;


        try {
            // InternalFacpl2.g:3378:2: (iv_ruleLiterals= ruleLiterals EOF )
            // InternalFacpl2.g:3379:2: iv_ruleLiterals= ruleLiterals EOF
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
    // InternalFacpl2.g:3386:1: ruleLiterals returns [EObject current=null] : (this_IntLiteral_0= ruleIntLiteral | this_DoubleLiteral_1= ruleDoubleLiteral | this_BooleanLiteral_2= ruleBooleanLiteral | this_StringLiteral_3= ruleStringLiteral | this_DateLiteral_4= ruleDateLiteral | this_TimeLiteral_5= ruleTimeLiteral | this_AttributeName_6= ruleAttributeName | this_Set_7= ruleSet ) ;
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
            // InternalFacpl2.g:3389:28: ( (this_IntLiteral_0= ruleIntLiteral | this_DoubleLiteral_1= ruleDoubleLiteral | this_BooleanLiteral_2= ruleBooleanLiteral | this_StringLiteral_3= ruleStringLiteral | this_DateLiteral_4= ruleDateLiteral | this_TimeLiteral_5= ruleTimeLiteral | this_AttributeName_6= ruleAttributeName | this_Set_7= ruleSet ) )
            // InternalFacpl2.g:3390:1: (this_IntLiteral_0= ruleIntLiteral | this_DoubleLiteral_1= ruleDoubleLiteral | this_BooleanLiteral_2= ruleBooleanLiteral | this_StringLiteral_3= ruleStringLiteral | this_DateLiteral_4= ruleDateLiteral | this_TimeLiteral_5= ruleTimeLiteral | this_AttributeName_6= ruleAttributeName | this_Set_7= ruleSet )
            {
            // InternalFacpl2.g:3390:1: (this_IntLiteral_0= ruleIntLiteral | this_DoubleLiteral_1= ruleDoubleLiteral | this_BooleanLiteral_2= ruleBooleanLiteral | this_StringLiteral_3= ruleStringLiteral | this_DateLiteral_4= ruleDateLiteral | this_TimeLiteral_5= ruleTimeLiteral | this_AttributeName_6= ruleAttributeName | this_Set_7= ruleSet )
            int alt45=8;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt45=1;
                }
                break;
            case RULE_REAL:
                {
                alt45=2;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt45=3;
                }
                break;
            case RULE_STRING:
                {
                alt45=4;
                }
                break;
            case RULE_DATE:
                {
                alt45=5;
                }
                break;
            case RULE_TIME:
                {
                alt45=6;
                }
                break;
            case RULE_ID:
                {
                alt45=7;
                }
                break;
            case 65:
                {
                alt45=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalFacpl2.g:3391:5: this_IntLiteral_0= ruleIntLiteral
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
                    // InternalFacpl2.g:3401:5: this_DoubleLiteral_1= ruleDoubleLiteral
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
                    // InternalFacpl2.g:3411:5: this_BooleanLiteral_2= ruleBooleanLiteral
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
                    // InternalFacpl2.g:3421:5: this_StringLiteral_3= ruleStringLiteral
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
                    // InternalFacpl2.g:3431:5: this_DateLiteral_4= ruleDateLiteral
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
                    // InternalFacpl2.g:3441:5: this_TimeLiteral_5= ruleTimeLiteral
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
                    // InternalFacpl2.g:3451:5: this_AttributeName_6= ruleAttributeName
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
                    // InternalFacpl2.g:3461:5: this_Set_7= ruleSet
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
    // InternalFacpl2.g:3477:1: entryRuleSet returns [EObject current=null] : iv_ruleSet= ruleSet EOF ;
    public final EObject entryRuleSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSet = null;


        try {
            // InternalFacpl2.g:3478:2: (iv_ruleSet= ruleSet EOF )
            // InternalFacpl2.g:3479:2: iv_ruleSet= ruleSet EOF
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
    // InternalFacpl2.g:3486:1: ruleSet returns [EObject current=null] : (otherlv_0= 'set(' ( ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )* ) otherlv_4= ')' ) ;
    public final EObject ruleSet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_args_1_0 = null;

        EObject lv_args_3_0 = null;


         enterRule(); 
            
        try {
            // InternalFacpl2.g:3489:28: ( (otherlv_0= 'set(' ( ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )* ) otherlv_4= ')' ) )
            // InternalFacpl2.g:3490:1: (otherlv_0= 'set(' ( ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )* ) otherlv_4= ')' )
            {
            // InternalFacpl2.g:3490:1: (otherlv_0= 'set(' ( ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )* ) otherlv_4= ')' )
            // InternalFacpl2.g:3490:3: otherlv_0= 'set(' ( ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )* ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_37); 

                	newLeafNode(otherlv_0, grammarAccess.getSetAccess().getSetKeyword_0());
                
            // InternalFacpl2.g:3494:1: ( ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )* )
            // InternalFacpl2.g:3494:2: ( (lv_args_1_0= ruleLiterals ) ) (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )*
            {
            // InternalFacpl2.g:3494:2: ( (lv_args_1_0= ruleLiterals ) )
            // InternalFacpl2.g:3495:1: (lv_args_1_0= ruleLiterals )
            {
            // InternalFacpl2.g:3495:1: (lv_args_1_0= ruleLiterals )
            // InternalFacpl2.g:3496:3: lv_args_1_0= ruleLiterals
            {
             
            	        newCompositeNode(grammarAccess.getSetAccess().getArgsLiteralsParserRuleCall_1_0_0()); 
            	    
            pushFollow(FOLLOW_18);
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

            // InternalFacpl2.g:3512:2: (otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==23) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalFacpl2.g:3512:4: otherlv_2= ',' ( (lv_args_3_0= ruleLiterals ) )
            	    {
            	    otherlv_2=(Token)match(input,23,FOLLOW_37); 

            	        	newLeafNode(otherlv_2, grammarAccess.getSetAccess().getCommaKeyword_1_1_0());
            	        
            	    // InternalFacpl2.g:3516:1: ( (lv_args_3_0= ruleLiterals ) )
            	    // InternalFacpl2.g:3517:1: (lv_args_3_0= ruleLiterals )
            	    {
            	    // InternalFacpl2.g:3517:1: (lv_args_3_0= ruleLiterals )
            	    // InternalFacpl2.g:3518:3: lv_args_3_0= ruleLiterals
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSetAccess().getArgsLiteralsParserRuleCall_1_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_18);
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
            	    break loop46;
                }
            } while (true);


            }

            otherlv_4=(Token)match(input,27,FOLLOW_2); 

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
    // InternalFacpl2.g:3546:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalFacpl2.g:3547:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalFacpl2.g:3548:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalFacpl2.g:3555:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:3558:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalFacpl2.g:3559:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalFacpl2.g:3559:1: ( (lv_value_0_0= RULE_STRING ) )
            // InternalFacpl2.g:3560:1: (lv_value_0_0= RULE_STRING )
            {
            // InternalFacpl2.g:3560:1: (lv_value_0_0= RULE_STRING )
            // InternalFacpl2.g:3561:3: lv_value_0_0= RULE_STRING
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
    // InternalFacpl2.g:3585:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalFacpl2.g:3586:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalFacpl2.g:3587:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalFacpl2.g:3594:1: ruleBooleanLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:3597:28: ( ( (lv_value_0_0= RULE_BOOLEAN ) ) )
            // InternalFacpl2.g:3598:1: ( (lv_value_0_0= RULE_BOOLEAN ) )
            {
            // InternalFacpl2.g:3598:1: ( (lv_value_0_0= RULE_BOOLEAN ) )
            // InternalFacpl2.g:3599:1: (lv_value_0_0= RULE_BOOLEAN )
            {
            // InternalFacpl2.g:3599:1: (lv_value_0_0= RULE_BOOLEAN )
            // InternalFacpl2.g:3600:3: lv_value_0_0= RULE_BOOLEAN
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
    // InternalFacpl2.g:3624:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalFacpl2.g:3625:2: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalFacpl2.g:3626:2: iv_ruleIntLiteral= ruleIntLiteral EOF
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
    // InternalFacpl2.g:3633:1: ruleIntLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:3636:28: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalFacpl2.g:3637:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalFacpl2.g:3637:1: ( (lv_value_0_0= RULE_INT ) )
            // InternalFacpl2.g:3638:1: (lv_value_0_0= RULE_INT )
            {
            // InternalFacpl2.g:3638:1: (lv_value_0_0= RULE_INT )
            // InternalFacpl2.g:3639:3: lv_value_0_0= RULE_INT
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
    // InternalFacpl2.g:3663:1: entryRuleDoubleLiteral returns [EObject current=null] : iv_ruleDoubleLiteral= ruleDoubleLiteral EOF ;
    public final EObject entryRuleDoubleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteral = null;


        try {
            // InternalFacpl2.g:3664:2: (iv_ruleDoubleLiteral= ruleDoubleLiteral EOF )
            // InternalFacpl2.g:3665:2: iv_ruleDoubleLiteral= ruleDoubleLiteral EOF
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
    // InternalFacpl2.g:3672:1: ruleDoubleLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_REAL ) ) ;
    public final EObject ruleDoubleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:3675:28: ( ( (lv_value_0_0= RULE_REAL ) ) )
            // InternalFacpl2.g:3676:1: ( (lv_value_0_0= RULE_REAL ) )
            {
            // InternalFacpl2.g:3676:1: ( (lv_value_0_0= RULE_REAL ) )
            // InternalFacpl2.g:3677:1: (lv_value_0_0= RULE_REAL )
            {
            // InternalFacpl2.g:3677:1: (lv_value_0_0= RULE_REAL )
            // InternalFacpl2.g:3678:3: lv_value_0_0= RULE_REAL
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
    // InternalFacpl2.g:3702:1: entryRuleDateLiteral returns [EObject current=null] : iv_ruleDateLiteral= ruleDateLiteral EOF ;
    public final EObject entryRuleDateLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateLiteral = null;


        try {
            // InternalFacpl2.g:3703:2: (iv_ruleDateLiteral= ruleDateLiteral EOF )
            // InternalFacpl2.g:3704:2: iv_ruleDateLiteral= ruleDateLiteral EOF
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
    // InternalFacpl2.g:3711:1: ruleDateLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_DATE ) ) ;
    public final EObject ruleDateLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:3714:28: ( ( (lv_value_0_0= RULE_DATE ) ) )
            // InternalFacpl2.g:3715:1: ( (lv_value_0_0= RULE_DATE ) )
            {
            // InternalFacpl2.g:3715:1: ( (lv_value_0_0= RULE_DATE ) )
            // InternalFacpl2.g:3716:1: (lv_value_0_0= RULE_DATE )
            {
            // InternalFacpl2.g:3716:1: (lv_value_0_0= RULE_DATE )
            // InternalFacpl2.g:3717:3: lv_value_0_0= RULE_DATE
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
    // InternalFacpl2.g:3741:1: entryRuleTimeLiteral returns [EObject current=null] : iv_ruleTimeLiteral= ruleTimeLiteral EOF ;
    public final EObject entryRuleTimeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeLiteral = null;


        try {
            // InternalFacpl2.g:3742:2: (iv_ruleTimeLiteral= ruleTimeLiteral EOF )
            // InternalFacpl2.g:3743:2: iv_ruleTimeLiteral= ruleTimeLiteral EOF
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
    // InternalFacpl2.g:3750:1: ruleTimeLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_TIME ) ) ;
    public final EObject ruleTimeLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalFacpl2.g:3753:28: ( ( (lv_value_0_0= RULE_TIME ) ) )
            // InternalFacpl2.g:3754:1: ( (lv_value_0_0= RULE_TIME ) )
            {
            // InternalFacpl2.g:3754:1: ( (lv_value_0_0= RULE_TIME ) )
            // InternalFacpl2.g:3755:1: (lv_value_0_0= RULE_TIME )
            {
            // InternalFacpl2.g:3755:1: (lv_value_0_0= RULE_TIME )
            // InternalFacpl2.g:3756:3: lv_value_0_0= RULE_TIME
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
    // InternalFacpl2.g:3780:1: ruleTypeLiteral returns [Enumerator current=null] : ( (enumLiteral_0= 'Int' ) | (enumLiteral_1= 'Double' ) | (enumLiteral_2= 'Bool' ) | (enumLiteral_3= 'String' ) | (enumLiteral_4= 'DateTime' ) | (enumLiteral_5= 'Set<Int>' ) | (enumLiteral_6= 'Set<Double>' ) | (enumLiteral_7= 'Set<Bool>' ) | (enumLiteral_8= 'Set<String>' ) | (enumLiteral_9= 'Set<DateTime>' ) ) ;
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
            // InternalFacpl2.g:3782:28: ( ( (enumLiteral_0= 'Int' ) | (enumLiteral_1= 'Double' ) | (enumLiteral_2= 'Bool' ) | (enumLiteral_3= 'String' ) | (enumLiteral_4= 'DateTime' ) | (enumLiteral_5= 'Set<Int>' ) | (enumLiteral_6= 'Set<Double>' ) | (enumLiteral_7= 'Set<Bool>' ) | (enumLiteral_8= 'Set<String>' ) | (enumLiteral_9= 'Set<DateTime>' ) ) )
            // InternalFacpl2.g:3783:1: ( (enumLiteral_0= 'Int' ) | (enumLiteral_1= 'Double' ) | (enumLiteral_2= 'Bool' ) | (enumLiteral_3= 'String' ) | (enumLiteral_4= 'DateTime' ) | (enumLiteral_5= 'Set<Int>' ) | (enumLiteral_6= 'Set<Double>' ) | (enumLiteral_7= 'Set<Bool>' ) | (enumLiteral_8= 'Set<String>' ) | (enumLiteral_9= 'Set<DateTime>' ) )
            {
            // InternalFacpl2.g:3783:1: ( (enumLiteral_0= 'Int' ) | (enumLiteral_1= 'Double' ) | (enumLiteral_2= 'Bool' ) | (enumLiteral_3= 'String' ) | (enumLiteral_4= 'DateTime' ) | (enumLiteral_5= 'Set<Int>' ) | (enumLiteral_6= 'Set<Double>' ) | (enumLiteral_7= 'Set<Bool>' ) | (enumLiteral_8= 'Set<String>' ) | (enumLiteral_9= 'Set<DateTime>' ) )
            int alt47=10;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt47=1;
                }
                break;
            case 67:
                {
                alt47=2;
                }
                break;
            case 68:
                {
                alt47=3;
                }
                break;
            case 69:
                {
                alt47=4;
                }
                break;
            case 70:
                {
                alt47=5;
                }
                break;
            case 71:
                {
                alt47=6;
                }
                break;
            case 72:
                {
                alt47=7;
                }
                break;
            case 73:
                {
                alt47=8;
                }
                break;
            case 74:
                {
                alt47=9;
                }
                break;
            case 75:
                {
                alt47=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalFacpl2.g:3783:2: (enumLiteral_0= 'Int' )
                    {
                    // InternalFacpl2.g:3783:2: (enumLiteral_0= 'Int' )
                    // InternalFacpl2.g:3783:4: enumLiteral_0= 'Int'
                    {
                    enumLiteral_0=(Token)match(input,66,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getIntEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getTypeLiteralAccess().getIntEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:3789:6: (enumLiteral_1= 'Double' )
                    {
                    // InternalFacpl2.g:3789:6: (enumLiteral_1= 'Double' )
                    // InternalFacpl2.g:3789:8: enumLiteral_1= 'Double'
                    {
                    enumLiteral_1=(Token)match(input,67,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getDoubleEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getTypeLiteralAccess().getDoubleEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalFacpl2.g:3795:6: (enumLiteral_2= 'Bool' )
                    {
                    // InternalFacpl2.g:3795:6: (enumLiteral_2= 'Bool' )
                    // InternalFacpl2.g:3795:8: enumLiteral_2= 'Bool'
                    {
                    enumLiteral_2=(Token)match(input,68,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getBoolEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getTypeLiteralAccess().getBoolEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalFacpl2.g:3801:6: (enumLiteral_3= 'String' )
                    {
                    // InternalFacpl2.g:3801:6: (enumLiteral_3= 'String' )
                    // InternalFacpl2.g:3801:8: enumLiteral_3= 'String'
                    {
                    enumLiteral_3=(Token)match(input,69,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getStringEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getTypeLiteralAccess().getStringEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalFacpl2.g:3807:6: (enumLiteral_4= 'DateTime' )
                    {
                    // InternalFacpl2.g:3807:6: (enumLiteral_4= 'DateTime' )
                    // InternalFacpl2.g:3807:8: enumLiteral_4= 'DateTime'
                    {
                    enumLiteral_4=(Token)match(input,70,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getDateTimeEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getTypeLiteralAccess().getDateTimeEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // InternalFacpl2.g:3813:6: (enumLiteral_5= 'Set<Int>' )
                    {
                    // InternalFacpl2.g:3813:6: (enumLiteral_5= 'Set<Int>' )
                    // InternalFacpl2.g:3813:8: enumLiteral_5= 'Set<Int>'
                    {
                    enumLiteral_5=(Token)match(input,71,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getSetIntEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getTypeLiteralAccess().getSetIntEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // InternalFacpl2.g:3819:6: (enumLiteral_6= 'Set<Double>' )
                    {
                    // InternalFacpl2.g:3819:6: (enumLiteral_6= 'Set<Double>' )
                    // InternalFacpl2.g:3819:8: enumLiteral_6= 'Set<Double>'
                    {
                    enumLiteral_6=(Token)match(input,72,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getSetDoubleEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getTypeLiteralAccess().getSetDoubleEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // InternalFacpl2.g:3825:6: (enumLiteral_7= 'Set<Bool>' )
                    {
                    // InternalFacpl2.g:3825:6: (enumLiteral_7= 'Set<Bool>' )
                    // InternalFacpl2.g:3825:8: enumLiteral_7= 'Set<Bool>'
                    {
                    enumLiteral_7=(Token)match(input,73,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getSetBoolEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getTypeLiteralAccess().getSetBoolEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // InternalFacpl2.g:3831:6: (enumLiteral_8= 'Set<String>' )
                    {
                    // InternalFacpl2.g:3831:6: (enumLiteral_8= 'Set<String>' )
                    // InternalFacpl2.g:3831:8: enumLiteral_8= 'Set<String>'
                    {
                    enumLiteral_8=(Token)match(input,74,FOLLOW_2); 

                            current = grammarAccess.getTypeLiteralAccess().getSetStringEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getTypeLiteralAccess().getSetStringEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // InternalFacpl2.g:3837:6: (enumLiteral_9= 'Set<DateTime>' )
                    {
                    // InternalFacpl2.g:3837:6: (enumLiteral_9= 'Set<DateTime>' )
                    // InternalFacpl2.g:3837:8: enumLiteral_9= 'Set<DateTime>'
                    {
                    enumLiteral_9=(Token)match(input,75,FOLLOW_2); 

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
    // InternalFacpl2.g:3847:1: rulePEPAlg returns [Enumerator current=null] : ( (enumLiteral_0= 'base' ) | (enumLiteral_1= 'deny-biased' ) | (enumLiteral_2= 'permit-biased' ) ) ;
    public final Enumerator rulePEPAlg() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // InternalFacpl2.g:3849:28: ( ( (enumLiteral_0= 'base' ) | (enumLiteral_1= 'deny-biased' ) | (enumLiteral_2= 'permit-biased' ) ) )
            // InternalFacpl2.g:3850:1: ( (enumLiteral_0= 'base' ) | (enumLiteral_1= 'deny-biased' ) | (enumLiteral_2= 'permit-biased' ) )
            {
            // InternalFacpl2.g:3850:1: ( (enumLiteral_0= 'base' ) | (enumLiteral_1= 'deny-biased' ) | (enumLiteral_2= 'permit-biased' ) )
            int alt48=3;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt48=1;
                }
                break;
            case 77:
                {
                alt48=2;
                }
                break;
            case 78:
                {
                alt48=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalFacpl2.g:3850:2: (enumLiteral_0= 'base' )
                    {
                    // InternalFacpl2.g:3850:2: (enumLiteral_0= 'base' )
                    // InternalFacpl2.g:3850:4: enumLiteral_0= 'base'
                    {
                    enumLiteral_0=(Token)match(input,76,FOLLOW_2); 

                            current = grammarAccess.getPEPAlgAccess().getBASEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getPEPAlgAccess().getBASEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:3856:6: (enumLiteral_1= 'deny-biased' )
                    {
                    // InternalFacpl2.g:3856:6: (enumLiteral_1= 'deny-biased' )
                    // InternalFacpl2.g:3856:8: enumLiteral_1= 'deny-biased'
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_2); 

                            current = grammarAccess.getPEPAlgAccess().getDENYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getPEPAlgAccess().getDENYEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalFacpl2.g:3862:6: (enumLiteral_2= 'permit-biased' )
                    {
                    // InternalFacpl2.g:3862:6: (enumLiteral_2= 'permit-biased' )
                    // InternalFacpl2.g:3862:8: enumLiteral_2= 'permit-biased'
                    {
                    enumLiteral_2=(Token)match(input,78,FOLLOW_2); 

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
    // InternalFacpl2.g:3872:1: ruleAlgLiteral returns [Enumerator current=null] : ( (enumLiteral_0= 'only-one-applicable' ) | (enumLiteral_1= 'deny-overrides' ) | (enumLiteral_2= 'permit-overrides' ) | (enumLiteral_3= 'first-applicable' ) | (enumLiteral_4= 'deny-unless-permit' ) | (enumLiteral_5= 'permit-unless-deny' ) | (enumLiteral_6= 'weak-consensus' ) | (enumLiteral_7= 'strong-consensus' ) | (enumLiteral_8= 'custom-algorithm' ) ) ;
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
            // InternalFacpl2.g:3874:28: ( ( (enumLiteral_0= 'only-one-applicable' ) | (enumLiteral_1= 'deny-overrides' ) | (enumLiteral_2= 'permit-overrides' ) | (enumLiteral_3= 'first-applicable' ) | (enumLiteral_4= 'deny-unless-permit' ) | (enumLiteral_5= 'permit-unless-deny' ) | (enumLiteral_6= 'weak-consensus' ) | (enumLiteral_7= 'strong-consensus' ) | (enumLiteral_8= 'custom-algorithm' ) ) )
            // InternalFacpl2.g:3875:1: ( (enumLiteral_0= 'only-one-applicable' ) | (enumLiteral_1= 'deny-overrides' ) | (enumLiteral_2= 'permit-overrides' ) | (enumLiteral_3= 'first-applicable' ) | (enumLiteral_4= 'deny-unless-permit' ) | (enumLiteral_5= 'permit-unless-deny' ) | (enumLiteral_6= 'weak-consensus' ) | (enumLiteral_7= 'strong-consensus' ) | (enumLiteral_8= 'custom-algorithm' ) )
            {
            // InternalFacpl2.g:3875:1: ( (enumLiteral_0= 'only-one-applicable' ) | (enumLiteral_1= 'deny-overrides' ) | (enumLiteral_2= 'permit-overrides' ) | (enumLiteral_3= 'first-applicable' ) | (enumLiteral_4= 'deny-unless-permit' ) | (enumLiteral_5= 'permit-unless-deny' ) | (enumLiteral_6= 'weak-consensus' ) | (enumLiteral_7= 'strong-consensus' ) | (enumLiteral_8= 'custom-algorithm' ) )
            int alt49=9;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt49=1;
                }
                break;
            case 80:
                {
                alt49=2;
                }
                break;
            case 81:
                {
                alt49=3;
                }
                break;
            case 82:
                {
                alt49=4;
                }
                break;
            case 83:
                {
                alt49=5;
                }
                break;
            case 84:
                {
                alt49=6;
                }
                break;
            case 85:
                {
                alt49=7;
                }
                break;
            case 86:
                {
                alt49=8;
                }
                break;
            case 87:
                {
                alt49=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalFacpl2.g:3875:2: (enumLiteral_0= 'only-one-applicable' )
                    {
                    // InternalFacpl2.g:3875:2: (enumLiteral_0= 'only-one-applicable' )
                    // InternalFacpl2.g:3875:4: enumLiteral_0= 'only-one-applicable'
                    {
                    enumLiteral_0=(Token)match(input,79,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getONLY_ONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getAlgLiteralAccess().getONLY_ONEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:3881:6: (enumLiteral_1= 'deny-overrides' )
                    {
                    // InternalFacpl2.g:3881:6: (enumLiteral_1= 'deny-overrides' )
                    // InternalFacpl2.g:3881:8: enumLiteral_1= 'deny-overrides'
                    {
                    enumLiteral_1=(Token)match(input,80,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getDENY_OVEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getAlgLiteralAccess().getDENY_OVEREnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalFacpl2.g:3887:6: (enumLiteral_2= 'permit-overrides' )
                    {
                    // InternalFacpl2.g:3887:6: (enumLiteral_2= 'permit-overrides' )
                    // InternalFacpl2.g:3887:8: enumLiteral_2= 'permit-overrides'
                    {
                    enumLiteral_2=(Token)match(input,81,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getPERMIT_OVEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getAlgLiteralAccess().getPERMIT_OVEREnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalFacpl2.g:3893:6: (enumLiteral_3= 'first-applicable' )
                    {
                    // InternalFacpl2.g:3893:6: (enumLiteral_3= 'first-applicable' )
                    // InternalFacpl2.g:3893:8: enumLiteral_3= 'first-applicable'
                    {
                    enumLiteral_3=(Token)match(input,82,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getFIRSTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getAlgLiteralAccess().getFIRSTEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalFacpl2.g:3899:6: (enumLiteral_4= 'deny-unless-permit' )
                    {
                    // InternalFacpl2.g:3899:6: (enumLiteral_4= 'deny-unless-permit' )
                    // InternalFacpl2.g:3899:8: enumLiteral_4= 'deny-unless-permit'
                    {
                    enumLiteral_4=(Token)match(input,83,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getDENY_UNLESSEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getAlgLiteralAccess().getDENY_UNLESSEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // InternalFacpl2.g:3905:6: (enumLiteral_5= 'permit-unless-deny' )
                    {
                    // InternalFacpl2.g:3905:6: (enumLiteral_5= 'permit-unless-deny' )
                    // InternalFacpl2.g:3905:8: enumLiteral_5= 'permit-unless-deny'
                    {
                    enumLiteral_5=(Token)match(input,84,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getPERMIT_UNLESSEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getAlgLiteralAccess().getPERMIT_UNLESSEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // InternalFacpl2.g:3911:6: (enumLiteral_6= 'weak-consensus' )
                    {
                    // InternalFacpl2.g:3911:6: (enumLiteral_6= 'weak-consensus' )
                    // InternalFacpl2.g:3911:8: enumLiteral_6= 'weak-consensus'
                    {
                    enumLiteral_6=(Token)match(input,85,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getWEAK_CONSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getAlgLiteralAccess().getWEAK_CONSEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // InternalFacpl2.g:3917:6: (enumLiteral_7= 'strong-consensus' )
                    {
                    // InternalFacpl2.g:3917:6: (enumLiteral_7= 'strong-consensus' )
                    // InternalFacpl2.g:3917:8: enumLiteral_7= 'strong-consensus'
                    {
                    enumLiteral_7=(Token)match(input,86,FOLLOW_2); 

                            current = grammarAccess.getAlgLiteralAccess().getSTRONG_CONSEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getAlgLiteralAccess().getSTRONG_CONSEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // InternalFacpl2.g:3923:6: (enumLiteral_8= 'custom-algorithm' )
                    {
                    // InternalFacpl2.g:3923:6: (enumLiteral_8= 'custom-algorithm' )
                    // InternalFacpl2.g:3923:8: enumLiteral_8= 'custom-algorithm'
                    {
                    enumLiteral_8=(Token)match(input,87,FOLLOW_2); 

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
    // InternalFacpl2.g:3933:1: ruleFulfillmentStrategy returns [Enumerator current=null] : ( (enumLiteral_0= 'greedy' ) | (enumLiteral_1= 'all' ) ) ;
    public final Enumerator ruleFulfillmentStrategy() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalFacpl2.g:3935:28: ( ( (enumLiteral_0= 'greedy' ) | (enumLiteral_1= 'all' ) ) )
            // InternalFacpl2.g:3936:1: ( (enumLiteral_0= 'greedy' ) | (enumLiteral_1= 'all' ) )
            {
            // InternalFacpl2.g:3936:1: ( (enumLiteral_0= 'greedy' ) | (enumLiteral_1= 'all' ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==88) ) {
                alt50=1;
            }
            else if ( (LA50_0==89) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalFacpl2.g:3936:2: (enumLiteral_0= 'greedy' )
                    {
                    // InternalFacpl2.g:3936:2: (enumLiteral_0= 'greedy' )
                    // InternalFacpl2.g:3936:4: enumLiteral_0= 'greedy'
                    {
                    enumLiteral_0=(Token)match(input,88,FOLLOW_2); 

                            current = grammarAccess.getFulfillmentStrategyAccess().getGREEDYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getFulfillmentStrategyAccess().getGREEDYEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:3942:6: (enumLiteral_1= 'all' )
                    {
                    // InternalFacpl2.g:3942:6: (enumLiteral_1= 'all' )
                    // InternalFacpl2.g:3942:8: enumLiteral_1= 'all'
                    {
                    enumLiteral_1=(Token)match(input,89,FOLLOW_2); 

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
    // InternalFacpl2.g:3952:1: ruleEffect returns [Enumerator current=null] : ( (enumLiteral_0= 'permit' ) | (enumLiteral_1= 'deny' ) ) ;
    public final Enumerator ruleEffect() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // InternalFacpl2.g:3954:28: ( ( (enumLiteral_0= 'permit' ) | (enumLiteral_1= 'deny' ) ) )
            // InternalFacpl2.g:3955:1: ( (enumLiteral_0= 'permit' ) | (enumLiteral_1= 'deny' ) )
            {
            // InternalFacpl2.g:3955:1: ( (enumLiteral_0= 'permit' ) | (enumLiteral_1= 'deny' ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==90) ) {
                alt51=1;
            }
            else if ( (LA51_0==91) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalFacpl2.g:3955:2: (enumLiteral_0= 'permit' )
                    {
                    // InternalFacpl2.g:3955:2: (enumLiteral_0= 'permit' )
                    // InternalFacpl2.g:3955:4: enumLiteral_0= 'permit'
                    {
                    enumLiteral_0=(Token)match(input,90,FOLLOW_2); 

                            current = grammarAccess.getEffectAccess().getPERMITEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEffectAccess().getPERMITEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:3961:6: (enumLiteral_1= 'deny' )
                    {
                    // InternalFacpl2.g:3961:6: (enumLiteral_1= 'deny' )
                    // InternalFacpl2.g:3961:8: enumLiteral_1= 'deny'
                    {
                    enumLiteral_1=(Token)match(input,91,FOLLOW_2); 

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
    // InternalFacpl2.g:3971:1: rulefunID returns [Enumerator current=null] : ( (enumLiteral_0= 'equal' ) | (enumLiteral_1= 'not-equal' ) | (enumLiteral_2= 'less-than' ) | (enumLiteral_3= 'less-than-or-equal' ) | (enumLiteral_4= 'greater-than' ) | (enumLiteral_5= 'greater-than-or-equal' ) | (enumLiteral_6= 'in' ) | (enumLiteral_7= 'addition' ) | (enumLiteral_8= 'subtract' ) | (enumLiteral_9= 'divide' ) | (enumLiteral_10= 'multiply' ) ) ;
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
            // InternalFacpl2.g:3973:28: ( ( (enumLiteral_0= 'equal' ) | (enumLiteral_1= 'not-equal' ) | (enumLiteral_2= 'less-than' ) | (enumLiteral_3= 'less-than-or-equal' ) | (enumLiteral_4= 'greater-than' ) | (enumLiteral_5= 'greater-than-or-equal' ) | (enumLiteral_6= 'in' ) | (enumLiteral_7= 'addition' ) | (enumLiteral_8= 'subtract' ) | (enumLiteral_9= 'divide' ) | (enumLiteral_10= 'multiply' ) ) )
            // InternalFacpl2.g:3974:1: ( (enumLiteral_0= 'equal' ) | (enumLiteral_1= 'not-equal' ) | (enumLiteral_2= 'less-than' ) | (enumLiteral_3= 'less-than-or-equal' ) | (enumLiteral_4= 'greater-than' ) | (enumLiteral_5= 'greater-than-or-equal' ) | (enumLiteral_6= 'in' ) | (enumLiteral_7= 'addition' ) | (enumLiteral_8= 'subtract' ) | (enumLiteral_9= 'divide' ) | (enumLiteral_10= 'multiply' ) )
            {
            // InternalFacpl2.g:3974:1: ( (enumLiteral_0= 'equal' ) | (enumLiteral_1= 'not-equal' ) | (enumLiteral_2= 'less-than' ) | (enumLiteral_3= 'less-than-or-equal' ) | (enumLiteral_4= 'greater-than' ) | (enumLiteral_5= 'greater-than-or-equal' ) | (enumLiteral_6= 'in' ) | (enumLiteral_7= 'addition' ) | (enumLiteral_8= 'subtract' ) | (enumLiteral_9= 'divide' ) | (enumLiteral_10= 'multiply' ) )
            int alt52=11;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt52=1;
                }
                break;
            case 93:
                {
                alt52=2;
                }
                break;
            case 94:
                {
                alt52=3;
                }
                break;
            case 95:
                {
                alt52=4;
                }
                break;
            case 96:
                {
                alt52=5;
                }
                break;
            case 97:
                {
                alt52=6;
                }
                break;
            case 98:
                {
                alt52=7;
                }
                break;
            case 99:
                {
                alt52=8;
                }
                break;
            case 100:
                {
                alt52=9;
                }
                break;
            case 101:
                {
                alt52=10;
                }
                break;
            case 102:
                {
                alt52=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalFacpl2.g:3974:2: (enumLiteral_0= 'equal' )
                    {
                    // InternalFacpl2.g:3974:2: (enumLiteral_0= 'equal' )
                    // InternalFacpl2.g:3974:4: enumLiteral_0= 'equal'
                    {
                    enumLiteral_0=(Token)match(input,92,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getEQUALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getFunIDAccess().getEQUALEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalFacpl2.g:3980:6: (enumLiteral_1= 'not-equal' )
                    {
                    // InternalFacpl2.g:3980:6: (enumLiteral_1= 'not-equal' )
                    // InternalFacpl2.g:3980:8: enumLiteral_1= 'not-equal'
                    {
                    enumLiteral_1=(Token)match(input,93,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getN_EQUALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getFunIDAccess().getN_EQUALEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalFacpl2.g:3986:6: (enumLiteral_2= 'less-than' )
                    {
                    // InternalFacpl2.g:3986:6: (enumLiteral_2= 'less-than' )
                    // InternalFacpl2.g:3986:8: enumLiteral_2= 'less-than'
                    {
                    enumLiteral_2=(Token)match(input,94,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getLESSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getFunIDAccess().getLESSEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalFacpl2.g:3992:6: (enumLiteral_3= 'less-than-or-equal' )
                    {
                    // InternalFacpl2.g:3992:6: (enumLiteral_3= 'less-than-or-equal' )
                    // InternalFacpl2.g:3992:8: enumLiteral_3= 'less-than-or-equal'
                    {
                    enumLiteral_3=(Token)match(input,95,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getLESS_EQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getFunIDAccess().getLESS_EQEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // InternalFacpl2.g:3998:6: (enumLiteral_4= 'greater-than' )
                    {
                    // InternalFacpl2.g:3998:6: (enumLiteral_4= 'greater-than' )
                    // InternalFacpl2.g:3998:8: enumLiteral_4= 'greater-than'
                    {
                    enumLiteral_4=(Token)match(input,96,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getGREATEREnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getFunIDAccess().getGREATEREnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // InternalFacpl2.g:4004:6: (enumLiteral_5= 'greater-than-or-equal' )
                    {
                    // InternalFacpl2.g:4004:6: (enumLiteral_5= 'greater-than-or-equal' )
                    // InternalFacpl2.g:4004:8: enumLiteral_5= 'greater-than-or-equal'
                    {
                    enumLiteral_5=(Token)match(input,97,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getGREATER_EQEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getFunIDAccess().getGREATER_EQEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // InternalFacpl2.g:4010:6: (enumLiteral_6= 'in' )
                    {
                    // InternalFacpl2.g:4010:6: (enumLiteral_6= 'in' )
                    // InternalFacpl2.g:4010:8: enumLiteral_6= 'in'
                    {
                    enumLiteral_6=(Token)match(input,98,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getINEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getFunIDAccess().getINEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // InternalFacpl2.g:4016:6: (enumLiteral_7= 'addition' )
                    {
                    // InternalFacpl2.g:4016:6: (enumLiteral_7= 'addition' )
                    // InternalFacpl2.g:4016:8: enumLiteral_7= 'addition'
                    {
                    enumLiteral_7=(Token)match(input,99,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getADDEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getFunIDAccess().getADDEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // InternalFacpl2.g:4022:6: (enumLiteral_8= 'subtract' )
                    {
                    // InternalFacpl2.g:4022:6: (enumLiteral_8= 'subtract' )
                    // InternalFacpl2.g:4022:8: enumLiteral_8= 'subtract'
                    {
                    enumLiteral_8=(Token)match(input,100,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getSUBTRACTEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getFunIDAccess().getSUBTRACTEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // InternalFacpl2.g:4028:6: (enumLiteral_9= 'divide' )
                    {
                    // InternalFacpl2.g:4028:6: (enumLiteral_9= 'divide' )
                    // InternalFacpl2.g:4028:8: enumLiteral_9= 'divide'
                    {
                    enumLiteral_9=(Token)match(input,101,FOLLOW_2); 

                            current = grammarAccess.getFunIDAccess().getDIVIDEEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getFunIDAccess().getDIVIDEEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // InternalFacpl2.g:4034:6: (enumLiteral_10= 'multiply' )
                    {
                    // InternalFacpl2.g:4034:6: (enumLiteral_10= 'multiply' )
                    // InternalFacpl2.g:4034:8: enumLiteral_10= 'multiply'
                    {
                    enumLiteral_10=(Token)match(input,102,FOLLOW_2); 

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


    protected DFA16 dfa16 = new DFA16(this);
    static final String dfa_1s = "\36\uffff";
    static final String dfa_2s = "\1\47\4\32\5\uffff\4\5\4\27\4\7\10\uffff";
    static final String dfa_3s = "\1\57\4\32\5\uffff\4\5\4\27\4\10\10\uffff";
    static final String dfa_4s = "\5\uffff\1\11\1\12\1\13\1\14\1\15\14\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\10\1\7";
    static final String dfa_5s = "\36\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15",
            "",
            "",
            "",
            "",
            "",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26\1\27",
            "\1\30\1\31",
            "\1\32\1\33",
            "\1\35\1\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1090:1: ( ( ( (lv_name_0_0= 'add-status' ) ) otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( (lv_value_4_0= ruleIntLiteral ) ) otherlv_5= ')' ) | ( ( (lv_name_6_0= 'add-status' ) ) otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) otherlv_9= ',' ( (lv_value_10_0= ruleDoubleLiteral ) ) otherlv_11= ')' ) | ( ( (lv_name_12_0= 'sub-status' ) ) otherlv_13= '(' ( (otherlv_14= RULE_ID ) ) otherlv_15= ',' ( (lv_value_16_0= ruleIntLiteral ) ) otherlv_17= ')' ) | ( ( (lv_name_18_0= 'sub-status' ) ) otherlv_19= '(' ( (otherlv_20= RULE_ID ) ) otherlv_21= ',' ( (lv_value_22_0= ruleDoubleLiteral ) ) otherlv_23= ')' ) | ( ( (lv_name_24_0= 'div-status' ) ) otherlv_25= '(' ( (otherlv_26= RULE_ID ) ) otherlv_27= ',' ( (lv_value_28_0= ruleIntLiteral ) ) otherlv_29= ')' ) | ( ( (lv_name_30_0= 'div-status' ) ) otherlv_31= '(' ( (otherlv_32= RULE_ID ) ) otherlv_33= ',' ( (lv_value_34_0= ruleDoubleLiteral ) ) otherlv_35= ')' ) | ( ( (lv_name_36_0= 'mul-status' ) ) otherlv_37= '(' ( (otherlv_38= RULE_ID ) ) otherlv_39= ',' ( (lv_value_40_0= ruleIntLiteral ) ) otherlv_41= ')' ) | ( ( (lv_name_42_0= 'mul-status' ) ) otherlv_43= '(' ( (otherlv_44= RULE_ID ) ) otherlv_45= ',' ( (lv_value_46_0= ruleDoubleLiteral ) ) otherlv_47= ')' ) | ( ( (lv_name_48_0= 'sum-date' ) ) otherlv_49= '(' ( (otherlv_50= RULE_ID ) ) otherlv_51= ',' ( ( (lv_value_52_1= ruleDateLiteral | lv_value_52_2= ruleTimeLiteral ) ) ) otherlv_53= ')' ) | ( ( (lv_name_54_0= 'set-date' ) ) otherlv_55= '(' ( (otherlv_56= RULE_ID ) ) otherlv_57= ',' ( ( (lv_value_58_1= ruleDateLiteral | lv_value_58_2= ruleTimeLiteral ) ) ) otherlv_59= ')' ) | ( ( (lv_name_60_0= 'set-string' ) ) otherlv_61= '(' ( (otherlv_62= RULE_ID ) ) otherlv_63= ',' ( (lv_value_64_0= ruleStringLiteral ) ) otherlv_65= ')' ) | ( ( (lv_name_66_0= 'sum-string' ) ) otherlv_67= '(' ( (otherlv_68= RULE_ID ) ) otherlv_69= ',' ( (lv_value_70_0= ruleStringLiteral ) ) otherlv_71= ')' ) | ( ( (lv_name_72_0= 'flag-status' ) ) otherlv_73= '(' ( (otherlv_74= RULE_ID ) ) otherlv_75= ',' ( (lv_value_76_0= ruleBooleanLiteral ) ) otherlv_77= ')' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0104000002018002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000FFCL});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000007000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000FF8000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000104000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000007A00000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000FF8000000020L,0x0000007FF0000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x8000FF800C0007F0L,0x0000007FF0000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x8000FF800C8007F0L,0x0000007FF0000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x8000FF80040007F0L,0x0000007FF0000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000100800000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000080020000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000005000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0070000000080002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x1180000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x1180000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x1980000001000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000003000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0A00000008000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0800000008000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000088000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x8000FF80040007F0L,0x0000007FF0000003L});

}
