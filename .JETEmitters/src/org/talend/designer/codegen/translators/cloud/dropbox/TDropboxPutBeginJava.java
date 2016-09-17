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

public class TDropboxPutBeginJava
{
  protected static String nl;
  public static synchronized TDropboxPutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDropboxPutBeginJava result = new TDropboxPutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\t\tcom.dropbox.core.DbxRequestConfig ";
  protected final String TEXT_4 = "_config = new com.dropbox.core.DbxRequestConfig(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = NL + "\t\t\t\t,new com.dropbox.core.http.StandardHttpRequestor(new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = "))));" + NL + "\t\t\tcom.dropbox.core.DbxClient ";
  protected final String TEXT_9 = "_client = new com.dropbox.core.DbxClient(";
  protected final String TEXT_10 = "_config, ";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\t\t\tcom.dropbox.core.DbxRequestConfig ";
  protected final String TEXT_13 = "_config = new com.dropbox.core.DbxRequestConfig(";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ");" + NL + "\t\t\tcom.dropbox.core.DbxClient ";
  protected final String TEXT_16 = "_client = new com.dropbox.core.DbxClient(";
  protected final String TEXT_17 = "_config, ";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + NL + "\t\tcom.dropbox.core.DbxClient ";
  protected final String TEXT_20 = "_client = (com.dropbox.core.DbxClient)globalMap.get(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = NL + "\t\tcom.dropbox.core.DbxClient.Uploader ";
  protected final String TEXT_24 = "_uploader = ";
  protected final String TEXT_25 = "_client.startUploadFile(";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = ", -1);" + NL + "\t\tjava.io.OutputStream ";
  protected final String TEXT_28 = "_uploader_body = ";
  protected final String TEXT_29 = "_uploader.getBody();" + NL + "\t\tjava.io.FilterOutputStream ";
  protected final String TEXT_30 = "_uploader_output = new java.io.FilterOutputStream(new com.dropbox.core.NoThrowOutputStream(";
  protected final String TEXT_31 = "_uploader_body)){" + NL + "\t\t\tpublic void close(){}" + NL + "\t\t};" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_32 = "_OUTPUTSTREAM\", ";
  protected final String TEXT_33 = "_uploader_output);" + NL + "\t\ttry{";
  protected final String TEXT_34 = NL + "\t\t\t";

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
		
		String exposeOutput = ElementParameterParser.getValue(node, "__EXPOSE_OUTPUT_STREAM__");
		String filePath = ElementParameterParser.getValue(node, "__FILE_PATH__");
		
	    String mode = "com.dropbox.core.DbxWriteMode.add()";
	    if("true".equals(ElementParameterParser.getValue(node,"__FORCE_MODE__"))){
	    	mode = "com.dropbox.core.DbxWriteMode.force()";
	    }else if("true".equals(ElementParameterParser.getValue(node,"__UPDATE_MODE__"))){
	    	mode = "com.dropbox.core.DbxWriteMode.update("+ElementParameterParser.getValue(node,"__REVISION__")+")";
	    }

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
    if("true".equals(exposeOutput)){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(filePath);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(mode);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}
