package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class THiveConnectionBeginJava
{
  protected static String nl;
  public static synchronized THiveConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveConnectionBeginJava result = new THiveConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t";
  protected final String TEXT_2 = " " + NL + "\t\tfinal String hdInsightPassword_";
  protected final String TEXT_3 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = NL + "\t\tfinal String hdInsightPassword_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = "; ";
  protected final String TEXT_8 = " " + NL + "\t\tfinal String wasbPassword_";
  protected final String TEXT_9 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\tfinal String wasbPassword_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = "; ";
  protected final String TEXT_14 = NL + "\t" + NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_15 = " = new StringBuilder();" + NL + "\t" + NL + "\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_16 = " = new org.talend.bigdata.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t+ \"AccountName=\"" + NL + "\t\t+ ";
  protected final String TEXT_17 = NL + "\t\t+ \";\"" + NL + "\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = ");" + NL + "\t\t\t" + NL + "\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_20 = " = new org.talend.bigdata.launcher.webhcat.QueryJob(azureFs_";
  protected final String TEXT_21 = ", org.talend.bigdata.launcher.utils.JobType.HIVE);" + NL + "\t\t\t\t\t" + NL + "\tinstance_";
  protected final String TEXT_22 = ".setCredentials(new org.talend.bigdata.launcher.security.HDInsightCredentials(";
  protected final String TEXT_23 = ", hdInsightPassword_";
  protected final String TEXT_24 = "));" + NL + "\tinstance_";
  protected final String TEXT_25 = ".setUsername(";
  protected final String TEXT_26 = ");" + NL + "\tinstance_";
  protected final String TEXT_27 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_28 = " + \":\" + ";
  protected final String TEXT_29 = ");" + NL + "\tinstance_";
  protected final String TEXT_30 = ".setStatusFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_31 = "));" + NL + "\tinstance_";
  protected final String TEXT_32 = ".setRemoteFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_33 = "));" + NL + "\t" + NL + "\tjava.util.List<String> connectionCommandList_";
  protected final String TEXT_34 = " = new java.util.ArrayList<String>();" + NL + "\t";
  protected final String TEXT_35 = NL + "\t\tconnectionCommandList_";
  protected final String TEXT_36 = ".add(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_37 = " + \";\");" + NL + "\t\tconnectionCommandList_";
  protected final String TEXT_38 = ".add(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_39 = " + \";\");" + NL + "\t\tconnectionCommandList_";
  protected final String TEXT_40 = ".add(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_41 = " + \";\");";
  protected final String TEXT_42 = NL + "\t\t\tconnectionCommandList_";
  protected final String TEXT_43 = ".add(\"SET \"+";
  protected final String TEXT_44 = "+\"=\"+";
  protected final String TEXT_45 = " + \";\");";
  protected final String TEXT_46 = NL + NL + "\tString dbname_";
  protected final String TEXT_47 = " = ";
  protected final String TEXT_48 = ";" + NL + "\tif(dbname_";
  protected final String TEXT_49 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_50 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_51 = ".trim())) {" + NL + "\t\tconnectionCommandList_";
  protected final String TEXT_52 = ".add(\"use \" + dbname_";
  protected final String TEXT_53 = " + \";\");" + NL + "\t}" + NL + "" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_54 = "\", instance_";
  protected final String TEXT_55 = ");" + NL + "\tglobalMap.put(\"commandList_";
  protected final String TEXT_56 = "\", connectionCommandList_";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\t\t";
  protected final String TEXT_59 = NL + "\t";
  protected final String TEXT_60 = NL + "\t\t\tString driverClass_";
  protected final String TEXT_61 = " = \"";
  protected final String TEXT_62 = "\";" + NL + "\t\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "\t\t\tSharedDBConnectionLog4j.initLogger(log,\"";
  protected final String TEXT_65 = "\");";
  protected final String TEXT_66 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_69 = " = ";
  protected final String TEXT_70 = ".getDBConnection(\"";
  protected final String TEXT_71 = "\",url_";
  protected final String TEXT_72 = ",dbUser_";
  protected final String TEXT_73 = " , dbPwd_";
  protected final String TEXT_74 = " , sharedConnectionName_";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "\t\tconn_";
  protected final String TEXT_77 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_78 = ",dbUser_";
  protected final String TEXT_79 = ",dbPwd_";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_82 = " - Connection is set auto commit to '";
  protected final String TEXT_83 = "'.\");";
  protected final String TEXT_84 = NL + "\t\t\tconn_";
  protected final String TEXT_85 = ".setAutoCommit(";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "\t\t\t\tconn_";
  protected final String TEXT_88 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "                if(true) {" + NL + "                    throw new java.lang.Exception(\"The distribution ";
  protected final String TEXT_91 = " does not support this version of Hive . Please check your component configuration.\");" + NL + "                }";
  protected final String TEXT_92 = NL + "                if(true) {" + NL + "                    throw new java.lang.Exception(\"The distribution ";
  protected final String TEXT_93 = " does not support this connection mode . Please check your component configuration.\");" + NL + "                }";
  protected final String TEXT_94 = NL + "                if(true) {" + NL + "                    throw new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "                }";
  protected final String TEXT_95 = NL + "\t\t\t\t\tSystem.setProperty(";
  protected final String TEXT_96 = " ,";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"false\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_103 = ");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_104 = ");" + NL + "" + NL + "        \t\t";
  protected final String TEXT_105 = NL + NL + "        \t\t";
  protected final String TEXT_106 = NL + "            \tString decryptedMetastorePassword_";
  protected final String TEXT_107 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_108 = ");" + NL + "       \t\t \t";
  protected final String TEXT_109 = NL + "            \tString decryptedMetastorePassword_";
  protected final String TEXT_110 = " = ";
  protected final String TEXT_111 = ";" + NL + "    \t\t\t";
  protected final String TEXT_112 = NL + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", decryptedMetastorePassword_";
  protected final String TEXT_113 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_114 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.principal\", ";
  protected final String TEXT_116 = ");" + NL + "\t\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.keytab\", ";
  protected final String TEXT_117 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_119 = ", ";
  protected final String TEXT_120 = ");";
  protected final String TEXT_121 = NL + "\t\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_122 = ");";
  protected final String TEXT_123 = NL + "\t\t\t\tSystem.setProperty(\"";
  protected final String TEXT_124 = "\", ";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "                String username_";
  protected final String TEXT_127 = " = ";
  protected final String TEXT_128 = ";" + NL + "                if(username_";
  protected final String TEXT_129 = "!=null && !\"\".equals(username_";
  protected final String TEXT_130 = ".trim())) {" + NL + "                    System.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_131 = ");" + NL + "                }";
  protected final String TEXT_132 = NL + "\t\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_133 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "\t\t\t";
  protected final String TEXT_134 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_135 = " + \":\" + ";
  protected final String TEXT_136 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\t\tString url_";
  protected final String TEXT_137 = " = \"jdbc:";
  protected final String TEXT_138 = "://\";";
  protected final String TEXT_139 = NL + "\t\t\t\t\tString dbUserName_";
  protected final String TEXT_140 = " = ";
  protected final String TEXT_141 = ";" + NL + "\t\t\t\t\tif(dbUserName_";
  protected final String TEXT_142 = "!=null && !\"\".equals(dbUserName_";
  protected final String TEXT_143 = ".trim())) {" + NL + "\t\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUserName_";
  protected final String TEXT_144 = ");" + NL + "\t\t\t\t\t\t//make relative file path work for hive" + NL + "\t\t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\t\t\t\tSystem.setProperty(\"user.name\",dbUserName_";
  protected final String TEXT_145 = ");" + NL + "\t\t\t\t\t\tglobalMap.put(\"dbUser_";
  protected final String TEXT_146 = "\",dbUserName_";
  protected final String TEXT_147 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_148 = NL + "\t\t\t\t\tString url_";
  protected final String TEXT_149 = " = \"jdbc:";
  protected final String TEXT_150 = "://\" + ";
  protected final String TEXT_151 = " + \":\" + ";
  protected final String TEXT_152 = " + \"/\" + ";
  protected final String TEXT_153 = " + \";\";" + NL + "\t\t\t\t\tString secureSSLMode = \";sasl.qop=auth-conf\";" + NL + "" + NL + "\t\t\t\t\t// Add HADOOP_CONF_DIR to the classpath if it's present" + NL + "\t\t\t\t\tString hadoopConfDir_";
  protected final String TEXT_154 = " = System.getenv(\"HADOOP_CONF_DIR\");" + NL + "\t\t\t\t\tif(hadoopConfDir_";
  protected final String TEXT_155 = " != null){" + NL + "\t\t\t\t\t\tjava.net.URLClassLoader sysloader = (java.net.URLClassLoader) ClassLoader.getSystemClassLoader();" + NL + "\t\t\t\t\t\tjava.lang.reflect.Method method = java.net.URLClassLoader.class.getDeclaredMethod(\"addURL\", new Class[] { java.net.URL.class });" + NL + "\t\t\t\t\t\tmethod.setAccessible(true);" + NL + "\t\t\t\t\t\tmethod.invoke(sysloader,new Object[] { new java.io.File(hadoopConfDir_";
  protected final String TEXT_156 = ").toURI().toURL() });" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_157 = " = new org.apache.hadoop.conf.Configuration();" + NL + "" + NL + "\t\t\t\t\t// Adding any talend-site.xml files on the classpath" + NL + "\t\t\t\t\tconf_";
  protected final String TEXT_158 = ".addResource(\"talend-site.xml\");" + NL + "\t\t\t\t\tString tldHiveKerberosAuth = conf_";
  protected final String TEXT_159 = ".get(\"talend.kerberos.authentication\", \"\");" + NL + "\t\t\t\t\tString tldHiveKerberosKtPrincipal = conf_";
  protected final String TEXT_160 = ".get(\"talend.kerberos.keytab.principal\", \"\");" + NL + "\t\t\t\t\tString tldHiveKerberosKtPath = conf_";
  protected final String TEXT_161 = ".get(\"talend.kerberos.keytab.path\", \"\");" + NL + "\t\t\t\t\tString tldHiveEnc = conf_";
  protected final String TEXT_162 = ".get(\"talend.encryption\", \"\");" + NL + "\t\t\t\t\tString tldHiveSslTsPath = conf_";
  protected final String TEXT_163 = ".get(\"talend.ssl.trustStore.path\", \"\");" + NL + "\t\t\t\t\tString tldHiveSslTsPassword = conf_";
  protected final String TEXT_164 = ".get(\"talend.ssl.trustStore.password\", \"\");" + NL + "" + NL + "\t\t\t\t\t// Add configurations from hive-site.xml" + NL + "\t\t\t\t\tconf_";
  protected final String TEXT_165 = ".addResource(\"hive-site.xml\");" + NL + "" + NL + "\t\t\t\t\t// Add configurations from yarn-site.xml" + NL + "\t\t\t\t\tconf_";
  protected final String TEXT_166 = ".addResource(\"yarn-site.xml\");" + NL + "" + NL + "\t\t\t\t\t// Add configurations from mapred-site.xml" + NL + "\t\t\t\t\tconf_";
  protected final String TEXT_167 = ".addResource(\"mapred-site.xml\");" + NL + "" + NL + "\t\t\t\t\t// Add configurations from hdfs-site.xml" + NL + "\t\t\t\t\tconf_";
  protected final String TEXT_168 = ".addResource(\"hdfs-site.xml\");";
  protected final String TEXT_169 = NL + "\t\t\t\t\t\t// Add configurations from hbase-site.xml" + NL + "\t\t\t\t\t\tconf_";
  protected final String TEXT_170 = ".addResource(\"hbase-site.xml\");";
  protected final String TEXT_171 = NL + "\t\t\t\t\t\tconf_";
  protected final String TEXT_172 = ".set(";
  protected final String TEXT_173 = " ,";
  protected final String TEXT_174 = ");";
  protected final String TEXT_175 = NL + "\t\t\t\t\t\tlog.debug(\"CLASSPATH_CONFIGURATION_";
  protected final String TEXT_176 = "\" + \" Loaded : \" + conf_";
  protected final String TEXT_177 = ");" + NL + "\t\t\t\t\t\tlog.debug(\"CLASSPATH_CONFIGURATION_";
  protected final String TEXT_178 = "\" + \" key value pairs : \");" + NL + "\t\t\t\t\t\tjava.util.Iterator<java.util.Map.Entry<String,String>> iterator_log_";
  protected final String TEXT_179 = " = conf_";
  protected final String TEXT_180 = ".iterator();" + NL + "\t\t\t\t\t\twhile(iterator_log_";
  protected final String TEXT_181 = ".hasNext()){" + NL + "\t\t\t\t\t\t\tjava.util.Map.Entry<String,String> property = iterator_log_";
  protected final String TEXT_182 = ".next();" + NL + "\t\t\t\t\t\t\tlog.debug(\"CLASSPATH_CONFIGURATION_";
  protected final String TEXT_183 = " \" + property.getKey() + \" : \" + property.getValue());" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_184 = NL + "\t\t\t\t\tif(org.apache.hadoop.security.UserGroupInformation.isSecurityEnabled()){" + NL + "" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tString hiveServer2KerberosPrincipal = conf_";
  protected final String TEXT_185 = ".get(\"hive.server2.authentication.kerberos.principal\", \"\");" + NL + "\t\t\t\t\t\tString urlKerberosParameter = \"principal=\" + hiveServer2KerberosPrincipal;" + NL + "" + NL + "\t\t\t\t\t\t// Keytab configurations" + NL + "\t\t\t\t\t\tif(tldHiveKerberosAuth.equalsIgnoreCase(\"keytab\")){" + NL + "\t\t\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(tldHiveKerberosKtPrincipal, tldHiveKerberosKtPath);" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t// SSL configurations" + NL + "\t\t\t\t\t\tif(tldHiveEnc.equalsIgnoreCase(\"ssl\")){" + NL + "\t\t\t\t\t\t\turl_";
  protected final String TEXT_186 = " += urlKerberosParameter + secureSSLMode;" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\turl_";
  protected final String TEXT_187 = " += urlKerberosParameter;" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t}else{" + NL + "" + NL + "\t\t\t\t\t\t// SSL configurations" + NL + "\t\t\t\t\t\tif(tldHiveEnc.equalsIgnoreCase(\"ssl\")){" + NL + "\t\t\t\t\t\t\turl_";
  protected final String TEXT_188 = " += \";ssl=true\" +\";sslTrustStore=\" + tldHiveSslTsPath + \";trustStorePassword=\" + tldHiveSslTsPassword;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}";
  protected final String TEXT_189 = NL + "\t\t\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_190 = ", ";
  protected final String TEXT_191 = ");";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\t\tString url_";
  protected final String TEXT_193 = " = \"jdbc:";
  protected final String TEXT_194 = "://\" + ";
  protected final String TEXT_195 = " + \":\" + ";
  protected final String TEXT_196 = " + \"/\" + ";
  protected final String TEXT_197 = " + \";principal=\" + ";
  protected final String TEXT_198 = "+\";sasl.qop=auth-conf\";";
  protected final String TEXT_199 = NL + "\t\t\t\t\t\t\tString url_";
  protected final String TEXT_200 = " = \"jdbc:";
  protected final String TEXT_201 = "://\" + ";
  protected final String TEXT_202 = " + \":\" + ";
  protected final String TEXT_203 = " + \"/\" + ";
  protected final String TEXT_204 = " + \";principal=\" + ";
  protected final String TEXT_205 = ";";
  protected final String TEXT_206 = NL + "\t\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_207 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_208 = ");";
  protected final String TEXT_209 = NL + "\t\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_210 = " = ";
  protected final String TEXT_211 = ";";
  protected final String TEXT_212 = NL + "\t\t\t\t\t\t\tString url_";
  protected final String TEXT_213 = " = \"jdbc:";
  protected final String TEXT_214 = "://\" + ";
  protected final String TEXT_215 = " + \":\" + ";
  protected final String TEXT_216 = " + \"/\" + ";
  protected final String TEXT_217 = "+ \";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_218 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_219 = ";";
  protected final String TEXT_220 = NL + "\t\t\t\t\t\t\tString url_";
  protected final String TEXT_221 = " = \"jdbc:";
  protected final String TEXT_222 = "://\" + ";
  protected final String TEXT_223 = " + \":\" + ";
  protected final String TEXT_224 = " + \"/\" + ";
  protected final String TEXT_225 = ";";
  protected final String TEXT_226 = NL + "\t\t\t\tString additionalJdbcSettings_";
  protected final String TEXT_227 = " = ";
  protected final String TEXT_228 = ";" + NL + "\t\t\t\tif(!\"\".equals(additionalJdbcSettings_";
  protected final String TEXT_229 = ".trim())) {" + NL + "\t\t\t\t\tif(!additionalJdbcSettings_";
  protected final String TEXT_230 = ".startsWith(\";\")) {" + NL + "\t\t\t\t\t\tadditionalJdbcSettings_";
  protected final String TEXT_231 = " = \";\" + additionalJdbcSettings_";
  protected final String TEXT_232 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_233 = " += additionalJdbcSettings_";
  protected final String TEXT_234 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_235 = NL + "\t\t\tconn_";
  protected final String TEXT_236 = ".setAutoCommit(";
  protected final String TEXT_237 = ");";
  protected final String TEXT_238 = NL + NL + "\t";
  protected final String TEXT_239 = NL + NL + "\tString dbUser_";
  protected final String TEXT_240 = " = ";
  protected final String TEXT_241 = ";";
  protected final String TEXT_242 = NL + "\t" + NL + "\t";
  protected final String TEXT_243 = NL + "\t\tString dbPwd_";
  protected final String TEXT_244 = " = null;" + NL + "\t";
  protected final String TEXT_245 = NL + "\t\t";
  protected final String TEXT_246 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_247 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_248 = ");";
  protected final String TEXT_249 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_250 = " = ";
  protected final String TEXT_251 = "; ";
  protected final String TEXT_252 = NL + "\t\tString dbPwd_";
  protected final String TEXT_253 = " = decryptedPassword_";
  protected final String TEXT_254 = ";" + NL + "\t";
  protected final String TEXT_255 = NL + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_256 = " = null;" + NL + "\t";
  protected final String TEXT_257 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_258 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_259 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_260 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_261 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_262 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_263 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_264 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_265 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_266 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_267 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_268 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_269 = " - Written records count: \" + nb_line_";
  protected final String TEXT_270 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_271 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_272 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_273 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_274 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_275 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_276 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_277 = " - Writing the record \" + nb_line_";
  protected final String TEXT_278 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_279 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_280 = " - Processing the record \" + nb_line_";
  protected final String TEXT_281 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_282 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_283 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_284 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_285 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_286 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_287 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_288 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_289 = " - Uses an existing connection ";
  protected final String TEXT_290 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_291 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_292 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_293 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_294 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_295 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_296 = NL + "\t\t\tconn_";
  protected final String TEXT_297 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_298 = ", dbUser_";
  protected final String TEXT_299 = ", dbPwd_";
  protected final String TEXT_300 = ");" + NL + "\t\t\t";
  protected final String TEXT_301 = NL + "\t\t\tconn_";
  protected final String TEXT_302 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_303 = NL + "\t\t\tconn_";
  protected final String TEXT_304 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_305 = NL + "\t\t\tconn_";
  protected final String TEXT_306 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_307 = NL + "\t\t\t\tconn_";
  protected final String TEXT_308 = ".setAutoCommit(";
  protected final String TEXT_309 = ");" + NL + "\t\t\t";
  protected final String TEXT_310 = NL + "\t\t\t\tlog.";
  protected final String TEXT_311 = "(\"";
  protected final String TEXT_312 = " - \" + ";
  protected final String TEXT_313 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_314 = NL + "\t    \t\tlog.";
  protected final String TEXT_315 = "(\"";
  protected final String TEXT_316 = "\");" + NL + "\t\t\t";
  protected final String TEXT_317 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_318 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_319 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_320 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_321 = ": pstmt_";
  protected final String TEXT_322 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_323 = " += (countEach_";
  protected final String TEXT_324 = " < 0 ? 0 : ";
  protected final String TEXT_325 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_326 = NL + "\t";
  protected final String TEXT_327 = NL + NL + "\tif ((null == globalMap.get(KEY_DB_DATASOURCES)) || \"\".equals(";
  protected final String TEXT_328 = ")) {";
  protected final String TEXT_329 = NL + "\t\t";
  protected final String TEXT_330 = NL + "\t\t";
  protected final String TEXT_331 = NL + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_332 = "\", conn_";
  protected final String TEXT_333 = ");";
  protected final String TEXT_334 = NL + "\t}";
  protected final String TEXT_335 = NL + "\tif (null != conn_";
  protected final String TEXT_336 = ") {" + NL + "\t\t";
  protected final String TEXT_337 = NL + "\t}";
  protected final String TEXT_338 = NL;
  protected final String TEXT_339 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_340 = ");" + NL + "" + NL + "\tjava.sql.Statement init_";
  protected final String TEXT_341 = " = conn_";
  protected final String TEXT_342 = ".createStatement();";
  protected final String TEXT_343 = NL + "        init_";
  protected final String TEXT_344 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_345 = ");" + NL + "\t    init_";
  protected final String TEXT_346 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_347 = ");";
  protected final String TEXT_348 = NL + "\t\tinit_";
  protected final String TEXT_349 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_350 = ");";
  protected final String TEXT_351 = NL + "\t\t\tinit_";
  protected final String TEXT_352 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_353 = ");";
  protected final String TEXT_354 = NL + "\t\t\tinit_";
  protected final String TEXT_355 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_356 = ");";
  protected final String TEXT_357 = NL + "    \t\tinit_";
  protected final String TEXT_358 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "    \t\tinit_";
  protected final String TEXT_359 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_360 = ");";
  protected final String TEXT_361 = NL + "\t\t\tinit_";
  protected final String TEXT_362 = ".execute(\"SET mapreduce.jobhistory.address=\" + ";
  protected final String TEXT_363 = ");" + NL + "\t\t\t";
  protected final String TEXT_364 = NL + "\t\t\tinit_";
  protected final String TEXT_365 = ".execute(\"SET dfs.client.use.datanode.hostname=true\");";
  protected final String TEXT_366 = NL + "\t\t\tinit_";
  protected final String TEXT_367 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_368 = ");";
  protected final String TEXT_369 = NL + "\t\t\tinit_";
  protected final String TEXT_370 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_371 = ");";
  protected final String TEXT_372 = NL + "\t\t\t\tinit_";
  protected final String TEXT_373 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_374 = NL + "\t\t\t\tinit_";
  protected final String TEXT_375 = ".execute(\"SET mapreduce.job.map.output.collector.class=org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t\t\t\tinit_";
  protected final String TEXT_376 = ".execute(\"SET mapreduce.job.reduce.shuffle.consumer.plugin.class=org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_377 = NL + "\t\t\t\tinit_";
  protected final String TEXT_378 = ".execute(\"SET mapreduce.application.classpath=$PWD/mr-framework/hadoop/share/hadoop/mapreduce/*:$PWD/mr-framework/hadoop/share/hadoop/mapreduce/lib/*:$PWD/mr-framework/hadoop/share/hadoop/common/*:$PWD/mr-framework/hadoop/share/hadoop/common/lib/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/lib/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/lib/*:/etc/hadoop/conf/secure\");";
  protected final String TEXT_379 = NL + "\t\t\tinit_";
  protected final String TEXT_380 = ".execute(\"SET yarn.application.classpath=";
  protected final String TEXT_381 = "\");";
  protected final String TEXT_382 = NL + "\t\t\tinit_";
  protected final String TEXT_383 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_384 = ");" + NL + "\t\t\tinit_";
  protected final String TEXT_385 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_386 = ");" + NL + "\t\t\tinit_";
  protected final String TEXT_387 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_388 = ");";
  protected final String TEXT_389 = NL + "\t\t\tinit_";
  protected final String TEXT_390 = ".execute(\"SET \"+";
  protected final String TEXT_391 = "+\"=\"+";
  protected final String TEXT_392 = ");";
  protected final String TEXT_393 = NL + NL + "\t";
  protected final String TEXT_394 = NL;
  protected final String TEXT_395 = NL + "    \t\tinit_";
  protected final String TEXT_396 = ".execute(\"SET hive.execution.engine=tez\");";
  protected final String TEXT_397 = NL + "                        System.err.println(\"Please set the path of Tez lib in 'Tez lib path'!\");";
  protected final String TEXT_398 = NL;
  protected final String TEXT_399 = NL + "        String username_";
  protected final String TEXT_400 = " = (";
  protected final String TEXT_401 = " != null && !\"\".equals(";
  protected final String TEXT_402 = ")) ? ";
  protected final String TEXT_403 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_404 = " = null;";
  protected final String TEXT_405 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_406 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_407 = ".set(\"";
  protected final String TEXT_408 = "\", ";
  protected final String TEXT_409 = ");" + NL + "        ";
  protected final String TEXT_410 = NL + "            conf_";
  protected final String TEXT_411 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_412 = NL + "        \t\tconf_";
  protected final String TEXT_413 = ".set(";
  protected final String TEXT_414 = " ,";
  protected final String TEXT_415 = ");" + NL + "        \t";
  protected final String TEXT_416 = NL + "            username_";
  protected final String TEXT_417 = " = null;" + NL + "    \t\tconf_";
  protected final String TEXT_418 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_419 = ");" + NL + "    \t\t";
  protected final String TEXT_420 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_421 = ", ";
  protected final String TEXT_422 = ");" + NL + "    \t\t";
  protected final String TEXT_423 = NL + "\t\t\tconf_";
  protected final String TEXT_424 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_425 = "+\",\"+";
  protected final String TEXT_426 = ");" + NL + "        \tfs_";
  protected final String TEXT_427 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_428 = ");";
  protected final String TEXT_429 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_430 = " == null || \"\".equals(username_";
  protected final String TEXT_431 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_432 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_433 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_434 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_435 = ".get(\"";
  protected final String TEXT_436 = "\")),conf_";
  protected final String TEXT_437 = ",username_";
  protected final String TEXT_438 = ");" + NL + "        \t}\t";
  protected final String TEXT_439 = NL + "                    String hdfsUserName_";
  protected final String TEXT_440 = " = (";
  protected final String TEXT_441 = " != null && !\"\".equals(";
  protected final String TEXT_442 = ")) ? ";
  protected final String TEXT_443 = " : System.getProperty(\"user.name\");" + NL + "                    String tezLibPath_";
  protected final String TEXT_444 = " = \"/tmp/\" + hdfsUserName_";
  protected final String TEXT_445 = " + \"/talend_tez_libs/";
  protected final String TEXT_446 = "\";";
  protected final String TEXT_447 = NL + "                    String tezLibPath_";
  protected final String TEXT_448 = " = ";
  protected final String TEXT_449 = ";";
  protected final String TEXT_450 = NL + "                fs_";
  protected final String TEXT_451 = ".mkdirs(new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_452 = "));";
  protected final String TEXT_453 = NL + "                String[] classPaths_";
  protected final String TEXT_454 = " = System.getProperty(\"java.class.path\").split(";
  protected final String TEXT_455 = "String.valueOf(globalMap.get(\"current_client_path_separator\"))";
  protected final String TEXT_456 = "System.getProperty(\"path.separator\")";
  protected final String TEXT_457 = ");" + NL + "                String tezLibLocalPath_";
  protected final String TEXT_458 = " = null;" + NL + "                for(String classPath_";
  protected final String TEXT_459 = " : classPaths_";
  protected final String TEXT_460 = "){";
  protected final String TEXT_461 = NL + "                        if(classPath_";
  protected final String TEXT_462 = ".endsWith(\"";
  protected final String TEXT_463 = "\")){" + NL + "                            org.apache.hadoop.fs.Path tezJarPath_";
  protected final String TEXT_464 = " = new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_465 = " + \"/";
  protected final String TEXT_466 = "\");" + NL + "                            if(!fs_";
  protected final String TEXT_467 = ".exists(tezJarPath_";
  protected final String TEXT_468 = ")){" + NL + "                                fs_";
  protected final String TEXT_469 = ".copyFromLocalFile(false, false, new org.apache.hadoop.fs.Path(classPath_";
  protected final String TEXT_470 = "), tezJarPath_";
  protected final String TEXT_471 = ");" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_472 = NL + "                }";
  protected final String TEXT_473 = NL + "                String tezLibPath_";
  protected final String TEXT_474 = " = ";
  protected final String TEXT_475 = ";";
  protected final String TEXT_476 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_477 = " = new StringBuilder();" + NL + "\t\t\tString[] tezLibPaths_";
  protected final String TEXT_478 = " = tezLibPath_";
  protected final String TEXT_479 = ".split(\",\");" + NL + "\t\t\tscript_";
  protected final String TEXT_480 = ".append(\"SET tez.lib.uris=\");" + NL + "\t\t\tint tezLibPathCount_";
  protected final String TEXT_481 = " = 1;" + NL + "\t\t\tfor(String tezLibPathKey_";
  protected final String TEXT_482 = " : tezLibPaths_";
  protected final String TEXT_483 = "){" + NL + "\t\t\t\t script_";
  protected final String TEXT_484 = ".append(";
  protected final String TEXT_485 = " + \"/\" + tezLibPathKey_";
  protected final String TEXT_486 = ");" + NL + "\t\t\t\t if(tezLibPathCount_";
  protected final String TEXT_487 = " < tezLibPaths_";
  protected final String TEXT_488 = ".length){" + NL + "\t\t\t\t \tscript_";
  protected final String TEXT_489 = ".append(\",\");" + NL + "\t\t\t\t }" + NL + "\t\t\t\t tezLibPathCount_";
  protected final String TEXT_490 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tinit_";
  protected final String TEXT_491 = ".execute(script_";
  protected final String TEXT_492 = ".toString());" + NL + "\t\t";
  protected final String TEXT_493 = NL + "\t";
  protected final String TEXT_494 = NL + NL + "\tinit_";
  protected final String TEXT_495 = ".close();" + NL + "" + NL + "\t";
  protected final String TEXT_496 = NL + "\t\tjava.sql.Statement statement_";
  protected final String TEXT_497 = " = conn_";
  protected final String TEXT_498 = ".createStatement();" + NL + "\t\t";
  protected final String TEXT_499 = NL + "\t\t\tstatement_";
  protected final String TEXT_500 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_501 = ");" + NL + "\t\t";
  protected final String TEXT_502 = NL + NL + "\t\t";
  protected final String TEXT_503 = NL + "\t\t\tstatement_";
  protected final String TEXT_504 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_505 = ");" + NL + "\t\t";
  protected final String TEXT_506 = NL + NL + "\t\t";
  protected final String TEXT_507 = NL + "\t\t\tstatement_";
  protected final String TEXT_508 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_509 = ");" + NL + "\t\t";
  protected final String TEXT_510 = NL + NL + "\t\t";
  protected final String TEXT_511 = NL + "\t\t\tstatement_";
  protected final String TEXT_512 = ".execute(\"SET hbase.security.authentication=kerberos\");" + NL + "\t\t\tstatement_";
  protected final String TEXT_513 = ".execute(\"SET hbase.rpc.engine=org.apache.hadoop.hbase.ipc.SecureRpcEngine\");" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_514 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_515 = ".execute(\"SET hbase.master.kerberos.principal=\"+";
  protected final String TEXT_516 = ");" + NL + "\t\t\t";
  protected final String TEXT_517 = NL + "\t\t\t";
  protected final String TEXT_518 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_519 = ".execute(\"SET hbase.regionserver.kerberos.principal=\"+";
  protected final String TEXT_520 = ");" + NL + "\t\t\t";
  protected final String TEXT_521 = NL + "\t\t";
  protected final String TEXT_522 = NL + NL + "\t\t";
  protected final String TEXT_523 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_524 = ".execute(\"add jar \"+";
  protected final String TEXT_525 = ");" + NL + "\t\t";
  protected final String TEXT_526 = NL + "\t\tstatement_";
  protected final String TEXT_527 = ".close();" + NL + "\t";
  protected final String TEXT_528 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_529 = "\",conn_";
  protected final String TEXT_530 = ");" + NL + "" + NL + "\tglobalMap.put(\"db_";
  protected final String TEXT_531 = "\",";
  protected final String TEXT_532 = ");" + NL + "" + NL + "\tString currentClientPathSeparator_";
  protected final String TEXT_533 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "\tif(currentClientPathSeparator_";
  protected final String TEXT_534 = "!=null) {" + NL + "\t\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_535 = ");" + NL + "\t\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "\t}" + NL + "" + NL + "\tString currentClientUsername_";
  protected final String TEXT_536 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "\tif(currentClientUsername_";
  protected final String TEXT_537 = "!=null) {" + NL + "\t\tSystem.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_538 = ");" + NL + "\t\tglobalMap.put(\"current_client_user_name\", null);" + NL + "\t}" + NL + "" + NL + "\tString originalHadoopUsername_";
  protected final String TEXT_539 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_540 = "\");" + NL + "\tif(originalHadoopUsername_";
  protected final String TEXT_541 = "!=null) {" + NL + "\t\tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_542 = ");" + NL + "\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_543 = "\", null);" + NL + "\t} else {" + NL + "\t\tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument theCodeGenArgument = (CodeGeneratorArgument) argument;
	INode theNode = (INode)theCodeGenArgument.getArgument();
	String theDistribution = ElementParameterParser.getValue(theNode, "__DISTRIBUTION__");
	String theVersion = ElementParameterParser.getValue(theNode, "__HIVE_VERSION__");

	org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
	try {
		hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(theDistribution, theVersion);
	} catch (java.lang.Exception e) {
		e.printStackTrace();
		return "";
	}
	boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;	
	
	if(hiveDistrib.isExecutedThroughWebHCat()) { // Execution through WebHCat

    stringBuffer.append(TEXT_1);
    

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String cid = node.getUniqueName();

	String passwordFieldName = "__HDINSIGHT_PASSWORD__";
	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_4);
    
	} else {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_7);
    
	}
			
	passwordFieldName = "__WASB_PASSWORD__";
	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    
	} else {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    
	}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
	boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
	if(setMemory) {
		String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
		String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
		String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_41);
    
	}
	
	List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
	if(advProps!=null) {
		for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_45);
    
		}
	}

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
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
    
	} else { // JDBC execution

    stringBuffer.append(TEXT_58);
    stringBuffer.append(TEXT_59);
    
	class DefaultConnectionUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected boolean isLog4jEnabled;
	    
	    public void beforeComponentProcess(INode node){
	    }
	    
		public void createURL(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
		
		public void classForName(INode node){

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");
			String shareDBClass = "SharedDBConnection";
			if(isLog4jEnabled){
				shareDBClass = "SharedDBConnectionLog4j";

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
			}

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(shareDBClass);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
		}
		
		public void createConnection(INode node) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
		}
		
		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_83);
    
			}

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_86);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    

	class ConnectionUtil extends DefaultConnectionUtil{
		private String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		private org.talend.hadoop.distribution.component.HiveComponent hiveDistrib;
		private boolean isCustom;

		public ConnectionUtil(org.talend.hadoop.distribution.component.HiveComponent hiveDistrib) {
			this.hiveDistrib = hiveDistrib;
			this.isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
		}

		public void createConnection(INode node) {
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");

			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));

			boolean securityIsEnabled = useKrb && (isCustom || (this.hiveDistrib.doSupportKerberos() && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer))));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
			} else {
				super.createConnection(node);
			}
		}

		public void createURL(INode node) {
			super.createURL(node);
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String fsDefalutName = "fs.default.name";
			String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");

			boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
			boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
			List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");

			boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));

			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean securityIsEnabled = useKrb && (isCustom || (this.hiveDistrib.doSupportKerberos() && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer))));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
			boolean securedEmbeddedHive2 = securedEmbedded && "HIVE2".equalsIgnoreCase(hiveServer);

			String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");
			boolean useSsl = "true".equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
			String sslTrustStore = ElementParameterParser.getValue(node, "__SSL_TRUST_STORE__");
			boolean configureFromClassPath = "true".equals(ElementParameterParser.getValue(node, "__CONFIGURATIONS_FROM_CLASSPATH__"));
			boolean storeByHBase = "true".equals(ElementParameterParser.getValue(node, "__STORE_BY_HBASE__"));


			if(hiveServer!=null && !"".equals(hiveServer.trim()) && (this.isCustom || this.hiveDistrib.doSupportHive2())) {
				hiveServer = hiveServer.toLowerCase();
				if ("hive2".equals(hiveServer)) {
					javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
				}
			} else {
				hiveServer = "hive";
			}

            if(("hive".equals(hiveServer) && !hiveDistrib.doSupportHive1()) || ("hive2".equals(hiveServer) && !hiveDistrib.doSupportHive2())) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_91);
    
            }

            if(("STANDALONE".equals(connectionMode) && !hiveDistrib.doSupportStandaloneMode()) || ("EMBEDDED".equals(connectionMode) && !hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_93);
    
            }

            if("STANDALONE".equals(connectionMode) && "hive".equals(hiveServer) && !hiveDistrib.doSupportHive1Standalone()) {

    stringBuffer.append(TEXT_94);
    
          }
          	// When configuraing from the classpath we do not set the variables using System.setProperty
          	// We set them directly on the Hadoop Configuration object
			if((hadoopProps.size() > 0) && (!configureFromClassPath)) {
				for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_95);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_97);
    
				}
			}

			if(securedEmbedded) {
				String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
				String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
				String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
				boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
				String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
				String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_98);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_99);
    if(securedEmbeddedHive2){
					// Disable authorization when using local HiveServer2 in secure mode
					
    stringBuffer.append(TEXT_100);
    
				}else{
					
    stringBuffer.append(TEXT_101);
    
				}
			
    stringBuffer.append(TEXT_102);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_104);
    
        		String passwordFieldName = "__METASTORE_PASSWORD__";
        		
    stringBuffer.append(TEXT_105);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_108);
    } else {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_114);
    
				if(securedEmbeddedHive2){
				
    stringBuffer.append(TEXT_115);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_PRINCIPAL__"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_KEYTAB__"));
    stringBuffer.append(TEXT_117);
    
				}
			
    
				if(useKeytab) {

    stringBuffer.append(TEXT_118);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_120);
    
				}
			}

			if(((this.isCustom && !useYarn) || (!this.isCustom && this.hiveDistrib.isHadoop1())) && setMapredJT && !configureFromClassPath) {
				String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_121);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_122);
    
			}

			if(setNamenode && !configureFromClassPath) {
				String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_123);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_125);
    
			}

			boolean setHadoopUser = "true".equals(ElementParameterParser.getValue(node, "__SET_HADOOP_USER__"));
		    if (setHadoopUser) {
	            String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");
                
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    
            }
		    
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    

			// BEGIN IF01
			if("EMBEDDED".equals(connectionMode) && (this.isCustom || this.hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_134);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_138);
    
				if(this.isCustom || (!this.isCustom && this.hiveDistrib.doSupportImpersonation())) {
					String dbuser = ElementParameterParser.getValue(node, "__USER__");

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(dbuser);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    
				}

			// END IF01
			// BEGIN IF02
			} else if("STANDALONE".equals(connectionMode) && (this.isCustom || this.hiveDistrib.doSupportStandaloneMode())) {
				boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
				String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
				String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
				String sslStorepasswordFieldName = "__SSL_TRUST_STORE_PASSWORD__";
				String additionalJdbcSettings = ElementParameterParser.getValue(node, "__HIVE_ADDITIONAL_JDBC__");
				// User the classpath to infer Kerberos parameters
				// BEGIN IF03
				if(configureFromClassPath){

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(dbname);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
					if(storeByHBase){

    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    
					}

					// Set advanced hadoop properties
					if(hadoopProps.size() > 0) {
						for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_174);
    
						}
					}

					// log all loaded xxx-site.xml files and all of the key value pairs for debugging
					if(isLog4jEnabled){

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
    
					}

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
				// END IF03
				// BEGIN IF04
				} else {
				// BEGIN IF 06
					if(securedStandaloneHive2) {
						if(useKeytab) {

    stringBuffer.append(TEXT_189);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_191);
    
						}
						// Using SSL in Secure Mode
						if(useSsl && this.hiveDistrib.doSupportSSL()){

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_198);
    
						}else{

    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_205);
    
						}
					// END IF06
					// BEGIN IF07
					} else {
						// Using SSL in non Secure Mode
						if(useSsl && this.hiveDistrib.doSupportSSL()){
							if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_208);
    
							}else{

    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_211);
    
							}

    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
						}else{

    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_225);
    
						}
					// END IF07
					}
				// END IF04
				}

    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(additionalJdbcSettings);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    
			// END IF02
			}
		}

		public void setAutoCommit(INode node) {
			boolean useTransaction = false;//("true").equals(ElementParameterParser.getValue(node,"__IS_USE_AUTO_COMMIT__"));
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if (useTransaction) {

    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_237);
    
			}
		}

		public String getDirverClassName(INode node){
			return javaDbDriver;
		}
	}//end class

	connUtil = new ConnectionUtil(hiveDistrib);

    //----------------------------component codes-----------------------------------------
    stringBuffer.append(TEXT_238);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    if(dbschema == null||dbschema.trim().length()==0) {
    	 dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
    }
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHARED_CONNECTION__"));

    
	connUtil.beforeComponentProcess(node);
	connUtil.createURL(node);

    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_241);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_242);
    if(dbpass != null && dbpass.trim().length() == 0) {
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    } else {
		String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_245);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_248);
    } else {
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_251);
    }
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    }
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    
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
			
    stringBuffer.append(TEXT_257);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_258);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_259);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_262);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_265);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_268);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_273);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_275);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_276);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_279);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_282);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    
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
			
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    if (cid.startsWith("tImpala") || cid.startsWith("tHive")) {
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_290);
    } else {
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    }
    stringBuffer.append(TEXT_295);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    
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
			
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
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
			
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    
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
			
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_309);
    
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
	    	
    stringBuffer.append(TEXT_310);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_313);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_314);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_316);
    
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
			
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_325);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_326);
    connUtil.useShareConnection(node);
    
	} else {
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_327);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_328);
    
		}

    stringBuffer.append(TEXT_329);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_330);
    
		log4jCodeGenerateUtil.debugConnectionParams(node);
		log4jCodeGenerateUtil.connect_begin();
		connUtil.createConnection(node);
		log4jCodeGenerateUtil.connect_end();
		
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    
		if(specify_alias){

    stringBuffer.append(TEXT_334);
    
		}
	}

    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_337);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_338);
    
	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
	String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
	String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
	String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");
	String hbaseMasterPrincipal = ElementParameterParser.getValue(node, "__HBASE_MASTER_PRINCIPAL__");
	String hbaseRegionServerPrincipal = ElementParameterParser.getValue(node, "__HBASE_REGIONSERVER_PRINCIPAL__");

	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
	String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");

	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));

	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	boolean securityIsEnabled = useKrb && (isCustom || (hiveDistrib.doSupportKerberos() && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer))));
	boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
	boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
	boolean securedEmbeddedHive2 = securedEmbedded && "HIVE2".equalsIgnoreCase(hiveServer);

	boolean isKerberosAvailableHadoop2 = !isCustom && hiveDistrib.isHadoop2() && hiveDistrib.doSupportKerberos();
	boolean isHadoop2 = !isCustom && hiveDistrib.isHadoop2();
	boolean isKerberosAvailableHadoop1 = !isCustom && hiveDistrib.isHadoop1() && hiveDistrib.doSupportKerberos();
	boolean configureFromClassPath = "true".equals(ElementParameterParser.getValue(node, "__CONFIGURATIONS_FROM_CLASSPATH__"));


    stringBuffer.append(TEXT_339);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    
    if(!configureFromClassPath && !isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_347);
    
	}

	if(securedEmbedded) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_350);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobtrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_353);
    
		}
		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_356);
    
		}

	}

	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
		if(!configureFromClassPath && setResourceManager) {
			String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_360);
    
		}

		boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
		if(!configureFromClassPath && setJobHistoryAddress) {
			String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
			
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_363);
    
		}

		if ("true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"))) {

    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    
		}

		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
		if(!configureFromClassPath && setSchedulerAddress) {
			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_368);
    
		}

		if(!configureFromClassPath && "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"))) {
			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_371);
    
		}

		if("EMBEDDED".equals(connectionMode) && (isCustom || hiveDistrib.doSupportEmbeddedMode())) {
			boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
			if((isCustom && useYarn && crossPlatformSubmission) || (!isCustom && hiveDistrib.doSupportCrossPlatformSubmission())) {

    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    
			}

			if("MAPR410".equals(hiveVersion)){

    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    
			}

			if(!isCustom && ("HDP_2_2".equals(hiveVersion) || "HDP_2_3".equals(hiveVersion))) {

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    
			}

    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(hiveDistrib.getYarnApplicationClasspath());
    stringBuffer.append(TEXT_381);
    
		}

		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
		if(setMemory) {
			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_388);
    
		}
	}

	List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
	if(advProps!=null) {
		for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_391);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_392);
    
		}
	}

    stringBuffer.append(TEXT_393);
    stringBuffer.append(TEXT_394);
    
