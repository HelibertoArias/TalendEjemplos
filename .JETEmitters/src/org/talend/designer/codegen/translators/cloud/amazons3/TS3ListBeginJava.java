package org.talend.designer.codegen.translators.cloud.amazons3;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TS3ListBeginJava
{
  protected static String nl;
  public static synchronized TS3ListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TS3ListBeginJava result = new TS3ListBeginJava();
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
  protected final String TEXT_57 = NL + NL + "\tint nb_bucket_";
  protected final String TEXT_58 = " = 0;" + NL + "\tint nb_bucket_object_";
  protected final String TEXT_59 = " = 0;" + NL + "\ttry{" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\t\tjava.util.List<com.amazonaws.services.s3.model.Bucket> buckets_";
  protected final String TEXT_61 = " = conn_";
  protected final String TEXT_62 = ".listBuckets();" + NL + "\t\t\tfor (com.amazonaws.services.s3.model.Bucket bucket_";
  protected final String TEXT_63 = " : buckets_";
  protected final String TEXT_64 = ") {" + NL + "\t\t\t\tString currentBucketName_";
  protected final String TEXT_65 = " = bucket_";
  protected final String TEXT_66 = ".getName();" + NL + "\t\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_68 = " - Retrieving objects from:\" + currentBucketName_";
  protected final String TEXT_69 = " + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\tcom.amazonaws.services.s3.model.ObjectListing objects_";
  protected final String TEXT_71 = " = null;" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tobjects_";
  protected final String TEXT_72 = " = conn_";
  protected final String TEXT_73 = ".listObjects(currentBucketName_";
  protected final String TEXT_74 = ",";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\t}catch(com.amazonaws.AmazonClientException e_";
  protected final String TEXT_76 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_78 = " - Failed to list objects from bucket \"+currentBucketName_";
  protected final String TEXT_79 = ");" + NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_80 = " - \"+e_";
  protected final String TEXT_81 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\tSystem.err.println(\"WARNING: [";
  protected final String TEXT_83 = "] failed to list objects from bucket \"+currentBucketName_";
  protected final String TEXT_84 = ");" + NL + "\t\t\t\t\t\tSystem.err.println(\"WARNING: [";
  protected final String TEXT_85 = "] \"+e_";
  protected final String TEXT_86 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t";
  protected final String TEXT_88 = NL + "\t\t\tjava.util.List<java.util.Map<String,String>> buckets_map_list_";
  protected final String TEXT_89 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "\t\t\tjava.util.Map<String,String> bucket_prefix_map_";
  protected final String TEXT_90 = " = null;" + NL + "\t\t\tString object_prefix_";
  protected final String TEXT_91 = " = \"\";" + NL + "\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\t\tobject_prefix_";
  protected final String TEXT_93 = " = ";
  protected final String TEXT_94 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\tbucket_prefix_map_";
  protected final String TEXT_96 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\t\tbucket_prefix_map_";
  protected final String TEXT_97 = ".put(";
  protected final String TEXT_98 = ",object_prefix_";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\tbuckets_map_list_";
  protected final String TEXT_100 = ".add(bucket_prefix_map_";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\tobject_prefix_";
  protected final String TEXT_102 = " = \"\";" + NL + "\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\tfor (java.util.Map<String,String> bucketMap_";
  protected final String TEXT_104 = ": buckets_map_list_";
  protected final String TEXT_105 = ") {" + NL + "\t\t\t\tString currentBucketName_";
  protected final String TEXT_106 = " = \"\";" + NL + "\t\t\t\tString currentPrefix_";
  protected final String TEXT_107 = " = \"\";" + NL + "\t\t\t\tfor(java.util.Map.Entry<String,String> entry_";
  protected final String TEXT_108 = ":bucketMap_";
  protected final String TEXT_109 = ".entrySet()){" + NL + "\t\t\t\t\tcurrentBucketName_";
  protected final String TEXT_110 = " = entry_";
  protected final String TEXT_111 = ".getKey();" + NL + "\t\t\t\t\tcurrentPrefix_";
  protected final String TEXT_112 = " = entry_";
  protected final String TEXT_113 = ".getValue();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.ObjectListing objects_";
  protected final String TEXT_114 = " = null;" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_116 = " - Retrieving objects from:\" + currentBucketName_";
  protected final String TEXT_117 = " + \".\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t\t\tobjects_";
  protected final String TEXT_119 = " = conn_";
  protected final String TEXT_120 = ".listObjects(currentBucketName_";
  protected final String TEXT_121 = ",currentPrefix_";
  protected final String TEXT_122 = ");" + NL + "\t\t\t\t}catch(com.amazonaws.AmazonClientException e_";
  protected final String TEXT_123 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_125 = " - Failed to list objects from bucket \"+currentBucketName_";
  protected final String TEXT_126 = ");" + NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_127 = " - \"+e_";
  protected final String TEXT_128 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_129 = NL + "\t\t\t\t\t\tSystem.err.println(\"WARNING: [";
  protected final String TEXT_130 = "] failed to list objects from bucket \"+currentBucketName_";
  protected final String TEXT_131 = ");" + NL + "\t\t\t\t\t\tSystem.err.println(\"WARNING: [";
  protected final String TEXT_132 = "] \"+e_";
  protected final String TEXT_133 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_134 = NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\twhile(true){" + NL + "\t\t\t\t\tjava.util.List<com.amazonaws.services.s3.model.S3ObjectSummary> list_objects_";
  protected final String TEXT_136 = " = objects_";
  protected final String TEXT_137 = ".getObjectSummaries();" + NL + "\t\t\t\t\tif(list_objects_";
  protected final String TEXT_138 = ".size()>0){" + NL + "\t\t\t\t\t\tnb_bucket_";
  protected final String TEXT_139 = "++;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tfor (com.amazonaws.services.s3.model.S3ObjectSummary objectSummary_";
  protected final String TEXT_140 = " : list_objects_";
  protected final String TEXT_141 = ") {" + NL + "\t\t\t\t\t\tnb_bucket_object_";
  protected final String TEXT_142 = "++;" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_143 = "_CURRENT_BUCKET\", currentBucketName_";
  protected final String TEXT_144 = ");" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_145 = "_CURRENT_KEY\", objectSummary_";
  protected final String TEXT_146 = ".getKey());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_147 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_148 = " - Retrieving the object \" + nb_bucket_object_";
  protected final String TEXT_149 = " + \".\");" + NL + "\t\t\t\t\t\t\tlog.trace(\"";
  protected final String TEXT_150 = " - Key of current object : \" + objectSummary_";
  protected final String TEXT_151 = ".getKey());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
	
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
		List<Map<String, String>> buckets = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__BUCKETS__");
		boolean listAll = "true".equals(ElementParameterParser.getValue(node,"__LISTALL__"));
		if(listAll){
			String objects_prefix=ElementParameterParser.getValue(node,"__OBJECTS_PREFIX__");
			
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
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
				}
				
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(objects_prefix!=null && objects_prefix.trim().length()>0 ?objects_prefix:null);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
			    	if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
					}
					
    stringBuffer.append(TEXT_87);
    
		} else if(buckets.size()>0){
		
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
			for(Map<String, String> map: buckets){
				String bucket_name =map.get("BUCKET_NAME");
				String object_prefix =map.get("OBJECT_PREFIX");
				if(object_prefix!=null && object_prefix.trim().length()>0){
				
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(object_prefix);
    stringBuffer.append(TEXT_94);
    
				}
				
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(bucket_name);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
			}
			
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
					}
					
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
			    	if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
					}else{
			    	
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
					}
					
    stringBuffer.append(TEXT_134);
    
			}
			if(listAll || buckets.size()>0){
			
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
						}
						
    stringBuffer.append(TEXT_152);
    
			}
			
    return stringBuffer.toString();
  }
}
