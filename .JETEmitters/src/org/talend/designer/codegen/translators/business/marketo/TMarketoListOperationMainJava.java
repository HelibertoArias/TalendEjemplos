package org.talend.designer.codegen.translators.business.marketo;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TMarketoListOperationMainJava
{
  protected static String nl;
  public static synchronized TMarketoListOperationMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoListOperationMainJava result = new TMarketoListOperationMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\t\t";
  protected final String TEXT_2 = " = null;\t\t\t" + NL + "\t";
  protected final String TEXT_3 = NL + "\t\t\t\t\t";
  protected final String TEXT_4 = NL + "\tif(firstList_";
  protected final String TEXT_5 = "){" + NL + "\t\tlistTypeFlag_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ".ListKeyType;" + NL + "\t\tlistValueFlag_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ".ListKeyValue;" + NL + "\t\tfirstList_";
  protected final String TEXT_10 = " = false;" + NL + "\t}" + NL + "\tif(!listTypeFlag_";
  protected final String TEXT_11 = ".equals(";
  protected final String TEXT_12 = ".ListKeyType) || !listValueFlag_";
  protected final String TEXT_13 = ".equals(";
  protected final String TEXT_14 = ".ListKeyValue)){" + NL + "\t\ttry{" + NL + "\t\t\tclient_";
  protected final String TEXT_15 = ".listOperation(\"";
  protected final String TEXT_16 = "\",listTypeFlag_";
  protected final String TEXT_17 = ",listValueFlag_";
  protected final String TEXT_18 = ",leadKeyList_";
  protected final String TEXT_19 = ".toArray(new com.marketo.www.mktows.LeadKey[leadKeyList_";
  protected final String TEXT_20 = ".size()]),";
  protected final String TEXT_21 = ");" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_22 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_23 = ");\t\t" + NL + "\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_24 = "){" + NL + "\t\t\tif(ex_";
  protected final String TEXT_25 = " instanceof org.apache.axis.AxisFault){" + NL + "    \t\t\tif(!client_";
  protected final String TEXT_26 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_27 = ")){" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_28 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_29 = ");\t\t" + NL + "\t\t\t\t}" + NL + "    \t\t}" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t            throw(ex_";
  protected final String TEXT_31 = ");" + NL + "\t        ";
  protected final String TEXT_32 = NL + "\t        \tSystem.err.println(ex_";
  protected final String TEXT_33 = ".getMessage());" + NL + "\t        ";
  protected final String TEXT_34 = NL + "\t\t}" + NL + "\t\tleadKeyList_";
  protected final String TEXT_35 = ".clear();" + NL + "\t\tlistTypeFlag_";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = ".ListKeyType;" + NL + "\t\tlistValueFlag_";
  protected final String TEXT_38 = " = ";
  protected final String TEXT_39 = ".ListKeyValue;" + NL + "\t}" + NL + "\tleadKeyList_";
  protected final String TEXT_40 = ".add(client_";
  protected final String TEXT_41 = ".getLeadKey(";
  protected final String TEXT_42 = ".LeadKeyType,";
  protected final String TEXT_43 = ".LeadKeyValue));";
  protected final String TEXT_44 = " " + NL + "\tleadKeyList_";
  protected final String TEXT_45 = ".add(client_";
  protected final String TEXT_46 = ".getLeadKey(";
  protected final String TEXT_47 = ".LeadKeyType,";
  protected final String TEXT_48 = ".LeadKeyValue));" + NL + "\ttry{" + NL + "\t\twhetherReject_";
  protected final String TEXT_49 = " = false;" + NL + "\t\tresultListOperation_";
  protected final String TEXT_50 = " = client_";
  protected final String TEXT_51 = ".listOperation(\"";
  protected final String TEXT_52 = "\",";
  protected final String TEXT_53 = ".ListKeyType,";
  protected final String TEXT_54 = ".ListKeyValue,leadKeyList_";
  protected final String TEXT_55 = ".toArray(new com.marketo.www.mktows.LeadKey[leadKeyList_";
  protected final String TEXT_56 = ".size()]),";
  protected final String TEXT_57 = ");" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_58 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_59 = ");" + NL + "\t}catch(java.lang.Exception ex_";
  protected final String TEXT_60 = "){" + NL + "\t\tif(ex_";
  protected final String TEXT_61 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t\tif(!client_";
  protected final String TEXT_62 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_63 = ")){" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_64 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_65 = ");\t\t" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\twhetherReject_";
  protected final String TEXT_66 = " = true;" + NL + "\t\t";
  protected final String TEXT_67 = NL + "            throw(ex_";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "            \t";
  protected final String TEXT_70 = " = new ";
  protected final String TEXT_71 = "Struct();";
  protected final String TEXT_72 = NL + "                ";
  protected final String TEXT_73 = ".ListKeyType = ";
  protected final String TEXT_74 = ".ListKeyType;";
  protected final String TEXT_75 = NL + "                ";
  protected final String TEXT_76 = ".ListKeyValue = ";
  protected final String TEXT_77 = ".ListKeyValue;";
  protected final String TEXT_78 = NL + "                ";
  protected final String TEXT_79 = ".LeadKeyType = ";
  protected final String TEXT_80 = ".LeadKeyType;";
  protected final String TEXT_81 = NL + "                ";
  protected final String TEXT_82 = ".LeadKeyValue = ";
  protected final String TEXT_83 = ".LeadKeyValue;" + NL + "            \t";
  protected final String TEXT_84 = ".ERROR_MSG = ex_";
  protected final String TEXT_85 = ".getMessage();";
  protected final String TEXT_86 = NL + "        \t\tSystem.err.println(ex_";
  protected final String TEXT_87 = ".getMessage());" + NL + "        \t";
  protected final String TEXT_88 = NL + "\t}" + NL + "\tleadKeyList_";
  protected final String TEXT_89 = ".clear();";
  protected final String TEXT_90 = "\t\t" + NL + "\t\t";
  protected final String TEXT_91 = NL + "\t\t\tif(!whetherReject_";
  protected final String TEXT_92 = "){" + NL + "\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\t";
  protected final String TEXT_94 = " = new ";
  protected final String TEXT_95 = "Struct();" + NL + "\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t\t";
  protected final String TEXT_97 = ".Success = resultListOperation_";
  protected final String TEXT_98 = ".isSuccess();" + NL + "\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t";
  protected final String TEXT_100 = "\t\t\t" + NL + "\t\t   \t\t\t";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = " = ";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = "; \t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_105 = NL + "\t\t";
  protected final String TEXT_106 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_107 = NL + NL + NL + NL + "\t\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\t\t";
  protected final String TEXT_109 = NL + "\tif(firstList_";
  protected final String TEXT_110 = "){" + NL + "\t\tlistIdFlag_";
  protected final String TEXT_111 = " = ";
  protected final String TEXT_112 = ".ListId;" + NL + "\t\tfirstList_";
  protected final String TEXT_113 = " = false;" + NL + "\t}" + NL + "\tif(!listIdFlag_";
  protected final String TEXT_114 = ".equals(";
  protected final String TEXT_115 = ".ListId)){" + NL + "\t\twhile(true){" + NL + "\t\t\ttry{" + NL + "\t\t\t\tresultListOperation_";
  protected final String TEXT_116 = " = client_";
  protected final String TEXT_117 = ".listOperation(\"";
  protected final String TEXT_118 = "\",listIdFlag_";
  protected final String TEXT_119 = ",leadKeyList_";
  protected final String TEXT_120 = ");" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_121 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_122 = ");" + NL + "\t\t\t\tif(client_";
  protected final String TEXT_123 = ".isAccessTokenExpired(resultListOperation_";
  protected final String TEXT_124 = ".getErrors())){" + NL + "            \t\tclient_";
  protected final String TEXT_125 = ".refreshToken();" + NL + "            \t\tcontinue;" + NL + "            \t}\t" + NL + "\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_126 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\t            throw(ex_";
  protected final String TEXT_128 = ");" + NL + "\t\t        ";
  protected final String TEXT_129 = NL + "\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_130 = ".getMessage());" + NL + "\t\t        ";
  protected final String TEXT_131 = NL + "\t\t\t}" + NL + "\t\t\tleadKeyList_";
  protected final String TEXT_132 = ".clear();" + NL + "\t\t\tlistIdFlag_";
  protected final String TEXT_133 = " = ";
  protected final String TEXT_134 = ".ListId;" + NL + "\t\t\tbreak;" + NL + "\t\t}" + NL + "\t}" + NL + "\tleadKeyList_";
  protected final String TEXT_135 = ".add(";
  protected final String TEXT_136 = ".LeadId);";
  protected final String TEXT_137 = " " + NL + "\tleadKeyList_";
  protected final String TEXT_138 = ".add(";
  protected final String TEXT_139 = ".LeadId);" + NL + "\tString status";
  protected final String TEXT_140 = " = \"failes\";" + NL + "\twhile(true){" + NL + "\t\ttry{" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_141 = " = false;" + NL + "\t\t\tresultListOperation_";
  protected final String TEXT_142 = " = client_";
  protected final String TEXT_143 = ".listOperation(\"";
  protected final String TEXT_144 = "\",";
  protected final String TEXT_145 = ".ListId,leadKeyList_";
  protected final String TEXT_146 = ");" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_147 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_148 = ");" + NL + "\t\t\tif(client_";
  protected final String TEXT_149 = ".isAccessTokenExpired(resultListOperation_";
  protected final String TEXT_150 = ".getErrors())){" + NL + "        \t\tclient_";
  protected final String TEXT_151 = ".refreshToken();" + NL + "        \t\tcontinue;" + NL + "        \t}\t" + NL + "\t\t\torg.talend.marketo.type.SyncStatus statusObj_";
  protected final String TEXT_152 = " = resultListOperation_";
  protected final String TEXT_153 = ".getResult().get(0);" + NL + "\t\t\tif(statusObj_";
  protected final String TEXT_154 = ".getReasons()!=null){" + NL + "\t\t\t\tthrow new Exception(statusObj_";
  protected final String TEXT_155 = ".getReasons().toString());\t\t" + NL + "\t\t\t}" + NL + "\t\t\tstatus";
  protected final String TEXT_156 = " = statusObj_";
  protected final String TEXT_157 = ".getStatus();" + NL + "\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_158 = "){" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_159 = " = true;" + NL + "\t\t\t";
  protected final String TEXT_160 = NL + "\t            throw(ex_";
  protected final String TEXT_161 = ");" + NL + "\t        ";
  protected final String TEXT_162 = NL + "\t            \t";
  protected final String TEXT_163 = " = new ";
  protected final String TEXT_164 = "Struct();" + NL + "\t                ";
  protected final String TEXT_165 = ".ListId = ";
  protected final String TEXT_166 = ".ListId;" + NL + "\t                ";
  protected final String TEXT_167 = ".LeadId = ";
  protected final String TEXT_168 = ".LeadId;" + NL + "\t                ";
  protected final String TEXT_169 = ".Status = status";
  protected final String TEXT_170 = ";" + NL + "\t            \t";
  protected final String TEXT_171 = ".ERROR_MSG = ex_";
  protected final String TEXT_172 = ".getMessage();" + NL + "\t            ";
  protected final String TEXT_173 = NL + "\t        \t\tSystem.err.println(ex_";
  protected final String TEXT_174 = ".getMessage());" + NL + "\t        \t";
  protected final String TEXT_175 = NL + "\t\t}" + NL + "\t\tleadKeyList_";
  protected final String TEXT_176 = ".clear();" + NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_177 = "\t\t" + NL + "\t\t";
  protected final String TEXT_178 = NL + "\t\t\tif(!whetherReject_";
  protected final String TEXT_179 = "){" + NL + "\t\t";
  protected final String TEXT_180 = NL + "\t\t\t\t";
  protected final String TEXT_181 = " = new ";
  protected final String TEXT_182 = "Struct();" + NL + "\t\t\t\t";
  protected final String TEXT_183 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_184 = ".Status = status";
  protected final String TEXT_185 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_186 = "\t\t\t" + NL + "\t\t\t\t   \t\t\t";
  protected final String TEXT_187 = ".";
  protected final String TEXT_188 = " = ";
  protected final String TEXT_189 = ".";
  protected final String TEXT_190 = "; \t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_191 = NL + "\t\t";
  protected final String TEXT_192 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_193 = NL + "\t\t\t\t";
  protected final String TEXT_194 = NL + NL;
  protected final String TEXT_195 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    
	String operation = ElementParameterParser.getValue(node, "__OPERATION__");
	boolean mutipleOperation = ("true").equals(ElementParameterParser.getValue(node,"__MUTIPLE_OPERATION__"));
	boolean isMutiple = false;
	if(mutipleOperation&&!operation.equals("ISMEMBEROFLIST")){
		isMutiple = true;
	}
	boolean strict = ("true").equals(ElementParameterParser.getValue(node,"__STRICT__"));
	
	String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    
    IConnection mainConn = null;
    String mainConnName = null;
    List<? extends IConnection> mainConns = node.getOutgoingConnections("OUTPUT_MAIN");
    if(mainConns != null && mainConns.size() > 0) {
        mainConn = mainConns.get(0);
        mainConnName = mainConn.getName();
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
	
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    
    if (metadata!=null) {//2
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
    			boolean useSoapAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_SOAP_API__"));
				boolean useRestAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_REST_API__"));
				if(useSoapAPI){
				
    stringBuffer.append(TEXT_3);
    if(isMutiple){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(operation);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(strict);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
	        if (strict) {
	        
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
	        } else {
	        
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
	        }
	        
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_43);
    }else{
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(operation);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(strict);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
        if (strict) {
        
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
        } else {
        	if(rejectConnName != null) {
            
    stringBuffer.append(TEXT_69);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
            } else {
            
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
        	}
        }
        
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    }		
	 if(mainConnName != null){

    stringBuffer.append(TEXT_90);
    if(!isMutiple){
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    stringBuffer.append(mainConnName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(mainConnName);
    stringBuffer.append(TEXT_95);
    if(!isMutiple){
    stringBuffer.append(TEXT_96);
    stringBuffer.append(mainConnName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    }
    stringBuffer.append(TEXT_99);
    
				for (IMetadataColumn column: metadata.getListColumns()) {
					if(!isMutiple){
						if("Success".equals(column.getLabel()))
							continue;
					}
					
    stringBuffer.append(TEXT_100);
    stringBuffer.append(mainConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_104);
     					 
				}
				
    stringBuffer.append(TEXT_105);
    if(!isMutiple){
    stringBuffer.append(TEXT_106);
    
		}
	}

    stringBuffer.append(TEXT_107);
    
				}
				if(useRestAPI){
				
    stringBuffer.append(TEXT_108);
    if(isMutiple){
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(operation);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
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
    
		        if (strict) {
		        
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
		        } else {
		        
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
		        }
		        
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_136);
    }else{
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(operation);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
	        if (strict) {
	        
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
	        } else {
	        	if(rejectConnName != null) {
	            
    stringBuffer.append(TEXT_162);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
	            } else {
	            
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    
	        	}
	        }
	        
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    }		
	 if(mainConnName != null){
	
    stringBuffer.append(TEXT_177);
    if(!isMutiple){
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    }
    stringBuffer.append(TEXT_180);
    stringBuffer.append(mainConnName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(mainConnName);
    stringBuffer.append(TEXT_182);
    
				if(mainConn!=null){
					IMetadataTable outTable = mainConn.getMetadataTable();
					if(outTable!=null && outTable.getListColumns()!=null){
						for (IMetadataColumn column: outTable.getListColumns()) {
							if("Status".equals(column.getLabel())){
								if(!isMutiple){
								
    stringBuffer.append(TEXT_183);
    stringBuffer.append(mainConnName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    
								}
								continue;
							}
							
    stringBuffer.append(TEXT_186);
    stringBuffer.append(mainConnName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_190);
    
						}
					}
				}
			
    stringBuffer.append(TEXT_191);
    if(!isMutiple){
    stringBuffer.append(TEXT_192);
    
		}
	}

    stringBuffer.append(TEXT_193);
    
				}
			}//4
		}//3
	}//2
}//1

    stringBuffer.append(TEXT_194);
    stringBuffer.append(TEXT_195);
    return stringBuffer.toString();
  }
}
