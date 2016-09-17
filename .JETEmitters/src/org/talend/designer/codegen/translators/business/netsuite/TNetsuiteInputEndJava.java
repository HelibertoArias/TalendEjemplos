package org.talend.designer.codegen.translators.business.netsuite;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TNetsuiteInputEndJava
{
  protected static String nl;
  public static synchronized TNetsuiteInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNetsuiteInputEndJava result = new TNetsuiteInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t// We check if we have some more record in the NS feed. Since paging is 1000 max items per page." + NL + "\t\t\t\t\t\tcontinue_";
  protected final String TEXT_3 = " = nsMgr_";
  protected final String TEXT_4 = ".hasMore();" + NL + "\t\t\t\t\t\tif (continue_";
  protected final String TEXT_5 = ") {" + NL + "\t\t\t\t\t\t\trecords_";
  protected final String TEXT_6 = " = nsMgr_";
  protected final String TEXT_7 = ".getMoreRecords();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tcontinue_";
  protected final String TEXT_8 = " = false;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch (Exception e) {" + NL + "\t\t\t\tthrow(e);" + NL + "\t\t\t}" + NL;
  protected final String TEXT_9 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_10 = "_NB_LINE\", nb_line_";
  protected final String TEXT_11 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if (metadatas != null) {
	IMetadataTable metadata = metadatas.get(0);
    
	if (metadata != null) {
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
        
		if (metadata.getListColumns().size() > 0 && outgoingConns != null){
        
			if(outgoingConns.get(0).getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
			}
		}
	}
}

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
