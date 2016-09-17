package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.EConnectionType;

/**
 * add by xzhang
 */
public class TWriteXMLFieldOutMainJava {

  protected static String nl;
  public static synchronized TWriteXMLFieldOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWriteXMLFieldOutMainJava result = new TWriteXMLFieldOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.info(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\t\tvalueMap_";
  protected final String TEXT_30 = ".get(\"";
  protected final String TEXT_31 = "\")";
  protected final String TEXT_32 = NL + "\t(";
  protected final String TEXT_33 = NL + "\t\t";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " != null?";
  protected final String TEXT_36 = NL + "    \t\tFormatterUtils.format_Number(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ".toPlainString(), ";
  protected final String TEXT_39 = ",";
  protected final String TEXT_40 = ")\t\t\t\t\t";
  protected final String TEXT_41 = NL + "    \t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = "), ";
  protected final String TEXT_44 = ",";
  protected final String TEXT_45 = ")\t\t\t\t\t\t";
  protected final String TEXT_46 = NL + "            String.valueOf(";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ")";
  protected final String TEXT_49 = NL + "            FormatterUtils.format_Date(";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = ",";
  protected final String TEXT_52 = ")";
  protected final String TEXT_53 = NL + "\t\t\t";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = NL + "\t\t\t";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = ".toPlainString()";
  protected final String TEXT_58 = NL + "            ";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = ".toString()";
  protected final String TEXT_61 = ":";
  protected final String TEXT_62 = "null";
  protected final String TEXT_63 = NL + "\t\t)";
  protected final String TEXT_64 = NL + "\t\t\t";
  protected final String TEXT_65 = "_";
  protected final String TEXT_66 = ".setName(\"";
  protected final String TEXT_67 = "\");";
  protected final String TEXT_68 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = ";" + NL + "\t\tif (";
  protected final String TEXT_71 = "_";
  protected final String TEXT_72 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_73 = "\") == null) {";
  protected final String TEXT_74 = NL + "            ";
  protected final String TEXT_75 = "_";
  protected final String TEXT_76 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_77 = "\");" + NL + "        } else {" + NL + "        \t";
  protected final String TEXT_78 = "_";
  protected final String TEXT_79 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_80 = "\");" + NL + "        }";
  protected final String TEXT_81 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_82 = "_";
  protected final String TEXT_83 = " = org.dom4j.DocumentHelper.createElement(\"";
  protected final String TEXT_84 = "\");";
  protected final String TEXT_85 = NL + "        if(orders_";
  protected final String TEXT_86 = "[";
  protected final String TEXT_87 = "]==0){" + NL + "        \torders_";
  protected final String TEXT_88 = "[";
  protected final String TEXT_89 = "] = ";
  protected final String TEXT_90 = ";" + NL + "        }" + NL + "        if(";
  protected final String TEXT_91 = " < orders_";
  protected final String TEXT_92 = ".length){" + NL + "        \t\torders_";
  protected final String TEXT_93 = "[";
  protected final String TEXT_94 = "] = 0;" + NL + "        }";
  protected final String TEXT_95 = NL + "        ";
  protected final String TEXT_96 = "_";
  protected final String TEXT_97 = ".elements().add(orders_";
  protected final String TEXT_98 = "[";
  protected final String TEXT_99 = "]++,";
  protected final String TEXT_100 = "_";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_103 = "_";
  protected final String TEXT_104 = ";" + NL + "\t\tif (";
  protected final String TEXT_105 = "_";
  protected final String TEXT_106 = ".getNamespaceForPrefix(\"";
  protected final String TEXT_107 = "\") == null) {";
  protected final String TEXT_108 = NL + "            ";
  protected final String TEXT_109 = "_";
  protected final String TEXT_110 = " = ";
  protected final String TEXT_111 = "_";
  protected final String TEXT_112 = ".addElement(\"";
  protected final String TEXT_113 = "\");" + NL + "        } else {" + NL + "        \t";
  protected final String TEXT_114 = "_";
  protected final String TEXT_115 = " = ";
  protected final String TEXT_116 = "_";
  protected final String TEXT_117 = ".addElement(\"";
  protected final String TEXT_118 = "\");" + NL + "        }";
  protected final String TEXT_119 = NL + "\t\torg.dom4j.Element ";
  protected final String TEXT_120 = "_";
  protected final String TEXT_121 = " = ";
  protected final String TEXT_122 = "_";
  protected final String TEXT_123 = ".addElement(\"";
  protected final String TEXT_124 = "\");";
  protected final String TEXT_125 = NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_126 = " = ";
  protected final String TEXT_127 = "_";
  protected final String TEXT_128 = ";";
  protected final String TEXT_129 = NL + "\t\tif(";
  protected final String TEXT_130 = "!=null){" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_131 = " .parseAndAdd(";
  protected final String TEXT_132 = "_";
  protected final String TEXT_133 = ",";
  protected final String TEXT_134 = ");" + NL + "\t\t}";
  protected final String TEXT_135 = NL + "\t\telse{" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_136 = " .parseAndAdd(";
  protected final String TEXT_137 = "_";
  protected final String TEXT_138 = ",\"\");" + NL + "\t\t\t";
  protected final String TEXT_139 = "_";
  protected final String TEXT_140 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_141 = NL + "\t\tif(";
  protected final String TEXT_142 = "!=null){" + NL + "\t\t\tnestXMLTool_";
  protected final String TEXT_143 = " .setText(";
  protected final String TEXT_144 = "_";
  protected final String TEXT_145 = ",";
  protected final String TEXT_146 = ");" + NL + "\t\t}";
  protected final String TEXT_147 = NL + "\t\telse{" + NL + "\t\t\t";
  protected final String TEXT_148 = "_";
  protected final String TEXT_149 = ".setText(\"\");" + NL + "\t\t\t";
  protected final String TEXT_150 = "_";
  protected final String TEXT_151 = ".addAttribute(\"xsi:nil\",\"true\");" + NL + "\t\t}";
  protected final String TEXT_152 = NL + "\t\tnestXMLTool_";
  protected final String TEXT_153 = ".parseAndAdd(";
  protected final String TEXT_154 = "_";
  protected final String TEXT_155 = ",\"";
  protected final String TEXT_156 = "\");";
  protected final String TEXT_157 = NL + "\t\tif(";
  protected final String TEXT_158 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_159 = "_";
  protected final String TEXT_160 = ".addAttribute(\"";
  protected final String TEXT_161 = "\",";
  protected final String TEXT_162 = ");" + NL + "\t\t}";
  protected final String TEXT_163 = NL + "\t\t";
  protected final String TEXT_164 = "_";
  protected final String TEXT_165 = ".addAttribute(\"";
  protected final String TEXT_166 = "\", \"";
  protected final String TEXT_167 = "\");";
  protected final String TEXT_168 = NL + "\t\tif(";
  protected final String TEXT_169 = "!=null){" + NL + "\t\t\t";
  protected final String TEXT_170 = "_";
  protected final String TEXT_171 = ".addNamespace(\"";
  protected final String TEXT_172 = "\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_173 = "));";
  protected final String TEXT_174 = NL + "        \t";
  protected final String TEXT_175 = "_";
  protected final String TEXT_176 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_177 = "_";
  protected final String TEXT_178 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_179 = "))));";
  protected final String TEXT_180 = NL + "\t\t}";
  protected final String TEXT_181 = NL + "\t\t\t";
  protected final String TEXT_182 = "_";
  protected final String TEXT_183 = ".addNamespace(\"";
  protected final String TEXT_184 = "\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_185 = "\"));";
  protected final String TEXT_186 = NL + "        \t";
  protected final String TEXT_187 = "_";
  protected final String TEXT_188 = ".setQName(org.dom4j.DocumentHelper.createQName(";
  protected final String TEXT_189 = "_";
  protected final String TEXT_190 = ".getName()," + NL + "        \torg.dom4j.DocumentHelper.createNamespace(\"\",TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_191 = "\"))));";
  protected final String TEXT_192 = NL + "    \t// buffer the start tabs to group buffer" + NL + "    \tgroupBuffer_";
  protected final String TEXT_193 = "[";
  protected final String TEXT_194 = "] = buf_";
  protected final String TEXT_195 = ".toString();" + NL + "        buf_";
  protected final String TEXT_196 = " = new StringBuffer();";
  protected final String TEXT_197 = NL + "\t\tstartTabs_";
  protected final String TEXT_198 = "[";
  protected final String TEXT_199 = "] = buf_";
  protected final String TEXT_200 = ".toString();" + NL + "        buf_";
  protected final String TEXT_201 = " = new StringBuffer();";
  protected final String TEXT_202 = NL + "\t\tout_";
  protected final String TEXT_203 = ".write(buf_";
  protected final String TEXT_204 = ".toString());" + NL + "        buf_";
  protected final String TEXT_205 = " = new StringBuffer();";
  protected final String TEXT_206 = NL + "\t\tif( false";
  protected final String TEXT_207 = " || valueMap_";
  protected final String TEXT_208 = ".get(\"";
  protected final String TEXT_209 = "\") != null";
  protected final String TEXT_210 = " || true " + NL + "                    \t";
  protected final String TEXT_211 = NL + "\t\t){";
  protected final String TEXT_212 = NL + "\t\t}";
  protected final String TEXT_213 = NL + "\t\tbuf_";
  protected final String TEXT_214 = ".append(\"";
  protected final String TEXT_215 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_216 = ".append(\"";
  protected final String TEXT_217 = "<";
  protected final String TEXT_218 = "\");";
  protected final String TEXT_219 = NL + "\t\tbuf_";
  protected final String TEXT_220 = ".append(\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\"\");" + NL + "\t\tbuf_";
  protected final String TEXT_221 = ".append(\" xsi:noNamespaceSchemaLocation= \\\"\"+";
  protected final String TEXT_222 = "+\"\\\"\");";
  protected final String TEXT_223 = NL + "\t\tif(";
  protected final String TEXT_224 = "==null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_225 = ".append(\" xsi:nil=\\\"true\\\"\");" + NL + "\t\t}";
  protected final String TEXT_226 = NL + "\t\tbuf_";
  protected final String TEXT_227 = ".append(\">\");";
  protected final String TEXT_228 = NL + "\t\tbuf_";
  protected final String TEXT_229 = ".append(\"";
  protected final String TEXT_230 = "\");" + NL + "\t\tbuf_";
  protected final String TEXT_231 = ".append(\"";
  protected final String TEXT_232 = "</";
  protected final String TEXT_233 = ">\");";
  protected final String TEXT_234 = NL + "\t\tbuf_";
  protected final String TEXT_235 = ".append(\"</";
  protected final String TEXT_236 = ">\");";
  protected final String TEXT_237 = NL + "\t\tif(";
  protected final String TEXT_238 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_239 = ".append(";
  protected final String TEXT_240 = ");" + NL + "\t\t}";
  protected final String TEXT_241 = NL + "\t\tif(";
  protected final String TEXT_242 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_243 = ".append(TalendString.checkCDATAForXML(";
  protected final String TEXT_244 = "));" + NL + "\t\t}";
  protected final String TEXT_245 = NL + "\t\tbuf_";
  protected final String TEXT_246 = ".append(\"";
  protected final String TEXT_247 = "\");";
  protected final String TEXT_248 = NL + "\t\tif(";
  protected final String TEXT_249 = "!=null){" + NL + "\t\t\tbuf_";
  protected final String TEXT_250 = ".append(\" ";
  protected final String TEXT_251 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_252 = ")+\"\\\"\");" + NL + "\t\t}";
  protected final String TEXT_253 = NL + "\t\tbuf_";
  protected final String TEXT_254 = ".append(\" ";
  protected final String TEXT_255 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_256 = "\")+\"\\\"\");";
  protected final String TEXT_257 = NL + "\t\tif(";
  protected final String TEXT_258 = "!=null){";
  protected final String TEXT_259 = NL + "        \tbuf_";
  protected final String TEXT_260 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_261 = ")+\"\\\"\");";
  protected final String TEXT_262 = NL + "\t\t\tbuf_";
  protected final String TEXT_263 = ".append(\" xmlns:";
  protected final String TEXT_264 = "=\\\"\"+TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_265 = ")+\"\\\"\");";
  protected final String TEXT_266 = NL + "\t\t}";
  protected final String TEXT_267 = NL + "        \tbuf_";
  protected final String TEXT_268 = ".append(\" xmlns=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_269 = "\")+\"\\\"\");";
  protected final String TEXT_270 = NL + "\t\t\tbuf_";
  protected final String TEXT_271 = ".append(\" xmlns:";
  protected final String TEXT_272 = "=\\\"\"+TalendString.replaceSpecialCharForXML(\"";
  protected final String TEXT_273 = "\")+\"\\\"\");";
  protected final String TEXT_274 = NL + "\tif(txf_";
  protected final String TEXT_275 = ".getLastException()!=null) {" + NL + "\t\tcurrentComponent = txf_";
  protected final String TEXT_276 = ".getCurrentComponent();" + NL + "\t\tthrow txf_";
  protected final String TEXT_277 = ".getLastException();" + NL + "\t}";
  protected final String TEXT_278 = NL + "\tnb_line_";
  protected final String TEXT_279 = "++;";
  protected final String TEXT_280 = NL + "\tvalueMap_";
  protected final String TEXT_281 = ".clear();";
  protected final String TEXT_282 = NL + "\tvalueMap_";
  protected final String TEXT_283 = ".put(\"";
  protected final String TEXT_284 = "\",";
  protected final String TEXT_285 = ");";
  protected final String TEXT_286 = NL + "\tflowValues_";
  protected final String TEXT_287 = " = new java.util.HashMap<String,String>();" + NL + "\tflowValues_";
  protected final String TEXT_288 = ".putAll(valueMap_";
  protected final String TEXT_289 = ");" + NL + "\tflows_";
  protected final String TEXT_290 = ".add(flowValues_";
  protected final String TEXT_291 = ");";
  protected final String TEXT_292 = NL + "\t\tString strTemp_";
  protected final String TEXT_293 = " = \"\";";
  protected final String TEXT_294 = "\t\tstrTemp_";
  protected final String TEXT_295 = " = strTemp_";
  protected final String TEXT_296 = " + valueMap_";
  protected final String TEXT_297 = ".get(\"";
  protected final String TEXT_298 = "\")" + NL + "\t\t\t\t\t\t\t+ valueMap_";
  protected final String TEXT_299 = ".get(\"";
  protected final String TEXT_300 = "\").length();";
  protected final String TEXT_301 = NL + "\tif(strCompCache_";
  protected final String TEXT_302 = "==null){" + NL + "\t\tstrCompCache_";
  protected final String TEXT_303 = "=strTemp_";
  protected final String TEXT_304 = ";" + NL + "\t\t";
  protected final String TEXT_305 = NL + "\t\t\t\t\t\t      rowStructOutput_";
  protected final String TEXT_306 = " = ";
  protected final String TEXT_307 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_308 = NL + "\t}else{";
  protected final String TEXT_309 = NL + "\t\t//the data read is different from the data read last time. " + NL + "\t\tif(strCompCache_";
  protected final String TEXT_310 = ".equals(strTemp_";
  protected final String TEXT_311 = ")==false){\t";
  protected final String TEXT_312 = NL + "\t\t\tdoc_";
  protected final String TEXT_313 = ".getRootElement().addAttribute(\"xsi:noNamespaceSchemaLocation\", ";
  protected final String TEXT_314 = ");" + NL + "\t\t    doc_";
  protected final String TEXT_315 = ".getRootElement().addNamespace(\"xsi\", \"http://www.w3.org/2001/XMLSchema-instance\");";
  protected final String TEXT_316 = "  " + NL + "    \t\tnestXMLTool_";
  protected final String TEXT_317 = ".replaceDefaultNameSpace(doc_";
  protected final String TEXT_318 = ".getRootElement());";
  protected final String TEXT_319 = NL + "    \t\tnestXMLTool_";
  protected final String TEXT_320 = ".removeEmptyElement(doc_";
  protected final String TEXT_321 = ".getRootElement());";
  protected final String TEXT_322 = "\t\t\t" + NL + "\t\t\tjava.io.StringWriter strWriter_";
  protected final String TEXT_323 = " = new java.io.StringWriter();\t" + NL + "\t\t\torg.dom4j.io.XMLWriter output_";
  protected final String TEXT_324 = " = new org.dom4j.io.XMLWriter(strWriter_";
  protected final String TEXT_325 = ", format_";
  protected final String TEXT_326 = ");" + NL + "\t\t\toutput_";
  protected final String TEXT_327 = ".write(doc_";
  protected final String TEXT_328 = ");" + NL + "\t\t    output_";
  protected final String TEXT_329 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_330 = NL + "\t\t\tString removeHeader_";
  protected final String TEXT_331 = " = strWriter_";
  protected final String TEXT_332 = ".toString();" + NL + "\t\t\tif(removeHeader_";
  protected final String TEXT_333 = ".indexOf(\"<?xml\") >=0 ){" + NL + "\t\t\t\tremoveHeader_";
  protected final String TEXT_334 = " = removeHeader_";
  protected final String TEXT_335 = ".substring(removeHeader_";
  protected final String TEXT_336 = ".indexOf(\"?>\")+3);" + NL + "\t\t\t}" + NL + "\t\t\tlistGroupby_";
  protected final String TEXT_337 = ".add(removeHeader_";
  protected final String TEXT_338 = ");";
  protected final String TEXT_339 = NL + "                map_";
  protected final String TEXT_340 = ".put(\"json_";
  protected final String TEXT_341 = "\",strWriter_";
  protected final String TEXT_342 = ".toString());" + NL + "                listGroupby_";
  protected final String TEXT_343 = ".add(map_";
  protected final String TEXT_344 = ");";
  protected final String TEXT_345 = NL + "\t\t\t\t  \t\t  ";
  protected final String TEXT_346 = " row_";
  protected final String TEXT_347 = " = new ";
  protected final String TEXT_348 = "();" + NL + "\t\t\t\t\t\t  ";
  protected final String TEXT_349 = NL + "\t\t\t\t\t\t\t\trow_";
  protected final String TEXT_350 = ".";
  protected final String TEXT_351 = " = rowStructOutput_";
  protected final String TEXT_352 = ".";
  protected final String TEXT_353 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_354 = NL + "\t\t\t\t\t     \t\trow_";
  protected final String TEXT_355 = ".";
  protected final String TEXT_356 = " = strWriter_";
  protected final String TEXT_357 = ".toString();" + NL + "\t\t\t\t\t     \t\tlistGroupby_";
  protected final String TEXT_358 = ".add(row_";
  protected final String TEXT_359 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_360 = NL + "\t\t\t\t\t\t\t\t\t\t    listGroupby_";
  protected final String TEXT_361 = ".add(strWriter_";
  protected final String TEXT_362 = ".toString());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_363 = NL + "\t\t    doc_";
  protected final String TEXT_364 = ".clearContent();" + NL + "\t\t\tneedRoot_";
  protected final String TEXT_365 = " = true;" + NL + "\t\t\tfor(int i_";
  protected final String TEXT_366 = "=0;i_";
  protected final String TEXT_367 = "<orders_";
  protected final String TEXT_368 = ".length;i_";
  protected final String TEXT_369 = "++){" + NL + "\t\t\t\torders_";
  protected final String TEXT_370 = "[i_";
  protected final String TEXT_371 = "] = 0;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(groupbyList_";
  protected final String TEXT_372 = " != null && groupbyList_";
  protected final String TEXT_373 = ".size() >= 0){" + NL + "\t\t\t\tgroupbyList_";
  protected final String TEXT_374 = ".clear();" + NL + "\t\t\t}" + NL + "\t\t\tstrCompCache_";
  protected final String TEXT_375 = "=strTemp_";
  protected final String TEXT_376 = ";";
  protected final String TEXT_377 = NL + "\t\t\t\trowStructOutput_";
  protected final String TEXT_378 = " = ";
  protected final String TEXT_379 = ";" + NL + "\t\t\t";
  protected final String TEXT_380 = NL + "\t\t}";
  protected final String TEXT_381 = NL + "\t}" + NL;
  protected final String TEXT_382 = NL + "                map_";
  protected final String TEXT_383 = "  = new java.util.HashMap();";
  protected final String TEXT_384 = NL + "                    map_";
  protected final String TEXT_385 = ".put(\"";
  protected final String TEXT_386 = "\",";
  protected final String TEXT_387 = ".";
  protected final String TEXT_388 = ");";
  protected final String TEXT_389 = NL + "\torg.dom4j.Element subTreeRootParent_";
  protected final String TEXT_390 = " = null;" + NL + "\t" + NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_391 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_392 = "=false;";
  protected final String TEXT_393 = NL + "\t\troot4Group_";
  protected final String TEXT_394 = " = subTreeRootParent_";
  protected final String TEXT_395 = ";" + NL + "\t}else{" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_396 = "=root4Group_";
  protected final String TEXT_397 = ";" + NL + "\t}" + NL + "\t// build group xml tree ";
  protected final String TEXT_398 = NL + "\tboolean isNewElememt = false;";
  protected final String TEXT_399 = NL + "\tif(isNewElememt || groupbyList_";
  protected final String TEXT_400 = ".size()<=";
  protected final String TEXT_401 = " || groupbyList_";
  protected final String TEXT_402 = ".get(";
  protected final String TEXT_403 = ")==null";
  protected final String TEXT_404 = NL + "\t|| ( groupbyList_";
  protected final String TEXT_405 = ".get(";
  protected final String TEXT_406 = ").get(";
  protected final String TEXT_407 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_408 = ".get(";
  protected final String TEXT_409 = ").get(";
  protected final String TEXT_410 = ").equals(";
  protected final String TEXT_411 = ") " + NL + "\t\t: ";
  protected final String TEXT_412 = "!=null )";
  protected final String TEXT_413 = NL + "\t){";
  protected final String TEXT_414 = NL + "\t\tif(groupbyList_";
  protected final String TEXT_415 = ".size()<=";
  protected final String TEXT_416 = "){" + NL + "        \tgroupbyList_";
  protected final String TEXT_417 = ".add(new java.util.ArrayList<String>());" + NL + "        }else{" + NL + "        \tgroupbyList_";
  protected final String TEXT_418 = ".get(";
  protected final String TEXT_419 = ").clear();" + NL + "        }";
  protected final String TEXT_420 = NL + "\t\tgroupbyList_";
  protected final String TEXT_421 = ".get(";
  protected final String TEXT_422 = ").add(";
  protected final String TEXT_423 = ");";
  protected final String TEXT_424 = NL + "        isNewElememt=true;" + NL + "        if(groupElementList_";
  protected final String TEXT_425 = ".size()<=";
  protected final String TEXT_426 = "){" + NL + "\t\t\tgroupElementList_";
  protected final String TEXT_427 = ".add(group";
  protected final String TEXT_428 = "__";
  protected final String TEXT_429 = ");" + NL + "        }else{" + NL + "        \tgroupElementList_";
  protected final String TEXT_430 = ".set(";
  protected final String TEXT_431 = ",group";
  protected final String TEXT_432 = "__";
  protected final String TEXT_433 = ");" + NL + "        }" + NL + "        " + NL + "\t}else{" + NL + "\t\tsubTreeRootParent_";
  protected final String TEXT_434 = "=groupElementList_";
  protected final String TEXT_435 = ".get(";
  protected final String TEXT_436 = ");" + NL + "\t}";
  protected final String TEXT_437 = NL + "\t// build loop xml tree";
  protected final String TEXT_438 = NL + "\t\t//the data read is different from the data read last time. " + NL + "\t\tif(strCompCache_";
  protected final String TEXT_439 = ".equals(strTemp_";
  protected final String TEXT_440 = ")==false){";
  protected final String TEXT_441 = NL + NL + "\t\t // write the endtag to the StringWriter:strWriter_tWriteXMLField_1_Out" + NL + "\t\t // close the bufferWriter" + NL + "\t\t // add the data in strWriter_tWriteXMLField_1_Out to listGroupby\t\t\t\t\t\t\t " + NL + "" + NL + "\t\tif (preUnNullMaxIndex_";
  protected final String TEXT_442 = " >= 0) {" + NL + "\t        // output all buffer" + NL + "\t        for (int j_";
  protected final String TEXT_443 = " = 0; j_";
  protected final String TEXT_444 = " <= preUnNullMaxIndex_";
  protected final String TEXT_445 = "; j_";
  protected final String TEXT_446 = "++) {" + NL + "\t            if (startTabs_";
  protected final String TEXT_447 = "[j_";
  protected final String TEXT_448 = "] != null)" + NL + "\t                out_";
  protected final String TEXT_449 = ".write(startTabs_";
  protected final String TEXT_450 = "[j_";
  protected final String TEXT_451 = "]);" + NL + "\t        }" + NL + "\t" + NL + "\t        if (preUnNullMaxIndex_";
  protected final String TEXT_452 = " < preNewTabIndex_";
  protected final String TEXT_453 = " ) {" + NL + "\t\t\t\tfor (int i_";
  protected final String TEXT_454 = " = preNewTabIndex_";
  protected final String TEXT_455 = " - 1; i_";
  protected final String TEXT_456 = " >= 0; i_";
  protected final String TEXT_457 = "--) {" + NL + "                \tif(endTabs_";
  protected final String TEXT_458 = "[i_";
  protected final String TEXT_459 = "]!=null){" + NL + "                \t\tout_";
  protected final String TEXT_460 = ".write(endTabs_";
  protected final String TEXT_461 = "[i_";
  protected final String TEXT_462 = "]);" + NL + "                \t}                \t" + NL + "\t                out_";
  protected final String TEXT_463 = ".write(\"";
  protected final String TEXT_464 = "\");" + NL + "\t                out_";
  protected final String TEXT_465 = ".write(endTabStrs_";
  protected final String TEXT_466 = ".get(i_";
  protected final String TEXT_467 = "));" + NL + "\t            }" + NL + "\t        } else {" + NL + "\t            for (int i_";
  protected final String TEXT_468 = " = preUnNullMaxIndex_";
  protected final String TEXT_469 = "; i_";
  protected final String TEXT_470 = " >= 0; i_";
  protected final String TEXT_471 = "--) {" + NL + "                \tif(endTabs_";
  protected final String TEXT_472 = "[i_";
  protected final String TEXT_473 = "]!=null){" + NL + "                \t\tout_";
  protected final String TEXT_474 = ".write(endTabs_";
  protected final String TEXT_475 = "[i_";
  protected final String TEXT_476 = "]);" + NL + "                \t}" + NL + "                \tout_";
  protected final String TEXT_477 = ".write(\"";
  protected final String TEXT_478 = "\");" + NL + "\t                out_";
  protected final String TEXT_479 = ".write(endTabStrs_";
  protected final String TEXT_480 = ".get(i_";
  protected final String TEXT_481 = "));" + NL + "\t            }" + NL + "\t        }" + NL + "\t    }";
  protected final String TEXT_482 = NL + "\t\tfor (int i_";
  protected final String TEXT_483 = " = endTabStrs_";
  protected final String TEXT_484 = ".size() - 1; i_";
  protected final String TEXT_485 = " >= 0; i_";
  protected final String TEXT_486 = "--) {" + NL + "        \tif(endTabs_";
  protected final String TEXT_487 = "[i_";
  protected final String TEXT_488 = "]!=null){" + NL + "        \t\tout_";
  protected final String TEXT_489 = ".write(endTabs_";
  protected final String TEXT_490 = "[i_";
  protected final String TEXT_491 = "]);" + NL + "        \t}" + NL + "\t        out_";
  protected final String TEXT_492 = ".write(\"";
  protected final String TEXT_493 = "\");" + NL + "\t        out_";
  protected final String TEXT_494 = ".write(endTabStrs_";
  protected final String TEXT_495 = ".get(i_";
  protected final String TEXT_496 = "));" + NL + "\t    }";
  protected final String TEXT_497 = NL + "\t\tfor (int i_";
  protected final String TEXT_498 = " = 0; i_";
  protected final String TEXT_499 = " < endTabs_";
  protected final String TEXT_500 = ".length; i_";
  protected final String TEXT_501 = "++) {" + NL + "\t\t\tstartTabs_";
  protected final String TEXT_502 = "[i_";
  protected final String TEXT_503 = "] = null;" + NL + "\t\t\tendTabs_";
  protected final String TEXT_504 = "[i_";
  protected final String TEXT_505 = "] = null;" + NL + "\t\t}" + NL + "//\t\tendTabStrs_";
  protected final String TEXT_506 = ".clear();" + NL + "\t\tout_";
  protected final String TEXT_507 = ".write(\"";
  protected final String TEXT_508 = "\");" + NL + "\t\tout_";
  protected final String TEXT_509 = ".close();" + NL + "\t\tlistGroupby_";
  protected final String TEXT_510 = ".add(strWriter_";
  protected final String TEXT_511 = ".toString());" + NL + "" + NL + "\t\t//create a new StringWriter and BufferWriter" + NL + "\t\t//write the head title to the StringWriter\t\t" + NL + "\t\tstrWriter_";
  protected final String TEXT_512 = " = new java.io.StringWriter();" + NL + "\t\tout_";
  protected final String TEXT_513 = " = new java.io.BufferedWriter(strWriter_";
  protected final String TEXT_514 = ");";
  protected final String TEXT_515 = NL + "\t\tout_";
  protected final String TEXT_516 = ".write(\"<?xml version=\\\"1.0\\\" encoding=\\\"\"+";
  protected final String TEXT_517 = "+\"\\\"?>\");" + NL + "\t\tout_";
  protected final String TEXT_518 = ".write(\"";
  protected final String TEXT_519 = "\");";
  protected final String TEXT_520 = NL + NL + "\t\tneedRoot_";
  protected final String TEXT_521 = " = true;" + NL + "\t\tstrCompCache_";
  protected final String TEXT_522 = "=strTemp_";
  protected final String TEXT_523 = ";" + NL + "\t\tpreNewTabIndex_";
  protected final String TEXT_524 = " = -1;";
  protected final String TEXT_525 = NL + "\t\t}";
  protected final String TEXT_526 = "\t" + NL + "\t}\t" + NL + "\t" + NL + "\tStringBuffer buf_";
  protected final String TEXT_527 = " = new StringBuffer();" + NL + "\t//init value is 0 not -1, because it will output the root tab when all the row value is null." + NL + "\tint unNullMaxIndex_";
  protected final String TEXT_528 = " = 0;" + NL + "" + NL + "\t// build root xml tree " + NL + "\tif (needRoot_";
  protected final String TEXT_529 = ") {" + NL + "\t\tneedRoot_";
  protected final String TEXT_530 = "=false;";
  protected final String TEXT_531 = NL + "\t\tif( false";
  protected final String TEXT_532 = " || valueMap_";
  protected final String TEXT_533 = ".get(\"";
  protected final String TEXT_534 = "\") != null";
  protected final String TEXT_535 = NL + "\t\t){" + NL + "\t\t\tunNullMaxIndex_";
  protected final String TEXT_536 = " = ";
  protected final String TEXT_537 = ";" + NL + "\t\t}";
  protected final String TEXT_538 = NL + "\t\tendTabs_";
  protected final String TEXT_539 = "[";
  protected final String TEXT_540 = "] = buf_";
  protected final String TEXT_541 = ".toString();" + NL + "\t\tbuf_";
  protected final String TEXT_542 = " = new StringBuffer();";
  protected final String TEXT_543 = NL + "\t}" + NL + "\t" + NL + "\t// build group xml tree ";
  protected final String TEXT_544 = NL + "\tboolean isNewElememt = false;" + NL + "\t//The index of group element which is the first new group in groups." + NL + "\tint newTabIndex_";
  protected final String TEXT_545 = " = -1;" + NL + "\t//Buffer all group tab XML, then set to startTabBuffer." + NL + "    String[] groupBuffer_";
  protected final String TEXT_546 = " = new String[";
  protected final String TEXT_547 = "];" + NL + "    String[] groupEndBuffer_";
  protected final String TEXT_548 = " = new String[";
  protected final String TEXT_549 = "];";
  protected final String TEXT_550 = NL + NL + "\t// need a new group element ";
  protected final String TEXT_551 = " or not" + NL + "\tif(isNewElememt || groupbyList_";
  protected final String TEXT_552 = ".size()<=";
  protected final String TEXT_553 = " || groupbyList_";
  protected final String TEXT_554 = ".get(";
  protected final String TEXT_555 = ")==null";
  protected final String TEXT_556 = NL + "\t|| ( groupbyList_";
  protected final String TEXT_557 = ".get(";
  protected final String TEXT_558 = ").get(";
  protected final String TEXT_559 = ")!=null " + NL + "\t\t? !groupbyList_";
  protected final String TEXT_560 = ".get(";
  protected final String TEXT_561 = ").get(";
  protected final String TEXT_562 = ").equals(";
  protected final String TEXT_563 = ") " + NL + "\t\t: ";
  protected final String TEXT_564 = "!=null )";
  protected final String TEXT_565 = NL + "\t){" + NL + "\t\t// Is the first new element in groups." + NL + "\t\tif(isNewElememt == false && groupbyList_";
  protected final String TEXT_566 = ".size()>";
  protected final String TEXT_567 = "){" + NL + "\t\t\tnewTabIndex_";
  protected final String TEXT_568 = " = ";
  protected final String TEXT_569 = ";" + NL + "\t\t}" + NL + "" + NL + "\t\t// count the groupby element" + NL + "\t\tif(groupbyList_";
  protected final String TEXT_570 = ".size()<=";
  protected final String TEXT_571 = "){" + NL + "        \tgroupbyList_";
  protected final String TEXT_572 = ".add(new java.util.ArrayList<String>());" + NL + "        }else{" + NL + "        \tgroupbyList_";
  protected final String TEXT_573 = ".get(";
  protected final String TEXT_574 = ").clear();" + NL + "        }";
  protected final String TEXT_575 = NL + "\t\tgroupbyList_";
  protected final String TEXT_576 = ".get(";
  protected final String TEXT_577 = ").add(";
  protected final String TEXT_578 = ");";
  protected final String TEXT_579 = NL + "        isNewElememt=true;" + NL + "\t}" + NL + "\t" + NL + "\t// subtree XML string generate";
  protected final String TEXT_580 = NL + "\tif( false";
  protected final String TEXT_581 = " || valueMap_";
  protected final String TEXT_582 = ".get(\"";
  protected final String TEXT_583 = "\") != null";
  protected final String TEXT_584 = NL + "\t){" + NL + "\t\tunNullMaxIndex_";
  protected final String TEXT_585 = " = ";
  protected final String TEXT_586 = ";" + NL + "\t}";
  protected final String TEXT_587 = NL + "\t// buffer the end tabs to group buffer" + NL + "\tgroupEndBuffer_";
  protected final String TEXT_588 = "[";
  protected final String TEXT_589 = "] = buf_";
  protected final String TEXT_590 = ".toString();" + NL + "    buf_";
  protected final String TEXT_591 = " = new StringBuffer();";
  protected final String TEXT_592 = NL + "\t//output the previous groups as there's a new group" + NL + "    if (newTabIndex_";
  protected final String TEXT_593 = " >= 0 && preNewTabIndex_";
  protected final String TEXT_594 = "!=-1) {" + NL + "        //out_";
  protected final String TEXT_595 = ".newLine();//Track code";
  protected final String TEXT_596 = NL + "\t\t// output unNull tabs in start tabs buffer" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_597 = " >= 0) {" + NL + "            for (int i_";
  protected final String TEXT_598 = " = 0; i_";
  protected final String TEXT_599 = " < startTabs_";
  protected final String TEXT_600 = ".length; i_";
  protected final String TEXT_601 = "++) {" + NL + "                if (i_";
  protected final String TEXT_602 = " <= preUnNullMaxIndex_";
  protected final String TEXT_603 = ") {" + NL + "                    if (startTabs_";
  protected final String TEXT_604 = "[i_";
  protected final String TEXT_605 = "] != null) {" + NL + "                        out_";
  protected final String TEXT_606 = ".write(startTabs_";
  protected final String TEXT_607 = "[i_";
  protected final String TEXT_608 = "]);" + NL + "                    }" + NL + "                    startTabs_";
  protected final String TEXT_609 = "[i_";
  protected final String TEXT_610 = "] = null;" + NL + "                }" + NL + "            }" + NL + "        }";
  protected final String TEXT_611 = NL + "\t\t//output all start tabs buffer" + NL + "\t\tfor (int i_";
  protected final String TEXT_612 = " = 0; i_";
  protected final String TEXT_613 = " < startTabs_";
  protected final String TEXT_614 = ".length; i_";
  protected final String TEXT_615 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_616 = "[i_";
  protected final String TEXT_617 = "] != null) {" + NL + "                out_";
  protected final String TEXT_618 = ".write(startTabs_";
  protected final String TEXT_619 = "[i_";
  protected final String TEXT_620 = "]);" + NL + "            }" + NL + "            startTabs_";
  protected final String TEXT_621 = "[i_";
  protected final String TEXT_622 = "] = null;" + NL + "        }";
  protected final String TEXT_623 = NL + "        // output endtabs" + NL + "        if (preUnNullMaxIndex_";
  protected final String TEXT_624 = " >= preNewTabIndex_";
  protected final String TEXT_625 = NL + "            && preUnNullMaxIndex_";
  protected final String TEXT_626 = " >= ";
  protected final String TEXT_627 = " + newTabIndex_";
  protected final String TEXT_628 = ") {" + NL + "            for (int i_";
  protected final String TEXT_629 = " = preUnNullMaxIndex_";
  protected final String TEXT_630 = "; i_";
  protected final String TEXT_631 = " >= ";
  protected final String TEXT_632 = " + newTabIndex_";
  protected final String TEXT_633 = "; i_";
  protected final String TEXT_634 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_635 = "[i_";
  protected final String TEXT_636 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_637 = ".write(endTabs_";
  protected final String TEXT_638 = "[i_";
  protected final String TEXT_639 = "]);" + NL + "            \t}" + NL + "            \tendTabs_";
  protected final String TEXT_640 = "[i_";
  protected final String TEXT_641 = "] = null;" + NL + "                out_";
  protected final String TEXT_642 = ".write(\"";
  protected final String TEXT_643 = "\");" + NL + "                out_";
  protected final String TEXT_644 = ".write(endTabStrs_";
  protected final String TEXT_645 = NL + "                        .get(i_";
  protected final String TEXT_646 = "));" + NL + "            }" + NL + "        } else {";
  protected final String TEXT_647 = NL + "            for (int i_";
  protected final String TEXT_648 = " = preNewTabIndex_";
  protected final String TEXT_649 = " - 1; i_";
  protected final String TEXT_650 = " >= ";
  protected final String TEXT_651 = " + newTabIndex_";
  protected final String TEXT_652 = "; i_";
  protected final String TEXT_653 = "--) {" + NL + "            \tif(endTabs_";
  protected final String TEXT_654 = "[i_";
  protected final String TEXT_655 = "]!=null){" + NL + "            \t\tout_";
  protected final String TEXT_656 = ".write(endTabs_";
  protected final String TEXT_657 = "[i_";
  protected final String TEXT_658 = "]);" + NL + "            \t}" + NL + "            \tendTabs_";
  protected final String TEXT_659 = "[i_";
  protected final String TEXT_660 = "] = null;" + NL + "                out_";
  protected final String TEXT_661 = ".write(\"";
  protected final String TEXT_662 = "\");" + NL + "                out_";
  protected final String TEXT_663 = ".write(endTabStrs_";
  protected final String TEXT_664 = NL + "                        .get(i_";
  protected final String TEXT_665 = "));" + NL + "            }";
  protected final String TEXT_666 = NL + "        }";
  protected final String TEXT_667 = NL + "        preNewTabIndex_";
  protected final String TEXT_668 = " = newTabIndex_";
  protected final String TEXT_669 = " + ";
  protected final String TEXT_670 = ";" + NL + "    }" + NL + "" + NL + "    // set new element groupbuffer to startbuffer" + NL + "    for (int i_";
  protected final String TEXT_671 = " = 0; i_";
  protected final String TEXT_672 = " < groupBuffer_";
  protected final String TEXT_673 = ".length; i_";
  protected final String TEXT_674 = "++) {" + NL + "        // when newTabIndex is null, must use the perNewTabIndex" + NL + "        if (i_";
  protected final String TEXT_675 = " >= preNewTabIndex_";
  protected final String TEXT_676 = " - ";
  protected final String TEXT_677 = ") {" + NL + "            startTabs_";
  protected final String TEXT_678 = "[i_";
  protected final String TEXT_679 = " + ";
  protected final String TEXT_680 = "] = groupBuffer_";
  protected final String TEXT_681 = "[i_";
  protected final String TEXT_682 = "];" + NL + "            endTabs_";
  protected final String TEXT_683 = "[i_";
  protected final String TEXT_684 = " + ";
  protected final String TEXT_685 = "] = groupEndBuffer_";
  protected final String TEXT_686 = "[i_";
  protected final String TEXT_687 = "];" + NL + "        }" + NL + "    }";
  protected final String TEXT_688 = NL + "\t//reset the preUnNullMaxIndex" + NL + "\tif(unNullMaxIndex_";
  protected final String TEXT_689 = ">=0){" + NL + "    \tpreUnNullMaxIndex_";
  protected final String TEXT_690 = "=unNullMaxIndex_";
  protected final String TEXT_691 = ";" + NL + "\t}else{" + NL + "\t\tif(preUnNullMaxIndex_";
  protected final String TEXT_692 = ">";
  protected final String TEXT_693 = "){" + NL + "\t\t\tpreUnNullMaxIndex_";
  protected final String TEXT_694 = "=";
  protected final String TEXT_695 = ";" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_696 = NL + "\t// build loop xml tree";
  protected final String TEXT_697 = NL + "\t\tif( false";
  protected final String TEXT_698 = " || valueMap_";
  protected final String TEXT_699 = ".get(\"";
  protected final String TEXT_700 = "\") != null";
  protected final String TEXT_701 = " || true " + NL + "    \t";
  protected final String TEXT_702 = NL + "\t\t){";
  protected final String TEXT_703 = NL + "\t\t// output all buffer" + NL + "\t\tfor (int i_";
  protected final String TEXT_704 = " = 0; i_";
  protected final String TEXT_705 = " < startTabs_";
  protected final String TEXT_706 = ".length; i_";
  protected final String TEXT_707 = "++) {" + NL + "            if (startTabs_";
  protected final String TEXT_708 = "[i_";
  protected final String TEXT_709 = "] != null && startTabs_";
  protected final String TEXT_710 = "[i_";
  protected final String TEXT_711 = "].length() > 0) {" + NL + "                out_";
  protected final String TEXT_712 = ".write(startTabs_";
  protected final String TEXT_713 = "[i_";
  protected final String TEXT_714 = "]);" + NL + "                startTabs_";
  protected final String TEXT_715 = "[i_";
  protected final String TEXT_716 = "] = null;" + NL + "            }" + NL + "        }" + NL + "\t\tout_";
  protected final String TEXT_717 = ".write(buf_";
  protected final String TEXT_718 = ".toString());" + NL + "\t\tpreNewTabIndex_";
  protected final String TEXT_719 = " = ";
  protected final String TEXT_720 = ";";
  protected final String TEXT_721 = NL + "            preUnNullMaxIndex_";
  protected final String TEXT_722 = " = ";
  protected final String TEXT_723 = ";" + NL + "\t\t}";
  protected final String TEXT_724 = NL;

    static class XMLNode {

        // table parameter of component
        public String name = null;

        public String path = null;

        public String type = null;

        public String column = null;
        
        public String defaultValue = null;
        
        public int order = 0;
        
        public boolean hasDefaultValue = false;

        // special node
        public int special = 0; // 1 is subtree root, 2 is subtree root parent, 4 is main

        // column
        public IMetadataColumn relatedColumn = null;

        public List<IMetadataColumn> childrenColumnList = new ArrayList<IMetadataColumn>();

        // tree variable
        public XMLNode parent = null;

        public List<XMLNode> attributes = new LinkedList<XMLNode>();

        public List<XMLNode> namespaces = new LinkedList<XMLNode>();

        public List<XMLNode> elements = new LinkedList<XMLNode>(); // the main element is the last element

        public XMLNode(String path, String type, XMLNode parent, String column, String value, int order) {
        	this.order = order;
            this.path = path;
            this.parent = parent;
            this.type = type;
            this.column = column;
            this.defaultValue = value;
            if (type.equals("ELEMENT")) {
                this.name = path.substring(path.lastIndexOf("/") + 1);
            } else {
                this.name = path;
            }
        }
        
        public boolean isMainNode(){
            return 4 == (special & 4);
        }
        
        public boolean isSubTreeRoot(){
            return 1 == (special & 1);
        }
        
        public boolean isSubTreeParent(){
            return 2 == (special & 2);
        }
    
        public int getNodeInsertIndex(){
        	int insertIndex =0;
        	if(5==(special & 5)){//group and loop main node
        		if(parent!=null && parent.elements!=null){
            		for(XMLNode tmpNode: parent.elements){
            			if(order <= tmpNode.order){
            				break;
            			}
            			insertIndex++;
            		}
        		}
        	}
        	return insertIndex;
        }
        
        public int getCurrGroupPos(){
        	int currPos =0;
        	if(5==(special & 5)){//group and loop main node
    			XMLNode tmpNode = parent;
    			while(tmpNode!=null && (5==(tmpNode.special & 5))){
    				currPos++;
    				tmpNode = tmpNode.parent;
    			}
        	}
        	return currPos;
        }
    }

    
    // return [0] is root(XMLNode), [1] is groups(List<XMLNode>), [2] loop(XMLNode)
    public Object[] getTree(List<Map<String, String>> rootTable, List<Map<String, String>> groupTable,
            List<Map<String, String>> loopTable, List<IMetadataColumn> colList) {
        List<List<Map<String, String>>> tables = new ArrayList<List<Map<String, String>>>();
        tables.add(rootTable);
        tables.add(groupTable);
        tables.add(loopTable);

        XMLNode root = null;
        List<XMLNode> mains = new ArrayList<XMLNode>();
        List<XMLNode> groups = new ArrayList<XMLNode>();
        XMLNode loop = null;

        XMLNode tmpParent = null;
        XMLNode tmpMainNode = null;
        if (loopTable == null || loopTable.size() == 0) {
            return null;
        }
        int index =0;
        int currOrder = 0;
        String mainPath = loopTable.get(0).get("PATH");
        for (List<Map<String, String>> tmpTable : tables) {
            tmpParent = tmpMainNode;
            for (Map<String, String> tmpMap : tmpTable) {
            	index++;
            	if(tmpMap.get("ORDER")!=null && !"".equals(tmpMap.get("ORDER").trim())){
            		currOrder = Integer.parseInt(tmpMap.get("ORDER"));
            	}else{
            		currOrder = index;
            	}
                XMLNode tmpNew = null;
                if (tmpMap.get("ATTRIBUTE").equals("attri")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "ATTRIBUTE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                    tmpParent.attributes.add(tmpNew);
                } else if (tmpMap.get("ATTRIBUTE").equals("ns")) {
                    tmpNew = new XMLNode(tmpMap.get("PATH"), "NAMESPACE", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                    tmpParent.namespaces.add(tmpNew);
                } else {
                    if (tmpParent == null) {
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
//                        tmpNew.special |= 1;
                        root = tmpNew;
                        mains.add(root);
                    } else {
                        String tmpParentPath = tmpMap.get("PATH").substring(0, tmpMap.get("PATH").lastIndexOf("/"));
                        while (tmpParent != null && !tmpParentPath.equals(tmpParent.path)) {
                            tmpParent = tmpParent.parent;
                        }
                        tmpNew = new XMLNode(tmpMap.get("PATH"), "ELEMENT", tmpParent, tmpMap.get("COLUMN"), tmpMap.get("VALUE"), currOrder);
                        tmpParent.elements.add(tmpNew);
                        if (tmpMap.get("ATTRIBUTE").equals("main")) {
                            if (tmpTable == groupTable) {
                                tmpNew.special |= 1;
                                tmpParent.special |= 2;
                                groups.add(tmpNew);
                            } else if (tmpTable == loopTable) {
                                tmpNew.special |= 1;
                                tmpParent.special |= 2;
                                loop = tmpNew;
                            }else if (tmpTable == rootTable){
                                mains.add(tmpNew);
                            }
                        }
                    }
                    if (tmpMap.get("ATTRIBUTE").equals("main")) {
                        tmpMainNode = tmpNew;
                        tmpNew.special |= 4;
                    }
                    tmpParent = tmpNew;
                }
                setIMetadataColumn(tmpNew, colList);
                setDefaultValues(tmpNew);//add by wliu
            }
        }
        return new Object[] { mains, groups, loop };
    }
    
    private void setDefaultValues(XMLNode node){
    	if(node.defaultValue != null && !"".equals(node.defaultValue)){
    		XMLNode tmp = node;
    		while(tmp !=null){
    			tmp.hasDefaultValue = true;
    			if(tmp.isMainNode()){
    				break;
    			}
    			tmp = tmp.parent;
    		}
    	}
    }

    private void setIMetadataColumn(XMLNode node, List<IMetadataColumn> colList) {
        String value = null;
        JavaType javaType = null;
        if (node.column != null && node.column.length() > 0) {
            for (IMetadataColumn column : colList) {
                if (column.getLabel().equals(node.column)) {
                    node.relatedColumn = column;
                    XMLNode tmp = node;
                    while (tmp != null) {
                        if (!tmp.childrenColumnList.contains(column)) {
                            tmp.childrenColumnList.add(column);
                        }
                        if(tmp.isMainNode()){
                            break;
                        }
                        tmp = tmp.parent;
                    }
                }
            }
        }
    }

    public List<XMLNode> getGroupByNodeList(XMLNode group) {
        List<XMLNode> list = new ArrayList<XMLNode>();
        for (XMLNode attri : group.attributes) {
            if (attri.column != null && attri.column.length() != 0) {
                list.add(attri);
            }
        }
        if (group.relatedColumn != null) {
            list.add(group);
        } else {
            for (XMLNode element : group.elements) {
                if (!element.isMainNode()) {
                    list.addAll(getGroupByNodeList(element));
                }
            }
        }
        return list;
    }

    public XMLNode removeEmptyElement(XMLNode root) {
        List<XMLNode> removeNodes = new LinkedList<XMLNode>();
        for (XMLNode attri : root.attributes) {
            if ((attri.column == null || attri.column.length() == 0) && 
            		(attri.defaultValue == null || "".equals(attri.defaultValue)) ) {
                attri.parent = null;
                removeNodes.add(attri);
            }
        }
        root.attributes.removeAll(removeNodes);

        removeNodes.clear();
        for (XMLNode ns : root.namespaces) {
            if ( (ns.column == null || ns.column.length() == 0)
            		&& (ns.defaultValue == null || "".equals(ns.defaultValue)) ) {
                ns.parent = null;
                removeNodes.add(ns);
            }
        }
        root.namespaces.removeAll(removeNodes);

        removeNodes.clear();
        for (XMLNode child : root.elements) {
            removeNodes.add(removeEmptyElement(child));
        }
        root.elements.removeAll(removeNodes);

        if (root.attributes.size() == 0 && root.namespaces.size() == 0 && root.elements.size() == 0
                && (root.column == null || root.column.length() == 0)
                && (root.defaultValue == null || "".equals(root.defaultValue)) ) {
            return root;
        } else {
            return null;
        }
    }

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
//==========common part 1 begin===================================================================
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String jsonField = ElementParameterParser.getValue(node, "__JSONFIELD__");
String destination4JSON = ElementParameterParser.getValue(node, "__DESTINATION__");
boolean istWriteJSONField = destination4JSON == null ? false : destination4JSON.contains("tWriteJSONField_");
boolean isCompactFormat = ("true").equals(ElementParameterParser.getValue(node, "__COMPACT_FORMAT__"));
final String whiteSpace;
final String rowSeparator;
if(!isCompactFormat) { // pretty format
	whiteSpace = "  ";
	rowSeparator = "\\n";
} else { // compact format
	whiteSpace = "";
	rowSeparator = "";
}
//===========common part 1 end=============================================================

    
//XMLTool
class XMLTool{
	public boolean advancedSeparator = false;
	public String thousandsSeparator = null;
 	public String decimalSeparator =null;
	public String connName = null;
	public String cid = null;
	
	public void getValue(XMLNode node){

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(node.relatedColumn.getLabel());
    stringBuffer.append(TEXT_31);
    
	}

	public void getValue(IMetadataColumn column){
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String defaultValue=column.getDefault();
		boolean isNotSetDefault = false;
		if(defaultValue!=null){
			isNotSetDefault = defaultValue.length()==0;
		}else{
			isNotSetDefault=true;
		}

    stringBuffer.append(TEXT_32);
    
		if(column.isNullable()){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    
		}
		
        if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        	if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_38);
    stringBuffer.append( thousandsSeparator);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_40);
    
    		} else {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_43);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(decimalSeparator );
    stringBuffer.append(TEXT_45);
    
	   		}
        } else if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_48);
    
        }else if(javaType == JavaTypesManager.DATE){
            if( column.getPattern() != null && column.getPattern().trim().length() != 0 ){

    stringBuffer.append(TEXT_49);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getPattern());
    stringBuffer.append(TEXT_52);
    
            }else{

    stringBuffer.append(TEXT_53);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel());
    
           }
        }else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_57);
    
        }else{

    stringBuffer.append(TEXT_58);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
    
		}
		if(column.isNullable()){
			
    stringBuffer.append(TEXT_61);
     
			if(isNotSetDefault == false){
				
    stringBuffer.append(column.getDefault());
    
			}else{
				
    stringBuffer.append(TEXT_62);
    
			}
		}

    stringBuffer.append(TEXT_63);
    
	}
}

