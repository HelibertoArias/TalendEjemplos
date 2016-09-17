package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TMarketoOutputWriteEndJava
{
  protected static String nl;
  public static synchronized TMarketoOutputWriteEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoOutputWriteEndJava result = new TMarketoOutputWriteEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tif(leadRecordList_";
  protected final String TEXT_2 = ".size()>0){" + NL + "\t\t\t\tcom.marketo.www.mktows.LeadRecord[] leadRecords_";
  protected final String TEXT_3 = " = leadRecordList_";
  protected final String TEXT_4 = ".toArray(new com.marketo.www.mktows.LeadRecord[leadRecordList_";
  protected final String TEXT_5 = ".size()]);" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tcom.marketo.www.mktows.ResultSyncMultipleLeads syncLeads_";
  protected final String TEXT_6 = " = client_";
  protected final String TEXT_7 = ".syncMultipleLeads(";
  protected final String TEXT_8 = ",leadRecords_";
  protected final String TEXT_9 = ");" + NL + "\t\t\t\t\tstatusList_";
  protected final String TEXT_10 = ".add(syncLeads_";
  protected final String TEXT_11 = ".getSyncStatusList());" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_12 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_13 = "); \t" + NL + "\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_14 = "){" + NL + "\t\t\t\t\tif(ex_";
  protected final String TEXT_15 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t    \t\t\tif(!client_";
  protected final String TEXT_16 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_17 = ")){" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_18 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_19 = ");\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t    \t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_21 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_22 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_23 = ".getMessage());" + NL + "\t\t\t        ";
  protected final String TEXT_24 = NL + "\t\t\t\t}" + NL + "\t\t\t\tleadRecordList_";
  protected final String TEXT_25 = ".clear();" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_26 = NL + "\t\t\tif(leadRecordList_";
  protected final String TEXT_27 = ".size()>0){" + NL + "\t\t\t\twhile(true){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\torg.talend.marketo.response.ResultSync syncLeads_";
  protected final String TEXT_28 = " = client_";
  protected final String TEXT_29 = ".syncMultipleLeads(";
  protected final String TEXT_30 = ",";
  protected final String TEXT_31 = ",leadRecordList_";
  protected final String TEXT_32 = ",false,null);" + NL + "\t\t\t\t\t\tif(client_";
  protected final String TEXT_33 = ".isAccessTokenExpired(syncLeads_";
  protected final String TEXT_34 = ".getErrors())){" + NL + "\t\t            \t\tclient_";
  protected final String TEXT_35 = ".refreshToken();" + NL + "\t\t            \t\tglobalMap.put(\"";
  protected final String TEXT_36 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_37 = ");" + NL + "\t\t            \t\tcontinue;" + NL + "\t\t            \t}" + NL + "\t\t\t\t\t\tif(syncLeads_";
  protected final String TEXT_38 = ".getErrors() == null){" + NL + "\t\t            \t\tstatusList_";
  protected final String TEXT_39 = ".add(syncLeads_";
  protected final String TEXT_40 = ".getResult());" + NL + "\t\t            \t}else{" + NL + "\t\t            \t\tthrow(new java.lang.Exception(syncLeads_";
  protected final String TEXT_41 = ".getErrors().toString()));" + NL + "\t\t            \t}" + NL + "\t\t\t\t\t }catch(java.lang.Exception ex_";
  protected final String TEXT_42 = "){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t            throw(ex_";
  protected final String TEXT_44 = ");" + NL + "\t\t\t\t        ";
  protected final String TEXT_45 = NL + "\t\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_46 = ".getMessage());" + NL + "\t\t\t\t        ";
  protected final String TEXT_47 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tleadRecordList_";
  protected final String TEXT_48 = ".clear();" + NL + "\t\t\t\t\tbreak;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_49 = " " + NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_50 = "_NB_CALL\",nb_call_";
  protected final String TEXT_51 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_52 = "_STATUS_LIST\",statusList_";
  protected final String TEXT_53 = ");" + NL;
  protected final String TEXT_54 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName().replace("_Out","");
	String operation = ElementParameterParser.getValue(node, "__OPERATION__");
	boolean deDupenabled = ("true").equals(ElementParameterParser.getValue(node,"__DE_DUPENABLED__"));
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
	boolean useSoapAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_SOAP_API__"));
	boolean useRestAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_REST_API__"));
	if(useSoapAPI){
		if("syncMultipleLeads".equals(operation)){
		
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(deDupenabled);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
			        } else {
			        
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
			        }
			        
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
		}
	}
	if(useRestAPI){
		String operationType = ElementParameterParser.getValue(node,"__OPERATION_TYPE__");
		String lookupField = ElementParameterParser.getValue(node,"__LOOKUP_FIELD__");
		if(deDupenabled){
			operationType = null;
			lookupField = null;
		}else{
			operationType = "\""+operationType+"\"";
			lookupField = "\""+lookupField+"\"";
		}
		if("syncMultipleLeads".equals(operation)){
		
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(operationType);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(lookupField);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
				        if (dieOnError) {
				        
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
				        } else {
				        
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
				        }
				        
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
		}
	}
	
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(TEXT_54);
    return stringBuffer.toString();
  }
}
