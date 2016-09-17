package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TMarketoGenArrayMainJava
{
  protected static String nl;
  public static synchronized TMarketoGenArrayMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoGenArrayMainJava result = new TMarketoGenArrayMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " != null && !tmpBatch_";
  protected final String TEXT_5 = ".contains(String.valueOf(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = "))){" + NL + "\t\t\t\t\t\t\ttmpBatch_";
  protected final String TEXT_8 = ".add(String.valueOf(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = "));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_11 = "\t";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName().replace("_Out","");
	String keyColumn = ElementParameterParser.getValue(node, "__LEAD_KEYVALUES__");
	String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");
	
	String rowName= "";
	if ((node.getIncomingConnections()!=null)&&(node.getIncomingConnections().size()>0)) {
		rowName = node.getIncomingConnections().get(0).getName();
		List<IMetadataTable> metadatas = NodeUtil.getIncomingMetadataTable(node,IConnectionCategory.DATA);
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			IMetadataTable metadata = metadatas.get(0);
			if (metadata!=null) {
				for (IMetadataColumn column : metadata.getListColumns()) { 
					if(column.getLabel().equals(keyColumn)){
					
    stringBuffer.append(TEXT_2);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_10);
    
						break;
					}
				}
			}
		}
	}
	
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
