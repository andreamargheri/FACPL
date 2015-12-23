package it.unifi.xtext.facpl.generator;


import java.util.LinkedList;
import java.util.List;

import org.eclipse.xtext.resource.XtextResourceSet;
 
import it.unifi.xtext.facpl.facpl2.AttributeReq;
import it.unifi.xtext.facpl.facpl2.Request;
import it.unifi.xtext.facpl.generator.util.Connector;
import it.unifi.xtext.facpl.generator.util.TargetTree;

public class xtendUtil {

	public static List<String> getCategories(Request request){
		LinkedList<String> categories = new LinkedList<String>();
		for (AttributeReq attr : request.getAttributes()) {
			String category = attr.getName().getCategory();
			if (!categories.contains(category)){
				categories.add(category);
			}
		}
		
		return categories;
	}
	
	public static String parseNameCat(String category){
		char[] c = category.toCharArray();
		for (int i = 0; i < c.length; i++){
			if (c[i] == '.'){
				c[i] = '_';
			}
		}
		return String.valueOf(c);
	}
	
	public static Class<XtextResourceSet> getClassXtext (){
		return XtextResourceSet.class;
	}
	
	public static TargetTree refactorTargetTree(TargetTree tree){
		//si riorganizza l'albero per adeguarsi alla struttura di anyof, allof, match
		//check if tree start with OR
		if (tree.getRoot().equals(Connector.OR)){
			TargetTree tr = new TargetTree(Connector.AND,tree);
			tr.checkTree();
			return tr;
		}else{
			tree.checkTree();
			return tree;
		}
	}
}
