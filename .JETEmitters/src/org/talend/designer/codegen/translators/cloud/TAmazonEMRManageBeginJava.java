package org.talend.designer.codegen.translators.cloud;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TAmazonEMRManageBeginJava
{
  protected static String nl;
  public static synchronized TAmazonEMRManageBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAmazonEMRManageBeginJava result = new TAmazonEMRManageBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t        " + NL + "\t";
  protected final String TEXT_3 = NL + "\t" + NL + "\t";
  protected final String TEXT_4 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_5 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = "; ";
  protected final String TEXT_10 = NL + "   \t" + NL + "   \tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_11 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_12 = ",decryptedPassword_";
  protected final String TEXT_13 = ");" + NL + "   \t" + NL + "\tcom.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient emr_";
  protected final String TEXT_14 = " = new com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient(credentials_";
  protected final String TEXT_15 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_16 = NL + "\temr_";
  protected final String TEXT_17 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_18 = "));" + NL + "\t";
  protected final String TEXT_19 = NL + NL + "\t";
  protected final String TEXT_20 = NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.ListClustersRequest request_";
  protected final String TEXT_21 = " = new com.amazonaws.services.elasticmapreduce.model.ListClustersRequest()" + NL + "\t\t\t.withClusterStates(" + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.ClusterState.BOOTSTRAPPING," + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.ClusterState.STARTING," + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.ClusterState.RUNNING," + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.ClusterState.WAITING" + NL + "\t\t\t)" + NL + "\t\t;" + NL + "    \tcom.amazonaws.services.elasticmapreduce.model.ListClustersResult result_";
  protected final String TEXT_22 = " = emr_";
  protected final String TEXT_23 = ".listClusters(request_";
  protected final String TEXT_24 = ");" + NL + "    \tjava.util.List<com.amazonaws.services.elasticmapreduce.model.ClusterSummary> clusters_";
  protected final String TEXT_25 = " = result_";
  protected final String TEXT_26 = ".getClusters();" + NL + "    \t" + NL + "    \tjava.util.List<String> ids_";
  protected final String TEXT_27 = " = new java.util.ArrayList<String>();" + NL + "    \t" + NL + "    \t";
  protected final String TEXT_28 = NL + "    \tfor(com.amazonaws.services.elasticmapreduce.model.ClusterSummary summary_";
  protected final String TEXT_29 = " : clusters_";
  protected final String TEXT_30 = ") {" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\tids_";
  protected final String TEXT_32 = ".add(summary_";
  protected final String TEXT_33 = ".getId());" + NL + "\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\tif(";
  protected final String TEXT_35 = ".equals(summary_";
  protected final String TEXT_36 = ".getName())) {" + NL + "\t\t\t\t\tids_";
  protected final String TEXT_37 = ".add(summary_";
  protected final String TEXT_38 = ".getId());" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\tif(";
  protected final String TEXT_40 = ".equals(summary_";
  protected final String TEXT_41 = ".getId())) {" + NL + "\t\t\t\t\tids_";
  protected final String TEXT_42 = ".add(summary_";
  protected final String TEXT_43 = ".getId());" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "    \t}" + NL + "    \t" + NL + "    \tcom.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsRequest request2_";
  protected final String TEXT_45 = " = new com.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsRequest();" + NL + "    \tif(!ids_";
  protected final String TEXT_46 = ".isEmpty()) {" + NL + "    \t\trequest2_";
  protected final String TEXT_47 = ".withJobFlowIds(ids_";
  protected final String TEXT_48 = ");" + NL + "    \t\temr_";
  protected final String TEXT_49 = ".terminateJobFlows(request2_";
  protected final String TEXT_50 = ");\t" + NL + "    \t} else {" + NL + "    \t\t";
  protected final String TEXT_51 = NL + "    \t\t\tthrow new RuntimeException(\"can't find any running cluster\");" + NL + "    \t\t";
  protected final String TEXT_52 = NL + "    \t\t\tthrow new RuntimeException(\"can't find any running cluster with name : \" + ";
  protected final String TEXT_53 = ");" + NL + "    \t\t";
  protected final String TEXT_54 = NL + "    \t\t\tthrow new RuntimeException(\"can't find any running cluster with id : \" + ";
  protected final String TEXT_55 = ");" + NL + "    \t\t";
  protected final String TEXT_56 = NL + "    \t}" + NL + "    \t" + NL + "\t";
  protected final String TEXT_57 = NL + "\tcom.amazonaws.services.elasticmapreduce.util.StepFactory stepFactory_";
  protected final String TEXT_58 = " = new com.amazonaws.services.elasticmapreduce.util.StepFactory();" + NL + "" + NL + "\tcom.amazonaws.services.elasticmapreduce.model.StepConfig enabledebugging_";
  protected final String TEXT_59 = " = new com.amazonaws.services.elasticmapreduce.model.StepConfig()" + NL + "    \t.withName(\"Enable debugging\")" + NL + "    \t.withActionOnFailure(" + NL + "    \t\tcom.amazonaws.services.elasticmapreduce.model.ActionOnFailure.TERMINATE_JOB_FLOW" + NL + "    \t)" + NL + "    \t.withHadoopJarStep(stepFactory_";
  protected final String TEXT_60 = ".newEnableDebuggingStep());" + NL + "" + NL + "\t";
  protected final String TEXT_61 = NL + "\t";
  protected final String TEXT_62 = "\tString[] applications_";
  protected final String TEXT_63 = " = " + NL + "\t";
  protected final String TEXT_64 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Hive\",\"Hue\",\"Mahout\",\"Pig\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_65 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Hue\",\"Mahout\",\"Pig\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_66 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Mahout\",\"Pig\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_67 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Hive\",\"Pig\"}" + NL + "\t\t";
  protected final String TEXT_68 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Pig\"}" + NL + "\t\t";
  protected final String TEXT_69 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Pig\"}" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Presto-Sandbox\"}" + NL + "\t\t";
  protected final String TEXT_71 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Presto-Sandbox\"}" + NL + "\t\t";
  protected final String TEXT_72 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_73 = NL + "\t\t{\"Hadoop\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_74 = NL + "\t\t{\"Hadoop\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\t;" + NL + "\t" + NL + "    java.util.List<com.amazonaws.services.elasticmapreduce.model.Application> apps_";
  protected final String TEXT_76 = " = new java.util.ArrayList<com.amazonaws.services.elasticmapreduce.model.Application>();" + NL + "\tfor(String application_";
  protected final String TEXT_77 = " : applications_";
  protected final String TEXT_78 = ") {" + NL + "    \tcom.amazonaws.services.elasticmapreduce.model.Application app_";
  protected final String TEXT_79 = " = new com.amazonaws.services.elasticmapreduce.model.Application();" + NL + "    \tapp_";
  protected final String TEXT_80 = ".withName(application_";
  protected final String TEXT_81 = ");" + NL + "    \tapps_";
  protected final String TEXT_82 = ".add(app_";
  protected final String TEXT_83 = ");" + NL + "    }" + NL + "\t";
  protected final String TEXT_84 = NL + "\tcom.amazonaws.services.elasticmapreduce.model.RunJobFlowRequest request_";
  protected final String TEXT_85 = " = new com.amazonaws.services.elasticmapreduce.model.RunJobFlowRequest()" + NL + "    \t.withName(";
  protected final String TEXT_86 = ")" + NL + "    \t";
  protected final String TEXT_87 = NL + "    \t.withLogUri(";
  protected final String TEXT_88 = ")" + NL + "    \t";
  protected final String TEXT_89 = NL + "    \t" + NL + "    \t";
  protected final String TEXT_90 = NL + "    \t\t.withAmiVersion(";
  protected final String TEXT_91 = ")" + NL + "    \t";
  protected final String TEXT_92 = NL + "    \t\t.withReleaseLabel(";
  protected final String TEXT_93 = ")" + NL + "    \t";
  protected final String TEXT_94 = NL + "    \t" + NL + "    \t";
  protected final String TEXT_95 = NL + "    \t\t.withApplications(apps_";
  protected final String TEXT_96 = ")" + NL + "    \t";
  protected final String TEXT_97 = NL + "    \t" + NL + "    \t.withSteps(enabledebugging_";
  protected final String TEXT_98 = ")" + NL + "    \t" + NL + "    \t.withServiceRole(";
  protected final String TEXT_99 = ")" + NL + "    \t.withJobFlowRole(";
  protected final String TEXT_100 = ")" + NL + "    \t" + NL + "    \t";
  protected final String TEXT_101 = NL + "    \t.withVisibleToAllUsers(true)" + NL + "    \t";
  protected final String TEXT_102 = NL + "    \t" + NL + "    \t.withInstances(" + NL + "    \t\tnew com.amazonaws.services.elasticmapreduce.model.JobFlowInstancesConfig()" + NL + "    \t\t\t.withInstanceCount(";
  protected final String TEXT_103 = ")" + NL + "    \t\t\t";
  protected final String TEXT_104 = NL + "    \t\t\t.withEc2KeyName(";
  protected final String TEXT_105 = ")" + NL + "    \t\t\t";
  protected final String TEXT_106 = NL + "    \t\t\t.withMasterInstanceType(";
  protected final String TEXT_107 = ")" + NL + "    \t\t\t.withSlaveInstanceType(";
  protected final String TEXT_108 = ")" + NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_109 = NL + "    \t\t\t.withPlacement(new com.amazonaws.services.elasticmapreduce.model.PlacementType().withAvailabilityZone(";
  protected final String TEXT_110 = "))" + NL + "    \t\t\t";
  protected final String TEXT_111 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_112 = NL + "    \t\t\t.withEmrManagedMasterSecurityGroup(";
  protected final String TEXT_113 = ")" + NL + "    \t\t\t";
  protected final String TEXT_114 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_115 = NL + "    \t\t\t.withAdditionalMasterSecurityGroups(";
  protected final String TEXT_116 = ".split(\",\"))" + NL + "    \t\t\t";
  protected final String TEXT_117 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_118 = NL + "    \t\t\t.withEmrManagedSlaveSecurityGroup(";
  protected final String TEXT_119 = ")" + NL + "    \t\t\t";
  protected final String TEXT_120 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_121 = NL + "    \t\t\t.withAdditionalSlaveSecurityGroups(";
  protected final String TEXT_122 = ".split(\",\"))" + NL + "    \t\t\t";
  protected final String TEXT_123 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_124 = NL + "    \t\t\t.withTerminationProtected(true)" + NL + "    \t\t\t";
  protected final String TEXT_125 = NL + "    \t\t\t" + NL + "    \t\t\t.withKeepJobFlowAliveWhenNoSteps(true)" + NL + "    \t);" + NL + "" + NL + "\tcom.amazonaws.services.elasticmapreduce.model.RunJobFlowResult result_";
  protected final String TEXT_126 = " = emr_";
  protected final String TEXT_127 = ".runJobFlow(request_";
  protected final String TEXT_128 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_129 = NL + "\tlog.info(\"";
  protected final String TEXT_130 = " - cluster status : \" + result_";
  protected final String TEXT_131 = ");" + NL + "\t";
  protected final String TEXT_132 = NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_133 = "_CLUSTER_FINAL_ID\", result_";
  protected final String TEXT_134 = ".getJobFlowId());" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_135 = "_CLUSTER_FINAL_NAME\", ";
  protected final String TEXT_136 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_137 = NL + "\t\tboolean clusterReady_";
  protected final String TEXT_138 = " = false;" + NL + "        System.out.println(\"Wating for cluster to become available.\");" + NL + "        while (!clusterReady_";
  protected final String TEXT_139 = ") {" + NL + "            com.amazonaws.services.elasticmapreduce.model.DescribeClusterResult result2_";
  protected final String TEXT_140 = " = emr_";
  protected final String TEXT_141 = ".describeCluster(" + NL + "            \tnew com.amazonaws.services.elasticmapreduce.model.DescribeClusterRequest()" + NL + "               \t\t.withClusterId(result_";
  protected final String TEXT_142 = ".getJobFlowId())" + NL + "            );" + NL + "            String status_";
  protected final String TEXT_143 = " = result2_";
  protected final String TEXT_144 = ".getCluster().getStatus().getState();" + NL + "            if (\"WAITING\".equalsIgnoreCase(status_";
  protected final String TEXT_145 = ") || \"RUNNING\".equalsIgnoreCase(status_";
  protected final String TEXT_146 = ")) {" + NL + "                clusterReady_";
  protected final String TEXT_147 = " = true;" + NL + "            } else if(\"TERMINATED_WITH_ERRORS\".equalsIgnoreCase(status_";
  protected final String TEXT_148 = ") || \"TERMINATED\".equalsIgnoreCase(status_";
  protected final String TEXT_149 = ")) {" + NL + "            \tclusterReady_";
  protected final String TEXT_150 = " = true;" + NL + "            \tSystem.err.println(\"Fail to start the cluster.\");" + NL + "            } else {" + NL + "                System.out.print(\".\");" + NL + "                Thread.sleep(2000);" + NL + "            }" + NL + "        }" + NL + "\t";
  protected final String TEXT_151 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String region = ElementParameterParser.getValue(node, "__REGION__");
	String cluster_name = ElementParameterParser.getValue(node, "__CLUSTER_NAME__");
	String cluster_version = ElementParameterParser.getValue(node, "__CLUSTER_VERSION__");
	
	String service_role = ElementParameterParser.getValue(node, "__SERVICE_ROLE__");
	String jobflow_role = ElementParameterParser.getValue(node, "__JOBFLOW_ROLE__");
	
	boolean enable_log = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_LOG__"));
	String log_url = ElementParameterParser.getValue(node, "__LOG_URL__");
	
	boolean enable_key_pair = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_KEY_PAIR__"));
	String key_pair = ElementParameterParser.getValue(node, "__KEY_PAIR__");
	
	int instance_count = Integer.parseInt(ElementParameterParser.getValue(node, "__INSTANCE_COUNT__"));
	
	String master_instance_type = ElementParameterParser.getValue(node, "__MASTER_INSTANCE_TYPE__");
	String slave_instance_type = ElementParameterParser.getValue(node, "__SLAVE_INSTANCE_TYPE__");
	
	boolean visible_to_all_users = "true".equals(ElementParameterParser.getValue(node, "__VISIBLE_TO_ALL_USERS__"));
	
	boolean termination_protected = "true".equals(ElementParameterParser.getValue(node, "__TERMINATION_PROTECTED__"));
	
	String master_security_group = ElementParameterParser.getValue(node, "__MASTER_SECURITY_GROUP__");
	String additional_master_security_groups = ElementParameterParser.getValue(node, "__ADDITIONAL_MASTER_SECURITY_GROUPS__");
	String slave_security_group = ElementParameterParser.getValue(node, "__SLAVE_SECURITY_GROUP__");
	String additional_slave_security_groups = ElementParameterParser.getValue(node, "__ADDITIONAL_SLAVE_SECURITY_GROUPS__");
	
	boolean wait_for_cluster_ready = "true".equals(ElementParameterParser.getValue(node, "__WAIT_FOR_CLUSTER_READY__"));
	
	String accesskey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	
	String availability_zone = ElementParameterParser.getValue(node, "__AVAILABILITY_ZONE__");
	
	boolean isLog4jEnabled = "true".equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	class ParameterUtil {
		
		boolean isValid(String parameterValue) {
			return parameterValue!=null && !parameterValue.isEmpty() && !"\"\"".equals(parameterValue);
		}
	}
	
	ParameterUtil parameterUtil = new ParameterUtil();

    stringBuffer.append(TEXT_2);
    
	String passwordFieldName = "__SECRET_KEY__";
	
    stringBuffer.append(TEXT_3);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(accesskey);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
	if(region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region)){
	
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_18);
    
	}
	
    stringBuffer.append(TEXT_19);
    
	if("STOP".equals(action)) {
	
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
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
    
    	String predicates = ElementParameterParser.getValue(node, "__PREDICATES__");
    	String name = ElementParameterParser.getValue(node, "__NAME_OF_CLUSTER__");
    	String id = ElementParameterParser.getValue(node, "__ID_OF_CLUSTER__");
    	
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
			if("RUNNING".equals(predicates)) {
			
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
			} else if("RUNNING_WITH_NAME".equals(predicates)) {
			
    stringBuffer.append(TEXT_34);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
			} else if("RUNNING_WITH_ID".equals(predicates)) {
			
    stringBuffer.append(TEXT_39);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
			}
			
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
    		if("RUNNING".equals(predicates)) {
    		
    stringBuffer.append(TEXT_51);
    
    		} else if("RUNNING_WITH_NAME".equals(predicates)) {
    		
    stringBuffer.append(TEXT_52);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_53);
    
    		} else if("RUNNING_WITH_ID".equals(predicates)) {
    		
    stringBuffer.append(TEXT_54);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_55);
    
    		}
    		
    stringBuffer.append(TEXT_56);
    
		return stringBuffer.toString();
	}
	
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
	boolean setApps = cluster_version!=null && "\"emr-4.2.0\",\"emr-4.1.0\",\"emr-4.0.0\"".contains(cluster_version);
	if(setApps) {
	
    stringBuffer.append(TEXT_61);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
	String application = ElementParameterParser.getValue(node, "__APPLICATION__");
	if("ALL_APPLICATIONS".equals(application)) {
		if("\"emr-4.2.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_64);
    
		} else if("\"emr-4.1.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_65);
    
		} else if("\"emr-4.0.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_66);
    
		}
	} else if("CORE_HADOOP".equals(application)) {
		if("\"emr-4.2.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_67);
    
		} else if("\"emr-4.1.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_68);
    
		} else if("\"emr-4.0.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_69);
    
		}
	} else if("PRESTO_SANDBOX".equals(application)) {
		if("\"emr-4.2.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_70);
    
		} else if("\"emr-4.1.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_71);
    
		}
	} else if("SPARK".equals(application)) {
		if("\"emr-4.2.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_72);
    
		} else if("\"emr-4.1.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_73);
    
		} else if("\"emr-4.0.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_74);
    
		}
	}
	
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
	}
	
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cluster_name);
    stringBuffer.append(TEXT_86);
    if(enable_log){
    stringBuffer.append(TEXT_87);
    stringBuffer.append(log_url);
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    
    	if(cluster_version!=null && cluster_version.length()>1){
    		if(Character.isDigit(cluster_version.charAt(1))) {//AMI version
    	
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cluster_version);
    stringBuffer.append(TEXT_91);
    
    		} else {//EMR version
    	
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cluster_version);
    stringBuffer.append(TEXT_93);
    
    		}
    	}
    	
    stringBuffer.append(TEXT_94);
    
    	if(setApps) {
    	
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
    	}
    	
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(service_role);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(jobflow_role);
    stringBuffer.append(TEXT_100);
    if(visible_to_all_users){
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    stringBuffer.append(instance_count);
    stringBuffer.append(TEXT_103);
    if(enable_key_pair){
    stringBuffer.append(TEXT_104);
    stringBuffer.append(key_pair);
    stringBuffer.append(TEXT_105);
    }
    stringBuffer.append(TEXT_106);
    stringBuffer.append(master_instance_type);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(slave_instance_type);
    stringBuffer.append(TEXT_108);
    if(parameterUtil.isValid(availability_zone)){
    stringBuffer.append(TEXT_109);
    stringBuffer.append(availability_zone);
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    if(parameterUtil.isValid(master_security_group)){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(master_security_group);
    stringBuffer.append(TEXT_113);
    }
    stringBuffer.append(TEXT_114);
    if(parameterUtil.isValid(additional_master_security_groups)){
    stringBuffer.append(TEXT_115);
    stringBuffer.append(additional_master_security_groups);
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    if(parameterUtil.isValid(slave_security_group)){
    stringBuffer.append(TEXT_118);
    stringBuffer.append(slave_security_group);
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    if(parameterUtil.isValid(additional_slave_security_groups)){
    stringBuffer.append(TEXT_121);
    stringBuffer.append(additional_slave_security_groups);
    stringBuffer.append(TEXT_122);
    }
    stringBuffer.append(TEXT_123);
    if(termination_protected) {
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    }
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cluster_name);
    stringBuffer.append(TEXT_136);
    
	if(wait_for_cluster_ready) {
	
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
	}
	
    stringBuffer.append(TEXT_151);
    return stringBuffer.toString();
  }
}
