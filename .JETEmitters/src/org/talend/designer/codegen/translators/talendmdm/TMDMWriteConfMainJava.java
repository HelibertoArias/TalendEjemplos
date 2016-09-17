package org.talend.designer.codegen.translators.talendmdm;

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

public class TMDMWriteConfMainJava
{
  protected static String nl;
  public static synchronized TMDMWriteConfMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMWriteConfMainJava result = new TMDMWriteConfMainJava();
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
  protected final String TEXT_41 = NL + "        ";
  protected final String TEXT_42 = " = null;";
  protected final String TEXT_43 = NL + "      ";
  protected final String TEXT_44 = " = new ";
  protected final String TEXT_45 = "Struct();" + NL + "  \t";
  protected final String TEXT_46 = NL + "\t\t\t";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " = ParserUtils.parseTo_Document(queue_";
  protected final String TEXT_49 = ".peek());" + NL + "\t\t";
  protected final String TEXT_50 = NL + "\t\t\t";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = " = queue_";
  protected final String TEXT_53 = ".peek();" + NL + "\t\t";
  protected final String TEXT_54 = NL + "      \t\tjava.util.Map<String,String> xmlFlow_";
  protected final String TEXT_55 = " = xmlFlowList_";
  protected final String TEXT_56 = ".get(flowNum_";
  protected final String TEXT_57 = ");" + NL + "      \t\tString valueStr_";
  protected final String TEXT_58 = ";" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t \t\t\tvalueStr_";
  protected final String TEXT_60 = " = xmlFlow_";
  protected final String TEXT_61 = ".get(\"";
  protected final String TEXT_62 = "\");" + NL + "\t  \t\t\tif (valueStr_";
  protected final String TEXT_63 = " != null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = " = valueStr_";
  protected final String TEXT_67 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = " = ParserUtils.parseTo_Date(valueStr_";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = " = valueStr_";
  protected final String TEXT_76 = ".getBytes();" + NL + "\t\t\t\t\t";
  protected final String TEXT_77 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = " = ParserUtils.parseTo_";
  protected final String TEXT_80 = "(valueStr_";
  protected final String TEXT_81 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_82 = "\t\t\t" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = ";" + NL + "\t\t\t\t}" + NL + "\t      \t\t";
  protected final String TEXT_86 = NL + "    input_";
  protected final String TEXT_87 = " = queue_";
  protected final String TEXT_88 = ".peek();" + NL + "" + NL + "    try {" + NL + "\t\t";
  protected final String TEXT_89 = NL + "            Integer pos = null;" + NL + "            if(!";
  protected final String TEXT_90 = ") {" + NL + "                pos = ";
  protected final String TEXT_91 = ";" + NL + "            }                        " + NL + "            " + NL + "\t\t\torg.talend.mdm.webservice.WSPartialPutItem wsPartialPutItem_";
  protected final String TEXT_92 = " = new org.talend.mdm.webservice.WSPartialPutItem(";
  protected final String TEXT_93 = ",";
  protected final String TEXT_94 = ",";
  protected final String TEXT_95 = ", ";
  protected final String TEXT_96 = ", ";
  protected final String TEXT_97 = ", ";
  protected final String TEXT_98 = ",";
  protected final String TEXT_99 = ", ";
  protected final String TEXT_100 = ",pos, input_";
  protected final String TEXT_101 = ");" + NL + "\t\t\twspk_";
  protected final String TEXT_102 = " = service_";
  protected final String TEXT_103 = ".partialPutItem(wsPartialPutItem_";
  protected final String TEXT_104 = ");" + NL + "\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t";
  protected final String TEXT_106 = NL + "\t              \t";
  protected final String TEXT_107 = ".";
  protected final String TEXT_108 = "= wspk_";
  protected final String TEXT_109 = ".getIds().get(";
  protected final String TEXT_110 = ");" + NL + "\t            ";
  protected final String TEXT_111 = "     " + NL + "            " + NL + "\t\t";
  protected final String TEXT_112 = "   \t\t\t" + NL + "\t\t\t" + NL + "\t\t\torg.talend.mdm.webservice.WSPutItem item_";
  protected final String TEXT_113 = " = new org.talend.mdm.webservice.WSPutItem(";
  protected final String TEXT_114 = ", dataCluster_";
  protected final String TEXT_115 = ",dataModel_";
  protected final String TEXT_116 = ",input_";
  protected final String TEXT_117 = ");" + NL + "\t      \t";
  protected final String TEXT_118 = NL + "\t\t        " + NL + "\t\t        ";
  protected final String TEXT_119 = NL + "\t\t        " + NL + "\t        \torg.talend.mdm.webservice.WSPutItemWithReport itemReport_";
  protected final String TEXT_120 = " = new org.talend.mdm.webservice.WSPutItemWithReport(";
  protected final String TEXT_121 = ", ";
  protected final String TEXT_122 = ", item_";
  protected final String TEXT_123 = ");" + NL + "\t\t" + NL + "\t\t        ";
  protected final String TEXT_124 = NL + "\t\t        \t";
  protected final String TEXT_125 = NL + "\t\t        \t\ttaskIDs_";
  protected final String TEXT_126 = ".add(";
  protected final String TEXT_127 = ");" + NL + "\t\t        \t";
  protected final String TEXT_128 = NL + "\t\t          miList_";
  protected final String TEXT_129 = ".add(itemReport_";
  protected final String TEXT_130 = ");" + NL + "\t\t" + NL + "\t\t          if (miList_";
  protected final String TEXT_131 = ".size() >= ";
  protected final String TEXT_132 = ") {\t\t          \t\t          " + NL + "\t\t          " + NL + "\t\t            org.talend.mdm.webservice.WSPutItemWithReportArray putItemWithReportArray = new org.talend.mdm.webservice.WSPutItemWithReportArray(miList_";
  protected final String TEXT_133 = ");" + NL + "\t\t            wspks_";
  protected final String TEXT_134 = " = service_";
  protected final String TEXT_135 = ".putItemWithReportArray(putItemWithReportArray).getWsItemPK();" + NL + "\t\t            " + NL + "\t\t          ";
  protected final String TEXT_136 = NL + "\t\t            " + NL + "\t\t            miList_";
  protected final String TEXT_137 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_138 = "\t\t            \t\t\t            \t" + NL + "\t\t            \t" + NL + "\t\t            \tint i2_";
  protected final String TEXT_139 = " = 0;" + NL + "\t\t\t\t\t\tfor(org.talend.mdm.webservice.WSItemPK wspk2_";
  protected final String TEXT_140 = " : wspks_";
  protected final String TEXT_141 = "){" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t    String compositeId = \"\";" + NL + "\t\t\t\t\t\t    for(String id:wspk2_";
  protected final String TEXT_142 = ".getIds()) {" + NL + "\t\t\t\t\t\t          compositeId += id;" + NL + "\t\t\t\t\t\t    }\t\t\t\t\t\t    " + NL + "\t\t\t\t\t\t      " + NL + "\t\t\t\t\t\t\twspk2_";
  protected final String TEXT_143 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_144 = ");" + NL + "\t\t\t\t\t\t\tservice_";
  protected final String TEXT_145 = ".updateItemMetadata(util_";
  protected final String TEXT_146 = ".makeUpdateMeteItm(taskIDs_";
  protected final String TEXT_147 = ".get(i2_";
  protected final String TEXT_148 = "), wspk2_";
  protected final String TEXT_149 = "));" + NL + "\t\t\t\t\t\t\ti2_";
  protected final String TEXT_150 = "++;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t            \t" + NL + "\t\t            \t";
  protected final String TEXT_151 = NL + "\t\t            \ttaskIDs_";
  protected final String TEXT_152 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_153 = NL + "\t\t          }" + NL + "\t\t        ";
  protected final String TEXT_154 = "\t\t          " + NL + "\t\t        " + NL + "\t\t          wspk_";
  protected final String TEXT_155 = " = service_";
  protected final String TEXT_156 = ".putItemWithReport(itemReport_";
  protected final String TEXT_157 = ");" + NL + "\t\t          " + NL + "\t\t          ";
  protected final String TEXT_158 = NL + "\t\t          " + NL + "\t\t          \t";
  protected final String TEXT_159 = "\t\t          \t   " + NL + "\t\t            \tservice_";
  protected final String TEXT_160 = ".updateItemMetadata(util_";
  protected final String TEXT_161 = ". makeUpdateMeteItm(";
  protected final String TEXT_162 = ",wspk_";
  protected final String TEXT_163 = "));" + NL + "\t\t            \t";
  protected final String TEXT_164 = NL + "\t\t            ";
  protected final String TEXT_165 = NL + "\t\t        ";
  protected final String TEXT_166 = NL + "\t\t            ";
  protected final String TEXT_167 = ".";
  protected final String TEXT_168 = "= wspk_";
  protected final String TEXT_169 = ".getIds().get(";
  protected final String TEXT_170 = ");" + NL + "\t\t          ";
  protected final String TEXT_171 = NL + "\t\t          " + NL + "\t\t          ";
  protected final String TEXT_172 = NL + "\t\t          " + NL + "\t\t          ";
  protected final String TEXT_173 = NL + "\t\t        \t\ttaskIDs_";
  protected final String TEXT_174 = ".add(";
  protected final String TEXT_175 = ");" + NL + "\t\t        \t";
  protected final String TEXT_176 = NL + "\t\t          miList_";
  protected final String TEXT_177 = ".add(item_";
  protected final String TEXT_178 = ");" + NL + "\t\t" + NL + "\t\t          if (miList_";
  protected final String TEXT_179 = ".size() >= ";
  protected final String TEXT_180 = ") {\t\t          \t\t              " + NL + "\t\t              " + NL + "\t\t              org.talend.mdm.webservice.WSPutItemArray putItemArray = new org.talend.mdm.webservice.WSPutItemArray(miList_";
  protected final String TEXT_181 = ");" + NL + "\t\t              wspks_";
  protected final String TEXT_182 = " = service_";
  protected final String TEXT_183 = ".putItemArray(putItemArray).getWsItemPK();" + NL + "\t\t              " + NL + "\t\t              ";
  protected final String TEXT_184 = NL + "\t\t              " + NL + "\t\t              miList_";
  protected final String TEXT_185 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_186 = "\t\t            \t\t\t            \t" + NL + "                        " + NL + "\t\t            \tint i2_";
  protected final String TEXT_187 = " = 0;" + NL + "\t\t\t\t\t\tfor(org.talend.mdm.webservice.WSItemPK wspk2_";
  protected final String TEXT_188 = " : wspks_";
  protected final String TEXT_189 = "){" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t    String compositeId = \"\";" + NL + "\t\t\t\t\t\t    for(String id:wspk2_";
  protected final String TEXT_190 = ".getIds()) {" + NL + "\t\t\t\t\t\t          compositeId += id;" + NL + "\t\t\t\t\t\t    }\t\t\t\t\t\t    " + NL + "                " + NL + "\t\t\t\t\t\t\twspk2_";
  protected final String TEXT_191 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_192 = ");" + NL + "\t\t\t\t\t\t\tservice_";
  protected final String TEXT_193 = ".updateItemMetadata(util_";
  protected final String TEXT_194 = ".makeUpdateMeteItm(taskIDs_";
  protected final String TEXT_195 = ".get(i2_";
  protected final String TEXT_196 = "), wspk2_";
  protected final String TEXT_197 = "));" + NL + "\t\t\t\t\t\t\ti2_";
  protected final String TEXT_198 = "++;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t            \t";
  protected final String TEXT_199 = NL + "\t\t            \ttaskIDs_";
  protected final String TEXT_200 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_201 = NL + "\t\t          }" + NL + "\t\t        ";
  protected final String TEXT_202 = "\t\t        \t\t          " + NL + "\t\t          " + NL + "\t\t          wspk_";
  protected final String TEXT_203 = " = service_";
  protected final String TEXT_204 = ".putItem(item_";
  protected final String TEXT_205 = ");" + NL + "\t\t          " + NL + "\t\t          ";
  protected final String TEXT_206 = NL + "\t\t          " + NL + "\t\t\t\t\t";
  protected final String TEXT_207 = "\t\t\t\t\t   " + NL + "\t\t            \tservice_";
  protected final String TEXT_208 = ".updateItemMetadata(util_";
  protected final String TEXT_209 = ". makeUpdateMeteItm(";
  protected final String TEXT_210 = ",wspk_";
  protected final String TEXT_211 = "));" + NL + "\t\t            \t";
  protected final String TEXT_212 = NL + "\t\t            ";
  protected final String TEXT_213 = NL + "\t\t          ";
  protected final String TEXT_214 = NL + "\t\t              ";
  protected final String TEXT_215 = ".";
  protected final String TEXT_216 = "= wspk_";
  protected final String TEXT_217 = ".getIds(";
  protected final String TEXT_218 = ");" + NL + "\t\t            ";
  protected final String TEXT_219 = NL + "\t    ";
  protected final String TEXT_220 = "  " + NL + "    } catch (java.lang.Exception e) {";
  protected final String TEXT_221 = "        " + NL + "        throw(e);";
  protected final String TEXT_222 = NL + "            ";
  protected final String TEXT_223 = " = null;";
  protected final String TEXT_224 = NL + "          ";
  protected final String TEXT_225 = " = new ";
  protected final String TEXT_226 = "Struct();" + NL + "          ";
  protected final String TEXT_227 = NL + "      \t\tjava.util.Map<String,String> rejectXmlFlow_";
  protected final String TEXT_228 = " = xmlFlowList_";
  protected final String TEXT_229 = ".get(flowNum_";
  protected final String TEXT_230 = ");" + NL + "      \t\tString rejectValueStr_";
  protected final String TEXT_231 = ";" + NL + "\t\t\t";
  protected final String TEXT_232 = NL + "\t \t\t\trejectValueStr_";
  protected final String TEXT_233 = " = rejectXmlFlow_";
  protected final String TEXT_234 = ".get(\"";
  protected final String TEXT_235 = "\");" + NL + "\t  \t\t\tif (rejectValueStr_";
  protected final String TEXT_236 = " != null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_237 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_238 = ".";
  protected final String TEXT_239 = " = rejectValueStr_";
  protected final String TEXT_240 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_241 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_242 = ".";
  protected final String TEXT_243 = " = ParserUtils.parseTo_Date(rejectValueStr_";
  protected final String TEXT_244 = ", ";
  protected final String TEXT_245 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_246 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_247 = ".";
  protected final String TEXT_248 = " = rejectValueStr_";
  protected final String TEXT_249 = ".getBytes();" + NL + "\t\t\t\t\t";
  protected final String TEXT_250 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_251 = ".";
  protected final String TEXT_252 = " = ParserUtils.parseTo_";
  protected final String TEXT_253 = "(rejectValueStr_";
  protected final String TEXT_254 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_255 = "\t\t\t" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_256 = ".";
  protected final String TEXT_257 = " = ";
  protected final String TEXT_258 = ";" + NL + "\t\t\t\t}" + NL + "\t      \t\t";
  protected final String TEXT_259 = NL + "\t\t\t";
  protected final String TEXT_260 = ".";
  protected final String TEXT_261 = " = ParserUtils.parseTo_Document(queue_";
  protected final String TEXT_262 = ".peek());" + NL + "\t\t  ";
  protected final String TEXT_263 = NL + "\t\t\t";
  protected final String TEXT_264 = ".";
  protected final String TEXT_265 = " = queue_";
  protected final String TEXT_266 = ".peek();" + NL + "\t\t  ";
  protected final String TEXT_267 = NL + "\t\t  nb_line_rejected_";
  protected final String TEXT_268 = "++; ";
  protected final String TEXT_269 = NL + "          ";
  protected final String TEXT_270 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_271 = ";";
  protected final String TEXT_272 = NL + "          System.err.println(e.getMessage());";
  protected final String TEXT_273 = NL + "    }";
  protected final String TEXT_274 = NL + "    flowNum_";
  protected final String TEXT_275 = "++;";
  protected final String TEXT_276 = NL + "    nb_line_";
  protected final String TEXT_277 = "++;";
  protected final String TEXT_278 = NL + "queue_";
  protected final String TEXT_279 = ".remove();";
  protected final String TEXT_280 = NL;

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
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");

boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));

boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
String xmlField = ElementParameterParser.getValue(node,"__XMLFIELD__");
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

boolean storeFlow = ("true").equals(ElementParameterParser.getValue(node, "__STORE_FLOW__"));

List<IMetadataTable> metadatas = node.getMetadataList();

if (destination != null && !"".equals(destination)) {
  cid = destination;
}

if (metadatas != null && metadatas.size()>0) { 
  IMetadataTable metadata = metadatas.get(0);
  if (metadata != null) { 
  
    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    List<IMetadataColumn> rejectColumnList = null;
    boolean xmlFieldDocType=false;
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
    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    List<IMetadataColumn> outputColumnList = null;

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

    if (outConnName != null) {
    
    stringBuffer.append(TEXT_43);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_45);
    
  		if(outputColumnList!=null){
  			for(IMetadataColumn column:outputColumnList) {
  				if(column.getLabel().equals(xmlField) && "id_Document".equals(column.getTalendType())) {
  					xmlFieldDocType=true;
  					break;
  				}
  			}
  		}
      	if(xmlFieldDocType) {
		
    stringBuffer.append(TEXT_46);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(xmlField );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    
		}else{
		
    stringBuffer.append(TEXT_50);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(xmlField );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
		}
		 if(storeFlow){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
			if(outputColumnList!=null){
				for( int i = 0; i < outputColumnList.size(); i++) {
					IMetadataColumn column = outputColumnList.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(xmlField.equals(column.getLabel())){
						continue;
					}
				
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
					if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object
					
    stringBuffer.append(TEXT_64);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
					} else if(javaType == JavaTypesManager.DATE) { // Date
					
    stringBuffer.append(TEXT_68);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_72);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { // byte[]
					
    stringBuffer.append(TEXT_73);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
					} else  { // other
					
    stringBuffer.append(TEXT_77);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_79);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
					}
					
    stringBuffer.append(TEXT_82);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_85);
    }
	      	}
      }
    }
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    if(usePartialUpdate){ // partial
    
			String dataclusterString = "";
    		if(isStaging){
    			dataclusterString = dataCluster + " + \"#STAGING\"";
    		} else {
    			dataclusterString = dataCluster;
    		}

    stringBuffer.append(TEXT_89);
    stringBuffer.append(usePartialDelete );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(position.equals("")?null:position);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(dataclusterString );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(dataModel );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(usePartialDelete );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(key.equals("")?null:key);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(overwrite);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(pivot);
    stringBuffer.append(TEXT_98);
    stringBuffer.append( true==isStaging?false:withReport);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(sourceName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
     logUtil.debug("\"Partial put item successfully.\"");
    stringBuffer.append(TEXT_105);
    
	        if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
	        	for (int i = 0; i < keysReturn.size(); i++){
	            	Map<String,String> map = keysReturn.get(i);
	              	
    stringBuffer.append(TEXT_106);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_110);
    
	            }
	       	}
		   	
    stringBuffer.append(TEXT_111);
    }else{// not partial 
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(isUpdate );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
		    if (!isStaging && withReport) {
    stringBuffer.append(TEXT_118);
     logUtil.debug("\"Put item to MDM server with full update.\"");
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(needCheck );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(sourceName );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    if (isMassInsert) {
    stringBuffer.append(TEXT_124);
    if(addTaskID){
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(isCustom?taskID:"xmlFlowList_" + cid + ".get(flowNum_" + cid + ").get(\"" + prevColumn + "\")");
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
     logUtil.debug("\"Put item with report array successfully.\"");
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    if(addTaskID){
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
     logUtil.debug("\"Add task id successfully.\"");
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    }
    stringBuffer.append(TEXT_153);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
     logUtil.debug("\"Put item with report array successfully.\"");
    stringBuffer.append(TEXT_158);
    if(addTaskID){
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(isCustom?taskID:"xmlFlowList_" + cid + ".get(flowNum_" + cid + ").get(\"" + prevColumn + "\")");
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
     logUtil.debug("\"Add task id successfully.\"");
    stringBuffer.append(TEXT_164);
    }
    stringBuffer.append(TEXT_165);
    
		        }
		
		        if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
		        
		          for (int i = 0; i < keysReturn.size(); i++){
		            Map<String,String> map = keysReturn.get(i);
		            
    stringBuffer.append(TEXT_166);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_170);
    
		          }
		        }
		      } else {
		          
    stringBuffer.append(TEXT_171);
     logUtil.debug("\"Put item with to MDM server.\"");
    stringBuffer.append(TEXT_172);
    
		        if (isMassInsert) {
		        	if(addTaskID){
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(isCustom?taskID:"xmlFlowList_" + cid + ".get(flowNum_" + cid + ").get(\"" + prevColumn + "\")");
    stringBuffer.append(TEXT_175);
    }
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
     logUtil.debug("\"Put item array successfully.\"");
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    if(addTaskID){
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
     logUtil.debug("\"Add task id successfully.\"");
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    }
    stringBuffer.append(TEXT_201);
    
		        } else {
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
     logUtil.debug("\"Put item successfully.\"");
    stringBuffer.append(TEXT_206);
    if(addTaskID){
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(isCustom?taskID:"xmlFlowList_" + cid + ".get(flowNum_" + cid + ").get(\"" + prevColumn + "\")");
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
     logUtil.debug("\"Add task id successfully.\"");
    stringBuffer.append(TEXT_212);
    }
    stringBuffer.append(TEXT_213);
    
		          if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
		            for (int i = 0; i < keysReturn.size(); i++){
		              Map<String,String> map = keysReturn.get(i);
		              
    stringBuffer.append(TEXT_214);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_218);
    
		            }
		          }
		        }
		      }
		      
    stringBuffer.append(TEXT_219);
    }//end partial
    stringBuffer.append(TEXT_220);
     logUtil.error("\"Unexpected error:\"+e.getMessage()");
    if (dieOnError) {
    stringBuffer.append(TEXT_221);
    } else {

        if (rejectConnName != null) {
          if (outConnName != null) {
    stringBuffer.append(TEXT_222);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_226);
    if(storeFlow){
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    
			if(rejectColumnList!=null){
				for( int i = 0; i < rejectColumnList.size(); i++) {
					IMetadataColumn column = rejectColumnList.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(xmlField.equals(column.getLabel())){
						continue;
					}
				
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    
					if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object
					
    stringBuffer.append(TEXT_237);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    
					} else if(javaType == JavaTypesManager.DATE) { // Date
					
    stringBuffer.append(TEXT_241);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_245);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { // byte[]
					
    stringBuffer.append(TEXT_246);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    
					} else  { // other
					
    stringBuffer.append(TEXT_250);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_252);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    
					}
					
    stringBuffer.append(TEXT_255);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_257);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_258);
    }
	      	}
      	  }
      	  if(xmlFieldDocType) {
		  
    stringBuffer.append(TEXT_259);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(xmlField );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    
		  }else{
		  
    stringBuffer.append(TEXT_263);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(xmlField );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    
		  }
		  
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_271);
    } else {
    stringBuffer.append(TEXT_272);
    }
      }
    stringBuffer.append(TEXT_273);
    if(storeFlow){
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    }
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    
  }
}
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(TEXT_280);
    return stringBuffer.toString();
  }
}
