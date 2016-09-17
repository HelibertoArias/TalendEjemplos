package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class TTeradataFastLoadMainJava
{
  protected static String nl;
  public static synchronized TTeradataFastLoadMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastLoadMainJava result = new TTeradataFastLoadMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_30 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_31 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_33 = " - Uses an existing connection ";
  protected final String TEXT_34 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_36 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_37 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_38 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\tconn_";
  protected final String TEXT_41 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_42 = ", dbUser_";
  protected final String TEXT_43 = ", dbPwd_";
  protected final String TEXT_44 = ");" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\tconn_";
  protected final String TEXT_46 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\tconn_";
  protected final String TEXT_48 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\tconn_";
  protected final String TEXT_50 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\tconn_";
  protected final String TEXT_52 = ".setAutoCommit(";
  protected final String TEXT_53 = ");" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\tlog.";
  protected final String TEXT_55 = "(\"";
  protected final String TEXT_56 = " - \" + ";
  protected final String TEXT_57 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t    \t\tlog.";
  protected final String TEXT_59 = "(\"";
  protected final String TEXT_60 = "\");" + NL + "\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_62 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_64 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_65 = ": pstmt_";
  protected final String TEXT_66 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_67 = " += (countEach_";
  protected final String TEXT_68 = " < 0 ? 0 : ";
  protected final String TEXT_69 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_70 = NL + NL + "\t";
  protected final String TEXT_71 = NL + "if(";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = "==null){" + NL + "\t";
  protected final String TEXT_74 = ".setNull(";
  protected final String TEXT_75 = ",java.sql.Types.CHAR);" + NL + "\t";
  protected final String TEXT_76 = NL + "if(";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = "==null){" + NL + "\t";
  protected final String TEXT_79 = ".setNull(";
  protected final String TEXT_80 = ",java.sql.Types.DATE);" + NL + "\t";
  protected final String TEXT_81 = NL + "if(";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = "==null){";
  protected final String TEXT_84 = NL + "    ";
  protected final String TEXT_85 = ".setNull(";
  protected final String TEXT_86 = ",java.sql.Types.TIMESTAMP);";
  protected final String TEXT_87 = NL + "if(";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = "==null){" + NL + "\t";
  protected final String TEXT_90 = ".setNull(";
  protected final String TEXT_91 = ",java.sql.Types.ARRAY);\t\t\t" + NL + "\t";
  protected final String TEXT_92 = NL + "if(";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = "==null){" + NL + "\t";
  protected final String TEXT_95 = ".setNull(";
  protected final String TEXT_96 = ",java.sql.Types.INTEGER);" + NL + "\t";
  protected final String TEXT_97 = NL + "if(";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = "==null){" + NL + "\t";
  protected final String TEXT_100 = ".setNull(";
  protected final String TEXT_101 = ",java.sql.Types.VARCHAR);" + NL + "\t";
  protected final String TEXT_102 = NL + "if(";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = "==null){" + NL + "\t";
  protected final String TEXT_105 = ".setNull(";
  protected final String TEXT_106 = ",java.sql.Types.OTHER);" + NL + "\t";
  protected final String TEXT_107 = NL + "if(";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = "==null){" + NL + "\t";
  protected final String TEXT_110 = ".setNull(";
  protected final String TEXT_111 = ",java.sql.Types.BOOLEAN);\t" + NL + "\t";
  protected final String TEXT_112 = NL + "if(";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = "==null){" + NL + "\t";
  protected final String TEXT_115 = ".setNull(";
  protected final String TEXT_116 = ",java.sql.Types.DOUBLE);\t" + NL + "\t";
  protected final String TEXT_117 = NL + "if(";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = "==null){" + NL + "\t";
  protected final String TEXT_120 = ".setNull(";
  protected final String TEXT_121 = ",java.sql.Types.FLOAT);\t" + NL + "\t";
  protected final String TEXT_122 = NL + NL + "}else{" + NL + "" + NL + "\t";
  protected final String TEXT_123 = NL + "\t";
  protected final String TEXT_124 = NL + "\tif(";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = "==null){" + NL + "\t";
  protected final String TEXT_127 = NL + "\tif((\"null\").equals(String.valueOf(";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = ").toLowerCase())){" + NL + "\t";
  protected final String TEXT_130 = NL + "\t\t";
  protected final String TEXT_131 = ".setNull(";
  protected final String TEXT_132 = ",java.sql.Types.CHAR);" + NL + "\t\t" + NL + "\t}else if(";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " == '\\0'){" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_135 = ".setString(";
  protected final String TEXT_136 = ",\"\");" + NL + "\t\t" + NL + "\t}else{" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_137 = ".setString(";
  protected final String TEXT_138 = ",String.valueOf(";
  protected final String TEXT_139 = ".";
  protected final String TEXT_140 = "));" + NL + "\t}" + NL + "\t";
  protected final String TEXT_141 = NL + "\tif(";
  protected final String TEXT_142 = ".";
  protected final String TEXT_143 = "!=null){" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_144 = ".setDate(";
  protected final String TEXT_145 = ",new java.sql.Date(";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = ".getTime()));" + NL + "\t\t" + NL + "\t}else{" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_148 = ".setNull(";
  protected final String TEXT_149 = ",java.sql.Types.DATE);" + NL + "\t\t" + NL + "\t}" + NL + "\t";
  protected final String TEXT_150 = NL + "\tif(";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = "!=null){" + NL + "\t    " + NL + "\t   ";
  protected final String TEXT_153 = ".setTimestamp(";
  protected final String TEXT_154 = ",new java.sql.Timestamp(";
  protected final String TEXT_155 = ".";
  protected final String TEXT_156 = ".getTime()));" + NL + "\t        " + NL + "\t}else{" + NL + "\t    " + NL + "\t   ";
  protected final String TEXT_157 = ".setNull(";
  protected final String TEXT_158 = ",java.sql.Types.TIMESTAMP);" + NL + "\t        " + NL + "    }" + NL + "\t";
  protected final String TEXT_159 = NL + "\t";
  protected final String TEXT_160 = ".set";
  protected final String TEXT_161 = "(";
  protected final String TEXT_162 = ",";
  protected final String TEXT_163 = ".";
  protected final String TEXT_164 = ");" + NL + "\t";
  protected final String TEXT_165 = NL + "}";
  protected final String TEXT_166 = NL + "\t\ttry{" + NL + "\t\t\t\tpstmt_";
  protected final String TEXT_167 = ".addBatch();" + NL + "\t\t   }catch(java.lang.Exception e){" + NL + "\t\t            ";
  protected final String TEXT_168 = NL + "\t\t                throw(e);" + NL + "\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t                        ";
  protected final String TEXT_170 = ".";
  protected final String TEXT_171 = " = ";
  protected final String TEXT_172 = ".";
  protected final String TEXT_173 = ";" + NL + "\t\t\t\t                        ";
  protected final String TEXT_174 = NL + "\t\t                    ";
  protected final String TEXT_175 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_176 = ";" + NL + "\t\t                    ";
  protected final String TEXT_177 = NL + "\t\t                    System.err.print(e.getMessage());" + NL + "\t\t                    ";
  protected final String TEXT_178 = NL + "\t\t        }" + NL + "\t\t\t";
  protected final String TEXT_179 = NL + "\t\t\t                ";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = " = ";
  protected final String TEXT_182 = ".";
  protected final String TEXT_183 = ";" + NL + "\t\t\t                ";
  protected final String TEXT_184 = NL + "\t    commitCounter_";
  protected final String TEXT_185 = "++;" + NL + "\t    nb_line_";
  protected final String TEXT_186 = "++;";
  protected final String TEXT_187 = NL + "        if(commitEvery_";
  protected final String TEXT_188 = " <= commitCounter_";
  protected final String TEXT_189 = "){" + NL + "\t\t\tint[] resultArr = pstmt_";
  protected final String TEXT_190 = ".executeBatch();" + NL + "\t\t\tpstmt_";
  protected final String TEXT_191 = ".clearBatch();" + NL + "        \tcommitCounter_";
  protected final String TEXT_192 = "=0;" + NL + "        \tint sum = 0;" + NL + "        \tfor(int i : resultArr){" + NL + "  \t\t    \tsum += (i<0 ? 0 : i);" + NL + "        \t}" + NL + "        \tinsertedCount_";
  protected final String TEXT_193 = " += sum;" + NL + "        }" + NL + "\t";
  protected final String TEXT_194 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    if (cid.startsWith("tImpala") || cid.startsWith("tHive")) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_34);
    } else {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
			connect_end();
		}

		public void connect_begin(){
			logInfo(node,"info",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"info",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"info",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"info",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"info",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_53);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			logInfo(node,"info",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"info",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_57);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_58);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_60);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_69);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();	
	String cid = node.getUniqueName();
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	String incomingConnName = null;
	List<IMetadataColumn> columnList = null;
	
	List<? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size()>0){
		IConnection conn = conns.get(0);
		incomingConnName = conn.getName();
	}
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if(metadatas != null && metadatas.size()>0){
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null){
			columnList = metadata.getListColumns();
		}
	}
	
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
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