class PrepareTez{
	public void invoke(INode node, String cid){
        String hiveDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

        org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
        try {
            hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(hiveDistribution, hiveVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

        boolean changePathSeparator = !hiveDistrib.isExecutedThroughWebHCat();

        String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
        boolean useTez = "tez".equals(ElementParameterParser.getValue(node, "__EXECUTION_ENGINE__"));
    	boolean supportTez = (isCustom || hiveDistrib.doSupportTezForHive()) && "EMBEDDED".equals(connectionMode);
    	if(supportTez && useTez){
    	
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    
            if(advProps != null){
                for(Map<String, String> item : advProps){
                    if("\"tez.lib.uris\"".equals(item.get("PROPERTY"))){
                    
    stringBuffer.append(TEXT_397);
      
                    }
                }
            }
            boolean installTez = "INSTALL".equals(ElementParameterParser.getValue(node, "__TEZ_LIB__"));
            if(installTez){
                //prepare the folder
                
    stringBuffer.append(TEXT_398);
    
class GetFileSystem{
	public void invoke(INode node, String cid){
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String fsDefaultNameKey = "fs.default.name";
        
        String distribution = null;
        String hadoopVersion = null;
        boolean isCustom = false;

        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    
        distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

        org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
        try {
            hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
        
        
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_409);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_415);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_419);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_420);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_422);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		String group = ElementParameterParser.getValue(node, "__GROUP__");
    		
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(group);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    
        }else{
        
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    
        }
    }
}

      
                (new GetFileSystem()).invoke(node, cid);
                String tezLibFolder = ElementParameterParser.getValue(node, "__TEZ_LIB_FOLDER__");
                boolean useDefaultTezLibFolder = "\"/tmp/{USERNAME}/talend_tez_libs/{custom|HIVE_VERSION}\"".equals(tezLibFolder);
                if(useDefaultTezLibFolder){
                
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(isCustom?"custom":hiveVersion);
    stringBuffer.append(TEXT_446);
    
                }else{
                
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(tezLibFolder);
    stringBuffer.append(TEXT_449);
    
                }
                
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    
                List<String> tezLibJarsName = new java.util.ArrayList<String>();
                if(isCustom){
                    List<Map<String,String>> tezLibJarsNameValue = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__TEZ_LIB_NAME__");
                    for(Map<String, String> tezLibJarsNameV : tezLibJarsNameValue){
                        tezLibJarsName.add(tezLibJarsNameV.get("JAR_NAME"));
                    }
                }else{
                    String tezLibJarsNameValue = ElementParameterParser.getValue(node, "__TEZ_JARS_NAME__");
                    if(tezLibJarsNameValue != null && !"".equals(tezLibJarsNameValue)){
                        tezLibJarsName = java.util.Arrays.asList(tezLibJarsNameValue.split(","));
                    }
                }
                
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    if(changePathSeparator){
    stringBuffer.append(TEXT_455);
    }else{
    stringBuffer.append(TEXT_456);
    }
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    
                    for(String jarName : tezLibJarsName){
                    
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(jarName);
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
    
                    }
                    
