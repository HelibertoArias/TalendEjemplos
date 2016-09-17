package org.talend.designer.codegen.translators.business.microsoft_crm;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
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

public class TMicrosoftCrmInputBeginJava
{
  protected static String nl;
  public static synchronized TMicrosoftCrmInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftCrmInputBeginJava result = new TMicrosoftCrmInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "class CrmClass2JavaClassHelper{" + NL + "    public Object extractValue(Object obj){" + NL + "        Object value = null;" + NL + "        if(obj instanceof com.microsoft.schemas.xrm._2011.contracts.OptionSetValue){" + NL + "            //Integer" + NL + "            value = ((com.microsoft.schemas.xrm._2011.contracts.OptionSetValue)obj).getValue();" + NL + "        }else if(obj instanceof com.microsoft.schemas._2003._10.serialization.Guid){" + NL + "            //String" + NL + "            value = ((com.microsoft.schemas._2003._10.serialization.Guid)obj).getValue();" + NL + "        }else if(obj instanceof com.microsoft.schemas.xrm._2011.contracts.Money){" + NL + "            //BigDecimal" + NL + "            value = ((com.microsoft.schemas.xrm._2011.contracts.Money)obj).getValue();" + NL + "        }else if(obj instanceof com.microsoft.schemas.xrm._2011.contracts.EntityReference){" + NL + "            //JOSN String" + NL + "            com.microsoft.schemas.xrm._2011.contracts.EntityReference entityRef = (com.microsoft.schemas.xrm._2011.contracts.EntityReference)obj;" + NL + "            StringBuilder strBuilder = new StringBuilder(\"{\\\"guid\\\":\\\"\");" + NL + "                          strBuilder.append(entityRef.getId().getValue());" + NL + "                          strBuilder.append(\"\\\",\\\"logical_name\\\":\\\"\");" + NL + "                          strBuilder.append(entityRef.getLogicalName());" + NL + "                          strBuilder.append(\"\\\",\\\"name\\\":\\\"\");" + NL + "                          strBuilder.append(entityRef.getName());" + NL + "                          strBuilder.append(\"\\\"}\");" + NL + "           value = strBuilder.toString();" + NL + "        }else if(obj instanceof com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl){" + NL + "            //java.util.Date" + NL + "            value = ((com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl)obj).toGregorianCalendar().getTime();" + NL + "        }else{" + NL + "           //Object (EntityCollection)" + NL + "           value = obj;" + NL + "        }" + NL + "        return value;" + NL + "    }" + NL + "}" + NL + "" + NL + "CrmClass2JavaClassHelper crmClazzHelper_";
  protected final String TEXT_3 = " = new CrmClass2JavaClassHelper();" + NL + "" + NL + "int nb_line_";
  protected final String TEXT_4 = " = 0;";
  protected final String TEXT_5 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_6 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = "; ";
  protected final String TEXT_11 = NL + "                    System.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "                    com.talend.microsoft.crm._2015_.utils.MsCrmWsdl" + NL + "                                         msCrmWsdl_";
  protected final String TEXT_14 = " = new com.talend.microsoft.crm._2015_.utils.MsCrmWsdl(";
  protected final String TEXT_15 = NL + "                                         ";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = NL + "                                         );" + NL + "                    com.talend.microsoft.crm._2015_.utils.DynamicsCRMConnector" + NL + "                                        crmConnector_";
  protected final String TEXT_18 = " = new com.talend.microsoft.crm._2015_.utils.DynamicsCRMConnector(";
  protected final String TEXT_19 = NL + "                                        ";
  protected final String TEXT_20 = ", decryptedPassword_";
  protected final String TEXT_21 = ", msCrmWsdl_";
  protected final String TEXT_22 = NL + "                                        );" + NL + "                   com.microsoft.schemas.xrm._2011.contracts.services.IOrganizationService" + NL + "                                                   iorgService_";
  protected final String TEXT_23 = " = crmConnector_";
  protected final String TEXT_24 = ".getOrganizationService();" + NL;
  protected final String TEXT_25 = NL + "                    com.microsoft.schemas.xrm._2011.contracts.QueryExpression" + NL + "                                                    queryExp_";
  protected final String TEXT_26 = " = new com.microsoft.schemas.xrm._2011.contracts.QueryExpression();" + NL + "                    com.microsoft.schemas.xrm._2011.contracts.ColumnSet" + NL + "                                                    columnSet_";
  protected final String TEXT_27 = " = new com.microsoft.schemas.xrm._2011.contracts.ColumnSet();" + NL + "                    com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring" + NL + "                                                    arrOfStr_";
  protected final String TEXT_28 = " = new com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring();" + NL;
  protected final String TEXT_29 = NL + "                       com.microsoft.schemas.xrm._2011.contracts.FilterExpression" + NL + "                                     filterExp_";
  protected final String TEXT_30 = " = new com.microsoft.schemas.xrm._2011.contracts.FilterExpression();" + NL + "                       com.microsoft.schemas.xrm._2011.contracts.ArrayOfConditionExpression" + NL + "                                     arrOfAnyConditionExp_";
  protected final String TEXT_31 = " = new com.microsoft.schemas.xrm._2011.contracts.ArrayOfConditionExpression();" + NL;
  protected final String TEXT_32 = NL + "                        com.microsoft.schemas.xrm._2011.contracts.ConditionExpression" + NL + "                                      conditionExp_";
  protected final String TEXT_33 = " = new com.microsoft.schemas.xrm._2011.contracts.ConditionExpression();" + NL + "                                      conditionExp_";
  protected final String TEXT_34 = ".setAttributeName(\"";
  protected final String TEXT_35 = "\");" + NL + "                                      conditionExp_";
  protected final String TEXT_36 = ".setOperator(" + NL + "                                            com.microsoft.schemas.xrm._2011.contracts.ConditionOperator.fromValue(" + NL + "                                            \"";
  protected final String TEXT_37 = "\"));" + NL + "                        com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfanyType" + NL + "                                      arrOfAnyType_";
  protected final String TEXT_38 = " = new com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfanyType();" + NL + "                                      arrOfAnyType_";
  protected final String TEXT_39 = ".getAnyTypes().add(";
  protected final String TEXT_40 = ");" + NL + "                                      conditionExp_";
  protected final String TEXT_41 = ".setValues(arrOfAnyType_";
  protected final String TEXT_42 = ");" + NL + "                                      arrOfAnyConditionExp_";
  protected final String TEXT_43 = ".getConditionExpressions().add(conditionExp_";
  protected final String TEXT_44 = ");" + NL;
  protected final String TEXT_45 = NL + "                                      filterExp_";
  protected final String TEXT_46 = ".setConditions(arrOfAnyConditionExp_";
  protected final String TEXT_47 = ");" + NL + "                                      filterExp_";
  protected final String TEXT_48 = ".setFilterOperator(" + NL + "                                                    com.microsoft.schemas.xrm._2011.contracts.LogicalOperator.fromValue(\"";
  protected final String TEXT_49 = "\")" + NL + "                                                    );" + NL + "                                      queryExp_";
  protected final String TEXT_50 = ".setCriteria(filterExp_";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "                                                    arrOfStr_";
  protected final String TEXT_53 = ".getStrings().addAll(" + NL + "                                                            java.util.Arrays.asList(";
  protected final String TEXT_54 = ")" + NL + "                                                    );" + NL + "                                      columnSet_";
  protected final String TEXT_55 = ".setColumns(arrOfStr_";
  protected final String TEXT_56 = ");" + NL + "                                      queryExp_";
  protected final String TEXT_57 = ".setColumnSet(columnSet_";
  protected final String TEXT_58 = ");" + NL + "                                      queryExp_";
  protected final String TEXT_59 = ".setEntityName(\"";
  protected final String TEXT_60 = "\");" + NL;
  protected final String TEXT_61 = NL + "                    com.microsoft.schemas.xrm._2011.contracts.EntityCollection" + NL + "                                  entityCollection_";
  protected final String TEXT_62 = " = iorgService_";
  protected final String TEXT_63 = ".retrieveMultiple(queryExp_";
  protected final String TEXT_64 = ");" + NL + "                    List<com.microsoft.schemas.xrm._2011.contracts.Entity>" + NL + "                                  entityList_";
  protected final String TEXT_65 = " = entityCollection_";
  protected final String TEXT_66 = ".getEntities().getEntities();" + NL + "                    java.util.Map<String,Object> map_";
  protected final String TEXT_67 = " = new java.util.HashMap<String,Object>();" + NL + "                    //Entity For Loop Begin" + NL + "                    for(com.microsoft.schemas.xrm._2011.contracts.Entity entity: entityList_";
  protected final String TEXT_68 = "){" + NL + "                            nb_line_";
  protected final String TEXT_69 = " ++;" + NL + "                            map_";
  protected final String TEXT_70 = ".clear();" + NL + "                            List<org.datacontract.schemas._2004._07.system_collections.KeyValuePairOfstringanyType>" + NL + "                                     props = entity.getAttributes().getKeyValuePairOfstringanyTypes();" + NL + "                            for(org.datacontract.schemas._2004._07.system_collections.KeyValuePairOfstringanyType prop: props){" + NL + "                                String key = prop.getKey(); Object value = prop.getValue();" + NL + "                                map_";
  protected final String TEXT_71 = ".put(key,value);" + NL + "                            }";
  protected final String TEXT_72 = NL + "                                    if(map_";
  protected final String TEXT_73 = ".get(\"";
  protected final String TEXT_74 = "\") != null){" + NL + "                                        Object obj_";
  protected final String TEXT_75 = " = crmClazzHelper_";
  protected final String TEXT_76 = ".extractValue(map_";
  protected final String TEXT_77 = ".get(\"";
  protected final String TEXT_78 = "\"));";
  protected final String TEXT_79 = NL + "                                            ";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = " = obj_";
  protected final String TEXT_82 = ".toString();";
  protected final String TEXT_83 = NL + "                                           ";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = " = map_";
  protected final String TEXT_86 = ".get(\"";
  protected final String TEXT_87 = "\");";
  protected final String TEXT_88 = NL + "                                            if(obj_";
  protected final String TEXT_89 = " instanceof java.util.Date){";
  protected final String TEXT_90 = NL + "                                                 ";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = (java.util.Date)obj_";
  protected final String TEXT_93 = ";" + NL + "                                            }else{";
  protected final String TEXT_94 = NL + "                                                 ";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = " = ParserUtils.parseTo_Date(obj_";
  protected final String TEXT_97 = ".toString(), ";
  protected final String TEXT_98 = ");" + NL + "                                            }";
  protected final String TEXT_99 = NL + "                                            if(obj_";
  protected final String TEXT_100 = " instanceof java.lang.Integer){";
  protected final String TEXT_101 = NL + "                                                ";
  protected final String TEXT_102 = ".";
  protected final String TEXT_103 = " = (java.lang.Integer)obj_";
  protected final String TEXT_104 = ";" + NL + "                                            }else{";
  protected final String TEXT_105 = NL + "                                                ";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = " = ParserUtils.parseTo_Integer(obj_";
  protected final String TEXT_108 = ".toString());" + NL + "                                            }";
  protected final String TEXT_109 = NL + "                                           if(obj_";
  protected final String TEXT_110 = " instanceof java.math.BigDecimal){";
  protected final String TEXT_111 = NL + "                                             ";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = " = (java.math.BigDecimal)obj_";
  protected final String TEXT_114 = ";" + NL + "                                           }else{";
  protected final String TEXT_115 = NL + "                                             ";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = " = ParserUtils.parseTo_BigDecimal(obj_";
  protected final String TEXT_118 = ".toString());" + NL + "                                           }";
  protected final String TEXT_119 = NL + "                                            ";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = " = ParserUtils.parseTo_";
  protected final String TEXT_122 = "(obj_";
  protected final String TEXT_123 = ".toString());";
  protected final String TEXT_124 = NL + "                                    }else{";
  protected final String TEXT_125 = NL + "                                        ";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = " = ";
  protected final String TEXT_128 = ";" + NL + "                                    }";
  protected final String TEXT_129 = NL + "int nb_line_";
  protected final String TEXT_130 = " = 0;";
  protected final String TEXT_131 = NL + "\t\t\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.SimpleLog\");" + NL + "\t\t    System.setProperty(\"org.apache.commons.logging.simplelog.showdatetime\", \"true\");" + NL + "\t\t    System.setProperty(\"org.apache.commons.logging.simplelog.log.httpclient.wire\", \"debug\");" + NL + "\t\t    System.setProperty(\"org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient\", \"debug\");" + NL + "\t\t\t";
  protected final String TEXT_132 = NL + "\t\t\tSystem.setProperty(\"org.apache.commons.logging.Log\", \"org.apache.commons.logging.impl.NoOpLog\");" + NL + "\t\t\t";
  protected final String TEXT_133 = NL + NL + "\t\t\t";
  protected final String TEXT_134 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_135 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_138 = " = ";
  protected final String TEXT_139 = "; ";
  protected final String TEXT_140 = NL + NL + "\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\t\torg.apache.commons.httpclient.auth.AuthPolicy.registerAuthScheme(org.apache.commons.httpclient.auth.AuthPolicy.NTLM, org.talend.mscrm.login.ntlm.JCIFS_NTLMScheme.class);" + NL + "" + NL + "\t\t\t\t\tcom.microsoft.crm4.webserviceTest.CrmServiceStub service_";
  protected final String TEXT_142 = " = new com.microsoft.crm4.webserviceTest.CrmServiceStub(";
  protected final String TEXT_143 = ");" + NL + "\t\t\t\t\torg.apache.axis2.client.Options options_";
  protected final String TEXT_144 = " = service_";
  protected final String TEXT_145 = "._getServiceClient().getOptions();" + NL + "\t\t\t\t\torg.apache.axis2.transport.http.HttpTransportProperties.Authenticator auth_";
  protected final String TEXT_146 = " = new org.apache.axis2.transport.http.HttpTransportProperties.Authenticator();" + NL + "" + NL + "\t\t\t\t\tList<String> authSchemes_";
  protected final String TEXT_147 = " = new java.util.ArrayList<String>();" + NL + "\t\t\t\t\tauthSchemes_";
  protected final String TEXT_148 = ".add(org.apache.axis2.transport.http.HttpTransportProperties.Authenticator.NTLM);" + NL + "\t\t\t\t\tauth_";
  protected final String TEXT_149 = " .setAuthSchemes(authSchemes_";
  protected final String TEXT_150 = ");" + NL + "" + NL + "\t\t            auth_";
  protected final String TEXT_151 = " .setUsername(";
  protected final String TEXT_152 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_153 = " .setPassword(decryptedPassword_";
  protected final String TEXT_154 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_155 = " .setHost(";
  protected final String TEXT_156 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_157 = " .setPort(";
  protected final String TEXT_158 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_159 = " .setDomain(";
  protected final String TEXT_160 = ");" + NL + "\t\t            auth_";
  protected final String TEXT_161 = " .setPreemptiveAuthentication(false);" + NL + "" + NL + "\t\t            options_";
  protected final String TEXT_162 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, auth_";
  protected final String TEXT_163 = ");" + NL + "\t\t           \toptions_";
  protected final String TEXT_164 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.REUSE_HTTP_CLIENT, \"";
  protected final String TEXT_165 = "\");" + NL + "" + NL + "" + NL + "\t\t            options_";
  protected final String TEXT_166 = " .setUserName(";
  protected final String TEXT_167 = ");" + NL + "\t\t            options_";
  protected final String TEXT_168 = " .setPassword(decryptedPassword_";
  protected final String TEXT_169 = ");" + NL + "\t\t            options_";
  protected final String TEXT_170 = " .setTimeOutInMilliSeconds(Long.valueOf(";
  protected final String TEXT_171 = "));" + NL + "" + NL + "\t\t            options_";
  protected final String TEXT_172 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.SO_TIMEOUT,new Integer(";
  protected final String TEXT_173 = "));" + NL + "\t\t            options_";
  protected final String TEXT_174 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.CONNECTION_TIMEOUT, new Integer(";
  protected final String TEXT_175 = "));" + NL + "" + NL + "\t\t            com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument catd_";
  protected final String TEXT_176 = " = com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument.Factory.newInstance();" + NL + "\t\t            com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken token_";
  protected final String TEXT_177 = " = com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken.Factory.newInstance();" + NL + "\t\t            token_";
  protected final String TEXT_178 = ".setAuthenticationType(0);" + NL + "\t\t            token_";
  protected final String TEXT_179 = ".setOrganizationName(";
  protected final String TEXT_180 = ");" + NL + "\t\t            catd_";
  protected final String TEXT_181 = ".setCrmAuthenticationToken(token_";
  protected final String TEXT_182 = ");" + NL + "\t\t        ";
  protected final String TEXT_183 = NL + "\t\t        \tcom.microsoft.crm4.webserviceTest.CrmServiceStub service_";
  protected final String TEXT_184 = " = new com.microsoft.crm4.webserviceTest.CrmServiceStub(\"https://\" + ";
  protected final String TEXT_185 = " + \"/MSCrmServices/2007/CrmService.asmx\");" + NL + "\t\t\t\t\torg.apache.axis2.client.Options options_";
  protected final String TEXT_186 = " = service_";
  protected final String TEXT_187 = "._getServiceClient().getOptions();" + NL + "\t\t        \torg.talend.mscrm.login.passport.MsDynamicsWrapper msDynamicsWrapper_";
  protected final String TEXT_188 = " = new org.talend.mscrm.login.passport.MsDynamicsWrapper(";
  protected final String TEXT_189 = ",";
  protected final String TEXT_190 = ",";
  protected final String TEXT_191 = ",decryptedPassword_";
  protected final String TEXT_192 = ");" + NL + "\t\t\t\t\tmsDynamicsWrapper_";
  protected final String TEXT_193 = ".connect();" + NL + "\t\t\t\t\tString crmTicket_";
  protected final String TEXT_194 = " = msDynamicsWrapper_";
  protected final String TEXT_195 = ".getCrmTicket();" + NL + "" + NL + "\t\t        \toptions_";
  protected final String TEXT_196 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.REUSE_HTTP_CLIENT, \"";
  protected final String TEXT_197 = "\");" + NL + "\t\t        \toptions_";
  protected final String TEXT_198 = " .setTimeOutInMilliSeconds(Long.valueOf(";
  protected final String TEXT_199 = "));" + NL + "" + NL + "\t\t            options_";
  protected final String TEXT_200 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.SO_TIMEOUT,new Integer(";
  protected final String TEXT_201 = "));" + NL + "\t\t            options_";
  protected final String TEXT_202 = " .setProperty(org.apache.axis2.transport.http.HTTPConstants.CONNECTION_TIMEOUT, new Integer(";
  protected final String TEXT_203 = "));" + NL + "" + NL + "\t\t        \tcom.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument catd_";
  protected final String TEXT_204 = " = com.microsoft.schemas.crm._2007.webservices.CrmAuthenticationTokenDocument.Factory.newInstance();" + NL + "\t\t            com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken token_";
  protected final String TEXT_205 = " = com.microsoft.schemas.crm._2007.coretypes.CrmAuthenticationToken.Factory.newInstance();" + NL + "\t\t            token_";
  protected final String TEXT_206 = ".setAuthenticationType(1);" + NL + "\t\t            token_";
  protected final String TEXT_207 = ".setOrganizationName(";
  protected final String TEXT_208 = ");" + NL + "\t\t            token_";
  protected final String TEXT_209 = ".setCrmTicket(crmTicket_";
  protected final String TEXT_210 = ");" + NL + "\t\t            catd_";
  protected final String TEXT_211 = ".setCrmAuthenticationToken(token_";
  protected final String TEXT_212 = ");" + NL + "\t\t        ";
  protected final String TEXT_213 = NL + NL + "\t     \t\t";
  protected final String TEXT_214 = NL + "\t        \tcom.microsoft.schemas.crm._2006.query.QueryExpression query_";
  protected final String TEXT_215 = " = com.microsoft.schemas.crm._2006.query.QueryExpression.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas.crm._2006.query.ColumnSet cols_";
  protected final String TEXT_216 = " = com.microsoft.schemas.crm._2006.query.ColumnSet.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas.crm._2006.query.ArrayOfString aos_";
  protected final String TEXT_217 = " = com.microsoft.schemas.crm._2006.query.ArrayOfString.Factory.newInstance();" + NL + "\t       \t\t";
  protected final String TEXT_218 = NL + "\t            \t\tcom.microsoft.schemas.crm._2006.query.ConditionExpression condition_";
  protected final String TEXT_219 = " = com.microsoft.schemas.crm._2006.query.ConditionExpression.Factory.newInstance();" + NL + "\t            \t\tcondition_";
  protected final String TEXT_220 = ".setAttributeName(\"";
  protected final String TEXT_221 = "\");" + NL + "\t            \t\tcondition_";
  protected final String TEXT_222 = ".setOperator(com.microsoft.schemas.crm._2006.query.ConditionOperator.Enum.forString(\"";
  protected final String TEXT_223 = "\"));" + NL + "\t        \t\t\t";
  protected final String TEXT_224 = NL + "\t            \t\t\tcom.microsoft.schemas.crm._2006.query.ArrayOfAnyType values_";
  protected final String TEXT_225 = " = com.microsoft.schemas.crm._2006.query.ArrayOfAnyType.Factory.newInstance();" + NL + "\t            \t\t\torg.xmlsoap.schemas.soap.encoding.String StringValue_";
  protected final String TEXT_226 = " = org.xmlsoap.schemas.soap.encoding.String.Factory.newInstance();" + NL + "\t            \t\t\tStringValue_";
  protected final String TEXT_227 = ".setStringValue(";
  protected final String TEXT_228 = ");" + NL + "\t            \t\t\tvalues_";
  protected final String TEXT_229 = ".setValueArray(new org.xmlsoap.schemas.soap.encoding.String[] { StringValue_";
  protected final String TEXT_230 = " });" + NL + "\t            \t\t\tcondition_";
  protected final String TEXT_231 = ".setValues(values_";
  protected final String TEXT_232 = ");" + NL + "\t       \t\t\t\t";
  protected final String TEXT_233 = NL + "\t        \t\tcom.microsoft.schemas.crm._2006.query.ArrayOfConditionExpression conditions_";
  protected final String TEXT_234 = " = com.microsoft.schemas.crm._2006.query.ArrayOfConditionExpression.Factory.newInstance();" + NL + "\t        \t\tconditions_";
  protected final String TEXT_235 = ".setConditionArray(new com.microsoft.schemas.crm._2006.query.ConditionExpression[] { ";
  protected final String TEXT_236 = " });" + NL + "\t        \t\t";
  protected final String TEXT_237 = NL + "\t        \t\t\tcom.microsoft.schemas.crm._2006.query.FilterExpression filter_";
  protected final String TEXT_238 = " = com.microsoft.schemas.crm._2006.query.FilterExpression.Factory.newInstance();" + NL + "\t        \t\t\tfilter_";
  protected final String TEXT_239 = ".setFilterOperator(com.microsoft.schemas.crm._2006.query.LogicalOperator.Enum.forString(\"";
  protected final String TEXT_240 = "\"));" + NL + "\t        \t\t\tfilter_";
  protected final String TEXT_241 = ".setConditions(conditions_";
  protected final String TEXT_242 = ");" + NL + "\t        \t\t\tquery_";
  protected final String TEXT_243 = ".setCriteria(filter_";
  protected final String TEXT_244 = ");" + NL + "\t       \t\t\t";
  protected final String TEXT_245 = NL + NL + "\t        \t";
  protected final String TEXT_246 = NL + "\t        \taos_";
  protected final String TEXT_247 = ".setAttributeArray(new String[]{";
  protected final String TEXT_248 = "});" + NL + "\t        \tcols_";
  protected final String TEXT_249 = ".setAttributes(aos_";
  protected final String TEXT_250 = ");" + NL + "\t        \tquery_";
  protected final String TEXT_251 = ".setColumnSet(cols_";
  protected final String TEXT_252 = ");" + NL + "\t        \tquery_";
  protected final String TEXT_253 = ".setEntityName(\"";
  protected final String TEXT_254 = "\");" + NL + "" + NL + "\t        \tcom.microsoft.schemas.crm._2006.query.PagingInfo pagingInfo_";
  protected final String TEXT_255 = " = com.microsoft.schemas.crm._2006.query.PagingInfo.Factory.newInstance();" + NL + "\t        \tint pageNumber_";
  protected final String TEXT_256 = " = 1;" + NL + "\t        \tpagingInfo_";
  protected final String TEXT_257 = ".setPageNumber(pageNumber_";
  protected final String TEXT_258 = ");" + NL + "\t        \t";
  protected final String TEXT_259 = NL + "\t        \tpagingInfo_";
  protected final String TEXT_260 = ".setCount(5);" + NL + "\t        \t";
  protected final String TEXT_261 = NL + "\t        \tquery_";
  protected final String TEXT_262 = ".setPageInfo(pagingInfo_";
  protected final String TEXT_263 = ");" + NL + "" + NL + "\t        \tcom.microsoft.schemas.crm._2007.webservices.RetrieveMultipleRequest rmr_";
  protected final String TEXT_264 = " = com.microsoft.schemas.crm._2007.webservices.RetrieveMultipleRequest.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Execute execute_";
  protected final String TEXT_265 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Execute.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas.crm._2007.webservices.ExecuteDocument executeDoc_";
  protected final String TEXT_266 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Factory.newInstance();" + NL + "\t        \trmr_";
  protected final String TEXT_267 = ".setReturnDynamicEntities(true);" + NL + "\t        \trmr_";
  protected final String TEXT_268 = ".setQuery(query_";
  protected final String TEXT_269 = ");" + NL + "\t        \texecute_";
  protected final String TEXT_270 = ".setRequest(rmr_";
  protected final String TEXT_271 = ");" + NL + "\t        \texecuteDoc_";
  protected final String TEXT_272 = ".setExecute(execute_";
  protected final String TEXT_273 = ");" + NL + "\t        \texecuteDoc_";
  protected final String TEXT_274 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Factory.parse(executeDoc_";
  protected final String TEXT_275 = ".toString());" + NL + "\t        \tcom.microsoft.schemas.crm._2007.webservices.ExecuteResponseDocument result_";
  protected final String TEXT_276 = ";" + NL + "\t        \tboolean fetchMore_";
  protected final String TEXT_277 = " = true;" + NL + "\t        \twhile (fetchMore_";
  protected final String TEXT_278 = ") {" + NL + "\t        \t\tresult_";
  protected final String TEXT_279 = " = service_";
  protected final String TEXT_280 = ".execute(executeDoc_";
  protected final String TEXT_281 = ", catd_";
  protected final String TEXT_282 = ", null, null);" + NL + "\t        \t\tcom.microsoft.schemas.crm._2007.webservices.ExecuteResponseDocument.ExecuteResponse executeResponse_";
  protected final String TEXT_283 = " =  result_";
  protected final String TEXT_284 = ".getExecuteResponse();" + NL + "\t           \t\tcom.microsoft.schemas.crm._2007.webservices.Response response_";
  protected final String TEXT_285 = " = executeResponse_";
  protected final String TEXT_286 = ".getResponse();" + NL + "\t        \t\tcom.microsoft.schemas.crm._2007.webservices.RetrieveMultipleResponse rmp_";
  protected final String TEXT_287 = " = (com.microsoft.schemas.crm._2007.webservices.RetrieveMultipleResponse)response_";
  protected final String TEXT_288 = ";" + NL + "\t        \t\tcom.microsoft.schemas.crm._2006.webservices.BusinessEntityCollection bec_";
  protected final String TEXT_289 = " = rmp_";
  protected final String TEXT_290 = ".getBusinessEntityCollection();" + NL + "\t        \t\tString pagingCookie_";
  protected final String TEXT_291 = " = bec_";
  protected final String TEXT_292 = ".getPagingCookie();" + NL + "\t        \t\tfetchMore_";
  protected final String TEXT_293 = " = bec_";
  protected final String TEXT_294 = ".getMoreRecords();" + NL + "\t        \t\tcom.microsoft.schemas.crm._2006.webservices.ArrayOfBusinessEntity aobe_";
  protected final String TEXT_295 = " = bec_";
  protected final String TEXT_296 = ".getBusinessEntities();" + NL + "\t        \t\tcom.microsoft.schemas.crm._2006.webservices.BusinessEntity[] entities_";
  protected final String TEXT_297 = " = aobe_";
  protected final String TEXT_298 = ".getBusinessEntityArray();" + NL + "" + NL + "\t        \t\tfor (int i_";
  protected final String TEXT_299 = " = 0; i_";
  protected final String TEXT_300 = " < entities_";
  protected final String TEXT_301 = ".length; i_";
  protected final String TEXT_302 = "++) {" + NL + "\t                    com.microsoft.schemas.crm._2006.webservices.DynamicEntity dynamicEntity_";
  protected final String TEXT_303 = " = (com.microsoft.schemas.crm._2006.webservices.DynamicEntity)entities_";
  protected final String TEXT_304 = "[i_";
  protected final String TEXT_305 = "];" + NL + "\t                    com.microsoft.schemas.crm._2006.webservices.DynamicEntity.Properties properties_";
  protected final String TEXT_306 = " = dynamicEntity_";
  protected final String TEXT_307 = ".getProperties();" + NL + "\t                    com.microsoft.schemas.crm._2006.webservices.Property[] propertyArray_";
  protected final String TEXT_308 = " = properties_";
  protected final String TEXT_309 = ".getPropertyArray();" + NL + "\t                   \tnb_line_";
  protected final String TEXT_310 = " ++;" + NL + "\t                    String[] propertyValue_";
  protected final String TEXT_311 = " = new String[propertyArray_";
  protected final String TEXT_312 = ".length];" + NL + "\t                    String propertyType_";
  protected final String TEXT_313 = ";" + NL + "\t                    java.util.Map<String,String> propertyMap_";
  protected final String TEXT_314 = " = new java.util.HashMap<String,String>();" + NL + "" + NL + "\t                    for(int j_";
  protected final String TEXT_315 = " = 0; j_";
  protected final String TEXT_316 = " < propertyArray_";
  protected final String TEXT_317 = ".length; j_";
  protected final String TEXT_318 = "++){" + NL + "" + NL + "\t                    \tpropertyType_";
  protected final String TEXT_319 = " = propertyArray_";
  protected final String TEXT_320 = "[j_";
  protected final String TEXT_321 = "].schemaType().getShortJavaName();" + NL + "\t                    \tif(\"CrmBooleanProperty\".equals(propertyType_";
  protected final String TEXT_322 = ")){" + NL + "\t                    \t\tcom.microsoft.schemas.crm._2006.webservices.CrmBooleanProperty tempProperty_";
  protected final String TEXT_323 = " = (com.microsoft.schemas.crm._2006.webservices.CrmBooleanProperty)propertyArray_";
  protected final String TEXT_324 = "[j_";
  protected final String TEXT_325 = "];" + NL + "\t                    \t\tpropertyValue_";
  protected final String TEXT_326 = "[j_";
  protected final String TEXT_327 = "] = tempProperty_";
  protected final String TEXT_328 = ".getValue().getStringValue();" + NL + "\t                    \t\tpropertyMap_";
  protected final String TEXT_329 = ".put(tempProperty_";
  protected final String TEXT_330 = ".getName(),propertyValue_";
  protected final String TEXT_331 = "[j_";
  protected final String TEXT_332 = "]);" + NL + "\t                    \t}else if(\"CrmDateTimeProperty\".equals(propertyType_";
  protected final String TEXT_333 = ")){" + NL + "\t                    \t\tcom.microsoft.schemas.crm._2006.webservices.CrmDateTimeProperty tempProperty_";
  protected final String TEXT_334 = " = (com.microsoft.schemas.crm._2006.webservices.CrmDateTimeProperty)propertyArray_";
  protected final String TEXT_335 = "[j_";
  protected final String TEXT_336 = "];" + NL + "\t\t\t\t\t\t\t\tString tempDateString_";
  protected final String TEXT_337 = " = tempProperty_";
  protected final String TEXT_338 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_339 = NL + "\t\t\t\t\t\t\t\ttempDateString_";
  protected final String TEXT_340 = " = tempDateString_";
  protected final String TEXT_341 = ".substring(0, tempDateString_";
  protected final String TEXT_342 = ".lastIndexOf(\":\")) + tempDateString_";
  protected final String TEXT_343 = ".substring(tempDateString_";
  protected final String TEXT_344 = ".lastIndexOf(\":\") + 1);" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_345 = "[j_";
  protected final String TEXT_346 = "] = tempDateString_";
  protected final String TEXT_347 = ";" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_348 = ".put(tempProperty_";
  protected final String TEXT_349 = ".getName(),propertyValue_";
  protected final String TEXT_350 = "[j_";
  protected final String TEXT_351 = "]);" + NL + "\t                    \t}else if(\"CrmDecimalProperty\".equals(propertyType_";
  protected final String TEXT_352 = ")){" + NL + "\t                    \t\tcom.microsoft.schemas.crm._2006.webservices.CrmDecimalProperty tempProperty_";
  protected final String TEXT_353 = " = (com.microsoft.schemas.crm._2006.webservices.CrmDecimalProperty)propertyArray_";
  protected final String TEXT_354 = "[j_";
  protected final String TEXT_355 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_356 = "[j_";
  protected final String TEXT_357 = "] = tempProperty_";
  protected final String TEXT_358 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_359 = ".put(tempProperty_";
  protected final String TEXT_360 = ".getName(),propertyValue_";
  protected final String TEXT_361 = "[j_";
  protected final String TEXT_362 = "]);" + NL + "\t                    \t}else if(\"CrmFloatProperty\".equals(propertyType_";
  protected final String TEXT_363 = ")){" + NL + "\t                    \t\tcom.microsoft.schemas.crm._2006.webservices.CrmFloatProperty tempProperty_";
  protected final String TEXT_364 = " = (com.microsoft.schemas.crm._2006.webservices.CrmFloatProperty)propertyArray_";
  protected final String TEXT_365 = "[j_";
  protected final String TEXT_366 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_367 = "[j_";
  protected final String TEXT_368 = "] = tempProperty_";
  protected final String TEXT_369 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_370 = ".put(tempProperty_";
  protected final String TEXT_371 = ".getName(),propertyValue_";
  protected final String TEXT_372 = "[j_";
  protected final String TEXT_373 = "]);" + NL + "\t                    \t}else if(\"CrmMoneyProperty\".equals(propertyType_";
  protected final String TEXT_374 = ")){" + NL + "\t                    \t\tcom.microsoft.schemas.crm._2006.webservices.CrmMoneyProperty tempProperty_";
  protected final String TEXT_375 = " = (com.microsoft.schemas.crm._2006.webservices.CrmMoneyProperty)propertyArray_";
  protected final String TEXT_376 = "[j_";
  protected final String TEXT_377 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_378 = "[j_";
  protected final String TEXT_379 = "] = tempProperty_";
  protected final String TEXT_380 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_381 = ".put(tempProperty_";
  protected final String TEXT_382 = ".getName(),propertyValue_";
  protected final String TEXT_383 = "[j_";
  protected final String TEXT_384 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"CrmNumberProperty\".equals(propertyType_";
  protected final String TEXT_385 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.CrmNumberProperty tempProperty_";
  protected final String TEXT_386 = " = (com.microsoft.schemas.crm._2006.webservices.CrmNumberProperty)propertyArray_";
  protected final String TEXT_387 = "[j_";
  protected final String TEXT_388 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_389 = "[j_";
  protected final String TEXT_390 = "] = tempProperty_";
  protected final String TEXT_391 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_392 = ".put(tempProperty_";
  protected final String TEXT_393 = ".getName(),propertyValue_";
  protected final String TEXT_394 = "[j_";
  protected final String TEXT_395 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"CustomerProperty\".equals(propertyType_";
  protected final String TEXT_396 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.CustomerProperty tempProperty_";
  protected final String TEXT_397 = " = (com.microsoft.schemas.crm._2006.webservices.CustomerProperty)propertyArray_";
  protected final String TEXT_398 = "[j_";
  protected final String TEXT_399 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_400 = "[j_";
  protected final String TEXT_401 = "] = tempProperty_";
  protected final String TEXT_402 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_403 = ".put(tempProperty_";
  protected final String TEXT_404 = ".getName(),propertyValue_";
  protected final String TEXT_405 = "[j_";
  protected final String TEXT_406 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"KeyProperty\".equals(propertyType_";
  protected final String TEXT_407 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.KeyProperty tempProperty_";
  protected final String TEXT_408 = " = (com.microsoft.schemas.crm._2006.webservices.KeyProperty)propertyArray_";
  protected final String TEXT_409 = "[j_";
  protected final String TEXT_410 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_411 = "[j_";
  protected final String TEXT_412 = "] = tempProperty_";
  protected final String TEXT_413 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_414 = ".put(tempProperty_";
  protected final String TEXT_415 = ".getName(),propertyValue_";
  protected final String TEXT_416 = "[j_";
  protected final String TEXT_417 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"LookupProperty\".equals(propertyType_";
  protected final String TEXT_418 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.LookupProperty tempProperty_";
  protected final String TEXT_419 = " = (com.microsoft.schemas.crm._2006.webservices.LookupProperty)propertyArray_";
  protected final String TEXT_420 = "[j_";
  protected final String TEXT_421 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_422 = "[j_";
  protected final String TEXT_423 = "] = tempProperty_";
  protected final String TEXT_424 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_425 = ".put(tempProperty_";
  protected final String TEXT_426 = ".getName(),propertyValue_";
  protected final String TEXT_427 = "[j_";
  protected final String TEXT_428 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"OwnerProperty\".equals(propertyType_";
  protected final String TEXT_429 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.OwnerProperty tempProperty_";
  protected final String TEXT_430 = " = (com.microsoft.schemas.crm._2006.webservices.OwnerProperty)propertyArray_";
  protected final String TEXT_431 = "[j_";
  protected final String TEXT_432 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_433 = "[j_";
  protected final String TEXT_434 = "] = tempProperty_";
  protected final String TEXT_435 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_436 = ".put(tempProperty_";
  protected final String TEXT_437 = ".getName(),propertyValue_";
  protected final String TEXT_438 = "[j_";
  protected final String TEXT_439 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"PicklistProperty\".equals(propertyType_";
  protected final String TEXT_440 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.PicklistProperty tempProperty_";
  protected final String TEXT_441 = " = (com.microsoft.schemas.crm._2006.webservices.PicklistProperty)propertyArray_";
  protected final String TEXT_442 = "[j_";
  protected final String TEXT_443 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_444 = "[j_";
  protected final String TEXT_445 = "] = tempProperty_";
  protected final String TEXT_446 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_447 = ".put(tempProperty_";
  protected final String TEXT_448 = ".getName(),propertyValue_";
  protected final String TEXT_449 = "[j_";
  protected final String TEXT_450 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"StateProperty\".equals(propertyType_";
  protected final String TEXT_451 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.StateProperty tempProperty_";
  protected final String TEXT_452 = " = (com.microsoft.schemas.crm._2006.webservices.StateProperty)propertyArray_";
  protected final String TEXT_453 = "[j_";
  protected final String TEXT_454 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_455 = "[j_";
  protected final String TEXT_456 = "] = tempProperty_";
  protected final String TEXT_457 = ".getValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_458 = ".put(tempProperty_";
  protected final String TEXT_459 = ".getName(),propertyValue_";
  protected final String TEXT_460 = "[j_";
  protected final String TEXT_461 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"StatusProperty\".equals(propertyType_";
  protected final String TEXT_462 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.StatusProperty tempProperty_";
  protected final String TEXT_463 = " = (com.microsoft.schemas.crm._2006.webservices.StatusProperty)propertyArray_";
  protected final String TEXT_464 = "[j_";
  protected final String TEXT_465 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_466 = "[j_";
  protected final String TEXT_467 = "] = tempProperty_";
  protected final String TEXT_468 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_469 = ".put(tempProperty_";
  protected final String TEXT_470 = ".getName(),propertyValue_";
  protected final String TEXT_471 = "[j_";
  protected final String TEXT_472 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"StringProperty\".equals(propertyType_";
  protected final String TEXT_473 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.StringProperty tempProperty_";
  protected final String TEXT_474 = " = (com.microsoft.schemas.crm._2006.webservices.StringProperty)propertyArray_";
  protected final String TEXT_475 = "[j_";
  protected final String TEXT_476 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_477 = "[j_";
  protected final String TEXT_478 = "] = tempProperty_";
  protected final String TEXT_479 = ".getValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_480 = ".put(tempProperty_";
  protected final String TEXT_481 = ".getName(),propertyValue_";
  protected final String TEXT_482 = "[j_";
  protected final String TEXT_483 = "]);" + NL + "\t\t\t\t\t\t\t}else if(\"UniqueIdentifierProperty\".equals(propertyType_";
  protected final String TEXT_484 = ")){" + NL + "\t\t\t\t\t\t\t\tcom.microsoft.schemas.crm._2006.webservices.UniqueIdentifierProperty tempProperty_";
  protected final String TEXT_485 = " = (com.microsoft.schemas.crm._2006.webservices.UniqueIdentifierProperty)propertyArray_";
  protected final String TEXT_486 = "[j_";
  protected final String TEXT_487 = "];" + NL + "\t\t\t\t\t\t\t\tpropertyValue_";
  protected final String TEXT_488 = "[j_";
  protected final String TEXT_489 = "] = tempProperty_";
  protected final String TEXT_490 = ".getValue().getStringValue();" + NL + "\t\t\t\t\t\t\t\tpropertyMap_";
  protected final String TEXT_491 = ".put(tempProperty_";
  protected final String TEXT_492 = ".getName(),propertyValue_";
  protected final String TEXT_493 = "[j_";
  protected final String TEXT_494 = "]);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t                    }" + NL + "\t                   \t\t";
  protected final String TEXT_495 = NL + NL + "\t\t\t\t\t\t\t\tif(propertyMap_";
  protected final String TEXT_496 = ".get(\"";
  protected final String TEXT_497 = "\")!=null){" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_498 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_499 = ".";
  protected final String TEXT_500 = " = propertyMap_";
  protected final String TEXT_501 = ".get(\"";
  protected final String TEXT_502 = "\");" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_503 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_504 = ".";
  protected final String TEXT_505 = " = ParserUtils.parseTo_Date(propertyMap_";
  protected final String TEXT_506 = ".get(\"";
  protected final String TEXT_507 = "\"), ";
  protected final String TEXT_508 = ");" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_509 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_510 = ".";
  protected final String TEXT_511 = " = ParserUtils.parseTo_Double(propertyMap_";
  protected final String TEXT_512 = ".get(\"";
  protected final String TEXT_513 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_514 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_515 = ".";
  protected final String TEXT_516 = " = ParserUtils.parseTo_BigDecimal(propertyMap_";
  protected final String TEXT_517 = ".get(\"";
  protected final String TEXT_518 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_519 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_520 = ".";
  protected final String TEXT_521 = " = ParserUtils.parseTo_Float(propertyMap_";
  protected final String TEXT_522 = ".get(\"";
  protected final String TEXT_523 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_524 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_525 = ".";
  protected final String TEXT_526 = " = ParserUtils.parseTo_Integer(propertyMap_";
  protected final String TEXT_527 = ".get(\"";
  protected final String TEXT_528 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_529 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_530 = ".";
  protected final String TEXT_531 = " = ParserUtils.parseTo_Boolean(propertyMap_";
  protected final String TEXT_532 = ".get(\"";
  protected final String TEXT_533 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_534 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_535 = ".";
  protected final String TEXT_536 = " = propertyMap_";
  protected final String TEXT_537 = ".get(\"";
  protected final String TEXT_538 = "\");" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_539 = NL + "\t        \t\t\t\t\t\t\t";
  protected final String TEXT_540 = ".";
  protected final String TEXT_541 = " = ParserUtils.parseTo_";
  protected final String TEXT_542 = "(propertyMap_";
  protected final String TEXT_543 = ".get(\"";
  protected final String TEXT_544 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_545 = NL + "\t        \t\t\t\t\t}else{" + NL + "\t        \t\t\t\t\t\t";
  protected final String TEXT_546 = ".";
  protected final String TEXT_547 = " = ";
  protected final String TEXT_548 = ";" + NL + "\t        \t\t\t\t\t}" + NL + "\t        \t\t\t\t";
  protected final String TEXT_549 = NL + NL + NL + "\t\t\t\t";
  protected final String TEXT_550 = NL + "\t\t\t\torg.talend.ms.crm.MSCRMClient client_";
  protected final String TEXT_551 = " = new org.talend.ms.crm.MSCRMClient(";
  protected final String TEXT_552 = ", decryptedPassword_";
  protected final String TEXT_553 = ", ";
  protected final String TEXT_554 = ");" + NL + "\t\t\t\tclient_";
  protected final String TEXT_555 = ".setTimeout(";
  protected final String TEXT_556 = ");" + NL + "\t\t\t\tclient_";
  protected final String TEXT_557 = ".setReuseHttpClient(";
  protected final String TEXT_558 = ");" + NL + "\t\t\t\tcom.microsoft.schemas.xrm._2011.contracts.OrganizationServiceStub serviceStub_";
  protected final String TEXT_559 = " = client_";
  protected final String TEXT_560 = ".getOnlineConnection(";
  protected final String TEXT_561 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_562 = NL + "\t        \tcom.microsoft.schemas.xrm._2011.contracts.QueryExpression query_";
  protected final String TEXT_563 = " = com.microsoft.schemas.xrm._2011.contracts.QueryExpression.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas.xrm._2011.contracts.ColumnSet cols_";
  protected final String TEXT_564 = " = com.microsoft.schemas.xrm._2011.contracts.ColumnSet.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring aos_";
  protected final String TEXT_565 = " = com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring.Factory.newInstance();" + NL + "\t       \t\t";
  protected final String TEXT_566 = NL + "\t        \t\tcom.microsoft.schemas.xrm._2011.contracts.ArrayOfConditionExpression conditions_";
  protected final String TEXT_567 = " = com.microsoft.schemas.xrm._2011.contracts.ArrayOfConditionExpression.Factory.newInstance();" + NL + "\t        \t\tcom.microsoft.schemas.xrm._2011.contracts.ConditionExpression condition_";
  protected final String TEXT_568 = " = null;" + NL + "\t        \t\tcom.microsoft.schemas._2003._10.serialization.arrays.ArrayOfanyType values_";
  protected final String TEXT_569 = " = null;" + NL + "\t        \t\torg.apache.xmlbeans.XmlString conditionValue_";
  protected final String TEXT_570 = " = null;" + NL + "\t            \t";
  protected final String TEXT_571 = NL + "\t\t            \t\tcondition_";
  protected final String TEXT_572 = " = conditions_";
  protected final String TEXT_573 = ".addNewConditionExpression();" + NL + "\t\t            \t\tcondition_";
  protected final String TEXT_574 = ".setAttributeName(\"";
  protected final String TEXT_575 = "\");" + NL + "\t\t            \t\tcondition_";
  protected final String TEXT_576 = ".setOperator(com.microsoft.schemas.xrm._2011.contracts.ConditionOperator.Enum.forString(\"";
  protected final String TEXT_577 = "\"));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_578 = NL + "\t            \t\t\tvalues_";
  protected final String TEXT_579 = " = com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfanyType.Factory.newInstance();" + NL + "\t            \t\t\tconditionValue_";
  protected final String TEXT_580 = " = org.apache.xmlbeans.XmlString.Factory.newInstance();" + NL + "\t            \t\t\tconditionValue_";
  protected final String TEXT_581 = ".setStringValue(";
  protected final String TEXT_582 = ");" + NL + "\t            \t\t\tvalues_";
  protected final String TEXT_583 = ".setAnyTypeArray(new org.apache.xmlbeans.XmlString[]{conditionValue_";
  protected final String TEXT_584 = "});" + NL + "\t            \t\t\tcondition_";
  protected final String TEXT_585 = ".setValues(values_";
  protected final String TEXT_586 = ");" + NL + "\t       \t\t\t\t";
  protected final String TEXT_587 = NL + "\t        \t\t";
  protected final String TEXT_588 = NL + "\t        \t\t\tcom.microsoft.schemas.xrm._2011.contracts.FilterExpression filter_";
  protected final String TEXT_589 = " = com.microsoft.schemas.xrm._2011.contracts.FilterExpression.Factory.newInstance();" + NL + "\t        \t\t\tfilter_";
  protected final String TEXT_590 = ".setFilterOperator(com.microsoft.schemas.xrm._2011.contracts.LogicalOperator.Enum.forString(\"";
  protected final String TEXT_591 = "\"));" + NL + "\t        \t\t\tfilter_";
  protected final String TEXT_592 = ".setConditions(conditions_";
  protected final String TEXT_593 = ");" + NL + "\t        \t\t\tquery_";
  protected final String TEXT_594 = ".setCriteria(filter_";
  protected final String TEXT_595 = ");" + NL + "\t       \t\t\t";
  protected final String TEXT_596 = NL + NL + "\t        \t";
  protected final String TEXT_597 = NL + "\t        \taos_";
  protected final String TEXT_598 = ".setStringArray(new String[]{";
  protected final String TEXT_599 = "});" + NL + "\t        \tcols_";
  protected final String TEXT_600 = ".setColumns(aos_";
  protected final String TEXT_601 = ");" + NL + "\t        \tquery_";
  protected final String TEXT_602 = ".setColumnSet(cols_";
  protected final String TEXT_603 = ");" + NL + "\t        \tquery_";
  protected final String TEXT_604 = ".setEntityName(\"";
  protected final String TEXT_605 = "\");" + NL + "" + NL + "\t        \tcom.microsoft.schemas.xrm._2011.contracts.PagingInfo pagingInfo_";
  protected final String TEXT_606 = " = com.microsoft.schemas.xrm._2011.contracts.PagingInfo.Factory.newInstance();" + NL + "\t        \tint pageNumber_";
  protected final String TEXT_607 = " = 1;" + NL + "\t        \tpagingInfo_";
  protected final String TEXT_608 = ".setPageNumber(pageNumber_";
  protected final String TEXT_609 = ");" + NL + "\t        \t";
  protected final String TEXT_610 = NL + "\t        \tpagingInfo_";
  protected final String TEXT_611 = ".setCount(5);" + NL + "\t        \t";
  protected final String TEXT_612 = NL + "\t        \tquery_";
  protected final String TEXT_613 = ".setPageInfo(pagingInfo_";
  protected final String TEXT_614 = ");" + NL + "" + NL + "\t        \tcom.microsoft.schemas.xrm._2011.contracts.services.RetrieveMultipleDocument.RetrieveMultiple rmr_";
  protected final String TEXT_615 = " = com.microsoft.schemas.xrm._2011.contracts.services.RetrieveMultipleDocument.RetrieveMultiple.Factory.newInstance();" + NL + "\t        \tcom.microsoft.schemas.xrm._2011.contracts.services.RetrieveMultipleResponseDocument.RetrieveMultipleResponse retrieveMultipleResp_";
  protected final String TEXT_616 = " = null;" + NL + "\t        \twhile(true){" + NL + "\t        \t\trmr_";
  protected final String TEXT_617 = ".setQuery(query_";
  protected final String TEXT_618 = ");" + NL + "\t        \t\tcom.microsoft.schemas.xrm._2011.contracts.services.RetrieveMultipleDocument rmrdoc_";
  protected final String TEXT_619 = " = com.microsoft.schemas.xrm._2011.contracts.services.RetrieveMultipleDocument.Factory.newInstance();" + NL + "\t        \t\trmrdoc_";
  protected final String TEXT_620 = ".setRetrieveMultiple(rmr_";
  protected final String TEXT_621 = ");" + NL + "\t        \t\ttry{" + NL + "\t        \t\t\tretrieveMultipleResp_";
  protected final String TEXT_622 = " = serviceStub_";
  protected final String TEXT_623 = ".retrieveMultiple(rmrdoc_";
  protected final String TEXT_624 = ").getRetrieveMultipleResponse();" + NL + "\t        \t\t}catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_RetrieveMultiple_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_625 = "){" + NL + "\t        \t\t\tthrow new Exception(ex_";
  protected final String TEXT_626 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "\t        \t\t}" + NL + "\t        \t\tcom.microsoft.schemas.xrm._2011.contracts.EntityCollection retrieveMultipleResult_";
  protected final String TEXT_627 = " = retrieveMultipleResp_";
  protected final String TEXT_628 = ".getRetrieveMultipleResult();" + NL + "\t        \t\tcom.microsoft.schemas.xrm._2011.contracts.Entity[] entities_";
  protected final String TEXT_629 = " = retrieveMultipleResult_";
  protected final String TEXT_630 = ".getEntities().getEntityArray();" + NL + "\t        \t\tfor(com.microsoft.schemas.xrm._2011.contracts.Entity entity_";
  protected final String TEXT_631 = " : entities_";
  protected final String TEXT_632 = "){" + NL + "\t                   \tnb_line_";
  protected final String TEXT_633 = "++;" + NL + "\t                    org.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringanyType[] properties_";
  protected final String TEXT_634 = " = entity_";
  protected final String TEXT_635 = ".getAttributes().getKeyValuePairOfstringanyTypeArray();" + NL + "" + NL + "\t                    java.util.Map<String, String> propertyMap_";
  protected final String TEXT_636 = " = new java.util.HashMap<String, String>();" + NL + "\t                    String propertyValue_";
  protected final String TEXT_637 = " = null;" + NL + "\t                    org.apache.xmlbeans.XmlObject tempPropertyValue_";
  protected final String TEXT_638 = " = null;" + NL + "\t                    for(org.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringanyType property_";
  protected final String TEXT_639 = " : properties_";
  protected final String TEXT_640 = "){" + NL + "\t                    \ttempPropertyValue_";
  protected final String TEXT_641 = " = property_";
  protected final String TEXT_642 = ".getValue();" + NL + "\t                    \tif(tempPropertyValue_";
  protected final String TEXT_643 = " instanceof org.apache.xmlbeans.XmlAnySimpleType){" + NL + "\t                    \t\tpropertyValue_";
  protected final String TEXT_644 = " = ((org.apache.xmlbeans.XmlAnySimpleType)tempPropertyValue_";
  protected final String TEXT_645 = ").getStringValue();" + NL + "\t                    \t}else if(tempPropertyValue_";
  protected final String TEXT_646 = " instanceof com.microsoft.schemas.xrm._2011.contracts.OptionSetValue){" + NL + "\t                    \t\tpropertyValue_";
  protected final String TEXT_647 = " = ((com.microsoft.schemas.xrm._2011.contracts.OptionSetValue)tempPropertyValue_";
  protected final String TEXT_648 = ").xgetValue().getStringValue();" + NL + "\t                    \t}else if(tempPropertyValue_";
  protected final String TEXT_649 = " instanceof com.microsoft.schemas.xrm._2011.contracts.Money){" + NL + "\t                    \t\tpropertyValue_";
  protected final String TEXT_650 = " = ((com.microsoft.schemas.xrm._2011.contracts.Money)tempPropertyValue_";
  protected final String TEXT_651 = ").xgetValue().getStringValue();" + NL + "\t                    \t}else if(tempPropertyValue_";
  protected final String TEXT_652 = " instanceof com.microsoft.schemas.xrm._2011.contracts.EntityReference){" + NL + "\t                    \t\tcom.microsoft.schemas.xrm._2011.contracts.EntityReference entityReference_";
  protected final String TEXT_653 = " = (com.microsoft.schemas.xrm._2011.contracts.EntityReference)tempPropertyValue_";
  protected final String TEXT_654 = ";" + NL + "                        \t\tpropertyValue_";
  protected final String TEXT_655 = " = \"{\\\"id\\\":\\\"\"+entityReference_";
  protected final String TEXT_656 = ".getId() + \"\\\",\\\"logicalName\\\":\\\"\" + entityReference_";
  protected final String TEXT_657 = ".getLogicalName() + \"\\\",\\\"name\\\":\\\"\" + entityReference_";
  protected final String TEXT_658 = ".getName() + \"\\\"}\";" + NL + "\t                    \t}else if(tempPropertyValue_";
  protected final String TEXT_659 = " instanceof com.microsoft.schemas.xrm._2011.contracts.BooleanManagedProperty){" + NL + "\t                    \t\tcom.microsoft.schemas.xrm._2011.contracts.BooleanManagedProperty booleanManagedProperty_";
  protected final String TEXT_660 = " = (com.microsoft.schemas.xrm._2011.contracts.BooleanManagedProperty)tempPropertyValue_";
  protected final String TEXT_661 = ";" + NL + "\t                    \t\tpropertyValue_";
  protected final String TEXT_662 = " = \"{\\\"canBeChanged\\\":\\\"\"+booleanManagedProperty_";
  protected final String TEXT_663 = ".getCanBeChanged() + \"\\\",\\\"logicalName\\\":\\\"\" + booleanManagedProperty_";
  protected final String TEXT_664 = ".getManagedPropertyLogicalName() + \"\\\",\\\"value\\\":\\\"\" + booleanManagedProperty_";
  protected final String TEXT_665 = ".getValue() + \"\\\"}\";" + NL + "\t                    \t}else{" + NL + "\t                    \t\tSystem.err.println(\"don't support the type of \" + property_";
  protected final String TEXT_666 = ");" + NL + "\t                    \t\tpropertyValue_";
  protected final String TEXT_667 = " = null;" + NL + "\t                    \t}" + NL + "                    \t\tpropertyMap_";
  protected final String TEXT_668 = ".put(property_";
  protected final String TEXT_669 = ".getKey(), propertyValue_";
  protected final String TEXT_670 = ");" + NL + "\t                    }" + NL + "                   \t\t";
  protected final String TEXT_671 = NL + NL + "\t\t\t\t\t\t\tif(propertyMap_";
  protected final String TEXT_672 = ".get(\"";
  protected final String TEXT_673 = "\")!=null){" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_674 = NL + "\t        \t\t\t\t\t\t";
  protected final String TEXT_675 = ".";
  protected final String TEXT_676 = " = propertyMap_";
  protected final String TEXT_677 = ".get(\"";
  protected final String TEXT_678 = "\");" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_679 = NL + "\t        \t\t\t\t\t\t";
  protected final String TEXT_680 = ".";
  protected final String TEXT_681 = " = ParserUtils.parseTo_Date(propertyMap_";
  protected final String TEXT_682 = ".get(\"";
  protected final String TEXT_683 = "\"), ";
  protected final String TEXT_684 = ");" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_685 = NL + "\t        \t\t\t\t\t\t";
  protected final String TEXT_686 = ".";
  protected final String TEXT_687 = " = ParserUtils.parseTo_";
  protected final String TEXT_688 = "(propertyMap_";
  protected final String TEXT_689 = ".get(\"";
  protected final String TEXT_690 = "\"));" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_691 = NL + "        \t\t\t\t\t}else{" + NL + "        \t\t\t\t\t\t";
  protected final String TEXT_692 = ".";
  protected final String TEXT_693 = " = ";
  protected final String TEXT_694 = ";" + NL + "        \t\t\t\t\t}" + NL + "        \t\t\t\t";
  protected final String TEXT_695 = NL + "\t\t\t\t";
  protected final String TEXT_696 = NL;

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
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
   List<IMetadataTable> metadataTableList = node.getMetadataList();
   if((metadataTableList != null) && (metadataTableList.size() > 0)){
        IMetadataTable metadata = metadataTableList.get(0);
        if(metadata != null){
            List<IMetadataColumn> columnList = metadata.getListColumns();
            int columnSize = columnList.size();
            //Concatenate schemas as string
            String schemasAsString = null;
            StringBuilder strBuilder4Schema = new StringBuilder();
            for(int i = 0; i < columnSize; i++){
                if(i > 0){
                    strBuilder4Schema.append(", ");
                }
                   strBuilder4Schema.append("\"");
                   strBuilder4Schema.append(columnList.get(i).getLabel());
                   strBuilder4Schema.append("\"");
            }
            schemasAsString = strBuilder4Schema.toString();

            List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
            if(columnSize > 0 && outgoingConns != null && outgoingConns.size() > 0){
                 String domainUserName =  ElementParameterParser.getValue(node, "__USERNAME__");
                 String passwordFieldName = "__PASSWORD__";
                 
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_7);
    } else {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    }
    
                 String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
                 int timeoutInSeconds = Integer.valueOf((timeout != null && !"".equals(timeout)) ? timeout : "1").intValue() * 1000;

                 String organizationWsdl = ElementParameterParser.getValue(node, "__ORGANIZATION_WSDL__");
                 String securityServiceWsdl = ElementParameterParser.getValue(node, "__SECURITY_SERVICE_URL__");
                 String certificatePath = ElementParameterParser.getValue(node, "__CERTIFICATE_PATH__");
                 if(certificatePath != null && !"".equals(certificatePath) && !"\"\"".equals(certificatePath)){
                 
    stringBuffer.append(TEXT_11);
    stringBuffer.append( certificatePath );
    stringBuffer.append(TEXT_12);
    
                 }
                 
    stringBuffer.append(TEXT_13);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( organizationWsdl );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( securityServiceWsdl );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( domainUserName );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_24);
    
                   String entityname = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
                   String customEntityname = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
                   if("CustomEntity".equals(entityname)){
                       entityname = customEntityname.replaceAll("\"","");
                   }
                       entityname = entityname.toLowerCase();
                   //Logical Operator for FilterExpression
                   String logicalOperator = ElementParameterParser.getValue(node,"__LOGICAL_OP__");
                   //Logical Operator for ConditionExpression
                   List<Map<String, String>> keyColumns = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__CONDITIONS__");
                 
    stringBuffer.append(TEXT_25);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_28);
    
                //Use Query Criteria
                if(keyColumns.size()>0){
                    
    stringBuffer.append(TEXT_29);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_31);
    
                    StringBuilder strBuilder = new StringBuilder("");
                    int conditionIndex = 0;
                    for(Map<String, String> keyColumn: keyColumns){
                        String conditionId = cid + "_" + String.valueOf(conditionIndex);
                        
    stringBuffer.append(TEXT_32);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_34);
    stringBuffer.append( keyColumn.get("INPUT_COLUMN") );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(keyColumn.get("OPERATOR"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(keyColumn.get("RVALUE"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_42);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append( conditionId );
    stringBuffer.append(TEXT_44);
    
                        conditionIndex ++;
                    }
                        
    stringBuffer.append(TEXT_45);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append( logicalOperator );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_51);
    
                }
                
    stringBuffer.append(TEXT_52);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( schemasAsString );
    stringBuffer.append(TEXT_54);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( entityname );
    stringBuffer.append(TEXT_60);
    
                //Begin to Transfer Data
                IConnection outgoingConn = outgoingConns.get(0);
                if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
                
    stringBuffer.append(TEXT_61);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_71);
    
                                for(int i = 0; i < columnList.size(); i++){
                                    IMetadataColumn column = columnList.get(i);
                                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                                    String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                                    
    stringBuffer.append(TEXT_72);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_74);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_78);
    
                                        if(javaType == JavaTypesManager.STRING){
                                        
    stringBuffer.append(TEXT_79);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_81);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_82);
    
                                        }else if(javaType == JavaTypesManager.OBJECT){
                                        
    stringBuffer.append(TEXT_83);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_85);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_87);
    
                                        }
                                        else if(javaType == JavaTypesManager.DATE){
                                        
    stringBuffer.append(TEXT_88);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_92);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_96);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_98);
    
                                        }else if(javaType == JavaTypesManager.INTEGER){
                                         
    stringBuffer.append(TEXT_99);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_103);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_107);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_108);
    
                                        }else if(javaType == JavaTypesManager.BIGDECIMAL){
                                        
    stringBuffer.append(TEXT_109);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_113);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_117);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_118);
    
                                        }else{
                                        
    stringBuffer.append(TEXT_119);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_122);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_123);
    
                                        }
                                        
    stringBuffer.append(TEXT_124);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_128);
    
                                }
                            
     //}// Entity For Loop end but moved to the end part 
    
                }
            }
        }
    }
 
    
    }else{
        
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);

	if (metadata != null) {
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

		// if output columns are defined
		if(nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){
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
			if(debug){
    stringBuffer.append(TEXT_131);
    }else{
    stringBuffer.append(TEXT_132);
    }

			String passwordFieldName = "__PASSWORD__";
			
    stringBuffer.append(TEXT_133);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_136);
    } else {
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    
			if(!isAPI2011 || ("ON_PREMISE").equals(authType)){
				if(("ON_PREMISE").equals(authType)){
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(endpointURL);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(domain);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    }else if(("ONLINE").equals(authType)){
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    }
    stringBuffer.append(TEXT_213);
    
	     		String entityname = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
	     		String customEntityname = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
	     		if("CustomEntity".equals(entityname)){
					entityname = customEntityname.replaceAll("\"","");
				}
	     		String entitynamealllower = entityname.toLowerCase();
	     		String logical = ElementParameterParser.getValue(node,"__LOGICAL_OP__");
	     		List<Map<String, String>> keyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONDITIONS__");
	     		
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
	        	if(keyColumns.size()>0 ){
	            	StringBuffer conditionList = new StringBuffer("");
	            	int nbCondition = 0;
	            	for(Map<String, String> keyColumn:keyColumns){
	            		nbCondition++;
	            		String conditionID = cid + "_" + String.valueOf(nbCondition);
	        			
    stringBuffer.append(TEXT_218);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(keyColumn.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(keyColumn.get("OPERATOR"));
    stringBuffer.append(TEXT_223);
    
	        			if(!("").equals(keyColumn.get("RVALUE"))){
	        			
    stringBuffer.append(TEXT_224);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(keyColumn.get("RVALUE"));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(conditionID);
    stringBuffer.append(TEXT_232);
    
	            		}
	            		conditionList.append("condition_"+conditionID+",");
	        		}
	        		conditionList.deleteCharAt(conditionList.lastIndexOf(","));
	        		
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(conditionList);
    stringBuffer.append(TEXT_236);
    
	        		if(!("").equals(logical)){
	        		
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    
	        		}
	        	}
	        	
    stringBuffer.append(TEXT_245);
    
	        	StringBuilder sb = new StringBuilder("");
	        	for(IMetadataColumn column: columnList){
	  				sb.append("\"");
	  				sb.append(column.getLabel());
	  				sb.append("\",");
	        	}
	        	sb.deleteCharAt(sb.lastIndexOf(","));
	        	IConnection outgoingConn = outgoingConns.get(0);
				if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(sb);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(entitynamealllower);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    boolean debugPaging=false;
	        	if(debugPaging){
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    }
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    //2009-04-14T10:09:42-07:00 ---> 2009-04-14T10:09:42-0700
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    
							for( int i = 0; i < columnList.size(); i++) {

								IMetadataColumn column = columnList.get(i);

								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

								String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
								
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_497);
    
	        						if (javaType == JavaTypesManager.STRING) {
	        					
    stringBuffer.append(TEXT_498);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_499);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_502);
    
	        						} else if(javaType == JavaTypesManager.DATE) { // Date
	        					
    stringBuffer.append(TEXT_503);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_504);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_507);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_508);
    
	        						} else if(javaType == JavaTypesManager.DOUBLE) { // Double
	        					
    stringBuffer.append(TEXT_509);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_510);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_513);
    
	        						} else if(javaType == JavaTypesManager.BIGDECIMAL) { // BigDecimal
	        					
    stringBuffer.append(TEXT_514);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_515);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_518);
    
	        						} else if(javaType == JavaTypesManager.FLOAT) { // Float
	        					
    stringBuffer.append(TEXT_519);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_520);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_523);
    
	        						} else if(javaType == JavaTypesManager.INTEGER) { // Integer
	        					
    stringBuffer.append(TEXT_524);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_525);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_528);
    
	        						} else if(javaType == JavaTypesManager.BOOLEAN) { // Boolean
	        					
    stringBuffer.append(TEXT_529);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_530);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_533);
    
	        						} else if(javaType == JavaTypesManager.OBJECT) { // OBJECT
	        					
    stringBuffer.append(TEXT_534);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_535);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_538);
    
	        						} else  { // other
	        					
    stringBuffer.append(TEXT_539);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_540);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_541);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_544);
    
	        						}
	        					
    stringBuffer.append(TEXT_545);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_546);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_547);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_548);
    
							}
							
    stringBuffer.append(TEXT_549);
    
				}

			}else{//api 2011
			
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(orgName);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(reuseHttpClient);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(discWSDL);
    stringBuffer.append(TEXT_561);
    
	     		String entityname = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
	     		String customEntityname = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
	     		if("CustomEntity".equals(entityname)){
					entityname = customEntityname.replaceAll("\"","");
				}
	     		String entitynamealllower = entityname.toLowerCase();
	     		String logical = ElementParameterParser.getValue(node,"__LOGICAL_OP__");
	     		List<Map<String, String>> keyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONDITIONS__");
	     		
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    
	        	if(keyColumns.size()>0 ){
				
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    
	            	for(Map<String, String> keyColumn:keyColumns){
	        		
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(keyColumn.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(keyColumn.get("OPERATOR"));
    stringBuffer.append(TEXT_577);
    
	        			if(!("").equals(keyColumn.get("RVALUE"))){
	        			
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(keyColumn.get("RVALUE"));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    
	            		}
	        		}
	        		
    stringBuffer.append(TEXT_587);
    
	        		if(!("").equals(logical)){
	        		
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(logical);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    
	        		}
	        	}
	        	
    stringBuffer.append(TEXT_596);
    
	        	StringBuilder sb = new StringBuilder("");
	        	for(IMetadataColumn column: columnList){
	  				sb.append("\"");
	  				sb.append(column.getLabel());
	  				sb.append("\",");
	        	}
	        	sb.deleteCharAt(sb.lastIndexOf(","));
	        	IConnection outgoingConn = outgoingConns.get(0);
				if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(sb);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append(entitynamealllower);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    boolean debugPaging=false;
	        	if(debugPaging){
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    }
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_670);
    
						for(int i = 0; i < columnList.size(); i++){//for begin

							IMetadataColumn column = columnList.get(i);

							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

							String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_673);
    
	       						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
	        					
    stringBuffer.append(TEXT_674);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_675);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_678);
    
	        					}else if(javaType == JavaTypesManager.DATE){ // Date
	        					
    stringBuffer.append(TEXT_679);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_680);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_683);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_684);
    
	        					}else{ // other
	        					
    stringBuffer.append(TEXT_685);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_686);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_687);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_690);
    
	        					}
	        					
    stringBuffer.append(TEXT_691);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_692);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_693);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_694);
    
						}//for end
						
    stringBuffer.append(TEXT_695);
    
				}
			}
		}
	}
}

    
    }

    stringBuffer.append(TEXT_696);
    return stringBuffer.toString();
  }
}
