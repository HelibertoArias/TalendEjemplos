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

public class TDropboxListBeginJava
{
  protected static String nl;
  public static synchronized TDropboxListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDropboxListBeginJava result = new TDropboxListBeginJava();
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
  protected final String TEXT_21 = NL + "\tcom.dropbox.core.DbxEntry.WithChildren ";
  protected final String TEXT_22 = "_entries = ";
  protected final String TEXT_23 = "_client" + NL + "\t\t\t.getMetadataWithChildren(";
  protected final String TEXT_24 = ");" + NL + "\tif (";
  protected final String TEXT_25 = "_entries == null) {" + NL + "\t\tthrow new Exception(\"No File or Directory found at \" + ";
  protected final String TEXT_26 = ");" + NL + "\t}" + NL + "\tjava.util.Deque<com.dropbox.core.DbxEntry> ";
  protected final String TEXT_27 = "_files = new java.util.ArrayDeque<com.dropbox.core.DbxEntry>();" + NL + "\tif (";
  protected final String TEXT_28 = "_entries.entry.isFile()) {" + NL + "\t\t";
  protected final String TEXT_29 = "_files.add(";
  protected final String TEXT_30 = "_entries.entry);" + NL + "\t} else if (";
  protected final String TEXT_31 = "_entries.children != null) {" + NL + "\t\t";
  protected final String TEXT_32 = "_files.addAll(";
  protected final String TEXT_33 = "_entries.children);" + NL + "\t}" + NL + "\tif (!";
  protected final String TEXT_34 = "_files.isEmpty()) {" + NL + "\t\tcom.dropbox.core.DbxEntry ";
  protected final String TEXT_35 = "_child = null;" + NL + "\t\twhile( (";
  protected final String TEXT_36 = "_child = ";
  protected final String TEXT_37 = "_files.poll()) != null) {" + NL + "\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\tif (!";
  protected final String TEXT_39 = "_child.isFile()) {" + NL + "\t\t\t\t\t\tcom.dropbox.core.DbxEntry.WithChildren tmp = ";
  protected final String TEXT_40 = "_client.getMetadataWithChildren(";
  protected final String TEXT_41 = "_child.path);" + NL + "\t\t\t\t\t\tif(tmp != null && tmp.children != null){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_42 = "_files.addAll(tmp.children);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\tcom.dropbox.core.DbxClient.Downloader ";
  protected final String TEXT_44 = "_downloader = null;" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\tif (!";
  protected final String TEXT_46 = "_child.isFile()) {" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_47 = "_downloader = ";
  protected final String TEXT_48 = "_client.startGetFile(";
  protected final String TEXT_49 = "_child.path, null);" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_50 = "_LAST_MODIFIED\",";
  protected final String TEXT_51 = "_child.asFile().lastModified.getTime());" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_52 = "_SIZE\",";
  protected final String TEXT_53 = "_child.asFile().numBytes);" + NL + "\t\t\t\tif (";
  protected final String TEXT_54 = "_downloader != null) {" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_55 = "_CONTENT\",";
  protected final String TEXT_56 = "_downloader.body);" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\tif (";
  protected final String TEXT_58 = "_child.isFile()) {" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\tif(";
  protected final String TEXT_60 = "_child.isFile()){" + NL + "\t\t\t\t\t";
  protected final String TEXT_61 = "_downloader = ";
  protected final String TEXT_62 = "_client.startGetFile(";
  protected final String TEXT_63 = "_child.path, null);" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_64 = "_LAST_MODIFIED\",";
  protected final String TEXT_65 = "_child.asFile().lastModified.getTime());" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_66 = "_SIZE\",";
  protected final String TEXT_67 = "_child.asFile().numBytes);" + NL + "\t\t\t\t\tif (";
  protected final String TEXT_68 = "_downloader != null) {" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_69 = "_CONTENT\",";
  protected final String TEXT_70 = "_downloader.body);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_71 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_72 = "_NAME\",";
  protected final String TEXT_73 = "_child.name);" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_74 = "_PATH\",";
  protected final String TEXT_75 = "_child.path);" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_76 = "_IS_FILE\",";
  protected final String TEXT_77 = "_child.isFile());" + NL + "\t\t\t" + NL + "\t\t\ttry{";

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
		String includeSubDir = ElementParameterParser.getValue(node, "__INCLUDSUBDIR__");
		String listMode = ElementParameterParser.getValue(node, "__LIST_MODE__");

    
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    if("true".equals(includeSubDir)){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    if("FILES".equals(listMode)){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
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
    }else if("DIRECTORIES".equals(listMode)){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    }else{
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    return stringBuffer.toString();
  }
}
