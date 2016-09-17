package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.Map;

public class TMDMViewSearchBeginJava
{
  protected static String nl;
  public static synchronized TMDMViewSearchBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMViewSearchBeginJava result = new TMDMViewSearchBeginJava();
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
  protected final String TEXT_41 = "       " + NL + "\t\t\t\tint nb_line_";
  protected final String TEXT_42 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t    ";
  protected final String TEXT_44 = NL + NL + "\t\t\t\t\tString murl = ";
  protected final String TEXT_45 = ";" + NL + "\t\t\t\t\tif(murl.endsWith(\"?wsdl\")) {" + NL + "\t\t\t\t\t   murl = murl.substring(0, murl.length() - 5);" + NL + "\t\t\t\t\t}" + NL + "                    " + NL + "                    org.talend.mdm.webservice.TMDMService_Service service_service_";
  protected final String TEXT_46 = " = new org.talend.mdm.webservice.TMDMService_Service(null);" + NL + "                    org.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_47 = " = service_service_";
  protected final String TEXT_48 = ".getTMDMPort();" + NL + "                    javax.xml.ws.BindingProvider stub_";
  protected final String TEXT_49 = " = (javax.xml.ws.BindingProvider) service_";
  protected final String TEXT_50 = ";" + NL + "                    stub_";
  protected final String TEXT_51 = ".getRequestContext().put(javax.xml.ws.BindingProvider.SESSION_MAINTAIN_PROPERTY, false);" + NL + "" + NL + "                    java.util.Map<String, Object> context_";
  protected final String TEXT_52 = " = stub_";
  protected final String TEXT_53 = ".getRequestContext();" + NL + "" + NL + "                    context_";
  protected final String TEXT_54 = ".put(javax.xml.ws.BindingProvider.USERNAME_PROPERTY, ";
  protected final String TEXT_55 = ");" + NL + "                    context_";
  protected final String TEXT_56 = ".put(javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY, murl);" + NL + "\t\t\t\t\t";
  protected final String TEXT_57 = NL + "                    ";
  protected final String TEXT_58 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_59 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_62 = " = ";
  protected final String TEXT_63 = "; ";
  protected final String TEXT_64 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tcontext_";
  protected final String TEXT_65 = ".put(javax.xml.ws.BindingProvider.PASSWORD_PROPERTY, decryptedPassword_";
  protected final String TEXT_66 = ");" + NL + "\t\t\t\t\t\t\t\t\t    " + NL + "\t\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\t\torg.talend.mdm.webservice.TMDMService service_";
  protected final String TEXT_68 = " = (org.talend.mdm.webservice.TMDMService)globalMap.get(\"";
  protected final String TEXT_69 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t\t" + NL + "\t\t\t\torg.talend.mdm.webservice.WSDataClusterPK dataCluster_";
  protected final String TEXT_71 = " = new org.talend.mdm.webservice.WSDataClusterPK(";
  protected final String TEXT_72 = " + \"";
  protected final String TEXT_73 = "\");" + NL + "\t\t\t\t" + NL + "\t\t\t\torg.talend.mdm.webservice.WSWhereCondition wc_";
  protected final String TEXT_74 = " = null;" + NL + "\t\t\t\tjava.util.List<org.talend.mdm.webservice.WSWhereItem> conditions_";
  protected final String TEXT_75 = " = new java.util.ArrayList<org.talend.mdm.webservice.WSWhereItem>();" + NL + "\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\twc_";
  protected final String TEXT_77 = " =new org.talend.mdm.webservice.WSWhereCondition(";
  protected final String TEXT_78 = ",org.talend.mdm.webservice.WSWhereOperator.";
  protected final String TEXT_79 = ", ";
  protected final String TEXT_80 = ", false, org.talend.mdm.webservice.WSStringPredicate.";
  protected final String TEXT_81 = ");" + NL + "\t\t\t\t\torg.talend.mdm.webservice.WSWhereItem wsItem_";
  protected final String TEXT_82 = "=new org.talend.mdm.webservice.WSWhereItem(null,wc_";
  protected final String TEXT_83 = ",null);" + NL + "\t\t\t\t\tconditions_";
  protected final String TEXT_84 = ".add(wsItem_";
  protected final String TEXT_85 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\torg.talend.mdm.webservice.WSWhereItem wsItem_";
  protected final String TEXT_87 = " = null;" + NL + "\t\t\t\tif(conditions_";
  protected final String TEXT_88 = ".size() > 0){" + NL + "\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t    org.talend.mdm.webservice.WSWhereAnd whereAnd_";
  protected final String TEXT_90 = " = new org.talend.mdm.webservice.WSWhereAnd(conditions_";
  protected final String TEXT_91 = ");" + NL + "\t\t\t\t\twsItem_";
  protected final String TEXT_92 = " =new org.talend.mdm.webservice.WSWhereItem(whereAnd_";
  protected final String TEXT_93 = ",null,null);" + NL + "\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t    org.talend.mdm.webservice.WSWhereOr whereOr_";
  protected final String TEXT_95 = " = new org.talend.mdm.webservice.WSWhereOr(conditions_";
  protected final String TEXT_96 = "); " + NL + "\t\t\t\t\twsItem_";
  protected final String TEXT_97 = " =new org.talend.mdm.webservice.WSWhereItem(null,null,whereOr_";
  protected final String TEXT_98 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\torg.talend.mdm.webservice.WSViewSearch wsViewSearch_";
  protected final String TEXT_100 = " = null;" + NL + "\t\t\t\t" + NL + "\t\t\t\tint limit_";
  protected final String TEXT_101 = " = ";
  protected final String TEXT_102 = ";" + NL + "\t\t\t\tint recordsPerPage_";
  protected final String TEXT_103 = " = ";
  protected final String TEXT_104 = ";" + NL + "\t\t\t\tint skip_";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = ";" + NL + "\t\t\t\t" + NL + "\t\t\t\tif (skip_";
  protected final String TEXT_107 = " < 0)" + NL + "\t                skip_";
  protected final String TEXT_108 = " = 0;" + NL + "\t" + NL + "\t            if (recordsPerPage_";
  protected final String TEXT_109 = " <= 0)" + NL + "\t                recordsPerPage_";
  protected final String TEXT_110 = " = -1;// read whole records in one time" + NL + "\t" + NL + "\t            if (limit_";
  protected final String TEXT_111 = " <= 0)" + NL + "\t                limit_";
  protected final String TEXT_112 = " = -1;// no limit" + NL + "\t\t\t\t" + NL + "\t            int retrievedCount_";
  protected final String TEXT_113 = " = 0;" + NL + "       \t\t\tint readRecordsSize_";
  protected final String TEXT_114 = " = limit_";
  protected final String TEXT_115 = " == -1 ? recordsPerPage_";
  protected final String TEXT_116 = " : (recordsPerPage_";
  protected final String TEXT_117 = " == -1 ? limit_";
  protected final String TEXT_118 = " : (recordsPerPage_";
  protected final String TEXT_119 = " > limit_";
  protected final String TEXT_120 = " ? limit_";
  protected final String TEXT_121 = NL + "                : recordsPerPage_";
  protected final String TEXT_122 = "));" + NL + "" + NL + "        \t\tboolean continueFlag_";
  protected final String TEXT_123 = " = true;" + NL + "\t\t\t\tint totalCount_";
  protected final String TEXT_124 = " = -1;";
  protected final String TEXT_125 = NL + "        \t\twhile (continueFlag_";
  protected final String TEXT_126 = ") {" + NL + "\t\t\t\t\twsViewSearch_";
  protected final String TEXT_127 = " = new org.talend.mdm.webservice.WSViewSearch();       \t\t\t\t\t                " + NL + "\t                wsViewSearch_";
  protected final String TEXT_128 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_129 = ");" + NL + "\t\t\t\t\twsViewSearch_";
  protected final String TEXT_130 = ".setWsViewPK(new org.talend.mdm.webservice.WSViewPK(";
  protected final String TEXT_131 = "));" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\twsViewSearch_";
  protected final String TEXT_132 = ".setSpellTreshold(";
  protected final String TEXT_133 = ");" + NL + "\t\t\t\t\twsViewSearch_";
  protected final String TEXT_134 = ".setSkip(skip_";
  protected final String TEXT_135 = " + retrievedCount_";
  protected final String TEXT_136 = ");" + NL + "\t\t\t\t\twsViewSearch_";
  protected final String TEXT_137 = ".setMaxItems(readRecordsSize_";
  protected final String TEXT_138 = ");" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t\t\t\twsViewSearch_";
  protected final String TEXT_140 = ".setOrderBy(";
  protected final String TEXT_141 = "); // OPTIONAL" + NL + "\t\t\t\t\t\twsViewSearch_";
  protected final String TEXT_142 = ".setDirection(\"";
  protected final String TEXT_143 = "\"); // OPTIONAL" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\t\twsViewSearch_";
  protected final String TEXT_145 = ".setWhereItem(wsItem_";
  protected final String TEXT_146 = "); // OPTIONAL\t\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tString[] items_";
  protected final String TEXT_147 = " = service_";
  protected final String TEXT_148 = ".viewSearch(wsViewSearch_";
  protected final String TEXT_149 = ").getStrings().toArray(new String[0]);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif(totalCount_";
  protected final String TEXT_151 = " < 0){" + NL + "\t\t\t\t\t\ttotalCount_";
  protected final String TEXT_152 = " = Integer.valueOf(items_";
  protected final String TEXT_153 = "[0].replaceAll(\"<totalCount>\", \"\").replaceAll(\"</totalCount>\", \"\"));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tretrievedCount_";
  protected final String TEXT_155 = " += items_";
  protected final String TEXT_156 = ".length - 1; // for header" + NL + "\t\t\t\t\tif (totalCount_";
  protected final String TEXT_157 = " == retrievedCount_";
  protected final String TEXT_158 = " || recordsPerPage_";
  protected final String TEXT_159 = " == -1 || items_";
  protected final String TEXT_160 = ".length < readRecordsSize_";
  protected final String TEXT_161 = " || limit_";
  protected final String TEXT_162 = " == retrievedCount_";
  protected final String TEXT_163 = ") {" + NL + "\t                    continueFlag_";
  protected final String TEXT_164 = " = false;" + NL + "\t                } else if (limit_";
  protected final String TEXT_165 = " != -1 && limit_";
  protected final String TEXT_166 = " < retrievedCount_";
  protected final String TEXT_167 = " + readRecordsSize_";
  protected final String TEXT_168 = ") {" + NL + "\t                    readRecordsSize_";
  protected final String TEXT_169 = " = limit_";
  protected final String TEXT_170 = " - retrievedCount_";
  protected final String TEXT_171 = ";" + NL + "\t                }" + NL + "\t\t\t\t" + NL + "\t\t\t\t\tfor(int i_";
  protected final String TEXT_172 = "=1;i_";
  protected final String TEXT_173 = " < items_";
  protected final String TEXT_174 = ".length; i_";
  protected final String TEXT_175 = "++){" + NL + "\t\t\t\t\t\tnb_line_";
  protected final String TEXT_176 = " ++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_177 = ".";
  protected final String TEXT_178 = " = items_";
  protected final String TEXT_179 = "[i_";
  protected final String TEXT_180 = "];\t" + NL + "\t\t\t";

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
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
	
