package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;

public class TRESTBeginJava
{
  protected static String nl;
  public static synchronized TRESTBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRESTBeginJava result = new TRESTBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "                if(log.is";
  protected final String TEXT_4 = "Enabled())";
  protected final String TEXT_5 = NL + "            log.";
  protected final String TEXT_6 = "(\"";
  protected final String TEXT_7 = " - \" ";
  protected final String TEXT_8 = " + ";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "            StringBuilder ";
  protected final String TEXT_12 = " = new StringBuilder();";
  protected final String TEXT_13 = NL + "            ";
  protected final String TEXT_14 = ".append(\"Parameters:\");";
  protected final String TEXT_15 = NL + "                    ";
  protected final String TEXT_16 = ".append(\"";
  protected final String TEXT_17 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_18 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_19 = NL + "                    ";
  protected final String TEXT_20 = ".append(\"";
  protected final String TEXT_21 = "\" + \" = \" + ";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "                ";
  protected final String TEXT_24 = ".append(\" | \");";
  protected final String TEXT_25 = NL + "            StringBuilder ";
  protected final String TEXT_26 = " = new StringBuilder();    ";
  protected final String TEXT_27 = NL + "                    ";
  protected final String TEXT_28 = ".append(";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "                    if(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = " == null){";
  protected final String TEXT_34 = NL + "                        ";
  protected final String TEXT_35 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_36 = NL + "                        ";
  protected final String TEXT_37 = ".append(";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ");" + NL + "                    }   ";
  protected final String TEXT_40 = NL + "                ";
  protected final String TEXT_41 = ".append(\"|\");";
  protected final String TEXT_42 = NL + "\t";
  protected final String TEXT_43 = NL + "\tString endpoint_";
  protected final String TEXT_44 = " = ";
  protected final String TEXT_45 = ";" + NL + "\t" + NL + "\tString trustStoreFile_";
  protected final String TEXT_46 = " = System.getProperty(\"javax.net.ssl.trustStore\");" + NL + "\tString trustStoreType_";
  protected final String TEXT_47 = " = System.getProperty(\"javax.net.ssl.trustStoreType\");" + NL + "\tString trustStorePWD_";
  protected final String TEXT_48 = " = System.getProperty(\"javax.net.ssl.trustStorePassword\");" + NL + "\t" + NL + "\tString keyStoreFile_";
  protected final String TEXT_49 = " = System.getProperty(\"javax.net.ssl.keyStore\");" + NL + "\tString keyStoreType_";
  protected final String TEXT_50 = " = System.getProperty(\"javax.net.ssl.keyStoreType\");" + NL + "\tString keyStorePWD_";
  protected final String TEXT_51 = " = System.getProperty(\"javax.net.ssl.keyStorePassword\");" + NL + "\t" + NL + "\tcom.sun.jersey.api.client.config.ClientConfig config_";
  protected final String TEXT_52 = " = new com.sun.jersey.api.client.config.DefaultClientConfig();" + NL + "\tjavax.net.ssl.SSLContext ctx_";
  protected final String TEXT_53 = " = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "\t" + NL + "\tjavax.net.ssl.TrustManager[] tms_";
  protected final String TEXT_54 = " = null;" + NL + "\tif(trustStoreFile_";
  protected final String TEXT_55 = "!=null && trustStoreType_";
  protected final String TEXT_56 = "!=null){" + NL + "\t\tchar[] password_";
  protected final String TEXT_57 = " = null;" + NL + "\t\tif(trustStorePWD_";
  protected final String TEXT_58 = "!=null)" + NL + "\t\t\tpassword_";
  protected final String TEXT_59 = " = trustStorePWD_";
  protected final String TEXT_60 = ".toCharArray();" + NL + "\t\tjava.security.KeyStore trustStore_";
  protected final String TEXT_61 = " = java.security.KeyStore.getInstance(trustStoreType_";
  protected final String TEXT_62 = ");" + NL + "\t\ttrustStore_";
  protected final String TEXT_63 = ".load(new java.io.FileInputStream(trustStoreFile_";
  protected final String TEXT_64 = "), password_";
  protected final String TEXT_65 = ");" + NL + "\t\t" + NL + "\t\tjavax.net.ssl.TrustManagerFactory tmf_";
  protected final String TEXT_66 = " = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "        tmf_";
  protected final String TEXT_67 = ".init(trustStore_";
  protected final String TEXT_68 = ");" + NL + "        tms_";
  protected final String TEXT_69 = " = tmf_";
  protected final String TEXT_70 = ".getTrustManagers();" + NL + "\t}" + NL + "\t" + NL + "\tjavax.net.ssl.KeyManager[] kms_";
  protected final String TEXT_71 = " = null;" + NL + "\tif(keyStoreFile_";
  protected final String TEXT_72 = "!=null && keyStoreType_";
  protected final String TEXT_73 = "!=null){" + NL + "\t\tchar[] password_";
  protected final String TEXT_74 = " = null;" + NL + "\t\tif(keyStorePWD_";
  protected final String TEXT_75 = "!=null)" + NL + "\t\t\tpassword_";
  protected final String TEXT_76 = " = keyStorePWD_";
  protected final String TEXT_77 = ".toCharArray();" + NL + "\t\tjava.security.KeyStore keyStore_";
  protected final String TEXT_78 = " = java.security.KeyStore.getInstance(keyStoreType_";
  protected final String TEXT_79 = ");" + NL + "\t\tkeyStore_";
  protected final String TEXT_80 = ".load(new java.io.FileInputStream(keyStoreFile_";
  protected final String TEXT_81 = "), password_";
  protected final String TEXT_82 = ");" + NL + "\t\t" + NL + "\t\tjavax.net.ssl.KeyManagerFactory kmf_";
  protected final String TEXT_83 = " = javax.net.ssl.KeyManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "        kmf_";
  protected final String TEXT_84 = ".init(keyStore_";
  protected final String TEXT_85 = ",password_";
  protected final String TEXT_86 = ");" + NL + "        kms_";
  protected final String TEXT_87 = " = kmf_";
  protected final String TEXT_88 = ".getKeyManagers();" + NL + "\t}" + NL + "\t" + NL + "    ctx_";
  protected final String TEXT_89 = ".init(kms_";
  protected final String TEXT_90 = ", tms_";
  protected final String TEXT_91 = " , null);" + NL + "    config_";
  protected final String TEXT_92 = ".getProperties().put(com.sun.jersey.client.urlconnection.HTTPSProperties.PROPERTY_HTTPS_PROPERTIES," + NL + "                new com.sun.jersey.client.urlconnection.HTTPSProperties(new javax.net.ssl.HostnameVerifier() {" + NL + "" + NL + "                    public boolean verify(String hostName, javax.net.ssl.SSLSession session) {" + NL + "                        return true;" + NL + "                    }" + NL + "                }, ctx_";
  protected final String TEXT_93 = "));" + NL + "" + NL + "\tcom.sun.jersey.api.client.Client restClient_";
  protected final String TEXT_94 = " = com.sun.jersey.api.client.Client.create(config_";
  protected final String TEXT_95 = ");" + NL + "\tcom.sun.jersey.api.client.WebResource restResource_";
  protected final String TEXT_96 = ";" + NL + "\tif(endpoint_";
  protected final String TEXT_97 = "!=null && !(\"\").equals(endpoint_";
  protected final String TEXT_98 = ")){" + NL + "\t\trestResource_";
  protected final String TEXT_99 = " = restClient_";
  protected final String TEXT_100 = ".resource(endpoint_";
  protected final String TEXT_101 = ");" + NL + "\t}else{" + NL + "\t\tthrow new IllegalArgumentException(\"url can't be empty!\");" + NL + "\t}" + NL + "\t" + NL + "\tcom.sun.jersey.api.client.ClientResponse errorResponse_";
  protected final String TEXT_102 = " = null;" + NL + "\tString restResponse_";
  protected final String TEXT_103 = " = \"\";" + NL + "\ttry{" + NL + "\t\t";
  protected final String TEXT_104 = NL + "\t\trestResponse_";
  protected final String TEXT_105 = " = restResource_";
  protected final String TEXT_106 = NL + "\t\t";
  protected final String TEXT_107 = NL + "        \t.header(";
  protected final String TEXT_108 = ",";
  protected final String TEXT_109 = ")" + NL + "\t\t";
  protected final String TEXT_110 = "  " + NL + "\t\t";
  protected final String TEXT_111 = NL + "\t\t\t.get(String.class);" + NL + "\t\t";
  protected final String TEXT_112 = NL + "\t\t\t.post(String.class,";
  protected final String TEXT_113 = ");" + NL + "\t\t";
  protected final String TEXT_114 = NL + "\t\t\t.put(String.class,";
  protected final String TEXT_115 = ");" + NL + "\t\t";
  protected final String TEXT_116 = NL + "\t\t\t.delete(String.class);" + NL + "\t\t";
  protected final String TEXT_117 = NL + "\t}catch (com.sun.jersey.api.client.UniformInterfaceException ue) {" + NL + "        errorResponse_";
  protected final String TEXT_118 = " = ue.getResponse();" + NL + "    }" + NL + "\t";
  protected final String TEXT_119 = NL + "\t// for output" + NL + "\t";
  protected final String TEXT_120 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_121 = " = new ";
  protected final String TEXT_122 = "Struct();" + NL + "\t\t\t\tif(errorResponse_";
  protected final String TEXT_123 = "!=null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_124 = ".ERROR_CODE = errorResponse_";
  protected final String TEXT_125 = ".getStatus();" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_126 = ".Body = restResponse_";
  protected final String TEXT_127 = ";" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_128 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_3);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_4);
    
            }
            
    stringBuffer.append(TEXT_5);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_7);
    for(String message : messages){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        info(str("Start to work."));
    }
    
    public void endWork(){
        info(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_11);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_14);
    
            java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
            ignoredParamsTypes.addAll(
                java.util.Arrays.asList(
                    org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                    org.talend.core.model.process.EParameterFieldType.LABEL,
                    org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                    org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                    org.talend.core.model.process.EParameterFieldType.IMAGE,
                    org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                    org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                    org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                    org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                    org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                    org.talend.core.model.process.EParameterFieldType.VERSION,
                    org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                    org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                    org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                    org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                    org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                    org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                    org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                    )
            );
            for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                    continue;
                }
                String name = ep.getName();
                if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                    String epName = "__" + name + "__";
                    String password = "";
                    if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                        password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                    }else{
                        String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                        if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                            passwordValue = "\"\"";
                        } 
                        password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                    } 
                    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_18);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_19);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_22);
    
                }   
                
    stringBuffer.append(TEXT_23);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_24);
    
            }
        }
        debug(var("log4jParamters"));
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_26);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_27);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_30);
    
                }else{
                
    stringBuffer.append(TEXT_31);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_39);
    
                }
                
    stringBuffer.append(TEXT_40);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_41);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    stringBuffer.append(TEXT_42);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	log = new LogUtil(node);
	
	String url = ElementParameterParser.getValue(node,"__URL__");
	String method = ElementParameterParser.getValue(node,"__METHOD__");
	List<Map<String, String>> headers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__HEADERS__");
	        
	String body = ElementParameterParser.getValue(node,"__BODY__");
	body = body.replaceAll("[\r\n]", " ");
	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(url);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    log.info(log.str("Prepare to send request to rest server."));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
        for (int i = 0; i < headers.size(); i++) {
            Map<String, String> line = headers.get(i);
			
    stringBuffer.append(TEXT_107);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_109);
    
        }
		
    stringBuffer.append(TEXT_110);
    
		if("GET".equals(method)){
		
    stringBuffer.append(TEXT_111);
    
		}else if("POST".equals(method)){
		
    stringBuffer.append(TEXT_112);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_113);
    		
		}else if("PUT".equals(method)){
		
    stringBuffer.append(TEXT_114);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_115);
    
		}else if("DELETE".equals(method)){
		
    stringBuffer.append(TEXT_116);
    
		}	
		
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    log.info(log.str("Has sent request to rest server."));
    stringBuffer.append(TEXT_119);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	if (conns!=null) {//1
		if (conns.size()>0) {//2
			IConnection conn = conns.get(0); //the first connection
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3
				IMetadataTable metadata = conn.getMetadataTable();
				List<IMetadataColumn> columnList = metadata.getListColumns();
				
    stringBuffer.append(TEXT_120);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    		
			}//3
		}//2
	}//1
	
    stringBuffer.append(TEXT_128);
    return stringBuffer.toString();
  }
}
