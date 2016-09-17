package org.talend.designer.codegen.translators.cloud;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TAmazonRedshiftManageBeginJava
{
  protected static String nl;
  public static synchronized TAmazonRedshiftManageBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAmazonRedshiftManageBeginJava result = new TAmazonRedshiftManageBeginJava();
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
  protected final String TEXT_13 = ");" + NL + "   \t" + NL + "\tcom.amazonaws.services.redshift.AmazonRedshiftClient client_";
  protected final String TEXT_14 = " = new com.amazonaws.services.redshift.AmazonRedshiftClient(credentials_";
  protected final String TEXT_15 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_16 = NL + "\tclient_";
  protected final String TEXT_17 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_18 = "));" + NL + "\t";
  protected final String TEXT_19 = NL + "\t" + NL + "\t";
  protected final String TEXT_20 = " " + NL + "\t\t\tfinal String decryptedPwd_";
  protected final String TEXT_21 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "        \tfinal String decryptedPwd_";
  protected final String TEXT_24 = " = ";
  protected final String TEXT_25 = "; ";
  protected final String TEXT_26 = NL + "    \tcom.amazonaws.services.redshift.model.CreateClusterRequest request_";
  protected final String TEXT_27 = " = new com.amazonaws.services.redshift.model.CreateClusterRequest()" + NL + "    \t\t.withClusterIdentifier(";
  protected final String TEXT_28 = ")" + NL + "    \t\t" + NL + "    \t\t.withDBName(";
  protected final String TEXT_29 = ")" + NL + "    \t\t.withPort(new Integer(";
  protected final String TEXT_30 = "))" + NL + "    \t\t.withMasterUsername(";
  protected final String TEXT_31 = ")" + NL + "    \t\t.withMasterUserPassword(decryptedPwd_";
  protected final String TEXT_32 = ")" + NL + "    \t\t" + NL + "    \t\t.withNodeType(";
  protected final String TEXT_33 = ")" + NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_34 = NL + "    \t\t.withNumberOfNodes(";
  protected final String TEXT_35 = ")" + NL + "    \t\t";
  protected final String TEXT_36 = NL + "    \t\t.withClusterType(\"single-node\")" + NL + "    \t\t";
  protected final String TEXT_37 = NL + "    \t\t" + NL + "    \t\t//advanced settings" + NL + "    \t\t";
  protected final String TEXT_38 = NL + "    \t\t.withClusterParameterGroupName(";
  protected final String TEXT_39 = ")" + NL + "    \t\t";
  protected final String TEXT_40 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t.withClusterSubnetGroupName(";
  protected final String TEXT_42 = ")" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t.withPubliclyAccessible(true)" + NL + "    \t\t\t";
  protected final String TEXT_45 = NL + "    \t\t\t.withElasticIp(";
  protected final String TEXT_46 = ")" + NL + "    \t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t.withPubliclyAccessible(false)" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t.withAvailabilityZone(";
  protected final String TEXT_51 = ")" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t.withVpcSecurityGroupIds(";
  protected final String TEXT_54 = ".split(\",\"))" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "    \t;" + NL + "    " + NL + "    \tcom.amazonaws.services.redshift.model.Cluster result_";
  protected final String TEXT_56 = " = client_";
  protected final String TEXT_57 = ".createCluster(request_";
  protected final String TEXT_58 = ");" + NL + "    \t";
  protected final String TEXT_59 = NL + "    \tlog.info(\"";
  protected final String TEXT_60 = " - cluster status : \" + result_";
  protected final String TEXT_61 = ");" + NL + "    \t";
  protected final String TEXT_62 = NL + "    \tglobalMap.put(\"";
  protected final String TEXT_63 = "_CLUSTER_FINAL_ID\", result_";
  protected final String TEXT_64 = ".getClusterIdentifier());" + NL + "    \t" + NL + "    \t";
  protected final String TEXT_65 = NL + "    \t\tboolean clusterReady_";
  protected final String TEXT_66 = " = false;" + NL + "            System.out.println(\"Wating for cluster to become available.\");" + NL + "            while (!clusterReady_";
  protected final String TEXT_67 = ") {" + NL + "                com.amazonaws.services.redshift.model.DescribeClustersResult result2_";
  protected final String TEXT_68 = " = client_";
  protected final String TEXT_69 = ".describeClusters(" + NL + "                \tnew com.amazonaws.services.redshift.model.DescribeClustersRequest()" + NL + "                   \t\t.withClusterIdentifier(result_";
  protected final String TEXT_70 = ".getClusterIdentifier())" + NL + "                );" + NL + "                com.amazonaws.services.redshift.model.Cluster cluster_";
  protected final String TEXT_71 = " = result2_";
  protected final String TEXT_72 = ".getClusters().get(0);" + NL + "                String status_";
  protected final String TEXT_73 = " = cluster_";
  protected final String TEXT_74 = ".getClusterStatus();" + NL + "                if (\"available\".equalsIgnoreCase(status_";
  protected final String TEXT_75 = ")) {" + NL + "                    clusterReady_";
  protected final String TEXT_76 = " = true;" + NL + "                    globalMap.put(\"";
  protected final String TEXT_77 = "_ENDPOINT\", cluster_";
  protected final String TEXT_78 = ".getEndpoint().getAddress());" + NL + "                } else {" + NL + "                    System.out.print(\".\");" + NL + "                    Thread.sleep(2000);" + NL + "                }" + NL + "            }" + NL + "    \t";
  protected final String TEXT_79 = NL + "\t";
  protected final String TEXT_80 = NL + "    \tcom.amazonaws.services.redshift.model.DeleteClusterRequest request_";
  protected final String TEXT_81 = " = new com.amazonaws.services.redshift.model.DeleteClusterRequest()" + NL + "    \t\t.withClusterIdentifier(";
  protected final String TEXT_82 = ")" + NL + "    \t\t";
  protected final String TEXT_83 = NL + "    \t\t.withSkipFinalClusterSnapshot(false)" + NL + "    \t\t.withFinalClusterSnapshotIdentifier(";
  protected final String TEXT_84 = ")" + NL + "    \t\t";
  protected final String TEXT_85 = NL + "    \t\t.withSkipFinalClusterSnapshot(true)" + NL + "    \t\t";
  protected final String TEXT_86 = NL + "\t\t;" + NL + "    " + NL + "\t\tcom.amazonaws.services.redshift.model.Cluster result_";
  protected final String TEXT_87 = " = client_";
  protected final String TEXT_88 = ".deleteCluster(request_";
  protected final String TEXT_89 = ");" + NL + "\t\t";
  protected final String TEXT_90 = NL + "    \tlog.info(\"";
  protected final String TEXT_91 = " - cluster status : \" + result_";
  protected final String TEXT_92 = ");" + NL + "    \t";
  protected final String TEXT_93 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_94 = "_CLUSTER_FINAL_ID\", result_";
  protected final String TEXT_95 = ".getClusterIdentifier());" + NL + "\t";
  protected final String TEXT_96 = NL + "\t\tcom.amazonaws.services.redshift.model.RestoreFromClusterSnapshotRequest request_";
  protected final String TEXT_97 = " = new com.amazonaws.services.redshift.model.RestoreFromClusterSnapshotRequest()" + NL + "    \t\t.withSnapshotIdentifier(";
  protected final String TEXT_98 = ")" + NL + "    \t\t.withClusterIdentifier(";
  protected final String TEXT_99 = ")" + NL + "    \t\t.withPort(new Integer(";
  protected final String TEXT_100 = "))" + NL + "    \t\t.withNodeType(";
  protected final String TEXT_101 = ")" + NL + "    \t\t" + NL + "    \t\t//advanced settings" + NL + "    \t\t";
  protected final String TEXT_102 = NL + "    \t\t.withSnapshotClusterIdentifier(";
  protected final String TEXT_103 = ")" + NL + "    \t\t";
  protected final String TEXT_104 = NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_105 = NL + "    \t\t.withClusterParameterGroupName(";
  protected final String TEXT_106 = ")" + NL + "    \t\t";
  protected final String TEXT_107 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t.withClusterSubnetGroupName(";
  protected final String TEXT_109 = ")" + NL + "\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t.withPubliclyAccessible(true)" + NL + "    \t\t\t";
  protected final String TEXT_112 = NL + "    \t\t\t.withElasticIp(";
  protected final String TEXT_113 = ")" + NL + "    \t\t\t";
  protected final String TEXT_114 = NL + "\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t.withPubliclyAccessible(false)" + NL + "\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t.withAvailabilityZone(";
  protected final String TEXT_118 = ")" + NL + "\t\t\t";
  protected final String TEXT_119 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t.withVpcSecurityGroupIds(";
  protected final String TEXT_121 = ".split(\",\"))" + NL + "\t\t\t";
  protected final String TEXT_122 = NL + "\t\t;" + NL + "\t\tcom.amazonaws.services.redshift.model.Cluster result_";
  protected final String TEXT_123 = " = client_";
  protected final String TEXT_124 = ".restoreFromClusterSnapshot(request_";
  protected final String TEXT_125 = ");" + NL + "\t\t";
  protected final String TEXT_126 = NL + "    \tlog.info(\"";
  protected final String TEXT_127 = " - cluster status : \" + result_";
  protected final String TEXT_128 = ");" + NL + "    \t";
  protected final String TEXT_129 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_130 = "_CLUSTER_FINAL_ID\", result_";
  protected final String TEXT_131 = ".getClusterIdentifier());" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_132 = NL + "    \t\tboolean clusterReady_";
  protected final String TEXT_133 = " = false;" + NL + "            System.out.println(\"Wating for cluster to become available.\");" + NL + "            while (!clusterReady_";
  protected final String TEXT_134 = ") {" + NL + "                com.amazonaws.services.redshift.model.DescribeClustersResult result2_";
  protected final String TEXT_135 = " = client_";
  protected final String TEXT_136 = ".describeClusters(" + NL + "                \tnew com.amazonaws.services.redshift.model.DescribeClustersRequest()" + NL + "                   \t\t.withClusterIdentifier(result_";
  protected final String TEXT_137 = ".getClusterIdentifier())" + NL + "                );" + NL + "                com.amazonaws.services.redshift.model.Cluster cluster_";
  protected final String TEXT_138 = " = result2_";
  protected final String TEXT_139 = ".getClusters().get(0);" + NL + "                String status_";
  protected final String TEXT_140 = " = cluster_";
  protected final String TEXT_141 = ".getClusterStatus();" + NL + "                " + NL + "                String restoreStatus_";
  protected final String TEXT_142 = " = cluster_";
  protected final String TEXT_143 = ".getRestoreStatus().getStatus();" + NL + "                " + NL + "                if (\"available\".equalsIgnoreCase(status_";
  protected final String TEXT_144 = ") && (\"completed\".equalsIgnoreCase(restoreStatus_";
  protected final String TEXT_145 = ") || \"failed\".equalsIgnoreCase(restoreStatus_";
  protected final String TEXT_146 = "))) {" + NL + "                    clusterReady_";
  protected final String TEXT_147 = " = true;" + NL + "                    globalMap.put(\"";
  protected final String TEXT_148 = "_ENDPOINT\", cluster_";
  protected final String TEXT_149 = ".getEndpoint().getAddress());" + NL + "                } else {" + NL + "                    System.out.print(\".\");" + NL + "                    Thread.sleep(2000);" + NL + "                }" + NL + "            }" + NL + "    \t";
  protected final String TEXT_150 = NL + "\t";
  protected final String TEXT_151 = NL + "\t\tcom.amazonaws.services.redshift.model.DeleteClusterSnapshotRequest request_";
  protected final String TEXT_152 = " = new com.amazonaws.services.redshift.model.DeleteClusterSnapshotRequest()" + NL + "    \t\t.withSnapshotIdentifier(";
  protected final String TEXT_153 = ")" + NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_154 = NL + "    \t\t.withSnapshotClusterIdentifier(";
  protected final String TEXT_155 = ")" + NL + "    \t\t";
  protected final String TEXT_156 = NL + "\t\t;" + NL + "\t\tcom.amazonaws.services.redshift.model.Snapshot result_";
  protected final String TEXT_157 = " = client_";
  protected final String TEXT_158 = ".deleteClusterSnapshot(request_";
  protected final String TEXT_159 = ");" + NL + "\t\t";
  protected final String TEXT_160 = NL + "    \tlog.info(\"";
  protected final String TEXT_161 = " - cluster status : \" + result_";
  protected final String TEXT_162 = ");" + NL + "    \t";
  protected final String TEXT_163 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_164 = "_CLUSTER_FINAL_ID\", result_";
  protected final String TEXT_165 = ".getClusterIdentifier());" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String region = ElementParameterParser.getValue(node, "__REGION__");
	
	boolean create_snapshot_when_delete_cluster = "true".equals(ElementParameterParser.getValue(node, "__CREATE_SNAPSHOT_WHEN_DELETE_CLUSTER__"));
	String snapshot_id = ElementParameterParser.getValue(node, "__SNAPSHOT_ID__");
	String cluster_id = ElementParameterParser.getValue(node, "__CLUSTER_ID__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String port = ElementParameterParser.getValue(node, "__PORT__");
	String user = ElementParameterParser.getValue(node, "__USER__");
	String node_type = ElementParameterParser.getValue(node, "__NODE_TYPE__");
	String node_count = ElementParameterParser.getValue(node, "__NODE_COUNT__");
	
	String accesskey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	
	boolean isLog4jEnabled = "true".equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String parameter_group_name = ElementParameterParser.getValue(node, "__PARAMETER_GROUP_NAME__");
	String subnet_group_name = ElementParameterParser.getValue(node, "__SUBNET_GROUP_NAME__");
	
	boolean publicly_accessible = "true".equals(ElementParameterParser.getValue(node, "__PUBLICLY_ACCESSIBLE__"));
	boolean set_public_ip_address = "true".equals(ElementParameterParser.getValue(node, "__SET_PUBLIC_IP_ADDRESS__"));
	String elastic_ip = ElementParameterParser.getValue(node, "__ELASTIC_IP__");
	
	String availability_zone = ElementParameterParser.getValue(node, "__AVAILABILITY_ZONE__");
	String vpc_security_groupids = ElementParameterParser.getValue(node, "__VPC_SECURITY_GROUPIDS__");
	
	boolean wait_for_cluster_ready = "true".equals(ElementParameterParser.getValue(node, "__WAIT_FOR_CLUSTER_READY__"));
	
	String original_cluster_id_of_snapshot = ElementParameterParser.getValue(node, "__ORIGINAL_CLUSTER_ID_OF_SNAPSHOT__");
	
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
    
	if("CREATE_CLUSTER".equals(action)) {
		passwordFieldName = "__PASS__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
		
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_22);
    
        } else {
        
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_25);
    
        }
        
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cluster_id);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(node_type);
    stringBuffer.append(TEXT_33);
    
    		if(new Integer(node_count) > 1){
    		
    stringBuffer.append(TEXT_34);
    stringBuffer.append(node_count);
    stringBuffer.append(TEXT_35);
    
    		} else {
    		
    stringBuffer.append(TEXT_36);
    
    		}
    		
    stringBuffer.append(TEXT_37);
    if(parameterUtil.isValid(parameter_group_name)) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(parameter_group_name);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    if(parameterUtil.isValid(subnet_group_name)) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(subnet_group_name);
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    
			if(publicly_accessible) {
			
    stringBuffer.append(TEXT_44);
    if(set_public_ip_address) {
    stringBuffer.append(TEXT_45);
    stringBuffer.append(elastic_ip);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    
			} else {
			
    stringBuffer.append(TEXT_48);
    
			}
			
    stringBuffer.append(TEXT_49);
    if(parameterUtil.isValid(availability_zone)) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(availability_zone);
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    if(parameterUtil.isValid(vpc_security_groupids)) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(vpc_security_groupids);
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
    	if(wait_for_cluster_ready) {
    	
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
    	}
    	
    stringBuffer.append(TEXT_79);
    
	} else if("DELETE_CLUSTER".equals(action)) {
	
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cluster_id);
    stringBuffer.append(TEXT_82);
    if(create_snapshot_when_delete_cluster) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(snapshot_id);
    stringBuffer.append(TEXT_84);
    } else {
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
	} else if("RESTORE_FROM_SNAPSHOT".equals(action)) {
	
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(snapshot_id);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cluster_id);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(node_type);
    stringBuffer.append(TEXT_101);
    if(parameterUtil.isValid(original_cluster_id_of_snapshot)) {
    stringBuffer.append(TEXT_102);
    stringBuffer.append(original_cluster_id_of_snapshot);
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    if(parameterUtil.isValid(parameter_group_name)) {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(parameter_group_name);
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    if(parameterUtil.isValid(subnet_group_name)) {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(subnet_group_name);
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    
			if(publicly_accessible) {
			
    stringBuffer.append(TEXT_111);
    if(set_public_ip_address) {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(elastic_ip);
    stringBuffer.append(TEXT_113);
    }
    stringBuffer.append(TEXT_114);
    
			} else {
			
    stringBuffer.append(TEXT_115);
    
			}
			
    stringBuffer.append(TEXT_116);
    if(parameterUtil.isValid(availability_zone)) {
    stringBuffer.append(TEXT_117);
    stringBuffer.append(availability_zone);
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    if(parameterUtil.isValid(vpc_security_groupids)) {
    stringBuffer.append(TEXT_120);
    stringBuffer.append(vpc_security_groupids);
    stringBuffer.append(TEXT_121);
    }
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    }
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
    	if(wait_for_cluster_ready) {
    	
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
    	}
    	
    stringBuffer.append(TEXT_150);
    
	} else if("DELETE_SNAPSHOT".equals(action)) {
	
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(snapshot_id);
    stringBuffer.append(TEXT_153);
    if(parameterUtil.isValid(original_cluster_id_of_snapshot)) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(original_cluster_id_of_snapshot);
    stringBuffer.append(TEXT_155);
    }
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
	}
	
    return stringBuffer.toString();
  }
}
