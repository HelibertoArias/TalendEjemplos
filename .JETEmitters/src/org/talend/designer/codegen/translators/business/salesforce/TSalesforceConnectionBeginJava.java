package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.TalendTextUtils;

public class TSalesforceConnectionBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceConnectionBeginJava result = new TSalesforceConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "                if(log.is";
  protected final String TEXT_3 = "Enabled())";
  protected final String TEXT_4 = NL + "            log.";
  protected final String TEXT_5 = "(\"";
  protected final String TEXT_6 = " - \" ";
  protected final String TEXT_7 = " + ";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "            StringBuilder ";
  protected final String TEXT_11 = " = new StringBuilder();";
  protected final String TEXT_12 = NL + "            ";
  protected final String TEXT_13 = ".append(\"Parameters:\");";
  protected final String TEXT_14 = NL + "                    ";
  protected final String TEXT_15 = ".append(\"";
  protected final String TEXT_16 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_17 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_18 = NL + "                    ";
  protected final String TEXT_19 = ".append(\"";
  protected final String TEXT_20 = "\" + \" = \" + ";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "                ";
  protected final String TEXT_23 = ".append(\" | \");";
  protected final String TEXT_24 = NL + "            StringBuilder ";
  protected final String TEXT_25 = " = new StringBuilder();    ";
  protected final String TEXT_26 = NL + "                    ";
  protected final String TEXT_27 = ".append(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "                    if(";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = " == null){";
  protected final String TEXT_33 = NL + "                        ";
  protected final String TEXT_34 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_35 = NL + "                        ";
  protected final String TEXT_36 = ".append(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ");" + NL + "                    }   ";
  protected final String TEXT_39 = NL + "                ";
  protected final String TEXT_40 = ".append(\"|\");";
  protected final String TEXT_41 = NL + "System.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");";
  protected final String TEXT_42 = NL + "\t";
  protected final String TEXT_43 = NL + "    \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_44 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_45 = ");" + NL + "    \t";
  protected final String TEXT_46 = NL + "    \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_47 = " = ";
  protected final String TEXT_48 = ";" + NL + "    \t";
  protected final String TEXT_49 = NL + "    \torg.talend.salesforceBulk.SforceBulkConnection sforceConn_";
  protected final String TEXT_50 = NL + "    \t\t= new org.talend.salesforceBulk.SforceOAuthBulkConnection.Builder(";
  protected final String TEXT_51 = ", ";
  protected final String TEXT_52 = ", decryptedQauthClientPwd_";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ", ";
  protected final String TEXT_55 = ", ";
  protected final String TEXT_56 = ")" + NL + "    \t\t\t";
  protected final String TEXT_57 = NL + "    \t\t\t\t.setTokenFilePath(";
  protected final String TEXT_58 = ")" + NL + "    \t\t\t";
  protected final String TEXT_59 = NL + "    \t\t\t.needCompression(";
  protected final String TEXT_60 = ").needTraceMessage(";
  protected final String TEXT_61 = ")" + NL + "    \t\t\t.build();" + NL + "\t";
  protected final String TEXT_62 = NL + NL + "\t\t";
  protected final String TEXT_63 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_64 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = "; ";
  protected final String TEXT_69 = NL + "\t\t";
  protected final String TEXT_70 = NL + "    \t\t\tString decryptedPwd_";
  protected final String TEXT_71 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_72 = ");" + NL + "    \t\t";
  protected final String TEXT_73 = NL + "    \t\t\tString decryptedPwd_";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = ";" + NL + "    \t\t";
  protected final String TEXT_76 = NL + "\t\t";
  protected final String TEXT_77 = NL + "\t\torg.talend.salesforceBulk.SforceBulkConnection sforceConn_";
  protected final String TEXT_78 = NL + "\t\t\t= new org.talend.salesforceBulk.SforceBasicBulkConnection.Builder(";
  protected final String TEXT_79 = ",";
  protected final String TEXT_80 = ",decryptedPassword_";
  protected final String TEXT_81 = ",";
  protected final String TEXT_82 = ")" + NL + "\t\t\t\t.needCompression(";
  protected final String TEXT_83 = ").needTraceMessage(";
  protected final String TEXT_84 = ")" + NL + "\t\t\t\t";
  protected final String TEXT_85 = NL + "        \t\t\t.setProxy(true,";
  protected final String TEXT_86 = ",";
  protected final String TEXT_87 = ",";
  protected final String TEXT_88 = ",decryptedPwd_";
  protected final String TEXT_89 = ")" + NL + "        \t\t";
  protected final String TEXT_90 = NL + "\t\t\t\t.build();" + NL + "\t";
  protected final String TEXT_91 = NL;
  protected final String TEXT_92 = NL + "\t";
  protected final String TEXT_93 = NL + "    \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_94 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_95 = ");" + NL + "    \t";
  protected final String TEXT_96 = NL + "    \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_97 = " = ";
  protected final String TEXT_98 = ";" + NL + "    \t";
  protected final String TEXT_99 = NL + "\t\torg.talend.salesforce.SforceConnection sforceConn_";
  protected final String TEXT_100 = NL + "\t\t\t= new org.talend.salesforce.SforceOAuthConnection.Builder(";
  protected final String TEXT_101 = ", ";
  protected final String TEXT_102 = ", decryptedQauthClientPwd_";
  protected final String TEXT_103 = ", ";
  protected final String TEXT_104 = ", ";
  protected final String TEXT_105 = ", ";
  protected final String TEXT_106 = ")" + NL + "\t\t\t\t";
  protected final String TEXT_107 = NL + "    \t\t\t\t.setTokenFilePath(";
  protected final String TEXT_108 = ")" + NL + "\t\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\t.setTimeout(";
  protected final String TEXT_110 = ").needCompression(";
  protected final String TEXT_111 = ")" + NL + "            \t";
  protected final String TEXT_112 = NL + "            \t\t.setClientID(";
  protected final String TEXT_113 = ")" + NL + "            \t";
  protected final String TEXT_114 = NL + "                .useHttpChunked(";
  protected final String TEXT_115 = ")" + NL + "            \t.build();" + NL + "\t";
  protected final String TEXT_116 = NL + "    \t\t\tString decryptedPwd_";
  protected final String TEXT_117 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_118 = ");" + NL + "    \t\t";
  protected final String TEXT_119 = NL + "    \t\t\tString decryptedPwd_";
  protected final String TEXT_120 = " = ";
  protected final String TEXT_121 = ";" + NL + "    \t\t";
  protected final String TEXT_122 = NL + "\t\t    java.util.Properties props_";
  protected final String TEXT_123 = " = System.getProperties();" + NL + "\t\t    props_";
  protected final String TEXT_124 = ".put(\"socksProxyHost\",";
  protected final String TEXT_125 = ");" + NL + "\t\t    props_";
  protected final String TEXT_126 = ".put(\"socksProxyPort\",";
  protected final String TEXT_127 = ");" + NL + "\t\t    props_";
  protected final String TEXT_128 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_129 = ");" + NL + "\t\t    props_";
  protected final String TEXT_130 = ".put(\"java.net.socks.password\", decryptedPwd_";
  protected final String TEXT_131 = ");" + NL + "\t\t";
  protected final String TEXT_132 = NL + NL + "\t\t";
  protected final String TEXT_133 = NL + NL + "\t\t";
  protected final String TEXT_134 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_135 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_138 = " = ";
  protected final String TEXT_139 = "; ";
  protected final String TEXT_140 = NL + NL + "\t\torg.talend.salesforce.SforceConnection sforceConn_";
  protected final String TEXT_141 = NL + "\t\t\t= new org.talend.salesforce.SforceBasicConnection.Builder(";
  protected final String TEXT_142 = ", ";
  protected final String TEXT_143 = ", decryptedPassword_";
  protected final String TEXT_144 = ")" + NL + "\t\t\t\t.setTimeout(";
  protected final String TEXT_145 = ").needCompression(";
  protected final String TEXT_146 = ")" + NL + "            \t";
  protected final String TEXT_147 = NL + "            \t\t.setClientID(";
  protected final String TEXT_148 = ")" + NL + "            \t";
  protected final String TEXT_149 = NL + "                .useHttpChunked(";
  protected final String TEXT_150 = ")" + NL + "            \t.build();" + NL + "\t";
  protected final String TEXT_151 = NL + "globalMap.put(\"conn_";
  protected final String TEXT_152 = "\", sforceConn_";
  protected final String TEXT_153 = ");" + NL;
  protected final String TEXT_154 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_3);
    
            }
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_6);
    for(String message : messages){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
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
        
    stringBuffer.append(TEXT_10);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_13);
    
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
                    
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_17);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_18);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_21);
    
                }   
                
    stringBuffer.append(TEXT_22);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_23);
    
            }
        }
        debug(var("log4jParamters"));
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_24);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_25);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_26);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_29);
    
                }else{
                
    stringBuffer.append(TEXT_30);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_38);
    
                }
                
    stringBuffer.append(TEXT_39);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_40);
    
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

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
log = new LogUtil(node);

