package org.talend.designer.codegen.translators.business.marketo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMarketoInputBeginJava
{
  protected static String nl;
  public static synchronized TMarketoInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMarketoInputBeginJava result = new TMarketoInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "int nb_call_";
  protected final String TEXT_2 = " = 0;" + NL + "globalMap.put(\"";
  protected final String TEXT_3 = "_NB_CALL\",0);  ";
  protected final String TEXT_4 = NL + "            \t" + NL + "            \tint reConnMaxNum_";
  protected final String TEXT_5 = "=";
  protected final String TEXT_6 = ";" + NL + "\t\t\t\treConnMaxNum_";
  protected final String TEXT_7 = " = reConnMaxNum_";
  protected final String TEXT_8 = " >0 ?reConnMaxNum_";
  protected final String TEXT_9 = ":1;" + NL + "\t" + NL + "\t            ";
  protected final String TEXT_10 = NL + "\t            " + NL + "\t            ";
  protected final String TEXT_11 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_12 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = "; ";
  protected final String TEXT_17 = NL + "            \t" + NL + "            \t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\tString[] includeTypes_";
  protected final String TEXT_20 = " = " + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tnull;" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\tnew String[]{\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_23 = "\t" + NL + "\t\t\t\t\t\"";
  protected final String TEXT_24 = "\",\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t};" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "        \tString[] excludeTypes_";
  protected final String TEXT_27 = " = " + NL + "\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\tnull;" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tnew String[]{\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_30 = "\t" + NL + "\t\t\t\t\t\"";
  protected final String TEXT_31 = "\",\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t};" + NL + "\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\torg.talend.marketo.Client client_";
  protected final String TEXT_34 = " = new org.talend.marketo.Client(";
  protected final String TEXT_35 = ",decryptedPassword_";
  protected final String TEXT_36 = ",";
  protected final String TEXT_37 = ");" + NL + "\t\t\tclient_";
  protected final String TEXT_38 = ".setTimeout(";
  protected final String TEXT_39 = ");" + NL + "\t\t";
  protected final String TEXT_40 = NL + "\t\t\tcom.marketo.www.mktows.ResultGetLead leads_";
  protected final String TEXT_41 = " = null;" + NL + "\t\t\tcom.marketo.www.mktows.LeadRecord[] records_";
  protected final String TEXT_42 = " = null;" + NL + "\t\t\ttry{" + NL + "\t\t\t\tfor(int i_";
  protected final String TEXT_43 = "=0;i_";
  protected final String TEXT_44 = " <= reConnMaxNum_";
  protected final String TEXT_45 = ";i_";
  protected final String TEXT_46 = "++){" + NL + "            \t\ttry{" + NL + "                \t\tleads_";
  protected final String TEXT_47 = " = client_";
  protected final String TEXT_48 = ".getLead(\"";
  protected final String TEXT_49 = "\",";
  protected final String TEXT_50 = ");" + NL + "                \t\tbreak;\t" + NL + "\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_51 = "){" + NL + "\t\t\t\t\t\tif(ex_";
  protected final String TEXT_52 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t\t\t\t\t\tString faultStr_";
  protected final String TEXT_53 = " = ((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_54 = ").getFaultString();" + NL + "\t\t\t\t\t\t\tif(faultStr_";
  protected final String TEXT_55 = "!=null && faultStr_";
  protected final String TEXT_56 = ".startsWith(\"201\")){" + NL + "\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_57 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(i_";
  protected final String TEXT_58 = " != reConnMaxNum_";
  protected final String TEXT_59 = "){" + NL + "\t\t\t\t\t\t\tSystem.err.println(\"Connection error:\");" + NL + "\t\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_60 = ".getMessage());" + NL + "\t\t\t\t\t\t\tSystem.err.println(\"Waiting to retry...\");" + NL + "\t\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_61 = ");" + NL + "\t\t\t\t\t\t\tSystem.err.println(\"Attempting to reconnect...\");" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_62 = ";" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "                }" + NL + "\t\t\t\t" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_63 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_64 = ");  " + NL + "\t\t\t\t" + NL + "\t\t\t\trecords_";
  protected final String TEXT_65 = " = leads_";
  protected final String TEXT_66 = ".getLeadRecordList();" + NL + "\t\t\t}catch(org.apache.axis.AxisFault axisFault_";
  protected final String TEXT_67 = "){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tif(!client_";
  protected final String TEXT_68 = ".isSystemError(axisFault_";
  protected final String TEXT_69 = ")){" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_70 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_71 = ");  " + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tclient_";
  protected final String TEXT_72 = ".inputExceptionFilter(axisFault_";
  protected final String TEXT_73 = ");" + NL + "\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_74 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_75 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_76 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_77 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_78 = ".getMessage());" + NL + "\t\t\t        ";
  protected final String TEXT_79 = NL + "\t\t\t\t}" + NL + "\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_80 = "){" + NL + "\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t            throw(ex_";
  protected final String TEXT_82 = ");" + NL + "\t\t        ";
  protected final String TEXT_83 = NL + "\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_84 = ".getMessage());" + NL + "\t\t        ";
  protected final String TEXT_85 = NL + "\t\t\t}" + NL + "\t\t\tif(leads_";
  protected final String TEXT_86 = " != null && records_";
  protected final String TEXT_87 = "!=null){" + NL + "\t\t\t\tfor (int i_";
  protected final String TEXT_88 = " = 0; i_";
  protected final String TEXT_89 = " < leads_";
  protected final String TEXT_90 = ".getCount(); i_";
  protected final String TEXT_91 = "++) {" + NL + "\t            \tjava.util.Map<String, String> result_";
  protected final String TEXT_92 = " = client_";
  protected final String TEXT_93 = ".readLead(records_";
  protected final String TEXT_94 = "[i_";
  protected final String TEXT_95 = "]);";
  protected final String TEXT_96 = NL + "            String streamPosition_";
  protected final String TEXT_97 = " = null;" + NL + "            String[] includeAttributes_";
  protected final String TEXT_98 = " = new String[]{" + NL + "\t\t\t";
  protected final String TEXT_99 = "\t" + NL + "    \t\t\t";
  protected final String TEXT_100 = ",\t\t" + NL + "\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t};" + NL + "\t\t\tcom.marketo.www.mktows.LeadSelector selector_";
  protected final String TEXT_102 = " = new com.marketo.www.mktows.";
  protected final String TEXT_103 = "();" + NL + "\t\t\t";
  protected final String TEXT_104 = NL + "\t\t\t\tfor(String[] valuesArray_";
  protected final String TEXT_105 = ":leadKeyValues_";
  protected final String TEXT_106 = "){" + NL + "\t\t\t\t\tselector_";
  protected final String TEXT_107 = " = org.talend.marketo.SelectorUtil.getLeadKeySelector(\"";
  protected final String TEXT_108 = "\",valuesArray_";
  protected final String TEXT_109 = ");" + NL + "\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\t\tselector_";
  protected final String TEXT_111 = " = org.talend.marketo.SelectorUtil.getStaticListSelectorByName(";
  protected final String TEXT_112 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t\t\tselector_";
  protected final String TEXT_114 = " = org.talend.marketo.SelectorUtil.getStaticListSelectorByID(";
  protected final String TEXT_115 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\tselector_";
  protected final String TEXT_117 = " =  org.talend.marketo.SelectorUtil.getLastUpdateAtSelector(";
  protected final String TEXT_118 = ",";
  protected final String TEXT_119 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_120 = NL + "            while(true){" + NL + "            \tcom.marketo.www.mktows.ResultGetMultipleLeads leads_";
  protected final String TEXT_121 = " = null;" + NL + "            \ttry{ " + NL + "\t\t\t\t\tfor(int i_";
  protected final String TEXT_122 = "=0;i_";
  protected final String TEXT_123 = " <= reConnMaxNum_";
  protected final String TEXT_124 = ";i_";
  protected final String TEXT_125 = "++){" + NL + "\t            \t\ttry{" + NL + "\t                \t\tleads_";
  protected final String TEXT_126 = " = client_";
  protected final String TEXT_127 = ".getMultipleLeads(includeAttributes_";
  protected final String TEXT_128 = ", ";
  protected final String TEXT_129 = ", streamPosition_";
  protected final String TEXT_130 = ",selector_";
  protected final String TEXT_131 = ");" + NL + "\t                \t\tbreak;\t" + NL + "\t\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_132 = "){" + NL + "\t\t\t\t\t\t\tif(ex_";
  protected final String TEXT_133 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t\t\t\t\t\t\tString faultStr_";
  protected final String TEXT_134 = " = ((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_135 = ").getFaultString();" + NL + "\t\t\t\t\t\t\t\tif(faultStr_";
  protected final String TEXT_136 = "!=null && faultStr_";
  protected final String TEXT_137 = ".startsWith(\"201\")){" + NL + "\t\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_138 = ";" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(i_";
  protected final String TEXT_139 = " != reConnMaxNum_";
  protected final String TEXT_140 = "){" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Connection error:\");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_141 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Waiting to retry...\");" + NL + "\t\t\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_142 = ");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Attempting to reconnect...\");" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_143 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t                }" + NL + "            \t\tglobalMap.put(\"";
  protected final String TEXT_144 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_145 = ");" + NL + "            \t}catch(java.lang.Exception ex_";
  protected final String TEXT_146 = "){" + NL + "            \t\tif(ex_";
  protected final String TEXT_147 = " instanceof org.apache.axis.AxisFault){" + NL + "            \t\t\tif(!client_";
  protected final String TEXT_148 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_149 = ")){" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_150 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_151 = ");\t\t" + NL + "\t\t\t\t\t\t}" + NL + "            \t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_153 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_154 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_155 = ".getMessage());" + NL + "\t\t\t\t        break;" + NL + "\t\t\t        ";
  protected final String TEXT_156 = NL + "\t\t\t\t}" + NL + "            \tif(leads_";
  protected final String TEXT_157 = " != null){" + NL + "\t            \tcom.marketo.www.mktows.LeadRecord[] records_";
  protected final String TEXT_158 = " = leads_";
  protected final String TEXT_159 = ".getLeadRecordList();" + NL + "\t            \tfor (int i_";
  protected final String TEXT_160 = " = 0; i_";
  protected final String TEXT_161 = " < leads_";
  protected final String TEXT_162 = ".getReturnCount(); i_";
  protected final String TEXT_163 = "++) {" + NL + "\t            \t\tjava.util.Map<String, String> result_";
  protected final String TEXT_164 = " = client_";
  protected final String TEXT_165 = ".readLead(records_";
  protected final String TEXT_166 = "[i_";
  protected final String TEXT_167 = "]);";
  protected final String TEXT_168 = NL + "\t\t\tcom.marketo.www.mktows.StreamPosition streamPosition_";
  protected final String TEXT_169 = " = null;" + NL + "\t\t\twhile(true){" + NL + "\t\t\t\tcom.marketo.www.mktows.LeadActivityList activities_";
  protected final String TEXT_170 = " = null;" + NL + "\t\t\t\tcom.marketo.www.mktows.ActivityRecord[] activityRecords_";
  protected final String TEXT_171 = " = null;" + NL + "                try{" + NL + "                \tfor(int i_";
  protected final String TEXT_172 = "=0;i_";
  protected final String TEXT_173 = " <= reConnMaxNum_";
  protected final String TEXT_174 = ";i_";
  protected final String TEXT_175 = "++){" + NL + "                \t\ttry{" + NL + "\t                \t\tactivities_";
  protected final String TEXT_176 = " = client_";
  protected final String TEXT_177 = ".getLeadActivity(\"";
  protected final String TEXT_178 = "\",";
  protected final String TEXT_179 = ", ";
  protected final String TEXT_180 = ", includeTypes_";
  protected final String TEXT_181 = ", excludeTypes_";
  protected final String TEXT_182 = ",streamPosition_";
  protected final String TEXT_183 = ");" + NL + "\t                \t\tbreak;" + NL + "\t\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_184 = "){" + NL + "\t\t\t\t\t\t\tif(ex_";
  protected final String TEXT_185 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t\t\t\t\t\t\tString faultStr_";
  protected final String TEXT_186 = " = ((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_187 = ").getFaultString();" + NL + "\t\t\t\t\t\t\t\tif(faultStr_";
  protected final String TEXT_188 = "!=null && faultStr_";
  protected final String TEXT_189 = ".startsWith(\"201\")){" + NL + "\t\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_190 = ";" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(i_";
  protected final String TEXT_191 = " != reConnMaxNum_";
  protected final String TEXT_192 = "){" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Connection error:\");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_193 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Waiting to retry...\");" + NL + "\t\t\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_194 = ");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Attempting to reconnect...\");" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_195 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t                }" + NL + "\t                globalMap.put(\"";
  protected final String TEXT_196 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_197 = ");\t" + NL + "\t                activityRecords_";
  protected final String TEXT_198 = " = activities_";
  protected final String TEXT_199 = ".getActivityRecordList();" + NL + "\t            }catch(org.apache.axis.AxisFault axisFault_";
  protected final String TEXT_200 = "){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tif(!client_";
  protected final String TEXT_201 = ".isSystemError(axisFault_";
  protected final String TEXT_202 = ")){" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_203 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_204 = ");\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tclient_";
  protected final String TEXT_205 = ".inputExceptionFilter(axisFault_";
  protected final String TEXT_206 = ");" + NL + "\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_207 = "){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_208 = NL + "\t\t\t\t            throw(ex_";
  protected final String TEXT_209 = ");" + NL + "\t\t\t\t        ";
  protected final String TEXT_210 = NL + "\t\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_211 = ".getMessage());" + NL + "\t\t\t\t\t        break;" + NL + "\t\t\t\t        ";
  protected final String TEXT_212 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_213 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_214 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_215 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_216 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_217 = ".getMessage());" + NL + "\t\t\t\t        break;" + NL + "\t\t\t        ";
  protected final String TEXT_218 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif(activities_";
  protected final String TEXT_219 = " != null && activityRecords_";
  protected final String TEXT_220 = " != null){" + NL + "\t                for (int i_";
  protected final String TEXT_221 = " = 0; i_";
  protected final String TEXT_222 = " < activities_";
  protected final String TEXT_223 = ".getReturnCount(); i_";
  protected final String TEXT_224 = "++) {" + NL + "\t                    java.util.Map<String, String> result_";
  protected final String TEXT_225 = " = client_";
  protected final String TEXT_226 = ".readActivity(activityRecords_";
  protected final String TEXT_227 = "[i_";
  protected final String TEXT_228 = "]);";
  protected final String TEXT_229 = NL + "\t\t\tcom.marketo.www.mktows.StreamPosition streamPosition_";
  protected final String TEXT_230 = " = new com.marketo.www.mktows.StreamPosition();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_231 = NL + "\t\t\t\tjava.text.SimpleDateFormat oldestcreatedat_";
  protected final String TEXT_232 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss Z\");" + NL + "\t\t\t\tif(";
  protected final String TEXT_233 = " != null){" + NL + "\t\t        \toldestcreatedat_";
  protected final String TEXT_234 = ".parse(";
  protected final String TEXT_235 = ");" + NL + "\t\t            java.util.Calendar calendar_oldestcreatedat_";
  protected final String TEXT_236 = " = oldestcreatedat_";
  protected final String TEXT_237 = ".getCalendar();" + NL + "\t\t            streamPosition_";
  protected final String TEXT_238 = ".setOldestCreatedAt(calendar_oldestcreatedat_";
  protected final String TEXT_239 = ");" + NL + "\t            }";
  protected final String TEXT_240 = NL + "\t            java.text.SimpleDateFormat latestcreatedat_";
  protected final String TEXT_241 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss Z\");" + NL + "\t            if(";
  protected final String TEXT_242 = " != null){" + NL + "\t\t        \tlatestcreatedat_";
  protected final String TEXT_243 = ".parse(";
  protected final String TEXT_244 = ");" + NL + "\t\t            java.util.Calendar calendar_latestcreatedat_";
  protected final String TEXT_245 = " = latestcreatedat_";
  protected final String TEXT_246 = ".getCalendar();" + NL + "\t\t            streamPosition_";
  protected final String TEXT_247 = ".setLatestCreatedAt(calendar_latestcreatedat_";
  protected final String TEXT_248 = ");" + NL + "\t\t        }";
  protected final String TEXT_249 = NL + "            " + NL + "            com.marketo.www.mktows.LastUpdateAtSelector leadSelector_";
  protected final String TEXT_250 = " = new com.marketo.www.mktows.LastUpdateAtSelector();" + NL + "            ";
  protected final String TEXT_251 = NL + "\t\t\t\tjava.text.SimpleDateFormat oldestupdatedat_";
  protected final String TEXT_252 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss Z\");" + NL + "\t\t\t\tif(";
  protected final String TEXT_253 = " != null){" + NL + "\t\t        \toldestupdatedat_";
  protected final String TEXT_254 = ".parse(";
  protected final String TEXT_255 = ");" + NL + "\t\t            java.util.Calendar calendar_oldestupdatedat_";
  protected final String TEXT_256 = " = oldestupdatedat_";
  protected final String TEXT_257 = ".getCalendar();" + NL + "\t\t            leadSelector_";
  protected final String TEXT_258 = ".setOldestUpdatedAt(calendar_oldestupdatedat_";
  protected final String TEXT_259 = ");" + NL + "\t            }";
  protected final String TEXT_260 = NL + "\t            java.text.SimpleDateFormat latestupdatedat_";
  protected final String TEXT_261 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss Z\");" + NL + "\t            if(";
  protected final String TEXT_262 = " != null){" + NL + "\t\t        \tlatestupdatedat_";
  protected final String TEXT_263 = ".parse(";
  protected final String TEXT_264 = ");" + NL + "\t\t            java.util.Calendar calendar_latestupdatedat_";
  protected final String TEXT_265 = " = latestupdatedat_";
  protected final String TEXT_266 = ".getCalendar();" + NL + "\t\t            leadSelector_";
  protected final String TEXT_267 = ".setLatestUpdatedAt(calendar_latestupdatedat_";
  protected final String TEXT_268 = ");" + NL + "\t\t        }";
  protected final String TEXT_269 = NL + "            " + NL + "            " + NL + "            while(true){" + NL + "                com.marketo.www.mktows.ResultGetLeadChanges changes_";
  protected final String TEXT_270 = " = null;" + NL + "                try{" + NL + "\t\t\t\t\tfor(int i_";
  protected final String TEXT_271 = "=0;i_";
  protected final String TEXT_272 = " <= reConnMaxNum_";
  protected final String TEXT_273 = ";i_";
  protected final String TEXT_274 = "++){" + NL + "\t            \t\ttry{" + NL + "\t                \t\tchanges_";
  protected final String TEXT_275 = " = client_";
  protected final String TEXT_276 = ".getLeadChanges(";
  protected final String TEXT_277 = ", includeTypes_";
  protected final String TEXT_278 = ", excludeTypes_";
  protected final String TEXT_279 = ", streamPosition_";
  protected final String TEXT_280 = ", leadSelector_";
  protected final String TEXT_281 = ");" + NL + "\t                \t\tbreak;\t" + NL + "\t\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_282 = "){" + NL + "\t\t\t\t\t\t\tif(ex_";
  protected final String TEXT_283 = " instanceof org.apache.axis.AxisFault){" + NL + "\t\t\t\t\t\t\t\tString faultStr_";
  protected final String TEXT_284 = " = ((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_285 = ").getFaultString();" + NL + "\t\t\t\t\t\t\t\tif(faultStr_";
  protected final String TEXT_286 = "!=null && faultStr_";
  protected final String TEXT_287 = ".startsWith(\"201\")){" + NL + "\t\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_288 = ";" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(i_";
  protected final String TEXT_289 = " != reConnMaxNum_";
  protected final String TEXT_290 = "){" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Connection error:\");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_291 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Waiting to retry...\");" + NL + "\t\t\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_292 = ");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Attempting to reconnect...\");" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_293 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t                }" + NL + "                \tglobalMap.put(\"";
  protected final String TEXT_294 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_295 = ");" + NL + "                }catch(java.lang.Exception ex_";
  protected final String TEXT_296 = "){" + NL + "                \tif(ex_";
  protected final String TEXT_297 = " instanceof org.apache.axis.AxisFault){" + NL + "            \t\t\tif(!client_";
  protected final String TEXT_298 = ".isSystemError((org.apache.axis.AxisFault)ex_";
  protected final String TEXT_299 = ")){" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_300 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_301 = ");\t\t" + NL + "\t\t\t\t\t\t}" + NL + "            \t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_302 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_303 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_304 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_305 = ".getMessage());" + NL + "\t\t\t\t        break;" + NL + "\t\t\t        ";
  protected final String TEXT_306 = NL + "\t\t\t\t}" + NL + "                if(changes_";
  protected final String TEXT_307 = " != null){" + NL + "\t                com.marketo.www.mktows.LeadChangeRecord[] changeRecords_";
  protected final String TEXT_308 = " = changes_";
  protected final String TEXT_309 = ".getLeadChangeRecordList();" + NL + "\t                for (int i_";
  protected final String TEXT_310 = " = 0; i_";
  protected final String TEXT_311 = " < changes_";
  protected final String TEXT_312 = ".getReturnCount(); i_";
  protected final String TEXT_313 = "++) {" + NL + "\t                    java.util.Map<String, String> result_";
  protected final String TEXT_314 = " = client_";
  protected final String TEXT_315 = ".readChange(changeRecords_";
  protected final String TEXT_316 = "[i_";
  protected final String TEXT_317 = "]);";
  protected final String TEXT_318 = NL + "\t\t\t\tif(result_";
  protected final String TEXT_319 = ".get(";
  protected final String TEXT_320 = ")!=null){" + NL + "    \t\t\t";
  protected final String TEXT_321 = "\t\t\t\t" + NL + "    \t\t\t\t\t";
  protected final String TEXT_322 = ".";
  protected final String TEXT_323 = " = result_";
  protected final String TEXT_324 = ".get(";
  protected final String TEXT_325 = ");" + NL + "    \t\t\t";
  protected final String TEXT_326 = NL + "    \t\t\t\t\t";
  protected final String TEXT_327 = ".";
  protected final String TEXT_328 = " = ParserUtils.parseTo_Date(result_";
  protected final String TEXT_329 = ".get(";
  protected final String TEXT_330 = "), ";
  protected final String TEXT_331 = ");" + NL + "    \t\t\t";
  protected final String TEXT_332 = "\t\t\t\t\t\t\t" + NL + "    \t\t\t\t\t";
  protected final String TEXT_333 = ".";
  protected final String TEXT_334 = " = ParserUtils.parseTo_";
  protected final String TEXT_335 = "(result_";
  protected final String TEXT_336 = ".get(";
  protected final String TEXT_337 = "));\t" + NL + "    \t\t\t";
  protected final String TEXT_338 = NL + "    \t\t\t}else{" + NL + "    \t\t\t\t";
  protected final String TEXT_339 = ".";
  protected final String TEXT_340 = " = ";
  protected final String TEXT_341 = ";" + NL + "    \t\t\t}";
  protected final String TEXT_342 = NL + NL + NL + NL + "        " + NL + "\t\t\t\t";
  protected final String TEXT_343 = NL + "\t\t\t\t\t";
  protected final String TEXT_344 = "\t\t\t";
  protected final String TEXT_345 = NL + "\t\t\torg.talend.marketo.MarketoRestClient client_";
  protected final String TEXT_346 = " = new org.talend.marketo.MarketoRestClient(";
  protected final String TEXT_347 = ",decryptedPassword_";
  protected final String TEXT_348 = ",";
  protected final String TEXT_349 = ");" + NL + "\t\t\tclient_";
  protected final String TEXT_350 = ".setTimeOut(";
  protected final String TEXT_351 = ");" + NL + "\t\t\tclient_";
  protected final String TEXT_352 = ".refreshToken();" + NL + "\t\t\t";
  protected final String TEXT_353 = NL + "\t\t\t\t\tjava.util.Set<Integer> includeTypes_";
  protected final String TEXT_354 = " = new java.util.HashSet<Integer>(){" + NL + "                \t\t{" + NL + "\t                    \t";
  protected final String TEXT_355 = NL + "\t\t    \t\t\t\t\tadd(";
  protected final String TEXT_356 = ");" + NL + "\t\t    \t\t\t\t";
  protected final String TEXT_357 = NL + "                \t\t}" + NL + "            \t\t};" + NL + "\t\t\t\t";
  protected final String TEXT_358 = NL + "\t\t\t\t\tjava.util.Set<Integer> includeTypes_";
  protected final String TEXT_359 = " = client_";
  protected final String TEXT_360 = ".getLocalActivityTypes().keySet();" + NL + "\t\t\t\t\t";
  protected final String TEXT_361 = NL + "\t\t    \t\t\t\tincludeTypes_";
  protected final String TEXT_362 = ".remove(";
  protected final String TEXT_363 = ");" + NL + "\t\t    \t\t\t";
  protected final String TEXT_364 = NL + "\t\t\t\tString nextPageToken_";
  protected final String TEXT_365 = " = client_";
  protected final String TEXT_366 = ".getPageToken(";
  protected final String TEXT_367 = ");" + NL + "\t\t\t";
  protected final String TEXT_368 = NL + "\t\t\torg.talend.marketo.response.ResultBasic leadRecords_";
  protected final String TEXT_369 = " = null;" + NL + "\t\t\tjava.util.List<java.util.Map<String, String>> leads_";
  protected final String TEXT_370 = " = null;" + NL + "\t\t\t\tString[] includeAttributes_";
  protected final String TEXT_371 = " = new String[]{" + NL + "\t\t\t\t";
  protected final String TEXT_372 = "\t" + NL + "\t    \t\t\t";
  protected final String TEXT_373 = ",\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_374 = NL + "\t\t\t\t};" + NL + "\t\t\t";
  protected final String TEXT_375 = NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tfor(int i_";
  protected final String TEXT_376 = "=0;i_";
  protected final String TEXT_377 = " <= reConnMaxNum_";
  protected final String TEXT_378 = ";i_";
  protected final String TEXT_379 = "++){" + NL + "\t            \t\ttry{" + NL + "\t                \t\tleadRecords_";
  protected final String TEXT_380 = "  = client_";
  protected final String TEXT_381 = ".getLead(includeAttributes_";
  protected final String TEXT_382 = ",\"";
  protected final String TEXT_383 = "\",";
  protected final String TEXT_384 = ");" + NL + "\t                \t\tif(client_";
  protected final String TEXT_385 = ".isAccessTokenExpired(leadRecords_";
  protected final String TEXT_386 = ".getErrors())){" + NL + "\t                \t\t\tclient_";
  protected final String TEXT_387 = ".refreshToken();" + NL + "\t                \t\t\tcontinue;" + NL + "\t                \t\t}else{" + NL + "\t                \t\t\tbreak;" + NL + "\t                \t\t}" + NL + "\t\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_388 = "){" + NL + "\t\t\t\t\t\t\tif(i_";
  protected final String TEXT_389 = " != reConnMaxNum_";
  protected final String TEXT_390 = "){" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Connection error:\");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_391 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Waiting to retry...\");" + NL + "\t\t\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_392 = ");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Attempting to reconnect...\");" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_393 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t                }" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_394 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_395 = ");  " + NL + "\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_396 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_397 = NL + "\t\t\t            throw(ex_";
  protected final String TEXT_398 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_399 = NL + "\t\t\t        \tSystem.err.println(ex_";
  protected final String TEXT_400 = ".getMessage());" + NL + "\t\t\t        ";
  protected final String TEXT_401 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif(leadRecords_";
  protected final String TEXT_402 = " != null && leadRecords_";
  protected final String TEXT_403 = ".getResult()!=null){" + NL + "\t\t\t\t\tleads_";
  protected final String TEXT_404 = " = leadRecords_";
  protected final String TEXT_405 = ".getResult();" + NL + "\t\t\t\t\tfor (java.util.Map<String, String> record_";
  protected final String TEXT_406 = ":leads_";
  protected final String TEXT_407 = ") {" + NL + "\t\t\t";
  protected final String TEXT_408 = NL + "\t        \tString nextPageToken_";
  protected final String TEXT_409 = " = null;" + NL + "\t        \t";
  protected final String TEXT_410 = NL + "\t        \t\tfor(String[] valuesArray_";
  protected final String TEXT_411 = ":leadKeyValues_";
  protected final String TEXT_412 = "){" + NL + "\t        \t";
  protected final String TEXT_413 = NL + "\t\t\t\t\t\tint listId_";
  protected final String TEXT_414 = " =  client_";
  protected final String TEXT_415 = ".getListIdByName(";
  protected final String TEXT_416 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_417 = NL + "\t\t\t\t\t\tint listId_";
  protected final String TEXT_418 = " = ";
  protected final String TEXT_419 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_420 = NL + "\t            while(true){" + NL + "\t\t\t\t\tfor(int i_";
  protected final String TEXT_421 = "=0;i_";
  protected final String TEXT_422 = " <= reConnMaxNum_";
  protected final String TEXT_423 = ";i_";
  protected final String TEXT_424 = "++){" + NL + "\t            \t\ttry{" + NL + "\t            \t\t\t";
  protected final String TEXT_425 = NL + "\t\t\t\t\t\t\t\t\tleadRecords_";
  protected final String TEXT_426 = " = client_";
  protected final String TEXT_427 = ".getMultipleLeads(includeAttributes_";
  protected final String TEXT_428 = ", \"";
  protected final String TEXT_429 = "\",valuesArray_";
  protected final String TEXT_430 = ",";
  protected final String TEXT_431 = ", nextPageToken_";
  protected final String TEXT_432 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_433 = NL + "\t\t\t\t\t\t\t\tleadRecords_";
  protected final String TEXT_434 = " = client_";
  protected final String TEXT_435 = ".getLeadsByListId(includeAttributes_";
  protected final String TEXT_436 = ", ";
  protected final String TEXT_437 = ", nextPageToken_";
  protected final String TEXT_438 = ",listId_";
  protected final String TEXT_439 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_440 = NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_441 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_442 = ");" + NL + "\t                \t\tif(client_";
  protected final String TEXT_443 = ".isAccessTokenExpired(leadRecords_";
  protected final String TEXT_444 = ".getErrors())){" + NL + "\t\t                \t\tclient_";
  protected final String TEXT_445 = ".refreshToken();" + NL + "\t\t                \t\tcontinue;" + NL + "\t\t                \t}else{" + NL + "\t\t                \t\tbreak;" + NL + "\t\t                \t}\t" + NL + "\t\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_446 = "){" + NL + "\t\t\t\t\t\t\tif(i_";
  protected final String TEXT_447 = " != reConnMaxNum_";
  protected final String TEXT_448 = "){" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Connection error:\");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_449 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Waiting to retry...\");" + NL + "\t\t\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_450 = ");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Attempting to reconnect...\");" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_451 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t                }" + NL + "\t            \tif(leadRecords_";
  protected final String TEXT_452 = " != null && leadRecords_";
  protected final String TEXT_453 = ".getResult()!=null){" + NL + "\t\t            \tleads_";
  protected final String TEXT_454 = " = leadRecords_";
  protected final String TEXT_455 = ".getResult();" + NL + "\t\t            \tfor (java.util.Map<String, String> record_";
  protected final String TEXT_456 = ":leads_";
  protected final String TEXT_457 = ") {";
  protected final String TEXT_458 = NL + "\t\t\tjava.util.List<java.util.List<Integer>> activityTypes_";
  protected final String TEXT_459 = " = org.talend.marketo.MarketoUtils.splitList(java.util.Arrays.asList(includeTypes_";
  protected final String TEXT_460 = ".toArray(new Integer[0])),10);" + NL + "\t\t\tfor(java.util.List<Integer> activPageIds_";
  protected final String TEXT_461 = ":activityTypes_";
  protected final String TEXT_462 = "){" + NL + "\t\t\t\twhile(true){" + NL + "\t\t\t\t\torg.talend.marketo.response.ResultGetLeadActivities activityRecords_";
  protected final String TEXT_463 = " = null;" + NL + "\t\t\t\t\tjava.util.List<org.talend.marketo.type.LeadActivityRecord> activities_";
  protected final String TEXT_464 = " = null;" + NL + "                \tfor(int i_";
  protected final String TEXT_465 = "=0;i_";
  protected final String TEXT_466 = " <= reConnMaxNum_";
  protected final String TEXT_467 = ";i_";
  protected final String TEXT_468 = "++){" + NL + "                \t\ttry{" + NL + "\t                \t\tactivityRecords_";
  protected final String TEXT_469 = " = client_";
  protected final String TEXT_470 = ".getLeadActivities(activPageIds_";
  protected final String TEXT_471 = ", nextPageToken_";
  protected final String TEXT_472 = ",";
  protected final String TEXT_473 = ",null);" + NL + "\t                \t\tglobalMap.put(\"";
  protected final String TEXT_474 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_475 = ");\t" + NL + "\t                \t\tif(client_";
  protected final String TEXT_476 = ".isAccessTokenExpired(activityRecords_";
  protected final String TEXT_477 = ".getErrors())){" + NL + "\t                \t\t\tclient_";
  protected final String TEXT_478 = ".refreshToken();" + NL + "\t                \t\t\tcontinue;" + NL + "\t                \t\t}else{" + NL + "\t                \t\t\tbreak;" + NL + "\t                \t\t}" + NL + "\t\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_479 = "){" + NL + "\t\t\t\t\t\t\tif(i_";
  protected final String TEXT_480 = " != reConnMaxNum_";
  protected final String TEXT_481 = "){" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Connection error:\");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_482 = ".getMessage());" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Waiting to retry...\");" + NL + "\t\t\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_483 = ");" + NL + "\t\t\t\t\t\t\t\tSystem.err.println(\"Attempting to reconnect...\");" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_484 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t                }" + NL + "\t\t\t\t\tif(activityRecords_";
  protected final String TEXT_485 = " != null && activityRecords_";
  protected final String TEXT_486 = ".getResult()!=null){" + NL + "\t\t\t\t\t\tactivities_";
  protected final String TEXT_487 = " = activityRecords_";
  protected final String TEXT_488 = ".getResult();" + NL + "\t\t                for (org.talend.marketo.type.LeadActivityRecord activityRecord_";
  protected final String TEXT_489 = ":activities_";
  protected final String TEXT_490 = ") {" + NL + "\t\t                    java.util.Map<String, String> record_";
  protected final String TEXT_491 = " = client_";
  protected final String TEXT_492 = ".readActivity(activityRecord_";
  protected final String TEXT_493 = ");" + NL + "\t\t\t";
  protected final String TEXT_494 = NL + "\t\t\tString[] fields_";
  protected final String TEXT_495 = " = (";
  protected final String TEXT_496 = "!=null && ";
  protected final String TEXT_497 = ".length()>0)?";
  protected final String TEXT_498 = ".split(\",\"):new String[0];" + NL + "            while(true){" + NL + "            \torg.talend.marketo.response.ResultGetLeadChanges changeRecords_";
  protected final String TEXT_499 = " = null;" + NL + "\t\t\t\tjava.util.List<org.talend.marketo.type.LeadChangeRecord> changes_";
  protected final String TEXT_500 = " = null;" + NL + "\t\t\t\tfor(int i_";
  protected final String TEXT_501 = "=0;i_";
  protected final String TEXT_502 = " <= reConnMaxNum_";
  protected final String TEXT_503 = ";i_";
  protected final String TEXT_504 = "++){" + NL + "            \t\ttry{" + NL + "                \t\tchangeRecords_";
  protected final String TEXT_505 = " = client_";
  protected final String TEXT_506 = ".getLeadChanges(nextPageToken_";
  protected final String TEXT_507 = ", ";
  protected final String TEXT_508 = ",null,fields_";
  protected final String TEXT_509 = " );" + NL + "                \t\tglobalMap.put(\"";
  protected final String TEXT_510 = "_NB_CALL\",++nb_call_";
  protected final String TEXT_511 = ");" + NL + "                \t\tif(client_";
  protected final String TEXT_512 = ".isAccessTokenExpired(changeRecords_";
  protected final String TEXT_513 = ".getErrors())){" + NL + "                \t\t\tclient_";
  protected final String TEXT_514 = ".refreshToken();" + NL + "                \t\t\tcontinue;" + NL + "                \t\t}else{" + NL + "                \t\t\tbreak;" + NL + "                \t\t}" + NL + "\t\t\t\t\t}catch(java.lang.Exception ex_";
  protected final String TEXT_515 = "){" + NL + "\t\t\t\t\t\tif(i_";
  protected final String TEXT_516 = " != reConnMaxNum_";
  protected final String TEXT_517 = "){" + NL + "\t\t\t\t\t\t\tSystem.err.println(\"Connection error:\");" + NL + "\t\t\t\t\t\t\tSystem.err.println(ex_";
  protected final String TEXT_518 = ".getMessage());" + NL + "\t\t\t\t\t\t\tSystem.err.println(\"Waiting to retry...\");" + NL + "\t\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_519 = ");" + NL + "\t\t\t\t\t\t\tSystem.err.println(\"Attempting to reconnect...\");" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tthrow ex_";
  protected final String TEXT_520 = ";" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "                }" + NL + "            " + NL + "                if(changeRecords_";
  protected final String TEXT_521 = " != null && changeRecords_";
  protected final String TEXT_522 = ".getResult()!=null){" + NL + "\t                changes_";
  protected final String TEXT_523 = " = changeRecords_";
  protected final String TEXT_524 = ".getResult();" + NL + "\t                for (org.talend.marketo.type.LeadChangeRecord change_";
  protected final String TEXT_525 = ":changes_";
  protected final String TEXT_526 = ") {" + NL + "\t                    java.util.Map<String, String> record_";
  protected final String TEXT_527 = " = client_";
  protected final String TEXT_528 = ".readChange(change_";
  protected final String TEXT_529 = ");" + NL + "\t\t\t";
  protected final String TEXT_530 = NL + "\t\t\t\tif(record_";
  protected final String TEXT_531 = ".get(";
  protected final String TEXT_532 = ")!=null){" + NL + "    \t\t\t\t";
  protected final String TEXT_533 = "\t\t\t\t" + NL + "    \t\t\t\t\t";
  protected final String TEXT_534 = ".";
  protected final String TEXT_535 = " = record_";
  protected final String TEXT_536 = ".get(";
  protected final String TEXT_537 = ");" + NL + "    \t\t\t\t";
  protected final String TEXT_538 = NL + "\t    \t\t\t\t\t";
  protected final String TEXT_539 = ".";
  protected final String TEXT_540 = " = ParserUtils.parseTo_Date(record_";
  protected final String TEXT_541 = ".get(";
  protected final String TEXT_542 = ").replaceFirst(\"Z\", \"\"), \"yyyy-MM-dd'T'HH:mm:ss\");" + NL + "\t    \t\t\t\t";
  protected final String TEXT_543 = NL + "\t    \t\t\t\t\t";
  protected final String TEXT_544 = ".";
  protected final String TEXT_545 = " = ParserUtils.parseTo_Date(record_";
  protected final String TEXT_546 = ".get(";
  protected final String TEXT_547 = "), \"yyyy-MM-dd'T'HH:mm:ssZ\");" + NL + "\t    \t\t\t\t";
  protected final String TEXT_548 = "\t\t\t\t\t\t\t" + NL + "    \t\t\t\t\t";
  protected final String TEXT_549 = ".";
  protected final String TEXT_550 = " = ParserUtils.parseTo_";
  protected final String TEXT_551 = "(record_";
  protected final String TEXT_552 = ".get(";
  protected final String TEXT_553 = "));\t" + NL + "    \t\t\t\t";
  protected final String TEXT_554 = NL + "    \t\t\t}else{" + NL + "    \t\t\t\t";
  protected final String TEXT_555 = ".";
  protected final String TEXT_556 = " = ";
  protected final String TEXT_557 = ";" + NL + "    \t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_558 = NL + NL + NL + NL + "        " + NL + "\t\t\t\t";
  protected final String TEXT_559 = NL + NL + NL + NL + "        ";
  protected final String TEXT_560 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName().replace("_In","");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) { //1
	IMetadataTable metadata = metadatas.get(0);
	if (metadata != null) { //2
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();			
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
		if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){ //3
			IConnection outgoingConn = outgoingConns.get(0);
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { //4
				boolean useSoapAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_SOAP_API__"));
				boolean useRestAPI = ("true").equals(ElementParameterParser.getValue(node,"__USE_REST_API__"));

	            String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
	            String clientAccessID = ElementParameterParser.getValue(node, "__CLIENT_ACCESSID__");
	            String operation = ElementParameterParser.getValue(node, "__OPERATION__");
	            String leadKeyValue = ElementParameterParser.getValue(node, "__LEAD_KEYVALUE__");
	            String leadKeyValues = ElementParameterParser.getValue(node, "__LEAD_KEYVALUES__");
	            String leadSelector = ElementParameterParser.getValue(node, "__LEAD_SELECTOR__");
	            String oldestUpdatedAt = ElementParameterParser.getValue(node, "__MUTIPLE_LEADS_OLDESTUPDATEDAT__");
	            String lastestUpdatedAt = ElementParameterParser.getValue(node, "__MUTIPLE_LEADS_LASTUPDATEDAT__");
	            
	            String listParam = ElementParameterParser.getValue(node, "__LIST_PARAM__");
	            String listParamValue = ElementParameterParser.getValue(node, "__LIST_PARAM_VALUE__");
	            
	            String batchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");
	            String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
	            String attemptConnTimes = ElementParameterParser.getValue(node, "__MAX_RECONN_ATTEMPS__");
	            String attemptsInterval = ElementParameterParser.getValue(node, "__ATTEMPS_INTERVAL_TIME__");
	            
	            boolean setIncludeTypes = ("true").equals(ElementParameterParser.getValue(node,"__SET_INCLUDE_TYPES__"));
	            boolean setExcludeTypes = ("true").equals(ElementParameterParser.getValue(node,"__SET_EXCLUDE_TYPES__"));
				boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
	            
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
            	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(attemptConnTimes);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
	            String passwordFieldName = "__SECRET_KEY__";
	            
    stringBuffer.append(TEXT_10);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    } else {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    
				if(useSoapAPI){
				
    stringBuffer.append(TEXT_18);
    
			String leadKeyType = ElementParameterParser.getValue(node, "__LEAD_KEYTYPE__");
			List<Map<String, String>> includeTypesListSoap = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__INCLUDE_TYPES__");
			List<Map<String, String>> excludeTypesListSoap = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__EXCLUDE_TYPES__");
	            
			List<String> includeTypes = null;
			if(setIncludeTypes){
				includeTypes = new ArrayList<String>();
    			for(Map<String,String> includeTypesMap:includeTypesListSoap){
    				includeTypes.add(includeTypesMap.get("TYPES").toString());
    			} 
			}
			List<String> excludeTypes = null;
			if(setExcludeTypes){
				excludeTypes = new ArrayList<String>();
    			for(Map<String,String> excludeTypesMap:excludeTypesListSoap){
    				excludeTypes.add(excludeTypesMap.get("TYPES").toString());
    			} 
			}
			if("getLeadChanges".equals(operation)||"getLeadActivity".equals(operation)){

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    if(includeTypes==null){
    stringBuffer.append(TEXT_21);
    }else{
    stringBuffer.append(TEXT_22);
    for(String includeType:includeTypes){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(includeType);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    if(excludeTypes==null){
    stringBuffer.append(TEXT_28);
    }else{
    stringBuffer.append(TEXT_29);
    for(String excludeType:excludeTypes){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(excludeType);
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    }
    
			}

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(clientAccessID);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_39);
    
			if("getLead".equals(operation)){

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
    stringBuffer.append(leadKeyType);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(leadKeyValue);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
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
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
			        } else {
			        
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
			        }
			        
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
		        if (dieOnError) {
		        
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
		        } else {
		        
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
		        }
		        
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    			
			}else if("getMutipleLeads".equals(operation)){

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    for(String key:fldMapping.keySet()){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(fldMapping.get(key));
    stringBuffer.append(TEXT_100);
    }
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(leadSelector);
    stringBuffer.append(TEXT_103);
    
			if("LeadKeySelector".equals(leadSelector)){
				batchSize = ElementParameterParser.getValue(node, "__MAX_RETURN__");
				
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(leadKeyType);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
			}else if("StaticListSelector".equals(leadSelector)){
				if("STATIC_LIST_NAME".equals(listParam)){
            	
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(listParamValue);
    stringBuffer.append(TEXT_112);
    
            	}else{
            	
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(listParamValue);
    stringBuffer.append(TEXT_115);
    
            	}
			}else{
				
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(oldestUpdatedAt);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(lastestUpdatedAt);
    stringBuffer.append(TEXT_119);
    
			}
			
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(batchSize);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
			        } else {
			        
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    
			        }
			        
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
    
			}else if("getLeadActivity".equals(operation)){

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
    stringBuffer.append(leadKeyType);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(leadKeyValue);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(batchSize);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    
				        if (dieOnError) {
				        
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    
				        } else {
				        
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
				        }
				        
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
			        } else {
			        
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
			        }
			        
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    
			}else if("getLeadChanges".equals(operation)){
				String oldestcreatedat = ElementParameterParser.getValue(node, "__LEADS_OLDESTCREATEDAT__");
				String latestcreatedat = ElementParameterParser.getValue(node, "__LEADS_LATESTCREATEDAT__");
				String oldestupdatedat = ElementParameterParser.getValue(node, "__LEADS_OLDESTUPDATEDAT__");
				String latestupdatedat = ElementParameterParser.getValue(node, "__LEADS_LATESTUPDATEDAT__");

    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    if(!"".equals(oldestcreatedat) && !"\"\"".equals(oldestcreatedat) && !"\"yyyy-MM-dd HH:mm:ss Z\"".equals(oldestcreatedat)){
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(oldestcreatedat);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(oldestcreatedat);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    }
    if(!"".equals(latestcreatedat) && !"\"\"".equals(latestcreatedat) && !"\"yyyy-MM-dd HH:mm:ss Z\"".equals(latestcreatedat)){
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(latestcreatedat);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(latestcreatedat);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    }
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    if(!"".equals(oldestupdatedat) && !"\"\"".equals(oldestupdatedat) && !"\"yyyy-MM-dd HH:mm:ss Z\"".equals(oldestupdatedat)){
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(oldestupdatedat);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(oldestupdatedat);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    }
    if(!"".equals(latestupdatedat) && !"\"\"".equals(latestupdatedat) && !"\"yyyy-MM-dd HH:mm:ss Z\"".equals(latestupdatedat)){
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(latestupdatedat);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(latestupdatedat);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    }
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    
			        } else {
			        
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    
			        }
			        
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    
			}
			

			for( int i = 0; i < columnList.size(); i++) {
			
				IMetadataColumn column = columnList.get(i);
				
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_320);
    	
    				if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
    			
    stringBuffer.append(TEXT_321);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_322);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_325);
    
    				} else if(javaType == JavaTypesManager.DATE) { // Date
    			
    stringBuffer.append(TEXT_326);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_327);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_330);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_331);
    
    				}  else  { // other
    			
    stringBuffer.append(TEXT_332);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_333);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_334);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_337);
    
    				}
    			
    stringBuffer.append(TEXT_338);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_339);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_340);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_341);
    
			}

    stringBuffer.append(TEXT_342);
    
				}
				if(useRestAPI){
				
    stringBuffer.append(TEXT_343);
    stringBuffer.append(TEXT_344);
    
			String leadKeyType = ElementParameterParser.getValue(node, "__LEAD_KEYTYPE_REST__");
            List<Map<String, String>> includeTypesListRest = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__INCLUDE_TYPES_REST__");
			List<Map<String, String>> excludeTypesListRest = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__EXCLUDE_TYPES_REST__");
			
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(clientAccessID);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    
			if("getLeadActivity".equals(operation)){
				if(setIncludeTypes){
					
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    
	                    	for(Map<String,String> includeTypesMap:includeTypesListRest){
		    				
    stringBuffer.append(TEXT_355);
    stringBuffer.append(includeTypesMap.get("TYPES"));
    stringBuffer.append(TEXT_356);
    
		    				} 
	                    	
    stringBuffer.append(TEXT_357);
    
				}else{
				
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    
					if(setExcludeTypes){
		    			for(Map<String,String> excludeTypesMap:excludeTypesListRest){
		    			
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(excludeTypesMap.get("TYPES"));
    stringBuffer.append(TEXT_363);
    
		    			} 
					}
				}
			}
			if("getLeadActivity".equals(operation) || "getLeadChanges".equals(operation)){
				String sinceDateTime = ElementParameterParser.getValue(node, "__SINCE_DATETIME__");
			
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(sinceDateTime);
    stringBuffer.append(TEXT_367);
    
			}else{
			
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    for(String key:fldMapping.keySet()){
    stringBuffer.append(TEXT_372);
    stringBuffer.append(fldMapping.get(key));
    stringBuffer.append(TEXT_373);
    }
    stringBuffer.append(TEXT_374);
    
			}
			if("getLead".equals(operation)){
			
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(leadKeyType);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(leadKeyValue);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    
			        if (dieOnError) {
			        
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    
			        } else {
			        
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    
			        }
			        
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    			
			}else if("getMutipleLeads".equals(operation)){
			
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    
	        	if("LeadKeySelector".equals(leadSelector)){
	        	
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_412);
    
	        	}
				if("StaticListSelector".equals(leadSelector)){
					if("STATIC_LIST_NAME".equals(listParam)){
				
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(listParamValue);
    stringBuffer.append(TEXT_416);
    
					}else{
					
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(listParamValue);
    stringBuffer.append(TEXT_419);
    
					}
				}
				
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    
							if("LeadKeySelector".equals(leadSelector)){
								batchSize = ElementParameterParser.getValue(node, "__MAX_RETURN__");
								
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(leadKeyType);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    
							}else if("StaticListSelector".equals(leadSelector)){
				            
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    
							}
							
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    
			}else if("getLeadActivity".equals(operation)){

    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    
			}else if("getLeadChanges".equals(operation)){
				String fields = ElementParameterParser.getValue(node, "__FIELD_LIST__");
			
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(fields);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(fields);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(fields);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(batchSize);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(attemptsInterval);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    
			}
			for( int i = 0; i < columnList.size(); i++) {
			
				IMetadataColumn column = columnList.get(i);
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_532);
    	
    				if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
    				
    stringBuffer.append(TEXT_533);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_534);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_537);
    
    				} else if(javaType == JavaTypesManager.DATE) { // Date
	    				if("getMutipleLeads".equals(operation)||"getLead".equals(operation)){
	    				
    stringBuffer.append(TEXT_538);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_539);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_542);
    
	    				}else{
	    				
    stringBuffer.append(TEXT_543);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_544);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_547);
    
	    				}
    				}  else  { // other
    				
    stringBuffer.append(TEXT_548);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_549);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_550);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(fldMapping.get(column.getLabel()));
    stringBuffer.append(TEXT_553);
    
    				}
    				
    stringBuffer.append(TEXT_554);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_555);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_556);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_557);
    
			}
			
    stringBuffer.append(TEXT_558);
    
				}
			}//4
		}//3
	}//2
}//1

    stringBuffer.append(TEXT_559);
    stringBuffer.append(TEXT_560);
    return stringBuffer.toString();
  }
}
