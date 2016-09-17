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
import java.util.List;
import java.util.Map;

public class TSalesforceOutputMainJava
{
  protected static String nl;
  public static synchronized TSalesforceOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceOutputMainJava result = new TSalesforceOutputMainJava();
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
  protected final String TEXT_41 = NL;
  protected final String TEXT_42 = NL + "    String decryptedPwd_";
  protected final String TEXT_43 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "    String decryptedPwd_";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = ";";
  protected final String TEXT_48 = NL + "    java.util.Properties props_";
  protected final String TEXT_49 = " = System.getProperties();" + NL + "    props_";
  protected final String TEXT_50 = ".put(\"socksProxyHost\",";
  protected final String TEXT_51 = ");  " + NL + "    props_";
  protected final String TEXT_52 = ".put(\"socksProxyPort\",";
  protected final String TEXT_53 = ");" + NL + "    props_";
  protected final String TEXT_54 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_55 = ");" + NL + "    props_";
  protected final String TEXT_56 = ".put(\"java.net.socks.password\", decryptedPwd_";
  protected final String TEXT_57 = "); " + NL + "    ";
  protected final String TEXT_58 = NL;
  protected final String TEXT_59 = NL + NL + "\t";
  protected final String TEXT_60 = " = null;\t\t\t";
  protected final String TEXT_61 = NL + "///////////////////////\t\t" + NL + "" + NL + "" + NL + "Object[] resultMessageObj_";
  protected final String TEXT_62 = " = null;";
  protected final String TEXT_63 = NL;
  protected final String TEXT_64 = NL + "\t\t\t\tjava.util.List<org.apache.axiom.om.OMElement> list_";
  protected final String TEXT_65 = " = new java.util.ArrayList<org.apache.axiom.om.OMElement>();" + NL + "\t\t\t\t//the null value will be updated or inserted,so we can't treat it as key for updating(only Id can be the key) or upserting(Id,external id or indexed id)" + NL + "\t\t\t\tjava.util.List<String> nullList_";
  protected final String TEXT_66 = " = new java.util.ArrayList<String>();\t\t\t\t";
  protected final String TEXT_67 = NL + "    \t\t\t\t\tsfDynamicUtils_";
  protected final String TEXT_68 = ".extractDynamicColumn(";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = ", list_";
  protected final String TEXT_71 = ",  nullList_";
  protected final String TEXT_72 = ");" + NL + "    \t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\t\t\torg.apache.axiom.om.OMElement reference_";
  protected final String TEXT_74 = "_";
  protected final String TEXT_75 = "_";
  protected final String TEXT_76 = " = fac_";
  protected final String TEXT_77 = ".createOMElement(";
  protected final String TEXT_78 = ", null);" + NL + "\t\t\t\t\t\t\t\treference_";
  protected final String TEXT_79 = "_";
  protected final String TEXT_80 = "_";
  protected final String TEXT_81 = ".addChild(org.talend.salesforce.SforceManagementUtil.newOMElement(\"type\",";
  protected final String TEXT_82 = "));";
  protected final String TEXT_83 = NL + "\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = " != null){" + NL + "\t\t\t\t\t\t\t\t\t\treference_";
  protected final String TEXT_86 = "_";
  protected final String TEXT_87 = "_";
  protected final String TEXT_88 = ".addChild(org.talend.salesforce.SforceManagementUtil.newOMElement(";
  protected final String TEXT_89 = ",FormatterUtils.format_Date(";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = ", ";
  protected final String TEXT_92 = ") ));" + NL + "        \t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_93 = ".add(reference_";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = "_";
  protected final String TEXT_96 = ");" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_97 = NL + "\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = " != null){" + NL + "\t\t\t\t\t\t\t\t\t\treference_";
  protected final String TEXT_100 = "_";
  protected final String TEXT_101 = "_";
  protected final String TEXT_102 = ".addChild(org.talend.salesforce.SforceManagementUtil.newOMElement(";
  protected final String TEXT_103 = ",java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = ")).toString() ));" + NL + "        \t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_106 = ".add(reference_";
  protected final String TEXT_107 = "_";
  protected final String TEXT_108 = "_";
  protected final String TEXT_109 = ");" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_110 = "   \t\t\t\t" + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\t    \t\t\tif(";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = " != null && !\"\".equals(String.valueOf(";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = "))) { " + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t    \t\t\tif(!\"\".equals(String.valueOf(";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = "))) { " + NL + "\t\t\t\t\t    \t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\t\t\t\t\treference_";
  protected final String TEXT_120 = "_";
  protected final String TEXT_121 = "_";
  protected final String TEXT_122 = ".addChild(org.talend.salesforce.SforceManagementUtil.newOMElement(";
  protected final String TEXT_123 = ",String.valueOf(";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = ") ));" + NL + "    \t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_126 = ".add(reference_";
  protected final String TEXT_127 = "_";
  protected final String TEXT_128 = "_";
  protected final String TEXT_129 = ");" + NL + "\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_130 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_131 = ".";
  protected final String TEXT_132 = " != null){" + NL + "\t\t\t\t\t\t\tlist_";
  protected final String TEXT_133 = ".add(org.talend.salesforce.SforceManagementUtil.newOMElement(\"";
  protected final String TEXT_134 = "\",FormatterUtils.format_Date(";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = ", ";
  protected final String TEXT_137 = ") ));" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_138 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_139 = ".";
  protected final String TEXT_140 = " != null){" + NL + "\t\t\t\t\t\t\tlist_";
  protected final String TEXT_141 = ".add(org.talend.salesforce.SforceManagementUtil.newOMElement(\"";
  protected final String TEXT_142 = "\",java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = ")).toString() ));" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_145 = "   \t\t\t\t" + NL + "\t\t    \t\t\t";
  protected final String TEXT_146 = NL + "\t\t    \t\t\tif(";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " != null && !\"\".equals(String.valueOf(";
  protected final String TEXT_149 = ".";
  protected final String TEXT_150 = "))) { " + NL + "\t\t    \t\t\t";
  protected final String TEXT_151 = NL + "\t\t    \t\t\tif(!\"\".equals(String.valueOf(";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = "))) { " + NL + "\t\t    \t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\t\tlist_";
  protected final String TEXT_155 = ".add(org.talend.salesforce.SforceManagementUtil.newOMElement(\"";
  protected final String TEXT_156 = "\",String.valueOf(";
  protected final String TEXT_157 = ".";
  protected final String TEXT_158 = ") ));" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_159 = NL + "\t\t\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\t\t\t    else{" + NL + "\t\t\t\t\t\t\tnullList_";
  protected final String TEXT_161 = ".add(\"";
  protected final String TEXT_162 = "\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_163 = NL + "\t\t\t\t\t\t\t" + NL + " \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_164 = " " + NL + "\t\t\t";
  protected final String TEXT_165 = NL + NL + "resultMessageObj_";
  protected final String TEXT_166 = " = sforceManagement_";
  protected final String TEXT_167 = ".insert(";
  protected final String TEXT_168 = ", (org.apache.axiom.om.OMElement[])list_";
  protected final String TEXT_169 = ".toArray(new org.apache.axiom.om.OMElement[list_";
  protected final String TEXT_170 = ".size()]));    \t\t\t" + NL;
  protected final String TEXT_171 = NL + "resultMessageObj_";
  protected final String TEXT_172 = " = sforceManagement_";
  protected final String TEXT_173 = ".update(";
  protected final String TEXT_174 = ", ";
  protected final String TEXT_175 = ".Id";
  protected final String TEXT_176 = "String.valueOf(";
  protected final String TEXT_177 = ".";
  protected final String TEXT_178 = ".getColumnValue(\"Id\"))";
  protected final String TEXT_179 = ", " + NL + "\t(org.apache.axiom.om.OMElement[])list_";
  protected final String TEXT_180 = ".toArray(new org.apache.axiom.om.OMElement[list_";
  protected final String TEXT_181 = ".size()]),(String[])nullList_";
  protected final String TEXT_182 = ".toArray(new String[nullList_";
  protected final String TEXT_183 = ".size()]));    \t\t\t" + NL;
  protected final String TEXT_184 = " " + NL + "" + NL + "resultMessageObj_";
  protected final String TEXT_185 = " = sforceManagement_";
  protected final String TEXT_186 = ".upsert(";
  protected final String TEXT_187 = ", \"";
  protected final String TEXT_188 = "\", (org.apache.axiom.om.OMElement[])list_";
  protected final String TEXT_189 = ".toArray(new org.apache.axiom.om.OMElement[list_";
  protected final String TEXT_190 = ".size()]),(String[])nullList_";
  protected final String TEXT_191 = ".toArray(new String[nullList_";
  protected final String TEXT_192 = ".size()]));    \t\t\t" + NL;
  protected final String TEXT_193 = NL + "    \t\t\t";
  protected final String TEXT_194 = NL + NL + "resultMessageObj_";
  protected final String TEXT_195 = " = sforceManagement_";
  protected final String TEXT_196 = ".delete(";
  protected final String TEXT_197 = ".Id";
  protected final String TEXT_198 = "String.valueOf(";
  protected final String TEXT_199 = ".";
  protected final String TEXT_200 = ".getColumnValue(\"Id\"))";
  protected final String TEXT_201 = ");    \t\t\t" + NL;
  protected final String TEXT_202 = "     \t\t\t" + NL + "    \t\t\t" + NL + "\t\t\tnb_line_";
  protected final String TEXT_203 = "++;" + NL + "\t\t\t";
  protected final String TEXT_204 = NL + "\t\t\t\tjava.util.Map<String,String> resultMessage_";
  protected final String TEXT_205 = " = sforceManagement_";
  protected final String TEXT_206 = ".readResult(resultMessageObj_";
  protected final String TEXT_207 = ");" + NL + "\t\t\t\tif(resultMessage_";
  protected final String TEXT_208 = "!=null){" + NL + "\t\t\t\t\tif(\"true\".equals(resultMessage_";
  protected final String TEXT_209 = ".get(\"success\"))){" + NL + "\t\t\t\t\t\tnb_success_";
  protected final String TEXT_210 = "++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_211 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_212 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_213 = " = new ";
  protected final String TEXT_214 = "Struct();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_215 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_216 = ".salesforce_id = resultMessage_";
  protected final String TEXT_217 = ".get(\"id\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_218 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_219 = "\t\t\t" + NL + "\t\t    \t\t\t\t\t\t";
  protected final String TEXT_220 = ".";
  protected final String TEXT_221 = " = ";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = ";\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_224 = NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tnb_reject_";
  protected final String TEXT_225 = "++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_226 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_227 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_228 = " = new ";
  protected final String TEXT_229 = "Struct();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_230 = ".errorCode = resultMessage_";
  protected final String TEXT_231 = ".get(\"StatusCode\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_232 = ".errorFields = resultMessage_";
  protected final String TEXT_233 = ".get(\"Fields\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_234 = ".errorMessage = resultMessage_";
  protected final String TEXT_235 = ".get(\"Message\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_236 = "\t\t\t" + NL + "\t\t    \t\t\t\t\t\t";
  protected final String TEXT_237 = ".";
  protected final String TEXT_238 = " = ";
  protected final String TEXT_239 = ".";
  protected final String TEXT_240 = ";\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_241 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_242 = NL + "\t\t\t\tnb_success_";
  protected final String TEXT_243 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_244 = NL + "\t\t\t\t";
  protected final String TEXT_245 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_246 = " = new ";
  protected final String TEXT_247 = "Struct();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_248 = "\t\t\t" + NL + "\t\t    \t\t\t\t";
  protected final String TEXT_249 = ".";
  protected final String TEXT_250 = " = ";
  protected final String TEXT_251 = ".";
  protected final String TEXT_252 = ";\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_253 = "\t\t \t" + NL + "\t\t\t";
  protected final String TEXT_254 = "\t\t\t    \t\t\t" + NL + "///////////////////////    \t\t\t";
  protected final String TEXT_255 = NL;

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
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");

