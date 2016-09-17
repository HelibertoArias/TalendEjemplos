package org.talend.designer.codegen.translators.cloud.dropbox;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TDropboxGetBeginJava
{
  protected static String nl;
  public static synchronized TDropboxGetBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDropboxGetBeginJava result = new TDropboxGetBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\tcom.dropbox.core.DbxRequestConfig ";
  protected final String TEXT_4 = "_config = new com.dropbox.core.DbxRequestConfig(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = NL + "\t\t\t,new com.dropbox.core.http.StandardHttpRequestor(new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = "))));" + NL + "\t\tcom.dropbox.core.DbxClient ";
  protected final String TEXT_9 = "_client = new com.dropbox.core.DbxClient(";
  protected final String TEXT_10 = "_config, ";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\tcom.dropbox.core.DbxRequestConfig ";
  protected final String TEXT_13 = "_config = new com.dropbox.core.DbxRequestConfig(";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ");" + NL + "\tcom.dropbox.core.DbxClient ";
  protected final String TEXT_16 = "_client = new com.dropbox.core.DbxClient(";
  protected final String TEXT_17 = "_config, ";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\tcom.dropbox.core.DbxClient ";
  protected final String TEXT_20 = "_client = (com.dropbox.core.DbxClient)globalMap.get(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\tcom.dropbox.core.DbxEntry.WithChildren ";
  protected final String TEXT_23 = "_entries = ";
  protected final String TEXT_24 = "_client.getMetadataWithChildren(";
  protected final String TEXT_25 = ");" + NL + "\tif (";
  protected final String TEXT_26 = "_entries == null || ";
  protected final String TEXT_27 = "_entries.entry == null || !";
  protected final String TEXT_28 = "_entries.entry.isFile()) {" + NL + "\t\tthrow new Exception(";
  protected final String TEXT_29 = " + \" is not a valid file path on Dropbox\");" + NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_30 = NL + "\t\tjava.io.File ";
  protected final String TEXT_31 = "_outputFile = new java.io.File(";
  protected final String TEXT_32 = ");" + NL + "\t\tif(!";
  protected final String TEXT_33 = "_outputFile.getParentFile().exists()){" + NL + "\t\t\t";
  protected final String TEXT_34 = "_outputFile.getParentFile().mkdirs();" + NL + "\t\t}" + NL + "\t\tjava.io.FileOutputStream ";
  protected final String TEXT_35 = "_outputStream = null;" + NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_36 = "_outputStream = new java.io.FileOutputStream(";
  protected final String TEXT_37 = "_outputFile);" + NL + "\t\t\tcom.dropbox.core.DbxEntry.File downloadedFile = ";
  protected final String TEXT_38 = "_client.getFile(";
  protected final String TEXT_39 = "_entries.entry.path," + NL + "\t\t            null, ";
  protected final String TEXT_40 = "_outputStream);" + NL + "\t\t} finally {" + NL + "\t\t\tif(";
  protected final String TEXT_41 = "_outputStream != null){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = "_outputStream.close();" + NL + "\t\t\t\t}catch(Exception e){" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t\t\t";
  protected final String TEXT_44 = ".content = new java.io.FileInputStream(";
  protected final String TEXT_45 = "_outputFile);" + NL + "\t\t\t";
  protected final String TEXT_46 = ".fileName = ";
  protected final String TEXT_47 = "_entries.entry.name;" + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t";
  protected final String TEXT_49 = NL + "\t\tcom.dropbox.core.DbxClient.Downloader ";
  protected final String TEXT_50 = "_downloader = ";
  protected final String TEXT_51 = "_client.startGetFile(";
  protected final String TEXT_52 = "_entries.entry.path, null);" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\t\tif (";
  protected final String TEXT_54 = "_downloader != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_55 = ".content = ";
  protected final String TEXT_56 = "_downloader.body;" + NL + "\t\t\t\t";
  protected final String TEXT_57 = ".fileName = ";
  protected final String TEXT_58 = "_entries.entry.name;" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_59 = NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		
		String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		String accessToken = ElementParameterParser.getValue(node,"__ACCESS_TOKEN__");
	    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	    String connectionKey = "\"conn_" + connection+"\"";
		String dropboxPath = ElementParameterParser.getValue(node, "__PATH__");
		String outputFile = ElementParameterParser.getValue(node, "__OUTPUT__");
		String store2Local = ElementParameterParser.getValue(node, "__STORE_TO_LOCAL__");
		
		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			metadata = metadatas.get(0);    
	    }
		
		List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
		
        String dataOutputConnection = null;	
	    for(IConnection conn : outputConnections) {
	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	dataOutputConnection = conn.getName();
	        	break;
	        } // if(conn) end
	    } // for(conns) end

    stringBuffer.append(TEXT_2);
    
if(!"true".equals(useExistingConn)){
	String clientIdentifier = "\""+cid+"\"";
	String localeName = "\""+java.util.Locale.getDefault().toString()+"\"";
	
	String useProxy = ElementParameterParser.getValue(node,"__USE_PROXY__");
	if("true".equals(useProxy)){
		String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
		String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(clientIdentifier);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(localeName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_11);
    
	}else{

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(clientIdentifier);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(localeName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_18);
    
	}
}else{

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(connectionKey);
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dropboxPath);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dropboxPath);
    stringBuffer.append(TEXT_29);
    if("true".equals(store2Local)){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(outputFile);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
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
    if(dataOutputConnection != null){
    stringBuffer.append(TEXT_43);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    }else{
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    if(dataOutputConnection != null){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    }
    return stringBuffer.toString();
  }
}