// ------------------- *** Dom4j generation mode start *** ------------------- //
class GenerateToolByDom4j{
	String cid = null;
	boolean allowEmpty = false;
	boolean outputAsXSD = false;
	XMLTool tool = null;
	public void generateCode(XMLNode node, String currEleName, String parentName){
		if(("ELEMENT").equals(node.type)){
			createElement(currEleName,node,parentName);
			setText(currEleName,node);
			for(XMLNode ns:node.namespaces){
				addNameSpace(currEleName,ns);
			}
			for(XMLNode attri:node.attributes){
				addAttribute(currEleName,attri);
			}
			if(node.name.indexOf(":")>0){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_67);
    
			}
			int index = 0;
			for(XMLNode child:node.elements){
				if(0==(child.special & 1)){
					generateCode(child,currEleName+"_"+index++,currEleName);
				}
			}
		}
	}
	private void createElement(String currEleName, XMLNode node, String parentName){
		int index = node.name.indexOf(":");
		if(5==(node.special & 5)){
			int currPos = node.getCurrGroupPos();
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_68);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_80);
    
			}else{

    stringBuffer.append(TEXT_81);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_84);
    
			}

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(node.getNodeInsertIndex() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(currPos +1 );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(currPos );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
		}else{
			if(index>0 && node.parent!=null){

    stringBuffer.append(TEXT_102);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(node.name.substring(0,index));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(node.name.substring(index+1));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_118);
    
			}else{

    stringBuffer.append(TEXT_119);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(parentName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_124);
    
			}
		}
		if(0!=(node.special & 2)){

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
		}
	}
	private void setText(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_129);
    tool.getValue(node);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    tool.getValue(node);
    stringBuffer.append(TEXT_134);
    
				if(outputAsXSD){

    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
				}
			}else{

    stringBuffer.append(TEXT_141);
    tool.getValue(node);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    tool.getValue(node);
    stringBuffer.append(TEXT_146);
    
				if(outputAsXSD){

    stringBuffer.append(TEXT_147);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
				}
			}
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_156);
    
		}
	}
	private void addAttribute(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_157);
    tool.getValue(node);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_161);
    tool.getValue(node);
    stringBuffer.append(TEXT_162);
    
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_163);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_167);
    
		}
	}
	private void addNameSpace(String currEleName, XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_168);
    tool.getValue(node);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_172);
    tool.getValue(node);
    stringBuffer.append(TEXT_173);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_174);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(currEleName);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    tool.getValue(node);
    stringBuffer.append(TEXT_179);
    
			}

    stringBuffer.append(TEXT_180);
    
		}else if(node.defaultValue != null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_181);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(node.path );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_185);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_186);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(currEleName );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_191);
    
			}
		}
	}
}
// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Null generation mode start *** ------------------- //
class GenerateToolByNull{
	String cid = null;
	boolean allowEmpty = false;
	boolean outputAsXSD = false;
	String fileNameXSD = "";
	XMLTool tool = null;
	
