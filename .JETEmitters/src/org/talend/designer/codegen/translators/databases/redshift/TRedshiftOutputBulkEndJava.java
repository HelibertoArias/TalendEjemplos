package org.talend.designer.codegen.translators.databases.redshift;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;
import java.util.List;

public class TRedshiftOutputBulkEndJava
{
  protected static String nl;
  public static synchronized TRedshiftOutputBulkEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRedshiftOutputBulkEndJava result = new TRedshiftOutputBulkEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\tcsvWriter_";
  protected final String TEXT_30 = ".close();" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_31 = "_NB_LINE\",nb_line_";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\tif(file_";
  protected final String TEXT_34 = ".exists() && (file_";
  protected final String TEXT_35 = ".length() > 0)) {" + NL + "\t\t";
  protected final String TEXT_36 = NL + "\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_37 = " = (com.amazonaws.services.s3.AmazonS3Client)globalMap.get(\"";
  protected final String TEXT_38 = "\");" + NL + "\t\t";
  protected final String TEXT_39 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_40 = " - Get an free connection from \" + \"";
  protected final String TEXT_41 = "\" + \".\");" + NL + "\t\t";
  protected final String TEXT_42 = NL + "\t    ";
  protected final String TEXT_43 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_44 = " - Creating new connection.\");" + NL + "\t\t";
  protected final String TEXT_45 = NL + "    " + NL + "    \t";
  protected final String TEXT_46 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_47 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = "; ";
  protected final String TEXT_52 = NL + NL + "\t\tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_53 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_54 = ",decryptedPassword_";
  protected final String TEXT_55 = ");" + NL + "\t\t";
  protected final String TEXT_56 = NL + "\t\t\tcom.amazonaws.ClientConfiguration cc_";
  protected final String TEXT_57 = " = new com.amazonaws.ClientConfiguration();" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\t\tint scketSendBufferSizeHints_";
  protected final String TEXT_59 = " = 0;" + NL + "\t\t\t\t\tint socketReceiveBufferSizeHints_";
  protected final String TEXT_60 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\tscketSendBufferSizeHints_";
  protected final String TEXT_62 = " = ";
  protected final String TEXT_63 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t\tsocketReceiveBufferSizeHints_";
  protected final String TEXT_65 = " = ";
  protected final String TEXT_66 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_68 = ".setProtocol(com.amazonaws.Protocol.";
  protected final String TEXT_69 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_71 = ".set";
  protected final String TEXT_72 = "(";
  protected final String TEXT_73 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\tcc_";
  protected final String TEXT_75 = ".setSocketBufferSizeHints(scketSendBufferSizeHints_";
  protected final String TEXT_76 = ",socketReceiveBufferSizeHints_";
  protected final String TEXT_77 = ");" + NL + "\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_79 = " = new com.amazonaws.services.s3.AmazonS3Client(credentials_";
  protected final String TEXT_80 = ",cc_";
  protected final String TEXT_81 = ");" + NL + "\t\t";
  protected final String TEXT_82 = NL + "\t\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_83 = " = new com.amazonaws.services.s3.AmazonS3Client(credentials_";
  protected final String TEXT_84 = ");" + NL + "\t\t";
  protected final String TEXT_85 = NL + "\t\t\tconn_";
  protected final String TEXT_86 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_87 = "));" + NL + "\t\t";
  protected final String TEXT_88 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_89 = " - Creating new connection successfully.\");" + NL + "\t\t";
  protected final String TEXT_90 = NL + "\t\ttry{" + NL + "\t\t\t";
  protected final String TEXT_91 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_92 = " - Uploading an object with key:\" + ";
  protected final String TEXT_93 = ");" + NL + "\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\tconn_";
  protected final String TEXT_95 = ".putObject(";
  protected final String TEXT_96 = ", ";
  protected final String TEXT_97 = ", file_";
  protected final String TEXT_98 = ");" + NL + "\t\t\t";
  protected final String TEXT_99 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_100 = " - Upload the object successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_101 = NL + "\t\t} finally {" + NL + "\t\t\tif(conn_";
  protected final String TEXT_102 = " !=null){" + NL + "\t\t\t\tconn_";
  protected final String TEXT_103 = ".shutdown();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t} else {";
  protected final String TEXT_104 = NL + "\t\tlog.error(\"";
  protected final String TEXT_105 = " - \" + \"file doesn't exist or content is empty.\");";
  protected final String TEXT_106 = NL + "\t\tSystem.err.println(\"file doesn't exist or content is empty.\");" + NL + "\t}";
  protected final String TEXT_107 = NL + "\tif(file_";
  protected final String TEXT_108 = ".exists()) {" + NL + "\t\tfile_";
  protected final String TEXT_109 = ".delete();" + NL + "\t}";
  protected final String TEXT_110 = NL + "\tresourceMap.put(\"finish_";
  protected final String TEXT_111 = "\", true);";
  protected final String TEXT_112 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
	log4jFileUtil.writeDataFinishInfo(node);
	
	//upload the bulk data file to amazon s3
    String bucket = ElementParameterParser.getValue(node,"__BUCKET__");
    String key = ElementParameterParser.getValue(node,"__KEY__");
    String file = ElementParameterParser.getValue(node,"__FILE__");
	
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	boolean configClient = "true".equals(ElementParameterParser.getValue(node, "__CONFIG_CLIENT__"));
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	List<Map<String,String>> clientConfiguration = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CLIENT_CONFIGURATION__");
	String region = ElementParameterParser.getValue(node,"__REGION__");
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;;
		
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_38);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_41);
    
		}
	}else{
	
    stringBuffer.append(TEXT_42);
    
	    if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
		}
	    String passwordFieldName = "__SECRET_KEY__";
	    
    stringBuffer.append(TEXT_45);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_48);
    } else {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    
		if(configClient && clientConfiguration.size()>0){
		
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
			boolean setBuffer = false;
			for(Map<String,String> map :clientConfiguration){
				String client_parameter = map.get("CLIENT_PARAMETER");
				String value = map.get("VALUE");
				if(!setBuffer && ("SocketSendBufferSizeHints".equals(client_parameter) || "SocketReceiveBufferSizeHints".equals(client_parameter))){
					setBuffer=true;
					
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
				}
				if("SocketSendBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_63);
    
				}else if("SocketReceiveBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_66);
    
				}else if("Protocol".equals(client_parameter)){
				
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(value.toUpperCase().replaceAll("\"",""));
    stringBuffer.append(TEXT_69);
    
				}else{
				
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(client_parameter);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_73);
    
				}
			}
			if(setBuffer){
			
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
			}
			
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
		}else{
		
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
		}
		if(region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region)){
		
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_87);
    
		}
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
		}
	}
	
    stringBuffer.append(TEXT_90);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_93);
    
			}
			
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
			}
			
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
		if(isLog4jEnabled){

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
		}

    stringBuffer.append(TEXT_106);
    
	boolean delete = "true".equals(ElementParameterParser.getValue(node,"__DELETE_LOCALFILE__"));
	if(delete) {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
	}

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(TEXT_112);
    return stringBuffer.toString();
  }
}
