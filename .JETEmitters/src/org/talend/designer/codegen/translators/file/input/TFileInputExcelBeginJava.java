package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileInputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputExcelBeginJava result = new TFileInputExcelBeginJava();
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
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "\t\t\t\t\tint dynamic_column_count_";
  protected final String TEXT_31 = "=1;" + NL + "\t\t\t\t\tif(isFirstCheckDyn_";
  protected final String TEXT_32 = "){// for the header line" + NL + "\t\t\t\t\t\tif(row_";
  protected final String TEXT_33 = "==null " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\t\t|| row_";
  protected final String TEXT_35 = ".length == 0" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t\t|| row_";
  protected final String TEXT_37 = ".getLastCellNum() == 0" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t\t|| row_";
  protected final String TEXT_39 = ".size() == 0" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_40 = "){" + NL + "\t\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t\tint colsLen_";
  protected final String TEXT_42 = " = row_";
  protected final String TEXT_43 = ".length-start_column_";
  protected final String TEXT_44 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t    \t\t\t\tint colsLen_";
  protected final String TEXT_46 = " =  row_";
  protected final String TEXT_47 = ".getLastCellNum()-start_column_";
  protected final String TEXT_48 = ";" + NL + "\t\t    \t\t\t";
  protected final String TEXT_49 = NL + "\t\t    \t\t\t\tint colsLen_";
  protected final String TEXT_50 = " = row_";
  protected final String TEXT_51 = ".size()-start_column_";
  protected final String TEXT_52 = ";" + NL + "\t\t    \t\t\t";
  protected final String TEXT_53 = NL + "\t\t    \t\t\tdynamic_column_count_";
  protected final String TEXT_54 = " = colsLen_";
  protected final String TEXT_55 = "-";
  protected final String TEXT_56 = ";" + NL + "\t\t    \t\t\tfor (int i = ";
  protected final String TEXT_57 = "; i < colsLen_";
  protected final String TEXT_58 = "-";
  protected final String TEXT_59 = "; i++) {" + NL + "\t\t\t\t\t    \troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_60 = " = new routines.system.DynamicMetadata();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\t\t\t\tString content_";
  protected final String TEXT_62 = " = row_";
  protected final String TEXT_63 = "[i].getContents();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t    \t\t\t\tString content_";
  protected final String TEXT_65 = " = row_";
  protected final String TEXT_66 = ".getCell(i)==null?null:row_";
  protected final String TEXT_67 = ".getCell(i).toString();" + NL + "\t\t\t    \t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t    \t\t\t\tString content_";
  protected final String TEXT_69 = " = row_";
  protected final String TEXT_70 = ".get(i);" + NL + "\t\t\t    \t\t\t";
  protected final String TEXT_71 = NL + "\t\t\t    \t\t\tif(content_";
  protected final String TEXT_72 = "!=null){" + NL + "\t\t\t\t\t    \t\tdynamicMetadata_";
  protected final String TEXT_73 = ".setName(content_";
  protected final String TEXT_74 = ".replaceAll(\"[ .-]+\", \"_\"));" + NL + "\t\t\t\t\t    \t}" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_75 = ".setDbName(dynamicMetadata_";
  protected final String TEXT_76 = ".getName());" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_77 = ".setType(\"id_String\");" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_78 = ".setDbType(\"VARCHAR\");" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_79 = ".setLength(100);" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_80 = ".setPrecision(0);" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_81 = ".setNullable(true);" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_82 = ".setKey(false);" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_83 = ".setSourceType(routines.system.DynamicMetadata.sourceTypes.excelFile);" + NL + "\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_84 = ".setColumnPosition(i);" + NL + "\t\t\t\t\t    \tdynamic_";
  protected final String TEXT_85 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_86 = ");" + NL + "\t\t\t\t\t    }" + NL + "\t\t    \t\t\tisFirstCheckDyn_";
  protected final String TEXT_87 = " = false;" + NL + "\t\t    \t\t\t" + NL + "\t\t    \t\t\tcontinue;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tint tempRowLength_";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = "+dynamic_";
  protected final String TEXT_90 = ".getColumnCount()-1;" + NL + "\t\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\t\tint tempRowLength_";
  protected final String TEXT_92 = " = ";
  protected final String TEXT_93 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\tint columnIndex_";
  protected final String TEXT_95 = " = 0;" + NL + "\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\tboolean isFirstCheckDyn_";
  protected final String TEXT_97 = " = true;" + NL + "\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_98 = " = new routines.system.Dynamic();" + NL + "\t\t";
  protected final String TEXT_99 = NL + NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_100 = " {" + NL + "" + NL + "\t\t    \tpublic java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, String oneSheetName, boolean useRegex) {" + NL + "" + NL + "\t\t\t        java.util.List<jxl.Sheet> list = new java.util.ArrayList<jxl.Sheet>();" + NL + "" + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "" + NL + "\t\t\t\t        jxl.Sheet[] sheets = workbook.getSheets();" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (int i = 0; i < sheets.length; i++) {" + NL + "\t\t\t\t            String sheetName = sheets[i].getName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tjxl.Sheet sheet = workbook.getSheet(sheetName);" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "" + NL + "\t\t\t        }else{" + NL + "\t\t\t        \tjxl.Sheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "" + NL + "\t\t\t        }" + NL + "" + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "" + NL + "\t\t\t    public java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<jxl.Sheet> list =  new java.util.ArrayList<jxl.Sheet>();" + NL + "\t\t\t    \tjxl.Sheet sheet = workbook.getSheet(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "" + NL + "\t\t\t}" + NL + "" + NL + "" + NL + "\t\tRegexUtil_";
  protected final String TEXT_101 = " regexUtil_";
  protected final String TEXT_102 = " = new RegexUtil_";
  protected final String TEXT_103 = "();" + NL + "\t\tfinal jxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_104 = " = new jxl.WorkbookSettings();" + NL + "\t\tworkbookSettings_";
  protected final String TEXT_105 = ".setDrawingsDisabled(true);";
  protected final String TEXT_106 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_107 = ".setCellValidationDisabled(true);";
  protected final String TEXT_108 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_109 = ".setSuppressWarnings(true);";
  protected final String TEXT_110 = NL + "        workbookSettings_";
  protected final String TEXT_111 = ".setEncoding(";
  protected final String TEXT_112 = ");" + NL + "" + NL + "        Object source_";
  protected final String TEXT_113 = " =";
  protected final String TEXT_114 = ";" + NL + "        final jxl.Workbook workbook_";
  protected final String TEXT_115 = ";" + NL + "" + NL + "        java.io.InputStream toClose_";
  protected final String TEXT_116 = " = null;" + NL + "        java.io.BufferedInputStream buffIStream";
  protected final String TEXT_117 = " = null;" + NL + "        try {" + NL + "            if(source_";
  protected final String TEXT_118 = " instanceof java.io.InputStream){" + NL + "        \t\ttoClose_";
  protected final String TEXT_119 = " = (java.io.InputStream)source_";
  protected final String TEXT_120 = ";" + NL + "        \t\tbuffIStream";
  protected final String TEXT_121 = " = new java.io.BufferedInputStream(toClose_";
  protected final String TEXT_122 = ");" + NL + "        \t\tworkbook_";
  protected final String TEXT_123 = " = jxl.Workbook.getWorkbook(buffIStream";
  protected final String TEXT_124 = ", workbookSettings_";
  protected final String TEXT_125 = ");" + NL + "            }else if(source_";
  protected final String TEXT_126 = " instanceof String){" + NL + "        \t\ttoClose_";
  protected final String TEXT_127 = " = new java.io.FileInputStream(source_";
  protected final String TEXT_128 = ".toString());" + NL + "        \t\tbuffIStream";
  protected final String TEXT_129 = " = new java.io.BufferedInputStream(toClose_";
  protected final String TEXT_130 = ");" + NL + "        \t\tworkbook_";
  protected final String TEXT_131 = " = jxl.Workbook.getWorkbook(buffIStream";
  protected final String TEXT_132 = ", workbookSettings_";
  protected final String TEXT_133 = ");" + NL + "            }else{" + NL + "            \tworkbook_";
  protected final String TEXT_134 = " = null;" + NL + "            \tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "            }" + NL + "        } finally {" + NL + "\t\t\ttry{" + NL + "\t\t\t   if(buffIStream";
  protected final String TEXT_135 = " != null){" + NL + "\t\t\t   \t  buffIStream";
  protected final String TEXT_136 = ".close();" + NL + "\t\t\t   }" + NL + "\t\t\t}catch(Exception e){" + NL + "\t\t\t}" + NL + "        }" + NL + "        try {";
  protected final String TEXT_137 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_138 = " = java.util.Arrays.<jxl.Sheet> asList(workbook_";
  protected final String TEXT_139 = ".getSheets());";
  protected final String TEXT_140 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_141 = " = new java.util.ArrayList<jxl.Sheet>();";
  protected final String TEXT_142 = NL + "        sheetList_";
  protected final String TEXT_143 = ".addAll(regexUtil_";
  protected final String TEXT_144 = ".getSheets(workbook_";
  protected final String TEXT_145 = ", ";
  protected final String TEXT_146 = ", ";
  protected final String TEXT_147 = "));";
  protected final String TEXT_148 = NL + "        if(sheetList_";
  protected final String TEXT_149 = ".size() <= 0){" + NL + "        \tthrow new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "" + NL + "        java.util.List<jxl.Sheet> sheet_FilterNullList_";
  protected final String TEXT_150 = " = new java.util.ArrayList<jxl.Sheet>();" + NL + "        for(jxl.Sheet sheet_FilterNull_";
  protected final String TEXT_151 = " : sheetList_";
  protected final String TEXT_152 = "){" + NL + "        \tif(sheet_FilterNull_";
  protected final String TEXT_153 = ".getRows()>0){" + NL + "        \t\tsheet_FilterNullList_";
  protected final String TEXT_154 = ".add(sheet_FilterNull_";
  protected final String TEXT_155 = ");" + NL + "        \t}" + NL + "        }" + NL + "\t\tsheetList_";
  protected final String TEXT_156 = " = sheet_FilterNullList_";
  protected final String TEXT_157 = ";" + NL + "\tif(sheetList_";
  protected final String TEXT_158 = ".size()>0){" + NL + "        int nb_line_";
  protected final String TEXT_159 = " = 0;" + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_160 = " = ";
  protected final String TEXT_161 = "0";
  protected final String TEXT_162 = ";" + NL + "" + NL + "        int footer_input_";
  protected final String TEXT_163 = " = ";
  protected final String TEXT_164 = "0";
  protected final String TEXT_165 = ";" + NL + "" + NL + "        int end_line_";
  protected final String TEXT_166 = "=0;" + NL + "        for(jxl.Sheet sheet_";
  protected final String TEXT_167 = ":sheetList_";
  protected final String TEXT_168 = "){" + NL + "        \tend_line_";
  protected final String TEXT_169 = "+=sheet_";
  protected final String TEXT_170 = ".getRows();" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_171 = " -= footer_input_";
  protected final String TEXT_172 = ";" + NL + "        int limit_";
  protected final String TEXT_173 = " = ";
  protected final String TEXT_174 = "-1";
  protected final String TEXT_175 = ";" + NL + "        int start_column_";
  protected final String TEXT_176 = " = ";
  protected final String TEXT_177 = "0";
  protected final String TEXT_178 = "-1";
  protected final String TEXT_179 = ";" + NL + "        int end_column_";
  protected final String TEXT_180 = " = sheetList_";
  protected final String TEXT_181 = ".get(0).getColumns();";
  protected final String TEXT_182 = NL + "        Integer lastColumn_";
  protected final String TEXT_183 = " = ";
  protected final String TEXT_184 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_185 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_186 = " = lastColumn_";
  protected final String TEXT_187 = ".intValue();" + NL + "        }";
  protected final String TEXT_188 = NL + "        jxl.Cell[] row_";
  protected final String TEXT_189 = " = null;" + NL + "        jxl.Sheet sheet_";
  protected final String TEXT_190 = " = sheetList_";
  protected final String TEXT_191 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_192 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_193 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_194 = " = sheetList_";
  protected final String TEXT_195 = ".get(0).getRows();" + NL + "" + NL + "        //for the number format" + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_196 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "\t\tchar separatorChar_";
  protected final String TEXT_197 = " = df_";
  protected final String TEXT_198 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t";
  protected final String TEXT_199 = NL + "\t\t\tif(begin_line_";
  protected final String TEXT_200 = " > 0){" + NL + "\t\t\t\tbegin_line_";
  protected final String TEXT_201 = " = begin_line_";
  protected final String TEXT_202 = " - 1;" + NL + "\t\t\t}" + NL + "\t\t\tboolean isFirstRow_";
  protected final String TEXT_203 = "=true;" + NL + "\t\t";
  protected final String TEXT_204 = NL + "\t\t";
  protected final String TEXT_205 = NL + "\t\t" + NL + "        for(int i_";
  protected final String TEXT_206 = " = begin_line_";
  protected final String TEXT_207 = "; i_";
  protected final String TEXT_208 = " < end_line_";
  protected final String TEXT_209 = "; i_";
  protected final String TEXT_210 = "++){" + NL + "" + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_211 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_212 = " != -1 && nb_line_";
  protected final String TEXT_213 = " >= limit_";
  protected final String TEXT_214 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "" + NL + "            while (i_";
  protected final String TEXT_215 = " >= rowCount_";
  protected final String TEXT_216 = " + currentRows_";
  protected final String TEXT_217 = ") {" + NL + "                rowCount_";
  protected final String TEXT_218 = " += currentRows_";
  protected final String TEXT_219 = ";" + NL + "                sheet_";
  protected final String TEXT_220 = " = sheetList_";
  protected final String TEXT_221 = ".get(++sheetIndex_";
  protected final String TEXT_222 = ");" + NL + "                currentRows_";
  protected final String TEXT_223 = " = sheet_";
  protected final String TEXT_224 = ".getRows();" + NL + "            }";
  protected final String TEXT_225 = NL + "            if (rowCount_";
  protected final String TEXT_226 = " <= i_";
  protected final String TEXT_227 = ") {" + NL + "                row_";
  protected final String TEXT_228 = " = sheet_";
  protected final String TEXT_229 = ".getRow(i_";
  protected final String TEXT_230 = " - rowCount_";
  protected final String TEXT_231 = ");" + NL + "            }";
  protected final String TEXT_232 = NL + "            if (rowCount_";
  protected final String TEXT_233 = " <= i_";
  protected final String TEXT_234 = " && i_";
  protected final String TEXT_235 = " - rowCount_";
  protected final String TEXT_236 = " >= (";
  protected final String TEXT_237 = "begin_line_";
  protected final String TEXT_238 = "isFirstRow_";
  protected final String TEXT_239 = "?begin_line_";
  protected final String TEXT_240 = ":(begin_line_";
  protected final String TEXT_241 = "+1)";
  protected final String TEXT_242 = ")" + NL + "            \t&& currentRows_";
  protected final String TEXT_243 = " - footer_input_";
  protected final String TEXT_244 = " > i_";
  protected final String TEXT_245 = " - rowCount_";
  protected final String TEXT_246 = ") {" + NL + "                row_";
  protected final String TEXT_247 = " = sheet_";
  protected final String TEXT_248 = ".getRow(i_";
  protected final String TEXT_249 = " - rowCount_";
  protected final String TEXT_250 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_251 = NL + "\t\t\tisFirstRow_";
  protected final String TEXT_252 = " = false;" + NL + "\t\t";
  protected final String TEXT_253 = NL + "        \tglobalMap.put(\"";
  protected final String TEXT_254 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_255 = ".getName());";
  protected final String TEXT_256 = NL + "    \t\t";
  protected final String TEXT_257 = " = null;";
  protected final String TEXT_258 = NL + "//" + NL + "//end%>" + NL + "\t\t\t" + NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_259 = " = new String[tempRowLength_";
  protected final String TEXT_260 = "];" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_261 = " = end_column_";
  protected final String TEXT_262 = " >\trow_";
  protected final String TEXT_263 = ".length ? row_";
  protected final String TEXT_264 = ".length : end_column_";
  protected final String TEXT_265 = ";" + NL + "\t\t\tfor(int i=0;i<tempRowLength_";
  protected final String TEXT_266 = ";i++){" + NL + "" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_267 = " < actual_end_column_";
  protected final String TEXT_268 = "){" + NL + "" + NL + "\t\t\t\t  jxl.Cell cell_";
  protected final String TEXT_269 = " = row_";
  protected final String TEXT_270 = "[i + start_column_";
  protected final String TEXT_271 = "];";
  protected final String TEXT_272 = NL + "                        if (jxl.CellType.NUMBER == cell_";
  protected final String TEXT_273 = ".getType()){" + NL + "                            double doubleCell_";
  protected final String TEXT_274 = " = ((jxl.NumberCell)cell_";
  protected final String TEXT_275 = ").getValue();" + NL + "                            temp_row_";
  protected final String TEXT_276 = "[i] = String.valueOf(doubleCell_";
  protected final String TEXT_277 = ");" + NL + "                            if(temp_row_";
  protected final String TEXT_278 = "[i]!=null) {" + NL + "                                temp_row_";
  protected final String TEXT_279 = "[i] = df_";
  protected final String TEXT_280 = ".format(doubleCell_";
  protected final String TEXT_281 = ");" + NL + "                            }" + NL + "                        } else{" + NL + "                            temp_row_";
  protected final String TEXT_282 = "[i] = cell_";
  protected final String TEXT_283 = ".getContents();" + NL + "                        }";
  protected final String TEXT_284 = NL + "                        temp_row_";
  protected final String TEXT_285 = "[i] = cell_";
  protected final String TEXT_286 = ".getContents();";
  protected final String TEXT_287 = NL + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_288 = "[i]=\"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_289 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_290 = " = new ";
  protected final String TEXT_291 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_292 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_293 = " = \"\";" + NL + "\t\t\ttry {";
  protected final String TEXT_294 = NL + "\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_295 = " = ";
  protected final String TEXT_296 = "+dynamic_column_count_";
  protected final String TEXT_297 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_298 = NL + "\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_299 = " = ";
  protected final String TEXT_300 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_301 = NL + "\t\t\tif( temp_row_";
  protected final String TEXT_302 = "[columnIndex_";
  protected final String TEXT_303 = "]";
  protected final String TEXT_304 = ".length() > 0) {";
  protected final String TEXT_305 = NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_306 = "=columnIndex_";
  protected final String TEXT_307 = " + start_column_";
  protected final String TEXT_308 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_309 = " = \"";
  protected final String TEXT_310 = "\";";
  protected final String TEXT_311 = NL + "\t\t\t";
  protected final String TEXT_312 = ".";
  protected final String TEXT_313 = " = temp_row_";
  protected final String TEXT_314 = "[columnIndex_";
  protected final String TEXT_315 = "]";
  protected final String TEXT_316 = ";";
  protected final String TEXT_317 = NL + "\t\t\tif(";
  protected final String TEXT_318 = "<actual_end_column_";
  protected final String TEXT_319 = "){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tjava.util.Date dateGMT_";
  protected final String TEXT_320 = " = ((jxl.DateCell)row_";
  protected final String TEXT_321 = "[columnIndex_";
  protected final String TEXT_322 = " + start_column_";
  protected final String TEXT_323 = "]).getDate();" + NL + "\t\t\t\t\t";
  protected final String TEXT_324 = ".";
  protected final String TEXT_325 = " = new java.util.Date(dateGMT_";
  protected final String TEXT_326 = ".getTime() - java.util.TimeZone.getDefault().getOffset(dateGMT_";
  protected final String TEXT_327 = ".getTime()));" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_328 = NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_329 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_330 = " + \" )\");" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_331 = NL + "\t\t";
  protected final String TEXT_332 = ".";
  protected final String TEXT_333 = " = ParserUtils.parseTo_";
  protected final String TEXT_334 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_335 = "[columnIndex_";
  protected final String TEXT_336 = "]";
  protected final String TEXT_337 = ", ";
  protected final String TEXT_338 = ", ";
  protected final String TEXT_339 = "));";
  protected final String TEXT_340 = NL + "\t\t\t";
  protected final String TEXT_341 = ".";
  protected final String TEXT_342 = " = temp_row_";
  protected final String TEXT_343 = "[columnIndex_";
  protected final String TEXT_344 = "]";
  protected final String TEXT_345 = ".getBytes(";
  protected final String TEXT_346 = ");" + NL + "\t";
  protected final String TEXT_347 = NL + "\t\t\t\tdynamic_";
  protected final String TEXT_348 = ".clearColumnValues();" + NL + "\t\t\t\tint fieldCount = row_";
  protected final String TEXT_349 = ".length;" + NL + "\t\t\t\tdynamic_column_count_";
  protected final String TEXT_350 = " = dynamic_";
  protected final String TEXT_351 = ".getColumnCount();" + NL + "\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_352 = " ; i++) {" + NL + "\t\t\t\t\tif ((";
  protected final String TEXT_353 = "+i) < fieldCount){" + NL + "\t\t\t\t\t\tif(temp_row_";
  protected final String TEXT_354 = "[";
  protected final String TEXT_355 = "+i]";
  protected final String TEXT_356 = ".length() < 1){" + NL + "\t\t\t\t\t\t\temptyColumnCount_";
  protected final String TEXT_357 = "++;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tdynamic_";
  protected final String TEXT_358 = ".addColumnValue(temp_row_";
  protected final String TEXT_359 = "[";
  protected final String TEXT_360 = "+i]";
  protected final String TEXT_361 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\telse{" + NL + "\t\t\t\t\t\tdynamic_";
  protected final String TEXT_362 = ".addColumnValue(\"\");" + NL + "\t\t\t\t\t\temptyColumnCount_";
  protected final String TEXT_363 = "++;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_364 = ".";
  protected final String TEXT_365 = " =dynamic_";
  protected final String TEXT_366 = ";" + NL + "\t\t\t";
  protected final String TEXT_367 = NL + "\t\t\t";
  protected final String TEXT_368 = ".";
  protected final String TEXT_369 = " = ParserUtils.parseTo_";
  protected final String TEXT_370 = "(temp_row_";
  protected final String TEXT_371 = "[columnIndex_";
  protected final String TEXT_372 = "]";
  protected final String TEXT_373 = ");";
  protected final String TEXT_374 = NL + "\t\t\t}else {";
  protected final String TEXT_375 = NL + "\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_376 = "' in '";
  protected final String TEXT_377 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_378 = NL + "\t\t\t\t";
  protected final String TEXT_379 = ".";
  protected final String TEXT_380 = " = ";
  protected final String TEXT_381 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_382 = "++;";
  protected final String TEXT_383 = NL + "\t\t}";
  protected final String TEXT_384 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_385 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_386 = " ";
  protected final String TEXT_387 = " = null; ";
  protected final String TEXT_388 = NL;
  protected final String TEXT_389 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_390 = " >= ";
  protected final String TEXT_391 = "+dynamic_column_count_";
  protected final String TEXT_392 = "-1";
  protected final String TEXT_393 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_394 = NL + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_395 = " = true;";
  protected final String TEXT_396 = NL + "            throw(e);";
  protected final String TEXT_397 = NL + "                    ";
  protected final String TEXT_398 = " = new ";
  protected final String TEXT_399 = "Struct();";
  protected final String TEXT_400 = NL + "                    ";
  protected final String TEXT_401 = ".";
  protected final String TEXT_402 = " = ";
  protected final String TEXT_403 = ".";
  protected final String TEXT_404 = ";";
  protected final String TEXT_405 = NL + "                ";
  protected final String TEXT_406 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_407 = "+ \" column: \" + curColName_";
  protected final String TEXT_408 = " + \" (No. \" + curColNum_";
  protected final String TEXT_409 = " + \")\";";
  protected final String TEXT_410 = NL + "                ";
  protected final String TEXT_411 = " = null;";
  protected final String TEXT_412 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_413 = NL + "                ";
  protected final String TEXT_414 = " = null;";
  protected final String TEXT_415 = NL + "            \t";
  protected final String TEXT_416 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_417 = "+ \" column: \" + curColName_";
  protected final String TEXT_418 = " + \" (No. \" + curColNum_";
  protected final String TEXT_419 = " + \")\";";
  protected final String TEXT_420 = NL + "    }" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_421 = NL + "\t\t";
  protected final String TEXT_422 = "if(!whetherReject_";
  protected final String TEXT_423 = ") { ";
  protected final String TEXT_424 = NL + "             if(";
  protected final String TEXT_425 = " == null){" + NL + "            \t ";
  protected final String TEXT_426 = " = new ";
  protected final String TEXT_427 = "Struct();" + NL + "             }";
  protected final String TEXT_428 = NL + "\t    \t ";
  protected final String TEXT_429 = ".";
  protected final String TEXT_430 = " = ";
  protected final String TEXT_431 = ".";
  protected final String TEXT_432 = ";";
  protected final String TEXT_433 = NL + "\t\t";
  protected final String TEXT_434 = " } ";
  protected final String TEXT_435 = NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_436 = " {" + NL + "" + NL + "\t\t    \tpublic java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {" + NL + "" + NL + "\t\t\t        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "" + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (org.apache.poi.xssf.usermodel.XSSFSheet sheet : workbook) {" + NL + "\t\t\t\t            String sheetName = sheet.getSheetName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "" + NL + "\t\t\t        }else{" + NL + "\t\t\t        \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "" + NL + "\t\t\t        }" + NL + "" + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "" + NL + "\t\t\t    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\t\t    \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheetAt(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "" + NL + "\t\t\t}" + NL + "\t\tRegexUtil_";
  protected final String TEXT_437 = " regexUtil_";
  protected final String TEXT_438 = " = new RegexUtil_";
  protected final String TEXT_439 = "();" + NL + "" + NL + "\t\tObject source_";
  protected final String TEXT_440 = " = ";
  protected final String TEXT_441 = ";" + NL + "\t\torg.apache.poi.xssf.usermodel.XSSFWorkbook workbook_";
  protected final String TEXT_442 = " = null;" + NL + "" + NL + "\t\tif(source_";
  protected final String TEXT_443 = " instanceof String){" + NL + "\t\t\tworkbook_";
  protected final String TEXT_444 = " = new org.apache.poi.xssf.usermodel.XSSFWorkbook((String)source_";
  protected final String TEXT_445 = ");" + NL + "\t\t} else if(source_";
  protected final String TEXT_446 = " instanceof java.io.InputStream) {" + NL + "     \t\tworkbook_";
  protected final String TEXT_447 = " = new org.apache.poi.xssf.usermodel.XSSFWorkbook((java.io.InputStream)source_";
  protected final String TEXT_448 = ");" + NL + "\t\t} else{" + NL + "\t\t\tworkbook_";
  protected final String TEXT_449 = " = null;" + NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "\t\ttry {" + NL;
  protected final String TEXT_450 = NL + "    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_451 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "    \tfor(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_452 = ":workbook_";
  protected final String TEXT_453 = "){" + NL + "   \t\t\tsheetList_";
  protected final String TEXT_454 = ".add(sheet_";
  protected final String TEXT_455 = ");" + NL + "    \t}";
  protected final String TEXT_456 = NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_457 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();";
  protected final String TEXT_458 = NL + "        sheetList_";
  protected final String TEXT_459 = ".addAll(regexUtil_";
  protected final String TEXT_460 = ".getSheets(workbook_";
  protected final String TEXT_461 = ", ";
  protected final String TEXT_462 = ", ";
  protected final String TEXT_463 = "));";
  protected final String TEXT_464 = NL + "    \tif(sheetList_";
  protected final String TEXT_465 = ".size() <= 0){" + NL + "            throw new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "" + NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_";
  protected final String TEXT_466 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\tfor (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_";
  protected final String TEXT_467 = " : sheetList_";
  protected final String TEXT_468 = ") {" + NL + "\t\t\tif(sheet_FilterNull_";
  protected final String TEXT_469 = "!=null && sheetList_FilterNull_";
  protected final String TEXT_470 = ".iterator()!=null && sheet_FilterNull_";
  protected final String TEXT_471 = ".iterator().hasNext()){" + NL + "\t\t\t\tsheetList_FilterNull_";
  protected final String TEXT_472 = ".add(sheet_FilterNull_";
  protected final String TEXT_473 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsheetList_";
  protected final String TEXT_474 = " = sheetList_FilterNull_";
  protected final String TEXT_475 = ";" + NL + "\tif(sheetList_";
  protected final String TEXT_476 = ".size()>0){" + NL + "\t\tint nb_line_";
  protected final String TEXT_477 = " = 0;" + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_478 = " = ";
  protected final String TEXT_479 = "0";
  protected final String TEXT_480 = ";" + NL + "" + NL + "        int footer_input_";
  protected final String TEXT_481 = " = ";
  protected final String TEXT_482 = "0";
  protected final String TEXT_483 = ";" + NL + "" + NL + "        int end_line_";
  protected final String TEXT_484 = "=0;" + NL + "        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_485 = ":sheetList_";
  protected final String TEXT_486 = "){" + NL + "\t\t\tend_line_";
  protected final String TEXT_487 = "+=(sheet_";
  protected final String TEXT_488 = ".getLastRowNum()+1);" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_489 = " -= footer_input_";
  protected final String TEXT_490 = ";" + NL + "        int limit_";
  protected final String TEXT_491 = " = ";
  protected final String TEXT_492 = "-1";
  protected final String TEXT_493 = ";" + NL + "        int start_column_";
  protected final String TEXT_494 = " = ";
  protected final String TEXT_495 = "0";
  protected final String TEXT_496 = "-1";
  protected final String TEXT_497 = ";" + NL + "        int end_column_";
  protected final String TEXT_498 = " = -1;";
  protected final String TEXT_499 = NL + "        Integer lastColumn_";
  protected final String TEXT_500 = " = ";
  protected final String TEXT_501 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_502 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_503 = " = lastColumn_";
  protected final String TEXT_504 = ".intValue();" + NL + "        }";
  protected final String TEXT_505 = NL + NL + "        org.apache.poi.xssf.usermodel.XSSFRow row_";
  protected final String TEXT_506 = " = null;" + NL + "        org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_507 = " = sheetList_";
  protected final String TEXT_508 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_509 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_510 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_511 = " = (sheetList_";
  protected final String TEXT_512 = ".get(0).getLastRowNum()+1);" + NL + "" + NL + "\t\t//for the number format" + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_513 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "        char decimalChar_";
  protected final String TEXT_514 = " = df_";
  protected final String TEXT_515 = ".getDecimalFormatSymbols().getDecimalSeparator();";
  protected final String TEXT_516 = NL + "\t\t\tif(begin_line_";
  protected final String TEXT_517 = " > 0){" + NL + "\t\t\t\tbegin_line_";
  protected final String TEXT_518 = " = begin_line_";
  protected final String TEXT_519 = " - 1;" + NL + "\t\t\t}" + NL + "\t\t\tboolean isFirstRow_";
  protected final String TEXT_520 = "=true;" + NL + "\t\t";
  protected final String TEXT_521 = NL + "\t\t";
  protected final String TEXT_522 = NL + "        for(int i_";
  protected final String TEXT_523 = " = begin_line_";
  protected final String TEXT_524 = "; i_";
  protected final String TEXT_525 = " < end_line_";
  protected final String TEXT_526 = "; i_";
  protected final String TEXT_527 = "++){" + NL + "" + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_528 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_529 = " != -1 && nb_line_";
  protected final String TEXT_530 = " >= limit_";
  protected final String TEXT_531 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "" + NL + "            while (i_";
  protected final String TEXT_532 = " >= rowCount_";
  protected final String TEXT_533 = " + currentRows_";
  protected final String TEXT_534 = ") {" + NL + "                rowCount_";
  protected final String TEXT_535 = " += currentRows_";
  protected final String TEXT_536 = ";" + NL + "                sheet_";
  protected final String TEXT_537 = " = sheetList_";
  protected final String TEXT_538 = ".get(++sheetIndex_";
  protected final String TEXT_539 = ");" + NL + "                currentRows_";
  protected final String TEXT_540 = " = (sheet_";
  protected final String TEXT_541 = ".getLastRowNum()+1);" + NL + "            }" + NL + "            globalMap.put(\"";
  protected final String TEXT_542 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_543 = ".getSheetName());";
  protected final String TEXT_544 = NL + "            if (rowCount_";
  protected final String TEXT_545 = " <= i_";
  protected final String TEXT_546 = ") {" + NL + "                row_";
  protected final String TEXT_547 = " = sheet_";
  protected final String TEXT_548 = ".getRow(i_";
  protected final String TEXT_549 = " - rowCount_";
  protected final String TEXT_550 = ");" + NL + "            }";
  protected final String TEXT_551 = NL + "            if (rowCount_";
  protected final String TEXT_552 = " <= i_";
  protected final String TEXT_553 = " && i_";
  protected final String TEXT_554 = " - rowCount_";
  protected final String TEXT_555 = " >= (";
  protected final String TEXT_556 = "begin_line_";
  protected final String TEXT_557 = "isFirstRow_";
  protected final String TEXT_558 = "?begin_line_";
  protected final String TEXT_559 = ":(begin_line_";
  protected final String TEXT_560 = "+1)";
  protected final String TEXT_561 = ")" + NL + "            \t&& currentRows_";
  protected final String TEXT_562 = " - footer_input_";
  protected final String TEXT_563 = " > i_";
  protected final String TEXT_564 = " - rowCount_";
  protected final String TEXT_565 = ") {" + NL + "                row_";
  protected final String TEXT_566 = " = sheet_";
  protected final String TEXT_567 = ".getRow(i_";
  protected final String TEXT_568 = " - rowCount_";
  protected final String TEXT_569 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_570 = NL + "\t\t\tisFirstRow_";
  protected final String TEXT_571 = " = false;" + NL + "\t\t";
  protected final String TEXT_572 = NL + "\t\t    ";
  protected final String TEXT_573 = " = null;";
  protected final String TEXT_574 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_575 = " = new String[tempRowLength_";
  protected final String TEXT_576 = "];";
  protected final String TEXT_577 = NL + "\t\t\t\tList<Boolean> datelist_";
  protected final String TEXT_578 = " = new java.util.ArrayList<Boolean>();" + NL + "\t\t\t\tList<String> patternlist_";
  protected final String TEXT_579 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_580 = NL + "\t\t\t\t\t\t\tdatelist_";
  protected final String TEXT_581 = ".add(";
  protected final String TEXT_582 = ");" + NL + "\t\t\t\t\t\t\tpatternlist_";
  protected final String TEXT_583 = ".add(";
  protected final String TEXT_584 = ");";
  protected final String TEXT_585 = NL + "\t\t\tint excel_end_column_";
  protected final String TEXT_586 = ";" + NL + "\t\t\tif(row_";
  protected final String TEXT_587 = "==null){" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_588 = "=0;" + NL + "\t\t\t}else{" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_589 = "=row_";
  protected final String TEXT_590 = ".getLastCellNum();" + NL + "\t\t\t}" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_591 = ";" + NL + "\t\t\tif(end_column_";
  protected final String TEXT_592 = " == -1){" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_593 = " = excel_end_column_";
  protected final String TEXT_594 = ";" + NL + "\t\t\t}" + NL + "\t\t\telse{" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_595 = " = end_column_";
  protected final String TEXT_596 = " >\texcel_end_column_";
  protected final String TEXT_597 = " ? excel_end_column_";
  protected final String TEXT_598 = " : end_column_";
  protected final String TEXT_599 = ";" + NL + "\t\t\t}" + NL + "\t\t\torg.apache.poi.ss.formula.eval.NumberEval ne_";
  protected final String TEXT_600 = " = null;" + NL + "\t\t\tfor(int i=0;i<tempRowLength_";
  protected final String TEXT_601 = ";i++){" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_602 = " < actual_end_column_";
  protected final String TEXT_603 = "){" + NL + "\t\t\t\t\torg.apache.poi.ss.usermodel.Cell cell_";
  protected final String TEXT_604 = " = row_";
  protected final String TEXT_605 = ".getCell(i + start_column_";
  protected final String TEXT_606 = ");" + NL + "\t\t\t\t\tif(cell_";
  protected final String TEXT_607 = "!=null){" + NL + "\t\t\t\t\tswitch (cell_";
  protected final String TEXT_608 = ".getCellType()) {" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                            temp_row_";
  protected final String TEXT_609 = "[i] = cell_";
  protected final String TEXT_610 = ".getRichStringCellValue().getString();" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_611 = ")) {";
  protected final String TEXT_612 = NL + "\t                            \tif(i>=";
  protected final String TEXT_613 = " && i<(";
  protected final String TEXT_614 = " + dynamic_";
  protected final String TEXT_615 = ".getColumnCount())){" + NL + "\t                            \t\ttemp_row_";
  protected final String TEXT_616 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_617 = ".getDateCellValue(),";
  protected final String TEXT_618 = ");" + NL + "\t                            \t}else{";
  protected final String TEXT_619 = NL + "\t\t\t\t\t\t\t\t\tint dateColIndex_";
  protected final String TEXT_620 = " = i;";
  protected final String TEXT_621 = NL + "\t\t\t\t\t\t\t\t\t\tif(i>";
  protected final String TEXT_622 = "){" + NL + "\t\t\t\t\t\t\t\t\t\t\tdateColIndex_";
  protected final String TEXT_623 = " = i-dynamic_";
  protected final String TEXT_624 = ".getColumnCount()+1;" + NL + "\t\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_625 = NL + "                    \t        \tif(datelist_";
  protected final String TEXT_626 = ".get(dateColIndex_";
  protected final String TEXT_627 = ")){" + NL + "                        \t        \ttemp_row_";
  protected final String TEXT_628 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_629 = ".getDateCellValue(),patternlist_";
  protected final String TEXT_630 = ".get(dateColIndex_";
  protected final String TEXT_631 = "));" + NL + "                            \t   \t} else{" + NL + "                                \t\ttemp_row_";
  protected final String TEXT_632 = "[i] = cell_";
  protected final String TEXT_633 = ".getDateCellValue().toString();" + NL + "                                \t}";
  protected final String TEXT_634 = NL + "\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_635 = "[i] =cell_";
  protected final String TEXT_636 = ".getDateCellValue().toString();";
  protected final String TEXT_637 = NL + "                            \t\t}";
  protected final String TEXT_638 = NL + "                            } else {" + NL + "                                temp_row_";
  protected final String TEXT_639 = "[i] = df_";
  protected final String TEXT_640 = ".format(cell_";
  protected final String TEXT_641 = ".getNumericCellValue());" + NL + "                            }" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                            temp_row_";
  protected final String TEXT_642 = "[i] =String.valueOf(cell_";
  protected final String TEXT_643 = ".getBooleanCellValue());" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA:" + NL + "        \t\t\t\t\tswitch (cell_";
  protected final String TEXT_644 = ".getCachedFormulaResultType()) {" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                                    temp_row_";
  protected final String TEXT_645 = "[i] = cell_";
  protected final String TEXT_646 = ".getRichStringCellValue().getString();" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_647 = ")) {";
  protected final String TEXT_648 = NL + "\t\t\t                            \tif(i>=";
  protected final String TEXT_649 = " && i<(";
  protected final String TEXT_650 = " + dynamic_";
  protected final String TEXT_651 = ".getColumnCount())){" + NL + "\t\t\t                            \t\ttemp_row_";
  protected final String TEXT_652 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_653 = ".getDateCellValue(),";
  protected final String TEXT_654 = ");" + NL + "\t\t\t                            \t}else{";
  protected final String TEXT_655 = NL + "\t\t\t\t\t\t\t\t\t\t\tint dateColIndex_";
  protected final String TEXT_656 = " = i;";
  protected final String TEXT_657 = NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(i>";
  protected final String TEXT_658 = "){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tdateColIndex_";
  protected final String TEXT_659 = " = i-dynamic_";
  protected final String TEXT_660 = ".getColumnCount()+1;" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}";
  protected final String TEXT_661 = NL + "                    \t        \t\t\tif(datelist_";
  protected final String TEXT_662 = ".get(dateColIndex_";
  protected final String TEXT_663 = ")){" + NL + "                        \t        \t\t\ttemp_row_";
  protected final String TEXT_664 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_665 = ".getDateCellValue(),patternlist_";
  protected final String TEXT_666 = ".get(dateColIndex_";
  protected final String TEXT_667 = "));" + NL + "                            \t   \t\t\t} else{" + NL + "                                \t\t\t\ttemp_row_";
  protected final String TEXT_668 = "[i] =cell_";
  protected final String TEXT_669 = ".getDateCellValue().toString();" + NL + "                                \t\t\t}";
  protected final String TEXT_670 = NL + "\t\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_671 = "[i] =cell_";
  protected final String TEXT_672 = ".getDateCellValue().toString();";
  protected final String TEXT_673 = NL + "                            \t\t\t\t}";
  protected final String TEXT_674 = NL + "                                    } else {" + NL + "\t                                    ne_";
  protected final String TEXT_675 = " = new org.apache.poi.ss.formula.eval.NumberEval(cell_";
  protected final String TEXT_676 = ".getNumericCellValue());" + NL + "\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_677 = "[i] = ne_";
  protected final String TEXT_678 = ".getStringValue();" + NL + "                                    }" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                                    temp_row_";
  protected final String TEXT_679 = "[i] =String.valueOf(cell_";
  protected final String TEXT_680 = ".getBooleanCellValue());" + NL + "                                    break;" + NL + "                                default:" + NL + "                            \t\ttemp_row_";
  protected final String TEXT_681 = "[i] = \"\";" + NL + "                            }" + NL + "                            break;" + NL + "                        default:" + NL + "                            temp_row_";
  protected final String TEXT_682 = "[i] = \"\";" + NL + "                        }" + NL + "                \t}" + NL + "                \telse{" + NL + "                \t\ttemp_row_";
  protected final String TEXT_683 = "[i]=\"\";" + NL + "                \t}" + NL + "" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_684 = "[i]=\"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_685 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_686 = " = new ";
  protected final String TEXT_687 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_688 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_689 = " = \"\";" + NL + "\t\t\ttry{";
  protected final String TEXT_690 = NL + "\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_691 = " = ";
  protected final String TEXT_692 = "+dynamic_column_count_";
  protected final String TEXT_693 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_694 = NL + "\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_695 = " = ";
  protected final String TEXT_696 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_697 = NL + "\t\t\tif( temp_row_";
  protected final String TEXT_698 = "[columnIndex_";
  protected final String TEXT_699 = "]";
  protected final String TEXT_700 = ".length() > 0) {";
  protected final String TEXT_701 = NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_702 = "=columnIndex_";
  protected final String TEXT_703 = " + start_column_";
  protected final String TEXT_704 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_705 = " = \"";
  protected final String TEXT_706 = "\";" + NL;
  protected final String TEXT_707 = NL + "\t\t\t\t";
  protected final String TEXT_708 = ".";
  protected final String TEXT_709 = " = temp_row_";
  protected final String TEXT_710 = "[columnIndex_";
  protected final String TEXT_711 = "]";
  protected final String TEXT_712 = ";";
  protected final String TEXT_713 = NL + "\t\t\t\tif(";
  protected final String TEXT_714 = "<actual_end_column_";
  protected final String TEXT_715 = "){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tif(row_";
  protected final String TEXT_716 = ".getCell(columnIndex_";
  protected final String TEXT_717 = "+ start_column_";
  protected final String TEXT_718 = ").getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(row_";
  protected final String TEXT_719 = ".getCell(columnIndex_";
  protected final String TEXT_720 = "+ start_column_";
  protected final String TEXT_721 = "))){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_722 = ".";
  protected final String TEXT_723 = " = row_";
  protected final String TEXT_724 = ".getCell(columnIndex_";
  protected final String TEXT_725 = "+ start_column_";
  protected final String TEXT_726 = ").getDateCellValue();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\telse{" + NL + "                            java.util.Date tempDate_";
  protected final String TEXT_727 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_728 = "[columnIndex_";
  protected final String TEXT_729 = "]";
  protected final String TEXT_730 = ", ";
  protected final String TEXT_731 = ");" + NL + "                            if(tempDate_";
  protected final String TEXT_732 = ".after((new SimpleDateFormat(\"yyyy/MM/dd hh:mm:ss.SSS\")).parse(\"9999/12/31 23:59:59.999\"))||tempDate_";
  protected final String TEXT_733 = ".before((new SimpleDateFormat(\"yyyy/MM/dd\")).parse(\"1900/01/01\"))){" + NL + "                                throw new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_734 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_735 = " + \" )\");" + NL + "                            }else{";
  protected final String TEXT_736 = NL + "                                ";
  protected final String TEXT_737 = ".";
  protected final String TEXT_738 = " = tempDate_";
  protected final String TEXT_739 = ";" + NL + "                            }" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_740 = NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_741 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_742 = " + \" )\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL;
  protected final String TEXT_743 = NL + "\t\t\t\t";
  protected final String TEXT_744 = ".";
  protected final String TEXT_745 = " = ParserUtils.parseTo_";
  protected final String TEXT_746 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_747 = "[columnIndex_";
  protected final String TEXT_748 = "]";
  protected final String TEXT_749 = ", ";
  protected final String TEXT_750 = ", ";
  protected final String TEXT_751 = "));";
  protected final String TEXT_752 = NL + "\t\t\t\t";
  protected final String TEXT_753 = ".";
  protected final String TEXT_754 = " = ParserUtils.parseTo_";
  protected final String TEXT_755 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_756 = "[columnIndex_";
  protected final String TEXT_757 = "]";
  protected final String TEXT_758 = ", null, '.'==decimalChar_";
  protected final String TEXT_759 = " ? null : decimalChar_";
  protected final String TEXT_760 = "));";
  protected final String TEXT_761 = NL + "\t\t\t\t";
  protected final String TEXT_762 = ".";
  protected final String TEXT_763 = " = temp_row_";
  protected final String TEXT_764 = "[columnIndex_";
  protected final String TEXT_765 = "]";
  protected final String TEXT_766 = ".getBytes(";
  protected final String TEXT_767 = ");";
  protected final String TEXT_768 = NL + "\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_769 = ".clearColumnValues();" + NL + "\t\t\t\t\t\t\tint fieldCount = row_";
  protected final String TEXT_770 = ".getLastCellNum()-row_";
  protected final String TEXT_771 = ".getFirstCellNum()+1;" + NL + "\t\t\t\t\t\t\tdynamic_column_count_";
  protected final String TEXT_772 = " = dynamic_";
  protected final String TEXT_773 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_774 = " ; i++) {" + NL + "\t\t\t\t\t\t\t\tif ((";
  protected final String TEXT_775 = "+i) < fieldCount){" + NL + "\t\t\t\t\t\t\t\t\tif(temp_row_";
  protected final String TEXT_776 = "[";
  protected final String TEXT_777 = "+i]";
  protected final String TEXT_778 = ".length() < 1){" + NL + "\t\t\t\t\t\t\t\t\t\temptyColumnCount_";
  protected final String TEXT_779 = "++;" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_780 = ".addColumnValue(temp_row_";
  protected final String TEXT_781 = "[";
  protected final String TEXT_782 = "+i]";
  protected final String TEXT_783 = ");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\telse{" + NL + "\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_784 = ".addColumnValue(\"\");" + NL + "\t\t\t\t\t\t\t\t\temptyColumnCount_";
  protected final String TEXT_785 = "++;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_786 = ".";
  protected final String TEXT_787 = " =dynamic_";
  protected final String TEXT_788 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_789 = NL + "\t\t\t\t";
  protected final String TEXT_790 = ".";
  protected final String TEXT_791 = " = ParserUtils.parseTo_";
  protected final String TEXT_792 = "(temp_row_";
  protected final String TEXT_793 = "[columnIndex_";
  protected final String TEXT_794 = "]";
  protected final String TEXT_795 = ");";
  protected final String TEXT_796 = NL + "\t\t\t}else{";
  protected final String TEXT_797 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_798 = "' in '";
  protected final String TEXT_799 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_800 = NL + "\t\t\t\t";
  protected final String TEXT_801 = ".";
  protected final String TEXT_802 = " = ";
  protected final String TEXT_803 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_804 = "++;";
  protected final String TEXT_805 = NL + "\t\t\t}";
  protected final String TEXT_806 = NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_807 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_808 = " ";
  protected final String TEXT_809 = " = null; ";
  protected final String TEXT_810 = NL;
  protected final String TEXT_811 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_812 = " >= ";
  protected final String TEXT_813 = "+dynamic_column_count_";
  protected final String TEXT_814 = "-1";
  protected final String TEXT_815 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_816 = NL + "\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_817 = " = true;";
  protected final String TEXT_818 = NL + "\t            throw(e);";
  protected final String TEXT_819 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_820 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_821 = NL + "\t\t\t\t\t";
  protected final String TEXT_822 = " = new ";
  protected final String TEXT_823 = "Struct();";
  protected final String TEXT_824 = NL + "\t\t\t\t\t";
  protected final String TEXT_825 = ".";
  protected final String TEXT_826 = " = ";
  protected final String TEXT_827 = ".";
  protected final String TEXT_828 = ";";
  protected final String TEXT_829 = NL + "\t\t\t\t\t";
  protected final String TEXT_830 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_831 = "+ \" column: \" + curColName_";
  protected final String TEXT_832 = " + \" (No. \" + curColNum_";
  protected final String TEXT_833 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_834 = " = null;";
  protected final String TEXT_835 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_836 = " = null;";
  protected final String TEXT_837 = NL + "\t\t\t\t\t";
  protected final String TEXT_838 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_839 = "+ \" column: \" + curColName_";
  protected final String TEXT_840 = " + \" (No. \" + curColNum_";
  protected final String TEXT_841 = " + \")\";";
  protected final String TEXT_842 = NL + "\t\t\t}" + NL + NL;
  protected final String TEXT_843 = NL + "\t\t";
  protected final String TEXT_844 = "if(!whetherReject_";
  protected final String TEXT_845 = ") { ";
  protected final String TEXT_846 = NL + "             if(";
  protected final String TEXT_847 = " == null){" + NL + "            \t ";
  protected final String TEXT_848 = " = new ";
  protected final String TEXT_849 = "Struct();" + NL + "             }";
  protected final String TEXT_850 = NL + "\t    \t ";
  protected final String TEXT_851 = ".";
  protected final String TEXT_852 = " = ";
  protected final String TEXT_853 = ".";
  protected final String TEXT_854 = ";";
  protected final String TEXT_855 = NL + "\t\t";
  protected final String TEXT_856 = " } ";
  protected final String TEXT_857 = NL + "\t\tObject source_";
  protected final String TEXT_858 = " = ";
  protected final String TEXT_859 = ";" + NL + "\t\tcom.talend.excel.xssf.event.ExcelReader excelReader_";
  protected final String TEXT_860 = " = null;" + NL + "" + NL + "\t\tif(source_";
  protected final String TEXT_861 = " instanceof java.io.InputStream || source_";
  protected final String TEXT_862 = " instanceof String){" + NL + "\t\t\texcelReader_";
  protected final String TEXT_863 = " = new com.talend.excel.xssf.event.ExcelReader();" + NL + "\t\t}else{" + NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "" + NL + "\t\ttry {";
  protected final String TEXT_864 = NL + "\t\texcelReader_";
  protected final String TEXT_865 = ".addSheetName(\".*\",true);";
  protected final String TEXT_866 = NL + "\t\texcelReader_";
  protected final String TEXT_867 = ".addSheetName(";
  protected final String TEXT_868 = ", ";
  protected final String TEXT_869 = ");";
  protected final String TEXT_870 = NL + "\t\tint start_column_";
  protected final String TEXT_871 = " = ";
  protected final String TEXT_872 = "0";
  protected final String TEXT_873 = "-1";
  protected final String TEXT_874 = ";" + NL + "\t\tint end_column_";
  protected final String TEXT_875 = " = ";
  protected final String TEXT_876 = "-1";
  protected final String TEXT_877 = "-1";
  protected final String TEXT_878 = ";" + NL + "\t\tif(start_column_";
  protected final String TEXT_879 = " >=0) {//follow start column" + NL + "\t\t\t";
  protected final String TEXT_880 = NL + "\t\t\t\t\tend_column_";
  protected final String TEXT_881 = " = 16384;" + NL + "\t\t\t\t";
  protected final String TEXT_882 = NL + "\t\t\t\t\tend_column_";
  protected final String TEXT_883 = " = ";
  protected final String TEXT_884 = "-1;" + NL + "\t\t\t\t";
  protected final String TEXT_885 = NL + "\t\t\t\tend_column_";
  protected final String TEXT_886 = " = start_column_";
  protected final String TEXT_887 = " + ";
  protected final String TEXT_888 = " - 1;" + NL + "\t\t\t";
  protected final String TEXT_889 = NL + "\t\t} else if(end_column_";
  protected final String TEXT_890 = " >= 0) {//follow end column" + NL + "\t\t\tstart_column_";
  protected final String TEXT_891 = " = end_column_";
  protected final String TEXT_892 = " - ";
  protected final String TEXT_893 = " + 1;" + NL + "\t\t}" + NL + "" + NL + "\t\tif(end_column_";
  protected final String TEXT_894 = "<0 || start_column_";
  protected final String TEXT_895 = "<0) {" + NL + "\t\t\tthrow new RuntimeException(\"Error start column and end column.\");" + NL + "\t\t}" + NL + "\t\tint actual_end_column_";
  protected final String TEXT_896 = " = end_column_";
  protected final String TEXT_897 = " ;" + NL + "" + NL + "\t\tint header_";
  protected final String TEXT_898 = " = ";
  protected final String TEXT_899 = "0";
  protected final String TEXT_900 = ";" + NL + "\t\tint limit_";
  protected final String TEXT_901 = " = ";
  protected final String TEXT_902 = "-1";
  protected final String TEXT_903 = ";" + NL + "" + NL + "\t\tint nb_line_";
  protected final String TEXT_904 = " = 0;" + NL + "" + NL + "\t\t//for the number format" + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_905 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "        char decimalChar_";
  protected final String TEXT_906 = " = df_";
  protected final String TEXT_907 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "" + NL + "\t\tif(source_";
  protected final String TEXT_908 = " instanceof String){" + NL + "\t\t\texcelReader_";
  protected final String TEXT_909 = ".parse((String)source_";
  protected final String TEXT_910 = ",";
  protected final String TEXT_911 = ");" + NL + "\t\t} else if(source_";
  protected final String TEXT_912 = " instanceof java.io.InputStream) {" + NL + "\t\t\texcelReader_";
  protected final String TEXT_913 = ".parse((java.io.InputStream)source_";
  protected final String TEXT_914 = ",";
  protected final String TEXT_915 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_916 = NL + "\t\t\tif(header_";
  protected final String TEXT_917 = " > 0){" + NL + "\t\t\t\theader_";
  protected final String TEXT_918 = " = header_";
  protected final String TEXT_919 = " - 1;" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_920 = NL + NL + NL + "\t\twhile((header_";
  protected final String TEXT_921 = "--)>0 && excelReader_";
  protected final String TEXT_922 = ".hasNext()) {//skip the header" + NL + "\t\t\texcelReader_";
  protected final String TEXT_923 = ".next();" + NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_924 = NL + "\t\twhile(excelReader_";
  protected final String TEXT_925 = ".hasNext()) {" + NL + "\t\t\tint emptyColumnCount_";
  protected final String TEXT_926 = " = 0;" + NL + "" + NL + "\t\t\tif (limit_";
  protected final String TEXT_927 = " != -1 && nb_line_";
  protected final String TEXT_928 = " >= limit_";
  protected final String TEXT_929 = ") {" + NL + "\t\t\t\texcelReader_";
  protected final String TEXT_930 = ".stopRead();" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "" + NL + "        \tjava.util.List<String> row_";
  protected final String TEXT_931 = " = excelReader_";
  protected final String TEXT_932 = ".next();";
  protected final String TEXT_933 = NL + "\t\t";
  protected final String TEXT_934 = " = null;";
  protected final String TEXT_935 = NL + "\t\t\t\t\t" + NL + "\t\tString[] temp_row_";
  protected final String TEXT_936 = " = new String[tempRowLength_";
  protected final String TEXT_937 = "];" + NL + "\t\t";
  protected final String TEXT_938 = NL + "\t\t\tactual_end_column_";
  protected final String TEXT_939 = " = end_column_";
  protected final String TEXT_940 = "+dynamic_";
  protected final String TEXT_941 = ".getColumnCount()-1;" + NL + "\t\t";
  protected final String TEXT_942 = NL + "\t\tfor(int i_";
  protected final String TEXT_943 = "=0;i_";
  protected final String TEXT_944 = " < tempRowLength_";
  protected final String TEXT_945 = ";i_";
  protected final String TEXT_946 = "++){" + NL + "\t\t\tint current_";
  protected final String TEXT_947 = " = i_";
  protected final String TEXT_948 = " + start_column_";
  protected final String TEXT_949 = ";" + NL + "\t\t\tif(current_";
  protected final String TEXT_950 = " <= actual_end_column_";
  protected final String TEXT_951 = "){" + NL + "\t\t\t\tif(current_";
  protected final String TEXT_952 = " < row_";
  protected final String TEXT_953 = ".size()){" + NL + "\t\t\t\t\tString column_";
  protected final String TEXT_954 = " = row_";
  protected final String TEXT_955 = ".get(current_";
  protected final String TEXT_956 = ");" + NL + "\t\t\t\t\tif(column_";
  protected final String TEXT_957 = "!=null) {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_958 = "[i_";
  protected final String TEXT_959 = "] = column_";
  protected final String TEXT_960 = ";" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_961 = "[i_";
  protected final String TEXT_962 = "]=\"\";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_963 = "[i_";
  protected final String TEXT_964 = "]=\"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttemp_row_";
  protected final String TEXT_965 = "[i_";
  protected final String TEXT_966 = "]=\"\";" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tboolean whetherReject_";
  protected final String TEXT_967 = " = false;" + NL + "\t\t";
  protected final String TEXT_968 = " = new ";
  protected final String TEXT_969 = "Struct();" + NL + "\t\tint curColNum_";
  protected final String TEXT_970 = " = -1;" + NL + "\t\tString curColName_";
  protected final String TEXT_971 = " = \"\";" + NL + "" + NL + "\t\ttry{";
  protected final String TEXT_972 = NL + "\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_973 = " = ";
  protected final String TEXT_974 = "+dynamic_column_count_";
  protected final String TEXT_975 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_976 = NL + "\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_977 = " = ";
  protected final String TEXT_978 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_979 = NL + "\t\t\tif( temp_row_";
  protected final String TEXT_980 = "[columnIndex_";
  protected final String TEXT_981 = "]";
  protected final String TEXT_982 = ".length() > 0) {";
  protected final String TEXT_983 = NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_984 = "=columnIndex_";
  protected final String TEXT_985 = " + start_column_";
  protected final String TEXT_986 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_987 = " = \"";
  protected final String TEXT_988 = "\";" + NL;
  protected final String TEXT_989 = NL + "\t\t\t\t";
  protected final String TEXT_990 = ".";
  protected final String TEXT_991 = " = temp_row_";
  protected final String TEXT_992 = "[columnIndex_";
  protected final String TEXT_993 = "]";
  protected final String TEXT_994 = ";";
  protected final String TEXT_995 = NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_996 = ".";
  protected final String TEXT_997 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_998 = "[columnIndex_";
  protected final String TEXT_999 = "]";
  protected final String TEXT_1000 = ", ";
  protected final String TEXT_1001 = ");" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_1002 = NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_1003 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_1004 = " + \" )\");" + NL + "\t\t\t\t}" + NL;
  protected final String TEXT_1005 = NL + "\t\t\t\t";
  protected final String TEXT_1006 = ".";
  protected final String TEXT_1007 = " = ParserUtils.parseTo_";
  protected final String TEXT_1008 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_1009 = "[columnIndex_";
  protected final String TEXT_1010 = "]";
  protected final String TEXT_1011 = ", ";
  protected final String TEXT_1012 = ", ";
  protected final String TEXT_1013 = "));";
  protected final String TEXT_1014 = NL + "\t\t\t\t";
  protected final String TEXT_1015 = ".";
  protected final String TEXT_1016 = " = ParserUtils.parseTo_";
  protected final String TEXT_1017 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_1018 = "[columnIndex_";
  protected final String TEXT_1019 = "]";
  protected final String TEXT_1020 = ", null, '.'==decimalChar_";
  protected final String TEXT_1021 = " ? null : decimalChar_";
  protected final String TEXT_1022 = "));";
  protected final String TEXT_1023 = NL + "\t\t\t\t";
  protected final String TEXT_1024 = ".";
  protected final String TEXT_1025 = " = temp_row_";
  protected final String TEXT_1026 = "[columnIndex_";
  protected final String TEXT_1027 = "]";
  protected final String TEXT_1028 = ".getBytes(";
  protected final String TEXT_1029 = ");";
  protected final String TEXT_1030 = NL + "\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_1031 = ".clearColumnValues();" + NL + "\t\t\t\t\t\t\tint fieldCount = row_";
  protected final String TEXT_1032 = ".size();" + NL + "\t\t\t\t\t\t\tdynamic_column_count_";
  protected final String TEXT_1033 = " = dynamic_";
  protected final String TEXT_1034 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_1035 = " ; i++) {" + NL + "\t\t\t\t\t\t\t\tif ((";
  protected final String TEXT_1036 = "+i) < fieldCount){" + NL + "\t\t\t\t\t\t\t\t\tif(temp_row_";
  protected final String TEXT_1037 = "[";
  protected final String TEXT_1038 = "+i]";
  protected final String TEXT_1039 = ".length() < 1){" + NL + "\t\t\t\t\t\t\t\t\t\temptyColumnCount_";
  protected final String TEXT_1040 = "++;" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_1041 = ".addColumnValue(temp_row_";
  protected final String TEXT_1042 = "[";
  protected final String TEXT_1043 = "+i]";
  protected final String TEXT_1044 = ");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\telse{" + NL + "\t\t\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_1045 = ".addColumnValue(\"\");" + NL + "\t\t\t\t\t\t\t\t\temptyColumnCount_";
  protected final String TEXT_1046 = "++;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_1047 = ".";
  protected final String TEXT_1048 = " =dynamic_";
  protected final String TEXT_1049 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_1050 = NL + "\t\t\t\t";
  protected final String TEXT_1051 = ".";
  protected final String TEXT_1052 = " = ParserUtils.parseTo_";
  protected final String TEXT_1053 = "(temp_row_";
  protected final String TEXT_1054 = "[columnIndex_";
  protected final String TEXT_1055 = "]";
  protected final String TEXT_1056 = ");";
  protected final String TEXT_1057 = NL + "\t\t\t}else{";
  protected final String TEXT_1058 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_1059 = "' in '";
  protected final String TEXT_1060 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_1061 = NL + "\t\t\t\t";
  protected final String TEXT_1062 = ".";
  protected final String TEXT_1063 = " = ";
  protected final String TEXT_1064 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_1065 = "++;";
  protected final String TEXT_1066 = NL + "\t\t\t}";
  protected final String TEXT_1067 = NL + NL + "\t\t\t\t\tnb_line_";
  protected final String TEXT_1068 = "++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_1069 = " ";
  protected final String TEXT_1070 = " = null; ";
  protected final String TEXT_1071 = NL;
  protected final String TEXT_1072 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_1073 = " >= ";
  protected final String TEXT_1074 = "+dynamic_column_count_";
  protected final String TEXT_1075 = "-1";
  protected final String TEXT_1076 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_1077 = NL + "\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_1078 = " = true;";
  protected final String TEXT_1079 = NL + "\t            throw(e);";
  protected final String TEXT_1080 = NL + "\t\t\t\t\t";
  protected final String TEXT_1081 = " = new ";
  protected final String TEXT_1082 = "Struct();";
  protected final String TEXT_1083 = NL + "\t\t\t\t\t";
  protected final String TEXT_1084 = ".";
  protected final String TEXT_1085 = " = ";
  protected final String TEXT_1086 = ".";
  protected final String TEXT_1087 = ";";
  protected final String TEXT_1088 = NL + "\t\t\t\t\t";
  protected final String TEXT_1089 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1090 = "+ \" column: \" + curColName_";
  protected final String TEXT_1091 = " + \" (No. \" + curColNum_";
  protected final String TEXT_1092 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_1093 = " = null;";
  protected final String TEXT_1094 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_1095 = " = null;";
  protected final String TEXT_1096 = NL + "\t\t\t\t\t";
  protected final String TEXT_1097 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_1098 = "+ \" column: \" + curColName_";
  protected final String TEXT_1099 = " + \" (No. \" + curColNum_";
  protected final String TEXT_1100 = " + \")\";";
  protected final String TEXT_1101 = NL + "\t\t\t}" + NL;
  protected final String TEXT_1102 = NL + "        \t\t";
  protected final String TEXT_1103 = "if(!whetherReject_";
  protected final String TEXT_1104 = ") { ";
  protected final String TEXT_1105 = NL + "                     if(";
  protected final String TEXT_1106 = " == null){" + NL + "                    \t ";
  protected final String TEXT_1107 = " = new ";
  protected final String TEXT_1108 = "Struct();" + NL + "                     }";
  protected final String TEXT_1109 = NL + "        \t    \t ";
  protected final String TEXT_1110 = ".";
  protected final String TEXT_1111 = " = ";
  protected final String TEXT_1112 = ".";
  protected final String TEXT_1113 = ";";
  protected final String TEXT_1114 = NL + "        \t\t";
  protected final String TEXT_1115 = " } ";
  protected final String TEXT_1116 = NL;
  protected final String TEXT_1117 = NL;
  protected final String TEXT_1118 = NL;
  protected final String TEXT_1119 = NL;

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
	
    stringBuffer.append(TEXT_29);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
final String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		final boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));

		String fileName = ElementParameterParser.getValue(node,"__FILENAME__");

    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    	String firstColumn = ElementParameterParser.getValue(node, "__FIRST_COLUMN__");
    	String lastColumn = ElementParameterParser.getValue(node, "__LAST_COLUMN__");
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");

		String allSheets = ElementParameterParser.getValue(node, "__ALL_SHEETS__");
		boolean isAllSheets = (allSheets!=null&&!("").equals(allSheets))?("true").equals(allSheets):false;
		List<Map<String, String>> sheetNameList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SHEETLIST__");

		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

		boolean affect = ("true").equals(ElementParameterParser.getValue(node,"__AFFECT_EACH_SHEET__"));
		boolean stopOnEmptyRow = ("true").equals(ElementParameterParser.getValue(node,"__STOPREAD_ON_EMPTYROW__"));

		List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
		String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
		boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;

		String mode = ElementParameterParser.getValue(node,"__GENERATION_MODE__");
		final boolean eventMode = "EVENT_MODE".equals(mode);

		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		
		int dynamic_index = -1;
		boolean hasDynamic = false;
		List<IMetadataColumn> columnList = metadata.getListColumns();
		String datePattern = "\"dd-MM-yyyy\"";
		for(int i=0; columnList!=null && i< columnList.size(); i++) {
	        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
	            dynamic_index = i+1;
	            hasDynamic = true;
	            datePattern= columnList.get(i).getPattern();
	            break;
	        }
		}
		
		class GenerateCodeUtil{
			public void generateCode(int dynamic_index,int colLen,boolean hasDynamic){
				if(hasDynamic){
				
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_33);
    if(!version07){
    stringBuffer.append(TEXT_34);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_35);
    }else if(!eventMode){
    stringBuffer.append(TEXT_36);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_37);
    }else{
    stringBuffer.append(TEXT_38);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    
						if(!version07){
						
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    
						}else if(!eventMode){
						
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_48);
    
		    			}else{
		    			
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_52);
    
		    			}
		    			
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(colLen-1);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(colLen-dynamic_index);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
							if(!version07){
							
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_63);
    
							}else if(!eventMode){
							
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_67);
    
			    			}else{
			    			
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append( cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(colLen);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    
				}else{
				
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(colLen);
    stringBuffer.append(TEXT_93);
    
				}
				
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
			}
		}
		GenerateCodeUtil generateCodeUtil = new GenerateCodeUtil();
		if(hasDynamic){
			
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    
		}
		/* -------------------------- */
		if(!version07){//version judgement
			boolean bReadRealValue = ("true").equals(ElementParameterParser.getValue(node, "__READ_REAL_VALUE__"));
			boolean notNeedValidateOnCell = !("false").equals(ElementParameterParser.getValue(node,"__NOVALIDATE_ON_CELL__"));//make wizard work
			boolean suppressWarn = !("false").equals(ElementParameterParser.getValue(node,"__SUPPRESS_WARN__"));//make wizard work

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_105);
    
		if(notNeedValidateOnCell==true){

    stringBuffer.append(TEXT_106);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_107);
    
		}
		if(suppressWarn ==true){

    stringBuffer.append(TEXT_108);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_109);
    
		}

    stringBuffer.append(TEXT_110);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_136);
    
		if(isAllSheets){

    stringBuffer.append(TEXT_137);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_139);
    
		}else{

    stringBuffer.append(TEXT_140);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_141);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_142);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_147);
    
			}
		}

    stringBuffer.append(TEXT_148);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_160);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_161);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_163);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_164);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_165);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_173);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_174);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_175);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_176);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_177);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_181);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    }
    stringBuffer.append(TEXT_188);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    
		if(hasDynamic){
		
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    
		}
		
    stringBuffer.append(TEXT_204);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_205);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_224);
    
	if(!affect){

    stringBuffer.append(TEXT_225);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_231);
    
	}else{

    stringBuffer.append(TEXT_232);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_236);
    if(!hasDynamic){
    stringBuffer.append(TEXT_237);
    stringBuffer.append( cid );
    }else{
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_241);
    }
    stringBuffer.append(TEXT_242);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_250);
    
    }
    	if(hasDynamic){

    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    
		}
		
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    
//begin
//
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

    String rejectConnName = "";
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
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

    stringBuffer.append(TEXT_256);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_257);
    
    				}
    			}
    		}
    	}

		String firstConnName = "";
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				 	generateCodeUtil.generateCode(dynamic_index,size,hasDynamic);
					
    stringBuffer.append(TEXT_258);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_271);
    
                    if(bReadRealValue){

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    
                    }else{

    stringBuffer.append(TEXT_284);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    
                    }

    stringBuffer.append(TEXT_287);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    
