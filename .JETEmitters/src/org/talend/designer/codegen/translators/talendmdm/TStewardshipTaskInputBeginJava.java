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

public class TStewardshipTaskInputBeginJava
{
  protected static String nl;
  public static synchronized TStewardshipTaskInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TStewardshipTaskInputBeginJava result = new TStewardshipTaskInputBeginJava();
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
  protected final String TEXT_41 = NL + "\t\t\t\tint nb_line_";
  protected final String TEXT_42 = " = 0;\t" + NL + "                java.net.Authenticator.setDefault(new java.net.Authenticator() {" + NL + "                    protected java.net.PasswordAuthentication getPasswordAuthentication() {" + NL + "                    ";
  protected final String TEXT_43 = NL + "                        ";
  protected final String TEXT_44 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_45 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_48 = " = ";
  protected final String TEXT_49 = "; ";
  protected final String TEXT_50 = NL + "                                " + NL + "                    \treturn new java.net.PasswordAuthentication(";
  protected final String TEXT_51 = ", decryptedPassword_";
  protected final String TEXT_52 = ".toCharArray());" + NL + "                }});" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t" + NL + "\t\t\t\tjava.net.URL wsdlUrl_";
  protected final String TEXT_54 = " = new java.net.URL(";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\torg.talend.datastewardship.server.ws.TDSCWS_Service service_";
  protected final String TEXT_56 = " = new org.talend.datastewardship.server.ws.TDSCWS_Service(wsdlUrl_";
  protected final String TEXT_57 = ");" + NL + "\t\t\t\torg.talend.datastewardship.server.ws.TDSCWS TDSCWS_";
  protected final String TEXT_58 = " = service_";
  protected final String TEXT_59 = ".getTDSCWSImplPort();\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\tString startDateString_";
  protected final String TEXT_60 = " = ";
  protected final String TEXT_61 = ";" + NL + "\t\t\t\tString endDateString_";
  protected final String TEXT_62 = " = ";
  protected final String TEXT_63 = ";" + NL + "\t\t\t\tjavax.xml.datatype.DatatypeFactory factory_";
  protected final String TEXT_64 = " = javax.xml.datatype.DatatypeFactory.newInstance();" + NL + "            \tjavax.xml.datatype.XMLGregorianCalendar startXMLGregorianCalendar_";
  protected final String TEXT_65 = " = null;" + NL + "            \tjavax.xml.datatype.XMLGregorianCalendar endXMLGregorianCalendar_";
  protected final String TEXT_66 = " = null;" + NL + "            \tif(startDateString_";
  protected final String TEXT_67 = "!=null && !startDateString_";
  protected final String TEXT_68 = ".equals(\"\")){" + NL + "            \t\tjava.text.SimpleDateFormat startdf_";
  protected final String TEXT_69 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "\t\t\t\t\tstartdf_";
  protected final String TEXT_70 = ".parse(startDateString_";
  protected final String TEXT_71 = ");" + NL + "\t\t\t\t\tjava.util.Calendar startCal_";
  protected final String TEXT_72 = " = startdf_";
  protected final String TEXT_73 = ".getCalendar();" + NL + "\t\t\t\t\tjava.util.GregorianCalendar startDate_";
  protected final String TEXT_74 = " = (java.util.GregorianCalendar) startCal_";
  protected final String TEXT_75 = ";" + NL + "\t\t\t\t\tstartXMLGregorianCalendar_";
  protected final String TEXT_76 = " = factory_";
  protected final String TEXT_77 = ".newXMLGregorianCalendar(startDate_";
  protected final String TEXT_78 = ");" + NL + "\t\t\t\t}" + NL + "            \tif(endDateString_";
  protected final String TEXT_79 = "!=null && !endDateString_";
  protected final String TEXT_80 = ".equals(\"\")){" + NL + "                \tjava.text.SimpleDateFormat enddf_";
  protected final String TEXT_81 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "                    enddf_";
  protected final String TEXT_82 = ".parse(endDateString_";
  protected final String TEXT_83 = ");" + NL + "                    java.util.Calendar endCal_";
  protected final String TEXT_84 = " = enddf_";
  protected final String TEXT_85 = ".getCalendar();" + NL + "                    java.util.GregorianCalendar endDate_";
  protected final String TEXT_86 = " = (java.util.GregorianCalendar) endCal_";
  protected final String TEXT_87 = ";" + NL + "\t\t\t\t\tendXMLGregorianCalendar_";
  protected final String TEXT_88 = " = factory_";
  protected final String TEXT_89 = ".newXMLGregorianCalendar(endDate_";
  protected final String TEXT_90 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\t" + NL + "\t\t\t\tjava.util.List<net.java.dev.jaxb.array.StringArray> tasksResult_";
  protected final String TEXT_92 = " = TDSCWS_";
  protected final String TEXT_93 = ".searchTasks(";
  protected final String TEXT_94 = ",";
  protected final String TEXT_95 = ",";
  protected final String TEXT_96 = ",startXMLGregorianCalendar_";
  protected final String TEXT_97 = ",endXMLGregorianCalendar_";
  protected final String TEXT_98 = ",";
  protected final String TEXT_99 = ",";
  protected final String TEXT_100 = ",";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\tfor(net.java.dev.jaxb.array.StringArray taskResult_";
  protected final String TEXT_102 = ":tasksResult_";
  protected final String TEXT_103 = "){" + NL + "\t\t\t\t\tjava.util.List<String> taskCols_";
  protected final String TEXT_104 = " = taskResult_";
  protected final String TEXT_105 = ".getItem();" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tjava.util.List<java.util.Map<String,String>> records_";
  protected final String TEXT_106 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "\t\t\t\t\tjava.util.Map<String,String> recordTmp_";
  protected final String TEXT_107 = "  = null;" + NL + "\t\t\t\t\tjava.util.List<net.java.dev.jaxb.array.StringArray> tgtRecord_";
  protected final String TEXT_108 = " = TDSCWS_";
  protected final String TEXT_109 = ".getTgtRecord(taskCols_";
  protected final String TEXT_110 = ".get(0));" + NL + "\t\t\t\t\trecordTmp_";
  protected final String TEXT_111 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\t\t\tif(tgtRecord_";
  protected final String TEXT_112 = " != null){" + NL + "\t\t\t\t\t\trecordTmp_";
  protected final String TEXT_113 = ".put(\"TARGET\",\"true\");" + NL + "\t\t\t\t\t\tfor(net.java.dev.jaxb.array.StringArray tgtCols_";
  protected final String TEXT_114 = ":tgtRecord_";
  protected final String TEXT_115 = "){" + NL + "\t\t\t\t\t\t\tjava.util.List<String> tgtCol_";
  protected final String TEXT_116 = " = tgtCols_";
  protected final String TEXT_117 = ".getItem();" + NL + "\t\t\t\t\t\t\tif(tgtCol_";
  protected final String TEXT_118 = "!=null && !tgtCol_";
  protected final String TEXT_119 = ".isEmpty()){" + NL + "\t\t\t\t\t\t\t\t recordTmp_";
  protected final String TEXT_120 = ".put(tgtCol_";
  protected final String TEXT_121 = ".get(0),tgtCol_";
  protected final String TEXT_122 = ".get(3));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\trecords_";
  protected final String TEXT_123 = ".add(recordTmp_";
  protected final String TEXT_124 = ");// out of if statement is for return task info." + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\t\t\tjava.util.List<net.java.dev.jaxb.array.StringArrayArray> srcRecords_";
  protected final String TEXT_126 = " = TDSCWS_";
  protected final String TEXT_127 = ".getSrcRecord(taskCols_";
  protected final String TEXT_128 = ".get(0));" + NL + "\t\t\t            for (net.java.dev.jaxb.array.StringArrayArray srcRecord_";
  protected final String TEXT_129 = " : srcRecords_";
  protected final String TEXT_130 = ") {" + NL + "\t\t\t                java.util.List<net.java.dev.jaxb.array.StringArray> srcRecordItem_";
  protected final String TEXT_131 = " = srcRecord_";
  protected final String TEXT_132 = ".getItem();" + NL + "\t\t\t                recordTmp_";
  protected final String TEXT_133 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\t\t\t\t\trecordTmp_";
  protected final String TEXT_134 = ".put(\"TARGET\",\"false\");" + NL + "\t\t\t\t\t\t\tString srcRecordName_";
  protected final String TEXT_135 = " = \"\";" + NL + "\t\t\t                for (net.java.dev.jaxb.array.StringArray srcCols_";
  protected final String TEXT_136 = " : srcRecordItem_";
  protected final String TEXT_137 = ") {" + NL + "\t\t\t                    java.util.List<String> srcCol_";
  protected final String TEXT_138 = " = srcCols_";
  protected final String TEXT_139 = ".getItem();" + NL + "\t\t\t                    if(srcCol_";
  protected final String TEXT_140 = "!=null && !srcCol_";
  protected final String TEXT_141 = ".isEmpty()){" + NL + "\t\t\t\t\t\t\t\t\t recordTmp_";
  protected final String TEXT_142 = ".put(srcCol_";
  protected final String TEXT_143 = ".get(0),srcCol_";
  protected final String TEXT_144 = ".get(3));" + NL + "\t\t\t\t\t\t\t\t\t srcRecordName_";
  protected final String TEXT_145 = " = srcCol_";
  protected final String TEXT_146 = ".get(4);" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t                }" + NL + "\t\t\t                recordTmp_";
  protected final String TEXT_147 = ".put(\"SOURCE\",srcRecordName_";
  protected final String TEXT_148 = ");" + NL + "\t\t\t                records_";
  protected final String TEXT_149 = ".add(recordTmp_";
  protected final String TEXT_150 = ");" + NL + "\t\t\t            }" + NL + "\t\t            ";
  protected final String TEXT_151 = NL + "\t\t            for(java.util.Map<String,String> record_";
  protected final String TEXT_152 = " : records_";
  protected final String TEXT_153 = "){" + NL + "\t\t            " + NL + "\t\t                ";
  protected final String TEXT_154 = NL + "\t\t            \t" + NL + "\t\t            \t";
  protected final String TEXT_155 = ".TASK_ID = taskCols_";
  protected final String TEXT_156 = ".get(0);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_157 = ".TASK_TYPE = taskCols_";
  protected final String TEXT_158 = ".get(1);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_159 = ".TASK_CREATEDBY = taskCols_";
  protected final String TEXT_160 = ".get(2);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_161 = ".TASK_CREATEDON = ParserUtils.parseTo_Date(taskCols_";
  protected final String TEXT_162 = ".get(3),\"yyyy-MM-dd HH:mm:ss\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_163 = ".TASK_OWNER = taskCols_";
  protected final String TEXT_164 = ".get(4);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_165 = ".TASK_STATUS = taskCols_";
  protected final String TEXT_166 = ".get(5);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_167 = ".TASK_STARS = Integer.valueOf(taskCols_";
  protected final String TEXT_168 = ".get(6));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_170 = ".TARGET = Boolean.valueOf(record_";
  protected final String TEXT_171 = ".get(\"TARGET\"));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_172 = ".SOURCE = record_";
  protected final String TEXT_173 = ".get(\"SOURCE\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_174 = NL + "\t\t\t\t\t\tnb_line_";
  protected final String TEXT_175 = " ++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_176 = NL + "\t\t\t\t\t\t\t\tif(record_";
  protected final String TEXT_177 = ".get(\"";
  protected final String TEXT_178 = "\")!=null){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_179 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = " = record_";
  protected final String TEXT_182 = ".get(\"";
  protected final String TEXT_183 = "\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = " = ParserUtils.parseTo_Date(record_";
  protected final String TEXT_187 = ".get(\"";
  protected final String TEXT_188 = "\"), ";
  protected final String TEXT_189 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_190 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = " = ParserUtils.parseTo_";
  protected final String TEXT_193 = "(record_";
  protected final String TEXT_194 = ".get(\"";
  protected final String TEXT_195 = "\"));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_196 = NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t    \t\t\t\t";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = " = ";
  protected final String TEXT_199 = ";" + NL + "\t\t\t\t    \t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_200 = NL + "\t\t\t";

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

    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
	
	if (metadata != null) {
	
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();			
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		// if output columns are defined
		if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){

			String url = ElementParameterParser.getValue(node, "__URL__");
			String taskType = ElementParameterParser.getValue(node, "__TASKTYPE__");
			String owner = ElementParameterParser.getValue(node,"__OWNER__");
			String tag = ElementParameterParser.getValue(node, "__TAG__");
			String startDate = ElementParameterParser.getValue(node, "__START_DATETIME__");
			String endDate = ElementParameterParser.getValue(node, "__END_DATETIME__");
			String starRanking = ElementParameterParser.getValue(node, "__STAR_RANKING__");
			String limit = ElementParameterParser.getValue(node,"__LIMIT__");
			String status = ElementParameterParser.getValue(node,"__STATUS__");
			String username = ElementParameterParser.getValue(node, "__USERNAME__");
    		String password = ElementParameterParser.getValue(node, "__PASSWORD__");
			boolean targetRecordOnly = ("true").equals(ElementParameterParser.getValue(node,"__TARGET_RECORD_ONLY__"));
			final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			
			IConnection outgoingConn = outgoingConns.get(0);
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
                        String passwordFieldName = "__PASSWORD__";
                        
    stringBuffer.append(TEXT_43);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_46);
    } else {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
     logUtil.debug("\"Initializing DSC web service from URL: \"", url,"\".\"");
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(url );
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
    stringBuffer.append(startDate.equals("")?null:startDate);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(endDate.equals("")?null:endDate);
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
     logUtil.info("\"Start retrieving tasks.\"");
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(taskType);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(owner.equals("")?null:owner);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(tag.equals("")?null:tag);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(starRanking);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(status.equals("null")?null:"\""+status+"\"");
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    if(!targetRecordOnly){
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    }
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
     logUtil.info("\"Total tasks retrieved \"+ nb_line_"+cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    if(!targetRecordOnly){
    stringBuffer.append(TEXT_169);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
						for( int i = 0; i < columnList.size(); i++) {
							IMetadataColumn column = columnList.get(i);
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
							if(!"TASK_ID".equals(column.getLabel()) 
								&& !"TASK_TYPE".equals(column.getLabel()) 
								&& !"TASK_CREATEDBY".equals(column.getLabel()) 
								&& !"TASK_CREATEDON".equals(column.getLabel()) 
								&& !"TASK_OWNER".equals(column.getLabel()) 
								&& !"TASK_STATUS".equals(column.getLabel()) 
								&& !"TASK_STARS".equals(column.getLabel())
								&& !"TARGET".equals(column.getLabel())
								&& !"SOURCE".equals(column.getLabel())){
								
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_178);
    
									if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object
									
    stringBuffer.append(TEXT_179);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_183);
    
									} else if(javaType == JavaTypesManager.DATE) { // Date
									
    stringBuffer.append(TEXT_184);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_185);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_188);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_189);
    						
									}else{
									
    stringBuffer.append(TEXT_190);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_192);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_195);
    
									}
									
    stringBuffer.append(TEXT_196);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_198);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_199);
    
							}
						}
						
    stringBuffer.append(TEXT_200);
    
			}
		}
	}
}

    return stringBuffer.toString();
  }
}