    stringBuffer.append(TEXT_472);
    
            }else{
            
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TEZ_LIB_PATH__"));
    stringBuffer.append(TEXT_475);
    
            }
            //define the location of tez lib    
            
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__"));
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
    
    	}
    }
}

    stringBuffer.append(TEXT_493);
    
	(new PrepareTez()).invoke(node, cid);
	
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    if("true".equalsIgnoreCase(storeByHBase) && (isCustom || hiveDistrib.doSupportHBaseForHive())) {
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    if(!configureFromClassPath && zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_501);
    }
    stringBuffer.append(TEXT_502);
    if(!configureFromClassPath && zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_505);
    }
    stringBuffer.append(TEXT_506);
    if(!configureFromClassPath && setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_509);
    }
    stringBuffer.append(TEXT_510);
    if(!configureFromClassPath && useKrb){
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    if(hbaseMasterPrincipal!=null && !"".equals(hbaseMasterPrincipal) && !"\"\"".equals(hbaseMasterPrincipal)){
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_516);
    }
    stringBuffer.append(TEXT_517);
    if(hbaseRegionServerPrincipal!=null && !"".equals(hbaseRegionServerPrincipal) && !"\"\"".equals(hbaseRegionServerPrincipal)){
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(hbaseRegionServerPrincipal);
    stringBuffer.append(TEXT_520);
    }
    stringBuffer.append(TEXT_521);
    }
    stringBuffer.append(TEXT_522);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
			for(Map<String, String> jar : registerJarForHBase){
				String path = jar.get("JAR_PATH");
				if(path == null || "".equals(path) || "\"\"".equals(path)) {
					continue;
				}
		
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_525);
    
			}
		}
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    }
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    
	}

    return stringBuffer.toString();
  }
}
