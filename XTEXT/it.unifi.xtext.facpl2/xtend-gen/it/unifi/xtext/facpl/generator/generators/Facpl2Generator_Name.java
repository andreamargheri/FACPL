package it.unifi.xtext.facpl.generator.generators;

import it.unifi.xtext.facpl.facpl2.funID;
import it.unifi.xtext.facpl.validation.FacplType;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class Facpl2Generator_Name {
  public static String getFunName(final funID str) {
    if (str != null) {
      switch (str) {
        case EQUAL:
          return "comparison.Equal";
        case NEQUAL:
          return "comparison.NotEqual";
        case GREATER:
          return "comparison.GreaterThan";
        case GREATER_EQ:
          return "comparison.GreaterThanOrEqual";
        case LESS:
          return "comparison.LessThan";
        case LESS_EQ:
          return "comparison.LessThanOrEqual";
        case IN:
          return "comparison.In";
        case ADD:
          return "arithmetic.Add";
        case SUBTRACT:
          return "arithmetic.Subtract";
        case MULTIPLY:
          return "arithmetic.Multiply";
        case DIVIDE:
          return "arithmetic.Divide";
        default:
          break;
      }
    }
    return null;
  }
  
  public static String getJavaType(final FacplType t) {
    try {
      if (t != null) {
        switch (t) {
          case SET_BOOLEAN:
            return "Set";
          case SET_DATETIME:
            return "Set";
          case SET_DOUBLE:
            return "Set";
          case SET_INT:
            return "Set";
          case SET_NAME:
            return "Set";
          case SET_STRING:
            return "Set";
          case BOOLEAN:
            return "Boolean";
          case DATETIME:
            return "FacplDate";
          case DOUBLE:
            return "Double";
          case INT:
            return "Integer";
          case STRING:
            return "String";
          case NAME:
            return "AttributeName";
          default:
            throw new Exception("Unsupported Typed for Declared Functions");
        }
      } else {
        throw new Exception("Unsupported Typed for Declared Functions");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
