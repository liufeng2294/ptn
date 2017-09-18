package com.nms.snmp.ninteface.mib;
//--AgentGen BEGIN=_BEGIN
//--AgentGen END

import java.util.List;

import org.snmp4j.PDU;
import org.snmp4j.agent.DuplicateRegistrationException;
import org.snmp4j.agent.MOGroup;
import org.snmp4j.agent.MOQueryWithSource;
import org.snmp4j.agent.MOServer;
import org.snmp4j.agent.MOServerLookupEvent;
import org.snmp4j.agent.MOServerLookupListener;
import org.snmp4j.agent.mo.DefaultMOFactory;
import org.snmp4j.agent.mo.DefaultMOMutableRow2PC;
import org.snmp4j.agent.mo.MOAccessImpl;
import org.snmp4j.agent.mo.MOColumn;
import org.snmp4j.agent.mo.MOFactory;
import org.snmp4j.agent.mo.MOMutableColumn;
import org.snmp4j.agent.mo.MOMutableTableModel;
import org.snmp4j.agent.mo.MOTable;
import org.snmp4j.agent.mo.MOTableIndex;
import org.snmp4j.agent.mo.MOTableIndexValidator;
import org.snmp4j.agent.mo.MOTableModel;
import org.snmp4j.agent.mo.MOTableRowFactory;
import org.snmp4j.agent.mo.MOTableSubIndex;
import org.snmp4j.agent.mo.MOValueValidationEvent;
import org.snmp4j.agent.mo.MOValueValidationListener;
import org.snmp4j.agent.request.SnmpRequest;
import org.snmp4j.log.LogAdapter;
import org.snmp4j.log.LogFactory;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.SMIConstants;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;

import com.nms.snmp.ninteface.framework.MOHandlerMgr;


//--AgentGen BEGIN=_IMPORT
//--AgentGen END