//start
//
					for (int i=0; i<size; i++) {
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(metadata.isDynamicSchema()){
						
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    
						}else{
						
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_300);
    
						}
//
//end
		if(!column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_304);
    
		}

    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_310);
    
//start
//

						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
//
//end
    stringBuffer.append(TEXT_311);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_316);
    
//start
			} else if(javaType == JavaTypesManager.DATE) {
//
//end
    stringBuffer.append(TEXT_317);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_318);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_328);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    
//start
			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) {

    stringBuffer.append(TEXT_331);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_333);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_337);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_338);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_339);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) {
	
    stringBuffer.append(TEXT_340);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_346);
    
			}else if(column.getTalendType().equals("id_Dynamic")){
				dynamic_index = i;
			
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_353);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_355);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_356);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_360);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    
			} else {
//
//end
    stringBuffer.append(TEXT_367);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_369);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_373);
    
//start
//
						}
//
//end
		if(!column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_374);
    
//start
//
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {
//
//end
    stringBuffer.append(TEXT_375);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_377);
    
//start
//
						} else {
//
//end
    stringBuffer.append(TEXT_378);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_381);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_382);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_383);
    
//start
//
		}
					}
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    log4jFileUtil.debugRetriveData(node);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_386);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_387);
    }
    stringBuffer.append(TEXT_388);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_389);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(size );
    if(hasDynamic){
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    }
    stringBuffer.append(TEXT_393);
    
	}

    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_396);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_397);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_399);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_400);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_402);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_404);
    
                }
                
    stringBuffer.append(TEXT_405);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_411);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_412);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_414);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_415);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_419);
    }
        }
        
    stringBuffer.append(TEXT_420);
    
				}
			}
		if (conns.size()>0) {
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_421);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_424);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_425);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_426);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_427);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_428);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_432);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_433);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_434);
     } 
    
		}
		}

    
		} else if(!eventMode) {//version judgement /***excel 2007 xlsx and usermodel mode*****/

    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    
		if(isAllSheets){

    stringBuffer.append(TEXT_450);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    
		}else{

    stringBuffer.append(TEXT_456);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_457);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_458);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_460);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_462);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_463);
    
			}
		}

    stringBuffer.append(TEXT_464);
    stringBuffer.append( cid );
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
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_476);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_477);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_478);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_479);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_480);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_481);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_482);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_483);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_491);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_492);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_493);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_494);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_495);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_496);
    }
    stringBuffer.append(TEXT_497);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_498);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_502);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_504);
    }
    stringBuffer.append(TEXT_505);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_507);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_511);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_515);
    
		if(hasDynamic){
		
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_520);
    
		}
		
    stringBuffer.append(TEXT_521);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_522);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_524);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_525);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_529);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_530);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_531);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_533);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_535);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_536);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_537);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_538);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_539);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_540);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_543);
    
	if(!affect){

    stringBuffer.append(TEXT_544);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_545);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_546);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_547);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_548);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_549);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_550);
    
	}else{

    stringBuffer.append(TEXT_551);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_552);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_553);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_555);
    if(!hasDynamic){
    stringBuffer.append(TEXT_556);
    stringBuffer.append( cid );
    }else{
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_560);
    }
    stringBuffer.append(TEXT_561);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_563);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_564);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_565);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_566);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_567);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_568);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_569);
    
    }
    	if(hasDynamic){
	
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    
		}
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		String rejectConnName = "";
		List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
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

    stringBuffer.append(TEXT_572);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_573);
    
		    		}
		    	}
		    }
		}
		List<Map<String, String>> dateSelect = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DATESELECT__");
		boolean converDatetoString = ("true").equals(ElementParameterParser.getValue(node, "__CONVERTDATETOSTRING__"));
		String firstConnName = "";
		if (conns!=null) {//3
			if (conns.size()>0) {//4
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//5
					generateCodeUtil.generateCode(dynamic_index,size,hasDynamic);
					
    stringBuffer.append(TEXT_574);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    
			if(converDatetoString){

    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    
				for(IMetadataColumn column:listColumns){
					for(Map<String, String> line:dateSelect){// search in the date table
						String columnName = line.get("SCHEMA_COLUMN");
						if(column.getLabel().equals(columnName)){

    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(line.get("CONVERTDATE"));
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(line.get("PATTERN"));
    stringBuffer.append(TEXT_584);
    
						}
					}
				}
			}

    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_590);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_595);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_602);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_604);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_605);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    
                            	if(hasDynamic){

    stringBuffer.append(TEXT_612);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(datePattern);
    stringBuffer.append(TEXT_618);
    
		                     	}
								if(converDatetoString){

    stringBuffer.append(TEXT_619);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_620);
    
									if(hasDynamic){

    stringBuffer.append(TEXT_621);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_622);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    
									}

    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_627);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_631);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    
								}else{

    stringBuffer.append(TEXT_634);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    
								}
                            	if(hasDynamic){

    stringBuffer.append(TEXT_637);
    
                            	}

    stringBuffer.append(TEXT_638);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    
                            			if(hasDynamic){

    stringBuffer.append(TEXT_648);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(datePattern);
    stringBuffer.append(TEXT_654);
    
		                     			}
										if(converDatetoString){

    stringBuffer.append(TEXT_655);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_656);
    
											if(hasDynamic){

    stringBuffer.append(TEXT_657);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_658);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    
											}

    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_663);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_666);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_667);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    
										}else{

    stringBuffer.append(TEXT_670);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    
										}
                            			if(hasDynamic){

    stringBuffer.append(TEXT_673);
    
										}

    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_676);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_680);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_681);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_685);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_689);
    
					for (int i=0; i<size; i++) {//5
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(metadata.isDynamicSchema()){
						
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    
						}else{
						
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_695);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_696);
    
						}
		if(!column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_699);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_700);
    
		}

    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_703);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_705);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_706);
    
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_707);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_708);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_712);
    
						} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_713);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_714);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_715);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_717);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_718);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_720);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_721);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_722);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_723);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_725);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_728);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_729);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_730);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_733);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_735);
    stringBuffer.append(TEXT_736);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_737);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_739);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_740);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_741);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_742);
    
						}else if(JavaTypesManager.isNumberType(javaType)) {
							if(advancedSeparator) {

    stringBuffer.append(TEXT_743);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_744);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_745);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_747);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_748);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_749);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_750);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_751);
    
							} else {

    stringBuffer.append(TEXT_752);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_753);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_754);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_755);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_756);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_757);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_759);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_760);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_761);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_762);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_763);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_764);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_765);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_766);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_767);
    
						}else if(column.getTalendType().equals("id_Dynamic")){
							dynamic_index = i;
							
    stringBuffer.append(TEXT_768);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_769);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_770);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_771);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_772);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_774);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_775);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_776);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_777);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_778);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_779);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_780);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_781);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_782);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_783);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_784);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_785);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_786);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_787);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_788);
    
						} else {

    stringBuffer.append(TEXT_789);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_790);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_791);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_794);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_795);
    
						}
		if(!column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_796);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_797);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_798);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_799);
    
						} else {

    stringBuffer.append(TEXT_800);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_801);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_802);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_803);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_804);
    
						}

    stringBuffer.append(TEXT_805);
    
		}
					}

    stringBuffer.append(TEXT_806);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_807);
    log4jFileUtil.debugRetriveData(node);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_808);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_809);
    }
    stringBuffer.append(TEXT_810);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_811);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_812);
    stringBuffer.append(size );
    if(hasDynamic){
    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_814);
    }
    stringBuffer.append(TEXT_815);
    
	}

    stringBuffer.append(TEXT_816);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_817);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_818);
    
		        }
		        else{
					if(isLog4jEnabled){
    stringBuffer.append(TEXT_819);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_820);
    }
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_821);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_822);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_823);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_824);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_826);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_827);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_828);
    
					    }//16

    stringBuffer.append(TEXT_829);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_830);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_831);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_832);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_833);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_834);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_835);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_836);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_837);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_838);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_839);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_840);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_841);
    
					}//15
				}

    stringBuffer.append(TEXT_842);
    
				}
			}
		if (conns.size()>0) {
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_843);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_844);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_845);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_846);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_847);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_848);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_849);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_850);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_851);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_852);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_853);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_854);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_855);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_856);
     } 
    
		}
		}

    
		} else {//version judgement /***excel 2007 xlsx and event mode*****/

    stringBuffer.append(TEXT_857);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_858);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_859);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_860);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_861);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_862);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_863);
    
			if(isAllSheets){

    stringBuffer.append(TEXT_864);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_865);
    
			} else {
				for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_866);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_867);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_868);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_869);
    
				}
			}

    stringBuffer.append(TEXT_870);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_871);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_872);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_873);
    }
    stringBuffer.append(TEXT_874);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_875);
    if(("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_876);
    }else{
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_877);
    }
    stringBuffer.append(TEXT_878);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_879);
    
			if(hasDynamic){
				if(("").equals(lastColumn.trim())){
				
    stringBuffer.append(TEXT_880);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_881);
    
				}else{
				
    stringBuffer.append(TEXT_882);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_883);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_884);
    
				}
			}else{
			
    stringBuffer.append(TEXT_885);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_886);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_887);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_888);
    
			}
			
    stringBuffer.append(TEXT_889);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_890);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_891);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_892);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_893);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_894);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_895);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_896);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_897);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_898);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_899);
    }else{
    stringBuffer.append(header);
    }
    stringBuffer.append(TEXT_900);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_901);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_902);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_903);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_904);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_905);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_906);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_907);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_908);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_909);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_910);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_911);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_912);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_913);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_914);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_915);
    
		if(hasDynamic){
		
    stringBuffer.append(TEXT_916);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_917);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_918);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_919);
    
		}
		
    stringBuffer.append(TEXT_920);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_921);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_922);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_923);
    log4jFileUtil.startRetriveDataInfo();
    stringBuffer.append(TEXT_924);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_925);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_926);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_927);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_928);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_929);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_930);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_931);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_932);
    
			List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

			String rejectConnName = "";
			List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
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

    stringBuffer.append(TEXT_933);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_934);
    
    		    		}
    		    	}
    		    }
			}

			String firstConnName = "";
			if (conns!=null) {//TD1024
				if (conns.size()>0) {//TD528
					IConnection conn = conns.get(0);
    				firstConnName = conn.getName();
    				List<IMetadataColumn> listColumns = metadata.getListColumns();
    				int size = listColumns.size();
    				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//TD256
						generateCodeUtil.generateCode(dynamic_index,size,hasDynamic);
						
    stringBuffer.append(TEXT_935);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_936);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_937);
    
		if(hasDynamic && ("").equals(lastColumn.trim())){
		
    stringBuffer.append(TEXT_938);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_939);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_940);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_941);
    
		}
		
    stringBuffer.append(TEXT_942);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_943);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_944);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_945);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_946);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_947);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_948);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_949);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_950);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_951);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_952);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_953);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_954);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_955);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_956);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_957);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_958);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_959);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_960);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_961);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_962);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_963);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_964);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_965);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_966);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_967);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_968);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_969);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_970);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_971);
    
                		for (int i=0; i<size; i++) {//TD128
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(metadata.isDynamicSchema()){
						
    stringBuffer.append(TEXT_972);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_973);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_974);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_975);
    
						}else{
						
    stringBuffer.append(TEXT_976);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_977);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_978);
    
						}
		if(!column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_979);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_980);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_981);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_982);
    
		}

    stringBuffer.append(TEXT_983);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_984);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_985);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_986);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_987);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_988);
    
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_989);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_990);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_991);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_992);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_993);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_994);
    
						} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_995);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_996);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_997);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_998);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_999);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_1000);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_1001);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_1002);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1004);
    
						}else if(JavaTypesManager.isNumberType(javaType)) {
							if(advancedSeparator) {

    stringBuffer.append(TEXT_1005);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1007);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1010);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_1011);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_1012);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_1013);
    
							} else {

    stringBuffer.append(TEXT_1014);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1016);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1019);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1022);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_1023);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1027);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_1029);
    
						}else if(column.getTalendType().equals("id_Dynamic")){
							dynamic_index = i;
			
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1031);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_1036);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_1038);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_1039);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1041);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_1043);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1045);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1049);
    
						} else {

    stringBuffer.append(TEXT_1050);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1052);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1055);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_1056);
    
						}
		if(!column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_1057);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_1058);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_1060);
    
						} else {

    stringBuffer.append(TEXT_1061);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_1064);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_1065);
    
						}

    stringBuffer.append(TEXT_1066);
    
		}
					}//TD128

    stringBuffer.append(TEXT_1067);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1068);
    log4jFileUtil.debugRetriveData(node);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1070);
    }
    stringBuffer.append(TEXT_1071);
    
	if(stopOnEmptyRow && false){

    stringBuffer.append(TEXT_1072);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(size );
    if(hasDynamic){
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1075);
    }
    stringBuffer.append(TEXT_1076);
    
	}

    stringBuffer.append(TEXT_1077);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1078);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_1079);
    
		        }
		        else{
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_1080);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_1082);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_1083);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_1087);
    
					    }//16

    stringBuffer.append(TEXT_1088);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1093);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_1094);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1095);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_1096);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1100);
    
					}//15
				}

    stringBuffer.append(TEXT_1101);
    
    				}//TD256
				}//TD528

        		if (conns.size()>0) {//TD64
        			boolean isFirstEnter = true;
        			for (int i=0;i<conns.size();i++) {
        				IConnection conn = conns.get(i);
        				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_1102);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1104);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_1107);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_1108);
    
        			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_1109);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1113);
    
        				 	}
        				}
        			}

    stringBuffer.append(TEXT_1114);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_1115);
     } 
    
        		}//TD64

			}//TD1024

    stringBuffer.append(TEXT_1116);
    
		}//end version judgement

    stringBuffer.append(TEXT_1117);
    
	}
}
//
//end
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(TEXT_1119);
    return stringBuffer.toString();
  }
}
