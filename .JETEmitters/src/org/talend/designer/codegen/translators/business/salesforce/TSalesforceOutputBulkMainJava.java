package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TSalesforceOutputBulkMainJava
{
  protected static String nl;
  public static synchronized TSalesforceOutputBulkMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceOutputBulkMainJava result = new TSalesforceOutputBulkMainJava();
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
  protected final String TEXT_41 = " " + NL + "\t        \t\t\tif(isGenDynamicHeader_";
  protected final String TEXT_42 = "){" + NL + "\t\t        \t\t\tif(file_";
  protected final String TEXT_43 = ".length() == 0 && ";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = " != null){" + NL + "\t\t        \t\t\t\tint dynamicColCount_";
  protected final String TEXT_46 = " = 1;" + NL + "\t\t        \t\t\t\tif(";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = "!=null){" + NL + "\t\t        \t\t\t\t\tdynamicColCount_";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = ".getColumnCount();" + NL + "\t\t        \t\t\t\t\tcolumnCount_";
  protected final String TEXT_52 = " = dynamicColCount_";
  protected final String TEXT_53 = " + ";
  protected final String TEXT_54 = "-1;" + NL + "\t\t        \t\t\t\t}" + NL + "\t\t                \t\tString[] header_";
  protected final String TEXT_55 = " = new String[";
  protected final String TEXT_56 = "+dynamicColCount_";
  protected final String TEXT_57 = "-1];" + NL + "\t\t\t                \t";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = "!=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\tfor(int i_";
  protected final String TEXT_61 = "=0;i_";
  protected final String TEXT_62 = "<";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = ".getColumnCount();i_";
  protected final String TEXT_65 = "++){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = ".getColumnMetadata(i_";
  protected final String TEXT_69 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tString fieldName_";
  protected final String TEXT_70 = " = dynamicMetadata_";
  protected final String TEXT_71 = ".getName();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(dynamicMetadata_";
  protected final String TEXT_72 = ".getRefFieldName()!=null && dynamicMetadata_";
  protected final String TEXT_73 = ".getRefModuleName()!=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\theader_";
  protected final String TEXT_74 = "[i_";
  protected final String TEXT_75 = "+";
  protected final String TEXT_76 = "] = dynamicMetadata_";
  protected final String TEXT_77 = ".getRefModuleName() + \":\" + dynamicMetadata_";
  protected final String TEXT_78 = ".getRefFieldName()+ \".\" + fieldName_";
  protected final String TEXT_79 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\theader_";
  protected final String TEXT_80 = "[i_";
  protected final String TEXT_81 = "+";
  protected final String TEXT_82 = "] = fieldName_";
  protected final String TEXT_83 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\t\t\t\t\theader_";
  protected final String TEXT_85 = "[";
  protected final String TEXT_86 = "] = \"";
  protected final String TEXT_87 = "\";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t\t\t\t\tcsvWriter_";
  protected final String TEXT_90 = ".writeNext(header_";
  protected final String TEXT_91 = ");\t" + NL + "\t\t\t\t\t\t\t}\t" + NL + "\t\t\t\t\t\t\tisGenDynamicHeader_";
  protected final String TEXT_92 = " = false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_93 = " " + NL + "                \t\tString[] row_";
  protected final String TEXT_94 = " = new String[]{";
  protected final String TEXT_95 = " \"\",";
  protected final String TEXT_96 = "\"#N/A\",";
  protected final String TEXT_97 = "};\t\t//empty value must be NULL('#N/A' in bulk file)" + NL + "                \t";
  protected final String TEXT_98 = NL + "                \t\tString[] row_";
  protected final String TEXT_99 = " = new String[columnCount_";
  protected final String TEXT_100 = "];" + NL + "                \t\tfor(int j_";
  protected final String TEXT_101 = "=0;j_";
  protected final String TEXT_102 = "<columnCount_";
  protected final String TEXT_103 = ";j_";
  protected final String TEXT_104 = "++){" + NL + "\t\t\t\t\t\t\trow_";
  protected final String TEXT_105 = "[j_";
  protected final String TEXT_106 = "] = ";
  protected final String TEXT_107 = " \"\"";
  protected final String TEXT_108 = "\"#N/A\"";
  protected final String TEXT_109 = ";" + NL + "\t\t\t\t\t\t}" + NL + "                \t";
  protected final String TEXT_110 = NL + "            \t\t\t\tif(";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = "!=null){" + NL + "\t\t\t\t\t\t\t\tfor(int i_";
  protected final String TEXT_113 = "=0;i_";
  protected final String TEXT_114 = "< ";
  protected final String TEXT_115 = ".";
  protected final String TEXT_116 = ".getColumnCount();i_";
  protected final String TEXT_117 = "++){" + NL + "\t\t\t\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = ".getColumnMetadata(i_";
  protected final String TEXT_121 = ");" + NL + "\t\t\t\t\t\t\t\t\tString talendType_";
  protected final String TEXT_122 = " = dynamicMetadata_";
  protected final String TEXT_123 = ".getType();" + NL + "\t\t\t\t\t\t\t\t\tString fieldName_";
  protected final String TEXT_124 = " = dynamicMetadata_";
  protected final String TEXT_125 = ".getName();" + NL + "\t\t\t\t\t\t\t\t\tObject fieldValue_";
  protected final String TEXT_126 = " = ";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = ".getColumnValue(fieldName_";
  protected final String TEXT_129 = ");" + NL + "\t\t\t\t\t\t\t\t\tif(fieldValue_";
  protected final String TEXT_130 = "!=null){" + NL + "\t\t\t\t\t\t\t\t\t\tif(\"id_Date\".equals(talendType_";
  protected final String TEXT_131 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\trow_";
  protected final String TEXT_132 = "[i_";
  protected final String TEXT_133 = "+";
  protected final String TEXT_134 = "] = FormatterUtils.format_Date((java.util.Date)(fieldValue_";
  protected final String TEXT_135 = "), dynamicMetadata_";
  protected final String TEXT_136 = ".getFormat());" + NL + "\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\trow_";
  protected final String TEXT_137 = "[i_";
  protected final String TEXT_138 = "+";
  protected final String TEXT_139 = "] = String.valueOf(fieldValue_";
  protected final String TEXT_140 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "            \t\t\t\t";
  protected final String TEXT_141 = NL + "        \t\t\t    \trow_";
  protected final String TEXT_142 = "[";
  protected final String TEXT_143 = "] = String.valueOf(";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = ");" + NL + "        \t\t\t    ";
  protected final String TEXT_146 = NL + "            \t\t\t    if(";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " != null){" + NL + "            \t\t\t        ";
  protected final String TEXT_149 = NL + "            \t\t\t            row_";
  protected final String TEXT_150 = "[";
  protected final String TEXT_151 = "] = FormatterUtils.format_Date(";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = ", ";
  protected final String TEXT_154 = ");" + NL + "            \t\t\t            ";
  protected final String TEXT_155 = NL + "            \t\t\t            row_";
  protected final String TEXT_156 = "[";
  protected final String TEXT_157 = "] = String.valueOf(";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = ");" + NL + "            \t\t\t            ";
  protected final String TEXT_160 = "                \t\t\t    " + NL + "            \t\t\t    }" + NL + "            \t\t \t";
  protected final String TEXT_161 = NL + "    \t\t\t    csvWriter_";
  protected final String TEXT_162 = ".writeNext(row_";
  protected final String TEXT_163 = ");\t" + NL + "    \t\t\t    " + NL + "    \t\t\t\tnb_line_";
  protected final String TEXT_164 = "++;" + NL + "    \t\t\t\t";
  protected final String TEXT_165 = NL + "    \t\t\t";
  protected final String TEXT_166 = NL;

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
log = new LogUtil(node);
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();

boolean ignoreNullValue = ("true").equals(ElementParameterParser.getValue(node, "__IGNORE_NULL__"));

if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	boolean hasDynamic = metadata.isDynamicSchema();
    	String dynamicColName = hasDynamic?metadata.getDynamicColumn().getLabel():"";
    	if(conns!=null){
    		if (conns.size()>0){
    		    IConnection conn =conns.get(0);
        		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        			List<IMetadataColumn> columns = metadata.getListColumns();
            		int sizeColumns = columns.size();
            		if(hasDynamic){
        			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(dynamicColName );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(dynamicColName );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(dynamicColName );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
			                	String columnIndex = "0";
			                	boolean isAfterDynamic = false;
			        			for (int i = 0; i < sizeColumns; i++){
			            			IMetadataColumn column = columns.get(i);
			            			if(isAfterDynamic){
			            				columnIndex = conn.getName()+"."+dynamicColName +".getColumnCount()+"+(i-1);
			            			}else{
			            				columnIndex = ""+i;
			            			}
									if(column.getTalendType().equals("id_Dynamic")){
									
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(dynamicColName );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(dynamicColName );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(dynamicColName );
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
    stringBuffer.append(columnIndex);
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
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
										isAfterDynamic = true;
									}else{
									
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_87);
    
									}
								}
								
    stringBuffer.append(TEXT_88);
    log.trace(log.str("Written header: "), "java.util.Arrays.asList(header_" + cid + ")");
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
					}
					if(!hasDynamic){
					
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    for(int j=0;j<sizeColumns;j++){ if(ignoreNullValue){
    stringBuffer.append(TEXT_95);
    }else{
    stringBuffer.append(TEXT_96);
    }}
    stringBuffer.append(TEXT_97);
    
                	}else{
                	
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
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
    if(ignoreNullValue){
    stringBuffer.append(TEXT_107);
    }else{
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    
                	}
                	String columnIndex = "i";
			        boolean isAfterDynamic = false;
        			for (int i = 0; i < sizeColumns; i++) {
            			IMetadataColumn column = columns.get(i);
            			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
            			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
            			if(hasDynamic && isAfterDynamic){
            				columnIndex = conn.getName()+"."+dynamicColName +".getColumnCount()+"+(i-1);
            			}else{
            				columnIndex = ""+i;
            			}
            			if(column.getTalendType().equals("id_Dynamic")){
            			
    stringBuffer.append(TEXT_110);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(dynamicColName );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(dynamicColName );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(dynamicColName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(dynamicColName );
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
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
            				isAfterDynamic = true;
            			}else if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){
        			    
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_145);
    
            			}else {
        			    
    stringBuffer.append(TEXT_146);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_148);
    					
            			        if(javaType == JavaTypesManager.DATE && pattern != null){
            			            
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_154);
    
            			        }else{
            			            
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(columnIndex);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_159);
    
            			        }
            			        
    stringBuffer.append(TEXT_160);
     
            			}
        			} 
        			
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    log.debug(log.str("Writing the record "), log.var("nb_line"), log.str("."));
    stringBuffer.append(TEXT_165);
       		
        		}
    		}
    	}
    }
}

    stringBuffer.append(TEXT_166);
    return stringBuffer.toString();
  }
}
