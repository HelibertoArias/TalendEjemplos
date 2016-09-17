package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TStewardshipTaskOutputMainJava
{
  protected static String nl;
  public static synchronized TStewardshipTaskOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TStewardshipTaskOutputMainJava result = new TStewardshipTaskOutputMainJava();
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
  protected final String TEXT_41 = NL + "\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\tif(!taskFlag_";
  protected final String TEXT_43 = ".equals(";
  protected final String TEXT_44 = ")){" + NL + "\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\tif(targetRecordExisted_";
  protected final String TEXT_46 = "){" + NL + "\t\t\t\t\t\trecord_";
  protected final String TEXT_47 = " = task_";
  protected final String TEXT_48 = ".addTargetRecord();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t    \t\t\trecord_";
  protected final String TEXT_50 = ".addSrcColumn(recordColumn_";
  protected final String TEXT_51 = "_";
  protected final String TEXT_52 = ",recordColumn_";
  protected final String TEXT_53 = "_Value_";
  protected final String TEXT_54 = ",recordColumn_";
  protected final String TEXT_55 = "_Type_";
  protected final String TEXT_56 = ",recordColumn_";
  protected final String TEXT_57 = "_Key_";
  protected final String TEXT_58 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\t\t\ttargetRecordExisted_";
  protected final String TEXT_60 = " = false;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif(tasks_";
  protected final String TEXT_62 = ".getTaskCount()>=";
  protected final String TEXT_63 = "){" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_64 = NL + "\t\t\t\t\t    " + NL + "\t\t\t\t\t\tString content = tasks_";
  protected final String TEXT_65 = ".getTasksAndClear();" + NL + "\t\t\t\t\t\t//System.out.println(content);" + NL + "\t\t\t\t\t\tboolean loadResult_";
  protected final String TEXT_66 = " = taskLoadClient_";
  protected final String TEXT_67 = ".doLoad(content);" + NL + "\t\t\t\t\t\tif(!loadResult_";
  protected final String TEXT_68 = "){" + NL + "\t\t\t\t\t\t    " + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_69 = NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tSystem.err.println(\"An error occured while uploading tasks.\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\telse{" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_70 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_71 = " ++;" + NL + "\t\t\t\t\ttask_";
  protected final String TEXT_72 = " = tasks_";
  protected final String TEXT_73 = ".addTask();" + NL + "\t\t\t\t\ttask_";
  protected final String TEXT_74 = ".setBasicInfo(";
  protected final String TEXT_75 = ",\"";
  protected final String TEXT_76 = "\",";
  protected final String TEXT_77 = ",";
  protected final String TEXT_78 = ",";
  protected final String TEXT_79 = ",";
  protected final String TEXT_80 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\t\ttaskFlag_";
  protected final String TEXT_82 = " = ";
  protected final String TEXT_83 = ";\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t" + NL + "\t\t\t\t\tif(";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = "){" + NL + "\t\t\t\t\t\ttargetRecordExisted_";
  protected final String TEXT_87 = " = true;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t    \t\trecordColumn_";
  protected final String TEXT_89 = "_";
  protected final String TEXT_90 = " = \"";
  protected final String TEXT_91 = "\";" + NL + "\t\t\t\t\t    \t\trecordColumn_";
  protected final String TEXT_92 = "_Value_";
  protected final String TEXT_93 = " = ";
  protected final String TEXT_94 = ";" + NL + "\t\t\t\t\t    \t\trecordColumn_";
  protected final String TEXT_95 = "_Type_";
  protected final String TEXT_96 = " = \"";
  protected final String TEXT_97 = "\";" + NL + "\t\t\t\t\t    \t\trecordColumn_";
  protected final String TEXT_98 = "_Key_";
  protected final String TEXT_99 = " = \"";
  protected final String TEXT_100 = "\";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\trecord_";
  protected final String TEXT_102 = " = task_";
  protected final String TEXT_103 = ".addSourceRecord();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_104 = "\t" + NL + "\t\t\t\t\t\t\trecord_";
  protected final String TEXT_105 = ".setBasicInfo(";
  protected final String TEXT_106 = ",";
  protected final String TEXT_107 = ",";
  protected final String TEXT_108 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\t\t\t\trecord_";
  protected final String TEXT_110 = ".setBasicInfo(";
  protected final String TEXT_111 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_112 = "\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\t\t\t\t    if(";
  protected final String TEXT_114 = "!=null && !\"\".equals(";
  protected final String TEXT_115 = ")){" + NL + "\t\t\t\t\t\t\t    \trecord_";
  protected final String TEXT_116 = ".addExtraInfo(";
  protected final String TEXT_117 = ",";
  protected final String TEXT_118 = ",\"";
  protected final String TEXT_119 = "\");" + NL + "\t\t\t\t\t\t\t    }" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\t\t    \t\trecord_";
  protected final String TEXT_121 = ".addSrcColumn(\"";
  protected final String TEXT_122 = "\",";
  protected final String TEXT_123 = ",\"";
  protected final String TEXT_124 = "\",\"";
  protected final String TEXT_125 = "\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_127 = NL + NL;
  protected final String TEXT_128 = NL;

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
    
	String loopingColumn = ElementParameterParser.getValue(node, "__LOOPING_COLUMN__");
	String maxTaskCount = ElementParameterParser.getValue(node, "__NB_TASKS_PER_COMMIT__");
	String taskName = ElementParameterParser.getValue(node, "__TASKNAME__");
	String type = ElementParameterParser.getValue(node, "__TASKTYPE__");
	String createdBy = ElementParameterParser.getValue(node, "__CREATED_BY__");
	String owner = ElementParameterParser.getValue(node, "__OWNER__");
	String starRanking = ElementParameterParser.getValue(node, "__STAR_RANKING__");
	String tags = ElementParameterParser.getValue(node, "__TAGS__");
	
	String recordType = ElementParameterParser.getValue(node, "__RECORD_TYPE__");
	
	String source = ElementParameterParser.getValue(node, "__SOURCE__");
	String score = ElementParameterParser.getValue(node, "__SCORE__");
	String weights = ElementParameterParser.getValue(node, "__WEIGHTS__");
	
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	List<Map<String, String>> extraInfos = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__EXTRA_INFO__");
	List<Map<String, String>> recordColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__RECORD_COLUMN__");
	
	final String RESOLUTION_TYPE = "1";

	class DataUtil{
		Map<String,String> colTypeMap = new java.util.HashMap<String,String>();
		Map<String,JavaType> colTalendTypeMap = new java.util.HashMap<String,JavaType>();
	    Map<String,Boolean> colKeyMap = new java.util.HashMap<String,Boolean>();
	    Map<String,String> colPatternMap = new java.util.HashMap<String,String>();
		public DataUtil(IMetadataTable metadata){
			List<IMetadataColumn> columns = metadata.getListColumns();
	        int sizeColumns = columns.size();
	        for (int i = 0; i < sizeColumns; i++) {
	        	IMetadataColumn column = columns.get(i);
	        	JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
	        	String typeName;
	        	if(javaType == JavaTypesManager.DATE){
	        		String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
	        		colPatternMap.put(column.getLabel(),patternValue);
	        		typeName = "date";
	        	}else if(javaType == JavaTypesManager.BIGDECIMAL){
	        		typeName = "decimal";
	        	}else{
	        		typeName = JavaTypesManager.getShortNameFromJavaType(javaType).toLowerCase();
	        	}
	        	//JavaTypesManager.getShortNameFromJavaType(javaType)
	        	colTypeMap.put(column.getLabel(),typeName);
	        	colKeyMap.put(column.getLabel(),column.isKey());
	        	colTalendTypeMap.put(column.getLabel(),javaType);
	        }
		}
	    public String getValueExpression(String connName,String columnName){
	    	if(colTalendTypeMap.get(columnName) == JavaTypesManager.DATE){
	    		return "("+connName+"."+columnName+"!=null)?FormatterUtils.format_Date("+connName+"."+columnName+","+colPatternMap.get(columnName)+"):null";
	    	}else{
	    		return "("+connName+"."+columnName+"!=null)?String.valueOf("+connName+"."+columnName+"):null";
	    	}
		}
		public String getColType(String columnName){
			return colTypeMap.get(columnName);
		}
		public String isKey(String columnName){
			return colKeyMap.get(columnName)?"1":"0";
		}
	}

	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {//1
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {//2
	
	    	List< ? extends IConnection> conns = node.getIncomingConnections();
	    	for (IConnection conn : conns) {//3
	    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
	    			DataUtil dataUtil = new DataUtil(metadata);
					
    stringBuffer.append(TEXT_41);
    if(RESOLUTION_TYPE.equals(type)){
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),loopingColumn));
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
						if(recordColumns.size()>0){
							for(Map<String, String> recordColumn:recordColumns){
							
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
							}
						}
						
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
     logUtil.debug("\"Task \"+ (nb_line_"+cid+"+1) + \" was generated.\"");
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(maxTaskCount);
    stringBuffer.append(TEXT_63);
     logUtil.info("\"Uploading \"+ tasks_"+cid+".getTaskCount() + \" tasks...\"");
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
     logUtil.error("\"An error occured while uploading tasks.\"");
    stringBuffer.append(TEXT_69);
     logUtil.info("\"Tasks uploaded successfully.\"");
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(taskName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(type);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(createdBy);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(owner);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(starRanking);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(tags);
    stringBuffer.append(TEXT_80);
    if(RESOLUTION_TYPE.equals(type)){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),loopingColumn));
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(recordType);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
						if(recordColumns.size()>0){
							for(Map<String, String> recordColumn:recordColumns){
							
    stringBuffer.append(TEXT_88);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),recordColumn.get("CONTENT")));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(dataUtil.getColType(recordColumn.get("CONTENT")));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(dataUtil.isKey(recordColumn.get("CONTENT")));
    stringBuffer.append(TEXT_100);
    
							}
						}
						
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    if(RESOLUTION_TYPE.equals(type)){
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),source));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),score));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),weights));
    stringBuffer.append(TEXT_108);
    }else{
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),source));
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    
						if(extraInfos.size()>0){
							for(Map<String, String> extraInfo:extraInfos){
							
    stringBuffer.append(TEXT_113);
    stringBuffer.append(extraInfo.get("TITLE"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(extraInfo.get("TITLE"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(extraInfo.get("TITLE"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(extraInfo.get("INFO"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(extraInfo.get("SCOPE"));
    stringBuffer.append(TEXT_119);
    
							}
						}
						if(recordColumns.size()>0){
							for(Map<String, String> recordColumn:recordColumns){
							
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(recordColumn.get("CONTENT"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(dataUtil.getValueExpression(conn.getName(),recordColumn.get("CONTENT")));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(dataUtil.getColType(recordColumn.get("CONTENT")));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(dataUtil.isKey(recordColumn.get("CONTENT")));
    stringBuffer.append(TEXT_125);
    
							}
						}
						
    stringBuffer.append(TEXT_126);
    
				}//4
			}//3
		}//2
	}//1
	
    stringBuffer.append(TEXT_127);
    stringBuffer.append(TEXT_128);
    return stringBuffer.toString();
  }
}
