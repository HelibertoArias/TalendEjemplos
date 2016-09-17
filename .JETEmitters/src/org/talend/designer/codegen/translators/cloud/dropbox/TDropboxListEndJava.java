package org.talend.designer.codegen.translators.cloud.dropbox;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TDropboxListEndJava
{
  protected static String nl;
  public static synchronized TDropboxListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDropboxListEndJava result = new TDropboxListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t}finally{" + NL + "\t\t\tif(";
  protected final String TEXT_3 = "_downloader != null){" + NL + "\t\t\t\tif(";
  protected final String TEXT_4 = "_downloader.body != null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_5 = "_downloader.body.close();" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_6 = "_downloader.close();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
