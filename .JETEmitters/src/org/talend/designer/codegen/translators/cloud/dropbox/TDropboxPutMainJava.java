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

public class TDropboxPutMainJava
{
  protected static String nl;
  public static synchronized TDropboxPutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDropboxPutMainJava result = new TDropboxPutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t";
  protected final String TEXT_3 = NL + "\t\tObject ";
  protected final String TEXT_4 = "_content = ";
  protected final String TEXT_5 = ".content;" + NL + "\t\t" + NL + "\t\tif(";
  protected final String TEXT_6 = "_content == null){" + NL + "\t\t\tthrow new Exception(\"The Uploaded Dropbox file Content can't be null\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tjava.io.InputStream ";
  protected final String TEXT_7 = "_InputStream = null;" + NL + "\t\tif(";
  protected final String TEXT_8 = "_content instanceof byte[]){" + NL + "\t\t\t";
  protected final String TEXT_9 = "_InputStream = new java.io.ByteArrayInputStream((byte[])";
  protected final String TEXT_10 = "_content);" + NL + "\t\t}else if(";
  protected final String TEXT_11 = "_content instanceof java.io.InputStream){" + NL + "\t\t\t";
  protected final String TEXT_12 = "_InputStream = (java.io.InputStream)";
  protected final String TEXT_13 = "_content;" + NL + "\t\t}else{" + NL + "\t\t\t";
  protected final String TEXT_14 = "_InputStream = new java.io.ByteArrayInputStream(";
  protected final String TEXT_15 = "_content.toString().getBytes());" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t\tcom.dropbox.core.DbxEntry.File ";
  protected final String TEXT_16 = "_UploadedFile = ";
  protected final String TEXT_17 = "_client.uploadFile(";
  protected final String TEXT_18 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = ", -1, ";
  protected final String TEXT_20 = "_InputStream);" + NL + "\t\t} finally {" + NL + "\t\t\t";
  protected final String TEXT_21 = "_InputStream.close();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\t\t";
  protected final String TEXT_23 = ".content = ";
  protected final String TEXT_24 = "_content;" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t\t" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_26 = NL + "\tjava.io.InputStream ";
  protected final String TEXT_27 = "_InputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(";
  protected final String TEXT_28 = "));" + NL + "\ttry {" + NL + "\t\tcom.dropbox.core.DbxEntry.File ";
  protected final String TEXT_29 = "_UploadedFile = ";
  protected final String TEXT_30 = "_client.uploadFile(";
  protected final String TEXT_31 = "," + NL + "\t\t\t\t";
  protected final String TEXT_32 = ", -1, ";
  protected final String TEXT_33 = "_InputStream);" + NL + "\t} finally {" + NL + "\t\t";
  protected final String TEXT_34 = "_InputStream.close();" + NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_35 = NL + "\t\t";
  protected final String TEXT_36 = ".content = ";
  protected final String TEXT_37 = "_content;" + NL + "\t";
  protected final String TEXT_38 = NL + "     ";
  protected final String TEXT_39 = "_uploader.finish();" + NL + "\t ";
  protected final String TEXT_40 = "_uploader.close();" + NL + "\t ";
  protected final String TEXT_41 = "_uploader = ";
  protected final String TEXT_42 = "_client.startUploadFile(";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = ", -1);" + NL + "\t ";
  protected final String TEXT_45 = "_uploader_body = ";
  protected final String TEXT_46 = "_uploader.getBody();" + NL + "\t ";
  protected final String TEXT_47 = "_uploader_output = new java.io.FilterOutputStream(new com.dropbox.core.NoThrowOutputStream(";
  protected final String TEXT_48 = "_uploader_body)){" + NL + "\t\tpublic void close(){}" + NL + "\t };" + NL + "\t globalMap.put(\"";
  protected final String TEXT_49 = "_OUTPUTSTREAM\", ";
  protected final String TEXT_50 = "_uploader_output);";
  protected final String TEXT_51 = NL + "\t\t\t";

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
	    
	    String uploadLocalFile = ElementParameterParser.getValue(node, "__UPLOAD_LOCAL_FILE__");
	    String localFilePath = ElementParameterParser.getValue(node, "__LOCAL_FILE_PATH__");
	    
		String readContentFromInput = ElementParameterParser.getValue(node, "__READ_CONTENT_FROM_INPUT__");
		String exposeOutput = ElementParameterParser.getValue(node, "__EXPOSE_OUTPUT_STREAM__");
		
		String filePath = ElementParameterParser.getValue(node, "__FILE_PATH__");
		
        String dataInputConnection = null;	
        String dataOutputConnection = null;	
        
        if("true".equals(readContentFromInput)){
	        List< ? extends IConnection> inputConnections = node.getIncomingConnections();
		    for(IConnection conn : inputConnections) {
		        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		        	dataInputConnection = conn.getName();
		        	break;
		        } // if(conn) end
		    } // for(conns) end
		    
		    
			List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
		    for(IConnection conn : outputConnections) {
		        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		        	dataOutputConnection = conn.getName();
		        	break;
		        } // if(conn) end
		    } // for(conns) end
        }
	    String mode = "com.dropbox.core.DbxWriteMode.add()";
	    if("true".equals(ElementParameterParser.getValue(node,"__FORCE_MODE__"))){
	    	mode = "com.dropbox.core.DbxWriteMode.force()";
	    }else if("true".equals(ElementParameterParser.getValue(node,"__UPDATE_MODE__"))){
	    	mode = "com.dropbox.core.DbxWriteMode.update("+ElementParameterParser.getValue(node,"__REVISION__")+")";
	    }


    if("true".equals(readContentFromInput)){
    stringBuffer.append(TEXT_2);
    if(dataInputConnection != null){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dataInputConnection);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(filePath);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(mode);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    if(dataOutputConnection != null){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    }
}else if("true".equals(uploadLocalFile)){
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(localFilePath);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(filePath);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(mode);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    if(dataOutputConnection != null){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    }
    } else if("true".equals(exposeOutput)){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(filePath);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(mode);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
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
    }
    stringBuffer.append(TEXT_51);
    return stringBuffer.toString();
  }
}