String action = ElementParameterParser.getValue(node, "__ACTION__");
String modulename = ElementParameterParser.getValue(node, "__MODULENAME__");

String customModulename = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_NAME__");

boolean retreiveInsertID = ("true").equals(ElementParameterParser.getValue(node, "__RETREIVE_INSERT_ID__"));
boolean extendedInsert = ("true").equals(ElementParameterParser.getValue(node, "__EXTENDINSERT__"));

boolean ignoreNullValue = ("true").equals(ElementParameterParser.getValue(node, "__IGNORE_NULL__"));

//var for upsert(contain upsert by relationship)
String upsertkey = ElementParameterParser.getValue(node, "__UPSERT_KEY_COLUMN__");
List<Map<String, String>> relationshipMappings = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__UPSERT_RELATION__");

    stringBuffer.append(TEXT_41);
    
String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
boolean useOAuth = "OAUTH".equals(loginType);
if(!useOAuth && useProxy){
    String passwordFieldName = "__PROXY_PASSWORD__";
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_44);
    
    } else {
    
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_47);
    
    }

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(proxyUsername );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
}

    stringBuffer.append(TEXT_58);
    
if ("CustomModule".equals(modulename)) {
	//modulename = customModulename; 
	modulename = customModulename;
}else{
	modulename = "\""+modulename+"\"";
}

