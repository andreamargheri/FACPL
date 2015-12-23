package it.unifi.xtext.facpl.generator.util;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class TargetTree {

	private LinkedList<TargetTree> child;
	private Object root;

	public TargetTree(Connector conn, TargetTree... nodes) {
		child = new LinkedList<TargetTree>();
		root = conn;
		for (TargetTree nodeTargetTree : nodes) {
			child.add(nodeTargetTree);
		}
	}

	private TargetTree(Connector conn, LinkedList<TargetTree> nodes, TargetTree el) {
		child = new LinkedList<TargetTree>();
		root = conn;
		for (TargetTree nodeTargetTree : nodes) {
			child.add(nodeTargetTree);
		}
		child.add(el);
	}

	@Override
	public TargetTree clone() {
		TargetTree tclone = new TargetTree(root.toString());
		tclone.child = (LinkedList<TargetTree>) child.clone();
		return tclone;

	}

	public TargetTree(String node, TargetTree... nodes) {
		root = node;
		child = new LinkedList<TargetTree>();
		for (TargetTree nodeTargetTree : nodes) {
			child.add(nodeTargetTree);
		}
	}

	public Object getRoot() {
		return root;
	}

	public void setRoot(Object newroot) {
		root = newroot;
	}

	public LinkedList<TargetTree> getChild() {
		return child;
	}

	public String print() {
		StringBuffer str = new StringBuffer();
		str.append(root.toString() + "->" + "(");
		for (TargetTree el : child) {
			str.append(el.print());
		}
		str.append(")");
		return str.toString();
	}

	// METODI PER RIORGANIZZARE E CONTROLLARE I TARGET
	public void checkTree() {
		// System.out.println(this.print());
		checkEqualConnector();
		// System.out.println(this.print());
		// check #level of tree
		// System.out.println("Level: ");
		// System.out.println(this.nLevel());
		try {
			int i = 0;
			while (this.nLevel() > 4) {
				if (i > 100) {
					throw new Exception("Error in target generation");
				}
				i++;
				// reorganize tree
				// System.out.println("No ok per XML generation");
				distributingTree(1, this);
				// System.out.println(this.print());
				// factorize equal connector
				checkEqualConnector();
				// System.out.println(this.print());
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error in target translation.");
		}
	}

	private Integer nLevel() {
		int level = 1;
		if (root instanceof Connector) {
			for (TargetTree el : child) {
				int nLev = 1 + el.nLevel();
				if (level < nLev)
					level = nLev;
			}
		} else {
			// no child
			return 1;
		}
		return level;
	}

	private void distributingTree(int level, TargetTree dad) throws Exception {
		// find && -> || on 4th level and distributing area
		if (level < 2) {
			for (TargetTree el : this.child) {
				el.distributingTree(level + 1, this);
			}
		} else if (level == 2) {
			Boolean flag = true;
			while (flag) {
				flag = false;
				for (TargetTree el : this.child) { // OR level. check level
													// under for incompatible
													// formula
					Boolean change = el.distributingSubTree(this);
					if (!change) {
						flag = true;
						// change in OR child
						break;
					}
				}
			}
		} else {
			throw new Exception("illegal target tree");
		}
	}

	/**
	 * 
	 * @param dad
	 * @return false = if tree is changed true = if tree is not changed
	 */
	private Boolean distributingSubTree(TargetTree dad) {
		// find && -> ||
		if (root.equals(Connector.AND)) {
			TargetTree fix = null;
			for (TargetTree el : this.child) {
				if (el.getRoot().equals(Connector.OR)) {
					fix = el;
					break;
				}
			}
			if (fix != null) {
				// dad = OR node
				// this = AND node
				// fix = node to distributed
				LinkedList<TargetTree> copyAnd = new LinkedList<TargetTree>();
				for (TargetTree el : this.child) {
					if (!el.equals(fix)) {
						copyAnd.add(el); // And node's children less fix
					}
				}
				for (TargetTree el : fix.getChild()) { // Fix children
					// one for each child of fix node
					// System.out.println("copia figli:"+copyAnd.toString());
					// System.out.println("figlio in pi�:"+el.print());
					TargetTree r = new TargetTree(Connector.AND, copyAnd, el);
					// System.out.println("add child "+ r.print());
					dad.addChild(r);
				}
				// remove old AND node. Now OR children is distributed over AND
				dad.removeChild(this);
				return false;
			} else {
				// no other case
				return true;
			}
		}
		return true;
	}

	public void addChild(TargetTree targetTree) {
		this.child.add(targetTree);
	}

	public void removeChild(TargetTree targetTree) {
		this.child.remove(targetTree);
	}

	private void checkEqualConnector() {
		Boolean flag = false;
		while (!flag) {
			if (this.child.size() == 0) {
				break;
			}
			for (TargetTree el : this.child) {
				// ha figli quindi root = connctor
				if (el.getRoot() instanceof Connector) {
					if (el.getRoot().equals(this.root)) {
						// equal connector -> factorize child in root
						child.addAll(el.getChild());
						child.remove(el);
						flag = false;
						break;
					} else {
						// call on child
						el.checkEqualConnector();
						flag = true;
					}
				}
				if (!(el.getRoot() instanceof Connector)) {
					flag = true;
				}
			}
		}
	}
}