public class ProtectionGroup 
//--AgentGen BEGIN=_EXTENDS
//--AgentGen END
implements MOGroup 
//--AgentGen BEGIN=_IMPLEMENTS
//--AgentGen END
,MOServerLookupListener
{

  private static final LogAdapter LOGGER = 
      LogFactory.getLogger(ProtectionGroup.class);

//--AgentGen BEGIN=_STATIC
//--AgentGen END

  // Factory
  private MOFactory moFactory = 
    DefaultMOFactory.getInstance();

  // Constants 

  /**
   * OID of this MIB module for usage which can be 
   * used for its identification.
   */
  public static final OID oidProtectionGroup =
    new OID(new int[] {  });

  // Identities
  // Scalars
  // Tables

  // Notifications

  // Enumerations




  // TextualConventions

  // Scalars

  // Tables
  public static final OID oidMyEntry = 
    new OID(new int[] { 1,3,6,1,4,1,44484,1,19,2,1 });

  // Index OID definitions
  public static final OID oidIndex =
    new OID(new int[] { 1,3,6,1,4,1,44484,1,19,2,1,1 });

  // Column TC definitions for myEntry:
    
  // Column sub-identifer definitions for myEntry:
  public static final int colName = 2;
  public static final int colReversionMode = 3;
  public static final int colRate = 4;
  public static final int colPgpParameters = 5;
  public static final int colPgpTPList = 6;

  // Column index definitions for myEntry:
  public static final int idxName = 0;
  public static final int idxReversionMode = 1;
  public static final int idxRate = 2;
  public static final int idxPgpParameters = 3;
  public static final int idxPgpTPList = 4;

  private MOTableSubIndex[] myEntryIndexes;
  private MOTableIndex myEntryIndex;
  
  private MOTable<MyEntryRow,
                  MOColumn,
                  MOTableModel<MyEntryRow>> myEntry;
  private MOTableModel<MyEntryRow> myEntryModel;


//--AgentGen BEGIN=_MEMBERS
//--AgentGen END

  /**
   * Constructs a ProtectionGroup instance without actually creating its
   * <code>ManagedObject</code> instances. This has to be done in a
   * sub-class constructor or after construction by calling 
   * {@link #createMO(MOFactory moFactory)}. 
   */
  protected ProtectionGroup() {
//--AgentGen BEGIN=_DEFAULTCONSTRUCTOR
//--AgentGen END
  }

  /**
   * Constructs a ProtectionGroup instance and actually creates its
   * <code>ManagedObject</code> instances using the supplied 
   * <code>MOFactory</code> (by calling
   * {@link #createMO(MOFactory moFactory)}).
   * @param moFactory
   *    the <code>MOFactory</code> to be used to create the
   *    managed objects for this module.
   */
  public ProtectionGroup(MOFactory moFactory) {
  	this();
    createMO(moFactory);
//--AgentGen BEGIN=_FACTORYCONSTRUCTOR
//--AgentGen END
  }

//--AgentGen BEGIN=_CONSTRUCTORS
//--AgentGen END

  /**
   * Create the ManagedObjects defined for this MIB module
   * using the specified {@link MOFactory}.
   * @param moFactory
   *    the <code>MOFactory</code> instance to use for object 
   *    creation.
   */
  protected void createMO(MOFactory moFactory) {
    addTCsToFactory(moFactory);
    createMyEntry(moFactory);
  }



  public MOTable<MyEntryRow,MOColumn,MOTableModel<MyEntryRow>> getMyEntry() {
    return myEntry;
  }


  @SuppressWarnings(value={"unchecked"})
  private void createMyEntry(MOFactory moFactory) {
    // Index definition
    myEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)    };

    myEntryIndex = 
      moFactory.createIndex(myEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
     //--AgentGen BEGIN=myEntry::isValidIndex
     //--AgentGen END
        return isValidIndex;
      }
    });

    // Columns
    MOColumn[] myEntryColumns = new MOColumn[5];
    myEntryColumns[idxName] = 
      moFactory.createColumn(colName, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    myEntryColumns[idxReversionMode] = 
      moFactory.createColumn(colReversionMode, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    myEntryColumns[idxRate] = 
      moFactory.createColumn(colRate, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    myEntryColumns[idxPgpParameters] = 
      new MOMutableColumn<OctetString>(colPgpParameters,
                          SMIConstants.SYNTAX_OCTET_STRING,
                          moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE),
                          (OctetString)null);
    ((MOMutableColumn)myEntryColumns[idxPgpParameters]).
      addMOValueValidationListener(new PgpParametersValidator());
    myEntryColumns[idxPgpTPList] = 
      moFactory.createColumn(colPgpTPList, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    // Table model
    myEntryModel = 
      moFactory.createTableModel(oidMyEntry,
                                 myEntryIndex,
                                 myEntryColumns);
    ((MOMutableTableModel<MyEntryRow>)myEntryModel).setRowFactory(
      new MyEntryRowFactory());
    myEntry = 
      moFactory.createTable(oidMyEntry,
                            myEntryIndex,
                            myEntryColumns,
                            myEntryModel);
  }



  public void registerMOs(MOServer server, OctetString context) 
    throws DuplicateRegistrationException 
  {
    // Scalar Objects
    server.register(this.myEntry, context);
    server.addLookupListener(this, this.myEntry);
//--AgentGen BEGIN=_registerMOs
//--AgentGen END
  }

  public void unregisterMOs(MOServer server, OctetString context) {
    // Scalar Objects
    server.unregister(this.myEntry, context);
//--AgentGen BEGIN=_unregisterMOs
//--AgentGen END
  }

  // Notifications

  // Scalars

  // Value Validators

  /**
   * The <code>PgpParametersValidator</code> implements the value
   * validation for <code>PgpParameters</code>.
   */
  static class PgpParametersValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
     //--AgentGen BEGIN=pgpParameters::validate
     //--AgentGen END
    }
  }

  // Rows and Factories

  public class MyEntryRow extends DefaultMOMutableRow2PC {

     //--AgentGen BEGIN=myEntry::RowMembers
     //--AgentGen END

    public MyEntryRow(OID index, Variable[] values) {
      super(index, values);
     //--AgentGen BEGIN=myEntry::RowConstructor
     //--AgentGen END
    }
    
    public OctetString getName() {
     //--AgentGen BEGIN=myEntry::getName
     //--AgentGen END
      return (OctetString) super.getValue(idxName);
    }  
    
    public void setName(OctetString newValue) {
     //--AgentGen BEGIN=myEntry::setName
     //--AgentGen END
      super.setValue(idxName, newValue);
    }
    
    public OctetString getReversionMode() {
     //--AgentGen BEGIN=myEntry::getReversionMode
     //--AgentGen END
      return (OctetString) super.getValue(idxReversionMode);
    }  
    
    public void setReversionMode(OctetString newValue) {
     //--AgentGen BEGIN=myEntry::setReversionMode
     //--AgentGen END
      super.setValue(idxReversionMode, newValue);
    }
    
    public OctetString getRate() {
     //--AgentGen BEGIN=myEntry::getRate
     //--AgentGen END
      return (OctetString) super.getValue(idxRate);
    }  
    
    public void setRate(OctetString newValue) {
     //--AgentGen BEGIN=myEntry::setRate
     //--AgentGen END
      super.setValue(idxRate, newValue);
    }
    
    public OctetString getPgpParameters() {
     //--AgentGen BEGIN=myEntry::getPgpParameters
     //--AgentGen END
      return (OctetString) super.getValue(idxPgpParameters);
    }  
    
    public void setPgpParameters(OctetString newValue) {
     //--AgentGen BEGIN=myEntry::setPgpParameters
     //--AgentGen END
      super.setValue(idxPgpParameters, newValue);
    }
    
    public OctetString getPgpTPList() {
     //--AgentGen BEGIN=myEntry::getPgpTPList
     //--AgentGen END
      return (OctetString) super.getValue(idxPgpTPList);
    }  
    
    public void setPgpTPList(OctetString newValue) {
     //--AgentGen BEGIN=myEntry::setPgpTPList
     //--AgentGen END
      super.setValue(idxPgpTPList, newValue);
    }
    
    public Variable getValue(int column) {
     //--AgentGen BEGIN=myEntry::RowGetValue
     //--AgentGen END
      switch(column) {
        case idxName: 
        	return getName();
        case idxReversionMode: 
        	return getReversionMode();
        case idxRate: 
        	return getRate();
        case idxPgpParameters: 
        	return getPgpParameters();
        case idxPgpTPList: 
        	return getPgpTPList();
        default:
          return super.getValue(column);
      }
    }
    
    public void setValue(int column, Variable value) {
     //--AgentGen BEGIN=myEntry::RowSetValue
     //--AgentGen END
      switch(column) {
        case idxName: 
        	setName((OctetString)value);
        	break;
        case idxReversionMode: 
        	setReversionMode((OctetString)value);
        	break;
        case idxRate: 
        	setRate((OctetString)value);
        	break;
        case idxPgpParameters: 
        	setPgpParameters((OctetString)value);
        	break;
        case idxPgpTPList: 
        	setPgpTPList((OctetString)value);
        	break;
        default:
          super.setValue(column, value);
      }
    }

     //--AgentGen BEGIN=myEntry::Row
     //--AgentGen END
  }
  
  class MyEntryRowFactory 
        implements MOTableRowFactory<MyEntryRow>
  {
    public synchronized MyEntryRow createRow(OID index, Variable[] values)
        throws UnsupportedOperationException 
    {
      MyEntryRow row = 
        new MyEntryRow(index, values);
     //--AgentGen BEGIN=myEntry::createRow
     //--AgentGen END
      return row;
    }
    
    public synchronized void freeRow(MyEntryRow row) {
     //--AgentGen BEGIN=myEntry::freeRow
     //--AgentGen END
    }

     //--AgentGen BEGIN=myEntry::RowFactory
     //--AgentGen END
  }


