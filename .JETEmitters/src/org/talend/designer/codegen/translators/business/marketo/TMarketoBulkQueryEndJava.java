package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TMarketoBulkQueryEndJava
{
  protected static String nl;
  public static synchronized TMarketoBulkQueryEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoBulkQueryEndJava result = new TMarketoBulkQueryEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_2 = "\t" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t    \t\t\t\t\tif (leads_";
  protected final String TEXT_4 = ".getRemainingCount() != 0) {" + NL + "\t\t\t                            streamPosition_";
  protected final String TEXT_5 = " = leads_";
  protected final String TEXT_6 = ".getNewStreamPosition();" + NL + "\t\t\t                        } else {" + NL + "\t\t\t                            break;" + NL + "\t\t\t                        }" + NL + "\t\t\t                 \t";
  protected final String TEXT_7 = NL + "\t\t\t                 \t\tbreak;" + NL + "\t\t\t                 \t";
  protected final String TEXT_8 = NL + "\t\t                    }\t" + NL + "\t                    }" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_9 = "\t" + NL + "\t\t\t\t\t}\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t            \t\t\t}" + NL + "\t\t                        if (activities_";
  protected final String TEXT_11 = ".getRemainingCount() != 0) {" + NL + "\t\t                            streamPosition_";
  protected final String TEXT_12 = " = activities_";
  protected final String TEXT_13 = ".getNewStartPosition();" + NL + "\t\t                        } else {" + NL + "\t\t                            break;" + NL + "\t\t                        }" + NL + "\t                    \t}else{" + NL + "\t                    \t\tbreak;" + NL + "\t                    \t}" + NL + "\t                  \t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t                        if (changes_";
  protected final String TEXT_15 = ".getRemainingCount() != 0) {" + NL + "\t\t                            streamPosition_";
  protected final String TEXT_16 = " = changes_";
  protected final String TEXT_17 = ".getNewStartPosition();" + NL + "\t\t                        } else {" + NL + "\t\t                            break;" + NL + "\t\t                        }" + NL + "\t                        }" + NL + "\t                    }\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_18 = "\t\t" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = "\t" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t    \t\t\t\t\tif (leadRecords_";
  protected final String TEXT_20 = ".getNextPageToken() != null) {" + NL + "\t\t                            nextPageToken_";
  protected final String TEXT_21 = " = leadRecords_";
  protected final String TEXT_22 = ".getNextPageToken();" + NL + "\t\t                        } else {" + NL + "\t\t                            break;" + NL + "\t\t                        }" + NL + "\t\t                    }else{" + NL + "\t                    \t\tbreak;" + NL + "\t                    \t}" + NL + "\t                    }" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_23 = "\t" + NL + "\t\t\t\t\t}\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t            \t\t\t}" + NL + "\t\t\t                        if (activityRecords_";
  protected final String TEXT_25 = ".getNextPageToken() != null) {" + NL + "\t\t\t                            nextPageToken_";
  protected final String TEXT_26 = " =activityRecords_";
  protected final String TEXT_27 = ".getNextPageToken();" + NL + "\t\t\t                        } else {" + NL + "\t\t\t                            break;" + NL + "\t\t\t                        }" + NL + "\t\t                    \t}else{" + NL + "\t\t                    \t\tbreak;" + NL + "\t\t                    \t}" + NL + "\t\t                  \t}" + NL + "\t\t            \t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t                        if (changeRecords_";
  protected final String TEXT_29 = ".getNextPageToken() != null) {" + NL + "\t\t                            nextPageToken_";
  protected final String TEXT_30 = " = changeRecords_";
  protected final String TEXT_31 = ".getNextPageToken();" + NL + "\t\t                        } else {" + NL + "\t\t                            break;" + NL + "\t\t                        }" + NL + "\t                        }else{" + NL + "\t                    \t\tbreak;" + NL + "\t                    \t}" + NL + "\t                    }\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_32 = "\t" + NL + "globalMap.put(\"";
  protected final String TEXT_33 = "_NB_CALL\",nb_call_";
  protected final String TEXT_34 = ");     ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName().replace("_In","");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) { //1
	IMetadataTable metadata = metadatas.get(0);
	if (metadata != null) { //2
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();			
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
		if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){ //3
			IConnection outgoingConn = outgoingConns.get(0);
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { //4
				String operation = ElementParameterParser.getValue(node, "__OPERATION__");
				String leadSelector = ElementParameterParser.getValue(node, "__LEAD_SELECTOR__");
				String listParam = ElementParameterParser.getValue(node, "__LIST_PARAM__");
				boolean useSoapAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_SOAP_API__"));
				boolean useRestAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_REST_API__"));
				
				if(useSoapAPI){//5
					if("getLead".equals(operation)){
					
    stringBuffer.append(TEXT_1);
    			
					}else if("getMutipleLeads".equals(operation)){
					
    stringBuffer.append(TEXT_2);
    
								if(!"LeadKeySelector".equals(leadSelector)){
								
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			                 	}else{
			                 	
    stringBuffer.append(TEXT_7);
    
			                 	}
			                 	
    stringBuffer.append(TEXT_8);
    
						if("LeadKeySelector".equals(leadSelector)){
						
    stringBuffer.append(TEXT_9);
    
						}
					}else if("getLeadActivity".equals(operation)){
					
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
					}else if("getLeadChanges".equals(operation)){
					
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
					}
				}else if(useRestAPI){//5
					if("getLead".equals(operation)){
					
    stringBuffer.append(TEXT_18);
    			
					}else if("getMutipleLeads".equals(operation)){
					
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
						if("LeadKeySelector".equals(leadSelector)){
						
    stringBuffer.append(TEXT_23);
    
						}
					}else if("getLeadActivity".equals(operation)){
					
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
					}else if("getLeadChanges".equals(operation)){
					
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
					}
				}//5
			}//4
		}//3
	}//2
}//1	

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}
