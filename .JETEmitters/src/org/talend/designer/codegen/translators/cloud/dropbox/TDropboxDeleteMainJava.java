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

public class TDropboxDeleteMainJava
{
  protected static String nl;
  public static synchronized TDropboxDeleteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDropboxDeleteMainJava result = new TDropboxDeleteMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tcom.dropbox.core.DbxRequestConfig ";
  protected final String TEXT_3 = "_config = new com.dropbox.core.DbxRequestConfig(";
  protected final String TEXT_4 = ", ";
  protected final String TEXT_5 = NL + "\t\t\t,new com.dropbox.core.http.StandardHttpRequestor(new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = "))));" + NL + "\t\tcom.dropbox.core.DbxClient ";
  protected final String TEXT_8 = "_client = new com.dropbox.core.DbxClient(";
  protected final String TEXT_9 = "_config, ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\tcom.dropbox.core.DbxRequestConfig ";
  protected final String TEXT_12 = "_config = new com.dropbox.core.DbxRequestConfig(";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ");" + NL + "\t\tcom.dropbox.core.DbxClient ";
  protected final String TEXT_15 = "_client = new com.dropbox.core.DbxClient(";
  protected final String TEXT_16 = "_config, ";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\tcom.dropbox.core.DbxClient ";
  protected final String TEXT_19 = "_client = (com.dropbox.core.DbxClient)globalMap.get(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t";
  protected final String TEXT_22 = "_client.delete(";
  protected final String TEXT_23 = ");";

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
		String path = ElementParameterParser.getValue(node, "__PATH__");

    
if(!"true".equals(useExistingConn)){
	String clientIdentifier = "\""+cid+"\"";
	String localeName = "\""+java.util.Locale.getDefault().toString()+"\"";
	String useProxy = ElementParameterParser.getValue(node,"__USE_PROXY__");
	if("true".equals(useProxy)){
		String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
		String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(clientIdentifier);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(localeName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_10);
    
	}else{

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(clientIdentifier);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(localeName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_17);
    
	}
}else{

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(connectionKey);
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_23);
    return stringBuffer.toString();
  }
}
