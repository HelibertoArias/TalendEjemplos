package org.talend.designer.codegen.translators.esb.rest;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeConnectionsHelper;
import org.talend.designer.codegen.config.NodeParamsHelper;

public class TRESTClientMainJava
{
  protected static String nl;
  public static synchronized TRESTClientMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRESTClientMainJava result = new TRESTClientMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + NL + "try {" + NL + "\t// request body" + NL + "\torg.dom4j.Document requestDoc_";
  protected final String TEXT_4 = " = null;" + NL + "\tString requestString_";
  protected final String TEXT_5 = " = null;";
  protected final String TEXT_6 = NL + "\t\t\tif (null != ";
  protected final String TEXT_7 = ".body) {" + NL + "\t\t\t\trequestDoc_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ".body.getDocument();" + NL + "\t\t\t}";
  protected final String TEXT_10 = NL + "\t\t\trequestString_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ".string;";
  protected final String TEXT_13 = NL + NL + "\tObject requestBody_";
  protected final String TEXT_14 = " = requestDoc_";
  protected final String TEXT_15 = " != null ? requestDoc_";
  protected final String TEXT_16 = " : requestString_";
  protected final String TEXT_17 = ";" + NL + "" + NL + "\t// expected response body" + NL + "\tObject responseDoc_";
  protected final String TEXT_18 = " = null;" + NL + "\t";
  protected final String TEXT_19 = NL + "\tClass<?> responseClass_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = "String.class";
  protected final String TEXT_22 = "org.dom4j.Document.class";
  protected final String TEXT_23 = ";" + NL + "" + NL + "\t// create web client instance" + NL + "\torg.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_";
  protected final String TEXT_24 = " =" + NL + "\t\t\tnew org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();" + NL + "" + NL + "\tboolean inOSGi = false;" + NL + "\ttry {" + NL + "\t\tinOSGi = (null != factoryBean_";
  protected final String TEXT_25 = ".getBus().getExtension(Class.forName(\"org.osgi.framework.BundleContext\")));" + NL + "\t} catch (ClassNotFoundException e_";
  protected final String TEXT_26 = ") {" + NL + "\t\t; // ignore" + NL + "\t}" + NL + "" + NL + "\tfinal java.util.List<org.apache.cxf.feature.Feature> features_";
  protected final String TEXT_27 = " =" + NL + "\t\t\tnew java.util.ArrayList<org.apache.cxf.feature.Feature>();" + NL + "" + NL + "\t";
  protected final String TEXT_28 = NL + "\t\tfactoryBean_";
  protected final String TEXT_29 = ".setAddress(\"locator://rest\");" + NL + "\t\tfactoryBean_";
  protected final String TEXT_30 = ".setServiceName(new javax.xml.namespace.QName(" + NL + "\t\t\t";
  protected final String TEXT_31 = "," + NL + "\t\t\t";
  protected final String TEXT_32 = "));" + NL + "" + NL + "\t\tif (!inOSGi) {" + NL + "\t\t\tfactoryBean_";
  protected final String TEXT_33 = ".setBus(new org.apache.cxf.bus.spring.SpringBusFactory().createBus(\"META-INF/tesb/locator/beans.xml\"));" + NL + "\t\t}" + NL + "" + NL + "\t\torg.talend.esb.servicelocator.cxf.LocatorFeature feature_";
  protected final String TEXT_34 = " =" + NL + "\t\t\t\tnew org.talend.esb.servicelocator.cxf.LocatorFeature();" + NL + "\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\tfinal java.util.Map<String, String> slCustomProps_";
  protected final String TEXT_36 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\tslCustomProps_";
  protected final String TEXT_38 = ".put(";
  protected final String TEXT_39 = ", ";
  protected final String TEXT_40 = ");" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\tfeature_";
  protected final String TEXT_42 = ".setRequiredEndpointProperties(slCustomProps_";
  protected final String TEXT_43 = ");" + NL + "\t\t";
  protected final String TEXT_44 = NL + NL + "\t\tfeatures_";
  protected final String TEXT_45 = ".add(feature_";
  protected final String TEXT_46 = ");" + NL + "\t";
  protected final String TEXT_47 = NL + "\t\tString url = ";
  protected final String TEXT_48 = ";" + NL + "\t\t// {baseUri}tRESTClient" + NL + "\t\tfactoryBean_";
  protected final String TEXT_49 = ".setServiceName(new javax.xml.namespace.QName(url, \"tRESTClient\"));" + NL + "\t\tfactoryBean_";
  protected final String TEXT_50 = ".setAddress(url);" + NL + "\t";
  protected final String TEXT_51 = NL + NL + "\t";
  protected final String TEXT_52 = NL + "\t\torg.talend.esb.sam.agent.feature.EventFeature samEventFeature = null;" + NL + "\t\tif (null == eventFeature) {" + NL + "\t\t\torg.springframework.context.support.ClassPathXmlApplicationContext context =" + NL + "\t\t\t\t\tnew org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/tesb/agent-context.xml\");" + NL + "\t\t\tsamEventFeature = context.getBean(org.talend.esb.sam.agent.feature.EventFeature.class);" + NL + "\t\t} else {" + NL + "\t\t\tsamEventFeature = (org.talend.esb.sam.agent.feature.EventFeature) eventFeature;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\t\torg.talend.esb.sam.common.handler.impl.CustomInfoHandler ciHandler = new org.talend.esb.sam.common.handler.impl.CustomInfoHandler();" + NL + "\t\t\tjava.util.Map<String, String> samCustomProps_";
  protected final String TEXT_54 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t";
  protected final String TEXT_55 = NL + "\t\t\t\tsamCustomProps_";
  protected final String TEXT_56 = ".put(";
  protected final String TEXT_57 = ", ";
  protected final String TEXT_58 = ");" + NL + "\t\t\t";
  protected final String TEXT_59 = NL + "\t\t\tciHandler.setCustomInfo(samCustomProps_";
  protected final String TEXT_60 = ");" + NL + "\t\t\tsamEventFeature.setHandler(ciHandler);" + NL + "\t\t";
  protected final String TEXT_61 = NL + "\t\tfeatures_";
  protected final String TEXT_62 = ".add(samEventFeature);" + NL + "\t";
  protected final String TEXT_63 = NL + NL + "\t";
  protected final String TEXT_64 = NL + "\t\tfeatures_";
  protected final String TEXT_65 = ".add(new org.apache.cxf.feature.LoggingFeature());" + NL + "\t";
  protected final String TEXT_66 = NL + NL + "\t";
  protected final String TEXT_67 = NL + "\t\tclass EsbJobCorrelationCallbackHandler implements org.talend.esb.policy.correlation.CorrelationIDCallbackHandler {" + NL + "\t\t\t\tprivate String correlationId;" + NL + "\t\t\t\tpublic EsbJobCorrelationCallbackHandler(final String correlationId) {" + NL + "\t\t\t\t\tif (null != correlationId && correlationId.length() > 0) {" + NL + "\t\t\t\t\t\tthis.correlationId = correlationId;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic String getCorrelationId() {" + NL + "\t\t\t\t\treturn correlationId;" + NL + "\t\t\t\t};" + NL + "\t\t\t}" + NL + "\t\tfinal Object correlationIDCallbackHandler = new EsbJobCorrelationCallbackHandler(";
  protected final String TEXT_68 = ");" + NL + "\t\tfactoryBean_";
  protected final String TEXT_69 = ".getProperties(true).put(" + NL + "\t\t\t\torg.talend.esb.policy.correlation.feature.CorrelationIDFeature.CORRELATION_ID_CALLBACK_HANDLER," + NL + "\t\t\t\tcorrelationIDCallbackHandler);" + NL + "\t\tfeatures_";
  protected final String TEXT_70 = ".add(new org.talend.esb.policy.correlation.feature.CorrelationIDFeature());" + NL + "\t";
  protected final String TEXT_71 = NL + NL + "\tfactoryBean_";
  protected final String TEXT_72 = ".setFeatures(features_";
  protected final String TEXT_73 = ");" + NL + "" + NL + "" + NL + "\tjava.util.List<Object> providers_";
  protected final String TEXT_74 = " = new java.util.ArrayList<Object>();" + NL + "\tproviders_";
  protected final String TEXT_75 = ".add(new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {" + NL + "\t\t// workaround for https://jira.talendforge.org/browse/TESB-7276" + NL + "\t\tpublic org.dom4j.Document readFrom(Class<org.dom4j.Document> cls," + NL + "\t\t\t\t\t\t\t\t\t\t\tjava.lang.reflect.Type type," + NL + "\t\t\t\t\t\t\t\t\t\t\tjava.lang.annotation.Annotation[] anns," + NL + "\t\t\t\t\t\t\t\t\t\t\tjavax.ws.rs.core.MediaType mt," + NL + "\t\t\t\t\t\t\t\t\t\t\tjavax.ws.rs.core.MultivaluedMap<String, String> headers," + NL + "\t\t\t\t\t\t\t\t\t\t\tjava.io.InputStream is)" + NL + "\t\t\t\tthrows IOException, javax.ws.rs.WebApplicationException {" + NL + "\t\t\tString contentLength = headers.getFirst(\"Content-Length\");" + NL + "\t\t\tif (!org.apache.cxf.common.util.StringUtils.isEmpty(contentLength)" + NL + "\t\t\t\t\t&& Integer.valueOf(contentLength) <= 0) {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\treturn org.dom4j.DocumentHelper.parseText(\"<root/>\");" + NL + "\t\t\t\t} catch (org.dom4j.DocumentException e_";
  protected final String TEXT_76 = ") {" + NL + "\t\t\t\t\te_";
  protected final String TEXT_77 = ".printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn super.readFrom(cls, type, anns, mt, headers, is);" + NL + "\t\t}" + NL + "\t});" + NL + "\torg.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_";
  protected final String TEXT_78 = " =" + NL + "\t\t\tnew org.apache.cxf.jaxrs.provider.json.JSONProvider();" + NL + "\t\tjsonProvider_";
  protected final String TEXT_79 = ".setIgnoreNamespaces(true);" + NL + "\t\tjsonProvider_";
  protected final String TEXT_80 = ".setAttributesToElements(true);" + NL + "\t";
  protected final String TEXT_81 = NL + "\t";
  protected final String TEXT_82 = NL + "\t\tjsonProvider_";
  protected final String TEXT_83 = ".setSupportUnwrapped(true);" + NL + "\t\tjsonProvider_";
  protected final String TEXT_84 = ".setWrapperName(\"root\");" + NL + "\t";
  protected final String TEXT_85 = NL + "\t";
  protected final String TEXT_86 = NL + "\t\tjsonProvider_";
  protected final String TEXT_87 = ".setDropRootElement(";
  protected final String TEXT_88 = ");" + NL + "\tproviders_";
  protected final String TEXT_89 = ".add(jsonProvider_";
  protected final String TEXT_90 = ");" + NL + "\tfactoryBean_";
  protected final String TEXT_91 = ".setProviders(providers_";
  protected final String TEXT_92 = ");" + NL + "\tfactoryBean_";
  protected final String TEXT_93 = ".setTransportId(\"http://cxf.apache.org/transports/http\");" + NL + "" + NL + "\tboolean use_auth_";
  protected final String TEXT_94 = " = ";
  protected final String TEXT_95 = ";" + NL + "\tif (use_auth_";
  protected final String TEXT_96 = " && \"SAML\".equals(";
  protected final String TEXT_97 = ")) {" + NL + "\t\tif (!inOSGi) {" + NL + "\t\t\tthrow new IllegalArgumentException(\"SAML based security scenarios are not supported in Studio (standalone)\");" + NL + "\t\t}" + NL + "\t\t// set SAML Token authentication" + NL + "\t\t";
  protected final String TEXT_98 = NL + "\t\t";
  protected final String TEXT_99 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_100 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_103 = " = ";
  protected final String TEXT_104 = "; ";
  protected final String TEXT_105 = NL + NL + "\t\torg.apache.cxf.ws.security.trust.STSClient stsClient =" + NL + "\t\t\torg.talend.esb.security.saml.STSClientUtils.createSTSClient(factoryBean_";
  protected final String TEXT_106 = ".getBus()," + NL + "\t\t\t\t";
  protected final String TEXT_107 = ", decryptedPassword_";
  protected final String TEXT_108 = ");" + NL + "\t\t";
  protected final String TEXT_109 = NL + "\t\t\torg.talend.esb.security.saml.STSClientUtils.applyAuthorization(stsClient, ";
  protected final String TEXT_110 = ");" + NL + "\t\t";
  protected final String TEXT_111 = NL + "\t\torg.talend.esb.security.saml.SAMLRESTUtils.configureClient(factoryBean_";
  protected final String TEXT_112 = ", stsClient);" + NL + "\t}" + NL + "" + NL + "\torg.apache.cxf.jaxrs.client.WebClient webClient_";
  protected final String TEXT_113 = " = factoryBean_";
  protected final String TEXT_114 = ".createWebClient();" + NL + "" + NL + "\t// set request path" + NL + "\twebClient_";
  protected final String TEXT_115 = ".path(";
  protected final String TEXT_116 = ");" + NL + "" + NL + "\t// set connection properties" + NL + "\torg.apache.cxf.jaxrs.client.ClientConfiguration clientConfig_";
  protected final String TEXT_117 = " = org.apache.cxf.jaxrs.client.WebClient.getConfig(webClient_";
  protected final String TEXT_118 = ");" + NL + "\torg.apache.cxf.transport.http.HTTPConduit conduit_";
  protected final String TEXT_119 = " = clientConfig_";
  protected final String TEXT_120 = ".getHttpConduit();" + NL + "\tif (use_auth_";
  protected final String TEXT_121 = " && \"BASIC\".equals(";
  protected final String TEXT_122 = ")) {" + NL + "\t\t// set BASIC auth" + NL + "\t\t";
  protected final String TEXT_123 = NL + "\t\t";
  protected final String TEXT_124 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_125 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_128 = " = ";
  protected final String TEXT_129 = "; ";
  protected final String TEXT_130 = NL + NL + "\t\torg.apache.cxf.configuration.security.AuthorizationPolicy authPolicy_";
  protected final String TEXT_131 = " = new org.apache.cxf.configuration.security.AuthorizationPolicy();" + NL + "\t\t\tauthPolicy_";
  protected final String TEXT_132 = ".setAuthorizationType(\"Basic\");" + NL + "\t\t\tauthPolicy_";
  protected final String TEXT_133 = ".setUserName(";
  protected final String TEXT_134 = ");" + NL + "\t\t\tauthPolicy_";
  protected final String TEXT_135 = ".setPassword(decryptedPassword_";
  protected final String TEXT_136 = ");" + NL + "\t\tconduit_";
  protected final String TEXT_137 = ".setAuthorization(authPolicy_";
  protected final String TEXT_138 = ");" + NL + "\t} else if (use_auth_";
  protected final String TEXT_139 = " && \"HTTP Digest\".equals(";
  protected final String TEXT_140 = ")) {" + NL + "\t\t// set Digest auth" + NL + "\t\t";
  protected final String TEXT_141 = NL + "\t\t";
  protected final String TEXT_142 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_143 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = "; ";
  protected final String TEXT_148 = NL + NL + "\t\torg.apache.cxf.configuration.security.AuthorizationPolicy authPolicy_";
  protected final String TEXT_149 = " = new org.apache.cxf.configuration.security.AuthorizationPolicy();" + NL + "\t\tauthPolicy_";
  protected final String TEXT_150 = ".setAuthorizationType(\"Digest\");" + NL + "\t\tauthPolicy_";
  protected final String TEXT_151 = ".setUserName(";
  protected final String TEXT_152 = ");" + NL + "\t\tauthPolicy_";
  protected final String TEXT_153 = ".setPassword(decryptedPassword_";
  protected final String TEXT_154 = ");" + NL + "\t\tconduit_";
  protected final String TEXT_155 = ".setAuthorization(authPolicy_";
  protected final String TEXT_156 = ");" + NL + "\t}" + NL + "" + NL + "\tif (!inOSGi) {" + NL + "\t\tconduit_";
  protected final String TEXT_157 = ".getClient().setReceiveTimeout((long)(";
  protected final String TEXT_158 = " * 1000L));" + NL + "\t\tconduit_";
  protected final String TEXT_159 = ".getClient().setConnectionTimeout((long)(";
  protected final String TEXT_160 = " * 1000L));" + NL + "\t\tboolean use_proxy_";
  protected final String TEXT_161 = " = ";
  protected final String TEXT_162 = ";" + NL + "\t\tif (use_proxy_";
  protected final String TEXT_163 = ") {" + NL + "\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t";
  protected final String TEXT_165 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_166 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_167 = ");";
  protected final String TEXT_168 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_169 = " = ";
  protected final String TEXT_170 = "; ";
  protected final String TEXT_171 = NL + NL + "\t\t\tconduit_";
  protected final String TEXT_172 = ".getClient().setProxyServer(";
  protected final String TEXT_173 = ");" + NL + "\t\t\tconduit_";
  protected final String TEXT_174 = ".getClient().setProxyServerPort(Integer.valueOf(";
  protected final String TEXT_175 = "));" + NL + "\t\t\tconduit_";
  protected final String TEXT_176 = ".getProxyAuthorization().setUserName(";
  protected final String TEXT_177 = ");" + NL + "\t\t\tconduit_";
  protected final String TEXT_178 = ".getProxyAuthorization().setPassword(decryptedPassword_";
  protected final String TEXT_179 = ");" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t";
  protected final String TEXT_180 = NL + "\t\tconduit_";
  protected final String TEXT_181 = ".getClient().setAutoRedirect(true);" + NL + "\t\tclientConfig_";
  protected final String TEXT_182 = ".getRequestContext().put(\"http.redirect.relative.uri\", true);" + NL + "\t\tclientConfig_";
  protected final String TEXT_183 = ".getRequestContext().put(\"http.redirect.same.host.only\", ";
  protected final String TEXT_184 = ");" + NL + "\t";
  protected final String TEXT_185 = NL + NL + "\t";
  protected final String TEXT_186 = NL + "\t\tconduit_";
  protected final String TEXT_187 = ".getClient().setAllowChunking(false);" + NL + "\t";
  protected final String TEXT_188 = NL + NL + "\t";
  protected final String TEXT_189 = NL + "\t\t// set Content-Type" + NL + "\t\twebClient_";
  protected final String TEXT_190 = ".type(\"";
  protected final String TEXT_191 = "\");" + NL + "\t";
  protected final String TEXT_192 = NL + NL + "\t";
  protected final String TEXT_193 = NL + "\t\t// set Accept-Type" + NL + "\t\twebClient_";
  protected final String TEXT_194 = ".accept(\"";
  protected final String TEXT_195 = "\");" + NL + "\t";
  protected final String TEXT_196 = NL + NL + "\t";
  protected final String TEXT_197 = NL + "\t\t// set optional query and header properties if any" + NL + "\t";
  protected final String TEXT_198 = NL + "\t\twebClient_";
  protected final String TEXT_199 = ".header(";
  protected final String TEXT_200 = ", ";
  protected final String TEXT_201 = ");" + NL + "\t";
  protected final String TEXT_202 = NL + "\tif (use_auth_";
  protected final String TEXT_203 = " && \"OAUTH2_BEARER\".equals(";
  protected final String TEXT_204 = ")) {" + NL + "\t\t// set oAuth2 bearer token" + NL + "\t\twebClient_";
  protected final String TEXT_205 = ".header(\"Authorization\", \"Bearer \" + ";
  protected final String TEXT_206 = ");" + NL + "\t}" + NL + "" + NL + "\t// if FORM request then capture query parameters into Form, otherwise set them as queries" + NL + "\t";
  protected final String TEXT_207 = NL + "\t\tjavax.ws.rs.core.Form form_";
  protected final String TEXT_208 = " = new javax.ws.rs.core.Form();" + NL + "\t\t";
  protected final String TEXT_209 = NL + "\t\t\tform_";
  protected final String TEXT_210 = ".param(";
  protected final String TEXT_211 = " ,";
  protected final String TEXT_212 = ");" + NL + "\t\t";
  protected final String TEXT_213 = NL + "\t\trequestBody_";
  protected final String TEXT_214 = " = form_";
  protected final String TEXT_215 = ";" + NL + "\t";
  protected final String TEXT_216 = NL + "\t\t";
  protected final String TEXT_217 = NL + "\t\t\twebClient_";
  protected final String TEXT_218 = ".query(";
  protected final String TEXT_219 = " ,";
  protected final String TEXT_220 = ");" + NL + "\t\t";
  protected final String TEXT_221 = NL + "\t";
  protected final String TEXT_222 = NL + NL + NL + "\ttry {" + NL + "\t\t// start send request" + NL + "\t\t";
  protected final String TEXT_223 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_224 = " = webClient_";
  protected final String TEXT_225 = ".get(responseClass_";
  protected final String TEXT_226 = ");" + NL + "\t\t";
  protected final String TEXT_227 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_228 = " = webClient_";
  protected final String TEXT_229 = ".post(requestBody_";
  protected final String TEXT_230 = ", responseClass_";
  protected final String TEXT_231 = ");" + NL + "\t\t";
  protected final String TEXT_232 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_233 = " = webClient_";
  protected final String TEXT_234 = ".put(requestBody_";
  protected final String TEXT_235 = ", responseClass_";
  protected final String TEXT_236 = ");" + NL + "\t\t";
  protected final String TEXT_237 = NL + "\t\t\torg.apache.cxf.jaxrs.client.WebClient.getConfig(webClient_";
  protected final String TEXT_238 = ").getRequestContext().put(\"use.httpurlconnection.method.reflection\", true);" + NL + "\t\t\tresponseDoc_";
  protected final String TEXT_239 = " = webClient_";
  protected final String TEXT_240 = ".invoke(\"PATCH\", requestBody_";
  protected final String TEXT_241 = ", responseClass_";
  protected final String TEXT_242 = ");" + NL + "\t\t";
  protected final String TEXT_243 = NL + "\t\t\twebClient_";
  protected final String TEXT_244 = ".invoke(\"";
  protected final String TEXT_245 = "\", requestBody_";
  protected final String TEXT_246 = ");" + NL + "\t\t";
  protected final String TEXT_247 = NL + NL + NL + "\t\tint webClientResponseStatus_";
  protected final String TEXT_248 = " = webClient_";
  protected final String TEXT_249 = ".getResponse().getStatus();" + NL + "\t\tif (webClientResponseStatus_";
  protected final String TEXT_250 = " >= 300) {" + NL + "\t\t\tthrow new javax.ws.rs.WebApplicationException(webClient_";
  protected final String TEXT_251 = ".getResponse());" + NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_252 = NL + "\t\t\tif (";
  protected final String TEXT_253 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_254 = " = new ";
  protected final String TEXT_255 = "Struct();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_256 = ".statusCode = webClientResponseStatus_";
  protected final String TEXT_257 = ";" + NL + "\t\t\tif (responseDoc_";
  protected final String TEXT_258 = " != null) {" + NL + "\t\t\t\tif (responseClass_";
  protected final String TEXT_259 = " == String.class) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_260 = ".string = (String) responseDoc_";
  protected final String TEXT_261 = ";" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\troutines.system.Document responseTalendDoc_";
  protected final String TEXT_262 = " = null;" + NL + "\t\t\t\t\tif (null != responseDoc_";
  protected final String TEXT_263 = ") {" + NL + "\t\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_264 = " = new routines.system.Document();" + NL + "\t\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_265 = ".setDocument((org.dom4j.Document) responseDoc_";
  protected final String TEXT_266 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_267 = ".body = responseTalendDoc_";
  protected final String TEXT_268 = ";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_269 = "_HEADERS\", webClient_";
  protected final String TEXT_270 = ".getResponse().getHeaders());" + NL + "\t\t\t";
  protected final String TEXT_271 = NL + "\t\t\tif (null != webClient_";
  protected final String TEXT_272 = ".getResponse().getHeaders().get(\"CorrelationID\")) {" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_273 = "_CORRELATION_ID\", webClient_";
  protected final String TEXT_274 = ".getResponse().getHeaders().get(\"CorrelationID\").get(0));" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_275 = NL + "\t\t";
  protected final String TEXT_276 = NL + NL + "\t} catch (javax.ws.rs.WebApplicationException ex_";
  protected final String TEXT_277 = ") {" + NL + "\t\t";
  protected final String TEXT_278 = NL + "\t\t\tif (";
  protected final String TEXT_279 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_280 = " = new ";
  protected final String TEXT_281 = "Struct();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_282 = ".errorCode = ex_";
  protected final String TEXT_283 = ".getResponse().getStatus();" + NL + "" + NL + "\t\t\tString errorMessage_";
  protected final String TEXT_284 = " = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\terrorMessage_";
  protected final String TEXT_285 = " = ex_";
  protected final String TEXT_286 = ".getResponse().readEntity(String.class);" + NL + "\t\t\t} catch (Exception exe_";
  protected final String TEXT_287 = ") {" + NL + "\t\t\t\t// ignore" + NL + "\t\t\t}" + NL + "\t\t\tif (null == errorMessage_";
  protected final String TEXT_288 = " || 0 == errorMessage_";
  protected final String TEXT_289 = ".trim().length()) {" + NL + "\t\t\t\terrorMessage_";
  protected final String TEXT_290 = " = ex_";
  protected final String TEXT_291 = ".getMessage();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_292 = ".errorMessage = errorMessage_";
  protected final String TEXT_293 = ";" + NL + "" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_294 = "_HEADERS\", ex_";
  protected final String TEXT_295 = ".getResponse().getHeaders());" + NL + "\t\t\t";
  protected final String TEXT_296 = NL + "\t\t\tif (null != webClient_";
  protected final String TEXT_297 = ".getResponse().getHeaders().get(\"CorrelationID\")) {" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_298 = "_CORRELATION_ID\", webClient_";
  protected final String TEXT_299 = ".getResponse().getHeaders().get(\"CorrelationID\").get(0));" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_300 = NL + "\t\t";
  protected final String TEXT_301 = NL + "\t\t\tthrow ex_";
  protected final String TEXT_302 = ";" + NL + "\t\t";
  protected final String TEXT_303 = NL + "\t}" + NL + "" + NL + "} catch(Exception e_";
  protected final String TEXT_304 = ") {" + NL + "\t";
  protected final String TEXT_305 = NL + "\t\tthrow new TalendException(e_";
  protected final String TEXT_306 = ", currentComponent, globalMap);" + NL + "\t";
  protected final String TEXT_307 = NL + "\t\tnew TalendException(e_";
  protected final String TEXT_308 = ", currentComponent, globalMap).printStackTrace();" + NL + "\t";
  protected final String TEXT_309 = NL + "}";
  protected final String TEXT_310 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();

