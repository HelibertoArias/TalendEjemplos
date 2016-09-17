package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TSalesforceGetUpdatedBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceGetUpdatedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceGetUpdatedBeginJava result = new TSalesforceGetUpdatedBeginJava();
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
  protected final String TEXT_41 = NL + NL + "int nb_line_";
  protected final String TEXT_42 = " = 0;" + NL;
  protected final String TEXT_43 = NL + "\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_44 = " = new routines.system.Dynamic();" + NL + "\t\t\t\tjava.util.List<String> unDynamicCols_";
  protected final String TEXT_45 = "=java.util.Arrays.asList(\"";
  protected final String TEXT_46 = "\".split(\",\"));" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "        \tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\t\t\tjava.text.SimpleDateFormat startdf_";
  protected final String TEXT_48 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "\t\t    java.text.SimpleDateFormat enddf_";
  protected final String TEXT_49 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "" + NL + "\t\t\tstartdf_";
  protected final String TEXT_50 = ".parse(";
  protected final String TEXT_51 = ");" + NL + "\t\t    enddf_";
  protected final String TEXT_52 = ".parse(";
  protected final String TEXT_53 = ");" + NL + "" + NL + "\t\t    java.util.Calendar startCal_";
  protected final String TEXT_54 = " = startdf_";
  protected final String TEXT_55 = ".getCalendar();" + NL + "\t\t    java.util.Calendar endCal_";
  protected final String TEXT_56 = " = enddf_";
  protected final String TEXT_57 = ".getCalendar();" + NL + "\t\t\torg.talend.salesforce.SforceConnection sforceConn_";
  protected final String TEXT_58 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\t\tif(globalMap.get(\"conn_";
  protected final String TEXT_60 = "\") == null){" + NL + "\t\t\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_61 = "\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tsforceConn_";
  protected final String TEXT_63 = " = (org.talend.salesforce.SforceConnection)globalMap.get(\"conn_";
  protected final String TEXT_64 = "\");" + NL + "\t\t\t";
  protected final String TEXT_65 = NL + "            \t\t";
  protected final String TEXT_66 = NL + "                \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_67 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_68 = ");" + NL + "                \t";
  protected final String TEXT_69 = NL + "                \t\tString decryptedQauthClientPwd_";
  protected final String TEXT_70 = " = ";
  protected final String TEXT_71 = ";" + NL + "                \t";
  protected final String TEXT_72 = NL + "\t\t\t\t\tsforceConn_";
  protected final String TEXT_73 = " =" + NL + "\t\t\t\t\t\tnew org.talend.salesforce.SforceOAuthConnection.Builder(";
  protected final String TEXT_74 = ", ";
  protected final String TEXT_75 = ", decryptedQauthClientPwd_";
  protected final String TEXT_76 = ", ";
  protected final String TEXT_77 = ", ";
  protected final String TEXT_78 = ", ";
  protected final String TEXT_79 = ")" + NL + "            \t\t\t\t";
  protected final String TEXT_80 = NL + "                \t\t\t\t.setTokenFilePath(";
  protected final String TEXT_81 = ")" + NL + "            \t\t\t\t";
  protected final String TEXT_82 = NL + "            \t\t\t\t.setTimeout(";
  protected final String TEXT_83 = ").needCompression(";
  protected final String TEXT_84 = ")" + NL + "                        \t";
  protected final String TEXT_85 = NL + "                        \t\t.setClientID(";
  protected final String TEXT_86 = ")" + NL + "                        \t";
  protected final String TEXT_87 = NL + "                            .useHttpChunked(";
  protected final String TEXT_88 = ")" + NL + "                        \t.build();" + NL + "\t\t\t\t";
  protected final String TEXT_89 = NL + "                \t\t\tString decryptedPwd_";
  protected final String TEXT_90 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_91 = ");" + NL + "                \t\t";
  protected final String TEXT_92 = NL + "                \t\t\tString decryptedPwd_";
  protected final String TEXT_93 = " = ";
  protected final String TEXT_94 = ";" + NL + "                \t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t\t    java.util.Properties props_";
  protected final String TEXT_96 = " = System.getProperties();" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_97 = ".put(\"socksProxyHost\",";
  protected final String TEXT_98 = ");" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_99 = ".put(\"socksProxyPort\",";
  protected final String TEXT_100 = ");" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_101 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_102 = ");" + NL + "\t\t\t\t\t    props_";
  protected final String TEXT_103 = ".put(\"java.net.socks.password\", decryptedPwd_";
  protected final String TEXT_104 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_105 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_106 = NL + NL + "        \t\t\t";
  protected final String TEXT_107 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_108 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_111 = " = ";
  protected final String TEXT_112 = "; ";
  protected final String TEXT_113 = NL + NL + "\t\t\t\t\tsforceConn_";
  protected final String TEXT_114 = " =" + NL + "            \t\t\tnew org.talend.salesforce.SforceBasicConnection.Builder(";
  protected final String TEXT_115 = ", ";
  protected final String TEXT_116 = ", decryptedPassword_";
  protected final String TEXT_117 = ")" + NL + "            \t\t\t\t.setTimeout(";
  protected final String TEXT_118 = ").needCompression(";
  protected final String TEXT_119 = ")" + NL + "                        \t";
  protected final String TEXT_120 = NL + "                        \t\t.setClientID(";
  protected final String TEXT_121 = ")" + NL + "                        \t";
  protected final String TEXT_122 = NL + "                            .useHttpChunked(";
  protected final String TEXT_123 = ")" + NL + "                        \t.build();" + NL + "\t\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\torg.talend.salesforce.SforceManagement sfMgr_";
  protected final String TEXT_125 = " = new org.talend.salesforce.SforceManagementImpl(sforceConn_";
  protected final String TEXT_126 = ");" + NL + "\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\tjava.util.List<String> dynamicColsName_";
  protected final String TEXT_128 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\tclass SFDynamicUtil_";
  protected final String TEXT_129 = "{" + NL + "\t\t\t\t\tpublic void genDynamicColumn(org.talend.salesforce.SforceManagement sfMgr, routines.system.Dynamic dynamic, java.util.List<String> dynamicColsName, java.util.List<String> unDynamicCols){" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t            com.salesforce.soap.partner.DescribeSObjectResult objInfo = sfMgr.describeSObject(";
  protected final String TEXT_130 = ");" + NL + "\t\t\t\t            com.salesforce.soap.partner.Field[] fields = objInfo.getFields();" + NL + "\t\t\t\t            for (com.salesforce.soap.partner.Field field:fields) {" + NL + "\t\t\t\t\t\t\t\tif(!unDynamicCols.contains(field.getName())){" + NL + "\t\t\t\t\t\t\t\t\tString sfType = field.getType().toString();" + NL + "\t\t\t\t\t\t\t\t\tString talendType = \"String\";" + NL + "\t\t\t\t\t\t\t        if (sfType.equals(\"boolean\")) {" + NL + "\t\t\t\t\t\t\t            talendType = \"Boolean\";" + NL + "\t\t\t\t\t\t\t        } else if (sfType.equals(\"int\")) {" + NL + "\t\t\t\t\t\t\t            talendType = \"Integer\";" + NL + "\t\t\t\t\t\t\t        } else if (sfType.equals(\"date\") || sfType.equals(\"datetime\")) {" + NL + "\t\t\t\t\t\t\t            talendType = \"Date\";" + NL + "\t\t\t\t\t\t\t        } else if (sfType.equals(\"double\") || sfType.equals(\"currency\")) {" + NL + "\t\t\t\t\t\t\t            talendType = \"Double\";" + NL + "\t\t\t\t\t\t\t        } else {" + NL + "\t\t\t\t\t\t\t            talendType = \"String\";" + NL + "\t\t\t\t\t\t\t        }" + NL + "\t\t\t\t\t\t\t    \troutines.system.DynamicMetadata dynamicMetadata = new routines.system.DynamicMetadata();" + NL + "\t\t\t\t\t\t\t    \tdynamicColsName.add(field.getName());" + NL + "\t\t\t\t\t\t\t    \tdynamicMetadata.setName(field.getName());" + NL + "\t\t\t\t\t\t\t    \tdynamicMetadata.setDbName(dynamicMetadata.getName());" + NL + "\t\t\t\t\t\t\t    \tdynamicMetadata.setType(\"id_\" + talendType);" + NL + "\t\t\t\t\t\t\t    \t if (sfType.equals(\"date\")) {" + NL + "\t\t\t\t\t\t\t            dynamicMetadata.setFormat(\"yyyy-MM-dd\");" + NL + "\t\t\t\t\t\t\t        } else if (sfType.equals(\"datetime\")) {" + NL + "\t\t\t\t\t\t\t            dynamicMetadata.setFormat(\"yyyy-MM-dd'T'HH:mm:ss.'000Z'\");" + NL + "\t\t\t\t\t\t\t        } else {" + NL + "\t\t\t\t\t\t\t            dynamicMetadata.setFormat(null);" + NL + "\t\t\t\t\t\t\t        }" + NL + "\t\t\t\t\t\t\t        if (\"String\".equals(talendType)) {" + NL + "\t\t\t\t\t\t\t            dynamicMetadata.setLength(field.getLength());" + NL + "\t\t\t\t\t\t\t            dynamicMetadata.setPrecision(field.getPrecision());" + NL + "\t\t\t\t\t\t\t        } else {" + NL + "\t\t\t\t\t\t\t            dynamicMetadata.setLength(field.getPrecision());" + NL + "\t\t\t\t\t\t\t            dynamicMetadata.setPrecision(field.getScale());" + NL + "\t\t\t\t\t\t\t        }" + NL + "\t\t\t\t\t\t\t    \tdynamicMetadata.setDbType(\"VARCHAR\");" + NL + "\t\t\t\t\t\t\t    \tdynamicMetadata.setNullable(field.getNillable());" + NL + "\t\t\t\t\t\t\t    \tdynamicMetadata.setKey(false);" + NL + "\t\t\t\t\t\t\t    \tif(field.getReferenceTo()!=null && field.getReferenceTo().length > 0){" + NL + "\t\t\t\t\t\t\t    \t\tdynamicMetadata.setRefFieldName(field.getRelationshipName());" + NL + "\t\t\t\t\t\t\t    \t\tdynamicMetadata.setRefModuleName(field.getReferenceTo()[0]);" + NL + "\t\t\t\t\t\t\t    \t}" + NL + "\t\t\t\t\t\t\t    \tdynamicMetadata.setSourceType(routines.system.DynamicMetadata.sourceTypes.salesforce);" + NL + "\t\t\t\t\t\t\t    \t//dynamicMetadata.setColumnPosition(i);" + NL + "\t\t\t\t\t\t\t    \tdynamic.metadatas.add(dynamicMetadata);" + NL + "\t\t\t\t\t\t\t    }" + NL + "\t\t\t\t\t\t    }" + NL + "\t\t\t\t        } catch (Exception e) {" + NL + "\t\t\t\t            e.printStackTrace();" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tSFDynamicUtil_";
  protected final String TEXT_131 = " sfDynamicUtil_";
  protected final String TEXT_132 = " =new SFDynamicUtil_";
  protected final String TEXT_133 = "();" + NL + "\t\t\t\tsfDynamicUtil_";
  protected final String TEXT_134 = ".genDynamicColumn(sfMgr_";
  protected final String TEXT_135 = ", dynamic_";
  protected final String TEXT_136 = ", dynamicColsName_";
  protected final String TEXT_137 = ", unDynamicCols_";
  protected final String TEXT_138 = " );" + NL + "\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\tStringBuilder fieldsName_";
  protected final String TEXT_140 = " = new StringBuilder();" + NL + "\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\tfieldsName_";
  protected final String TEXT_142 = ".append(\"";
  protected final String TEXT_143 = "\");" + NL + "\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\tif(dynamicColsName_";
  protected final String TEXT_145 = ".size()>0){" + NL + "\t\t\t\t\tfieldsName_";
  protected final String TEXT_146 = ".append(\"";
  protected final String TEXT_147 = "\"+routines.system.StringUtils.list(dynamicColsName_";
  protected final String TEXT_148 = ".toArray(new String[0]),\",\"));" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_149 = NL + NL + "\tcom.salesforce.soap.partner.sobject.SObject[] so_";
  protected final String TEXT_150 = " = null;" + NL + "\tcom.salesforce.soap.partner.ID[] ids_";
  protected final String TEXT_151 = " = sfMgr_";
  protected final String TEXT_152 = ".getUpdated(";
  protected final String TEXT_153 = ", startCal_";
  protected final String TEXT_154 = ", endCal_";
  protected final String TEXT_155 = ");" + NL + "" + NL + "\tif(ids_";
  protected final String TEXT_156 = " !=null && ids_";
  protected final String TEXT_157 = ".length > 0){" + NL + "" + NL + "\t\tint newMax_";
  protected final String TEXT_158 = " = 0;" + NL + "\t\tint newBase_";
  protected final String TEXT_159 = " = 0;" + NL + "" + NL + "\t\twhile (newMax_";
  protected final String TEXT_160 = " < ids_";
  protected final String TEXT_161 = ".length){" + NL + "" + NL + "\t\t\tnewBase_";
  protected final String TEXT_162 = " = newMax_";
  protected final String TEXT_163 = ";" + NL + "\t\t\tnewMax_";
  protected final String TEXT_164 = " += 2000;" + NL + "" + NL + "\t\t\tif (newMax_";
  protected final String TEXT_165 = " > ids_";
  protected final String TEXT_166 = ".length){" + NL + "\t\t\t\tnewMax_";
  protected final String TEXT_167 = " = ids_";
  protected final String TEXT_168 = ".length;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tcom.salesforce.soap.partner.ID[] localIds_";
  protected final String TEXT_169 = " = new com.salesforce.soap.partner.ID[newMax_";
  protected final String TEXT_170 = "-newBase_";
  protected final String TEXT_171 = "];" + NL + "" + NL + "\t\t\tfor (int i_";
  protected final String TEXT_172 = "=newBase_";
  protected final String TEXT_173 = ";i_";
  protected final String TEXT_174 = " < newMax_";
  protected final String TEXT_175 = ";i_";
  protected final String TEXT_176 = "++){" + NL + "\t\t\t\tlocalIds_";
  protected final String TEXT_177 = "[i_";
  protected final String TEXT_178 = "-newBase_";
  protected final String TEXT_179 = "] = ids_";
  protected final String TEXT_180 = "[i_";
  protected final String TEXT_181 = "];" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tso_";
  protected final String TEXT_182 = " = sfMgr_";
  protected final String TEXT_183 = ".retrieve(localIds_";
  protected final String TEXT_184 = ",";
  protected final String TEXT_185 = ",fieldsName_";
  protected final String TEXT_186 = ".toString());" + NL + "" + NL + "    \t\tif(so_";
  protected final String TEXT_187 = " != null){" + NL + "" + NL + "\t\t\tfor (int i_";
  protected final String TEXT_188 = "=0;i_";
  protected final String TEXT_189 = "<so_";
  protected final String TEXT_190 = ".length;i_";
  protected final String TEXT_191 = "++){" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_192 = " ++;" + NL + "" + NL + "\t\t\t  if(so_";
  protected final String TEXT_193 = "[i_";
  protected final String TEXT_194 = "]!=null){" + NL + "\t\t\t\torg.apache.axiom.om.OMElement[] fields_";
  protected final String TEXT_195 = " = so_";
  protected final String TEXT_196 = "[i_";
  protected final String TEXT_197 = "].getExtraElement();" + NL + "\t\t\t\tint len_";
  protected final String TEXT_198 = " = fields_";
  protected final String TEXT_199 = ".length;";
  protected final String TEXT_200 = NL + "\t\t\t\t    \t\tif (";
  protected final String TEXT_201 = " < len_";
  protected final String TEXT_202 = " &&  fields_";
  protected final String TEXT_203 = "[";
  protected final String TEXT_204 = "]!=null && fields_";
  protected final String TEXT_205 = "[";
  protected final String TEXT_206 = "].getText() != null && !\"\".equals(fields_";
  protected final String TEXT_207 = "[";
  protected final String TEXT_208 = "].getText())){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_209 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = " = fields_";
  protected final String TEXT_212 = "[";
  protected final String TEXT_213 = "].getText();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_214 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_215 = ".";
  protected final String TEXT_216 = " = ParserUtils.parseTo_Date(fields_";
  protected final String TEXT_217 = "[";
  protected final String TEXT_218 = "].getText(), ";
  protected final String TEXT_219 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_221 = ".";
  protected final String TEXT_222 = " = fields_";
  protected final String TEXT_223 = "[";
  protected final String TEXT_224 = "].getText().getBytes();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_225 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = " = ParserUtils.parseTo_";
  protected final String TEXT_228 = "(fields_";
  protected final String TEXT_229 = "[";
  protected final String TEXT_230 = "].getText());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_231 = NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_232 = ".";
  protected final String TEXT_233 = " = ";
  protected final String TEXT_234 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_235 = NL + "\t\t\t\t\t    \tdynamic_";
  protected final String TEXT_236 = ".clearColumnValues();" + NL + "\t\t\t\t\t    \tfor(int j_";
  protected final String TEXT_237 = " = 0; j_";
  protected final String TEXT_238 = " < dynamic_";
  protected final String TEXT_239 = ".getColumnCount(); j_";
  protected final String TEXT_240 = "++){" + NL + "\t\t\t\t\t    \t\tint columnIndex_";
  protected final String TEXT_241 = " = j_";
  protected final String TEXT_242 = "+";
  protected final String TEXT_243 = ";" + NL + "\t\t\t\t\t\t\t\tString valueObj_";
  protected final String TEXT_244 = " = fields_";
  protected final String TEXT_245 = "[columnIndex_";
  protected final String TEXT_246 = "].getText();" + NL + "\t\t\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_247 = " = dynamic_";
  protected final String TEXT_248 = ".getColumnMetadata(j_";
  protected final String TEXT_249 = ");" + NL + "\t\t\t\t\t\t\t\tif (columnIndex_";
  protected final String TEXT_250 = " < len_";
  protected final String TEXT_251 = " && fields_";
  protected final String TEXT_252 = "[columnIndex_";
  protected final String TEXT_253 = "].getText() != null && !\"\".equals(fields_";
  protected final String TEXT_254 = "[columnIndex_";
  protected final String TEXT_255 = "].getText())){" + NL + "\t\t\t\t\t\t\t\t\tif(\"id_Date\".equals(dynamicMetadata_";
  protected final String TEXT_256 = ".getType())){" + NL + "\t\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_257 = ".addColumnValue(ParserUtils.parseTo_Date(valueObj_";
  protected final String TEXT_258 = ", dynamicMetadata_";
  protected final String TEXT_259 = ".getFormat()));" + NL + "\t\t\t\t\t\t\t\t\t}else if(\"id_Double\".equals(dynamicMetadata_";
  protected final String TEXT_260 = ".getType())){" + NL + "\t\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_261 = ".addColumnValue(ParserUtils.parseTo_Double(valueObj_";
  protected final String TEXT_262 = "));" + NL + "\t\t\t\t\t\t\t\t\t}else if(\"id_Integer\".equals(dynamicMetadata_";
  protected final String TEXT_263 = ".getType())){" + NL + "\t\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_264 = ".addColumnValue(ParserUtils.parseTo_Integer(valueObj_";
  protected final String TEXT_265 = "));" + NL + "\t\t\t\t\t\t\t\t\t}else if(\"id_Boolean\".equals(dynamicMetadata_";
  protected final String TEXT_266 = ".getType())){" + NL + "\t\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_267 = ".addColumnValue(ParserUtils.parseTo_Boolean(valueObj_";
  protected final String TEXT_268 = "));" + NL + "\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_269 = ".addColumnValue(valueObj_";
  protected final String TEXT_270 = ");" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_271 = ".addColumnValue(null);" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_272 = ".";
  protected final String TEXT_273 = " = dynamic_";
  protected final String TEXT_274 = ";" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_275 = NL;

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
	boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
   	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
   	String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
   	String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");
   	boolean needCompression = ("true").equals(ElementParameterParser.getValue(node,"__NEED_COMPRESSION__"));
    boolean useHttpChunked = "true".equals(ElementParameterParser.getValue(node,"__USE_HTTP_CHUNKED__"));

	String cid = node.getUniqueName();

   	String passwordFieldName = "";

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);

	if (metadata != null) {

		List<IMetadataColumn> columnList = metadata.getListColumns();
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		if (outgoingConns != null && outgoingConns.size() > 0){

			String sd = ElementParameterParser.getValue(node, "__START_DATE__");
			String ed = ElementParameterParser.getValue(node, "__END_DATE__");

			String username = ElementParameterParser.getValue(node, "__USER__");

			String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
			String module = ElementParameterParser.getValue(node, "__MODULENAME__");
			String customModulename = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_NAME__").trim();
			module = (("CustomModule").equals(module)) ? customModulename : "\""+module+"\"";
			String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
			boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
			String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
			String clientID = ElementParameterParser.getValue(node,"__CLIENT_ID__");

			boolean bulkConnection = false; //for tSalesforceOAuth.javajet

			String apiVersion = ElementParameterParser.getValue(node,"__API_VERSION__");
			String loginType = ElementParameterParser.getValue(node,"__LOGIN_TYPE__");
			boolean useOAuth = "OAUTH".equals(loginType);

			boolean hasDynamic = false;
			StringBuilder unDynamicCols = new StringBuilder();
			String dynamicColName = "";
			for(int i=0; columnList!=null && i< columnList.size(); i++) {
		        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
		            hasDynamic = true;
		            dynamicColName = columnList.get(i).getLabel();
		        }else{
		        	unDynamicCols.append(columnList.get(i).getLabel());
		        	unDynamicCols.append(",");
		        }
			}
			if(unDynamicCols.lastIndexOf(",")>-1){
				unDynamicCols.deleteCharAt(unDynamicCols.lastIndexOf(","));
			}
			if(hasDynamic){
			
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(unDynamicCols);
    stringBuffer.append(TEXT_46);
    
			}

			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(sd);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(ed);
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
    if(useExistingConn){
    stringBuffer.append(TEXT_59);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_61);
    log.info(log.str("Use exist connection : " + connection + "."));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_64);
    
			}else{
				if(useOAuth){
					String oauthKey = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_ID__");
            		String oauthSecret = ElementParameterParser.getValue(node,"__OAUTH_CLIENT_SECRET__");
            		
    stringBuffer.append(TEXT_65);
    
                	passwordFieldName = "__OAUTH_CLIENT_SECRET__";
                	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
                	
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_68);
    
                	} else {
                	
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_71);
    
                	}
                	String tokenFile = ElementParameterParser.getValue(node,"__OAUTH_TOKEN_FILE__");

            		String callbackHost = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_HOST__");
            		String callbackPort = ElementParameterParser.getValue(node,"__OAUTH_CALLBACK_PORT__");
					
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(oauthKey);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(callbackHost);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(callbackPort);
    stringBuffer.append(TEXT_79);
    
            				if(!"".equals(tokenFile) && !"\"\"".equals(tokenFile)){
            				
    stringBuffer.append(TEXT_80);
    stringBuffer.append(tokenFile);
    stringBuffer.append(TEXT_81);
    
            				}
            				
    stringBuffer.append(TEXT_82);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_84);
    
                        	if(clientID != null && !"".equals(clientID) && !"\"\"".equals(clientID)){
                        	
    stringBuffer.append(TEXT_85);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_86);
    
                        	}
                        	
    stringBuffer.append(TEXT_87);
    stringBuffer.append( useHttpChunked );
    stringBuffer.append(TEXT_88);
    
				}else{
					if(useProxy){
						passwordFieldName = "__PROXY_PASSWORD__";
        				if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
                		
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_91);
    
                		} else {
                		
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_94);
    
                		}
						
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(proxyUsername );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
					}
					
    stringBuffer.append(TEXT_105);
    
        			passwordFieldName = "__PASS__";
        			
    stringBuffer.append(TEXT_106);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_109);
    } else {
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_119);
    
                        	if(clientID!=null && !"".equals(clientID) && !"\"\"".equals(clientID)){
                        	
    stringBuffer.append(TEXT_120);
    stringBuffer.append(clientID);
    stringBuffer.append(TEXT_121);
    
                        	}
                        	
    stringBuffer.append(TEXT_122);
    stringBuffer.append( useHttpChunked );
    stringBuffer.append(TEXT_123);
    
				}
				log.info(log.str("Login successful."));
			}
			
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
			if(hasDynamic){
			
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(module);
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
    
			}
			
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
			if(unDynamicCols.length() > 0){
			
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(unDynamicCols);
    stringBuffer.append(TEXT_143);
    
			}
			if(hasDynamic){
			
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(unDynamicCols.length()>0?",":"");
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
			}

			IConnection outgoingConn = outgoingConns.get(0);

			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // start 1
				log.info(log.str("Retrieving records from the datasource."));

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(module);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(module );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    
						boolean isAfterDynamic =  false;
						int columnIndex = 0;
						for( int i = 0; i < columnList.size(); i++) {
							if(isAfterDynamic){
								columnIndex = i-1;
							}else{
								columnIndex = i;
							}
							IMetadataColumn column = columnList.get(i);

							if(column.getTalendType().equals("id_Dynamic")){
								isAfterDynamic = true;
								continue;
							}

							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

							String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
    stringBuffer.append(TEXT_200);
    stringBuffer.append(columnIndex );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(columnIndex );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(columnIndex );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(columnIndex );
    stringBuffer.append(TEXT_208);
    
								if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object
								
    stringBuffer.append(TEXT_209);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_210);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(columnIndex );
    stringBuffer.append(TEXT_213);
    
								} else if(javaType == JavaTypesManager.DATE) { // Date
								
    stringBuffer.append(TEXT_214);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_215);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(columnIndex );
    stringBuffer.append(TEXT_218);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_219);
    
								} else if(javaType == JavaTypesManager.BYTE_ARRAY) { // byte[]
								
    stringBuffer.append(TEXT_220);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_221);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(columnIndex );
    stringBuffer.append(TEXT_224);
    
								} else  { // other
								
    stringBuffer.append(TEXT_225);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_226);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_227);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(columnIndex );
    stringBuffer.append(TEXT_230);
    
								}
								
    stringBuffer.append(TEXT_231);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_233);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_234);
    
						}
						if(hasDynamic){
					    
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(columnList.size()-1);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(dynamicColName);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    
					    }

						log.debug(log.str("Retrieving the record "), log.var("nb_line"), log.str("."));
			}

		}
	}
}

    stringBuffer.append(TEXT_275);
    return stringBuffer.toString();
  }
}