	public void generateCode(XMLNode node, String emptySpace){	
		if(("ELEMENT").equals(node.type)){
			startElement(node,emptySpace);
			setText(node);
			XMLNode mainChild = null;
			for(XMLNode child:node.elements){
				if(child.isMainNode()){ //loop dosen't have a main child node
					mainChild = child;
					break;
				}
			}
			for(XMLNode child:node.elements){
				if(mainChild!=null && mainChild.order<=child.order){ //loop dosen't have a main child node
					if(1==(node.special & 1)){ // group

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(node.getCurrGroupPos());
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
					}else{// root
    					int num = node.path.split("/").length-2;
    					if(!outputAsXSD && !allowEmpty){

    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(num);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
						}else{

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    
						}
					}
					mainChild = null;
				}
				if(!child.isMainNode()){ //make the main node output last
					if(!outputAsXSD && !allowEmpty && (child.relatedColumn != null || child.childrenColumnList.size()>0 || child.hasDefaultValue == true)){

    stringBuffer.append(TEXT_206);
    
                    	for(IMetadataColumn column : child.childrenColumnList){
                    		
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_209);
    
                    	}
                    	if(child.hasDefaultValue == true){
    stringBuffer.append(TEXT_210);
    }
    stringBuffer.append(TEXT_211);
    
						generateCode(child,emptySpace+whiteSpace);

    stringBuffer.append(TEXT_212);
    
            		}else{
            			generateCode(child,emptySpace+whiteSpace);
            		}
				}
			}

			if(!node.isMainNode()){ // is not main node
				endElement(node,emptySpace);
			}
		}
	}
	private void startElement(XMLNode node, String emptySpace){

    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_218);
    
		if(outputAsXSD && node.parent==null){

    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(fileNameXSD);
    stringBuffer.append(TEXT_222);
    
		}
		for(XMLNode ns:node.namespaces){
			addNameSpace(ns);
		}
		for(XMLNode attri:node.attributes){
			addAttribute(attri);
		}
		if(outputAsXSD && node.relatedColumn != null){

    stringBuffer.append(TEXT_223);
    tool.getValue(node);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    
		}

    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    
	}
	
	public void endElement(XMLNode node, String emptySpace){
		if(node.elements.size()>0){

    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(emptySpace);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_233);
    
		}else{

    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(node.name);
    stringBuffer.append(TEXT_236);
    
		}
	}
	private void setText(XMLNode node){
		if(node.relatedColumn!=null){
			JavaType javaType = JavaTypesManager.getJavaTypeFromId(node.relatedColumn.getTalendType());
			if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_237);
    tool.getValue(node);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    tool.getValue(node);
    stringBuffer.append(TEXT_240);
    
			}else{

    stringBuffer.append(TEXT_241);
    tool.getValue(node);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    tool.getValue(node);
    stringBuffer.append(TEXT_244);
    
			}
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_247);
    
		}
	}
	private void addAttribute(XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_248);
    tool.getValue(node);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_251);
    tool.getValue(node);
    stringBuffer.append(TEXT_252);
    
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){

    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_256);
    
		}
	}
	private void addNameSpace(XMLNode node){
		if(node.relatedColumn!=null){

    stringBuffer.append(TEXT_257);
    tool.getValue(node);
    stringBuffer.append(TEXT_258);
    
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    tool.getValue(node);
    stringBuffer.append(TEXT_261);
    
			}else{

    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_264);
    tool.getValue(node);
    stringBuffer.append(TEXT_265);
    
			}

    stringBuffer.append(TEXT_266);
    
		}else if(node.defaultValue !=null && !("").equals(node.defaultValue) ){
			if(node.path ==null || node.path.length()==0){

    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_269);
    
			}else{

    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(node.path);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(node.defaultValue );
    stringBuffer.append(TEXT_273);
    
			}
		}
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

