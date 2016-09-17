package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMarketoGenArrayBeginJava
{
  protected static String nl;
  public static synchronized TMarketoGenArrayBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoGenArrayBeginJava result = new TMarketoGenArrayBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "java.util.Arrays array";
  protected final String TEXT_3 = ";" + NL + "int nb_fields_";
  protected final String TEXT_4 = " = 0;" + NL + "" + NL + "java.util.List<String> tmpBatch_";
  protected final String TEXT_5 = " = new java.util.ArrayList<String>();" + NL + "java.util.List<String[]> leadKeyValues_";
  protected final String TEXT_6 = " = new java.util.ArrayList<String[]>();";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName().replace("_Out","");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
