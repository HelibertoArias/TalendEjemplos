package org.talend.designer.codegen.translators.business.microsoft_crm;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMicrosoftCrmOutputBeginJava
{
  protected static String nl;
  public static synchronized TMicrosoftCrmOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftCrmOutputBeginJava result = new TMicrosoftCrmOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "          ";
  protected final String TEXT_3 = "class CrmEntityHelper{" + NL + "      private com.microsoft.schemas.xrm._2011.contracts.services.IOrganizationService iorgService;" + NL + "      public CrmEntityHelper(){}" + NL + "      public CrmEntityHelper(com.microsoft.schemas.xrm._2011.contracts.services.IOrganizationService iorgService){" + NL + "             this.iorgService = iorgService;" + NL + "      }" + NL + "      public void setIOrgService(com.microsoft.schemas.xrm._2011.contracts.services.IOrganizationService iorgService){" + NL + "             this.iorgService = iorgService;" + NL + "      }" + NL + "      public com.microsoft.schemas.xrm._2011.contracts.services.IOrganizationService getIOrgService(){" + NL + "            return this.iorgService;" + NL + "      }" + NL + "" + NL + "      public com.microsoft.schemas.xrm._2011.contracts.Entity buildEntity(java.util.Map<String, Object> attrMap){" + NL + "             com.microsoft.schemas.xrm._2011.contracts.Entity" + NL + "                           entity = new com.microsoft.schemas.xrm._2011.contracts.Entity();" + NL + "             com.microsoft.schemas.xrm._2011.contracts.AttributeCollection" + NL + "                           attrColl = new com.microsoft.schemas.xrm._2011.contracts.AttributeCollection();" + NL + "             java.util.List<org.datacontract.schemas._2004._07.system_collections.KeyValuePairOfstringanyType>" + NL + "                          kvPairList = new java.util.ArrayList<org.datacontract.schemas._2004._07.system_collections.KeyValuePairOfstringanyType>();" + NL + "             java.util.Set<java.util.Map.Entry<String, Object>> set = attrMap.entrySet();" + NL + "             for(java.util.Map.Entry<String, Object> entry: set){" + NL + "                String key = entry.getKey();" + NL + "                Object value = entry.getValue();" + NL + "                if(\"Id\".equals(key)){" + NL + "                    com.microsoft.schemas._2003._10.serialization.Guid guid = new com.microsoft.schemas._2003._10.serialization.Guid();" + NL + "                    if(value instanceof java.lang.String){" + NL + "                        guid.setValue((String)value);" + NL + "                    }else{" + NL + "                        guid.setValue(value.toString());" + NL + "                    }" + NL + "                    entity.setId(guid);" + NL + "                }else{" + NL + "                    org.datacontract.schemas._2004._07.system_collections.KeyValuePairOfstringanyType" + NL + "                           kvPair = new org.datacontract.schemas._2004._07.system_collections.KeyValuePairOfstringanyType();" + NL + "                           kvPair.setKey(key);" + NL + "                           kvPair.setValue(value);" + NL + "                           kvPairList.add(kvPair);" + NL + "                }" + NL + "             }" + NL + "             attrColl.getKeyValuePairOfstringanyTypes().addAll(kvPairList);" + NL + "             entity.setAttributes(attrColl);" + NL + "             return entity;" + NL + "      }" + NL + "" + NL + "      public void createEntity(String entityName,java.util.Map<String, Object> attrMap){" + NL + "             com.microsoft.schemas.xrm._2011.contracts.Entity entity = buildEntity(attrMap);" + NL + "             entity.setLogicalName(entityName);" + NL + "             try{" + NL + "                 this.iorgService.create(entity);" + NL + "             }catch(Exception e){" + NL + "                 e.printStackTrace();" + NL + "             }" + NL + "      }" + NL + "" + NL + "      public void deleteEntity(String entityName, String guid){" + NL + "             com.microsoft.schemas._2003._10.serialization.Guid" + NL + "                 guidObj = new com.microsoft.schemas._2003._10.serialization.Guid();" + NL + "                 guidObj.setValue(guid);" + NL + "             try{" + NL + "                 this.iorgService.delete(entityName, guidObj);" + NL + "             }catch(Exception e){" + NL + "                 e.printStackTrace();" + NL + "             }" + NL + "      }" + NL + "" + NL + "      public void updateEntity(String entityName,java.util.Map<String, Object> attrMap){" + NL + "             com.microsoft.schemas.xrm._2011.contracts.Entity entity = buildEntity(attrMap);" + NL + "             entity.setLogicalName(entityName);" + NL + "             try{" + NL + "                 this.iorgService.update(entity);" + NL + "             }catch(Exception e){" + NL + "                 e.printStackTrace();" + NL + "             }" + NL + "      }" + NL + "}" + NL + "" + NL + "class XmlHelper{" + NL + "    public String parseXml(org.dom4j.Document document, String xpath){" + NL + "        @SuppressWarnings(\"unchecked\")" + NL + "        List<org.dom4j.Node> nodeList = document.selectNodes(xpath);" + NL + "        org.dom4j.Node node = nodeList.get(0);" + NL + "        return node.getStringValue();" + NL + "    }" + NL + "}" + NL;
  protected final String TEXT_4 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_5 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = "; ";
  protected final String TEXT_10 = NL + "           System.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "            com.talend.microsoft.crm._2015_.utils.MsCrmWsdl" + NL + "                                 msCrmWsdl_";
  protected final String TEXT_13 = " = new com.talend.microsoft.crm._2015_.utils.MsCrmWsdl(";
  protected final String TEXT_14 = NL + "                                 ";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = NL + "                                 );" + NL + "            com.talend.microsoft.crm._2015_.utils.DynamicsCRMConnector" + NL + "                                crmConnector_";
  protected final String TEXT_17 = " = new com.talend.microsoft.crm._2015_.utils.DynamicsCRMConnector(";
  protected final String TEXT_18 = NL + "                                ";
  protected final String TEXT_19 = ", decryptedPassword_";
  protected final String TEXT_20 = ", msCrmWsdl_";
  protected final String TEXT_21 = NL + "                                );" + NL + "           com.microsoft.schemas.xrm._2011.contracts.services.IOrganizationService" + NL + "                                           iorgService_";
  protected final String TEXT_22 = " = crmConnector_";
  protected final String TEXT_23 = ".getOrganizationService();";
  protected final String TEXT_24 = NL + NL + "CrmEntityHelper crmEntityHelper_";
  protected final String TEXT_25 = " = new CrmEntityHelper(iorgService_";
  protected final String TEXT_26 = ");" + NL + "XmlHelper xmlHelper_";
  protected final String TEXT_27 = " = new XmlHelper();" + NL + "int nb_line_";
  protected final String TEXT_28 = " = 0;" + NL + "" + NL + "final String guid_xpath_";
  protected final String TEXT_29 = " = \"//entity_reference/guid\";" + NL + "final String logical_name_xpath_";
  protected final String TEXT_30 = " = \"//entity_reference/logical_name\";" + NL + "final String name_xpath_";
  protected final String TEXT_31 = " = \"//entity_reference/name\";";
  protected final String TEXT_32 = NL + "\tint nb_line_";
  protected final String TEXT_33 = " = 0;" + NL + "\t";
  protected final String TEXT_34 = NL + "\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.SimpleLog\");" + NL + "    System.setProperty(\"org.apache.commons.logging.simplelog.showdatetime\", \"true\");" + NL + "    System.setProperty(\"org.apache.commons.logging.simplelog.log.httpclient.wire\", \"debug\");" + NL + "    System.setProperty(\"org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient\", \"debug\");" + NL + "\t";
  protected final String TEXT_35 = NL + "\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\t";
  protected final String TEXT_36 = NL + NL + "\t";
  protected final String TEXT_37 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_38 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = "; ";
  protected final String TEXT_43 = NL + NL + "\t";
  protected final String TEXT_44 = NL + "\t\t\torg.apache.commons.httpclient.auth.AuthPolicy.registerAuthScheme(org.apache.commons.httpclient.auth.AuthPolicy.NTLM, org.talend.mscrm.login.ntlm.JCIFS_NTLMScheme.class);" + NL + "" + NL + "\t\t\tcom.microsoft.crm4.webserviceTest.CrmServiceStub service_";
  protected final String TEXT_45 = " = new com.microsoft.crm4.webserviceTest.CrmServiceStub(";
  protected final String TEXT_46 = ");" + NL + "\t\t\torg.apache.axis2.client.Options options_";
  protected final String TEXT_47 = " = service_";
  protected final String TEXT_48 = "._getServiceClient().getOptions();" + NL + "\t\t\torg.apache.axis2.transport.http.HttpTransportProperties.Authenticator auth_";
  protected final String TEXT_49 = " = new org.apache.axis2.transport.http.HttpTransportProperties.Authenticator();" + NL + "" + NL + "\t\t\tList<String> authSchemes_";
  protected final String TEXT_50 = " = new java.util.ArrayList<String>();" + NL + "\t\t\tauthSchemes_";
  protected final String TEXT_51 = ".add(org.apache.axis2.transport.http.HttpTransportProperties.Authenticator.NTLM);" + NL + "\t\t\tauth_";
  protected final String TEXT_52 = " .setAuthSchemes(authSchemes_";
  protected final String TEXT_53 = ");" + NL + "" + NL + "            auth_";
  protected final String TEXT_54 = " .setUsername(";
  protected final String TEXT_55 = ");" + NL + "            auth_";
  protected final String TEXT_56 = " .setPassword(decryptedPassword_";
  protected final String TEXT_57 = ");" + NL + "            auth_";
  protected final String TEXT_58 = " .setHost(";
  protected final String TEXT_59 = ");" + NL + "            auth_";
  protected final String TEXT_60 = " .setPort(";
  protected final String TEXT_61 = ");" + NL + "            auth_";
  protected final String TEXT_62 = " .setDomain(";
  protected final String TEXT_63 = ");" + NL + "            auth_";
  protected final String TEXT_64 = " .setPreemptiveAuthentication(false);" + NL + "" + NL + "            options_";
  protected final String TEXT_65 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, auth_";
  protected final String TEXT_66 = ");" + NL + "            options_";
  protected final String TEXT_67 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.REUSE_HTTP_CLIENT, \"";
  protected final String TEXT_68 = "\");" + NL + "" + NL + "            options_";
  protected final String TEXT_69 = " .setUserName(";
  protected final String TEXT_70 = ");" + NL + "            options_";
  protected final String TEXT_71 = " .setPassword(decryptedPassword_";
  protected final String TEXT_72 = ");" + NL + "            options_";
  protected final String TEXT_73 = " .setTimeOutInMilliSeconds(Long.valueOf(";
  protected final String TEXT_74 = "));" + NL + "" + NL + "            options_";
  protected final String TEXT_75 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.SO_TIMEOUT,new Integer(";
  protected final String TEXT_76 = "));" + NL + "            options_";
  protected final String TEXT_77 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.CONNECTION_TIMEOUT, new Integer(";
  protected final String TEXT_78 = "));" + NL + "" + NL + "            com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument catd_";
  protected final String TEXT_79 = " = com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument.Factory.newInstance();" + NL + "            com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken token_";
  protected final String TEXT_80 = " = com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken.Factory.newInstance();" + NL + "            token_";
  protected final String TEXT_81 = ".setAuthenticationType(0);" + NL + "            token_";
  protected final String TEXT_82 = ".setOrganizationName(";
  protected final String TEXT_83 = ");" + NL + "            catd_";
  protected final String TEXT_84 = ".setCrmAuthenticationToken(token_";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL + "        \tcom.microsoft.crm4.webserviceTest.CrmServiceStub service_";
  protected final String TEXT_87 = " = new com.microsoft.crm4.webserviceTest.CrmServiceStub(\"https://\" + ";
  protected final String TEXT_88 = " + \"/MSCrmServices/2007/CrmService.asmx\");" + NL + "\t\t\torg.apache.axis2.client.Options options_";
  protected final String TEXT_89 = " = service_";
  protected final String TEXT_90 = "._getServiceClient().getOptions();" + NL + "        \torg.talend.mscrm.login.passport.MsDynamicsWrapper msDynamicsWrapper_";
  protected final String TEXT_91 = " = new org.talend.mscrm.login.passport.MsDynamicsWrapper(";
  protected final String TEXT_92 = ",";
  protected final String TEXT_93 = ",";
  protected final String TEXT_94 = ",decryptedPassword_";
  protected final String TEXT_95 = ");" + NL + "\t\t\tmsDynamicsWrapper_";
  protected final String TEXT_96 = ".connect();" + NL + "\t\t\tString crmTicket_";
  protected final String TEXT_97 = " = msDynamicsWrapper_";
  protected final String TEXT_98 = ".getCrmTicket();" + NL + "" + NL + "        \toptions_";
  protected final String TEXT_99 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.REUSE_HTTP_CLIENT, \"";
  protected final String TEXT_100 = "\");" + NL + "        \toptions_";
  protected final String TEXT_101 = " .setTimeOutInMilliSeconds(Long.valueOf(";
  protected final String TEXT_102 = "));" + NL + "" + NL + "            options_";
  protected final String TEXT_103 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.SO_TIMEOUT,new Integer(";
  protected final String TEXT_104 = "));" + NL + "            options_";
  protected final String TEXT_105 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.CONNECTION_TIMEOUT, new Integer(";
  protected final String TEXT_106 = "));" + NL + "" + NL + "        \tcom.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument catd_";
  protected final String TEXT_107 = " = com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument.Factory.newInstance();" + NL + "            com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken token_";
  protected final String TEXT_108 = " = com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken.Factory.newInstance();" + NL + "            token_";
  protected final String TEXT_109 = ".setAuthenticationType(1);" + NL + "            token_";
  protected final String TEXT_110 = ".setOrganizationName(";
  protected final String TEXT_111 = ");" + NL + "            token_";
  protected final String TEXT_112 = ".setCrmTicket(crmTicket_";
  protected final String TEXT_113 = ");" + NL + "            catd_";
  protected final String TEXT_114 = ".setCrmAuthenticationToken(token_";
  protected final String TEXT_115 = ");" + NL + "    \t";
  protected final String TEXT_116 = NL + "    \torg.talend.ms.crm.MSCRMClient client_";
  protected final String TEXT_117 = " = new org.talend.ms.crm.MSCRMClient(";
  protected final String TEXT_118 = ", decryptedPassword_";
  protected final String TEXT_119 = ", ";
  protected final String TEXT_120 = ");" + NL + "\t\tclient_";
  protected final String TEXT_121 = ".setTimeout(";
  protected final String TEXT_122 = ");" + NL + "\t\tclient_";
  protected final String TEXT_123 = ".setReuseHttpClient(";
  protected final String TEXT_124 = ");" + NL + "\t\tcom.microsoft.schemas.xrm._2011.contracts.OrganizationServiceStub serviceStub_";
  protected final String TEXT_125 = " = client_";
  protected final String TEXT_126 = ".getOnlineConnection(";
  protected final String TEXT_127 = ");";
  protected final String TEXT_128 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    String authenticationType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
    String crmVersion = ElementParameterParser.getValue(node, "__MS_CRM_VERSION__");

    boolean isMsCrm2015OnPremise = "ON_PREMISE".equals(authenticationType) && "CRM_2015".equals(crmVersion);

    if(isMsCrm2015OnPremise){
       
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    
    String domainUserName = ElementParameterParser.getValue(node, "__USERNAME__");

    String passwordFieldName = "__PASSWORD__";
    
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
    

    String organizationWsdl = ElementParameterParser.getValue(node, "__ORGANIZATION_WSDL__");
    String securityServiceWsdl = ElementParameterParser.getValue(node, "__SECURITY_SERVICE_URL__");
    String certificatePath = ElementParameterParser.getValue(node, "__CERTIFICATE_PATH__");

    if(certificatePath != null && !"".equals(certificatePath) && !"\"\"".equals(certificatePath)){
        
    stringBuffer.append(TEXT_10);
    stringBuffer.append( certificatePath );
    stringBuffer.append(TEXT_11);
    
    }
        
    stringBuffer.append(TEXT_12);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( organizationWsdl );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( securityServiceWsdl );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    stringBuffer.append( domainUserName );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    
 
    stringBuffer.append(TEXT_24);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_31);
    
    }else{
        
    
	String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
	String endpointURL = ElementParameterParser.getValue(node, "__ENDPOINTURL__");
	String orgName = ElementParameterParser.getValue(node, "__ORGNAME__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");

	String domain = ElementParameterParser.getValue(node, "__DOMAIN__");
	String host = ElementParameterParser.getValue(node, "__HOST__");
	String port = ElementParameterParser.getValue(node, "__PORT__");
	String timeoutSecTemp = ElementParameterParser.getValue(node, "__TIMEOUT__");
	String timeoutSec = (timeoutSecTemp!=null&&!("").equals(timeoutSecTemp))?timeoutSecTemp:"2";
	int timeout = (int)(Double.valueOf(timeoutSec) * 1000);
	boolean reuseHttpClient = ("true").equals(ElementParameterParser.getValue(node,"__REUSE_HTTP_CLIENT__"));
	boolean debug = ("true").equals(ElementParameterParser.getValue(node,"__DEBUG__"));
	boolean isAPI2011 = ("API_2011").equals(ElementParameterParser.getValue(node,"__API_VERSION__"));
	String discWSDL = ElementParameterParser.getValue(node, "__DISC_WSDL__");
	
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    if(debug){
    stringBuffer.append(TEXT_34);
    }else{
    stringBuffer.append(TEXT_35);
    }

	String passwordFieldName = "__PASSWORD__";
	
    stringBuffer.append(TEXT_36);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_39);
    } else {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    
	if(!isAPI2011 || ("ON_PREMISE").equals(authType)){
		if(("ON_PREMISE").equals(authType)){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(endpointURL);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
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
    stringBuffer.append(username);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    }else if(("ONLINE").equals(authType)){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    }
    }else{
    
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(discWSDL);
    stringBuffer.append(TEXT_127);
    
    }
    
    }

    stringBuffer.append(TEXT_128);
    return stringBuffer.toString();
  }
}
