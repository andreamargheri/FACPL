/**
 * 
 */
package it.unifi.facpl.lib.util;

/**
 * @author Andrea Margheri
 *
 */
public class FacplLiteralTypes {

	/**
	 * Check if the passed argument is a valued managed by the librari
	 * 
	 * @param obj
	 * @return
	 */
	public static Boolean isFacplValue(Object obj) {

		if (obj instanceof Integer)
			return true;
		else if (obj instanceof String)
			return true;
		else if (obj instanceof Boolean)
			return true;
		else if (obj instanceof Double)
			return true;
		else if (obj instanceof Set)
			return true;
		else if (obj instanceof FacplDate)
			return true;
		else
			return false;
	}
}
