package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TMarketoOutputWriteMainJava
{
  protected static String nl;
  public static synchronized TMarketoOutputWriteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoOutputWriteMainJava result = new TMarketoOutputWriteMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\t";
  protected final String TEXT_2 = " = null;\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_4 = "\tjava.util.Map<String, String> leadAllAttrList_";
  protected final String TEXT_5 = " = new java.util.HashMap<String,String>();" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\t\tif(";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " != null){" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tleadAllAttrList_";
  protected final String TEXT_10 = ".put(";
  protected final String TEXT_11 = ",FormatterUtils.format_Date(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = "));" + NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tleadAllAttrList_";
  protected final String TEXT_16 = ".put(";
  protected final String TEXT_17 = ",String.valueOf(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = "));" + NL + "\t\t";
  protected final String TEXT_20 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_21 = NL + "\t\tboolean hasFault_";
  protected final String TEXT_22 = " = false;" + NL + "\t\tString errorMsg_";
  protected final String TEXT_23 = " = null;" + NL + "\t\tInteger marketoId_";
  protected final String TEXT_24 = " = null;" + NL + "\t\tString marketoStatus_";
  protected final String TEXT_25 = "=null;" + NL + "\t\ttry{" + NL + "\t\t\tcom.marketo.www.mktows.ResultSyncLead syncLead_";
  protected final String TEXT_26 = " = client_";
  protected final String TEXT_27 = ".syncLead(false,null,client_";
  protected final String TEXT_28 = ".buildLead(leadAllAttrList_";
  protected final String TEXT_29 = "));" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_30 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_31 = ");" + NL + "\t\t\tcom.marketo.www.mktows.SyncStatus syncStatus_";
  protected final String TEXT_32 = " = syncLead_";
  protected final String TEXT_33 = ".getSyncStatus();" + NL + "\t\t\tstatusList_";
  protected final String TEXT_34 = ".add(new com.marketo.www.mktows.SyncStatus[]{syncStatus_";
  protected final String TEXT_35 = "});" + NL + "\t\t\tif (!com.marketo.www.mktows.LeadSyncStatus.FAILED.equals(syncStatus_";
  protected final String TEXT_36 = ".getStatus())) {" + NL + "\t\t\t\thasFault_";
  protected final String TEXT_37 = " = false;" + NL + "\t\t\t}else{" + NL + "\t\t\t\thasFault_";
  protected final String TEXT_38 = " = true;" + NL + "\t\t\t\terrorMsg_";
  protected final String TEXT_39 = " = syncStatus_";
  protected final String TEXT_40 = ".getError();" + NL + "\t\t\t}" + NL + "\t\t\tmarketoId_";
  protected final String TEXT_41 = " = syncStatus_";
  protected final String TEXT_42 = ".getLeadId();" + NL + "\t\t\tmarketoStatus_";
  protected final String TEXT_43 = " = syncStatus_";
  protected final String TEXT_44 = ".getStatus().getValue();" + NL + "\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_45 = "){" + NL + "\t\t\tif(ex_";
  protected final String TEXT_46 = " instanceof org.apache.axis.AxisFault){" + NL + "    \t\t\tif(!client_";
  protected final String TEXT_47 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_48 = ")){" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_49 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_50 = ");\t\t" + NL + "\t\t\t\t}" + NL + "    \t\t}" + NL + "\t\t\thasFault_";
  protected final String TEXT_51 = " = true;" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "                throw(ex_";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "\t\t\t\t\terrorMsg_";
  protected final String TEXT_55 = " = ex_";
  protected final String TEXT_56 = ".getMessage();" + NL + "\t\t\t\t\tmarketoId_";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = ".Id;" + NL + "\t\t\t\t\tmarketoStatus_";
  protected final String TEXT_59 = " = \"FAILED\";" + NL + "\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_61 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_63 = NL + "\t\tleadRecordList_";
  protected final String TEXT_64 = ".add(client_";
  protected final String TEXT_65 = ".buildLead(leadAllAttrList_";
  protected final String TEXT_66 = "));" + NL + "\t\tif(leadRecordList_";
  protected final String TEXT_67 = ".size()>=";
  protected final String TEXT_68 = "){" + NL + "\t\t\tcom.marketo.www.mktows.LeadRecord[] leadRecords_";
  protected final String TEXT_69 = " = leadRecordList_";
  protected final String TEXT_70 = ".toArray(new com.marketo.www.mktows.LeadRecord[leadRecordList_";
  protected final String TEXT_71 = ".size()]);" + NL + "\t\t\ttry{" + NL + "\t\t\t\tcom.marketo.www.mktows.ResultSyncMultipleLeads syncLeads_";
  protected final String TEXT_72 = " = client_";
  protected final String TEXT_73 = ".syncMultipleLeads(";
  protected final String TEXT_74 = ",leadRecords_";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\tstatusList_";
  protected final String TEXT_76 = ".add(syncLeads_";
  protected final String TEXT_77 = ".getSyncStatusList());" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_78 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_79 = ");" + NL + "\t\t\t }catch(java.lang.Exception ex_";
  protected final String TEXT_80 = "){" + NL + "\t\t\t \tif(ex_";
  protected final String TEXT_81 = " instanceof org.apache.axis.AxisFault){" + NL + "\t    \t\t\tif(!client_";
  protected final String TEXT_82 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_83 = ")){" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_84 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_85 = ");\t\t" + NL + "\t\t\t\t\t}" + NL + "\t    \t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t            throw(ex_";
  protected final String TEXT_87 = ");" + NL + "\t\t        ";
  protected final String TEXT_88 = NL + "\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_89 = ".getMessage());" + NL + "\t\t        ";
  protected final String TEXT_90 = NL + "\t\t\t}" + NL + "\t\t\tleadRecordList_";
  protected final String TEXT_91 = ".clear();" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_92 = NL + "\t\t\t\t\tif (!hasFault_";
  protected final String TEXT_93 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_94 = " = new ";
  protected final String TEXT_95 = "Struct();" + NL + "\t\t\t\t\t\t//";
  protected final String TEXT_96 = ".SYNC_STATUS = syncStatus_";
  protected final String TEXT_97 = ".getStatus().toString();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_99 = ".Id = marketoId_";
  protected final String TEXT_100 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_102 = ".Status = marketoStatus_";
  protected final String TEXT_103 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_104 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = " = ";
  protected final String TEXT_107 = ".";
  protected final String TEXT_108 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\tif(hasFault_";
  protected final String TEXT_111 = "){\t" + NL + "\t\t\t\t";
  protected final String TEXT_112 = " = new ";
  protected final String TEXT_113 = "Struct();" + NL + "\t\t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_114 = ".ERROR_MSG = errorMsg_";
  protected final String TEXT_115 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_117 = ".Id = marketoId_";
  protected final String TEXT_118 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_120 = ".Status = marketoStatus_";
  protected final String TEXT_121 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_122 = "\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = " = ";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\t\t";
  protected final String TEXT_129 = " = new ";
  protected final String TEXT_130 = "Struct();" + NL + "\t\t\t\t";
  protected final String TEXT_131 = "\t\t\t" + NL + "\t\t   \t\t\t";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = " = ";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = ";\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_138 = "\tjava.util.Map<String, Object> leadAllAttrList_";
  protected final String TEXT_139 = " = new java.util.HashMap<String,Object>();" + NL + "\t";
  protected final String TEXT_140 = NL + "\t\t\tif(";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = " != null){" + NL + "\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\tleadAllAttrList_";
  protected final String TEXT_144 = ".put(\"";
  protected final String TEXT_145 = "\",FormatterUtils.format_Date(";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = ", ";
  protected final String TEXT_148 = "));" + NL + "\t\t";
  protected final String TEXT_149 = NL + "\t\t\t\tleadAllAttrList_";
  protected final String TEXT_150 = ".put(\"";
  protected final String TEXT_151 = "\",String.valueOf(";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = "));" + NL + "\t\t";
  protected final String TEXT_154 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_155 = NL + "\t\tboolean hasFault_";
  protected final String TEXT_156 = " = false;" + NL + "\t\tString errorMsg_";
  protected final String TEXT_157 = " = null;" + NL + "\t\tInteger marketoId_";
  protected final String TEXT_158 = " = null;" + NL + "\t\tString marketoStatus_";
  protected final String TEXT_159 = "=null;" + NL + "\t\twhile(true){" + NL + "\t\t\ttry{" + NL + "\t\t\t\torg.talend.marketo.response.ResultSync syncLead_";
  protected final String TEXT_160 = " = client_";
  protected final String TEXT_161 = ".syncLead(";
  protected final String TEXT_162 = ",";
  protected final String TEXT_163 = ",leadAllAttrList_";
  protected final String TEXT_164 = ",false,null);" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_165 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_166 = ");" + NL + "\t\t\t\tif(client_";
  protected final String TEXT_167 = ".isAccessTokenExpired(syncLead_";
  protected final String TEXT_168 = ".getErrors())){" + NL + "\t            \tclient_";
  protected final String TEXT_169 = ".refreshToken();" + NL + "\t            \tcontinue;" + NL + "\t            }" + NL + "\t\t\t\tjava.util.List<org.talend.marketo.type.SyncStatus> syncStatus_";
  protected final String TEXT_170 = " = syncLead_";
  protected final String TEXT_171 = ".getResult();" + NL + "\t\t\t\tif(syncStatus_";
  protected final String TEXT_172 = "!=null){" + NL + "\t\t\t\t\tstatusList_";
  protected final String TEXT_173 = ".add(syncStatus_";
  protected final String TEXT_174 = ");" + NL + "\t\t\t\t\torg.talend.marketo.type.SyncStatus status_";
  protected final String TEXT_175 = " = syncStatus_";
  protected final String TEXT_176 = ".get(0);" + NL + "\t\t\t\t\tif (status_";
  protected final String TEXT_177 = ".getReasons()==null) {" + NL + "\t\t\t\t\t\thasFault_";
  protected final String TEXT_178 = " = false;" + NL + "\t\t\t\t\t\tmarketoId_";
  protected final String TEXT_179 = " = status_";
  protected final String TEXT_180 = ".getId();" + NL + "\t\t\t\t\t\tmarketoStatus_";
  protected final String TEXT_181 = " = status_";
  protected final String TEXT_182 = ".getStatus();" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\thasFault_";
  protected final String TEXT_183 = " = true;" + NL + "\t\t\t\t\t\tmarketoStatus_";
  protected final String TEXT_184 = " = status_";
  protected final String TEXT_185 = ".getStatus();" + NL + "\t\t\t\t\t\tthrow new Exception(status_";
  protected final String TEXT_186 = ".getReasons().toString());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_187 = "){" + NL + "\t\t\t\thasFault_";
  protected final String TEXT_188 = " = true;" + NL + "\t\t\t\t";
  protected final String TEXT_189 = NL + "\t                throw(ex_";
  protected final String TEXT_190 = ");" + NL + "\t            ";
  protected final String TEXT_191 = NL + "\t\t\t\t\t\t\tmarketoId_";
  protected final String TEXT_192 = " = ";
  protected final String TEXT_193 = ".id;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\t\t\terrorMsg_";
  protected final String TEXT_195 = " = ex_";
  protected final String TEXT_196 = ".getMessage();" + NL + "\t\t\t\t\t";
  protected final String TEXT_197 = NL + "\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_198 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_199 = NL + "\t\t\t}" + NL + "\t\t\tbreak;" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_200 = NL + "\t\t// Note: batchSize should be <300" + NL + "\t\tleadRecordList_";
  protected final String TEXT_201 = ".add(leadAllAttrList_";
  protected final String TEXT_202 = ");" + NL + "\t\tif(leadRecordList_";
  protected final String TEXT_203 = ".size()>=";
  protected final String TEXT_204 = "){" + NL + "\t\t\twhile(true){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\torg.talend.marketo.response.ResultSync syncLeads_";
  protected final String TEXT_205 = " = client_";
  protected final String TEXT_206 = ".syncMultipleLeads(";
  protected final String TEXT_207 = ",";
  protected final String TEXT_208 = ",leadRecordList_";
  protected final String TEXT_209 = ",false,null);" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_210 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_211 = ");" + NL + "\t\t\t\t\tif(client_";
  protected final String TEXT_212 = ".isAccessTokenExpired(syncLeads_";
  protected final String TEXT_213 = ".getErrors())){" + NL + "\t            \t\tclient_";
  protected final String TEXT_214 = ".refreshToken();" + NL + "\t            \t\tcontinue;" + NL + "\t            \t}" + NL + "\t            \tif(syncLeads_";
  protected final String TEXT_215 = ".getErrors() == null){" + NL + "\t            \t\tstatusList_";
  protected final String TEXT_216 = ".add(syncLeads_";
  protected final String TEXT_217 = ".getResult());" + NL + "\t            \t}else{" + NL + "\t            \t\tthrow(new java.lang.Exception(syncLeads_";
  protected final String TEXT_218 = ".getErrors().toString()));" + NL + "\t            \t}" + NL + "\t\t\t\t }catch(java.lang.Exception ex_";
  protected final String TEXT_219 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_221 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_222 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_223 = ".getMessage());" + NL + "\t\t\t        ";
  protected final String TEXT_224 = NL + "\t\t\t\t}" + NL + "\t\t\t\tleadRecordList_";
  protected final String TEXT_225 = ".clear();" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_226 = NL + "\t\t\t\t\tif (!hasFault_";
  protected final String TEXT_227 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_228 = " = new ";
  protected final String TEXT_229 = "Struct();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_231 = ".id = marketoId_";
  protected final String TEXT_232 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_233 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_234 = ".ERROR_MSG = marketoStatus_";
  protected final String TEXT_235 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_236 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_237 = ".Status = marketoStatus_";
  protected final String TEXT_238 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_239 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_240 = ".";
  protected final String TEXT_241 = " = ";
  protected final String TEXT_242 = ".";
  protected final String TEXT_243 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_244 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_245 = NL + "\t\t\tif(hasFault_";
  protected final String TEXT_246 = "){\t" + NL + "\t\t\t\t";
  protected final String TEXT_247 = " = new ";
  protected final String TEXT_248 = "Struct();" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_249 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_250 = ".id = marketoId_";
  protected final String TEXT_251 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_252 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_253 = ".ERROR_MSG = errorMsg_";
  protected final String TEXT_254 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_255 = "\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_256 = ".";
  protected final String TEXT_257 = " = ";
  protected final String TEXT_258 = ".";
  protected final String TEXT_259 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_260 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_261 = NL + "\t\t\t\t\t";
  protected final String TEXT_262 = " = new ";
  protected final String TEXT_263 = "Struct();" + NL + "\t\t\t\t";
  protected final String TEXT_264 = "\t\t\t" + NL + "\t\t   \t\t\t";
  protected final String TEXT_265 = ".";
  protected final String TEXT_266 = " = ";
  protected final String TEXT_267 = ".";
  protected final String TEXT_268 = ";\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_269 = NL + "\t\t\t\t\t";
  protected final String TEXT_270 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName().replace("_Out","");
	
	String operation = ElementParameterParser.getValue(node, "__OPERATION__");
	boolean deDupenabled = ("true").equals(ElementParameterParser.getValue(node,"__DE_DUPENABLED__"));
	String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
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
	if(outgoingConns!=null){
		for (int i=0;i<outgoingConns.size();i++) {
	    IConnection outgoingConn = outgoingConns.get(i);
	    	if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_2);
    
	    	}
	    }
	}   	
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	for (IConnection conn : conns) {//1
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//2
			List<IMetadataTable> metadatas = node.getMetadataList();
			if ((metadatas!=null)&&(metadatas.size()>0)) {//3
			    IMetadataTable metadata = conn.getMetadataTable();
			    if (metadata!=null) {//4
		    		boolean useSoapAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_SOAP_API__"));
					boolean useRestAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_REST_API__"));
					if(useSoapAPI){
					
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	List<Map<String, String>> mappingList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MAPPING_INPUT__");
	Map<String,String> fldMapping = new HashMap<String,String>();
	for(Map<String,String> inputMapping:mappingList){
		String mapStr = inputMapping.get("PARAMETER_NAME");
		if("\"\"".equals(mapStr)){
			fldMapping.put(inputMapping.get("SCHEMA_COLUMN"),"\""+inputMapping.get("SCHEMA_COLUMN")+"\"");
		}else{	
			fldMapping.put(inputMapping.get("SCHEMA_COLUMN"),inputMapping.get("PARAMETER_NAME"));
		}
	}
	List<IMetadataColumn> columns = metadata.getListColumns();
	int sizeColumns = columns.size();
	for (int i = 0; i < sizeColumns; i++) {
		IMetadataColumn column = columns.get(i);
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
		String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
		
		if(!isPrimitive) {
		
    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_8);
    
		}
		if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date
		
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_14);
    
		} else {//others	
		
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    
		}
		if(!isPrimitive) {
		
    stringBuffer.append(TEXT_20);
    
		}
	}
	if("syncLead".equals(operation)){
	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
			if (dieOnError) {
            
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
            } else {
				if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
				
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
				}else{
				
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
				}
			}
			
    stringBuffer.append(TEXT_62);
    
	}else if("syncMultipleLeads".equals(operation)){
	
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(batchSize);
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
    stringBuffer.append(deDupenabled);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
		        if (dieOnError) {
		        
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
		        } else {
		        
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
		        }
		        
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
	}
	if("syncLead".equals(operation)){
		 for(IConnection outgoingConn : outgoingConns) {
        	if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
            	if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
						IMetadataTable outputMetadata = metadatas.get(0);
						if(outputMetadata!=null){
							for (IMetadataColumn column: outputMetadata.getListColumns()) {
								if("Id".equals(column.getLabel())){
								
    stringBuffer.append(TEXT_98);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
								}else if("Status".equals(column.getLabel())){
								
    stringBuffer.append(TEXT_101);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
								}else{
								
    stringBuffer.append(TEXT_104);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_108);
    
								}
							}
						}
						
    stringBuffer.append(TEXT_109);
    
				}
			}
		}
		if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
		
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
				IMetadataTable outputMetadata = metadatas.get(0);
				if(outputMetadata!=null){
					for (IMetadataColumn column: outputMetadata.getListColumns()) {
						if("Id".equals(column.getLabel())){
						
    stringBuffer.append(TEXT_116);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
						}else if("Status".equals(column.getLabel())){
						
    stringBuffer.append(TEXT_119);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
						}else{
						
    stringBuffer.append(TEXT_122);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_126);
    
						}				 
					}
				}
				
    stringBuffer.append(TEXT_127);
    
		}
	}else{//syncLead end 
		 for(IConnection outgoingConn : outgoingConns) {
	    	if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
	        	if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				
    stringBuffer.append(TEXT_128);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_130);
    
				for (IMetadataColumn column: metadata.getListColumns()) {
				
    stringBuffer.append(TEXT_131);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_135);
    
				}
				}
			}
		}
	}//syncMultipleLeads end
	
    stringBuffer.append(TEXT_136);
    
					}
					if(useRestAPI){
					
    stringBuffer.append(TEXT_137);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
	String operationType = ElementParameterParser.getValue(node,"__OPERATION_TYPE__");
	String lookupField = ElementParameterParser.getValue(node,"__LOOKUP_FIELD__");
	if(deDupenabled){
		operationType = null;
		lookupField = null;
	}else{
		operationType = "\""+operationType+"\"";
		lookupField = "\""+lookupField+"\"";
	}
	List<IMetadataColumn> columns = metadata.getListColumns();
	int sizeColumns = columns.size();
	for (int i = 0; i < sizeColumns; i++) {
		IMetadataColumn column = columns.get(i);
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
		String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
		if("id".equals(column.getLabel()) && !"id".equals(lookupField)){
				continue;
		}
		if(!isPrimitive) {
		
    stringBuffer.append(TEXT_140);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_142);
    
		}
		if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date
		
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_148);
    
		} else {//others	
		
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_153);
    
		}
		if(!isPrimitive) {
		
    stringBuffer.append(TEXT_154);
    
		}
	}
	if("syncLead".equals(operation)){
	
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
    stringBuffer.append(operationType);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(lookupField);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
				if (dieOnError) {
	            
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
	            } else {
					if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
						if(metadata.getColumn("id") != null){
						
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_193);
    
						}
						
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
					}else{
					
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    
					}
				}
				
    stringBuffer.append(TEXT_199);
    
	}else if("syncMultipleLeads".equals(operation)){
	
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(operationType);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(lookupField);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    
			        } else {
			        
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    
			        }
			        
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    
	}
	if("syncLead".equals(operation)){
		 for(IConnection outgoingConn : outgoingConns) {
        	if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
            	if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_228);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_229);
    
						IMetadataTable outputMetadata = metadatas.get(0);
						if(outputMetadata!=null){
							for (IMetadataColumn column: outputMetadata.getListColumns()) {
								if("id".equals(column.getLabel())){
								
    stringBuffer.append(TEXT_230);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
								}else if("ERROR_MSG".equals(column.getLabel())){
								
    stringBuffer.append(TEXT_233);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    
								}else if("Status".equals(column.getLabel())){
								
    stringBuffer.append(TEXT_236);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    
								}else{
								
    stringBuffer.append(TEXT_239);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_243);
    
								}
							}
						}
						
    stringBuffer.append(TEXT_244);
    
				}
			}
		}
		if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
		
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_248);
    
				IMetadataTable outputMetadata = metadatas.get(0);
				if(outputMetadata!=null){
					for (IMetadataColumn column: outputMetadata.getListColumns()) {
						if("id".equals(column.getLabel())){
						
    stringBuffer.append(TEXT_249);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    
						}else if("Status".equals(column.getLabel())){
						
    stringBuffer.append(TEXT_252);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    
						}else{
						
    stringBuffer.append(TEXT_255);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_259);
    
						}				 
					}
				}
				
    stringBuffer.append(TEXT_260);
    
		}
	}else{//syncLead end 
		 for(IConnection outgoingConn : outgoingConns) {
	    	if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
	        	if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				
    stringBuffer.append(TEXT_261);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_262);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_263);
    
				for (IMetadataColumn column: metadata.getListColumns()) {
				
    stringBuffer.append(TEXT_264);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_265);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_268);
    
				}
				}
			}
		}
	}//syncMultipleLeads end
	
    stringBuffer.append(TEXT_269);
    
					}
				}//4
			}//3
		}//2
	}//1

    stringBuffer.append(TEXT_270);
    return stringBuffer.toString();
  }
}
