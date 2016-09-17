package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class THiveInMainJava
{
  protected static String nl;
  public static synchronized THiveInMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveInMainJava result = new THiveInMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t";
  protected final String TEXT_3 = NL + "\tjava.io.File localPigLatin_";
  protected final String TEXT_4 = " = new java.io.File(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tjava.io.FileWriter fw_";
  protected final String TEXT_5 = " = new java.io.FileWriter(localPigLatin_";
  protected final String TEXT_6 = ".getAbsoluteFile());" + NL + "\tjava.io.BufferedWriter bw_";
  protected final String TEXT_7 = " = new java.io.BufferedWriter(fw_";
  protected final String TEXT_8 = ");" + NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_9 = " = new StringBuilder();";
  protected final String TEXT_10 = " " + NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_11 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "; ";
  protected final String TEXT_16 = " " + NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_17 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = "; ";
  protected final String TEXT_22 = NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_23 = " = new org.talend.bigdata.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t\t+ \"AccountName=\"" + NL + "\t\t\t+ ";
  protected final String TEXT_24 = NL + "\t\t\t+ \";\"" + NL + "\t\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");" + NL + "\t\t\t\t" + NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_27 = " = new org.talend.bigdata.launcher.webhcat.QueryJob(azureFs_";
  protected final String TEXT_28 = ", org.talend.bigdata.launcher.utils.JobType.HIVE);" + NL + "\t\t\t\t\t\t" + NL + "\t\tinstance_";
  protected final String TEXT_29 = ".setCredentials(new org.talend.bigdata.launcher.security.HDInsightCredentials(";
  protected final String TEXT_30 = ", hdInsightPassword_";
  protected final String TEXT_31 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_32 = ".setUsername(";
  protected final String TEXT_33 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_34 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_35 = " + \":\" + ";
  protected final String TEXT_36 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_37 = ".setStatusFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_38 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_39 = ".setRemoteFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_40 = "));";
  protected final String TEXT_41 = NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_42 = " = (org.talend.bigdata.launcher.webhcat.WebHCatJob) globalMap.get(\"conn_";
  protected final String TEXT_43 = "\");" + NL + "\t\t" + NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_44 = " = instance_";
  protected final String TEXT_45 = ".getFileSystem();\t\t" + NL + "\t\t" + NL + "\t\tjava.util.List<String> connectionCommandList_";
  protected final String TEXT_46 = " = (java.util.List<String>)globalMap.get(\"commandList_";
  protected final String TEXT_47 = "\");" + NL + "\t\tfor(String command : connectionCommandList_";
  protected final String TEXT_48 = ") {" + NL + "\t\t\tbw_";
  protected final String TEXT_49 = ".write(command);" + NL + "\t\t}";
  protected final String TEXT_50 = NL + "\t((org.talend.bigdata.launcher.webhcat.QueryJob)instance_";
  protected final String TEXT_51 = ").setFileToExecute(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tString wasbPath_";
  protected final String TEXT_52 = " = azureFs_";
  protected final String TEXT_53 = ".getFileSystemPrefix() + \"/\"\t+ instance_";
  protected final String TEXT_54 = ".getRemoteFolder()\t+ \"/libjars/\";";
  protected final String TEXT_55 = NL + "\t\t\tbw_";
  protected final String TEXT_56 = ".write(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_57 = " + \";\");" + NL + "\t\t\tbw_";
  protected final String TEXT_58 = ".write(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_59 = " + \";\");" + NL + "\t\t\tbw_";
  protected final String TEXT_60 = ".write(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_61 = " + \";\");";
  protected final String TEXT_62 = NL + "\t\t\t\tbw_";
  protected final String TEXT_63 = ".write(\"SET \"+";
  protected final String TEXT_64 = "+\"=\"+";
  protected final String TEXT_65 = " + \";\");";
  protected final String TEXT_66 = NL + "\t\tString dbname_";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = ";" + NL + "\t\tif(dbname_";
  protected final String TEXT_69 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_70 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_71 = ".trim())) {" + NL + "\t\t\tbw_";
  protected final String TEXT_72 = ".write(\"use \" + dbname_";
  protected final String TEXT_73 = " + \";\");" + NL + "\t\t}";
  protected final String TEXT_74 = NL + "\t\troutines.system.GetJarsToRegister getJarsToRegister_";
  protected final String TEXT_75 = " = new routines.system.GetJarsToRegister();";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\tbw_";
  protected final String TEXT_77 = ".write(\"ADD JAR \" + wasbPath_";
  protected final String TEXT_78 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_79 = ".replaceJarPaths(\"";
  protected final String TEXT_80 = "\")).getName() + \";\");" + NL + "\t\t\t\t\t\tlibjars_";
  protected final String TEXT_81 = ".append(getJarsToRegister_";
  protected final String TEXT_82 = ".replaceJarPaths(\"";
  protected final String TEXT_83 = "\") + \",\");";
  protected final String TEXT_84 = NL + NL + "\tbw_";
  protected final String TEXT_85 = ".write(";
  protected final String TEXT_86 = " + \";\");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_87 = "_QUERY\", ";
  protected final String TEXT_88 = ");" + NL + "" + NL + "\tbw_";
  protected final String TEXT_89 = ".close();" + NL + "\tif(libjars_";
  protected final String TEXT_90 = ".length() > 0) {" + NL + "\t\t\tinstance_";
  protected final String TEXT_91 = ".setLibJars(libjars_";
  protected final String TEXT_92 = ".toString().substring(0, libjars_";
  protected final String TEXT_93 = ".length()-1));" + NL + "\t}" + NL + "\tinstance_";
  protected final String TEXT_94 = ".callWS(instance_";
  protected final String TEXT_95 = ".sendFiles());" + NL + "\tint exitCode_";
  protected final String TEXT_96 = " = instance_";
  protected final String TEXT_97 = ".execute();" + NL + "\tif(exitCode_";
  protected final String TEXT_98 = " > 0) {" + NL;
  protected final String TEXT_99 = NL + "\t\t\tthrow new Exception(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_100 = NL + "\t\t\tSystem.err.println(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_101 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_102 = " - The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_103 = NL + "\t}" + NL + "" + NL + "\tjava.io.InputStream ";
  protected final String TEXT_104 = " = instance_";
  protected final String TEXT_105 = ".getStdOut();";
  protected final String TEXT_106 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	final String cid = node.getUniqueName();
	String processId = node.getProcess().getId();

	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	boolean useParquet = "true".equals(ElementParameterParser.getValue(node,"__USE_PARQUET__"));
	boolean generateAddJarCodeForAll = useParquet;
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean isLog4jEnabled = "true".equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

	String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);

    stringBuffer.append(TEXT_2);
    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
	if("false".equals(useExistingConn)) {
		String passwordFieldName = "__HDINSIGHT_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_12);
    
		} else {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_15);
    
		}
			
		passwordFieldName = "__WASB_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_18);
    
		} else {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_21);
    
		}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_40);
    
	} else {
		String azureConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
	}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
	if("false".equals(useExistingConn)) { // This variable is declared and initialized in the GetAzureConnection.javajet
		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
		if(setMemory) {
			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_61);
    
		}

		List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
		if(advProps!=null) {
			for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_65);
    
			}
		}

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(dbname);
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
    
	}

	// Register jars to handle the parquet format.

	java.util.List<String> jarsToRegister = null;
	java.util.List<String> jars = null;
	if(generateAddJarCodeForAll) {
		String[] commandLine = new String[] {"<command>"};
		try {
			commandLine = ProcessorUtilities.getCommandLine("win32",true, processId, "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
		} catch (ProcessorException e) {
			e.printStackTrace();
		}

		jarsToRegister = new java.util.ArrayList();

		jarsToRegister.add("snappy-java");
		jarsToRegister.add("parquet-hive-bundle");

		for (int j = 0; j < commandLine.length; j++) {
			if(commandLine[j].contains("jar")) {
				jars = java.util.Arrays.asList(commandLine[j].split(";"));
				break;
			}
		}
	}


	if(jarsToRegister!=null && jars!=null) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    
		if(generateAddJarCodeForAll) {
			for(int i=0; i<jarsToRegister.size(); i++) {
				String jarToRegister = jarsToRegister.get(i);
				for(int j=0; j<jars.size(); j++) {
					if(jars.get(j).contains(jarToRegister)) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_83);
    
					}
				}
			}
		}
	}

	// End of parquet format handling.

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid.replaceAll("tHiveIn", "tHiveInput"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dbquery);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
		if(("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_99);
    
		} else {

    stringBuffer.append(TEXT_100);
    
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
			}
		}

    stringBuffer.append(TEXT_103);
    stringBuffer.append(ElementParameterParser.getValue(node, "__INPUT_STREAM_NAME__"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(TEXT_106);
    return stringBuffer.toString();
  }
}
