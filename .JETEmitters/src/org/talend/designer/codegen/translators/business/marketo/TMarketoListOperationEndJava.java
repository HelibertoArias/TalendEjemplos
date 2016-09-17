package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TMarketoListOperationEndJava
{
  protected static String nl;
  public static synchronized TMarketoListOperationEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoListOperationEndJava result = new TMarketoListOperationEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\t\tif(!leadKeyList_";
  protected final String TEXT_2 = ".isEmpty() && !\"\".equals(listTypeFlag_";
  protected final String TEXT_3 = ") && !\"\".equals(listValueFlag_";
  protected final String TEXT_4 = ")){" + NL + "\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\tclient_";
  protected final String TEXT_5 = ".listOperation(\"";
  protected final String TEXT_6 = "\",listTypeFlag_";
  protected final String TEXT_7 = ",listValueFlag_";
  protected final String TEXT_8 = ",leadKeyList_";
  protected final String TEXT_9 = ".toArray(new com.marketo.www.mktows.LeadKey[leadKeyList_";
  protected final String TEXT_10 = ".size()]),";
  protected final String TEXT_11 = ");" + NL + "\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_12 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_13 = ");\t" + NL + "\t\t\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_14 = "){" + NL + "\t\t\t\t\t\t\t\tif(ex_";
  protected final String TEXT_15 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t\t\t\t    \t\t\tif(!client_";
  protected final String TEXT_16 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_17 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_18 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_19 = ");\t\t" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t    \t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\t\t            throw(ex_";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\t\t\t        ";
  protected final String TEXT_22 = NL + "\t\t\t\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_23 = ".getMessage());" + NL + "\t\t\t\t\t\t        ";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tleadKeyList_";
  protected final String TEXT_25 = ".clear();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\t\tif(!leadKeyList_";
  protected final String TEXT_27 = ".isEmpty()){" + NL + "\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\tclient_";
  protected final String TEXT_28 = ".listOperation(\"";
  protected final String TEXT_29 = "\",listIdFlag_";
  protected final String TEXT_30 = ",leadKeyList_";
  protected final String TEXT_31 = ");" + NL + "\t\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_32 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_33 = ");\t\t" + NL + "\t\t\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_34 = "){" + NL + "\t\t\t\t\t\t\t\t/**" + NL + "\t\t\t\t\t\t\t\t\tfixed exception" + NL + "\t\t\t\t\t\t\t\t*/ " + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\t            throw(ex_";
  protected final String TEXT_36 = ");" + NL + "\t\t\t\t\t\t        ";
  protected final String TEXT_37 = NL + "\t\t\t\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_38 = ".getMessage());" + NL + "\t\t\t\t\t\t        ";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tleadKeyList_";
  protected final String TEXT_40 = ".clear();" + NL + "\t\t\t\t\t\t\tlistIdFlag_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = ".ListId;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_44 = "_NB_CALL\",nb_call_";
  protected final String TEXT_45 = ");     ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

String operation = ElementParameterParser.getValue(node, "__OPERATION__");
boolean mutipleOperation = ("true").equals(ElementParameterParser.getValue(node,"__MUTIPLE_OPERATION__"));
boolean isMutiple = false;
if(mutipleOperation&&!operation.equals("ISMEMBEROFLIST")){
	isMutiple = true;
}
boolean strict = ("true").equals(ElementParameterParser.getValue(node,"__STRICT__"));

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2

    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
    			boolean useSoapAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_SOAP_API__"));
				boolean useRestAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_REST_API__"));
    			if(isMutiple){
    				if(useSoapAPI){
					
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(operation);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(strict);
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
    
						        if (strict) {
						        
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
					if(useRestAPI){
					
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(operation);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
						        if (strict) {
						        
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
						        } else {
						        
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
						        }
						        
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_42);
    
					}
				}
			}	
		}
	}	
}

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    return stringBuffer.toString();
  }
}