// ------------------- *** Common code start *** ------------------- //
IMetadataTable metadata = null;
IConnection inConn = null;
for (IConnection conn : node.getIncomingConnections()) {
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.FLOW)) {
		inConn = conn;
		break;
	}
}
if (inConn != null) {
	metadata = inConn.getMetadataTable();
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	List< ? extends IConnection> connsOut = NodeUtil.getOutgoingConnections(node,EConnectionType.ON_COMPONENT_OK);
    	String rowStructNameOutput = null;
    	if (connsOut != null && connsOut.size() > 0 && istWriteJSONField) {
    		List< ? extends IConnection> connsTarget = connsOut.get(0).getTarget().getOutgoingConnections();
			if(connsTarget != null && connsTarget.size()>0){
				rowStructNameOutput = connsTarget.get(0).getName();
	    		rowStructNameOutput += "Struct";
			}
    	}
    	String rowNameInput = null;
    	String rowStructNameInput = null;
    	if(conns!=null && conns.size()>0){
    		IConnection conn = conns.get(0);
    		rowNameInput = conn.getName();
    		rowStructNameInput = rowNameInput + "Struct";
    		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){ 
    		
            	List<Map<String, String>> rootTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");
                List<Map<String, String>> groupTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUP__");
                List<Map<String, String>> loopTable = 
                	(List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__LOOP__");
                
                IMetadataTable inputMetadataTable= conn.getMetadataTable();
                List<IMetadataColumn> inputColumns= inputMetadataTable.getListColumns();
                
                List<Map<String,String>> groupbys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
				
				String removeHeader = ElementParameterParser.getValue(node, "__REMOVE_HEADER__"); // add for feature7788
                String allowEmpty = ElementParameterParser.getValue(node, "__CREATE_EMPTY_ELEMENT__");
                String outputAsXSD = ElementParameterParser.getValue(node, "__OUTPUT_AS_XSD__");
                String fileNameXSD = ElementParameterParser.getValue(node, "__XSD_FILE__");
                String encoding = ElementParameterParser.getValue(node, "__ENCODING__");                
                
	            String rowNumber = ElementParameterParser.getValue(node, "__ROW_NUMBER__");
                
                String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
        		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
        		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
        		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
        		
        		String mode = ElementParameterParser.getValue(node, "__GENERATION_MODE__");
        		
        		boolean storeFlow = ("true").equals(ElementParameterParser.getValue(node, "__STORE_FLOW__"));
        		                
                java.util.Map<String,IMetadataColumn> inputKeysColumns = new java.util.HashMap<String,IMetadataColumn>();
                if(inputColumns!=null){
                	for(IMetadataColumn column :inputColumns){
                		for(int i=0;i<groupbys.size();i++){
                			String columnName=groupbys.get(i).get("INPUT_COLUMN");
                			if(column.getLabel().equals(columnName)){
                				inputKeysColumns.put(columnName,column);
                				break;
                			}
                		}
                	}
                }
        		
                String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
        		// init tool
                XMLTool tool = new XMLTool();
                tool.connName = conn.getName();
                tool.advancedSeparator=advancedSeparator;
                tool.thousandsSeparator=thousandsSeparator;
                tool.decimalSeparator=decimalSeparator;
                tool.cid=cid;
                
                // change tables to a tree 
				Object[] treeObjs = getTree(rootTable, groupTable, loopTable, metadata.getListColumns());
            	List<XMLNode> mainList = (ArrayList<XMLNode>)treeObjs[0];
                List<XMLNode> groupList = (ArrayList<XMLNode>)treeObjs[1];
                XMLNode root = mainList.get(0);
            	XMLNode loop = (XMLNode)treeObjs[2];
                
                if(!("true").equals(allowEmpty)){
                	removeEmptyElement(root);
                }
                
                List<List<XMLNode>> groupbyNodeList = new ArrayList<List<XMLNode>>();
                for(XMLNode group:groupList){
                	groupbyNodeList.add(getGroupByNodeList(group));
                }
                IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
				if(nextMergeConn == null || nextMergeConn.getInputId()==1){

    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    
				}

    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
	log4jFileUtil.logCurrentRowNumberInfo();

    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    
				for(IMetadataColumn column :inputColumns){

    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_284);
    tool.getValue(column);
    stringBuffer.append(TEXT_285);
    
				}

    if(storeFlow){
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
    }
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    
	if(inputKeysColumns.size() !=0){
		for (IMetadataColumn column : inputColumns) {
			if(inputKeysColumns.containsKey(column.getLabel())) {

    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_300);
    			}
		}
	}

    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    
		     if(istWriteJSONField){
						
    stringBuffer.append(TEXT_305);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append( rowNameInput );
    stringBuffer.append(TEXT_307);
    
		 }
		
    stringBuffer.append(TEXT_308);
    
// ------------------- *** Common code end *** ------------------- //

// ------------------- *** Dom4j generation mode start *** ------------------- //
if(("Dom4j").equals(mode)){
		if(inputKeysColumns.size() !=0){

    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    		}
		if(("true").equals(outputAsXSD)){

    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(fileNameXSD);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    
		}

    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    
		}

    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
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
    
		if(("true").equals(removeHeader)){

    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    
		}else{
            if(destination!=null && (destination.indexOf("tCouchbaseOutput_")==0) || destination.indexOf("tCouchDBOutput_")==0){

    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(destination);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    
            }else{
				if(istWriteJSONField){
					
    stringBuffer.append(TEXT_345);
    stringBuffer.append( rowStructNameOutput );
    stringBuffer.append(TEXT_346);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append( rowStructNameOutput );
    stringBuffer.append(TEXT_348);
    
					      for(Map<String,String> map : groupbys){
								String groupByColumnName = map.get("INPUT_COLUMN");
								String outputColumnName = map.get("OUTPUT_COLUMN");
								if (!outputColumnName.equals(jsonField)) {
								
    stringBuffer.append(TEXT_349);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append( outputColumnName );
    stringBuffer.append(TEXT_351);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append( groupByColumnName );
    stringBuffer.append(TEXT_353);
    
								}
					     }
					
    stringBuffer.append(TEXT_354);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_355);
    stringBuffer.append( jsonField );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_359);
    
				}else{
								
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    
				}
            }
		}

    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    
		if(istWriteJSONField){
			
    stringBuffer.append(TEXT_377);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append( rowNameInput );
    stringBuffer.append(TEXT_379);
    
		}
		if(inputKeysColumns.size() !=0){

    stringBuffer.append(TEXT_380);
    
		}

    stringBuffer.append(TEXT_381);
    
	//init the generate tool.
	GenerateToolByDom4j generateToolByDom4j = new GenerateToolByDom4j();
    if(("true").equals(outputAsXSD)){
    	generateToolByDom4j.outputAsXSD = true;
    }
    if(("true").equals(allowEmpty)){
    	generateToolByDom4j.allowEmpty = true;
    }
    generateToolByDom4j.cid = cid;
    generateToolByDom4j.tool = tool;
    
    //start generate code
    if(destination!=null && (destination.indexOf("tCouchbaseOutput_")==0 || destination.indexOf("tCouchDBOutput_")==0)){
        INode previousNode = conn.getSource();
        List<IMetadataTable> previous_metadatas = previousNode.getMetadataList();
        if ((previous_metadatas!=null)&&(previous_metadatas.size()>0)) {
            IMetadataTable previous_metadata = previous_metadatas.get(0);
            if (previous_metadata!=null) {
                List<IMetadataColumn> columnList = previous_metadata.getListColumns();

    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    
                for(IMetadataColumn colum: columnList){

    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(colum.getLabel());
    stringBuffer.append(TEXT_386);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_387);
    stringBuffer.append(colum.getLabel());
    stringBuffer.append(TEXT_388);
    
                }
            }
        }
    }

    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    
	generateToolByDom4j.generateCode(root,"root","doc");

    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_398);
    
	}
	for(int i=0;i<groupList.size();i++){
		XMLNode groupRootNode = groupList.get(i);

    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_403);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);
			if(attr.relatedColumn!=null){

    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_410);
    tool.getValue(attr);
    stringBuffer.append(TEXT_411);
    tool.getValue(attr);
    stringBuffer.append(TEXT_412);
    
			}
		}

    stringBuffer.append(TEXT_413);
    
		generateToolByDom4j.generateCode(groupList.get(i),"group"+i+"_","subTreeRootParent");

    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_419);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);

    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_422);
    tool.getValue(attr);
    stringBuffer.append(TEXT_423);
    
		}

    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_436);
    
	}

    stringBuffer.append(TEXT_437);
    
	generateToolByDom4j.generateCode(loop,"loop","subTreeRootParent");
}
// ------------------- *** Dom4j generation mode end *** ------------------- //

