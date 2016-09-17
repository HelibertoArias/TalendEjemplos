package org.talend.designer.codegen.translators.business.netsuite;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TNetsuiteOutputBeginJava
{
  protected static String nl;
  public static synchronized TNetsuiteOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNetsuiteOutputBeginJava result = new TNetsuiteOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "       " + NL;
  protected final String TEXT_3 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_4 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = "; ";
  protected final String TEXT_9 = NL + NL + "int nb_line_";
  protected final String TEXT_10 = " = 0;" + NL + "" + NL + "org.talend.netsuite.NetsuiteManagement_CXF nsMgr_";
  protected final String TEXT_11 = " = new org.talend.netsuite.NetsuiteManagement_CXF(";
  protected final String TEXT_12 = ", decryptedPassword_";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = " + \"\", ";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();    	
	
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
	String username = ElementParameterParser.getValue(node, "__USER__");
	String passwordFieldName = "__PASS__";
	String role = ElementParameterParser.getValue(node, "__ROLE__");
	String account = ElementParameterParser.getValue(node, "__ACCOUNT__");

    stringBuffer.append(TEXT_2);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_5);
    } else {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(role);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(account);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
