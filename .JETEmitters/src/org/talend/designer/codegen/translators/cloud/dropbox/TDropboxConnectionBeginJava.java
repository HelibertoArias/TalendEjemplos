package org.talend.designer.codegen.translators.cloud.dropbox;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TDropboxConnectionBeginJava
{
  protected static String nl;
  public static synchronized TDropboxConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDropboxConnectionBeginJava result = new TDropboxConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\tcom.dropbox.core.DbxRequestConfig ";
  protected final String TEXT_4 = "_config = new com.dropbox.core.DbxRequestConfig(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = "," + NL + "\t\t\t\tnew com.dropbox.core.http.StandardHttpRequestor(new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = "))));";
  protected final String TEXT_9 = NL + "\tcom.dropbox.core.DbxRequestConfig ";
  protected final String TEXT_10 = "_config = new com.dropbox.core.DbxRequestConfig(";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\tcom.dropbox.core.DbxClient ";
  protected final String TEXT_14 = "_client = new com.dropbox.core.DbxClient(";
  protected final String TEXT_15 = "_config, ";
  protected final String TEXT_16 = ");" + NL + "\t" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_17 = "\",  ";
  protected final String TEXT_18 = "_client);";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		
		String accessToken = ElementParameterParser.getValue(node, "__ACCESS_TOKEN__");
		
		String useProxy = ElementParameterParser.getValue(node, "__USE_PROXY__");
		String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
		String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
		
		String clientIdentifier = "\""+cid+"\"";
		
		String localeName = "\""+java.util.Locale.getDefault().toString()+"\"";
		

    stringBuffer.append(TEXT_2);
    if("true".equals(useProxy)){
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
    }else{
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(clientIdentifier);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(localeName);
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
