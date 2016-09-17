package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.List;

public class TMarketoGenArrayEndJava
{
  protected static String nl;
  public static synchronized TMarketoGenArrayEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoGenArrayEndJava result = new TMarketoGenArrayEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\tif(tmpBatch_";
  protected final String TEXT_3 = ".size() > 0){" + NL + "\t\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\t\tint arrayCount_";
  protected final String TEXT_5 = "=0;" + NL + "\t\t\t\t\twhile(true){" + NL + "\t\t\t\t\t\tif(tmpBatch_";
  protected final String TEXT_6 = ".size() > ";
  protected final String TEXT_7 = "*(arrayCount_";
  protected final String TEXT_8 = "+1)){" + NL + "\t\t\t\t\t\t\tleadKeyValues_";
  protected final String TEXT_9 = ".add(tmpBatch_";
  protected final String TEXT_10 = ".subList(";
  protected final String TEXT_11 = "*arrayCount_";
  protected final String TEXT_12 = ",";
  protected final String TEXT_13 = "*(arrayCount_";
  protected final String TEXT_14 = "+1)).toArray(new String[";
  protected final String TEXT_15 = "]));" + NL + "\t\t\t\t\t\t\tarrayCount_";
  protected final String TEXT_16 = "++;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tleadKeyValues_";
  protected final String TEXT_17 = ".add(tmpBatch_";
  protected final String TEXT_18 = ".subList(";
  protected final String TEXT_19 = "*arrayCount_";
  protected final String TEXT_20 = ",tmpBatch_";
  protected final String TEXT_21 = ".size()).toArray(new String[tmpBatch_";
  protected final String TEXT_22 = ".size()-";
  protected final String TEXT_23 = "*arrayCount_";
  protected final String TEXT_24 = "]));" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\tleadKeyValues_";
  protected final String TEXT_26 = ".add(tmpBatch_";
  protected final String TEXT_27 = ".toArray(new String[tmpBatch_";
  protected final String TEXT_28 = ".size()]));" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\ttmpBatch_";
  protected final String TEXT_30 = ".clear();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_31 = "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName().replace("_Out","");
	
	String segmentSizeStr = ElementParameterParser.getValue(node, "__LEADERKEYS_SEGMENT_SIZE__");
	int segmentSize = -1;
	if(segmentSizeStr!=null && !"".equals(segmentSizeStr) && !"\"\"".equals(segmentSizeStr)){
		segmentSize = Integer.parseInt(segmentSizeStr);
	}
	String rowName= "";
	if ((node.getIncomingConnections()!=null)&&(node.getIncomingConnections().size()>0)) {
		rowName = node.getIncomingConnections().get(0).getName();
	} else {
		rowName="defaultRow";
	}
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
				if(segmentSize > 0){
				
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(segmentSize);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(segmentSize);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(segmentSize);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(segmentSize);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(segmentSize);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(segmentSize);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
				}else{
				
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
				}
				
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    
		}
	}
	
    stringBuffer.append(TEXT_31);
    return stringBuffer.toString();
  }
}