///////////////Inner Class Column///////////////////////////
class Column{
	IMetadataColumn column;
	String name;
	String sqlStmt;
	String value;
	boolean addCol;
	List<Column> replacement = new ArrayList<Column>();
	
	public Column(String colName,String sqlStmt,boolean addCol){
		this.column = null;
		this.name = colName;
		this.sqlStmt = sqlStmt;
		this.value = "?";
		this.addCol =addCol;
	}
	
	public Column(IMetadataColumn column){
		this.column = column;
		this.name = column.getLabel();
		this.sqlStmt = "=?";
		this.value = "?";
		this.addCol =false;
	}
	
	public boolean isReplaced(){
		return replacement.size()>0;
	}
	
	public void replace(Column column){
		this.replacement.add(column);
	}
	
	public List<Column> getReplacement(){
		return this.replacement;
	}
	
	public void setColumn(IMetadataColumn column){
		this.column = column;
	}
	
	public IMetadataColumn getColumn(){
		return this.column;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}
	
	public void setIsAddCol(boolean isadd){
		this.addCol = isadd;
	}
	
	public boolean isAddCol(){
		return this.addCol;
	}
	
	public void setSqlStmt(String sql){
		this.sqlStmt = sql;
	}
	
	public String getSqlStmt(){
		return this.sqlStmt;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}

