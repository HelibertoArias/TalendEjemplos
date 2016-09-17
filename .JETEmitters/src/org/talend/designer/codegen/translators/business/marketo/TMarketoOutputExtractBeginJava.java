package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TMarketoOutputExtractBeginJava
{
  protected static String nl;
  public static synchronized TMarketoOutputExtractBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoOutputExtractBeginJava result = new TMarketoOutputExtractBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t\t\tList<com.marketo.www.mktows.SyncStatus[]> extractStatusList_";
  protected final String TEXT_2 = " = (List<com.marketo.www.mktows.SyncStatus[]>)globalMap.get(\"";
  protected final String TEXT_3 = "_STATUS_LIST\");" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tif(extractStatusList_";
  protected final String TEXT_4 = "!=null && extractStatusList_";
  protected final String TEXT_5 = ".size() >0){" + NL + "\t\t\t\t\t\t\tfor(com.marketo.www.mktows.SyncStatus[] statusArray_";
  protected final String TEXT_6 = " : extractStatusList_";
  protected final String TEXT_7 = "){" + NL + "\t\t\t\t\t\t\t\tfor(com.marketo.www.mktows.SyncStatus status_";
  protected final String TEXT_8 = " : statusArray_";
  protected final String TEXT_9 = "){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_10 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_11 = ".Id = status_";
  protected final String TEXT_12 = ".getLeadId();\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_13 = ".Status = status_";
  protected final String TEXT_14 = ".getStatus().getValue();" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_15 = ".ERROR_MSG = status_";
  protected final String TEXT_16 = ".getError();\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\tList<List<org.talend.marketo.type.SyncStatus>> extractStatusList_";
  protected final String TEXT_18 = " = (List<List<org.talend.marketo.type.SyncStatus>>)globalMap.get(\"";
  protected final String TEXT_19 = "_STATUS_LIST\");" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tif(extractStatusList_";
  protected final String TEXT_20 = "!=null && extractStatusList_";
  protected final String TEXT_21 = ".size() >0){" + NL + "\t\t\t\t\t\t\tfor(List<org.talend.marketo.type.SyncStatus> statusArray_";
  protected final String TEXT_22 = " : extractStatusList_";
  protected final String TEXT_23 = "){" + NL + "\t\t\t\t\t\t\t\tfor(org.talend.marketo.type.SyncStatus status_";
  protected final String TEXT_24 = " : statusArray_";
  protected final String TEXT_25 = "){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_26 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_27 = ".id = status_";
  protected final String TEXT_28 = ".getId();\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_29 = ".Status = status_";
  protected final String TEXT_30 = ".getStatus();" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_31 = ".ERROR_MSG = String.valueOf(status_";
  protected final String TEXT_32 = ".getReasons());\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName().replace("_In","");
	
	List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {//1
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {//2
	    	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	    	for (IConnection conn : conns) {//3
	    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
	    			boolean useSoapAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_SOAP_API__"));
					boolean useRestAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_REST_API__"));
					if(useSoapAPI){
					
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
									for(IConnection outgoingConn : outgoingConns) {
									
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
									}
					}
					if(useRestAPI){
					
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
									for(IConnection outgoingConn : outgoingConns) {
									
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
									}
					}
				}//4
			}//3
		}//2
	}//1
	
    return stringBuffer.toString();
  }
}