//--AgentGen BEGIN=_METHODS
//--AgentGen END

  // Textual Definitions of MIB module ProtectionGroup
  protected void addTCsToFactory(MOFactory moFactory) {
  }


//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_BEGIN
//--AgentGen END

  // Textual Definitions of other MIB modules
  public void addImportedTCsToFactory(MOFactory moFactory) {
  }

@Override
public void lookupEvent(MOServerLookupEvent paramMOServerLookupEvent) {
	// TODO Auto-generated method stub
	
}

@Override
public void queryEvent(MOServerLookupEvent event) {
	// TODO Auto-generated method stub
	if((event.getLookupResult() == this.myEntry) 
			&&(!MOQueryWithSource.isSameSource(event.getQuery(), event.getSource()))){
		if(!(event.getQuery() instanceof MOQueryWithSource)){
			return;
		}
		MOQueryWithSource query = ((MOQueryWithSource)event.getQuery());
		SnmpRequest request = (SnmpRequest)query.getSource();
		OID oid = event.getQuery().getLowerBound();
		System.out.println(oid);
		List<VariableBinding> vbList = request.getSource().getPDU().getBindingList(oidMyEntry);
		//set
		if(query.isWriteAccessQuery())
			MOHandlerMgr.setTableValue(myEntry, vbList);
		int actionType = request.getSource().getPDU().getType();
		System.out.println("actionType:"+request.getSource().getPDU().toString()+"!!!!!!!!!!!!!!!!!!!!!");
		if(actionType == PDU.GET || actionType == PDU.GETNEXT || actionType == PDU.GETBULK){
			MOHandlerMgr.updateTableMO(myEntry, vbList);
		}
	}
}


//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_END
//--AgentGen END

//--AgentGen BEGIN=_CLASSES
//--AgentGen END

//--AgentGen BEGIN=_END
//--AgentGen END
}