	StringBuilder insertColName = new StringBuilder();
	StringBuilder insertValueStmt = new StringBuilder();
	StringBuilder updateSetStmt = new StringBuilder();
	StringBuilder updateWhereStmt = new StringBuilder();
	List<Column> stmtStructure =  new LinkedList<Column>();
	
for(IMetadataColumn column:columnList){
	stmtStructure.add(new Column(column));
}

List<Column> colStruct =  new ArrayList();
for(Column colStmt:stmtStructure){
	if(!colStmt.isReplaced()&&!colStmt.isAddCol()){
		colStruct.add(colStmt);
	}
}

class Operation{
	public static final int NORMAL_TYPE = 0;
	public static final int INSERT_TYPE = 1;
	public static final int UPDATE_TYPE = 2;
	
	public String generateType(String typeToGenerate){
		if(("byte[]").equals(typeToGenerate)){
 	  		typeToGenerate = "Bytes";
 	   	}else if(("java.util.Date").equals(typeToGenerate)){
 	   		typeToGenerate = "Date";
 	  	}else if(("java.util.Timestamp").equals(typeToGenerate)){
            typeToGenerate = "Timestamp";
        }else if(("Integer").equals(typeToGenerate)){
 	   		typeToGenerate = "Int";
 	   	}else{
			typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
		}
		return typeToGenerate;
	}
	
