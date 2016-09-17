package org.talend.designer.codegen.translators.business.sap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TSAPCommitMainJava
{
  protected static String nl;
  public static synchronized TSAPCommitMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPCommitMainJava result = new TSAPCommitMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t" + NL + "\tcom.sap.mw.jco.JCO.Client client_";
  protected final String TEXT_3 = " = (com.sap.mw.jco.JCO.Client)globalMap.get(\"";
  protected final String TEXT_4 = "\");\t" + NL + "\t" + NL + "\tif(client_";
  protected final String TEXT_5 = " != null)" + NL + "\t{" + NL + "\t\tcom.sap.mw.jco.IRepository repository_";
  protected final String TEXT_6 = " = com.sap.mw.jco.JCO.createRepository(\"REPOSITORY\", client_";
  protected final String TEXT_7 = ");" + NL + "\t" + NL + "\t\tcom.sap.mw.jco.IFunctionTemplate functionTemplate_";
  protected final String TEXT_8 = " = repository_";
  protected final String TEXT_9 = ".getFunctionTemplate(\"BAPI_TRANSACTION_COMMIT\");" + NL + "\t" + NL + "\t    com.sap.mw.jco.JCO.Function function_";
  protected final String TEXT_10 = " = functionTemplate_";
  protected final String TEXT_11 = ".getFunction();" + NL + "\t    " + NL + "\t\ttry{" + NL + "\t\t\tclient_";
  protected final String TEXT_12 = ".execute(function_";
  protected final String TEXT_13 = ");" + NL + "\t    }catch (java.lang.Exception e_";
  protected final String TEXT_14 = ") {" + NL + "\t\t\tcom.sap.mw.jco.JCO.releaseClient(client_";
  protected final String TEXT_15 = ");" + NL + "\t\t    throw new RuntimeException(e_";
  protected final String TEXT_16 = ".getMessage());" + NL + "\t\t}\t" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_17 = NL + "    \tcom.sap.mw.jco.JCO.releaseClient(client_";
  protected final String TEXT_18 = ");" + NL + "\t\t";
  protected final String TEXT_19 = "\t" + NL + "\t}" + NL + "\t";
  protected final String TEXT_20 = NL + "\tcom.sap.conn.jco.JCoDestination dest_";
  protected final String TEXT_21 = " = (com.sap.conn.jco.JCoDestination)globalMap.get(\"";
  protected final String TEXT_22 = "\");";
  protected final String TEXT_23 = NL + "\t\t\tif(dest_";
  protected final String TEXT_24 = " == null){" + NL + "\t\t\t\tdest_";
  protected final String TEXT_25 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(";
  protected final String TEXT_26 = ");" + NL + "\t\t\t}";
  protected final String TEXT_27 = NL + "\tif(dest_";
  protected final String TEXT_28 = " != null)" + NL + "\t{" + NL + "\t\tcom.sap.conn.jco.JCoRepository repository_";
  protected final String TEXT_29 = " = dest_";
  protected final String TEXT_30 = ".getRepository();" + NL + "\t\t" + NL + "\t\tcom.sap.conn.jco.JCoFunctionTemplate functionTemplate_";
  protected final String TEXT_31 = " = repository_";
  protected final String TEXT_32 = ".getFunctionTemplate(\"BAPI_TRANSACTION_COMMIT\");" + NL + "\t\t" + NL + "\t\tcom.sap.conn.jco.JCoFunction function_";
  protected final String TEXT_33 = " = functionTemplate_";
  protected final String TEXT_34 = ".getFunction();" + NL + "\t\t" + NL + "\t\ttry{" + NL + "\t\t\tfunction_";
  protected final String TEXT_35 = ".execute(dest_";
  protected final String TEXT_36 = ");" + NL + "\t\t}catch (java.lang.Exception e_";
  protected final String TEXT_37 = ") {" + NL + "\t\t\tcom.sap.conn.jco.JCoContext.end(dest_";
  protected final String TEXT_38 = ");" + NL + "\t\t    throw new RuntimeException(e_";
  protected final String TEXT_39 = ".getMessage());" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_40 = NL + "\t\tcom.sap.conn.jco.JCoContext.end(dest_";
  protected final String TEXT_41 = ");" + NL + "\t\t";
  protected final String TEXT_42 = NL + "\t}";
  protected final String TEXT_43 = NL + "\torg.talend.sap.ISAPConnection connection_";
  protected final String TEXT_44 = " = (org.talend.sap.ISAPConnection)globalMap.get(\"";
  protected final String TEXT_45 = "\");";
  protected final String TEXT_46 = NL + "\t\t\tif(connection_";
  protected final String TEXT_47 = " == null){" + NL + "\t\t\t\tconnection_";
  protected final String TEXT_48 = " = ((org.talend.sap.impl.SAPConnectionFactory)(org.talend.sap.impl.SAPConnectionFactory.getInstance())).createConnection(";
  protected final String TEXT_49 = ");" + NL + "\t\t\t}";
  protected final String TEXT_50 = NL + "\tif(connection_";
  protected final String TEXT_51 = "!=null && connection_";
  protected final String TEXT_52 = ".isAlive()) {" + NL + "\t\torg.talend.sap.ISAPTransaction transaction_";
  protected final String TEXT_53 = " = connection_";
  protected final String TEXT_54 = ".getTransaction();" + NL + "\t\tif(transaction_";
  protected final String TEXT_55 = "!=null && transaction_";
  protected final String TEXT_56 = ".isAlive()) {" + NL + "\t\t\ttry {" + NL + "\t     \t\ttransaction_";
  protected final String TEXT_57 = ".commit();" + NL + "\t    \t} catch (org.talend.sap.exception.SAPException e_";
  protected final String TEXT_58 = ") {" + NL + "\t    \t\tconnection_";
  protected final String TEXT_59 = ".close();" + NL + "\t    \t\tthrow new RuntimeException(e_";
  protected final String TEXT_60 = ".getMessage());" + NL + "\t\t    }" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_61 = NL + "\t\tconnection_";
  protected final String TEXT_62 = ".close();" + NL + "\t\t";
  protected final String TEXT_63 = NL + "\t\tconnection_";
  protected final String TEXT_64 = ".beginTransaction();" + NL + "\t\t";
  protected final String TEXT_65 = NL + "\t}";
  protected final String TEXT_66 = NL;
  protected final String TEXT_67 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();

    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

    boolean close = ("true").equals(ElementParameterParser.getValue(node,"__CLOSE__"));

    String conn = "conn_" + connection;
    
    String VERSION_SAP2 = "sapjco.jar";
    String VERSION_SAP3 = "sapjco3.jar";
    
    String version = VERSION_SAP2;
    List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
    for(INode targetNode : nodes){
    	if (targetNode.getUniqueName().equals(connection)) {
	      version = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
	    }
    }

    if(VERSION_SAP2.equals(version)){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    if(close){
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    }else if(VERSION_SAP3.equals(version)){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_22);
    	
	INode connectionNode = null; 
	for (INode processNode : node.getProcess().getGeneratingNodes()) { 
		if(connection.equals(processNode.getUniqueName())) { 
			connectionNode = processNode; 
			break; 
		} 
	} 
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__"));
	if(specify_alias){
		String alias = ElementParameterParser.getValue(connectionNode, "__SAP_DATASOURCE_ALIAS__");
		if(null != alias && !("".equals(alias))){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_26);
    
		}
	}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    if(close){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    } else {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_45);
    
	INode connectionNode = null; 
	for (INode processNode : node.getProcess().getGeneratingNodes()) { 
		if(connection.equals(processNode.getUniqueName())) { 
			connectionNode = processNode; 
			break; 
		} 
	} 
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__"));
	if(specify_alias){
		String alias = ElementParameterParser.getValue(connectionNode, "__SAP_DATASOURCE_ALIAS__");
		if(null != alias && !("".equals(alias))){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_49);
    
		}
	}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    if(close){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    } else {//begin a new transaction for next commit or rollback
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
    stringBuffer.append(TEXT_67);
    return stringBuffer.toString();
  }
}
