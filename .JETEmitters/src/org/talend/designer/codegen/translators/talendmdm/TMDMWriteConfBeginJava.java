package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TMDMWriteConfBeginJava
{
  protected static String nl;
  public static synchronized TMDMWriteConfBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMWriteConfBeginJava result = new TMDMWriteConfBeginJava();
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
  protected final String TEXT_41 = "       " + NL + "int nb_line_";
  protected final String TEXT_42 = " = 0;" + NL + "int nb_line_rejected_";
  protected final String TEXT_43 = " = 0;";
  protected final String TEXT_44 = NL + "\t";
  protected final String TEXT_45 = NL + "\t\tclass Util_";
  protected final String TEXT_46 = "{" + NL + "\t\t\tpublic org.talend.mdm.webservice.WSUpdateMetadataItem makeUpdateMeteItm(String taskID,org.talend.mdm.webservice.WSItemPK wspk){" + NL + "\t\t\t\torg.talend.mdm.webservice.WSUpdateMetadataItem wsUpdateMetadataItem = new org.talend.mdm.webservice.WSUpdateMetadataItem();" + NL + "\t\t        wsUpdateMetadataItem.setTaskId(taskID);" + NL + "\t\t        wsUpdateMetadataItem.setWsItemPK(wspk);" + NL + "\t\t        return wsUpdateMetadataItem;" + NL + "\t\t\t}" + NL + "\t\t\tpublic org.talend.mdm.webservice.WSUpdateMetadataItem[] makeUpdateMeteItms(java.util.List<String> taskIDs,org.talend.mdm.webservice.WSItemPK[] wspks){" + NL + "\t\t\t\tjava.util.List<org.talend.mdm.webservice.WSUpdateMetadataItem> wsUpdateMetadataItems = new java.util.ArrayList<org.talend.mdm.webservice.WSUpdateMetadataItem>();" + NL + "\t\t\t\tint i = 0;" + NL + "\t\t        for(org.talend.mdm.webservice.WSItemPK wspk : wspks){" + NL + "\t\t        \twsUpdateMetadataItems.add(makeUpdateMeteItm(taskIDs.get(i),wspk));" + NL + "\t\t        \ti++;" + NL + "\t\t        }" + NL + "\t\t        return wsUpdateMetadataItems.toArray(new org.talend.mdm.webservice.WSUpdateMetadataItem[wsUpdateMetadataItems.size()]);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tUtil_";
  protected final String TEXT_47 = " util_";
  protected final String TEXT_48 = " = new Util_";
  protected final String TEXT_49 = "();" + NL + "\t";
  protected final String TEXT_50 = NL + "\t";
  protected final String TEXT_51 = NL + "\t\t\tjava.util.List <org.talend.mdm.webservice.WSPutItemWithReport> miList_";
  protected final String TEXT_52 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItemWithReport>();" + NL + "\t";
  protected final String TEXT_53 = NL + "\t\t\tjava.util.List <org.talend.mdm.webservice.WSPutItem> miList_";
  protected final String TEXT_54 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSPutItem>();" + NL + "\t";
  protected final String TEXT_55 = NL + "\t\t\tjava.util.List<String> taskIDs_";
  protected final String TEXT_56 = " = new java.util.ArrayList<String>();" + NL + "\t";
  protected final String TEXT_57 = NL;
  protected final String TEXT_58 = NL + "\t";
  protected final String TEXT_59 = "    " + NL + "    " + NL + "    String murl = ";
  protected final String TEXT_60 = ";" + NL + "    if(murl.endsWith(\"?wsdl\")) {" + NL + "       murl = murl.substring(0, murl.length() - 5);" + NL + "    }" + NL + "    " + NL + "    org.talend.mdm.webservice.TMDMService_Service service_service_";
  protected final String TEXT_61 = " = new org.talend.mdm.webservice.TMDMService_Service(null);" + NL + "    org.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_62 = " = service_service_";
  protected final String TEXT_63 = ".getTMDMPort();" + NL + "    javax.xml.ws.BindingProvider stub_";
  protected final String TEXT_64 = " = (javax.xml.ws.BindingProvider) service_";
  protected final String TEXT_65 = ";" + NL + "    stub_";
  protected final String TEXT_66 = ".getRequestContext().put(javax.xml.ws.BindingProvider.SESSION_MAINTAIN_PROPERTY, false);" + NL + "    " + NL + "    java.util.Map<String, Object> context_";
  protected final String TEXT_67 = " = stub_";
  protected final String TEXT_68 = ".getRequestContext();" + NL + "    context_";
  protected final String TEXT_69 = ".put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, ";
  protected final String TEXT_70 = ");" + NL + "    context_";
  protected final String TEXT_71 = ".put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, murl);" + NL + "    ";
  protected final String TEXT_72 = "    ";
  protected final String TEXT_73 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_74 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = "; ";
  protected final String TEXT_79 = NL + "\t" + NL + "\tcontext_";
  protected final String TEXT_80 = ".put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, decryptedPassword_";
  protected final String TEXT_81 = ");" + NL + "\t    ";
  protected final String TEXT_82 = NL + "\torg.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_83 = " = (org.talend.mdm.webservice.TMDMService)globalMap.get(\"";
  protected final String TEXT_84 = "\");";
  protected final String TEXT_85 = NL + NL + "org.talend.mdm.webservice.WSDataClusterPK dataCluster_";
  protected final String TEXT_86 = " = new org.talend.mdm.webservice.WSDataClusterPK(";
  protected final String TEXT_87 = " + \"";
  protected final String TEXT_88 = "\");" + NL + "org.talend.mdm.webservice.WSDataModelPK dataModel_";
  protected final String TEXT_89 = " = new org.talend.mdm.webservice.WSDataModelPK(";
  protected final String TEXT_90 = ");" + NL + "" + NL + "String input_";
  protected final String TEXT_91 = ";" + NL + "" + NL + "java.util.List<org.talend.mdm.webservice.WSItemPK> wspks_";
  protected final String TEXT_92 = ";" + NL + "org.talend.mdm.webservice.WSItemPK wspk_";
  protected final String TEXT_93 = ";" + NL;
  protected final String TEXT_94 = NL + "\tjava.util.Queue<String> queue_";
  protected final String TEXT_95 = " = new java.util.concurrent.ConcurrentLinkedQueue<String>();" + NL + "\t";
  protected final String TEXT_96 = NL + "\t\tjava.util.List<java.util.Map<String,String>> xmlFlowList_";
  protected final String TEXT_97 = " = java.util.Collections.synchronizedList(new java.util.ArrayList<java.util.Map<String,String>>());" + NL + "\t\tint flowNum_";
  protected final String TEXT_98 = " = 0;" + NL + "\t";
  protected final String TEXT_99 = NL + "\tclass ThreadXMLField_";
  protected final String TEXT_100 = " extends Thread {" + NL + "\t\tjava.util.Queue<String> queue;" + NL + "\t\tjava.util.List<java.util.Map<String,String>> flows;" + NL + "\t\tjava.lang.Exception lastException;" + NL + "\t\tString currentComponent;" + NL + "\t\t" + NL + "\t\tThreadXMLField_";
  protected final String TEXT_101 = "(java.util.Queue q) {" + NL + "\t\t\tthis.queue = q;" + NL + "\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_102 = "\", queue);" + NL + "\t\t\tlastException = null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tThreadXMLField_";
  protected final String TEXT_103 = "(java.util.Queue q, java.util.List<java.util.Map<String,String>> l) {" + NL + "\t\t\tthis.queue = q;" + NL + "\t\t\tthis.flows = l;" + NL + "\t\t\tlastException = null;" + NL + "\t\t\tglobalMap.put(\"queue_";
  protected final String TEXT_104 = "\", queue);" + NL + "\t\t\tglobalMap.put(\"flows_";
  protected final String TEXT_105 = "\", flows);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic java.lang.Exception getLastException() {" + NL + "\t\t\treturn this.lastException;" + NL + "\t\t}" + NL + "\t\tpublic String getCurrentComponent() {" + NL + "\t\t\treturn this.currentComponent;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t@Override" + NL + "\t\tpublic void run() {" + NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_106 = "Process(globalMap);" + NL + "\t\t\t} catch (TalendException te) {" + NL + "\t\t\t\tthis.lastException = te.getException();" + NL + "\t\t\t\tthis.currentComponent = te.getCurrentComponent();" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_107 = "_FINISH\" + (this.queue==null?\"\":this.queue.hashCode()), \"true\");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_108 = NL + "\t\tThreadXMLField_";
  protected final String TEXT_109 = " txf_";
  protected final String TEXT_110 = " = new ThreadXMLField_";
  protected final String TEXT_111 = "(queue_";
  protected final String TEXT_112 = ", xmlFlowList_";
  protected final String TEXT_113 = ");" + NL + "\t";
  protected final String TEXT_114 = NL + "\t\tThreadXMLField_";
  protected final String TEXT_115 = " txf_";
  protected final String TEXT_116 = " = new ThreadXMLField_";
  protected final String TEXT_117 = "(queue_";
  protected final String TEXT_118 = ");" + NL + "\t";
  protected final String TEXT_119 = NL + "\ttxf_";
  protected final String TEXT_120 = ".start();";
  protected final String TEXT_121 = NL + "\t\tjava.util.List<java.util.Map<String,String>> xmlFlowList_";
  protected final String TEXT_122 = " = (java.util.List<java.util.Map<String,String>>)globalMap.get(\"flows_";
  protected final String TEXT_123 = "\");" + NL + "\t\tint flowNum_";
  protected final String TEXT_124 = " = 0;" + NL + "\t";
  protected final String TEXT_125 = NL + "\tjava.util.Queue<String> queue_";
  protected final String TEXT_126 = " = (java.util.Queue<String>) globalMap.get(\"queue_";
  protected final String TEXT_127 = "\"); ";
  protected final String TEXT_128 = NL + "\tString readFinishMarkWithPipeId_";
  protected final String TEXT_129 = " = \"";
  protected final String TEXT_130 = "_FINISH\"+(queue_";
  protected final String TEXT_131 = "==null?\"\":queue_";
  protected final String TEXT_132 = ".hashCode());" + NL + "\twhile(!globalMap.containsKey(readFinishMarkWithPipeId_";
  protected final String TEXT_133 = ") || !queue_";
  protected final String TEXT_134 = ".isEmpty()) { " + NL + "\t\tif (!queue_";
  protected final String TEXT_135 = ".isEmpty()) {";
  protected final String TEXT_136 = NL;

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
	LogUtil logUtil = new LogUtil(node);
	String cid = node.getUniqueName();
	String virtualcid = cid;
	String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
	if(destination!=null && !"".equals(destination)){
		cid = destination;
	}

	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "TMDMService_" + connection;
	String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");

	String dataModel = ElementParameterParser.getValue(node, "__DATAMODEL__");
	String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
	boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
	
	boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
	boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
	
	boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
	boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));
	boolean usePartialDelete = ("true").equals(ElementParameterParser.getValue(node,"__PARTIAL_DELETE__"));
	
	boolean storeFlow = ("true").equals(ElementParameterParser.getValue(node, "__STORE_FLOW__"));
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    if(!usePartialUpdate){
    stringBuffer.append(TEXT_44);
    if(addTaskID){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    if(isMassInsert){
		if(!isStaging && withReport){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    	}else{
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    
		}
		if(addTaskID){
	
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    	
		}
	}
}
    stringBuffer.append(TEXT_57);
    if(!useExistingConn){
    stringBuffer.append(TEXT_58);
     logUtil.debug("\"Initializing web service from URL: \"", mdmUrl,"\".\"");
    stringBuffer.append(TEXT_59);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    
    String passwordFieldName = "__PASSWORD__";
    
    stringBuffer.append(TEXT_72);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_75);
    } else {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    }else{
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(isStaging?"#STAGING":"");
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(dataModel );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    
INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
String virtualSourceCid = sourceNode.getUniqueName();
INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
String startNodeCid = null; 
if(startNode != null){
	startNodeCid = startNode.getUniqueName();
} 
IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){	

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
	if(storeFlow){
	
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
	}
	
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(startNodeCid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_107);
    if(storeFlow){
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
    }else{
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    
}else{
	if(storeFlow){
	
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
	}
	
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_127);
    
}

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(virtualcid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(TEXT_136);
    return stringBuffer.toString();
  }
}
