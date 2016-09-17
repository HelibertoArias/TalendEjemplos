package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileDeleteMainJava
{
  protected static String nl;
  public static synchronized TFileDeleteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileDeleteMainJava result = new TFileDeleteMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
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
  protected final String TEXT_30 = NL + " " + NL;
  protected final String TEXT_31 = NL + "class DeleteFolder";
  protected final String TEXT_32 = "{" + NL + "\t /**" + NL + "     * delete all the sub-files in 'file'" + NL + "     * " + NL + "     * @param file" + NL + "     */" + NL + "\tpublic boolean delete(java.io.File file) {" + NL + "        java.io.File[] files = file.listFiles();" + NL + "        for (int i = 0; i < files.length; i++) {" + NL + "            if (files[i].isFile()) {" + NL + "                files[i].delete();" + NL + "            } else if (files[i].isDirectory()) {" + NL + "                if (!files[i].delete()) {" + NL + "                    delete(files[i]);" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "        deleteDirectory(file);" + NL + "        return file.delete();" + NL + "    }" + NL + "" + NL + "    /**" + NL + "     * delete all the sub-folders in 'file'" + NL + "     * " + NL + "     * @param file" + NL + "     */" + NL + "    private void deleteDirectory(java.io.File file) {" + NL + "        java.io.File[] filed = file.listFiles();" + NL + "        for (int i = 0; i < filed.length; i++) {" + NL + "        \tif(filed[i].isDirectory()) {" + NL + "            \tdeleteDirectory(filed[i]);" + NL + "            }" + NL + "            filed[i].delete();" + NL + "        }" + NL + "    }" + NL + "" + NL + "}";
  protected final String TEXT_33 = NL + "\tjava.io.File path_";
  protected final String TEXT_34 = "=new java.io.File(";
  protected final String TEXT_35 = ");" + NL + "\tif(path_";
  protected final String TEXT_36 = ".exists()){" + NL + "\t\tif(path_";
  protected final String TEXT_37 = ".isFile()){" + NL + "\t    \tif(path_";
  protected final String TEXT_38 = ".delete()){" + NL + "\t    \t\tglobalMap.put(\"";
  protected final String TEXT_39 = "_CURRENT_STATUS\", \"File deleted.\");";
  protected final String TEXT_40 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_41 = " - File : \"+ path_";
  protected final String TEXT_42 = ".getAbsolutePath() + \" is deleted.\");";
  protected final String TEXT_43 = NL + "\t    \t}else{" + NL + "\t    \t\tglobalMap.put(\"";
  protected final String TEXT_44 = "_CURRENT_STATUS\", \"No file deleted.\");";
  protected final String TEXT_45 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_46 = " - Fail to delete file : \"+ path_";
  protected final String TEXT_47 = ".getAbsolutePath());";
  protected final String TEXT_48 = NL + "\t    \t}" + NL + "\t\t}else if(path_";
  protected final String TEXT_49 = ".isDirectory()){ " + NL + "\t    \tDeleteFolder";
  protected final String TEXT_50 = " df";
  protected final String TEXT_51 = " = new DeleteFolder";
  protected final String TEXT_52 = "();" + NL + "\t    \tif(df";
  protected final String TEXT_53 = ".delete(path_";
  protected final String TEXT_54 = ")){" + NL + "\t    \t\tglobalMap.put(\"";
  protected final String TEXT_55 = "_CURRENT_STATUS\", \"Path deleted.\");";
  protected final String TEXT_56 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_57 = " - Directory : \"+ path_";
  protected final String TEXT_58 = ".getAbsolutePath() + \" is deleted.\");";
  protected final String TEXT_59 = NL + "\t    \t}else{" + NL + "\t    \t\tglobalMap.put(\"";
  protected final String TEXT_60 = "_CURRENT_STATUS\", \"No path deleted.\");";
  protected final String TEXT_61 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_62 = " - Fail to delete directory : \"+ path_";
  protected final String TEXT_63 = ".getAbsolutePath());";
  protected final String TEXT_64 = NL + "\t    \t}" + NL + "\t\t}" + NL + "    }else{" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_65 = "_CURRENT_STATUS\", \"File or path does not exist or is invalid.\");";
  protected final String TEXT_66 = NL + "    \t\tthrow new RuntimeException(\"File or path does not exist or is invalid.\");";
  protected final String TEXT_67 = NL + "    \t\tlog.error(\"";
  protected final String TEXT_68 = " - File or directory : \"+ path_";
  protected final String TEXT_69 = ".getAbsolutePath() + \" does not exist or is invalid.\");";
  protected final String TEXT_70 = NL + "    }" + NL + "    globalMap.put(\"";
  protected final String TEXT_71 = "_DELETE_PATH\",";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + NL + "\tjava.io.File file";
  protected final String TEXT_74 = " = new java.io.File(";
  protected final String TEXT_75 = ");" + NL + "" + NL + "\tif(file";
  protected final String TEXT_76 = ".exists()&& file";
  protected final String TEXT_77 = ".isDirectory()){" + NL + "\t\tDeleteFolder";
  protected final String TEXT_78 = " df";
  protected final String TEXT_79 = " = new DeleteFolder";
  protected final String TEXT_80 = "();" + NL + "\t\tif(df";
  protected final String TEXT_81 = ".delete(file";
  protected final String TEXT_82 = ")){" + NL + "    \t\tglobalMap.put(\"";
  protected final String TEXT_83 = "_CURRENT_STATUS\", \"Path deleted.\");";
  protected final String TEXT_84 = NL + "    \t\tlog.info(\"";
  protected final String TEXT_85 = " - Directory : \"+ file";
  protected final String TEXT_86 = ".getAbsolutePath() + \" is deleted.\");";
  protected final String TEXT_87 = NL + "    \t}else{" + NL + "    \t\tglobalMap.put(\"";
  protected final String TEXT_88 = "_CURRENT_STATUS\", \"No path deleted.\");";
  protected final String TEXT_89 = NL + "    \t\tlog.info(\"";
  protected final String TEXT_90 = " - Fail to delete directory : \"+ file";
  protected final String TEXT_91 = ".getAbsolutePath());";
  protected final String TEXT_92 = NL + "    \t}" + NL + "\t}else{" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_93 = "_CURRENT_STATUS\", \"Path does not exist or is invalid.\");";
  protected final String TEXT_94 = NL + "    \t\tthrow new RuntimeException(\"Path does not exist or is invalid.\");";
  protected final String TEXT_95 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_96 = " - \"+ file";
  protected final String TEXT_97 = ".getAbsolutePath() + \" does not exist or is invalid or is not a directory.\");";
  protected final String TEXT_98 = NL + "    }" + NL + "    globalMap.put(\"";
  protected final String TEXT_99 = "_DELETE_PATH\",";
  protected final String TEXT_100 = ");";
  protected final String TEXT_101 = NL + "    java.io.File file_";
  protected final String TEXT_102 = "=new java.io.File(";
  protected final String TEXT_103 = ");" + NL + "    if(file_";
  protected final String TEXT_104 = ".exists()&& file_";
  protected final String TEXT_105 = ".isFile()){" + NL + "    \tif(file_";
  protected final String TEXT_106 = ".delete()){" + NL + "    \t\tglobalMap.put(\"";
  protected final String TEXT_107 = "_CURRENT_STATUS\", \"File deleted.\");";
  protected final String TEXT_108 = NL + "    \t\tlog.info(\"";
  protected final String TEXT_109 = " - File : \"+ file_";
  protected final String TEXT_110 = ".getAbsolutePath() + \" is deleted.\");";
  protected final String TEXT_111 = NL + "    \t}else{" + NL + "    \t\tglobalMap.put(\"";
  protected final String TEXT_112 = "_CURRENT_STATUS\", \"No file deleted.\");";
  protected final String TEXT_113 = NL + "    \t\tlog.info(\"";
  protected final String TEXT_114 = " - Fail to delete file : \"+ file_";
  protected final String TEXT_115 = ".getAbsolutePath());";
  protected final String TEXT_116 = NL + "    \t}" + NL + "    }else{" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_117 = "_CURRENT_STATUS\", \"File does not exist or is invalid.\");";
  protected final String TEXT_118 = NL + "    \t\tthrow new RuntimeException(\"File does not exist or is invalid.\");";
  protected final String TEXT_119 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_120 = " - \"+ file_";
  protected final String TEXT_121 = ".getAbsolutePath() + \" does not exist or is invalid or is not a file.\");";
  protected final String TEXT_122 = NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_123 = "_DELETE_PATH\",";
  protected final String TEXT_124 = ");";
  protected final String TEXT_125 = NL + "    " + NL + "     " + NL + " ";
  protected final String TEXT_126 = NL;

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
	
    stringBuffer.append(TEXT_30);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
String dirName = ElementParameterParser.getValue(node, "__DIRECTORY__");
String path = ElementParameterParser.getValue(node, "__PATH__");
String failon = ElementParameterParser.getValue(node, "__FAILON__");
boolean ifFolder = ("true").equals(ElementParameterParser.getValue(node, "__FOLDER__"));
boolean either = ("true").equals(ElementParameterParser.getValue(node, "__FOLDER_FILE__"));

final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

log4jFileUtil.componentStartInfo(node);

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
if(either){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    
				if(isLog4jEnabled) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
				}

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    
				if(isLog4jEnabled) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
				}

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    
				if(isLog4jEnabled) {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    
				}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
				if(isLog4jEnabled) {

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
				}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    
		if(("true").equals(failon)){

    stringBuffer.append(TEXT_66);
    
		} else if(isLog4jEnabled) {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
		}

    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_72);
    
}else if(ifFolder){

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(dirName);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
			}

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
			}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    
		if(("true").equals(failon)){

    stringBuffer.append(TEXT_94);
    
		} else if(isLog4jEnabled) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
		}

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(dirName);
    stringBuffer.append(TEXT_100);
    
}else{

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
			}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
			}

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
		if(("true").equals(failon)){

    stringBuffer.append(TEXT_118);
    
		} else if(isLog4jEnabled) {

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
		}

    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_124);
    
}


    stringBuffer.append(TEXT_125);
    stringBuffer.append(TEXT_126);
    return stringBuffer.toString();
  }
}