	if (metadata != null) {
	
		List<IMetadataColumn> columnList = metadata.getListColumns();
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		// if output columns are defined
		if (outgoingConns != null && outgoingConns.size() > 0){
		
			IConnection outgoingConn = outgoingConns.get(0);
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // start 1
	
				boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
				String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				String conn = "TMDMService_" + connection;
				String mdmUrl = ElementParameterParser.getValue(node, "__MDMURL__");
				String username = ElementParameterParser.getValue(node, "__USERNAME__");

				//String concept = ElementParameterParser.getValue(node, "__CONCEPT__");
				String xmlField = ElementParameterParser.getValue(node, "__XMLFIELD__");
				
				String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
				boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
				String viewName = ElementParameterParser.getValue(node, "__VIEWNAME__");
				
				List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
				List<Map<String, String>> orders = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ORDER_TABLE__");
				
				String spellThrehold = ElementParameterParser.getValue(node, "__SPELLTHREHOLD__");
				String skip = ElementParameterParser.getValue(node, "__SKIP__");
				String limit = ElementParameterParser.getValue(node, "__MAXVALUE__");
				String bufferSize = ElementParameterParser.getValue(node, "__FETCHSIZE__");
				if(spellThrehold==null || ("").equals(spellThrehold)){
					spellThrehold = "-1";
				}
				if(skip==null || ("").equals(skip)){
					skip = "0";
				}
				
				if(limit==null || ("").equals(limit)){
					limit = "-1";
				}
				
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    if(!useExistingConn){
    stringBuffer.append(TEXT_43);
     logUtil.debug("\"Initializing web service from URL: \"", mdmUrl,"\".\"");
    stringBuffer.append(TEXT_44);
    stringBuffer.append(mdmUrl );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
                    String passwordFieldName = "__PASSWORD__";
                    
    stringBuffer.append(TEXT_57);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_60);
    } else {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    }else{
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(isStaging?"#STAGING":"");
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    
				boolean isOnlyOrPredicate=true;
				for(int i=0; i < operations.size(); i++){
					Map<String, String> map= operations.get(i);
					String xpath=map.get("XPATH");
					String operator=map.get("FUNCTION");
					String value = map.get("VALUE");
					String predicate = map.get("PREDICATE");
					if((i < operations.size()-1) && (!"OR".equals(predicate))){
						isOnlyOrPredicate = false;
					}
					
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(xpath );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(operator );
    stringBuffer.append(TEXT_79);
    stringBuffer.append("EMPTY_NULL".equals(operator)? null:value );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(predicate );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_85);
    
				}//for
				
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    
				if(!isOnlyOrPredicate){
				
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    
				}else{
				
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    
				}
				
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(bufferSize);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(skip);
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
    //For TDI-26039
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
    stringBuffer.append(viewName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(spellThrehold);
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
    
					for(int i=0; i< orders.size(); i++){ // only the first one will be effective.
						Map<String, String> map= orders.get(i);
						
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(map.get("XPATH"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(map.get("ORDER"));
    stringBuffer.append(TEXT_143);
    
						break;
					}
					
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
     logUtil.debug("\"View search executed successfully.\"");
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
     logUtil.info("\"Get item count :\"+totalCount_" + cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(xmlField );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    
			}
		}
	}
}

    return stringBuffer.toString();
  }
}
