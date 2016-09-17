package org.talend.designer.codegen.translators.business.microsoft_crm;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMicrosoftCrmOutputMainJava
{
  protected static String nl;
  public static synchronized TMicrosoftCrmOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMicrosoftCrmOutputMainJava result = new TMicrosoftCrmOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "                               nb_line_";
  protected final String TEXT_2 = " ++;" + NL + "                               java.util.Map<String, Object> map_";
  protected final String TEXT_3 = " = new java.util.HashMap<String, Object>();";
  protected final String TEXT_4 = NL + "                                            if(";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = " != null){" + NL + "                                                map_";
  protected final String TEXT_7 = ".put(\"";
  protected final String TEXT_8 = "\", Long.valueOf(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = "));" + NL + "                                            }else{" + NL + "                                                map_";
  protected final String TEXT_11 = ".put(\"";
  protected final String TEXT_12 = "\", null);" + NL + "                                            }";
  protected final String TEXT_13 = NL + "                                            if(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = " != null){" + NL + "                                                map_";
  protected final String TEXT_16 = ".put(\"";
  protected final String TEXT_17 = "\", Boolean.valueOf(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = "));" + NL + "                                            }else{" + NL + "                                                map_";
  protected final String TEXT_20 = ".put(\"";
  protected final String TEXT_21 = "\", null);" + NL + "                                            }";
  protected final String TEXT_22 = NL + "                                            if(";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = " != null){" + NL + "                                                map_";
  protected final String TEXT_25 = ".put(\"";
  protected final String TEXT_26 = "\", (com.microsoft.schemas.xrm._2011.contracts.EntityCollection)";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ");" + NL + "                                            }else{" + NL + "                                                map_";
  protected final String TEXT_29 = ".put(\"";
  protected final String TEXT_30 = "\", null);" + NL + "                                            }";
  protected final String TEXT_31 = NL + NL + "                                                                 org.dom4j.Document doc_";
  protected final String TEXT_32 = " = null;";
  protected final String TEXT_33 = NL + "                                                                 if(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " instanceof com.microsoft.schemas.xrm._2011.contracts.EntityReference){" + NL + "                                                                      map_";
  protected final String TEXT_36 = ".put(\"";
  protected final String TEXT_37 = "\", ";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ");" + NL + "                                                                 }else if(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = " instanceof routines.system.Document || ";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = " instanceof String){" + NL + "                                                                      if(";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = " instanceof routines.system.Document){" + NL + "                                                                            routines.system.Document document_";
  protected final String TEXT_46 = " = (routines.system.Document)";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ";" + NL + "                                                                            doc_";
  protected final String TEXT_49 = " = document_";
  protected final String TEXT_50 = ".getDocument();" + NL + "                                                                      }else{" + NL + "                                                                           try{" + NL + "                                                                               doc_";
  protected final String TEXT_51 = " = org.dom4j.DocumentHelper.parseText((String)";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = ");" + NL + "                                                                           }catch(org.dom4j.DocumentException e){" + NL + "                                                                               throw new RuntimeException(e.getMessage(), e);" + NL + "                                                                           }" + NL + "                                                                      }" + NL + "                                                                      com.microsoft.schemas.xrm._2011.contracts.EntityReference" + NL + "                                                                                    entityRef_";
  protected final String TEXT_54 = " = new com.microsoft.schemas.xrm._2011.contracts.EntityReference();" + NL + "                                                                      com.microsoft.schemas._2003._10.serialization.Guid" + NL + "                                                                                    guid_";
  protected final String TEXT_55 = " = new com.microsoft.schemas._2003._10.serialization.Guid();" + NL + "                                                                                    guid_";
  protected final String TEXT_56 = ".setValue(" + NL + "                                                                                                         xmlHelper_";
  protected final String TEXT_57 = ".parseXml(doc_";
  protected final String TEXT_58 = ", guid_xpath_";
  protected final String TEXT_59 = ")" + NL + "                                                                                                      );" + NL + "                                                                      entityRef_";
  protected final String TEXT_60 = ".setId(guid_";
  protected final String TEXT_61 = ");" + NL + "                                                                      entityRef_";
  protected final String TEXT_62 = ".setLogicalName(xmlHelper_";
  protected final String TEXT_63 = ".parseXml(doc_";
  protected final String TEXT_64 = ", logical_name_xpath_";
  protected final String TEXT_65 = "));" + NL + "                                                                      entityRef_";
  protected final String TEXT_66 = ".setName(xmlHelper_";
  protected final String TEXT_67 = ".parseXml(doc_";
  protected final String TEXT_68 = ", name_xpath_";
  protected final String TEXT_69 = "));" + NL + "                                                                      map_";
  protected final String TEXT_70 = ".put(\"";
  protected final String TEXT_71 = "\", entityRef_";
  protected final String TEXT_72 = ");" + NL + "                                                                 }else{" + NL + "                                                                      map_";
  protected final String TEXT_73 = ".put(\"";
  protected final String TEXT_74 = "\", null);" + NL + "                                                                 }";
  protected final String TEXT_75 = NL + "                                                                if(";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = " != null){" + NL + "                                                                    try{" + NL + "                                                                        doc_";
  protected final String TEXT_78 = " = org.dom4j.DocumentHelper.parseText(";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = ");" + NL + "                                                                    }catch(org.dom4j.DocumentException e){" + NL + "                                                                        throw new RuntimeException(e.getMessage(), e);" + NL + "                                                                    }" + NL + "                                                                    com.microsoft.schemas.xrm._2011.contracts.EntityReference" + NL + "                                                                                  entityRef_";
  protected final String TEXT_81 = " = new com.microsoft.schemas.xrm._2011.contracts.EntityReference();" + NL + "                                                                    com.microsoft.schemas._2003._10.serialization.Guid" + NL + "                                                                                  guid_";
  protected final String TEXT_82 = " = new com.microsoft.schemas._2003._10.serialization.Guid();" + NL + "                                                                                  guid_";
  protected final String TEXT_83 = ".setValue(" + NL + "                                                                                                       xmlHelper_";
  protected final String TEXT_84 = ".parseXml(doc_";
  protected final String TEXT_85 = ", guid_xpath_";
  protected final String TEXT_86 = ")" + NL + "                                                                                                    );" + NL + "                                                                    entityRef_";
  protected final String TEXT_87 = ".setId(guid_";
  protected final String TEXT_88 = ");" + NL + "                                                                    entityRef_";
  protected final String TEXT_89 = ".setLogicalName(xmlHelper_";
  protected final String TEXT_90 = ".parseXml(doc_";
  protected final String TEXT_91 = ", logical_name_xpath_";
  protected final String TEXT_92 = "));" + NL + "                                                                    entityRef_";
  protected final String TEXT_93 = ".setName(xmlHelper_";
  protected final String TEXT_94 = ".parseXml(doc_";
  protected final String TEXT_95 = ", name_xpath_";
  protected final String TEXT_96 = "));" + NL + "                                                                    map_";
  protected final String TEXT_97 = ".put(\"";
  protected final String TEXT_98 = "\", entityRef_";
  protected final String TEXT_99 = ");" + NL + "                                                                }else{" + NL + "                                                                    map_";
  protected final String TEXT_100 = ".put(\"";
  protected final String TEXT_101 = "\", null);" + NL + "                                                                }";
  protected final String TEXT_102 = NL + "                                                            if(";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = " != null){" + NL + "                                                                routines.system.Document document_";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = ";" + NL + "                                                                doc_";
  protected final String TEXT_108 = " = document_";
  protected final String TEXT_109 = ".getDocument();" + NL + "                                                                com.microsoft.schemas.xrm._2011.contracts.EntityReference" + NL + "                                                                              entityRef_";
  protected final String TEXT_110 = " = new com.microsoft.schemas.xrm._2011.contracts.EntityReference();" + NL + "                                                                com.microsoft.schemas._2003._10.serialization.Guid" + NL + "                                                                              guid_";
  protected final String TEXT_111 = " = new com.microsoft.schemas._2003._10.serialization.Guid();" + NL + "                                                                              guid_";
  protected final String TEXT_112 = ".setValue(" + NL + "                                                                                                   xmlHelper_";
  protected final String TEXT_113 = ".parseXml(doc_";
  protected final String TEXT_114 = ", guid_xpath_";
  protected final String TEXT_115 = ")" + NL + "                                                                                                );" + NL + "                                                                entityRef_";
  protected final String TEXT_116 = ".setId(guid_";
  protected final String TEXT_117 = ");" + NL + "                                                                entityRef_";
  protected final String TEXT_118 = ".setLogicalName(xmlHelper_";
  protected final String TEXT_119 = ".parseXml(doc_";
  protected final String TEXT_120 = ", logical_name_xpath_";
  protected final String TEXT_121 = "));" + NL + "                                                                entityRef_";
  protected final String TEXT_122 = ".setName(xmlHelper_";
  protected final String TEXT_123 = ".parseXml(doc_";
  protected final String TEXT_124 = ", name_xpath_";
  protected final String TEXT_125 = "));" + NL + "                                                                map_";
  protected final String TEXT_126 = ".put(\"";
  protected final String TEXT_127 = "\", entityRef_";
  protected final String TEXT_128 = ");" + NL + "                                                            }else{" + NL + "                                                                map_";
  protected final String TEXT_129 = ".put(\"";
  protected final String TEXT_130 = "\", null);" + NL + "                                                            }";
  protected final String TEXT_131 = NL;
  protected final String TEXT_132 = NL + "                                                                if(";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = " instanceof java.util.Date){" + NL + "                                                                     map_";
  protected final String TEXT_135 = ".put(\"";
  protected final String TEXT_136 = "\", ";
  protected final String TEXT_137 = ".";
  protected final String TEXT_138 = ");" + NL + "                                                                }else{" + NL + "                                                                 if(";
  protected final String TEXT_139 = ".";
  protected final String TEXT_140 = " != null){" + NL + "                                                                     map_";
  protected final String TEXT_141 = ".put(\"";
  protected final String TEXT_142 = "\",ParserUtils.parseTo_Date(";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = ".toString(), ";
  protected final String TEXT_145 = "));" + NL + "                                                                 }else{" + NL + "                                                                     map_";
  protected final String TEXT_146 = ".put(\"";
  protected final String TEXT_147 = "\", null);" + NL + "                                                                 }" + NL + "                                                                }";
  protected final String TEXT_148 = NL + "                                                                     map_";
  protected final String TEXT_149 = ".put(\"";
  protected final String TEXT_150 = "\", ";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = ");";
  protected final String TEXT_153 = NL + "                                                             if(";
  protected final String TEXT_154 = ".";
  protected final String TEXT_155 = " != null){" + NL + "                                                                     map_";
  protected final String TEXT_156 = ".put(\"";
  protected final String TEXT_157 = "\",ParserUtils.parseTo_Date(";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = ".toString(), ";
  protected final String TEXT_160 = "));" + NL + "                                                             }else{" + NL + "                                                                     map_";
  protected final String TEXT_161 = ".put(\"";
  protected final String TEXT_162 = "\", null);" + NL + "                                                             }";
  protected final String TEXT_163 = NL + "                                                                 if(";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = " instanceof java.math.BigDecimal){" + NL + "                                                                    map_";
  protected final String TEXT_166 = ".put(\"";
  protected final String TEXT_167 = "\", ";
  protected final String TEXT_168 = ".";
  protected final String TEXT_169 = ");" + NL + "                                                                 }else{" + NL + "                                                                    if(";
  protected final String TEXT_170 = ".";
  protected final String TEXT_171 = " != null){" + NL + "                                                                    map_";
  protected final String TEXT_172 = ".put(\"";
  protected final String TEXT_173 = "\"," + NL + "                                                                                      ParserUtils.parseTo_BigDecimal(";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = ".toString()));" + NL + "                                                                    }else{" + NL + "                                                                    map_";
  protected final String TEXT_176 = ".put(\"";
  protected final String TEXT_177 = "\", null);" + NL + "                                                                    }" + NL + "                                                                 }";
  protected final String TEXT_178 = NL + "                                                                    map_";
  protected final String TEXT_179 = ".put(\"";
  protected final String TEXT_180 = "\", ";
  protected final String TEXT_181 = ".";
  protected final String TEXT_182 = ");";
  protected final String TEXT_183 = NL + "                                                             if(";
  protected final String TEXT_184 = ".";
  protected final String TEXT_185 = " != null){" + NL + "                                                                    map_";
  protected final String TEXT_186 = ".put(\"";
  protected final String TEXT_187 = "\"," + NL + "                                                                                      ParserUtils.parseTo_BigDecimal(";
  protected final String TEXT_188 = ".";
  protected final String TEXT_189 = ".toString()));" + NL + "                                                             }else{" + NL + "                                                                    map_";
  protected final String TEXT_190 = ".put(\"";
  protected final String TEXT_191 = "\", null);" + NL + "                                                             }";
  protected final String TEXT_192 = NL + "                                                if(";
  protected final String TEXT_193 = ".";
  protected final String TEXT_194 = " != null){" + NL + "                                                     map_";
  protected final String TEXT_195 = ".put(\"";
  protected final String TEXT_196 = "\"," + NL + "                                                                       Double.valueOf(";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = "));" + NL + "                                                 }else{" + NL + "                                                     map_";
  protected final String TEXT_199 = ".put(\"";
  protected final String TEXT_200 = "\", null);" + NL + "                                                 }";
  protected final String TEXT_201 = NL + "                                                 if(";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = " != null){" + NL + "                                                    map_";
  protected final String TEXT_204 = ".put(\"";
  protected final String TEXT_205 = "\",";
  protected final String TEXT_206 = NL + "                                                                      ";
  protected final String TEXT_207 = ".";
  protected final String TEXT_208 = ".toString());" + NL + "                                                  }else{" + NL + "                                                    map_";
  protected final String TEXT_209 = ".put(\"";
  protected final String TEXT_210 = "\", null);" + NL + "                                                  }";
  protected final String TEXT_211 = NL + "                                                if(";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = " != null){" + NL + "                                                      map_";
  protected final String TEXT_214 = ".put(\"";
  protected final String TEXT_215 = "\"," + NL + "                                                                        Integer.valueOf(";
  protected final String TEXT_216 = ".";
  protected final String TEXT_217 = "));" + NL + "                                                }else{" + NL + "                                                      map_";
  protected final String TEXT_218 = ".put(\"";
  protected final String TEXT_219 = "\", null);" + NL + "                                                }";
  protected final String TEXT_220 = NL + "                                              map_";
  protected final String TEXT_221 = ".put(\"";
  protected final String TEXT_222 = "\"," + NL + "                                                                new com.microsoft.schemas.xrm._2011.contracts.BooleanManagedProperty());";
  protected final String TEXT_223 = NL + "                                              com.microsoft.schemas.xrm._2011.contracts.Money" + NL + "                                                            money_";
  protected final String TEXT_224 = " = new com.microsoft.schemas.xrm._2011.contracts.Money();";
  protected final String TEXT_225 = NL + "                                                                 if(";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = " instanceof java.math.BigDecimal){" + NL + "                                                                                money_";
  protected final String TEXT_228 = ".setValue(";
  protected final String TEXT_229 = ".";
  protected final String TEXT_230 = ");" + NL + "                                                                 }else{" + NL + "                                                                       if(";
  protected final String TEXT_231 = ".";
  protected final String TEXT_232 = " != null){" + NL + "                                                                                money_";
  protected final String TEXT_233 = ".setValue(ParserUtils.parseTo_BigDecimal(";
  protected final String TEXT_234 = NL + "                                                                                                             ";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = ".toString()" + NL + "                                                                                                             )" + NL + "                                                                                                         );" + NL + "                                                                        }else{" + NL + "                                                                               money_";
  protected final String TEXT_237 = ".setValue(null);" + NL + "                                                                        }" + NL + "                                                                 }";
  protected final String TEXT_238 = NL + "                                                             money_";
  protected final String TEXT_239 = ".setValue(";
  protected final String TEXT_240 = ".";
  protected final String TEXT_241 = ");";
  protected final String TEXT_242 = NL + "                                                          if(";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = " != null){" + NL + "                                                             money_";
  protected final String TEXT_245 = ".setValue(ParserUtils.parseTo_BigDecimal(";
  protected final String TEXT_246 = NL + "                                                                                          ";
  protected final String TEXT_247 = ".";
  protected final String TEXT_248 = ".toString()" + NL + "                                                                                          )" + NL + "                                                                                      );" + NL + "                                                          }else{" + NL + "                                                            money_";
  protected final String TEXT_249 = ".setValue(null);" + NL + "                                                          }";
  protected final String TEXT_250 = NL + "                                             map_";
  protected final String TEXT_251 = ".put(\"";
  protected final String TEXT_252 = "\", money_";
  protected final String TEXT_253 = ");";
  protected final String TEXT_254 = NL + "                                                 com.microsoft.schemas.xrm._2011.contracts.OptionSetValue" + NL + "                                                               optionSetValue_";
  protected final String TEXT_255 = " = new com.microsoft.schemas.xrm._2011.contracts.OptionSetValue();" + NL + "                                                 if(";
  protected final String TEXT_256 = ".";
  protected final String TEXT_257 = " != null){" + NL + "                                                 optionSetValue_";
  protected final String TEXT_258 = ".setValue(Integer.valueOf(";
  protected final String TEXT_259 = ".";
  protected final String TEXT_260 = "));" + NL + "                                                 }else{" + NL + "                                                 optionSetValue_";
  protected final String TEXT_261 = ".setValue(null);" + NL + "                                                 }" + NL + "                                                 map_";
  protected final String TEXT_262 = ".put(\"";
  protected final String TEXT_263 = "\", optionSetValue_";
  protected final String TEXT_264 = ");";
  protected final String TEXT_265 = NL + "                                                 com.microsoft.schemas._2003._10.serialization.Guid" + NL + "                                                               guid_";
  protected final String TEXT_266 = " = new com.microsoft.schemas._2003._10.serialization.Guid();" + NL + "                                                 if(";
  protected final String TEXT_267 = ".";
  protected final String TEXT_268 = " != null){" + NL + "                                                 guid_";
  protected final String TEXT_269 = ".setValue(";
  protected final String TEXT_270 = ".";
  protected final String TEXT_271 = ".toString());" + NL + "                                                 }else{" + NL + "                                                 throw new RuntimeException(\"UNIQUEIDENTIFIER can't be null, the column name is ";
  protected final String TEXT_272 = "\");" + NL + "                                                 }" + NL + "                                                 map_";
  protected final String TEXT_273 = ".put(\"";
  protected final String TEXT_274 = "\", guid_";
  protected final String TEXT_275 = ");";
  protected final String TEXT_276 = NL + "                                                  System.err.println(\"Unsupported Crm Data Type ==> ";
  protected final String TEXT_277 = "\");" + NL + "                                                  map_";
  protected final String TEXT_278 = ".put(\"";
  protected final String TEXT_279 = "\", null);";
  protected final String TEXT_280 = NL + "                                      crmEntityHelper_";
  protected final String TEXT_281 = ".createEntity(\"";
  protected final String TEXT_282 = "\", map_";
  protected final String TEXT_283 = ");";
  protected final String TEXT_284 = NL + "                                      crmEntityHelper_";
  protected final String TEXT_285 = ".updateEntity(\"";
  protected final String TEXT_286 = "\", map_";
  protected final String TEXT_287 = ");";
  protected final String TEXT_288 = NL + "                                crmEntityHelper_";
  protected final String TEXT_289 = ".deleteEntity(\"";
  protected final String TEXT_290 = "\",";
  protected final String TEXT_291 = ".Id);";
  protected final String TEXT_292 = NL + "                               System.out.println(\"Unsupported Operation ==> ";
  protected final String TEXT_293 = "\");";
  protected final String TEXT_294 = NL + "                        StringBuffer OperXml_";
  protected final String TEXT_295 = " = new StringBuffer();" + NL;
  protected final String TEXT_296 = NL + "                                OperXml_";
  protected final String TEXT_297 = ".append(\"<Create xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\">\");";
  protected final String TEXT_298 = NL + "                                OperXml_";
  protected final String TEXT_299 = ".append(\"<Update xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\">\");";
  protected final String TEXT_300 = NL + "                            OperXml_";
  protected final String TEXT_301 = ".append(\"\\n\");" + NL + "                            OperXml_";
  protected final String TEXT_302 = ".append(\"<entity xsi:type=\\\"web:\");" + NL + "                            OperXml_";
  protected final String TEXT_303 = ".append(\"";
  protected final String TEXT_304 = "\");" + NL + "                            OperXml_";
  protected final String TEXT_305 = ".append(\"\\\" xmlns:web=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\">\");" + NL + "                            OperXml_";
  protected final String TEXT_306 = ".append(\"\\n\");" + NL;
  protected final String TEXT_307 = NL + "                                    OperXml_";
  protected final String TEXT_308 = ".append(\"<\");" + NL + "                                    OperXml_";
  protected final String TEXT_309 = ".append(\"";
  protected final String TEXT_310 = "\");";
  protected final String TEXT_311 = NL + "                                            OperXml_";
  protected final String TEXT_312 = ".append(\" type=\\\"\");" + NL + "                                            OperXml_";
  protected final String TEXT_313 = ".append(";
  protected final String TEXT_314 = ");" + NL + "                                            OperXml_";
  protected final String TEXT_315 = ".append(\"\\\"\");";
  protected final String TEXT_316 = NL + "                                    OperXml_";
  protected final String TEXT_317 = ".append(\">\");" + NL + "                                    OperXml_";
  protected final String TEXT_318 = ".append(\"<![CDATA[\");";
  protected final String TEXT_319 = NL + "                                        if(";
  protected final String TEXT_320 = ".";
  protected final String TEXT_321 = " != null ){" + NL + "                                            OperXml_";
  protected final String TEXT_322 = ".append(FormatterUtils.format_Date(";
  protected final String TEXT_323 = ".";
  protected final String TEXT_324 = ", ";
  protected final String TEXT_325 = "));" + NL + "                                        }else{" + NL + "                                            OperXml_";
  protected final String TEXT_326 = ".append(";
  protected final String TEXT_327 = ");" + NL + "                                        }";
  protected final String TEXT_328 = NL + "                                        if(";
  protected final String TEXT_329 = ".";
  protected final String TEXT_330 = " != null ){" + NL + "                                            OperXml_";
  protected final String TEXT_331 = ".append(String.valueOf(";
  protected final String TEXT_332 = ".";
  protected final String TEXT_333 = "));" + NL + "                                        }else{" + NL + "                                            OperXml_";
  protected final String TEXT_334 = ".append(";
  protected final String TEXT_335 = ");" + NL + "                                        }";
  protected final String TEXT_336 = NL + "                                    OperXml_";
  protected final String TEXT_337 = ".append(\"]]>\");" + NL + "                                    OperXml_";
  protected final String TEXT_338 = ".append(\"</\");" + NL + "                                    OperXml_";
  protected final String TEXT_339 = ".append(\"";
  protected final String TEXT_340 = "\");" + NL + "                                    OperXml_";
  protected final String TEXT_341 = ".append(\">\");" + NL + "                                    OperXml_";
  protected final String TEXT_342 = ".append(\"\\n\");";
  protected final String TEXT_343 = NL + "                                    OperXml_";
  protected final String TEXT_344 = ".append(\"<\");" + NL + "                                    OperXml_";
  protected final String TEXT_345 = ".append(\"";
  protected final String TEXT_346 = "\");" + NL + "                                    OperXml_";
  protected final String TEXT_347 = ".append(\"id>\");" + NL + "                                    OperXml_";
  protected final String TEXT_348 = ".append(";
  protected final String TEXT_349 = ".Id);" + NL + "                                    OperXml_";
  protected final String TEXT_350 = ".append(\"</\");" + NL + "                                    OperXml_";
  protected final String TEXT_351 = ".append(\"";
  protected final String TEXT_352 = "\");" + NL + "                                    OperXml_";
  protected final String TEXT_353 = ".append(\"id>\");" + NL + "                                    OperXml_";
  protected final String TEXT_354 = ".append(\"\\n\");";
  protected final String TEXT_355 = NL + "                                OperXml_";
  protected final String TEXT_356 = ".append(\"</entity>\");" + NL + "                                OperXml_";
  protected final String TEXT_357 = ".append(\"\\n\");" + NL + "                                OperXml_";
  protected final String TEXT_358 = ".append(\"</Create>\");" + NL + "                                com.microsoft.schemas.crm._2007.webservices.CreateDocument createDoc_";
  protected final String TEXT_359 = " =  com.microsoft.schemas.crm._2007.webservices.CreateDocument.Factory.parse(OperXml_";
  protected final String TEXT_360 = ".toString());" + NL + "                                service_";
  protected final String TEXT_361 = ".create(createDoc_";
  protected final String TEXT_362 = ", catd_";
  protected final String TEXT_363 = ", null, null);";
  protected final String TEXT_364 = NL + "                                OperXml_";
  protected final String TEXT_365 = ".append(\"</entity>\");" + NL + "                                OperXml_";
  protected final String TEXT_366 = ".append(\"\\n\");" + NL + "                                OperXml_";
  protected final String TEXT_367 = ".append(\"</Update>\");" + NL + "                                com.microsoft.schemas.crm._2007.webservices.UpdateDocument updateDoc_";
  protected final String TEXT_368 = " = com.microsoft.schemas.crm._2007.webservices.UpdateDocument.Factory.parse(OperXml_";
  protected final String TEXT_369 = ".toString());" + NL + "                                service_";
  protected final String TEXT_370 = ".update(updateDoc_";
  protected final String TEXT_371 = ",catd_";
  protected final String TEXT_372 = ",null,null);";
  protected final String TEXT_373 = NL + "                            OperXml_";
  protected final String TEXT_374 = ".append(\"<Delete xmlns=\\\"http://schemas.microsoft.com/crm/2007/WebServices\\\">\");" + NL + "                            OperXml_";
  protected final String TEXT_375 = ".append(\"\\n\");" + NL + "                            OperXml_";
  protected final String TEXT_376 = ".append(\"<entityName>\");" + NL + "                            OperXml_";
  protected final String TEXT_377 = ".append(\"";
  protected final String TEXT_378 = "\");" + NL + "                            OperXml_";
  protected final String TEXT_379 = ".append(\"</entityName>\");" + NL + "                            OperXml_";
  protected final String TEXT_380 = ".append(\"\\n\");" + NL + "                            OperXml_";
  protected final String TEXT_381 = ".append(\"<id>\");" + NL + "                            OperXml_";
  protected final String TEXT_382 = ".append(";
  protected final String TEXT_383 = ".Id);" + NL + "                            OperXml_";
  protected final String TEXT_384 = ".append(\"</id>\\n\");" + NL + "                            OperXml_";
  protected final String TEXT_385 = ".append(\"</Delete>\");" + NL + "                            com.microsoft.schemas.crm._2007.webservices.DeleteDocument deleteDoc_";
  protected final String TEXT_386 = " = com.microsoft.schemas.crm._2007.webservices.DeleteDocument.Factory.parse(OperXml_";
  protected final String TEXT_387 = ".toString());" + NL + "                            service_";
  protected final String TEXT_388 = ".delete(deleteDoc_";
  protected final String TEXT_389 = ",catd_";
  protected final String TEXT_390 = ",null,null);";
  protected final String TEXT_391 = NL + "                            com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Execute execute_";
  protected final String TEXT_392 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Execute.Factory" + NL + "                                    .newInstance();" + NL + "                            com.microsoft.schemas.crm._2007.webservices.ExecuteDocument executeDoc_";
  protected final String TEXT_393 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Factory" + NL + "                                    .newInstance();" + NL + "                            com.microsoft.schemas.crm._2007.webservices.AssignRequest assignRequest_";
  protected final String TEXT_394 = " = com.microsoft.schemas.crm._2007.webservices.AssignRequest.Factory" + NL + "                                    .newInstance();" + NL + "                            com.microsoft.schemas.crm._2006.coretypes.SecurityPrincipal assignee_";
  protected final String TEXT_395 = " = com.microsoft.schemas.crm._2006.coretypes.SecurityPrincipal.Factory.newInstance();" + NL + "                            assignee_";
  protected final String TEXT_396 = ".setPrincipalId(String.valueOf(";
  protected final String TEXT_397 = ".ownerid));" + NL + "                            assignee_";
  protected final String TEXT_398 = ".setType(com.microsoft.schemas.crm._2006.coretypes.SecurityPrincipalType.Enum.forString(\"User\"));" + NL + "                            assignRequest_";
  protected final String TEXT_399 = ".setAssignee(assignee_";
  protected final String TEXT_400 = ");" + NL + "" + NL + "                            com.microsoft.schemas.crm._2007.webservices.TargetOwnedDynamic dynamicTarget_";
  protected final String TEXT_401 = " = com.microsoft.schemas.crm._2007.webservices.TargetOwnedDynamic.Factory" + NL + "                                    .newInstance();" + NL + "                            dynamicTarget_";
  protected final String TEXT_402 = ".setEntityName(\"";
  protected final String TEXT_403 = "\");" + NL + "                            dynamicTarget_";
  protected final String TEXT_404 = ".setEntityId(String.valueOf(";
  protected final String TEXT_405 = ".Id));" + NL + "" + NL + "                            assignRequest_";
  protected final String TEXT_406 = ".setTarget(dynamicTarget_";
  protected final String TEXT_407 = ");" + NL + "" + NL + "                            execute_";
  protected final String TEXT_408 = ".setRequest(assignRequest_";
  protected final String TEXT_409 = ");" + NL + "                            executeDoc_";
  protected final String TEXT_410 = ".setExecute(execute_";
  protected final String TEXT_411 = ");" + NL + "" + NL + "                            executeDoc_";
  protected final String TEXT_412 = " = com.microsoft.schemas.crm._2007.webservices.ExecuteDocument.Factory.parse(executeDoc_";
  protected final String TEXT_413 = ".toString());" + NL + "" + NL + "                            service_";
  protected final String TEXT_414 = ".execute(executeDoc_";
  protected final String TEXT_415 = ", catd_";
  protected final String TEXT_416 = ", null,null);" + NL;
  protected final String TEXT_417 = NL + "                            com.microsoft.schemas.xrm._2011.contracts.Entity entity_";
  protected final String TEXT_418 = " = com.microsoft.schemas.xrm._2011.contracts.Entity.Factory.newInstance();" + NL + "                            entity_";
  protected final String TEXT_419 = ".setLogicalName(\"";
  protected final String TEXT_420 = "\");" + NL + "" + NL + "                            com.microsoft.schemas.xrm._2011.contracts.AttributeCollection attributes_";
  protected final String TEXT_421 = " = com.microsoft.schemas.xrm._2011.contracts.AttributeCollection.Factory.newInstance();" + NL + "                            org.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringanyType attribute_";
  protected final String TEXT_422 = " = null;" + NL + "" + NL + "                            org.apache.xmlbeans.XmlObject xmlObject_";
  protected final String TEXT_423 = " = null;";
  protected final String TEXT_424 = NL + "                                attribute_";
  protected final String TEXT_425 = " = attributes_";
  protected final String TEXT_426 = ".addNewKeyValuePairOfstringanyType();" + NL + "                                attribute_";
  protected final String TEXT_427 = ".setKey(\"";
  protected final String TEXT_428 = "\");";
  protected final String TEXT_429 = NL + "                                                xmlObject_";
  protected final String TEXT_430 = " = com.microsoft.schemas.xrm._2011.contracts.EntityReference.Factory.newInstance();" + NL + "                                                ((com.microsoft.schemas.xrm._2011.contracts.EntityReference)xmlObject_";
  protected final String TEXT_431 = ").setId(";
  protected final String TEXT_432 = ".";
  protected final String TEXT_433 = ");" + NL + "                                                ((com.microsoft.schemas.xrm._2011.contracts.EntityReference)xmlObject_";
  protected final String TEXT_434 = ").setLogicalName(";
  protected final String TEXT_435 = ");";
  protected final String TEXT_436 = NL + "                                    \"The type of column \"";
  protected final String TEXT_437 = "\" is EntityReference, need to specify the reference entity logical name in EntityReference Type Mapping table.\"";
  protected final String TEXT_438 = NL + "                                    xmlObject_";
  protected final String TEXT_439 = " = com.microsoft.schemas.xrm._2011.contracts.OptionSetValue.Factory.newInstance();" + NL + "                                    ((com.microsoft.schemas.xrm._2011.contracts.OptionSetValue)xmlObject_";
  protected final String TEXT_440 = ").setValue(";
  protected final String TEXT_441 = ".";
  protected final String TEXT_442 = ");";
  protected final String TEXT_443 = NL + "                                    xmlObject_";
  protected final String TEXT_444 = " = com.microsoft.schemas.xrm._2011.contracts.Money.Factory.newInstance();" + NL + "                                    ((com.microsoft.schemas.xrm._2011.contracts.Money)xmlObject_";
  protected final String TEXT_445 = ").setValue(";
  protected final String TEXT_446 = ".";
  protected final String TEXT_447 = ");";
  protected final String TEXT_448 = NL + "                                    xmlObject_";
  protected final String TEXT_449 = " = com.microsoft.schemas._2003._10.serialization.Guid.Factory.newInstance();" + NL + "                                    ((com.microsoft.schemas._2003._10.serialization.Guid)xmlObject_";
  protected final String TEXT_450 = ").setStringValue(";
  protected final String TEXT_451 = ".";
  protected final String TEXT_452 = ");";
  protected final String TEXT_453 = NL + "                                    xmlObject_";
  protected final String TEXT_454 = " = org.apache.xmlbeans.XmlString.Factory.newInstance();" + NL + "                                    ((org.apache.xmlbeans.XmlString)xmlObject_";
  protected final String TEXT_455 = ").setStringValue(";
  protected final String TEXT_456 = ".";
  protected final String TEXT_457 = ");";
  protected final String TEXT_458 = NL + "                                    xmlObject_";
  protected final String TEXT_459 = " = org.apache.xmlbeans.XmlDateTime.Factory.newInstance();" + NL + "                                    ((org.apache.xmlbeans.XmlDateTime)xmlObject_";
  protected final String TEXT_460 = ").setDateValue(";
  protected final String TEXT_461 = ".";
  protected final String TEXT_462 = ");";
  protected final String TEXT_463 = NL + "                                    xmlObject_";
  protected final String TEXT_464 = " = org.apache.xmlbeans.XmlBoolean.Factory.newInstance();" + NL + "                                    ((org.apache.xmlbeans.XmlBoolean)xmlObject_";
  protected final String TEXT_465 = ").setBooleanValue(";
  protected final String TEXT_466 = ".";
  protected final String TEXT_467 = ");";
  protected final String TEXT_468 = NL + "                                    xmlObject_";
  protected final String TEXT_469 = " = org.apache.xmlbeans.XmlDecimal.Factory.newInstance();" + NL + "                                    ((org.apache.xmlbeans.XmlDecimal)xmlObject_";
  protected final String TEXT_470 = ").setBigDecimalValue(";
  protected final String TEXT_471 = ".";
  protected final String TEXT_472 = ");";
  protected final String TEXT_473 = NL + "                                    xmlObject_";
  protected final String TEXT_474 = " = org.apache.xmlbeans.XmlInt.Factory.newInstance();" + NL + "                                    ((org.apache.xmlbeans.XmlInt)xmlObject_";
  protected final String TEXT_475 = ").setIntValue(";
  protected final String TEXT_476 = ".";
  protected final String TEXT_477 = ");";
  protected final String TEXT_478 = NL + "                                    xmlObject_";
  protected final String TEXT_479 = " = org.apache.xmlbeans.XmlLong.Factory.newInstance();" + NL + "                                    ((org.apache.xmlbeans.XmlLong)xmlObject_";
  protected final String TEXT_480 = ").setLongValue(";
  protected final String TEXT_481 = ".";
  protected final String TEXT_482 = ");";
  protected final String TEXT_483 = NL + "                                    xmlObject_";
  protected final String TEXT_484 = " = org.apache.xmlbeans.XmlDouble.Factory.newInstance();" + NL + "                                    ((org.apache.xmlbeans.XmlDouble)xmlObject_";
  protected final String TEXT_485 = ").setDoubleValue(";
  protected final String TEXT_486 = ".";
  protected final String TEXT_487 = ");";
  protected final String TEXT_488 = NL + "                                    \"don't support entityCollection yet;\"";
  protected final String TEXT_489 = NL + "                                    \"don't support booleanManagedProperty yet;\"";
  protected final String TEXT_490 = NL + "                                    \"wrong type ";
  protected final String TEXT_491 = "\"";
  protected final String TEXT_492 = NL + "                                attribute_";
  protected final String TEXT_493 = ".setValue(xmlObject_";
  protected final String TEXT_494 = ");";
  protected final String TEXT_495 = NL + "                            entity_";
  protected final String TEXT_496 = ".setAttributes(attributes_";
  protected final String TEXT_497 = ");";
  protected final String TEXT_498 = NL + "                                com.microsoft.schemas.xrm._2011.contracts.services.CreateDocument.Create create_";
  protected final String TEXT_499 = " = com.microsoft.schemas.xrm._2011.contracts.services.CreateDocument.Create.Factory.newInstance();" + NL + "                                create_";
  protected final String TEXT_500 = ".setEntity(entity_";
  protected final String TEXT_501 = ");" + NL + "                                com.microsoft.schemas.xrm._2011.contracts.services.CreateDocument createDoc_";
  protected final String TEXT_502 = " = com.microsoft.schemas.xrm._2011.contracts.services.CreateDocument.Factory.newInstance();" + NL + "                                createDoc_";
  protected final String TEXT_503 = ".setCreate(create_";
  protected final String TEXT_504 = ");" + NL + "                                com.microsoft.schemas.xrm._2011.contracts.services.CreateResponseDocument.CreateResponse createResp_";
  protected final String TEXT_505 = " = null;" + NL + "                                try{" + NL + "                                    createResp_";
  protected final String TEXT_506 = " = serviceStub_";
  protected final String TEXT_507 = ".create(createDoc_";
  protected final String TEXT_508 = ").getCreateResponse();" + NL + "                                }catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Create_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_509 = "){" + NL + "                                    throw new Exception(ex_";
  protected final String TEXT_510 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "                                }" + NL + "                                //String returnId_";
  protected final String TEXT_511 = " = createResp_";
  protected final String TEXT_512 = ".getCreateResult();";
  protected final String TEXT_513 = NL + "                                    com.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument.Update update_";
  protected final String TEXT_514 = " = com.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument.Update.Factory.newInstance();" + NL + "                                    update_";
  protected final String TEXT_515 = ".setEntity(entity_";
  protected final String TEXT_516 = ");" + NL + "                                    com.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument updateDoc_";
  protected final String TEXT_517 = " = com.microsoft.schemas.xrm._2011.contracts.services.UpdateDocument.Factory.newInstance();" + NL + "                                    updateDoc_";
  protected final String TEXT_518 = ".setUpdate(update_";
  protected final String TEXT_519 = ");" + NL + "                                    try{" + NL + "                                        serviceStub_";
  protected final String TEXT_520 = ".update(updateDoc_";
  protected final String TEXT_521 = ");" + NL + "                                    }catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Update_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_522 = "){" + NL + "                                        throw new Exception(ex_";
  protected final String TEXT_523 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "                                    }";
  protected final String TEXT_524 = NL + "                                    com.microsoft.schemas.xrm._2011.contracts.OrganizationRequest request_";
  protected final String TEXT_525 = " = com.microsoft.schemas.xrm._2011.contracts.OrganizationRequest.Factory.newInstance();" + NL + "                                    request_";
  protected final String TEXT_526 = ".setNilRequestId();" + NL + "                                    request_";
  protected final String TEXT_527 = ".setRequestName(\"Assign\");" + NL + "                                    com.microsoft.schemas.xrm._2011.contracts.ParameterCollection parameters_";
  protected final String TEXT_528 = " = com.microsoft.schemas.xrm._2011.contracts.ParameterCollection.Factory.newInstance();" + NL + "                                    org.datacontract.schemas._2004._07.system_collections_generic.KeyValuePairOfstringanyType parameter_";
  protected final String TEXT_529 = " = null;" + NL + "" + NL + "                                    parameter_";
  protected final String TEXT_530 = " = parameters_";
  protected final String TEXT_531 = ".addNewKeyValuePairOfstringanyType();" + NL + "                                    parameter_";
  protected final String TEXT_532 = ".setKey(\"Target\");" + NL + "                                    com.microsoft.schemas.xrm._2011.contracts.EntityReference targetEntity_";
  protected final String TEXT_533 = " = com.microsoft.schemas.xrm._2011.contracts.EntityReference.Factory.newInstance();" + NL + "                                    targetEntity_";
  protected final String TEXT_534 = ".setId(";
  protected final String TEXT_535 = ".";
  protected final String TEXT_536 = ");" + NL + "                                    targetEntity_";
  protected final String TEXT_537 = ".setLogicalName(\"";
  protected final String TEXT_538 = "\");" + NL + "                                    parameter_";
  protected final String TEXT_539 = ".setValue(targetEntity_";
  protected final String TEXT_540 = ");" + NL + "" + NL + "                                    parameter_";
  protected final String TEXT_541 = " = parameters_";
  protected final String TEXT_542 = ".addNewKeyValuePairOfstringanyType();" + NL + "                                    parameter_";
  protected final String TEXT_543 = ".setKey(\"Assignee\");" + NL + "                                    com.microsoft.schemas.xrm._2011.contracts.EntityReference assigneeEntity_";
  protected final String TEXT_544 = " = com.microsoft.schemas.xrm._2011.contracts.EntityReference.Factory.newInstance();" + NL + "                                    assigneeEntity_";
  protected final String TEXT_545 = ".setId(";
  protected final String TEXT_546 = ".";
  protected final String TEXT_547 = ");" + NL + "                                    assigneeEntity_";
  protected final String TEXT_548 = ".setLogicalName(\"systemuser\");" + NL + "                                    parameter_";
  protected final String TEXT_549 = ".setValue(assigneeEntity_";
  protected final String TEXT_550 = ");" + NL + "" + NL + "                                    request_";
  protected final String TEXT_551 = ".setParameters(parameters_";
  protected final String TEXT_552 = ");" + NL + "                                    com.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument.Execute execute_";
  protected final String TEXT_553 = " = com.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument.Execute.Factory.newInstance();" + NL + "                                    execute_";
  protected final String TEXT_554 = ".setRequest(request_";
  protected final String TEXT_555 = ");" + NL + "                                    com.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument executeDoc_";
  protected final String TEXT_556 = " = com.microsoft.schemas.xrm._2011.contracts.services.ExecuteDocument.Factory.newInstance();" + NL + "                                    executeDoc_";
  protected final String TEXT_557 = ".setExecute(execute_";
  protected final String TEXT_558 = ");" + NL + "                                    try{" + NL + "                                        serviceStub_";
  protected final String TEXT_559 = ".execute(executeDoc_";
  protected final String TEXT_560 = ");" + NL + "                                    }catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Execute_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_561 = "){" + NL + "                                        throw new Exception(ex_";
  protected final String TEXT_562 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "                                    }";
  protected final String TEXT_563 = NL + "                            com.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument.Delete delete_";
  protected final String TEXT_564 = " = com.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument.Delete.Factory.newInstance();" + NL + "                            delete_";
  protected final String TEXT_565 = ".setEntityName(\"";
  protected final String TEXT_566 = "\");" + NL + "                            delete_";
  protected final String TEXT_567 = ".setId(";
  protected final String TEXT_568 = ".Id);" + NL + "                            com.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument deleteDoc_";
  protected final String TEXT_569 = " = com.microsoft.schemas.xrm._2011.contracts.services.DeleteDocument.Factory.newInstance();" + NL + "                            deleteDoc_";
  protected final String TEXT_570 = ".setDelete(delete_";
  protected final String TEXT_571 = ");" + NL + "                            try{" + NL + "                                serviceStub_";
  protected final String TEXT_572 = ".delete(deleteDoc_";
  protected final String TEXT_573 = ");" + NL + "                            }catch(com.microsoft.schemas.xrm._2011.contracts.IOrganizationService_Delete_OrganizationServiceFaultFault_FaultMessage ex_";
  protected final String TEXT_574 = "){" + NL + "                                throw new Exception(ex_";
  protected final String TEXT_575 = ".getFaultMessage().getOrganizationServiceFault().getMessage());" + NL + "                            }";
  protected final String TEXT_576 = NL + "                    nb_line_";
  protected final String TEXT_577 = "++;";
  protected final String TEXT_578 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();

    String authenticationType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
    String crmVersion = ElementParameterParser.getValue(node, "__MS_CRM_VERSION__");

    boolean isMsCrm2015OnPremise = "ON_PREMISE".equals(authenticationType) && "CRM_2015".equals(crmVersion);

        if(isMsCrm2015OnPremise){
           
    
    String entityName = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
    String customEntityName = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
    if("CustomEntity".equals(entityName)){
        entityName = customEntityName.replace("\"","");
    }
    entityName = entityName.toLowerCase();
    String action = ElementParameterParser.getValue(node,"__ACTION__");

    List<IMetadataTable> metadatas = node.getMetadataList();
    if((metadatas != null) && (metadatas.size() > 0)){
        IMetadataTable metadata = metadatas.get(0);
        if(metadata != null){
            List<? extends IConnection> conns = node.getIncomingConnections();
            for(IConnection conn : conns){
                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
                    String connName = conn.getName();
                    List<IMetadataColumn> columns = metadata.getListColumns();
                    int columnSize = columns.size();

    
                        if("insert".equals(action) || "update".equals(action)){
                            
    stringBuffer.append(TEXT_1);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_3);
    
                            for(int i = 0; i < columnSize; i++){
                                String index = cid + "_" + i;
                                IMetadataColumn column = columns.get(i);
                                String columnName = column.getLabel();
                                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                                String crmType = column.getType();
                                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                            
    
                                       if("BIGINT".equals(crmType)){
                                           //Map 2 Java Long
                                           
    stringBuffer.append(TEXT_4);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_12);
    
                                       }else if("BOOLEAN".equals(crmType)){
                                            //Map 2 Java Boolean
                                            
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_21);
    
                                       }else if("CALENDARRULES".equals(crmType) || "PARTYLIST".equals(crmType)){
                                            //Todo: Need to find a better solution.
                                            
    stringBuffer.append(TEXT_22);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_30);
    
                                       }else if("CUSTOMER".equals(crmType) || "LOOKUP".equals(crmType) || "OWNER".equals(crmType)){
                                            //Map 2 Java Document
                                            
    stringBuffer.append(TEXT_31);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_32);
    
                                                   if(javaType == JavaTypesManager.OBJECT){
                                                              
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_54);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_74);
    
                                                   }else if(javaType == JavaTypesManager.STRING){
                                                              
    stringBuffer.append(TEXT_75);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_81);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_82);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_83);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_91);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_93);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_95);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_101);
    
                                                   }else{
                                                        
    stringBuffer.append(TEXT_102);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_109);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_116);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_117);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_120);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_122);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_124);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_128);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_130);
    
                                                   }
                                                
    stringBuffer.append(TEXT_131);
    
                                   }else if("DATETIME".equals(crmType)){
                                             
    
                                                  if(javaType == JavaTypesManager.OBJECT){
                                                             
    stringBuffer.append(TEXT_132);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_145);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_147);
    
                                                  }else if(javaType == JavaTypesManager.DATE){
                                                             
    stringBuffer.append(TEXT_148);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_152);
    
                                                  }else{
                                                             
    stringBuffer.append(TEXT_153);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_160);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_162);
    
                                                  }
                                                
    
                                  }else if("DECIMAL".equals(crmType)){
                                             //Map 2 Java BigDecimal
                                              
    
                                                if(javaType == JavaTypesManager.OBJECT){
                                                             
    stringBuffer.append(TEXT_163);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_177);
    
                                                }else if(javaType == JavaTypesManager.BIGDECIMAL){
                                                             
    stringBuffer.append(TEXT_178);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_182);
    
                                                }else{
                                                             
    stringBuffer.append(TEXT_183);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_191);
    
                                                }
                                               
    
                                  }else if("DOUBLE".equals(crmType)){
                                              //Map 2 Java Double
                                              
    stringBuffer.append(TEXT_192);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_200);
    
                                  }else if("ENTITYNAME".equals(crmType) || "MEMO".equals(crmType) || "STRING".equals(crmType)){
                                              //Map 2 Java String
                                              
    stringBuffer.append(TEXT_201);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_203);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_210);
    
                                  }else if("INTEGER".equals(crmType)){
                                              //Map 2 Java Integer
                                              
    stringBuffer.append(TEXT_211);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_219);
    
                                  }else if("MANAGEDPROPERTY".equals(crmType)){
                                              //Map 2 Java Object
                                              
    stringBuffer.append(TEXT_220);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_222);
    
                                  }else if("MONEY".equals(crmType)){
                                              //Map to Java BigDecimal
                                              
    stringBuffer.append(TEXT_223);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_224);
    
                                               if(javaType == JavaTypesManager.OBJECT){
                                                          
    stringBuffer.append(TEXT_225);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_232);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_236);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_237);
    
                                               }else if(javaType == JavaTypesManager.BIGDECIMAL){
                                                          
    stringBuffer.append(TEXT_238);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_241);
    
                                               }else{
                                                          
    stringBuffer.append(TEXT_242);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_244);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_248);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_249);
    
                                               }
                                               
    stringBuffer.append(TEXT_250);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_252);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_253);
    
                                  }else if("PICKLIST".equals(crmType) || "STATE".equals(crmType) || "STATUS".equals(crmType) ){
                                              //Map to Java Integer
                                              
    stringBuffer.append(TEXT_254);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_257);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_261);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_263);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_264);
    
                                  }else if("UNIQUEIDENTIFIER".equals(crmType)){
                                              //Map to Java String
                                              
    stringBuffer.append(TEXT_265);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_268);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_272);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_274);
    stringBuffer.append( index );
    stringBuffer.append(TEXT_275);
    
                                  }else{
                                               
    stringBuffer.append(TEXT_276);
    stringBuffer.append( crmType );
    stringBuffer.append(TEXT_277);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append( columnName );
    stringBuffer.append(TEXT_279);
    
                                  }
                        }
                            
    
                                 if("insert".equals(action)){
                                   
    stringBuffer.append(TEXT_280);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append( entityName );
    stringBuffer.append(TEXT_282);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_283);
    
                                 }else{
                                   
    stringBuffer.append(TEXT_284);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append( entityName );
    stringBuffer.append(TEXT_286);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_287);
    
                                 }
                                 
    
                        }else if("delete".equals(action)){
                            
    stringBuffer.append(TEXT_288);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append( entityName );
    stringBuffer.append(TEXT_290);
    stringBuffer.append( connName );
    stringBuffer.append(TEXT_291);
    
                        }else{
                            
    stringBuffer.append(TEXT_292);
    stringBuffer.append( action );
    stringBuffer.append(TEXT_293);
    
                        }
                }
            }
        }
    }

    
        }else{
            
    
    String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
    boolean isAPI2011 = ("API_2011").equals(ElementParameterParser.getValue(node,"__API_VERSION__"));

    String str4nil = "\"\"";
    String entityname = ElementParameterParser.getValue(node, "__ENTITYNAME__").trim();
    String customEntityname = ElementParameterParser.getValue(node, "__CUSTOM_ENTITY_NAME__");
    if("CustomEntity".equals(entityname)){
        entityname = customEntityname.replaceAll("\"","");
    }
    entityname = entityname.toLowerCase();
    String action = ElementParameterParser.getValue(node,"__ACTION__");

    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {//1
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {//2
            List<? extends IConnection> conns = node.getIncomingConnections();
            for (IConnection conn : conns) {//3
                if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
                    String connName = conn.getName();
                    List<IMetadataColumn> columns = metadata.getListColumns();
                    int sizeColumns = columns.size();
                    List<Map<String, String>> lookupMapping = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOKUP_MAPPING__");

                    if(!isAPI2011 || ("ON_PREMISE").equals(authType)){// (2007,on-premise),(2007,online),(2011,on-premise)

                        if("update".equals(action) && sizeColumns == 2 && "ownerid".equals(columns.get(1).getLabel())){
                             action = "reassignOwnerID";
                        }
                        boolean hasOwnerID = false;
                        
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    
                        if("insert".equals(action) || "update".equals(action)){//************
                            List activityEntities = java.util.Arrays.asList(new String[]{"activitypointer","appointment","bulkoperation","campaignactivity","campaignresponse","email","fax","incidentresolution","letter","opportunityclose","orderclose","phonecall","quoteclose","serviceappointment","task"});

                            if("insert".equals(action)){
                            
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    
                            }else if("update".equals(action)){
                            
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    
                            }
                            
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    
                            for(int i = 0; i < sizeColumns; i++){//5
                                IMetadataColumn column = columns.get(i);
                                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                                String entityMethodTemp = column.getLabel();
                                String entityMethod = "";

                                if("update".equals(action) && "ownerid".equals(column.getLabel()))  {
                                    hasOwnerID = true;
                                    continue;
                                }

                                if(!"Id".equals(column.getLabel())){
                                
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_310);
    
                                    if(lookupMapping.size()>0){
                                        for(Map<String, String> lookupMapper:lookupMapping){
                                            if(column.getLabel().equals(lookupMapper.get("INPUT_COLUMN"))){
                                            
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(lookupMapper.get("TYPE"));
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    
                                            }
                                        }
                                    }
                                    
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    
                                    String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                                    if(javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0){//Date
                                    
    stringBuffer.append(TEXT_319);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_324);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append( str4nil );
    stringBuffer.append(TEXT_327);
    
                                    } else {//others
                                    
    stringBuffer.append(TEXT_328);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append( str4nil );
    stringBuffer.append(TEXT_335);
    
                                    }
                                    
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    
                                }else{
                                    String entityIdStr = entityname;
                                    if(activityEntities.contains(entityIdStr)){
                                        entityIdStr = "activity";
                                    }
                                    
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(entityIdStr);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(entityIdStr);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    
                                }
                            }//5
                            if("insert".equals(action)){//#######
                            
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
    
                            }else if("update".equals(action)){//#######
                            
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
    
                            }//#######
                        }else if("delete".equals(action)){//*************
                        
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(conn.getName() );
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
    
                        }//************
                        if("reassignOwnerID".equals(action) || ("update".equals(action) && hasOwnerID)){
                        
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
    stringBuffer.append(conn.getName() );
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
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(conn.getName() );
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
    
                        }
                        
    
                    }else{//(2011,on-line)
                        Map<String, String> crmTypeMapping = new HashMap<String, String>();
                        crmTypeMapping.put("BOOLEAN", "bool");
                        crmTypeMapping.put("CUSTOMER", "entityRef");
                        crmTypeMapping.put("DATETIME", "datatime");
                        crmTypeMapping.put("DECIMAL", "bigDecimal");
                        crmTypeMapping.put("DOUBLE", "double");
                        crmTypeMapping.put("INTEGER", "int");
                        crmTypeMapping.put("LOOKUP", "entityRef");
                        crmTypeMapping.put("MEMO", "string");
                        crmTypeMapping.put("MONEY", "money");
                        crmTypeMapping.put("OWNER", "entityRef");
                        crmTypeMapping.put("PARTYLIST", "entityCollection");
                        crmTypeMapping.put("PICKLIST", "optionSetValue");
                        crmTypeMapping.put("STATE", "optionSetValue");
                        crmTypeMapping.put("STATUS", "optionSetValue");
                        crmTypeMapping.put("STRING", "string");
                        crmTypeMapping.put("UNIQUEIDENTIFIER", "guid");
                        crmTypeMapping.put("CALENDARRULES", "entityCollection");
                        crmTypeMapping.put("BIGINT", "long");
                        crmTypeMapping.put("MANAGEDPROPERTY", "booleanManagedProperty");
                        crmTypeMapping.put("ENTITYNAME", "string");

                        if("insert".equals(action) || "update".equals(action)){
                            String ownerColumnName = null;
                            String idColumnName = null;
                            
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    
                            for(int i = 0; i < sizeColumns; i++){
                                IMetadataColumn column = columns.get(i);
                                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                                String crmType = column.getType();
                                String columnName = column.getLabel();
                                if("update".equals(action)){
                                    if("OWNER".equals(crmType)){
                                        ownerColumnName = columnName;
                                        continue;
                                    }
                                    if(column.isKey() && idColumnName == null){
                                        idColumnName = columnName;
                                    }
                                }
                                
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_428);
    
                                if("entityRef".equals(crmTypeMapping.get(crmType))){
                                    boolean hasFound = false;
                                    if(lookupMapping.size()>0){
                                        for(Map<String, String> lookupMapper:lookupMapping){
                                            if(columnName.equals(lookupMapper.get("INPUT_COLUMN"))){
                                                hasFound = true;
                                                
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(lookupMapper.get("TYPE"));
    stringBuffer.append(TEXT_435);
    
                                            }
                                        }
                                    }
                                    if(!hasFound){
                                    
    stringBuffer.append(TEXT_436);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_437);
    
                                    }
                                }else if("optionSetValue".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_442);
    
                                }else if("money".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_447);
    
                                }else if("guid".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_452);
    
                                }else if("string".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_457);
    
                                }else if("datatime".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_462);
    
                                }else if("bool".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_467);
    
                                }else if("bigDecimal".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_472);
    
                                }else if("int".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_477);
    
                                }else if("long".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_482);
    
                                }else if("double".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_487);
    
                                }else if("entityCollection".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_488);
    
                                }else if("booleanManagedProperty".equals(crmTypeMapping.get(crmType))){
                                
    stringBuffer.append(TEXT_489);
    
                                }else{
                                
    stringBuffer.append(TEXT_490);
    stringBuffer.append(crmType);
    stringBuffer.append(TEXT_491);
    
                                }
                                
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    
                            }
                            
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    if("insert".equals(action)){
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    
                            }else if("update".equals(action)){
                                if(ownerColumnName != null && columns.size() == 2){
                                //don't need to update, just do reassign opertion is enough.
                                }else{
                                
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    
                                }
                                if(ownerColumnName != null){
                                
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(idColumnName);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(entityname);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(ownerColumnName);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    
                                }
                            }
                        }
                        else if("delete".equals(action)){
                        
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(entityname);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    
                }//4
            }//3
        }//2
    }//1
    
    
        }

    stringBuffer.append(TEXT_578);
    return stringBuffer.toString();
  }
}
