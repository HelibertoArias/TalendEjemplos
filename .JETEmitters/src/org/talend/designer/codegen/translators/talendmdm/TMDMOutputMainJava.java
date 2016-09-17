package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;

public class TMDMOutputMainJava
{
  protected static String nl;
  public static synchronized TMDMOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMOutputMainJava result = new TMDMOutputMainJava();
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
  protected final String TEXT_41 = NL + "            ";
  protected final String TEXT_42 = " = null;";
  protected final String TEXT_43 = NL + "      ";
  protected final String TEXT_44 = " = new ";
  protected final String TEXT_45 = "Struct();";
  protected final String TEXT_46 = NL + "      ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " = ";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = ";";
  protected final String TEXT_51 = NL + "      ";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = ".toString();";
  protected final String TEXT_56 = NL + "\t";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = ";";
  protected final String TEXT_61 = NL + "    input_";
  protected final String TEXT_62 = " = ";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = ".toString();" + NL + "" + NL + "    try {" + NL + "\t\t";
  protected final String TEXT_65 = NL + "\t\t    ";
  protected final String TEXT_66 = NL + "            Integer pos = null;" + NL + "            if(!";
  protected final String TEXT_67 = ") {" + NL + "                pos = ";
  protected final String TEXT_68 = ";" + NL + "            }                        " + NL + "            " + NL + "\t\t\torg.talend.mdm.webservice.WSPartialPutItem wsPartialPutItem_";
  protected final String TEXT_69 = " = new org.talend.mdm.webservice.WSPartialPutItem(";
  protected final String TEXT_70 = ",";
  protected final String TEXT_71 = ",";
  protected final String TEXT_72 = ",";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = ", ";
  protected final String TEXT_75 = ",";
  protected final String TEXT_76 = ", ";
  protected final String TEXT_77 = ", pos, input_";
  protected final String TEXT_78 = ");" + NL + "\t\t\twspk_";
  protected final String TEXT_79 = " = service_";
  protected final String TEXT_80 = ".partialPutItem(wsPartialPutItem_";
  protected final String TEXT_81 = ");\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_82 = NL + "\t              \t";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = "= wspk_";
  protected final String TEXT_85 = ".getIds().get(";
  protected final String TEXT_86 = ");" + NL + "\t            ";
  protected final String TEXT_87 = "     " + NL + "            " + NL + "\t\t";
  protected final String TEXT_88 = "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\torg.talend.mdm.webservice.WSPutItem item_";
  protected final String TEXT_89 = " = new org.talend.mdm.webservice.WSPutItem(";
  protected final String TEXT_90 = ", dataCluster_";
  protected final String TEXT_91 = ",dataModel_";
  protected final String TEXT_92 = ",input_";
  protected final String TEXT_93 = ");" + NL + "\t      \t";
  protected final String TEXT_94 = NL + "\t\t        ";
  protected final String TEXT_95 = NL + "\t\t        " + NL + "\t        \torg.talend.mdm.webservice.WSPutItemWithReport itemReport_";
  protected final String TEXT_96 = " = new org.talend.mdm.webservice.WSPutItemWithReport(";
  protected final String TEXT_97 = ", ";
  protected final String TEXT_98 = ", item_";
  protected final String TEXT_99 = ");" + NL + "\t\t" + NL + "\t\t        ";
  protected final String TEXT_100 = NL + "\t\t        \t";
  protected final String TEXT_101 = NL + "\t\t        \t\ttaskIDs_";
  protected final String TEXT_102 = ".add(";
  protected final String TEXT_103 = "); " + NL + "\t\t        \t";
  protected final String TEXT_104 = NL + "\t\t          miList_";
  protected final String TEXT_105 = ".add(itemReport_";
  protected final String TEXT_106 = ");" + NL + "\t\t" + NL + "\t\t          if (miList_";
  protected final String TEXT_107 = ".size() >= ";
  protected final String TEXT_108 = ") {\t\t          \t\t            " + NL + "\t\t            " + NL + "\t\t            org.talend.mdm.webservice.WSPutItemWithReportArray putItemWithReportArray = new org.talend.mdm.webservice.WSPutItemWithReportArray(miList_";
  protected final String TEXT_109 = ");" + NL + "\t\t            wspks_";
  protected final String TEXT_110 = " = service_";
  protected final String TEXT_111 = ".putItemWithReportArray(putItemWithReportArray).getWsItemPK();" + NL + "\t\t            " + NL + "\t\t            ";
  protected final String TEXT_112 = NL + "\t\t            ";
  protected final String TEXT_113 = NL + "\t\t            " + NL + "\t\t            miList_";
  protected final String TEXT_114 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_115 = NL + "\t\t                ";
  protected final String TEXT_116 = NL + "\t\t                " + NL + "\t\t            \tint i2_";
  protected final String TEXT_117 = " = 0;" + NL + "\t\t\t\t\t    for(org.talend.mdm.webservice.WSItemPK wspk2_";
  protected final String TEXT_118 = " : wspks_";
  protected final String TEXT_119 = "){" + NL + "\t\t\t\t\t    " + NL + "\t\t\t\t\t       String compositeId = \"\";" + NL + "\t\t\t\t\t       for(String id:wspk2_";
  protected final String TEXT_120 = ".getIds()) {" + NL + "\t\t\t\t\t           compositeId += id;" + NL + "\t\t\t\t\t       }\t\t\t\t\t       " + NL + "\t\t\t\t\t       " + NL + "\t\t\t\t\t    \twspk2_";
  protected final String TEXT_121 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_122 = ");" + NL + "\t\t\t\t\t    \tservice_";
  protected final String TEXT_123 = ".updateItemMetadata(util_";
  protected final String TEXT_124 = ".makeUpdateMeteItm(taskIDs_";
  protected final String TEXT_125 = ".get(i2_";
  protected final String TEXT_126 = "), wspk2_";
  protected final String TEXT_127 = "));" + NL + "\t\t\t\t\t    \ti2_";
  protected final String TEXT_128 = "++;" + NL + "\t\t\t\t\t    }" + NL + "\t\t\t\t\t    " + NL + "\t\t                ";
  protected final String TEXT_129 = NL + "\t\t            \ttaskIDs_";
  protected final String TEXT_130 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_131 = NL + "\t\t          }" + NL + "\t\t        ";
  protected final String TEXT_132 = NL + "\t\t          ";
  protected final String TEXT_133 = NL + "\t\t          " + NL + "\t\t          wspk_";
  protected final String TEXT_134 = " = service_";
  protected final String TEXT_135 = ".putItemWithReport(itemReport_";
  protected final String TEXT_136 = ");" + NL + "\t\t          " + NL + "\t\t          ";
  protected final String TEXT_137 = NL + "\t\t          " + NL + "\t\t          \t";
  protected final String TEXT_138 = NL + "\t\t          \t   ";
  protected final String TEXT_139 = NL + "\t\t            \tservice_";
  protected final String TEXT_140 = ".updateItemMetadata(util_";
  protected final String TEXT_141 = ". makeUpdateMeteItm(";
  protected final String TEXT_142 = ",wspk_";
  protected final String TEXT_143 = "));" + NL + "\t\t                ";
  protected final String TEXT_144 = NL + "\t\t            ";
  protected final String TEXT_145 = NL + "\t\t        ";
  protected final String TEXT_146 = NL + "\t\t            ";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = "= wspk_";
  protected final String TEXT_149 = ".getIds().get(";
  protected final String TEXT_150 = ");" + NL + "\t\t          ";
  protected final String TEXT_151 = NL + "\t\t          " + NL + "\t\t          ";
  protected final String TEXT_152 = NL + "\t\t          " + NL + "\t\t        ";
  protected final String TEXT_153 = NL + "\t\t        \t\ttaskIDs_";
  protected final String TEXT_154 = ".add(";
  protected final String TEXT_155 = "); " + NL + "\t\t        ";
  protected final String TEXT_156 = NL + "\t\t          miList_";
  protected final String TEXT_157 = ".add(item_";
  protected final String TEXT_158 = ");" + NL + "\t\t" + NL + "\t\t          if (miList_";
  protected final String TEXT_159 = ".size() >= ";
  protected final String TEXT_160 = ") {\t\t            \t\t            " + NL + "\t\t            " + NL + "\t\t            org.talend.mdm.webservice.WSPutItemArray putItemArray = new org.talend.mdm.webservice.WSPutItemArray(miList_";
  protected final String TEXT_161 = ");" + NL + "\t\t            wspks_";
  protected final String TEXT_162 = " = service_";
  protected final String TEXT_163 = ".putItemArray(putItemArray).getWsItemPK();" + NL + "\t\t            " + NL + "\t\t            ";
  protected final String TEXT_164 = NL + "\t\t            ";
  protected final String TEXT_165 = NL + "\t\t            " + NL + "\t\t            miList_";
  protected final String TEXT_166 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_167 = NL + "\t\t            \t";
  protected final String TEXT_168 = NL + "\t\t            \tint i2_";
  protected final String TEXT_169 = " = 0;" + NL + "\t\t\t\t\t    for(org.talend.mdm.webservice.WSItemPK wspk2_";
  protected final String TEXT_170 = " : wspks_";
  protected final String TEXT_171 = "){" + NL + "\t\t\t\t\t        " + NL + "\t\t\t\t\t        String compositeId = \"\";" + NL + "\t\t\t\t\t        for(String id:wspk2_";
  protected final String TEXT_172 = ".getIds()) {" + NL + "\t\t\t\t\t           compositeId += id;" + NL + "\t\t\t\t\t        }\t\t\t\t\t        " + NL + "\t\t\t\t\t        " + NL + "\t\t\t\t\t    \twspk2_";
  protected final String TEXT_173 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_174 = ");" + NL + "\t\t\t\t\t    \tservice_";
  protected final String TEXT_175 = ".updateItemMetadata(util_";
  protected final String TEXT_176 = ".makeUpdateMeteItm(taskIDs_";
  protected final String TEXT_177 = ".get(i2_";
  protected final String TEXT_178 = "), wspk2_";
  protected final String TEXT_179 = "));" + NL + "\t\t\t\t\t    \ti2_";
  protected final String TEXT_180 = "++;" + NL + "\t\t\t\t\t    }" + NL + "\t\t            \t";
  protected final String TEXT_181 = NL + "\t\t            \ttaskIDs_";
  protected final String TEXT_182 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_183 = NL + "\t\t          }" + NL + "\t\t        ";
  protected final String TEXT_184 = NL + "\t\t          ";
  protected final String TEXT_185 = NL + "\t\t          " + NL + "\t\t          wspk_";
  protected final String TEXT_186 = " = service_";
  protected final String TEXT_187 = ".putItem(item_";
  protected final String TEXT_188 = ");" + NL + "\t\t          " + NL + "\t\t          ";
  protected final String TEXT_189 = NL + "\t\t          " + NL + "\t\t\t\t\t";
  protected final String TEXT_190 = NL + "\t\t\t\t\t   ";
  protected final String TEXT_191 = NL + "\t\t\t\t\t   " + NL + "\t\t            \tservice_";
  protected final String TEXT_192 = ".updateItemMetadata(util_";
  protected final String TEXT_193 = ".makeUpdateMeteItm(";
  protected final String TEXT_194 = ",wspk_";
  protected final String TEXT_195 = ")); " + NL + "\t\t            \t" + NL + "\t\t\t\t\t   ";
  protected final String TEXT_196 = NL + "\t\t            ";
  protected final String TEXT_197 = NL + "\t\t          ";
  protected final String TEXT_198 = NL + "\t\t              ";
  protected final String TEXT_199 = ".";
  protected final String TEXT_200 = "= wspk_";
  protected final String TEXT_201 = ".getIds().get(";
  protected final String TEXT_202 = ");" + NL + "\t\t            ";
  protected final String TEXT_203 = NL + "\t    ";
  protected final String TEXT_204 = "  " + NL + "    } catch (java.lang.Exception e) {" + NL + "    \t";
  protected final String TEXT_205 = "        " + NL + "        throw(e);";
  protected final String TEXT_206 = NL + "            ";
  protected final String TEXT_207 = " = null;";
  protected final String TEXT_208 = NL + "          ";
  protected final String TEXT_209 = " = new ";
  protected final String TEXT_210 = "Struct();" + NL + "          " + NL + "          \t";
  protected final String TEXT_211 = NL + "\t\t  ";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = " = ";
  protected final String TEXT_214 = ".";
  protected final String TEXT_215 = ".toString();" + NL + "\t\t\t";
  protected final String TEXT_216 = NL + "\t\t  ";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = " = ";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = ";" + NL + "\t\t   \t";
  protected final String TEXT_221 = NL + "\t\t   \t\t\t\t";
  protected final String TEXT_222 = ".xml = input_";
  protected final String TEXT_223 = ";" + NL + "\t\t   \t\t\t";
  protected final String TEXT_224 = NL + "\t\t   \t\t\t\t";
  protected final String TEXT_225 = ".xml = ";
  protected final String TEXT_226 = ".xml;" + NL + "\t\t   \t\t\t";
  protected final String TEXT_227 = "   " + NL + "\t\t  nb_line_rejected_";
  protected final String TEXT_228 = "++;";
  protected final String TEXT_229 = NL + "          ";
  protected final String TEXT_230 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_231 = ";";
  protected final String TEXT_232 = NL + "          System.err.println(e.getMessage());";
  protected final String TEXT_233 = NL + "    }" + NL + "    nb_line_";
  protected final String TEXT_234 = "++;";
  protected final String TEXT_235 = NL;

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
    
    boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
    
    String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
    boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
    String needCheck = ElementParameterParser.getValue(node,"__ISINVOKE__");
    boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
    String numMassInsert = ElementParameterParser.getValue(node,"__COMMIT_LEVEL__");
    String sourceName = ElementParameterParser.getValue(node,"__SOURCE__");
    boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
    String isUpdate = ElementParameterParser.getValue(node,"__ISUPDATE__");
    List<Map<String,String>> keysReturn = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__RETURN_IDS__");
    
    boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
    boolean isCustom = "true".equals(ElementParameterParser.getValue(node, "__CUSTOM__")); 
    String taskID = ElementParameterParser.getValue(node,"__TASKID__");
    String prevColumn = ElementParameterParser.getValue(node, "__PREV_COLUMN_TASK_ID__");
    
    boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));
    boolean usePartialDelete = ("true").equals(ElementParameterParser.getValue(node,"__PARTIAL_DELETE__"));
    String pivot = ElementParameterParser.getValue(node,"__PIVOT__");
    boolean overwrite = ("true").equals(ElementParameterParser.getValue(node,"__OVERWRITE__"));
    String key = ElementParameterParser.getValue(node,"__KEY__");
    String position = ElementParameterParser.getValue(node,"__POSITION__");
    String dataModel = ElementParameterParser.getValue(node, "__DATAMODEL__");
    String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");
    
    String doc = ElementParameterParser.getValue(node, "__DOCUMENT__");
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    
    if (destination != null && !"".equals(destination)) {
      cid = destination;
    }
    
    if (metadatas != null && metadatas.size()>0) { 
      IMetadataTable metadata = metadatas.get(0);
      if (metadata != null) { 
      
      	List<? extends IConnection> outputConns = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
      	List<IMetadataColumn> inputColumnList = null;
      	List<IMetadataColumn> outputColumnList = null;
      	List<IMetadataColumn> columnList =metadata.getListColumns();
      	
        String rejectConnName = null;
        List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
        List<IMetadataColumn> rejectColumnList = null;
        if (rejectConns != null && rejectConns.size() > 0) {
          IConnection rejectConn = rejectConns.get(0);
          if(rejectConn!=null){
          	rejectConnName = rejectConn.getName();
          	IMetadataTable metadataTable = rejectConn.getMetadataTable();
          	if(metadataTable!=null){
          		rejectColumnList = metadataTable.getListColumns();
          	}
          }
        }
       
        String outConnName = null;
    	String inputConnName = null;
        List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    
        for(IConnection tmpconn : outgoingConns) {
          if (tmpconn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            if(rejectConnName==null || !rejectConnName.equals(tmpconn.getName())){
              outConnName=tmpconn.getName();
    		  IMetadataTable outputMetadata = tmpconn.getMetadataTable();
    		  if(outputMetadata!=null){
    		      outputColumnList = outputMetadata.getListColumns();
    		  }
            }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_42);
    
          }
        }
    	
    	List<? extends IConnection> inputConns = node.getIncomingConnections();
        if (inputConns != null && inputConns.size() > 0) {
          IConnection inputConn = inputConns.get(0);
          if(inputConn!=null){
          	inputConnName = inputConn.getName();
          	IMetadataTable inputMetadata = inputConn.getMetadataTable();
          	if(inputMetadata!=null) {
          		inputColumnList = inputMetadata.getListColumns();
          	}
    	  }
    	}
    
        if (outConnName != null && inputConnName!=null) {
        
    stringBuffer.append(TEXT_43);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_45);
    
        for(IMetadataColumn outputColumn : outputColumnList) {
        	for(IMetadataColumn inputColumn : inputColumnList) {
        		if (outputColumn.getLabel().equals(inputColumn.getLabel())) {
	        		if(doc!=null && doc.equals(outputColumn.getLabel())) {
	        			if("id_Document".equals(outputColumn.getTalendType())) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(doc);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(inputConnName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(doc);
    stringBuffer.append(TEXT_50);
    
        				} else {

    stringBuffer.append(TEXT_51);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(doc);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(inputConnName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(doc);
    stringBuffer.append(TEXT_55);
     
    					}
    				} else { // to those which do not match doc columns

    stringBuffer.append(TEXT_56);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(outputColumn.getLabel());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(inputConnName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(inputColumn.getLabel());
    stringBuffer.append(TEXT_60);
    
    				}
    			} // if input column matches output column
    		} // for input column
    	} // for output column
    }
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(inputConnName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(doc);
    stringBuffer.append(TEXT_64);
    if(usePartialUpdate){ // partial
    stringBuffer.append(TEXT_65);
     logUtil.debug("\"Try to use partial update.\"");
    
			String dataclusterString = "";
    		if(isStaging){
    			dataclusterString = dataCluster + " + \"#STAGING\"";
    		} else {
    			dataclusterString = dataCluster;
    		}

    stringBuffer.append(TEXT_66);
    stringBuffer.append(usePartialDelete );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(position.equals("")?null:position);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dataclusterString );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(dataModel );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(usePartialDelete );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(key.equals("")?null:key);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(overwrite);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(pivot);
    stringBuffer.append(TEXT_75);
    stringBuffer.append( true==isStaging?false:withReport);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(sourceName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
	        if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
	        	for (int i = 0; i < keysReturn.size(); i++){
	            	Map<String,String> map = keysReturn.get(i);
	              	
    stringBuffer.append(TEXT_82);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_86);
    
	            }
	       	}
		   	
    stringBuffer.append(TEXT_87);
    }else{// not partial 
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(isUpdate );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    
		    if (!isStaging && withReport) {
    stringBuffer.append(TEXT_94);
     logUtil.debug("\"Put item with report to MDM server.\"");
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(needCheck );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(sourceName );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    if (isMassInsert) {
    stringBuffer.append(TEXT_100);
    if(addTaskID){
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(isCustom?taskID:inputConnName + "." + prevColumn);
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
     logUtil.debug("\"Put items size:\"+wspks_"+cid+".size()");
    stringBuffer.append(TEXT_112);
     logUtil.debug("\"Successfully put item .\"");
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    if(addTaskID){
    stringBuffer.append(TEXT_115);
     logUtil.debug("\"Attempt to add task id .\"");
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
     logUtil.debug("\"Add task id successfully.\"");
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    } else {
    stringBuffer.append(TEXT_132);
     logUtil.debug("\"Try to put items with report.\"");
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
     logUtil.debug("\"Put items successfully.\"");
    stringBuffer.append(TEXT_137);
    if(addTaskID){
    stringBuffer.append(TEXT_138);
     logUtil.debug("\"Try to add task id.\"");
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(isCustom?taskID:inputConnName + "." + prevColumn);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
     logUtil.debug("\"Add task id successfully.\"");
    stringBuffer.append(TEXT_144);
    }
    stringBuffer.append(TEXT_145);
    
		        }
		
		        if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
		        
		          for (int i = 0; i < keysReturn.size(); i++){
		            Map<String,String> map = keysReturn.get(i);
		            
    stringBuffer.append(TEXT_146);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_150);
    
		          }
		        }
		      } else {
		          
    stringBuffer.append(TEXT_151);
     logUtil.debug("\"Put item to MDM server.\"");
    stringBuffer.append(TEXT_152);
      
		        if (isMassInsert) {
		        	if(addTaskID){
		        
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(isCustom?taskID:inputConnName + "." + prevColumn);
    stringBuffer.append(TEXT_155);
    }
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
     logUtil.debug("\"Put items size:\"+wspks_"+cid+".size()");
    stringBuffer.append(TEXT_164);
     logUtil.debug("\"Put item successfully.\"");
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    if(addTaskID){
    stringBuffer.append(TEXT_167);
     logUtil.debug("\"Attempt to add task id .\"");
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
     logUtil.debug("\"Add task id successfully.\"");
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    }
    stringBuffer.append(TEXT_183);
    
		        } else {
    stringBuffer.append(TEXT_184);
     logUtil.debug("\"Attempt to put item .\"");
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
     logUtil.debug("\"Successfully put item .\"");
    stringBuffer.append(TEXT_189);
    if(addTaskID){
    stringBuffer.append(TEXT_190);
     logUtil.debug("\"Attempt to add task id .\"");
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(isCustom?taskID:inputConnName + "." + prevColumn);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
     logUtil.debug("\"Add task id successfully.\"");
    stringBuffer.append(TEXT_196);
    }
    stringBuffer.append(TEXT_197);
    
		          if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
		            for (int i = 0; i < keysReturn.size(); i++){
		              Map<String,String> map = keysReturn.get(i);
		              
    stringBuffer.append(TEXT_198);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_202);
    
		            }
		          }
		        }
		      }
		      
    stringBuffer.append(TEXT_203);
    }//end partial
    stringBuffer.append(TEXT_204);
     logUtil.error("\"Unexpected error:\"+e.getMessage()");
    if (dieOnError) {
    stringBuffer.append(TEXT_205);
    } else {

        if (rejectConnName != null) {
          if (outConnName != null) {
    stringBuffer.append(TEXT_206);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_207);
    }
    stringBuffer.append(TEXT_208);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_210);
    
            for(IMetadataColumn column : columnList) {
				if (!"xml".equals(column.getLabel()) && !"errorCode".equals(column.getLabel()) && !"errorMessage".equals(column.getLabel())) {
					if(column.getLabel().equals(doc) && "id_String".equals(column.getTalendType())) {
			
    stringBuffer.append(TEXT_211);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_213);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_215);
    
					} else {
			
    stringBuffer.append(TEXT_216);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_220);
    
		   			}
		   		}
		   		if("xml".equals(column.getLabel())){
		   			if("id_String".equals(column.getTalendType())){
		   			
    stringBuffer.append(TEXT_221);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
     
		   			}else{
		   				  
    stringBuffer.append(TEXT_224);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(inputConnName );
    stringBuffer.append(TEXT_226);
    
		   			}
		   		}
			}
			
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_231);
    } else {
    stringBuffer.append(TEXT_232);
    }
      }
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    
  }
}
    stringBuffer.append(TEXT_235);
    return stringBuffer.toString();
  }
}
