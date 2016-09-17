package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TWebServiceMainJava
{
  protected static String nl;
  public static synchronized TWebServiceMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWebServiceMainJava result = new TWebServiceMainJava();
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
  protected final String TEXT_41 = NL + "\t\tinMap_";
  protected final String TEXT_42 = " = new java.util.HashMap<String,Object>();" + NL + "\t\tjava.util.Map<String,Object> paramMap_";
  protected final String TEXT_43 = " = new java.util.HashMap<String,Object>();" + NL + "\t\tObject inputValueObject_";
  protected final String TEXT_44 = ";" + NL + "\t\tjavax.xml.namespace.QName anyTypeQName_";
  protected final String TEXT_45 = ";";
  protected final String TEXT_46 = "\t" + NL + "    \t\t\t\tinputValueObject_";
  protected final String TEXT_47 = " = util_";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = ";";
  protected final String TEXT_50 = "\t" + NL + "\t\t\t\t\tinputValueObject_";
  protected final String TEXT_51 = " = ";
  protected final String TEXT_52 = ";";
  protected final String TEXT_53 = NL + "\t\t\t\tparamMap_";
  protected final String TEXT_54 = ".put(util_";
  protected final String TEXT_55 = ".removePunctuation(\"";
  protected final String TEXT_56 = "\"),inputValueObject_";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\t\tutil_";
  protected final String TEXT_59 = ".resolveInputPath(paramMap_";
  protected final String TEXT_60 = ");" + NL + "\t\tif(!paramMap_";
  protected final String TEXT_61 = ".isEmpty()){" + NL + "\t\t\tinMap_";
  protected final String TEXT_62 = " = org.talend.webservice.helper.map.MapConverter.mapToDeepMap(paramMap_";
  protected final String TEXT_63 = ");" + NL + "\t\t}" + NL + "\t\tif(inMap_";
  protected final String TEXT_64 = ".isEmpty()){" + NL + "\t\t\tinMap_";
  protected final String TEXT_65 = " = null;" + NL + "\t\t}";
  protected final String TEXT_66 = "\t" + NL + "\t java.util.Map<String, Object> results_";
  protected final String TEXT_67 = " = null;" + NL + "\t try{" + NL + "\t \t";
  protected final String TEXT_68 = NL + "\t \tresults_";
  protected final String TEXT_69 = " = serviceInvokerHelper_";
  protected final String TEXT_70 = ".invoke(serviceName_";
  protected final String TEXT_71 = ", portName_";
  protected final String TEXT_72 = ", \"";
  protected final String TEXT_73 = "\", inMap_";
  protected final String TEXT_74 = ");" + NL + "\t \t";
  protected final String TEXT_75 = NL + "\t }catch(java.lang.Exception e){";
  protected final String TEXT_76 = NL + "\t\tthrow(e);";
  protected final String TEXT_77 = NL + "\t\tSystem.err.print(e.getMessage());";
  protected final String TEXT_78 = NL + "\t }";
  protected final String TEXT_79 = "            \t\t" + NL + "\t\t\t\t\tjava.util.Map<String, Object> outMap_";
  protected final String TEXT_80 = "=null;" + NL + "\t\t\t\t\tif(results_";
  protected final String TEXT_81 = "!=null&&!results_";
  protected final String TEXT_82 = ".isEmpty()){" + NL + "\t\t\t\t\t\toutMap_";
  protected final String TEXT_83 = " = org.talend.webservice.helper.map.MapConverter.deepMapToMap(results_";
  protected final String TEXT_84 = ");" + NL + "\t\t\t\t\t}" + NL + "            \t\tjava.util.Map<String,Object> returnValuesMap_";
  protected final String TEXT_85 = " = new java.util.HashMap<String,Object>();" + NL + "            \t\tObject outputValue_";
  protected final String TEXT_86 = ";";
  protected final String TEXT_87 = NL + "\t\t\t\t\toutputValue_";
  protected final String TEXT_88 = " = util_";
  protected final String TEXT_89 = ".normalize(util_";
  protected final String TEXT_90 = ".getValue(outMap_";
  protected final String TEXT_91 = ",util_";
  protected final String TEXT_92 = ".removePunctuation(\"";
  protected final String TEXT_93 = "\")).toString(),\"";
  protected final String TEXT_94 = "\");";
  protected final String TEXT_95 = "    \t\t\t\t" + NL + "        \t\t\toutputValue_";
  protected final String TEXT_96 = " = util_";
  protected final String TEXT_97 = ".denormalize((List)util_";
  protected final String TEXT_98 = ".getValue(outMap_";
  protected final String TEXT_99 = ",util_";
  protected final String TEXT_100 = ".removePunctuation(\"";
  protected final String TEXT_101 = "\")),\"";
  protected final String TEXT_102 = "\");    \t\t\t\t";
  protected final String TEXT_103 = NL + " \t\t\t\t\toutputValue_";
  protected final String TEXT_104 = " = util_";
  protected final String TEXT_105 = ".getValue(outMap_";
  protected final String TEXT_106 = ",util_";
  protected final String TEXT_107 = ".removePunctuation(\"";
  protected final String TEXT_108 = "\"));";
  protected final String TEXT_109 = NL + "\t\t\t\t\treturnValuesMap_";
  protected final String TEXT_110 = ".put(\"";
  protected final String TEXT_111 = "\",outputValue_";
  protected final String TEXT_112 = ");\t\t";
  protected final String TEXT_113 = "\t\t\t\t" + NL + "\t\t\tif(returnValuesMap_";
  protected final String TEXT_114 = "!=null&&!returnValuesMap_";
  protected final String TEXT_115 = ".isEmpty()){";
  protected final String TEXT_116 = NL + NL + "\t\t\t\tif(returnValuesMap_";
  protected final String TEXT_117 = ".get(\"";
  protected final String TEXT_118 = "\")!=null){";
  protected final String TEXT_119 = "\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = " = returnValuesMap_";
  protected final String TEXT_122 = ".get(\"";
  protected final String TEXT_123 = "\").toString();";
  protected final String TEXT_124 = NL + "\t\t\t\t\t";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = " = ParserUtils.parseTo_Date(returnValuesMap_";
  protected final String TEXT_127 = ".get(\"";
  protected final String TEXT_128 = "\").toString(), ";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = NL + "\t\t\t\t\tif(returnValuesMap_";
  protected final String TEXT_131 = ".get(\"";
  protected final String TEXT_132 = "\") instanceof byte[]){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " = (byte[])returnValuesMap_";
  protected final String TEXT_135 = ".get(\"";
  protected final String TEXT_136 = "\");\t" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_137 = ".";
  protected final String TEXT_138 = " = returnValuesMap_";
  protected final String TEXT_139 = ".get(\"";
  protected final String TEXT_140 = "\").toString().getBytes();" + NL + "\t\t\t\t\t}";
  protected final String TEXT_141 = NL + "\t\t\t\t\t";
  protected final String TEXT_142 = ".";
  protected final String TEXT_143 = " = (List<Object>)returnValuesMap_";
  protected final String TEXT_144 = ".get(\"";
  protected final String TEXT_145 = "\");";
  protected final String TEXT_146 = "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " = ParserUtils.parseTo_";
  protected final String TEXT_149 = "(returnValuesMap_";
  protected final String TEXT_150 = ".get(\"";
  protected final String TEXT_151 = "\").toString());\t";
  protected final String TEXT_152 = NL + "\t\t\t\t}else{" + NL + "        \t\t\t";
  protected final String TEXT_153 = ".";
  protected final String TEXT_154 = " = ";
  protected final String TEXT_155 = ";" + NL + "\t\t\t\t}\t";
  protected final String TEXT_156 = "\t\t\t";

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

String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
String methodTemp = ElementParameterParser.getValue(node,"__METHOD__");
String method = methodTemp.indexOf("(")!=-1?methodTemp.substring(0,methodTemp.indexOf("(")):methodTemp;

IConnection inputConn = null;
List<? extends IConnection> incomingConnections = node.getIncomingConnections();
if (incomingConnections != null && !incomingConnections.isEmpty()) {
	for (IConnection conn : incomingConnections) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			inputConn = conn;
			break;
		}
	}
}

    
	List<Map<String, String>> inputParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__INPUT_PARAMS__");
	
	if(inputParams!=null&&!inputParams.isEmpty()){//input params start
    	String expression;
    	String element;
    	String namespace;

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
        
		int elementNum = 0;
		java.util.regex.Pattern normalizePattern = java.util.regex.Pattern.compile("^normalize\\(.*,\".*\"\\)$"); // normalize(row1.col1,";")
        java.util.regex.Pattern denormalizePattern = java.util.regex.Pattern.compile("^denormalize\\(.*,\".*\"\\)$"); // denormalize(row1.col1,";")
		
		for(Map<String,String> inputParam:inputParams){
    		elementNum++;
    		expression = inputParam.get("EXPRESSION");
        	element = inputParam.get("ELEMENT").trim();
			if(expression!=null&&!"".equals(expression)&&element!=null&&!"".equals(element)){
				    		
        		if(normalizePattern.matcher(expression).matches()||denormalizePattern.matcher(expression).matches()){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_49);
        		
        		}else{

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_52);
        		
        		}

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(element);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
			}
    	}

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
    
	}//input params end


    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    log.debug(log.str("Invoking the method " + method + " on "), log.var("serviceName"), log.str("."));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    log.debug(log.str("Invoke the method " + method + " on "), log.var("serviceName"), log.str(" has succeeded."));
    stringBuffer.append(TEXT_75);
    
	 if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_76);
    
	 } else {

    stringBuffer.append(TEXT_77);
    
		log.logPrintedException("e.getMessage()");
	 }

    stringBuffer.append(TEXT_78);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	//IMetadataTable metadata = metadatas.get(0);
	
