package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;

public class TSalesforceBulkExecBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceBulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceBulkExecBeginJava result = new TSalesforceBulkExecBeginJava();
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
  protected final String TEXT_43 = NL + "\tint nb_line_";
  protected final String TEXT_44 = " = 0;" + NL + "    int nb_success_";
  protected final String TEXT_45 = " = 0;" + NL + "    int nb_reject_";
  protected final String TEXT_46 = " = 0;" + NL + "\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "" + NL + "\torg.talend.salesforceBulk.SforceBulkConnection sforceConn_";
  protected final String TEXT_47 = " = null;" + NL + "\t";
  protected final String TEXT_48 = NL + "\t\tif(globalMap.get(\"conn_";
  protected final String TEXT_49 = "\")==null){" + NL + "\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_50 = "\");" + NL + "\t\t}" + NL + "\t\tsforceConn_";
  protected final String TEXT_51 = " = (org.talend.salesforceBulk.SforceBulkConnection)globalMap.get(\"conn_";
  protected final String TEXT_52 = "\");" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t";
  protected final String TEXT_54 = NL + "        \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_55 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_56 = ");" + NL + "        \t";
  protected final String TEXT_57 = NL + "        \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = ";" + NL + "        \t";
  protected final String TEXT_60 = NL + "    \t\tsforceConn_";
  protected final String TEXT_61 = NL + "        \t\t= new org.talend.salesforceBulk.SforceOAuthBulkConnection.Builder(";
  protected final String TEXT_62 = ", ";
  protected final String TEXT_63 = ", decryptedQauthClientPwd_";
  protected final String TEXT_64 = ", ";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ")" + NL + "        \t\t\t";
  protected final String TEXT_68 = NL + "        \t\t\t\t.setTokenFilePath(";
  protected final String TEXT_69 = ")" + NL + "        \t\t\t";
  protected final String TEXT_70 = NL + "        \t\t\t.build();" + NL + "\t\t";
  protected final String TEXT_71 = NL + NL + "\t\t\t";
  protected final String TEXT_72 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_73 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = "; ";
  protected final String TEXT_78 = NL + "\t\t\t";
  protected final String TEXT_79 = NL + "        \t\t\tString decryptedPwd_";
  protected final String TEXT_80 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_81 = ");" + NL + "        \t\t";
  protected final String TEXT_82 = NL + "        \t\t\tString decryptedPwd_";
  protected final String TEXT_83 = " = ";
  protected final String TEXT_84 = ";" + NL + "        \t\t";
  protected final String TEXT_85 = NL + "    \t\t";
  protected final String TEXT_86 = NL + "\t\t\tsforceConn_";
  protected final String TEXT_87 = NL + "    \t\t\t= new org.talend.salesforceBulk.SforceBasicBulkConnection.Builder(";
  protected final String TEXT_88 = ",";
  protected final String TEXT_89 = ",decryptedPassword_";
  protected final String TEXT_90 = ",";
  protected final String TEXT_91 = ")" + NL + "    \t\t\t\t";
  protected final String TEXT_92 = NL + "            \t\t\t.setProxy(true,";
  protected final String TEXT_93 = ",";
  protected final String TEXT_94 = ",";
  protected final String TEXT_95 = ",decryptedPwd_";
  protected final String TEXT_96 = ")" + NL + "            \t\t";
  protected final String TEXT_97 = NL + "    \t\t\t\t.build();" + NL + "\t\t";
  protected final String TEXT_98 = NL + "\torg.talend.salesforceBulk.SalesforceBulkAPI\tsforceBulk_";
  protected final String TEXT_99 = " = new org.talend.salesforceBulk.SalesforceBulkAPI(sforceConn_";
  protected final String TEXT_100 = ");" + NL + "\tsforceBulk_";
  protected final String TEXT_101 = ".setConcurrencyMode(\"";
  protected final String TEXT_102 = "\");" + NL + "\tsforceBulk_";
  protected final String TEXT_103 = ".setAwaitTime(";
  protected final String TEXT_104 = ");" + NL + "\t";
  protected final String TEXT_105 = NL + "\tsforceBulk_";
  protected final String TEXT_106 = ".executeBulk(";
  protected final String TEXT_107 = ",\"";
  protected final String TEXT_108 = "\",";
  protected final String TEXT_109 = ",\"";
  protected final String TEXT_110 = "\",";
  protected final String TEXT_111 = ",";
  protected final String TEXT_112 = ",";
  protected final String TEXT_113 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_114 = NL + "\t\t\tint j_";
  protected final String TEXT_115 = "=0;" + NL + "\t\t\tint batchCount_";
  protected final String TEXT_116 = " = sforceBulk_";
  protected final String TEXT_117 = ".getBatchCount();" + NL + "\t\t\tfor(int i = 0; i < batchCount_";
  protected final String TEXT_118 = "; i++){" + NL + "\t\t\t\tjava.util.List<java.util.Map<String,String>> resultListMessage_";
  protected final String TEXT_119 = " = sforceBulk_";
  protected final String TEXT_120 = ".getBatchLog(i);" + NL + "\t\t\t\tfor(java.util.Map<String,String> resultMessage_";
  protected final String TEXT_121 = " : resultListMessage_";
  protected final String TEXT_122 = "){" + NL + "\t\t\t\t\tj_";
  protected final String TEXT_123 = "++;" + NL + "\t\t\t\t \tnb_line_";
  protected final String TEXT_124 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_126 = " = null;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\t\tif(\"true\".equals(resultMessage_";
  protected final String TEXT_128 = ".get(\"Success\"))){" + NL + "\t\t\t\t\t\tnb_success_";
  protected final String TEXT_129 = "++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_130 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_132 = " = new ";
  protected final String TEXT_133 = "Struct();" + NL + "" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_134 = ".salesforce_created = resultMessage_";
  protected final String TEXT_135 = ".get(\"Created\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_136 = ".salesforce_id = resultMessage_";
  protected final String TEXT_137 = ".get(\"Id\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\t\t\t\t\t\tif(\"#N/A\".equals(String.valueOf(resultMessage_";
  protected final String TEXT_139 = ".get(\"";
  protected final String TEXT_140 = "\")))){" + NL + "\t\t\t\t\t\t        \t\tresultMessage_";
  protected final String TEXT_141 = ".put(\"";
  protected final String TEXT_142 = "\",null);" + NL + "\t\t\t\t\t\t        \t}" + NL + "\t\t\t\t\t\t\t\t    ";
  protected final String TEXT_143 = NL + "\t\t\t\t\t\t\t            ";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = " = resultMessage_";
  protected final String TEXT_146 = ".get(\"";
  protected final String TEXT_147 = "\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_148 = NL + "\t\t\t\t\t\t\t            ";
  protected final String TEXT_149 = ".";
  protected final String TEXT_150 = " = ParserUtils.parseTo_Date(resultMessage_";
  protected final String TEXT_151 = ".get(\"";
  protected final String TEXT_152 = "\"), ";
  protected final String TEXT_153 = ");" + NL + "\t\t\t\t\t\t\t        ";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\t\t            ";
  protected final String TEXT_155 = ".";
  protected final String TEXT_156 = " = ParserUtils.parseTo_";
  protected final String TEXT_157 = "(resultMessage_";
  protected final String TEXT_158 = ".get(\"";
  protected final String TEXT_159 = "\"));" + NL + "\t\t\t\t\t\t\t        ";
  protected final String TEXT_160 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = " = ParserUtils.parseTo_";
  protected final String TEXT_163 = "(resultMessage_";
  protected final String TEXT_164 = ".get(\"";
  protected final String TEXT_165 = "\"));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tnb_reject_";
  protected final String TEXT_167 = "++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_168 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_170 = " = new ";
  protected final String TEXT_171 = "Struct();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_172 = ".error = resultMessage_";
  protected final String TEXT_173 = ".get(\"Error\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_174 = NL + "\t\t\t\t\t\t\t\t\tif(\"#N/A\".equals(String.valueOf(resultMessage_";
  protected final String TEXT_175 = ".get(\"";
  protected final String TEXT_176 = "\")))){" + NL + "\t\t\t\t\t\t\t        \tresultMessage_";
  protected final String TEXT_177 = ".put(\"";
  protected final String TEXT_178 = "\", null);" + NL + "\t\t\t\t\t\t\t        }" + NL + "\t\t\t\t\t\t\t\t    ";
  protected final String TEXT_179 = NL + "\t\t\t\t\t\t\t            ";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = " = resultMessage_";
  protected final String TEXT_182 = ".get(\"";
  protected final String TEXT_183 = "\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\t\t            ";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = " = ParserUtils.parseTo_Date(resultMessage_";
  protected final String TEXT_187 = ".get(\"";
  protected final String TEXT_188 = "\"), ";
  protected final String TEXT_189 = ");" + NL + "\t\t\t\t\t\t\t        ";
  protected final String TEXT_190 = NL + "\t\t\t\t\t\t\t            ";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = " = ParserUtils.parseTo_";
  protected final String TEXT_193 = "(resultMessage_";
  protected final String TEXT_194 = ".get(\"";
  protected final String TEXT_195 = "\"));" + NL + "\t\t\t\t\t\t\t        ";
  protected final String TEXT_196 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = " = ParserUtils.parseTo_";
  protected final String TEXT_199 = "(resultMessage_";
  protected final String TEXT_200 = ".get(\"";
  protected final String TEXT_201 = "\"));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_202 = NL + "\t\t\t\t\t\t\tString errorMessage_";
  protected final String TEXT_203 = " = \"Row \"+j_";
  protected final String TEXT_204 = "+\":\"+resultMessage_";
  protected final String TEXT_205 = ".get(\"Error\");" + NL + "\t\t\t\t\t\t\tSystem.err.println(errorMessage_";
  protected final String TEXT_206 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_207 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_208 = NL + "\t\t";
  protected final String TEXT_209 = NL + "}";
  protected final String TEXT_210 = NL;

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

	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
	String apiVersion = ElementParameterParser.getValue(node, "__API_VERSION__");
	String username = ElementParameterParser.getValue(node, "__USER__");


	String sObject = ElementParameterParser.getValue(node, "__MODULENAME__");
	String customModulename = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_NAME__");
	if ("CustomModule".equals(sObject)) {
		//modulename = customModulename;
		sObject = customModulename;
	}else{
		sObject = "\""+sObject+"\"";
	}

	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String externalId = ElementParameterParser.getValue(node, "__UPSERT_KEY_COLUMN__");
	//String contentType = ElementParameterParser.getValue(node, "__CONTENTTYPE__");
	String contentType = "csv";
	String bulkFileName = ElementParameterParser.getValue(node, "__BULKFILENAME__").trim();

	String maxBytes = ElementParameterParser.getValue(node,"__COMMIT_LEVEL_BYTES__");
	String maxRows = ElementParameterParser.getValue(node,"__COMMIT_LEVEL_ROWS__");

	boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
   	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
   	String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
   	String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");

	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");

	String concurrencyMode = ElementParameterParser.getValue(node,"__CONCURRENCY_MODE__");
	String awaitTime = ElementParameterParser.getValue(node,"__AWAIT_TIME__");

	boolean bulkConnection = true; //for tSalesforceOAuth.javajet

	String passwordFieldName = "";

	String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
	boolean useOAuth = "OAUTH".equals(loginType);
	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
	if(useExistingConn){
	
    stringBuffer.append(TEXT_48);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_52);
    log.info(log.str("Use exist connection : " + connection + "."));
    stringBuffer.append(TEXT_53);
    
	}else{
		if(useOAuth){
    		String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
    		String oauthSecret = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_SECRET__");
        	passwordFieldName = "__OAUTH_CLIENT_SECRET__";
        	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
        	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_56);
    
        	} else {
        	
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_59);
    
        	}
        	String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");
    		String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
    		String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
    		
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(callbackPort);
    stringBuffer.append(TEXT_67);
    
        			if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
        			
    stringBuffer.append(TEXT_68);
    stringBuffer.append(tokenFile);
    stringBuffer.append(TEXT_69);
    
        			}
        			
    stringBuffer.append(TEXT_70);
    
		}else{
			passwordFieldName = "__PASS__";
			
    stringBuffer.append(TEXT_71);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_74);
    } else {
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    
			if(useProxy){
    			passwordFieldName = "__PROXY_PASSWORD__";

    			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
        		
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_81);
    
        		} else {
        		
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_84);
    
        		}
    			
    stringBuffer.append(TEXT_85);
    
    		}
			
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_91);
    
    				if(useProxy){
            		
    stringBuffer.append(TEXT_92);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(TalendTextUtils.removeQuotes(proxyPort));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
            		}
    				
    stringBuffer.append(TEXT_97);
    
		}
		log.info(log.str("Login successful."));
	}
	
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(concurrencyMode);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(awaitTime);
    stringBuffer.append(TEXT_104);
    log.info(log.str("Start to " + action + " records in bulk."));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(sObject);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(action);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(externalId);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(contentType);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(bulkFileName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(maxBytes);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(maxRows);
    stringBuffer.append(TEXT_113);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {//1
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {//2
		
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    
					List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
					if(outgoingConns!=null){
						for (int i=0;i<outgoingConns.size();i++) {
					   		IConnection outgoingConn = outgoingConns.get(i);
					    	if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							
    stringBuffer.append(TEXT_125);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_126);
    
					    	}
					    }
					}

					List<? extends IConnection> connsSuccess = node.getOutgoingConnections("MAIN");
					List<? extends IConnection> connsReject = node.getOutgoingConnections("REJECT");
					
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    log.debug(log.str(logHelper.upperFirstChar(action) + " record "), log.var("nb_line"), log.str(" successfully."));
    stringBuffer.append(TEXT_130);
    
						if (connsSuccess != null && connsSuccess.size() == 1) {
							IConnection connSuccess = connsSuccess.get(0);
							if (connSuccess.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							
    stringBuffer.append(TEXT_131);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
								for (IMetadataColumn column: metadata.getListColumns()) {
									String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
									JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
									String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
									
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_142);
    
							        if(javaType == JavaTypesManager.STRING ){
									
    stringBuffer.append(TEXT_143);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_147);
    
							        }else if(javaType == JavaTypesManager.DATE){
							        
    stringBuffer.append(TEXT_148);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_153);
    
							        }else if(JavaTypesManager.isNumberType(javaType)) {
							        
    stringBuffer.append(TEXT_154);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_159);
    
							        }else {
									
    stringBuffer.append(TEXT_160);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_165);
    
									}
								}
							}
						}
						
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    log.debug(log.str("Failed to " + action + " record "), log.var("nb_line"), log.str("."));
    stringBuffer.append(TEXT_168);
    
						if (connsReject != null && connsReject.size() == 1) {
							IConnection connReject = connsReject.get(0);
							if (connReject.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							
    stringBuffer.append(TEXT_169);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
								for (IMetadataColumn column: metadata.getListColumns()) {
									String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
									JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
									String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
									
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_178);
    
							        if(javaType == JavaTypesManager.STRING ){
									
    stringBuffer.append(TEXT_179);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_183);
    
							        }else if(javaType == JavaTypesManager.DATE && pattern != null){
							        
    stringBuffer.append(TEXT_184);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_188);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_189);
    
							        }else if(JavaTypesManager.isNumberType(javaType)) {
							        
    stringBuffer.append(TEXT_190);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_195);
    
							        }else {
									
    stringBuffer.append(TEXT_196);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_201);
    
									}
								}
							}
						}else{
						
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    log.logPrintedException(log.var("errorMessage"));
    stringBuffer.append(TEXT_207);
    
						}
						
    stringBuffer.append(TEXT_208);
    
		}//2
	}//1
	
    stringBuffer.append(TEXT_209);
    stringBuffer.append(TEXT_210);
    return stringBuffer.toString();
  }
}
