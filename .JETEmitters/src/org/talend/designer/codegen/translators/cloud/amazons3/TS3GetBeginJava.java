package org.talend.designer.codegen.translators.cloud.amazons3;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TS3GetBeginJava
{
  protected static String nl;
  public static synchronized TS3GetBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3GetBeginJava result = new TS3GetBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_4 = " = (com.amazonaws.services.s3.AmazonS3Client)globalMap.get(\"";
  protected final String TEXT_5 = "\");" + NL + "\t\t";
  protected final String TEXT_6 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Get an free connection from \" + \"";
  protected final String TEXT_8 = "\" + \".\");" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t    ";
  protected final String TEXT_10 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Creating new connection.\");" + NL + "\t\t";
  protected final String TEXT_12 = NL + "    " + NL + "    \t";
  protected final String TEXT_13 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_14 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "; ";
  protected final String TEXT_19 = NL + NL + "\t\tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_20 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_21 = ",decryptedPassword_";
  protected final String TEXT_22 = ");" + NL + "\t\t";
  protected final String TEXT_23 = NL + "\t\t\tcom.amazonaws.ClientConfiguration cc_";
  protected final String TEXT_24 = " = new com.amazonaws.ClientConfiguration();" + NL + "\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\tint scketSendBufferSizeHints_";
  protected final String TEXT_26 = " = 0;" + NL + "\t\t\t\t\tint socketReceiveBufferSizeHints_";
  protected final String TEXT_27 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\t\tscketSendBufferSizeHints_";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\tsocketReceiveBufferSizeHints_";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_35 = ".setProtocol(com.amazonaws.Protocol.";
  protected final String TEXT_36 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_38 = ".set";
  protected final String TEXT_39 = "(";
  protected final String TEXT_40 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\tcc_";
  protected final String TEXT_42 = ".setSocketBufferSizeHints(scketSendBufferSizeHints_";
  protected final String TEXT_43 = ",socketReceiveBufferSizeHints_";
  protected final String TEXT_44 = ");" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_46 = " = new com.amazonaws.services.s3.AmazonS3Client(credentials_";
  protected final String TEXT_47 = ",cc_";
  protected final String TEXT_48 = ");" + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_50 = " = new com.amazonaws.services.s3.AmazonS3Client(credentials_";
  protected final String TEXT_51 = ");" + NL + "\t\t";
  protected final String TEXT_52 = NL + "\t\t\tconn_";
  protected final String TEXT_53 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_54 = "));" + NL + "\t\t";
  protected final String TEXT_55 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_56 = " - Creating new connection successfully.\");" + NL + "\t\t";
  protected final String TEXT_57 = NL + "\ttry{" + NL + "\t\t";
  protected final String TEXT_58 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_59 = " - Getting an object with key:\" + ";
  protected final String TEXT_60 = ");" + NL + "\t\t";
  protected final String TEXT_61 = NL + "\t\tconn_";
  protected final String TEXT_62 = ".getObject(new com.amazonaws.services.s3.model.GetObjectRequest(";
  protected final String TEXT_63 = ", ";
  protected final String TEXT_64 = "),new java.io.File(";
  protected final String TEXT_65 = "));" + NL + "\t\t";
  protected final String TEXT_66 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_67 = " - Get the object successfully.\");" + NL + "\t\t";
  protected final String TEXT_68 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_69 = "){" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\t\tthrow(e_";
  protected final String TEXT_71 = ");" + NL + "\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_73 = " - \" + e_";
  protected final String TEXT_74 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_75 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_76 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_77 = NL + "\t}finally{" + NL + "\t\tif(conn_";
  protected final String TEXT_78 = " !=null){" + NL + "\t\t\tconn_";
  protected final String TEXT_79 = ".shutdown();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_80 = NL + "\t}" + NL + "\t";
  protected final String TEXT_81 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String bucket = ElementParameterParser.getValue(node,"__BUCKET__");
    String key = ElementParameterParser.getValue(node,"__KEY__");
    String file = ElementParameterParser.getValue(node,"__FILE__");
    boolean dieOnError = "true".equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
	
    stringBuffer.append(TEXT_2);
    
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	boolean configClient = "true".equals(ElementParameterParser.getValue(node, "__CONFIG_CLIENT__"));
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	List<Map<String,String>> clientConfiguration = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CLIENT_CONFIGURATION__");
	String region = ElementParameterParser.getValue(node,"__REGION__");
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;;
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_5);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_8);
    
		}
	}else{
	
    stringBuffer.append(TEXT_9);
    
	    if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		}
	    String passwordFieldName = "__SECRET_KEY__";
	    
    stringBuffer.append(TEXT_12);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
		if(configClient && clientConfiguration.size()>0){
		
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
			boolean setBuffer = false;
			for(Map<String,String> map :clientConfiguration){
				String client_parameter = map.get("CLIENT_PARAMETER");
				String value = map.get("VALUE");
				if(!setBuffer && ("SocketSendBufferSizeHints".equals(client_parameter) || "SocketReceiveBufferSizeHints".equals(client_parameter))){
					setBuffer=true;
					
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
				}
				if("SocketSendBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_30);
    
				}else if("SocketReceiveBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_33);
    
				}else if("Protocol".equals(client_parameter)){
				
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(value.toUpperCase().replaceAll("\"",""));
    stringBuffer.append(TEXT_36);
    
				}else{
				
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(client_parameter);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_40);
    
				}
			}
			if(setBuffer){
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
			}
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
		}else{
		
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
		}
		if(region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region)){
		
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_54);
    
		}
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
		}
	}
	
    stringBuffer.append(TEXT_57);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_60);
    
		}
		
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_65);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
		}
		
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
		if (dieOnError) {
		
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
		} else {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
			}
			
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
		}
		if(!("true").equals(useExistingConn)) {
		
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
		}
		
    stringBuffer.append(TEXT_80);
    stringBuffer.append(TEXT_81);
    return stringBuffer.toString();
  }
}