boolean ceaseForError = ("true").equals(ElementParameterParser.getValue(node, "__CEASE_FOR_ERROR__"));

List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
if(outgoingConns!=null){
	for (int i=0;i<outgoingConns.size();i++) {
    IConnection outgoingConn = outgoingConns.get(i);
    	if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_60);
    
    	}
    }
}
    	
List<? extends IConnection> connsSuccess = node.getOutgoingConnections("MAIN");
List<? extends IConnection> connsReject = node.getOutgoingConnections("REJECT");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	boolean hasDynamic = metadata.isDynamicSchema();
    	boolean isExistIdColumn = false;
    	String dynamicColName = hasDynamic?metadata.getDynamicColumn().getLabel():"";
    	if(!"Id".equals(dynamicColName) && metadata.getColumn("Id")!=null && ("update".equals(action) || "delete".equals(action))){
    		isExistIdColumn = true;
    	}
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    log.debug(log.str("Prepare to " + action + " record "), "(nb_line_" + cid + " + 1)", log.str("."));
    
 if ("insert".equals(action) || "update".equals(action) || "upsert".equals(action)) {//************

    stringBuffer.append(TEXT_63);
      
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
        			
    			for (int i = 0; i < sizeColumns; i++) {//5  			

  			        
    				IMetadataColumn column = columns.get(i);
    				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				
    				if(column.getTalendType().equals("id_Dynamic")){
    				
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
    					continue;
    				}
    				
    				boolean generateFinished = false;
    				if("upsert".equals(action) && (relationshipMappings.size() > 0)) {//TD512
    					int j = 0;
						for(Map<String,String> row : relationshipMappings) {
							String columnName = row.get("COLUMN_NAME");
							if(columnName.equals(column.getLabel())) {
								j++;
								String loookupFieldName = row.get("LOOKUP_FIELD_NAME");
								String externalIdFromLookupField = row.get("LOOKUP_FIELD_EXTERNAL_ID_NAME");
								String moduleNameOfLookupField = row.get("LOOKUP_FIELD_MODULE_NAME");
								generateFinished = true;

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(loookupFieldName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(moduleNameOfLookupField);
    stringBuffer.append(TEXT_82);
    
								if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(externalIdFromLookupField );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_96);
    
								} else if (javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(externalIdFromLookupField );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_109);
    
								} else {//TD1024

    stringBuffer.append(TEXT_110);
    if(!isPrimitive) {
    stringBuffer.append(TEXT_111);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_115);
    }else{
    stringBuffer.append(TEXT_116);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(externalIdFromLookupField );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_129);
    
								}////TD1024
							}
						}
    				}//TD512
    				
    				//make sure to filter the schema "Id", when updating (but not when upserting)
  			        if(("Id".equals(column.getLabel()) && (!("upsert".equals(action)) || ("upsert".equals(action) && !"Id".equals(upsertkey)))) || generateFinished) continue;
    				
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_130);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_137);
    				
					} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_138);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_144);
    				
					} else {//others
						

    stringBuffer.append(TEXT_145);
    if(!isPrimitive) {
    stringBuffer.append(TEXT_146);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_150);
    }else{
    stringBuffer.append(TEXT_151);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_158);
    				
					}

    stringBuffer.append(TEXT_159);
    if(!ignoreNullValue && !(("Id".equals(column.getLabel()) || upsertkey.equals(column.getLabel())) && ("upsert".equals(action)))){
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    
				}//5	

    stringBuffer.append(TEXT_164);
    
 if ("insert".equals(action)) {//#######

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    
	} else if ("update".equals(action)) {//#######

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_174);
    if(!hasDynamic || isExistIdColumn){
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_175);
    }else{
    stringBuffer.append(TEXT_176);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(dynamicColName );
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
    } else if ("upsert".equals(action)) {//#######

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(upsertkey);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    
    }//#######

    stringBuffer.append(TEXT_193);
    
	} else if ("delete".equals(action)) {//*************	

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    if(!hasDynamic || isExistIdColumn){
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_197);
    }else{
    stringBuffer.append(TEXT_198);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(dynamicColName );
    stringBuffer.append(TEXT_200);
    }
    stringBuffer.append(TEXT_201);
    
  }//************

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    
			if(!extendedInsert){ 
			
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    log.debug(log.str("Has " + logHelper.toPastTense(action) + " record "), log.var("nb_line"), log.str(" successfully."));
    stringBuffer.append(TEXT_211);
    
						if (connsSuccess != null && connsSuccess.size() == 1) {
							IConnection connSuccess = connsSuccess.get(0);
							if (connSuccess.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							
    stringBuffer.append(TEXT_212);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_214);
    
								if(retreiveInsertID&&"insert".equals(action)){
								
    stringBuffer.append(TEXT_215);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
								}
								
    stringBuffer.append(TEXT_218);
    
								for (IMetadataColumn column: metadata.getListColumns()) {
								
    stringBuffer.append(TEXT_219);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_223);
    					 
								}
							}
						}
						
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    log.debug(log.str("Failed to " + action + " record "), log.var("nb_line"), log.str("."));
    stringBuffer.append(TEXT_226);
    
						if (connsReject != null && connsReject.size() == 1) {
							IConnection connReject = connsReject.get(0);
							if (connReject.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							
    stringBuffer.append(TEXT_227);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    
								for (IMetadataColumn column: metadata.getListColumns()) {
								
    stringBuffer.append(TEXT_236);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_240);
    					 
								}
							}
						}
						
    stringBuffer.append(TEXT_241);
    
			}else{//batch start
			
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    log.debug(log.str(logHelper.upperFirstChar(logHelper.toPastTense(action)) + " record "), log.var("nb_line"), log.str(" to batch."));
    stringBuffer.append(TEXT_244);
    
				if (connsSuccess != null && connsSuccess.size() == 1) {
					IConnection connSuccess = connsSuccess.get(0);
					if (connSuccess.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					
    stringBuffer.append(TEXT_245);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_247);
    
						for (IMetadataColumn column: metadata.getListColumns()) {
						
    stringBuffer.append(TEXT_248);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_252);
    					 
						}
					}
				}
				
    stringBuffer.append(TEXT_253);
    
			}  //batch end
			
    stringBuffer.append(TEXT_254);
    
    		}//4
    	}//3
    }//2
}//1


    stringBuffer.append(TEXT_255);
    return stringBuffer.toString();
  }
}