String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
String username = ElementParameterParser.getValue(node, "__USER__");

String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
boolean needCompression = ("true").equals(ElementParameterParser.getValue(node,"__NEED_COMPRESSION__"));
boolean useHttpChunked = "true".equals(ElementParameterParser.getValue(node,"__USE_HTTP_CHUNKED__"));
boolean httpTraceMessage = ("true").equals(ElementParameterParser.getValue(node,"__HTTP_TRACEMESSAGE__"));

boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");

boolean bulkConnection = ("true").equals(ElementParameterParser.getValue(node,"__BULK_CONNECTION__"));
String apiVersion = ElementParameterParser.getValue(node,"__API_VERSION__");
String clientID = ElementParameterParser.getValue(node,"__CLIENT_ID__");

    stringBuffer.append(TEXT_41);
    
String passwordFieldName = "";

String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
boolean useOAuth = "OAUTH".equals(loginType);
if(bulkConnection){//TODO: ==> need to investigate set http chunked for bulk connection.

    stringBuffer.append(TEXT_42);
    
	if(useOAuth){
		String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
		String oauthSecret = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_SECRET__");
    	passwordFieldName = "__OAUTH_CLIENT_SECRET__";
    	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_45);
    
    	} else {
    	
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_48);
    
    	}
    	String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
		String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
		String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
		
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(callbackPort);
    stringBuffer.append(TEXT_56);
    
    			if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
    			
    stringBuffer.append(TEXT_57);
    stringBuffer.append(tokenFile);
    stringBuffer.append(TEXT_58);
    
    			}
    			
    stringBuffer.append(TEXT_59);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(httpTraceMessage);
    stringBuffer.append(TEXT_61);
    
	}else{
		passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_62);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_65);
    } else {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    
		if(useProxy){
			passwordFieldName = "__PROXY_PASSWORD__";

			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    		
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_72);
    
    		} else {
    		
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_75);
    
    		}
			
    stringBuffer.append(TEXT_76);
    
		}
		
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(httpTraceMessage);
    stringBuffer.append(TEXT_84);
    
				if(useProxy){
        		
    stringBuffer.append(TEXT_85);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(TalendTextUtils.removeQuotes(proxyPort));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
        		}
				
    stringBuffer.append(TEXT_90);
    
	}
	
    stringBuffer.append(TEXT_91);
    
}else{

    stringBuffer.append(TEXT_92);
    
	if(useOAuth){
		String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
		String oauthSecret = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_SECRET__");
    	passwordFieldName = "__OAUTH_CLIENT_SECRET__";
    	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    	
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_95);
    
    	} else {
    	
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_98);
    
    	}
    	String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
		String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
		String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
    	
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(callbackPort);
    stringBuffer.append(TEXT_106);
    
				if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
				
    stringBuffer.append(TEXT_107);
    stringBuffer.append(tokenFile);
    stringBuffer.append(TEXT_108);
    
				}
				
    stringBuffer.append(TEXT_109);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_111);
    
            	if(clientID != null && !"".equals(clientID) && !"\"\"".equals(clientID)){
            	
    stringBuffer.append(TEXT_112);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_113);
    
            	}
            	
    stringBuffer.append(TEXT_114);
    stringBuffer.append( useHttpChunked );
    stringBuffer.append(TEXT_115);
    
	}else{
		if(useProxy){
			passwordFieldName = "__PROXY_PASSWORD__";

			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    		
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_118);
    
    		} else {
    		
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_121);
    
    		}
			
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
		}
		
    stringBuffer.append(TEXT_132);
    
		passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_133);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_136);
    } else {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_146);
    
            	if(clientID!=null && !"".equals(clientID) && !"\"\"".equals(clientID)){
            	
    stringBuffer.append(TEXT_147);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_148);
    
            	}
            	
    stringBuffer.append(TEXT_149);
    stringBuffer.append( useHttpChunked );
    stringBuffer.append(TEXT_150);
    
	}
	
    
}

    log.info(log.str("Login successful."));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(TEXT_154);
    return stringBuffer.toString();
  }
}