/*INIT PARAMETERS AND INDICATORS.*/
NodeConnectionsHelper connsHelper = new NodeConnectionsHelper(node);
IConnection inputConn = connsHelper.getInputConn();
IConnection connResponse = connsHelper.getOutputConnResponse();
IConnection connFault = connsHelper.getOutputConnFault();
List<IConnection> dataOutputs = connsHelper.getDataOutputs();

String cid = node.getUniqueName();
String passwordFieldName;
NodeParamsHelper paramsHelper = new NodeParamsHelper(node);

String method = paramsHelper.getStringParam("__METHOD__");
String acceptType = paramsHelper.getStringParam("__ACCEPT_TYPE__");
if (acceptType == null) {
	acceptType = "application/xml";
}
String contentType = paramsHelper.getStringParam("__CONTENT_TYPE__");
if (contentType == null) {
	contentType = "application/xml";
}

String useAuth = ElementParameterParser.getValue(node, "__NEED_AUTH__");
if (!node.getElementParameter("NEED_AUTH").isContextMode()) {
	// non-dynamic (bug with non updating parameter value after removing field from dynamic)
	useAuth = "true".equals(useAuth) ? "true" : "false";
}
String authType = paramsHelper.getStringParam("__AUTH_TYPE__");
if (!node.getElementParameter("AUTH_TYPE").isContextMode()) {
	authType = "\"" + authType + "\"";
}

