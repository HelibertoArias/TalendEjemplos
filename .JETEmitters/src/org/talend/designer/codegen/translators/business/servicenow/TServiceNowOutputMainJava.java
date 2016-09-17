package org.talend.designer.codegen.translators.business.servicenow;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TServiceNowOutputMainJava
{
  protected static String nl;
  public static synchronized TServiceNowOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TServiceNowOutputMainJava result = new TServiceNowOutputMainJava();
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
  protected final String TEXT_41 = NL + "\t\t";
  protected final String TEXT_42 = " = null;            " + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\twhetherReject_";
  protected final String TEXT_44 = " = false;" + NL + "\t\t\t\t//Set json" + NL + "\t\t\t\torg.json.JSONObject ";
  protected final String TEXT_45 = "_Payload = new org.json.JSONObject();" + NL + "\t\t\t\torg.json.JSONArray ";
  protected final String TEXT_46 = "_PayloadArray= new org.json.JSONArray();" + NL + "\t\t\t\torg.json.JSONObject ";
  protected final String TEXT_47 = "_SysId = new org.json.JSONObject();" + NL + "\t\t\t\torg.json.JSONObject ";
  protected final String TEXT_48 = "_ob = new org.json.JSONObject();" + NL + "\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\tif(";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = " != null) {//6" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = ";" + NL + "\t\t\t\t\t\t\tfor (int j_";
  protected final String TEXT_56 = " = 0; j_";
  protected final String TEXT_57 = " < dynamic_";
  protected final String TEXT_58 = ".getColumnCount(); j_";
  protected final String TEXT_59 = "++) {" + NL + "                                if (dynamic_";
  protected final String TEXT_60 = ".getColumnValue(j_";
  protected final String TEXT_61 = ") != null) {" + NL + "                                    routines.system.DynamicMetadata metadata_";
  protected final String TEXT_62 = " = dynamic_";
  protected final String TEXT_63 = ".getColumnMetadata(j_";
  protected final String TEXT_64 = ");" + NL + "                                    if (\"sys_id\".equals(metadata_";
  protected final String TEXT_65 = ".getName())) {" + NL + "                                    \t";
  protected final String TEXT_66 = "_SysId.put(metadata_";
  protected final String TEXT_67 = ".getName(), ";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = ".getColumnValue(metadata_";
  protected final String TEXT_70 = ".getName()));" + NL + "                                    } else {" + NL + "                                    \t";
  protected final String TEXT_71 = "_ob.put(metadata_";
  protected final String TEXT_72 = ".getName(), ";
  protected final String TEXT_73 = ".";
  protected final String TEXT_74 = ".getColumnValue(metadata_";
  protected final String TEXT_75 = ".getName()));" + NL + "                                    }" + NL + "                                }" + NL + "                            }" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_77 = "_SysId.put(\"";
  protected final String TEXT_78 = "\", ";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_82 = "_ob.put(\"";
  protected final String TEXT_83 = "\", ";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\t}//6" + NL + "\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\t";
  protected final String TEXT_88 = "_PayloadArray.put(";
  protected final String TEXT_89 = "_ob);" + NL + "\t\t\t\t";
  protected final String TEXT_90 = "_Payload.put(\"data\",";
  protected final String TEXT_91 = "_PayloadArray);" + NL + "\t\t\t\t";
  protected final String TEXT_92 = "log.info(\"";
  protected final String TEXT_93 = " - Payload: '\" + ";
  protected final String TEXT_94 = "_Payload + \"'.\");";
  protected final String TEXT_95 = "globalMap.put(\"";
  protected final String TEXT_96 = "_PAYLOAD\", ";
  protected final String TEXT_97 = "_Payload);";
  protected final String TEXT_98 = NL + "\t\t\t\ttry {//7" + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_99 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_101 = "_httpPost = new org.apache.http.client.methods.HttpPost(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_102 = "_URL + " + NL + "\t\t\t\t\t\t\t\"/api/now/table/\" + " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_103 = NL + "\t\t\t\t\t\t\t);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_104 = "_httpPost.setHeader(\"Accept\", \"application/json\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_105 = "_httpPost.setHeader(\"Content-Type\", \"application/json\");" + NL + "\t//activate Cookie header only if unreliable connection" + NL + "\t\t\t\t\t\t//";
  protected final String TEXT_106 = "_httpPost.setHeader(\"Cookie\", ";
  protected final String TEXT_107 = "_cookie); " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_108 = "_entity = new org.apache.http.entity.StringEntity(";
  protected final String TEXT_109 = "_PayloadArray.get(0).toString());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_110 = "_httpPost.setEntity(";
  protected final String TEXT_111 = "_entity);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_112 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_113 = " - Executing '\" + \"";
  protected final String TEXT_114 = "\".toUpperCase() + \"' request.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_116 = "_response = ";
  protected final String TEXT_117 = "_httpclient.execute(";
  protected final String TEXT_118 = "_httpPost);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_119 = "_responseBody = org.apache.http.util.EntityUtils.toString(";
  protected final String TEXT_120 = "_response.getEntity());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_121 = "_responseCode = ";
  protected final String TEXT_122 = "_response.getStatusLine().getStatusCode();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_123 = "_jsonResponse = new org.json.JSONObject(";
  protected final String TEXT_124 = "_responseBody);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_126 = "_httpPut = new org.apache.http.client.methods.HttpPut(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_127 = "_URL + " + NL + "\t\t\t\t\t\t\t\"/api/now/table/\" + " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_128 = " + " + NL + "\t\t\t\t\t\t\t\"/\" + " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_129 = "_SysId.get(\"sys_id\")" + NL + "\t\t\t\t\t\t\t);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_130 = "_httpPut.setHeader(\"Accept\", \"application/json\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_131 = "_httpPut.setHeader(\"Content-Type\", \"application/json\");" + NL + "\t//activate Cookie header only if unreliable connection " + NL + "\t\t\t\t\t\t//";
  protected final String TEXT_132 = "_httpPut.setHeader(\"Cookie\", ";
  protected final String TEXT_133 = "_cookie);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_134 = "_entity = new org.apache.http.entity.StringEntity(";
  protected final String TEXT_135 = "_PayloadArray.get(0).toString());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_136 = "_httpPut.setEntity(";
  protected final String TEXT_137 = "_entity);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_139 = " - Executing '\" + \"";
  protected final String TEXT_140 = "\".toUpperCase() + \"' request.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_142 = "_response = ";
  protected final String TEXT_143 = "_httpclient.execute(";
  protected final String TEXT_144 = "_httpPut);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_145 = "_responseBody = org.apache.http.util.EntityUtils.toString(";
  protected final String TEXT_146 = "_response.getEntity());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_147 = "_responseCode = ";
  protected final String TEXT_148 = "_response.getStatusLine().getStatusCode();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_149 = "_jsonResponse = new org.json.JSONObject(";
  protected final String TEXT_150 = "_responseBody);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_151 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_152 = "_responseCode != 201) {" + NL + "\t\t\t\t\t\t\tnb_line_rejected_";
  protected final String TEXT_153 = "++;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_154 = "_response.close();" + NL + "\t\t\t\t\t\t\tthrow new org.apache.http.HttpException(";
  protected final String TEXT_155 = "_jsonResponse.getJSONObject(\"error\").getString(\"message\"));" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tnb_line_inserted_";
  protected final String TEXT_156 = "++;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_157 = NL + "\t\t\t\t\t\tif(";
  protected final String TEXT_158 = "_responseCode != 200) {" + NL + "\t\t\t\t\t\t\tnb_line_rejected_";
  protected final String TEXT_159 = "++;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_160 = "_response.close();" + NL + "\t\t\t\t\t\t\tthrow new org.apache.http.HttpException(";
  protected final String TEXT_161 = "_jsonResponse.getJSONObject(\"error\").getString(\"message\"));" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tnb_line_update_";
  protected final String TEXT_162 = "++;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_163 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_164 = " - Execution code '\" + ";
  protected final String TEXT_165 = "_responseCode + \"'.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_168 = " - Response: '\" + ";
  protected final String TEXT_169 = "_responseBody + \"'.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_170 = NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_171 = "_RESPONSE\", ";
  protected final String TEXT_172 = "_responseBody);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_173 = NL + "\t\t\t\t\t// ";
  protected final String TEXT_174 = "_response.close();" + NL + "\t\t\t\t} //7" + NL + "\t\t\t\tcatch(java.lang.Exception e_";
  protected final String TEXT_175 = ") {//9" + NL + "\t\t\t\t\twhetherReject_";
  protected final String TEXT_176 = " = true;" + NL + "\t\t\t\t\t";
  protected final String TEXT_177 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_178 = " = new ";
  protected final String TEXT_179 = "Struct();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_180 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_181 = ".";
  protected final String TEXT_182 = " = ";
  protected final String TEXT_183 = ".";
  protected final String TEXT_184 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_186 = ".action = \"";
  protected final String TEXT_187 = "\";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_188 = ".errorCode = Integer.valueOf(";
  protected final String TEXT_189 = "_responseCode).toString();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_190 = ".errorMessage = e_";
  protected final String TEXT_191 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_192 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_193 = NL + NL + NL + "\t\t\t\t\t\tthrow new java.lang.RuntimeException(\"Could not execute \" + e_";
  protected final String TEXT_194 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_195 = NL + "\t\t\t\t}//9" + NL + "\t\t\t\t";
  protected final String TEXT_196 = NL + "\t\t\t\t\tif(!whetherReject_";
  protected final String TEXT_197 = ") {//11" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_198 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_199 = " = new ";
  protected final String TEXT_200 = "Struct();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = " = ";
  protected final String TEXT_204 = ".";
  protected final String TEXT_205 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_206 = NL + "\t\t\t\t\t}//11" + NL + "\t\t\t\t\t";
  protected final String TEXT_207 = NL;
  protected final String TEXT_208 = NL;

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

String tablename = ElementParameterParser.getValue(node, "__TABLENAME__").trim().toLowerCase();
String customTablename = ElementParameterParser.getValue(node, "__CUSTOM_TABLE__").trim().toLowerCase();
tablename = "custom_table".equals(tablename) ? customTablename : "\""+tablename+"\"";

String dataAction = ElementParameterParser.getValue(node,"__ACTION__");
boolean isEnablePayloadDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_PAYLOAD_DEBUG_MODE__"));
boolean isEnableResponseDebug = ("true").equals(ElementParameterParser.getValue(node,"__ENABLE_RESPONSE_DEBUG_MODE__"));

log = new LogUtil(node);
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

String rejectConnName = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
	IConnection rejectConn = rejectConns.get(0);
	rejectConnName = rejectConn.getName();
}
List<IMetadataColumn> rejectColumnList = null;
IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
if(metadataTable != null) {
	rejectColumnList = metadataTable.getListColumns();	    
}

List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
for(IConnection conn : outgoingConns) {
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		
    stringBuffer.append(TEXT_41);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_42);
    
	}
}
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
	IMetadataTable metadata = metadatas.get(0);
	List<IMetadataColumn> columnList = metadata.getListColumns();
	int nbSchemaColumns = columnList.size();
	List< ? extends IConnection> conns = node.getIncomingConnections();
	for(IConnection conn:conns) {//2
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {//3
			String firstConnName = conn.getName();
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
				
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
				for(IMetadataColumn column:columnList) {//5
					
    stringBuffer.append(TEXT_49);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_51);
    
						if("id_Dynamic".equals(column.getTalendType())) {
						
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel());
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
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
						} else if ("sys_id".equals(column.getLabel())) {
						
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_80);
    
						} else {
						
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_85);
    
						}
						
    stringBuffer.append(TEXT_86);
    
				}//5
				
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
				if (isEnablePayloadDebug) {//9
					if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
					}
					
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
				}//9
				
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
					if(("insert").equals(dataAction)) {
						
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(tablename);
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
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_114);
    
						}
						
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
    
					} else {
						
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(tablename);
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
    
						if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_140);
    
						}
						
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
					if("insert".equals(dataAction)) {
						
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
					}
					if("update".equals(dataAction)) {
						
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
    
					}
					if(isLog4jEnabled) {
						
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
					}
					if (isEnableResponseDebug) {
						
    stringBuffer.append(TEXT_166);
    
						if(isLog4jEnabled) {
							
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
						}
						
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
					}
					
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
					if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
						
    stringBuffer.append(TEXT_177);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_179);
    
						for(IMetadataColumn column : columnList) {
							
    stringBuffer.append(TEXT_180);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_184);
    
						}
						
    stringBuffer.append(TEXT_185);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(dataAction);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_192);
    
					} else {
						
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
					}
					
    stringBuffer.append(TEXT_195);
    
				if(outgoingConns != null && outgoingConns.size() > 0) {//10
					
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
						for(IConnection outgoingConn : outgoingConns) {//12
							if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {//13
								if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//14
									
    stringBuffer.append(TEXT_198);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_199);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_200);
    
									for(IMetadataColumn column : columnList) {//15
										
    stringBuffer.append(TEXT_201);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_203);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_205);
     
									}//15
								}//14
							}//13
						}//12
						
    stringBuffer.append(TEXT_206);
    
				}//10
			}//4
		}//3
	}//2
}//1

    stringBuffer.append(TEXT_207);
    stringBuffer.append(TEXT_208);
    return stringBuffer.toString();
  }
}