// ------------------- *** Null generation mode start *** ------------------- //
else if(("Null").equals(mode)){
//	String fileNameXSD = ElementParameterParser.getValue(node, "__XSD_FILE__");
	//init the generate tool.
	GenerateToolByNull generateToolByNull = new GenerateToolByNull();
    if(("true").equals(outputAsXSD)){
    	generateToolByNull.outputAsXSD = true;
    	generateToolByNull.fileNameXSD = fileNameXSD;
    }
    if(("true").equals(allowEmpty)){
    	generateToolByNull.allowEmpty = true;
    }
    generateToolByNull.cid = cid;
    generateToolByNull.tool = tool;

	if(inputKeysColumns.size() !=0){
	
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_440);
    	}
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_463);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    
		}else{
			if(loopTable.size()>0){

    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_492);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    
			}
		}

    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_514);
    
	if(!("true").equals(removeHeader)){

    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_519);
    
	}

    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    	if(inputKeysColumns.size() !=0){
    stringBuffer.append(TEXT_525);
    	}
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    
	String rootEmptySpace = "";
	for(int i=0;i<mainList.size();i++){
		generateToolByNull.generateCode(mainList.get(i),rootEmptySpace);
		rootEmptySpace+=whiteSpace;
		
		if(!generateToolByNull.outputAsXSD && !generateToolByNull.allowEmpty){
			if(mainList.get(i).relatedColumn != null || mainList.get(i).childrenColumnList.size()>0){

    stringBuffer.append(TEXT_531);
    
                	for(IMetadataColumn column : mainList.get(i).childrenColumnList){
                		
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_534);
    
                	}

    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_537);
    
			}
		}

    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_539);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    

	}

    stringBuffer.append(TEXT_543);
    
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(groupList.size());
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(groupList.size());
    stringBuffer.append(TEXT_549);
    
	}
	for(int i=0;i<groupList.size();i++){
		XMLNode groupRootNode = groupList.get(i);

    stringBuffer.append(TEXT_550);
    stringBuffer.append(groupRootNode.name);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_554);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_555);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);
			if(attr.relatedColumn!=null){

    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_562);
    tool.getValue(attr);
    stringBuffer.append(TEXT_563);
    tool.getValue(attr);
    stringBuffer.append(TEXT_564);
    
			}
		}

    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_574);
    
		for(int j=0;j<groupbyNodeList.get(i).size();j++){
			XMLNode attr = groupbyNodeList.get(i).get(j);

    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_577);
    tool.getValue(attr);
    stringBuffer.append(TEXT_578);
    
		}

    stringBuffer.append(TEXT_579);
    
		String emptySpace = "";
		for(int len = groupList.get(i).path.split("/").length-1;len>1;len--){
			emptySpace +=whiteSpace;
		}
		generateToolByNull.generateCode(groupList.get(i),emptySpace);
		
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){
			if((groupList.get(i).relatedColumn != null || groupList.get(i).childrenColumnList.size()>0)){

    stringBuffer.append(TEXT_580);
    
            	for(IMetadataColumn column : groupList.get(i).childrenColumnList){
            		
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_583);
    
            	}

    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(i+mainList.size());
    stringBuffer.append(TEXT_586);
    
			}
		}

    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    
	}//End of groupList loop
	
	if(groupTable.size()>0){

    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    
		}else{

    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
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
    
		}
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_642);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    
		}

    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_661);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    
		if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_666);
    
		}

    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_676);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_684);
    stringBuffer.append(mainList.size());
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    
	}
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(mainList.size()-1);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(mainList.size()-1);
    stringBuffer.append(TEXT_695);
    
	}

    stringBuffer.append(TEXT_696);
    
	String emptySpace = "";
	for(int len =loop.path.split("/").length-1;len>1;len--){
		emptySpace +=whiteSpace;
	}
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_697);
    
    	for(IMetadataColumn column : loop.childrenColumnList){
    		
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_700);
    
    	}
    	if(loop.hasDefaultValue == true){
    stringBuffer.append(TEXT_701);
    }
    stringBuffer.append(TEXT_702);
    
	}
	generateToolByNull.generateCode(loop,emptySpace);
	generateToolByNull.endElement(loop,emptySpace);

    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_717);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(groupList.size()+mainList.size());
    stringBuffer.append(TEXT_720);
    
	if(!("true").equals(outputAsXSD) && !("true").equals(allowEmpty)){

    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(groupList.size()+mainList.size()-1);
    stringBuffer.append(TEXT_723);
    
	}
}
// ------------------- *** Null generation mode end *** ------------------- //

// ------------------- *** Common code start *** ------------------- //
			}
		}
	}
}
// ------------------- *** Common code end *** ------------------- //

    stringBuffer.append(TEXT_724);
    return stringBuffer.toString();
  }
}