String useProxy = ElementParameterParser.getValue(node, "__USE_PROXY__");
if (!node.getElementParameter("USE_PROXY").isContextMode()) {
	// non-dynamic (bug with non updating parameter value after removing field from dynamic)
	useProxy = "true".equals(useProxy) ? "true" : "false";
}

boolean isSLEnable = paramsHelper.getBoolParam("__SERVICE_LOCATOR__");
boolean isSAMEnable = paramsHelper.getBoolParam("__SERVICE_ACTIVITY_MONITOR__");
boolean useBusinessCorrelation = paramsHelper.getBoolParam("__USE_BUSINESS_CORRELATION__");

/*GENERATE CODE*/
//clear connection row data
for (IConnection conn : dataOutputs) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_2);
    
}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    	if (null != inputConn) {
		IMetadataColumn inputConnBodyColumn = inputConn.getMetadataTable().getColumn("body");
		if (null != inputConnBodyColumn && "id_Document".equals(inputConnBodyColumn.getTalendType())) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_9);
    		}
		IMetadataColumn inputConnStringColumn = inputConn.getMetadataTable().getColumn("string");
		if (null != inputConnStringColumn && "id_String".equals(inputConnStringColumn.getTalendType())) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_12);
    		}
	} 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
		String convertResponseToDomProperty = paramsHelper.getStringParam("__CONVERT_RESPONSE_TO_DOM__");
		boolean convertResponseToDom = convertResponseToDomProperty == null ? true : Boolean.valueOf(convertResponseToDomProperty);
	
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
     if ("*/*".equals(acceptType) || !convertResponseToDom) { 
    stringBuffer.append(TEXT_21);
     } else { 
    stringBuffer.append(TEXT_22);
     } 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
     if (isSLEnable) { 
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(paramsHelper.getStringParam("__SERVICE_NAMESPACE__"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(paramsHelper.getStringParam("__SERVICE_NAME__"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
     List<Entry<String, String>> customProperties = paramsHelper.getPropertiesPram("__SERVICE_LOCATOR_CUSTOM_PROPERTIES__");
		if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
     for (Entry<String,String> prop : customProperties) { 
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(prop.getKey());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(prop.getValue());
    stringBuffer.append(TEXT_40);
     } 
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
     } else { 
    stringBuffer.append(TEXT_47);
    stringBuffer.append(paramsHelper.getStringParam("__URL__"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
     } 
    stringBuffer.append(TEXT_51);
     if (isSAMEnable) { 
    stringBuffer.append(TEXT_52);
     List<Entry<String, String>> samCustomProperties = paramsHelper.getPropertiesPram("__SERVICE_ACTIVITY_MONITOR_CUSTOM_PROPERTIES__");
		if (!samCustomProperties.isEmpty()) { 
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
     for (Entry<String,String> prop : samCustomProperties) { 
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(prop.getKey());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(prop.getValue());
    stringBuffer.append(TEXT_58);
     } 
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
     } 
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
     } 
    stringBuffer.append(TEXT_63);
     if (paramsHelper.getBoolParam("__LOG_MESSAGES__")) { 
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
     } 
    stringBuffer.append(TEXT_66);
     if (useBusinessCorrelation) { 
    stringBuffer.append(TEXT_67);
    stringBuffer.append(paramsHelper.getStringParam("__CORRELATION_VALUE__"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
     } 
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
		String wrapJsonResponseProperty = paramsHelper.getStringParam("__WRAP_JSON_RESPONSE__");
		boolean wrapJsonResponse = wrapJsonResponseProperty == null ? true : Boolean.valueOf(wrapJsonResponseProperty);
	
    stringBuffer.append(TEXT_81);
     if (wrapJsonResponse) { 
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
     } 
    stringBuffer.append(TEXT_85);
    
		boolean dropJsonRoot = (("POST".equals(method) || "PUT".equals(method) || "PATCH".equals(method)) && "application/json".equals(contentType))
				? paramsHelper.getBoolParam("__UNWRAP_JSON_REQUEST__") : false;
	
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(dropJsonRoot);
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
    stringBuffer.append(useAuth);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_97);
     passwordFieldName = "__AUTH_PASSWORD__"; 
    stringBuffer.append(TEXT_98);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_101);
    } else {
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(ElementParameterParser.getValue(node, "__AUTH_USERNAME__"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
     if ("true".equals(ElementParameterParser.getValue(node, "__NEED_AUTHORIZATION__"))) { 
    stringBuffer.append(TEXT_109);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROLE__"));
    stringBuffer.append(TEXT_110);
     } 
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(paramsHelper.getStringParam("__PATH__"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_122);
     passwordFieldName = "__AUTH_PASSWORD__"; 
    stringBuffer.append(TEXT_123);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_126);
    } else {
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(paramsHelper.getStringParam("__AUTH_USERNAME__"));
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
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_140);
     passwordFieldName = "__AUTH_PASSWORD__"; 
    stringBuffer.append(TEXT_141);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_144);
    } else {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_147);
    }
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(paramsHelper.getStringParam("__AUTH_USERNAME__"));
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
    stringBuffer.append(paramsHelper.getStringParam("__RECEIVE_TIMEOUT__"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(paramsHelper.getStringParam("__CONNECTION_TIMEOUT__"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(useProxy);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
     passwordFieldName = "__PROXY_PASSWORD__"; 
    stringBuffer.append(TEXT_164);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_167);
    } else {
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_170);
    }
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_HOST__"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_PORT__"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_USERNAME__"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
     if (paramsHelper.getBoolParam("__FOLLOW_REDIRECTS__")) { 
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(!paramsHelper.getBoolParam("__REDIRECT_NON_SAME_HOST__"));
    stringBuffer.append(TEXT_184);
     } 
    stringBuffer.append(TEXT_185);
     if (paramsHelper.getBoolParam("__DISABLE_CHUNKED_ENCODING__")) { 
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
     } 
    stringBuffer.append(TEXT_188);
     if (!"GET".equals(method) && !"DELETE".equals(method)) { 
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(contentType);
    stringBuffer.append(TEXT_191);
     } 
    stringBuffer.append(TEXT_192);
     if (!acceptType.isEmpty()) { 
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(acceptType);
    stringBuffer.append(TEXT_195);
     } 
    stringBuffer.append(TEXT_196);
     List<Map<String, String>> headers = paramsHelper.getObjectParam("__HEADERS__"); 
    stringBuffer.append(TEXT_197);
     for (Map<String, String> header : headers) { 
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(header.get("NAME"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(header.get("VALUE"));
    stringBuffer.append(TEXT_201);
     } 
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(paramsHelper.getStringParam("__AUTH_BEARER_TOKEN__"));
    stringBuffer.append(TEXT_206);
     List<Map<String, String>> queries = paramsHelper.getObjectParam("__QUERY__");
		if ("application/x-www-form-urlencoded".equals(contentType) && !"GET".equals(method) && !"DELETE".equals(method)) { 
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
     for (Map<String, String> query : queries) { 
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(query.get("NAME"));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(query.get("VALUE"));
    stringBuffer.append(TEXT_212);
     } 
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
     } else { 
    stringBuffer.append(TEXT_216);
     for (Map<String, String> query : queries) { 
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(query.get("NAME"));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(query.get("VALUE"));
    stringBuffer.append(TEXT_220);
     } 
    stringBuffer.append(TEXT_221);
     } 
    stringBuffer.append(TEXT_222);
     if ("GET".equals(method)) { 
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
     } else if ("POST".equals(method)) { 
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
     } else if ("PUT".equals(method)) { 
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
     } else if ("PATCH".equals(method)) { 
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
     } else { 
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
     } 
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
     if (null != connResponse) {
			String connResponseName = connResponse.getName(); 
    stringBuffer.append(TEXT_252);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
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
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
     if (useBusinessCorrelation) { 
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
     } 
    stringBuffer.append(TEXT_275);
     } 
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
     if (null != connFault) {
			String connFaultName = connFault.getName(); 
    stringBuffer.append(TEXT_278);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(connFaultName);
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
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
     if (useBusinessCorrelation) { 
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
     } 
    stringBuffer.append(TEXT_300);
     } else { 
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
     } 
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
     if (paramsHelper.getBoolParam( "__DIE_ON_ERROR__")) { 
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
     } else { 
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
     } 
    stringBuffer.append(TEXT_309);
    stringBuffer.append(TEXT_310);
    return stringBuffer.toString();
  }
}
