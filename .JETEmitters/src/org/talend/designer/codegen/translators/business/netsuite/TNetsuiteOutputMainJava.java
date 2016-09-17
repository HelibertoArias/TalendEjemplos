package org.talend.designer.codegen.translators.business.netsuite;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class TNetsuiteOutputMainJava
{
  protected static String nl;
  public static synchronized TNetsuiteOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNetsuiteOutputMainJava result = new TNetsuiteOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL;
  protected final String TEXT_3 = NL + "                ";
  protected final String TEXT_4 = NL + "                ";
  protected final String TEXT_5 = " record_";
  protected final String TEXT_6 = " = new ";
  protected final String TEXT_7 = "();" + NL + "                ";
  protected final String TEXT_8 = NL + NL + "        \t    \t\t\tif (";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = " == null) {" + NL + "            \t\t\t\t\tcom.netsuite.webservices.platform.core.NullField fl_";
  protected final String TEXT_11 = " = record_";
  protected final String TEXT_12 = ".getNullFieldList();" + NL + "            \t\t\t\t\t" + NL + "            \t\t\t\t\tif (fl_";
  protected final String TEXT_13 = "==null) {" + NL + "            \t\t\t\t\t\trecord_";
  protected final String TEXT_14 = ".setNullFieldList(new com.netsuite.webservices.platform.core.NullField());" + NL + "            \t\t\t\t\t}" + NL + "            \t\t\t\t\t" + NL + "            \t\t\t\t\tString label_";
  protected final String TEXT_15 = " = \"";
  protected final String TEXT_16 = "\";" + NL + "            \t\t\t\t\tString field_";
  protected final String TEXT_17 = " = label_";
  protected final String TEXT_18 = ".substring(0, 1).toLowerCase() + label_";
  protected final String TEXT_19 = ".substring(1);" + NL + "            \t\t\t\t\tnsMgr_";
  protected final String TEXT_20 = ".setNullFieldValue(record_";
  protected final String TEXT_21 = ".getNullFieldList(), field_";
  protected final String TEXT_22 = ");" + NL + "        \t    \t\t\t} else {" + NL;
  protected final String TEXT_23 = NL + NL + "                \t\t\t\t\tjava.util.GregorianCalendar cal_";
  protected final String TEXT_24 = "_";
  protected final String TEXT_25 = " = new java.util.GregorianCalendar();" + NL + "    \t\t\t\t\t\t\t    cal_";
  protected final String TEXT_26 = "_";
  protected final String TEXT_27 = ".setTime(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ");" + NL + "    \t\t\t\t\t\t\t    javax.xml.datatype.XMLGregorianCalendar gc_";
  protected final String TEXT_30 = "_";
  protected final String TEXT_31 = " = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(cal_";
  protected final String TEXT_32 = "_";
  protected final String TEXT_33 = ");" + NL + "                \t\t\t\t\t\t" + NL + "                \t\t\t\t\trecord_";
  protected final String TEXT_34 = ".set";
  protected final String TEXT_35 = "(gc_";
  protected final String TEXT_36 = "_";
  protected final String TEXT_37 = ");" + NL;
  protected final String TEXT_38 = NL + NL + "\t\t\t\t\t\t\t\t\trecord_";
  protected final String TEXT_39 = ".set";
  protected final String TEXT_40 = "(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ")).toString());" + NL;
  protected final String TEXT_43 = NL + NL + "\t\t\t\t\t\t\t\t\tnsMgr_";
  protected final String TEXT_44 = ".invokeSetter(record_";
  protected final String TEXT_45 = ",\"";
  protected final String TEXT_46 = "\",";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ");" + NL;
  protected final String TEXT_49 = NL + NL + "\t\t\t\t\t\t\t\t\trecord_";
  protected final String TEXT_50 = ".set";
  protected final String TEXT_51 = "(";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = ");" + NL;
  protected final String TEXT_54 = NL + "        \t    \t\t\t}//if !=null";
  protected final String TEXT_55 = NL + "\t\t\t\t\t\t\t\trecord_";
  protected final String TEXT_56 = ".set";
  protected final String TEXT_57 = "(";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_61 = " " + NL + "" + NL + "        \ttry {" + NL + " \t\t\t\t";
  protected final String TEXT_62 = NL + NL + "            \t\tString internalId_";
  protected final String TEXT_63 = " = nsMgr_";
  protected final String TEXT_64 = ".insert(record_";
  protected final String TEXT_65 = ");" + NL + "                    globalMap.put(\"";
  protected final String TEXT_66 = "_CURRENT_INTERNALID\", Integer.parseInt(internalId_";
  protected final String TEXT_67 = "));" + NL;
  protected final String TEXT_68 = NL + NL + "\t\t\t\t\tnsMgr_";
  protected final String TEXT_69 = ".update(record_";
  protected final String TEXT_70 = ");" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_71 = "_CURRENT_INTERNALID\", Integer.parseInt(";
  protected final String TEXT_72 = ".InternalId));\t" + NL;
  protected final String TEXT_73 = " " + NL + "" + NL + "                    String internalId_";
  protected final String TEXT_74 = " = nsMgr_";
  protected final String TEXT_75 = ".upsert(record_";
  protected final String TEXT_76 = ");" + NL + "                    globalMap.put(\"";
  protected final String TEXT_77 = "_CURRENT_INTERNALID\", Integer.parseInt(internalId_";
  protected final String TEXT_78 = "));" + NL + "\t\t";
  protected final String TEXT_79 = NL + NL + "\t\t\t\t\tnsMgr_";
  protected final String TEXT_80 = ".delete(\"";
  protected final String TEXT_81 = "\", ";
  protected final String TEXT_82 = ".InternalId);" + NL + "\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_83 = "_CURRENT_INTERNALID\", Integer.parseInt(";
  protected final String TEXT_84 = ".InternalId));\t" + NL;
  protected final String TEXT_85 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = " = ";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = ";";
  protected final String TEXT_90 = "  " + NL + "\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_91 = " = null;   // reject line" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_92 = "\t\t\t\t" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_93 = "++;" + NL + "" + NL + "        \t} catch (Exception e_";
  protected final String TEXT_94 = ") {" + NL;
  protected final String TEXT_95 = NL + NL + "\t\t\t\t\tthrow e_";
  protected final String TEXT_96 = ";" + NL;
  protected final String TEXT_97 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_98 = " = null;   // main line" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_100 = NL + "                    \t";
  protected final String TEXT_101 = " = new ";
  protected final String TEXT_102 = "Struct();";
  protected final String TEXT_103 = NL + "                            \t\t";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = ";" + NL + "                                        ";
  protected final String TEXT_108 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tif(e_";
  protected final String TEXT_109 = " instanceof org.talend.netsuite.NetsuiteException){" + NL + "\t\t\t\t\t\t\t\torg.talend.netsuite.NetsuiteException ne_";
  protected final String TEXT_110 = " = (org.talend.netsuite.NetsuiteException)e_";
  protected final String TEXT_111 = ";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_112 = ".errorCode = ne_";
  protected final String TEXT_113 = ".getCode();" + NL + "\t\t                    \t";
  protected final String TEXT_114 = ".errorMessage = ne_";
  protected final String TEXT_115 = ".getMessage();" + NL + "\t\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_116 = ".errorCode = \"\";" + NL + "\t\t                    \t";
  protected final String TEXT_117 = ".errorMessage = \"\";" + NL + "\t\t\t\t\t\t\t}" + NL;
  protected final String TEXT_118 = NL;
  protected final String TEXT_119 = NL + NL + "                        System.err.print(e_";
  protected final String TEXT_120 = ".getMessage());" + NL;
  protected final String TEXT_121 = NL + "\t\t\t}" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    
    boolean dieonerror = "true".equals(ElementParameterParser.getValue(node,"__CEASE_FOR_ERROR__"));
    String action = ElementParameterParser.getValue(node, "__ACTION__");
    String modulenameKey = ElementParameterParser.getValue(node, "__MODULENAME__");
    
    Map<String, String> typeMap = new HashMap<String, String>();
	typeMap.put("Account", "com.netsuite.webservices.lists.accounting.Account");
	typeMap.put("AccountingPeriod", "com.netsuite.webservices.lists.accounting.AccountingPeriod");
	typeMap.put("AppDefinition", "com.netsuite.webservices.setup.customization.AppDefinition");
	typeMap.put("AppPackage", "com.netsuite.webservices.setup.customization.AppPackage");
	typeMap.put("BillingSchedule", "com.netsuite.webservices.lists.accounting.BillingSchedule");
	typeMap.put("Bin", "com.netsuite.webservices.lists.accounting.Bin");
	typeMap.put("Budget", "com.netsuite.webservices.transactions.financial.Budget");
	typeMap.put("CalendarEvent", "com.netsuite.webservices.activities.scheduling.CalendarEvent");
	typeMap.put("Campaign", "com.netsuite.webservices.lists.marketing.Campaign");
	typeMap.put("Charge", "com.netsuite.webservices.transactions.customers.Charge");
	typeMap.put("Classification", "com.netsuite.webservices.lists.accounting.Classification");
	typeMap.put("Contact", "com.netsuite.webservices.lists.relationships.Contact");
	typeMap.put("ContactCategory", "com.netsuite.webservices.lists.accounting.ContactCategory");
	typeMap.put("ContactRole", "com.netsuite.webservices.lists.accounting.ContactRole");
	typeMap.put("CouponCode", "com.netsuite.webservices.lists.marketing.CouponCode");
	typeMap.put("CurrencyRate", "com.netsuite.webservices.lists.accounting.CurrencyRate");
	typeMap.put("Customer", "com.netsuite.webservices.lists.relationships.Customer");
	typeMap.put("CustomerCategory", "com.netsuite.webservices.lists.accounting.CustomerCategory");
	typeMap.put("CustomerMessage", "com.netsuite.webservices.lists.accounting.CustomerMessage");
	typeMap.put("CustomerStatus", "com.netsuite.webservices.lists.relationships.CustomerStatus");
	typeMap.put("CustomList", "com.netsuite.webservices.setup.customization.CustomList");
	typeMap.put("CustomRecord", "com.netsuite.webservices.setup.customization.CustomRecord");
	typeMap.put("Department", "com.netsuite.webservices.lists.accounting.Department");
	typeMap.put("Employee", "com.netsuite.webservices.lists.employees.Employee");
	typeMap.put("EntityGroup", "com.netsuite.webservices.lists.relationships.EntityGroup");
	typeMap.put("ExpenseCategory", "com.netsuite.webservices.lists.accounting.ExpenseCategory");
	typeMap.put("File", "com.netsuite.webservices.documents.filecabinet.File");
	typeMap.put("Folder", "com.netsuite.webservices.documents.filecabinet.Folder");
	typeMap.put("GiftCertificate", "com.netsuite.webservices.lists.accounting.GiftCertificate");
	typeMap.put("GlobalAccountMapping", "com.netsuite.webservices.lists.accounting.GlobalAccountMapping");
	typeMap.put("InventoryNumber", "com.netsuite.webservices.lists.accounting.InventoryNumber");
	typeMap.put("Issue", "com.netsuite.webservices.lists.support.Issue");
	typeMap.put("ItemAccountMapping", "com.netsuite.webservices.lists.accounting.ItemAccountMapping");
	typeMap.put("ItemDemandPlan", "com.netsuite.webservices.transactions.demandplanning.ItemDemandPlan");
	typeMap.put("ItemRevision", "com.netsuite.webservices.lists.accounting.ItemRevision");
	typeMap.put("ItemSupplyPlan", "com.netsuite.webservices.transactions.demandplanning.ItemSupplyPlan");
	typeMap.put("Job", "com.netsuite.webservices.lists.relationships.Job");
	typeMap.put("JobStatus", "com.netsuite.webservices.lists.relationships.JobStatus");
	typeMap.put("JobType", "com.netsuite.webservices.lists.relationships.JobType");
	typeMap.put("Location", "com.netsuite.webservices.lists.accounting.Location");
	typeMap.put("ManufacturingCostTemplate", "com.netsuite.webservices.lists.supplychain.ManufacturingCostTemplate");
	typeMap.put("ManufacturingOperationTask", "com.netsuite.webservices.lists.supplychain.ManufacturingOperationTask");
	typeMap.put("ManufacturingRouting", "com.netsuite.webservices.lists.supplychain.ManufacturingRouting");
	typeMap.put("Message", "com.netsuite.webservices.general.communication.Message");
	typeMap.put("Nexus", "com.netsuite.webservices.lists.accounting.Nexus");
	typeMap.put("Note", "com.netsuite.webservices.general.communication.Note");
	typeMap.put("NoteType", "com.netsuite.webservices.lists.accounting.NoteType");
	typeMap.put("OtherNameCategory", "com.netsuite.webservices.lists.accounting.OtherNameCategory");
	typeMap.put("Partner", "com.netsuite.webservices.lists.relationships.Partner");
	typeMap.put("PartnerCategory", "com.netsuite.webservices.lists.accounting.PartnerCategory");
	typeMap.put("PaymentMethod", "com.netsuite.webservices.lists.accounting.PaymentMethod");
	typeMap.put("PayrollItem", "com.netsuite.webservices.lists.employees.PayrollItem");
	typeMap.put("PhoneCall", "com.netsuite.webservices.activities.scheduling.PhoneCall");
	typeMap.put("PriceLevel", "com.netsuite.webservices.lists.accounting.PriceLevel");
	typeMap.put("PricingGroup", "com.netsuite.webservices.lists.accounting.PricingGroup");
	typeMap.put("ProjectTask", "com.netsuite.webservices.activities.scheduling.ProjectTask");
	typeMap.put("PromotionCode", "com.netsuite.webservices.lists.marketing.PromotionCode");
	typeMap.put("ResourceAllocation", "com.netsuite.webservices.activities.scheduling.ResourceAllocation");
	typeMap.put("RevRecSchedule", "com.netsuite.webservices.lists.accounting.RevRecSchedule");
	typeMap.put("RevRecTemplate", "com.netsuite.webservices.lists.accounting.RevRecTemplate");
	typeMap.put("SalesRole", "com.netsuite.webservices.lists.accounting.SalesRole");
	typeMap.put("SiteCategory", "com.netsuite.webservices.lists.website.SiteCategory");
	typeMap.put("Solution", "com.netsuite.webservices.lists.support.Solution");
	typeMap.put("Subsidiary", "com.netsuite.webservices.lists.accounting.Subsidiary");
	typeMap.put("SupportCase", "com.netsuite.webservices.lists.support.SupportCase");
	typeMap.put("Task", "com.netsuite.webservices.activities.scheduling.Task");
	typeMap.put("Term", "com.netsuite.webservices.lists.accounting.Term");
	typeMap.put("TimeBill", "com.netsuite.webservices.transactions.employees.TimeBill");
	typeMap.put("TimeEntry", "com.netsuite.webservices.transactions.employees.TimeEntry");
	typeMap.put("TimeSheet", "com.netsuite.webservices.transactions.employees.TimeSheet");
	typeMap.put("Topic", "com.netsuite.webservices.lists.support.Topic");
	typeMap.put("UnitsType", "com.netsuite.webservices.lists.accounting.UnitsType");
	typeMap.put("Vendor", "com.netsuite.webservices.lists.relationships.Vendor");
	typeMap.put("VendorCategory", "com.netsuite.webservices.lists.accounting.VendorCategory");
	typeMap.put("WinLossReason", "com.netsuite.webservices.lists.accounting.WinLossReason");
	typeMap.put("AssemblyBuild", "com.netsuite.webservices.transactions.inventory.AssemblyBuild");
	typeMap.put("AssemblyUnbuild", "com.netsuite.webservices.transactions.inventory.AssemblyUnbuild");
	typeMap.put("BinTransfer", "com.netsuite.webservices.transactions.inventory.BinTransfer");
	typeMap.put("BinWorksheet", "com.netsuite.webservices.transactions.inventory.BinWorksheet");
	typeMap.put("CashRefund", "com.netsuite.webservices.transactions.customers.CashRefund");
	typeMap.put("CashSale", "com.netsuite.webservices.transactions.sales.CashSale");
	typeMap.put("Check", "com.netsuite.webservices.transactions.bank.Check");
	typeMap.put("CreditMemo", "com.netsuite.webservices.transactions.customers.CreditMemo");
	typeMap.put("CustomerDeposit", "com.netsuite.webservices.transactions.customers.CustomerDeposit");
	typeMap.put("CustomerPayment", "com.netsuite.webservices.transactions.customers.CustomerPayment");
	typeMap.put("CustomerRefund", "com.netsuite.webservices.transactions.customers.CustomerRefund");
	typeMap.put("Deposit", "com.netsuite.webservices.transactions.bank.Deposit");
	typeMap.put("DepositApplication", "com.netsuite.webservices.transactions.customers.DepositApplication");
	typeMap.put("Estimate", "com.netsuite.webservices.transactions.sales.Estimate");
	typeMap.put("ExpenseReport", "com.netsuite.webservices.transactions.employees.ExpenseReport");
	typeMap.put("InterCompanyJournalEntry", "com.netsuite.webservices.transactions.general.InterCompanyJournalEntry");
	typeMap.put("InventoryAdjustment", "com.netsuite.webservices.transactions.inventory.InventoryAdjustment");
	typeMap.put("InventoryCostRevaluation", "com.netsuite.webservices.transactions.inventory.InventoryCostRevaluation");
	typeMap.put("InventoryTransfer", "com.netsuite.webservices.transactions.inventory.InventoryTransfer");
	typeMap.put("Invoice", "com.netsuite.webservices.transactions.sales.Invoice");
	typeMap.put("ItemFulfillment", "com.netsuite.webservices.transactions.sales.ItemFulfillment");
	typeMap.put("ItemReceipt", "com.netsuite.webservices.transactions.purchases.ItemReceipt");
	typeMap.put("JournalEntry", "com.netsuite.webservices.transactions.general.JournalEntry");
	typeMap.put("Opportunity", "com.netsuite.webservices.transactions.sales.Opportunity");
	typeMap.put("PaycheckJournal", "com.netsuite.webservices.transactions.employees.PaycheckJournal");
	typeMap.put("PurchaseOrder", "com.netsuite.webservices.transactions.purchases.PurchaseOrder");
	typeMap.put("ReturnAuthorization", "com.netsuite.webservices.transactions.customers.ReturnAuthorization");
	typeMap.put("SalesOrder", "com.netsuite.webservices.transactions.sales.SalesOrder");
	typeMap.put("State", "com.netsuite.webservices.lists.accounting.State");
	typeMap.put("TransferOrder", "com.netsuite.webservices.transactions.inventory.TransferOrder");
	typeMap.put("VendorBill", "com.netsuite.webservices.transactions.purchases.VendorBill");
	typeMap.put("VendorCredit", "com.netsuite.webservices.transactions.purchases.VendorCredit");
	typeMap.put("VendorPayment", "com.netsuite.webservices.transactions.purchases.VendorPayment");
	typeMap.put("VendorReturnAuthorization", "com.netsuite.webservices.transactions.purchases.VendorReturnAuthorization");
	typeMap.put("WorkOrder", "com.netsuite.webservices.transactions.inventory.WorkOrder");
	typeMap.put("WorkOrderClose", "com.netsuite.webservices.transactions.inventory.WorkOrderClose");
	typeMap.put("WorkOrderCompletion", "com.netsuite.webservices.transactions.inventory.WorkOrderCompletion");
	typeMap.put("WorkOrderIssue", "com.netsuite.webservices.transactions.inventory.WorkOrderIssue");
    
    String modulename = typeMap.get(modulenameKey);

    stringBuffer.append(TEXT_2);
    
	IConnection conn = null;
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {//1
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {//2
            String cid = node.getUniqueName();
        	List< ? extends IConnection> conns = node.getIncomingConnections();
        	conn = conns.get(0);
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4

    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(modulename);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(modulename);
    stringBuffer.append(TEXT_7);
    
                if ("insert".equals(action) || "update".equals(action) || "upsert".equals(action)) { //************
                	List<IMetadataColumn> columns = metadata.getListColumns();
                    int sizeColumns = columns.size();
                    for (int i = 0; i < sizeColumns; i++) { //5  			
                    	IMetadataColumn column = columns.get(i);
                  		
                		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                		if(!javaType.isPrimitive() || column.isNullable()){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
            					String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
            					
            					if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_37);
    
								} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_42);
    
								} else if (javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_48);
    
								} else { //others

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_53);
    
								}

    stringBuffer.append(TEXT_54);
    
							} else {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_59);
    
							}

    stringBuffer.append(TEXT_60);
    
                    	}//5
					}//upsert, insert, update  ************

    stringBuffer.append(TEXT_61);
    
                if ("insert".equals(action)) {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
				// InternalId no need
				} else if ("update".equals(action)) {

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_72);
    
				} else if ("upsert".equals(action)) {

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
    
				// InternalId no need
				} else if ("delete".equals(action)) {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_84);
    
				}
				
				IConnection conn2 = null;
			    List<IMetadataTable> metadatas2 = node.getMetadataList();
			    if ((metadatas2 != null) && (metadatas2.size() > 0)) {//1
			        IMetadataTable metadata2 = metadatas2.get(0);
			        if (metadata != null) {//2
			        	List< ? extends IConnection> conns2 = node.getOutgoingConnections("FLOW");
			        	if(conns2.size() > 0){
			        		conn2 = conns2.get(0);
				    		if (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.FLOW)) {//4
								List<IMetadataColumn> columns2 = metadata2.getListColumns();
					            int sizeColumns2 = columns2.size();
					            for (int i = 0; i < sizeColumns2; i++) { //5  			
					            	IMetadataColumn column2 = columns2.get(i);

    stringBuffer.append(TEXT_85);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column2.getLabel());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column2.getLabel());
    stringBuffer.append(TEXT_89);
    		            	
					            }
					        }
			        	}
				    }
				}
				
				String rejectConnName = null;
                List< ? extends IConnection> outConns = node.getOutgoingConnections("REJECT");
                if(outConns.size() > 0){
                	rejectConnName = outConns.get(0).getName();
                }
				
				if(rejectConnName != null) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    
				if(dieonerror){

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    
				} else {
					if(conn2 != null) {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_98);
    }
    stringBuffer.append(TEXT_99);
    if(rejectConnName != null) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_102);
    
	                    List<IMetadataColumn> rejectColumnList = null;
	                    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
	                    if(metadataTable != null) {
	                    	rejectColumnList = metadataTable.getListColumns();
	                        for(IMetadataColumn column2 : rejectColumnList) {
	                        	if(conn != null && !"errorCode".equals(column2.getLabel()) && !"errorMessage".equals(column2.getLabel())){

    stringBuffer.append(TEXT_103);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(column2.getLabel());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column2.getLabel());
    stringBuffer.append(TEXT_107);
    
	                            }
	                        }

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_117);
    
                 	 }
                  }

    stringBuffer.append(TEXT_118);
    
                    if(rejectConnName == null){

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    
                    }
                }

    stringBuffer.append(TEXT_121);
    
    		}//4
    	}//2
	}//1

    return stringBuffer.toString();
  }
}
