package org.talend.designer.codegen.translators.business.sap;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TSAPConnectionBeginJava
{
  protected static String nl;
  public static synchronized TSAPConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPConnectionBeginJava result = new TSAPConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    ";
  protected final String TEXT_3 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_4 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = "; ";
  protected final String TEXT_9 = NL + "    ";
  protected final String TEXT_10 = NL + "\tcom.sap.mw.jco.JCO.Client client_";
  protected final String TEXT_11 = " = null;" + NL + "\tjava.util.Properties properties_";
  protected final String TEXT_12 = " = new java.util.Properties();" + NL + "\t";
  protected final String TEXT_13 = NL + "\t\t//Create a client connection to a dedicated R/3 system" + NL + "\t\tproperties_";
  protected final String TEXT_14 = ".put(\"jco.client.type\", \"3\");" + NL + "\t\tif (";
  protected final String TEXT_15 = " != null) properties_";
  protected final String TEXT_16 = ".put(\"jco.client.client\", ";
  protected final String TEXT_17 = ");" + NL + "\t\tif (";
  protected final String TEXT_18 = " != null) properties_";
  protected final String TEXT_19 = ".put(\"jco.client.user\", ";
  protected final String TEXT_20 = ");" + NL + "\t\tif (decryptedPassword_";
  protected final String TEXT_21 = " != null) properties_";
  protected final String TEXT_22 = ".put(\"jco.client.passwd\", decryptedPassword_";
  protected final String TEXT_23 = ");" + NL + "\t\tif (";
  protected final String TEXT_24 = " != null) properties_";
  protected final String TEXT_25 = ".put(\"jco.client.lang\", ";
  protected final String TEXT_26 = ");" + NL + "\t\tif (";
  protected final String TEXT_27 = " != null) properties_";
  protected final String TEXT_28 = ".put(\"jco.client.ashost\", ";
  protected final String TEXT_29 = ");" + NL + "\t\tif (";
  protected final String TEXT_30 = " != null) properties_";
  protected final String TEXT_31 = ".put(\"jco.client.sysnr\", ";
  protected final String TEXT_32 = ");\t            \t\t\t\t " + NL + "\t";
  protected final String TEXT_33 = NL + "\t\t//Create a client connection to Message Server " + NL + "\t\tproperties_";
  protected final String TEXT_34 = ".put(\"jco.client.type\", \"3\");" + NL + "        if (";
  protected final String TEXT_35 = " != null) properties_";
  protected final String TEXT_36 = ".put(\"jco.client.client\", ";
  protected final String TEXT_37 = ");" + NL + "\t\tif (";
  protected final String TEXT_38 = " != null) properties_";
  protected final String TEXT_39 = ".put(\"jco.client.user\", ";
  protected final String TEXT_40 = ");" + NL + "\t\tif (decryptedPassword_";
  protected final String TEXT_41 = " != null) properties_";
  protected final String TEXT_42 = ".put(\"jco.client.passwd\", decryptedPassword_";
  protected final String TEXT_43 = ");" + NL + "\t\tif (";
  protected final String TEXT_44 = " != null) properties_";
  protected final String TEXT_45 = ".put(\"jco.client.lang\", ";
  protected final String TEXT_46 = ");" + NL + "\t\tif (";
  protected final String TEXT_47 = " != null) properties_";
  protected final String TEXT_48 = ".put(\"jco.client.mshost\", ";
  protected final String TEXT_49 = ");" + NL + "\t\tif (";
  protected final String TEXT_50 = " != null) properties_";
  protected final String TEXT_51 = ".put(\"jco.client.r3name\", ";
  protected final String TEXT_52 = ");" + NL + "\t\tif (";
  protected final String TEXT_53 = " != null) properties_";
  protected final String TEXT_54 = ".put(\"jco.client.group\", ";
  protected final String TEXT_55 = ");" + NL + "\t";
  protected final String TEXT_56 = NL + "\t";
  protected final String TEXT_57 = NL + "\t\tproperties_";
  protected final String TEXT_58 = ".setProperty(\"jco.client.snc_mode\", \"1\");" + NL + "\t\tproperties_";
  protected final String TEXT_59 = ".setProperty(\"jco.client.snc_partnername\", ";
  protected final String TEXT_60 = ");" + NL + "\t\tproperties_";
  protected final String TEXT_61 = ".setProperty(\"jco.client.snc_qop\", String.valueOf(";
  protected final String TEXT_62 = "));" + NL + "\t\t";
  protected final String TEXT_63 = NL + "    \t\tif(";
  protected final String TEXT_64 = " != null){" + NL + "    \t\t\tproperties_";
  protected final String TEXT_65 = ".setProperty(\"jco.client.snc_myname\", ";
  protected final String TEXT_66 = ");" + NL + "    \t\t}" + NL + "\t\t";
  protected final String TEXT_67 = NL + "\t\t";
  protected final String TEXT_68 = NL + "    \t\tif(";
  protected final String TEXT_69 = " != null){" + NL + "    \t\t\tproperties_";
  protected final String TEXT_70 = ".setProperty(\"jco.client.snc_lib\", ";
  protected final String TEXT_71 = ");" + NL + "    \t\t}" + NL + "\t\t";
  protected final String TEXT_72 = NL + "\t";
  protected final String TEXT_73 = NL + "\t";
  protected final String TEXT_74 = "\t" + NL + "\t\tproperties_";
  protected final String TEXT_75 = ".put(";
  protected final String TEXT_76 = " ,";
  protected final String TEXT_77 = ");" + NL + "\t\t";
  protected final String TEXT_78 = NL + "\tclient_";
  protected final String TEXT_79 = " = com.sap.mw.jco.JCO.createClient(properties_";
  protected final String TEXT_80 = ");" + NL + "\t// Open the connection" + NL + "\tclient_";
  protected final String TEXT_81 = ".connect();" + NL + "\t";
  protected final String TEXT_82 = NL + "\tcom.sap.mw.jco.JCO.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "\tclient_";
  protected final String TEXT_83 = ".setSapGui(2);" + NL + "\t";
  protected final String TEXT_84 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_85 = "\", client_";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "\t\tcom.sap.conn.jco.JCoDestination dest_";
  protected final String TEXT_88 = " = null;";
  protected final String TEXT_89 = NL + "\t\t\t\tdest_";
  protected final String TEXT_90 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = NL + "\t\t\tif (dest_";
  protected final String TEXT_93 = " == null) {" + NL;
  protected final String TEXT_94 = NL + "\t\t\torg.talend.sap.TSAPDestinationData destinationData_";
  protected final String TEXT_95 = " = null;" + NL + "\t\t\t" + NL + "\t\t\tjava.util.Properties properties_";
  protected final String TEXT_96 = " = new java.util.Properties();" + NL + "\t\t\t";
  protected final String TEXT_97 = NL + "        \t\tproperties_";
  protected final String TEXT_98 = ".setProperty(\"jco.client.snc_mode\", \"1\");" + NL + "        \t\tproperties_";
  protected final String TEXT_99 = ".setProperty(\"jco.client.snc_partnername\", ";
  protected final String TEXT_100 = ");" + NL + "        \t\tproperties_";
  protected final String TEXT_101 = ".setProperty(\"jco.client.snc_qop\", String.valueOf(";
  protected final String TEXT_102 = "));" + NL + "        \t\t";
  protected final String TEXT_103 = NL + "            \t\tif(";
  protected final String TEXT_104 = " != null){" + NL + "            \t\t\tproperties_";
  protected final String TEXT_105 = ".setProperty(\"jco.client.snc_myname\", ";
  protected final String TEXT_106 = ");" + NL + "            \t\t}" + NL + "        \t\t";
  protected final String TEXT_107 = NL + "        \t\t";
  protected final String TEXT_108 = NL + "            \t\tif(";
  protected final String TEXT_109 = " != null){" + NL + "            \t\t\tproperties_";
  protected final String TEXT_110 = ".setProperty(\"jco.client.snc_lib\", ";
  protected final String TEXT_111 = ");" + NL + "            \t\t}" + NL + "        \t\t";
  protected final String TEXT_112 = NL + "        \t";
  protected final String TEXT_113 = NL + "        \t";
  protected final String TEXT_114 = "\t" + NL + "        \t\tproperties_";
  protected final String TEXT_115 = ".put(";
  protected final String TEXT_116 = " ,";
  protected final String TEXT_117 = ");" + NL + "        \t\t";
  protected final String TEXT_118 = NL + "        \t" + NL + "\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\tdestinationData_";
  protected final String TEXT_120 = " = new org.talend.sap.TSAPApplicationServerDestData.Builder(";
  protected final String TEXT_121 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_122 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdecryptedPassword_";
  protected final String TEXT_123 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_124 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_125 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_126 = ")" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_127 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setSAPGUI(\"2\")" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setCustomProp(properties_";
  protected final String TEXT_129 = ")" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.build();" + NL + "\t\t\t";
  protected final String TEXT_130 = "\t\t\t" + NL + "\t\t\t\tdestinationData_";
  protected final String TEXT_131 = " = new org.talend.sap.TSAPMessageServerDestData.Builder(";
  protected final String TEXT_132 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_133 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdecryptedPassword_";
  protected final String TEXT_134 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_135 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_136 = "," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_137 = "," + NL + "\t\t\t\t\t\t            \t\t\t\t \t\t\t\t\t\t\t\t";
  protected final String TEXT_138 = ")" + NL + "\t\t\t\t\t\t            \t\t\t\t \t\t\t\t\t\t\t\t";
  protected final String TEXT_139 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setSAPGUI(\"2\")" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_140 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.setCustomProp(properties_";
  protected final String TEXT_141 = ")" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.build();" + NL + "\t\t\t";
  protected final String TEXT_142 = NL + "\t\t    ";
  protected final String TEXT_143 = NL + "\t\t\t\tcom.sap.conn.jco.JCo.setMiddlewareProperty(\"jco.middleware.allow_start_of_programs\", \"ftp;sapftp;sapftpa;sapkprotp;http;saphttp;saphttpa\");" + NL + "\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\tdest_";
  protected final String TEXT_145 = " = org.talend.sap.TSAPDestinationFactory.getInstance().getDestination(destinationData_";
  protected final String TEXT_146 = ");";
  protected final String TEXT_147 = NL + "\t\t\t}";
  protected final String TEXT_148 = NL + "    // Begins the stateful call sequence for calls to the specified destination." + NL + "    com.sap.conn.jco.JCoContext.begin(dest_";
  protected final String TEXT_149 = ");" + NL + "\tdest_";
  protected final String TEXT_150 = ".ping();" + NL + "    globalMap.put(\"conn_";
  protected final String TEXT_151 = "\", dest_";
  protected final String TEXT_152 = ");";
  protected final String TEXT_153 = NL + "\torg.talend.sap.ISAPConnection connection_";
  protected final String TEXT_154 = " = null;";
  protected final String TEXT_155 = NL + "\t\t\tconnection_";
  protected final String TEXT_156 = " = ((org.talend.sap.impl.SAPConnectionFactory)(org.talend.sap.impl.SAPConnectionFactory.getInstance())).createConnection(";
  protected final String TEXT_157 = ");";
  protected final String TEXT_158 = NL + "\t\tif (connection_";
  protected final String TEXT_159 = " == null) {//}";
  protected final String TEXT_160 = NL + "\t" + NL + "\tjava.util.Properties properties_";
  protected final String TEXT_161 = " = new java.util.Properties();" + NL + "    properties_";
  protected final String TEXT_162 = ".put(org.talend.sap.ISAPConnection.PROP_CLIENT, ";
  protected final String TEXT_163 = ");" + NL + "    properties_";
  protected final String TEXT_164 = ".put(org.talend.sap.ISAPConnection.PROP_USER, ";
  protected final String TEXT_165 = ");" + NL + "    properties_";
  protected final String TEXT_166 = ".put(org.talend.sap.ISAPConnection.PROP_PASSWORD, decryptedPassword_";
  protected final String TEXT_167 = ");" + NL + "    properties_";
  protected final String TEXT_168 = ".put(org.talend.sap.ISAPConnection.PROP_LANGUAGE, ";
  protected final String TEXT_169 = ");" + NL + "    ";
  protected final String TEXT_170 = NL + "    properties_";
  protected final String TEXT_171 = ".put(org.talend.sap.ISAPConnection.PROP_APPLICATION_SERVER_HOST, ";
  protected final String TEXT_172 = ");" + NL + "    properties_";
  protected final String TEXT_173 = ".put(org.talend.sap.ISAPConnection.PROP_SYSTEM_NUMBER, ";
  protected final String TEXT_174 = ");";
  protected final String TEXT_175 = NL + "    properties_";
  protected final String TEXT_176 = ".put(\"jco.client.mshost\", ";
  protected final String TEXT_177 = ");" + NL + "    properties_";
  protected final String TEXT_178 = ".put(\"jco.client.r3name\", ";
  protected final String TEXT_179 = ");" + NL + "    properties_";
  protected final String TEXT_180 = ".put(\"jco.client.group\", ";
  protected final String TEXT_181 = ");";
  protected final String TEXT_182 = NL + "    ";
  protected final String TEXT_183 = NL + "\t\tproperties_";
  protected final String TEXT_184 = ".setProperty(\"jco.client.snc_mode\", \"1\");" + NL + "\t\tproperties_";
  protected final String TEXT_185 = ".setProperty(\"jco.client.snc_partnername\", ";
  protected final String TEXT_186 = ");" + NL + "\t\tproperties_";
  protected final String TEXT_187 = ".setProperty(\"jco.client.snc_qop\", String.valueOf(";
  protected final String TEXT_188 = "));" + NL + "\t\t";
  protected final String TEXT_189 = NL + "    \t\tif(";
  protected final String TEXT_190 = " != null){" + NL + "    \t\t\tproperties_";
  protected final String TEXT_191 = ".setProperty(\"jco.client.snc_myname\", ";
  protected final String TEXT_192 = ");" + NL + "    \t\t}" + NL + "\t\t";
  protected final String TEXT_193 = NL + "\t\t";
  protected final String TEXT_194 = NL + "    \t\tif(";
  protected final String TEXT_195 = " != null){" + NL + "    \t\t\tproperties_";
  protected final String TEXT_196 = ".setProperty(\"jco.client.snc_lib\", ";
  protected final String TEXT_197 = ");" + NL + "    \t\t}" + NL + "\t\t";
  protected final String TEXT_198 = NL + "\t";
  protected final String TEXT_199 = NL + "\t";
  protected final String TEXT_200 = "\t" + NL + "\t\tproperties_";
  protected final String TEXT_201 = ".put(";
  protected final String TEXT_202 = " ,";
  protected final String TEXT_203 = ");" + NL + "\t\t";
  protected final String TEXT_204 = NL + "    " + NL + "\tconnection_";
  protected final String TEXT_205 = " = org.talend.sap.impl.SAPConnectionFactory.getInstance().createConnection(properties_";
  protected final String TEXT_206 = ");";
  protected final String TEXT_207 = NL + "\t\t//{" + NL + "\t\t}";
  protected final String TEXT_208 = NL + "\tconnection_";
  protected final String TEXT_209 = ".beginTransaction();" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_210 = "\", connection_";
  protected final String TEXT_211 = ");";
  protected final String TEXT_212 = NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String version = ElementParameterParser.getValue(node, "__DB_VERSION__");
    String client = ElementParameterParser.getValue(node, "__CLIENT__");
    String userid = ElementParameterParser.getValue(node, "__USERID__");
    String password = ElementParameterParser.getValue(node, "__PASSWORD__");
    String language = ElementParameterParser.getValue(node, "__LANGUAGE__");
    String hostname = ElementParameterParser.getValue(node, "__HOSTNAME__");
    String systemnumber = ElementParameterParser.getValue(node, "__SYSTEMNUMBER__");
    
    String serverType = ElementParameterParser.getValue(node,"__SERVERTYPE__");
    String systemId = ElementParameterParser.getValue(node,"__SYSTEMID__");
    String groupName = ElementParameterParser.getValue(node,"__GROUPNAME__");
    boolean useFtpHttp = ("true").equals(ElementParameterParser.getValue(node,"__FTP_HTTP_FUNCTION__"));
    
    String passwordFieldName = "__PASSWORD__";
    
    boolean activeSNC = ("true").equals(ElementParameterParser.getValue(node,"__SNC_ACTIVE__"));
    String partnerSNCName = ElementParameterParser.getValue(node,"__SNC_PARTNER_NAME__");
    String mySNCName = ElementParameterParser.getValue(node,"__SNC_MY_NAME__");
    String sncLevel = ElementParameterParser.getValue(node,"__SNC_LEVEL__");
    String sncLibPath = ElementParameterParser.getValue(node,"__SNC_LIB_PATH__");
    boolean hasSNCLibPath = sncLibPath != null && !"".equals(sncLibPath);
    boolean hasMySNCName = mySNCName != null && !"".equals(mySNCName);
    
    List<Map<String, String>> sapProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SAP_PROPERTIES__");

    stringBuffer.append(TEXT_2);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_5);
    } else {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    if("sapjco.jar".equals(version)){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(systemnumber );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(systemnumber );
    stringBuffer.append(TEXT_32);
    }else{
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(client );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(userid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(language );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    
	if(activeSNC){
	
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(partnerSNCName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(sncLevel);
    stringBuffer.append(TEXT_62);
    if(hasMySNCName){
    stringBuffer.append(TEXT_63);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    if(hasSNCLibPath){
    stringBuffer.append(TEXT_68);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    
	}
	
    stringBuffer.append(TEXT_73);
    
    if(sapProps!=null) {
		for(Map<String, String> item : sapProps){
		
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_77);
     
		}
    }
	
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    if(useFtpHttp){
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    }else if("sapjco3.jar".equals(version)){
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__SAP_DATASOURCE_ALIAS__");
			if(null != alias && !("".equals(alias))){

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_91);
    
			}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
		}

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
        	if(activeSNC){
        	
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(partnerSNCName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(sncLevel);
    stringBuffer.append(TEXT_102);
    if(hasMySNCName){
    stringBuffer.append(TEXT_103);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    if(hasSNCLibPath){
    stringBuffer.append(TEXT_108);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    
        	}
        	
    stringBuffer.append(TEXT_113);
    
            if(sapProps!=null) {
        		for(Map<String, String> item : sapProps){
        		
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_117);
     
        		}
            }
        	
    stringBuffer.append(TEXT_118);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(systemnumber);
    stringBuffer.append(TEXT_126);
    if(useFtpHttp){
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    }else{
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(systemId );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_138);
    if(useFtpHttp){
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    if(useFtpHttp){
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
		if(specify_alias){

    stringBuffer.append(TEXT_147);
    
		}

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    }else{
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
	if(specify_alias){
		String alias = ElementParameterParser.getValue(node, "__SAP_DATASOURCE_ALIAS__");
		if(null != alias && !("".equals(alias))){

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_157);
    
		}

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
	}

    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(client);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(language);
    stringBuffer.append(TEXT_169);
    if("ApplicationServer".equals(serverType)){
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(systemnumber);
    stringBuffer.append(TEXT_174);
    }else{
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(hostname);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(systemId);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(groupName);
    stringBuffer.append(TEXT_181);
    }
    stringBuffer.append(TEXT_182);
    
	if(activeSNC){
	
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(partnerSNCName);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(sncLevel);
    stringBuffer.append(TEXT_188);
    if(hasMySNCName){
    stringBuffer.append(TEXT_189);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(mySNCName);
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    if(hasSNCLibPath){
    stringBuffer.append(TEXT_194);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(sncLibPath);
    stringBuffer.append(TEXT_197);
    }
    stringBuffer.append(TEXT_198);
    
	}
	
    stringBuffer.append(TEXT_199);
    
    if(sapProps!=null) {
		for(Map<String, String> item : sapProps){
		
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_203);
     
		}
    }
	
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    
	if(specify_alias){

    stringBuffer.append(TEXT_207);
    
	}

    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    }
    stringBuffer.append(TEXT_212);
    return stringBuffer.toString();
  }
}