for(IMetadataTable metadata:metadatas){
		if("OUTPUT".equals(metadata.getTableName())){
	if (metadata != null) {
	
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();			
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
		if(outgoingConns!=null&&outgoingConns.size()>0){
		IConnection outgoingConn = outgoingConns.get(0);
		if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
			if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){

    
				List<Map<String, String>> outputParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__OUTPUT_PARAMS__");	
				if(outputParams!=null){//retrieve start

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
    
            		String realExpression="";
            		String delimiter;
            		java.util.regex.Pattern normalizePattern = java.util.regex.Pattern.compile("^normalize\\(.*,\".*\"\\)$"); // normalize(row1.col1,";")
                    java.util.regex.Pattern denormalizePattern = java.util.regex.Pattern.compile("^denormalize\\(.*,\".*\"\\)$"); // denormalize(row1.col1,";")
            		for(Map<String,String> outputParam:outputParams){
                		String expression = outputParam.get("EXPRESSION").trim();
                		String column = outputParam.get("COLUMN").trim();
                		if(column!=null&&!"".equals(column)){
                    		if(normalizePattern.matcher(expression).matches()){ 
                    			realExpression = expression.substring(expression.indexOf("(")+1,expression.indexOf(",")).trim();
                    			delimiter = expression.substring(expression.indexOf("\"")+1,expression.lastIndexOf("\""));

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
    stringBuffer.append(realExpression);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(delimiter);
    stringBuffer.append(TEXT_94);
    
                    		}else if(denormalizePattern.matcher(expression).matches()){
                    			realExpression = expression.substring(expression.indexOf("(")+1,expression.indexOf(",")).trim();
                    			delimiter = expression.substring(expression.indexOf("\"")+1,expression.lastIndexOf("\""));

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
    stringBuffer.append(realExpression);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(delimiter);
    stringBuffer.append(TEXT_102);
        		
                    		}else{
                    			realExpression=expression.trim();

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(realExpression);
    stringBuffer.append(TEXT_108);
    
    						}

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
                		}
                	}
				}//retrieve end

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
    			for( int i = 0; i < columnList.size(); i++) {
    						
    			IMetadataColumn column = columnList.get(i);
    						
    			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
    							
    			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    							
    			String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_118);
    							
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_119);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_123);
    
					} else if(javaType == JavaTypesManager.DATE) { // Date

    stringBuffer.append(TEXT_124);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_128);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_129);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_140);
    
					} else if(javaType == JavaTypesManager.LIST){	//List

    stringBuffer.append(TEXT_141);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_145);
    
					}else{

    stringBuffer.append(TEXT_146);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_148);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_151);
    
					}

    stringBuffer.append(TEXT_152);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_154);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate,column.getDefault()));
    stringBuffer.append(TEXT_155);
    			
			}	
			
			}
		}
	}
	}}
	}
}

    stringBuffer.append(TEXT_156);
    return stringBuffer.toString();
  }
}