	public void generateSetStmt(String typeToGenerate,Column column,
								int counter,String incomingConnName,String cid,int stmtType){
		boolean isObject = false;								
		String prefix = null;								
		if(stmtType == Operation.NORMAL_TYPE){
			prefix = "pstmt_";
		}else if(stmtType == Operation.INSERT_TYPE){
			prefix = "pstmtInsert_";
		}else if(stmtType == Operation.UPDATE_TYPE){
			prefix = "pstmtUpdate_";
		}
		
    stringBuffer.append(TEXT_70);
    if(("Character").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_71);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_75);
    
	}else if(("Date").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_76);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_80);
    
	}else if(("Timestamp").equals(typeToGenerate)){
    isObject = true;
    
    stringBuffer.append(TEXT_81);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_86);
    
    }else if(("byte[]").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_87);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_91);
    
	}else if(("Long").equals(typeToGenerate)||("Byte").equals(typeToGenerate)||("Integer").equals(typeToGenerate)||("Short").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_92);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_96);
    
	}else if(("String").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_97);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_101);
    
	}else if(("Object").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_102);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_106);
    
	}else if(("Boolean").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_107);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_111);
    
	}else if(("Double").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_112);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_116);
    
	}else if(("Float").equals(typeToGenerate)){
	isObject = true;
	
    stringBuffer.append(TEXT_117);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_121);
    
	}
if(isObject){
	
    stringBuffer.append(TEXT_122);
    
}
	typeToGenerate = generateType(typeToGenerate);
	
	if(("Char").equals(typeToGenerate)||("Character").equals(typeToGenerate)){
	
    stringBuffer.append(TEXT_123);
    if(isObject){
    stringBuffer.append(TEXT_124);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_126);
    }else{
    stringBuffer.append(TEXT_127);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_140);
    
	}else if(("Date").equals(typeToGenerate)){
	
    stringBuffer.append(TEXT_141);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_149);
    
	}else if(("Timestamp").equals(typeToGenerate)){
	
    stringBuffer.append(TEXT_150);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_158);
    
	}else{
	
    stringBuffer.append(TEXT_159);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_164);
    
	}
if(isObject){
	
    stringBuffer.append(TEXT_165);
    
		} /* "if(isObject)" end */
	} /* "public void generateSetStmt" end */
} /* "class Operation" end */

Operation operation = new Operation();
if(incomingConnName != null && columnList != null){
		int counter = 1;
		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			operation.generateSetStmt(typeToGenerate,column,counter,incomingConnName,cid,0);
	    	counter++;
		}
		
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
     if (("true").equals(dieOnError)) { 
    stringBuffer.append(TEXT_168);
     } else {
						log4jCodeGenerateUtil.logError(node,"error");
		                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
			                    for(IMetadataColumn column : columnList) {
				                        
    stringBuffer.append(TEXT_169);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_171);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_173);
    
			                    } 
    stringBuffer.append(TEXT_174);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_176);
    
		                } else {
		                    
    stringBuffer.append(TEXT_177);
    
		                }
		            } 
		            
    stringBuffer.append(TEXT_178);
    

			if(outgoingConns != null && outgoingConns.size() > 0) {
			    for(IConnection outgoingConn : outgoingConns) {
			        if(!outgoingConn.getName().equals(rejectConnName) &&
			        	outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA) ) {
			            for(IMetadataColumn column : columnList) {
			                
    stringBuffer.append(TEXT_179);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_183);
    
			            }
			        }
			    }
			}
		
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
	////////////commit every////////////
	if(!("").equals(commitEvery) && !("0").equals(commitEvery)){
	
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
	}
}

    stringBuffer.append(TEXT_194);
    return stringBuffer.toString();
  }
}
