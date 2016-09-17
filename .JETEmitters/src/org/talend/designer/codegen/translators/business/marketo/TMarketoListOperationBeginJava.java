package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TMarketoListOperationBeginJava
{
  protected static String nl;
  public static synchronized TMarketoListOperationBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoListOperationBeginJava result = new TMarketoListOperationBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "int nb_call_";
  protected final String TEXT_2 = " = 0;" + NL + "globalMap.put(\"";
  protected final String TEXT_3 = "_NB_CALL\",0);  ";
  protected final String TEXT_4 = NL + "                ";
  protected final String TEXT_5 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_6 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = "; ";
  protected final String TEXT_11 = NL + "                ";
  protected final String TEXT_12 = NL + "\t\t\t\t\torg.talend.marketo.Client client_";
  protected final String TEXT_13 = " = new org.talend.marketo.Client(";
  protected final String TEXT_14 = ",decryptedPassword_";
  protected final String TEXT_15 = ",";
  protected final String TEXT_16 = ");" + NL + "\t\t\t\t\tclient_";
  protected final String TEXT_17 = ".setTimeout(";
  protected final String TEXT_18 = ");" + NL + "\t\t\t\t\tjava.util.List<com.marketo.www.mktows.LeadKey> leadKeyList_";
  protected final String TEXT_19 = " = new java.util.ArrayList<com.marketo.www.mktows.LeadKey>();" + NL + "\t\t\t\t\tcom.marketo.www.mktows.ResultListOperation resultListOperation_";
  protected final String TEXT_20 = " = null;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\tboolean firstList_";
  protected final String TEXT_22 = " = true;" + NL + "\t\t\t\t\t\tString listTypeFlag_";
  protected final String TEXT_23 = "=\"\";" + NL + "\t\t\t\t\t\tString listValueFlag_";
  protected final String TEXT_24 = "=\"\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\tboolean whetherReject_";
  protected final String TEXT_26 = " = false;" + NL + "\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\torg.talend.marketo.MarketoRestClient client_";
  protected final String TEXT_28 = " = new org.talend.marketo.MarketoRestClient(";
  protected final String TEXT_29 = ",decryptedPassword_";
  protected final String TEXT_30 = ",";
  protected final String TEXT_31 = ");" + NL + "\t\t\t\t\tclient_";
  protected final String TEXT_32 = ".setTimeOut(";
  protected final String TEXT_33 = ");" + NL + "\t\t\t\t\tclient_";
  protected final String TEXT_34 = ".refreshToken();" + NL + "\t\t\t\t\tjava.util.List<Integer> leadKeyList_";
  protected final String TEXT_35 = " = new java.util.ArrayList<Integer>();" + NL + "\t\t\t\t\torg.talend.marketo.response.ResultSync resultListOperation_";
  protected final String TEXT_36 = " = null;" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\t\tboolean firstList_";
  protected final String TEXT_38 = " = true;" + NL + "\t\t\t\t\t\tInteger listIdFlag_";
  protected final String TEXT_39 = "= null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\tboolean whetherReject_";
  protected final String TEXT_41 = " = false;" + NL + "\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    
   	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");

    String clientAccessID = ElementParameterParser.getValue(node, "__CLIENT_ACCESSID__");
    String operation = ElementParameterParser.getValue(node, "__OPERATION__");
    boolean mutipleOperation = ("true").equals(ElementParameterParser.getValue(node,"__MUTIPLE_OPERATION__"));
	boolean isMutiple = false;
	if(mutipleOperation&&!operation.equals("ISMEMBEROFLIST")){
		isMutiple = true;
	}
	String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
    List<IMetadataTable> metadatas = node.getMetadataList();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    
    if (metadata!=null) {//2
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	
    	for (IConnection conn : conns) {//3
    	
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
    			boolean useSoapAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_SOAP_API__"));
				boolean useRestAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_REST_API__"));
    			
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
					if(isMutiple){
					
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
     
					}
					
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
     
				}
				if(useRestAPI){
				
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(clientAccessID);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
					if(isMutiple){
					
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
     
					}
					
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
     
				}
			}	
		}
	}	
}

    return stringBuffer.toString();
  }
}
