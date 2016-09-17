package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;
import java.util.Map;

public class TFileInputPositionalBeginJava
{
  protected static String nl;
  public static synchronized TFileInputPositionalBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputPositionalBeginJava result = new TFileInputPositionalBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_31 = " = (routines.system.Dynamic)globalMap.get(\"";
  protected final String TEXT_32 = "\");" + NL + "\t\t\t\tint maxColumnCount_";
  protected final String TEXT_33 = " = dynamic_";
  protected final String TEXT_34 = ".getColumnCount();" + NL + "\t\t\t\tdynamic_";
  protected final String TEXT_35 = ".clearColumnValues();" + NL + "\t\t\t";
  protected final String TEXT_36 = NL + "            int nb_line_";
  protected final String TEXT_37 = " = 0;" + NL + "            int footer_";
  protected final String TEXT_38 = "  = ";
  protected final String TEXT_39 = ";" + NL + "            int nb_limit_";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ";" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "                class Arrays_";
  protected final String TEXT_43 = "{" + NL + "                    public byte[] copyOfRange(byte[] original, int from, int to) {" + NL + "                        int newLength = to - from;" + NL + "                        if (newLength < 0)" + NL + "                            throw new IllegalArgumentException(from + \" > \" + to);" + NL + "                        byte[] copy = new byte[newLength];" + NL + "                        System.arraycopy(original, from, copy, 0," + NL + "                                         Math.min(original.length - from, newLength));" + NL + "                        return copy;" + NL + "                    }" + NL + "                }" + NL + "                Arrays_";
  protected final String TEXT_44 = " arrays_";
  protected final String TEXT_45 = " = new Arrays_";
  protected final String TEXT_46 = "();" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + NL + "\t\t\tclass PositionalUtil_";
  protected final String TEXT_48 = "{";
  protected final String TEXT_49 = NL + "                  \t\t\t\t\t\tvoid setValue_";
  protected final String TEXT_50 = "(";
  protected final String TEXT_51 = "Struct ";
  protected final String TEXT_52 = ",int[] begins_";
  protected final String TEXT_53 = ",int[] ends_";
  protected final String TEXT_54 = ",int rowLen_";
  protected final String TEXT_55 = "," + NL + "                  \t\t\t\t\t\t";
  protected final String TEXT_56 = "byte[] byteArray_";
  protected final String TEXT_57 = ",Arrays_";
  protected final String TEXT_58 = " arrays_";
  protected final String TEXT_59 = ",";
  protected final String TEXT_60 = "String column_";
  protected final String TEXT_61 = ",String row_";
  protected final String TEXT_62 = ")throws java.lang.Exception {             " + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_63 = NL + "    \t\t\t\t\t\t\t\t\tif(begins_";
  protected final String TEXT_64 = "[";
  protected final String TEXT_65 = "] < rowLen_";
  protected final String TEXT_66 = "){" + NL + "        \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_67 = NL + "                                            \tbyteArray_";
  protected final String TEXT_68 = "=arrays_";
  protected final String TEXT_69 = ".copyOfRange(row_";
  protected final String TEXT_70 = ".getBytes(";
  protected final String TEXT_71 = "),begins_";
  protected final String TEXT_72 = "[";
  protected final String TEXT_73 = "],rowLen_";
  protected final String TEXT_74 = ");" + NL + "                                            \tcolumn_";
  protected final String TEXT_75 = " = TalendString.talendTrim(new String(byteArray_";
  protected final String TEXT_76 = ",";
  protected final String TEXT_77 = "), ";
  protected final String TEXT_78 = ", ";
  protected final String TEXT_79 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_81 = " = TalendString.talendTrim(row_";
  protected final String TEXT_82 = ".substring(begins_";
  protected final String TEXT_83 = "[";
  protected final String TEXT_84 = "]), ";
  protected final String TEXT_85 = ", ";
  protected final String TEXT_86 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_87 = NL + "                                        }else{" + NL + "                                        \tcolumn_";
  protected final String TEXT_88 = " = \"\";" + NL + "                                        }" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t\t\t\t\t\t\t\tif(begins_";
  protected final String TEXT_90 = "[";
  protected final String TEXT_91 = "] < rowLen_";
  protected final String TEXT_92 = "){" + NL + "        \t\t\t\t\t\t\t\t\t\tif(ends_";
  protected final String TEXT_93 = "[";
  protected final String TEXT_94 = "] <= rowLen_";
  protected final String TEXT_95 = "){" + NL + "        \t\t\t\t\t\t\t\t\t\t\tbyteArray_";
  protected final String TEXT_96 = " = arrays_";
  protected final String TEXT_97 = ".copyOfRange(row_";
  protected final String TEXT_98 = ".getBytes(";
  protected final String TEXT_99 = "),begins_";
  protected final String TEXT_100 = "[";
  protected final String TEXT_101 = "],ends_";
  protected final String TEXT_102 = "[";
  protected final String TEXT_103 = "]);" + NL + "        \t\t\t\t\t\t\t\t\t\t}else{" + NL + "        \t\t\t\t\t\t\t\t\t\t\tbyteArray_";
  protected final String TEXT_104 = " = arrays_";
  protected final String TEXT_105 = ".copyOfRange(row_";
  protected final String TEXT_106 = ".getBytes(";
  protected final String TEXT_107 = "),begins_";
  protected final String TEXT_108 = "[";
  protected final String TEXT_109 = "],rowLen_";
  protected final String TEXT_110 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_111 = " = TalendString.talendTrim(new String(byteArray_";
  protected final String TEXT_112 = ",";
  protected final String TEXT_113 = "), ";
  protected final String TEXT_114 = ", ";
  protected final String TEXT_115 = ");" + NL + "    \t\t\t\t\t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_116 = " = \"\";" + NL + "    \t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\t\t\t\t\t\t\t\tif(begins_";
  protected final String TEXT_118 = "[";
  protected final String TEXT_119 = "] < rowLen_";
  protected final String TEXT_120 = "){" + NL + "        \t\t\t\t\t\t\t\t\t\tif(ends_";
  protected final String TEXT_121 = "[";
  protected final String TEXT_122 = "] <= rowLen_";
  protected final String TEXT_123 = "){" + NL + "        \t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_124 = " = TalendString.talendTrim(row_";
  protected final String TEXT_125 = ".substring(begins_";
  protected final String TEXT_126 = "[";
  protected final String TEXT_127 = "], ends_";
  protected final String TEXT_128 = "[";
  protected final String TEXT_129 = "]), ";
  protected final String TEXT_130 = ", ";
  protected final String TEXT_131 = ");" + NL + "        \t\t\t\t\t\t\t\t\t\t}else{" + NL + "        \t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_132 = " = TalendString.talendTrim(row_";
  protected final String TEXT_133 = ".substring(begins_";
  protected final String TEXT_134 = "[";
  protected final String TEXT_135 = "]), ";
  protected final String TEXT_136 = ", ";
  protected final String TEXT_137 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_138 = " = \"\";" + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t\t\t\t\t\t\t\tcolumn_";
  protected final String TEXT_140 = " = column_";
  protected final String TEXT_141 = ".trim();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = " = column_";
  protected final String TEXT_145 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_146 = NL + "                \t\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_147 = " = (routines.system.Dynamic)globalMap.get(\"";
  protected final String TEXT_148 = "\");" + NL + "                \t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_149 = ".clearColumnValues();" + NL + "\t\t\t\t\t\t\t\t\t\t\tint maxColumnCount_";
  protected final String TEXT_150 = " = dynamic_";
  protected final String TEXT_151 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t\t\t\tint substringBegin";
  protected final String TEXT_152 = " = begins_";
  protected final String TEXT_153 = "[";
  protected final String TEXT_154 = "]; int substringEnd";
  protected final String TEXT_155 = " =0;" + NL + "\t\t\t\t\t\t\t\t\t\t\tfor (int i";
  protected final String TEXT_156 = "=0;i";
  protected final String TEXT_157 = "<maxColumnCount_";
  protected final String TEXT_158 = ";i";
  protected final String TEXT_159 = "++) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadataColumn_";
  protected final String TEXT_160 = " = dynamic_";
  protected final String TEXT_161 = ".getColumnMetadata(i";
  protected final String TEXT_162 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tint currentFieldLength_";
  protected final String TEXT_163 = " = dynamicMetadataColumn_";
  protected final String TEXT_164 = ".getLength();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_165 = " = substringBegin";
  protected final String TEXT_166 = "+currentFieldLength_";
  protected final String TEXT_167 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(substringEnd";
  protected final String TEXT_168 = " > rowLen_";
  protected final String TEXT_169 = "){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_170 = " = rowLen_";
  protected final String TEXT_171 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "        \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_172 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tbyte[] temp_byteArray_";
  protected final String TEXT_173 = " = arrays_";
  protected final String TEXT_174 = ".copyOfRange(row_";
  protected final String TEXT_175 = ".getBytes(";
  protected final String TEXT_176 = "),substringBegin";
  protected final String TEXT_177 = ", substringEnd";
  protected final String TEXT_178 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_179 = " = new String(temp_byteArray_";
  protected final String TEXT_180 = ",";
  protected final String TEXT_181 = ");\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_182 = NL + "                \t\t\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_183 = " = row_";
  protected final String TEXT_184 = ".substring(substringBegin";
  protected final String TEXT_185 = ", substringEnd";
  protected final String TEXT_186 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_187 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_188 = " = TalendString.talendTrim(currentColumnValue_";
  protected final String TEXT_189 = ", ";
  protected final String TEXT_190 = ", ";
  protected final String TEXT_191 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_193 = " = currentColumnValue_";
  protected final String TEXT_194 = ".trim();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_195 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tString type_";
  protected final String TEXT_196 = " = dynamicMetadataColumn_";
  protected final String TEXT_197 = ".getType();" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tif(\"id_Short\".equals(type_";
  protected final String TEXT_198 = ") || \"id_Integer\".equals(type_";
  protected final String TEXT_199 = ") || \"id_Double\".equals(type_";
  protected final String TEXT_200 = ") || \"id_Float\".equals(type_";
  protected final String TEXT_201 = ") || \"id_Long\".equals(type_";
  protected final String TEXT_202 = ") || \"id_BigDecimal\".equals(type_";
  protected final String TEXT_203 = ")){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_204 = " = ParserUtils.parseTo_Number(currentColumnValue_";
  protected final String TEXT_205 = ", ";
  protected final String TEXT_206 = ", ";
  protected final String TEXT_207 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_208 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_209 = ".addColumnValue(currentColumnValue_";
  protected final String TEXT_210 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tsubstringBegin";
  protected final String TEXT_211 = " = substringEnd";
  protected final String TEXT_212 = "; " + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_213 = ".";
  protected final String TEXT_214 = " = dynamic_";
  protected final String TEXT_215 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_216 = NL + "\t\t\t\t\t\t\t\t\t\tif(column_";
  protected final String TEXT_217 = ".length() > 0) {" + NL + "        \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_218 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = " = ParserUtils.parseTo_Date(column_";
  protected final String TEXT_221 = ", ";
  protected final String TEXT_222 = ",false);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_223 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = " = ParserUtils.parseTo_Date(column_";
  protected final String TEXT_226 = ", ";
  protected final String TEXT_227 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_228 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_229 = ".";
  protected final String TEXT_230 = " = ParserUtils.parseTo_";
  protected final String TEXT_231 = "(ParserUtils.parseTo_Number(column_";
  protected final String TEXT_232 = ", ";
  protected final String TEXT_233 = ", ";
  protected final String TEXT_234 = "));" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_235 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_236 = ".";
  protected final String TEXT_237 = " = column_";
  protected final String TEXT_238 = ".getBytes(";
  protected final String TEXT_239 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_240 = NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_241 = ".";
  protected final String TEXT_242 = " = ParserUtils.parseTo_";
  protected final String TEXT_243 = "(column_";
  protected final String TEXT_244 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_245 = NL + "    \t\t\t\t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_246 = ".";
  protected final String TEXT_247 = " = ";
  protected final String TEXT_248 = ";" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_249 = NL + "            \t\t\t\t\t\t\t}" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_250 = NL + "                \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_251 = NL + "                            \t\t    \tint parseValue_";
  protected final String TEXT_252 = "(String row_";
  protected final String TEXT_253 = ", int substringBegin";
  protected final String TEXT_254 = ", int substringEnd";
  protected final String TEXT_255 = ", int rowLen_";
  protected final String TEXT_256 = ", String[] columnValue";
  protected final String TEXT_257 = " ";
  protected final String TEXT_258 = ", Arrays_";
  protected final String TEXT_259 = " arrays_";
  protected final String TEXT_260 = ", byte[][] byteArray_";
  protected final String TEXT_261 = ", routines.system.Dynamic dynamic_";
  protected final String TEXT_262 = ")throws java.lang.Exception{" + NL + "                            \t\t    ";
  protected final String TEXT_263 = " \t" + NL + "                            \t\t\t\tdynamic_";
  protected final String TEXT_264 = ".clearColumnValues();" + NL + "                            \t\t\t\tint maxColumnCount_";
  protected final String TEXT_265 = " = dynamic_";
  protected final String TEXT_266 = ".getColumnCount();" + NL + "                            \t\t\t\tfor (int i";
  protected final String TEXT_267 = "=0;i";
  protected final String TEXT_268 = "<maxColumnCount_";
  protected final String TEXT_269 = ";i";
  protected final String TEXT_270 = "++) {" + NL + "                            \t\t\t\t\troutines.system.DynamicMetadata dynamicMetadataColumn_";
  protected final String TEXT_271 = " = dynamic_";
  protected final String TEXT_272 = ".getColumnMetadata(i";
  protected final String TEXT_273 = ");" + NL + "                            \t\t\t\t\tint currentFieldLength_";
  protected final String TEXT_274 = " = dynamicMetadataColumn_";
  protected final String TEXT_275 = ".getLength();" + NL + "                            \t\t\t\t\tsubstringEnd";
  protected final String TEXT_276 = " = substringBegin";
  protected final String TEXT_277 = "+currentFieldLength_";
  protected final String TEXT_278 = ";" + NL + "                            \t\t\t\t\tif(substringEnd";
  protected final String TEXT_279 = " > rowLen_";
  protected final String TEXT_280 = "){" + NL + "                            \t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_281 = " = rowLen_";
  protected final String TEXT_282 = ";" + NL + "                            \t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_283 = NL + "                        \t\t\t\t\t\t\tbyte[] temp_byteArray_";
  protected final String TEXT_284 = "= arrays_";
  protected final String TEXT_285 = ".copyOfRange(row_";
  protected final String TEXT_286 = ".getBytes(";
  protected final String TEXT_287 = "),substringBegin";
  protected final String TEXT_288 = ", substringEnd";
  protected final String TEXT_289 = ");" + NL + "    \t                    \t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_290 = " = new String(temp_byteArray_";
  protected final String TEXT_291 = ",";
  protected final String TEXT_292 = ");\t\t\t\t\t\t" + NL + "    \t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_293 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_294 = " = row_";
  protected final String TEXT_295 = ".substring(substringBegin";
  protected final String TEXT_296 = ", substringEnd";
  protected final String TEXT_297 = ");" + NL + "    \t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_298 = "\t\t\t" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_299 = " = currentColumnValue_";
  protected final String TEXT_300 = ".trim();" + NL + "    \t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_301 = " " + NL + "    \t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_302 = " = TalendString.talendTrim(currentColumnValue_";
  protected final String TEXT_303 = ", ";
  protected final String TEXT_304 = ", ";
  protected final String TEXT_305 = ");" + NL + "    \t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_306 = NL + "                            \t\t\t\t\t\tString type_";
  protected final String TEXT_307 = " = dynamicMetadataColumn_";
  protected final String TEXT_308 = ".getType();" + NL + "                            \t\t\t\t\t\tif(\"id_Short\".equals(type_";
  protected final String TEXT_309 = ") || \"id_Integer\".equals(type_";
  protected final String TEXT_310 = ") || \"id_Double\".equals(type_";
  protected final String TEXT_311 = ") || \"id_Float\".equals(type_";
  protected final String TEXT_312 = ") || \"id_Long\".equals(type_";
  protected final String TEXT_313 = ") || \"id_BigDecimal\".equals(type_";
  protected final String TEXT_314 = ")){" + NL + "                            \t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_315 = " = ParserUtils.parseTo_Number(currentColumnValue_";
  protected final String TEXT_316 = ", ";
  protected final String TEXT_317 = ", ";
  protected final String TEXT_318 = ");" + NL + "    \t                    \t\t\t\t\t\t}\t" + NL + "    \t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_319 = NL + "                            \t\t\t\t\tdynamic_";
  protected final String TEXT_320 = ".addColumnValue(currentColumnValue_";
  protected final String TEXT_321 = ");" + NL + "                            \t\t\t\t\tsubstringBegin";
  protected final String TEXT_322 = " = substringEnd";
  protected final String TEXT_323 = ";" + NL + "    \t\t\t\t\t\t\t\t\t\t}" + NL + "                        \t\t\t\t";
  protected final String TEXT_324 = "\t" + NL + "    \t\t\t\t\t\t\t\t\t\tcolumnValue";
  protected final String TEXT_325 = "[";
  protected final String TEXT_326 = "]=\"\";" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_327 = NL + "                                \t\t    if(substringBegin";
  protected final String TEXT_328 = " >= rowLen_";
  protected final String TEXT_329 = "){" + NL + "                                \t\t    \tcolumnValue";
  protected final String TEXT_330 = "[";
  protected final String TEXT_331 = "]= \"\";" + NL + "                                    \t\t}else{" + NL + "        \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_332 = NL + "            \t\t\t \t\t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_333 = "=rowLen_";
  protected final String TEXT_334 = ";" + NL + "        \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_335 = NL + "                \t\t\t\t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_336 = " = substringEnd";
  protected final String TEXT_337 = " + ";
  protected final String TEXT_338 = ";" + NL + "                " + NL + "                            \t\t\t\t        if(substringEnd";
  protected final String TEXT_339 = " > rowLen_";
  protected final String TEXT_340 = "){" + NL + "                            \t\t\t\t        \tsubstringEnd";
  protected final String TEXT_341 = " = rowLen_";
  protected final String TEXT_342 = ";" + NL + "                            \t\t\t\t    \t}" + NL + "        \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_343 = NL + "                                \t\t\t\t\tbyteArray_";
  protected final String TEXT_344 = "[";
  protected final String TEXT_345 = "] = arrays_";
  protected final String TEXT_346 = ".copyOfRange(row_";
  protected final String TEXT_347 = ".getBytes(";
  protected final String TEXT_348 = "),substringBegin";
  protected final String TEXT_349 = ", substringEnd";
  protected final String TEXT_350 = ");" + NL + "                                \t\t\t\t\tcolumnValue";
  protected final String TEXT_351 = "[";
  protected final String TEXT_352 = "] = new String(byteArray_";
  protected final String TEXT_353 = "[";
  protected final String TEXT_354 = "],";
  protected final String TEXT_355 = ");" + NL + "        \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_356 = NL + "                \t\t\t\t\t\t\t\t\tcolumnValue";
  protected final String TEXT_357 = "[";
  protected final String TEXT_358 = "] = row_";
  protected final String TEXT_359 = ".substring(substringBegin";
  protected final String TEXT_360 = ", substringEnd";
  protected final String TEXT_361 = ");" + NL + "        \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_362 = NL + "        \t\t\t\t\t\t\t\t\t\t\tcolumnValue";
  protected final String TEXT_363 = "[";
  protected final String TEXT_364 = "] = columnValue";
  protected final String TEXT_365 = "[";
  protected final String TEXT_366 = "].trim();" + NL + "        \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_367 = "    \t" + NL + "                \t\t\t\t\t\t\t\tsubstringBegin";
  protected final String TEXT_368 = " = substringEnd";
  protected final String TEXT_369 = ";" + NL + "        \t\t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_370 = NL + "                            \t\t    \t\treturn substringBegin";
  protected final String TEXT_371 = ";" + NL + "                            \t\t    \t}" + NL + "                        \t\t    \t";
  protected final String TEXT_372 = NL + "    \t\t\t\t\t\t\t\t\t\treturn substringBegin";
  protected final String TEXT_373 = ";" + NL + "                         \t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_374 = NL + "                                    \tvoid setValue_";
  protected final String TEXT_375 = "(";
  protected final String TEXT_376 = "Struct ";
  protected final String TEXT_377 = ",String[] columnValue";
  protected final String TEXT_378 = ")throws java.lang.Exception{" + NL + "                \t\t\t\t\t";
  protected final String TEXT_379 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_380 = NL + "\t                    \t\t\t\t";
  protected final String TEXT_381 = ".";
  protected final String TEXT_382 = " = columnValue";
  protected final String TEXT_383 = "[";
  protected final String TEXT_384 = "];" + NL + "\t\t\t\t\t                ";
  protected final String TEXT_385 = NL + "\t                    \t\t\t\tif(columnValue";
  protected final String TEXT_386 = "[";
  protected final String TEXT_387 = "].length() > 0) {" + NL + "\t\t\t\t\t\t                \t";
  protected final String TEXT_388 = "\t" + NL + "\t\t                            \t\t\t\t";
  protected final String TEXT_389 = ".";
  protected final String TEXT_390 = " = ParserUtils.parseTo_Date(columnValue";
  protected final String TEXT_391 = "[";
  protected final String TEXT_392 = "], ";
  protected final String TEXT_393 = ",false);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_394 = NL + "\t\t                            \t\t\t\t";
  protected final String TEXT_395 = ".";
  protected final String TEXT_396 = " = ParserUtils.parseTo_Date(columnValue";
  protected final String TEXT_397 = "[";
  protected final String TEXT_398 = "], ";
  protected final String TEXT_399 = ");\t" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_400 = NL + "\t\t                        \t\t\t\t";
  protected final String TEXT_401 = ".";
  protected final String TEXT_402 = " = ParserUtils.parseTo_";
  protected final String TEXT_403 = "(ParserUtils.parseTo_Number(columnValue";
  protected final String TEXT_404 = "[";
  protected final String TEXT_405 = "], ";
  protected final String TEXT_406 = ", ";
  protected final String TEXT_407 = "));" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_408 = "\t" + NL + "\t\t                        \t\t\t\t";
  protected final String TEXT_409 = ".";
  protected final String TEXT_410 = " = columnValue";
  protected final String TEXT_411 = "[";
  protected final String TEXT_412 = "].getBytes(";
  protected final String TEXT_413 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_414 = "\t" + NL + "\t\t                        \t\t\t\t";
  protected final String TEXT_415 = ".";
  protected final String TEXT_416 = " = ParserUtils.parseTo_";
  protected final String TEXT_417 = "(columnValue";
  protected final String TEXT_418 = "[";
  protected final String TEXT_419 = "].trim());" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_420 = NL + "                        \t\t\t\t}else{" + NL + "        \t                \t\t\t\t";
  protected final String TEXT_421 = ".";
  protected final String TEXT_422 = " = ";
  protected final String TEXT_423 = ";" + NL + "                        \t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_424 = NL + "\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_425 = NL + "                     \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_426 = NL + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_427 = NL + "                     \t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_428 = NL + "\t" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_429 = NL + "\t\t\t}" + NL + "" + NL + "\t\t\tPositionalUtil_";
  protected final String TEXT_430 = " positionalUtil_";
  protected final String TEXT_431 = "=new PositionalUtil_";
  protected final String TEXT_432 = "();" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_433 = NL + NL + "                int[] sizes_";
  protected final String TEXT_434 = " = new int[";
  protected final String TEXT_435 = "];" + NL + "                int[] begins_";
  protected final String TEXT_436 = " = new int[";
  protected final String TEXT_437 = "];" + NL + "                int[] ends_";
  protected final String TEXT_438 = " = new int[";
  protected final String TEXT_439 = "];" + NL + "\t\t\t\t";
  protected final String TEXT_440 = NL + "\t\t\t\t\t\tsizes_";
  protected final String TEXT_441 = "[";
  protected final String TEXT_442 = "] = ";
  protected final String TEXT_443 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_444 = NL + "\t\t\t\t\t\tsizes_";
  protected final String TEXT_445 = "[";
  protected final String TEXT_446 = "] = ";
  protected final String TEXT_447 = ";\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_448 = NL + "\t\t\t\t\t\tbegins_";
  protected final String TEXT_449 = "[";
  protected final String TEXT_450 = "] = 0;" + NL + "\t\t\t\t\t\tends_";
  protected final String TEXT_451 = "[";
  protected final String TEXT_452 = "] = sizes_";
  protected final String TEXT_453 = "[";
  protected final String TEXT_454 = "];" + NL + "\t\t\t\t\t";
  protected final String TEXT_455 = NL + "\t\t\t\t\t\tbegins_";
  protected final String TEXT_456 = "[";
  protected final String TEXT_457 = "] = begins_";
  protected final String TEXT_458 = "[";
  protected final String TEXT_459 = "] + sizes_";
  protected final String TEXT_460 = "[";
  protected final String TEXT_461 = "];" + NL + "\t\t\t\t\t\tends_";
  protected final String TEXT_462 = "[";
  protected final String TEXT_463 = "] = -1;" + NL + "\t\t\t\t\t";
  protected final String TEXT_464 = NL + "                        begins_";
  protected final String TEXT_465 = "[";
  protected final String TEXT_466 = "] = begins_";
  protected final String TEXT_467 = "[";
  protected final String TEXT_468 = "] + sizes_";
  protected final String TEXT_469 = "[";
  protected final String TEXT_470 = "];" + NL + "                        ends_";
  protected final String TEXT_471 = "[";
  protected final String TEXT_472 = "] = ends_";
  protected final String TEXT_473 = "[";
  protected final String TEXT_474 = "] + sizes_";
  protected final String TEXT_475 = "[";
  protected final String TEXT_476 = "];" + NL + "\t\t\t\t\t";
  protected final String TEXT_477 = NL + "            Object filename_";
  protected final String TEXT_478 = " = ";
  protected final String TEXT_479 = ";" + NL + "            java.io.BufferedReader in_";
  protected final String TEXT_480 = " = null;" + NL + "            org.talend.fileprocess.delimited.RowParser reader_";
  protected final String TEXT_481 = " = null; " + NL + "" + NL + "\t\t\t";
  protected final String TEXT_482 = NL + NL + "\t\t\t";
  protected final String TEXT_483 = NL + "                java.util.zip.ZipInputStream zis_";
  protected final String TEXT_484 = " = null;" + NL + "                try {" + NL + "                \tif(filename_";
  protected final String TEXT_485 = " instanceof java.io.InputStream){" + NL + "                \t\tzis_";
  protected final String TEXT_486 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream((java.io.InputStream)filename_";
  protected final String TEXT_487 = "));" + NL + "                \t}else{" + NL + "                \t\tzis_";
  protected final String TEXT_488 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_489 = "))));" + NL + "                \t}" + NL + "                } catch(java.lang.Exception e) {" + NL + "                \t";
  protected final String TEXT_490 = NL + "                \t\tthrow e;" + NL + "                \t";
  protected final String TEXT_491 = NL + "                \t\t";
  protected final String TEXT_492 = NL + "                \t\t\tlog.error(\"";
  protected final String TEXT_493 = " - \" +e.getMessage());" + NL + "                \t\t";
  protected final String TEXT_494 = NL + "                \t\t\tSystem.err.println(e.getMessage());" + NL + "                \t";
  protected final String TEXT_495 = NL + "                }" + NL + "                java.util.zip.ZipEntry entry_";
  protected final String TEXT_496 = " = null;" + NL + "                while (true) {" + NL + "                \ttry {" + NL + "                \t\tentry_";
  protected final String TEXT_497 = " = zis_";
  protected final String TEXT_498 = ".getNextEntry();" + NL + "                \t} catch(java.lang.Exception e) {" + NL + "                \t\t";
  protected final String TEXT_499 = NL + "                \t\t\tthrow e;" + NL + "                \t\t";
  protected final String TEXT_500 = NL + "                \t\t\t";
  protected final String TEXT_501 = NL + "                \t\t\t\tlog.error(\"";
  protected final String TEXT_502 = " - \" +e.getMessage());" + NL + "                \t\t\t";
  protected final String TEXT_503 = NL + "                    \t\tSystem.err.println(e.getMessage());" + NL + "                    \t\tbreak;" + NL + "                \t\t";
  protected final String TEXT_504 = NL + "                \t}" + NL + "                \tif(entry_";
  protected final String TEXT_505 = " == null) {" + NL + "                \t\tbreak;" + NL + "                \t}" + NL + "                \tif(entry_";
  protected final String TEXT_506 = ".isDirectory()){ //directory" + NL + "                \t\tcontinue;" + NL + "                \t}" + NL + "                \tString row_";
  protected final String TEXT_507 = " = null;" + NL + "                \tint rowLen_";
  protected final String TEXT_508 = " = 0;" + NL + "                \t";
  protected final String TEXT_509 = NL + "                \t\t\tbyte[] byteArray_";
  protected final String TEXT_510 = " = new byte[0];" + NL + "                    \t";
  protected final String TEXT_511 = NL + "                \t\tString column_";
  protected final String TEXT_512 = " = null;" + NL + "                \t";
  protected final String TEXT_513 = NL + "                \t\t\tbyte[][] byteArray_";
  protected final String TEXT_514 = " = new byte[";
  protected final String TEXT_515 = "][];" + NL + "                \t\t";
  protected final String TEXT_516 = NL + "                \t\tString[] columnValue";
  protected final String TEXT_517 = "=new String[";
  protected final String TEXT_518 = "];" + NL + "                \t";
  protected final String TEXT_519 = NL + "                \ttry {//TD110 begin" + NL + "                \t\tin_";
  protected final String TEXT_520 = " = new java.io.BufferedReader(new java.io.InputStreamReader(zis_";
  protected final String TEXT_521 = ", ";
  protected final String TEXT_522 = "));" + NL + "    \t\t";
  protected final String TEXT_523 = NL + "                String row_";
  protected final String TEXT_524 = " = null;" + NL + "                int rowLen_";
  protected final String TEXT_525 = " = 0;";
  protected final String TEXT_526 = NL + "            \t\t\tbyte[] byteArray_";
  protected final String TEXT_527 = " = new byte[0];";
  protected final String TEXT_528 = NL + "\t\t\t\t\tString column_";
  protected final String TEXT_529 = " = null;";
  protected final String TEXT_530 = NL + "\t\t                byte[][] byteArray_";
  protected final String TEXT_531 = " = new byte[";
  protected final String TEXT_532 = "][];" + NL + "        \t        ";
  protected final String TEXT_533 = NL + "                \tString[] columnValue";
  protected final String TEXT_534 = "=new String[";
  protected final String TEXT_535 = "];";
  protected final String TEXT_536 = " " + NL + "                try {//TD110 begin" + NL + "                \tif(filename_";
  protected final String TEXT_537 = " instanceof java.io.InputStream){" + NL + "                \t\tin_";
  protected final String TEXT_538 = " = " + NL + "                \t\t\t\tnew java.io.BufferedReader(new java.io.InputStreamReader((java.io.InputStream)filename_";
  protected final String TEXT_539 = ", ";
  protected final String TEXT_540 = "));" + NL + "                \t}else{" + NL + "                \t\tin_";
  protected final String TEXT_541 = " = " + NL + "                \t\t\tnew java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_542 = ")), ";
  protected final String TEXT_543 = "));" + NL + "                \t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_544 = NL + "\t\t\t\tint rowLength_";
  protected final String TEXT_545 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_546 = NL + "\t\t\t\t\t\trowLength_";
  protected final String TEXT_547 = " += sizes_";
  protected final String TEXT_548 = "[";
  protected final String TEXT_549 = "];" + NL + "\t\t\t\t\t";
  protected final String TEXT_550 = NL + "\t\t\t\t\t\trowLength_";
  protected final String TEXT_551 = " += ";
  protected final String TEXT_552 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_553 = NL + "\t\t\t\treader_";
  protected final String TEXT_554 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_555 = ", rowLength_";
  protected final String TEXT_556 = ");" + NL + "\t\t\t";
  protected final String TEXT_557 = NL + "\t\t\t\treader_";
  protected final String TEXT_558 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_559 = ", ";
  protected final String TEXT_560 = ", ";
  protected final String TEXT_561 = ");" + NL + "\t\t\t";
  protected final String TEXT_562 = NL + "            reader_";
  protected final String TEXT_563 = ".setSafetySwitch(";
  protected final String TEXT_564 = ");" + NL + "            reader_";
  protected final String TEXT_565 = ".skipHeaders(";
  protected final String TEXT_566 = ");" + NL + "            if(footer_";
  protected final String TEXT_567 = " > 0){" + NL + "            \tint available_";
  protected final String TEXT_568 = " = (int)reader_";
  protected final String TEXT_569 = ".getAvailableRowCount(footer_";
  protected final String TEXT_570 = ");" + NL + "            \treader_";
  protected final String TEXT_571 = ".close();" + NL + "            \tif(filename_";
  protected final String TEXT_572 = " instanceof java.io.InputStream){" + NL + "            \t\tin_";
  protected final String TEXT_573 = " = new java.io.BufferedReader(new java.io.InputStreamReader((java.io.InputStream)filename_";
  protected final String TEXT_574 = ", ";
  protected final String TEXT_575 = "));" + NL + "            \t}else{" + NL + "            \t\tin_";
  protected final String TEXT_576 = " = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_577 = ")), ";
  protected final String TEXT_578 = "));" + NL + "            \t}" + NL + "\t\t\t\t";
  protected final String TEXT_579 = NL + "\t\t\t\t\treader_";
  protected final String TEXT_580 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_581 = ", rowLength_";
  protected final String TEXT_582 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_583 = NL + "\t\t\t\t\treader_";
  protected final String TEXT_584 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_585 = ", ";
  protected final String TEXT_586 = ", ";
  protected final String TEXT_587 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_588 = "\t" + NL + "\t\t\t\treader_";
  protected final String TEXT_589 = ".skipHeaders(";
  protected final String TEXT_590 = ");" + NL + "\t" + NL + "            \tif ( nb_limit_";
  protected final String TEXT_591 = " >= 0 ){" + NL + "            \t\tnb_limit_";
  protected final String TEXT_592 = " = ( nb_limit_";
  protected final String TEXT_593 = " > available_";
  protected final String TEXT_594 = ") ? available_";
  protected final String TEXT_595 = " : nb_limit_";
  protected final String TEXT_596 = ";" + NL + "            \t}else{" + NL + "            \t\tnb_limit_";
  protected final String TEXT_597 = " = available_";
  protected final String TEXT_598 = ";" + NL + "            \t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t} catch(java.lang.Exception e) {//TD110 end" + NL + "        \t";
  protected final String TEXT_599 = NL + "        \t\tthrow e;" + NL + "        \t";
  protected final String TEXT_600 = NL + "        \t\t";
  protected final String TEXT_601 = NL + "        \t\t\tlog.error(\"";
  protected final String TEXT_602 = " - \" +e.getMessage());" + NL + "        \t\t";
  protected final String TEXT_603 = NL + "    \t\t\tSystem.err.println(e.getMessage());" + NL + "        \t";
  protected final String TEXT_604 = NL + "        }" + NL;
  protected final String TEXT_605 = NL + "        \t\tString arrFieldSeparator";
  protected final String TEXT_606 = "[] = \"";
  protected final String TEXT_607 = "\".split(\",\");" + NL + "        \t";
  protected final String TEXT_608 = "\t\t" + NL + "        \t\tString arrFieldSeparator";
  protected final String TEXT_609 = "[] = ";
  protected final String TEXT_610 = ".split(\",\");" + NL + "        \t";
  protected final String TEXT_611 = " " + NL + "" + NL + "            Integer star_";
  protected final String TEXT_612 = " = Integer.valueOf(-1);\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "            Integer[] tmpAry_";
  protected final String TEXT_613 = " = new Integer[arrFieldSeparator";
  protected final String TEXT_614 = ".length];\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "            for (int i";
  protected final String TEXT_615 = " = 0; i";
  protected final String TEXT_616 = " < arrFieldSeparator";
  protected final String TEXT_617 = ".length; i";
  protected final String TEXT_618 = "++ ){\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "            \tif ((\"*\").equals(arrFieldSeparator";
  protected final String TEXT_619 = "[i";
  protected final String TEXT_620 = "])) {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "            \t\ttmpAry_";
  protected final String TEXT_621 = "[i";
  protected final String TEXT_622 = "] = star_";
  protected final String TEXT_623 = ";\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "            \t}else{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "            \t\ttmpAry_";
  protected final String TEXT_624 = "[i";
  protected final String TEXT_625 = "] = Integer.parseInt(arrFieldSeparator";
  protected final String TEXT_626 = "[i";
  protected final String TEXT_627 = "]);\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "            \t}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "            }\t";
  protected final String TEXT_628 = NL + "        while (nb_limit_";
  protected final String TEXT_629 = " != 0 && reader_";
  protected final String TEXT_630 = "!=null && reader_";
  protected final String TEXT_631 = ".readRecord()) {" + NL + "        \trow_";
  protected final String TEXT_632 = " = reader_";
  protected final String TEXT_633 = ".getRowRecord();" + NL + "\t\t\t";
  protected final String TEXT_634 = NL + "\t\t\t\trowLen_";
  protected final String TEXT_635 = " = row_";
  protected final String TEXT_636 = ".getBytes(";
  protected final String TEXT_637 = ").length;" + NL + "\t\t\t";
  protected final String TEXT_638 = NL + "\t\t\t\trowLen_";
  protected final String TEXT_639 = " = row_";
  protected final String TEXT_640 = ".length();" + NL + "\t\t\t";
  protected final String TEXT_641 = NL + "\t\t\t";
  protected final String TEXT_642 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_643 = " = null;\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_644 = NL + "        \t\t\t" + NL + "            \t\t\tboolean whetherReject_";
  protected final String TEXT_645 = " = false;" + NL + "            \t\t\t";
  protected final String TEXT_646 = " = new ";
  protected final String TEXT_647 = "Struct();" + NL + "            \t\t\ttry {" + NL + "    \t\t\t" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_648 = NL + "                      \t\t\t\t\tpositionalUtil_";
  protected final String TEXT_649 = ".setValue_";
  protected final String TEXT_650 = "(";
  protected final String TEXT_651 = ",begins_";
  protected final String TEXT_652 = ",ends_";
  protected final String TEXT_653 = ",rowLen_";
  protected final String TEXT_654 = "," + NL + "                          \t\t\t\t";
  protected final String TEXT_655 = "byteArray_";
  protected final String TEXT_656 = ",arrays_";
  protected final String TEXT_657 = ",";
  protected final String TEXT_658 = "column_";
  protected final String TEXT_659 = ",row_";
  protected final String TEXT_660 = ");          " + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_661 = NL + "                            \tint substringBegin";
  protected final String TEXT_662 = "=0,substringEnd";
  protected final String TEXT_663 = "=0;" + NL + "                            \tint[]begin_end_";
  protected final String TEXT_664 = "=new int[2];" + NL + "        \t\t\t\t\t\t";
  protected final String TEXT_665 = NL + "                            \t\t\t\tsubstringBegin";
  protected final String TEXT_666 = " = positionalUtil_";
  protected final String TEXT_667 = ".parseValue_";
  protected final String TEXT_668 = "(row_";
  protected final String TEXT_669 = ", substringBegin";
  protected final String TEXT_670 = ", substringEnd";
  protected final String TEXT_671 = ", rowLen_";
  protected final String TEXT_672 = ", columnValue";
  protected final String TEXT_673 = " ";
  protected final String TEXT_674 = ", arrays_";
  protected final String TEXT_675 = ", byteArray_";
  protected final String TEXT_676 = ", dynamic_";
  protected final String TEXT_677 = ");" + NL + "                            \t\t\t\tsubstringEnd";
  protected final String TEXT_678 = " = substringBegin";
  protected final String TEXT_679 = ";" + NL + "                        \t\t\t\t";
  protected final String TEXT_680 = NL + "                            \t\tfor (int i_";
  protected final String TEXT_681 = " = 0; i_";
  protected final String TEXT_682 = " < ";
  protected final String TEXT_683 = "; i_";
  protected final String TEXT_684 = "++) {" + NL + "                            \t\t\tif (i_";
  protected final String TEXT_685 = " >= arrFieldSeparator";
  protected final String TEXT_686 = ".length ){" + NL + "                            \t\t\t\tcolumnValue";
  protected final String TEXT_687 = "[i_";
  protected final String TEXT_688 = "]=\"\";" + NL + "                            \t\t\t\tcontinue;" + NL + "                            \t\t\t}" + NL + "    \t\t\t " + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_689 = NL + "                            \t\t\t\tif(i_";
  protected final String TEXT_690 = "==";
  protected final String TEXT_691 = "){" + NL + "                            \t\t\t\t\tdynamic_";
  protected final String TEXT_692 = ".clearColumnValues();" + NL + "                            \t\t\t \t\tfor (int i";
  protected final String TEXT_693 = "=0;i";
  protected final String TEXT_694 = "<maxColumnCount_";
  protected final String TEXT_695 = ";i";
  protected final String TEXT_696 = "++) {" + NL + "                            \t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadataColumn_";
  protected final String TEXT_697 = " = dynamic_";
  protected final String TEXT_698 = ".getColumnMetadata(i";
  protected final String TEXT_699 = ");" + NL + "                            \t\t\t\t\t\tint currentFieldLength_";
  protected final String TEXT_700 = " = dynamicMetadataColumn_";
  protected final String TEXT_701 = ".getLength();" + NL + "                            \t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_702 = " = substringBegin";
  protected final String TEXT_703 = "+currentFieldLength_";
  protected final String TEXT_704 = ";" + NL + "                            \t\t\t\t\t\tif(substringEnd";
  protected final String TEXT_705 = " > rowLen_";
  protected final String TEXT_706 = "){" + NL + "                            \t\t\t\t\t\t\tsubstringEnd";
  protected final String TEXT_707 = " = rowLen_";
  protected final String TEXT_708 = ";" + NL + "                            \t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_709 = NL + "                            \t\t\t\t\t\t\tbyte[] temp_byteArray_";
  protected final String TEXT_710 = " = arrays_";
  protected final String TEXT_711 = ".copyOfRange(row_";
  protected final String TEXT_712 = ".getBytes(";
  protected final String TEXT_713 = "),substringBegin";
  protected final String TEXT_714 = ", substringEnd";
  protected final String TEXT_715 = ");" + NL + "                            \t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_716 = " = new String(temp_byteArray_";
  protected final String TEXT_717 = ",";
  protected final String TEXT_718 = ");\t\t\t\t\t\t" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_719 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\tString currentColumnValue_";
  protected final String TEXT_720 = " = row_";
  protected final String TEXT_721 = ".substring(substringBegin";
  protected final String TEXT_722 = ", substringEnd";
  protected final String TEXT_723 = ");" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_724 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_725 = " = TalendString.talendTrim(currentColumnValue_";
  protected final String TEXT_726 = ", ";
  protected final String TEXT_727 = ", ";
  protected final String TEXT_728 = ");" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_729 = NL + "                            \t\t\t\t\t\t\tString type_";
  protected final String TEXT_730 = " = dynamicMetadataColumn_";
  protected final String TEXT_731 = ".getType();" + NL + "                            \t\t\t\t\t\t\tif(\"id_Short\".equals(type_";
  protected final String TEXT_732 = ") || \"id_Integer\".equals(type_";
  protected final String TEXT_733 = ") || \"id_Double\".equals(type_";
  protected final String TEXT_734 = ") || \"id_Float\".equals(type_";
  protected final String TEXT_735 = ") || \"id_Long\".equals(type_";
  protected final String TEXT_736 = ") || \"id_BigDecimal\".equals(type_";
  protected final String TEXT_737 = ")){" + NL + "                            \t\t\t\t\t\t\t\tcurrentColumnValue_";
  protected final String TEXT_738 = " = ParserUtils.parseTo_Number(currentColumnValue_";
  protected final String TEXT_739 = ", ";
  protected final String TEXT_740 = ", ";
  protected final String TEXT_741 = ");" + NL + "                            \t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_742 = NL + "    \t\t\t\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_743 = ".addColumnValue(currentColumnValue_";
  protected final String TEXT_744 = ");" + NL + "    \t\t\t\t\t\t\t\t\t\t\t\tsubstringBegin";
  protected final String TEXT_745 = " = substringEnd";
  protected final String TEXT_746 = "; " + NL + "    \t\t\t\t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t\t\t}" + NL + "    \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_747 = NL + "                            \t\t    if (substringBegin";
  protected final String TEXT_748 = " >= rowLen_";
  protected final String TEXT_749 = ") {" + NL + "                            \t\t    \tcolumnValue";
  protected final String TEXT_750 = "[i_";
  protected final String TEXT_751 = "] = \"\";" + NL + "                            \t\t    } else{" + NL + "                            \t\t    " + NL + "                            \t\t\t\tif ((star_";
  protected final String TEXT_752 = ").equals(tmpAry_";
  protected final String TEXT_753 = "[i_";
  protected final String TEXT_754 = "])){" + NL + "                            \t\t\t\t\tsubstringEnd";
  protected final String TEXT_755 = " = rowLen_";
  protected final String TEXT_756 = ";" + NL + "                            \t\t\t\t} else{" + NL + "                            \t    \t\t\tsubstringEnd";
  protected final String TEXT_757 = " = substringEnd";
  protected final String TEXT_758 = " +tmpAry_";
  protected final String TEXT_759 = "[i_";
  protected final String TEXT_760 = "];" + NL + "                            \t\t\t        if(substringEnd";
  protected final String TEXT_761 = " > rowLen_";
  protected final String TEXT_762 = ")" + NL + "                            \t\t\t        \tsubstringEnd";
  protected final String TEXT_763 = " = rowLen_";
  protected final String TEXT_764 = ";" + NL + "                            \t\t\t\t}" + NL + "                            \t\t\t\t";
  protected final String TEXT_765 = NL + "                                \t\t\t\tbyteArray_";
  protected final String TEXT_766 = "[i_";
  protected final String TEXT_767 = "] = arrays_";
  protected final String TEXT_768 = ".copyOfRange(row_";
  protected final String TEXT_769 = ".getBytes(";
  protected final String TEXT_770 = "),substringBegin";
  protected final String TEXT_771 = ", substringEnd";
  protected final String TEXT_772 = ");" + NL + "                                \t\t\t\tcolumnValue";
  protected final String TEXT_773 = "[i_";
  protected final String TEXT_774 = "] = new String(byteArray_";
  protected final String TEXT_775 = "[i_";
  protected final String TEXT_776 = "],";
  protected final String TEXT_777 = ");" + NL + "    \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_778 = NL + "    \t        \t\t\t\t\t\t\t\tcolumnValue";
  protected final String TEXT_779 = "[i_";
  protected final String TEXT_780 = "] = row_";
  protected final String TEXT_781 = ".substring(substringBegin";
  protected final String TEXT_782 = ", substringEnd";
  protected final String TEXT_783 = ");\t" + NL + "    \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_784 = NL + "                            \t        \tif (";
  protected final String TEXT_785 = ")" + NL + "                            \t        \t\tcolumnValue";
  protected final String TEXT_786 = "[i_";
  protected final String TEXT_787 = "] = columnValue";
  protected final String TEXT_788 = "[i_";
  protected final String TEXT_789 = "].trim();" + NL + "    \t\t        \t" + NL + "    \t\t\t\t\t\t\t        \tsubstringBegin";
  protected final String TEXT_790 = " = substringEnd";
  protected final String TEXT_791 = ";" + NL + "                            \t        }" + NL + "                            \t\t}" + NL + "                            \t";
  protected final String TEXT_792 = NL + "      \t \t\t\t\t\t\t\t\tpositionalUtil_";
  protected final String TEXT_793 = ".setValue_";
  protected final String TEXT_794 = "(";
  protected final String TEXT_795 = ",columnValue";
  protected final String TEXT_796 = ");" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_797 = NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_798 = ".";
  protected final String TEXT_799 = "=dynamic_";
  protected final String TEXT_800 = ";" + NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_801 = NL + "    \t\t" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_802 = " ";
  protected final String TEXT_803 = " = null; ";
  protected final String TEXT_804 = "        \t\t\t" + NL + "            \t\t\t" + NL + "    \t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "        \t\t\t\t\twhetherReject_";
  protected final String TEXT_805 = " = true;";
  protected final String TEXT_806 = NL + "                                throw(e);";
  protected final String TEXT_807 = NL + "                                    ";
  protected final String TEXT_808 = " = new ";
  protected final String TEXT_809 = "Struct();";
  protected final String TEXT_810 = NL + "                                        ";
  protected final String TEXT_811 = ".";
  protected final String TEXT_812 = " = ";
  protected final String TEXT_813 = ".";
  protected final String TEXT_814 = ";";
  protected final String TEXT_815 = NL + "                                    ";
  protected final String TEXT_816 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_817 = ";";
  protected final String TEXT_818 = NL + "                                    ";
  protected final String TEXT_819 = " = null;";
  protected final String TEXT_820 = NL + "                    \t\t\t\t\tlog.error(\"";
  protected final String TEXT_821 = " - \" +e.getMessage());" + NL + "                    \t\t\t\t";
  protected final String TEXT_822 = NL + "                                    System.err.println(e.getMessage());";
  protected final String TEXT_823 = NL + "                                    ";
  protected final String TEXT_824 = " = null;";
  protected final String TEXT_825 = NL + "                                \t";
  protected final String TEXT_826 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_827 = ";";
  protected final String TEXT_828 = NL + "                        }" + NL + "        \t\t\t" + NL + "        \t\t\t";
  protected final String TEXT_829 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_830 = "if(!whetherReject_";
  protected final String TEXT_831 = ") { ";
  protected final String TEXT_832 = "      " + NL + "         \t\t\t\t\t\tif(";
  protected final String TEXT_833 = " == null){ " + NL + "            \t \t\t\t\t\t";
  protected final String TEXT_834 = " = new ";
  protected final String TEXT_835 = "Struct();" + NL + "         \t\t\t\t\t\t}\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_836 = NL + "\t    \t \t\t\t\t\t\t";
  protected final String TEXT_837 = ".";
  protected final String TEXT_838 = " = ";
  protected final String TEXT_839 = ".";
  protected final String TEXT_840 = ";    \t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_841 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_842 = " } ";
  protected final String TEXT_843 = "\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_844 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	List<? extends IConnection> connsFlow = node.getOutgoingConnections("FLOW");

    String rejectConnName = "";
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
			
			List<Map<String, String>> formats =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__FORMATS__"
            );
            
            List<Map<String, String>> trimSelects =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__TRIMSELECT__"
            );
            
            String pattern1 = ElementParameterParser.getValue(node, "__PATTERN__");
            
            boolean useByte = ("true").equals(ElementParameterParser.getValue(node, "__USE_BYTE__"));
            boolean advanced = ("true").equals(ElementParameterParser.getValue(node, "__ADVANCED_OPTION__"));
            
			String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
			
			String trimAll = ElementParameterParser.getValue(node,"__TRIMALL__");
			boolean isTrimAll = true;
			if(trimAll != null && ("false").equals(trimAll)){
				isTrimAll = false;
			}
			
   			String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
   			
    		String header = ElementParameterParser.getValue(node, "__HEADER__");
    		
    		String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    		
    		String limit = ElementParameterParser.getValue(node, "__LIMIT__");    		
    		if ("".equals(limit.trim())) limit = "-1";
    		
    		String removeEmptyRow = ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
    		
        	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
    		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
    		
    		//need to process rows longger than 100 000 characters, the property SafetySwitch(in talend_file_enhanced_20070724.jar) should be sent to false.(the default is true)
    		//that means if check the option(true), the logic value of bSafetySwitch should be changed to false (XOR with 'true')
    		boolean bSafetySwitch = (("true").equals(ElementParameterParser.getValue(node, "__PROCESS_LONG_ROW__")) ^ true);    		
    		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);    		  
			
			String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
			boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
			
			boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
			
			final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			log4jFileUtil.componentStartInfo(node);
			
    		if(("").equals(header)){
    			header = "0";
    		}
    			
    		if(("").equals(footer)){
    			footer = "0";
    		}
    		
    		boolean useStar = false;
    		
    		String pattern=TalendTextUtils.removeQuotes(pattern1);
    		String[] positions=(pattern.trim()).split(",");
    		for(int i=0;i<positions.length;i++){
            	if(("").equals(positions[i])){
               	 	positions[i]="0";
            	}
            	if(("*").equals(positions[i])){
            		useStar = true;
            	}
            }
			boolean hasDynamic = metadata.isDynamicSchema();
			String dynamic = ElementParameterParser.getValue(node, "__DYNAMIC__");
			boolean useExistingDynamic = "true".equals(ElementParameterParser.getValue(node, "__USE_EXISTING_DYNAMIC__"));
            String dyn = dynamic+"_DYNAMIC";
			if(useExistingDynamic){
				useStar = true;
				
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
			}
			
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(footer);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_41);
    
			if(useByte){
			
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    
			}
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
                String firstConnName = "";
                if (conns!=null) {
            		if (conns.size()>0) {
            			IConnection conn = conns.get(0);
            			firstConnName = conn.getName();
            			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                            List<IMetadataColumn> listColumns = metadata.getListColumns();
            				int sizeListColumns = listColumns.size();
                			if(advanced){// custom part start
                				for (int valueN=0; valueN<sizeListColumns; valueN++) {
                					String paddingChar = formats.get(valueN).get("PADDING_CHAR");
                					String align = formats.get(valueN).get("ALIGN");
                					if(("'L'").equals(align)){
                						align = "-1";
                					}else if(("'C'").equals(align)){
                						align = "0";
                					}else{
                						align = "1";
                					}
                					if(valueN%100==0){
    						        
    stringBuffer.append(TEXT_49);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
     if(useByte){ 
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
     } 
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
									}
    								if(valueN == sizeListColumns - 1 && useStar){ //last column
									
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    
        									if(useByte){
											
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_79);
    
											}else{
											
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_86);
    
											}
											
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    
									}else{//other column
										if(useByte){
										
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    
										}else{
										
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    
										}
									}
									if(isTrimAll || ("true").equals(trimSelects.get(valueN).get("TRIM"))){
									
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    
									}
									IMetadataColumn column = listColumns.get(valueN);
									String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
									JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
									String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
									if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
									
    stringBuffer.append(TEXT_142);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    
									} else if("id_Dynamic".equals(column.getTalendType())){
										if(useExistingDynamic){
										
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(dyn);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    
        										if(useByte){
												
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_181);
    
                								}else{
                								
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    
												}
												if(advanced){
												
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_191);
    
												}
												if(isTrimAll || (hasDynamic &&(("true").equals(trimSelects.get(trimSelects.size()-1).get("TRIM"))))){
												
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
												}
												if(advancedSeparator) { 
												
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_206);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_207);
    
												}
												
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    
                						}
                					} else {
									
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    
        									if(javaType == JavaTypesManager.DATE) {
												if(checkDate) {
												
    stringBuffer.append(TEXT_218);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_222);
    
												} else {
												
    stringBuffer.append(TEXT_223);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_227);
    
												}
											}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
											
    stringBuffer.append(TEXT_228);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_230);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_233);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_234);
    
											}else if(javaType == JavaTypesManager.BYTE_ARRAY) {
											
    stringBuffer.append(TEXT_235);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_239);
    
											} else {
											
    stringBuffer.append(TEXT_240);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_242);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    
											}
											
    stringBuffer.append(TEXT_245);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_248);
    					
									}
									if((valueN+1)%100==0){
									
    stringBuffer.append(TEXT_249);
    
        							}
        						}//end for_
        						if(sizeListColumns>0&&(sizeListColumns%100)>0){
        						
    stringBuffer.append(TEXT_250);
    
								}
							}//custom end
							else{//custom not check
								if(java.util.regex.Pattern.compile("[0-9]*").matcher(positions[0]).matches()){
									List<IMetadataColumn> columnList = metadata.getListColumns();
    								for(int i=0;i <	columnList.size();i++){
										if(i % 100 == 0){
                            		    
    stringBuffer.append(TEXT_251);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    if(useByte){
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    }
    if(useExistingDynamic){
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_262);
    
                            		    }
                            		    IMetadataColumn column = columnList.get(i);
										boolean isDynamic = "id_Dynamic".equals(column.getTalendType()) && useExistingDynamic;
                            		    if(isDynamic){
                            				String paddingChar = formats.get(i).get("PADDING_CHAR");
                            				String align = formats.get(i).get("ALIGN");
    										
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    
    											if(useByte){
    											
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_292);
    
    											}else{
    											
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    
                            					}
                            					if(isTrimAll || (hasDynamic &&(("true").equals(trimSelects.get(trimSelects.size()-1).get("TRIM"))))){
    											
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    
    											}
    											if(advanced){
    											
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_305);
    
    											}
    											if(advancedSeparator) { 
    											
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
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_317);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_318);
    
    											}
    											
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    
                        				}else if(i >= positions.length){
    									
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_326);
    
    									}else{
    									
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_331);
    
        										if(("*").equals(positions[i])){
        										
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_334);
    
        										} else{
        										
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(positions[i]);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_342);
    
                            					}
                            					if(useByte){
        										
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_355);
    
        										}else{
        										
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
     
        										}
               									if(isTrimAll || ("true").equals(trimSelects.get(i).get("TRIM"))){
        										
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_366);
    
        										}
        										
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    
    									}
    									if((i+1) % 100 == 0){
                            		    
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    
                            		    }
    								}//for(...)
                					if(columnList.size()>0&&(columnList.size()%100)>0){
    								
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    
             						}
    							}
							
                				for (int valueN=0; valueN<sizeListColumns; valueN++) {	
                				    if(valueN%100==0){
                					
    stringBuffer.append(TEXT_374);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_375);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    
                                    }	
                					
    stringBuffer.append(TEXT_379);
    
                                    IMetadataColumn column = listColumns.get(valueN);
                					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
									
    stringBuffer.append(TEXT_380);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_384);
    
                					}else if("id_Dynamic".equals(column.getTalendType())){
                					
                					} else {
                					
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_386);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_387);
    
                					        if(javaType == JavaTypesManager.DATE) {
                								if(checkDate) {
                								
    stringBuffer.append(TEXT_388);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_392);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_393);
    
												} else {
												
    stringBuffer.append(TEXT_394);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_398);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_399);
    
												}
											}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
											
    stringBuffer.append(TEXT_400);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_402);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_405);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_406);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_407);
    
					        				}else if(javaType == JavaTypesManager.BYTE_ARRAY) {
											
    stringBuffer.append(TEXT_408);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_413);
    
											} else {
											
    stringBuffer.append(TEXT_414);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_416);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_419);
    
											}
											
    stringBuffer.append(TEXT_420);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_421);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_423);
    
        							}
									
    stringBuffer.append(TEXT_424);
    
             						if((valueN+1)%100==0){
									
    stringBuffer.append(TEXT_425);
    
             						}
 								}
								
    stringBuffer.append(TEXT_426);
    
            					if(sizeListColumns>0&&(sizeListColumns%100)>0){
								
    stringBuffer.append(TEXT_427);
    
         						}
								
    stringBuffer.append(TEXT_428);
    
        					}//custom not check
                		}
                	}
                }
                
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    
			if(advanced){
			
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_438);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_439);
    
				for(int i = 0; i < formats.size(); i++){ 
    				if(i == formats.size() - 1 && !(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator))){
    					if(("*").equals(formats.get(i).get("SIZE"))){ 
    						useStar = true;
    					}
						
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_442);
    stringBuffer.append(useStar ? -1 :  formats.get(i).get("SIZE") );
    stringBuffer.append(TEXT_443);
    
					}else{
					
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(formats.get(i).get("SIZE") );
    stringBuffer.append(TEXT_447);
    
    				}
    			}
				for(int i = 0; i < formats.size(); i++){ 
					if(i == 0){
					
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_454);
    
					}else if(i == formats.size() - 1 && useStar){
					
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_460);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_463);
    
					}else{
					
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_465);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_471);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_476);
    
    				}
    			}
			}//end if(advanced)
			
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_482);
    
			if(uncompress){
			
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_489);
     if(dieOnError) {
    stringBuffer.append(TEXT_490);
     } else { 
    stringBuffer.append(TEXT_491);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    }
    stringBuffer.append(TEXT_494);
     } 
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
     if(dieOnError) {
    stringBuffer.append(TEXT_499);
     } else { 
    stringBuffer.append(TEXT_500);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    }
    stringBuffer.append(TEXT_503);
     } 
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    
                	if(advanced){
                		if(useByte){
                		
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    
                    	}
                    	
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    
                	}else{
                		if(useByte){
                		
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_514);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_515);
    
                		}
                		
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_518);
    
                	}
                	
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_522);
    
    		}else{
    		
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_525);
    
                if(advanced){
                	if(useByte){
               		
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_527);
    
                    }
                    
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_529);
    
                }else{
                	if(useByte){
                    
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_531);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_532);
    
                	}
            	    
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_535);
    
                }
                
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_539);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_543);
    
			}
			if(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator) ){
			
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_545);
    
				if(advanced){ 
					for(int i = 0; i < formats.size(); i++){ 
					
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_548);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_549);
    
					}
				}else{
					for(int i=0;i<positions.length;i++){
					
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_551);
    stringBuffer.append(positions[i] );
    stringBuffer.append(TEXT_552);
    
        			}
				}
				
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_556);
    
			}else{
			
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_560);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_561);
    
			}
			
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(bSafetySwitch);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_578);
    
				if(("").equals(rowSeparator) || ("\"\"").equals(rowSeparator) ){
				
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_582);
    
				}else{
				
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_585);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_586);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_587);
    
				}
				
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_589);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_598);
     if(dieOnError) {
    stringBuffer.append(TEXT_599);
     } else { 
    stringBuffer.append(TEXT_600);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    }
    stringBuffer.append(TEXT_603);
     } 
    stringBuffer.append(TEXT_604);
    
        if ( !(java.util.regex.Pattern.compile("[0-9]*").matcher(positions[0]).matches() )){
        	if(pattern1.startsWith("\"")){
    		
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(positions[0] );
    stringBuffer.append(TEXT_607);
     
        	}else{
        	
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(positions[0]);
    stringBuffer.append(TEXT_610);
     
        	}
        	
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    
        }	
        
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_633);
    
			if(useByte){
			
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_636);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_637);
    	
			}else{
			
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_640);
    
			}
			
    stringBuffer.append(TEXT_641);
    
            if(rejectConns != null && rejectConns.size() > 0) {
                IConnection rejectConn = rejectConns.get(0);
                rejectConnName = rejectConn.getName();
            }
            List<IMetadataColumn> rejectColumnList = null;
            IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
            if(metadataTable != null) {
                rejectColumnList = metadataTable.getListColumns();      
            }

        	if (conns!=null) {
        		if (conns.size()>0) {
        			for (int i=0;i<conns.size();i++) {
        				IConnection connTemp = conns.get(i);
        				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
						
    stringBuffer.append(TEXT_642);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_643);
    
        				}
        			}
        		}
        	}
    	
        	if (conns!=null) {
        		if (conns.size()>0) {
        			IConnection conn = conns.get(0);
        			firstConnName = conn.getName();
        			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_645);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_646);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_647);
    
                			if(advanced){
                				List<IMetadataColumn> listColumns = metadata.getListColumns();
               				    int sizeListColumns = listColumns.size();
                				for (int valueN=0; valueN<sizeListColumns; valueN++) {
                					String paddingChar = formats.get(valueN).get("PADDING_CHAR");
                					String align = formats.get(valueN).get("ALIGN");
                					if(("'L'").equals(align)){
                						align = "-1";
                					}else if(("'C'").equals(align)){
                						align = "0";
                					}else{
                						align = "1";
                					}
                       				if(valueN%100==0){
    								
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_650);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_654);
     if(useByte){ 
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_657);
     } 
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_660);
    
                      				}
        						}
        					}else{// end if(advance)
    						
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_664);
    
        						///////////////////
                            	//Branch: first item is a numberic, not '((String)globalMap.get("global_variable"))' or 'context.Separator'
                            	if ( java.util.regex.Pattern.compile("[0-9]*").matcher(positions[0]).matches() ){
                            	///////////////////
                            	    List<IMetadataColumn> columnList = metadata.getListColumns();
                            		for(int i=0; i < columnList.size(); i++){
                            			IMetadataColumn column = columnList.get(i);
                        				if(i % 100 == 0){
                        				
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_670);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    if(useByte){
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid);
    }
    if(useExistingDynamic){
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    }
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    
                            			}
                            		}
                            	///////////////
                            	} else{
                            	    List<IMetadataColumn> listColumns = metadata.getListColumns();
                            	    int column_index=listColumns.size()-1;
                            	    for(int i = 0;i<listColumns.size();i++){
                            	        if("id_Dynamic".equals(listColumns.get(i).getTalendType())){
                            	            column_index = i;
                            	        }
                            	    }
    								
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_688);
    
                            			if(useExistingDynamic){
                            				String paddingChar = formats.get(formats.size()-1).get("PADDING_CHAR");
                            				String align = formats.get(formats.size()-1).get("ALIGN");
    										
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_690);
    stringBuffer.append(column_index);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_708);
    
    												if(useByte){
    												
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_712);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_714);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_717);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_718);
    
    												}else{
    												
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_723);
    
    												}
    												if(advanced){
    												
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_727);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_728);
    
    												}
    												if(advancedSeparator) { 
    												
    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_733);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_739);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_740);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_741);
    
    												}
    												
    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_743);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_745);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_746);
    
    									}
    									
    stringBuffer.append(TEXT_747);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_749);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_750);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_752);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_754);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_755);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_756);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_759);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_760);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_761);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_762);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_763);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_764);
    
    										if(useByte){
    										
    stringBuffer.append(TEXT_765);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_766);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_767);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_768);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_769);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_770);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_771);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_772);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_774);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_776);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_777);
    
    										}else{
    										
    stringBuffer.append(TEXT_778);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_779);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_780);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_781);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_782);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_783);
    
    										}
    										
    stringBuffer.append(TEXT_784);
    stringBuffer.append(isTrimAll);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_786);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_787);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_788);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_789);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_790);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_791);
    
                            	}
                            	///////////////
                            	List<IMetadataColumn> listColumns = metadata.getListColumns();
                            	int sizeListColumns = listColumns.size();
                            	
                            	for (int valueN=0; valueN<sizeListColumns; valueN++) {	
                            		if(valueN%100==0){
    								
    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_793);
    stringBuffer.append((valueN/100));
    stringBuffer.append(TEXT_794);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_795);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_796);
    
                            	    }
                               	}
       	 
    							if(useExistingDynamic && !advanced){
    							
    stringBuffer.append(TEXT_797);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_798);
    stringBuffer.append(metadata.getDynamicColumn().getLabel());
    stringBuffer.append(TEXT_799);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_800);
    		
                        		}
                            }
        
        					log4jFileUtil.debugRetriveData(node,false);
    						
    stringBuffer.append(TEXT_801);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_802);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_803);
    }
    stringBuffer.append(TEXT_804);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_805);
    
                            if (dieOnError) {
                            
    stringBuffer.append(TEXT_806);
    
                            } else {
                                if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
                                
    stringBuffer.append(TEXT_807);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_808);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_809);
    
                                    for(IMetadataColumn column : metadata.getListColumns()) {
                                    
    stringBuffer.append(TEXT_810);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_811);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_812);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_813);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_814);
    
                                    }
                                    
    stringBuffer.append(TEXT_815);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_816);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_817);
    stringBuffer.append(TEXT_818);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_819);
    
                                } else if(("").equals(rejectConnName)){
                    	        	if(isLog4jEnabled){
                    	        	
    stringBuffer.append(TEXT_820);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_821);
    
                    				}
                                    
    stringBuffer.append(TEXT_822);
    stringBuffer.append(TEXT_823);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_824);
    
                                } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_825);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_826);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_827);
    
                                }
                            } 
                            
    stringBuffer.append(TEXT_828);
            			
    				}
            		if (conns.size()>0) {	
            			boolean isFirstEnter = true;
            			for (int i=0;i<conns.size();i++) {
            				conn = conns.get(i);
            				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
							
    stringBuffer.append(TEXT_829);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_830);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_831);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_832);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_833);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_834);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_835);
    
		    	 				for (IMetadataColumn column: metadata.getListColumns()) {
								
    stringBuffer.append(TEXT_836);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_837);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_838);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_839);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_840);
    
            				 	}
            				}
            			}
						
    stringBuffer.append(TEXT_841);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_842);
     } 
    stringBuffer.append(TEXT_843);
    
					}
            	}
    		}
    	}
    }
	
    stringBuffer.append(TEXT_844);
    return stringBuffer.toString();
  }
}
