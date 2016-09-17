package org.talend.designer.codegen.translators.business.netsuite;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.Character;
import java.util.Calendar;
import java.util.Arrays;

public class TNetsuiteInputBeginJava
{
  protected static String nl;
  public static synchronized TNetsuiteInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNetsuiteInputBeginJava result = new TNetsuiteInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "boolean continue_";
  protected final String TEXT_4 = " = true;" + NL;
  protected final String TEXT_5 = NL + NL + "\t\t\t";
  protected final String TEXT_6 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_7 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = "; ";
  protected final String TEXT_12 = NL + "\t\t\t" + NL + "\t\t\torg.talend.netsuite.NetsuiteManagement_CXF nsMgr_";
  protected final String TEXT_13 = " = new org.talend.netsuite.NetsuiteManagement_CXF(";
  protected final String TEXT_14 = ", decryptedPassword_";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = " + \"\", ";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = "); " + NL;
  protected final String TEXT_19 = " " + NL + "" + NL + "\t\t\ttry {" + NL + "\t\t\t" + NL + "\t\t\t\tjava.util.List<com.netsuite.webservices.platform.core.Record> records_";
  protected final String TEXT_20 = " = null;" + NL + "\t\t\t\tnsMgr_";
  protected final String TEXT_21 = ".initialize(\"";
  protected final String TEXT_22 = "\", null); " + NL;
  protected final String TEXT_23 = " " + NL + "" + NL + "\t\t\t\t\t\tjava.util.List<String> searchCriteria_";
  protected final String TEXT_24 = "_";
  protected final String TEXT_25 = " = new java.util.ArrayList<String>();" + NL;
  protected final String TEXT_26 = NL + NL + "\t\t\t\t\t\t\tsearchCriteria_";
  protected final String TEXT_27 = "_";
  protected final String TEXT_28 = ".addAll(";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t\t\tsearchCriteria_";
  protected final String TEXT_32 = "_";
  protected final String TEXT_33 = ".add(";
  protected final String TEXT_34 = " + \"\");";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t\t\tsearchCriteria_";
  protected final String TEXT_37 = "_";
  protected final String TEXT_38 = ".add(";
  protected final String TEXT_39 = " + \"\");";
  protected final String TEXT_40 = NL;
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tnsMgr_";
  protected final String TEXT_42 = ".search(\"";
  protected final String TEXT_43 = "\", \"";
  protected final String TEXT_44 = "\", \"";
  protected final String TEXT_45 = "\", searchCriteria_";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = ", \"";
  protected final String TEXT_48 = "\"); " + NL;
  protected final String TEXT_49 = " " + NL + "" + NL + "\t\t\t\trecords_";
  protected final String TEXT_50 = " = nsMgr_";
  protected final String TEXT_51 = ".submitRequest(true);" + NL + "" + NL + "\t\t\t\t// Get the value of a custom field." + NL + "\t\t\t\tObject customFieldValue_";
  protected final String TEXT_52 = " = null;" + NL + "\t\t\t\twhile (continue_";
  protected final String TEXT_53 = ") { // Block closed in END file" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\tif(records_";
  protected final String TEXT_54 = " != null){" + NL + "    \t\t\t\t\tfor (int i_";
  protected final String TEXT_55 = " = 0; i_";
  protected final String TEXT_56 = " < records_";
  protected final String TEXT_57 = ".size(); i_";
  protected final String TEXT_58 = "++) { // Block closed in END file" + NL + "    \t\t\t\t\t\tnb_line_";
  protected final String TEXT_59 = "++;" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_60 = " record_";
  protected final String TEXT_61 = " = (";
  protected final String TEXT_62 = ") records_";
  protected final String TEXT_63 = ".get(i_";
  protected final String TEXT_64 = ");" + NL;
  protected final String TEXT_65 = " " + NL;
  protected final String TEXT_66 = " " + NL + "" + NL + "\t\t\t\t\t\t\t\t\tif (record_";
  protected final String TEXT_67 = ".is";
  protected final String TEXT_68 = "() != null) { " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_69 = " " + NL + "" + NL + "\t\t\t\t\t\t\t\t\tif (record_";
  protected final String TEXT_70 = ".get";
  protected final String TEXT_71 = "() != null) { " + NL;
  protected final String TEXT_72 = " " + NL;
  protected final String TEXT_73 = " " + NL + "" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = " = record_";
  protected final String TEXT_76 = ".get";
  protected final String TEXT_77 = "().toGregorianCalendar().getTime(); " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_78 = " " + NL + "" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = " = record_";
  protected final String TEXT_81 = ".is";
  protected final String TEXT_82 = "(); " + NL;
  protected final String TEXT_83 = " " + NL + "" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_84 = ".";
  protected final String TEXT_85 = " = record_";
  protected final String TEXT_86 = ".get";
  protected final String TEXT_87 = "();" + NL;
  protected final String TEXT_88 = NL + "    \t\t\t\t\t\t\t} else {" + NL + "    \t\t\t\t\t\t\t\t";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = " = ";
  protected final String TEXT_91 = ";" + NL + "    \t\t\t\t\t\t\t}" + NL;

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
        
List<IMetadataTable> metadatas = node.getMetadataList(); // This is the Schema
if ((metadatas != null) && (metadatas.size() > 0)) {
	IMetadataTable metadata = metadatas.get(0);
		
	if (metadata != null) {
		List<IMetadataColumn> columnList = metadata.getListColumns();
		
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
		
		// Get the two search criteria tables
		List<Map<String, String>> bodyField = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__CONDITIONS__");
		List<Map<String, String>> customField = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__CUSTOM_SEARCH__");
		
		if (columnList.size() > 0 && outgoingConns != null && outgoingConns.size() > 0) {
			
			// Get the login credential for NetSuite
			String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
			String username = ElementParameterParser.getValue(node, "__USER__");
			String role = ElementParameterParser.getValue(node, "__ROLE__");
			String account = ElementParameterParser.getValue(node, "__ACCOUNT__");
			
			String passwordFieldName = "__PASS__";
			
			// Search configurations
			String searchEntityKey = ElementParameterParser.getValue(node, "__MODULENAME__").trim();
			String searchEntity = typeMap.get(searchEntityKey);
			
			boolean regularSearch = "true".equals(ElementParameterParser.getValue(node, "__SHOW_CONDITIONS__"));

    stringBuffer.append(TEXT_5);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_8);
    } else {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(role);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(account);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_18);
    
			IConnection outgoingConn = outgoingConns.get(0);
			if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(searchEntity);
    stringBuffer.append(TEXT_22);
    
						
				// Construct a search for body fields
				if(regularSearch) {
					int index = 0;
					for (Map<String, String> keyColumn : bodyField) {
						String operator = keyColumn.get("OPERATOR").substring(2);
						String fieldTypeShort = keyColumn.get("OPERATOR").substring(0, 1);
						String fieldType = "";
						
						if(fieldTypeShort.equals("S")) {
							fieldType = "String";
						} else if(fieldTypeShort.equals("N")){
							fieldType = "Long";
						} else if(fieldTypeShort.equals("L")){
							fieldType = "List";
						} else if(fieldTypeShort.equals("D")){
							fieldType = "Date";
						} else if(fieldTypeShort.equals("B")){
							fieldType = "Boolean";
						} else if(fieldTypeShort.equals("O")){
							fieldType = "Double";
						}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(index );
    stringBuffer.append(TEXT_25);
    
						if(operator.equals("anyOf") || operator.equals("noneOf")) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(index );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(keyColumn.get("RVALUE"));
    stringBuffer.append(TEXT_29);
    
						} else {

    stringBuffer.append(TEXT_30);
    
							if(!operator.equals("empty") && !operator.equals("notEmpty")) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(index );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(keyColumn.get("RVALUE"));
    stringBuffer.append(TEXT_34);
    
							}

    stringBuffer.append(TEXT_35);
    
							if(operator.equals("between") || operator.equals("notBetween") || operator.equals("within") || operator.equals("notWithin")) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(index );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(keyColumn.get("RVALUE2"));
    stringBuffer.append(TEXT_39);
    
							}

    stringBuffer.append(TEXT_40);
    
						}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(searchEntity);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(keyColumn.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(operator);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(index );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(fieldType );
    stringBuffer.append(TEXT_48);
    
						index++;
					}
				}
						
				// We execute the search.

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(searchEntity);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(searchEntity);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    
							// Block Start [1]
    						for (int i = 0; i < columnList.size(); i++) {
    									
    							IMetadataColumn column = columnList.get(i);
    							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
    							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

    stringBuffer.append(TEXT_65);
    
								if (javaType == JavaTypesManager.BOOLEAN) { 

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_68);
    
								} else  {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_71);
    
								}

    stringBuffer.append(TEXT_72);
    
								if (javaType == JavaTypesManager.DATE) { 

    stringBuffer.append(TEXT_73);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_77);
    
								} else if(javaType == JavaTypesManager.BOOLEAN) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_82);
    
								} else {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_87);
    
								}

    stringBuffer.append(TEXT_88);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_91);
    
						}
			}
		}
	}
}

    return stringBuffer.toString();
  }
}
