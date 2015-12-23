package it.unifi.xtext.facpl.generator.util;

public class TestTargetTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TargetTree a = new TargetTree(Connector.AND, 
				//new TargetTree(Connector.AND,new TargetTree("1"),new TargetTree("2")),
				new TargetTree(Connector.OR,new TargetTree("1a"),new TargetTree("2a"),
						new TargetTree(Connector.OR,
							new TargetTree(Connector.AND,new TargetTree("4a"),new TargetTree("4b"),
							new TargetTree(Connector.OR,
									new TargetTree(Connector.AND,
											new TargetTree("4aaa"),
											new TargetTree(Connector.OR,new TargetTree("1"),new TargetTree("2"))),
									new TargetTree("4ab"))),
							new TargetTree("5"))),
				new TargetTree("3"));
		
		a.checkTree();
		
		TargetTree b = new TargetTree("a");
		b.checkTree();

		TargetTree c = new TargetTree(Connector.AND,
				new TargetTree(Connector.OR,new TargetTree("1"),new TargetTree("2")));
		c.checkTree();
	}

}
