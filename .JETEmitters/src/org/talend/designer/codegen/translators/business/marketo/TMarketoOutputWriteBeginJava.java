package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMarketoOutputWriteBeginJava
{
  protected static String nl;
  public static synchronized TMarketoOutputWriteBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoOutputWriteBeginJava result = new TMarketoOutputWriteBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tint nb_call_";
  protected final String TEXT_2 = " = 0;" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_3 = "_NB_CALL\",0);" + NL + "\t";
  protected final String TEXT_4 = NL + "    ";
  protected final String TEXT_5 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_6 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = "; ";
  protected final String TEXT_11 = NL + "    " + NL + "" + NL + "\t";
  protected final String TEXT_12 = NL + "\t\torg.talend.marketo.Client client_";
  protected final String TEXT_13 = " = new org.talend.marketo.Client(";
  protected final String TEXT_14 = ",decryptedPassword_";
  protected final String TEXT_15 = ",";
  protected final String TEXT_16 = ");" + NL + "\t\tclient_";
  protected final String TEXT_17 = ".setTimeout(";
  protected final String TEXT_18 = ");" + NL + "\t\tList<com.marketo.www.mktows.SyncStatus[]> statusList_";
  protected final String TEXT_19 = " = new java.util.ArrayList<com.marketo.www.mktows.SyncStatus[]>();" + NL + "\t\t";
  protected final String TEXT_20 = NL + "\t\t\tjava.util.List<com.marketo.www.mktows.LeadRecord> leadRecordList_";
  protected final String TEXT_21 = " = new java.util.ArrayList<com.marketo.www.mktows.LeadRecord>(";
  protected final String TEXT_22 = " * 2);" + NL + "\t\t";
  protected final String TEXT_23 = NL + "\t\torg.talend.marketo.MarketoRestClient client_";
  protected final String TEXT_24 = " = new org.talend.marketo.MarketoRestClient(";
  protected final String TEXT_25 = ",decryptedPassword_";
  protected final String TEXT_26 = ",";
  protected final String TEXT_27 = ");" + NL + "\t\tclient_";
  protected final String TEXT_28 = ".setTimeOut(";
  protected final String TEXT_29 = ");" + NL + "\t\tclient_";
  protected final String TEXT_30 = ".refreshToken();" + NL + "\t\tList<List<org.talend.marketo.type.SyncStatus>> statusList_";
  protected final String TEXT_31 = " = new java.util.ArrayList<List<org.talend.marketo.type.SyncStatus>>();" + NL + "\t\t";
  protected final String TEXT_32 = NL + "\t\t\tjava.util.List<java.util.Map<String,Object>> leadRecordList_";
  protected final String TEXT_33 = " = new java.util.ArrayList<java.util.Map<String,Object>>(";
  protected final String TEXT_34 = " * 2);" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName().replace("_Out","");
	
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");

    String clientAccessID = ElementParameterParser.getValue(node, "__CLIENT_ACCESSID__");
    String operation = ElementParameterParser.getValue(node, "__OPERATION__");
	String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");
	String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
	
	boolean useSoapAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_SOAP_API__"));
	boolean useRestAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_REST_API__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
    String passwordFieldName = "__SECRET_KEY__";
    
    stringBuffer.append(TEXT_4);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_7);
    } else {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    
	if(useSoapAPI){
	
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(clientAccessID);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
		if(operation.equals("syncMultipleLeads")){
		
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_22);
    
		}
	
	}
	if(useRestAPI){
	
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(clientAccessID);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
		if(operation.equals("syncMultipleLeads")){
		
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_34);
    
		}
	}
	
    return stringBuffer.toString();
  }
}
